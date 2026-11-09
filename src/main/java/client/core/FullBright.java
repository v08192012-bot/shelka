/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.BlockPos;
import client.mc.Client;

public final class FullBright
extends Feature {
    public static final String MODULE = "full_bright";
    public static final String DISPLAY = "\u0424\u0443\u043b\u043b\u0411\u0440\u0438\u0433\u0445\u0442";
    public static final int VTABLE_RVA = 12575008;
    private static final double GAMMA_DEFAULT = 0.5;
    private static final double GAMMA_RANGE = 15.0;
    private static final double GAMMA_EPSILON = 1.0E-4;
    private static final double EASE_BASE = 0.5;
    private static final double EASE_TAU_MS = 120.0;
    private static final double EASE_TAU_LATE_MS = 180.0;
    private static final double NANOS_PER_MILLI = 1000000.0;
    private double gamma = 0.5;
    private double easeStart = 15.0;
    private boolean applied;
    private long lastFrameTime;
    private boolean easeStarted;
    private boolean hasTarget;
    private double targetGamma;
    private boolean optionBound;
    private Object optionHandle;

    public FullBright() {
        super(MODULE, DISPLAY, Category.Render);
        this.add(Setting.bool("mode", true));
        this.add(Setting.bool("dynamic", false));
        this.add(Setting.number("min_gamma", 0.0, 0.0, 15.0));
        this.add(Setting.number("gamma", 1.0, 0.0, 15.0));
    }

    @Override
    public void onEnable() {
        this.gamma = 0.5;
        this.easeStart = 15.0;
        this.applied = false;
        this.lastFrameTime = 0L;
        this.easeStarted = false;
        this.hasTarget = false;
        if (!this.mode()) {
            return;
        }
        if (!this.optionBound) {
            this.optionHandle = Client.gammaOption();
            this.optionBound = true;
        }
        this.gamma = this.step();
        this.apply();
    }

    @Override
    public void onDisable() {
        Object player;
        if (this.applied && Client.inGame() && (player = Client.playerHandle()) != null) {
            Client.setGammaOption(player, Client.gameGamma());
        }
        this.applied = false;
        if (this.optionBound) {
            Client.releaseOption(this.optionHandle);
            this.optionBound = false;
            this.optionHandle = null;
        }
        this.lastFrameTime = 0L;
        this.gamma = 0.5;
        this.easeStart = 15.0;
        this.easeStarted = false;
        this.hasTarget = false;
    }

    @Override
    public void onTick() {
        if (!Client.inGame()) {
            return;
        }
        Object player = Client.playerHandle();
        if (!this.mode()) {
            double frameTime = Client.frameTime();
            if (!this.applied && Client.hasNewFrameTime(player, frameTime)) {
                return;
            }
            Client.setFrameTime(player, frameTime);
            this.applied = true;
            return;
        }
        if (this.dynamic()) {
            BlockPos pos = Client.blockPosition(player);
            int x = 0;
            int y = 0;
            int z = 0;
            if (pos != null) {
                x = pos.x();
                y = pos.y();
                z = pos.z();
            }
            this.hasTarget = true;
            this.targetGamma = Client.biomeGamma(x, y, z);
        }
        if (!this.applied) {
            return;
        }
        double frameTime = Client.frameTime();
        if (player != null && frameTime != 0.0) {
            Client.applyGammaForFrame(player, this.optionHandle, frameTime);
            Client.checkPendingException();
        }
        this.applied = false;
    }

    private double step() {
        double eased;
        double value = this.gammaValue();
        if (!this.dynamic()) {
            return value;
        }
        double limit = Math.min(value, this.minGamma());
        if (!this.hasTarget) {
            return this.easeStart;
        }
        long now = Client.nanoTime();
        double delta = 0.0;
        if (this.lastFrameTime != 0L) {
            delta = (double)(now - this.lastFrameTime) / 1000000.0;
        }
        this.lastFrameTime = now;
        double previous = this.easeStart;
        if (!this.easeStarted) {
            this.easeStart = this.targetGamma;
            this.easeStarted = true;
            double normalized = this.targetGamma / 15.0;
            double factor = 1.0 - normalized;
            return factor * (value - limit) * factor + limit;
        }
        this.easeStart = eased = (1.0 - Math.pow(0.5, delta / 120.0)) * (this.targetGamma - previous) + previous;
        double normalized = 1.0 - eased / 15.0;
        double weight = Math.pow(0.5, delta / 180.0);
        return (1.0 - weight) * (normalized * (value - limit) * normalized + limit - this.gamma) + this.gamma;
    }

    private void apply() {
        double current = Client.gameGamma();
        if (Math.abs(current - this.gamma) > 1.0E-4) {
            Client.applyGamma(this.gamma);
        }
    }

    private boolean mode() {
        Setting setting = this.setting("mode");
        return setting == null || setting.getBoolean();
    }

    private boolean dynamic() {
        Setting setting = this.setting("dynamic");
        return setting != null && setting.getBoolean();
    }

    private double minGamma() {
        Setting setting = this.setting("min_gamma");
        return setting == null ? 0.0 : setting.getNumber();
    }

    private double gammaValue() {
        Setting setting = this.setting("gamma");
        return setting == null ? 1.0 : setting.getNumber();
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }
}

