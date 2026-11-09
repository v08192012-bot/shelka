/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.Setting;
import client.gui.AbstractTrackChoiceWidget;
import client.gui.Component;
import java.util.ArrayList;
import java.util.List;

public class DropDownWidget
extends Component {
    public static final long VTABLE_RVA = 12605384L;
    public static final int OFF_OPTIONS = 128;
    public static final int OFF_OPEN = 136;
    public static final int OFF_LAST_OPEN = 137;
    public static final int OFF_ANIM_FROM = 144;
    public static final int OFF_ANIM_CURRENT = 148;
    public static final int OFF_ANIM_TARGET = 152;
    public static final int OFF_ANIM_DURATION = 156;
    public static final int OFF_ANIM_EASING = 160;
    public static final int OFF_ANIM_START = 168;
    public static final int OFF_ANIM_RUNNING = 176;
    public static final int OFF_ENTRIES = 184;
    public static final int OFF_ENTRIES_END = 192;
    public static final int OFF_ENTRIES_CAP = 200;
    public static final int OFF_SCROLL_ANIM_FROM = 208;
    public static final int OFF_SCROLL_ANIM_CURRENT = 212;
    public static final int OFF_SCROLL_ANIM_TARGET = 216;
    public static final int OFF_SCROLL_ANIM_DURATION = 220;
    public static final int OFF_SCROLL_ANIM_EASING = 224;
    public static final int OFF_SCROLL_ANIM_START = 232;
    public static final int OFF_SCROLL_ANIM_RUNNING = 240;
    public static final int OFF_SCROLL = 248;
    public static final int OFF_SCROLL_TARGET = 252;
    public static final int OFF_DRAGGING_THUMB = 256;
    public static final int OFF_DRAG_OFFSET = 260;
    public static final int OFF_LABEL = 264;
    public static final int OFF_CACHED_COUNT = 296;
    public static final int OFF_CACHED_WIDTH = 304;
    public static final int ENTRY_SIZE = 40;
    public static final int ENTRY_OFF_FROM = 0;
    public static final int ENTRY_OFF_CURRENT = 4;
    public static final int ENTRY_OFF_TARGET = 8;
    public static final int ENTRY_OFF_DURATION = 12;
    public static final int ENTRY_OFF_EASING = 16;
    public static final int ENTRY_OFF_START = 24;
    public static final int ENTRY_OFF_RUNNING = 32;
    public static final int SLOT_DESTROY = 0;
    public static final int SLOT_RENDER = 8;
    public static final int SLOT_MOUSE_CLICKED = 32;
    public static final int SLOT_MOUSE_RELEASED = 40;
    public static final int SLOT_MOUSE_DRAGGED = 48;
    public static final int SLOT_MOUSE_SCROLLED = 56;
    public static final int SLOT_GET_HEIGHT = 96;
    public static final int SLOT_CONTENT_HEIGHT = 104;
    public static final int SLOT_CLOSE = 120;
    public static final int SLOT_TYPE_ID = 136;
    public static final int SLOT_VALUE_PAD = 144;
    public static final int SLOT_VALUE_MIN = 152;
    public static final long RVA_SETTING_WIDGET_CTOR = 2735201239728L;
    public static final long RVA_DESTROY = 2735201218272L;
    public static final long RVA_RENDER = 2735201221776L;
    public static final long RVA_MOUSE_CLICKED = 2735201224512L;
    public static final long RVA_MOUSE_RELEASED = 2735201225440L;
    public static final long RVA_MOUSE_DRAGGED = 2735201225472L;
    public static final long RVA_MOUSE_SCROLLED = 2735201225792L;
    public static final long RVA_GET_HEIGHT = 2735201219152L;
    public static final long RVA_CONTENT_HEIGHT = 2735201219408L;
    public static final long RVA_CLOSE = 2735201226160L;
    public static final long RVA_TYPE_ID = 2735201180016L;
    public static final long RVA_VALUE_PAD = 2735201175936L;
    public static final long RVA_VALUE_MIN = 2735201175936L;
    public static final long RVA_UPDATE_LABEL = 2735201218352L;
    public static final long RVA_LABEL_TOP = 2735201218912L;
    public static final long RVA_OPTION_LIST_HEIGHT = 2735201219040L;
    public static final long RVA_DRAW_OPTIONS = 2735201222976L;
    public static final long RVA_DRAW_HEAD = 2735201220544L;
    public static final long RVA_DRAW_OPTION_TEXT = 2735201219648L;
    public static final long RVA_ICON_METRICS = 2735199818160L;
    public static final long RVA_ICON_SIZE_TABLE = 2735201215232L;
    public static final long RVA_SET_SELECTED = 2735203010640L;
    public static final long RVA_PLAY_SOUND = 2735199719200L;
    public static final long RVA_RECT_TEST = 2735200779104L;
    public static final long RVA_PUSH_SCISSOR = 2735200780464L;
    public static final long RVA_POP_SCISSOR = 2735200780784L;
    public static final long RVA_SET_ANIM_TARGET = 2735200831376L;
    public static final long RVA_ADVANCE_ANIM = 2735200831600L;
    public static final long RVA_CLOCK = 2735199714128L;
    public static final long RVA_TEXT_WIDTH = 2735201456016L;
    public static final long RVA_DRAW_TEXT = 2735203174176L;
    public static final long RVA_DRAW_VALUE_TEXT = 2735200824688L;
    public static final long RVA_DRAW_ROW_BACKGROUND = 2735200823424L;
    public static final long RVA_DRAW_ROW_INNER = 2735200824272L;
    public static final long RVA_DRAW_ROW_DIVIDER = 2735200821536L;
    public static final long RVA_STRING_ASSIGN = 2735199764880L;
    public static final long RVA_FORMAT_STRING = 2735212022416L;
    public static final long RVA_HOVER_GATE_POINTER = 2735213249200L;
    public static final long RVA_MOUSE_INSIDE = 2735213242813L;
    public static final long RVA_HOVERED_WIDGET = 2735213246056L;
    public static final float DEFAULT_WIDTH = 269.0f;
    public static final float ROW_HEIGHT = 32.0f;
    public static final float PAD_Y = 6.0f;
    public static final float PAD_X = 8.0f;
    public static final float LIST_TOP_GAP = 6.0f;
    public static final float LIST_INNER = 4.0f;
    public static final float LIST_SIDE = 6.0f;
    public static final float OPTION_STEP = 30.0f;
    public static final float OPTION_HEIGHT = 26.0f;
    public static final float OPTION_TOP = 3.0f;
    public static final float OPTION_TEXT_TOP = 7.0f;
    public static final float OPTION_TEXT_LEFT = 8.0f;
    public static final float THUMB_HEIGHT = 59.0f;
    public static final float THUMB_WIDTH = 6.0f;
    public static final float LIST_MAX_HEIGHT = 154.0f;
    public static final float LIST_MIN_OPTIONS = 6.0f;
    public static final float LABEL_FONT = 12.0f;
    public static final float VALUE_FONT = 14.0f;
    public static final float LABEL_LINE_HEIGHT = 14.4f;
    public static final float VALUE_LINE_HEIGHT = 16.800001f;
    public static final float VALUE_MIN_HEIGHT = 20.0f;
    public static final float TEXT_PAD = 16.0f;
    public static final float OPEN_DURATION = 0.32f;
    public static final float CLOSE_DURATION = 0.3f;
    public static final float ANIM_DURATION = 0.22f;
    public static final float OPTION_IDLE = 0.4f;
    public static final float OPTION_HOVER = 0.7f;
    public static final float ONE = 1.0f;
    public static final float ZERO = 0.0f;
    public static final float HALF = 0.5f;
    public static final float EPSILON = 0.001f;
    public static final long NANOS_PER_SECOND = 1000000000L;
    public static final int TYPE_ID = 62;
    public static final int HEAD_ICON = 10;
    public static final int SOUND_OPEN = 4;
    public static final int SOUND_CLOSE = 5;
    public static final int SOUND_SELECT = 14;
    public static final int HOVER_KIND_ROW = 1;
    public static final int HOVER_KIND_DROP_DOWN = 4;
    public static boolean hoverGatePointerNull = true;
    public static boolean mouseInsideWindow;
    public static int hoveredWidget;
    protected Setting options;
    protected boolean open;
    protected boolean lastOpen;
    protected final Anim openAnim = new Anim(0.0f, 0.32f);
    protected final Anim scrollAnim = new Anim(0.0f, 0.32f);
    protected final List<OptionState> entries = new ArrayList<OptionState>();
    protected float scroll;
    protected float scrollTarget = -1.0f;
    protected boolean draggingThumb;
    protected float dragOffset;
    protected String label = "";
    protected long cachedCount = -1L;
    protected float cachedWidth;
    protected float labelWidthKey = -1.0f;
    protected float labelHeight;
    protected float valueHeightKey = -1.0f;
    protected float valueHeight;
    public static final float INNER_GAP = 3.0f;
    public static final float ROW_RADIUS = 10.0f;
    public static final float OPTION_RADIUS = 8.0f;

    public DropDownWidget() {
    }

    public DropDownWidget(Setting options) {
        this.initSettingWidget(options);
    }

    protected void initSettingWidget(Setting options) {
        this.flags = 256;
        this.x = 0.0f;
        this.y = 0.0f;
        this.width = 0.0f;
        this.height = 0.0f;
        this.animXFrom = 0.0f;
        this.animYFrom = 0.0f;
        this.animatingPosition = false;
        this.options = options;
        this.open = false;
        this.lastOpen = false;
        this.openAnim.duration = 0.32f;
        this.openAnim.start = DropDownWidget.clock();
        this.openAnim.running = false;
        this.scrollAnim.duration = 0.32f;
        this.scrollAnim.start = DropDownWidget.clock();
        this.scrollAnim.running = false;
        this.scroll = 0.0f;
        this.scrollTarget = -1.0f;
        this.draggingThumb = false;
        this.dragOffset = 0.0f;
        this.label = "";
        this.cachedCount = -1L;
        this.cachedWidth = 0.0f;
        this.width = 269.0f;
        this.buildEntries();
    }

    protected void buildEntries() {
        this.entries.clear();
        if (this.options == null) {
            return;
        }
        for (String mode : this.options.getModes()) {
            boolean selected = mode != null && mode.equals(this.options.getMode());
            float value = selected ? 1.0f : 0.4f;
            OptionState entry = new OptionState(mode == null ? "" : mode, value, 0.22f);
            entry.selected = selected;
            this.entries.add(entry);
        }
    }

    public Setting getOptions() {
        return this.options;
    }

    public boolean isOpen() {
        return this.open;
    }

    public void setOpen(boolean value) {
        this.open = value;
    }

    protected static long clock() {
        return System.nanoTime();
    }

    protected int getTypeId() {
        return 62;
    }

    protected float getValuePad() {
        return 16.0f;
    }

    protected float getValueMin() {
        return 16.0f;
    }

    protected static float advanceAnim(Anim anim) {
        if (!anim.running || anim.duration <= 0.0f) {
            anim.current = anim.target;
            anim.running = false;
            return anim.current;
        }
        float t = (float)((double)(DropDownWidget.clock() - anim.start) / 1.0E9) / anim.duration;
        if (t <= 0.0f) {
            anim.current = anim.from;
            return anim.current;
        }
        if (t >= 1.0f) {
            anim.running = false;
            anim.current = anim.target;
            return anim.current;
        }
        anim.current = DropDownWidget.easeOutCubic(t) * (anim.target - anim.from) + anim.from;
        return anim.current;
    }

    protected static void setAnimTarget(Anim anim, float target) {
        float current;
        if (anim.target == target) {
            return;
        }
        anim.from = current = DropDownWidget.advanceAnim(anim);
        anim.target = target;
        anim.start = DropDownWidget.clock();
        anim.running = true;
    }

    protected static float advanceEntry(OptionState entry) {
        if (!entry.running || entry.duration <= 0.0f) {
            entry.current = entry.target;
            entry.running = false;
            return entry.current;
        }
        float t = (float)((double)(DropDownWidget.clock() - entry.start) / 1.0E9) / entry.duration;
        if (t <= 0.0f) {
            entry.current = entry.from;
            return entry.current;
        }
        if (t >= 1.0f) {
            entry.running = false;
            entry.current = entry.target;
            return entry.current;
        }
        entry.current = DropDownWidget.easeOutCubic(t) * (entry.target - entry.from) + entry.from;
        return entry.current;
    }

    protected static void setEntryTarget(OptionState entry, float target) {
        float current;
        if (entry.target == target) {
            return;
        }
        entry.from = current = DropDownWidget.advanceEntry(entry);
        entry.target = target;
        entry.start = DropDownWidget.clock();
        entry.running = true;
    }

    protected int optionCount() {
        return this.options == null ? 0 : this.options.getModes().size();
    }

    protected int selectedIndex() {
        if (this.options == null) {
            return 0;
        }
        List<String> modes = this.options.getModes();
        int index = modes.indexOf(this.options.getMode());
        return index < 0 ? 0 : index;
    }

    protected int visibleCount() {
        return this.optionCount();
    }

    protected static float optionListHeight(int count) {
        if (count == 0) {
            return 0.0f;
        }
        return (float)(count - 1) * 4.0f + (float)count * 26.0f + 8.0f;
    }

    protected static float listViewHeight(int count) {
        float total = DropDownWidget.optionListHeight(count);
        if (154.0f <= total) {
            return 154.0f;
        }
        return total;
    }

    protected static float maxScroll(int count) {
        float view;
        float total = DropDownWidget.optionListHeight(count);
        float result = total - (view = DropDownWidget.listViewHeight(count));
        if (result <= 0.0f) {
            result = 0.0f;
        }
        return result;
    }

    protected String updateLabel() {
        if (this.options == null) {
            return this.label;
        }
        int count = this.visibleCount();
        if (count != (int)this.cachedCount) {
            this.label = this.optionCounterLabel();
            this.cachedWidth = AbstractTrackChoiceWidget.textWidth(this.label, 12.0f) + 16.0f;
            this.cachedCount = count;
        }
        return this.label;
    }

    protected String optionCounterLabel() {
        return this.selectedIndex() + "/" + this.visibleCount();
    }

    protected float measureLabelHeight(float available) {
        if (available != this.labelWidthKey) {
            int lines = DropDownWidget.wrapLineCount(0, this.settingLabel(), 12.0f, available);
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
            int lines = DropDownWidget.wrapLineCount(2, this.settingValue(), 14.0f, local);
            float measured = (float)lines * 16.800001f;
            this.valueHeightKey = local;
            this.valueHeight = measured;
            return measured;
        }
        return this.valueHeight;
    }

    protected String settingLabel() {
        return this.options == null ? "" : this.options.getName();
    }

    protected String settingValue() {
        return this.options == null ? "" : this.options.getName();
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

    protected float labelTop() {
        float label = this.measureLabelHeight(this.width);
        this.updateLabel();
        float available = this.width;
        if (0.0f < this.cachedWidth) {
            available = this.width - this.cachedWidth - 8.0f;
        }
        float value = this.measureValueHeight(available);
        if (label > 0.0f) {
            value = value + 0.0f + label;
        }
        return value + this.y + 6.0f;
    }

    protected float measureHeight() {
        float label = this.measureLabelHeight(this.width);
        this.updateLabel();
        float available = this.width;
        if (0.0f < this.cachedWidth) {
            available = this.width - this.cachedWidth - 8.0f;
        }
        float value = this.measureValueHeight(available);
        if (label > 0.0f) {
            value = value + 0.0f + label;
        }
        float animated = this.openAnim.current;
        float base = value + 6.0f + 32.0f;
        int count = this.optionCount();
        if (0.001f < animated && count != 0) {
            float listHeight = DropDownWidget.listViewHeight(count);
            return (listHeight + 6.0f) * animated + base;
        }
        return base;
    }

    public void measure() {
        this.measureHeight();
    }

    protected float contentHeight() {
        float label = this.measureLabelHeight(this.width);
        this.updateLabel();
        float available = this.width;
        if (0.0f < this.cachedWidth) {
            available = this.width - this.cachedWidth - 8.0f;
        }
        float value = this.measureValueHeight(available);
        if (label > 0.0f) {
            value = value + 0.0f + label;
        }
        float base = value + 6.0f + 32.0f;
        int count = this.optionCount();
        if (this.open && count != 0) {
            float listHeight = DropDownWidget.listViewHeight(count);
            return listHeight + base + 6.0f;
        }
        return base;
    }

    protected float drawHeader(Object mat, float available, float alpha) {
        float measured = this.measureValueHeight(available);
        DropDownWidget.drawValueText(mat, this.x + 20.0f, this.y, 14.0f, available, AbstractTrackChoiceWidget.rendererColor(), alpha);
        return measured;
    }

    protected float drawLabel(Object mat, float yOffset, float alpha) {
        float measured = this.measureLabelHeight(this.width);
        DropDownWidget.drawLabelText(mat, this.x, yOffset + this.y, 12.0f, AbstractTrackChoiceWidget.rendererColor(), alpha);
        return measured;
    }

    protected static void drawValueText(Object mat, float px, float py, float size, float available, int color, float alpha) {
    }

    protected static void drawLabelText(Object mat, float px, float py, float size, int color, float alpha) {
    }

    protected static void drawValueTextAtEdge(Object mat, float px, float py, String text, float alpha) {
    }

    protected static void drawRowBackground(Object mat, float px, float py, float w, float h, float radius, float alpha) {
    }

    protected static void drawRowInner(Object mat, float px, float py, float w, float h, float radius, int color, float alpha) {
    }

    protected static void drawRowDivider(Object mat, float px, float py, float w, float h, int color, float alpha) {
    }

    protected static void drawOptionText(Object mat, String text, float px, float py, float size, int color, float alpha) {
    }

    protected static void drawHead(Object mat, float px, float py, int color, float alpha, float available) {
    }

    protected static float[] iconMetrics(int icon) {
        return new float[]{0.0f, 0.0f};
    }

    protected static void playSound(int id) {
    }

    protected static void pushScissor(float px, float py, float w, float h) {
    }

    protected static void popScissor() {
    }

    protected static boolean rectTest(double mx, double my, float px, float py, float w, float h) {
        return mx >= (double)px && mx <= (double)(px + w) && my >= (double)py && my <= (double)(py + h);
    }

    public static boolean hoverAllowed() {
        return hoverGatePointerNull || mouseInsideWindow;
    }

    protected void setSelectedOption(int index) {
        if (this.options == null) {
            return;
        }
        List<String> modes = this.options.getModes();
        if (index < 0 || index >= modes.size()) {
            return;
        }
        this.options.setMode(modes.get(index));
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (button != 0) {
            return false;
        }
        float top = this.labelTop();
        float fieldX = this.x;
        if (mx >= (double)fieldX && mx <= (double)(fieldX + this.width) && my >= (double)top && my <= (double)(top + 32.0f)) {
            boolean wasOpen = this.open;
            this.open = !wasOpen;
            DropDownWidget.playSound(wasOpen ? 5 : 4);
            if (!this.open) {
                return true;
            }
            this.scroll = 0.0f;
            this.scrollAnim.from = 0.0f;
            this.scrollAnim.current = 0.0f;
            this.scrollAnim.target = 0.0f;
            this.scrollAnim.running = false;
            return true;
        }
        int count = this.optionCount();
        if (!this.open || count == 0) {
            return false;
        }
        float listTop = top + 32.0f + 6.0f;
        float total = DropDownWidget.optionListHeight(count);
        float view = DropDownWidget.listViewHeight(count);
        if (!DropDownWidget.rectTest(mx, my, fieldX, listTop, this.width, view)) {
            return false;
        }
        float rightEdge = this.width + fieldX - 4.0f;
        float leftEdge = fieldX + 4.0f;
        if (count < 6) {
            if (count != 0) {
                this.scanOptions(mx, my, listTop, view, total, count, listTop + 4.0f - this.scrollAnim.current, leftEdge, rightEdge);
            }
            return true;
        }
        float thumbTop = 0.0f;
        float span = total - view;
        if (span <= 0.0f) {
            span = 0.0f;
        }
        if (0.0f < span) {
            thumbTop = (view + listTop - 4.0f - (listTop + 4.0f) - 59.0f) * (this.scrollAnim.current / span);
        }
        thumbTop = thumbTop + listTop + 4.0f;
        if (mx < (double)rightEdge || my < (double)thumbTop || my > (double)(thumbTop + 59.0f)) {
            this.scanOptions(mx, my, listTop, view, total, count, listTop + 4.0f - this.scrollAnim.current, leftEdge, rightEdge);
        } else {
            this.draggingThumb = true;
            this.dragOffset = (float)my - thumbTop;
        }
        return true;
    }

    protected void scanOptions(double mx, double my, float listTop, float view, float total, int count, float baseTop, float leftEdge, float rightEdge) {
        float rowTop;
        int index = 0;
        while (!(listTop <= (rowTop = (float)index * 30.0f + baseTop) + 26.0f && rowTop <= view + listTop && mx >= (double)leftEdge && mx <= (double)rightEdge && my >= (double)rowTop && my <= (double)(rowTop + 26.0f))) {
            if (count > ++index) continue;
            return;
        }
        DropDownWidget.playSound(14);
        this.setSelectedOption(index);
    }

    @Override
    public boolean mouseReleased(double mx, double my, int button) {
        if (this.draggingThumb && button == 0) {
            this.draggingThumb = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean mouseMoved(double mx, double my, double delta) {
        float view;
        int button = (int)delta;
        if (!this.draggingThumb || button != 0) {
            return false;
        }
        int count = this.optionCount();
        if (count == 0) {
            return false;
        }
        float top = this.labelTop();
        float listTop = top + 32.0f + 6.0f;
        float total = DropDownWidget.optionListHeight(count);
        float limit = total - (view = DropDownWidget.listViewHeight(count));
        if (limit <= 0.0f) {
            limit = 0.0f;
        }
        float value = ((float)my - this.dragOffset - (listTop + 4.0f)) / (view + listTop - 4.0f - (listTop + 4.0f)) - 59.0f;
        if ((value *= limit) < 0.0f) {
            value = 0.0f;
        }
        if (value > limit) {
            value = limit;
        }
        this.scroll = value;
        return true;
    }

    @Override
    public boolean mouseScrolled(double mx, double my, double amount) {
        float view;
        if (!this.open) {
            return false;
        }
        int count = this.optionCount();
        if (count == 0 || 5 >= count) {
            return false;
        }
        float top = this.labelTop();
        float listTop = top + 32.0f + 6.0f;
        float total = DropDownWidget.optionListHeight(count);
        if (mx >= (double)this.x && mx <= (double)(this.x + this.width) && my >= (double)listTop && my <= (double)((view = DropDownWidget.listViewHeight(count)) + listTop)) {
            float value;
            float limit = total - view;
            if (limit <= 0.0f) {
                limit = 0.0f;
            }
            if ((value = this.scroll - (float)amount * 30.0f) < 0.0f) {
                value = 0.0f;
            }
            if (value > limit) {
                value = limit;
            }
            this.scroll = value;
            return true;
        }
        return false;
    }

    public void close() {
        this.open = false;
        this.draggingThumb = false;
    }

    protected void drawOptions(Object mat, float mouseX, float mouseY, float alpha, float top, float openValue) {
        float clamped;
        float limit;
        int count = this.optionCount();
        if (count == 0) {
            return;
        }
        float listTop = top + 32.0f + 6.0f;
        float total = DropDownWidget.optionListHeight(count);
        float view = DropDownWidget.listViewHeight(count);
        float scaled = alpha * openValue;
        DropDownWidget.pushScissor(this.x, listTop, this.width, view * openValue);
        DropDownWidget.drawRowBackground(mat, this.x, listTop, this.width, view, 10.0f, scaled);
        float contentX = this.x + 4.0f;
        float contentWidth = this.x + this.width - 4.0f;
        if (5 < count) {
            contentWidth = contentWidth - 6.0f - 4.0f;
        }
        if ((limit = total - view) <= 0.0f) {
            limit = 0.0f;
        }
        if ((clamped = this.scroll) < 0.0f) {
            clamped = 0.0f;
        }
        if (clamped > limit) {
            clamped = limit;
        }
        this.scroll = clamped;
        if (this.scroll != this.scrollTarget) {
            DropDownWidget.setAnimTarget(this.scrollAnim, this.scroll);
            this.scrollTarget = this.scroll;
        }
        float smooth = DropDownWidget.advanceAnim(this.scrollAnim);
        boolean inList = DropDownWidget.rectTest(mouseX, mouseY, this.x, listTop, this.width, view);
        float baseTop = listTop + 4.0f - smooth;
        for (int i = 0; i < count; ++i) {
            boolean hovered;
            float rowTop = (float)i * 30.0f + baseTop;
            float rowBottom = rowTop + 26.0f;
            if (!(listTop <= rowBottom) || !(rowTop <= listTop + view)) continue;
            boolean bl = hovered = inList && (double)mouseX >= (double)contentX && (double)mouseX <= (double)(contentX + contentWidth) && (double)mouseY >= (double)rowTop && (double)mouseY <= (double)rowBottom;
            if (hovered && DropDownWidget.hoverAllowed()) {
                hoveredWidget = 1;
            }
            OptionState entry = this.entries.get(i);
            float highlight = 1.0f;
            if (!entry.selected) {
                highlight = 0.4f;
                if (hovered) {
                    highlight = 0.7f;
                }
            }
            DropDownWidget.setEntryTarget(entry, highlight);
            float level = DropDownWidget.advanceEntry(entry);
            DropDownWidget.drawRowInner(mat, contentX, rowTop, contentWidth, 26.0f, 8.0f, AbstractTrackChoiceWidget.rendererColor(), level * scaled);
            DropDownWidget.drawOptionText(mat, entry.text, contentX + 8.0f, rowTop + 7.0f, 12.0f, AbstractTrackChoiceWidget.rendererColor(), level * scaled);
        }
        if (5 < count) {
            float trackTop = listTop + 4.0f;
            float trackRight = this.width + this.x - 4.0f - 6.0f;
            float thumb = 0.0f;
            if (0.0f < limit) {
                thumb = (total + listTop - 4.0f - trackTop - 59.0f) * (smooth / limit);
            }
            DropDownWidget.drawRowInner(mat, trackRight, thumb + trackTop, 6.0f, 59.0f, 3.0f, AbstractTrackChoiceWidget.rendererColor(), scaled);
        }
        DropDownWidget.popScissor();
    }

    public void renderWidget(Object mat, float mouseX, float mouseY, float alpha) {
        float target;
        boolean wasOpen;
        this.updateLabel();
        float available = this.width;
        if (0.0f < this.cachedWidth) {
            available = this.width - this.cachedWidth - 8.0f;
        }
        float valueMeasured = this.drawHeader(mat, available, alpha);
        float labelMeasured = this.drawLabel(mat, valueMeasured, alpha);
        if (0.0f < this.cachedWidth) {
            DropDownWidget.drawValueTextAtEdge(mat, this.x + this.width, this.y, this.updateLabel(), alpha);
        }
        float top = valueMeasured;
        if (0.0f < labelMeasured) {
            top = top + 0.0f + labelMeasured;
        }
        top = top + this.y + 6.0f;
        if (DropDownWidget.rectTest(mouseX, mouseY, this.x, this.y, this.width, 32.0f) && DropDownWidget.hoverAllowed()) {
            hoveredWidget = 1;
        }
        if ((wasOpen = this.open) != this.lastOpen) {
            this.openAnim.duration = wasOpen ? 0.32f : 0.3f;
            this.lastOpen = wasOpen;
        }
        float f = target = wasOpen ? 1.0f : 0.0f;
        if (this.openAnim.target != target) {
            DropDownWidget.setAnimTarget(this.openAnim, target);
        }
        float openValue = DropDownWidget.advanceAnim(this.openAnim);
        DropDownWidget.drawRowBackground(mat, this.x, top, this.width, 32.0f, 10.0f, alpha);
        float innerX = this.x + 3.0f;
        float innerY = top + 3.0f;
        float innerWidth = this.width - 6.0f;
        DropDownWidget.drawRowInner(mat, innerX, innerY, innerWidth, 26.0f, 8.0f, AbstractTrackChoiceWidget.rendererColor(), alpha);
        float[] metrics = DropDownWidget.iconMetrics(10);
        float iconX = innerWidth + innerX - 8.0f;
        float iconY = (26.0f - metrics[1]) * 0.5f + innerY + 1.0f;
        DropDownWidget.drawCenteredIcon(mat, 10, iconX - metrics[0], iconY, metrics[0], metrics[1], alpha);
        float headWidth = innerWidth - 16.0f - metrics[0] - 4.0f;
        DropDownWidget.drawHead(mat, innerX + 8.0f, innerY + 7.0f, AbstractTrackChoiceWidget.rendererSecondaryColor(), alpha, headWidth);
        float fieldBottom = top + 32.0f;
        this.height = fieldBottom - this.y;
        if (0.001f < openValue) {
            this.drawOptions(mat, mouseX, mouseY, alpha, top, openValue);
            if (this.draggingThumb) {
                hoveredWidget = 4;
            }
            float listHeight = DropDownWidget.listViewHeight(this.optionCount());
            this.height = (listHeight + 6.0f) * openValue + (fieldBottom - this.y);
        }
    }

    protected static void drawCenteredIcon(Object mat, int icon, float px, float py, float w, float h, float alpha) {
    }

    @Override
    public void render() {
    }

    protected static final class Anim {
        protected float from;
        protected float current;
        protected float target;
        protected float duration = 0.32f;
        protected long start;
        protected boolean running;

        protected Anim() {
        }

        protected Anim(float value, float duration0) {
            this.from = value;
            this.current = value;
            this.target = value;
            this.duration = duration0;
            this.start = DropDownWidget.clock();
            this.running = false;
        }
    }

    public static final class OptionState {
        public float from;
        public float current;
        public float target;
        public float duration = 0.22f;
        public long start;
        public boolean running;
        public boolean selected;
        public String text = "";

        public OptionState() {
        }

        public OptionState(String text, float value, float duration0) {
            this.text = text;
            this.from = value;
            this.current = value;
            this.target = value;
            this.duration = duration0;
            this.start = DropDownWidget.clock();
            this.running = false;
        }
    }
}

