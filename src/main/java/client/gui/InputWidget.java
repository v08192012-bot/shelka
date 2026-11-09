/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.Setting;
import client.gui.Screen;
import client.gui.SettingWidget;

public class InputWidget
extends SettingWidget {
    public static final int VTABLE_RVA = 12605808;
    public static final int NAME_MEASURE_KEY_OFFSET = 104;
    public static final int NAME_MEASURE_OFFSET = 108;
    public static final int DESC_MEASURE_KEY_OFFSET = 112;
    public static final int DESC_MEASURE_OFFSET = 116;
    public static final int MEASURE_LANG_OFFSET = 120;
    public static final int INPUT_SETTING_OFFSET = 128;
    public static final int TEXT_OFFSET = 136;
    public static final int TEXT_SIZE_OFFSET = 152;
    public static final int TEXT_CAP_OFFSET = 160;
    public static final int FONT_SIZE_OFFSET = 168;
    public static final int FIELD_FLAG_OFFSET = 172;
    public static final int MULTILINE_OFFSET = 174;
    public static final int SELECTION_START_OFFSET = 176;
    public static final int SELECTION_END_OFFSET = 184;
    public static final int PLACEHOLDER_OFFSET = 192;
    public static final int PLACEHOLDER_SIZE_OFFSET = 208;
    public static final int PLACEHOLDER_CAP_OFFSET = 216;
    public static final int TEXT_INPUT_OFFSET = 280;
    public static final int VALUE_FIELD_OFFSET = 344;
    public static final int FOCUS_ANIM_OFFSET = 352;
    public static final int FOCUS_ANIM_FROM_OFFSET = 352;
    public static final int FOCUS_ANIM_CURRENT_OFFSET = 356;
    public static final int FOCUS_ANIM_TARGET_OFFSET = 360;
    public static final int FOCUS_ANIM_DURATION_OFFSET = 364;
    public static final int FOCUS_ANIM_EASING_OFFSET = 368;
    public static final int FOCUS_ANIM_LAST_TICK_OFFSET = 376;
    public static final int FOCUS_ANIM_RUNNING_OFFSET = 384;
    public static final int FOCUSED_OFFSET = 392;
    public static final int CACHED_Y_OFFSET = 396;
    public static final int SETTING_NAME_OFFSET = 40;
    public static final int SETTING_DESC_OFFSET = 72;
    public static final int SETTING_VALUE_OFFSET = 232;
    public static final int SETTING_VALUE_SIZE_OFFSET = 248;
    public static final int SETTING_VALUE_CAP_OFFSET = 256;
    public static final int SETTING_PLACEHOLDER_OFFSET = 296;
    public static final int SETTING_PLACEHOLDER_SIZE_OFFSET = 312;
    public static final int SETTING_MULTILINE_OFFSET = 329;
    public static final int EASE_OUT_CUBIC = 0;
    public static final int VTABLE_SLOT_CONTENT_HEIGHT = 12;
    public static final int VTABLE_SLOT_MEASURE = 13;
    public static final int VTABLE_SLOT_ICON = 17;
    public static final int VTABLE_SLOT_ICON_WIDTH = 18;
    public static final int VTABLE_SLOT_ICON_HEIGHT = 19;
    public static final int ICON_ID = 26;
    public static final int ICON_INVALID = 89;
    public static final int HOVER_INPUT = 2;
    public static final int TEXT_ALIGN_LEFT = 0;
    public static final int TEXT_ALIGN_CENTER = 2;
    public static final int KEY_ESCAPE = 27;
    public static final int KEY_ENTER = 13;
    public static final int SOUND_CLICK = 17;
    public static final float FIELD_HEIGHT = 32.0f;
    public static final float FIELD_INSET = 3.0f;
    public static final float FIELD_PAD = 6.0f;
    public static final float TEXT_PAD = 8.0f;
    public static final float FOCUS_ANIM_DURATION = 0.15f;
    public static final float NAME_FONT_SIZE = 14.0f;
    public static final float DESC_FONT_SIZE = 12.0f;
    public static final float ICON_WIDTH = 12.0f;
    public static final float ICON_HEIGHT = 12.0f;
    public static final float ICON_RESERVE = 20.0f;
    public static final float ROW_GAP = 6.0f;
    public static final float ROW_PAD = 8.0f;
    public static final float HALF = 0.5f;
    public static final float ZERO = 0.0f;
    public static final float ONE = 1.0f;
    public static final float NONE = -1.0f;
    public static final float NAME_MEASURE_SCALE = 0.015625f;
    public static final float DESC_MEASURE_SCALE = 14.4f;
    public static final float TEXT_EPSILON = 0.001f;
    public static final String PLACEHOLDER_TEXT = "\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0442\u0435\u043a\u0441\u0442";
    protected Setting inputSetting;
    protected String text = "";
    protected float fontSize = 14.0f;
    protected short fieldFlag;
    protected boolean multiline;
    protected long selectionStart;
    protected long selectionEnd;
    protected String placeholder = "";
    protected Object textInput;
    protected long valueField;
    protected Anim focusAnim;
    protected boolean focused;
    protected float cachedY;
    protected boolean measureLang;
    protected float nameMeasureKey = -1.0f;
    protected float nameMeasure;
    protected float descMeasureKey = -1.0f;
    protected float descMeasure;
    private static boolean languageEnglish;

    public InputWidget(Setting setting) {
        super(setting);
        this.inputSetting = setting;
        this.text = "";
        this.fontSize = 14.0f;
        this.fieldFlag = 0;
        this.multiline = false;
        this.selectionStart = 0L;
        this.selectionEnd = 0L;
        this.placeholder = "";
        this.textInput = null;
        this.valueField = 0L;
        this.focusAnim = Anim.init(0.0f, 0.15f, 0);
        this.focused = false;
        this.cachedY = 0.0f;
        this.measureLang = false;
        this.multiline = InputWidget.settingFlag(setting, 329);
        this.text = InputWidget.settingValueText(setting);
        this.selectionStart = this.text.length();
        this.selectionEnd = this.text.length();
        if (this.textInput != null) {
            InputWidget.notifyTextChanged(this.textInput, this.text);
        }
        InputWidget.setOnChange(this, this.text);
    }

    @Override
    public void dispose() {
        if (Screen.focusedInput == this) {
            Screen.focusedInput = null;
            InputWidget.clearCapture();
        }
        InputWidget.disposeTextInput(this.text);
        super.dispose();
    }

    @Override
    public void render(Object mat, float mouseX, float mouseY, float alpha) {
        float label;
        float description;
        float rowY = this.cachedY;
        if (this.x <= mouseX && mouseX <= this.x + this.width && rowY <= mouseY && mouseY <= rowY + 32.0f && (Screen.focusedWidget == null || Screen.allowHover)) {
            Screen.hoveredWidget = 2;
        }
        if (this.focused) {
            Screen.textInputActive = true;
        }
        if (0.0f < (description = this.drawDescription(mat, label = this.drawLabel(mat, this.width, alpha), this.width))) {
            label = label + 0.0f + description;
        }
        this.cachedY = rowY = label + this.y + 6.0f;
        InputWidget.drawFieldBackdrop(mat, this.x, rowY, this.width);
        float fieldX = this.x + 3.0f;
        float fieldY = this.cachedY + 3.0f;
        float fieldWidth = this.width - 6.0f;
        InputWidget.beginField();
        InputWidget.drawFieldBorder(mat, fieldX, fieldY, fieldWidth);
        float focus = this.focusAnim.advance(this.now());
        if (0.001f < focus) {
            InputWidget.fieldTheme();
            InputWidget.drawFieldFill(mat, fieldX, fieldY, fieldWidth);
        }
        float textY = fieldY + 6.0f;
        InputWidget.setFieldClip(fieldX, textY, fieldWidth, 32.0f);
        if (this.text.length() == 0 && !this.focused) {
            Setting setting = this.inputSetting;
            InputWidget.fieldTheme();
            boolean hasPlaceholder = InputWidget.hasSettingPlaceholder(setting);
            String value = hasPlaceholder ? InputWidget.settingPlaceholder(setting) : PLACEHOLDER_TEXT;
            InputWidget.drawText(mat, 0, value, fieldX + 8.0f, textY, 32.0f, fieldWidth, 0, alpha);
        } else {
            InputWidget.fieldTheme();
            InputWidget.drawTextInput(this.text, mat, fieldX + 8.0f, textY, alpha);
        }
        InputWidget.resetFieldClip();
        this.height = this.cachedY + 32.0f - this.y;
    }

    @Override
    public void layout(Object mat, float x, float y, float alpha) {
    }

    @Override
    public void update() {
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (button != 0) {
            return false;
        }
        if ((double)this.x <= mx && mx <= (double)(this.x + this.width) && (double)this.cachedY <= my && my <= (double)(this.cachedY + 32.0f)) {
            this.setFocused(true);
            return true;
        }
        this.setFocused(false);
        return false;
    }

    @Override
    public boolean mouseReleased(double mx, double my, int button) {
        return false;
    }

    @Override
    public boolean mouseDragged(double mx, double my, int button) {
        return false;
    }

    @Override
    public boolean mouseScrolled(double mx, double my, double amount) {
        return false;
    }

    @Override
    public boolean keyPressed(int key) {
        if (!this.focused) {
            return false;
        }
        if (key != 27 && key != 13) {
            InputWidget.insertKey(this.text, key);
            return true;
        }
        this.focused = false;
        this.focusAnim.retarget(0.0f, this.now());
        InputWidget.notifyFocusLost(this);
        return true;
    }

    @Override
    public boolean keyReleased(int key) {
        return false;
    }

    @Override
    public boolean charTyped(int codePoint) {
        if (!this.focused) {
            return false;
        }
        return InputWidget.insertChar(this.text, codePoint);
    }

    @Override
    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public float contentHeight() {
        float label = this.descriptionHeight(this.width);
        float extra = this.nameHeight(this.width);
        if (0.0f < label) {
            extra = extra + 0.0f + label;
        }
        return extra + 6.0f + 32.0f;
    }

    @Override
    public void measure() {
        this.contentHeight();
    }

    @Override
    public void closeModal() {
    }

    @Override
    public boolean isOpen() {
        return false;
    }

    public int iconId() {
        return 26;
    }

    public float iconWidth() {
        return 12.0f;
    }

    public float iconHeight() {
        return 12.0f;
    }

    @Override
    public void setFocused(boolean value) {
        if (this.focused == value) {
            return;
        }
        this.focused = value;
        float target = 1.0f;
        if (!value) {
            target = 0.0f;
        }
        this.focusAnim.retarget(target, this.now());
        if (value) {
            Screen.focusedInput = this;
            InputWidget.requestTextFocus(this);
            return;
        }
        InputWidget.notifyFocusLost(this);
    }

    @Override
    public boolean isFocused() {
        return this.focused;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String value) {
        this.text = value == null ? "" : value;
    }

    public void commit() {
        this.setFocused(false);
    }

    public void cancel() {
        this.setFocused(false);
    }

    public void blur(String value) {
    }

    private float nameHeight(float width) {
        int icon = this.iconId();
        float reserve = 20.0f;
        if (icon == 89) {
            reserve = 0.0f;
        }
        if ((width -= reserve) <= 0.0f) {
            width = 0.0f;
        }
        if (this.measureLang != languageEnglish) {
            this.measureLang = languageEnglish;
            this.descMeasureKey = -1.0f;
            this.nameMeasureKey = -1.0f;
        }
        if (width != this.nameMeasureKey) {
            this.nameMeasureKey = width;
            String name = InputWidget.settingText(40);
            float measured = InputWidget.measureWrapped(name, 14.0f, width);
            this.nameMeasure = (float)((long)measured) * 0.015625f;
        }
        return this.nameMeasure;
    }

    private float descriptionHeight(float width) {
        if (!InputWidget.hasText(InputWidget.settingText(72))) {
            return 0.0f;
        }
        if (this.measureLang != languageEnglish) {
            this.measureLang = languageEnglish;
            this.descMeasureKey = -1.0f;
            this.nameMeasureKey = -1.0f;
        }
        if (width != this.descMeasureKey) {
            this.descMeasureKey = width;
            String description = InputWidget.settingText(72);
            float measured = InputWidget.measureWrapped(description, 12.0f, width);
            this.descMeasure = (float)((long)measured) * 14.4f;
        }
        return this.descMeasure;
    }

    private float drawLabel(Object mat, float x, float alpha) {
        float extra = this.nameHeight(x);
        int icon = this.iconId();
        float reserve = 20.0f;
        if (icon == 89) {
            reserve = 0.0f;
        }
        if ((x -= reserve) <= 0.0f) {
            x = 0.0f;
        }
        if (icon != 89) {
            float w = this.iconWidth();
            float h = this.iconHeight();
            int color = InputWidget.fieldThemeColor();
            InputWidget.drawIcon(mat, icon, (12.0f - w) * 0.5f + this.x, (14.0f - h) * 0.5f + this.y, w, h, color, alpha);
        }
        int color = InputWidget.fieldThemeColor();
        String name = InputWidget.settingText(40);
        InputWidget.drawText(mat, 2, name, reserve + this.x, this.y, 14.0f, x, color, alpha);
        return extra;
    }

    private float drawDescription(Object mat, float y, float width) {
        if (!InputWidget.hasText(InputWidget.settingText(72))) {
            return 0.0f;
        }
        float height = this.descriptionHeight(width);
        int color = InputWidget.fieldThemeColor();
        String description = InputWidget.settingText(72);
        InputWidget.drawText(mat, 0, description, this.x, y + this.y + 0.0f, 12.0f, height, color, width);
        return height;
    }

    private static boolean settingFlag(Setting setting, int offset) {
        return false;
    }

    private static String settingValueText(Setting setting) {
        return "";
    }

    private static String settingText(int offset) {
        return "";
    }

    private static String settingPlaceholder(Setting setting) {
        return "";
    }

    private static boolean hasSettingPlaceholder(Setting setting) {
        return false;
    }

    private static void setOnChange(InputWidget widget, String value) {
    }

    private static void notifyTextChanged(Object textInput, String value) {
    }

    private static void notifyFocusLost(InputWidget widget) {
    }

    private static void requestTextFocus(InputWidget widget) {
    }

    private static void clearCapture() {
    }

    private static void disposeTextInput(String value) {
    }

    private static void insertKey(String text, int key) {
    }

    private static boolean insertChar(String text, int codePoint) {
        return false;
    }

    private static boolean hasText(String value) {
        int tail;
        int start;
        if (value == null) {
            return false;
        }
        int end = value.length();
        for (start = 0; start < end && InputWidget.isBlank(value.charAt(start)); ++start) {
        }
        if (start == end) {
            return false;
        }
        for (tail = end; tail > start && InputWidget.isBlank(value.charAt(tail - 1)); --tail) {
        }
        return tail != start;
    }

    private static boolean isBlank(char c) {
        return c == ' ' || (c - 9 & 0xFA) == 0 && c != '\u000e';
    }

    private static float measureWrapped(String text, float size, float width) {
        return 0.0f;
    }

    private static void drawIcon(Object mat, int icon, float x, float y, float w, float h, int color, float alpha) {
    }

    private static void drawText(Object mat, int align, String text, float x, float y, float size, float maxWidth, int color, float alpha) {
    }

    private static void drawFieldBackdrop(Object mat, float x, float y, float width) {
    }

    private static void drawFieldBorder(Object mat, float x, float y, float width) {
    }

    private static void drawFieldFill(Object mat, float x, float y, float width) {
    }

    private static void drawTextInput(String text, Object mat, float x, float y, float alpha) {
    }

    private static void beginField() {
    }

    private static void setFieldClip(float x, float y, float w, float h) {
    }

    private static void resetFieldClip() {
    }

    private static void fieldTheme() {
    }

    private static int fieldThemeColor() {
        return 0;
    }

    @Override
    protected long now() {
        return System.nanoTime();
    }

    public static final class Anim {
        public float from;
        public float current;
        public float target;
        public float duration;
        public int easing;
        public long lastTick;
        public boolean animating;

        public Anim() {
        }

        public Anim(float value, float seconds, int easing) {
            this.from = value;
            this.current = value;
            this.target = value;
            this.duration = seconds;
            this.easing = easing;
        }

        public static Anim init(float value, float seconds, int easing) {
            Anim anim = new Anim(value, seconds, easing);
            anim.lastTick = System.nanoTime();
            anim.animating = false;
            return anim;
        }

        public void retarget(float target, long time) {
            if (this.target == target) {
                return;
            }
            this.from = this.advance(time);
            this.lastTick = time;
            this.target = target;
            this.animating = true;
        }

        public float advance(long time) {
            if (!this.animating || this.duration <= 0.0f) {
                this.current = this.target;
                this.animating = false;
                return this.current;
            }
            float k = (float)((double)(time - this.lastTick) / 1.0E9) / this.duration;
            if (k <= 0.0f) {
                this.current = this.from;
                return this.current;
            }
            if (k >= 1.0f) {
                this.animating = false;
                this.current = this.target;
                return this.current;
            }
            this.current = Anim.ease(this.easing, k) * (this.target - this.from) + this.from;
            return this.current;
        }

        private static float ease(int easing, float t) {
            float inv = 1.0f - t;
            return 1.0f - inv * inv * inv;
        }
    }
}

