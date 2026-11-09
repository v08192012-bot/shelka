/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.mc.Client;
import client.mc.Entity;

public final class AutoShiftTap
extends Feature {
    public static final String MODULE = "autoshifttap";
    public static final String DISPLAY = "\u0417\u0445\u0438\u0444\u0442\u0422\u0430\u043f";
    public static final int VTABLE_RVA = 12272168;
    public static final long RVA_ON_TICK = 2735200040608L;
    public static final long RVA_PRESS = 2735200040528L;
    public static final long RVA_ON_DISABLE = 2735200040480L;
    private static final long TAP_DURATION_NANOS = 25000000L;
    private long releaseAt;
    private boolean pressed;

    public AutoShiftTap() {
        super(MODULE, DISPLAY, Category.Combat);
    }

    public void press() {
        this.releaseAt = Client.timerNanos() + 25000000L;
        if (!this.pressed) {
            Client.setSneak(true);
            this.pressed = true;
        }
    }

    @Override
    public void onDisable() {
        if (this.pressed) {
            Client.setSneak(false);
            this.pressed = false;
        }
    }

    @Override
    public void onTick() {
        Entity player = Client.player();
        if (player != null && !Client.isSneaking(player)) {
            if (!this.pressed) {
                return;
            }
            if (Client.timerNanos() <= this.releaseAt) {
                return;
            }
        }
        if (this.pressed) {
            Client.setSneak(false);
            this.pressed = false;
        }
    }
}

