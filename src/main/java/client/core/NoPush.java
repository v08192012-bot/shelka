/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.mc.Client;

public final class NoPush
extends Feature {
    public static final String MODULE = "nopush";
    public static final String DISPLAY = "\u041d\u043e\u041f\u0443\u0437\u0445";
    public static final int VTABLE_RVA = 12318280;
    public static final long RVA_CONSTRUCT = 2735199916544L;
    public static final long RVA_ON_ENABLE = 2735200322048L;
    public static final long RVA_ON_DISABLE = 2735200322064L;

    public NoPush() {
        super(MODULE, DISPLAY, Category.Movement);
    }

    @Override
    public void onEnable() {
        Client.registerNoPush(this);
    }

    @Override
    public void onDisable() {
        Client.registerNoPush(null);
    }
}

