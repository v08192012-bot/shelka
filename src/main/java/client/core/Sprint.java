/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.mc.Client;
import client.mc.Entity;

public final class Sprint
extends Feature {
    public static final String MODULE = "sprint";
    public static final String DISPLAY = "\u0417\u043f\u0440\u0438\u043d\u0442";
    public static final int VTABLE_RVA = 12292688;
    public static final long RVA_ON_TICK = 2735200153520L;
    public static final long RVA_ON_DISABLE = 2735200154080L;
    public static final long RVA_CREATE = 2735199933600L;
    private static final long RVA_FORWARD_KEY_DOWN = 2735202267248L;
    private static final long RVA_SPRINT_KEY = 2735202266960L;
    private static final long RVA_IS_TOUCHING_WATER = 2735202492304L;
    private static final long RVA_IS_SUBMERGED = 2735202492496L;

    public Sprint() {
        super(MODULE, DISPLAY, Category.Movement);
    }

    @Override
    public void onDisable() {
        Client.setSprintKeyDown(false);
    }

    @Override
    public void onTick() {
        if (!Client.isForwardKeyDown()) {
            return;
        }
        Entity player = Client.localPlayer();
        Client.setSprintKeyDown(true);
        if (!Client.isTouchingWater(player)) {
            Client.setSprinting(player, true);
            return;
        }
        if (!Client.isSubmergedInWater(player)) {
            return;
        }
        if (player == null) {
            return;
        }
        Client.setSwimming(player, true);
        Client.checkJni();
    }
}

