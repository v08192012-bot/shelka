/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class FakeLag
extends Feature {
    public static final String MODULE = "fake_lag";
    public static final String DISPLAY = "\u0424\u0430\u043a\u0435\u041b\u0430\u0433";
    public static final int VTABLE_RVA = 12288304;
    public static final long RVA_RESET_WHEN_NO_PLAYER = 2735200155600L;
    public static final long RVA_TICK = 2735200155136L;
    public static final long RVA_LAG_RELEASE = 2735200155072L;
    public static final long RVA_ON_ENABLE = 2735200155056L;
    public static final long RVA_ON_DISABLE = 2735200155072L;
    public static final long RVA_LAG_ACTIVE = 2735199915776L;
    public static final double DELAY_VALUE = 200.0;
    public static final double DELAY_MIN = 50.0;
    public static final double DELAY_MAX = 400.0;
    public static final double DELAY_STEP = 10.0;
    private static final long CHECK_INTERVAL_NANOS = 25000000L;
    private static final double NANOS_TO_MILLIS = 1.0E-6;
    private static final double HOLD_SCALE = 2.0;
    private static final double HOLD_CAP_MILLIS = 800.0;
    private long lastCheckNanos;
    private double holdMillis;

    public FakeLag() {
        super(MODULE, DISPLAY, Category.Movement);
        this.add(Setting.number("delay", 200.0, 50.0, 400.0, 10.0));
        this.holdMillis = 0.0;
    }

    @Override
    public void onEnable() {
        Client.setLagStartNanos(0L);
    }

    @Override
    public void onDisable() {
        this.releaseLag();
    }

    public void resetWhenNoPlayer() {
        if (Client.player() != null) {
            return;
        }
        this.releaseLag();
    }

    public void releaseLag() {
        Client.setLagPending(false);
        Client.releaseLag();
        Client.setLagStartNanos(0L);
    }

    @Override
    public void onTick() {
        long now = Client.nanos();
        if (now - this.lastCheckNanos <= 25000000L) {
            return;
        }
        this.lastCheckNanos = now;
        double maxDelay = 0.0;
        boolean any = false;
        for (Object candidate : Client.lagFeatures()) {
            Feature module;
            if (!(candidate instanceof Feature) || !(module = (Feature)candidate).isEnabled() || Client.lagSuspended() || Client.lagQueueDepth() <= 0 || !Client.lagWindowOpen() || !this.lagActive(module)) continue;
            double delay = Client.settingNumber(module, "delay");
            any = true;
            if (!(delay > maxDelay)) continue;
            maxDelay = delay;
        }
        if (!any) {
            this.releaseLag();
            return;
        }
        if (Client.lagPending()) {
            if ((double)(now - Client.lagStartNanos()) * 1.0E-6 < this.holdMillis) {
                return;
            }
            this.releaseLag();
            return;
        }
        Client.beginLag(Client.tickCount());
        if (Client.canHoldLag() && Client.lagTicking()) {
            Client.setLagPending(true);
        }
        Client.setLagStartNanos(now);
        double hold = Client.lagHoldMillis(maxDelay * 2.0);
        this.holdMillis = Math.min(hold, 800.0);
    }

    public boolean lagActive(Feature module) {
        return true;
    }
}

