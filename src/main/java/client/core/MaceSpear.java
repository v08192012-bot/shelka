/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import client.mc.Entity;

public final class MaceSpear
extends Feature {
    public static final String MODULE = "macespear";
    public static final int VTABLE_RVA = 12278640;
    public static final int SWAP_BACK_RVA = 453456;
    public static final int CHECK_RVA = 452928;
    public static final int ACTION_RVA = 453120;
    public static final int DISABLE_RVA = 452864;
    public static final int FIND_TARGET_RVA = 453968;
    public static final int FIND_SLOT_RVA = 6414736;
    public static final int VIRTUAL_KIND = 2;
    private static final int HOTBAR_SLOTS = 8;
    private static final float READY_THRESHOLD = 1.0f;
    private static final int SLOT_NONE = -1;
    private boolean ready;
    private int savedSlot = -1;

    public MaceSpear() {
        super(MODULE, "\u041c\u0430\u0441\u0435\u0417\u043f\u0435\u0430\u0440", Category.Combat);
        this.add(Setting.number("reach", 4.5, 1.0, 8.0));
    }

    @Override
    public void onDisable() {
        this.ready = false;
        if (Client.inGame() && this.savedSlot != -1) {
            Client.setSelectedSlot(this.savedSlot);
        }
        this.savedSlot = -1;
    }

    @Override
    public void onTick() {
        this.swapBack();
        this.tickCheck();
        this.tickAction();
    }

    private void swapBack() {
        if (this.savedSlot == -1) {
            return;
        }
        if (!Client.inGame()) {
            this.savedSlot = -1;
            return;
        }
        int slot = this.savedSlot;
        if (slot == -1) {
            return;
        }
        if (slot > 8) {
            this.savedSlot = -1;
            return;
        }
        Client.setSelectedSlotReflective(slot);
        this.savedSlot = -1;
    }

    private void tickCheck() {
        this.ready = false;
        if (this.savedSlot != -1) {
            return;
        }
        if (!Client.isAttackKeyClicked()) {
            return;
        }
        if (Client.crosshairEntity() != null) {
            return;
        }
        if (Client.combatLock() >= 1) {
            return;
        }
        if (Client.airStuckCounter() >= 1) {
            return;
        }
        Entity self = Client.localPlayer();
        if (self != null && Client.attackCooldown(self) < 1.0) {
            return;
        }
        if (Client.findSlotWithItem(2) == -1) {
            return;
        }
        if (Client.findSlotWithItem(1) == -1) {
            return;
        }
        if (this.findTarget() == null) {
            return;
        }
        this.ready = Client.isAttackKeyClicked();
    }

    private void tickAction() {
        if (!this.ready) {
            return;
        }
        this.ready = false;
        if (!Client.inGame()) {
            return;
        }
        int spearSlot = Client.findSlotWithItem(2);
        int maceSlot = Client.findSlotWithItem(1);
        Entity target = this.findTarget();
        if (spearSlot == -1 || maceSlot == -1 || target == null) {
            return;
        }
        if (this.savedSlot == -1) {
            this.savedSlot = Client.selectedSlot();
        }
        Client.setSelectedSlot(spearSlot);
        Client.syncSelectedSlot();
        Client.setSelectedSlot(maceSlot);
        Client.resetAttackStrengthTicker(Client.localPlayer(), target);
    }

    private Entity findTarget() {
        return Client.findTargetEntity(this.reach());
    }

    private double reach() {
        Setting s = this.setting("reach");
        return s == null ? 4.5 : s.getNumber();
    }

    private Setting setting(String name) {
        for (Setting s : this.getSettings()) {
            if (!s.getName().equals(name)) continue;
            return s;
        }
        return null;
    }
}

