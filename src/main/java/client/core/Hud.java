/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class Hud
extends Feature {
    public static final String MODULE = "hud";
    public static final String DISPLAY = "\u0425\u0443\u0434";
    public static final int VTABLE_RVA = 12807648;
    public static final long RVA_CONSTRUCT = 2735203076880L;
    public static final long RVA_RESET_CALLBACK = 2735203081216L;
    public static final String[] ELEMENTS = new String[]{"watermark", "keybinds", "staff", "potions", "armor", "targethud", "cooldowns", "usetracker", "swapbinds", "notifications", "coords", "waypoints", "saturation", "inventory"};
    public static final String[] ELEMENT_LABELS = new String[]{"\u0412\u0430\u0442\u0435\u0440\u043c\u0430\u0440\u043a\u0430", "\u041a\u0435\u0439\u0431\u0438\u043d\u0434\u044b", "\u0421\u043f\u0438\u0441\u043e\u043a \u0441\u0442\u0430\u0444\u0430", "\u042d\u0444\u0444\u0435\u043a\u0442\u044b \u0437\u0435\u043b\u0438\u0439", "\u0411\u0440\u043e\u043d\u044f", "\u0422\u0430\u0440\u0433\u0435\u0442\u0425\u0443\u0434", "\u041a\u0443\u043b\u0434\u0430\u0443\u043d\u044b", "\u041a\u0443\u043b\u0434\u0430\u0443\u043d\u044b \u0446\u0435\u043b\u0438", "\u0421\u0432\u0430\u043f \u0431\u0438\u043d\u0434\u044b", "\u0423\u0432\u0435\u0434\u043e\u043c\u043b\u0435\u043d\u0438\u044f", "\u041a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u044b", "\u0412\u0435\u0439\u043f\u043e\u0438\u043d\u0442\u044b", "\u041d\u0430\u0441\u044b\u0449\u0435\u043d\u0438\u0435", "\u0418\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044c"};
    private static Hud active;

    public Hud() {
        super(MODULE, DISPLAY, Category.Client);
        this.add(Setting.multi("elements", ELEMENTS));
        this.add(Setting.bool("reset_positions", false));
        for (int i = 0; i < ELEMENTS.length; ++i) {
            Setting elements;
            if (ELEMENTS[i].equals("inventory") || (elements = this.setting("elements")) == null) continue;
            elements.setSelected(ELEMENTS[i], true);
        }
        this.setEnabled(true);
        active = this;
    }

    public static Hud active() {
        return active;
    }

    public boolean isElementEnabled(String key) {
        Setting elements = this.setting("elements");
        return elements != null && elements.isSelected(key);
    }

    public void resetPositions() {
        for (String element : ELEMENTS) {
            Client.resetHudElementPosition(element);
        }
    }

    private Setting setting(String name) {
        for (Setting candidate : this.getSettings()) {
            if (!candidate.getName().equals(name)) continue;
            return candidate;
        }
        return null;
    }
}

