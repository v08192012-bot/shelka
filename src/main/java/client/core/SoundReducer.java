/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import java.util.Collections;
import java.util.List;

public final class SoundReducer
extends Feature {
    public static final String MODULE = "sound_reducer";
    public static final String DISPLAY = "\u0417\u043e\u0443\u043d\u0434\u0420\u0435\u0434\u0443\u0441\u0435\u0440";
    public static final int VTABLE_RVA = 12324936;
    public static final long RVA_CONSTRUCT = 2735200364304L;
    public static final long RVA_FILTER = 2735201559072L;
    public static final long RVA_APPLY = 2735200366112L;
    public static final long RVA_GROUP_TABLE = 2735212007768L;
    public static final long RVA_LAMBDA = 2735200366704L;
    public static final String MODE_OFF = "\u041e\u0442\u043a\u043b\u044e\u0447\u0435\u043d\u0438\u0435";
    public static final String MODE_REDUCE = "\u041f\u0440\u0438\u0433\u043b\u0443\u0448\u0435\u043d\u0438\u0435";
    public static final String GROUP_POTIONS = "splash_potion";
    public static final String GROUP_ORBS = "experience_orb";
    public static final String GROUP_LINGERING = "lingering_potion";
    public static final String GROUP_CREEPER = "creeper";
    public static final String GROUP_TNT = "tnt";
    public static final String GROUP_ANVIL = "anvil";
    public static final String GROUP_BELL = "block.bell";
    public static final String GROUP_NOTE_BELL = "note_block.bell";
    public static final String GROUP_ARROW = "arrow";
    public static final String GROUP_GHAST = "ghast";
    public static final String GROUP_SKELETON = "skeleton";
    public static final String GROUP_PORTAL = "portal";
    public static final String GROUP_DRAGON = "entity.ender_dragon.ambient";
    public static final String GROUP_WITHER = "wither";
    public static final String GROUP_PHANTOM = "phantom";
    public static final String GROUP_TRIDENT = "trident";
    public static final String GROUP_TOTEM = "totem";
    public static final String GROUP_WARDEN = "warden";
    public static final String GROUP_SCULK = "sculk";
    public static final int GROUP_COUNT = 17;
    public static final long GROUP_TABLE_STRIDE = 136L;
    public static final long GROUP_TABLE_BYTES = 2312L;
    private static final double DEFAULT_VOLUME = 0.5;
    private static final double MIN_VOLUME = 0.0;
    private static final double MAX_VOLUME = 1.0;
    private static SoundReducer active;

    public SoundReducer() {
        super(MODULE, DISPLAY, Category.Client);
        this.add(Setting.mode("mode", MODE_REDUCE, MODE_OFF, MODE_REDUCE));
        this.add(Setting.number("volume", 0.5, 0.0, 1.0, 0.01));
        this.add(Setting.multi("groups", GROUP_POTIONS, GROUP_ORBS, GROUP_LINGERING, GROUP_CREEPER, GROUP_TNT, GROUP_ANVIL, GROUP_BELL, GROUP_NOTE_BELL, GROUP_ARROW, GROUP_GHAST, GROUP_SKELETON, GROUP_PORTAL, GROUP_DRAGON, GROUP_WITHER, GROUP_PHANTOM, GROUP_TRIDENT, GROUP_TOTEM));
    }

    public static SoundReducer active() {
        return active;
    }

    public boolean isReduceMode() {
        Setting setting = this.setting("mode");
        return setting != null && MODE_REDUCE.equals(setting.getMode());
    }

    public double volumeFactor() {
        Setting setting = this.setting("volume");
        return setting == null ? 0.5 : setting.getNumber();
    }

    public int selectedGroupCount() {
        Setting setting = this.setting("groups");
        return setting == null ? 0 : setting.getSelectedModes().size();
    }

    public boolean isGroupSelected(String group) {
        Setting setting = this.setting("groups");
        return setting != null && setting.isSelected(group);
    }

    public static boolean processingActive() {
        SoundReducer reducer = active;
        return reducer != null && reducer.enabled && Client.streamCaptureActive();
    }

    public static boolean shouldFilter() {
        if (!SoundReducer.processingActive()) {
            return false;
        }
        return active.selectedGroupCount() != 0;
    }

    public void applyTo(Object soundId) {
        if (!Client.streamCaptureActive()) {
            return;
        }
        List<String> selected = this.selectedGroups();
        if (selected.isEmpty()) {
            return;
        }
        for (int i = 0; i < selected.size(); ++i) {
            Client.soundReducerApply(this, soundId, selected.get(i), this.isReduceMode(), this.volumeFactor());
        }
    }

    private List<String> selectedGroups() {
        Setting setting = this.setting("groups");
        return setting == null ? Collections.emptyList() : setting.getSelectedModes();
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }
}

