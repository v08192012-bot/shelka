/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class PearlCatch
extends Feature {
    public static final String MODULE = "pearlcatch";
    public static final String DISPLAY = "\u041f\u0435\u0430\u0440\u043b\u0421\u0430\u0442\u0441\u0445";
    public static final int VTABLE_RVA = 12292416;
    public static final String STATUS_NOT_IN_HOTBAR = "\u041d\u0435\u0442 \u0432 \u0445\u043e\u0442\u0431\u0430\u0440\u0435";
    public static final String STATUS_ON_COOLDOWN = "\u041d\u0430 \u043e\u0442\u043a\u0430\u0442\u0435";
    private static final String ITEM_ENDER_PEARL = "ender_pearl";
    private static final int ITEM_WIND_CHARGE_ID = 17;
    private static final float PITCH_STRAIGHT_UP = -90.0f;
    private static final double YAW_FULL_TURN = 360.0;
    private static final double YAW_HALF_TURN = 180.0;
    private static final double YAW_NEGATIVE_HALF_TURN = -180.0;
    private static final double YAW_NEGATIVE_FULL_TURN = -360.0;
    private static final float EASE_SPLIT = 0.5f;
    private static final float EASE_DOUBLE = 2.0f;
    private static final float EASE_ONE = 1.0f;
    private static final float EASE_QUAD = 4.0f;
    private static final int PHASE_STEPS = 2;
    private static final int MIN_STATE_FLAG = 2;
    private int phase;
    private int turnTicks;
    private int delayTicks;
    private int returnSlot = -1;
    private int chargeSlot = -1;
    private float savedYaw;
    private float savedPitch;
    private float lastYaw;
    private String status = "";

    public PearlCatch() {
        super(MODULE, DISPLAY, Category.Movement);
        this.add(Setting.key("key", 0));
        this.add(Setting.bool("auto_turn", true));
        this.add(Setting.number("delay", 6.0, 1.0, 19.0));
    }

    @Override
    public void onDisable() {
        if (this.phase != 0) {
            Client.setSelectedSlot(this.returnSlot);
        }
        this.returnSlot = -1;
        this.phase = 0;
        this.delayTicks = 0;
    }

    @Override
    public void onTick() {
        if (!Client.inGame()) {
            this.returnSlot = -1;
            this.phase = 0;
            this.delayTicks = 0;
            return;
        }
        boolean pressed = Client.keybindPressed(this.key(), this.keyMods());
        if (this.phase == 0) {
            if (!pressed) {
                return;
            }
            this.begin();
            return;
        }
        float yaw = (float)Client.currentRotation()[0];
        float pitch = (float)Client.currentRotation()[1];
        float targetPitch = this.autoTurn() ? -90.0f : pitch;
        int state = this.phase;
        if (state == 1) {
            ++this.turnTicks;
            if (this.autoTurn()) {
                this.lastYaw = yaw;
                float[] turned = this.interpolate(this.lastYaw, this.savedPitch, yaw, targetPitch, this.turnTicks, 2);
                Client.setRotation(turned[0], turned[1]);
            }
            if (this.turnTicks < 2) {
                return;
            }
            this.phase = 2;
            return;
        }
        if (state == 2) {
            if (this.autoTurn()) {
                Client.setRotation(yaw, targetPitch);
            }
            Client.swapRotation(yaw, targetPitch);
            if (Client.stateFlag() < 2) {
                Client.setStateFlag(2);
            }
            Client.setSelectedSlot(this.chargeSlot);
            Client.checkJni();
            this.delayTicks = 0;
            this.phase = 3;
            return;
        }
        if (state == 3) {
            if (this.autoTurn()) {
                Client.setRotation(yaw, targetPitch);
            }
            ++this.delayTicks;
            if (this.delayTicks < (int)this.delay()) {
                return;
            }
            Client.swapRotation(yaw, targetPitch);
            Client.setSelectedSlot(this.returnSlot);
            Client.checkJni();
            this.savedYaw = yaw;
            this.savedPitch = targetPitch;
            this.phase = 4;
            return;
        }
        if (state != 4) {
            return;
        }
        if (this.autoTurn()) {
            ++this.turnTicks;
            float[] turned = this.interpolate(this.savedYaw, this.savedPitch, yaw, pitch, this.turnTicks, 2);
            Client.setRotation(turned[0], turned[1]);
            if (this.turnTicks < 2) {
                return;
            }
        }
        this.phase = 0;
        this.delayTicks = 0;
        this.returnSlot = -1;
    }

    private void begin() {
        int pearlSlot = Client.findHotbarSlotByName(ITEM_ENDER_PEARL);
        int chargeSlotFound = Client.findHotbarSlotByItemId(17);
        if (pearlSlot == -1 || chargeSlotFound == -1) {
            this.status = pearlSlot != -1 ? STATUS_ON_COOLDOWN : STATUS_NOT_IN_HOTBAR;
            return;
        }
        boolean ready = false;
        for (int i = 0; i < 2; ++i) {
            int slot;
            int n = slot = i == 0 ? pearlSlot : chargeSlotFound;
            if (Client.hotbarItemCooldown(slot) != -1 || !Client.hotbarItemUsable(slot)) continue;
            ready = true;
            break;
        }
        if (!ready) {
            this.status = STATUS_ON_COOLDOWN;
            return;
        }
        this.returnSlot = Client.selectedSlot();
        this.chargeSlot = chargeSlotFound;
        this.savedYaw = (float)Client.currentRotation()[0];
        this.savedPitch = (float)Client.currentRotation()[1];
        this.turnTicks = 0;
        Client.setSelectedSlot(pearlSlot);
        this.phase = 1;
    }

    private float[] interpolate(float fromYaw, float fromPitch, float toYaw, float toPitch, int step, int steps) {
        float t = (float)step / (float)steps;
        if (0.5f <= t) {
            t = 2.0f - (t + t);
            t = 1.0f - t * t * t * 0.5f;
        } else {
            t = t * 4.0f * t * t;
        }
        double delta = (double)toYaw - (double)fromYaw;
        delta %= 360.0;
        if (180.0 < delta) {
            delta += -360.0;
        }
        if (delta < -180.0) {
            delta += 360.0;
        }
        return new float[]{(float)delta * t + fromYaw, (toPitch - fromPitch) * t + fromPitch};
    }

    private int key() {
        Setting s = this.setting("key");
        return s == null ? 0 : s.getKey();
    }

    private int keyMods() {
        return 0;
    }

    private boolean autoTurn() {
        Setting s = this.setting("auto_turn");
        return s != null && s.getBoolean();
    }

    private double delay() {
        Setting s = this.setting("delay");
        return s == null ? 6.0 : s.getNumber();
    }

    private Setting setting(String name) {
        for (Setting s : this.getSettings()) {
            if (!s.getName().equals(name)) continue;
            return s;
        }
        return null;
    }

    public String status() {
        return this.status;
    }

    public int phase() {
        return this.phase;
    }

    public int delayTicks() {
        return this.delayTicks;
    }

    public int turnTicks() {
        return this.turnTicks;
    }
}

