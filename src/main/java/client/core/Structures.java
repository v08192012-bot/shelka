/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import java.util.ArrayList;
import java.util.List;

public final class Structures
extends Feature {
    public static final String MODULE = "structures";
    public static final String DISPLAY = "\u0417\u0442\u0440\u0443\u0441\u0442\u0443\u0440\u0435\u0437";
    public static final int VTABLE_RVA = 12352160;
    private final List<int[]> tracked = new ArrayList<int[]>();

    public Structures() {
        super(MODULE, DISPLAY, Category.Render);
        this.add(Setting.mode("tracked", "All", "All", "Stuns", "Marks"));
        this.add(Setting.number("plate_scale", 1.0, 0.1, 5.0));
        this.add(Setting.color("stun_color", 0xFFAA00));
    }

    @Override
    public void onEnable() {
        this.tracked.clear();
    }

    @Override
    public void onDisable() {
        this.tracked.clear();
    }

    @Override
    public void onTick() {
        if (!Client.inGame()) {
            return;
        }
        if (Client.isPaused()) {
            return;
        }
        this.tracked.clear();
    }
}

