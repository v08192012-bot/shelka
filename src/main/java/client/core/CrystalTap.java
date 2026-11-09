/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.BlockPos;
import client.mc.Client;
import client.mc.Entity;

public final class CrystalTap
extends Feature {
    public static final String MODULE = "crystaltap";
    public static final int VTABLE_RVA = 12278208;
    private static final int ITEM_NETHERITE = 49;
    private static final int ATTACK_COOLDOWN_TICKS = 9;
    private static final double OFFSET_A = 0.5;
    private static final double OFFSET_B = 1.0;
    private int tickCounter;
    private int lastAttackTick;
    private int lastActionTick;
    private int lastCrystalId = -1;
    private boolean placed;

    public CrystalTap() {
        super(MODULE, "", Category.Combat);
        this.add(Setting.bool("auto_place", true));
        this.add(Setting.number("place_cooldown", 2.0, 0.0, 20.0));
        this.add(Setting.number("attack_cooldown", 2.0, 0.0, 20.0));
    }

    @Override
    public void onDisable() {
        this.lastCrystalId = -1;
        this.placed = false;
    }

    @Override
    public void onTick() {
        int z;
        int y;
        Entity crosshair;
        ++this.tickCounter;
        if (!Client.inGame()) {
            return;
        }
        if (Client.isPaused()) {
            return;
        }
        Entity localPlayer = Client.player();
        boolean wantsCrystal = false;
        if (this.autoPlace() && localPlayer != null && Client.isHoldingItem(49) && (int)this.delay() < this.tickCounter - this.lastActionTick) {
            wantsCrystal = true;
        }
        if ((crosshair = Client.crosshairEntity()) == null || !Client.isLiving(crosshair)) {
            if (!wantsCrystal) {
                return;
            }
            BlockPos hit = Client.raycastBlock();
            if (hit == null) {
                return;
            }
            if (!Client.isObsidian(hit)) {
                return;
            }
            boolean[] didPlace = new boolean[1];
            this.crystalOn(hit, didPlace);
            if (didPlace[0]) {
                return;
            }
            Client.swingMainHand();
            return;
        }
        if (!Client.isCrystal(crosshair)) {
            return;
        }
        if (Client.isOwnCrystal(crosshair)) {
            return;
        }
        int entityId = Client.entityId(crosshair);
        if (entityId != this.lastCrystalId || this.tickCounter - this.lastAttackTick > 9) {
            if (this.tickCounter - this.lastAttackTick <= (int)this.delay()) {
                return;
            }
            Client.attack(crosshair);
            this.lastAttackTick = this.tickCounter;
            this.lastCrystalId = entityId;
            this.placed = false;
            return;
        }
        if (!wantsCrystal) {
            return;
        }
        if (this.placed) {
            return;
        }
        double[] pos = Client.entityPosition(crosshair);
        int x = (int)Math.floor(pos[0]);
        BlockPos base = new BlockPos(x, y = (int)Math.floor(pos[1]) - 1, z = (int)Math.floor(pos[2]));
        if (!Client.isObsidian(base)) {
            return;
        }
        double[] spawn = new double[]{(double)x + 0.5, (double)y + 1.0, (double)z + 0.5};
        Entity crystal = Client.spawnEndCrystal(spawn);
        if (crystal != null) {
            Client.swingMainHand();
        }
        this.placed = true;
        this.lastActionTick = this.tickCounter;
    }

    private boolean crystalOn(BlockPos pos, boolean[] didPlace) {
        if (!Client.canPlaceCrystal(pos)) {
            return false;
        }
        int x = pos.x();
        int y = pos.y() + 1;
        int z = pos.z();
        double[] spawn = new double[]{(double)x + 0.5, y, (double)z + 0.5};
        Entity crystal = Client.spawnEndCrystal(spawn);
        if (crystal != null) {
            didPlace[0] = true;
            return true;
        }
        return false;
    }

    private boolean autoPlace() {
        Setting s = this.setting("auto_place");
        return s == null || s.getBoolean();
    }

    private double delay() {
        Setting s = this.setting("place_cooldown");
        return s == null ? 2.0 : s.getNumber();
    }

    private Setting setting(String name) {
        for (Setting s : this.getSettings()) {
            if (!s.getName().equals(name)) continue;
            return s;
        }
        return null;
    }
}

