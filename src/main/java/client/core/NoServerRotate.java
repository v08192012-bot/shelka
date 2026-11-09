/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.mc.Client;

public final class NoServerRotate
extends Feature {
    public static final String MODULE = "noserverrotate";
    public static final String DISPLAY = "\u041d\u043e\u0417\u0435\u0440\u0432\u0435\u0440\u0420\u043e\u0442\u0430\u0442\u0435";
    public static final int VTABLE_RVA = 12318576;
    public static final long RVA_CONSTRUCT = 2735199916544L;
    public static final long RVA_ON_ENABLE = 2735200322080L;
    public static final long RVA_ON_DISABLE = 2735200322096L;

    public NoServerRotate() {
        super(MODULE, DISPLAY, Category.Player);
    }

    @Override
    public void onEnable() {
        Client.registerNoServerRotate(this);
    }

    @Override
    public void onDisable() {
        Client.registerNoServerRotate(null);
    }
}

