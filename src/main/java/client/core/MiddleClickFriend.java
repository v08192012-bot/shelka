/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import client.mc.Entity;

public final class MiddleClickFriend
extends Feature {
    public static final String MODULE = "middle_click_friend";
    public static final String DISPLAY = "\u041c\u0421\u0424";
    public static final int VTABLE_RVA = 12266248;
    public static final int SLOT_ON_BIND = 4;
    public static final long RVA_CONSTRUCT = 2735199990080L;
    public static final long RVA_ON_BIND = 2735199990752L;
    private static final int BIND_MODE = 0;

    public MiddleClickFriend() {
        super(MODULE, DISPLAY, Category.Player);
        this.add(Setting.key("key", 4));
    }

    @Override
    public void onTick() {
        if (!Client.isBindDown(this.bind(), 0)) {
            return;
        }
        if (!Client.inGame()) {
            return;
        }
        if (Client.isScreenOpen()) {
            return;
        }
        Entity target = Client.crosshairEntity();
        if (target == null) {
            return;
        }
        if (!Client.isPlayer(target)) {
            return;
        }
        Entity self = Client.localPlayer();
        if (self == null) {
            return;
        }
        if (Client.entityId(target) == Client.entityId(self)) {
            return;
        }
        String raw = Client.playerName(target);
        if (raw.isEmpty()) {
            return;
        }
        if (!Client.friendExists(raw)) {
            Client.addFriend(raw);
            return;
        }
        String name = raw.trim();
        if (name.isEmpty()) {
            return;
        }
        if (Client.removeFriend(name)) {
            Client.bumpFriendRevision();
            Client.notifyFriendListChanged();
        }
    }

    private int bind() {
        Setting setting = this.setting("key");
        return setting == null ? 4 : setting.getKey();
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }
}

