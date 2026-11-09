/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.AbstractOverlay;
import client.gui.Screen;

public class StatusMenu
extends AbstractOverlay {
    public static final long VTABLE_RVA = 12614192L;
    public static final long RVA_CTOR = 2735201396896L;
    public static final long RVA_DTOR = 2735201412048L;
    public static final long RVA_DTOR_BASE = 2735200808816L;
    public static final long RVA_REBUILD = 2735201412112L;
    public static final long RVA_HIT_ROW = 2735201412816L;
    public static final long RVA_OVERLAY_CONST = 2735201404944L;
    public static final long RVA_RENDER_BODY = 2735201412960L;
    public static final long RVA_ON_MOUSE_CLICKED = 2735201414688L;
    public static final long RVA_ANIM_HIGHLIGHT = 2735200260240L;
    public static final long RVA_ANIM_SLIDE = 2735200778960L;
    public static final int OFF_CALLBACK = 264;
    public static final int OFF_ROWS = 272;
    public static final int OFF_SELECTED = 560;
    public static final int OFF_SELECT_ANIM_Y = 568;
    public static final int OFF_SELECT_ANIM_HEIGHT = 608;
    public static final int OFF_REVEAL_Y = 648;
    public static final int ROW_STRIDE = 72;
    public static final int ROW_COUNT = 4;
    public static final int ROW_ID = 0;
    public static final int ROW_DESCRIPTION = 8;
    public static final int ROW_DESCRIPTION_LENGTH = 16;
    public static final int ROW_HIGHLIGHT = 24;
    public static final int ROW_LAYOUT_Y = 64;
    public static final int ROW_HEIGHT = 68;
    public static final int STATUS_OFFLINE = 0;
    public static final int STATUS_ONLINE = 1;
    public static final int STATUS_IDLE = 2;
    public static final int STATUS_DO_NOT_DISTURB = 3;
    public static final int SOUND_SELECT = 14;
    public static final float OVERLAY_METRIC = 20.0f;
    public static final float FULL_ALPHA = 1.0f;
    public static final float HALF = 0.5f;
    public static final float HOVER_ALPHA = 0.8f;
    public static final float IDLE_ALPHA = 0.5f;
    public static final float ALPHA_EPSILON = 0.001f;
    public static final float NEAR_ONE = 0.999f;
    public static final float ALPHA_SHIFT = 16.0f;
    public static final float EMPTY = 0.0f;
    public static final float ROW_ANIM_DURATION = 0.15f;
    public static final float SLIDE_ANIM_DURATION = 0.22f;
    public static final float LABEL_SIZE = 12.0f;
    public static final float DESCRIPTION_SIZE = 10.0f;
    public static final float LABEL_GAP = 8.0f;
    public static final float ROW_HEIGHT_SCALE = 16.0f;
    public static final float ROW_HEIGHT_BASE = 10.0f;
    public static final float ROW_GAP = 2.0f;
    public static final float ROW_TOP = 4.0f;
    public static final float WIDTH_PAD_LABEL = 16.0f;
    public static final float WIDTH_PAD_EDGE = 8.0f;
    public static final float PANEL_PAD = 8.0f;
    public static final float INDICATOR_INSET = 4.0f;
    public static final float INDICATOR_MAX_RADIUS = 16.0f;
    public static final float DOT_SIZE = 4.0f;
    public static final float DOT_RADIUS = 2.0f;
    public static final float DOT_OFFSET = 5.0f;
    public static final float DOT_GAP = 6.0f;
    public static final float LABEL_OFFSET = 2.0f;
    public static final float TEXT_PAD = 4.0f;
    public static final float DESCRIPTION_OFFSET = 16.0f;
    public static final float DESCRIPTION_GAP = 3.0f;
    public static final float DESCRIPTION_ALPHA = 0.5f;
    public static final int COLOR_ONLINE = -13919642;
    public static final int COLOR_IDLE = -17896;
    public static final int COLOR_DO_NOT_DISTURB = -2276315;
    public static final int COLOR_OFFLINE = -8158333;
    public static final String LABEL_ONLINE = "\u041e\u043d\u043b\u0438\u043d\u0435";
    public static final String LABEL_IDLE = "\u0418\u0434\u043b\u0435";
    public static final String LABEL_DO_NOT_DISTURB = "\u0414\u043e \u043d\u043e\u0442 \u0434\u0438\u0437\u0442\u0443\u0440\u0431";
    public static final String LABEL_OFFLINE = "\u041e\u0444\u0444\u043b\u0438\u043d\u0435";
    public static final String DESCRIPTION_DO_NOT_DISTURB = "\u041f\u0440\u0438\u0433\u043b\u0430\u0448\u0435\u043d\u0438\u044f \u0432 \u043f\u0430\u0442\u0438 \u0434\u043e \u0442\u0435\u0431\u044f \u043d\u0435 \u0434\u043e\u0439\u0434\u0443\u0442";
    public static final String DESCRIPTION_OFFLINE = "\u0414\u043b\u044f \u0432\u0441\u0435\u0445 \u0442\u044b \u0431\u0443\u0434\u0435\u0448\u044c \u043d\u0435 \u0432 \u0441\u0435\u0442\u0438";
    protected StatusListener callback = null;
    protected final Row[] rows = new Row[4];
    protected int selectedStatus;
    protected final AbstractOverlay.Animator selectYAnim = new AbstractOverlay.Animator();
    protected final AbstractOverlay.Animator selectHeightAnim = new AbstractOverlay.Animator();
    protected float revealY;

    public StatusMenu() {
        this.rows[0] = new Row();
        this.rows[0].id = 1;
        this.rows[0].description = "";
        StatusMenu.resetAnimator(this.rows[0].highlight, 0.0f, 0.15f, 0);
        this.rows[0].layoutY = 0.0f;
        this.rows[0].height = 0.0f;
        this.rows[1] = new Row();
        this.rows[1].id = 2;
        this.rows[1].description = "";
        StatusMenu.resetAnimator(this.rows[1].highlight, 0.0f, 0.15f, 0);
        this.rows[1].layoutY = 0.0f;
        this.rows[1].height = 0.0f;
        this.rows[2] = new Row();
        this.rows[2].id = 3;
        this.rows[2].description = DESCRIPTION_DO_NOT_DISTURB;
        StatusMenu.resetAnimator(this.rows[2].highlight, 0.0f, 0.15f, 0);
        this.rows[2].layoutY = 0.0f;
        this.rows[2].height = 0.0f;
        this.rows[3] = new Row();
        this.rows[3].id = 0;
        this.rows[3].description = DESCRIPTION_OFFLINE;
        StatusMenu.resetAnimator(this.rows[3].highlight, 0.0f, 0.15f, 0);
        this.rows[3].layoutY = 0.0f;
        this.rows[3].height = 0.0f;
        this.selectedStatus = 1;
        StatusMenu.resetAnimator(this.selectYAnim, 0.0f, 0.22f, 2);
        StatusMenu.resetAnimator(this.selectHeightAnim, 0.0f, 0.22f, 2);
        this.revealY = 0.0f;
        this.rebuild();
    }

    @Override
    public float overlayConst() {
        return 20.0f;
    }

    public void rebuild() {
        float labelSize = 12.0f;
        float descriptionSize = 10.0f;
        float labelScale = 16.0f;
        float labelGap = 8.0f;
        float rowGap = 2.0f;
        float full = 1.0f;
        float accumulated = 4.0f;
        float widest = 0.0f;
        float trailing = 4.0f;
        for (Row row : this.rows) {
            float height;
            String label = StatusMenu.labelFor(row.id);
            float labelWidth = OverlayDraw.measureText(0, label, labelSize);
            float descriptionWidth = row.description.length() == 0 ? 0.0f : OverlayDraw.measureText(1, row.description, descriptionSize);
            widest = StatusMenu.maxOf(widest, labelWidth + labelGap, descriptionWidth);
            row.layoutY = accumulated;
            row.height = height = (row.description.length() == 0 ? full : labelWidth) * labelScale + 10.0f;
            accumulated = accumulated + height + rowGap;
        }
        accumulated = accumulated - rowGap + trailing;
        this.width = widest + 16.0f + 8.0f;
        this.height = accumulated;
    }

    @Override
    public void renderBody(Object target, float rx, float ry, float parentAlpha) {
        float offsetY;
        this.rebuild();
        float half = 0.5f;
        float clamped = StatusMenu.clamp01(parentAlpha);
        this.revealY = offsetY = (1.0f - clamped) * 16.0f + this.y;
        Object rect = OverlayDraw.makeRect(target, parentAlpha, this.width * half + this.x, this.height * half + offsetY);
        OverlayDraw.drawPanelTinted(rect, this.x, this.revealY, this.width, this.height, 20.0f, parentAlpha);
        for (Row row : this.rows) {
            float rowHeight;
            if (row.id != this.selectedStatus) continue;
            float layoutY = row.layoutY;
            if (this.selectYAnim.target != layoutY) {
                StatusMenu.animate(this.selectYAnim, layoutY);
            }
            if (this.selectHeightAnim.target == (rowHeight = row.height)) continue;
            StatusMenu.animate(this.selectHeightAnim, rowHeight);
        }
        float selectedHeight = StatusMenu.advance(this.selectHeightAnim, this.now());
        float innerWidth = this.width - 8.0f;
        float selectedY = StatusMenu.advance(this.selectYAnim, this.now());
        float barX = this.x + 4.0f;
        int accent = OverlayDraw.accentColor();
        Row hoveredRow = null;
        float radius = selectedHeight * half;
        if (16.0f <= radius) {
            radius = 16.0f;
        }
        OverlayDraw.drawPanelRect(rect, barX, selectedY + this.revealY, innerWidth, selectedHeight, radius, accent, 0, 0, 0, 20.0f, half, parentAlpha);
        if (!this.closed && (hoveredRow = this.hitRow(rx, ry)) != null && hoveredRow.id != this.selectedStatus) {
            Screen.hoveredWidget = 1;
        }
        float rowLeft = this.x + 4.0f + 8.0f;
        for (Row row : this.rows) {
            float rowTarget = 1.0f;
            if (row.id != this.selectedStatus) {
                rowTarget = 0.5f;
                if (row == hoveredRow) {
                    rowTarget = 0.8f;
                }
            }
            if (row.highlight.target != rowTarget) {
                StatusMenu.animate(row.highlight, rowTarget);
            }
            float rowAlpha = StatusMenu.advance(row.highlight, this.now()) * parentAlpha;
            float dotTop = row.layoutY + this.revealY + 5.0f;
            OverlayDraw.drawPanel(rect, rowLeft, dotTop + 6.0f, 4.0f, 4.0f, 2.0f, 2.0f, 2.0f, 2.0f, StatusMenu.statusColor(row.id), 0, 0, 0, 0, 0, 0, rowAlpha, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
            OverlayDraw.drawText(5, rect, StatusMenu.labelFor(row.id), rowLeft + 4.0f + 4.0f, dotTop + 2.0f, 12.0f, OverlayDraw.themeColor(24), rowAlpha);
            if (row.description.length() == 0) continue;
            OverlayDraw.drawText(2, rect, row.description, rowLeft, dotTop + 16.0f + 3.0f, 10.0f, OverlayDraw.themeColor(24), rowAlpha * 0.5f);
        }
    }

    public Row hitRow(double mx, double my) {
        float left = this.x + 4.0f;
        for (Row row : this.rows) {
            float top = row.layoutY + this.revealY;
            if (!((double)left <= mx) || !(mx <= (double)(this.width - 8.0f + left)) || !((double)top <= my) || !(my <= (double)(top + row.height))) continue;
            return row;
        }
        return null;
    }

    @Override
    public boolean onMouseClicked(double mx, double my, int button) {
        Row row;
        if (button == 0 && (row = this.hitRow(mx, my)) != null) {
            OverlayDraw.playSound(14);
            int id = row.id;
            if (id != this.selectedStatus) {
                StatusListener listener = this.callback;
                this.selectedStatus = id;
                if (listener != null) {
                    listener.onStatusSelected(id);
                }
            }
            this.close();
        }
        return true;
    }

    @Override
    public void dispose() {
        this.callback = null;
        super.dispose();
    }

    public int selectedStatus() {
        return this.selectedStatus;
    }

    public void setSelectedStatus(int status) {
        this.selectedStatus = status;
    }

    public StatusListener listener() {
        return this.callback;
    }

    private static float maxOf(float a, float b, float c) {
        return Math.max(a, Math.max(b, c));
    }

    public static int statusColor(int status) {
        if (status == 1) {
            return -13919642;
        }
        if (status == 2) {
            return -17896;
        }
        if (status == 3) {
            return -2276315;
        }
        return -8158333;
    }

    public static String labelFor(int status) {
        if (status == 1) {
            return LABEL_ONLINE;
        }
        if (status == 2) {
            return LABEL_IDLE;
        }
        if (status == 3) {
            return LABEL_DO_NOT_DISTURB;
        }
        return LABEL_OFFLINE;
    }

    public static final class Row {
        public static final int OFF_ID = 0;
        public static final int OFF_DESCRIPTION = 8;
        public static final int OFF_DESCRIPTION_LENGTH = 16;
        public static final int OFF_HIGHLIGHT = 24;
        public static final int OFF_LAYOUT_Y = 64;
        public static final int OFF_HEIGHT = 68;
        public int id;
        public String description = "";
        public final AbstractOverlay.Animator highlight = new AbstractOverlay.Animator();
        public float layoutY;
        public float height;
    }

    public static interface StatusListener {
        public void onStatusSelected(int var1);
    }

    private static final class OverlayDraw {
        public static final int STYLE_LABEL = 0;
        public static final int STYLE_DESCRIPTION = 1;
        public static final int THEME_OFFSET_00 = 0;
        public static final int THEME_OFFSET_04 = 4;
        public static final int THEME_OFFSET_08 = 8;
        public static final int THEME_OFFSET_0C = 12;
        public static final int THEME_OFFSET_10 = 16;
        public static final int THEME_OFFSET_14 = 20;
        public static final int THEME_OFFSET_18 = 24;
        public static boolean THEME_GATE_A = false;
        public static boolean THEME_GATE_B = false;
        public static boolean THEME_GATE_C = false;
        public static boolean THEME_GATE_D = false;
        public static final float ACCENT_TINT_MAIN = 0.9f;
        public static final float ACCENT_TINT_ALT = 0.55f;
        public static final float PANEL_TINT = 0.08f;

        private OverlayDraw() {
        }

        public static void drawPanel(Object target, float x, float y, float w, float h, float radiusA, float radiusB, float radiusC, float radiusD, int color, int arg11, int arg12, int arg13, int arg14, int arg15, int arg16, float alpha, float arg18, float arg19, float arg20, float arg21, float arg22, float arg23, float arg24, float arg25, float arg26, float arg27, float arg28, float arg29, float arg30) {
        }

        public static void drawPanelRect(Object target, float x, float y, float w, float h, float radius, int fill, int arg8, int arg9, int arg10, float arg11, float arg12, float alpha) {
        }

        public static void drawPanelTinted(Object target, float x, float y, float w, float h, float radius, float alpha) {
        }

        public static void drawText(int align, Object target, String text, float x, float y, float size, int color, float alpha) {
        }

        public static void drawIcon(Object target, int icon, float x, float y, float w, float h, int color, float alpha) {
        }

        public static void drawIconInBox(Object target, int icon, float x, float y, float boxSize, int color, float alpha) {
        }

        public static Object makeRect(Object target, float alpha, float centerX, float centerY) {
            return null;
        }

        public static float measureText(int style, String text, float size) {
            return 0.0f;
        }

        public static int themeColor(int offset) {
            return 0;
        }

        public static int accentColor() {
            if (THEME_GATE_A && THEME_GATE_B && THEME_GATE_C && !THEME_GATE_D) {
                return OverlayDraw.themeTint(OverlayDraw.themeColor(8), 0.55f);
            }
            return OverlayDraw.themeTint(OverlayDraw.themeColor(0), 0.9f);
        }

        public static int themeTint(int color, float factor) {
            return 0;
        }

        public static void playSound(int id) {
        }
    }
}

