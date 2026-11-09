/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import client.mc.Entity;

public final class TriggerBot
extends Feature {
    public static final String MODULE = "triggerbot";
    public static final String DISPLAY = "\u0422\u0440\u0438\u0433\u0433\u0435\u0440\u0411\u043e\u0442";
    public static final int VTABLE_RVA = 12284488;
    public static final String STATUS_NO_PLAYER = "no player";
    public static final String STATUS_SCREEN_OPEN = "a screen is open";
    public static final String STATUS_BREAKING_BLOCK = "breaking a block";
    public static final String STATUS_NO_WEAPON = "no weapon in hand";
    public static final String STATUS_CROSSBOW = "holding a crossbow";
    public static final String STATUS_USING_ITEM = "using an item";
    public static final String STATUS_ATTACKING = "attacking";
    public static final String STATUS_TICK_MISSED = "attacking a target the tick missed";
    public static final String STATUS_STUNSLAM = "handed to StunSlam";
    public static final String STATUS_COMBO = "combo_lunge";
    private static final int RELEASE_TICKS = 10;
    private Entity lockedTarget;
    private Entity pendingTarget;
    private int attackCooldown;
    private int releaseTimer;
    private int rePressDelay;
    private int idleTicks;
    private float attackYaw;
    private float attackPitch;
    private boolean comboActive;
    private float comboYaw;
    private float comboPitch;
    private int lastTargetId = -1;
    private double lastTargetValue;
    private boolean fallStateValid;
    private boolean fallStateFlag;
    private int lastFallTick;
    private double lastFallY;
    private String status = "";

    public TriggerBot() {
        super(MODULE, DISPLAY, Category.Combat);
        this.add(Setting.mode("attack_mode", "\u041e\u0431\u044b\u0447\u043d\u044b\u0439", "\u041e\u0431\u044b\u0447\u043d\u044b\u0439"));
        this.add(Setting.mode("target_mode", "\u041d\u0435\u0432\u0438\u0434\u0438\u043c\u044b\u0445", "\u041d\u0435\u0432\u0438\u0434\u0438\u043c\u044b\u0445", "\u0422\u043e\u043b\u044c\u043a\u043e \u0438\u0433\u0440\u043e\u043a\u0438"));
        this.add(Setting.mode("hit_conditions", "\u0422\u043e\u043b\u044c\u043a\u043e \u043a\u0440\u0438\u0442\u044b", "\u0422\u043e\u043b\u044c\u043a\u043e \u043a\u0440\u0438\u0442\u044b", "\u0427\u0435\u0440\u0435\u0437 \u0442\u0440\u0430\u0432\u0443"));
        this.add(Setting.bool("weapon_only", true));
        this.add(Setting.number("reach", 3.0, 1.0, 6.0));
        this.add(Setting.bool("through_entities", false));
        this.add(Setting.bool("custom_cooldown", false));
        this.add(Setting.number("custom_cooldown_percent", 100.0, 0.0, 100.0));
        this.add(Setting.bool("tps_sync", false));
        this.add(Setting.bool(STATUS_COMBO, false));
    }

    @Override
    public void onEnable() {
        this.attackCooldown = 0;
        this.releaseTimer = 0;
        this.rePressDelay = 0;
        this.idleTicks = 0;
        this.comboActive = false;
        this.lastTargetId = -1;
        this.lastTargetValue = 0.0;
        this.pendingTarget = null;
        this.lastFallTick = -1;
        this.lastFallY = 0.0;
        this.fallStateValid = false;
        this.fallStateFlag = false;
        this.status = "";
    }

    @Override
    public void onDisable() {
        this.resetState();
    }

    @Override
    public void onTick() {
        Entity selfHandle;
        Entity self = Client.player();
        Entity entity = selfHandle = self == null ? null : Client.entityHandle(self);
        if (selfHandle != null) {
            Entity handle;
            Entity local = Client.player();
            if (local == null) {
                this.status = STATUS_NO_PLAYER;
                this.lastFallTick = -1;
                this.lastFallY = 0.0;
                this.fallStateValid = false;
                this.fallStateFlag = false;
            } else {
                Entity handle2 = Client.entityHandle(local);
                if (handle2 == null || !Client.hasPendingException()) {
                    this.status = STATUS_NO_PLAYER;
                    this.lastFallTick = -1;
                    this.lastFallY = 0.0;
                    this.fallStateValid = false;
                    this.fallStateFlag = false;
                } else {
                    int tick = Client.entityTick(handle2);
                    if (Client.hasPendingException()) {
                        tick = -1;
                    }
                    if (!this.fallStateValid || this.lastFallTick != tick) {
                        double[] position = Client.entityPosition(handle2);
                        boolean flag = !this.fallStateValid || tick != this.lastFallTick + 1 ? false : this.lastFallY <= position[1];
                        this.fallStateFlag = flag;
                        this.fallStateValid = true;
                        this.lastFallTick = tick;
                        this.lastFallY = position[1];
                    }
                }
            }
            if (Client.isPaused()) {
                this.status = STATUS_SCREEN_OPEN;
                return;
            }
            Entity target = this.lockedTarget;
            if (this.lockedTarget != null) {
                this.lockedTarget = null;
            }
            if (this.attackCooldown != 0) {
                --this.attackCooldown;
                if (this.attackCooldown == 1) {
                    Client.setAttackKey(false);
                } else {
                    Client.setAttackKey(Client.attackKeyState());
                }
            }
            if (this.rePressDelay > 0) {
                --this.rePressDelay;
            }
            if (this.releaseTimer != 0) {
                --this.releaseTimer;
                if (this.releaseTimer < 1) {
                    this.releaseTimer = 0;
                    if (Client.cameraOverrides() < 1) {
                        Client.setAttackKey(Client.attackKeyState());
                    }
                    this.rePressDelay = 10;
                }
            }
            if (Client.isBreakingBlock()) {
                this.status = STATUS_BREAKING_BLOCK;
                return;
            }
            Entity current = Client.player();
            Entity entity2 = handle = current == null ? null : Client.entityHandle(current);
            this.idleTicks = Client.canAttack(handle) ? ++this.idleTicks : 0;
            if (Client.hasCrosshairEntity()) {
                if (this.pendingTarget != null) {
                    this.cancelPendingTarget();
                }
                this.status = STATUS_USING_ITEM;
                return;
            }
            if (this.pendingTarget != null) {
                this.resolvePendingTarget();
                return;
            }
            if (Client.isHoldingCrossbow()) {
                this.status = STATUS_CROSSBOW;
                return;
            }
            if (this.weaponOnly() && !Client.isHoldingWeaponClass2()) {
                this.status = STATUS_NO_WEAPON;
                return;
            }
            Entity found = this.findNearestHit(handle);
            if (found != null) {
                this.status = STATUS_ATTACKING;
                this.handToStunSlam(found, handle);
                return;
            }
            this.attackLockedTarget(target, handle);
        }
    }

    private void attackLockedTarget(Entity target, Entity selfHandle) {
        if (target == null) {
            return;
        }
        if (!Client.canAttack(target)) {
            return;
        }
        if (!this.findThroughEntities(target, selfHandle)) {
            return;
        }
        if (!Client.canReachTarget(target, this.attackYaw, this.attackPitch, this.reach())) {
            return;
        }
        if (!this.canAttackTarget(target)) {
            return;
        }
        this.status = STATUS_TICK_MISSED;
        if (!this.comboLunge() && Client.isOnGround(selfHandle) && Client.lungeReady()) {
            this.startComboLunge(target);
            this.comboActive = true;
            this.comboYaw = this.attackYaw;
            this.comboPitch = this.attackPitch;
            return;
        }
        Client.beginAttack();
        String name = Client.entityName(target);
        if (name == null) {
            name = "";
        }
        if (Client.wtapActive() && Client.wtapAttackCheck(target)) {
            Client.wtapOnAttack(target);
        }
        Client.attackWith(selfHandle, target);
        if (this.releaseTimer != 0) {
            this.releaseTimer = 0;
            if (Client.cameraOverrides() > 0) {
                return;
            }
            Client.setAttackKey(Client.attackKeyState());
            return;
        }
        Client.completeAttack(this);
    }

    private Entity findNearestHit(Entity selfHandle) {
        return Client.findNearestHit(selfHandle);
    }

    private boolean findThroughEntities(Entity target, Entity selfHandle) {
        return Client.findThroughEntities(this, target, selfHandle);
    }

    private boolean canAttackTarget(Entity target) {
        return Client.canAttackTarget(this, target);
    }

    private void handToStunSlam(Entity target, Entity selfHandle) {
        if (!this.canAttackTarget(target)) {
            this.tryComboAttack(target, selfHandle);
            return;
        }
        this.status = STATUS_ATTACKING;
        if (Client.handToStunSlam(this, target, selfHandle)) {
            this.status = STATUS_STUNSLAM;
        }
    }

    private void tryComboAttack(Entity target, Entity selfHandle) {
        if (!this.comboLunge() && this.pendingTarget == null && Client.combatLock() < 1 && Client.isOnGround(selfHandle) && Client.lungeReady() && Client.slamReady()) {
            this.startComboLunge(target);
            return;
        }
        if (!this.comboLunge()) {
            return;
        }
        if (!Client.attackAllowed(this)) {
            return;
        }
        if (this.attackCooldown != 0 || this.rePressDelay != 0 || this.releaseTimer != 0) {
            return;
        }
        if (Client.combatLock() > 0 || Client.cameraOverrides() > 0) {
            return;
        }
        if (!Client.canAttack(selfHandle)) {
            return;
        }
        if (Client.isOnGround(selfHandle)) {
            return;
        }
        if (Client.hasCrosshairEntity()) {
            return;
        }
        if (Client.anyInputPressed()) {
            return;
        }
        if (!Client.slamReady()) {
            return;
        }
        if (!Client.comboAttackReady(this, target)) {
            return;
        }
        Client.setAttackKey(true);
        Client.setHeldFlag(selfHandle, true);
        this.releaseTimer = 2;
    }

    private void startComboLunge(Entity target) {
        Client.startComboLunge(this, target);
    }

    private void resolvePendingTarget() {
        Client.resolvePendingTarget(this);
        this.pendingTarget = null;
    }

    private void cancelPendingTarget() {
        Client.cancelPendingTarget(this);
        this.pendingTarget = null;
    }

    private void resetState() {
        if (this.lockedTarget != null) {
            this.lockedTarget = null;
        }
        this.status = "";
        this.idleTicks = 0;
        this.lastTargetId = -1;
        this.lastTargetValue = 0.0;
        this.comboActive = false;
        this.attackCooldown = 0;
        this.releaseTimer = 0;
        this.rePressDelay = 0;
        if (this.releaseTimer != 0 || this.attackCooldown != 0) {
            this.releaseTimer = 0;
            this.attackCooldown = 0;
            Client.setAttackKey(Client.attackKeyState());
        }
        if (this.pendingTarget != null) {
            this.pendingTarget = null;
        }
    }

    public String status() {
        return this.status;
    }

    public float attackYaw() {
        return this.attackYaw;
    }

    public float attackPitch() {
        return this.attackPitch;
    }

    public boolean comboActive() {
        return this.comboActive;
    }

    public float comboYaw() {
        return this.comboYaw;
    }

    public float comboPitch() {
        return this.comboPitch;
    }

    public int idleTicks() {
        return this.idleTicks;
    }

    public int attackCooldown() {
        return this.attackCooldown;
    }

    public int releaseTimer() {
        return this.releaseTimer;
    }

    public int rePressDelay() {
        return this.rePressDelay;
    }

    public boolean fallStateValid() {
        return this.fallStateValid;
    }

    public boolean fallStateFlag() {
        return this.fallStateFlag;
    }

    private boolean weaponOnly() {
        Setting s = this.setting("weapon_only");
        return s != null && s.getBoolean();
    }

    private boolean comboLunge() {
        Setting s = this.setting(STATUS_COMBO);
        return s != null && s.getBoolean();
    }

    private double reach() {
        Setting s = this.setting("reach");
        return s == null ? 3.0 : s.getNumber();
    }

    private Setting setting(String name) {
        for (Setting s : this.getSettings()) {
            if (!s.getName().equals(name)) continue;
            return s;
        }
        return null;
    }
}

