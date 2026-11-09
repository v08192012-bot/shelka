/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class ItemScroller
extends Feature {
    public static final String MODULE = "itemscroller";
    public static final String DISPLAY = "\u0418\u0442\u0435\u043c\u0417\u0441\u0440\u043e\u043b\u043b\u0435\u0440";
    public static final int VTABLE_RVA = 12315888;
    public static final long RVA_TICK = 2735200293264L;
    public static final long RVA_ON_ENABLE = 2735200292528L;
    public static final long RVA_ON_DISABLE = 2735200292528L;
    public static final double DELAY_VALUE = 50.0;
    public static final double DELAY_MIN = 0.0;
    public static final double DELAY_MAX = 100.0;
    public static final double DELAY_STEP = 1.0;
    private static final long MILLIS_TO_NANOS = 1000000L;
    private long nextMoveNanos;

    public ItemScroller() {
        super(MODULE, DISPLAY, Category.Player);
        this.add(Setting.number("delay", 50.0, 0.0, 100.0, 1.0));
    }

    @Override
    public void onEnable() {
        this.nextMoveNanos = 0L;
    }

    @Override
    public void onDisable() {
        this.nextMoveNanos = 0L;
    }

    @Override
    public void onTick() {
        if (!Client.sneakBindDown() && !Client.isSneakKeyPressed() || !Client.keyPressed() || !Client.containerScreenOpen()) {
            this.nextMoveNanos = 0L;
            return;
        }
        long now = Client.nanos();
        int slot = Client.quickMoveSlot();
        if (this.nextMoveNanos > now || slot < 0 || !Client.slotPresent(slot)) {
            return;
        }
        Client.quickMoveSlot(slot);
        this.nextMoveNanos = now + (long)(this.delay() * 1000000.0);
    }

    private double delay() {
        Setting setting = this.setting("delay");
        return setting == null ? 50.0 : setting.getNumber();
    }

    private Setting setting(String name) {
        for (Setting candidate : this.getSettings()) {
            if (!candidate.getName().equals(name)) continue;
            return candidate;
        }
        return null;
    }
}

