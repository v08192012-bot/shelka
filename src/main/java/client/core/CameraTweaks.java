/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class CameraTweaks
extends Feature {
    public static final String MODULE = "camera_tweaks";
    public static final String DISPLAY = "\u0421\u0430\u043c\u0435\u0440\u0430\u0422\u0448\u0435\u0430\u043a\u0437";
    public static final int VTABLE_RVA = 12571304;
    private static final double NANOS_PER_MILLI = 1000000.0;
    private float currentDistance;
    private float lastTarget;
    private long lastChangeTime = -1L;
    private long animationNanos;

    public CameraTweaks() {
        super(MODULE, DISPLAY, Category.Render);
        this.add(Setting.number("distance", 4.0, 0.0, 20.0));
        this.add(Setting.bool("clip_through", false));
        this.add(Setting.number("animation_ms", 0.0, 0.0, 2000.0));
    }

    @Override
    public void onEnable() {
        this.currentDistance = 0.0f;
        this.lastTarget = 0.0f;
        this.lastChangeTime = -1L;
        this.animationNanos = 0L;
    }

    @Override
    public void onDisable() {
        this.lastChangeTime = -1L;
        this.currentDistance = 0.0f;
        this.lastTarget = 0.0f;
        this.animationNanos = 0L;
    }

    @Override
    public void onTick() {
        float target;
        float f = target = Client.isThirdPerson() ? (float)this.distance() : 0.0f;
        if (target == this.lastTarget) {
            return;
        }
        this.currentDistance = this.animateDistance();
        this.lastTarget = target;
        Client.setCameraDistance(target, this.clipThrough());
        this.lastChangeTime = Client.nanoTime();
        this.animationNanos = (long)(this.animationMs() * 1000000.0);
    }

    private float animateDistance() {
        if (this.lastChangeTime == -1L || this.animationNanos <= 0L) {
            return this.lastTarget;
        }
        long elapsed = Client.nanoTime() - this.lastChangeTime;
        if (elapsed >= this.animationNanos) {
            return this.lastTarget;
        }
        float progress = (float)elapsed / (float)this.animationNanos;
        return this.currentDistance + (this.lastTarget - this.currentDistance) * progress;
    }

    private double distance() {
        Setting setting = this.setting("distance");
        return setting == null ? 4.0 : setting.getNumber();
    }

    private boolean clipThrough() {
        Setting setting = this.setting("clip_through");
        return setting != null && setting.getBoolean();
    }

    private double animationMs() {
        Setting setting = this.setting("animation_ms");
        return setting == null ? 0.0 : setting.getNumber();
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }
}

