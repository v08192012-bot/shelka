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

public final class ItemColor
extends Feature {
    public static final String MODULE = "item_color";
    public static final String DISPLAY = "\u0418\u0442\u0435\u043c\u0421\u043e\u043b\u043e\u0440";
    public static final int VTABLE_RVA = 12336408;
    public static final long RVA_TICK = 2735200434320L;
    public static final long RVA_ON_RENDER = 2735200436320L;
    public static final long RVA_IS_VISIBLE = 2735200430768L;
    public static final long RVA_RESET = 2735200430800L;
    public static final int HIGHLIGHT_STATIC = 1;
    public static final int HIGHLIGHT_BLINK = 2;
    public static final int WHITE = -1;
    public static final int ITEM_SHULKER = 27;
    public static final Entry[] ENTRIES = new Entry[]{new Entry("ender_eye", 1, -1), new Entry("fire_charge", 2, -1), new Entry("sugar", 3, -1), new Entry("netherite_scrap", 6, -1), new Entry("dried_kelp", 7, -1), new Entry("snowball_freeze", 13, -1), new Entry("bozha_aura", 18, -1), new Entry("totem", 4, -1), new Entry("golden_apple", 8, -1), new Entry("god_apple", 9, -1), new Entry("snowball", 13, -1), new Entry("popped_chorus", 11, -1), new Entry("nether_star", 14, -1), new Entry("jack_o_lantern", 15, -1), new Entry("prismarine", 16, -1), new Entry("crossbow", 20, -1), new Entry("shulker", 27, -1), new Entry("potion_assassin", 19, 0x333333), new Entry("potion_paladin", 19, 65535), new Entry("holy_water", 19, 0xFFFFFF), new Entry("potion_radiation", 19, 3329330), new Entry("potion_sleep", 19, 255), new Entry("potion_rage", 19, 0x993333), new Entry("potion_popper", 19, 16738740), new Entry("talic_mrak", 4, -1), new Entry("talic_vihr", 4, -1), new Entry("talic_demon", 4, -1), new Entry("talic_razdor", 4, -1), new Entry("talic_yarost", 4, -1), new Entry("talic_krush", 4, -1), new Entry("talic_karatel", 4, -1), new Entry("talic_tiran", 4, -1), new Entry("ender_pearl", 12, -1), new Entry("chorus_fruit", 10, -1), new Entry("wind_charge", 17, -1), new Entry("experience_bottle", 5, -1)};
    public static final int[] SHULKER_ITEM_IDS = new int[]{27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43};
    public static final int[] TALISMAN_IDS = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    private final List<int[]> highlights = new ArrayList<int[]>();
    private int screenId;
    private boolean applied;

    public ItemColor() {
        super(MODULE, DISPLAY, Category.Render);
        this.add(Setting.mode("highlight", "\u0421\u0442\u0430\u0442\u0438\u043a", "\u0421\u0442\u0430\u0442\u0438\u043a", "\u041c\u0438\u0433\u0430\u0442\u044c"));
        String[] keys = new String[ENTRIES.length];
        for (int i = 0; i < ENTRIES.length; ++i) {
            keys[i] = ItemColor.ENTRIES[i].key;
        }
        this.add(Setting.multi("items", keys));
        for (Entry entry : ENTRIES) {
            this.add(Setting.color(entry.key, entry.color));
        }
        this.add(Setting.multi("options", keys));
    }

    public List<int[]> highlights() {
        return this.highlights;
    }

    public int screenId() {
        return this.screenId;
    }

    public boolean hasHighlights() {
        return !this.highlights.isEmpty();
    }

    public int highlightMode() {
        Setting setting = this.setting("highlight");
        if (setting == null) {
            return 1;
        }
        return "\u041c\u0438\u0433\u0430\u0442\u044c".equals(setting.getMode()) ? 2 : 1;
    }

    public int colorOf(String key) {
        Setting setting = this.setting(key);
        return setting == null ? -1 : setting.getColor();
    }

    public boolean isItemEnabled(String key) {
        Setting setting = this.setting("items");
        return setting != null && setting.isSelected(key);
    }

    @Override
    public void onEnable() {
        this.reset();
    }

    @Override
    public void onDisable() {
        this.reset();
    }

    private void reset() {
        if (!this.highlights.isEmpty()) {
            this.highlights.clear();
        }
    }

    @Override
    public void onTick() {
        this.highlights.clear();
        this.applied = false;
        if (!Client.containerScreenOpen()) {
            return;
        }
        this.screenId = Client.openScreenId();
        int size = Client.containerSize();
        for (int index = 0; index < size; ++index) {
            Entry entry;
            Object item;
            Object stack = Client.slotStack(index);
            if (stack == null || !Client.stackPresent(stack) || (item = Client.slotItem(index)) == null || !Client.colorComponentMatches(item) || !Client.stackPresent(stack) || (entry = this.match(stack)) == null || !this.isItemEnabled(entry.key)) continue;
            int[] colors = Client.stackColorPair(stack);
            this.highlights.add(new int[]{colors[0], colors[1], this.colorOf(entry.key)});
        }
    }

    @Override
    public void onRender() {
        boolean previous = this.applied;
        this.applied = false;
        if (previous || this.highlights.isEmpty()) {
            return;
        }
        if (Client.containerScreenOpen()) {
            Client.applyItemColors(this);
        }
    }

    private Entry match(Object stack) {
        for (Entry entry : ENTRIES) {
            if (Client.stackMatchesItemId(stack, entry.itemId)) {
                return entry;
            }
            if (entry.itemId != 27 || !Client.stackMatchesAnyItemId(stack, SHULKER_ITEM_IDS)) continue;
            return entry;
        }
        return null;
    }

    private Setting setting(String name) {
        for (Setting candidate : this.getSettings()) {
            if (!candidate.getName().equals(name)) continue;
            return candidate;
        }
        return null;
    }

    public static final class Entry {
        public final String key;
        public final int itemId;
        public final int color;

        Entry(String key, int itemId, int color) {
            this.key = key;
            this.itemId = itemId;
            this.color = color;
        }
    }
}

