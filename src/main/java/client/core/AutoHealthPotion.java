/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import client.mc.Entity;

public final class AutoHealthPotion
extends Feature {
    public static final String MODULE = "autohealthpotion";
    public static final String DISPLAY = "\u0410\u0443\u0442\u043e\u0425\u0435\u0430\u043b\u0442\u0445\u041f\u043e\u0442";
    public static final int VTABLE_RVA = 12294056;
    public static final long RVA_ON_TICK = 2735200161328L;
    public static final long RVA_ON_LOOK = 2735200163152L;
    public static final long RVA_ON_TOGGLE = 2735200159984L;
    public static final long RVA_START = 2735200162640L;
    public static final long RVA_AIM_REACHED = 2735200163584L;
    private static final int STATE_IDLE = 0;
    private static final int STATE_SELECT = 1;
    private static final int STATE_USE = 2;
    private static final int STATE_AIM = 3;
    private static final int STATE_RESTORE = 4;
    private static final int INVENTORY_LIMIT = 36;
    private static final int HOTBAR_LAST = 8;
    private static final int HOTBAR_CONTAINER_OFFSET = 36;
    private static final double NANOS_PER_SECOND = 1.0E9;
    private static final float TARGET_PITCH = Float.intBitsToFloat(1118437376);
    private static final double AIM_EPSILON = 0.05;
    private static final double AIM_SCALE = 0.8;
    private static final double AIM_FACTOR_MIN = 0.01;
    private static final double AIM_FACTOR_MAX = 0.95;
    private static final double AIM_TOLERANCE = 1.5;
    private static final double ANGLE_FULL = 360.0;
    private static final double ANGLE_HALF = 180.0;
    private static final double ANGLE_NEG_FULL = -360.0;
    private static final double ANGLE_NEG_HALF = -180.0;
    private static final int SWAP_NONE = -1;
    private final int[] swapManager = Client.newSwapManager();
    private final boolean[] keyLatch = new boolean[1];
    private int state;
    private float capturedYaw;
    private float capturedPitch;
    private int previousSlot = -1;
    private int swapBackSlot = -1;
    private int targetSlot = -1;
    private float aimYaw;
    private float aimPitch;
    private long lastFrameNanos;

    public AutoHealthPotion() {
        super(MODULE, DISPLAY, Category.Player);
        this.add(Setting.number("aim_speed", 15.0, 10.0, 30.0));
        this.add(Setting.key("trigger", 0));
    }

    @Override
    public void onEnable() {
        this.reset();
    }

    @Override
    public void onDisable() {
        this.reset();
    }

    @Override
    public void onTick() {
        Client.swapManagerTick(this.swapManager);
        if (!Client.inGame()) {
            this.reset();
            return;
        }
        if (Client.keybindPressed(this.triggerKey(), this.triggerMods(), this.keyLatch) && !Client.isPaused() && this.state == 0) {
            this.startDrink();
        }
        Entity player = Client.player();
        int current = this.state;
        if (current == 0) {
            return;
        }
        if (current == 1) {
            if (!Client.swapManagerFree(this.swapManager)) {
                return;
            }
            if (!this.aimReached()) {
                return;
            }
            int slot = this.targetSlot;
            if (slot <= 8) {
                Client.setSelectedSlot(slot);
            }
            this.state = 2;
            return;
        }
        if (current == 2) {
            Client.interactItem(player);
            this.aimYaw = this.capturedYaw;
            this.aimPitch = this.capturedPitch;
            this.state = 3;
            return;
        }
        if (current == 3) {
            if (!this.aimReached()) {
                return;
            }
            this.state = 4;
            return;
        }
        if (current != 4) {
            return;
        }
        if (!Client.swapManagerFree(this.swapManager)) {
            return;
        }
        if (this.swapBackSlot != -1) {
            int slot = this.swapBackSlot > 8 ? this.swapBackSlot : this.swapBackSlot + 36;
            Client.swapManagerQueue(this.swapManager, slot, 8, 0);
            this.swapBackSlot = -1;
            return;
        }
        int restore = this.previousSlot;
        if (restore < 0 || restore > 8) {
            this.state = 0;
            return;
        }
        Client.setSelectedSlot(restore);
        this.state = 0;
    }

    @Override
    public void onRender() {
        this.applyAim();
    }

    public void applyAim() {
        if (this.state == 0) {
            return;
        }
        if (!Client.inGame()) {
            return;
        }
        if (Client.isPauseScreen()) {
            return;
        }
        long now = Client.nanos();
        double delta = 0.0;
        if (this.lastFrameNanos > 0L) {
            delta = (double)(now - this.lastFrameNanos) / 1.0E9;
        }
        this.lastFrameNanos = now;
        Entity player = Client.player();
        double yawDelta = AutoHealthPotion.wrap(this.aimYaw - Client.entityYaw(player));
        double pitchDelta = (double)this.aimPitch - (double)Client.entityPitch(player);
        if (Math.abs(yawDelta) < 0.05 && Math.abs(pitchDelta) < 0.05) {
            return;
        }
        double factor = AutoHealthPotion.clamp(this.aimSpeed() * 0.8 * delta, 0.01, 0.95);
        Client.rotateBy(player, (float)(factor * yawDelta), (float)(factor * pitchDelta));
    }

    private void startDrink() {
        int candidate = -1;
        for (int index = 0; index < 36; ++index) {
            int amplifier;
            Object potion;
            int next = candidate;
            Object stack = Client.inventoryStack(index);
            Object item = Client.stackItem(stack);
            if (Client.sameItem(item, potion = Client.potionItem()) && (amplifier = Client.itemStackEffectAmplifier(stack)) >= 0) {
                next = index;
                if (amplifier > 0) {
                    candidate = index;
                    break;
                }
                next = candidate;
                if (candidate == -1) {
                    next = index;
                }
            }
            candidate = next;
        }
        if (candidate == -1) {
            return;
        }
        Entity player = Client.player();
        this.capturedYaw = Client.entityYaw(player);
        this.capturedPitch = Client.entityPitch(player);
        this.previousSlot = Client.selectedSlot();
        this.aimYaw = this.capturedYaw;
        this.aimPitch = TARGET_PITCH;
        this.lastFrameNanos = Client.nanos();
        if (candidate < 9) {
            this.swapBackSlot = -1;
            this.targetSlot = candidate;
        } else {
            this.swapBackSlot = candidate;
            this.targetSlot = 8;
            Client.swapManagerQueue(this.swapManager, candidate, 8, 0);
        }
        this.state = 1;
    }

    private boolean aimReached() {
        double pitchDelta;
        Entity player = Client.player();
        double yawDelta = (double)this.aimYaw - (double)Client.entityYaw(player);
        if ((yawDelta %= 360.0) > 180.0) {
            yawDelta += -360.0;
        }
        if (yawDelta < -180.0) {
            yawDelta += 360.0;
        }
        return Math.sqrt((pitchDelta = (double)this.aimPitch - (double)Client.entityPitch(player)) * pitchDelta + yawDelta * yawDelta) < 1.5;
    }

    private void reset() {
        Client.swapManagerReset(this.swapManager);
        this.swapBackSlot = -1;
        this.state = 0;
        this.lastFrameNanos = 0L;
        this.previousSlot = -1;
        this.targetSlot = -1;
    }

    public int state() {
        return this.state;
    }

    public int previousSlot() {
        return this.previousSlot;
    }

    public int targetSlot() {
        return this.targetSlot;
    }

    public int swapBackSlot() {
        return this.swapBackSlot;
    }

    private static double clamp(double value, double min, double max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    private static double wrap(double angle) {
        double wrapped = angle % 360.0;
        if (wrapped > 180.0) {
            wrapped += -360.0;
        }
        if (wrapped < -180.0) {
            wrapped += 360.0;
        }
        return wrapped;
    }

    private double aimSpeed() {
        Setting setting = this.setting("aim_speed");
        return setting == null ? 15.0 : setting.getNumber();
    }

    private int triggerKey() {
        Setting setting = this.setting("trigger");
        return setting == null ? 0 : setting.getKey();
    }

    private int triggerMods() {
        return 0;
    }

    private Setting setting(String name) {
        for (Setting value : this.getSettings()) {
            if (!value.getName().equals(name)) continue;
            return value;
        }
        return null;
    }
}

