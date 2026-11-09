/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class AutoAccept
extends Feature {
    public static final String MODULE = "autoaccept";
    public static final String DISPLAY = "\u0410\u0443\u0442\u043e\u0410\u0441\u0441\u0435\u043f\u0442";
    public static final int VTABLE_RVA = 12293592;
    public static final long RVA_CONSTRUCT = 2735200157088L;
    public static final long RVA_ON_TICK = 2735200159344L;
    public static final long RVA_ON_MESSAGE = 2735200158640L;
    public static final long RVA_ON_ENABLE = 2735200157056L;
    private boolean pending;
    private int delayTicks;

    public AutoAccept() {
        super(MODULE, DISPLAY, Category.Player);
        this.add(Setting.bool("friends_only", false));
        this.add(Setting.number("delay", 40.0, 1.0, 40.0, 1.0));
        this.add(Setting.input("command", "tpaccept"));
    }

    @Override
    public void onEnable() {
        this.pending = false;
        this.delayTicks = 0;
    }

    @Override
    public void onDisable() {
        this.pending = false;
        this.delayTicks = 0;
    }

    public void onChat(String message) {
        if (this.pending) {
            return;
        }
        if (!message.contains("teleport") || !message.contains("request")) {
            return;
        }
        if (this.friendsOnly() && !Client.isFriendTeleportRequest()) {
            return;
        }
        this.pending = true;
        this.delayTicks = (int)this.delay();
    }

    @Override
    public void onTick() {
        if (!this.pending || !Client.inGame()) {
            return;
        }
        if (this.delayTicks > 0) {
            --this.delayTicks;
            return;
        }
        this.pending = false;
        String command = this.command();
        while (command.startsWith("/")) {
            command = command.substring(1);
        }
        if (!command.isEmpty()) {
            Client.sendChatCommand(command);
        }
    }

    private boolean friendsOnly() {
        Setting setting = this.setting("friends_only");
        return setting != null && setting.getBoolean();
    }

    private double delay() {
        Setting setting = this.setting("delay");
        return setting == null ? 40.0 : setting.getNumber();
    }

    private String command() {
        Setting setting = this.setting("command");
        return setting == null ? "" : setting.getText();
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }
}

