/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import client.mc.Entity;

public final class AutoRespawn
extends Feature {
    public static final String MODULE = "autorespawn";
    public static final String DISPLAY = "\u0410\u0443\u0442\u043e\u0420\u0435\u0437\u043f\u0430\u0448\u043d";
    public static final int VTABLE_RVA = 12296624;
    public static final long RVA_ON_TICK = 2735200175408L;
    public static final long RVA_ON_ENABLE = 2735200174704L;
    public static final long RVA_ON_DISABLE = 2735200174704L;
    private static final String MESSAGE_DEATH_COORDS = "\u0412\u044b \u0443\u043c\u0435\u0440\u043b\u0438 \u043d\u0430 \u043a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u0430\u0445: X={} Y={} Z={}";
    private static final long RESPAWN_DELAY = 500000000L;
    private long respawnAt;
    private boolean deathLatch;

    public AutoRespawn() {
        super(MODULE, DISPLAY, Category.Movement);
        this.add(Setting.bool("show_coordinates", true));
    }

    @Override
    public void onEnable() {
        this.respawnAt = 0L;
        this.deathLatch = false;
    }

    @Override
    public void onDisable() {
        this.respawnAt = 0L;
        this.deathLatch = false;
    }

    @Override
    public void onTick() {
        if (!Client.inGame()) {
            this.respawnAt = 0L;
            this.deathLatch = false;
            return;
        }
        Entity player = Client.player();
        if (Client.health(player) > 0.0 && !Client.isDeathScreenOpen()) {
            this.deathLatch = false;
            this.respawnAt = 0L;
            return;
        }
        if (!this.deathLatch && Client.isDeathScreenOpen()) {
            this.deathLatch = true;
            if (this.showCoordinates()) {
                double[] position = Client.entityPosition(player);
                Client.sendSystemMessage(Client.formatMessage(MESSAGE_DEATH_COORDS, (int)position[0], (int)position[1], (int)position[2]));
            }
            this.respawnAt = Client.nanos() + 500000000L;
            return;
        }
        if (this.respawnAt == 0L) {
            return;
        }
        if (Client.nanos() < this.respawnAt) {
            return;
        }
        this.respawnAt = 0L;
        if (Client.isDeathScreenOpen()) {
            Client.closeScreen();
        }
        if (player == null) {
            return;
        }
        Client.requestRespawn(player);
    }

    public long respawnAt() {
        return this.respawnAt;
    }

    public boolean deathLatch() {
        return this.deathLatch;
    }

    private boolean showCoordinates() {
        Setting setting = this.setting("show_coordinates");
        return setting != null && setting.getBoolean();
    }

    private Setting setting(String name) {
        for (Setting value : this.getSettings()) {
            if (!value.getName().equals(name)) continue;
            return value;
        }
        return null;
    }
}

