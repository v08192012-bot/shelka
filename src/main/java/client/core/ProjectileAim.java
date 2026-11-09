/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import client.mc.Entity;
import client.mc.ItemStack;

public final class ProjectileAim
extends Feature {
    public static final String MODULE = "projectileaim";
    public static final String DISPLAY = "\u041f\u0440\u043e\u0436\u0435\u0441\u0442\u0438\u043b\u0435\u0410\u0438\u043c";
    public static final int VTABLE_RVA = 12280304;
    private static final double HALF_TURN = Math.PI;
    private static final double LEAD_HALF = 0.5;
    private static final double ONE = 1.0;
    private static final double MIN_FACTOR = 0.01;
    private static final double ROT_EPSILON = 0.02;
    private static final double ROT_MIN = 0.001;
    private static final double STEP_MIN = 0.05;
    private static final double STEP_MAX = 0.5;
    private static final double NANOS_PER_STEP = 1.0E7;
    private static final double LEAD_NEW = 0.35;
    private static final double LEAD_OLD = 0.65;
    private boolean active;
    private boolean hasHistory;
    private float lastYaw;
    private float lastPitch;
    private long lastTime;
    private int lastTargetId = -1;
    private double lastPropA;
    private double lastPropB;
    private double lastPropC;
    private double leadX;
    private double leadY;
    private double leadZ;

    public ProjectileAim() {
        super(MODULE, DISPLAY, Category.Combat);
        this.add(Setting.mode("weapons", "\u041b\u0443\u043a", "\u041b\u0443\u043a", "\u0410\u0440\u0431\u0430\u043b\u0435\u0442", "\u0421\u043d\u0435\u0436\u043e\u043a", "\u0422\u0440\u0435\u0437\u0443\u0431\u0435\u0446"));
        this.add(Setting.number("distance", 30.0, 1.0, 100.0));
        this.add(Setting.number("fov", 90.0, 1.0, 180.0));
        this.add(Setting.number("lead", 100.0, 0.0, 100.0));
        this.add(Setting.number("speed", 0.5, 0.05, 1.0));
        this.add(Setting.bool("wall_check", true));
    }

    @Override
    public void onTick() {
        double leadCos;
        double distanceSq;
        double dirZ;
        double dirY;
        this.active = false;
        if (!Client.inGame() || Client.isPaused()) {
            this.hasHistory = false;
            return;
        }
        Entity self = Client.player();
        if (self == null) {
            this.hasHistory = false;
            return;
        }
        double[] trajectory = new double[4];
        if (!Client.prepareProjectileAim(self, trajectory)) {
            this.hasHistory = false;
            return;
        }
        ItemStack held = Client.heldItem();
        double itemA = 0.0;
        double itemB = 0.0;
        double itemC = 0.0;
        if (held != null) {
            itemA = Client.projectileSpeed(held);
            itemB = Client.projectileDivergence(held);
            itemC = Client.projectileGravity(held);
        }
        double[] rotation = Client.currentRotation();
        double yawRad = Math.toRadians(rotation[0]);
        double pitchRad = Math.toRadians(rotation[1]);
        double dirX = -Math.sin(yawRad) * Math.cos(pitchRad);
        Entity target = this.findTarget(dirX, dirY = -Math.sin(pitchRad), dirZ = Math.cos(yawRad) * Math.cos(pitchRad), distanceSq = this.distance() * this.distance(), leadCos = Math.cos(this.lead() * 0.5 * (Math.PI / 180)), this.wallCheck());
        if (target == null) {
            this.hasHistory = false;
            return;
        }
        double propA = Client.targetPropA(target);
        double propB = Client.targetPropB(target);
        double propC = Client.targetPropC(target);
        int id = Client.entityNetworkId(target);
        if (!this.hasHistory || id != this.lastTargetId) {
            this.lastTargetId = id;
            this.lastPropA = propA;
            this.lastPropB = propB;
            this.lastPropC = propC;
            this.leadX = 0.0;
            this.leadY = 0.0;
            this.leadZ = 0.0;
            this.hasHistory = true;
        } else {
            double dA = propA - this.lastPropA;
            double dB = propB - this.lastPropB;
            double dC = propC - this.lastPropC;
            this.lastPropA = propA;
            this.lastPropB = propB;
            this.lastPropC = propC;
            if (dB * dB + dA * dA + dC * dC <= Client.leadDeltaLimit()) {
                this.leadX = dA * 0.35 + this.leadX * 0.65;
                this.leadY = dB * 0.35 + this.leadY * 0.65;
                this.leadZ = dC * 0.35 + this.leadZ * 0.65;
            } else {
                this.leadX = 0.0;
                this.leadY = 0.0;
                this.leadZ = 0.0;
            }
        }
        this.active = this.applyAim(self, target, trajectory, itemA, itemB, itemC, leadCos);
    }

    @Override
    public void onDisable() {
        this.returnRotation();
        this.active = false;
        this.hasHistory = false;
        this.lastTargetId = -1;
        this.lastTime = 0L;
    }

    private void returnRotation() {
        if (!Client.inGame() || this.lastTargetId == -1) {
            return;
        }
        if (Client.isScreenOpen()) {
            return;
        }
        Entity self = Client.player();
        if (self == null) {
            return;
        }
        double yaw = Client.currentRotation()[0];
        double pitch = Client.currentRotation()[1];
        long now = Client.tickTime();
        double factor = 1.0;
        if (this.lastTime > 0L) {
            double elapsed = (double)(now - this.lastTime) / 1.0E7;
            double clamped = elapsed;
            if (0.05 >= clamped) {
                clamped = 0.05;
            }
            if (clamped >= 0.5) {
                clamped = 0.5;
            }
            factor = clamped;
        }
        this.lastTime = now;
        factor = Math.max(0.01, factor);
        factor = 1.0 - Math.pow(1.0 - this.aimSpeed(), factor);
        double deltaYaw = Client.wrapDegrees((double)this.lastYaw - yaw);
        double deltaPitch = (double)this.lastPitch - pitch;
        if (Math.abs(deltaYaw) >= 0.02) {
            deltaYaw *= factor;
        }
        if (Math.abs(deltaPitch) >= 0.02) {
            deltaPitch *= factor;
        }
        if (Math.abs(deltaYaw) >= 0.001 || Math.abs(deltaPitch) >= 0.001) {
            Client.addRotation((float)deltaYaw, (float)deltaPitch);
        }
    }

    private Entity findTarget(double dirX, double dirY, double dirZ, double distanceSq, double leadCos, boolean wallCheck) {
        Entity self = Client.player();
        if (self == null) {
            return null;
        }
        Entity best = null;
        double bestScore = Double.MAX_VALUE;
        double[] selfPosition = Client.entityPosition(self);
        double fovCos = Math.cos(Math.toRadians(this.fov() * 0.5));
        for (Entity entity : Client.entities()) {
            double projection;
            double cosAngle;
            double range;
            double dz;
            double dy;
            double[] position;
            double dx;
            double rangeSq;
            if (entity == self || !Client.isLiving(entity) || Client.isFriend(entity) || (rangeSq = (dx = (position = Client.entityPosition(entity))[0] - selfPosition[0]) * dx + (dy = position[1] - selfPosition[1]) * dy + (dz = position[2] - selfPosition[2]) * dz) > distanceSq || wallCheck && !Client.canSee(entity) || (range = Math.sqrt(rangeSq)) <= 0.0 || (cosAngle = (dx * dirX + dy * dirY + dz * dirZ) / range) < fovCos || (projection = range * cosAngle) <= 0.0 || projection < range * leadCos || !(projection < bestScore)) continue;
            bestScore = projection;
            best = entity;
        }
        return best;
    }

    private boolean applyAim(Entity self, Entity target, double[] trajectory, double itemA, double itemB, double itemC, double leadCos) {
        return Client.applyProjectileAim(self, target, trajectory, itemA, itemB, itemC, leadCos);
    }

    public boolean isActive() {
        return this.active;
    }

    public float lastYaw() {
        return this.lastYaw;
    }

    public float lastPitch() {
        return this.lastPitch;
    }

    public double leadX() {
        return this.leadX;
    }

    public double leadY() {
        return this.leadY;
    }

    public double leadZ() {
        return this.leadZ;
    }

    private double distance() {
        Setting s = this.setting("distance");
        return s == null ? 30.0 : s.getNumber();
    }

    private double fov() {
        Setting s = this.setting("fov");
        return s == null ? 90.0 : s.getNumber();
    }

    private double lead() {
        Setting s = this.setting("lead");
        return s == null ? 100.0 : s.getNumber();
    }

    private double aimSpeed() {
        Setting s = this.setting("speed");
        return s == null ? 0.5 : s.getNumber();
    }

    private boolean wallCheck() {
        Setting s = this.setting("wall_check");
        return s == null || s.getBoolean();
    }

    private Setting setting(String name) {
        for (Setting s : this.getSettings()) {
            if (!s.getName().equals(name)) continue;
            return s;
        }
        return null;
    }
}

