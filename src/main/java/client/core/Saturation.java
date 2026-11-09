/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class Saturation
extends Feature {
    public static final String MODULE = "saturation";
    public static final String DISPLAY = "\u0417\u0430\u0442\u0443\u0440\u0430\u0442\u0438\u043e\u043d";
    public static final int VTABLE_RVA = 12579600;
    public static final long RVA_ON_ENABLE = 2735200727104L;
    public static final long RVA_ON_DISABLE = 2735200727120L;
    public static final long RVA_APPLY_PASS = 2735201590256L;
    public static final long RVA_PASS_READY = 2735201480912L;
    public static final long RVA_PASS_BEGIN = 2735201506240L;
    public static final long RVA_PASS_TARGET_VALID = 2735201473968L;
    public static final long RVA_PASS_BIND = 2735201511328L;
    public static final long RVA_PASS_UNBIND = 2735201511264L;
    public static final long RVA_PASS_DRAW = 2735201464528L;
    public static final long RVA_PASS_SET_VALUE = 2735201508560L;
    public static final long RVA_PASS_END = 2735201510464L;
    public static final long RVA_PASS_RELEASE = 2735201463936L;
    private static final float NEUTRAL_AMOUNT = 1.0f;
    private static final float CHANGE_EPSILON = 0.001f;
    private static Saturation active;
    private double appliedAmount = 1.0;

    public Saturation() {
        super(MODULE, DISPLAY, Category.Render);
        this.add(Setting.number(MODULE, 1.0, 0.0, 2.0, 0.05));
        this.add(Setting.bool("world_only", false));
    }

    public static Saturation active() {
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

    public boolean worldOnly() {
        Setting setting = this.setting("world_only");
        return setting != null && setting.getBoolean();
    }

    public double amount() {
        Setting setting = this.setting(MODULE);
        return setting == null ? 1.0 : setting.getNumber();
    }

    public boolean appliesTo(boolean worldPass) {
        return this.enabled && Client.streamCaptureActive() && worldPass == this.worldOnly();
    }

    public double appliedAmount() {
        return this.appliedAmount;
    }

    public static void applyPass(boolean companionActive, int width, int height, boolean worldPass, int flags) {
        Saturation saturation = null;
        Saturation candidate = active;
        if (candidate != null && candidate.appliesTo(worldPass)) {
            saturation = candidate;
        }
        if (companionActive || saturation != null) {
            if (!Client.postProcessReady()) {
                return;
            }
            Client.beginPostProcess(width, height, flags);
            if (saturation != null) {
                double amount = saturation.amount();
                if (Math.abs((float)amount - 1.0f) > 0.001f && Client.postProcessTargetValid()) {
                    Client.bindPostProcessTarget();
                    Client.unbindPostProcessTarget();
                    Client.drawPostProcessQuad();
                    Client.setPostProcessValue((float)amount);
                    Client.endPostProcess();
                }
                saturation.appliedAmount = amount;
            }
            Client.releasePostProcess();
        }
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }
}

