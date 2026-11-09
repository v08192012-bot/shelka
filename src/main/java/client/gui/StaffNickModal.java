package client.gui;

import client.gui.AbstractOverlay;
import client.gui.Component;
import client.gui.Screen;
import java.util.ArrayList;
import java.util.List;

public class StaffNickModal extends AbstractOverlay {
    public static final long VTABLE_RVA = 12609832L;
    public static final long RVA_CTOR = 1558896L;
    public static final long RVA_DTOR_BODY = 1647120L;
    public static final long RVA_DTOR = 1647056L;
    public static final long RVA_SET_CHILD = 1647232L;
    public static final long RVA_SET_CHILD_ALT = 1647392L;
    public static final long RVA_ON_TEXT_CHANGED = 1647552L;
    public static final long RVA_CONTENT_HEIGHT = 1647904L;
    public static final long RVA_RENDER = 1648192L;
    public static final long RVA_SYNC_ROWS = 1648880L;
    public static final long RVA_DRAW_ROW = 1649952L;
    public static final long RVA_MOUSE_CLICKED = 1650960L;
    public static final long RVA_MOUSE_SCROLLED = 1651808L;
    public static final long RVA_KEY_PRESSED = 1652096L;
    public static final long RVA_CHAR_TYPED = 1652208L;
    public static final long RVA_ON_CLOSED = 1652256L;
    public static final long RVA_DESTROY_ROW = 1652336L;
    public static final long RVA_SORT_ROWS = 1652400L;
    public static final long RVA_REBUILD_ROWS = 1652784L;
    public static final long RVA_MERGE_ROWS = 1655120L;
    public static final long RVA_FREE_ROWS = 1655792L;
    public static final int OFF_X = 8;
    public static final int OFF_Y = 12;
    public static final int OFF_WIDTH = 16;
    public static final int OFF_HEIGHT = 20;
    public static final int OFF_CLOSED = 136;
    public static final int OFF_CLOSE_OUTSIDE = 137;
    public static final int OFF_CLOSE_ESCAPE = 138;
    public static final int OFF_CHILD = 200;
    public static final int OFF_SETTING = 208;
    public static final int OFF_INPUT = 216;
    public static final int OFF_INPUT_X = 224;
    public static final int OFF_INPUT_Y = 228;
    public static final int OFF_INPUT_TEXT = 312;
    public static final int OFF_INPUT_TEXT_LEN = 328;
    public static final int OFF_INPUT_TEXT_CAP = 336;
    public static final int OFF_INPUT_TEXT_BACKING = 352;
    public static final int OFF_INPUT_ON_SUBMIT = 456;
    public static final int OFF_ACTIVE = 572;
    public static final int OFF_FOCUS_ANIM = 576;
    public static final int OFF_ROWS = 656;
    public static final int OFF_ROWS_END = 664;
    public static final int OFF_ROWS_CAP = 672;
    public static final int OFF_ROW_GAP = 680;
    public static final int OFF_ROW_INDEX = 688;
    public static final int OFF_SCROLL_ANIM = 696;
    public static final int OFF_SCROLL_POS = 736;
    public static final int OFF_ROW_HOVER_ANIM = 40;
    public static final int OFF_ROW_NAME = 80;
    public static final int OFF_ROW_NAME_LEN = 96;
    public static final int OFF_ROW_NAME_CAP = 104;
    public static final int OFF_ROW_WEIGHT = 116;
    public static final int OFF_ROW_ENABLED = 120;
    public static final int OFF_ROW_DELAY = 124;
    public static final int OFF_ROW_POS_INIT = 137;
    public static final int OFF_ROW_POS = 140;
    public static final int OFF_ROW_POS_TARGET = 144;
    public static final float PAD = 16.0f;
    public static final float PAD_2X = 32.0f;
    public static final float ONE = 1.0f;
    public static final float ZERO = 0.0f;
    public static final float HALF = 0.5f;
    public static final float RADIUS = 12.0f;
    public static final float HEADER = 36.0f;
    public static final float GAP = 8.0f;
    public static final float EPS = 0.001f;
    public static final float ROW_GAP = 4.0f;
    public static final float ROW_INSET = 6.0f;
    public static final float ROW_BOTTOM = 3.0f;
    public static final float ROW_ACTION = 13.0f;
    public static final float ROW_ICON_GAP = 5.0f;
    public static final float ROW_STEP = 20.0f;
    public static final float ROW_TEXT_GAP = 10.0f;
    public static final float F14 = 14.0f;
    public static final float F48 = 48.0f;
    public static final float MODAL_WIDTH = 310.0f;
    public static final float MODAL_HEIGHT = 232.0f;
    public static final float FIELD_WIDTH = 278.0f;
    public static final float FIELD_HEIGHT = 36.0f;
    public static final float FIELD_PAD = 12.0f;
    public static final float FIELD_SCROLL = 0.28f;
    public static final float FOCUS_DURATION = 0.15f;
    public static final int THEME_PRIMARY = 0;
    public static final int THEME_SECONDARY = 8;
    public static final int THEME_PANEL = 12;
    public static final int THEME_ROW_A = 16;
    public static final int THEME_ROW_B = 24;
    private static final String PLACEHOLDER = "\u0412\u0441\u0442\u0430\u0432\u044c\u0442\u0435 \u043d\u0438\u043a\u0438 \u0447\u0435\u0440\u0435\u0437 \u043f\u0440\u043e\u0431\u0435\u043b, Enter";
    protected NickList setting;
    protected TextField input;
    protected boolean active;
    protected final AbstractOverlay.Animator focusAnim = new AbstractOverlay.Animator();
    protected final List<NickRow> rows = new ArrayList<NickRow>();
    protected float rowGap = 4.0f;
    protected int rowIndex = -1;
    protected final AbstractOverlay.Animator scrollAnim = new AbstractOverlay.Animator();
    protected float scrollPos;
    protected Runnable onChanged;

