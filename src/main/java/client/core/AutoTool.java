/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import client.mc.Entity;

public final class AutoTool
extends Feature {
    public static final String MODULE = "autotool";
    public static final String DISPLAY = "\u0410\u0443\u0442\u043e\u0422\u043e\u043e\u043b";
    public static final int VTABLE_RVA = 12310984;
    public static final long RVA_SELECT_TOOL = 2735200254272L;
    public static final long RVA_ON_TICK = 2735200254720L;
    public static final long RVA_ON_DISABLE = 2735200255040L;
    private static final int HOTBAR_SIZE = 9;
    private static final int HOTBAR_OFFSET = 36;
    private static final int MINING_IDLE_LIMIT = 10;
    private boolean mining;
    private int cooldown;
    private int toolMode;
    private int bestSlot = -1;
    private int bestSlotCurrent = -1;
    private int previousSelected = -1;
    private int previousSlot = -1;
    private int previousBestCurrent = -1;

    public AutoTool() {
        super(MODULE, DISPLAY, Category.Player);
        this.add(Setting.bool("prevent_break", true));
    }

    @Override
    public void onTick() {
        this.selectTool();
        this.applyTool();
    }

    @Override
    public void onDisable() {
        Client.resetToolSwitcher();
        if (Client.inGame() && this.previousSelected != -1) {
            Client.selectSlot(this.previousSelected);
        }
        this.mining = false;
        this.cooldown = 0;
        this.bestSlot = -1;
        this.bestSlotCurrent = -1;
        this.previousSelected = -1;
        this.previousSlot = -1;
        this.previousBestCurrent = -1;
    }

    private void selectTool() {
        Entity player = Client.player();
        if (Client.inGame() && !Client.isSpectator(player) && !Client.isScreenOpen() && Client.isMining() && Client.canMine()) {
            Object blockState;
            Object hit;
            this.mining = true;
            if ((this.toolMode == 0 || this.toolMode == 3) && this.previousSlot == -1 && this.bestSlot == -1 && Client.canMine() && (hit = Client.raycastTarget()) != null && player != null && (blockState = Client.blockState(player, hit)) != null) {
                if (this.previousSelected == -1) {
                    this.previousSelected = Client.selectedSlot();
                }
                int current = Client.selectedSlot();
                int best = Client.findBestTool(blockState);
                if (best != -1 && best != current) {
                    if (best > 8) {
                        this.bestSlot = best;
                        this.bestSlotCurrent = current;
                        return;
                    }
                    Client.selectSlot(best);
                }
            }
            return;
        }
        this.mining = false;
    }

    private void applyTool() {
        Client.updateToolState();
        if (!Client.inGame()) {
            this.bestSlot = -1;
            this.bestSlotCurrent = -1;
            return;
        }
        if (this.mining) {
            this.cooldown = 0;
            if ((this.toolMode == 0 || this.toolMode == 3) && this.bestSlot != -1) {
                if (this.previousSlot == -1) {
                    this.previousSlot = this.bestSlot;
                    this.previousBestCurrent = this.bestSlotCurrent;
                    if (this.bestSlotCurrent < 9) {
                        int target = this.bestSlot > 8 ? this.bestSlot : this.bestSlot + 36;
                        Client.selectToolSlot(target);
                    }
                }
                this.bestSlot = -1;
                this.bestSlotCurrent = -1;
            }
            return;
        }
        this.bestSlot = -1;
        this.bestSlotCurrent = -1;
        if (this.previousSlot == -1 && this.previousSelected == -1) {
            this.restoreTool();
            return;
        }
        if (Client.isMining() && this.cooldown < 10 && Client.isBreakKeyIdle()) {
            ++this.cooldown;
            return;
        }
        this.cooldown = 0;
        this.restoreTool();
    }

    private void restoreTool() {
        if (this.toolMode == 0 || this.toolMode == 3) {
            if (Client.inGame() && this.previousSlot != -1 && this.previousBestCurrent != -1) {
                Client.restoreToolSlot();
            }
            this.previousSlot = -1;
            this.previousBestCurrent = -1;
            if (Client.inGame() && this.previousSelected != -1) {
                Client.selectSlot(this.previousSelected);
            }
            this.previousSelected = -1;
        }
    }
}

