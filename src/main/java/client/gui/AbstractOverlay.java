/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.Component;

public class AbstractOverlay
extends Component {
    public static final long VTABLE_RVA = 12586352L;
    public static final long RVA_CTOR = 1167552L;
    public static final long RVA_DTOR = 1167808L;
    public static final long RVA_RENDER = 1166848L;
    public static final long RVA_RESET = 1167504L;
    public static final long RVA_MOUSE_CLICKED = 1167280L;
    public static final long RVA_KEY_PRESSED = 1167456L;
    public static final long RVA_SET_POSITION = 0x10BBB0L;
    public static final long RVA_ALPHA_CURRENT = 1167536L;
    public static final long RVA_ALPHA_REMAP = 1165872L;
    public static final long RVA_ALPHA_INVERSE = 1165792L;
    public static final long RVA_CONST_EIGHT = 1165776L;
    public static final long RVA_SET_CHILD = 1165968L;
    public static final long RVA_SET_CHILD_ALT = 1166176L;
    public static final long RVA_ACTIVATE = 1166384L;
    public static final long RVA_CLOSE = 1166688L;
    public static final long RVA_CONTAINS = 1096640L;
    public static final long RVA_COMPONENT_DTOR = 1096704L;
    public static final long RVA_ADVANCE_ANIM = 1149040L;
    public static final long RVA_ANIMATE = 1148816L;
    public static final long RVA_INIT_ANIM = 1173840L;
    public static final long RVA_INIT_ANIM_EXPO = 1096400L;
    public static final long RVA_INIT_COLOR_ANIM = 1149568L;
    public static final long RVA_TIME = 31568L;
    public static final long RVA_EASE_OUT_CUBIC = 577328L;
    public static final long RVA_EASE_OUT_QUINT = 1098464L;
    public static final long RVA_EASE_EXPO_OUT = 1096336L;
    public static final long RVA_PLAY_SOUND = 36640L;
    public static final long RVA_RENDER_GATE_A = 3515472L;
    public static final long RVA_RENDER_GATE_B = 3494400L;
    public static final long RVA_RENDER_GATE_C = 3491616L;
    public static final long RVA_RENDER_GATE_D = 3483568L;
    public static final int OFF_CHILD = 200;
    public static final int OFF_CLOSED = 136;
    public static final int OFF_CLOSE_OUTSIDE = 137;
    public static final int OFF_CLOSE_ESCAPE = 138;
    public static final int OFF_DETACHED = 139;
    public static final int OFF_RECT_ANIM = 32;
    public static final int OFF_FLAG_BLOCK = 136;
    public static final int EASE_OUT_CUBIC = 0;
    public static final int EASE_OUT_QUINT = 1;
    public static final int EASE_EXPO_OUT = 2;
    public static final int SOUND_CLOSE = 5;
    public static final int SOUND_ACTIVATE = 10;
    public static final float DEFAULT_RECT_DURATION = 0.15f;
    public static final float DEFAULT_ALPHA_DURATION = 0.38f;
    public static final float CLOSE_ALPHA_DURATION = 0.26f;
    public static final float ACTIVATE_ALPHA_DURATION = 0.38f;
    public static final float ALPHA_REMAP_SCALE = 0.08f;
    public static final float ALPHA_REMAP_BIAS = 0.92f;
    public static final float ALPHA_INVERSE_SCALE = 16.0f;
    public static final float ALPHA_VISIBLE_EPSILON = 0.001f;
    public static final float CONST_EIGHT = 8.0f;
    public static final float RENDER_GATE_ONE = 1.0f;
    public static final float RENDER_GATE_ZERO = 0.0f;
    protected static AbstractOverlay activeOverlay;
    protected boolean closed;
    protected boolean closeOnOutsideClick = true;
    protected boolean closeOnEscape = true;
    protected boolean detached;
    protected Component child;
    protected float rectFrom;
    protected float rectCurrent;
    protected float rectTarget;
    protected float rectDuration = 0.15f;
    protected int rectEasing = 0;
    protected long rectStart;
    protected boolean rectRunning;
    protected int alphaEasing = 1;
    private static boolean FRAME_STAGE_LOCKED;
    private static boolean FRAME_READY_A;
    private static boolean FRAME_READY_B;
    private static boolean FRAME_PRESENT_LOCKED;
    private static boolean FRAME_DEFERRED;
    private static boolean FRAME_DEFERRED_B;

    public AbstractOverlay() {
        this.flags = 256;
        this.x = 0.0f;
        this.y = 0.0f;
        this.width = 0.0f;
        this.height = 0.0f;
        this.initRectAnimator();
        this.animXFrom = 0.0f;
        this.animXCurrent = 0.0f;
        this.animXTarget = 0.0f;
        this.animYFrom = 0.0f;
        this.animYCurrent = 0.0f;
        this.animYTarget = 0.0f;
        this.animatingPosition = false;
        this.animFrom = 0.0f;
        this.alpha = 0.0f;
        this.alphaTarget = 0.0f;
        this.alphaDuration = 0.38f;
        this.alphaEasing = 1;
        this.alphaStart = this.now();
        this.alphaRunning = false;
        this.closed = false;
        this.closeOnOutsideClick = true;
        this.closeOnEscape = true;
        this.detached = false;
        this.child = null;
    }

    protected void initRectAnimator() {
        this.rectFrom = 0.0f;
        this.rectCurrent = 0.0f;
        this.rectTarget = 0.0f;
        this.rectDuration = 0.15f;
        this.rectEasing = 0;
        this.rectStart = this.now();
        this.rectRunning = false;
    }

    public static float clamp01(float value) {
        if (value <= 0.0f) {
            return 0.0f;
        }
        if (value <= 1.0f) {
            return value;
        }
        return 1.0f;
    }

    public static float easeOutQuint(float t) {
        float inv = 1.0f - t;
        return 1.0f - inv * inv * inv * inv * inv;
    }

    public static float easeExpoOut(float t) {
        if (t < 1.0f) {
            return 1.0f - (float)Math.exp(t * -6.931472f);
        }
        return 1.0f;
    }

    public static float applyEasing(int easing, float t) {
        if (easing == 1) {
            return AbstractOverlay.easeOutQuint(t);
        }
        if (easing == 2) {
            return AbstractOverlay.easeExpoOut(t);
        }
        return AbstractOverlay.easeOutCubic(t);
    }

    public static float advance(Animator anim, long time) {
        if (!anim.running || anim.duration <= 0.0f) {
            anim.current = anim.target;
            anim.running = false;
            return anim.current;
        }
        float t = (float)((double)(time - anim.start) / 1.0E9) / anim.duration;
        if (t <= 0.0f) {
            anim.current = anim.from;
            return anim.current;
        }
        if (t >= 1.0f) {
            anim.running = false;
            anim.current = anim.target;
            return anim.current;
        }
        float target = anim.target;
        float from = anim.from;
        anim.current = AbstractOverlay.applyEasing(anim.easing, t) * (target - from) + from;
        return anim.current;
    }

    public static void animate(Animator anim, float value) {
        if (anim.target == value) {
            return;
        }
        long time = System.nanoTime();
        float current = AbstractOverlay.advance(anim, time);
        anim.start = time;
        anim.from = current;
        anim.target = value;
        anim.running = true;
    }

    public static void resetAnimator(Animator anim, float value, float duration, int easing) {
        long time = System.nanoTime();
        anim.from = value;
        anim.current = value;
        anim.target = value;
        anim.duration = duration;
        anim.easing = easing;
        anim.start = time;
        anim.running = false;
    }

    public static void resetColorAnimator(ColorAnim anim, int color, float duration) {
        anim.duration = duration;
        anim.easing = 0;
        anim.from = 1.0f;
        anim.current = 1.0f;
        anim.target = 1.0f;
        anim.start = System.nanoTime();
        anim.colorFrom = color;
        anim.colorTarget = color;
        anim.running = false;
    }

    public static int mixColor(int from, int to, float t) {
        if (t <= 0.0f) {
            return from;
        }
        if (1.0f <= t) {
            return to;
        }
        int out = 0;
        for (int shift = 0; shift < 32; shift += 8) {
            float a = from >>> shift & 0xFF;
            float b = to >>> shift & 0xFF;
            int mix = (int)((b - a) * t + a);
            out |= mix << shift;
        }
        return out;
    }

    public static float repaintScale(float alpha) {
        float clamped = AbstractOverlay.clamp01(alpha);
        return clamped * 0.08f + 0.92f;
    }

    public static float fadeScale(float alpha) {
        float clamped = AbstractOverlay.clamp01(alpha);
        return (1.0f - clamped) * 16.0f;
    }

    public float alphaCurrent() {
        return this.alpha;
    }

    public float alphaRemap() {
        return AbstractOverlay.repaintScale(this.alpha);
    }

    public float alphaInverse() {
        return AbstractOverlay.fadeScale(this.alpha);
    }

    public float overlayConst() {
        return 8.0f;
    }

    public void reset() {
        this.closed = false;
        this.animFrom = 0.0f;
        this.alpha = 0.0f;
        this.alphaTarget = 0.0f;
        this.alphaRunning = false;
    }

    public void activate() {
        this.closed = false;
        this.detached = false;
        this.alphaDuration = 0.38f;
        this.alphaEasing = 1;
        if (this.alphaTarget != 1.0f) {
            long time = this.now();
            float current = this.advanceAlpha(time);
            this.alphaStart = time;
            this.animFrom = current;
            this.alpha = current;
            this.alphaTarget = 1.0f;
            this.alphaRunning = true;
        }
        AbstractOverlay.uiSound(10);
        if (activeOverlay != null && activeOverlay != this) {
            activeOverlay.reset();
        }
        activeOverlay = this;
    }

    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        AbstractOverlay.uiSound(5);
        this.alphaDuration = 0.26f;
        this.alphaEasing = 0;
        if (this.alphaTarget != 0.0f) {
            long time = this.now();
            float current = this.advanceAlpha(time);
            this.alphaStart = time;
            this.animFrom = current;
            this.alpha = current;
            this.alphaTarget = 0.0f;
            this.alphaRunning = true;
        }
        this.onClosed();
    }

    public float advanceAlpha(long time) {
        if (!this.alphaRunning || this.alphaDuration <= 0.0f) {
            this.alpha = this.alphaTarget;
            this.alphaRunning = false;
            return this.alpha;
        }
        float t = (float)((double)(time - this.alphaStart) / 1.0E9) / this.alphaDuration;
        if (t <= 0.0f) {
            this.alpha = this.animFrom;
            return this.alpha;
        }
        if (t >= 1.0f) {
            this.alphaRunning = false;
            this.alpha = this.alphaTarget;
            return this.alpha;
        }
        this.alpha = AbstractOverlay.applyEasing(this.alphaEasing, t) * (this.alphaTarget - this.animFrom) + this.animFrom;
        return this.alpha;
    }

    @Override
    public void updateAlpha(long time) {
        this.advanceAlpha(time);
    }

    public void animateAlphaTo(float target) {
        if (this.alphaTarget == target) {
            return;
        }
        long time = this.now();
        float current = this.advanceAlpha(time);
        this.alphaStart = time;
        this.animFrom = current;
        this.alpha = current;
        this.alphaTarget = target;
        this.alphaRunning = true;
    }

    public void setChild(Component value) {
        if (this.child != value) {
            if (this.child != null) {
                this.child = null;
            }
            this.child = value;
        }
        if (this.child != null) {
            this.x = this.child.getX();
            this.y = this.child.getY();
        }
        this.activate();
    }

    public void setChildAlt(Component value) {
        if (this.child != value) {
            if (this.child != null) {
                this.child = null;
            }
            this.child = value;
        }
        if (this.child != null) {
            this.x = this.child.getX();
            this.y = this.child.getY();
        }
        this.relayoutChildren();
    }

    protected void relayoutChildren() {
        this.activate();
    }

    protected void syncChildPosition() {
        if (this.child != null) {
            this.x = this.child.getX();
            this.y = this.child.getY();
        }
    }

    public void renderOverlay(Object target, float rx, float ry, float parentAlpha) {
        long time = this.now();
        float current = this.advanceAlpha(time);
        if (0.001f < current) {
            this.syncChildPosition();
            if (AbstractOverlay.isRenderGateOpen()) {
                AbstractOverlay.prepareFrameStage();
                if (AbstractOverlay.frameQueueHead() != AbstractOverlay.frameQueueTail()) {
                    AbstractOverlay.flushFrameQueue();
                }
                AbstractOverlay.presentFrame();
                AbstractOverlay.installShutdownHook();
                AbstractOverlay.resetFrameFlag();
            }
            this.renderBody(target, rx, ry, current * parentAlpha);
        } else if (this.closed) {
            this.onDisposed();
            if (this.child != null) {
                this.child = null;
            }
            if (!this.detached && activeOverlay == this) {
                activeOverlay = null;
            }
        }
    }

    @Override
    public void render() {
        this.renderOverlay(null, this.x, this.y, 1.0f);
    }

    public void renderBody(Object target, float rx, float ry, float parentAlpha) {
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (this.closed) {
            return true;
        }
        this.syncChildPosition();
        if (button == 0 && this.closeOnOutsideClick && !this.contains(mx, my)) {
            this.close();
            return true;
        }
        return this.onMouseClicked(mx, my, button);
    }

    public boolean onMouseClicked(double mx, double my, int button) {
        return false;
    }

    @Override
    public boolean keyPressed(int keyCode, int modifiers) {
        if (this.closeOnEscape && keyCode == 27) {
            this.close();
            return true;
        }
        return this.onKeyPressed(keyCode, modifiers);
    }

    public boolean onKeyPressed(int keyCode, int modifiers) {
        return false;
    }

    public void onClosed() {
    }

    public void onDisposed() {
    }

    public boolean isClosed() {
        return this.closed;
    }

    public Component child() {
        return this.child;
    }

    public static AbstractOverlay activeOverlay() {
        return activeOverlay;
    }

    private static boolean isRenderGateOpen() {
        if (FRAME_STAGE_LOCKED) {
            return false;
        }
        if (!FRAME_READY_A) {
            return false;
        }
        if (!FRAME_READY_B) {
            return false;
        }
        if (!FRAME_PRESENT_LOCKED) {
            return true;
        }
        return !FRAME_DEFERRED && FRAME_DEFERRED_B;
    }

    private static void prepareFrameStage() {
    }

    private static void flushFrameQueue() {
    }

    private static void presentFrame() {
    }

    private static void installShutdownHook() {
    }

    private static void resetFrameFlag() {
    }

    private static int frameQueueHead() {
        return 0;
    }

    private static int frameQueueTail() {
        return 0;
    }

    private static void playSoundLocal(int id) {
        AbstractOverlay.uiSound(id);
    }

    static {
        FRAME_STAGE_LOCKED = false;
        FRAME_READY_A = true;
        FRAME_READY_B = true;
        FRAME_PRESENT_LOCKED = false;
        FRAME_DEFERRED = false;
        FRAME_DEFERRED_B = false;
    }

    public static class Animator {
        public static final int OFF_FROM = 0;
        public static final int OFF_CURRENT = 4;
        public static final int OFF_TARGET = 8;
        public static final int OFF_DURATION = 12;
        public static final int OFF_EASING = 16;
        public static final int OFF_START = 24;
        public static final int OFF_RUNNING = 32;
        public float from;
        public float current;
        public float target;
        public float duration;
        public int easing = 0;
        public long start;
        public boolean running;

        public Animator() {
        }

        public Animator(float value, float duration, int easing) {
            this.from = value;
            this.current = value;
            this.target = value;
            this.duration = duration;
            this.easing = easing;
            this.start = System.nanoTime();
            this.running = false;
        }
    }

    public static class ColorAnim
    extends Animator {
        public static final int OFF_COLOR_FROM = 40;
        public static final int OFF_COLOR_TARGET = 44;
        public int colorFrom;
        public int colorTarget;

        public ColorAnim() {
        }

        public ColorAnim(int color, float duration) {
            AbstractOverlay.resetColorAnimator(this, color, duration);
        }
    }
}

