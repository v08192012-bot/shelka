/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;

public final class RPSpoofer
extends Feature {
    public static final String MODULE = "rpspoofer";
    public static final String DISPLAY = "\u0420\u041f\u0417\u043f\u043e\u043e\u0444\u0435\u0440";
    public static final int VTABLE_RVA = 12322760;
    private static RPSpoofer instance;

    public RPSpoofer() {
        super(MODULE, DISPLAY, Category.Client);
    }

    public static RPSpoofer instance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
        instance = null;
    }
}

