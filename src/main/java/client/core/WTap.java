/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import client.mc.Entity;

public final class WTap
extends Feature {
    public static final String MODULE = "wtap";
    public static final int VTABLE_RVA = 12285064;
    public static final int TRIGGER_RVA = 435216;
    public static final int TICK_RVA = 435536;
    public static final int ARM_RVA = 435040;
    public static final int RESTORE_RVA = 435008;
    public static final int ACTION_RVA = 436256;
    public static final int RANDOM_DELAY_RVA = 6396784;
    private static final int TAP_TICKS = 2;
    private static final long NANOS_PER_MILLI = 1000000L;
    private static final float ATTACK_LOOKAHEAD = 1.5f;
    private static final float ATTACK_READY_THRESHOLD = 0.9f;
    private boolean tapRequested;
    private boolean tapPending;
    private boolean forwardSeen;
    private Entity savedTarget;
    private long tapTimestamp;
    private long tapDelay;
    private int countdown;

    public WTap() {
        super(MODULE, "\u0428\u0422\u0430\u043f", Category.Combat);
        this.add(Setting.number("delay_min", 50.0, 0.0, 500.0));
        this.add(Setting.number("delay_max", 150.0, 0.0, 500.0));
        this.add(Setting.bool("in_air", false));
        this.add(Setting.bool("lunge", true));
    }

    @Override
    public void onDisable() {
        this.applyWTap();
        this.forwardSeen = false;
    }

    private void applyWTap() {
        if ((this.tapPending || this.countdown > 0) && Client.airStuckCounter() < 1) {
            Client.setAttackKey(Client.keyState().attack());
        }
        this.tapRequested = false;
        this.tapPending = false;
        this.countdown = 0;
        this.savedTarget = null;
    }

    @Override
    public void onTick() {
        this.tickTrigger();
        this.tickState();
        this.tickArm();
    }

    private void tickState() {
        Entity self;
        Entity raw;
        if (this.countdown > 0) {
            --this.countdown;
            if (this.countdown == 0) {
                raw = Client.player();
                if (raw != null) {
                    Entity crosshair;
                    self = Client.resolvePlayer(raw);
                    Entity saved = this.savedTarget;
                    if (self != null && saved != null && (crosshair = Client.crosshairEntity()) != null && Client.sameEntity(crosshair, saved)) {
                        Client.resetAttackStrengthTicker(self, saved);
                    }
                }
                this.savedTarget = null;
                if (Client.airStuckCounter() < 1 && !Client.keyState().attack()) {
                    Client.setAttackKey(false);
                }
            }
        }
        if (!(this.tapRequested || this.tapPending || this.forwardSeen)) {
            return;
        }
        if (!Client.keyState().attack()) {
            this.tapRequested = false;
            this.tapPending = false;
            return;
        }
        raw = Client.player();
        self = raw == null ? null : Client.resolvePlayer(raw);
        boolean inAir = this.inAir();
        if (!inAir && !Client.isOnGround(self)) {
            return;
        }
        if (Client.isOnGround(self)) {
            this.forwardSeen = false;
        }
        if (!inAir && Client.keyState().forward()) {
            if (this.tapRequested || this.tapPending) {
                this.applyWTap();
            }
        } else if (this.tapRequested) {
            double delayMin = this.delayMin();
            double delayMax = this.delayMax();
            Client.setAttackKey(false);
            this.tapTimestamp = Client.nanoTime();
            double low = Math.min(delayMin, delayMax);
            double high = Math.max(delayMin, delayMax);
            double delay = Client.randomDelay(low, high) * 1000000.0;
            this.tapRequested = false;
            this.tapPending = true;
            this.tapDelay = (long)delay;
            return;
        }
        if (!this.tapPending) {
            return;
        }
        if (Client.nanoTime() - this.tapTimestamp < this.tapDelay) {
            return;
        }
        this.applyWTap();
    }

    private void tickTrigger() {
        if (!this.lunge()) {
            return;
        }
        if (this.countdown >= 1) {
            return;
        }
        if (this.tapRequested || this.tapPending) {
            return;
        }
        if (Client.airStuckCounter() >= 1) {
            return;
        }
        Entity self = Client.localPlayer();
        if (self == null) {
            return;
        }
        if (!Client.isOnGround(self)) {
            return;
        }
        if (Client.isSprinting(self)) {
            return;
        }
        if (Client.hasCrosshairEntity()) {
            return;
        }
        Client.KeyState keys = Client.keyState();
        if (keys.attack() || keys.back() || keys.left() || keys.right() || keys.jump()) {
            return;
        }
        Entity crosshair = Client.crosshairEntity();
        if (crosshair == null) {
            return;
        }
        if (Client.attackCooldown(self, 1.5f) <= (double)0.9f) {
            return;
        }
        if (!Client.consumeAttackClick()) {
            return;
        }
        Client.setAttackKey(true);
        Client.setSprinting(self, true);
        this.savedTarget = crosshair;
        this.countdown = 2;
    }

    private void tickArm() {
        Entity raw = Client.player();
        if (raw == null) {
            return;
        }
        Entity self = Client.resolvePlayer(raw);
        if (self == null) {
            return;
        }
        if (!this.inAir()) {
            if (Client.keyState().forward()) {
                this.forwardSeen = true;
            }
            if (!Client.isOnGround(self)) {
                return;
            }
        }
        if (!this.forwardSeen && !Client.isForwardKeyDown() && Client.isSprinting(self)) {
            this.tapRequested = true;
        }
    }

    private boolean inAir() {
        Setting s = this.setting("in_air");
        return s != null && s.getBoolean();
    }

    private boolean lunge() {
        Setting s = this.setting("lunge");
        return s == null || s.getBoolean();
    }

    private double delayMin() {
        Setting s = this.setting("delay_min");
        return s == null ? 50.0 : s.getNumber();
    }

    private double delayMax() {
        Setting s = this.setting("delay_max");
        return s == null ? 150.0 : s.getNumber();
    }

    private Setting setting(String name) {
        for (Setting s : this.getSettings()) {
            if (!s.getName().equals(name)) continue;
            return s;
        }
        return null;
    }
}

