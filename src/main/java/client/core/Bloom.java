/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;

public final class Bloom
extends Feature {
    public static final String MODULE = "bloom";
    public static final String DISPLAY = "\u0411\u043b\u043e\u043e\u043c";
    public static final int VTABLE_RVA = 12570616;
    private static Bloom active;

    public Bloom() {
        super(MODULE, DISPLAY, Category.Render);
        this.add(Setting.number("threshold", 0.9, 0.0, 1.0));
        this.add(Setting.number("intensity", 4.0, 0.0, 10.0));
        this.add(Setting.number("boost", 3.0, 0.0, 8.0));
        this.add(Setting.bool("world_only", true));
    }

    public static Bloom active() {
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

