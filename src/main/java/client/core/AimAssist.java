/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.aim.Rotation;
import client.mc.Client;
import client.mc.Entity;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class AimAssist
extends Feature {
    public static final String MODULE = "aimassist";
    public static final int VTABLE_RVA = 12270808;
    private static final long NANOS_PER_UNIT = 1000000000L;
    private final List<Entity> candidates = new ArrayList<Entity>();
    private Entity cachedTarget;
    private double[] lastSelfPosition = new double[3];
    private double cachedX;
    private double cachedY;
    private double cachedZ;
    private double requiredSpeed = 1.0;
    private boolean hasTarget;
    private long lastTargetSwitch;
    private long lastReset;

    public AimAssist() {
        super(MODULE, "", Category.Combat);
        this.add(Setting.mode("rotation", "Linear", "Linear", "Smooth", "Instant"));
        this.add(Setting.number("speed", 3.0, 1.0, 10.0));
        this.add(Setting.number("strength", 100.0, 0.0, 100.0));
        this.add(Setting.number("vertical_freedom", 0.0, -90.0, 90.0));
        this.add(Setting.mode("behavior", "Legit", "Legit", "Rage"));
        this.add(Setting.number("slow_threshold", 0.4, 0.0, 3.0));
        this.add(Setting.number("legit_speed", 1.0, 0.1, 5.0));
        this.add(Setting.bool("randomize", false));
        this.add(Setting.mode("priority", "Distance", "Distance", "Health", "Angle"));
        this.add(Setting.number("distance", 4.5, 1.0, 8.0));
        this.add(Setting.number("fov", 90.0, 1.0, 360.0));
        this.add(Setting.bool("sticky", false));
        this.add(Setting.bool("last_hit_only", false));
        this.add(Setting.mode("targets", "Players", "Players", "Mobs", "All"));
        this.add(Setting.mode("conditions", "None", "None", "Visible", "Weapon"));
    }

    @Override
    public void onDisable() {
        this.cachedTarget = null;
        this.hasTarget = false;
    }

    @Override
    public void onTick() {
        if (!Client.inGame()) {
            return;
        }
        if (!Client.isPlayerAlive()) {
            return;
        }
        Entity self = Client.player();
        this.requiredSpeed = this.computeSpeed();
        double[] selfPosition = Client.eyePosition();
        if (this.hasTarget && this.lastSelfPosition[0] != 0.0) {
            double dx = selfPosition[0] - this.lastSelfPosition[0];
            double dy = selfPosition[1] - this.lastSelfPosition[1];
            double dz = selfPosition[2] - this.lastSelfPosition[2];
            double travelled = Math.sqrt(dx * dx + dy * dy + dz * dz);
            this.requiredSpeed = travelled / this.smoothingDivisor();
        }
        this.lastSelfPosition = selfPosition;
        Entity target = this.findTarget(self);
        if (target == null) {
            long resetDelay = (long)(this.resetDelay() * 1.0E9);
            if (resetDelay >= 1L && this.cachedTarget != null && System.nanoTime() - this.lastReset < resetDelay) {
                return;
            }
            this.resetRotation();
            return;
        }
        double[] targetPosition = Client.entityPosition(target);
        if (this.cachedTarget != null && Client.sameEntity(this.cachedTarget, target)) {
            double dx = this.cachedX - targetPosition[0];
            double dy = this.cachedY - targetPosition[1];
            double dz = this.cachedZ - targetPosition[2];
            double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
            if (System.nanoTime() - this.lastTargetSwitch < (long)(this.resetDelay() * 1.0E9)) {
                return;
            }
            double[] rotation = Client.currentRotation();
            double[] delta = Rotation.delta(rotation, targetPosition);
            double yaw = rotation[0] + delta[0] / Math.max(this.requiredSpeed, 1.0E-4);
            double pitch = rotation[1] + delta[1] / Math.max(this.requiredSpeed, 1.0E-4);
            Client.setRotation(Rotation.clamp(yaw), Rotation.clampPitch(pitch));
            this.lastTargetSwitch = System.nanoTime();
            this.hasTarget = true;
            return;
        }
        this.cachedTarget = target;
        this.cachedX = targetPosition[0];
        this.cachedY = targetPosition[1];
        this.cachedZ = targetPosition[2];
        this.lastTargetSwitch = System.nanoTime();
        this.hasTarget = true;
    }

    private void resetRotation() {
        this.cachedTarget = null;
        this.hasTarget = false;
        this.lastReset = System.nanoTime();
    }

    private Entity findTarget(Entity self) {
        this.collectCandidates(self);
        if (this.candidates.isEmpty()) {
            return null;
        }
        double[] selfPosition = Client.eyePosition();
        String priority = this.mode("priority");
        Comparator<Entity> comparator = "Health".equals(priority) ? Comparator.comparingDouble(Client::health) : ("Angle".equals(priority) ? Comparator.comparingDouble(e -> this.angleTo(selfPosition, (Entity)e)) : Comparator.comparingDouble(e -> this.distanceTo(selfPosition, (Entity)e)));
        this.candidates.sort(comparator);
        return this.candidates.get(0);
    }

    private void collectCandidates(Entity self) {
        this.candidates.clear();
        double range = this.range();
        double[] selfPosition = Client.eyePosition();
        boolean throughWalls = this.bool("sticky");
        for (Entity entity : Client.entities()) {
            if (entity == self || !Client.isLiving(entity) || Client.isFriend(entity) || !throughWalls && !Client.canSee(entity) || this.distanceTo(selfPosition, entity) > range) continue;
            this.candidates.add(entity);
        }
    }

    private double distanceTo(double[] from, Entity entity) {
        double[] p = Client.entityPosition(entity);
        double dx = p[0] - from[0];
        double dy = p[1] - from[1];
        double dz = p[2] - from[2];
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    private double angleTo(double[] from, Entity entity) {
        double[] p = Client.entityPosition(entity);
        double dx = p[0] - from[0];
        double dz = p[2] - from[2];
        double yaw = Math.toDegrees(Math.atan2(-dx, dz));
        return Math.abs(Rotation.wrap(Client.currentRotation()[0] - yaw));
    }

    private double computeSpeed() {
        Setting s = this.setting("speed");
        return s == null ? 3.0 : s.getNumber();
    }

    private double smoothingDivisor() {
        Setting s = this.setting("legit_speed");
        return s == null ? 1.0 : s.getNumber();
    }

    private double range() {
        Setting s = this.setting("distance");
        return s == null ? 4.5 : s.getNumber();
    }

    private double resetDelay() {
        Setting s = this.setting("slow_threshold");
        return s == null ? 0.4 : s.getNumber();
    }

    private String mode(String name) {
        Setting s = this.setting(name);
        return s == null ? "Distance" : s.getMode();
    }

    private boolean bool(String name) {
        Setting s = this.setting(name);
        return s != null && s.getBoolean();
    }

    private Setting setting(String name) {
        for (Setting s : this.getSettings()) {
            if (!s.getName().equals(name)) continue;
            return s;
        }
        return null;
    }
}

