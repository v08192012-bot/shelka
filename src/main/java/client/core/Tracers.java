/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class Tracers
extends Feature {
    public static final String MODULE = "tracers";
    public static final String DISPLAY = "\u0422\u0440\u0430\u0441\u0435\u0440\u0437";
    public static final int VTABLE_RVA = 12354376;
    private static final String[] TRACKED_ITEMS = new String[]{"ender_eye", "fire_charge", "sugar", "netherite_scrap", "dried_kelp", "snowball_freeze", "bozha_aura", "totem", "golden_apple", "god_apple", "snowball", "popped_chorus", "nether_star", "jack_o_lantern", "prismarine", "crossbow", "shulker", "potion_assassin", "potion_paladin", "holy_water", "potion_radiation", "potion_sleep", "potion_rage", "potion_popper", "talic_mrak", "talic_vihr", "talic_demon", "talic_razdor", "talic_yarost", "talic_krush", "talic_karatel", "talic_tiran", "ender_pearl", "chorus_fruit", "wind_charge", "experience_bottle"};

    public Tracers() {
        super(MODULE, DISPLAY, Category.Render);
        this.add(Setting.mode("targets", "All", "All", "Players", "Mobs"));
        this.add(Setting.number("max_distance", 64.0, 8.0, 256.0));
        this.add(Setting.mode("arrow_style", "Arrow", "Arrow", "Line", "Dot"));
        this.add(Setting.color("enemy_color", 0xFF0000));
        this.add(Setting.color("friend_color", 65280));
        this.add(Setting.number("arrow_size", 1.0, 0.1, 5.0));
        this.add(Setting.number("arrow_radius", 1.0, 0.1, 5.0));
        this.add(Setting.bool("labels", false));
        this.add(Setting.number("font_size", 1.0, 0.5, 3.0));
        for (String item : TRACKED_ITEMS) {
            this.add(Setting.bool(item, true));
        }
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

