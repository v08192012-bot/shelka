/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class HandGlow
extends Feature {
    public static final String MODULE = "hand_glow";
    public static final String DISPLAY = "\u0425\u0430\u043d\u0434\u0413\u043b\u043e\u0448";
    public static final int VTABLE_RVA = 12576904;
    public static final long RVA_CONSTRUCT = 2735200701296L;
    public static final long RVA_ON_ENABLE = 2735200701280L;
    public static final long RVA_ON_DISABLE = 2735200707664L;
    public static final int GRADIENT_MODE_WAVE = 0;
    public static final int GRADIENT_MODE_DIAGONAL = 1;
    public static final int GRADIENT_MODE_VERTICAL = 2;
    public static final int GRADIENT_MODE_RADIAL = 3;
    public static final int GRADIENT_MODE_PULSE = 4;
    public static final int COLOR_FROM = -13183233;
    public static final int COLOR_TO = -38090;
    private static HandGlow active;

    public HandGlow() {
        super(MODULE, DISPLAY, Category.Render);
        this.add(Setting.mode("colors", "item_color", "item_color", "color", "gradient_mode", "gradient_speed", "gradient_scale"));
        this.add(Setting.bool("item_color", false));
        this.add(Setting.gradient("color", -13183233, -38090));
        this.add(Setting.mode("gradient_mode", "wave", "wave", "diagonal", "vertical", "radial", "pulse"));
        this.add(Setting.number("gradient_speed", 0.5, 0.0, 5.0, 0.05));
        this.add(Setting.number("gradient_scale", 3.0, 0.5, 8.0, 0.1));
        this.add(Setting.mode("glow", "radius", "radius", "intensity"));
        this.add(Setting.number("radius", 16.0, 4.0, 64.0, 1.0));
        this.add(Setting.number("intensity", 1.5, 0.3, 4.0, 0.05));
        this.add(Setting.mode("animation_group", "animation", "animation", "flame_strength", "flame_rise", "flame_wobble", "flame_fade", "flame_intensity"));
        this.add(Setting.bool("animation", false));
        this.add(Setting.number("flame_strength", 3.0, 1.0, 5.0, 1.0));
        this.add(Setting.number("flame_rise", 2.5, 0.5, 4.0, 0.1));
        this.add(Setting.number("flame_wobble", 2.0, 0.0, 2.0, 0.1));
        this.add(Setting.number("flame_fade", 50.0, 0.0, 80.0, 1.0));
        this.add(Setting.number("flame_intensity", 2.0, 0.5, 4.0, 0.1));
    }

    public static HandGlow active() {
        return active;
    }

    public int gradientMode() {
        Setting setting = this.setting("gradient_mode");
        if (setting == null) {
            return 0;
        }
        String mode = setting.getMode();
        if ("diagonal".equals(mode)) {
            return 1;
        }
        if ("vertical".equals(mode)) {
            return 2;
        }
        if ("radial".equals(mode)) {
            return 3;
        }
        if ("pulse".equals(mode)) {
            return 4;
        }
        return 0;
    }

    @Override
    public void onEnable() {
        active = this;
    }

    @Override
    public void onDisable() {
        active = null;
        Client.markHandGlowDirty();
    }

    private Setting setting(String name) {
        for (Setting candidate : this.getSettings()) {
            if (!candidate.getName().equals(name)) continue;
            return candidate;
        }
        return null;
    }
}

