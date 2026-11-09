/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.mc.Client;

public final class ClickGui
extends Feature {
    public static final String MODULE = "clickgui";
    public static final String DISPLAY = "\u0421\u043b\u0438\u0441\u043a\u0413\u0443\u0438";
    public static final int VTABLE_RVA = 12265808;
    private static ClickGui instance;
    private boolean requested;

    public ClickGui() {
        super(MODULE, DISPLAY, Category.Client);
        instance = this;
    }

    public static ClickGui instance() {
        return instance;
    }

    public boolean requested() {
        return this.requested;
    }

    @Override
    public void setEnabled(boolean value) {
        if (value && Client.enableGateOpen() && !Client.shuttingDown()) {
            this.requested = true;
        }
    }
}

