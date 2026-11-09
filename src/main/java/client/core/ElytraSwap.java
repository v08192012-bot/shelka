/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class ElytraSwap
extends Feature {
    public static final String MODULE = "elytraswap";
    public static final int VTABLE_RVA = 12288032;
    private static final int STATE_IDLE = 0;
    private static final int STATE_RUNNING = 1;
    private static final int STATE_WAIT = 2;
    private static final int STATE_DONE = 3;
    private static final int STATE_USE = 4;
    private static final int STATE_RELEASE = 5;
    private static final int MAX_BIND_SLOT = 8;
    private static final int SLOT_OFFSET = 36;
    private static final int NO_TARGET = -1;
    public static int tickHookRefs;
    private int action = 0;
    private int actionStep;
    private int actionSteps;
    private int targetId = -1;
    private int waitTicks;
    private boolean armed;
    private boolean refCounted;
    private boolean swapKeyDown;
    private boolean fireworkKeyDown;

    public ElytraSwap() {
        super(MODULE, "", Category.Movement);
        this.add(Setting.key("swap_bind", 0));
        this.add(Setting.key("firework_bind", 0));
    }

    @Override
    public void onDisable() {
        this.cancelAction();
    }

    @Override
    public void onTick() {
        this.updateAction();
        this.swapKeyDown = Client.isBindDown(this.bind("swap_bind"), 0);
        this.fireworkKeyDown = Client.isBindDown(this.bind("firework_bind"), 0);
        if (!Client.inGame()) {
            return;
        }
        if (Client.isScreenOpen()) {
            return;
        }
        if (this.action != 0 && this.action != 3) {
            return;
        }
        if (!this.swapKeyDown) {
            if (this.fireworkKeyDown) {
                this.performFirework();
            }
            return;
        }
        this.performSwap();
    }

    private void updateAction() {
        if (this.action == 0) {
            return;
        }
        if (!Client.inGame()) {
            this.armed = false;
            this.action = 0;
            this.releaseRefCount();
            return;
        }
        if (this.action == 4) {
            Client.swingMainHand();
            this.action = 5;
            return;
        }
        if (this.action == 5) {
            Client.releaseAttack(this.targetId);
            this.targetId = -1;
            this.armed = true;
        } else if (this.action != 3) {
            Client.stepAction(this.action, this.actionStep, this.actionSteps, this.targetId);
        }
        this.action = 0;
        this.releaseRefCount();
    }

    private void performSwap() {
        int slot = Client.swapBindResult();
        if (slot < 0) {
            slot = Client.swapBindSlot();
            if (slot < 0) {
                return;
            }
            if (slot < 8) {
                slot += 36;
            }
        } else if (8 < slot) {
            return;
        }
        Client.pushActionStep(slot, 6, 0, 0);
    }

    private void performFirework() {
        int slot = Client.fireworkBindResult();
        if (slot < 0) {
            int alternative = Client.fireworkBindSlot();
            if (alternative < 0) {
                return;
            }
            Client.startFireworkAction(alternative, 0);
            return;
        }
        if (this.action != 0 && this.action != 3) {
            return;
        }
        if (!Client.inGame()) {
            return;
        }
        if (8 < slot) {
            return;
        }
        this.targetId = Client.crosshairEntityId();
        this.action = 4;
        this.waitTicks = 0;
        Client.releaseAttack(slot);
    }

    private void cancelAction() {
        if (this.action == 0) {
            return;
        }
        if (this.targetId >= 0 && Client.inGame()) {
            Client.releaseAttack(this.targetId);
        }
        this.action = 0;
        this.armed = false;
        this.releaseRefCount();
    }

    private void releaseRefCount() {
        if (!this.refCounted) {
            return;
        }
        this.refCounted = false;
        if (tickHookRefs > 0) {
            --tickHookRefs;
        }
        if (tickHookRefs == 0) {
            Client.uninstallTickHook();
        }
    }

    public boolean swapKeyDown() {
        return this.swapKeyDown;
    }

    public boolean fireworkKeyDown() {
        return this.fireworkKeyDown;
    }

    public int action() {
        return this.action;
    }

    private int bind(String name) {
        Setting s = this.setting(name);
        return s == null ? 0 : s.getKey();
    }

    private Setting setting(String name) {
        for (Setting s : this.getSettings()) {
            if (!s.getName().equals(name)) continue;
            return s;
        }
        return null;
    }
}

