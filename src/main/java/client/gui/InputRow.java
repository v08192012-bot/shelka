/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.Setting;
import client.gui.Component;

public class InputRow
extends Component {
    public static final long VTABLE_RVA = 12604560L;
    public static final long RVA_CTOR = 2735201204656L;
    public static final long RVA_SET_FOCUSED = 2735201206528L;
    public static final long RVA_RENDER = 2735201205072L;
    public static final long RVA_MOUSE_CLICKED = 2735201206160L;
    public static final long RVA_METRIC = 2735201205040L;
    public static final long RVA_KEY_PRESSED = 2735201206400L;
    public static final long RVA_CHAR_TYPED = 2735201206496L;
    public static final long RVA_COMMIT = 2735201206336L;
    public static final long RVA_DELETING_DTOR = 2735201206672L;
    public static final long RVA_TEXT_KEY = 2735203203472L;
    public static final long RVA_TEXT_CHAR = 2735203205536L;
    public static final long RVA_TEXT_FIELD = 2735203206320L;
    public static final long RVA_CLEAR_KEYBOARD = 2735201526656L;
    public static final long RVA_INSTALL_KEYBOARD = 2735201526304L;
    public static final long RVA_CLOCK = 2735199714128L;
    public static final long RVA_ROW_BASE = 2735200149152L;
    public static final int SLOT_ROW_HEIGHT = 1;
    public static final int SLOT_ROW_HEIGHT_ALIAS = 2;
    public static final int SLOT_UPDATE = 3;
    public static final int SLOT_RENDER = 4;
    public static final int SLOT_MOUSE_CLICKED = 5;
    public static final int SLOT_METRIC = 6;
    public static final int SLOT_SPACING = 7;
    public static final int SLOT_OPACITY = 8;
    public static final int SLOT_ACCENT = 9;
    public static final int SLOT_SET_POSITION = 11;
    public static final int SLOT_KEY_PRESSED = 12;
    public static final int SLOT_KEY_RELEASED = 13;
    public static final int SLOT_CHAR_TYPED = 14;
    public static final int SLOT_COMMIT = 15;
    public static final int OFF_OWNER = 8;
    public static final int OFF_SETTING = 16;
    public static final int OFF_ROW_HEIGHT = 24;
    public static final int OFF_REVEAL = 28;
    public static final int OFF_ROW_VISIBLE = 32;
    public static final int OFF_ROW_Y = 36;
    public static final int OFF_HANDLER = 40;
    public static final int OFF_ROW_FLAGS = 48;
    public static final int OFF_TAG = 52;
    public static final int OFF_BOUND = 64;
    public static final int OFF_TEXT = 72;
    public static final int OFF_FONT_SIZE = 104;
    public static final int OFF_FLAG_6C = 108;
    public static final int OFF_FLAG_6D = 109;
    public static final int OFF_FLAG_6E = 110;
    public static final int OFF_VALUE = 112;
    public static final int OFF_CALLBACK = 216;
    public static final int OFF_HANDLER2 = 280;
    public static final int OFF_FOCUS_ANIM = 288;
    public static final int OFF_HOVER_ANIM = 328;
    public static final int OFF_FOCUSED = 368;
    public static final float ROW_HEIGHT = 26.0f;
    public static final float ROW_SPACING = 4.0f;
    public static final float ROW_OPACITY = 1.0f;
    public static final float DEFAULT_ROW_HEIGHT = 4.5f;
    public static final float FONT_SIZE = 12.0f;
    public static final float FIELD_PAD_X = 8.0f;
    public static final float FIELD_OUTER_W = 96.0f;
    public static final float FIELD_H = 18.0f;
    public static final float FIELD_INNER_W = 84.0f;
    public static final float FIELD_TOP_PAD = 3.0f;
    public static final float FOCUS_DURATION = 0.15f;
    public static final float HOVER_DURATION = 0.15f;
    public static final float HOVER_EASE = 1.7f;
    public static final float EPSILON = 0.001f;
    public static final float NEAR_ONE = 0.999f;
    public static InputRow textInputOwner;
    public static boolean textInputActive;
    private static double pointerX;
    private static double pointerY;
    private Object owner;
    private Setting setting;
    private float rowHeight = 4.5f;
    private float reveal;
    private boolean rowVisible;
    private float rowY;
    private int rowFlags;
    private long tag;
    private Setting bound;
    private float boundsX;
    private float boundsY;
    private float boundsWidth;
    private float boundsHeight;
    private String text = "";
    private String value = "";
    private boolean focusedState;
    private final Anim focusAnim = new Anim(0.0f, 0.15f);
    private final Anim hoverAnim = new Anim(0.0f, 0.15f);
    private Object callback;
    private Object handler;
    private static final float DRAG_BIAS = 141.0f;
    private static final int BACK_COLOR = -15724524;
    private static final int ACCENT_COLOR = -1;
    private static final int TEXT_COLOR = -2039584;
    public static int cursorHint;

    public InputRow() {
    }

    public InputRow(Object owner, Setting setting) {
        this.owner = owner;
        this.setting = setting;
        this.bound = setting;
        this.value = this.text = InputRow.settingText(setting);
        long time = this.now();
        this.focusAnim.update(time);
        this.hoverAnim.set(1.0f);
        this.hoverAnim.update(time);
    }

    public InputRow(Object owner, Setting setting, String initial) {
        this(owner, setting);
        if (initial != null) {
            this.text = initial;
            this.value = initial;
        }
    }

    private static String settingText(Setting setting) {
        if (setting == null) {
            return "";
        }
        String s = setting.getText();
        if (s == null || s.isEmpty()) {
            s = setting.getName();
        }
        return s == null ? "" : s;
    }

    public float rowHeight() {
        return 26.0f;
    }

    public float rowSpacing() {
        return 4.0f;
    }

    public float opacity() {
        return 1.0f;
    }

    public int accentColor() {
        return -1;
    }

    public float metric(float a, float b) {
        return a + b - 8.0f - 96.0f;
    }

    public float drag(float value) {
        return value + 141.0f;
    }

    public void setReveal(float value) {
        if (this.reveal == value) {
            return;
        }
        this.reveal = value;
    }

    public void markVisible() {
        if (this.rowVisible) {
            return;
        }
        this.rowVisible = true;
        this.rowY = 0.0f;
    }

    public void hideAt(float targetY) {
        if (!this.rowVisible) {
            return;
        }
        this.rowVisible = false;
        this.rowY = targetY <= 0.0f ? 0.0f : targetY;
    }

    public void collapse() {
        this.boundsY = 1.0f;
        this.rowVisible = true;
        this.reveal = 1.0f;
    }

    public float reveal() {
        return this.reveal;
    }

    public boolean rowVisible() {
        return this.rowVisible;
    }

    public float rowY() {
        return this.rowY;
    }

    public Object owner() {
        return this.owner;
    }

    public Setting setting() {
        return this.setting;
    }

    public Setting boundSetting() {
        return this.bound;
    }

    public String text() {
        return this.text;
    }

    public void setText(String value) {
        this.text = value == null ? "" : value;
    }

    public boolean focusedState() {
        return this.focusedState;
    }

    public float measuredHeight() {
        return 26.0f;
    }

    public float measuredWidth() {
        return 26.0f;
    }

    public void update() {
    }

    @Override
    public void tick() {
        this.update();
    }

    @Override
    public void render() {
        this.renderWidget(null, this.x, this.y, this.width, (float)pointerX, (float)pointerY, this.alpha);
    }

    public void renderWidget(Object renderer, float px, float py, float pw, float mx, float my, float alpha) {
        boolean overField;
        float inner = px + pw - 8.0f - 96.0f;
        float top = py + 4.0f;
        boolean bl = overField = mx >= inner && mx <= inner + 96.0f && my >= top && my <= top + 18.0f;
        if (overField) {
            cursorHint = 2;
        }
        long time = this.now();
        this.focusAnim.update(time);
        float focus = this.focusAnim.current;
        InputRow.drawRounded(renderer, inner, top, 96.0f, 18.0f, 8.0f, -15724524, alpha);
        if (0.001f < focus) {
            InputRow.drawOutline(renderer, inner, top, 96.0f, 18.0f, 8.0f, -1, focus * alpha);
        }
        float textX = inner + 8.0f;
        float target = this.mouseOwned || this.focusedState ? 0.0f : 1.0f;
        this.hoverAnim.retarget(target, time);
        this.hoverAnim.update(time);
        float hover = this.hoverAnim.current;
        if (0.001f < hover) {
            InputRow.drawText(renderer, this.value, textX, top + 3.0f, 84.0f, 12.0f, -1, InputRow.easeHover(hover) * alpha);
        }
        if (hover < 0.999f) {
            InputRow.drawTextField(renderer, this.text, textX, top + 3.0f, 84.0f, -2039584, (1.0f - hover) * alpha, this.focusedState);
        }
        this.height = top + 18.0f - this.y;
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        return this.mouseClickedAt(mx, my, button, this.x, this.y, this.width);
    }

    public boolean mouseClickedAt(double mx, double my, int button, float px, float py, float pw) {
        if (button != 0) {
            return false;
        }
        float inner = px + pw - 8.0f - 96.0f;
        float top = py + 4.0f;
        if (mx >= (double)inner && mx <= (double)(inner + 96.0f) && my >= (double)top && my <= (double)(top + 18.0f)) {
            this.setFocused(true);
            return true;
        }
        this.setFocused(false);
        return false;
    }

    @Override
    public boolean mouseMoved(double mx, double my, double delta) {
        pointerX = mx;
        pointerY = my;
        return false;
    }

    @Override
    public boolean mouseScrolled(double mx, double my, double amount) {
        pointerX = mx;
        pointerY = my;
        return false;
    }

    public void setFocused(boolean value) {
        if (this.focusedState == value) {
            return;
        }
        this.focusedState = value;
        long time = this.now();
        this.focusAnim.retarget(value ? 1.0f : 0.0f, time);
        this.focusAnim.update(time);
        if (value) {
            InputRow.requestKeyboardFocus(this);
            return;
        }
        InputRow.clearKeyboardFocus(this);
    }

    public void onCommit() {
        if (!this.focusedState) {
            return;
        }
        this.focusedState = false;
        long time = this.now();
        this.focusAnim.retarget(0.0f, time);
        this.focusAnim.update(time);
        InputRow.clearKeyboardFocus(this);
    }

    @Override
    public boolean keyPressed(int keyCode, int modifiers) {
        if (!this.focusedState) {
            return false;
        }
        if (keyCode != 27 && keyCode != 13) {
            InputRow.textKey(this.text, keyCode);
            return true;
        }
        this.onCommit();
        return true;
    }

    @Override
    public boolean keyReleased(int keyCode) {
        return false;
    }

    @Override
    public boolean charTyped(char ch) {
        if (!this.focusedState) {
            return false;
        }
        InputRow.textChar(this.text, ch);
        return true;
    }

    private static void requestKeyboardFocus(InputRow row) {
        textInputOwner = row;
        textInputActive = true;
    }

    private static void clearKeyboardFocus(InputRow row) {
        if (textInputOwner == row || textInputOwner == null) {
            textInputOwner = null;
            textInputActive = false;
        }
    }

    private static float easeHover(float t) {
        float clamped = t < 0.0f ? 0.0f : (t > 1.0f ? 1.0f : t);
        return (float)Math.pow(clamped, 1.7f);
    }

    private static void drawRounded(Object renderer, float px, float py, float pw, float ph, float radius, int color, float alpha) {
    }

    private static void drawOutline(Object renderer, float px, float py, float pw, float ph, float radius, int color, float alpha) {
    }

    private static void drawText(Object renderer, String s, float px, float py, float pw, float size, int color, float alpha) {
    }

    private static void drawTextField(Object renderer, String s, float px, float py, float pw, int color, float alpha, boolean focusedNow) {
    }

    private static void textKey(String s, int keyCode) {
    }

    private static void textChar(String s, char ch) {
    }

    public static final class Anim {
        public float from;
        public float current;
        public float target;
        public float duration;
        public long start;
        public boolean running;

        public Anim(float value, float duration) {
            this.from = value;
            this.current = value;
            this.target = value;
            this.duration = duration;
        }

        public void set(float value) {
            this.from = value;
            this.current = value;
            this.target = value;
            this.running = false;
        }

        public void retarget(float value, long time) {
            if (this.target == value) {
                return;
            }
            this.from = this.value(time);
            this.start = time;
            this.target = value;
            this.running = true;
        }

        public float value(long time) {
            if (!this.running || this.duration <= 0.0f) {
                this.current = this.target;
                this.running = false;
                return this.current;
            }
            float t = (float)((double)(time - this.start) / 1.0E9) / this.duration;
            if (t <= 0.0f) {
                this.current = this.from;
                return this.current;
            }
            if (t >= 1.0f) {
                this.running = false;
                this.current = this.target;
                return this.current;
            }
            this.current = Component.easeOutCubic(t) * (this.target - this.from) + this.from;
            return this.current;
        }

        public void update(long time) {
            this.value(time);
        }
    }
}

