/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class JumpCircles
extends Feature {
    public static final String MODULE = "jump_circles";
    public static final String DISPLAY = "\u0416\u0443\u043c\u043f\u0421\u0438\u0440\u0441\u043b\u0435\u0437";
    public static final int VTABLE_RVA = 12577960;
    private float progress;

    public JumpCircles() {
        super(MODULE, DISPLAY, Category.Combat);
        this.add(Setting.mode("mode", "Circle", "Circle", "Wave"));
        this.add(Setting.number("lifetime", 1.0, 0.1, 10.0));
        this.add(Setting.number("radius", 1.0, 0.1, 5.0));
        this.add(Setting.number("wave_strength", 1.0, 0.0, 5.0));
        this.add(Setting.number("wave_radius", 1.0, 0.0, 5.0));
        this.add(Setting.number("wave_time", 1.0, 0.1, 10.0));
        this.add(Setting.number("distortion", 0.0, 0.0, 1.0));
        this.add(Setting.color("color", 0xFFFFFF));
    }

    @Override
    public void onEnable() {
        this.progress = 0.0f;
    }

    @Override
    public void onDisable() {
        this.progress = 0.0f;
    }

    @Override
    public void onTick() {
        if (!Client.inGame()) {
            return;
        }
        if (Client.isPaused()) {
            return;
        }
        this.progress = 0.0f;
    }
}

