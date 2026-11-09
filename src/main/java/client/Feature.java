/*
 * Decompiled with CFR 0.152.
 */
package client;

import client.Category;
import client.Setting;
import client.mc.Entity;
import java.util.ArrayList;
import java.util.List;

public class Feature {
    public static final int ENABLED_OFFSET = 116;
    private final String name;
    private final String displayName;
    private final Category category;
    private final List<Setting> settings = new ArrayList<Setting>();
    protected boolean enabled;

    public Feature(String name, String displayName, Category category) {
        this.name = name;
        this.displayName = displayName;
        this.category = category;
    }

    public String getName() {
        return this.name;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public Category getCategory() {
        return this.category;
    }

    public List<Setting> getSettings() {
        return this.settings;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isVisible() {
        return true;
    }

    public boolean isBindable() {
        return true;
    }

    public void setEnabled(boolean value) {
        if (this.enabled == value) {
            return;
        }
        this.enabled = value;
        if (!value) {
            this.onSettingsVisibilityChanged(false);
            this.onDisable();
        } else {
            this.onSettingsVisibilityChanged(true);
            this.onEnable();
        }
    }

    public void toggle() {
        this.setEnabled(!this.enabled);
    }

    protected void onEnable() {
    }

    protected void onDisable() {
    }

    protected void onSettingsVisibilityChanged(boolean visible) {
    }

    public void onTick() {
    }

    public void onRender() {
    }

    public void onKey(int key, boolean pressed) {
    }

    public void onEntityHit(Entity entity) {
    }

    protected Setting add(Setting setting) {
        this.settings.add(setting);
        return setting;
    }
}

