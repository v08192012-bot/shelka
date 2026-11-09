/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.mc.Client;

public final class Panic
extends Feature {
    public static final String MODULE = "panic";
    public static final String DISPLAY = "\u041f\u0430\u043d\u0438\u0441";
    public static final int VTABLE_RVA = 12266512;

    public Panic() {
        super(MODULE, DISPLAY, Category.Client);
    }

    @Override
    public void setEnabled(boolean value) {
        if (value && !Client.panicRequested()) {
            Client.requestPanic();
        }
    }
}

