/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.AbstractSidebarBlock;

public class TextBlock
extends AbstractSidebarBlock {
    public static final int VTABLE_RVA = 12613008;
    public static final int RECT_ANIM_OFFSET = 32;
    public static final int OWNED_BUFFER_A_OFFSET = 72;
    public static final int OWNED_BUFFER_B_OFFSET = 80;
    public static final int FLAG_58_OFFSET = 88;
    public static final int TEXT_OFFSET = 96;
    public static final int REVEAL_OFFSET = 128;
    public static final float DEFAULT_WIDTH = 208.0f;
    public static final float DEFAULT_HEIGHT = 32.0f;
    public static final float ALPHA_SCALE = 0.7f;
    public static final float INSET = 8.0f;
    public static final float FONT_SIZE = 12.0f;
    public static final float EPSILON = 0.001f;
    protected final Anim rectAnim = new Anim();
    protected long ownedBufferA;
    protected long ownedBufferB;
    protected byte flag58;
    protected String text = "";
    protected float reveal;
    private static final float ONE = 1.0f;
    private static final float HALF = 0.5f;
    private static final float RECT_ANIM_DURATION = 0.15f;

    public TextBlock() {
    }

    public TextBlock(String text) {
        super(text);
        this.flags = 256;
        this.x = 0.0f;
        this.y = 0.0f;
        this.width = 0.0f;
        this.height = 0.0f;
        this.rectAnim.set(0.0f, 0.15f);
        this.ownedBufferA = 0L;
        this.ownedBufferB = 0L;
        this.flag58 = 0;
        this.text = text != null ? text : "";
        this.width = 208.0f;
        this.height = 32.0f;
        this.reveal = 0.0f;
    }

    @Override
    public void dispose() {
        TextBlock.resetString();
        TextBlock.freeString();
        super.dispose();
    }

    @Override
    public void render(Object mat, float mouseX, float mouseY, float alpha) {
        alpha *= 0.7f;
        float textY = (this.height - 12.0f) * 0.5f + this.y;
        float left = this.x + 8.0f - 1.0f;
        float fade = 1.0f - this.reveal;
        float width = this.x + this.width - 8.0f - left;
        if (width <= 0.0f) {
            width = 0.0f;
        }
        TextBlock.drawScissoredBlock(this, mat, left, textY, width, this.y, this.height, 12.0f, TextBlock.themeColor(24), fade * alpha);
    }

    public String text() {
        return this.text;
    }

    public void setText(String value) {
        this.text = value != null ? value : "";
    }

    public float reveal() {
        return this.reveal;
    }

    public void setReveal(float value) {
        this.reveal = value;
    }

    private static void drawScissoredBlock(TextBlock block, Object mat, float x, float y, float width, float clipY, float clipHeight, float fontSize, int color, float alpha) {
        if (0.0f < width && 0.001f < alpha) {
            TextBlock.pushScissor(x, clipY, width, clipHeight);
            TextBlock.drawText(mat, block.text, x, y, fontSize, color, alpha);
            TextBlock.popScissor();
        }
    }

    private static void drawText(Object mat, String text, float x, float y, float size, int color, float alpha) {
    }

    private static int themeColor(int offset) {
        return 0;
    }

    protected static void pushScissor(float x, float y, float width, float height) {
    }

    protected static void popScissor() {
    }

    private static void resetString() {
    }

    private static void freeString() {
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
        public static final int EASING_IN_OUT_CUBIC = 2;
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
            if (this.easing == 2) {
                return Anim.easeInOutCubic(t);
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

        static float easeInOutCubic(float t) {
            if (t < 0.5f) {
                return 4.0f * t * t * t;
            }
            float inv = 2.0f - 2.0f * t;
            return 1.0f - inv * inv * inv / 2.0f;
        }
    }
}

