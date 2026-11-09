/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import client.mc.Entity;
import client.mc.ItemStack;

public final class TapeMouse
extends Feature {
    public static final String MODULE = "tapemouse";
    public static final int VTABLE_RVA = 12282456;
    private int delay;

    public TapeMouse() {
        super(MODULE, "", Category.Player);
        this.add(Setting.number("cooldown", 2.0, 0.0, 20.0));
        this.add(Setting.bool("pause_in_screen", true));
    }

    @Override
    public void onEnable() {
        this.delay = 0;
    }

    @Override
    public void onDisable() {
        this.delay = 0;
    }

    @Override
    public void onTick() {
        if (!Client.inGame()) {
            return;
        }
        if (this.pauseInScreen() && Client.isScreenOpen()) {
            return;
        }
        if (Client.isBreakingBlock()) {
            return;
        }
        if (this.delay > 0) {
            --this.delay;
            return;
        }
        if (!Client.isScreenOpen()) {
            ItemStack held = Client.heldItem();
            if (held != null) {
                Client.useItem(held);
            }
        } else {
            Entity candidate = Client.crosshairTarget();
            if (candidate != null) {
                Entity self = Client.player();
                Client.attackWith(self, candidate);
            }
        }
        this.delay = (int)this.cooldown();
    }

    private boolean pauseInScreen() {
        Setting s = this.setting("pause_in_screen");
        return s != null && s.getBoolean();
    }

    private double cooldown() {
        Setting s = this.setting("cooldown");
        return s == null ? 2.0 : s.getNumber();
    }

    private Setting setting(String name) {
        for (Setting s : this.getSettings()) {
            if (!s.getName().equals(name)) continue;
            return s;
        }
        return null;
    }
}

