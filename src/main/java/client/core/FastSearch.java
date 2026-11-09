/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class FastSearch
extends Feature {
    public static final String MODULE = "fastsearch";
    public static final String DISPLAY = "\u0424\u0430\u0437\u0442\u0417\u0435\u0430\u0440\u0441\u0445";
    public static final int VTABLE_RVA = 12313864;
    public static final long RVA_CONSTRUCT = 2735200281568L;
    public static final long RVA_ON_TICK = 2735200283376L;
    public static final long RVA_ON_ENABLE = 2735200281552L;
    private static final String DEFAULT_TEMPLATE = "ah search {name}";
    private static final String NAME_PLACEHOLDER = "{name}";
    private static final int BIND_MODE = 0;
    private boolean triggerHeld;

    public FastSearch() {
        super(MODULE, DISPLAY, Category.Player);
        this.add(Setting.input("template", DEFAULT_TEMPLATE));
        this.add(Setting.bool("off_hand", false));
        this.add(Setting.bool("strip_brackets", true));
        this.add(Setting.key("trigger", 0));
    }

    @Override
    public void onEnable() {
        this.triggerHeld = false;
    }

    @Override
    public void onTick() {
        Setting trigger = this.setting("trigger");
        if (trigger == null) {
            return;
        }
        if (!this.consumeTrigger(trigger.getKey())) {
            return;
        }
        if (Client.isScreenOpen() || !Client.inGame()) {
            return;
        }
        String name = Client.heldItemName(this.offHand(), this.stripBrackets());
        if (name.isEmpty()) {
            return;
        }
        String template = this.template();
        int at = template.indexOf(NAME_PLACEHOLDER);
        Object command = at < 0 ? template + " " + name : template.substring(0, at) + name + template.substring(at + NAME_PLACEHOLDER.length());
        while (((String)command).length() > 0 && ((String)command).charAt(0) == '/') {
            command = ((String)command).substring(1);
        }
        Client.sendChatCommand((String)command);
    }

    private String template() {
        Setting setting = this.setting("template");
        return setting == null ? DEFAULT_TEMPLATE : setting.getText();
    }

    private boolean offHand() {
        Setting setting = this.setting("off_hand");
        return setting != null && setting.getBoolean();
    }

    private boolean stripBrackets() {
        Setting setting = this.setting("strip_brackets");
        return setting != null && setting.getBoolean();
    }

    private boolean consumeTrigger(int key) {
        boolean down = key >= 1 && key <= 255 && Client.isBindDown(key, 0);
        boolean fired = down && !this.triggerHeld;
        this.triggerHeld = down;
        return fired;
    }

    private Setting setting(String name) {
        for (Setting candidate : this.getSettings()) {
            if (!candidate.getName().equals(name)) continue;
            return candidate;
        }
        return null;
    }
}

