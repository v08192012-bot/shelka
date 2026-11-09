/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import java.util.HashMap;
import java.util.Map;

public final class ItemTracker
extends Feature {
    public static final String MODULE = "itemtracker";
    public static final int VTABLE_RVA = 12317312;
    private final Map<String, Integer> cooldowns = new HashMap<String, Integer>();
    private final Map<String, Integer> uses = new HashMap<String, Integer>();
    private final Map<String, Integer> throws_ = new HashMap<String, Integer>();

    public ItemTracker() {
        super(MODULE, "", Category.Render);
        this.add(Setting.number("radius", 32.0, 8.0, 128.0));
        this.add(Setting.mode("track", "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u044f", "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u044f"));
        this.add(Setting.bool("enemy_cooldowns", true));
        this.add(Setting.bool("include_self", false));
        this.add(Setting.bool("ignore_friends", true));
    }

    @Override
    public void onDisable() {
        this.cooldowns.clear();
        this.uses.clear();
        this.throws_.clear();
    }

    public double radius() {
        Setting s = this.setting("radius");
        return s == null ? 32.0 : s.getNumber();
    }

    public String track() {
        Setting s = this.setting("track");
        return s == null ? "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u044f" : s.getMode();
    }

    public boolean enemyCooldowns() {
        Setting s = this.setting("enemy_cooldowns");
        return s != null && s.getBoolean();
    }

    public boolean includeSelf() {
        Setting s = this.setting("include_self");
        return s != null && s.getBoolean();
    }

    public boolean ignoreFriends() {
        Setting s = this.setting("ignore_friends");
        return s != null && s.getBoolean();
    }

    public void trackUses(String owner, String item) {
        if (owner == null || item == null) {
            return;
        }
        if (!this.includeSelf() && owner.equals("self")) {
            return;
        }
        this.uses.merge(owner + ":" + item, 1, Integer::sum);
    }

    public void trackThrows(String owner, String item) {
        if (owner == null || item == null) {
            return;
        }
        this.throws_.merge(owner + ":" + item, 1, Integer::sum);
    }

    public void reportPotionImpact(String owner, String item) {
        if (owner == null || item == null) {
            return;
        }
        this.cooldowns.merge(owner + ":" + item, 1, Integer::sum);
    }

    private Setting setting(String name) {
        for (Setting s : this.getSettings()) {
            if (!s.getName().equals(name)) continue;
            return s;
        }
        return null;
    }
}

