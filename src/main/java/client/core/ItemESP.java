/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class ItemESP
extends Feature {
    public static final String MODULE = "item_esp";
    public static final String DISPLAY = "\u0418\u0442\u0435\u043c\u0415\u0417\u041f";
    public static final int VTABLE_RVA = 12339440;

    public ItemESP() {
        super(MODULE, DISPLAY, Category.Render);
        this.add(Setting.mode("mode", "Box", "Box", "Plate", "Both"));
        this.add(Setting.number("scale", 1.0, 0.1, 5.0));
        this.add(Setting.number("plate_opacity", 1.0, 0.0, 1.0));
        this.add(Setting.bool("only_valuable", false));
        this.add(Setting.bool("highlight_talismans", true));
        this.add(Setting.color("talisman_color", 0xFFAA00));
        this.add(Setting.mode("box_geometry", "Full", "Full", "Corners"));
        this.add(Setting.gradient("box_colors", 0xFFFFFF, 0xFFFFFF));
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

