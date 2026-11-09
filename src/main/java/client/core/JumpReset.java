/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import client.mc.Entity;

public final class JumpReset
extends Feature {
    public static final String MODULE = "jumpreset";
    public static final int VTABLE_RVA = 12289984;
    private static final double MIN_SPEED_SQUARED = 0.0064;
    private static final double CHANCE_BOUND = 100.0;
    private static final int JUMP_KEY_DOWN = 1;
    private int hurtTicks;
    private boolean jumpHeld;

    public JumpReset() {
        super(MODULE, "", Category.Combat);
        this.add(Setting.bool("use_chance", true));
        this.add(Setting.number("chance", 100.0, 0.0, 100.0));
    }

    @Override
    public void onEnable() {
        this.hurtTicks = 0;
    }

    @Override
    public void onDisable() {
        this.releaseJump();
        this.hurtTicks = 0;
    }

    @Override
    public void onTick() {
        if (this.jumpHeld) {
            this.jumpHeld = false;
            Client.setJumpKey(Client.jumpKey());
        }
        Entity self = Client.player();
        int current = 0;
        if (self != null) {
            current = Client.hurtTicks(self);
            if (Client.hasPendingException()) {
                current = 0;
            }
        }
        int previous = this.hurtTicks;
        this.hurtTicks = current;
        if (previous >= current) {
            return;
        }
        if (!Client.isOnGround(self)) {
            return;
        }
        if (!Client.isSprinting(self)) {
            return;
        }
        if (Client.isPaused()) {
            return;
        }
        if (Client.isRiding(self)) {
            return;
        }
        if (Client.isInWater(self)) {
            return;
        }
        if (Client.isAttackKeyDown()) {
            return;
        }
        double vertical = 0.0;
        double horizontal = 0.0;
        Entity source = Client.knockbackSource(self);
        if (source != null) {
            horizontal = Client.motionHorizontal(source);
            Client.clearMotion(source);
            vertical = Client.motionY(source);
        }
        if (0.0064 > vertical * vertical + horizontal * horizontal) {
            return;
        }
        if (this.useChance() && Client.random(100.0) > this.chance()) {
            return;
        }
        Client.setJumpKey(1);
        this.jumpHeld = true;
    }

    private void releaseJump() {
        if (this.jumpHeld) {
            this.jumpHeld = false;
            Client.setJumpKey(Client.jumpKey());
        }
    }

    private boolean useChance() {
        Setting s = this.setting("use_chance");
        return s != null && s.getBoolean();
    }

    private double chance() {
        Setting s = this.setting("chance");
        return s == null ? 100.0 : s.getNumber();
    }

    private Setting setting(String name) {
        for (Setting s : this.getSettings()) {
            if (!s.getName().equals(name)) continue;
            return s;
        }
        return null;
    }
}

