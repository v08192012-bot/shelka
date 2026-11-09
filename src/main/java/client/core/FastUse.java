/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class FastUse
extends Feature {
    public static final String MODULE = "fastuse";
    public static final String DISPLAY = "\u0424\u0430\u0437\u0442\u0423\u0437\u0435";
    public static final int VTABLE_RVA = 12314384;
    public static final long RVA_TICK = 2735200287408L;
    public static final long RVA_BIND_PREDICATE = 2735200292400L;
    public static final long RVA_RIGHT_CLICK_DELAY_READ = 2735202115728L;
    public static final long RVA_RIGHT_CLICK_DELAY_WRITE = 2735202116176L;
    private static final int EXPERIENCE_BOTTLE_ID = 5;
    private static final double DEFAULT_DELAY = 0.0;
    private static final double MIN_DELAY = 0.0;
    private static final double MAX_DELAY = 4.0;
    private static final double DELAY_STEP = 1.0;

    public FastUse() {
        super(MODULE, DISPLAY, Category.Movement);
        this.add(Setting.number("delay", 0.0, 0.0, 4.0, 1.0));
        this.add(Setting.bool("only_experience", false));
    }

    @Override
    public void onTick() {
        if (!Client.inGame()) {
            return;
        }
        if (this.onlyExperience() && Client.mainHandItemId() != 5) {
            return;
        }
        int delay = (int)this.delay();
        if (Client.itemUseCooldown() <= delay) {
            return;
        }
        Client.setItemUseCooldown(delay);
    }

    private double delay() {
        Setting setting = this.setting("delay");
        return setting == null ? 0.0 : setting.getNumber();
    }

    private boolean onlyExperience() {
        Setting setting = this.setting("only_experience");
        return setting != null && setting.getBoolean();
    }

    private Setting setting(String name) {
        for (Setting candidate : this.getSettings()) {
            if (!candidate.getName().equals(name)) continue;
            return candidate;
        }
        return null;
    }
}

