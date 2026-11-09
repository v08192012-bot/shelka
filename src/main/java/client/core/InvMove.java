/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class InvMove
extends Feature {
    public static final String MODULE = "invmove";
    public static final int VTABLE_RVA = 12289520;
    private static final int RING_SIZE = 8;
    private static final int HOLD_LIMIT = 4;
    private static final int CLOSE_DELAY = 2;
    private static final int OVERFLOW_LIMIT = 3;
    private static InvMove instance;
    private static int activeContainers;
    private static boolean closePending;
    private static boolean overflowed;
    private final int[] ringIds = new int[8];
    private final int[] ringFirst = new int[8];
    private final int[] ringSecond = new int[8];
    private final Object[] ringRefs = new Object[8];
    private int ringIndex;
    private int pushIndex;
    private int containerId = -1;
    private boolean active;
    private boolean replayGuard;
    private int holdCounter;
    private int closeTimer;

    public InvMove() {
        super(MODULE, "", Category.Movement);
        this.add(Setting.bool("in_inventory", true));
        this.add(Setting.bool("in_gui", false));
    }

    @Override
    public void onEnable() {
        instance = this;
        this.reset();
    }

    @Override
    public void onDisable() {
        instance = null;
        this.reset();
    }

    @Override
    public void onTick() {
        int index;
        if (!Client.inGame()) {
            this.reset();
            return;
        }
        if (InvMove.wrap(this.pushIndex - this.ringIndex) == 0 && !this.active && this.containerId < 0) {
            return;
        }
        boolean inputDown = Client.isJumpKeyDown();
        if (!(this.active || InvMove.wrap(this.pushIndex - this.ringIndex) <= 0 && this.containerId < 0)) {
            this.active = true;
            closePending = false;
            if (++activeContainers > 3 && !overflowed) {
                overflowed = true;
            }
            Client.installTickHook();
        }
        if (activeContainers < 1) {
            if (closePending) {
                Client.uninstallTickHook();
            }
        } else {
            Client.installTickHook();
        }
        if (InvMove.wrap(this.pushIndex - (index = this.ringIndex)) <= 0) {
            if (this.containerId < 0) {
                if (this.closeTimer > 0) {
                    --this.closeTimer;
                    if (this.closeTimer > 0) {
                        return;
                    }
                }
                this.active = false;
                if (activeContainers > 0) {
                    --activeContainers;
                }
                if (activeContainers != 0) {
                    return;
                }
                Client.uninstallTickHook();
                return;
            }
            if (inputDown || this.holdCounter > 4) {
                this.holdCounter = 0;
                Client.closeContainer();
                this.containerId = -1;
                this.closeTimer = 2;
                return;
            }
        } else if (inputDown || this.holdCounter > 4) {
            this.holdCounter = 0;
            this.closeTimer = 2;
            this.ringIndex = InvMove.wrap(index + 1);
            this.replay(index);
            return;
        }
        ++this.holdCounter;
    }

    private void replay(int index) {
        if (this.ringIds[index] == Client.containerSyncId()) {
            this.replayGuard = true;
            Client.replayContainerAction(this.ringIds[index], this.ringFirst[index], this.ringSecond[index], this.ringRefs[index]);
            this.replayGuard = false;
        }
        this.ringRefs[index] = null;
    }

    public static boolean queue(int first, int second, int third, Object reference) {
        InvMove module = instance;
        if (module == null || !module.isEnabled()) {
            return false;
        }
        if (!Client.containerScreenOpen()) {
            return false;
        }
        if (activeContainers >= 1) {
            return false;
        }
        if (module.replayGuard) {
            return false;
        }
        int index = module.pushIndex;
        int next = InvMove.wrap(index + 1);
        if (next == module.ringIndex) {
            return false;
        }
        module.ringIds[index] = first;
        module.ringFirst[index] = second;
        module.ringSecond[index] = third;
        module.ringRefs[index] = reference;
        if (module.ringRefs[index] == null) {
            return false;
        }
        module.pushIndex = next;
        return true;
    }

    public static InvMove instance() {
        return instance;
    }

    private void reset() {
        for (int i = 0; i < 8; ++i) {
            this.ringRefs[i] = null;
        }
        this.ringIndex = 0;
        this.pushIndex = 0;
        if (this.containerId >= 0) {
            Client.closeContainer();
            this.containerId = -1;
        }
        this.holdCounter = 0;
        this.closeTimer = 0;
        if (this.active) {
            this.active = false;
            if (activeContainers > 0) {
                --activeContainers;
            }
            if (activeContainers == 0) {
                Client.uninstallTickHook();
            }
        }
    }

    private static int wrap(int value) {
        return value % 8;
    }
}

