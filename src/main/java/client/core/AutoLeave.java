/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import client.mc.Entity;

public final class AutoLeave
extends Feature {
    public static final String MODULE = "autoleave";
    public static final int VTABLE_RVA = 12295216;
    private static final double MAX_RADIUS = 128.0;
    private static final double TELEPORT_DISTANCE = 3.0;
    private static final String REASON_CRYSTAL = "\u043a\u0440\u0438\u0441\u0442\u0430\u043b\u043b";
    private static final String REASON_TNT = "\u0422\u041d\u0422";
    private boolean left;
    private boolean teleportGuard;
    private String reason = "";
    private Entity cause;

    public AutoLeave() {
        super(MODULE, "", Category.Player);
        this.add(Setting.number("distance", 3.0, 0.0, 16.0));
        this.add(Setting.bool("crystal", true));
        this.add(Setting.number("crystal_distance", 4.0, 0.0, 16.0));
        this.add(Setting.bool("tnt", true));
        this.add(Setting.number("tnt_distance", 6.0, 0.0, 16.0));
        this.add(Setting.number("tnt_fuse", 40.0, 0.0, 80.0));
        this.add(Setting.bool("anti_teleport", false));
        this.add(Setting.mode("mode", REASON_CRYSTAL, REASON_CRYSTAL, "hub"));
    }

    @Override
    public void onEnable() {
        this.left = false;
        this.cause = null;
        this.reason = "";
    }

    @Override
    public void onDisable() {
        this.left = false;
        this.cause = null;
        this.reason = "";
    }

    @Override
    public void onTick() {
        if (this.left) {
            return;
        }
        if (!Client.inGame()) {
            return;
        }
        Entity self = Client.player();
        double distance = this.distance();
        double radius = Math.min(distance, 128.0);
        double radiusSquared = radius * radius;
        double[] selfPosition = Client.entityPosition(self);
        this.cause = null;
        this.reason = "";
        Client.forEachEntity(entity -> this.inspect((Entity)entity, self, selfPosition, radiusSquared, distance));
        if (this.cause != null) {
            this.left = true;
            Client.leaveServer();
        }
    }

    public void onTeleport(double distance) {
        if (this.teleportGuard && !this.left && 3.0 <= distance) {
            this.setEnabled(false);
        }
    }

    public String reason() {
        return this.reason;
    }

    public boolean hasLeft() {
        return this.left;
    }

    private void inspect(Entity entity, Entity self, double[] selfPosition, double radiusSquared, double distance) {
        boolean crystal;
        double dz;
        double dy;
        if (this.cause != null) {
            return;
        }
        double[] position = Client.entityPosition(entity);
        double dx = selfPosition[0] - position[0];
        double distanceSquared = dx * dx + (dy = selfPosition[1] - position[1]) * dy + (dz = selfPosition[2] - position[2]) * dz;
        if (!(distanceSquared < radiusSquared)) {
            return;
        }
        double real = Math.sqrt(distanceSquared);
        boolean player = Client.isPlayer(entity);
        if (player && real <= distance && !Client.sameEntity(entity, self)) {
            String name = Client.playerName(entity);
            if (!Client.isIgnoredName(name)) {
                this.cause = entity;
                this.reason = name;
            }
            return;
        }
        boolean bl = crystal = this.crystal() && Client.isCrystalEntity(entity) && !(this.crystalDistance() < real);
        if (crystal) {
            this.cause = entity;
            this.reason = REASON_CRYSTAL;
            return;
        }
        if (!this.tnt() || !Client.isTntEntity(entity)) {
            return;
        }
        if (this.tntDistance() < real) {
            return;
        }
        int fuse = Client.tntFuse(entity);
        if (fuse < 0) {
            return;
        }
        if (this.tntFuse() < (double)fuse) {
            return;
        }
        this.cause = entity;
        this.reason = REASON_TNT;
    }

    public double distance() {
        return this.number("distance", 3.0);
    }

    public boolean crystal() {
        return this.bool("crystal", true);
    }

    public double crystalDistance() {
        return this.number("crystal_distance", 4.0);
    }

    public boolean tnt() {
        return this.bool("tnt", true);
    }

    public double tntDistance() {
        return this.number("tnt_distance", 6.0);
    }

    public double tntFuse() {
        return this.number("tnt_fuse", 40.0);
    }

    public boolean antiTeleport() {
        return this.bool("anti_teleport", false);
    }

    public String mode() {
        Setting s = this.setting("mode");
        return s == null ? REASON_CRYSTAL : s.getMode();
    }

    private double number(String name, double fallback) {
        Setting s = this.setting(name);
        return s == null ? fallback : s.getNumber();
    }

    private boolean bool(String name, boolean fallback) {
        Setting s = this.setting(name);
        return s == null ? fallback : s.getBoolean();
    }

    private Setting setting(String name) {
        for (Setting s : this.getSettings()) {
            if (!s.getName().equals(name)) continue;
            return s;
        }
        return null;
    }
}

