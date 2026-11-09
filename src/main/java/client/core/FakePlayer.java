/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.mc.Client;
import client.mc.Entity;

public final class FakePlayer
extends Feature {
    public static final String MODULE = "fake_player";
    public static final String DISPLAY = "\u0424\u0430\u043a\u0435\u041f\u043b\u0430\u0439\u0435\u0440";
    public static final int VTABLE_RVA = 12573208;
    public static final long RVA_CONSTRUCT = 2735199935936L;
    public static final long RVA_ON_TICK = 2735200694864L;
    public static final long RVA_ON_ENABLE = 2735200694368L;
    public static final long RVA_ON_DISABLE = 2735200694736L;
    private static final String NAME = "ShelkaLegit";
    private Entity fake;
    private int fakeId = -1;

    public FakePlayer() {
        super(MODULE, DISPLAY, Category.Render);
    }

    @Override
    public void onEnable() {
        if (!Client.inGame()) {
            return;
        }
        Entity created = Client.spawnNamedPlayer(NAME);
        if (created != null) {
            this.fakeId = Client.entityId(created);
            this.fake = created;
        }
    }

    @Override
    public void onDisable() {
        if (this.fake != null && Client.inGame()) {
            Client.removeEntity(this.fakeId);
        }
        this.fake = null;
        this.fakeId = -1;
    }

    @Override
    public void onTick() {
        if (this.fake == null) {
            return;
        }
        if (Client.inGame() && Client.isAlive(this.fake)) {
            return;
        }
        this.fake = null;
        this.fakeId = -1;
        Client.onFakePlayerRemoved();
    }
}

