/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class SwapWheel
extends Feature {
    public static final String MODULE = "swapwheel";
    public static final String DISPLAY = "\u0417\u0448\u0430\u043f\u0428\u0445\u0435\u0435\u043b";
    public static final int VTABLE_RVA = 12328608;
    public static final long RVA_CONSTRUCT = 2735200370112L;
    public static final long RVA_ON_TICK = 2735200373504L;
    public static final long RVA_KEY_HANDLER = 2735200376512L;
    public static final long RVA_RENDER = 2735200376720L;
    public static final long RVA_HAS_SELECTION = 2735200366736L;
    public static final long RVA_ON_ENABLE = 2735200373168L;
    public static final long RVA_ON_DISABLE = 2735200373376L;
    public static final long RVA_WHEEL_CONSTRUCT = 2735200368304L;
    public static final long RVA_USE_FROM_BUNDLE = 2735200375920L;
    public static final long RVA_CELL_USE_CHECK = 2735200378256L;
    public static final long RVA_WHEEL_UPDATE = 2735200374416L;
    public static final long RVA_WHEEL_ACTIVATE = 2735200375344L;
    public static final long RVA_WHEEL_CLOSE = 2735200374864L;
    public static final long RVA_CURSOR_CELL = 2735200375104L;
    public static final long RVA_SLOT_FOR_CELL = 2735200375520L;
    public static final long RVA_CELL_MATCH = 2735200367344L;
    public static final long RVA_SELECT_USE_SLOT = 2735200611888L;
    public static final long RVA_COMMIT_SELECTION = 2735200612240L;
    private static final String KEY_SWAP_BIND = "wheel_swap_bind";
    private static final String KEY_SWAP_CELLS = "wheel_swap_cells";
    private static final String KEY_SWAP_COUNT = "wheel_swap_count";
    private static final String KEY_USE_BIND = "wheel_use_bind";
    private static final String KEY_USE_CELLS = "wheel_use_cells";
    private static final String KEY_USE_COUNT = "wheel_use_count";
    private static final String KEY_TRIGGER = "trigger";
    private static final String TRIGGER_TAP = "\u0422\u0430\u043f";
    private static final String TRIGGER_HOLD = "\u0425\u043e\u043b\u0434";
    private static final int WHEEL_NONE = 0;
    private static final int WHEEL_SWAP = 1;
    private static final int WHEEL_USE = 2;
    private static final int WHEELS = 2;
    private static final int CELLS = 6;
    private static final int HOTBAR_SLOTS = 9;
    private static final int INVENTORY_SLOTS = 36;
    private static final int MOUSE_LEFT = 1;
    private static final int MOUSE_RIGHT = 2;
    private static final double CELL_MASK_MAX = 511.0;
    private static final double COUNT_DEFAULT = 6.0;
    private static final double COUNT_MIN = 3.0;
    private static final double COUNT_MAX = 6.0;
    private static final int SLOT_NONE = -1;
    private static final int COUNT_NONE = -1;
    private static final int ACTION_MODE_SWAP = 0;
    private static final int ACTION_MODE_USE = 1;
    private static final int ACTION_MODE_SEQUENCE = 2;
    private static final int ACTION_MODE_FINISH = 3;
    private static final int ACTION_WAIT = 0;
    private static final float TAU = (float)Math.PI * 2;
    private static final float HALF = 0.5f;
    private static final float ONE = 1.0f;
    private static final float ZERO = 0.0f;
    private static final float SEGMENT_RADIUS = 38.0f;
    private static final float CELL_SCALE = 16.0f;
    private static final float RING_INSET = 92.0f;
    private static final int COLOR_SEGMENT = -1441195751;
    private static final int COLOR_SEGMENT_ACTIVE = -587214545;
    private static final int[][] BUNDLE_SEQUENCE = new int[][]{{-1, -1, 2}, {-1, -1, 1}, {-1, -1, 3}};
    private int activeWheel;
    private int activeIndex = -1;
    private int pendingWheel;
    private int pendingIndex = -1;
    private boolean selectionActive;
    private int selectionSlot = -1;
    private int selectionItem = -1;
    private int selectionField = -1;
    private int selectionAux = -1;
    private boolean selectionFlag;
    private boolean swapButtonDown;
    private boolean useButtonDown;
    private boolean playerUsingCleared;

    public SwapWheel() {
        super(MODULE, DISPLAY, Category.Player);
        this.add(Setting.key(KEY_SWAP_BIND, 0));
        this.add(Setting.number(KEY_SWAP_CELLS, 0.0, 0.0, 511.0));
        this.add(Setting.number(KEY_SWAP_COUNT, 6.0, 3.0, 6.0));
        this.add(Setting.key(KEY_USE_BIND, 0));
        this.add(Setting.number(KEY_USE_CELLS, 0.0, 0.0, 511.0));
        this.add(Setting.number(KEY_USE_COUNT, 6.0, 3.0, 6.0));
        this.add(Setting.mode(KEY_TRIGGER, TRIGGER_TAP, TRIGGER_TAP, TRIGGER_HOLD));
        Client.setWheelCellCount(1, this.cellCount(KEY_SWAP_COUNT));
        Client.setWheelCellCount(2, this.cellCount(KEY_USE_COUNT));
    }

    public boolean isActive() {
        return this.activeWheel != 0;
    }

    @Override
    public void onEnable() {
        Client.handHoldRelease(this);
        this.activeIndex = -1;
        this.clearSelection();
        for (int wheel = 1; wheel <= 2; ++wheel) {
            Client.clearWheelCellKeys(wheel);
        }
    }

    @Override
    public void onDisable() {
        this.closeWheel();
        this.pendingWheel = 0;
        this.pendingIndex = -1;
        this.clearSelection();
        this.activeIndex = -1;
        Client.handHoldRelease(this);
    }

    @Override
    public void onTick() {
        int index;
        Client.handHoldTick(this);
        if (!Client.inGame()) {
            this.closeWheel();
            this.activeIndex = -1;
            this.clearSelection();
            Client.handHoldRelease(this);
            return;
        }
        if (this.selectionActive) {
            boolean kept = false;
            index = this.activeIndex;
            if (index >= 0 && index < 6) {
                kept = Client.wheelCellBindHeld(2, index);
            }
            if (!kept && Client.handHoldIdle(this)) {
                if (index >= 0) {
                    Object item;
                    Object cell;
                    if (!Client.isScreenOpen() && Client.wheelCellMatchesStack(cell = Client.wheelAt(2, index), item = Client.stackItem(Client.heldSlotStack()))) {
                        Client.useHeldItem(item);
                    }
                    this.activeIndex = -1;
                }
                this.commitSelection();
            }
        }
        this.updateWheel(1);
        this.updateWheel(2);
        if (this.pendingWheel != 0) {
            int wheel = this.pendingWheel;
            index = this.pendingIndex;
            this.pendingWheel = 0;
            this.pendingIndex = -1;
            this.activateCell(wheel, index);
        }
        if (this.activeWheel != 0 && Client.isScreenOpen()) {
            this.closeWheel();
        }
        boolean screenOpen = Client.isScreenOpen();
        for (int wheel = 1; wheel <= 2; ++wheel) {
            for (int cell = 0; cell < 6; ++cell) {
                int key = Client.wheelCellBindKey(wheel, cell);
                if (key == 0 || !Client.wheelCellKeyClicked(wheel, cell, key, Client.wheelCellBindModifiers(wheel, cell)) || screenOpen || cell >= Client.wheelCellCount(wheel)) continue;
                if (!this.holdTrigger() || wheel != 2) {
                    this.activateCell(wheel, cell);
                    continue;
                }
                Object useCell = Client.wheelAt(2, cell);
                if (Client.wheelCellEmpty(useCell) || !Client.handHoldIdle(this) || this.selectionActive) continue;
                int slot = Client.findSlotForWheelCell(useCell);
                if (slot == -1) {
                    if (!this.useFromBundle(useCell, false)) continue;
                    this.activeIndex = cell;
                    continue;
                }
                this.selectUseSlot(slot);
                this.activeIndex = cell;
            }
        }
    }

    public void onMouseState() {
        boolean cancel;
        boolean commit;
        boolean blocked = Client.mouseInputBlocked();
        if (this.activeWheel == 0) {
            return;
        }
        if (Client.mouseButtonDown(1) && !this.swapButtonDown) {
            this.swapButtonDown = true;
            commit = !blocked;
        } else {
            this.swapButtonDown = Client.mouseButtonDown(1);
            commit = false;
        }
        if (Client.mouseButtonDown(2) && !this.useButtonDown) {
            this.useButtonDown = true;
            cancel = !blocked;
        } else {
            this.useButtonDown = Client.mouseButtonDown(2);
            cancel = false;
        }
        if (commit) {
            int index = Client.hoveredWheelCell(this.activeWheel, Client.wheelCellCount(this.activeWheel));
            if (this.activeWheel != 0 && index >= 0) {
                this.pendingWheel = this.activeWheel;
                this.pendingIndex = index;
                this.closeWheel();
                return;
            }
        } else if (!cancel) {
            return;
        }
        this.closeWheel();
    }

    @Override
    public void onRender() {
        int index;
        if (this.activeWheel == 0) {
            return;
        }
        int count = Client.wheelCellCount(this.activeWheel);
        float height = Client.guiHeight();
        if (0.0f >= height) {
            return;
        }
        float scaleX = Client.windowPixelWidth() / height * 0.5f;
        float scaleY = Client.windowPixelHeight() / height * 0.5f;
        float mirroredX = -scaleX;
        float mirroredY = -scaleY;
        float insetX = scaleX - 92.0f;
        float insetY = scaleY - 92.0f;
        float segments = count;
        float step = 1.0f / segments;
        int hovered = Client.hoveredWheelCell(this.activeWheel, count);
        float[] cellRect = new float[]{height, 0.0f, 0.0f, height};
        for (index = 0; index < count; ++index) {
            float angle = (float)index * ((float)Math.PI * 2) / segments;
            float cos = (float)Math.cos(angle);
            float sin = (float)Math.sin(angle);
            int color = index == hovered ? -587214545 : -1441195751;
            float x1 = sin * height + cos * 0.0f;
            float y1 = cos * 0.0f - sin * height;
            float x2 = sin * 0.0f + cos * height;
            float y2 = cos * height - sin * 0.0f;
            float anchorX = mirroredY * y1 + mirroredX * x2 + insetY * 0.0f + insetX * height + 0.0f;
            float anchorY = mirroredY * y2 + mirroredX * x1 + insetX * 0.0f + height * insetY + 0.0f;
            Client.drawWheelSegment(new float[]{x1, y1, x2, y2}, anchorX, anchorY, 38.0f, step, color);
        }
        for (index = 0; index < count; ++index) {
            Object cell;
            Object object = cell = index < 6 ? Client.wheelAt(this.activeWheel, index) : null;
            if (cell == null || Client.wheelCellEmpty(cell)) continue;
            float angle = ((float)index + 0.5f) * ((float)Math.PI * 2) / segments;
            Client.drawWheelCell(cellRect, this.activeWheel, index, angle, 16.0f, 1.0f);
        }
    }

    public boolean useFromBundle(Object cell, boolean fillState) {
        int slot;
        CellUseMatcher matcher = new CellUseMatcher(cell);
        Object inventory = Client.playerInventory();
        boolean found = false;
        if (inventory != null) {
            for (slot = 9; slot < 36 && !found; ++slot) {
                found = this.matchInventorySlot(inventory, slot, matcher);
            }
            if (!found) {
                for (slot = 0; slot < 9 && !found; ++slot) {
                    found = this.matchInventorySlot(inventory, slot, matcher);
                }
            }
        }
        if ((slot = matcher.matchedSlot()) == -1) {
            return false;
        }
        int itemId = matcher.matchedItemId();
        int selected = Client.selectedSlot();
        int selectedItem = Client.slotItemId(selected);
        boolean empty = Client.slotEmpty(selected);
        Client.stageBundleUse(this, slot, itemId, selected, selectedItem, empty);
        if (!fillState) {
            if (slot >= 0) {
                Client.handHoldPushActions(this, BUNDLE_SEQUENCE);
            }
            return true;
        }
        this.selectionActive = true;
        this.selectionItem = selected;
        this.selectionSlot = -1;
        this.selectionField = slot;
        this.selectionAux = selectedItem;
        if (slot >= 0) {
            Client.handHoldPushAction(this, -1, -1, 2);
        }
        this.selectionFlag = empty;
        return true;
    }

    public CellUseMatcher cellUseCheck(Object cell) {
        return new CellUseMatcher(cell);
    }

    private boolean matchInventorySlot(Object inventory, int slot, CellUseMatcher matcher) {
        int itemId = Client.inventoryItemIdForCell(inventory, slot, matcher.cell());
        if (itemId < 0) {
            return false;
        }
        matcher.accept(slot, itemId);
        return true;
    }

    private void updateWheel(int wheel) {
        if (!Client.isWheelKeyHeld(wheel)) {
            if (Client.wheelIsOpen(wheel) && this.activeWheel == wheel) {
                int index = Client.hoveredWheelCell(wheel, Client.wheelCellCount(wheel));
                if (this.activeWheel != 0 && index >= 0) {
                    this.pendingWheel = this.activeWheel;
                    this.pendingIndex = index;
                }
                this.closeWheel();
            }
            Client.setWheelOpen(wheel, false);
            return;
        }
        if (!Client.wheelIsOpen(wheel) && this.activeWheel == 0 && !Client.isScreenOpen()) {
            this.activeWheel = wheel;
            this.swapButtonDown = Client.mouseButtonDown(1);
            this.useButtonDown = Client.mouseButtonDown(2);
            if (!this.playerUsingCleared) {
                this.playerUsingCleared = true;
                Client.clearPlayerUsingState();
            }
        }
        Client.setWheelOpen(wheel, true);
    }

    private void activateCell(int wheel, int index) {
        Object cell = Client.wheelAt(wheel, index);
        if (Client.wheelCellEmpty(cell)) {
            return;
        }
        if (!Client.handHoldIdle(this) || this.selectionActive) {
            return;
        }
        int slot = Client.findSlotForWheelCell(cell);
        if (slot == -1) {
            if (wheel == 2) {
                this.useFromBundle(cell, false);
            }
            return;
        }
        if (wheel == 2) {
            Client.handHoldUseSlot(this, slot, 0);
            return;
        }
        Client.handHoldSwapSlot(this, slot);
    }

    private void selectUseSlot(int slot) {
        int selected;
        this.selectionActive = true;
        this.selectionItem = selected = Client.selectedSlot();
        if (slot < 9) {
            this.selectionSlot = -1;
            Client.selectHotbarSlot(slot);
            return;
        }
        this.selectionSlot = slot;
        if (selected < 9) {
            Client.handHoldPushAction(this, slot, 0, 0);
        }
    }

    private void commitSelection() {
        Client.handHoldCommitSelection(this, this.selectionSlot, this.selectionItem, this.selectionField, this.selectionAux, this.selectionFlag);
        this.clearSelection();
    }

    private void clearSelection() {
        this.selectionActive = false;
        this.selectionSlot = -1;
        this.selectionItem = -1;
        this.selectionField = -1;
        this.selectionAux = -1;
        this.selectionFlag = false;
    }

    private void closeWheel() {
        this.activeWheel = 0;
        if (this.playerUsingCleared) {
            this.playerUsingCleared = false;
            if (!Client.isScreenOpen()) {
                Client.clearPlayerUsingState();
            }
        }
    }

    private int cellCount(String key) {
        int value = (int)this.number(key);
        if (value < 3) {
            return 3;
        }
        if (value > 6) {
            return 6;
        }
        return value;
    }

    private boolean holdTrigger() {
        return TRIGGER_HOLD.equals(this.mode(KEY_TRIGGER));
    }

    private double number(String key) {
        Setting setting = this.setting(key);
        return setting == null ? 0.0 : setting.getNumber();
    }

    private String mode(String key) {
        Setting setting = this.setting(key);
        return setting == null ? "" : setting.getMode();
    }

    private Setting setting(String key) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(key)) continue;
            return setting;
        }
        return null;
    }

    public static final class CellUseMatcher {
        private final Object cell;
        private int slot = -1;
        private int itemId = -1;

        CellUseMatcher(Object cell) {
            this.cell = cell;
        }

        public Object cell() {
            return this.cell;
        }

        public void accept(int slotIndex, int stackItemId) {
            this.slot = slotIndex;
            this.itemId = stackItemId;
        }

        public int matchedSlot() {
            return this.slot;
        }

        public int matchedItemId() {
            return this.itemId;
        }
    }
}

