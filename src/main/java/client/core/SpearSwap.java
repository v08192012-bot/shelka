/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class SpearSwap
extends Feature {
    public static final String MODULE = "spearswap";
    public static final int VTABLE_RVA = 12281576;
    public static final int TICK_RVA = 403040;
    public static final int DISABLE_RVA = 402976;
    public static final int FIND_LUNGE_RVA = 404080;
    public static final int RESTORE_SAVED_RVA = 403984;
    public static final String MSG_NO_LUNGE_SPEAR = "\u041a\u043e\u043f\u044c\u0451 \u0441 \u0412\u044b\u043f\u0430\u0434\u043e\u043c \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d\u043e";
    public static final String MSG_LUNGE = "\u0412\u044b\u043f\u0430\u0434";
    private static final int HOTBAR_SLOTS = 8;
    private static final int HOLD_COUNTER_TICKS = 15;
    private static final int LOCK_VALUE = 2;
    private static final float ATTACK_READY = 1.0f;
    private static final int SLOT_NONE = -1;
    private int savedSlot = -1;
    private int holdCounter;
    private int lastLungeSlot = -1;
    private int tickCounter;

    public SpearSwap() {
        super(MODULE, "\u0417\u043f\u0435\u0430\u0440\u0417\u0448\u0430\u043f", Category.Combat);
        this.add(Setting.key("lunge_bind", 0));
        this.add(Setting.number("hold_ticks", 3.0, 0.0, 20.0));
    }

    @Override
    public void onDisable() {
        if (Client.inGame()) {
            this.restoreSaved();
        }
        this.holdCounter = 0;
        this.savedSlot = -1;
    }

    @Override
    public void onTick() {
        int lungeSlot;
        boolean hasLunge = Client.hasLungeSpear();
        if (!Client.inGame()) {
            this.savedSlot = -1;
            this.holdCounter = 0;
            return;
        }
        if (this.savedSlot != -1) {
            ++this.tickCounter;
            if (this.tickCounter >= (int)this.holdTicks()) {
                if (Client.selectedSlot() == this.lastLungeSlot) {
                    int slot = this.savedSlot;
                    if (slot < 9) {
                        Client.setSelectedSlotReflective(slot);
                    }
                    if (Client.combatLock() < 2) {
                        Client.setCombatLock(2);
                    }
                }
                this.savedSlot = -1;
            }
        }
        if (hasLunge && !Client.isScreenOpen()) {
            lungeSlot = Client.findSlotWithLungeSpear();
            if (lungeSlot == -1) {
                Client.notifyMissingLungeSpear(MSG_NO_LUNGE_SPEAR, MSG_LUNGE);
                return;
            }
            this.holdCounter = 15;
        }
        if (this.holdCounter == 0) {
            return;
        }
        --this.holdCounter;
        if (Client.isScreenOpen()) {
            return;
        }
        if (Client.combatLock() >= 1) {
            return;
        }
        if (Client.airStuckCounter() >= 1) {
            return;
        }
        if (Client.attackCooldown(Client.localPlayer()) < 1.0) {
            return;
        }
        lungeSlot = Client.findSlotWithLungeSpear();
        this.holdCounter = 0;
        if (lungeSlot == -1) {
            return;
        }
        if (Client.selectedSlot() != lungeSlot) {
            if (this.savedSlot == -1) {
                this.savedSlot = Client.selectedSlot();
            }
            this.lastLungeSlot = lungeSlot;
            this.tickCounter = 0;
            Client.setSelectedSlot(lungeSlot);
            if (Client.combatLock() < 2) {
                Client.setCombatLock(2);
            }
        }
        Client.performLungeAttack();
    }

    private void restoreSaved() {
        if (this.savedSlot == -1) {
            return;
        }
        if (Client.selectedSlot() == this.lastLungeSlot) {
            Client.setSelectedSlot(this.savedSlot);
            if (Client.combatLock() < 2) {
                Client.setCombatLock(2);
            }
        }
        this.savedSlot = -1;
    }

    private double holdTicks() {
        Setting s = this.setting("hold_ticks");
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

