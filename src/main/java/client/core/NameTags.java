/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import client.mc.Entity;
import java.util.ArrayList;
import java.util.List;

public final class NameTags
extends Feature {
    public static final String MODULE = "nametags";
    public static final String DISPLAY = "\u041d\u0430\u043c\u0435\u0422\u0430\u0433\u0437";
    public static final int VTABLE_RVA = 12342408;
    public static final long RVA_CONSTRUCT = 2735200453888L;
    public static final long RVA_ON_TICK = 2735200463280L;
    public static final long RVA_ON_RENDER = 2735200469536L;
    public static final long RVA_ON_ENABLE = 2735200461696L;
    public static final long RVA_ON_DISABLE = 2735200461696L;
    public static final long RVA_TICK_LAMBDA = 2735200464080L;
    public static final long RVA_PREFIX_REFRESH = 2735200461712L;
    public static final String KEY_OFF = "off";
    public static final String KEY_MINEBLAZE = "mineblaze";
    public static final String KEY_FUNTIME = "funtime";
    public static final String KEY_HEARTS = "hearts";
    public static final String KEY_POINTS = "points";
    public static final String KEY_FRIENDS = "friends";
    public static final String KEY_ENEMIES = "enemies";
    public static final String KEY_ARMORED_ENEMIES_ONLY = "armored_enemies_only";
    public static final String KEY_PREFIX = "prefix";
    public static final String KEY_ARMOR = "armor";
    public static final String KEY_OFFHAND = "offhand";
    public static final String KEY_MAINHAND = "mainhand";
    public static final String KEY_COLORED_HP = "colored_hp";
    public static final String KEY_HIDE_EMPTY = "hide_empty";
    public static final String KEY_SHOW_COUNT = "show_count";
    public static final String KEY_BACKGROUND = "background";
    public static final String KEY_BG_OPACITY = "bg_opacity";
    public static final String KEY_LOD = "lod";
    public static final String KEY_LOD_DISTANCE = "lod_distance";
    private static final int SLOT_REFRESH_PERIOD = 5;
    private final List<Object> entries = new ArrayList<Object>();
    private boolean funtime;
    private boolean mineblaze;
    private boolean prefix;
    private boolean refreshSlot;
    private boolean hearts;
    private boolean slotsEnabled;
    private boolean voiceReady;
    private boolean pulseReady;
    private int slotRefreshCounter;

    public NameTags() {
        super(MODULE, DISPLAY, Category.Render);
        this.add(Setting.bool("hp_bypass", false));
        this.add(Setting.bool(KEY_OFF, false));
        this.add(Setting.bool(KEY_MINEBLAZE, false));
        this.add(Setting.bool(KEY_FUNTIME, true));
        this.add(Setting.bool("hp_mode", false));
        this.add(Setting.bool(KEY_HEARTS, false));
        this.add(Setting.bool(KEY_POINTS, true));
        this.add(Setting.number("scale", 0.35, 0.01, 1.0));
        this.add(Setting.number("max_distance", 64.0, 8.0, 256.0));
        this.add(Setting.bool("targets", false));
        this.add(Setting.bool(KEY_FRIENDS, false));
        this.add(Setting.bool(KEY_ENEMIES, false));
        this.add(Setting.bool(KEY_ARMORED_ENEMIES_ONLY, false));
        this.add(Setting.bool("parts", false));
        this.add(Setting.bool(KEY_PREFIX, true));
        this.add(Setting.bool(KEY_ARMOR, true));
        this.add(Setting.bool(KEY_OFFHAND, true));
        this.add(Setting.bool(KEY_MAINHAND, false));
        this.add(Setting.bool(KEY_COLORED_HP, true));
        this.add(Setting.bool("voice_icon", true));
        this.add(Setting.bool("pulse_icon", true));
        this.add(Setting.bool(KEY_BACKGROUND, true));
        this.add(Setting.number(KEY_BG_OPACITY, 100.0, 0.0, 100.0));
        this.add(Setting.bool("plate", true));
        this.add(Setting.bool(KEY_HIDE_EMPTY, false));
        this.add(Setting.bool(KEY_SHOW_COUNT, true));
        this.add(Setting.bool("slots", true));
        this.add(Setting.bool("keep_vanilla", false));
        this.add(Setting.bool(KEY_LOD, false));
        this.add(Setting.number(KEY_LOD_DISTANCE, 30.0, 8.0, 128.0));
        this.add(Setting.bool("lod_group", true));
    }

    public List<Object> entries() {
        return this.entries;
    }

    @Override
    public void onEnable() {
        this.reset();
        Client.resetNameTagGroups(this);
    }

    @Override
    public void onDisable() {
        this.reset();
        Client.resetNameTagGroups(this);
    }

    public void reset() {
        this.entries.clear();
        Client.resetNameTagLayout(this);
    }

    @Override
    public void onTick() {
        if (!this.entries.isEmpty()) {
            this.entries.clear();
            Client.resetNameTagLayout(this);
        }
        Client.resetNameTagGroups(this);
        Entity self = Client.player();
        if (self == null) {
            return;
        }
        this.funtime = this.flag(KEY_FUNTIME);
        this.mineblaze = this.flag(KEY_MINEBLAZE);
        if (this.mineblaze) {
            Client.refreshNameTagPrefixes(this);
        }
        this.prefix = this.flag(KEY_PREFIX);
        ++this.slotRefreshCounter;
        this.refreshSlot = this.slotRefreshCounter == this.slotRefreshCounter / 5 * 5;
        this.hearts = this.flag(KEY_HEARTS);
        this.slotsEnabled = !this.flag(KEY_ARMOR) && !this.flag(KEY_OFFHAND) ? this.flag(KEY_MAINHAND) : true;
        if (!Client.voiceChatEnabled()) {
            this.voiceReady = false;
        } else {
            Client.initVoiceChatIcon();
            this.voiceReady = Client.voiceChatIconReady();
        }
        if (!Client.flagC48(this)) {
            this.pulseReady = false;
        } else {
            Client.initPulseIcon();
            this.pulseReady = Client.pulseIconReady();
        }
        double[] position = Client.entityPosition(self);
        double distanceSq = this.maxDistance() * this.maxDistance();
        Client.forEachPlayer(player -> Client.buildNameTag(this, player, position, distanceSq, this.voiceReady, this.pulseReady, this.prefix, this.refreshSlot, this.funtime, this.mineblaze, this.hearts, this.slotsEnabled));
    }

    @Override
    public void onRender() {
        Client.renderNameTags(this);
    }

    private double maxDistance() {
        Setting setting = this.setting("max_distance");
        return setting == null ? 64.0 : setting.getNumber();
    }

    private boolean flag(String name) {
        Setting setting = this.setting(name);
        return setting != null && setting.getBoolean();
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }
}

