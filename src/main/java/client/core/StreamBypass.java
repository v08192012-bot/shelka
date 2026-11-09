/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class StreamBypass
extends Feature {
    public static final String MODULE = "stream_bypass";
    public static final String DISPLAY = "\u0417\u0442\u0440\u0435\u0430\u043c\u0411\u0439\u043f\u0430\u0437\u0437";
    public static final int VTABLE_RVA = 12269048;
    public static final long RVA_MASK = 2735200005888L;
    public static final long RVA_DISABLE = 2735200006064L;
    public static final long RVA_TOOLTIP = 2735200005856L;
    public static final long RVA_ON_ENABLE = 2735200004288L;
    public static final long RVA_ON_DISABLE = 2735200004304L;
    public static final int MASK_WORLD_PLATES = 1;
    public static final int MASK_HUD = 2;
    public static final int MASK_OVERLAYS = 4;
    public static final int MASK_GUI = 8;
    public static final String TOOLTIP = "\u0421\u043a\u0440\u044b\u0442\u043e\u0435 \u0440\u0438\u0441\u0443\u0435\u0442\u0441\u044f \u043f\u043e\u0432\u0435\u0440\u0445 \u044d\u043a\u0440\u0430\u043d\u043e\u0432 \u0438\u0433\u0440\u044b (\u043a\u0440\u043e\u043c\u0435 \u0447\u0430\u0442\u0430), \u0430 \u044d\u0444\u0444\u0435\u043a\u0442\u044b \u043a\u0430\u0434\u0440\u0430 \u2014 \u0431\u043b\u0443\u043c, \u043f\u043e\u0433\u043e\u0434\u0430, \u0441\u0432\u0435\u0447\u0435\u043d\u0438\u0435 \u2014 \u043d\u0430 \u0437\u0430\u043f\u0438\u0441\u0438 \u043e\u0441\u0442\u0430\u044e\u0442\u0441\u044f";
    public static final int TOOLTIP_LENGTH = 204;
    private static StreamBypass active;

    public StreamBypass() {
        super(MODULE, DISPLAY, Category.Client);
        this.add(Setting.bool("hud", true));
        this.add(Setting.bool("gui", true));
        this.add(Setting.bool("overlays", true));
        this.add(Setting.bool("world_plates", true));
    }

    public static StreamBypass active() {
        return active;
    }

    @Override
    public void onEnable() {
        active = this;
    }

    @Override
    public void onDisable() {
        active = null;
    }

    @Override
    public void setEnabled(boolean value) {
        if (!value && this.enabled && Client.streamExclusionOverlayActive()) {
            this.enabled = false;
            Client.teardownStreamExclusion(this);
            this.onDisable();
            Client.notifyModuleToggled(this);
            return;
        }
        super.setEnabled(value);
    }

    public boolean hud() {
        Setting setting = this.setting("hud");
        return setting == null || setting.getBoolean();
    }

    public boolean gui() {
        Setting setting = this.setting("gui");
        return setting == null || setting.getBoolean();
    }

    public boolean overlays() {
        Setting setting = this.setting("overlays");
        return setting == null || setting.getBoolean();
    }

    public boolean worldPlates() {
        Setting setting = this.setting("world_plates");
        return setting == null || setting.getBoolean();
    }

    public static int currentMask() {
        StreamBypass module = active;
        if (module == null || !module.enabled) {
            return 0;
        }
        if (!Client.streamCaptureActive()) {
            return 0;
        }
        int mask = 0;
        if (module.worldPlates()) {
            mask |= 1;
        }
        if (module.overlays()) {
            mask |= 4;
        }
        if (module.gui()) {
            mask |= 8;
        }
        if (module.hud()) {
            mask |= 2;
        }
        return mask;
    }

    public String tooltip() {
        return TOOLTIP;
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }
}

