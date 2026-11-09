/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;

public final class Atmosphere
extends Feature {
    public static final String MODULE = "atmosphere";
    public static final String DISPLAY = "\u0410\u0442\u043c\u043e\u0437\u043f\u0445\u0435\u0440\u0435";
    public static final int VTABLE_RVA = 12568456;
    public static final long RVA_ON_ENABLE = 2735200654576L;
    public static final long RVA_ON_DISABLE = 2735200654592L;
    public static final long RVA_LAMBDA_VISIBILITY = 2735200665024L;
    private static Atmosphere active;

    public Atmosphere() {
        super(MODULE, DISPLAY, Category.Render);
        this.add(Setting.mode("mode", "Dawn", "Dawn", "Day", "Dusk", "Night", "Dust", "Snow", "Ash"));
        this.add(Setting.number("density", 1.0, 0.0, 3.0));
        this.add(Setting.number("scatter_height", 64.0, 0.0, 320.0));
        this.add(Setting.number("god_rays", 1.0, 0.0, 3.0));
        this.add(Setting.number("softness", 1.0, 0.0, 3.0));
        this.add(Setting.color("dawn_color", -20384));
        this.add(Setting.number("amount", 1.0, 0.0, 3.0));
        this.add(Setting.number("speed", 1.0, 0.0, 5.0));
        this.add(Setting.number("haze", 1.0, 0.0, 3.0));
        this.add(Setting.number("grade", 1.0, 0.0, 3.0));
        this.add(Setting.number("vignette", 1.0, 0.0, 3.0));
    }

    public static Atmosphere active() {
        return active;
    }

    @Override
    public void onEnable() {
        active = this;
    }

    @Override
    public void onDisable() {
        active = null;
    }
}

