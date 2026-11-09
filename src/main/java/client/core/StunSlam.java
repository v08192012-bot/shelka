/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import client.mc.Entity;

public final class StunSlam
extends Feature {
    public static final String MODULE = "stunslam";
    public static final String DISPLAY = "\u0417\u0442\u0443\u043d\u0417\u043b\u0430\u043c";
    public static final int VTABLE_RVA = 12282016;
    private static final int HOTBAR_LAST = 8;
    private boolean slamPending;
    private boolean restorePending;
    private int savedSlot = -1;

    public StunSlam() {
        super(MODULE, DISPLAY, Category.Combat);
        this.add(Setting.number("min_fall", 3.0, 0.0, 10.0));
        this.add(Setting.number("delay", 0.0, 0.0, 1000.0));
    }

    @Override
    public void onTick() {
        this.applyPendingSlot();
        this.tickSlam();
        this.scanForSlam();
    }

    @Override
    public void onDisable() {
        if (Client.inGame() && this.savedSlot != -1) {
            Client.selectSlot(this.savedSlot);
        }
        this.slamPending = false;
        this.restorePending = false;
        this.savedSlot = -1;
    }

    private void applyPendingSlot() {
        if (this.savedSlot == -1) {
            return;
        }
        if (!Client.inGame()) {
            this.slamPending = false;
            this.savedSlot = -1;
            return;
        }
        if (this.restorePending) {
            return;
        }
        int slot = this.savedSlot;
        if (slot == -1) {
            return;
        }
        if (slot <= 8) {
            Client.setSelectedSlot(slot);
        }
        this.slamPending = false;
        this.savedSlot = -1;
    }

    private void tickSlam() {
        if (!Client.inGame()) {
            this.slamPending = false;
            this.savedSlot = -1;
            return;
        }
        if (this.restorePending) {
            this.restorePending = false;
            Entity self = Client.player();
            if (self == null) {
                return;
            }
            if (!(Client.isAlive(self) && Client.canAttack(self) && Client.isVisibleTarget(self))) {
                return;
            }
            int slot = Client.findSlotWithItem(2);
            if (slot == -1) {
                return;
            }
            Client.selectSlot(slot);
            Client.resetAttackStrength(Client.player());
            return;
        }
        if (!this.slamPending) {
            return;
        }
        this.slamPending = false;
        if (!this.readyToSlam()) {
            return;
        }
        int slamSlot = Client.findSlotWithItem(1);
        if (slamSlot == -1) {
            return;
        }
        int mainSlot = Client.findSlotWithItem(2);
        if (mainSlot == -1) {
            return;
        }
        Entity target = Client.findSlamTarget();
        if (target == null) {
            return;
        }
        if (Client.entityId(target) != Client.entityNetworkId(target)) {
            return;
        }
        if (!Client.isTargetValid(target)) {
            return;
        }
        slamSlot = Client.findSlotWithItem(1);
        if (slamSlot == -1) {
            return;
        }
        this.savedSlot = Client.selectedSlot();
        Client.selectSlot(slamSlot);
        Client.resetAttackStrength(Client.player());
        this.restorePending = true;
    }

    private void scanForSlam() {
        this.slamPending = false;
        if (!Client.inGame()) {
            return;
        }
        if (this.savedSlot != -1) {
            Client.slamKeyPressed();
            return;
        }
        if (!Client.slamKeyPressed()) {
            return;
        }
        Entity self = Client.player();
        if (self == null) {
            return;
        }
        if (!(Client.isAlive(self) && Client.canAttack(self) && Client.isVisibleTarget(self))) {
            return;
        }
        if (!this.readyToSlam()) {
            return;
        }
        int slamSlot = Client.findSlotWithItem(1);
        if (slamSlot == -1) {
            return;
        }
        int mainSlot = Client.findSlotWithItem(2);
        if (mainSlot == -1) {
            return;
        }
        Entity target = Client.findSlamTarget();
        if (target == null) {
            return;
        }
        if (Client.entityId(target) != Client.entityNetworkId(target)) {
            return;
        }
        if (!Client.isTargetValid(target)) {
            return;
        }
        this.slamPending = Client.slamKeyPressed();
    }

    private boolean readyToSlam() {
        if (Client.combatLock() > 0) {
            return false;
        }
        if (Client.cameraOverrides() > 0) {
            return false;
        }
        Entity self = Client.player();
        if (self == null) {
            return false;
        }
        double fall = Client.fallDistance(self);
        if (Double.isNaN(fall)) {
            fall = 0.0;
        }
        return fall > this.minFall();
    }

    public Setting minFallSetting() {
        return this.setting("min_fall");
    }

    public Setting delaySetting() {
        return this.setting("delay");
    }

    private double minFall() {
        Setting s = this.setting("min_fall");
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

