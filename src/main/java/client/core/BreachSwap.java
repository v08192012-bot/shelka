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

public final class BreachSwap
extends Feature {
    public static final String MODULE = "breachswap";
    public static final int VTABLE_RVA = 12277472;
    public static final int RESTORE_RVA = 448016;
    public static final int FIND_AND_SWAP_RVA = 447536;
    public static final int DISABLE_RVA = 448560;
    private static final int HOTBAR_SLOTS = 8;
    private static final int RESTORE_DELAY_CALLS = 2;
    private static final int SLOT_NONE = -1;
    private int savedSlot = -1;
    private int restoreDelay;

    public BreachSwap() {
        super(MODULE, "\u0411\u0440\u0435\u0430\u0441\u0445\u0417\u0448\u0430\u043f", Category.Combat);
        this.add(Setting.bool("sword_only", true));
    }

    @Override
    public void onDisable() {
        if (Client.inGame() && this.savedSlot != -1) {
            Client.setSelectedSlot(this.savedSlot);
            this.restoreDelay = 0;
        }
        this.savedSlot = -1;
    }

    @Override
    public void onTick() {
        this.restore();
        this.findAndSwap();
    }

    private void restore() {
        if (this.savedSlot == -1) {
            return;
        }
        if (!Client.inGame()) {
            this.savedSlot = -1;
            return;
        }
        ++this.restoreDelay;
        if (this.restoreDelay < 2) {
            return;
        }
        int slot = this.savedSlot;
        if (slot == -1) {
            return;
        }
        if (slot > 8) {
            this.savedSlot = -1;
            this.restoreDelay = 0;
            return;
        }
        Client.setSelectedSlotReflective(slot);
        this.savedSlot = -1;
        this.restoreDelay = 0;
    }

    private void findAndSwap() {
        if (this.savedSlot != -1) {
            return;
        }
        Entity raw = Client.player();
        if (raw == null) {
            return;
        }
        Entity self = Client.resolvePlayer(raw);
        if (self == null) {
            return;
        }
        if (this.swordOnly() && !Client.isHoldingSword(self)) {
            return;
        }
        for (int slot = 0; slot <= 8; ++slot) {
            ItemStack stack = Client.itemAtSlot(slot);
            if (stack == null || !Client.isMaceItem(stack)) continue;
            if (slot == -1) {
                return;
            }
            if (slot == Client.selectedSlot()) {
                return;
            }
            this.savedSlot = Client.selectedSlot();
            this.restoreDelay = 0;
            Client.setSelectedSlot(slot);
            return;
        }
    }

    private boolean swordOnly() {
        Setting s = this.setting("sword_only");
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

