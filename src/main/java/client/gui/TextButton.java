/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.AbstractButton;
import client.gui.Screen;

public class TextButton
extends AbstractButton {
    public static final int VTABLE_RVA = 12589256;
    public static final int RECT_ANIM_OFFSET = 32;
    public static final int OWNED_BUFFER_A_OFFSET = 72;
    public static final int OWNED_BUFFER_B_OFFSET = 80;
    public static final int FLAG_58_OFFSET = 88;
    public static final int LABEL_OFFSET = 96;
    public static final int KEY_OFFSET = 128;
    public static final int ACCENT_OFFSET = 132;
    public static final int PANEL_STYLE_OFFSET = 136;
    public static final int ACTIVE_OFFSET = 140;
    public static final int EXPAND_ANIM_OFFSET = 144;
    public static final int PRESS_ANIM_OFFSET = 184;
    public static final int ROW_HEIGHT_ANIM_OFFSET = 224;
    public static final int ROW_HEIGHT_READY_OFFSET = 264;
    public static final int REVEAL_ANIM_OFFSET = 272;
    public static final int ALT_TEXT_OFFSET = 312;
    public static final int ALT_KEY_OFFSET = 344;
    public static final int CALLBACK_STORAGE_OFFSET = 352;
    public static final int CALLBACK_OFFSET = 408;
    public static final int TOOLTIP_OFFSET = 416;
    public static final int DISABLED_OFFSET = 448;
    public static final int DISABLED_TOOLTIP_OFFSET = 456;
    public static final int SHIMMER_ANIM_OFFSET = 488;
    public static final float LABEL_KEY_EXTRA = 18.0f;
    public static final float LABEL_PADDING = 30.0f;
    public static final float BUTTON_HEIGHT = 42.0f;
    public static final float FONT_SIZE = 14.0f;
    public static final float KEY_INSET = 12.0f;
    public static final float KEY_GLYPH_INSET = 6.0f;
    public static final float KEY_GLYPH_SIZE = 12.0f;
    public static final float KEY_GLYPH_SPACING = 18.0f;
    public static final float TEXT_INSET_Y = 7.0f;
    public static final float EXPAND_DURATION = 0.22f;
    public static final float PRESS_DURATION = 0.15f;
    public static final float ROW_DURATION = 0.32f;
    public static final float FADE_DURATION = 0.22f;
    public static final float HOVER_SCALE = 0.12f;
    public static final float PRESS_SCALE = 0.1f;
    public static final float REVEAL_EXPONENT = 1.7f;
    public static final float EPSILON = 0.001f;
    public static final float NEAR_ONE = 0.999f;
    public static final float HALF = 0.5f;
    public static final float PANEL_INSET = 3.0f;
    public static final float INNER_HEIGHT = 36.0f;
    public static final float INNER_RADIUS = 12.0f;
    public static final float INNER_GAP = 6.0f;
    public static final float PANEL_RADIUS = 14.0f;
    public static final int PANEL_SHADOW = 0x33000000;
    public static final float SHIMMER_SCALE = 0.5f;
    public static final int KEY_NONE = 89;
    public static final int TEXT_ALIGNMENT = 5;
    public static final int ACCENT_DEFAULT = 0;
    public static final int ACCENT_DANGER = 1;
    public static final int ACCENT_SUCCESS = 2;
    public static final int COLOR_DANGER = -2343358;
    public static final int COLOR_SUCCESS = -13919642;
    public static final int COLOR_BRIGHT = -772;
    public static final int HOVER_BUTTON = 1;
    public static final int HOVER_DISABLED = 7;
    public static final int SOUND_CLICK = 14;
    protected final Anim rectAnim = new Anim();
    protected long ownedBufferA;
    protected long ownedBufferB;
    protected byte flag58;
    protected String label = "";
    protected int key = 89;
    protected int accent = 0;
    protected float panelStyle;
    protected byte active = 1;
    protected final Anim expandAnim = new Anim();
    protected final Anim pressAnim = new Anim();
    protected final Anim rowHeightAnim = new Anim();
    protected boolean rowHeightReady;
    protected final Anim revealAnim = new Anim();
    protected String altText = "";
    protected int altKey = 89;
    protected final byte[] callbackStorage = new byte[56];
    protected Object callback;
    protected String tooltip = "";
    protected byte disabled;
    protected String disabledTooltip = "";
    protected final Anim shimmerAnim = new Anim();
    private static final float ONE = 1.0f;

    public TextButton() {
    }

    public TextButton(String label, int key, int accent) {
        this.x = 0.0f;
        this.y = 0.0f;
        this.width = 0.0f;
        this.height = 0.0f;
        this.flags = 256;
        this.rectAnim.set(0.0f, 0.15f);
        this.ownedBufferA = 0L;
        this.ownedBufferB = 0L;
        this.flag58 = 0;
        this.label = label != null ? label : "";
        this.key = key;
        this.accent = accent;
        this.panelStyle = 0.0f;
        this.active = 1;
        this.expandAnim.set(1.0f, 0.22f);
        this.pressAnim.set(0.0f, 0.15f);
        this.rowHeightAnim.from = 0.0f;
        this.rowHeightAnim.current = 0.0f;
        this.rowHeightAnim.target = 0.0f;
        this.rowHeightAnim.duration = 0.32f;
        this.rowHeightAnim.easing = 2;
        this.rowHeightAnim.start = Anim.now();
        this.rowHeightAnim.running = false;
        this.rowHeightReady = false;
        this.revealAnim.from = 1.0f;
        this.revealAnim.current = 1.0f;
        this.revealAnim.target = 1.0f;
        this.revealAnim.duration = 0.32f;
        this.revealAnim.easing = 2;
        this.revealAnim.start = Anim.now();
        this.revealAnim.running = false;
        this.altText = "";
        this.altKey = 89;
        this.callback = null;
        this.tooltip = "";
        this.disabled = 0;
        this.disabledTooltip = "";
        this.shimmerAnim.set(0.0f, 0.22f);
        float keyExtra = 0.0f;
        if (this.key != 89) {
            keyExtra = 18.0f;
        }
        this.width = TextButton.measureText(this.label, 14.0f) + keyExtra + 30.0f;
        this.height = 0.0f;
        this.height = 42.0f;
    }

    @Override
    public void dispose() {
        TextButton.resetString(96);
        TextButton.resetString(312);
        TextButton.resetString(416);
        TextButton.resetString(456);
        if (this.callback != null) {
            TextButton.releaseCallback(this.callback, this.callback != this.callbackStorage);
            this.callback = null;
        }
        TextButton.freeString(456);
        TextButton.freeString(416);
        if (this.callback != null) {
            TextButton.releaseCallback(this.callback, this.callback != this.callbackStorage);
            this.callback = null;
        }
        TextButton.freeString(312);
        TextButton.freeString(96);
        super.dispose();
    }

    @Override
    public void render(Object mat, float mouseX, float mouseY, float alpha) {
        String hint;
        boolean clip;
        int base;
        int color;
        float reveal = this.revealAnim.advance(Anim.now());
        this.updateWidth();
        float expand = this.expandAnim.current;
        float rowHeight = this.rowHeightAnim.current;
        float preferred = this.preferredHeight();
        if (expand <= 0.001f) {
            this.flags &= 0xFF00;
            return;
        }
        float hover = this.updateHover(mouseX, mouseY);
        if (this.disabled != 0) {
            hover = 0.0f;
        }
        if ((this.flags & 0xFF) != 0) {
            Screen.hoveredWidget = 1;
            if (this.disabled != 0) {
                Screen.hoveredWidget = 7;
            }
        }
        float press = this.pressAnim.advance(Anim.now());
        float shimmer = this.shimmerAnim.advance(Anim.now());
        float value = TextButton.clamp01(expand);
        value = (float)Math.pow(value, 1.7f);
        value = (1.0f - (shimmer *= 0.5f)) * value * alpha;
        if (this.accent == 1) {
            color = -2343358;
            base = -772;
        } else if (this.accent == 2) {
            color = -13919642;
            base = -772;
        } else {
            color = TextButton.themeColor(24);
            base = TextButton.themeColor(0);
        }
        color = TextButton.mixColor(color, base, hover * 0.12f - press * 0.1f);
        float panelX = this.x + this.width - rowHeight;
        boolean bl = clip = 0.001f < Math.abs(rowHeight - preferred);
        if (clip) {
            TextButton.pushScissor(panelX, this.y, rowHeight, this.height);
        }
        TextButton.drawPanel(mat, panelX, this.y, rowHeight, this.height, 14.0f, value, this.panelStyle);
        float innerX = panelX + 3.0f;
        float innerY = this.y + 3.0f;
        TextButton.drawRoundedQuad(mat, innerX, innerY, rowHeight - 6.0f, 36.0f, 12.0f, color, 0x33000000, 6.0f, value);
        float textY = innerY + 18.0f;
        if (reveal < 0.999f) {
            float out = TextButton.clamp01(1.0f - reveal);
            out = (float)Math.pow(out, 1.7f);
            TextButton.drawLabelWithKey(mat, innerX, textY, this.altText, this.altKey, color, out * value);
        }
        float in = TextButton.clamp01(reveal);
        in = (float)Math.pow(in, 1.7f);
        TextButton.drawLabelWithKey(mat, innerX, textY, this.label, this.key, color, in * value);
        if (clip) {
            TextButton.popScissor();
        }
        String string = hint = this.disabled == 0 ? this.tooltip : this.disabledTooltip;
        if ((this.flags & 0xFF) != 0 && hint != null && !hint.isEmpty()) {
            TextButton.drawTooltip(hint, this.x, this.y, this.width, this.height);
        }
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (this.active != 0 && 0.5f <= this.expandAnim.current && button == 0 && this.x <= (float)mx && mx <= (double)(this.x + this.width) && this.y <= (float)my && my <= (double)(this.y + this.height)) {
            return this.press();
        }
        return false;
    }

    public boolean press() {
        float value;
        if (this.disabled != 0) {
            return true;
        }
        TextButton.playSound(14);
        this.pressAnim.from = 1.0f;
        this.pressAnim.current = 1.0f;
        this.pressAnim.target = 1.0f;
        this.pressAnim.running = false;
        this.pressAnim.current = value = this.pressAnim.advance(Anim.now());
        this.pressAnim.start = Anim.now();
        this.pressAnim.from = value;
        this.pressAnim.target = 0.0f;
        this.pressAnim.running = true;
        if (this.callback != null) {
            TextButton.invokeCallback(this.callback);
        }
        return true;
    }

    private void updateWidth() {
        float value;
        float expand = this.expandAnim.advance(Anim.now());
        float height = this.preferredHeight();
        if (!this.rowHeightReady) {
            this.rowHeightAnim.from = height;
            this.rowHeightAnim.current = height;
            this.rowHeightAnim.target = height;
            this.rowHeightAnim.running = false;
            this.rowHeightReady = true;
        } else {
            this.rowHeightAnim.retarget(height);
        }
        this.rowHeightAnim.current = value = this.advanceRowHeight();
        this.width = value * expand;
    }

    private float advanceRowHeight() {
        if (this.rowHeightAnim.running && 0.0f < this.rowHeightAnim.duration) {
            float k = (float)((double)(Anim.now() - this.rowHeightAnim.start) / 1.0E9) / this.rowHeightAnim.duration;
            if (k <= 0.0f) {
                return this.rowHeightAnim.from;
            }
            if (k < 1.0f) {
                float to = this.rowHeightAnim.target;
                float from = this.rowHeightAnim.from;
                float eased = this.rowHeightAnim.ease(k);
                return eased * (to - from) + from;
            }
        }
        this.rowHeightAnim.running = false;
        return this.rowHeightAnim.target;
    }

    @Override
    public float preferredHeight() {
        float extra = 18.0f;
        if (this.key == 89) {
            extra = 0.0f;
        }
        return TextButton.measureText(this.label, 14.0f) + extra + 30.0f;
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

    public String label() {
        return this.label;
    }

    public void setLabel(String value) {
        this.label = value != null ? value : "";
    }

    public String altText() {
        return this.altText;
    }

    public void setAltText(String value) {
        this.altText = value != null ? value : "";
    }

    public void setAltKey(int value) {
        this.altKey = value;
    }

    public void setTooltip(String value) {
        this.tooltip = value != null ? value : "";
    }

    public void setDisabledTooltip(String value) {
        this.disabledTooltip = value != null ? value : "";
    }

    public void setDisabled(boolean value) {
        this.disabled = value ? (byte)1 : 0;
    }

    public void setCallback(Object value) {
        this.callback = value;
    }

    public int key() {
        return this.key;
    }

    public float currentHeight() {
        return this.rowHeightAnim.current;
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

    private static void drawLabelWithKey(Object mat, float x, float textY, String text, int key, int color, float alpha) {
        float cursor = x + 12.0f;
        if (key != 89) {
            TextButton.drawKeyGlyph(mat, key, cursor, textY - 6.0f, 12.0f, 12.0f, color, alpha);
            cursor += 18.0f;
        }
        TextButton.drawText(mat, text, cursor, textY - 7.0f, 14.0f, color, alpha);
    }

    private static float measureText(String value, float size) {
        return 0.0f;
    }

    private static int themeColor(int offset) {
        return 0;
    }

    private static int mixColor(int from, int to, float t) {
        return 0;
    }

    private static void drawPanel(Object mat, float x, float y, float width, float height, float radius, float alpha, float style) {
    }

    private static void drawRoundedQuad(Object mat, float x, float y, float width, float height, float radius, int color, int border, float inset, float alpha) {
    }

    private static void drawKeyGlyph(Object mat, int key, float x, float y, float width, float height, int color, float alpha) {
    }

    private static void drawText(Object mat, String text, float x, float y, float size, int color, float alpha) {
    }

    private static void drawTooltip(String text, float x, float y, float width, float height) {
    }

    private static void pushScissor(float x, float y, float width, float height) {
    }

    private static void popScissor() {
    }

    private static void playSound(int id) {
    }

    private static void resetString(int offset) {
    }

    private static void freeString(int offset) {
    }

    private static void releaseCallback(Object sub, boolean heap) {
    }

    private static void invokeCallback(Object sub) {
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

