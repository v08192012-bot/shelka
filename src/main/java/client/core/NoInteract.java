/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.mc.Client;

public final class NoInteract
extends Feature {
    public static final String MODULE = "nointeract";
    public static final String DISPLAY = "\u041d\u043e\u0418\u043d\u0442\u0435\u0440\u0430\u0441\u0442";
    public static final int VTABLE_RVA = 12318016;
    public static final long RVA_CONSTRUCT = 2735199916544L;
    public static final long RVA_ON_ENABLE = 2735200322016L;
    public static final long RVA_ON_DISABLE = 2735200322032L;

    public NoInteract() {
        super(MODULE, DISPLAY, Category.Movement);
    }

    @Override
    public void onEnable() {
        Client.registerNoInteract(this);
    }

    @Override
    public void onDisable() {
        Client.registerNoInteract(null);
    }
}

