/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.Component;
import client.gui.Screen;

public class TextInput
extends Component {
    public static final int VTABLE_RVA = 12599448;
    public static final int RECT_ANIM_OFFSET = 32;
    public static final int OWNED_BUFFER_A_OFFSET = 72;
    public static final int OWNED_BUFFER_B_OFFSET = 80;
    public static final int FLAG_58_OFFSET = 88;
    public static final int TEXT_OFFSET = 96;
    public static final int TEXT_SIZE_OFFSET = 112;
    public static final int TEXT_CAPACITY_OFFSET = 120;
    public static final int FONT_SIZE_OFFSET = 128;
    public static final int FLAG_84_OFFSET = 132;
    public static final int FLAG_85_OFFSET = 133;
    public static final int FLAG_86_OFFSET = 134;
    public static final int CURSOR_OFFSET = 136;
    public static final int SELECTION_OFFSET = 144;
    public static final int VIEW_TEXT_OFFSET = 152;
    public static final int SUBJECT_OFFSET = 240;
    public static final int RESERVED_130_OFFSET = 304;
    public static final int LABEL_OFFSET = 312;
    public static final int FIELD_HEIGHT_OFFSET = 344;
    public static final int FIELD_INSET_OFFSET = 348;
    public static final int FIELD_EXTRA_OFFSET = 352;
    public static final int FOCUSED_OFFSET = 356;
    public static final int FOCUS_ANIM_OFFSET = 360;
    public static final int GHOST_ANIM_OFFSET = 400;
    public static final float FIELD_RADIUS = 8.0f;
    public static final float FOCUS_DURATION = 0.15f;
    public static final float GHOST_DURATION = 0.15f;
    public static final float REVEAL_EXPONENT = 1.7f;
    public static final float EPSILON = 0.001f;
    public static final float NEAR_ONE = 0.999f;
    public static final float HOVER_SCALE = 0.5f;
    public static final int HOVER_INPUT = 2;
    public static final int TEXT_ALIGNMENT = 0;
    public static final int FIELD_BORDER = 0x1A000000;
    public static final int KEY_ESCAPE = 27;
    protected final Anim rectAnim = new Anim();
    protected long ownedBufferA;
    protected long ownedBufferB;
    protected byte flag58;
    protected String text = "";
    protected float fontSize;
    protected byte flag84;
    protected byte flag85;
    protected byte flag86;
    protected long cursor;
    protected long selection;
    protected String viewText = "";
    protected Object subject;
    protected long reserved130;
    protected String label = "";
    protected float fieldHeight;
    protected float fieldInset;
    protected float fieldExtra;
    protected boolean focused;
    protected final Anim focusAnim = new Anim();
    protected final Anim ghostAnim = new Anim();
    private static final float ONE = 1.0f;

    public TextInput() {
        this(0.0f, 0.0f, "", 0.0f, 0.0f, 0.0f);
    }

    public TextInput(float width, float height, String label, float fontSize, float inset, float extra) {
        this.x = 0.0f;
        this.y = 0.0f;
        this.width = 0.0f;
        this.height = 0.0f;
        this.flags = 256;
        this.rectAnim.set(0.0f, 0.15f);
        this.ownedBufferA = 0L;
        this.ownedBufferB = 0L;
        this.flag58 = 0;
        this.text = "";
        this.fontSize = fontSize;
        this.flag84 = 0;
        this.flag85 = 0;
        this.flag86 = 0;
        this.cursor = 0L;
        this.selection = 0L;
        this.viewText = "";
        this.subject = null;
        this.reserved130 = 0L;
        this.label = "";
        this.label = label != null ? label : "";
        this.fieldHeight = fontSize;
        this.fieldInset = inset;
        this.fieldExtra = extra;
        this.focused = false;
        this.focusAnim.set(0.0f, 0.15f);
        this.ghostAnim.set(1.0f, 0.15f);
        this.width = width;
        this.height = height;
    }

    @Override
    public void dispose() {
        TextInput.releaseGlobalTextOwner(this);
        TextInput.resetString(312);
        TextInput.freeString(312);
        TextInput.freeString(96);
        super.dispose();
    }

    @Override
    public void render(Object mat, float mouseX, float mouseY, float alpha) {
        if (this.focused) {
            Screen.textInputActive = true;
        }
        if (this.x <= mouseX && mouseX <= this.x + this.width && this.y <= mouseY && mouseY <= this.y + this.height && (Screen.focusedInput == null || Screen.allowHover)) {
            Screen.hoveredWidget = 2;
        }
        float focus = this.focusAnim.advance(Anim.now());
        int focusColor = TextInput.mixColor(TextInput.themeColor(12), TextInput.themeColor(20), focus);
        TextInput.uiDrawBox(mat, this.x, this.y, this.width, this.height, 8.0f, 8.0f, 8.0f, 8.0f, TextInput.themeColor(0), focusColor, 1.0f, 0x1A000000, 0.0f, 1.0f, 1.0f, alpha, 0);
        float textWidth = this.width - (this.fieldInset + this.fieldInset) - this.fieldExtra;
        float textY = (this.height - this.fieldHeight) * 0.5f + this.y;
        float textVisible = 0.0f;
        if (this.text.isEmpty() && !this.focused) {
            textVisible = 1.0f;
        }
        if (this.ghostAnim.target != textVisible) {
            float value;
            long time = Anim.now();
            this.ghostAnim.from = value = this.ghostAnim.advance(time);
            this.ghostAnim.target = textVisible;
            this.ghostAnim.start = time;
            this.ghostAnim.running = true;
        }
        float ghost = this.ghostAnim.advance(Anim.now());
        TextInput.pushScissor(this.x + this.fieldInset, this.y, textWidth, this.height);
        if (0.001f < ghost) {
            float fade = TextInput.clamp01(ghost);
            fade = (float)Math.pow(fade, 1.7f);
            TextInput.drawText(0, mat, this.label, this.x + this.fieldInset, textY, this.fieldHeight, TextInput.themeColor(16), fade * alpha);
        }
        if (ghost < 0.999f) {
            TextInput.drawTextField(mat, this.text, this.x + this.fieldInset, textY, textWidth, TextInput.themeColor(24), (1.0f - ghost) * alpha, this.focused);
        }
        TextInput.popScissor();
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (button != 0) {
            return false;
        }
        if (this.x <= (float)mx && mx <= (double)(this.x + this.width) && this.y <= (float)my && my <= (double)(this.y + this.height)) {
            this.setFocused(true);
            return true;
        }
        this.setFocused(false);
        return false;
    }

    public boolean keyPressed(int keyCode) {
        if (!this.focused) {
            return false;
        }
        if (keyCode == 27) {
            this.focused = false;
            this.focusAnim.retarget(0.0f);
            TextInput.clearGlobalFocus(this);
            return true;
        }
        return TextInput.textKey(this.text, keyCode);
    }

    @Override
    public boolean charTyped(char ch) {
        if (!this.focused) {
            return false;
        }
        return TextInput.textChar(this.text, ch);
    }

    public void setFocused(boolean value) {
        if (this.focused == value) {
            return;
        }
        this.focused = value;
        this.focusAnim.retarget(value ? 1.0f : 0.0f);
        if (value) {
            TextInput.installGlobalFocus(this);
            return;
        }
        TextInput.clearGlobalFocus(this);
    }

    public boolean isFocused() {
        return this.focused;
    }

    public String text() {
        return this.text;
    }

    public void setText(String value) {
        this.text = value != null ? value : "";
    }

    public String label() {
        return this.label;
    }

    public void setLabel(String value) {
        this.label = value != null ? value : "";
    }

    public void setSubject(Object value) {
        this.subject = value;
    }

    public static boolean releaseFocus(Object lambda) {
        TextInput widget = (TextInput)TextInput.lambdaOwner(lambda);
        if (widget != null && widget.focused) {
            widget.focused = false;
            widget.focusAnim.retarget(0.0f);
            TextInput.clearGlobalFocus(widget);
            return true;
        }
        return false;
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

    private static void installGlobalFocus(TextInput widget) {
    }

    private static void clearGlobalFocus(TextInput widget) {
    }

    private static void releaseGlobalTextOwner(TextInput widget) {
    }

    private static Object lambdaOwner(Object lambda) {
        return null;
    }

    private static void resetString(int offset) {
    }

    private static void freeString(int offset) {
    }

    private static boolean textKey(String value, int keyCode) {
        return true;
    }

    private static boolean textChar(String value, char ch) {
        return true;
    }

    private static int themeColor(int offset) {
        return 0;
    }

    private static int mixColor(int from, int to, float t) {
        return 0;
    }

    private static void drawText(int alignment, Object mat, String text, float x, float y, float size, int color, float alpha) {
    }

    private static void drawTextField(Object mat, String value, float x, float y, float width, int color, float alpha, boolean focusedNow) {
    }

    private static void pushScissor(float x, float y, float width, float height) {
    }

    private static void popScissor() {
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

