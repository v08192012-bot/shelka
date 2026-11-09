/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class AutoInteract
extends Feature {
    public static final String MODULE = "autointeract";
    public static final String DISPLAY = "\u0410\u0443\u0442\u043e\u0418\u043d\u0442\u0435\u0440\u0430\u0441\u0442";
    public static final int VTABLE_RVA = 12294808;
    private static final String FEATURE_INVIS = "invis";
    private static final String FEATURE_FOOD = "food";
    private static final int PHASE_IDLE = 0;
    private static final int PHASE_USE = 1;
    private static final int PHASE_HOLD = 2;
    private static final int PHASE_RELEASE = 3;
    private static final int PHASE_COOLDOWN = 4;
    private static final int TIMER_IDLE = 0;
    private static final int TIMER_DONE = 3;
    private static final int SLOT_MAIN_HAND = 8;
    private static final int HOTBAR_SIZE = 9;
    private static final int INVENTORY_OFFSET = 36;
    private static final int HOLD_LIMIT_TICKS = 60;
    private static final int MIN_HOLD_TICKS = 4;
    private static final int DEFAULT_USE_TICKS = 32;
    private static final int REUSE_COOLDOWN = 20;
    private int timerState;
    private int phase;
    private int lastSlot = -1;
    private int targetSlot = -1;
    private int holdTicks;
    private int cooldown;
    private boolean useKeyHeld;

    public AutoInteract() {
        super(MODULE, DISPLAY, Category.Player);
        this.add(Setting.mode("features", FEATURE_INVIS, FEATURE_INVIS, FEATURE_FOOD));
        this.add(Setting.number("invis_remaining", 0.0, 0.0, 20.0));
        this.add(Setting.number("min_food", 0.0, 0.0, 20.0));
    }

    @Override
    public void onEnable() {
        this.resetTimer();
        this.lastSlot = -1;
        this.phase = 0;
        this.holdTicks = 0;
        this.useKeyHeld = false;
    }

    @Override
    public void onDisable() {
        if (this.useKeyHeld) {
            Client.setUseKey(false);
        }
        if (this.targetSlot >= 0) {
            Client.restoreSlot();
        }
        this.resetTimer();
        this.lastSlot = -1;
        this.targetSlot = -1;
        this.phase = 0;
        this.holdTicks = 0;
        this.cooldown = 0;
        this.useKeyHeld = false;
    }

    @Override
    public void onTick() {
        this.advanceTimer();
        if (!Client.inGame() || Client.isPaused()) {
            if (this.phase == 0) {
                return;
            }
            if (this.useKeyHeld) {
                Client.setUseKey(false);
            }
            if (this.targetSlot >= 0) {
                Client.restoreSlot();
            }
            this.resetTimer();
            this.lastSlot = -1;
            this.holdTicks = 0;
            this.useKeyHeld = false;
            this.phase = 0;
            return;
        }
        Object player = Client.playerHandle();
        if (this.phase == 0) {
            if (this.cooldown > 0) {
                --this.cooldown;
                return;
            }
            int slot = -1;
            if (this.feature(FEATURE_INVIS)) {
                slot = Client.findInvisSlot();
            }
            if (slot == -1) {
                if (!this.feature(FEATURE_FOOD)) {
                    return;
                }
                if ((int)this.minFood() < Client.foodLevel(player)) {
                    return;
                }
                slot = Client.findFoodSlot();
                if (slot == -1) {
                    return;
                }
            }
            this.beginUse(slot);
            return;
        }
        if (this.phase == 1) {
            if (this.timerState != 0 && this.timerState != 3) {
                return;
            }
            int slot = this.lastSlot == -1 ? this.targetSlot : 8;
            Client.selectSlot(slot);
            Client.setUseKey(true);
            this.useKeyHeld = true;
            this.holdTicks = 0;
            this.phase = 2;
            return;
        }
        if (this.phase == 2) {
            boolean stalled;
            ++this.holdTicks;
            int useTicks = Client.itemUseTicks();
            boolean using = Client.isUsingItem();
            boolean finished = using && Client.itemUseRemaining() >= useTicks;
            boolean bl = stalled = !using && this.holdTicks > 4;
            if (!finished && !stalled && this.holdTicks < 60) {
                return;
            }
            this.phase = 3;
            return;
        }
        if (this.phase == 3) {
            int hotbar;
            Client.setUseKey(false);
            int slot = this.lastSlot;
            this.useKeyHeld = false;
            if (slot != -1) {
                int mapped = slot > 8 ? slot : slot + 36;
                this.scheduleTimer(mapped, 8);
                this.lastSlot = -1;
            }
            if ((hotbar = this.targetSlot) >= 0 && hotbar <= 8) {
                Client.swapHotbarSlot(hotbar);
            }
            Client.checkPendingException();
            this.targetSlot = -1;
            this.cooldown = 20;
            this.phase = 4;
            return;
        }
        if (this.phase != 4) {
            return;
        }
        if (this.timerState == 0 || this.timerState == 3) {
            this.phase = 0;
        }
    }

    private void beginUse(int slot) {
        this.lastSlot = slot;
        this.targetSlot = slot;
        this.resetTimer();
        this.phase = 1;
    }

    private void resetTimer() {
        this.timerState = 0;
    }

    private void advanceTimer() {
        if (this.timerState != 0) {
            this.timerState = 0;
        }
    }

    private void scheduleTimer(int slot, int duration) {
        this.timerState = 3;
    }

    private boolean feature(String id) {
        Setting setting = this.setting("features");
        return setting != null && id.equals(setting.getMode());
    }

    private double minFood() {
        Setting setting = this.setting("min_food");
        return setting == null ? 0.0 : setting.getNumber();
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }
}

