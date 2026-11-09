/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class AttackEffect
extends Feature {
    public static final String MODULE = "attack_effect";
    public static final String DISPLAY = "\u0410\u0442\u0442\u0430\u0441\u043a\u0415\u0444\u0444\u0435\u0441\u0442";
    public static final int VTABLE_RVA = 12569784;
    private float flashAmount;

    public AttackEffect() {
        super(MODULE, DISPLAY, Category.Combat);
        this.add(Setting.mode("effect", "Flash", "Flash", "Slash", "Impact"));
        this.add(Setting.bool("flash", true));
        this.add(Setting.color("colors", 0xFFFFFF));
    }

    @Override
    public void onEnable() {
        this.flashAmount = 0.0f;
    }

    @Override
    public void onDisable() {
        this.flashAmount = 0.0f;
    }

    @Override
    public void onTick() {
        if (!Client.inGame()) {
            return;
        }
        if (Client.isPaused()) {
            return;
        }
        this.flashAmount = 0.0f;
    }
}

