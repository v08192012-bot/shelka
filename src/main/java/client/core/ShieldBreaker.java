/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import client.mc.Entity;

public final class ShieldBreaker
extends Feature {
    public static final String MODULE = "shieldbreaker";
    public static final int VTABLE_RVA = 12280944;
    private static final double NANOS_PER_MILLI = 1000000.0;
    private static final long MAX_HOLD_NANOS = 100000000L;
    private static final int NO_TARGET = -1;
    private int targetId = -1;
    private long startTime;
    private boolean active;
    private Entity target;

    public ShieldBreaker() {
        super(MODULE, "", Category.Combat);
        this.add(Setting.number("hold_time", 1000.0, 0.0, 5000.0));
        this.add(Setting.number("range", 3.0, 1.0, 6.0));
    }

    @Override
    public void onDisable() {
        this.releaseAndReset();
    }

    @Override
    public void onTick() {
        this.process();
        this.tryStart();
    }

    private void process() {
        if (!this.active) {
            return;
        }
        if (Client.inGame()) {
            boolean holding;
            int other;
            if (this.targetId == -1) {
                return;
            }
            int current = Client.crosshairEntityId();
            if (current != (other = Client.blockingEntityId()) && current != this.targetId) {
                this.reset();
                return;
            }
            long elapsed = Client.nanoTime() - this.startTime;
            long holdNanos = (long)(this.holdTime() * 1000000.0);
            boolean bl = holding = Client.isBlocking(this.target) && Client.isTargetBlocking(this.target);
            if (holding) {
                if (elapsed < holdNanos) {
                    return;
                }
            } else {
                if (holdNanos <= elapsed) {
                    this.releaseAndReset();
                    return;
                }
                if (elapsed < 100000000L) {
                    return;
                }
            }
        }
        this.releaseAndReset();
    }

    private void tryStart() {
        if (this.active) {
            return;
        }
        if (!Client.inGame()) {
            return;
        }
        if (!Client.isSneaking()) {
            return;
        }
        Entity candidate = Client.crosshairTarget();
        boolean allowed = this.canBreak(candidate);
        if (!allowed || candidate == null) {
            return;
        }
        this.startBreaking(candidate);
    }

    private boolean canBreak(Entity candidate) {
        double dz;
        double dy;
        if (candidate == null) {
            return false;
        }
        if (!Client.isAttackable(candidate)) {
            return false;
        }
        if (!Client.isBlocking(candidate)) {
            return false;
        }
        if (!Client.isHoldingShield(candidate)) {
            return false;
        }
        double range = this.range();
        double[] targetPosition = Client.entityPosition(candidate);
        double[] selfPosition = Client.entityPosition(Client.player());
        double dx = selfPosition[0] - targetPosition[0];
        if (dx * dx + (dy = selfPosition[1] - targetPosition[1]) * dy + (dz = selfPosition[2] - targetPosition[2]) * dz <= range * range) {
            return Client.isTargetBlocking(candidate);
        }
        return false;
    }

    private void startBreaking(Entity candidate) {
        int id = Client.blockingEntityId();
        if (id == -1) {
            return;
        }
        if (this.targetId == -1) {
            this.targetId = Client.crosshairEntityId();
        }
        Client.releaseAttack(id);
        this.active = true;
        this.startTime = Client.nanoTime();
        this.target = candidate;
    }

    private void releaseAndReset() {
        if (this.targetId >= 0) {
            Client.releaseAttack();
        }
        this.reset();
    }

    private void reset() {
        this.targetId = -1;
        this.startTime = 0L;
        this.active = false;
        this.target = null;
    }

    private double holdTime() {
        Setting s = this.setting("hold_time");
        return s == null ? 1000.0 : s.getNumber();
    }

    private Setting setting(String name) {
        for (Setting s : this.getSettings()) {
            if (!s.getName().equals(name)) continue;
            return s;
        }
        return null;
    }

    private double range() {
        for (Setting s : this.getSettings()) {
            if (!s.getName().equals("range")) continue;
            return s.getNumber();
        }
        return 3.0;
    }
}

