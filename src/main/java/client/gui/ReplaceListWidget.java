/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.Setting;
import client.gui.SettingWidget;

public class ReplaceListWidget
extends SettingWidget {
    public static final int VTABLE_RVA = 12606296;
    public static final int NAME_MEASURE_KEY_OFFSET = 104;
    public static final int NAME_MEASURE_OFFSET = 108;
    public static final int DESC_MEASURE_KEY_OFFSET = 112;
    public static final int DESC_MEASURE_OFFSET = 116;
    public static final int MEASURE_LANG_OFFSET = 120;
    public static final int LIST_SETTING_OFFSET = 128;
    public static final int ROWS_BEGIN_OFFSET = 136;
    public static final int ROWS_END_OFFSET = 144;
    public static final int ROWS_CAP_OFFSET = 152;
    public static final int CACHED_Y_OFFSET = 160;
    public static final int ROW_FIRST_OFFSET = 0;
    public static final int ROW_SECOND_OFFSET = 8;
    public static final int ROW_STEP_ANIM_OFFSET = 16;
    public static final int ROW_STEP_FROM_OFFSET = 16;
    public static final int ROW_STEP_CURRENT_OFFSET = 20;
    public static final int ROW_STEP_TARGET_OFFSET = 24;
    public static final int ROW_STEP_DURATION_OFFSET = 28;
    public static final int ROW_STEP_EASING_OFFSET = 32;
    public static final int ROW_STEP_LAST_TICK_OFFSET = 40;
    public static final int ROW_STEP_RUNNING_OFFSET = 48;
    public static final int ROW_FADE_ANIM_OFFSET = 56;
    public static final int ROW_FADE_FROM_OFFSET = 56;
    public static final int ROW_FADE_CURRENT_OFFSET = 60;
    public static final int ROW_FADE_TARGET_OFFSET = 64;
    public static final int ROW_FADE_DURATION_OFFSET = 68;
    public static final int ROW_FADE_EASING_OFFSET = 72;
    public static final int ROW_FADE_LAST_TICK_OFFSET = 80;
    public static final int ROW_FADE_RUNNING_OFFSET = 88;
    public static final int ROW_FLAG_OFFSET = 96;
    public static final int ROW_SIZE = 104;
    public static final int SETTING_NAME_OFFSET = 40;
    public static final int SETTING_DESC_OFFSET = 72;
    public static final int SETTING_ENTRIES_BEGIN_OFFSET = 232;
    public static final int SETTING_ENTRIES_END_OFFSET = 240;
    public static final int SETTING_ENTRY_SIZE = 64;
    public static final int TEXT_INPUT_TEXT_OFFSET = 96;
    public static final int TEXT_INPUT_TEXT_SIZE_OFFSET = 112;
    public static final int TEXT_INPUT_FOCUSED_OFFSET = 356;
    public static final int TEXT_INPUT_X_OFFSET = 8;
    public static final int TEXT_INPUT_Y_OFFSET = 12;
    public static final int TEXT_INPUT_WIDTH_OFFSET = 16;
    public static final int EASE_OUT_CUBIC = 0;
    public static final int VTABLE_SLOT_CONTENT_HEIGHT = 12;
    public static final int VTABLE_SLOT_MEASURE = 13;
    public static final int VTABLE_SLOT_ICON = 17;
    public static final int VTABLE_SLOT_ICON_WIDTH = 18;
    public static final int VTABLE_SLOT_ICON_HEIGHT = 19;
    public static final int ICON_ID = 26;
    public static final int ARROW_ICON = 60;
    public static final int ICON_INVALID = 89;
    public static final int TEXT_ALIGN_LEFT = 0;
    public static final int TEXT_ALIGN_CENTER = 2;
    public static final int KEY_ESCAPE = 27;
    public static final float ROW_SPACING = 40.0f;
    public static final float ROW_GAP = 6.0f;
    public static final float EDGE_PAD = 8.0f;
    public static final float EDGE_INSET = 16.0f;
    public static final float ARROW_GAP = 28.0f;
    public static final float ARROW_SIZE = 12.0f;
    public static final float ARROW_OFFSET_X = 2.0f;
    public static final float ARROW_OFFSET_Y = 10.0f;
    public static final float NAME_FONT_SIZE = 14.0f;
    public static final float DESC_FONT_SIZE = 12.0f;
    public static final float FIELD_FONT_SIZE = 14.0f;
    public static final float FIELD_TEXT_SIZE = 12.0f;
    public static final float ICON_WIDTH = 12.0f;
    public static final float ICON_HEIGHT = 12.0f;
    public static final float ICON_RESERVE = 20.0f;
    public static final float STEP_EPSILON = 0.001f;
    public static final float FADE_EPSILON = 0.001f;
    public static final float HIT_HALF = 0.5f;
    public static final float HALF = 0.5f;
    public static final float ZERO = 0.0f;
    public static final float ONE = 1.0f;
    public static final float NONE = -1.0f;
    public static final float NAME_MEASURE_SCALE = 0.015625f;
    public static final float DESC_MEASURE_SCALE = 14.4f;
    public static final String SEARCH_PLACEHOLDER = "\u0427\u0442\u043e \u0438\u0441\u043a\u0430\u0442\u044c";
    public static final String REPLACE_PLACEHOLDER = "\u0417\u0430\u043c\u0435\u043d\u0430";
    public static final String EMPTY = "";
    protected Setting listSetting;
    protected Row[] rows = new Row[0];
    protected float cachedY;
    protected float nameMeasureKey = -1.0f;
    protected float nameMeasure;
    protected float descMeasureKey = -1.0f;
    protected float descMeasure;
    private static boolean languageEnglish;
    protected boolean languageCache;
    public static final float ROW_STEP_DURATION = 0.22f;

    public ReplaceListWidget(Setting setting) {
        super(setting);
        int count;
        this.listSetting = setting;
        this.rows = new Row[0];
        this.cachedY = 0.0f;
        this.nameMeasureKey = -1.0f;
        this.nameMeasure = 0.0f;
        this.descMeasureKey = -1.0f;
        this.descMeasure = 0.0f;
        int index = count = ReplaceListWidget.settingEntryCount(setting);
        while (index != 0) {
            String first = ReplaceListWidget.settingEntryText(setting, --index, 0);
            String second = ReplaceListWidget.settingEntryText(setting, index, 1);
            this.insertTop(first, second, true);
        }
        this.insertTop(EMPTY, EMPTY, true);
    }

    @Override
    public void dispose() {
        ReplaceListWidget.disposeRows();
        super.dispose();
    }

    @Override
    public void render(Object mat, float mouseX, float mouseY, float alpha) {
        float label = this.drawLabel(mat, this.width, alpha);
        float description = this.drawDescription(mat, label, this.width, alpha);
        if (0.0f < description) {
            label = label + 0.0f + description;
        }
        this.cachedY = label + this.y + 6.0f;
        if (this.rows.length != 0 && ReplaceListWidget.textLength(this.rows[0].first) != 0 && ReplaceListWidget.textLength(this.rows[0].second) != 0) {
            this.insertTop(EMPTY, EMPTY, false);
        }
        for (int index = 1; index < this.rows.length; ++index) {
            Row row = this.rows[index];
            if (row.flag60 || ReplaceListWidget.textLength(row.first) != 0 || ReplaceListWidget.isFocused(row.first) || ReplaceListWidget.isFocused(row.second)) continue;
            row.flag60 = true;
            if (row.stepAnim.target == 0.0f) continue;
            long time = this.now();
            row.stepAnim.from = row.stepAnim.advance(time);
            row.stepAnim.target = 0.0f;
            row.stepAnim.lastTick = time;
            row.stepAnim.animating = true;
        }
        float spacing = 40.0f;
        float rowY = this.cachedY;
        float halfWidth = (this.width - 16.0f - 16.0f) * 0.5f;
        float cursor = 8.0f;
        float gap = 16.0f;
        for (int i = 0; i < this.rows.length; ++i) {
            Row row = this.rows[i];
            float step = row.stepAnim.advance(this.now());
            if (!(0.001f < step)) continue;
            float target = 1.0f;
            if (ReplaceListWidget.textLength(row.first) == 0 && ReplaceListWidget.textLength(row.second) == 0) {
                target = 0.0f;
            }
            if (row.fadeAnim.target != target) {
                long time = this.now();
                row.fadeAnim.from = row.fadeAnim.advance(time);
                row.fadeAnim.target = target;
                row.fadeAnim.lastTick = time;
                row.fadeAnim.animating = true;
            }
            float fade = row.fadeAnim.advance(this.now());
            float full = this.width;
            float left = this.x;
            float firstWidth = (halfWidth - full) * fade + full;
            ReplaceListWidget.setTextInputBounds(row.first, left, rowY, firstWidth);
            cursor = left + firstWidth + cursor;
            float secondX = cursor + gap + 8.0f;
            float secondWidth = left + full - secondX;
            ReplaceListWidget.renderRow(row.first, mat, mouseX, mouseY, step * alpha);
            if (0.001f < fade) {
                float arrowAlpha = step * alpha * fade;
                ReplaceListWidget.rowTheme();
                ReplaceListWidget.drawIcon(mat, 60, cursor + 2.0f, rowY + 10.0f, 12.0f, 12.0f, ReplaceListWidget.rowThemeColor(), arrowAlpha);
                if (28.0f < secondWidth) {
                    ReplaceListWidget.setTextInputBounds(row.second, secondX, rowY, secondWidth);
                    ReplaceListWidget.renderRow(row.second, mat, mouseX, mouseY, arrowAlpha);
                }
            }
            rowY += step * spacing;
            gap = 16.0f;
            cursor = 8.0f;
        }
        this.compactRows();
        float total = 0.0f;
        for (int i = 0; i < this.rows.length; ++i) {
            total += this.rows[i].fadeAnim.current * spacing;
        }
        if ((total -= cursor) <= 0.0f) {
            total = 0.0f;
        }
        this.height = this.cachedY - this.y + total;
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
        boolean handled = false;
        for (int i = 0; i < this.rows.length; ++i) {
            Row row = this.rows[i];
            if (row.flag60) continue;
            if (ReplaceListWidget.hitTest(row.first, mx, my) || handled) {
                handled = true;
            }
            if (row.fadeAnim.current <= 0.5f) {
                if (!ReplaceListWidget.isFocused(row.second)) continue;
                ReplaceListWidget.blurTextInput(row.second);
                continue;
            }
            if (!ReplaceListWidget.hitTest(row.second, mx, my) && !handled) continue;
            handled = true;
        }
        return handled;
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
    public boolean keyPressed(int key, int modifiers) {
        for (int i = 0; i < this.rows.length; ++i) {
            Row row = this.rows[i];
            if (ReplaceListWidget.isFocused(row.first)) {
                if (key == 27) {
                    ReplaceListWidget.blurTextInput(row.first);
                    return true;
                }
                if (ReplaceListWidget.insertKey(row.first, key, modifiers)) {
                    return true;
                }
            }
            if (!ReplaceListWidget.isFocused(row.second)) continue;
            if (key == 27) {
                ReplaceListWidget.blurTextInput(row.second);
                return true;
            }
            if (!ReplaceListWidget.insertKey(row.second, key, modifiers)) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean keyReleased(int key) {
        return false;
    }

    @Override
    public boolean charTyped(int codePoint) {
        for (int i = 0; i < this.rows.length; ++i) {
            Row row = this.rows[i];
            if (ReplaceListWidget.isFocused(row.first) && ReplaceListWidget.insertChar(row.first, codePoint)) {
                return true;
            }
            if (!ReplaceListWidget.isFocused(row.second) || !ReplaceListWidget.insertChar(row.second, codePoint)) continue;
            return true;
        }
        return false;
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
        float total = 0.0f;
        for (int i = 0; i < this.rows.length; ++i) {
            total += this.rows[i].fadeAnim.current * 40.0f;
        }
        if ((total -= 8.0f) <= 0.0f) {
            total = 0.0f;
        }
        if (0.0f < label) {
            extra = extra + 0.0f + label;
        }
        return extra + 6.0f + total;
    }

    @Override
    public void measure() {
        this.measureContentHeight();
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

    public void insertTop(String first, String second, boolean animate) {
        float start = 1.0f;
        if (!animate) {
            start = 0.0f;
        }
        Row row = new Row();
        row.first = ReplaceListWidget.createTextInput(this.width, 40.0f, SEARCH_PLACEHOLDER, 14.0f, 12.0f);
        row.second = ReplaceListWidget.createTextInput(0.0f, 40.0f, REPLACE_PLACEHOLDER, 14.0f, 12.0f);
        row.stepAnim = Anim.init(start, 0.22f, 0);
        row.fadeAnim = Anim.init(animate ? 1.0f : 0.0f, 0.22f, 0);
        ReplaceListWidget.setText(row.first, first);
        ReplaceListWidget.resetTextCursor(row.first);
        ReplaceListWidget.setText(row.second, second);
        ReplaceListWidget.resetTextCursor(row.second);
        if (!animate && start != 1.0f) {
            long time = this.now();
            row.fadeAnim.from = row.fadeAnim.advance(time);
            row.fadeAnim.target = 1.0f;
            row.fadeAnim.lastTick = time;
            row.fadeAnim.animating = true;
        }
        ReplaceListWidget.setOnTextChanged(row.first, this);
        ReplaceListWidget.setOnTextChanged(row.second, this);
        ReplaceListWidget.setOnSubmit(row.first, row.second);
        ReplaceListWidget.setOnSubmit(row.second, row.second);
        this.insertRow(0, row);
    }

    private void measureContentHeight() {
        float label = this.descriptionHeight(this.width);
        float extra = this.nameHeight(this.width);
        float count = 0.0f;
        for (int i = 0; i < this.rows.length; ++i) {
            if (this.rows[i].flag60) continue;
            count += 1.0f;
        }
        float gap = count - 1.0f;
        if (gap <= 0.0f) {
            gap = 0.0f;
        }
        if (0.0f < label) {
            extra = extra + 0.0f + label;
        }
        this.height = extra + 6.0f + count * 40.0f + gap * 8.0f;
    }

    private void insertRow(int index, Row row) {
        int i;
        Row[] next = new Row[this.rows.length + 1];
        for (i = 0; i < index; ++i) {
            next[i] = this.rows[i];
        }
        next[index] = row;
        for (i = index; i < this.rows.length; ++i) {
            next[i + 1] = this.rows[i];
        }
        this.rows = next;
    }

    private void compactRows() {
        int write = 0;
        for (int i = 0; i < this.rows.length; ++i) {
            Row row = this.rows[i];
            if (i != 0 && !row.flag60 && ReplaceListWidget.textLength(row.first) == 0 && ReplaceListWidget.textLength(row.second) == 0 && !ReplaceListWidget.isFocused(row.first) && !ReplaceListWidget.isFocused(row.second)) continue;
            this.rows[write] = row;
            ++write;
        }
        if (write != this.rows.length) {
            Row[] next = new Row[write];
            for (int i = 0; i < write; ++i) {
                next[i] = this.rows[i];
            }
            this.rows = next;
        }
    }

    private static void disposeRows() {
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
        if (this.langFlag() != languageEnglish) {
            this.setLangFlag(languageEnglish);
            this.descMeasureKey = -1.0f;
            this.nameMeasureKey = -1.0f;
        }
        if (width != this.nameMeasureKey) {
            this.nameMeasureKey = width;
            String name = ReplaceListWidget.settingText(40);
            float measured = ReplaceListWidget.measureWrapped(name, 14.0f, width);
            this.nameMeasure = (float)((long)measured) * 0.015625f;
        }
        return this.nameMeasure;
    }

    private float descriptionHeight(float width) {
        if (!ReplaceListWidget.hasText(ReplaceListWidget.settingText(72))) {
            return 0.0f;
        }
        if (this.langFlag() != languageEnglish) {
            this.setLangFlag(languageEnglish);
            this.descMeasureKey = -1.0f;
            this.nameMeasureKey = -1.0f;
        }
        if (width != this.descMeasureKey) {
            this.descMeasureKey = width;
            String description = ReplaceListWidget.settingText(72);
            float measured = ReplaceListWidget.measureWrapped(description, 12.0f, width);
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
            int color = ReplaceListWidget.rowThemeColor();
            ReplaceListWidget.drawIcon(mat, icon, (12.0f - w) * 0.5f + this.x, (14.0f - h) * 0.5f + this.y, w, h, color, alpha);
        }
        int color = ReplaceListWidget.rowThemeColor();
        String name = ReplaceListWidget.settingText(40);
        ReplaceListWidget.drawText(mat, 2, name, reserve + this.x, this.y, 14.0f, x, color, alpha);
        return extra;
    }

    private float drawDescription(Object mat, float y, float width, float alpha) {
        if (!ReplaceListWidget.hasText(ReplaceListWidget.settingText(72))) {
            return 0.0f;
        }
        float height = this.descriptionHeight(width);
        int color = ReplaceListWidget.rowThemeColor();
        String description = ReplaceListWidget.settingText(72);
        ReplaceListWidget.drawText(mat, 0, description, this.x, y + this.y + 0.0f, 12.0f, height, color, alpha);
        return height;
    }

    private boolean langFlag() {
        return this.languageCache;
    }

    private void setLangFlag(boolean value) {
        this.languageCache = value;
    }

    private static int settingEntryCount(Setting setting) {
        return 0;
    }

    private static String settingEntryText(Setting setting, int index, int which) {
        return EMPTY;
    }

    private static String settingText(int offset) {
        return EMPTY;
    }

    private static boolean hasText(String value) {
        int tail;
        int start;
        if (value == null) {
            return false;
        }
        int end = value.length();
        for (start = 0; start < end && ReplaceListWidget.isBlank(value.charAt(start)); ++start) {
        }
        if (start == end) {
            return false;
        }
        for (tail = end; tail > start && ReplaceListWidget.isBlank(value.charAt(tail - 1)); --tail) {
        }
        return tail != start;
    }

    private static boolean isBlank(char c) {
        return c == ' ' || (c - 9 & 0xFA) == 0 && c != '\u000e';
    }

    private static float measureWrapped(String text, float size, float width) {
        return 0.0f;
    }

    private static Object createTextInput(float width, float height, String placeholder, float fontSize, float textSize) {
        return null;
    }

    private static int textLength(Object textInput) {
        return 0;
    }

    private static boolean isFocused(Object textInput) {
        return false;
    }

    private static void setText(Object textInput, String value) {
    }

    private static void resetTextCursor(Object textInput) {
    }

    private static void setTextInputBounds(Object textInput, float x, float y, float width) {
    }

    private static boolean hitTest(Object textInput, double mx, double my) {
        return false;
    }

    private static boolean insertKey(Object textInput, int key, int modifiers) {
        return false;
    }

    private static boolean insertChar(Object textInput, int codePoint) {
        return false;
    }

    private static void blurTextInput(Object textInput) {
    }

    private static void setOnTextChanged(Object textInput, ReplaceListWidget widget) {
    }

    private static void setOnSubmit(Object textInput, Object next) {
    }

    private static void renderRow(Object textInput, Object mat, float mouseX, float mouseY, float alpha) {
    }

    private static void drawIcon(Object mat, int icon, float x, float y, float w, float h, int color, float alpha) {
    }

    private static void drawText(Object mat, int align, String text, float x, float y, float size, float maxWidth, int color, float alpha) {
    }

    private static void rowTheme() {
    }

    private static int rowThemeColor() {
        return 0;
    }

    @Override
    protected long now() {
        return System.nanoTime();
    }

    private static final class Row {
        Object first;
        Object second;
        Anim stepAnim;
        Anim fadeAnim;
        boolean flag60;

        private Row() {
        }
    }

    public static final class Anim {
        public float from;
        public float current;
        public float target;
        public float duration;
        public int easing;
        public long lastTick;
        public boolean animating;
        public static final float ROW_STEP_DURATION = 0.22f;

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
            float inv = 1.0f - t;
            return 1.0f - inv * inv * inv;
        }
    }
}

