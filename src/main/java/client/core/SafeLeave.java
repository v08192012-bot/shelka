/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import java.util.List;

public final class SafeLeave
extends Feature {
    public static final String MODULE = "safeleave";
    public static final String DISPLAY = "\u0417\u0430\u0444\u0435\u041b\u0435\u0430\u0432\u0435";
    public static final int VTABLE_RVA = 12323560;
    public static final long RVA_CONSTRUCT = 2735200359392L;
    public static final long RVA_ON_TICK = 2735200361424L;
    public static final long RVA_ON_MESSAGE = 2735200360608L;
    public static final long RVA_ON_ENABLE = 2735200358624L;
    private static final String MODE_HOLYWORLD = "holyworld";
    private static final String MODE_SCOREBOARD = "scoreboard";
    private static final long MESSAGE_WINDOW_NANOS = 30000000000L;
    private static final long NANOS_PER_MILLI = 1000000L;
    private boolean leaving;
    private long holdUntil;

    public SafeLeave() {
        super(MODULE, DISPLAY, Category.Movement);
        this.add(Setting.mode("mode", MODE_SCOREBOARD, MODE_HOLYWORLD, MODE_SCOREBOARD));
    }

    @Override
    public void onDisable() {
        this.leaving = false;
        this.holdUntil = 0L;
    }

    @Override
    public void onTick() {
        boolean combat;
        if (!Client.inGame()) {
            this.leaving = false;
            return;
        }
        if (this.isHolyWorld()) {
            combat = Client.holyWorldCombatTicks() > 0;
        } else {
            List<String> lines = Client.scoreboardLines();
            combat = Client.containsLeaveMarker(lines);
        }
        if (combat && !this.leaving) {
            this.leaving = true;
            Client.leaveServer();
        }
        this.leaving = combat;
    }

    public void onMessage(String message) {
        long remaining;
        if (!this.isHolyWorld()) {
            return;
        }
        if (!Client.listContains(Client.boardSections(), message)) {
            return;
        }
        long seconds = Client.messageNumber(message);
        if (seconds <= 0L) {
            this.holdUntil = 0L;
            return;
        }
        long now = Client.timerNanos();
        if (this.holdUntil != 0L && (remaining = this.holdUntil - now) > 0L && Client.playerHealth() <= 0.0) {
            return;
        }
        this.holdUntil = seconds * 1000000000L + now;
        if (Client.textNumber(message, 6) > 0) {
            this.holdUntil = now;
        }
    }

    public boolean pending() {
        return this.holdUntil != 0L && this.holdUntil - Client.timerNanos() > 1000000000L;
    }

    private boolean isHolyWorld() {
        Setting setting = this.setting("mode");
        return setting != null && MODE_HOLYWORLD.equals(setting.getMode());
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }
}

