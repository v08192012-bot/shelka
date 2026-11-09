/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class Enchancer
extends Feature {
    public static final String MODULE = "enchancer";
    public static final String DISPLAY = "\u0415\u043d\u0441\u0445\u0430\u043d\u0441\u0435\u0440";
    public static final int VTABLE_RVA = 12572968;

    public Enchancer() {
        super(MODULE, DISPLAY, Category.Render);
        this.add(Setting.bool("chat", true));
        this.add(Setting.bool("clean_f3", false));
        this.add(Setting.mode("f3_fields", "All", "All", "Position", "Fps"));
        this.add(Setting.bool("typing", true));
        this.add(Setting.number("typing_time", 1.0, 0.0, 10.0));
        this.add(Setting.mode("typing_style", "Fade", "Fade", "Slide"));
    }

    @Override
    public void onDisable() {
    }

    @Override
    public void onTick() {
        if (!Client.inGame()) {
            return;
        }
        if (Client.isPaused()) {
            return;
        }
    }
}

