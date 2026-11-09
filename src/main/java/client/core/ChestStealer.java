/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class ChestStealer
extends Feature {
    public static final String MODULE = "cheststealer";
    public static final String DISPLAY = "\u0421\u0445\u0435\u0437\u0442\u0417\u0442\u0435\u0430\u043b\u0435\u0440";
    public static final int VTABLE_RVA = 0xBBDBB8;
    public static final long RVA_CONSTRUCT = 2735200257792L;
    public static final long RVA_ON_TICK = 2735200258848L;
    public static final long RVA_ON_ENABLE = 2735200257776L;
    private static final double MILLIS_TO_NANOS = 1000000.0;
    private long lastMoveTime;

    public ChestStealer() {
        super(MODULE, DISPLAY, Category.Player);
        this.add(Setting.number("delay", 100.0, 0.0, 500.0, 10.0));
        this.add(Setting.bool("auto_close", true));
    }

    @Override
    public void onEnable() {
        this.lastMoveTime = 0L;
    }

    @Override
    public void onDisable() {
        this.lastMoveTime = 0L;
    }

    @Override
    public void onTick() {
        if (!Client.inGame() || !Client.containerScreenOpen()) {
            return;
        }
        long now = Client.timerNanos();
        if ((long)(this.delay() * 1000000.0) > now - this.lastMoveTime) {
            return;
        }
        int slot = Client.findStealSlot();
        if (slot == -1) {
            if (this.autoClose()) {
                Client.closeScreen();
            }
            return;
        }
        Client.clickSlot(slot, 0, 1);
        this.lastMoveTime = now;
    }

    private double delay() {
        Setting setting = this.setting("delay");
        return setting == null ? 100.0 : setting.getNumber();
    }

    private boolean autoClose() {
        Setting setting = this.setting("auto_close");
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

