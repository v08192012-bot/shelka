/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class NoSlow
extends Feature {
    public static final String MODULE = "noslow";
    public static final String DISPLAY = "\u041d\u043e\u0417\u043b\u043e\u0448";
    public static final int VTABLE_RVA = 12291408;
    public static final long RVA_CONSTRUCT = 2735200146816L;
    public static final long RVA_ON_ENABLE = 2735200146784L;
    public static final long RVA_ON_DISABLE = 2735200146800L;

    public NoSlow() {
        super(MODULE, DISPLAY, Category.Movement);
        this.add(Setting.bool("only_ground", false));
        this.add(Setting.bool("only_crossbow", false));
    }

    @Override
    public void onEnable() {
        Client.registerNoSlow(this);
    }

    @Override
    public void onDisable() {
        Client.registerNoSlow(null);
    }
}

