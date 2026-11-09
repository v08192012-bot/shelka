/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.Setting;
import client.gui.AbstractTrackChoiceWidget;
import client.gui.Component;

public class CheckBoxWidget
extends Component {
    public static final long VTABLE_RVA = 12603168L;
    public static final int OFF_SETTING = 128;
    public static final int OFF_BUTTON = 136;
    public static final int OFF_BUTTON_X = 144;
    public static final int OFF_BUTTON_Y = 148;
    public static final int OFF_BUTTON_W = 152;
    public static final int OFF_BUTTON_H = 156;
    public static final int OFF_CHECKED = 232;
    public static final int OFF_CALLBACK = 296;
    public static final int OFF_CHECK_ANIM = 304;
    public static final int OFF_CROSS_ANIM = 344;
    public static final int BUTTON_OFF_CHECK_ANIM = 168;
    public static final int BUTTON_OFF_CROSS_ANIM = 208;
    public static final int SLOT_DESTROY = 0;
    public static final int SLOT_RENDER = 8;
    public static final int SLOT_MOUSE_CLICKED = 32;
    public static final int SLOT_GET_HEIGHT = 96;
    public static final int SLOT_TYPE_ID = 136;
    public static final int SLOT_VALUE_PAD = 144;
    public static final int SLOT_VALUE_MIN = 152;
    public static final int SLOT_BUTTON_CLICK = 96;
    public static final long RVA_SETTING_WIDGET_CTOR = 2735201239728L;
    public static final long RVA_DESTROY = 2735201180400L;
    public static final long RVA_RENDER = 2735201180528L;
    public static final long RVA_MOUSE_CLICKED = 2735201181088L;
    public static final long RVA_GET_HEIGHT = 2735201180960L;
    public static final long RVA_TYPE_ID = 2735201180368L;
    public static final long RVA_VALUE_PAD = 2735201180384L;
    public static final long RVA_VALUE_MIN = 2735201179232L;
    public static final long RVA_BUTTON_CTOR = 2735200890000L;
    public static final long RVA_BUTTON_RENDER = 2735200890464L;
    public static final long RVA_BUTTON_BIND = 2735200900960L;
    public static final long RVA_SET_ANIM_TARGET = 2735200831376L;
    public static final long RVA_ADVANCE_ANIM = 2735200831600L;
    public static final long RVA_TEXT_WIDTH = 2735201456016L;
    public static final long RVA_CLOCK = 2735199714128L;
    public static final long RVA_DRAW_BUTTON = 2735203170096L;
    public static final long RVA_DRAW_TEXT = 2735203174176L;
    public static final long RVA_DRAW_VALUE_TEXT = 2735200824688L;
    public static final long RVA_DRAW_ROW_BACKGROUND = 2735200823424L;
    public static final long RVA_DRAW_ROW_INNER = 2735200824272L;
    public static final long RVA_DRAW_ROW_DIVIDER = 2735200821536L;
    public static final long RVA_MEASURE_LABEL_HEIGHT = 2735201240352L;
    public static final long RVA_MEASURE_VALUE_HEIGHT = 2735201240064L;
    public static final long RVA_DRAW_HEADER = 2735201240576L;
    public static final long RVA_DRAW_LABEL = 2735201241104L;
    public static final long RVA_HOVER_GATE_POINTER = 2735213249200L;
    public static final long RVA_MOUSE_INSIDE = 2735213242813L;
    public static final long RVA_HOVERED_WIDGET = 2735213246056L;
    public static final float BUTTON_SIZE = 16.0f;
    public static final float MIN_HEIGHT = 16.0f;
    public static final float PAD_X = 8.0f;
    public static final float PAD_Y = 6.0f;
    public static final float LABEL_FONT = 12.0f;
    public static final float VALUE_FONT = 14.0f;
    public static final float LABEL_LINE_HEIGHT = 14.4f;
    public static final float VALUE_LINE_HEIGHT = 16.800001f;
    public static final float VALUE_MIN_HEIGHT = 20.0f;
    public static final float TEXT_PAD = 16.0f;
    public static final float HALF = 0.5f;
    public static final float ANIM_DURATION = 0.22f;
    public static final float EPSILON = 0.001f;
    public static final float ONE = 1.0f;
    public static final float ZERO = 0.0f;
    public static final long NANOS_PER_SECOND = 1000000000L;
    public static final int TYPE_ID = 65;
    public static final int CHECK_ICON = 20;
    public static final int HOVER_KIND_ROW = 1;
    public static boolean hoverGatePointerNull = true;
    public static boolean mouseInsideWindow;
    public static int hoveredWidget;
    protected Setting setting;
    protected float buttonX;
    protected float buttonY;
    protected float buttonWidth = 16.0f;
    protected float buttonHeight = 16.0f;
    protected boolean checked;
    protected final Anim checkAnim = new Anim();
    protected final Anim crossAnim = new Anim();
    protected byte checkAnimRunningFlag;
    protected float labelWidthKey = -1.0f;
    protected float labelHeight;
    protected float valueHeightKey = -1.0f;
    protected float valueHeight;

    public CheckBoxWidget() {
    }

    public CheckBoxWidget(Setting setting) {
        this.initSettingWidget(setting);
        this.initButton(setting != null && setting.getBoolean());
    }

    protected void initSettingWidget(Setting setting) {
        this.flags = 256;
        this.x = 0.0f;
        this.y = 0.0f;
        this.width = 0.0f;
        this.height = 0.0f;
        this.animXFrom = 0.0f;
        this.animYFrom = 0.0f;
        this.animatingPosition = false;
        this.setting = setting;
        this.width = 269.0f;
        this.buttonX = 0.0f;
        this.buttonY = 0.0f;
        this.buttonWidth = 16.0f;
        this.buttonHeight = 16.0f;
    }

    protected void initButton(boolean value) {
        float flag;
        this.checked = value;
        this.checkAnim.from = flag = value ? 1.0f : 0.0f;
        this.checkAnim.current = flag;
        this.checkAnim.target = flag;
        this.checkAnim.duration = 0.22f;
        this.checkAnim.start = CheckBoxWidget.clock();
        this.checkAnim.running = false;
        this.crossAnim.from = flag;
        this.crossAnim.current = flag;
        this.crossAnim.target = flag;
        this.crossAnim.duration = 0.22f;
        this.crossAnim.start = CheckBoxWidget.clock();
        this.crossAnim.running = false;
        this.bindCallback();
    }

    public Setting getSetting() {
        return this.setting;
    }

    protected void bindCallback() {
    }

    protected static long clock() {
        return System.nanoTime();
    }

    protected static float advanceAnim(Anim anim) {
        if (!anim.running || anim.duration <= 0.0f) {
            anim.current = anim.target;
            anim.running = false;
            return anim.current;
        }
        float t = (float)((double)(CheckBoxWidget.clock() - anim.start) / 1.0E9) / anim.duration;
        if (t <= 0.0f) {
            anim.current = anim.from;
            return anim.current;
        }
        if (t >= 1.0f) {
            anim.running = false;
            anim.current = anim.target;
            return anim.current;
        }
        anim.current = CheckBoxWidget.easeOutCubic(t) * (anim.target - anim.from) + anim.from;
        return anim.current;
    }

    protected static void setAnimTarget(Anim anim, float target) {
        float current;
        if (anim.target == target) {
            return;
        }
        anim.from = current = CheckBoxWidget.advanceAnim(anim);
        anim.target = target;
        anim.start = CheckBoxWidget.clock();
        anim.running = true;
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (button != 0) {
            return false;
        }
        if (mx >= (double)this.buttonX && mx <= (double)(this.buttonX + this.buttonWidth) && my >= (double)this.buttonY && my <= (double)(this.buttonY + this.buttonHeight)) {
            return this.buttonClicked(mx);
        }
        return false;
    }

    protected boolean buttonClicked(double mx) {
        return false;
    }

    protected float measureHeight() {
        float minimum = 16.0f;
        float label = this.measureLabelHeight(this.width - 16.0f - 8.0f);
        float value = this.measureValueHeight(this.width);
        if (label > 0.0f) {
            value = value + 0.0f + label;
        }
        if (minimum <= value) {
            minimum = value;
        }
        return minimum;
    }

    public void measure() {
        this.measureHeight();
    }

    protected float measureLabelHeight(float available) {
        if (available != this.labelWidthKey) {
            int lines = CheckBoxWidget.wrapLineCount(0, this.settingLabel(), 12.0f, available);
            float measured = (float)lines * 14.4f;
            this.labelWidthKey = available;
            this.labelHeight = measured;
            return measured;
        }
        return this.labelHeight;
    }

    protected float measureValueHeight(float available) {
        float local = available - 20.0f;
        if (local <= 0.0f) {
            local = 0.0f;
        }
        if (local != this.valueHeightKey) {
            int lines = CheckBoxWidget.wrapLineCount(2, this.settingValue(), 14.0f, local);
            float measured = (float)lines * 16.800001f;
            if (measured < 16.0f) {
                measured = 16.0f;
            }
            this.valueHeightKey = local;
            this.valueHeight = measured;
            return measured;
        }
        return this.valueHeight;
    }

    protected float drawHeader(Object mat, float available, float alpha) {
        float measured = this.measureValueHeight(available);
        CheckBoxWidget.drawValueTextAtEdge(mat, this.x + this.width, this.y, this.settingValue(), alpha);
        CheckBoxWidget.drawValueText(mat, this.x + 20.0f, this.y, 14.0f, available, AbstractTrackChoiceWidget.rendererColor(), alpha);
        return measured;
    }

    protected float drawLabel(Object mat, float yOffset, float alpha) {
        float measured = this.measureLabelHeight(this.width);
        CheckBoxWidget.drawLabelText(mat, this.x, yOffset + this.y, 12.0f, AbstractTrackChoiceWidget.rendererColor(), alpha);
        return measured;
    }

    protected String settingLabel() {
        return this.setting == null ? "" : this.setting.getName();
    }

    protected String settingValue() {
        return this.setting == null ? "" : this.setting.getName();
    }

    protected static int wrapLineCount(int align, String text, float size, float available) {
        if (available <= 0.0f || text == null) {
            return available <= 0.0f ? 0 : 1;
        }
        float measured = AbstractTrackChoiceWidget.textWidth(text, size);
        int lines = 1;
        while (measured > available) {
            measured -= available;
            ++lines;
        }
        return lines;
    }

    protected static void drawValueTextAtEdge(Object mat, float px, float py, String text, float alpha) {
    }

    protected static void drawValueText(Object mat, float px, float py, float size, float available, int color, float alpha) {
    }

    protected static void drawLabelText(Object mat, float px, float py, float size, int color, float alpha) {
    }

    protected static void drawRowBackground(Object mat, float px, float py, float w, float h, float radius, float alpha) {
    }

    protected static void drawRowDivider(Object mat, float px, float py, float w, float h, int color, float alpha) {
    }

    protected static void drawRowInner(Object mat, float px, float py, float w, float h, float radius, int color, float alpha) {
    }

    protected static void drawButton(Object mat, float px, float py, float w, float h, int icon, float alpha) {
    }

    public void renderWidget(Object mat, float mouseX, float mouseY, float alpha) {
        boolean value;
        boolean bl = value = this.setting != null && this.setting.getBoolean();
        if (this.checked != value) {
            float flag;
            this.checked = value;
            if (!value) {
                CheckBoxWidget.setAnimTarget(this.checkAnim, 0.0f);
                flag = 0.0f;
            } else {
                CheckBoxWidget.setAnimTarget(this.checkAnim, 1.0f);
                flag = 1.0f;
            }
            CheckBoxWidget.setAnimTarget(this.crossAnim, flag);
        }
        float minimum = 16.0f;
        float available = this.width - 16.0f - 8.0f;
        float valueMeasured = this.drawHeader(mat, available, alpha);
        float labelMeasured = this.drawLabel(mat, valueMeasured, alpha);
        this.buttonX = this.x + this.width - 16.0f;
        this.buttonY = this.y - 1.0f;
        CheckBoxWidget.drawButton(mat, this.buttonX, this.buttonY, this.buttonWidth, this.buttonHeight, 20, alpha);
        if (labelMeasured > 0.0f) {
            valueMeasured = valueMeasured + 0.0f + labelMeasured;
        }
        if (minimum <= valueMeasured) {
            minimum = valueMeasured;
        }
        this.height = minimum;
    }

    @Override
    public void render() {
    }

    protected static final class Anim {
        protected float from;
        protected float current;
        protected float target;
        protected float duration = 0.22f;
        protected long start;
        protected boolean running;

        protected Anim() {
        }

        protected Anim(float value, float duration0) {
            this.from = value;
            this.current = value;
            this.target = value;
            this.duration = duration0;
            this.start = CheckBoxWidget.clock();
            this.running = false;
        }
    }
}

