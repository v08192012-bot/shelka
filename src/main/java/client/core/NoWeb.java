/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import client.mc.Entity;

public final class NoWeb
extends Feature {
    public static final String MODULE = "noweb";
    public static final String DISPLAY = "\u041d\u043e\u0428\u0435\u0431";
    public static final int VTABLE_RVA = 12291712;
    public static final long RVA_CONSTRUCT = 2735200147808L;
    public static final long RVA_ON_TICK = 2735200148496L;
    private static final double STUCK_EPSILON = 1.0E-7;
    private static final double DEG_TO_RAD = Math.PI / 180;
    private static final float YAW_STEP = 45.0f;

    public NoWeb() {
        super(MODULE, DISPLAY, Category.Movement);
        this.add(Setting.number("speed", 0.6, 0.0, 1.0));
    }

    @Override
    public void onTick() {
        Entity self = Client.localPlayer();
        if (self == null) {
            return;
        }
        double[] stuck = Client.stuckSpeedMultiplier(self);
        if (stuck == null) {
            return;
        }
        if (stuck[0] * stuck[0] + stuck[1] * stuck[1] + stuck[2] * stuck[2] <= 1.0E-7) {
            return;
        }
        if (!Client.isInCobweb(self)) {
            return;
        }
        double speed = this.speed();
        float[] move = Client.moveVector(self);
        float strafe = move[0];
        float forward = move[1];
        float yaw = Client.viewYaw(self);
        float base = strafe;
        if (strafe != 0.0f) {
            base = 45.0f;
            if (forward < 0.0f) {
                if (strafe <= 0.0f) {
                    base = -45.0f;
                }
                yaw += base;
            } else if (forward > 0.0f) {
                if (strafe > 0.0f) {
                    base = -45.0f;
                }
                yaw += base;
            }
            forward = 0.0f;
            base = strafe > 0.0f ? 1.0f : -1.0f;
        }
        double radians = ((double)yaw + 90.0) * (Math.PI / 180);
        double sin = Math.sin(radians);
        double cos = Math.cos(radians);
        double x = (double)base * speed * cos + (double)forward * speed * sin;
        double z = (double)base * speed * sin - (double)forward * speed * cos;
        double y = 0.0;
        if (Client.isJumpKeyDown()) {
            y = speed;
        }
        if (Client.isSneakKeyDown()) {
            y -= speed;
        }
        Client.setDeltaMovement(self, new double[]{x, y, z});
    }

    private double speed() {
        Setting setting = this.setting("speed");
        return setting == null ? 0.6 : setting.getNumber();
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }
}

