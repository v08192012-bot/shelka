/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import client.mc.Entity;

public final class NoJumpDelay
extends Feature {
    public static final String MODULE = "nojumpdelay";
    public static final String DISPLAY = "\u041d\u043e\u0416\u0443\u043c\u043f\u0414\u0435\u043b\u0430\u0439";
    public static final int VTABLE_RVA = 0xBB8B28;
    public static final long RVA_CONSTRUCT = 2735200145840L;
    public static final long RVA_ON_TICK = 2735200146592L;

    public NoJumpDelay() {
        super(MODULE, DISPLAY, Category.Movement);
        this.add(Setting.number("delay", 0.0, 0.0, 10.0));
    }

    @Override
    public void onTick() {
        int cooldown;
        Entity self = Client.localPlayer();
        if (self == null) {
            return;
        }
        int delay = (int)this.delay();
        if (delay < (cooldown = Client.jumpCooldown(self))) {
            Client.setJumpCooldown(self, delay);
        }
        Client.checkJni();
    }

    private double delay() {
        Setting setting = this.setting("delay");
        return setting == null ? 0.0 : setting.getNumber();
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }
}

