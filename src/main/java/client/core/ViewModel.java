/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;

public final class ViewModel
extends Feature {
    public static final String MODULE = "view_model";
    public static final int VTABLE_RVA = 12581696;
    private static final double NANOS_PER_SECOND = 1.0E9;
    private static final float DELTA_CLAMP = 0.25f;
    private static final float SMOOTH_BASE = 0.45f;
    private static final float SMOOTH_DECAY = 0.55f;
    private static final float SMOOTH_HZ = 60.0f;
    private static final float SETTLE_EPSILON = 1.0E-5f;
    private static final double TRANSITION_SECONDS = 0.2;
    private static final int MASK_ABS = Integer.MAX_VALUE;
    private static final float ACCUMULATE_RATE = 0.22f;
    private static final float ACCUMULATE_DECAY_RATE = 0.3f;
    private static final int RESET_IDLE = -1;
    private static final int RESET_POSITION = 0;
    private static final int RESET_MIRROR = 1;
    private static ViewModel instance;
    private final Smooth rightScale = new Smooth();
    private final Smooth leftScale = new Smooth();
    private long lastUpdateNanos;
    private float rightCurrentX;
    private float rightCurrentY;
    private float leftCurrentX;
    private float leftCurrentY;
    private boolean resetActive;
    private boolean resetCleared;
    private int resetMode = -1;
    private float accumulator;

    public ViewModel() {
        super(MODULE, "", Category.Render);
        this.add(Setting.bool("mirror", false));
        this.add(Setting.bool("reset", false));
        this.add(Setting.number("right_x", 0.0, -2.0, 2.0));
        this.add(Setting.number("right_y", 0.0, -2.0, 2.0));
        this.add(Setting.number("right_scale", 1.0, 0.0, 3.0));
        this.add(Setting.number("left_x", 0.0, -2.0, 2.0));
        this.add(Setting.number("left_y", 0.0, -2.0, 2.0));
        this.add(Setting.number("left_scale", 1.0, 0.0, 3.0));
    }

    public static ViewModel instance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
        instance = null;
        this.resetActive = false;
        this.resetCleared = false;
        this.resetMode = -1;
    }

    @Override
    public void onRender() {
        float leftYTarget;
        long now = System.nanoTime();
        float delta = this.lastUpdateNanos == 0L ? 0.0f : (float)((double)(now - this.lastUpdateNanos) / 1.0E9);
        this.lastUpdateNanos = now;
        float step = delta <= 0.25f ? delta : 0.25f;
        float weight = 0.45f;
        if (0.0f < step) {
            weight = 1.0f - (float)Math.pow(0.55f, step * 60.0f);
        }
        boolean mirror = this.mirror();
        float rightXTarget = (float)this.rightX();
        float rightYTarget = (float)this.rightY();
        if (this.resetActive && this.resetMode == 0) {
            this.rightCurrentX = rightXTarget;
            this.rightCurrentY = rightYTarget;
        } else {
            this.rightCurrentX += (rightXTarget - this.rightCurrentX) * weight;
            this.rightCurrentY += (rightYTarget - this.rightCurrentY) * weight;
        }
        if (ViewModel.abs(rightXTarget - this.rightCurrentX) < 1.0E-5f) {
            this.rightCurrentX = rightXTarget;
        }
        if (ViewModel.abs(rightYTarget - this.rightCurrentY) < 1.0E-5f) {
            this.rightCurrentY = rightYTarget;
        }
        this.rightScale.update((float)this.rightScale(), now);
        float leftXTarget = mirror ? -((float)this.rightX()) : (float)this.leftX();
        float f = leftYTarget = mirror ? (float)this.rightY() : (float)this.leftY();
        if (this.resetActive && this.resetMode == 1) {
            this.leftCurrentX = leftXTarget;
            this.leftCurrentY = leftYTarget;
        } else {
            this.leftCurrentX += (leftXTarget - this.leftCurrentX) * weight;
            this.leftCurrentY += (leftYTarget - this.leftCurrentY) * weight;
        }
        if (ViewModel.abs(leftXTarget - this.leftCurrentX) < 1.0E-5f) {
            this.leftCurrentX = leftXTarget;
        }
        if (ViewModel.abs(leftYTarget - this.leftCurrentY) < 1.0E-5f) {
            this.leftCurrentY = leftYTarget;
        }
        this.leftScale.update(mirror ? (float)this.rightScale() : (float)this.leftScale(), now);
        this.accumulator = !(this.resetCleared || this.resetActive && this.resetMode >= 0) ? (this.accumulator += -delta / 0.3f) : (this.accumulator += delta / 0.22f);
        this.accumulator = ViewModel.clamp(this.accumulator, 0.0f, 1.0f);
    }

    public void requestReset(int mode) {
        this.resetActive = true;
        this.resetCleared = false;
        this.resetMode = mode;
    }

    public float rightOffsetX() {
        return this.rightCurrentX;
    }

    public float rightOffsetY() {
        return this.rightCurrentY;
    }

    public float rightOffsetScale() {
        return this.rightScale.value;
    }

    public float leftOffsetX() {
        return this.leftCurrentX;
    }

    public float leftOffsetY() {
        return this.leftCurrentY;
    }

    public float leftOffsetScale() {
        return this.leftScale.value;
    }

    public float accumulator() {
        return this.accumulator;
    }

    private static float abs(float value) {
        return Float.intBitsToFloat(Float.floatToRawIntBits(value) & Integer.MAX_VALUE);
    }

    private static float clamp(float value, float min, float max) {
        if (value < min) {
            return min;
        }
        return value > max ? max : value;
    }

    private boolean mirror() {
        Setting s = this.setting("mirror");
        return s != null && s.getBoolean();
    }

    private double rightX() {
        return this.number("right_x", 0.0);
    }

    private double rightY() {
        return this.number("right_y", 0.0);
    }

    private double rightScale() {
        return this.number("right_scale", 1.0);
    }

    private double leftX() {
        return this.number("left_x", 0.0);
    }

    private double leftY() {
        return this.number("left_y", 0.0);
    }

    private double leftScale() {
        return this.number("left_scale", 1.0);
    }

    private double number(String name, double fallback) {
        Setting s = this.setting(name);
        return s == null ? fallback : s.getNumber();
    }

    private Setting setting(String name) {
        for (Setting s : this.getSettings()) {
            if (!s.getName().equals(name)) continue;
            return s;
        }
        return null;
    }

    private static final class Smooth {
        private float target;
        private float start;
        private long nanos;
        private float value;

        private Smooth() {
        }

        private void update(float incoming, long now) {
            float t;
            if (this.value != incoming) {
                this.start = this.value;
                this.target = incoming;
                this.nanos = now;
                this.value = incoming;
            }
            if (this.nanos != 0L && (t = (float)((double)(now - this.nanos) / 1.0E9 / 0.2)) < 1.0f) {
                float clamped = ViewModel.clamp(t, 0.0f, 1.0f);
                float inverse = 1.0f - clamped;
                this.value = (1.0f - inverse * inverse * inverse) * (this.target - this.start) + this.start;
            }
        }
    }
}

