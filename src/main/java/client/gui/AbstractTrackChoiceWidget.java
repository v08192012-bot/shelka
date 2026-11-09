/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.Setting;
import client.gui.Component;

public class AbstractTrackChoiceWidget
extends Component {
    public static final long VTABLE_RVA = 12602304L;
    public static final int OFF_SETTING = 96;
    public static final int OFF_VALUE_HEIGHT_KEY = 104;
    public static final int OFF_VALUE_HEIGHT = 108;
    public static final int OFF_LABEL_WIDTH_KEY = 112;
    public static final int OFF_LABEL_HEIGHT = 116;
    public static final int OFF_METRIC_REVISION = 120;
    public static final int OFF_ANIM_FROM = 128;
    public static final int OFF_ANIM_CURRENT = 132;
    public static final int OFF_ANIM_TARGET = 136;
    public static final int OFF_ANIM_DURATION = 140;
    public static final int OFF_ANIM_EASING = 144;
    public static final int OFF_ANIM_START = 152;
    public static final int OFF_ANIM_RUNNING = 160;
    public static final int OFF_PRESSED = 168;
    public static final int OFF_DRAGGING = 169;
    public static final int OFF_PRESS_X = 176;
    public static final int OFF_TRACK_SETTING = 184;
    public static final int SLOT_DESTROY = 0;
    public static final int SLOT_RENDER = 8;
    public static final int SLOT_MOUSE_CLICKED = 32;
    public static final int SLOT_MOUSE_RELEASED = 40;
    public static final int SLOT_MOUSE_DRAGGED = 48;
    public static final int SLOT_SET_POSITION = 88;
    public static final int SLOT_GET_HEIGHT = 96;
    public static final int SLOT_MEASURE = 104;
    public static final int SLOT_TYPE_ID = 136;
    public static final int SLOT_VALUE_PAD = 144;
    public static final int SLOT_VALUE_MIN = 152;
    public static final int SLOT_TRACK_COUNT = 160;
    public static final int SLOT_LABEL = 168;
    public static final int SLOT_ANIM_TARGET = 176;
    public static final int SLOT_SET_INDEX = 184;
    public static final int SLOT_RENDER_TRACK = 192;
    public static final long RVA_SETTING_WIDGET_CTOR = 2735201239728L;
    public static final long RVA_TRACK_CTOR = 2735201175952L;
    public static final long RVA_RENDER = 2735201176528L;
    public static final long RVA_MOUSE_CLICKED = 2735201177920L;
    public static final long RVA_MOUSE_RELEASED = 2735201178304L;
    public static final long RVA_MOUSE_DRAGGED = 2735201178192L;
    public static final long RVA_GET_HEIGHT = 2735201178736L;
    public static final long RVA_MEASURE = 2735201175904L;
    public static final long RVA_CELL_WIDTH = 2735201176160L;
    public static final long RVA_LABEL_TEXT_WIDTH = 2735201176272L;
    public static final long RVA_WRAP_INDEX = 2735201178560L;
    public static final long RVA_MEASURE_LABEL_HEIGHT = 2735201240352L;
    public static final long RVA_MEASURE_VALUE_HEIGHT = 2735201240064L;
    public static final long RVA_DRAW_HEADER = 2735201240576L;
    public static final long RVA_DRAW_LABEL = 2735201241104L;
    public static final long RVA_ADVANCE_ANIM = 2735200831600L;
    public static final long RVA_SET_ANIM_TARGET = 2735200831376L;
    public static final long RVA_CLOCK = 2735199714128L;
    public static final long RVA_TEXT_WIDTH = 2735201456016L;
    public static final long RVA_WRAP_TEXT = 2735203178384L;
    public static final long RVA_DRAW_ROW_BACKGROUND = 2735200823424L;
    public static final long RVA_DRAW_ROW_DIVIDER = 2735200821536L;
    public static final long RVA_DRAW_ROW_INNER = 2735200824272L;
    public static final long RVA_DRAW_VALUE_TEXT = 2735200824688L;
    public static final long RVA_DRAW_TEXT = 2735203174176L;
    public static final long RVA_DRAW_TEXT_WRAP = 2735203176960L;
    public static final long RVA_FONT_HEADER = 2735213249872L;
    public static final long RVA_FONT_CELL = 2735213249648L;
    public static final float DEFAULT_WIDTH = 269.0f;
    public static final float ROW_HEIGHT = 32.0f;
    public static final float PAD_Y = 6.0f;
    public static final float PAD_X = 8.0f;
    public static final float TEXT_PAD = 16.0f;
    public static final float LABEL_FONT = 12.0f;
    public static final float VALUE_FONT = 14.0f;
    public static final float LABEL_LINE_HEIGHT = 14.4f;
    public static final float VALUE_LINE_HEIGHT = 16.800001f;
    public static final float VALUE_MIN_HEIGHT = 20.0f;
    public static final float INNER_GAP = 3.0f;
    public static final float CELL_GAP = 2.0f;
    public static final double CELL_INSET = 3.0;
    public static final float ICON_OFFSET = 7.0f;
    public static final float ROW_RADIUS = 10.0f;
    public static final float ANIM_DURATION = 0.22f;
    public static final float EPSILON = 0.001f;
    public static final float HALF = 0.5f;
    public static final float ONE = 1.0f;
    public static final float ZERO = 0.0f;
    public static final float DRAG_THRESHOLD = 1.5f;
    public static final long NANOS_PER_SECOND = 1000000000L;
    public static final int TYPE_ID = 89;
    public static final int TYPE_CHOICE = 73;
    public static final int TYPE_ALIGNMENT = 66;
    public static final int TYPE_CHECKBOX = 65;
    public static final int TYPE_COMPACT_GROUP = 27;
    public static final int TYPE_DROP_DOWN = 62;
    public static final int HOVER_KIND_NONE = 0;
    public static final int HOVER_KIND_ROW = 1;
    public static final int HOVER_KIND_TRACK_DRAG = 3;
    public static final int HOVER_KIND_DROP_DOWN = 4;
    public static final int ICON_ALIGN_LEFT = 42;
    public static final int ICON_ALIGN_CENTER = 43;
    public static final int ICON_ALIGN_RIGHT = 44;
    public static final int[] ALIGNMENT_VALUES = new int[]{0, 1, 2};
    public static final long RVA_ALIGNMENT_VALUES = 2735204072768L;
    public static final long RVA_HOVER_GATE_POINTER = 2735213249200L;
    public static final long RVA_MOUSE_INSIDE = 2735213242813L;
    public static final long RVA_HOVERED_WIDGET = 2735213246056L;
    public static final long RVA_METRIC_REVISION = 2735213239086L;
    public static boolean hoverGatePointerNull = true;
    public static boolean mouseInsideWindow;
    public static int hoveredWidget;
    public static byte metricRevision;
    protected Setting setting;
    protected float valueHeightKey = -1.0f;
    protected float valueHeight;
    protected float labelWidthKey = -1.0f;
    protected float labelHeight;
    protected byte metricRevisionLocal;
    protected float animFrom;
    protected float animCurrent;
    protected float animTarget;
    protected float animDuration = 0.22f;
    protected long animStart;
    protected boolean animRunning;
    protected boolean pressed;
    protected boolean dragging;
    protected double pressX;
    protected Setting trackSetting;

    public AbstractTrackChoiceWidget() {
    }

    public AbstractTrackChoiceWidget(Setting setting) {
        this.initSettingWidget(setting);
        this.animFrom = 0.0f;
        this.animCurrent = 0.0f;
        this.animTarget = 0.0f;
        this.animDuration = 0.22f;
        this.animStart = AbstractTrackChoiceWidget.clock();
        this.animRunning = false;
        this.pressed = false;
        this.dragging = false;
        this.pressX = 0.0;
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
        this.labelWidthKey = -1.0f;
        this.labelHeight = 0.0f;
        this.valueHeightKey = -1.0f;
        this.valueHeight = 0.0f;
        this.metricRevisionLocal = 0;
        this.width = 269.0f;
    }

    public Setting getSetting() {
        return this.setting;
    }

    public Setting getTrackSetting() {
        return this.trackSetting;
    }

    protected static long clock() {
        return System.nanoTime();
    }

    protected int getTypeId() {
        return 89;
    }

    protected float getValuePad() {
        return 16.0f;
    }

    protected float getValueMin() {
        return 16.0f;
    }

    protected int getTrackCount() {
        return 0;
    }

    protected String getTrackLabel() {
        return "";
    }

    protected float getTrackAnimTarget() {
        return 0.0f;
    }

    protected void setTrackIndex(int index) {
    }

    protected void renderTrack(Object mat, float top, float alpha) {
    }

    protected float cellWidth() {
        float trackWidth = this.width - 6.0f;
        int count = this.getTrackCount();
        return (trackWidth - ((float)(count - 1) + (float)(count - 1))) / (float)count;
    }

    protected float labelTextWidth() {
        return AbstractTrackChoiceWidget.textWidth(this.getTrackLabel(), 12.0f) + 16.0f;
    }

    protected float measureLabelHeight(float available) {
        if (!this.settingVisible()) {
            return 0.0f;
        }
        if (this.metricRevisionLocal != metricRevision) {
            this.metricRevisionLocal = metricRevision;
            this.labelWidthKey = -1.0f;
            this.valueHeightKey = -1.0f;
        }
        if (available != this.labelWidthKey) {
            int lines = AbstractTrackChoiceWidget.wrapLineCount(0, this.settingLabel(), 12.0f, available);
            float measured = (float)lines * 14.4f;
            this.labelWidthKey = available;
            this.labelHeight = measured;
            return measured;
        }
        return this.labelHeight;
    }

    protected float measureValueHeight(float available) {
        int typeId = this.getTypeId();
        float pad = typeId == 89 ? 0.0f : 20.0f;
        float local = available - pad;
        if (local <= 0.0f) {
            local = 0.0f;
        }
        if (this.metricRevisionLocal != metricRevision) {
            this.metricRevisionLocal = metricRevision;
            this.labelWidthKey = -1.0f;
            this.valueHeightKey = -1.0f;
        }
        if (local != this.valueHeightKey) {
            float minimum;
            int lines = AbstractTrackChoiceWidget.wrapLineCount(2, this.settingValue(), 14.0f, local);
            float measured = (float)lines * 16.800001f;
            if (typeId != 89 && (minimum = this.getValueMin()) > measured) {
                measured = minimum;
            }
            this.valueHeightKey = local;
            this.valueHeight = measured;
            return measured;
        }
        return this.valueHeight;
    }

    protected float drawHeader(Object mat, float available, float alpha) {
        float measured = this.measureValueHeight(available);
        int typeId = this.getTypeId();
        float pad = typeId == 89 ? 0.0f : 20.0f;
        float local = available - pad;
        if (local <= 0.0f) {
            local = 0.0f;
        }
        if (typeId != 89) {
            float valuePad = this.getValuePad();
            float minimum = this.getValueMin();
            int color = AbstractTrackChoiceWidget.rendererSecondaryColor();
            AbstractTrackChoiceWidget.drawText(mat, typeId, this.x + (16.0f - valuePad) * 0.5f, this.y + (14.0f - minimum) * 0.5f, valuePad, minimum, color, alpha);
        }
        AbstractTrackChoiceWidget.drawValueText(mat, this.x + pad, this.y, 14.0f, local, AbstractTrackChoiceWidget.rendererSecondaryColor(), alpha);
        return measured;
    }

    protected float drawLabel(Object mat, float yOffset, float alpha) {
        if (!this.settingVisible()) {
            return 0.0f;
        }
        float measured = this.measureLabelHeight(this.width);
        AbstractTrackChoiceWidget.drawLabelText(mat, this.x, yOffset + this.y, 12.0f, AbstractTrackChoiceWidget.rendererSecondaryColor(), alpha);
        return measured;
    }

    protected boolean settingVisible() {
        return true;
    }

    protected String settingLabel() {
        return this.setting == null ? "" : this.setting.getName();
    }

    protected String settingValue() {
        return this.setting == null ? "" : this.setting.getName();
    }

    protected static float textWidth(String text, float size) {
        return 0.0f;
    }

    protected static int wrapLineCount(int align, String text, float size, float available) {
        if (available <= 0.0f || text == null) {
            return available <= 0.0f ? 0 : 1;
        }
        float wrapped = AbstractTrackChoiceWidget.textWidth(text, size);
        int lines = 1;
        while (wrapped > available) {
            wrapped -= available;
            ++lines;
        }
        return lines;
    }

    protected static int rendererColor() {
        return 0;
    }

    protected static int rendererSecondaryColor() {
        return 0;
    }

    protected static void drawText(Object mat, int icon, float px, float py, float w, float h, int color, float alpha) {
    }

    protected static void drawValueText(Object mat, float px, float py, float size, float available, int color, float alpha) {
    }

    protected static void drawValueTextAtEdge(Object mat, float px, float py, String text, float alpha) {
    }

    protected static void drawLabelText(Object mat, float px, float py, float size, int color, float alpha) {
    }

    protected static void drawCell(Object mat, float px, float py, float w, float h, int color, float alpha) {
    }

    protected static void drawRowBackground(Object mat, float px, float py, float w, float h, float radius, float alpha) {
    }

    protected static void drawRowDivider(Object mat, float px, float py, float w, float h, int color, float alpha) {
    }

    protected static void drawRowInner(Object mat, float px, float py, float w, float h, float radius, int color, float alpha) {
    }

    public static boolean hoverAllowed() {
        return hoverGatePointerNull || mouseInsideWindow;
    }

    protected static boolean inside(float rx, float ry, float rw, float rh, double mx, double my) {
        return mx >= (double)rx && mx <= (double)(rx + rw) && my >= (double)ry && my <= (double)(ry + rh);
    }

    protected static float advanceAnim(AbstractTrackChoiceWidget widget) {
        if (!widget.animRunning || widget.animDuration <= 0.0f) {
            widget.animCurrent = widget.animTarget;
            widget.animRunning = false;
            return widget.animCurrent;
        }
        float t = (float)((double)(AbstractTrackChoiceWidget.clock() - widget.animStart) / 1.0E9) / widget.animDuration;
        if (t <= 0.0f) {
            widget.animCurrent = widget.animFrom;
            return widget.animCurrent;
        }
        if (t >= 1.0f) {
            widget.animRunning = false;
            widget.animCurrent = widget.animTarget;
            return widget.animCurrent;
        }
        widget.animCurrent = AbstractTrackChoiceWidget.easeOutCubic(t) * (widget.animTarget - widget.animFrom) + widget.animFrom;
        return widget.animCurrent;
    }

    protected static void setAnimTarget(AbstractTrackChoiceWidget widget, float target) {
        float current;
        if (widget.animTarget == target) {
            return;
        }
        widget.animFrom = current = AbstractTrackChoiceWidget.advanceAnim(widget);
        widget.animTarget = target;
        widget.animStart = AbstractTrackChoiceWidget.clock();
        widget.animRunning = true;
    }

    protected float wrapIndex(double mx) {
        float limit;
        float cells = this.cellWidth();
        float raw = (float)((mx - (double)this.x - 3.0) / (double)(cells + 2.0f)) - 0.5f;
        if (raw < 0.0f) {
            raw = 0.0f;
        }
        if (raw > (limit = (float)this.getTrackCount() - 1.0f)) {
            raw = limit;
        }
        return raw;
    }

    protected float measureHeight() {
        float labelWidth = this.labelTextWidth();
        float base = this.measureValueHeight(this.width - labelWidth - 8.0f);
        float label = this.measureLabelHeight(this.width);
        if (label > 0.0f) {
            base = base + 0.0f + label;
        }
        return base + 6.0f + 32.0f;
    }

    public void measure() {
        this.measureHeight();
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        float top;
        if (button != 0) {
            return false;
        }
        float label = this.measureLabelHeight(this.width);
        float labelWidth = this.labelTextWidth();
        float base = this.measureValueHeight(this.width - labelWidth - 8.0f);
        if (label > 0.0f) {
            base = base + 0.0f + label;
        }
        if (mx >= (double)this.x && mx <= (double)(this.x + this.width) && (double)(top = base + this.y + 6.0f) <= my && my <= (double)(top + 32.0f)) {
            this.pressX = mx;
            this.pressed = true;
            this.dragging = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean mouseReleased(double mx, double my, int button) {
        int index;
        if (!this.pressed || button != 0) {
            return false;
        }
        this.pressed = false;
        this.dragging = false;
        int count = this.getTrackCount();
        if (!this.dragging) {
            float cells = this.cellWidth();
            index = (int)Math.floor((mx - (double)this.x - 3.0) / (double)(cells + 2.0f));
        } else {
            index = Math.round(this.wrapIndex(mx));
        }
        if (index < 0) {
            index = 0;
        }
        if (index > count - 1) {
            index = count - 1;
        }
        this.setTrackIndex(index);
        return true;
    }

    @Override
    public boolean mouseMoved(double mx, double my, double delta) {
        if (!this.pressed || (int)delta != 0) {
            return false;
        }
        if (!this.dragging) {
            if (Math.abs(mx - this.pressX) < 1.5) {
                return true;
            }
            this.dragging = true;
        }
        AbstractTrackChoiceWidget.setAnimTarget(this, this.wrapIndex(mx));
        return true;
    }

    public void renderTrackWidget(Object mat, float mouseX, float mouseY, float alpha) {
        float target;
        float labelWidth = AbstractTrackChoiceWidget.textWidth(this.getTrackLabel(), 12.0f);
        float valueMeasured = this.drawHeader(mat, this.width - (labelWidth + 16.0f) - 8.0f, alpha);
        float labelMeasured = this.drawLabel(mat, valueMeasured, alpha);
        AbstractTrackChoiceWidget.drawValueTextAtEdge(mat, this.x + this.width, this.y, this.settingValue(), alpha);
        float top = valueMeasured;
        if (labelMeasured > 0.0f) {
            top = top + 0.0f + labelMeasured;
        }
        top = top + this.y + 6.0f;
        if (!this.dragging) {
            if (this.pressed || AbstractTrackChoiceWidget.inside(this.x, this.y, this.width, 32.0f, mouseX, mouseY) && AbstractTrackChoiceWidget.hoverAllowed()) {
                hoveredWidget = 1;
            }
        } else {
            hoveredWidget = 3;
        }
        AbstractTrackChoiceWidget.drawRowBackground(mat, this.x, top, this.width, 32.0f, 10.0f, alpha);
        this.cellWidth();
        int count = this.getTrackCount();
        int i = 0;
        if (count > 0) {
            do {
                float cells = this.cellWidth();
                AbstractTrackChoiceWidget.drawRowDivider(mat, this.x + (cells + 2.0f) * (float)i, top, cells, 32.0f, AbstractTrackChoiceWidget.rendererColor(), alpha);
            } while (++i < (count = this.getTrackCount()));
        }
        if (!this.dragging && this.animTarget != (target = this.getTrackAnimTarget())) {
            AbstractTrackChoiceWidget.setAnimTarget(this, target);
        }
        AbstractTrackChoiceWidget.drawRowInner(mat, this.x, top, this.width, 32.0f, 10.0f, AbstractTrackChoiceWidget.rendererColor(), alpha);
        this.renderTrack(mat, top, alpha);
        this.height = top + 32.0f - this.y;
    }

    @Override
    public void render() {
    }
}

