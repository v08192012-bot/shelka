/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import client.mc.Entity;
import java.util.ArrayList;
import java.util.List;

public final class PulseTag
extends Feature {
    public static final String MODULE = "pulse_tag";
    public static final int VTABLE_RVA = 12265440;
    private static final int REFRESH_INTERVAL = 40;
    private static final int NOTIFY_STYLE_DEFAULT = 96;
    private static final int NOTIFY_STYLE_ALTERNATE = 144;
    private static final int NOTIFY_STYLE_SWITCH = 1;
    private static final List<String> TAGS = new ArrayList<String>();
    private static boolean active;
    private static int notifyStyleDefault;
    private static int notifyStyleAlternate;
    private static int notifyCounter;
    private int tickCounter;
    private int taggedCount = -1;
    private String session = "";

    public PulseTag() {
        super(MODULE, "", Category.Client);
        this.add(Setting.bool("login", true));
        this.add(Setting.bool("logout", true));
    }

    @Override
    public boolean isVisible() {
        return !TAGS.isEmpty();
    }

    @Override
    public void onEnable() {
        active = true;
        this.tickCounter = 40;
        this.taggedCount = -1;
        this.session = "";
    }

    @Override
    public void onDisable() {
        active = false;
        this.taggedCount = -1;
        notifyCounter = 0;
        TAGS.clear();
    }

    @Override
    public void onTick() {
        ++this.tickCounter;
        if (this.tickCounter <= 39) {
            return;
        }
        this.tickCounter = 0;
        String current = Client.currentUsername();
        if (!current.equals(this.session)) {
            this.session = current;
        }
        this.collectTagged();
        if (TAGS.size() != this.taggedCount) {
            this.taggedCount = TAGS.size();
        }
    }

    @Override
    public void onRender() {
        if (TAGS.isEmpty()) {
            return;
        }
        ++notifyCounter;
        for (Entity entity : Client.entities()) {
            String name = Client.playerName(entity);
            int style = TAGS.size() > 1 ? 144 : 96;
            if ((style == 144 ? notifyStyleAlternate : notifyStyleDefault) == 0) continue;
            Client.notifyPulseTag(name);
        }
        if (--notifyCounter == 0) {
            Client.flushPulseTag();
        }
        TAGS.clear();
    }

    public static void requestLogin(String name) {
        if (name == null) {
            return;
        }
        TAGS.add(name);
    }

    public static void requestLogout(String name) {
        if (name == null) {
            return;
        }
        TAGS.remove(name);
    }

    public int taggedCount() {
        return this.taggedCount;
    }

    private void collectTagged() {
        TAGS.clear();
        Client.forEachPlayer(player -> {
            if (Client.isTaggedPlayer(player)) {
                TAGS.add(Client.playerName(player));
            }
        });
    }

    static {
        notifyStyleDefault = 1;
        notifyStyleAlternate = 1;
    }
}

