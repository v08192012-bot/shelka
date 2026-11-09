/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class Theme
extends Feature {
    public static final String MODULE = "theme";
    public static final String DISPLAY = "\u0422\u0445\u0435\u043c\u0435";
    public static final int VTABLE_RVA = 12817784;
    public static final long RVA_CTOR = 2735203121792L;
    public static final long RVA_LAMBDA_STYLE = 2735203134800L;
    public static final long RVA_LAMBDA_EFFECT_FROSTED = 2735203134672L;
    public static final long RVA_LAMBDA_EFFECT_POSTERIZE = 2735203134544L;
    public static final long RVA_LAMBDA_EFFECT_PIXELATE = 2735203134416L;
    public static final long RVA_LAMBDA_EFFECT_WAVE = 2735203134288L;
    public static final long RVA_LAMBDA_EFFECT_INNER_GLOW = 2735203134160L;
    public static final long RVA_LAMBDA_EFFECT_CURSOR_LIGHT = 2735203134032L;
    public static final long RVA_LAMBDA_EFFECT_REVEAL = 2735203133904L;
    public static final long RVA_LAMBDA_COLOR_MODE_CUSTOM = 2735203133792L;
    public static final long RVA_LAMBDA_GRADIENT_ANGLE = 2735203133648L;
    public static final long RVA_LAMBDA_ACCENT_TARGETS = 2735203133536L;
    public static final String SETTING_EXCEPT_GUI = "except_gui";
    public static final String SETTING_STYLE = "style";
    public static final String SETTING_GUI_SCALE = "gui_scale";
    public static final String SETTING_GUI_BLUR = "gui_blur";
    public static final String SETTING_GUI_DIM = "gui_dim";
    public static final String SETTING_EFFECTS = "effects";
    public static final String SETTING_GLASS = "glass";
    public static final String SETTING_INTENSITY = "intensity";
    public static final String SETTING_REFRACTION = "refraction";
    public static final String SETTING_CHROMATIC = "chromatic";
    public static final String SETTING_BLUR = "blur";
    public static final String SETTING_TINT_STRENGTH = "tint_strength";
    public static final String SETTING_FROSTED = "frosted";
    public static final String SETTING_POSTERIZE = "posterize";
    public static final String SETTING_PIXELATE = "pixelate";
    public static final String SETTING_WAVE = "wave";
    public static final String SETTING_WAVE_SPEED = "wave_speed";
    public static final String SETTING_WAVE_FREQUENCY = "wave_frequency";
    public static final String SETTING_INNER_GLOW = "inner_glow";
    public static final String SETTING_INNER_GLOW_SIZE = "inner_glow_size";
    public static final String SETTING_INNER_GLOW_COLOR = "inner_glow_color";
    public static final String SETTING_CURSOR_SIZE = "cursor_size";
    public static final String SETTING_CURSOR_STRENGTH = "cursor_strength";
    public static final String SETTING_REVEAL_RADIUS = "reveal_radius";
    public static final String SETTING_REVEAL_STRENGTH = "reveal_strength";
    public static final String SETTING_COLOR_MODE = "color_mode";
    public static final String SETTING_ACCENT = "accent";
    public static final String SETTING_GRADIENT_ANGLE = "gradient_angle";
    public static final String SETTING_ACCENT_TARGETS = "accent_targets";
    public static final String STYLE_PLAIN = "O\u0431\u044b\u0447\u043d\u044b\u0439";
    public static final String STYLE_TRANSPARENT = "\u041f\u0440o\u0437\u0440\u0430\u0447\u043d\u044b\u0439";
    public static final String EFFECT_FROSTED = "frosted";
    public static final String EFFECT_POSTERIZE = "posterize";
    public static final String EFFECT_PIXELATE = "pixelate";
    public static final String EFFECT_WAVE = "wave";
    public static final String EFFECT_INNER_GLOW = "inner_glow";
    public static final String EFFECT_SHEEN = "sheen";
    public static final String EFFECT_GRAIN = "grain";
    public static final String EFFECT_CURSOR_LIGHT = "cursor_light";
    public static final String EFFECT_CURSOR_INERTIA = "cursor_inertia";
    public static final String EFFECT_REVEAL = "reveal";
    public static final String EFFECT_TINTED_RIM = "tinted_rim";
    public static final String EFFECT_SCENE_RIM = "scene_rim";
    public static final String EFFECT_PRISM = "prism";
    public static final String EFFECT_THICKNESS = "thickness";
    public static final String EFFECT_UNDER_GLOW = "under_glow";
    public static final String EFFECT_AURORA = "aurora";
    public static final String COLOR_MODE_DEFAULT = "default";
    public static final String COLOR_MODE_CUSTOM = "custom";
    public static final String TARGET_BACKGROUND = "background";
    public static final String TARGET_SURFACE = "surface";
    public static final String TARGET_TEXT = "text";
    public static final String TARGET_BORDER = "border";
    public static final double GLASS_STEP = 0.05;
    public static final double GLASS_MIN = 0.05;
    public static final double GLASS_MAX = 1.0;
    public static final double INTENSITY_DEFAULT = 1.0;
    public static final double REFRACTION_DEFAULT = 1.0;
    public static final double CHROMATIC_DEFAULT = 1.0;
    public static final double BLUR_DEFAULT = 0.4;
    public static final double BLUR_MAX = 0.8;
    public static final double BLUR_STEP = 0.1;
    public static final double TINT_DEFAULT = 0.02;
    public static final double TINT_MAX = 0.05;
    public static final double TINT_STEP = 0.001;
    public static final double FROSTED_DEFAULT = 0.5;
    public static final double POSTERIZE_DEFAULT = 0.5;
    public static final double PIXELATE_DEFAULT = 0.3;
    public static final double WAVE_DEFAULT = 0.5;
    public static final double WAVE_SPEED_DEFAULT = 1.0;
    public static final double WAVE_SPEED_MAX = 3.0;
    public static final double WAVE_SPEED_STEP = 0.1;
    public static final double WAVE_FREQUENCY_DEFAULT = 0.5;
    public static final double INNER_GLOW_DEFAULT = 0.3;
    public static final double INNER_GLOW_SIZE_DEFAULT = 0.5;
    public static final int INNER_GLOW_COLOR = -8401921;
    public static final double CURSOR_SIZE_DEFAULT = 1.0;
    public static final double CURSOR_SIZE_MIN = 0.3;
    public static final double CURSOR_STRENGTH_DEFAULT = 1.0;
    public static final double CURSOR_STRENGTH_MIN = 0.2;
    public static final double CURSOR_MAX = 3.0;
    public static final double REVEAL_RADIUS_DEFAULT = 1.0;
    public static final double REVEAL_RADIUS_MIN = 0.3;
    public static final double REVEAL_STRENGTH_DEFAULT = 1.0;
    public static final double REVEAL_STRENGTH_MIN = 0.2;
    public static final double REVEAL_STRENGTH_MAX = 2.0;
    public static final double GUI_SCALE_DEFAULT = 1.0;
    public static final double GUI_SCALE_MIN = 0.5;
    public static final double GUI_SCALE_MAX = 1.5;
    public static final double GUI_BLUR_DEFAULT = 18.0;
    public static final double GUI_BLUR_MAX = 64.0;
    public static final double GUI_BLUR_STEP = 1.0;
    public static final double GUI_DIM_DEFAULT = 35.0;
    public static final double GUI_DIM_MIN = 0.0;
    public static final double GUI_DIM_MAX = 100.0;
    public static final double GUI_DIM_STEP = 5.0;
    public static final int ACCENT_FROM = -2343358;
    public static final int ACCENT_TO = -9814308;
    public static final double GRADIENT_ANGLE_DEFAULT = 45.0;
    public static final double GRADIENT_ANGLE_MIN = 0.0;
    public static final double GRADIENT_ANGLE_MAX = 360.0;
    public static final double GRADIENT_ANGLE_STEP = 5.0;
    private static Theme active;

    public Theme() {
        super(MODULE, DISPLAY, Category.Client);
        this.add(Setting.bool(SETTING_EXCEPT_GUI, true));
        this.add(Setting.mode(SETTING_STYLE, STYLE_TRANSPARENT, STYLE_PLAIN, STYLE_TRANSPARENT));
        this.add(Setting.number(SETTING_GUI_SCALE, 1.0, 0.5, 1.5));
        this.add(Setting.number(SETTING_GUI_BLUR, 18.0, 0.0, 64.0));
        this.add(Setting.number(SETTING_GUI_DIM, 35.0, 0.0, 100.0));
        this.add(Setting.mode(SETTING_EFFECTS, EFFECT_SHEEN, "frosted", "posterize", "pixelate", "wave", "inner_glow", EFFECT_SHEEN, EFFECT_GRAIN, EFFECT_CURSOR_LIGHT, EFFECT_CURSOR_INERTIA, EFFECT_REVEAL, EFFECT_TINTED_RIM, EFFECT_SCENE_RIM, EFFECT_PRISM, EFFECT_THICKNESS, EFFECT_UNDER_GLOW, EFFECT_AURORA));
        this.add(Setting.bool(SETTING_GLASS, true));
        this.add(Setting.number(SETTING_INTENSITY, 1.0, 0.0, 1.0));
        this.add(Setting.number(SETTING_REFRACTION, 1.0, 0.0, 3.0));
        this.add(Setting.number(SETTING_CHROMATIC, 1.0, 0.0, 3.0));
        this.add(Setting.number(SETTING_BLUR, 0.4, 0.0, 0.8));
        this.add(Setting.number(SETTING_TINT_STRENGTH, 0.02, 0.0, 0.05));
        this.add(Setting.number("frosted", 0.5, 0.05, 1.0));
        this.add(Setting.number("posterize", 0.5, 0.05, 1.0));
        this.add(Setting.number("pixelate", 0.3, 0.05, 1.0));
        this.add(Setting.number("wave", 0.5, 0.05, 1.0));
        this.add(Setting.number(SETTING_WAVE_SPEED, 1.0, 0.0, 3.0));
        this.add(Setting.number(SETTING_WAVE_FREQUENCY, 0.5, 0.05, 1.0));
        this.add(Setting.number("inner_glow", 0.3, 0.05, 1.0));
        this.add(Setting.number(SETTING_INNER_GLOW_SIZE, 0.5, 0.05, 1.0));
        this.add(Setting.color(SETTING_INNER_GLOW_COLOR, -8401921));
        this.add(Setting.number(SETTING_CURSOR_SIZE, 1.0, 0.3, 3.0));
        this.add(Setting.number(SETTING_CURSOR_STRENGTH, 1.0, 0.2, 3.0));
        this.add(Setting.number(SETTING_REVEAL_RADIUS, 1.0, 0.3, 3.0));
        this.add(Setting.number(SETTING_REVEAL_STRENGTH, 1.0, 0.2, 2.0));
        this.add(Setting.mode(SETTING_COLOR_MODE, COLOR_MODE_DEFAULT, COLOR_MODE_DEFAULT, COLOR_MODE_CUSTOM, "bluepink", "polarize", "water", "lilac", "spring", "winter", "midnight", "earth", "forest", "galaxy"));
        this.add(Setting.gradient(SETTING_ACCENT, -2343358, -9814308));
        this.add(Setting.number(SETTING_GRADIENT_ANGLE, 45.0, 0.0, 360.0));
        this.add(Setting.mode(SETTING_ACCENT_TARGETS, TARGET_BACKGROUND, TARGET_BACKGROUND, TARGET_SURFACE, TARGET_TEXT, TARGET_BORDER));
        this.applyVisibility();
    }

    public static Theme active() {
        return active;
    }

    @Override
    public void onEnable() {
        active = this;
        this.applyVisibility();
        Client.applyTheme(this);
    }

    @Override
    public void onDisable() {
        active = null;
        Client.resetTheme();
    }

    @Override
    public void onTick() {
        this.applyVisibility();
    }

    @Override
    public void onRender() {
        Client.applyTheme(this);
    }

    @Override
    protected void onSettingsVisibilityChanged(boolean visible) {
        this.applyVisibility();
    }

    public boolean exceptGui() {
        Setting setting = this.setting(SETTING_EXCEPT_GUI);
        return setting != null && setting.getBoolean();
    }

    public boolean transparentStyle() {
        Setting setting = this.setting(SETTING_STYLE);
        return setting != null && STYLE_TRANSPARENT.equals(setting.getMode());
    }

    public boolean customColorMode() {
        return Client.settingListContains(this, SETTING_COLOR_MODE, COLOR_MODE_CUSTOM);
    }

    public boolean defaultColorMode() {
        return Client.settingListContains(this, SETTING_COLOR_MODE, COLOR_MODE_DEFAULT);
    }

    public boolean effectEnabled(String effect) {
        return Client.settingListContains(this, SETTING_EFFECTS, effect);
    }

    private void applyVisibility() {
        boolean style = this.transparentStyle();
        this.show(SETTING_INTENSITY, style);
        this.show(SETTING_REFRACTION, style);
        this.show(SETTING_CHROMATIC, style);
        this.show(SETTING_BLUR, style);
        this.show(SETTING_TINT_STRENGTH, style);
        this.show(SETTING_EFFECTS, style);
        this.show(SETTING_GLASS, style);
        boolean frosted = style && this.effectEnabled("frosted");
        this.show("frosted", frosted);
        boolean posterize = style && this.effectEnabled("posterize");
        this.show("posterize", posterize);
        boolean pixelate = style && this.effectEnabled("pixelate");
        this.show("pixelate", pixelate);
        boolean wave = style && this.effectEnabled("wave");
        this.show("wave", wave);
        this.show(SETTING_WAVE_SPEED, wave);
        this.show(SETTING_WAVE_FREQUENCY, wave);
        boolean innerGlow = style && this.effectEnabled("inner_glow");
        this.show("inner_glow", innerGlow);
        this.show(SETTING_INNER_GLOW_SIZE, innerGlow);
        this.show(SETTING_INNER_GLOW_COLOR, innerGlow);
        boolean cursorLight = style && this.effectEnabled(EFFECT_CURSOR_LIGHT);
        this.show(SETTING_CURSOR_SIZE, cursorLight);
        this.show(SETTING_CURSOR_STRENGTH, cursorLight);
        boolean reveal = style && this.effectEnabled(EFFECT_REVEAL);
        this.show(SETTING_REVEAL_RADIUS, reveal);
        this.show(SETTING_REVEAL_STRENGTH, reveal);
        boolean custom = this.customColorMode();
        this.show(SETTING_ACCENT, custom);
        this.show(SETTING_GRADIENT_ANGLE, style && custom && Client.themeAccentGradientActive());
        this.show(SETTING_ACCENT_TARGETS, !this.defaultColorMode());
    }

    private void show(String name, boolean visible) {
        Setting setting = this.setting(name);
        if (setting != null) {
            setting.setVisible(visible);
        }
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }
}

