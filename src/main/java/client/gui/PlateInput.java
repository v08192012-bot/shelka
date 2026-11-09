/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.Component;
import client.gui.Screen;

public class PlateInput
extends Component {
    public static final int VTABLE_RVA = 12599288;
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
    public static final int ICON_OFFSET = 344;
    public static final int PANEL_STYLE_OFFSET = 348;
    public static final int FOCUSED_OFFSET = 352;
    public static final int FOCUS_ANIM_OFFSET = 360;
    public static final int REVEAL_ANIM_OFFSET = 400;
    public static final int GHOST_ANIM_OFFSET = 440;
    public static final int STAGING_OFFSET = 480;
    public static final int PENDING_CLEAR_OFFSET = 512;
    public static final int COLOR_ANIM_OFFSET = 520;
    public static final int FLASH_ALPHA_OFFSET = 568;
    public static final int FLASH_ANIM_OFFSET = 576;
    public static final int CALLBACK_STORAGE_OFFSET = 616;
    public static final int CALLBACK_OFFSET = 672;
    public static final int CHAR_FILTER_STORAGE_OFFSET = 680;
    public static final int CHAR_FILTER_OFFSET = 736;
    public static final float DEFAULT_WIDTH = 230.0f;
    public static final float HEIGHT = 42.0f;
    public static final float FONT_SIZE = 14.0f;
    public static final float VIEW_HEIGHT = 36.0f;
    public static final float VIEW_RADIUS = 12.0f;
    public static final float PANEL_RADIUS = 14.0f;
    public static final float PANEL_INSET = 3.0f;
    public static final float PANEL_GAP = 6.0f;
    public static final float ICON_SIZE = 12.0f;
    public static final float ICON_LABEL_INSET = 18.0f;
    public static final float ICON_TOP_INSET = 6.0f;
    public static final float SEPARATOR_SIZE = 20.0f;
    public static final float SEPARATOR_INSET = 10.0f;
    public static final float TEXT_TOP_INSET = 7.0f;
    public static final float FLASH_SCALE = 0.35f;
    public static final float HOVER_SCALE = 0.5f;
    public static final float FOCUS_DURATION = 0.15f;
    public static final float REVEAL_DURATION = 0.15f;
    public static final float GHOST_DURATION = 0.15f;
    public static final float FLASH_DURATION = 0.32f;
    public static final float REVEAL_EXPONENT = 1.7f;
    public static final float EPSILON = 0.001f;
    public static final float NEAR_ONE = 0.999f;
    public static final int HOVER_INPUT = 2;
    public static final int SEPARATOR_ICON = 80;
    public static final int TEXT_ALIGNMENT = 2;
    public static final int KEY_ENTER = 13;
    public static final int KEY_ESCAPE = 27;
    public static final int SPACE_LIMIT = 32;
    protected final Anim rectAnim = new Anim();
    protected long ownedBufferA;
    protected long ownedBufferB;
    protected byte flag58;
    protected String text = "";
    protected float fontSize = 14.0f;
    protected byte flag84;
    protected byte flag85;
    protected byte flag86;
    protected long cursor;
    protected long selection;
    protected String viewText = "";
    protected Object subject;
    protected long reserved130;
    protected String label = "";
    protected int icon;
    protected float panelStyle;
    protected boolean focused;
    protected final Anim focusAnim = new Anim();
    protected final Anim revealAnim = new Anim();
    protected final Anim ghostAnim = new Anim();
    protected String staging = "";
    protected boolean pendingClear;
    protected final ColorAnim colorAnim = new ColorAnim();
    protected float flashAlpha;
    protected final Anim flashAnim = new Anim();
    protected Object callback;
    protected final byte[] callbackStorage = new byte[56];
    protected Object charFilter;
    protected final byte[] charFilterStorage = new byte[56];
    private static final float ONE = 1.0f;

    public PlateInput(float width, String label, int icon) {
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
        this.cursor = 0L;
        this.selection = 0L;
        this.viewText = "";
        this.fontSize = 14.0f;
        this.flag84 = 0;
        this.flag85 = 0;
        this.flag86 = 0;
        this.subject = null;
        this.reserved130 = 0L;
        this.label = "";
        this.label = label != null ? label : "";
        PlateInput.releaseSourceString();
        this.icon = icon;
        this.panelStyle = 0.0f;
        this.focused = false;
        this.focusAnim.set(0.0f, 0.15f);
        this.revealAnim.set(1.0f, 0.15f);
        this.ghostAnim.set(1.0f, 0.15f);
        this.staging = "";
        this.pendingClear = false;
        this.colorAnim.set(PlateInput.themeColor(0), 0.15f);
        this.flashAlpha = 0.0f;
        this.flashAnim.set(0.0f, 0.32f);
        this.callback = null;
        this.charFilter = null;
        this.width = width;
        this.height = 42.0f;
        this.flag85 = 1;
    }

    @Override
    public void dispose() {
        PlateInput.releaseGlobalTextOwner(this);
        PlateInput.resetString(312);
        PlateInput.resetString(480);
        if (this.callback != null) {
            PlateInput.releaseCallback(this.callback, this.callback != this.callbackStorage);
            this.callback = null;
        }
        if (this.charFilter != null) {
            PlateInput.releaseCallback(this.charFilter, this.charFilter != this.charFilterStorage);
            this.charFilter = null;
        }
        PlateInput.freeString(480);
        PlateInput.freeString(312);
        PlateInput.freeString(96);
        super.dispose();
    }

    @Override
    public void render(Object mat, float mouseX, float mouseY, float alpha) {
        float flash;
        float focus;
        if (this.focused) {
            Screen.textInputActive = true;
        }
        float hover = this.updateHover(mouseX, mouseY);
        if ((this.flags & 0xFF) != 0) {
            Screen.hoveredWidget = 2;
        }
        if ((focus = this.focusAnim.advance(Anim.now())) <= hover) {
            focus = hover;
        }
        float panelAlpha = (focus * 0.5f + 0.5f) * alpha;
        PlateInput.drawPanel(mat, this.x, this.y, this.width, this.height, 14.0f, panelAlpha, this.panelStyle);
        float innerX = this.x + 3.0f;
        float innerY = this.y + 3.0f;
        float innerWidth = this.width - 6.0f;
        int frameColor = PlateInput.themeBorderColor();
        float iconSize = 12.0f;
        PlateInput.drawInnerPlate(mat, innerX, innerY, innerWidth, 36.0f, 12.0f, frameColor, panelAlpha);
        this.flashAlpha = flash = this.flashAnim.advance(Anim.now());
        if (0.001f < flash) {
            float tint = this.colorAnim.advance(Anim.now());
            float value = flash * alpha * 0.35f;
            int color = PlateInput.mixColor(this.colorAnim.colorFrom, this.colorAnim.colorTo, tint);
            PlateInput.drawAccentPlate(mat, innerX, innerY, innerWidth, 36.0f, 12.0f, color, value);
        }
        float iconY = innerY + 18.0f;
        float iconX = innerX + iconSize;
        PlateInput.drawIcon(mat, this.icon, iconX, iconY - 6.0f, iconSize, iconSize, PlateInput.themeColor(24), panelAlpha);
        float separatorSize = 20.0f;
        float separatorY = iconY - 10.0f;
        float separatorX = innerX + innerWidth - iconSize - 20.0f;
        PlateInput.drawSeparator(mat, separatorX, separatorY, separatorSize, separatorSize, PlateInput.themeColor(8), panelAlpha);
        float[] metrics = PlateInput.iconMetrics(80);
        PlateInput.drawIcon(mat, 80, (separatorSize - metrics[0]) * 0.5f + separatorX, (separatorSize - metrics[1]) * 0.5f + separatorY, metrics[0], metrics[1], PlateInput.themeColor(24), panelAlpha);
        float textY = iconY - 7.0f;
        float ghostTarget = 0.0f;
        float textX = innerX + iconSize + iconSize + 6.0f;
        float textWidth = separatorX - 6.0f - textX;
        if (textWidth <= 0.0f) {
            textWidth = 0.0f;
        }
        float reveal = this.revealAnim.advance(Anim.now());
        if (this.pendingClear && reveal <= 0.001f) {
            this.resetInput();
        }
        if (!this.staging.isEmpty() && this.ghostAnim.current <= 0.001f) {
            PlateInput.resetString(312);
            this.label = this.staging;
            this.staging = "";
        }
        if (this.text.isEmpty() && !this.focused && this.staging.isEmpty()) {
            ghostTarget = 1.0f;
        }
        if (this.ghostAnim.target != ghostTarget) {
            float value;
            long time = Anim.now();
            this.ghostAnim.from = value = this.ghostAnim.advance(time);
            this.ghostAnim.target = ghostTarget;
            this.ghostAnim.start = time;
            this.ghostAnim.running = true;
        }
        float ghost = this.ghostAnim.advance(Anim.now());
        PlateInput.pushScissor(textX, innerY, textWidth, 36.0f);
        if (0.001f < ghost) {
            float fade = PlateInput.clamp01(ghost);
            fade = (float)Math.pow(fade, 1.7f);
            PlateInput.drawText(2, mat, this.label, textX, textY, 14.0f, PlateInput.themeColor(24), fade * panelAlpha);
        }
        if (ghost < 0.999f) {
            PlateInput.drawTextField(mat, this.text, textX, textY, textWidth, PlateInput.themeColor(24), reveal * alpha * (1.0f - ghost), this.focused);
        }
        PlateInput.popScissor();
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
            PlateInput.clearGlobalFocus(this);
            return true;
        }
        if (keyCode == 13) {
            return this.submit();
        }
        return PlateInput.textKey(this.text, keyCode);
    }

    @Override
    public boolean charTyped(char ch) {
        if (!this.focused) {
            return false;
        }
        if (this.charFilter != null && !PlateInput.acceptChar(this.charFilter, ch)) {
            return false;
        }
        return PlateInput.textChar(this.text, ch);
    }

    public void setFocused(boolean value) {
        if (this.focused == value) {
            return;
        }
        this.focused = value;
        this.focusAnim.retarget(value ? 1.0f : 0.0f);
        if (value) {
            PlateInput.installGlobalFocus(this);
            return;
        }
        PlateInput.clearGlobalFocus(this);
    }

    public boolean isFocused() {
        return this.focused;
    }

    public String text() {
        return this.text;
    }

    public void setText(String value) {
        String next;
        String string = next = value != null ? value : "";
        if (next.length() == this.label.length()) {
            boolean sameAsLabel;
            boolean bl = sameAsLabel = next.length() == 0 || next.equals(this.label);
            if (sameAsLabel) {
                this.staging = "";
                return;
            }
        }
        if (next.length() == this.staging.length()) {
            if (next.length() == 0) {
                return;
            }
            if (next.equals(this.staging)) {
                return;
            }
        }
        if (0.001f < this.ghostAnim.current) {
            PlateInput.resetString(480);
            this.staging = next;
            return;
        }
        PlateInput.resetString(312);
        this.label = next;
    }

    public void setLabel(String value) {
        float target;
        this.staging = "";
        this.label = value != null ? value : "";
        this.ghostAnim.from = target = this.text.isEmpty() || this.focused ? 0.0f : 1.0f;
        this.ghostAnim.current = target;
        this.ghostAnim.target = target;
        this.ghostAnim.running = false;
    }

    public String label() {
        return this.label;
    }

    public int icon() {
        return this.icon;
    }

    public boolean hasText() {
        boolean blank;
        int start = 0;
        int remaining = this.text.length();
        boolean bl = blank = remaining == 0;
        if (!blank) {
            while (this.text.charAt(start) < '!') {
                ++start;
                if (--remaining != 0) continue;
                return false;
            }
            while (' ' >= this.text.charAt(start + remaining - 1) && --remaining != 0) {
            }
            blank = remaining == 0;
        }
        return !blank;
    }

    public boolean submit() {
        int end;
        int start;
        for (start = 0; start < this.text.length() && this.text.charAt(start) <= ' '; ++start) {
        }
        for (end = this.text.length(); end > start && this.text.charAt(end - 1) <= ' '; --end) {
        }
        String trimmed = this.text.substring(start, end);
        if (trimmed.isEmpty()) {
            return false;
        }
        if (this.callback != null) {
            PlateInput.invokeCallback(this.callback, trimmed);
        }
        this.resetInput();
        if (this.focused) {
            this.focused = false;
            this.focusAnim.retarget(0.0f);
            PlateInput.clearGlobalFocus(this);
        }
        return true;
    }

    public void resetInput() {
        this.text = "";
        this.cursor = 0L;
        this.selection = 0L;
        if (this.subject != null) {
            PlateInput.notifySubject(this.subject);
        }
        this.pendingClear = false;
        this.revealAnim.from = 1.0f;
        this.revealAnim.current = 1.0f;
        this.revealAnim.target = 1.0f;
        this.revealAnim.running = false;
    }

    public void takeOverFrom(PlateInput other) {
        if (other != this && other.hasText()) {
            this.text = other.text;
            this.cursor = this.text.length();
            this.selection = this.text.length();
            if (this.subject != null) {
                PlateInput.notifySubjectText(this.subject, this.text);
            }
            this.revealAnim.from = 0.0f;
            this.revealAnim.current = 0.0f;
            this.revealAnim.target = 0.0f;
            this.revealAnim.running = false;
            this.revealAnim.retarget(1.0f);
            if (!this.focused) {
                this.focused = true;
                this.focusAnim.retarget(1.0f);
                PlateInput.installGlobalFocus(this);
            }
            other.pendingClear = true;
            other.revealAnim.retarget(0.0f);
            if (other.focused) {
                other.focused = false;
                other.focusAnim.retarget(0.0f);
                PlateInput.clearGlobalFocus(other);
            }
            return;
        }
        if (!this.focused) {
            this.focused = true;
            this.focusAnim.retarget(1.0f);
            PlateInput.installGlobalFocus(this);
        }
    }

    public void setColor(int color) {
        float value;
        this.colorAnim.colorFrom = color;
        this.colorAnim.colorTo = color;
        this.colorAnim.from = 1.0f;
        this.colorAnim.current = 1.0f;
        this.colorAnim.target = 1.0f;
        this.colorAnim.running = false;
        this.flashAnim.from = 1.0f;
        this.flashAnim.current = 1.0f;
        this.flashAnim.target = 1.0f;
        this.flashAnim.running = false;
        long time = Anim.now();
        this.flashAnim.current = value = this.flashAnim.advance(time);
        this.flashAnim.start = time;
        this.flashAnim.from = value;
        this.flashAnim.target = 0.0f;
        this.flashAnim.running = true;
    }

    public float flashAlpha() {
        return this.flashAlpha;
    }

    public void setSubject(Object value) {
        this.subject = value;
    }

    public void setCallback(Object value) {
        this.callback = value;
    }

    public void setCharFilter(Object value) {
        this.charFilter = value;
    }

    public static boolean releaseFocus(Object lambda) {
        PlateInput widget = (PlateInput)PlateInput.lambdaOwner(lambda);
        if (widget != null && widget.focused) {
            widget.focused = false;
            widget.focusAnim.retarget(0.0f);
            PlateInput.clearGlobalFocus(widget);
            return true;
        }
        return false;
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

    private static void installGlobalFocus(PlateInput widget) {
    }

    private static void clearGlobalFocus(PlateInput widget) {
    }

    private static void releaseGlobalTextOwner(PlateInput widget) {
    }

    private static Object lambdaOwner(Object lambda) {
        return null;
    }

    private static void releaseSourceString() {
    }

    private static void resetString(int offset) {
    }

    private static void freeString(int offset) {
    }

    private static void releaseCallback(Object sub, boolean heap) {
    }

    private static void invokeCallback(Object sub, String value) {
    }

    private static void notifySubject(Object sub) {
    }

    private static void notifySubjectText(Object sub, String value) {
    }

    private static boolean acceptChar(Object filter, char ch) {
        return true;
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

    private static void drawAccentPlate(Object mat, float x, float y, float width, float height, float radius, int color, float alpha) {
    }

    private static void drawSeparator(Object mat, float x, float y, float width, float height, int color, float alpha) {
    }

    private static void drawIcon(Object mat, int icon, float x, float y, float width, float height, int color, float alpha) {
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

    private static final class ColorAnim {
        public static final int ANIM_FROM = 0;
        public static final int ANIM_CURRENT = 4;
        public static final int ANIM_TARGET = 8;
        public static final int ANIM_DURATION = 12;
        public static final int ANIM_EASING = 16;
        public static final int ANIM_START = 24;
        public static final int ANIM_RUNNING = 32;
        public static final int ANIM_COLOR_FROM = 40;
        public static final int ANIM_COLOR_TO = 44;
        float from;
        float current;
        float target;
        float duration;
        int easing;
        long start;
        boolean running;
        int colorFrom;
        int colorTo;

        private ColorAnim() {
        }

        void set(int color, float duration) {
            this.duration = duration;
            this.easing = 0;
            this.from = 1.0f;
            this.current = 1.0f;
            this.target = 1.0f;
            this.start = Anim.now();
            this.colorFrom = color;
            this.colorTo = color;
            this.running = false;
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
            this.current = Anim.easeOutCubic(k) * (this.target - this.from) + this.from;
            return this.current;
        }
    }
}

