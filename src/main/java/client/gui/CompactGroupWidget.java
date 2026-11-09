/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.Setting;
import client.gui.AbstractTrackChoiceWidget;
import client.gui.Component;
import java.util.ArrayList;
import java.util.List;

public class CompactGroupWidget
extends Component {
    public static final long VTABLE_RVA = 12604696L;
    public static final int OFF_GROUP = 128;
    public static final int OFF_ROWS = 136;
    public static final int OFF_ROWS_END = 144;
    public static final int OFF_ROWS_CAP = 152;
    public static final int OFF_ROW_SPACING = 160;
    public static final int OFF_REVEAL_HINT = 168;
    public static final int OFF_CAPTURED_ROW = 176;
    public static final int OFF_COLLAPSED = 184;
    public static final int SLOT_DESTROY = 0;
    public static final int SLOT_RENDER = 8;
    public static final int SLOT_MOUSE_CLICKED = 32;
    public static final int SLOT_MOUSE_RELEASED = 40;
    public static final int SLOT_MOUSE_DRAGGED = 48;
    public static final int SLOT_MOUSE_MOVED = 64;
    public static final int SLOT_KEY_PRESSED = 72;
    public static final int SLOT_KEY_RELEASED = 80;
    public static final int SLOT_GET_HEIGHT = 96;
    public static final int SLOT_CONTENT_HEIGHT = 104;
    public static final int SLOT_TYPE_ID = 136;
    public static final int SLOT_VALUE_PAD = 144;
    public static final int SLOT_VALUE_MIN = 152;
    public static final long RVA_SETTING_WIDGET_CTOR = 2735201239728L;
    public static final long RVA_DESTROY = 2735201206816L;
    public static final long RVA_RENDER = 2735201211040L;
    public static final long RVA_MOUSE_CLICKED = 2735201213664L;
    public static final long RVA_MOUSE_RELEASED = 2735201214464L;
    public static final long RVA_MOUSE_DRAGGED = 2735201213968L;
    public static final long RVA_MOUSE_MOVED = 2735201214688L;
    public static final long RVA_KEY_PRESSED = 2735201214800L;
    public static final long RVA_KEY_RELEASED = 2735201214896L;
    public static final long RVA_GET_HEIGHT = 2735201210544L;
    public static final long RVA_CONTENT_HEIGHT = 2735201210656L;
    public static final long RVA_TYPE_ID = 2735201190832L;
    public static final long RVA_VALUE_PAD = 2735201175936L;
    public static final long RVA_VALUE_MIN = 2735201175936L;
    public static final long RVA_SYNC_ROWS = 2735201208704L;
    public static final long RVA_ROW_HEIGHT_TOTAL = 2735201210272L;
    public static final long RVA_ROW_FACTORY = 2735201206896L;
    public static final long RVA_INPUT_ROW_FACTORY = 2735201204656L;
    public static final long RVA_COLLECT_ROWS = 2735201213296L;
    public static final long RVA_DRAW_ROW = 2735201211920L;
    public static final long RVA_DRAW_ROW_ICON = 2735201212624L;
    public static final long RVA_DRAW_ROW_HEAD = 2735201219648L;
    public static final long RVA_COMPACT_ROWS = 2735201215568L;
    public static final long RVA_ASSIGN_ROWS = 2735201215920L;
    public static final long RVA_PUSH_ROW = 2735199955088L;
    public static final long RVA_RESERVE = 2735201215232L;
    public static final long RVA_RESIZE = 2735201217040L;
    public static final long RVA_ROW_BASE_CTOR = 2735201206896L;
    public static final long RVA_BUTTON_RELEASE = 2735200896704L;
    public static final long RVA_BUTTON_DRAG = 2735200896480L;
    public static final long RVA_MEASURE_LABEL_HEIGHT = 2735201240352L;
    public static final long RVA_MEASURE_VALUE_HEIGHT = 2735201240064L;
    public static final long RVA_DRAW_HEADER = 2735201240576L;
    public static final long RVA_DRAW_LABEL = 2735201241104L;
    public static final long RVA_DRAW_ROW_BACKGROUND = 2735200823424L;
    public static final long RVA_DRAW_ROW_INNER = 2735200824272L;
    public static final long RVA_DRAW_ROW_DIVIDER = 2735200821536L;
    public static final long RVA_WRAP_TEXT = 2735203199984L;
    public static final long RVA_DRAW_TEXT_WRAP = 2735203176960L;
    public static final long RVA_HOVER_GATE_POINTER = 2735213249200L;
    public static final long RVA_MOUSE_INSIDE = 2735213242813L;
    public static final long RVA_HOVERED_WIDGET = 2735213246056L;
    public static final float DEFAULT_WIDTH = 269.0f;
    public static final float ROW_SPACING = 2.0f;
    public static final float ROW_SPACING_COLLAPSED = 0.04f;
    public static final float PAD_Y = 6.0f;
    public static final float PAD_X = 8.0f;
    public static final float ROW_INSET = 3.0f;
    public static final float ROW_SIDE_INSET = 6.0f;
    public static final float ROW_RADIUS = 10.0f;
    public static final float OPTION_RADIUS = 8.0f;
    public static final float LABEL_FONT = 12.0f;
    public static final float VALUE_FONT = 14.0f;
    public static final float LABEL_LINE_HEIGHT = 14.4f;
    public static final float VALUE_LINE_HEIGHT = 16.800001f;
    public static final float VALUE_MIN_HEIGHT = 20.0f;
    public static final float EPSILON = 0.001f;
    public static final float HALF = 0.5f;
    public static final float ONE = 1.0f;
    public static final float ZERO = 0.0f;
    public static final int TYPE_ID = 27;
    public static final int HOVER_KIND_ROW = 1;
    public static boolean hoverGatePointerNull = true;
    public static boolean mouseInsideWindow;
    public static int hoveredWidget;
    protected Setting group;
    protected final List<Setting> members = new ArrayList<Setting>();
    protected final List<Row> rows = new ArrayList<Row>();
    protected float rowSpacing = 2.0f;
    protected float revealHint;
    protected Row capturedRow;
    protected boolean collapsed = true;
    protected float labelWidthKey = -1.0f;
    protected float labelHeight;
    protected float valueHeightKey = -1.0f;
    protected float valueHeight;
    public static final float INNER_GAP = 3.0f;

    public CompactGroupWidget() {
    }

    public CompactGroupWidget(Setting group) {
        this.initSettingWidget(group);
    }

    public void setMembers(List<Setting> values) {
        this.members.clear();
        if (values != null) {
            this.members.addAll(values);
        }
    }

    public List<Setting> getMembers() {
        return this.members;
    }

    protected void initSettingWidget(Setting group) {
        this.flags = 256;
        this.x = 0.0f;
        this.y = 0.0f;
        this.width = 0.0f;
        this.height = 0.0f;
        this.animXFrom = 0.0f;
        this.animYFrom = 0.0f;
        this.animatingPosition = false;
        this.group = group;
        this.rows.clear();
        this.rowSpacing = 2.0f;
        this.revealHint = 0.0f;
        this.capturedRow = null;
        this.collapsed = true;
        this.width = 269.0f;
    }

    public Setting getGroup() {
        return this.group;
    }

    public List<Row> getRows() {
        return this.rows;
    }

    protected static long clock() {
        return System.nanoTime();
    }

    protected int getTypeId() {
        return 27;
    }

    protected float getValuePad() {
        return 16.0f;
    }

    protected float getValueMin() {
        return 16.0f;
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

    protected float measureLabelHeight(float available) {
        if (available != this.labelWidthKey) {
            int lines = CompactGroupWidget.wrapLineCount(0, this.settingLabel(), 12.0f, available);
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
            int lines = CompactGroupWidget.wrapLineCount(2, this.settingValue(), 14.0f, local);
            float measured = (float)lines * 16.800001f;
            this.valueHeightKey = local;
            this.valueHeight = measured;
            return measured;
        }
        return this.valueHeight;
    }

    protected String settingLabel() {
        return this.group == null ? "" : this.group.getName();
    }

    protected String settingValue() {
        return this.group == null ? "" : this.group.getName();
    }

    protected float drawHeader(Object mat, float available, float alpha) {
        float measured = this.measureValueHeight(available);
        CompactGroupWidget.drawValueTextAtEdge(mat, this.x + this.width, this.y, this.settingValue(), alpha);
        return measured;
    }

    protected float drawLabel(Object mat, float yOffset, float alpha) {
        float measured = this.measureLabelHeight(this.width);
        CompactGroupWidget.drawLabelText(mat, this.x, yOffset + this.y, 12.0f, AbstractTrackChoiceWidget.rendererColor(), alpha);
        return measured;
    }

    protected static void drawValueTextAtEdge(Object mat, float px, float py, String text, float alpha) {
    }

    protected static void drawLabelText(Object mat, float px, float py, float size, int color, float alpha) {
    }

    protected static void drawRowBackground(Object mat, float px, float py, float w, float h, float radius, float alpha) {
    }

    protected static void drawRowInner(Object mat, float px, float py, float w, float h, float radius, int color, float alpha) {
    }

    protected static void drawRowDivider(Object mat, float px, float py, float w, float h, int color, float alpha) {
    }

    protected static void drawRowIcon(Object mat, Row row, float px, float alpha) {
    }

    protected static void drawRowText(Object mat, String text, float px, float available, float size, float alpha) {
    }

    public static boolean hoverAllowed() {
        return hoverGatePointerNull || mouseInsideWindow;
    }

    public static Row createRow(CompactGroupWidget owner, Setting setting) {
        if (setting == null) {
            return null;
        }
        Setting.Type type = setting.getType();
        if (type == Setting.Type.KEYBIND) {
            return new HotkeyRow(owner, setting);
        }
        if (type == Setting.Type.BOOLEAN) {
            return new SwitchRow(owner, setting);
        }
        if (type == Setting.Type.NUMBER) {
            return new SliderRow(owner, setting);
        }
        if (type == Setting.Type.COLOR) {
            return new ColorRow(owner, setting);
        }
        if (type == Setting.Type.GRADIENT) {
            return new ColorRow(owner, setting);
        }
        if (type == Setting.Type.MODE) {
            return new DropDownRow(owner, setting);
        }
        if (type == Setting.Type.TEXT) {
            return new InputRow(owner, setting);
        }
        return null;
    }

    protected List<Setting> groupSettings() {
        ArrayList<Setting> list = new ArrayList<Setting>();
        for (Setting child : this.members) {
            if (child == null || !this.settingVisible(child)) continue;
            list.add(child);
        }
        return list;
    }

    protected boolean settingVisible(Setting candidate) {
        return candidate == null || candidate.isVisible();
    }

    @Override
    public void syncRows() {
        ArrayList<Setting> wanted = new ArrayList<Setting>();
        for (Setting child : this.members) {
            if (child == null || !this.settingVisible(child)) continue;
            wanted.add(child);
        }
        float spacing = this.collapsed ? 0.0f : 0.04f;
        ArrayList<Row> ordered = new ArrayList<Row>();
        int visibleIndex = 0;
        for (Setting setting : wanted) {
            Row existing = null;
            for (Row row : this.rows) {
                if (row.setting != setting) continue;
                existing = row;
                break;
            }
            if (existing != null) {
                if (!existing.visible) {
                    existing.visible = true;
                    existing.y = 0.0f;
                }
                ordered.add(existing);
                continue;
            }
            Row created = CompactGroupWidget.createRow(this, setting);
            if (created == null) continue;
            if (spacing <= 0.0f) {
                if (!created.visible) {
                    created.y = 0.0f;
                    created.visible = true;
                }
            } else {
                float target = (float)visibleIndex * spacing;
                if (!created.visible) {
                    if (target <= 0.0f) {
                        target = 0.0f;
                    }
                    created.y = target;
                    created.visible = true;
                }
            }
            this.rows.add(created);
            ordered.add(created);
            ++visibleIndex;
        }
        int hiddenIndex = 0;
        for (Row row : this.rows) {
            float target;
            boolean present = false;
            for (Row keep : ordered) {
                if (keep != row) continue;
                present = true;
                break;
            }
            if (present || !row.visible) continue;
            if (spacing <= 0.0f) {
                target = 0.0f;
            } else {
                target = (float)hiddenIndex * spacing;
                if (target <= 0.0f) {
                    target = 0.0f;
                }
            }
            row.visible = false;
            row.y = target;
            ++hiddenIndex;
        }
        ArrayList<Row> arrayList = new ArrayList<Row>();
        arrayList.addAll(ordered);
        for (Row row : this.rows) {
            if (arrayList.contains(row)) continue;
            arrayList.add(row);
        }
        this.rows.clear();
        this.rows.addAll(arrayList);
        this.assignRows();
        if (this.collapsed) {
            for (Row row : this.rows) {
                row.reveal = 1.0f;
                row.visible = true;
            }
            this.collapsed = false;
        }
        this.compactRows();
        for (Row row : this.rows) {
            row.markVisible();
        }
    }

    protected void assignRows() {
    }

    protected void compactRows() {
    }

    protected float rowHeightTotal() {
        float clampHigh = 1.0f;
        boolean first = true;
        float total = 0.0f;
        for (Row row : this.rows) {
            float clamped = row.reveal;
            if (clamped < 0.0f) {
                clamped = 0.0f;
            }
            if (clamped > clampHigh) {
                clamped = clampHigh;
            }
            float weight = row.heightForReveal(clamped);
            if (!first) {
                total += weight * this.rowSpacing;
            }
            first = false;
            float spacing = row.spacing();
            total += spacing * weight;
        }
        if (0.001f < total) {
            return total + 6.0f;
        }
        return 0.0f;
    }

    protected float measureHeight() {
        this.syncRows();
        float label = this.measureLabelHeight(this.width);
        float value = this.measureValueHeight(this.width);
        if (label > 0.0f) {
            value = value + 0.0f + label;
        }
        float rowsHeight = this.rowHeightTotal();
        return rowsHeight + value + 6.0f;
    }

    public void measure() {
        this.measureHeight();
    }

    protected float contentHeight() {
        float label = this.measureLabelHeight(this.width);
        float value = this.measureValueHeight(this.width);
        float rowHeight = 26.0f;
        float accumulated = 0.0f;
        int count = 0;
        for (Setting child : this.members) {
            if (child == null || !this.settingVisible(child)) continue;
            float height = rowHeight;
            for (Row row : this.rows) {
                if (row.setting != child) continue;
                height = row.heightValue();
            }
            accumulated += height;
            ++count;
        }
        if (label > 0.0f) {
            value = value + 0.0f + label;
        }
        value += 6.0f;
        float extra = 0.0f;
        if (count != 0) {
            extra = (float)(count - 1) + (float)(count - 1) + accumulated + 6.0f;
        }
        return value + extra;
    }

    protected List<RowEntry> collectRows() {
        ArrayList<RowEntry> list = new ArrayList<RowEntry>();
        float boundsX = this.x + 3.0f;
        float boundsWidth = this.width - 6.0f;
        int index = 0;
        for (Row row : this.rows) {
            float weight;
            float clamped = row.reveal;
            if (clamped < 0.0f) {
                clamped = 0.0f;
            }
            if (clamped > 1.0f) {
                clamped = 1.0f;
            }
            if (0.001f < (weight = row.heightForReveal(clamped))) {
                list.add(new RowEntry(row, boundsX, row.boundsY, boundsWidth, index));
            }
            ++index;
        }
        return list;
    }

    protected void drawRow(Object mat, Row row, float boundsX, float boundsY, float boundsWidth, float mouseX, float mouseY, float alpha) {
        CompactGroupWidget.drawRowDivider(mat, boundsX, boundsY, boundsWidth, row.height, 0, alpha);
        CompactGroupWidget.drawRowInner(mat, boundsX, boundsY, boundsWidth, row.height, 10.0f, 0, alpha);
        row.preRender();
        CompactGroupWidget.drawRowIcon(mat, row, boundsX, alpha);
        float textX = boundsX + 8.0f + 16.0f + 6.0f;
        float content = row.measureContent(boundsX, alpha);
        float inset = row.contentInset();
        row.postContent();
        float available = content - textX - inset;
        CompactGroupWidget.drawRowText(mat, row.setting == null ? "" : row.setting.getName(), textX, available, 12.0f, alpha);
        row.render(mat, boundsX, boundsY, boundsWidth, mouseX, mouseY, alpha);
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        boolean handled = false;
        for (RowEntry entry : this.collectRows()) {
            if (!handled) {
                boolean rowHandled = entry.row.mouseClicked(mx, my, button, entry.boundsX, entry.boundsY, entry.boundsWidth);
                if (rowHandled) {
                    handled = true;
                    continue;
                }
                entry.row.reset();
                continue;
            }
            entry.row.reset();
        }
        return handled;
    }

    @Override
    public boolean mouseReleased(double mx, double my, int button) {
        if (button != 0) {
            return false;
        }
        if (this.capturedRow == null) {
            boolean any = false;
            boolean previous = false;
            for (Row row : this.rows) {
                Object target = row.interactionTarget();
                if (target == null) continue;
                boolean handled = CompactGroupWidget.buttonRelease(target, mx, my);
                previous = any;
                if (!handled) continue;
                any = true;
                previous = true;
            }
            return previous;
        }
        this.capturedRow = null;
        return true;
    }

    protected static boolean buttonRelease(Object target, double mx, double my) {
        return false;
    }

    protected static boolean buttonDrag(Object target, double mx, double my) {
        return false;
    }

    @Override
    public boolean mouseMoved(double mx, double my, double delta) {
        int button = (int)delta;
        if (button != 0) {
            return false;
        }
        if (this.capturedRow != null) {
            for (RowEntry entry : this.collectRows()) {
                if (entry.row != this.capturedRow) continue;
                return entry.row.drag(this.capturedRow.interactionTarget(), mx, entry.index);
            }
            return false;
        }
        for (Row row : this.rows) {
            Object target = row.interactionTarget();
            if (target == null || !CompactGroupWidget.buttonDrag(target, mx, my)) continue;
            return true;
        }
        return false;
    }

    public boolean mouseMovedRows(double mx, double my) {
        for (Row row : this.rows) {
            if (!row.mouseMoved(mx, my)) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean keyPressed(int keyCode, int modifiers) {
        for (Row row : this.rows) {
            if (!row.keyPressed(keyCode)) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean keyReleased(int keyCode) {
        for (Row row : this.rows) {
            if (!row.keyReleased(keyCode)) continue;
            return true;
        }
        return false;
    }

    public void renderWidget(Object mat, float mouseX, float mouseY, float alpha) {
        float weight;
        float clamped;
        this.syncRows();
        float valueMeasured = this.drawHeader(mat, this.width, alpha);
        float labelMeasured = this.drawLabel(mat, valueMeasured, alpha);
        if (labelMeasured > 0.0f) {
            valueMeasured = valueMeasured + 0.0f + labelMeasured;
        }
        float top = this.y + valueMeasured + 6.0f;
        boolean anyVisible = false;
        for (Row row : this.rows) {
            if (!(0.001f < row.reveal)) continue;
            anyVisible = true;
            break;
        }
        if (!anyVisible) {
            this.height = top - this.y;
            return;
        }
        float rowsHeight = this.rowHeightTotal();
        CompactGroupWidget.drawRowBackground(mat, this.x, top, this.width, rowsHeight, 10.0f, alpha);
        boolean first = true;
        float cursor = top + 3.0f;
        float boundsX = this.x + 3.0f;
        for (Row row : this.rows) {
            clamped = row.reveal;
            if (clamped < 0.0f) {
                clamped = 0.0f;
            }
            if (clamped > 1.0f) {
                clamped = 1.0f;
            }
            weight = row.heightForReveal(clamped);
            if (!first) {
                cursor += weight * this.rowSpacing;
            }
            first = false;
            row.boundsY = cursor;
            if (!row.homeSet) {
                row.homeY = cursor;
                row.homeSet = true;
            }
            float spacing = row.spacing();
            cursor += spacing * weight;
        }
        for (Row row : this.rows) {
            clamped = row.reveal;
            if (clamped < 0.0f) {
                clamped = 0.0f;
            }
            if (clamped > 1.0f) {
                clamped = 1.0f;
            }
            if (!(0.001f < (weight = row.heightForReveal(clamped)))) continue;
            this.drawRow(mat, row, boundsX, row.boundsY, this.width - 6.0f, mouseX, mouseY, weight * alpha);
        }
        this.height = top - this.y + rowsHeight;
    }

    @Override
    public void render() {
    }

    public static class Row {
        public static final int OFF_OWNER = 8;
        public static final int OFF_SETTING = 16;
        public static final int OFF_HEIGHT = 24;
        public static final int OFF_REVEAL = 28;
        public static final int OFF_VISIBLE = 32;
        public static final int OFF_Y = 36;
        public static final int OFF_HEIGHT_FN = 40;
        public static final int OFF_FLAGS = 48;
        public static final int OFF_HOME_SET = 49;
        public static final int OFF_HOME_Y = 52;
        public static final int OFF_BOUNDS_Y = 56;
        public static final int SLOT_DESTROY = 0;
        public static final int SLOT_SPACING = 8;
        public static final int SLOT_HEIGHT_VALUE = 16;
        public static final int SLOT_MARK_VISIBLE = 24;
        public static final int SLOT_RENDER = 32;
        public static final int SLOT_MOUSE_CLICKED = 40;
        public static final int SLOT_MEASURE_CONTENT = 48;
        public static final int SLOT_CONTENT_INSET = 56;
        public static final int SLOT_PRE_RENDER = 64;
        public static final int SLOT_POST_CONTENT = 72;
        public static final int SLOT_INTERACTION_TARGET = 80;
        public static final int SLOT_DRAG = 88;
        public static final int SLOT_MOUSE_MOVED = 96;
        public static final int SLOT_KEY_PRESSED = 104;
        public static final int SLOT_KEY_RELEASED = 112;
        public static final int SLOT_RESET = 120;
        public static final float DEFAULT_HEIGHT = 4.5f;
        public static final float DEFAULT_REVEAL = 0.0f;
        public static final float ROW_HEIGHT = 26.0f;
        public CompactGroupWidget owner;
        public Setting setting;
        public float height = 4.5f;
        public float reveal = 0.0f;
        public boolean visible;
        public float y;
        public float homeY;
        public boolean homeSet;
        public float boundsY;
        public short flags;
        public float boundsX;
        public float boundsWidth;

        public Row() {
        }

        public Row(CompactGroupWidget owner, Setting setting) {
            this.owner = owner;
            this.setting = setting;
            this.height = 4.5f;
            this.reveal = 0.0f;
            this.visible = false;
            this.y = 0.0f;
            this.flags = 0;
            this.homeSet = false;
            this.homeY = 0.0f;
            this.boundsY = 0.0f;
        }

        public float heightForReveal(float value) {
            return 26.0f;
        }

        public float spacing() {
            return 0.0f;
        }

        public float heightValue() {
            return 26.0f;
        }

        public void markVisible() {
            if (this.visible) {
                return;
            }
            this.visible = true;
            this.y = 0.0f;
        }

        public void render(Object mat, float boundsX0, float boundsY0, float boundsWidth0, float mouseX, float mouseY, float alpha) {
        }

        public boolean mouseClicked(double mx, double my, int button, float boundsX0, float boundsY0, float boundsWidth0) {
            return false;
        }

        public float measureContent(float boundsX0, float alpha) {
            return 0.0f;
        }

        public float contentInset() {
            return 0.0f;
        }

        public void preRender() {
        }

        public void postContent() {
        }

        public Object interactionTarget() {
            return null;
        }

        public boolean drag(Object target, double mx, int index) {
            return false;
        }

        public boolean mouseMoved(double mx, double my) {
            return false;
        }

        public boolean keyPressed(int key) {
            return false;
        }

        public boolean keyReleased(int key) {
            return false;
        }

        public void reset() {
        }
    }

    public static final class HotkeyRow
    extends Row {
        public static final long VTABLE_RVA = 12604040L;
        public static final long RVA_CTOR = 2735201206896L;
        public static final int OFF_SETTING = 64;
        public static final int OFF_LISTENING = 72;
        public static final int OFF_HELD = 76;
        public static final int OFF_ANIM = 80;
        public static final int OFF_ANIM_FROM = 200;
        public static final int OFF_ANIM_TARGET = 208;
        public static final int OFF_ANIM_EASING = 216;
        public static final int OFF_ANIM_START = 224;
        public static final int OFF_ANIM_RUNNING = 232;
        public boolean listening;
        public float animFrom;
        public float animTarget;
        public long animStart;
        public boolean animRunning;

        public HotkeyRow() {
        }

        public HotkeyRow(CompactGroupWidget owner, Setting setting) {
            super(owner, setting);
            this.listening = false;
            this.animFrom = 0.0f;
            this.animTarget = 0.0f;
            this.animStart = 0L;
            this.animRunning = false;
        }
    }

    public static final class SwitchRow
    extends Row {
        public static final long VTABLE_RVA = 12604232L;
        public static final int OFF_SETTING = 64;
        public static final int OFF_TOGGLE = 72;
        public static final int OFF_CALLBACK = 232;
        public static final long RVA_CTOR = 2735201206896L;

        public SwitchRow() {
        }

        public SwitchRow(CompactGroupWidget owner, Setting setting) {
            super(owner, setting);
            this.bindToggle(setting != null && setting.getBoolean());
        }

        protected void bindToggle(boolean value) {
        }
    }

    public static final class SliderRow
    extends Row {
        public static final long VTABLE_RVA = 12605112L;
        public static final int OFF_SETTING = 64;
        public static final int OFF_CAPTURED = 72;
        public static final long RVA_CTOR = 2735201206896L;
        public static final int OFF_VALUE = 80;
        public static final int OFF_DRAGGING = 84;
        public static final int OFF_LAST_VALUE = 128;
        public static final int OFF_DRAG_ANIM = 136;
        public float value;
        public boolean draggingValue;
        public float lastValue;
        public float dragAnim = -1.0f;

        public SliderRow() {
        }

        public SliderRow(CompactGroupWidget owner, Setting setting) {
            super(owner, setting);
            this.value = 0.0f;
            this.draggingValue = false;
            this.lastValue = 0.0f;
            this.dragAnim = -1.0f;
        }
    }

    public static final class ColorRow
    extends Row {
        public static final long VTABLE_RVA = 12604424L;
        public static final long RVA_CTOR = 2735201206896L;
        public static final long RVA_COLOR_MODAL_CTOR = 2735201267568L;
        public static final int OFF_COLOR = 64;
        public static final int OFF_GRADIENT = 72;
        public static final int OFF_MODAL = 80;
        public static final int OFF_MODAL_STATE = 1632;
        public boolean gradient;

        public ColorRow() {
        }

        public ColorRow(CompactGroupWidget owner, Setting setting) {
            super(owner, setting);
            this.gradient = setting != null && setting.getType() == Setting.Type.GRADIENT;
        }
    }

    public static final class DropDownRow
    extends Row {
        public static final long VTABLE_RVA = 0xC055C0L;
        public static final long RVA_CTOR = 2735201206896L;
        public static final int OFF_SETTING = 64;
        public static final int OFF_EXPANDED = 72;
        public static final int OFF_LABEL = 80;
        public static final int OFF_OPTIONS = 120;
        public boolean expanded;
        public final List<OptionEntry> options = new ArrayList<OptionEntry>();

        public DropDownRow() {
        }

        public DropDownRow(CompactGroupWidget owner, Setting setting) {
            super(owner, setting);
            this.expanded = false;
            this.buildOptions(setting);
        }

        protected void buildOptions(Setting setting) {
            if (setting == null) {
                return;
            }
            for (String mode : setting.getModes()) {
                boolean selected = mode != null && mode.equals(setting.getMode());
                this.options.add(new OptionEntry(mode, selected ? 1 : 0));
            }
        }

        public static final class OptionEntry {
            public String text;
            public int color;

            public OptionEntry(String text, int color) {
                this.text = text;
                this.color = color;
            }
        }
    }

    public static final class InputRow
    extends Row {
        public static final long VTABLE_RVA = 12604560L;
        public static final long RVA_CTOR = 2735201204656L;
        public static final int OFF_SETTING = 64;
        public static final int OFF_TEXT = 72;
        public static final int OFF_LABEL_HEIGHT = 104;
        public static final int OFF_FLAGS = 108;
        public static final int OFF_MULTILINE = 109;
        public static final int OFF_SECRET = 110;
        public static final int OFF_VALUE = 144;
        public static final int OFF_FOCUS_ANIM = 288;
        public static final int OFF_FIELD_ANIM = 328;
        public static final int OFF_FOCUSED = 368;
        public String text = "";
        public String value = "";
        public float labelHeight = 12.0f;
        public boolean multiline = true;
        public boolean secret;
        public boolean focused;
        public float focusAnim;
        public float fieldAnim = 1.0f;

        public InputRow() {
        }

        public InputRow(CompactGroupWidget owner, Setting setting) {
            super(owner, setting);
            this.labelHeight = 12.0f;
            this.value = "";
            this.text = setting == null ? "" : setting.getText();
            this.multiline = true;
            this.fieldAnim = 1.0f;
        }

        public void setFocused(boolean value0) {
            if (this.focused == value0) {
                return;
            }
            this.focused = value0;
            this.focusAnim = value0 ? 1.0f : 0.0f;
        }
    }

    public static final class RowEntry {
        public final Row row;
        public final float boundsX;
        public final float boundsY;
        public final float boundsWidth;
        public final int index;

        public RowEntry(Row row, float boundsX, float boundsY, float boundsWidth, int index) {
            this.row = row;
            this.boundsX = boundsX;
            this.boundsY = boundsY;
            this.boundsWidth = boundsWidth;
            this.index = index;
        }
    }

    public static final class ColorToggleRow
    extends Row {
        public static final long VTABLE_RVA = 12605248L;
        public static final long RVA_CTOR = 2735201206896L;
        public static final long RVA_COLOR_MODAL_CTOR = 2735201267568L;
        public static final int OFF_SETTING = 64;
        public static final int OFF_MODAL = 72;
        public static final int OFF_TOGGLE = 1480;
        public static final int OFF_ENABLED_ANIM = 1672;
        public static final int OFF_TOGGLE_HELD = 1856;
        public boolean enabled;

        public ColorToggleRow() {
        }

        public ColorToggleRow(CompactGroupWidget owner, Setting setting) {
            super(owner, setting);
            this.enabled = setting != null && setting.getBoolean();
        }
    }
}

