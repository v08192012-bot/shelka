/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class SafeMode
extends Feature {
    public static final String MODULE = "safe_mode";
    public static final String DISPLAY = "\u0417\u0430\u0444\u0435\u041c\u043e\u0434\u0435";
    public static final int VTABLE_RVA = 12811704;
    public static final String STATUS_START = "\u0421\u0442\u0430\u0440\u0442";
    public static final String STATUS_STOP = "\u041e\u0441\u0442\u0430\u043d\u043e\u0432\u0438\u0442\u044c";
    private boolean startApplied;
    private boolean stopApplied;

    public SafeMode() {
        super(MODULE, DISPLAY, Category.Client);
        this.add(Setting.bool("start", false));
        this.add(Setting.bool("stop", false));
    }

    @Override
    public void onEnable() {
        this.startApplied = false;
        this.stopApplied = false;
    }

    @Override
    public void onDisable() {
        Client.safeModeShutdown();
        Client.removeLogFilter();
    }

    @Override
    public void onTick() {
        if (Client.toggleGateOpen()) {
            boolean start = this.flag("start");
            boolean stop = this.flag("stop");
            if (start && !this.startApplied) {
                Client.safeModeStart();
            }
            if (stop && !this.stopApplied) {
                Client.safeModeStop();
            }
            this.startApplied = start;
            this.stopApplied = stop;
        }
    }

    public boolean stopping() {
        return this.stopApplied;
    }

    private boolean flag(String name) {
        Setting s = this.setting(name);
        return s != null && s.getBoolean();
    }

    private Setting setting(String name) {
        for (Setting s : this.getSettings()) {
            if (!s.getName().equals(name)) continue;
            return s;
        }
        return null;
    }
}