    public StaffNickModal(NickList setting) {
        this.setting = setting;
        this.input = new TextField(278.0f, 36.0f, PLACEHOLDER, 14.0f, 12.0f, 0);
        this.rows.clear();
        this.rowGap = 4.0f;
        this.rowIndex = -1;
        StaffNickModal.resetAnimator(this.scrollAnim, 0.0f, 0.28f, 2);
        this.scrollPos = 0.0f;
        this.width = 310.0f;
        this.height = 232.0f;
        this.closeOnOutsideClick = false;
    }

    @Override
    public void dispose() {
        this.freeRows();
        this.input.dispose();
        if (this.child != null) {
            this.child = null;
        }
        this.children.clear();
        this.capture = null;
    }

    @Override
    public void setChild(Component value) {
        this.scrollPos = 0.0f;
        this.scrollAnim.from = 0.0f;
        this.scrollAnim.current = 0.0f;
        this.scrollAnim.target = 0.0f;
        this.scrollAnim.running = false;
        super.setChild(value);
    }

    @Override
    public void setChildAlt(Component value) {
        this.scrollPos = 0.0f;
        this.scrollAnim.from = 0.0f;
        this.scrollAnim.current = 0.0f;
        this.scrollAnim.target = 0.0f;
        this.scrollAnim.running = false;
        super.setChildAlt(value);
    }

    public boolean onTextChanged() {
        String text = this.input.text;
        int length = text.length();
        if (length == 0) {
            return true;
        }
        int added = 0;
        int index = 0;
        while (true) {
            if (index < length && StaffNickModal.isSpace(text.charAt(index))) {
                ++index;
                continue;
            }
            int end = index;
            if (index < length) {
                for (end = index; end < length && !StaffNickModal.isSpace(text.charAt(end)); ++end) {
                }
                if (index < end && this.setting.add(text.substring(index, end))) {
                    ++added;
                }
            }
            index = end;
            if (end >= length) break;
        }
        if (added != 0) {
            this.input.clearText();
            if (this.onChanged != null) {
                this.onChanged.run();
            }
            this.scrollPos = 0.0f;
        }
        return true;
    }

