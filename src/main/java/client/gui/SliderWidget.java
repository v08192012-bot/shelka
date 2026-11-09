/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.Setting;
import client.gui.Screen;
import client.gui.SettingWidget;

public class SliderWidget
extends SettingWidget {
    public static final int VTABLE_RVA = 12606632;
    public static final int NAME_MEASURE_KEY_OFFSET = 104;
    public static final int NAME_MEASURE_OFFSET = 108;
    public static final int DESC_MEASURE_KEY_OFFSET = 112;
    public static final int DESC_MEASURE_OFFSET = 116;
    public static final int MEASURE_LANG_OFFSET = 120;
    public static final int SLIDER_SETTING_OFFSET = 128;
    public static final int DRAG_ANIM_OFFSET = 136;
    public static final int DRAG_ANIM_FROM_OFFSET = 136;
    public static final int DRAG_ANIM_CURRENT_OFFSET = 140;
    public static final int DRAG_ANIM_TARGET_OFFSET = 144;
    public static final int DRAG_ANIM_DURATION_OFFSET = 148;
    public static final int DRAG_ANIM_EASING_OFFSET = 152;
    public static final int DRAG_ANIM_LAST_TICK_OFFSET = 160;
    public static final int DRAG_ANIM_RUNNING_OFFSET = 168;
    public static final int DRAGGING_OFFSET = 176;
    public static final int DISPLAY_VALUE_OFFSET = 180;
    public static final int DELTA_STAMP_OFFSET = 184;
    public static final int LAST_TEXT_VALUE_OFFSET = 192;
    public static final int TEXT_OFFSET = 200;
    public static final int TEXT_SIZE_OFFSET = 216;
    public static final int TEXT_CAP_OFFSET = 224;
    public static final int TEXT_DIRTY_OFFSET = 232;
    public static final int TEXT_SETTING_VALUE_OFFSET = 240;
    public static final int TEXT_WIDTH_OFFSET = 248;
    public static final int LANG_FLAG_OFFSET = 252;
    public static final int SETTING_NAME_OFFSET = 40;
    public static final int SETTING_DESC_OFFSET = 72;
    public static final int SETTING_VALUE_TEXT_OFFSET = 272;
    public static final int SETTING_VALUE_OFFSET = 232;
    public static final int SETTING_MIN_OFFSET = 248;
    public static final int SETTING_MAX_OFFSET = 256;
    public static final int EASE_OUT_EXPO = 1;
    public static final int VTABLE_SLOT_CONTENT_HEIGHT = 12;
    public static final int VTABLE_SLOT_MEASURE = 13;
    public static final int VTABLE_SLOT_ICON = 17;
    public static final int VTABLE_SLOT_ICON_WIDTH = 18;
    public static final int VTABLE_SLOT_ICON_HEIGHT = 19;
    public static final int ICON_ID = 64;
    public static final int ICON_INVALID = 89;
    public static final int HOVER_SLIDER = 3;
    public static final int TEXT_ALIGN_CENTER = 2;
    public static final int TEXT_ALIGN_LEFT = 0;
    public static final int SOUND_CLICK = 17;
    public static final float VALUE_EASE_RATE = -14.0f;
    public static final float DRAG_ANIM_DURATION = 0.22f;
    public static final float NAME_FONT_SIZE = 14.0f;
    public static final float DESC_FONT_SIZE = 12.0f;
    public static final float ICON_WIDTH = 16.0f;
    public static final float ICON_HEIGHT = 16.0f;
    public static final float ICON_RESERVE = 20.0f;
    public static final float ROW_PAD = 8.0f;
    public static final float ROW_GAP = 6.0f;
    public static final float HIT_PAD = 10.0f;
    public static final float KNOB_BASE = 14.0f;
    public static final float KNOB_GROWTH = 4.0f;
    public static final float KNOB_LIFT = 2.0f;
    public static final float HALF = 0.5f;
    public static final float ZERO = 0.0f;
    public static final float ONE = 1.0f;
    public static final float NONE = -1.0f;
    public static final float NAME_MEASURE_SCALE = 0.015625f;
    public static final float DESC_MEASURE_SCALE = 14.4f;
    public static final float DELTA_MAX = 0.1f;
    public static final float DELTA_FALLBACK = 0.01666667f;
    public static final long DELTA_SCALE = 1000000000L;
    public static final String FORMAT_TEMPLATE = "{:.{}f}{}";
    protected Setting sliderSetting;
    protected Anim dragAnim;
    protected boolean dragging;
    protected float displayedValue;
    protected long deltaStamp;
    protected float lastTextValue;
    protected String text = "";
    protected boolean textDirty;
    protected double textSettingValue;
    protected float textWidth = -1.0f;
    protected boolean langFlag;
    protected float nameMeasureKey = -1.0f;
    protected float nameMeasure;
    protected float descMeasureKey = -1.0f;
    protected float descMeasure;
    private static boolean languageEnglish;

    public SliderWidget(Setting setting) {
        super(setting);
        this.sliderSetting = setting;
        this.dragAnim = Anim.init(0.0f, 0.22f, 1);
        this.dragging = false;
        this.displayedValue = (float)this.settingValue();
        this.deltaStamp = -1L;
        this.lastTextValue = 0.0f;
        this.text = "";
        this.textDirty = false;
        this.textSettingValue = 0.0;
        this.textWidth = -1.0f;
        this.langFlag = false;
        this.nameMeasureKey = -1.0f;
        this.nameMeasure = 0.0f;
        this.descMeasureKey = -1.0f;
        this.descMeasure = 0.0f;
    }

    @Override
    public void dispose() {
        SliderWidget.clearString(this.text);
        SliderWidget.freeString(this.text);
        super.dispose();
    }

    @Override
    public void render(Object mat, float mouseX, float mouseY, float alpha) {
        double max;
        double min;
        double t;
        double target = this.settingValue();
        float delta = this.deltaSeconds();
        float shown = this.displayedValue;
        float decay = (float)Math.exp(delta * -14.0f);
        this.displayedValue = shown = (1.0f - decay) * ((float)target - shown) + shown;
        if (this.langFlag != languageEnglish) {
            this.langFlag = languageEnglish;
            this.textDirty = false;
            this.textWidth = -1.0f;
        }
        if (!this.textDirty || shown != this.lastTextValue) {
            String layout = SliderWidget.settingText(272);
            String formatted = SliderWidget.formatValue(layout, shown, target);
            SliderWidget.assignString(this, formatted);
            this.lastTextValue = shown;
            this.textDirty = true;
        }
        float valueWidth = this.valueTextWidth();
        float extra = this.drawLabel(mat, this.width - valueWidth - 8.0f, alpha);
        float description = this.drawDescription(mat, extra, alpha);
        SliderWidget.layoutValueText(mat, this.width + this.x, this.y, this.text);
        float bottom = 10.0f;
        if (0.0f < description) {
            extra = extra + 0.0f + description;
        }
        float rowY = extra + this.y + 6.0f;
        if (!this.dragging) {
            if (this.x <= mouseX && mouseX <= this.x + this.width && rowY - 10.0f <= mouseY && mouseY <= rowY - 10.0f + 10.0f + 10.0f && (Screen.focusedWidget == null || Screen.allowHover)) {
                Screen.hoveredWidget = 1;
            }
        } else {
            Screen.hoveredWidget = 3;
        }
        if ((t = ((double)shown - (min = this.settingMin())) / ((max = this.settingMax()) - min)) < 0.0) {
            t = 0.0;
        }
        if (t > 1.0) {
            t = 1.0;
        }
        float knobTrackWidth = this.width;
        float animTarget = 1.0f;
        if (!this.dragging) {
            animTarget = 0.0f;
        }
        if (this.dragAnim.target != animTarget) {
            long time = this.now();
            this.dragAnim.from = this.dragAnim.advance(time);
            this.dragAnim.target = animTarget;
            this.dragAnim.lastTick = time;
            this.dragAnim.animating = true;
        }
        float anim = this.dragAnim.advance(this.now());
        float knobSize = anim * 4.0f + 14.0f;
        float baseX = this.x;
        float half = knobSize * 0.5f;
        SliderWidget.sliderTheme();
        SliderWidget.sliderTheme();
        SliderWidget.drawSliderTrack(mat, this.x, rowY, this.width);
        SliderWidget.sliderTheme();
        SliderWidget.sliderTheme();
        SliderWidget.drawSliderKnob(mat, (float)((double)knobTrackWidth * t) + baseX - half, rowY - 2.0f, knobSize);
        this.height = rowY + bottom - this.y;
    }

    @Override
    public void layout(Object mat, float x, float y, float alpha) {
    }

    @Override
    public void update() {
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (button == 0) {
            float rowY;
            float valueWidth = this.valueTextWidth();
            float description = this.descriptionHeight(this.width);
            float extra = this.nameHeight(this.width - valueWidth - 8.0f);
            if (0.0f < description) {
                extra = extra + 0.0f + description;
            }
            if ((double)this.x <= mx && mx <= (double)(this.x + this.width) && (double)((rowY = extra + this.y + 6.0f) - 10.0f) <= my && my <= (double)(rowY + 10.0f)) {
                this.dragging = true;
                this.applyValueFromMouse(mx);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean mouseReleased(double mx, double my, int button) {
        if (!this.dragging) {
            return false;
        }
        this.dragging = false;
        return true;
    }

    @Override
    public boolean mouseDragged(double mx, double my, int button) {
        if (!this.dragging) {
            return false;
        }
        this.applyValueFromMouse(mx);
        return true;
    }

    @Override
    public boolean mouseScrolled(double mx, double my, double amount) {
        return false;
    }

    @Override
    public boolean keyPressed(int key) {
        return false;
    }

    @Override
    public boolean keyReleased(int key) {
        return false;
    }

    @Override
    public boolean charTyped(int codePoint) {
        return false;
    }

    @Override
    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public float contentHeight() {
        float valueWidth = this.valueTextWidth();
        float extra = this.nameHeight(this.width - valueWidth - 8.0f);
        float description = this.descriptionHeight(this.width);
        if (0.0f < description) {
            extra = extra + 0.0f + description;
        }
        return extra + 6.0f + 10.0f;
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
        return 64;
    }

    public float iconWidth() {
        return 16.0f;
    }

    public float iconHeight() {
        return 16.0f;
    }

    private void applyValueFromMouse(double mx) {
        double before = this.settingValue();
        double min = this.settingMin();
        double max = this.settingMax();
        double t = (mx - (double)this.x) / (double)this.width;
        if (t < 0.0) {
            t = 0.0;
        }
        if (t > 1.0) {
            t = 1.0;
        }
        SliderWidget.setSettingValue(this.sliderSetting, (max - min) * t + min);
        if (this.settingValue() != before) {
            SliderWidget.playSound(17);
        }
    }

    private float deltaSeconds() {
        long time;
        long last = this.deltaStamp;
        this.deltaStamp = time = this.now();
        if (last < 0L) {
            return 0.01666667f;
        }
        float seconds = (float)((double)(time - last) / 1.0E9);
        float result = 0.0f;
        if (0.0 <= (double)seconds && (double)seconds <= (double)0.1f) {
            result = seconds;
        }
        return result;
    }

    private float valueTextWidth() {
        if (this.langFlag != languageEnglish) {
            this.langFlag = languageEnglish;
            this.textDirty = false;
            this.textWidth = -1.0f;
        }
        if (this.textWidth < 0.0f || this.settingValue() != this.textSettingValue) {
            String layout = SliderWidget.settingText(272);
            String pattern = SliderWidget.buildFormat(layout);
            String formatted = SliderWidget.formatValue(pattern, this.displayedValue, this.settingValue());
            String token = SliderWidget.firstToken(formatted);
            this.textWidth = SliderWidget.measureText(token, 12.0f) + 16.0f;
            this.textSettingValue = this.settingValue();
        }
        return this.textWidth;
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
        if (this.langFlag != languageEnglish) {
            this.langFlag = languageEnglish;
            this.descMeasureKey = -1.0f;
            this.nameMeasureKey = -1.0f;
        }
        if (width != this.nameMeasureKey) {
            this.nameMeasureKey = width;
            String name = SliderWidget.settingText(40);
            float measured = SliderWidget.measureWrapped(name, 14.0f, width);
            this.nameMeasure = (float)((long)measured) * 0.015625f;
        }
        return this.nameMeasure;
    }

    private float descriptionHeight(float width) {
        if (!SliderWidget.hasText(SliderWidget.settingText(72))) {
            return 0.0f;
        }
        if (this.langFlag != languageEnglish) {
            this.langFlag = languageEnglish;
            this.descMeasureKey = -1.0f;
            this.nameMeasureKey = -1.0f;
        }
        if (width != this.descMeasureKey) {
            this.descMeasureKey = width;
            String description = SliderWidget.settingText(72);
            float measured = SliderWidget.measureWrapped(description, 12.0f, width);
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
            int color = SliderWidget.themeTextColor();
            SliderWidget.drawIcon(mat, icon, (16.0f - w) * 0.5f + this.x, (14.0f - h) * 0.5f + this.y, w, h, color, alpha);
        }
        int color = SliderWidget.themeTextColor();
        String name = SliderWidget.settingText(40);
        SliderWidget.drawText(mat, 2, name, reserve + this.x, this.y, 14.0f, x, color, alpha);
        return extra;
    }

    private float drawDescription(Object mat, float y, float alpha) {
        if (!SliderWidget.hasText(SliderWidget.settingText(72))) {
            return 0.0f;
        }
        float height = this.descriptionHeight(this.width);
        int color = SliderWidget.themeTextColor();
        String description = SliderWidget.settingText(72);
        SliderWidget.drawText(mat, 0, description, this.x, y + this.y + 0.0f, 12.0f, height, color, alpha);
        return height;
    }

    private double settingValue() {
        return SliderWidget.settingValue(this.sliderSetting);
    }

    private double settingMin() {
        return SliderWidget.settingMin(this.sliderSetting);
    }

    private double settingMax() {
        return SliderWidget.settingMax(this.sliderSetting);
    }

    private static double settingValue(Setting setting) {
        return 0.0;
    }

    private static double settingMin(Setting setting) {
        return 0.0;
    }

    private static double settingMax(Setting setting) {
        return 0.0;
    }

    private static void setSettingValue(Setting setting, double value) {
    }

    private static String settingText(int offset) {
        return "";
    }

    private static boolean hasText(String value) {
        int tail;
        int start;
        if (value == null) {
            return false;
        }
        int end = value.length();
        for (start = 0; start < end && SliderWidget.isBlank(value.charAt(start)); ++start) {
        }
        if (start == end) {
            return false;
        }
        for (tail = end; tail > start && SliderWidget.isBlank(value.charAt(tail - 1)); --tail) {
        }
        return tail != start;
    }

    private static boolean isBlank(char c) {
        return c == ' ' || (c - 9 & 0xFA) == 0 && c != '\u000e';
    }

    private static String buildFormat(String layout) {
        return FORMAT_TEMPLATE;
    }

    private static String formatValue(String pattern, float value, double target) {
        return pattern;
    }

    private static String firstToken(String value) {
        int tail;
        int start;
        if (value == null) {
            return "";
        }
        int end = value.length();
        for (start = 0; start < end && SliderWidget.isBlank(value.charAt(start)); ++start) {
        }
        if (start == end) {
            return "";
        }
        for (tail = end; tail > start && SliderWidget.isBlank(value.charAt(tail - 1)); --tail) {
        }
        return value.substring(start, tail);
    }

    private static float measureText(String text, float size) {
        return 0.0f;
    }

    private static float measureWrapped(String text, float size, float width) {
        return 0.0f;
    }

    private static void assignString(SliderWidget widget, String value) {
        widget.text = value == null ? "" : value;
    }

    private static void clearString(String value) {
    }

    private static void freeString(String value) {
    }

    private static void playSound(int id) {
    }

    private static void layoutValueText(Object mat, float x, float y, String text) {
    }

    private static void drawIcon(Object mat, int icon, float x, float y, float w, float h, int color, float alpha) {
    }

    private static void drawText(Object mat, int align, String text, float x, float y, float size, float maxWidth, int color, float alpha) {
    }

    private static void drawSliderTrack(Object mat, float x, float y, float w) {
    }

    private static void drawSliderKnob(Object mat, float x, float y, float size) {
    }

    private static void sliderTheme() {
    }

    private static int themeTextColor() {
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
            if (t >= 1.0f) {
                return 1.0f;
            }
            return 1.0f - (float)Math.exp(t * -6.931472f);
        }
    }
}

