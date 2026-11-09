/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import client.mc.Entity;

public final class LagRange
extends Feature {
    public static final String MODULE = "lag_range";
    public static final String DISPLAY = "\u041b\u0430\u0433\u0420\u0430\u043d\u0433\u0435";
    public static final int VTABLE_RVA = 12290384;
    public static final long RVA_RESET_WHEN_NO_PLAYER = 2735200155600L;
    public static final long RVA_TICK = 2735200155136L;
    public static final long RVA_LAG_RELEASE = 2735200155072L;
    public static final long RVA_ON_ENABLE = 2735200145200L;
    public static final long RVA_ON_DISABLE = 2735200155072L;
    public static final long RVA_PLAYER_WITHIN = 2735200145232L;
    public static final double DELAY_VALUE = 200.0;
    public static final double DELAY_MIN = 50.0;
    public static final double DELAY_MAX = 400.0;
    public static final double DELAY_STEP = 10.0;
    public static final double RANGE_VALUE = 10.0;
    public static final double RANGE_MIN = 1.0;
    public static final double RANGE_MAX = 30.0;
    public static final double RANGE_STEP = 0.5;
    private static final long CHECK_INTERVAL_NANOS = 25000000L;
    private static final double NANOS_TO_MILLIS = 1.0E-6;
    private static final double HOLD_SCALE = 2.0;
    private long lastCheckNanos;
    private long outsideSinceNanos;
    private double holdMillis;

    public LagRange() {
        super(MODULE, DISPLAY, Category.Movement);
        this.add(Setting.number("delay", 200.0, 50.0, 400.0, 10.0));
        this.add(Setting.number("range", 10.0, 1.0, 30.0, 0.5));
        this.outsideSinceNanos = 0L;
        this.holdMillis = 0.0;
    }

    @Override
    public void onEnable() {
        Client.setLagStartNanos(0L);
        this.outsideSinceNanos = 0L;
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
            if (!(candidate instanceof Feature) || !(module = (Feature)candidate).isEnabled() || Client.lagSuspended() || Client.lagQueueDepth() <= 0 || !Client.lagArmed() || !Client.lagWindowElapsed() || !this.playerWithin(module)) continue;
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
        if (Client.lagPendingTicks() != -1 && Client.lagHasTicks()) {
            Client.setLagPending(true);
        }
        Client.setLagStartNanos(now);
        this.holdMillis = Math.min(Client.lagHoldMillis(maxDelay * 2.0), Client.lagHoldCap());
    }

    public boolean playerWithin(Feature module) {
        double range = Client.settingNumber(module, "range");
        Entity self = Client.player();
        if (self != null) {
            double[] origin = Client.entityPosition(self);
            boolean[] found = new boolean[]{false};
            Client.forEachPlayer(other -> {
                double dz;
                if (other == null || other == self) {
                    return;
                }
                double[] position = Client.entityPosition(other);
                double dx = origin[0] - position[0];
                if (dx * dx + (dz = origin[2] - position[2]) * dz <= range * range) {
                    found[0] = true;
                }
            });
            if (found[0]) {
                this.outsideSinceNanos = 0L;
                return true;
            }
        }
        long now = Client.nanos();
        if (this.outsideSinceNanos == 0L) {
            this.outsideSinceNanos = now;
        }
        return (double)(now - this.outsideSinceNanos) * 1.0E-6 < Client.lagGraceMillis();
    }

    public void resetLag() {
        Client.setLagPending(false);
        Client.releaseLag();
        Client.setLagStartNanos(0L);
    }
}