    public float contentHeight(float viewHeight) {
        float weightMax = 1.0f;
        float step = 20.0f;
        float total = 0.0f;
        float viewport = viewHeight - 8.0f;
        boolean first = true;
        for (int i = 0; i < this.rows.size(); ++i) {
            NickRow row = this.rows.get(i);
            float weight = row.weight;
            if (weight < 0.0f) {
                weight = 0.0f;
            }
            if (weight > weightMax) {
                weight = weightMax;
            }
            float rowHeight = row.measuredHeight(weight);
            if (!first) {
                total += rowHeight * this.rowGap;
            }
            first = false;
            total += rowHeight * step;
        }
        if (viewport <= 0.0f) {
            viewport = 0.0f;
        }
        if ((total -= viewport) <= 0.0f) {
            total = 0.0f;
        }
        return total;
    }

    public void syncRows(Object target, float mouseX, float mouseY, float alpha, float top, float viewHeight) {
        float rowHeight;
        float weight;
        NickRow row;
        int i;
        String[] names = this.setting.nameArray();
        this.mergeRows(names, 0.0f);
        this.rebuildRows(names);
        this.sortRows();
        float left = this.x + 16.0f;
        float listWidth = this.width - 32.0f;
        StaffNickModal.drawBoxGradient(target, left, top, listWidth);
        float maxScroll = this.contentHeight(viewHeight);
        float next = this.scrollPos;
        if (next < 0.0f) {
            next = 0.0f;
        }
        if (next > maxScroll) {
            next = maxScroll;
        }
        this.scrollPos = next;
        if (this.scrollAnim.target != next) {
            StaffNickModal.animate(this.scrollAnim, next);
        }
        long time = this.now();
        StaffNickModal.advance(this.scrollAnim, time);
        float rowLeft = left + 4.0f;
        float y = top + 4.0f - this.scrollAnim.current;
        boolean first = true;
        for (i = 0; i < this.rows.size(); ++i) {
            row = this.rows.get(i);
            weight = row.weight;
            if (weight < 0.0f) {
                weight = 0.0f;
            }
            if (weight > 1.0f) {
                weight = 1.0f;
            }
            rowHeight = row.measuredHeight(weight);
            if (!first) {
                y += rowHeight * this.rowGap;
            }
            first = false;
            row.posTarget = y;
            if (!row.posInitialized) {
                row.pos = y;
                row.posInitialized = true;
            }
            y += rowHeight * 20.0f;
        }
        StaffNickModal.setScissor(rowLeft, top, listWidth, viewHeight);
        for (i = 0; i < this.rows.size(); ++i) {
            float rowY;
            row = this.rows.get(i);
            weight = row.weight;
            if (weight < 0.0f) {
                weight = 0.0f;
            }
            if (weight > 1.0f) {
                weight = 1.0f;
            }
            if (!(0.001f < (rowHeight = row.measuredHeight(weight))) || !(top <= (rowY = row.pos) + 20.0f) || !(rowY <= top + viewHeight)) continue;
            this.drawRow(rowHeight * alpha, target, row, rowLeft, rowY, listWidth, mouseX, mouseY);
        }
        StaffNickModal.resetScissor();
    }

    public void drawRow(float rowAlpha, Object target, NickRow row, float left, float rowY, float listWidth, float mouseX, float mouseY) {
        float inset = 6.0f;
        StaffNickModal.drawRowBackground(target, left, rowY);
        StaffNickModal.drawIcon(target, 34, left + inset, rowY + 5.0f);
        float actionLeft = left + listWidth - inset - 13.0f;
        float iconTop = rowY + 3.0f;
        float textLeft = left + inset + 10.0f + inset;
        float textWidth = actionLeft - inset - textLeft;
        if (textWidth <= 0.0f) {
            textWidth = 0.0f;
        }
        String clipped = StaffNickModal.clipText(row.name, textWidth, 12.0f);
        StaffNickModal.drawText(1, target, clipped, textLeft);
        float hover = 0.0f;
        if (actionLeft <= mouseX && mouseX <= actionLeft + 13.0f && iconTop <= mouseY && mouseY <= iconTop + 14.0f) {
            Screen.hoveredWidget = 1;
            hover = 1.0f;
        }
        if (row.hoverAnim.target != hover) {
            StaffNickModal.animate(row.hoverAnim, hover);
        }
        long time = this.now();
        float eased = StaffNickModal.advance(row.hoverAnim, time);
        StaffNickModal.uiLerpColor(StaffNickModal.themeColor(16), StaffNickModal.themeColor(24), eased);
        StaffNickModal.drawIcon(target, 32, actionLeft, iconTop);
    }

