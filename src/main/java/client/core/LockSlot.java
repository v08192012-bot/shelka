/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;

public final class LockSlot
extends Feature {
    public static final String MODULE = "lockslot";
    public static final String DISPLAY = "\u041b\u043e\u0441\u043a\u0417\u043b\u043e\u0442";
    public static final int VTABLE_RVA = 12317712;
    public static final long RVA_ON_ENABLE = 2735200319376L;
    public static final long RVA_ON_DISABLE = 2735200319392L;
    public static final long RVA_OPTIONS_BUILD = 2735200319408L;
    public static final int OPTION_COUNT = 9;
    private static LockSlot active;

    public LockSlot() {
        super(MODULE, DISPLAY, Category.Player);
        String[] slots = new String[9];
        for (int i = 0; i < 9; ++i) {
            slots[i] = Integer.toString(i + 1);
        }
        this.add(Setting.multi("slots", slots));
    }

    public static LockSlot active() {
        return active;
    }

    public static boolean isLocked(int slot) {
        if (active == null || slot < 0 || slot >= 9) {
            return false;
        }
        Setting setting = active.setting("slots");
        if (setting == null) {
            return false;
        }
        String value = Integer.toString(slot + 1);
        for (String selected : setting.getSelectedModes()) {
            if (!selected.equals(value)) continue;
            return true;
        }
        return false;
    }

    @Override
    public void onEnable() {
        active = this;
    }

    @Override
    public void onDisable() {
        active = null;
    }

    private Setting setting(String name) {
        for (Setting candidate : this.getSettings()) {
            if (!candidate.getName().equals(name)) continue;
            return candidate;
        }
        return null;
    }
}

