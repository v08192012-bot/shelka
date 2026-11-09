/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.AbstractButton;
import client.gui.Screen;

public class SwitcherButton
extends AbstractButton {
    public static final int VTABLE_RVA = 12589144;
    public static final int RECT_ANIM_OFFSET = 32;
    public static final int OWNED_BUFFER_A_OFFSET = 72;
    public static final int OWNED_BUFFER_B_OFFSET = 80;
    public static final int FLAG_58_OFFSET = 88;
    public static final int ON_OFFSET = 96;
    public static final int LOCKED_OFFSET = 97;
    public static final int CALLBACK_STORAGE_OFFSET = 104;
    public static final int CALLBACK_OFFSET = 160;
    public static final int TARGET_OFFSET = 168;
    public static final int FADE_OFFSET = 172;
    public static final int KNOB_OFFSET = 176;
    public static final int DRAGGING_OFFSET = 180;
    public static final int DRAG_PAST_THRESHOLD_OFFSET = 181;
    public static final int PRESS_STATE_OFFSET = 182;
    public static final int PRESS_X_OFFSET = 184;
    public static final float DEFAULT_WIDTH = 28.0f;
    public static final float DEFAULT_HEIGHT = 16.0f;
    public static final float ON_VALUE = 1.0f;
    public static final float OFF_VALUE = 0.0f;
    public static final float SNAP_THRESHOLD = 0.5f;
    public static final float DRAG_THRESHOLD = 1.5f;
    public static final float DRAG_ORIGIN_PAD = 2.0f;
    public static final float DRAG_ORIGIN_EXTRA = 6.0f;
    public static final float DRAG_RANGE_INSET = 12.0f;
    public static final float DRAG_RANGE_EXTRA = 4.0f;
    public static final float FADE_RATE = 14.0f;
    public static final float CHASE_RATE = 5.5f;
    public static final float MIN_CHASE_SPEED = 3.5f;
    public static final float RECT_ANIM_DURATION = 0.15f;
    public static final int HOVER_NONE = 0;
    public static final int HOVER_SWITCH = 1;
    public static final int HOVER_DRAG = 3;
    public static final int OPTION_ON_INDEX = 8;
    public static final int OPTION_OFF_INDEX = 9;
    protected final Anim rectAnim = new Anim();
    protected long ownedBufferA;
    protected long ownedBufferB;
    protected byte flag58;
    protected boolean on;
    protected byte locked;
    protected final byte[] callbackStorage = new byte[56];
    protected Object callback;
    protected float target;
    protected float fade;
    protected float knob;
    protected boolean dragging;
    protected boolean dragPastThreshold;
    protected boolean pressState;
    protected double pressX;
    private static final float ONE = 1.0f;

    public SwitcherButton() {
        this(false);
    }

    public SwitcherButton(boolean on) {
        this.flags = 256;
        this.x = 0.0f;
        this.y = 0.0f;
        this.rectAnim.set(0.0f, 0.15f);
        this.ownedBufferA = 0L;
        this.ownedBufferB = 0L;
        this.flag58 = 0;
        this.on = on;
        this.locked = 0;
        this.callback = null;
        float value = on ? 1.0f : 0.0f;
        this.dragging = false;
        this.dragPastThreshold = false;
        this.pressState = false;
        this.pressX = 0.0;
        this.target = value;
        this.fade = value;
        this.knob = value;
        this.width = 0.0f;
        this.height = 0.0f;
        this.width = 28.0f;
        this.height = 16.0f;
    }

    @Override
    public void dispose() {
        Object sub = this.callback;
        if (sub != null) {
            SwitcherButton.releaseCallback(sub, sub != this.callbackStorage);
            this.callback = null;
        }
        super.dispose();
    }

    @Override
    public void render(Object mat, float mouseX, float mouseY) {
        float dt = SwitcherButton.frameDelta();
        if (this.dragPastThreshold) {
            Screen.hoveredWidget = 3;
        } else if (this.dragging || !(mouseX < this.x) && !(this.x + this.width < mouseX) && !(mouseY < this.y) && !(this.y + this.height < mouseY) && (Screen.focusedInput == null || Screen.allowHover)) {
            Screen.hoveredWidget = 1;
        }
        float decay = (float)Math.exp(dt * -14.0f);
        float delta = this.target - this.knob;
        this.fade = (1.0f - decay) * (this.target - this.fade) + this.fade;
        float chase = (1.0f - (float)Math.exp(dt * -5.5f)) * delta;
        chase = Math.abs(chase);
        float step = Math.max(dt * 3.5f, chase);
        step = Math.min(step, Math.abs(delta));
        this.knob += Math.copySign(step, delta);
        SwitcherButton.mixColor(SwitcherButton.themeColor(12), SwitcherButton.themeColor(20), this.fade);
        SwitcherButton.mixColor(SwitcherButton.themeColor(24), SwitcherButton.themeColor(0), this.fade);
        SwitcherButton.drawSwitch(mat, this.x, this.y, this.width, this.height, this.knob, this.fade, this.on);
        SwitcherButton.flush(mat);
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (button == 0 && this.x <= (float)mx && mx <= (double)(this.x + this.width) && this.y <= (float)my && my <= (double)(this.y + this.height)) {
            return this.press(mx);
        }
        return false;
    }

    public boolean press(double mouseX) {
        this.pressState = this.on;
        this.pressX = mouseX;
        this.dragging = true;
        this.dragPastThreshold = false;
        return true;
    }

    @Override
    public boolean mouseDragged(double mx, double my, int button) {
        if (this.dragging && button == 0) {
            float fraction;
            if (!this.dragPastThreshold) {
                if (Math.abs(mx - this.pressX) < 1.5) {
                    return true;
                }
                this.dragPastThreshold = true;
            }
            if ((fraction = (float)((mx - (double)(this.x + 2.0f + 6.0f)) / (double)(this.width - 12.0f - 4.0f))) < 0.0f) {
                fraction = 0.0f;
            }
            if (fraction > 1.0f) {
                fraction = 1.0f;
            }
            this.target = fraction;
            return true;
        }
        return false;
    }

    @Override
    public boolean mouseReleased(double mx, double my, int button) {
        boolean value;
        if (!this.dragging || button != 0) {
            return false;
        }
        this.dragging = false;
        this.dragPastThreshold = false;
        if (!this.dragPastThreshold) {
            value = this.pressState;
        } else {
            boolean bl = value = 0.5f <= this.target;
        }
        if (this.on != value) {
            this.on = value;
            if (this.locked == 0) {
                SwitcherButton.updateOption((value ? 0 : 1) + 8);
            }
            if (this.callback != null) {
                SwitcherButton.invokeCallback(this.callback);
            }
        }
        if (value) {
            this.target = 1.0f;
            return true;
        }
        this.target = 0.0f;
        return true;
    }

    public boolean isOn() {
        return this.on;
    }

    public void setOn(boolean value) {
        this.on = value;
        this.target = value ? 1.0f : 0.0f;
    }

    public void setCallback(Object value) {
        this.callback = value;
    }

    public float knob() {
        return this.knob;
    }

    public float fade() {
        return this.fade;
    }

    private static float frameDelta() {
        return 0.0f;
    }

    private static int themeColor(int offset) {
        return 0;
    }

    private static void mixColor(int from, int to, float t) {
    }

    private static void drawSwitch(Object mat, float x, float y, float width, float height, float knob, float fade, boolean on) {
    }

    private static void flush(Object mat) {
    }

    private static void releaseCallback(Object sub, boolean heap) {
    }

    private static void invokeCallback(Object sub) {
    }

    private static void updateOption(int index) {
    }

    private static final class Anim {
        public static final int ANIM_FROM = 0;
        public static final int ANIM_CURRENT = 4;
        public static final int ANIM_TARGET = 8;
        public static final int ANIM_DURATION = 12;
        public static final int ANIM_EASING = 16;
        public static final int ANIM_START = 24;
        public static final int ANIM_RUNNING = 32;
        public static final int EASING_CUBIC = 0;
        public static final int EASING_EXPO = 1;
        float from;
        float current;
        float target;
        float duration;
        int easing;
        long start;
        boolean running;

        private Anim() {
        }

        void set(float value, float duration) {
            this.from = value;
            this.current = value;
            this.target = value;
            this.duration = duration;
            this.easing = 0;
            this.start = Anim.now();
            this.running = false;
        }

        void retarget(float target) {
            float value;
            if (this.target == target) {
                return;
            }
            long time = Anim.now();
            this.from = value = this.advance(time);
            this.target = target;
            this.start = time;
            this.running = true;
        }

        float advance(long time) {
            if (!this.running || this.duration <= 0.0f) {
                this.current = this.target;
                this.running = false;
                return this.current;
            }
            float k = (float)((double)(time - this.start) / 1.0E9) / this.duration;
            if (k <= 0.0f) {
                this.current = this.from;
                return this.current;
            }
            if (k >= 1.0f) {
                this.running = false;
                this.current = this.target;
                return this.current;
            }
            this.current = this.ease(k) * (this.target - this.from) + this.from;
            return this.current;
        }

        float ease(float t) {
            if (this.easing == 1) {
                return Anim.easeOutExpo(t);
            }
            return Anim.easeOutCubic(t);
        }

        static long now() {
            return System.nanoTime();
        }

        static float easeOutCubic(float t) {
            float inv = 1.0f - t;
            return 1.0f - inv * inv * inv;
        }

        static float easeOutExpo(float t) {
            return 1.0f - (float)Math.pow(2.0, -10.0 * (double)t);
        }
    }
}