    @Override
    public void renderBody(Object target, float px, float py, float parentAlpha) {
        float source = parentAlpha;
        float top = (1.0f - StaffNickModal.clamp01(source)) * 16.0f + this.y;
        float bottom = this.height * 0.5f + top;
        Object rect = StaffNickModal.makeRect(new float[8], bottom, source, this.width * 0.5f + this.x, bottom);
        int themePrimary = StaffNickModal.themeColor(0);
        int themePanel = StaffNickModal.themeColor(12);
        StaffNickModal.drawPanel(rect, this.x, top, this.width, this.height, 12.0f, 12.0f, 12.0f, 12.0f, themePrimary, themePanel, 1.0f, 0, 0, 0.0f, 0.0f, source, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        this.input.x = this.x + 16.0f;
        this.input.y = top + 16.0f;
        this.input.render(target, rect, px, py, source);
        float listTop = top + 16.0f + 36.0f + 8.0f;
        this.syncRows(target, px, py, source, listTop, top + this.height - 16.0f - listTop);
    }

    @Override
    public boolean onMouseClicked(double mx, double my, int button) {
        float pad = 16.0f;
        float rowStep = 20.0f;
        if (button == 0) {
            float fieldLeft = this.x + 16.0f;
            if (mx < (double)fieldLeft || (double)(this.width - 32.0f + fieldLeft) < mx || my < (double)(this.y + 16.0f) || (double)(this.y + 16.0f + 36.0f) < my) {
                if (this.active) {
                    this.active = false;
                    StaffNickModal.animate(this.focusAnim, 0.0f);
                    this.input.blur();
                }
                float listLeft = this.x + 16.0f;
                float listTop = this.y + 16.0f + 36.0f + 8.0f;
                float listWidth = this.width - 32.0f;
                if ((double)listLeft <= mx && mx <= (double)(listWidth + listLeft) && (double)listTop <= my && my <= (double)(this.y + this.height - 16.0f - listTop + listTop)) {
                    float innerWidth = listWidth - 8.0f;
                    float innerLeft = listLeft + 4.0f;
                    for (int i = 0; i < this.rows.size(); ++i) {
                        float rowHeight;
                        NickRow row = this.rows.get(i);
                        float weight = row.weight;
                        if (weight < 0.0f) {
                            weight = 0.0f;
                        }
                        if (weight > 1.0f) {
                            weight = 1.0f;
                        }
                        if (!(0.5f < (rowHeight = row.measuredHeight(weight)))) continue;
                        float rowY = row.pos;
                        if (!((double)innerLeft <= mx) || !(mx <= (double)(innerWidth + innerLeft)) || !((double)rowY <= my) || !(my <= (double)(rowY + rowStep))) continue;
                        float actionLeft = innerWidth + innerLeft - 6.0f - 13.0f;
                        if (mx < (double)actionLeft) {
                            return true;
                        }
                        if ((double)(actionLeft + 13.0f) < mx) {
                            return true;
                        }
                        if (my < (double)(rowY + 3.0f)) {
                            return true;
                        }
                        if ((double)(rowY + 3.0f + 14.0f) < my) {
                            return true;
                        }
                        this.setting.toggle(row.name);
                        return true;
                    }
                }
            } else {
                this.input.mouseClicked(mx, my, button);
            }
        }
        return true;
    }

    @Override
    public boolean mouseScrolled(double mx, double my, double amount) {
        float listLeft = this.x + 16.0f;
        float listTop = this.y + 16.0f + 36.0f + 8.0f;
        if ((double)listLeft <= mx && mx <= (double)(this.width - 32.0f + listLeft) && (double)listTop <= my && my <= (double)(listTop + (this.y + this.height - 16.0f - listTop))) {
            float maxScroll = this.contentHeight(this.y + this.height - 16.0f - listTop);
            float next = this.scrollPos - (float)amount * 48.0f;
            if (next <= 0.0f) {
                next = 0.0f;
            }
            if (next > maxScroll) {
                next = maxScroll;
            }
            if (next < 0.0f) {
                next = 0.0f;
            }
            this.scrollPos = next;
            StaffNickModal.animate(this.scrollAnim, this.scrollPos);
            return true;
        }
        return false;
    }

    @Override
    public boolean onKeyPressed(int keyCode, int modifiers) {
        if (!this.active) {
            return false;
        }
        if (keyCode == 27) {
            this.active = false;
            StaffNickModal.animate(this.focusAnim, 0.0f);
            this.input.blur();
            return true;
        }
        this.input.keyPressed(keyCode, modifiers);
        return true;
    }

    @Override
    public boolean charTyped(char ch) {
        if (!this.active) {
            return false;
        }
        this.input.charTyped(ch);
        return true;
    }

    @Override
    public void onClosed() {
        if (this.active) {
            this.active = false;
            StaffNickModal.animate(this.focusAnim, 0.0f);
            this.input.blur();
        }
    }

    public void mergeRows(String[] names, float delayStep) {
        int added = 0;
        for (int i = 0; i < names.length; ++i) {
            String name = names[i];
            NickRow found = null;
            for (int j = 0; j < this.rows.size(); ++j) {
                NickRow row = this.rows.get(j);
                if (row == null || !row.name.equals(name)) continue;
                found = row;
                break;
            }
            if (found != null) {
                if (found.enabled) continue;
                found.enabled = true;
                found.delay = 0.0f;
                continue;
            }
            NickRow created = this.createRow(name);
            if (created == null) continue;
            if (delayStep <= 0.0f) {
                if (!created.enabled) {
                    created.delay = 0.0f;
                    created.enabled = true;
                }
            } else {
                float delay = (float)added * delayStep;
                if (!created.enabled) {
                    if (delay <= 0.0f) {
                        delay = 0.0f;
                    }
                    created.delay = delay;
                    created.enabled = true;
                }
            }
            this.rows.add(created);
            ++added;
        }
        int removed = 0;
        for (int i = 0; i < this.rows.size(); ++i) {
            NickRow row = this.rows.get(i);
            if (row == null) continue;
            boolean present = false;
            for (int j = 0; j < names.length; ++j) {
                if (!names[j].equals(row.name)) continue;
                present = true;
                break;
            }
            if (present || !row.enabled) continue;
            float delay = 0.0f;
            if (delayStep > 0.0f && (delay = (float)removed * delayStep) <= 0.0f) {
                delay = 0.0f;
            }
            row.enabled = false;
            row.delay = delay;
            ++removed;
        }
    }

    public void rebuildRows(String[] names) {
        int matched = 0;
        block0: for (int i = 0; i < this.rows.size(); ++i) {
            NickRow row = this.rows.get(i);
            if (row == null) continue;
            for (int j = 0; j < names.length; ++j) {
                if (!names[j].equals(row.name)) continue;
                if (names.length <= matched) {
                    this.rebuildRowsSlow(names);
                    return;
                }
                if (!names[matched].equals(row.name)) {
                    this.rebuildRowsSlow(names);
                    return;
                }
                ++matched;
                continue block0;
            }
        }
        if (matched == names.length) {
            return;
        }
        this.rebuildRowsSlow(names);
    }

    private void rebuildRowsSlow(String[] names) {
        int i;
        ArrayList<NickRow> next = new ArrayList<NickRow>();
        ArrayList<NickRow> pool = new ArrayList<NickRow>(this.rows);
        for (i = 0; i < names.length; ++i) {
            NickRow row = null;
            for (int j = 0; j < pool.size(); ++j) {
                NickRow candidate = (NickRow)pool.get(j);
                if (candidate == null || !candidate.name.equals(names[i])) continue;
                row = candidate;
                pool.set(j, null);
                break;
            }
            if (row == null) {
                row = this.createRow(names[i]);
            }
            next.add(row);
        }
        for (i = 0; i < pool.size(); ++i) {
            NickRow leftover = (NickRow)pool.get(i);
            if (leftover == null) continue;
            leftover.dispose();
        }
        this.rows.clear();
        this.rows.addAll(next);
    }

    public void sortRows() {
        int first;
        NickRow row;
        long key = this.now();
        for (int i = 0; i < this.rows.size(); ++i) {
            row = this.rows.get(i);
            if (row == null) continue;
            row.sortKey = key;
        }
        for (first = 0; first < this.rows.size() && (row = this.rows.get(first)) != null && (row.enabled || 0.001f < row.weight); ++first) {
        }
        if (first != this.rows.size()) {
            for (int scan = first + 1; scan < this.rows.size(); ++scan) {
                NickRow row2 = this.rows.get(scan);
                if (row2 == null || !row2.enabled && !(0.001f < row2.weight)) continue;
                NickRow previous = this.rows.get(first);
                this.rows.set(scan, null);
                this.rows.set(first, row2);
                if (previous != null) {
                    previous.dispose();
                }
                ++first;
            }
            if (first != this.rows.size()) {
                for (int i = first; i < this.rows.size(); ++i) {
                    NickRow row3 = this.rows.get(i);
                    if (row3 == null) continue;
                    row3.dispose();
                }
                while (this.rows.size() > first) {
                    this.rows.remove(this.rows.size() - 1);
                }
            }
        }
    }

    public void freeRows() {
        for (int i = 0; i < this.rows.size(); ++i) {
            NickRow row = this.rows.get(i);
            if (row == null) continue;
            row.dispose();
        }
        this.rows.clear();
    }

    private NickRow createRow(String name) {
        return new NickRow(name);
    }

    protected static boolean isSpace(char ch) {
        return ch == ' ' || (ch - 9 & 0xFA) == 0 && ch != '\u000e';
    }

    protected static int themeColor(int index) {
        return 0;
    }

    protected static void drawPanel(Object rect, float px, float py, float pw, float ph, float r1, float r2, float r3, float r4, int colorA, int colorB, float alpha1, int border, int borderWidth, float cornerSpread, float thickness, float alpha2, int z1, int z2, int z3, int z4, int z5, int z6, int z7, int z8, int z9, int z10, int z11, int z12, int z13) {
    }

    protected static void drawBox(Object target, float px, float py, float pw, float ph, float r1, float r2, float r3, float r4, int fillTop, int fillBottom, float fillAlpha, int border, float borderWidth, float borderAlpha, float shadowAlpha, float alpha, int flags) {
    }

    protected static void drawBoxGradient(Object target, float px, float py, float pw) {
    }

    protected static void drawText(int mode, Object target, Object text, float px) {
    }

    protected static void drawText(int mode, Object target, Object text, float px, float py, float size, int color, float alpha) {
    }

    protected static void drawIcon(Object target, int icon, float px, float py) {
    }

    protected static void drawIcon(Object target, int icon, float px, float py, float pw, float ph, int color, float alpha) {
    }

    protected static float measureText(Object target, Object text, float size) {
        return 0.0f;
    }

    protected static int measureLines(Object target, Object text, float size, float maxWidth) {
        return 0;
    }

    protected static Object makeRect(Object out, float px, float py, float pw, float ph) {
        return out;
    }

    protected static String clipText(String text, float maxWidth, float size) {
        return text;
    }

    protected static void setScissor(float px, float py, float pw, float ph) {
    }

    protected static void resetScissor() {
    }

    protected static void drawRowBackground(Object target, float px, float py) {
    }

    protected static void drawRowIcon(Object target, int icon, float px, float py, float pw, float ph, int color, float alpha) {
    }

    public static class NickList {
        public final List<String> names = new ArrayList<String>();

        public boolean add(String name) {
            for (int i = 0; i < this.names.size(); ++i) {
                if (!this.names.get(i).equals(name)) continue;
                return false;
            }
            this.names.add(name);
            return true;
        }

        public void toggle(String name) {
            for (int i = 0; i < this.names.size(); ++i) {
                if (!this.names.get(i).equals(name)) continue;
                this.names.remove(i);
                return;
            }
            this.names.add(name);
        }

        public String[] nameArray() {
            return this.names.toArray(new String[this.names.size()]);
        }
    }

    public static class TextField {
        public static final int VTABLE_RVA = 0;
        public static final int OFF_X = 8;
        public static final int OFF_Y = 12;
        public static final int OFF_WIDTH = 16;
        public static final int OFF_HEIGHT = 20;
        public static final int OFF_TEXT = 312;
        public static final int OFF_TEXT_LEN = 328;
        public static final int OFF_TEXT_CAP = 336;
        public static final int OFF_TEXT_BACKING = 352;
        public static final int OFF_FOCUSED = 356;
        public static final int OFF_FOCUS_ANIM = 360;
        public static final int OFF_CARET_ANIM = 400;
        public float x;
        public float y;
        public float width;
        public float height;
        public String text = "";
        public int textLen;
        public int textCap;
        public int textBacking;
        public boolean focused;
        public final AbstractOverlay.Animator focusAnim = new AbstractOverlay.Animator();
        public final AbstractOverlay.Animator caretAnim = new AbstractOverlay.Animator();
        public final String placeholder;
        public final float padding;
        public final float radius;
        public final int flags;

        public TextField(float width, float height, String placeholder, float padding, float radius, int flags) {
            this.width = width;
            this.height = height;
            this.placeholder = placeholder;
            this.padding = padding;
            this.radius = radius;
            this.flags = flags;
        }

        public void render(Object target, Object rect, float mouseX, float mouseY, float alpha) {
            if (this.focused) {
                Screen.textInputActive = true;
            }
            if (this.x <= mouseX && mouseX <= this.x + this.width && this.y <= mouseY && mouseY <= this.y + this.height && (AbstractOverlay.activeOverlay == null || Screen.allowHover)) {
                Screen.hoveredWidget = 2;
            }
            StaffNickModal.drawBox(target, this.x, this.y, this.width, this.height, 8.0f, 8.0f, 8.0f, 8.0f, StaffNickModal.themeColor(0), StaffNickModal.themeColor(12), 1.0f, 0x1A000000, 0.0f, 1.0f, 1.0f, alpha, 0);
            float innerWidth = this.width - this.padding - this.padding - 14.0f;
            float innerY = (this.height - 8.0f) * 0.5f + this.y;
            if (!this.focused && this.text.isEmpty()) {
                StaffNickModal.drawText(0, target, this.placeholder, this.x + this.padding, innerY, 14.0f, StaffNickModal.themeColor(12), alpha);
            } else {
                StaffNickModal.drawText(0, target, this.text, this.x + this.padding, innerY, 14.0f, StaffNickModal.themeColor(12), alpha);
            }
            StaffNickModal.setScissor(this.x + this.padding, this.y, innerWidth, this.height);
            if (0.001f < alpha) {
                StaffNickModal.drawText(0, target, this.text, this.x + this.padding, innerY, 14.0f, StaffNickModal.themeColor(12), alpha);
            }
            if (alpha < 0.999f) {
                StaffNickModal.drawBoxGradient(target, this.x + this.padding, innerY, innerWidth);
            }
            StaffNickModal.resetScissor();
        }

        public boolean mouseClicked(double mx, double my, int button) {
            if (button != 0) {
                return false;
            }
            if ((double)this.x <= mx && mx <= (double)(this.x + this.width) && (double)this.y <= my && my <= (double)(this.y + this.height)) {
                this.setFocused(true);
                return true;
            }
            this.setFocused(false);
            return false;
        }

        public boolean keyPressed(int keyCode, int modifiers) {
            if (keyCode == 13) {
                return true;
            }
            if ((modifiers & 2) != 0) {
                if (keyCode == 65) {
                    this.textBacking = 0;
                    this.textLen = this.text.length();
                    return true;
                }
                if (keyCode == 67) {
                    return true;
                }
                if (keyCode == 88) {
                    return true;
                }
                if (keyCode == 86) {
                    return true;
                }
            }
            if (keyCode == 37) {
                return true;
            }
            if (keyCode == 39) {
                return true;
            }
            if (keyCode == 36) {
                return true;
            }
            if (keyCode == 35) {
                return true;
            }
            if (keyCode == 8) {
                if (!this.text.isEmpty()) {
                    this.text = this.text.substring(0, this.text.length() - 1);
                    this.textLen = this.text.length();
                    this.textBacking = this.text.length();
                }
                return true;
            }
            return keyCode == 46;
        }

        public boolean charTyped(char ch) {
            int value = ch & 0xFFFF;
            if (value < 32 || value == 127) {
                return false;
            }
            int bytes = value < 128 ? 1 : (value < 2048 ? 2 : (value < 65536 ? 3 : 4));
            this.appendUtf8(value, bytes);
            return true;
        }

        private void appendUtf8(int value, int bytes) {
            this.text = bytes == 1 ? this.text + (char)value : (bytes == 2 ? this.text + (char)(0xC0 | value >> 6) + (char)(0x80 | value & 0x3F) : (bytes == 3 ? this.text + (char)(0xE0 | value >> 12) + (char)(0x80 | value >> 6 & 0x3F) + (char)(0x80 | value & 0x3F) : this.text + (char)(0xF0 | value >> 18) + (char)(0x80 | value >> 12 & 0x3F) + (char)(0x80 | value >> 6 & 0x3F) + (char)(0x80 | value & 0x3F)));
            this.textLen = this.text.length();
            this.textBacking = this.text.length();
        }

        public void clearText() {
            this.text = "";
            this.textLen = 0;
            this.textBacking = 0;
            this.textCap = 0;
        }

        public void blur() {
            if (Screen.focusedInput == this) {
                Screen.focusedInput = null;
            }
            this.focused = false;
        }

        public void dispose() {
            if (Screen.focusedInput == this) {
                Screen.focusedInput = null;
            }
            this.focused = false;
            this.focusAnim.running = false;
            this.caretAnim.running = false;
        }

        private void setFocused(boolean value) {
            this.focused = value;
            if (value) {
                Screen.focusedInput = this;
            } else if (Screen.focusedInput == this) {
                Screen.focusedInput = null;
            }
        }
    }

    public static class NickRow {
        public static final int VTABLE_RVA = 0;
        public static final int OFF_VTABLE = 0;
        public static final int OFF_HOVER_ANIM = 40;
        public static final int OFF_NAME = 80;
        public static final int OFF_NAME_LEN = 96;
        public static final int OFF_NAME_CAP = 104;
        public static final int OFF_WEIGHT = 116;
        public static final int OFF_ENABLED = 120;
        public static final int OFF_DELAY = 124;
        public static final int OFF_POS_INIT = 137;
        public static final int OFF_POS = 140;
        public static final int OFF_POS_TARGET = 144;
        public String name;
        public final AbstractOverlay.Animator hoverAnim = new AbstractOverlay.Animator();
        public float weight;
        public boolean enabled;
        public float delay;
        public float pos;
        public boolean posInitialized;
        public float posTarget;
        public long sortKey;

        public NickRow(String name) {
            this.name = name;
            this.enabled = true;
            this.delay = 0.0f;
        }

        public float measuredHeight(float value) {
            return value;
        }

        public void dispose() {
        }
    }
}