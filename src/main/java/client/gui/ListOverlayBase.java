/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.AbstractOverlay;
import java.util.ArrayList;
import java.util.List;

public class ListOverlayBase
extends AbstractOverlay {
    public static final long VTABLE_RVA = 0xC06600L;
    public static final long RVA_CTOR = 1626416L;
    public static final long RVA_DTOR = 1627232L;
    public static final long RVA_DELETING_DTOR = 1627232L;
    public static final long RVA_SET_CHILD = 1627296L;
    public static final long RVA_SET_CHILD_ALT = 1627440L;
    public static final long RVA_ON_SHOW = 1627584L;
    public static final long RVA_HEADER_HEIGHT = 1627776L;
    public static final long RVA_HAS_CONTENT = 1627920L;
    public static final long RVA_BODY_TOP = 1628000L;
    public static final long RVA_LIST_TOP = 1628064L;
    public static final long RVA_ROW_REVEAL = 1626272L;
    public static final long RVA_ROWS_HEIGHT = 1631168L;
    public static final long RVA_RENDER_BODY = 1631456L;
    public static final long RVA_MOUSE_BODY = 1636544L;
    public static final long RVA_MOUSE_BODY_ALT = 1638352L;
    public static final long RVA_MOUSE_RELEASED = 1637984L;
    public static final long RVA_MOUSE_MOVED = 1638432L;
    public static final long RVA_KEY_BODY = 1638832L;
    public static final long RVA_SCROLL_BODY = 1638928L;
    public static final long RVA_RELEASE_DRAG = 1639008L;
    public static final long RVA_CLEANUP = 1567808L;
    public static final long RVA_SEARCH_CTOR = 1398896L;
    public static final long RVA_SEARCH_CALLBACK = 1427152L;
    public static final long RVA_SEARCH_RENDER = 1399648L;
    public static final long RVA_SEARCH_PRESS = 1400800L;
    public static final long RVA_SEARCH_CLICK = 1400672L;
    public static final long RVA_SEARCH_RESET = 1844096L;
    public static final long RVA_MEASURE = 1773456L;
    public static final long RVA_DRAW_BG = 3483568L;
    public static final long RVA_DRAW_TEXT = 3494400L;
    public static final long RVA_DRAW_GLYPH = 3491616L;
    public static final long RVA_DRAW_ROW = 3497136L;
    public static final long RVA_ENGINE_STATE = 3515472L;
    public static final int OFF_SEARCH = 208;
    public static final int OFF_SEARCH_CALLBACK = 304;
    public static final int OFF_SEARCH_ANIM = 560;
    public static final int OFF_SEARCH_FOCUSED = 564;
    public static final int OFF_SCROLL = 648;
    public static final int OFF_SCROLL_ANIM = 656;
    public static final int OFF_ROW_HEAD = 664;
    public static final int OFF_ROW_HEAD_ALT = 672;
    public static final int OFF_FILTER_SET = 680;
    public static final int OFF_FILTER_BUCKETS = 704;
    public static final int OFF_FILTER_BUCKET_COUNT = 712;
    public static final int OFF_FILTER_ALPHA = 720;
    public static final int OFF_NAME_SET = 728;
    public static final int OFF_NAME_LIST = 744;
    public static final int OFF_NAME_BUCKETS = 768;
    public static final int OFF_NAME_BUCKET_COUNT = 776;
    public static final int OFF_PENDING = 784;
    public static final int OFF_ROWS = 808;
    public static final int OFF_ROWS_END = 816;
    public static final int OFF_DRAG_ANIM = 832;
    public static final int OFF_LIST_ANIM = 872;
    public static final int OFF_BUTTON_ANIM = 912;
    public static final int OFF_DRAGGING = 952;
    public static final int OFF_DRAG_GRAB = 956;
    public static final float WIDTH = 335.0f;
    public static final float SEARCH_OFFSET = 311.0f;
    public static final float SEARCH_WIDTH = 303.0f;
    public static final float SEARCH_HEIGHT = 26.0f;
    public static final float SEARCH_PAD = 12.0f;
    public static final float SEARCH_GAP = 32.0f;
    public static final float LIST_ROW_WIDTH = 155.5f;
    public static final float LIST_ROW_HEIGHT = 28.0f;
    public static final float CLOSE_INSET = 14.0f;
    public static final float CLOSE_SIZE = 16.0f;
    public static final float ERROR_GAP = 4.0f;
    public static final float GAP = 8.0f;
    public static final float PAD = 12.0f;
    public static final float BODY_GAP = 10.0f;
    public static final float BODY_HEIGHT = 148.0f;
    public static final float BODY_INSET = 4.0f;
    public static final float BODY_TEXT_HEIGHT = 26.0f;
    public static final float SCROLL_STEP = 48.0f;
    public static final float SCROLLBAR_WIDTH = 6.0f;
    public static final float SCROLLBAR_HEIGHT = 40.0f;
    public static final float SCROLL_LIMIT = 140.0f;
    public static final float HEADER_TEXT_SCALE = 14.4f;
    public static final float HEADER_TEXT_BASE = 30.0f;
    public static final float TITLE_WIDTH = 24.0f;
    public static final float TITLE_GAP = 28.0f;
    public static final float TEXT_SIZE = 12.0f;
    public static final float TEXT_ADVANCE = 14.4f;
    public static final float ROW_TEXT_HEIGHT = 26.0f;
    public static final float ROW_SPACING = 4.0f;
    public static final float ROW_ROUND_TRIP = 2.0f;
    public static final float ROW_CURVE = 0.5f;
    public static final float ROW_HALF = 0.5f;
    public static final float ROW_QUARTER = 4.0f;
    public static final float ALT_BAND = 36.0f;
    public static final float EXTRA_ANIM_DURATION = 0.15f;
    public static final float ALT_BAND_ALT = 278.0f;
    public static final float DRAG_ANIM_DURATION = 0.28f;
    public static final float HOVER_EPSILON = 0.001f;
    public static final float ONE = 1.0f;
    public static final float ZERO = 0.0f;
    public static final float HALF = 0.5f;
    public static final float HEADER_ALPHA = 1.0f;
    public static final float BUCKET_COUNT = 7.0f;
    public static final float BUCKET_CAPACITY = 8.0f;
    public static final float BUCKET_SLOTS = 16.0f;
    protected final SearchField search;
    protected boolean searchFocused;
    protected final AbstractOverlay.Animator searchAnim = new AbstractOverlay.Animator();
    protected float scroll;
    protected float scrollAnim;
    protected final AbstractOverlay.Animator dragAnim = new AbstractOverlay.Animator();
    protected final AbstractOverlay.Animator listAnim = new AbstractOverlay.Animator();
    protected final AbstractOverlay.Animator buttonAnim = new AbstractOverlay.Animator();
    protected boolean dragging;
    protected float dragGrab;
    protected final List<Row> rows = new ArrayList<Row>();
    protected String pendingTitle = "";
    protected static boolean handCursor;

    public ListOverlayBase(String title) {
        this.search = new SearchField(303.0f, 26.0f, title, 12.0f, 32.0f);
        this.searchFocused = false;
        ListOverlayBase.resetAnimator(this.searchAnim, 0.0f, 0.28f, 2);
        this.scroll = 0.0f;
        this.scrollAnim = 0.0f;
        ListOverlayBase.resetAnimator(this.dragAnim, 0.0f, 0.28f, 2);
        ListOverlayBase.resetAnimator(this.listAnim, 0.0f, 0.15f, 0);
        ListOverlayBase.resetAnimator(this.buttonAnim, 0.0f, 0.15f, 0);
        this.dragging = false;
        this.dragGrab = 0.0f;
        this.pendingTitle = title == null ? "" : title;
        this.width = 335.0f;
    }

    public String title() {
        return "";
    }

    public String description() {
        return "";
    }

    public String filterLabel() {
        return "";
    }

    public String filterLabelAlt() {
        return "";
    }

    public boolean filterFlag() {
        return false;
    }

    public void toggleFilter() {
    }

    public void rebuildRows() {
    }

    public List<Row> rowList() {
        return this.rows;
    }

    public Row headerRowA() {
        return null;
    }

    public Row headerRowB() {
        return null;
    }

    public void onHeaderRowA() {
    }

    public void onHeaderRowB() {
    }

    public boolean onRowClicked(Row row, double mx, double my, float left, float top, float width) {
        return true;
    }

    public void onShowHook() {
    }

    public boolean onMouseMovedHook() {
        return false;
    }

    protected float headerHeight() {
        float maxWidth = this.width - 24.0f - 28.0f;
        float measured = ListOverlayBase.measureText(this.description(), 12.0f, maxWidth);
        return measured * 14.4f + 30.0f;
    }

    protected static float measureText(String text, float size, float maxWidth) {
        return 0.0f;
    }

    protected boolean hasContent() {
        Row a = this.headerRowA();
        if (a != null) {
            return true;
        }
        Row b = this.headerRowB();
        return b != null;
    }

    protected float bodyTop(float baseY) {
        return this.headerHeight() + baseY + 10.0f + 26.0f + 8.0f;
    }

    protected float listTop(float baseY) {
        return this.headerHeight() + baseY + 10.0f + 26.0f + 8.0f + 148.0f + 8.0f;
    }

    protected float rowsHeight() {
        float total = 0.0f;
        boolean first = true;
        for (int i = 0; i < this.rows.size(); ++i) {
            float v = ListOverlayBase.clamp01(this.rows.get((int)i).progress);
            if (0.5f <= v) {
                v = 2.0f - (v + v);
                v = 1.0f - v * v * v * 0.5f;
            } else {
                v = v * 4.0f * v * v;
            }
            if (!first) {
                total += v * 4.0f;
            }
            first = false;
            total += v * 26.0f;
        }
        return total;
    }

    public void onShow() {
        boolean hasA = this.headerRowA() != null;
        float band = 36.0f;
        if (!hasA) {
            boolean hasB;
            boolean bl = hasB = this.headerRowB() != null;
            if (!hasB) {
                band = 0.0f;
            }
        }
        this.height = this.headerHeight() + 10.0f + 26.0f + 8.0f + 148.0f + band + 12.0f;
        this.onShowHook();
        this.scroll = 0.0f;
        this.dragAnim.from = 0.0f;
        this.dragAnim.current = 0.0f;
        this.dragAnim.target = 0.0f;
        this.dragAnim.running = false;
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        boolean scrollBar;
        float top;
        float left;
        if (button != 0) {
            return true;
        }
        if (this.onMouseMovedHook()) {
            return true;
        }
        float baseY = this.y;
        float closeY = baseY + 14.0f - 4.0f;
        float closeX = this.x + this.width - 12.0f - 8.0f - 4.0f;
        if (mx >= (double)closeX && mx <= (double)(closeX + 16.0f) && my >= (double)closeY && my <= (double)(closeY + 16.0f)) {
            this.close();
            return true;
        }
        float searchX = (this.width - 303.0f) * 0.5f + this.x;
        float searchY = this.headerHeight() + baseY + 10.0f;
        if (mx >= (double)searchX && mx <= (double)(searchX + 303.0f) && my >= (double)searchY && my <= (double)(searchY + 26.0f)) {
            this.search.mousePressed(mx, my, 0);
            return true;
        }
        if (this.searchFocused) {
            this.searchFocused = false;
            ListOverlayBase.animate(this.searchAnim, 0.0f);
            this.search.reset();
        }
        if (this.hasContent()) {
            left = (this.width - 303.0f) * 0.5f + this.x;
            top = this.listTop(baseY);
            Row a = this.headerRowA();
            if (a != null && mx >= (double)left && mx <= (double)(left + 155.5f) && my >= (double)top && my <= (double)(top + 28.0f)) {
                this.onHeaderRowA();
                this.scroll = 0.0f;
                this.dragAnim.from = 0.0f;
                this.dragAnim.current = 0.0f;
                this.dragAnim.target = 0.0f;
                this.dragAnim.running = false;
                return true;
            }
            float rowBLeft = left + 155.5f;
            float rowBBottom = top + 28.0f;
            Row b = this.headerRowB();
            if (b != null && mx >= (double)rowBLeft && mx <= (double)(rowBLeft + 155.5f) && my >= (double)top && my <= (double)rowBBottom) {
                this.onHeaderRowB();
                return true;
            }
        }
        left = (this.width - 303.0f) * 0.5f + this.x;
        top = this.bodyTop(baseY);
        float contentHeight = this.rowsHeight();
        float right = left + 303.0f;
        boolean bl = scrollBar = 140.0f < contentHeight;
        if (scrollBar) {
            float barX = right - 4.0f - 6.0f;
            float knob = this.rowsHeight() - 140.0f;
            if (knob <= 0.0f) {
                knob = 0.0f;
            }
            float barY = 0.0f;
            if (0.0f < knob) {
                barY = (top + 148.0f - 4.0f - (top + 4.0f) - 40.0f) * (this.dragAnim.current / knob);
            }
            barY = barY + top + 4.0f;
            if (mx >= (double)barX && mx <= (double)(barX + 6.0f) && my >= (double)barY && my <= (double)(barY + 40.0f)) {
                this.dragging = true;
                this.dragGrab = (float)my - barY;
                return true;
            }
        }
        if (mx >= (double)left && mx <= (double)right && my >= (double)top && my <= (double)(top + 148.0f)) {
            float rowLeft = left + 4.0f;
            float rowRight = right - 4.0f;
            if (scrollBar) {
                rowRight = rowRight - 6.0f - 4.0f;
            }
            for (int i = 0; i < this.rows.size(); ++i) {
                Row row = this.rows.get(i);
                float reveal = ListOverlayBase.rowReveal(row);
                if (!(0.001f < reveal) || !(mx >= (double)rowLeft) || !(mx <= (double)rowRight) || !(my >= (double)row.y) || !(my <= (double)(row.y + 26.0f))) continue;
                return this.onRowClicked(row, mx, my, rowLeft, row.y, rowRight - rowLeft);
            }
        }
        return true;
    }

    protected static float rowReveal(Row row) {
        return row.progress;
    }

    @Override
    public boolean mouseReleased(double mx, double my, int button) {
        if (!this.onMouseReleasedHook()) {
            if (!this.dragging || button != 0) {
                return false;
            }
            this.dragging = false;
        }
        return true;
    }

    public boolean onMouseReleasedHook() {
        return false;
    }

    @Override
    public boolean mouseMoved(double mx, double my, double delta) {
        float value;
        if (this.onMouseMovedHook()) {
            return true;
        }
        if (!this.dragging || (int)delta != 0) {
            return false;
        }
        float top = this.listTop(this.y);
        float firstTop = top + 4.0f;
        float max = this.rowsHeight() - 140.0f;
        if (max <= 0.0f) {
            max = 0.0f;
        }
        if ((value = ((float)my - this.dragGrab - firstTop) / (top + 148.0f - 4.0f - firstTop - 40.0f) * max) < 0.0f) {
            value = 0.0f;
        }
        if (max < value) {
            value = max;
        }
        this.scroll = value;
        return true;
    }

    @Override
    public boolean onKeyPressed(int keyCode, int modifiers) {
        if (this.onKeyHook(keyCode, modifiers)) {
            return false;
        }
        if (!this.searchFocused) {
            return false;
        }
        ListOverlayBase.searchFieldKey(this.search, keyCode);
        return true;
    }

    public boolean onKeyHook(int keyCode, int modifiers) {
        return false;
    }

    protected static void searchFieldKey(SearchField field, int keyCode) {
    }

    @Override
    public boolean mouseScrolled(double mx, double my, double amount) {
        if (this.onScrollHook()) {
            return true;
        }
        float left = (this.width - 311.0f) * 0.5f + this.x;
        float top = this.listTop(this.y);
        if ((double)left <= mx && mx <= (double)(left + 311.0f) && (double)top <= my && my <= (double)(top + 148.0f)) {
            float value;
            float max = this.rowsHeight() - 140.0f;
            if (max <= 0.0f) {
                max = 0.0f;
            }
            if ((value = this.scroll - (float)amount * 48.0f) < 0.0f) {
                value = 0.0f;
            }
            if (max < value) {
                value = max;
            }
            this.scroll = value;
            ListOverlayBase.animate(this.dragAnim, value);
        }
        return true;
    }

    public boolean onScrollHook() {
        return false;
    }

    protected static void searchFieldScroll(SearchField field, double amount) {
    }

    @Override
    public boolean charTyped(char ch) {
        if (this.charTypedHook(ch)) {
            return false;
        }
        if (!this.searchFocused) {
            return false;
        }
        ListOverlayBase.searchFieldType(this.search, ch);
        return true;
    }

    public boolean charTypedHook(char ch) {
        return false;
    }

    protected static void searchFieldType(SearchField field, char ch) {
    }

    @Override
    public void renderBody(Object target, float rx, float ry, float parentAlpha) {
        float weight = ListOverlayBase.clamp01(parentAlpha);
        float top = (1.0f - weight) * 16.0f + this.y;
        Draw.panel(target, this.x, top, this.width, this.height, 12.0f, 12.0f, 12.0f, 12.0f, 40.0f, weight);
        Draw.text(target, this.x + 8.0f, top + 8.0f, this.title(), 12.0f, 12.0f, weight);
        String header = this.description();
        Draw.text(target, this.x + 8.0f, top + 14.4f, header, 14.4f, 12.0f, weight);
        Draw.row(target, this.x, (this.width - 303.0f) * 0.5f + this.x, top + 40.0f, 303.0f, 14.4f);
        this.search.render(target, this.x + 8.0f, top + 8.0f, weight);
        float left = (this.width - 303.0f) * 0.5f + this.x;
        float bodyY = this.bodyTop(top);
        Draw.preview(target, left, bodyY, 303.0f, 30.0f, weight);
        Draw.listHeader(target, left, top + 311.0f, this.width, 26.0f, 12.0f, weight);
        Row a = this.headerRowA();
        Row b = this.headerRowB();
        if (a == null && b == null) {
            return;
        }
        this.renderHeaderRows(target, left, bodyY, weight);
        float footer = left + 303.0f - 12.0f - 40.0f - 4.0f;
        if (footer <= rx + 0.0f && rx <= footer + 12.0f && top + 8.0f <= ry && ry <= top + 8.0f + 12.0f) {
            handCursor = true;
        }
        this.onRenderHook(target, left, bodyY, rx, ry, weight);
    }

    public void renderHeaderRows(Object target, float left, float top, float weight) {
    }

    public void onRenderHook(Object target, float left, float top, float rx, float ry, float weight) {
    }

    public void refresh() {
        ListOverlayBase.cleanupTail(this.rows);
    }

    protected static void cleanupTail(List<Row> rows) {
    }

    public static final class SearchField {
        public static final long VTABLE_RVA = 12640736L;
        public static final int OFF_X = 8;
        public static final int OFF_Y = 12;
        public static final int OFF_WIDTH = 16;
        public static final int OFF_HEIGHT = 20;
        public static final int OFF_VALUE = 48;
        public static final int OFF_FOCUSED = 96;
        public float x = 0.0f;
        public float y = 0.0f;
        public float width;
        public float height;
        public String value = "";
        public boolean focused;

        public SearchField(float width, float height, String value, float pad, float gap) {
            this.width = width;
            this.height = height;
            this.value = value == null ? "" : value;
            this.focused = false;
        }

        public void render(Object target, float rx, float ry, float alpha) {
        }

        public void mousePressed(double mx, double my, int button) {
        }

        public void reset() {
        }
    }

    public static class Row {
        public static final int OFF_NAME = 8;
        public static final int OFF_PROGRESS = 40;
        public static final int OFF_Y = 48;
        public String name = "";
        public float progress;
        public float y;

        public Row() {
        }

        public Row(String name) {
            this.name = name == null ? "" : name;
        }
    }

    public static final class Draw {
        public static void panel(Object target, float x, float y, float width, float height, float a, float b, float c, float d, float e, float alpha) {
        }

        public static void text(Object target, float x, float y, String text, float size, float width, float alpha) {
        }

        public static void row(Object target, float x, float y, float top, float width, float alpha) {
        }

        public static void preview(Object target, float x, float y, float width, float height, float alpha) {
        }

        public static void listHeader(Object target, float x, float y, float width, float height, float size, float alpha) {
        }
    }
}

