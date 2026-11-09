/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.AbstractButton;
import client.gui.Screen;

public class PlateIconButton
extends AbstractButton {
    public static final int VTABLE_RVA = 12589032;
    public static final int RECT_ANIM_OFFSET = 32;
    public static final int OWNED_BUFFER_A_OFFSET = 72;
    public static final int OWNED_BUFFER_B_OFFSET = 80;
    public static final int FLAG_58_OFFSET = 88;
    public static final int ICON_OFFSET = 96;
    public static final int TINT_OFFSET = 100;
    public static final int ENABLED_OFFSET = 104;
    public static final int REVEAL_ANIM_OFFSET = 112;
    public static final int PRESS_ANIM_OFFSET = 152;
    public static final int CALLBACK_STORAGE_OFFSET = 192;
    public static final int CALLBACK_OFFSET = 248;
    public static final int LABEL_OFFSET = 256;
    public static final float SIZE = 42.0f;
    public static final float PANEL_RADIUS = 14.0f;
    public static final float INNER_INSET = 3.0f;
    public static final float INNER_SIZE = 36.0f;
    public static final float INNER_RADIUS = 12.0f;
    public static final float REVEAL_DURATION = 0.22f;
    public static final float PRESS_DURATION = 0.15f;
    public static final float REVEAL_EXPONENT = 1.7f;
    public static final float PRESS_SCALE = 0.4f;
    public static final float TINT_SCALE = 0.85f;
    public static final float SNAP_THRESHOLD = 0.5f;
    public static final float HALF = 0.5f;
    public static final float EPSILON = 0.001f;
    public static final float PANEL_STYLE = 0.0f;
    public static final int HOVER_BUTTON = 1;
    public static final int TINT_DEFAULT = 0;
    protected final Anim rectAnim = new Anim();
    protected long ownedBufferA;
    protected long ownedBufferB;
    protected byte flag58;
    protected int icon;
    protected int tint;
    protected byte enabled = 1;
    protected final Anim revealAnim = new Anim();
    protected final Anim pressAnim = new Anim();
    protected Object callback;
    protected final byte[] callbackStorage = new byte[56];
    protected String label = "";
    private static final float ONE = 1.0f;

    public PlateIconButton(int icon, String label) {
        this.flags = 256;
        this.x = 0.0f;
        this.y = 0.0f;
        this.width = 0.0f;
        this.height = 0.0f;
        this.rectAnim.set(0.0f, 0.15f);
        this.ownedBufferA = 0L;
        this.ownedBufferB = 0L;
        this.flag58 = 0;
        this.icon = icon;
        this.tint = 0;
        this.enabled = 1;
        this.revealAnim.set(1.0f, 0.22f);
        this.pressAnim.set(0.0f, 0.15f);
        this.callback = null;
        this.label = "";
        this.label = label != null ? label : "";
        PlateIconButton.releaseSourceString();
        this.width = 42.0f;
        this.height = 42.0f;
    }

    @Override
    public void dispose() {
        PlateIconButton.resetString(256);
        if (this.callback != null) {
            PlateIconButton.releaseCallback(this.callback, this.callback != this.callbackStorage);
            this.callback = null;
        }
        PlateIconButton.freeString(256);
        if (this.callback != null) {
            PlateIconButton.releaseCallback(this.callback, this.callback != this.callbackStorage);
            this.callback = null;
        }
        super.dispose();
    }

    @Override
    public void render(Object mat, float mouseX, float mouseY, float alpha) {
        float reveal = this.revealAnim.advance(Anim.now());
        float panelWidth = 42.0f;
        float current = this.revealAnim.current;
        this.width = reveal * 42.0f;
        if (0.001f < current) {
            float hover = this.updateHover(mouseX, mouseY);
            if ((this.flags & 0xFF) != 0) {
                Screen.hoveredWidget = 1;
            }
            float press = this.pressAnim.advance(Anim.now());
            float fade = PlateIconButton.clamp01(current);
            fade = (float)Math.pow(fade, 1.7f);
            float value = fade * alpha;
            float panelX = this.x + this.width - panelWidth;
            PlateIconButton.drawPanel(mat, panelX, this.y, panelWidth, this.height, 14.0f, value, 0.0f);
            int base = PlateIconButton.themeBorderColor();
            float mix = press * 0.4f + hover;
            if (1.0f <= mix) {
                mix = 1.0f;
            }
            int accent = PlateIconButton.mixColor(base, PlateIconButton.themeColor(8), 0.85f);
            int color = PlateIconButton.mixColor(base, accent, mix);
            PlateIconButton.drawInnerPlate(mat, panelX + 3.0f, this.y + 3.0f, 36.0f, 36.0f, 12.0f, color, value);
            float[] metrics = PlateIconButton.iconMetrics(this.icon);
            int iconColor = this.tint;
            if (iconColor == 0) {
                iconColor = PlateIconButton.themeColor(24);
            }
            PlateIconButton.drawIcon(mat, this.icon, (panelWidth - metrics[0]) * 0.5f + panelX, (this.height - metrics[1]) * 0.5f + this.y, metrics[0], metrics[1], iconColor, value);
            if ((this.flags & 0xFF) != 0 && !this.label.isEmpty()) {
                PlateIconButton.drawTooltip(this.label, this.x, this.y, this.width, this.height);
            }
            return;
        }
        this.flags &= 0xFF00;
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (this.enabled != 0 && 0.5f <= this.revealAnim.current && button == 0 && this.x <= (float)mx && mx <= (double)(this.x + this.width) && this.y <= (float)my && my <= (double)(this.y + this.height)) {
            return this.onClick(mx, my);
        }
        return false;
    }

    @Override
    public boolean onClick(double mx, double my) {
        float value;
        this.pressAnim.from = 1.0f;
        this.pressAnim.current = 1.0f;
        this.pressAnim.target = 1.0f;
        this.pressAnim.running = false;
        long time = Anim.now();
        this.pressAnim.current = value = this.pressAnim.advance(time);
        this.pressAnim.start = time;
        this.pressAnim.from = value;
        this.pressAnim.target = 0.0f;
        this.pressAnim.running = true;
        if (this.callback != null) {
            PlateIconButton.invokeCallback(this.callback);
        }
        return true;
    }

    public void setEnabled(boolean value) {
        float target;
        this.enabled = value ? (byte)1 : 0;
        float f = target = value ? 1.0f : 0.0f;
        if (this.revealAnim.target != target) {
            long time = Anim.now();
            float current = this.revealAnim.advance(time);
            this.revealAnim.start = time;
            this.revealAnim.from = current;
            this.revealAnim.target = target;
            this.revealAnim.running = true;
        }
    }

    public boolean isEnabled() {
        return this.enabled != 0;
    }

    public int icon() {
        return this.icon;
    }

    public void setIcon(int value) {
        this.icon = value;
    }

    public int tint() {
        return this.tint;
    }

    public void setTint(int value) {
        this.tint = value;
    }

    public String label() {
        return this.label;
    }

    public void setLabel(String value) {
        this.label = value != null ? value : "";
    }

    public void setCallback(Object value) {
        this.callback = value;
    }

    public float reveal() {
        return this.revealAnim.current;
    }

    private float updateHover(float mouseX, float mouseY) {
        float target;
        if (mouseX < this.x || this.x + this.width < mouseX || mouseY < this.y || this.y + this.height < mouseY || Screen.focusedInput != null && !Screen.allowHover) {
            this.flags &= 0xFF00;
            target = 0.0f;
        } else {
            this.flags = this.flags & 0xFF00 | 1;
            target = 1.0f;
        }
        if (this.rectAnim.target != target) {
            long time = Anim.now();
            float value = this.rectAnim.advance(time);
            this.rectAnim.start = time;
            this.rectAnim.from = value;
            this.rectAnim.target = target;
            this.rectAnim.running = true;
        }
        return this.rectAnim.advance(Anim.now());
    }

    private static float clamp01(float value) {
        if (value < 0.0f) {
            return 0.0f;
        }
        if (value > 1.0f) {
            return 1.0f;
        }
        return value;
    }

    private static void releaseSourceString() {
    }

    private static void resetString(int offset) {
    }

    private static void freeString(int offset) {
    }

    private static void releaseCallback(Object sub, boolean heap) {
    }

    private static void invokeCallback(Object sub) {
    }

    private static int themeColor(int offset) {
        return 0;
    }

    private static int themeBorderColor() {
        return 0;
    }

    private static int mixColor(int from, int to, float t) {
        return 0;
    }

    private static float[] iconMetrics(int icon) {
        return new float[2];
    }

    private static void drawPanel(Object mat, float x, float y, float width, float height, float radius, float alpha, float style) {
    }

    private static void drawInnerPlate(Object mat, float x, float y, float width, float height, float radius, int color, float alpha) {
    }

    private static void drawIcon(Object mat, int icon, float x, float y, float width, float height, int color, float alpha) {
    }

    private static void drawTooltip(String text, float x, float y, float width, float height) {
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

