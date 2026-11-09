/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class Zoom
extends Feature {
    public static final String MODULE = "zoom";
    public static final String DISPLAY = "Z\u043e\u043e\u043c";
    public static final int VTABLE_RVA = 12582424;
    private boolean zooming;
    private double currentFov;

    public Zoom() {
        super(MODULE, DISPLAY, Category.Render);
        this.add(Setting.key("zoom_key", 0));
        this.add(Setting.number("zoom_fov", 30.0, 1.0, 110.0));
        this.add(Setting.number("speed", 1.0, 0.1, 10.0));
        this.add(Setting.bool("scroll_control", false));
        this.add(Setting.number("scroll_step", 5.0, 1.0, 30.0));
    }

    @Override
    public void onEnable() {
        this.zooming = false;
        this.currentFov = 0.0;
    }

    @Override
    public void onDisable() {
        this.zooming = false;
        this.currentFov = 0.0;
    }

    @Override
    public void onTick() {
        if (!Client.inGame()) {
            return;
        }
        if (Client.isPaused()) {
            return;
        }
        boolean pressed = Client.isKeyDown(this.zoomKey());
        if (pressed != this.zooming) {
            this.zooming = pressed;
            this.currentFov = this.zooming ? this.zoomFov() : 0.0;
        }
    }

    private int zoomKey() {
        Setting setting = this.setting("zoom_key");
        return setting == null ? 0 : setting.getKey();
    }

    private double zoomFov() {
        Setting setting = this.setting("zoom_fov");
        return setting == null ? 30.0 : setting.getNumber();
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }
}

