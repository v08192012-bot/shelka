/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class GhostHand
extends Feature {
    public static final String MODULE = "ghosthand";
    public static final String DISPLAY = "\u0413\u0445\u043e\u0437\u0442\u0425\u0430\u043d\u0434";
    public static final int VTABLE_RVA = 12314736;
    public static final int OFFSET_TARGET_HANDLE = 672;
    public static final int OFFSET_ATTACK_THROUGH_WALLS = 984;
    public static final int OFFSET_ONLY_CONTAINERS = 1224;
    private Object targetHandle;

    public GhostHand() {
        super(MODULE, DISPLAY, Category.Player);
        this.add(Setting.number("range", 3.0, 1.0, 6.0));
        this.add(Setting.bool("only_containers", false));
        this.add(Setting.bool("attack_through_walls", false));
        this.add(Setting.bool("attack_players", true));
        this.add(Setting.bool("attack_mobs", false));
        this.add(Setting.number("attack_range", 3.0, 1.0, 6.0));
    }

    @Override
    public void onDisable() {
        this.targetHandle = null;
    }

    @Override
    public void onTick() {
        Object target;
        if (!Client.inGame()) {
            return;
        }
        if (this.onlyContainers() && Client.isScreenOpen() && (target = this.findTarget()) != null) {
            Client.attackTarget(target);
            return;
        }
        Client.interactTarget(this.targetHandle, this.attackThroughWalls());
    }

    private Object findTarget() {
        return Client.raycastEntity();
    }

    private boolean onlyContainers() {
        Setting setting = this.setting("only_containers");
        return setting != null && setting.getBoolean();
    }

    private boolean attackThroughWalls() {
        Setting setting = this.setting("attack_through_walls");
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

