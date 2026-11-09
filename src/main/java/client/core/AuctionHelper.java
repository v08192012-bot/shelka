/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class AuctionHelper
extends Feature {
    public static final String MODULE = "auction_helper";
    public static final String DISPLAY = "\u0410\u0443\u0441\u0442\u0438\u043e\u043d\u0425\u0435\u043b\u043f\u0435\u0440";
    public static final int VTABLE_RVA = 12329408;
    public static final long RVA_ON_TICK = 2735200389232L;
    public static final long RVA_ON_MOUSE = 2735200396544L;
    public static final long RVA_RESET = 2735200389104L;
    private static final int NO_SLOT = -1;
    private static final int AUCTION_FILLER_SLOTS = 36;
    private static final int CYCLE_LIMIT = 19;
    private static final int HASH_MULTIPLIER = 31;
    private static final int CLICK_COOLDOWN_TICKS = 4;
    private static AuctionHelper active;
    private int hoverSlot = -1;
    private int pendingSlot = -1;
    private boolean screenActive;
    private boolean cardsDirty;
    private int screenId;
    private int lastSyncId;
    private int cycleCounter;
    private int lastItemHash;
    private int slotCount;
    private boolean rightButtonDown;
    private int pendingClickSlot = -1;
    private int pendingClickSyncId;
    private int clickCooldown;

    public AuctionHelper() {
        super(MODULE, DISPLAY, Category.Render);
        this.add(Setting.mode("highlight", "Both", "None", "Plate", "Box", "Both"));
        this.add(Setting.bool("options", true));
        this.add(Setting.gradient("colors", -10496, -16711936));
        this.add(Setting.bool("panel", true));
        this.add(Setting.bool("filters", false));
        this.add(Setting.bool("armor", false));
        this.add(Setting.bool("sword", false));
        this.add(Setting.bool("mace", false));
    }

    public static AuctionHelper active() {
        return active;
    }

    public boolean screenActive() {
        return this.screenActive;
    }

    public boolean cardsDirty() {
        return this.cardsDirty;
    }

    public boolean rightButtonDown() {
        return this.rightButtonDown;
    }

    public int hoverSlot() {
        return this.hoverSlot;
    }

    public void setHoverSlot(int value) {
        this.hoverSlot = value;
    }

    public int pendingSlot() {
        return this.pendingSlot;
    }

    public void setPendingSlot(int value) {
        this.pendingSlot = value;
    }

    public int screenId() {
        return this.screenId;
    }

    public int lastSyncId() {
        return this.lastSyncId;
    }

    public int cycleCounter() {
        return this.cycleCounter;
    }

    public int lastItemHash() {
        return this.lastItemHash;
    }

    public void setLastItemHash(int value) {
        this.lastItemHash = value;
    }

    public int slotCount() {
        return this.slotCount;
    }

    public int pendingClickSlot() {
        return this.pendingClickSlot;
    }

    public int pendingClickSyncId() {
        return this.pendingClickSyncId;
    }

    public void setPendingClickSlot(int value) {
        this.pendingClickSlot = value;
    }

    public int clickCooldown() {
        return this.clickCooldown;
    }

    public void resetState() {
        this.hoverSlot = -1;
        this.pendingSlot = -1;
        this.cardsDirty = false;
        this.screenActive = false;
        this.lastSyncId = -1;
        this.clickCooldown = 0;
        this.pendingClickSlot = -1;
    }

    @Override
    public void onEnable() {
        this.resetState();
        active = this;
    }

    @Override
    public void onDisable() {
        this.resetState();
        active = null;
    }

    @Override
    public void onTick() {
        boolean cycleEnded;
        int visible;
        boolean auction;
        boolean wasActive = this.screenActive;
        boolean containerOpen = Client.containerScreenOpen();
        String title = containerOpen ? Client.openScreenTitle() : "";
        this.screenActive = auction = Client.isAuctionScreen(title);
        if (!auction) {
            this.resetState();
            return;
        }
        this.screenId = Client.openScreenId();
        Client.auctionSearchText(this);
        if (!wasActive) {
            this.slotCount = Client.containerSize() + 24;
            Client.auctionOpenSearch(this);
        }
        if ((visible = Client.containerSize() - 36) < 1) {
            this.pendingSlot = -1;
            return;
        }
        int syncId = Client.containerSyncId();
        int previousSyncId = this.lastSyncId;
        this.lastSyncId = syncId;
        ++this.cycleCounter;
        boolean bl = cycleEnded = 19 < this.cycleCounter;
        if (cycleEnded) {
            this.cycleCounter = 0;
        }
        int hash = visible;
        for (int index = 0; index < visible; ++index) {
            hash = Client.auctionSlotItemId(this, index) + hash * 31;
        }
        if (hash == this.lastItemHash) {
            if (cycleEnded || syncId != previousSyncId) {
                Client.auctionRebuildCards(this);
            }
        } else {
            this.lastItemHash = hash;
            Client.auctionRebuildCards(this);
        }
        if (this.clickCooldown > 0) {
            --this.clickCooldown;
        }
        int slot = this.pendingClickSlot;
        this.pendingClickSlot = -1;
        if (slot >= 0 && this.pendingClickSyncId == syncId && slot < visible && Client.slotPresent(slot)) {
            Client.clickSlot(slot, 0);
            this.clickCooldown = 4;
            Client.auctionClearPending(this);
        }
    }

    public void onMouseState() {
        boolean pressed;
        int raw = Client.rawKeyState();
        boolean bl = pressed = raw < 0;
        if (pressed && !this.rightButtonDown) {
            boolean first = !Client.mouseConsumed();
            this.rightButtonDown = true;
            if (first) {
                this.handleMouse(1L);
                return;
            }
        } else {
            this.rightButtonDown = false;
        }
        this.handleMouse(0L);
    }

    private void handleMouse(long argument) {
        boolean wasDirty = this.cardsDirty;
        this.cardsDirty = false;
        if (!this.screenActive) {
            return;
        }
        if (!Client.containerScreenOpen()) {
            return;
        }
        if (Client.panelEnabled(this)) {
            Client.auctionBuildPanel(this, argument);
        }
        if (!(wasDirty || this.pendingSlot < 0 && this.hoverSlot < 0)) {
            Client.auctionClickCard(this, 0);
        }
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }
}

