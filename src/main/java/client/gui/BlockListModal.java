/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.ColorModal;
import client.gui.ListOverlayBase;
import java.util.ArrayList;
import java.util.List;

public class BlockListModal
extends ListOverlayBase {
    public static final long VTABLE_RVA = 12607576L;
    public static final long RVA_CTOR = 1562688L;
    public static final long RVA_DTOR = 1568000L;
    public static final long RVA_DELETING_DTOR = 1567744L;
    public static final long RVA_MOUSE_BODY = 1576448L;
    public static final long RVA_COLOR_MODAL_HIT = 1576336L;
    public static final long RVA_TITLE = 1568448L;
    public static final long RVA_DESCRIPTION = 1568480L;
    public static final long RVA_FILTER_LABEL = 1568512L;
    public static final long RVA_FILTER_LABEL_ALT = 1568576L;
    public static final long RVA_FILTER_FLAG = 1568608L;
    public static final long RVA_TOGGLE_FILTER = 1568624L;
    public static final long RVA_REBUILD_ROWS = 1568656L;
    public static final long RVA_ROW_DATA = 1571712L;
    public static final long RVA_CREATE_ROW = 1571728L;
    public static final long RVA_RENDER_ROW = 1573232L;
    public static final long RVA_SYNC_ROWS = 1569808L;
    public static final long RVA_ADD_ROW = 1570560L;
    public static final long RVA_ROW_CTOR = 1567296L;
    public static final long RVA_ROW_MATCH = 1571872L;
    public static final long RVA_ROW_COLOR = 1572048L;
    public static final long RVA_ROW_LABEL = 1569552L;
    public static final long RVA_SORT_ROWS = 1577312L;
    public static final long RVA_INPUT_CTOR = 374960L;
    public static final long RVA_INPUT_RENDER = 1643792L;
    public static final long RVA_INPUT_COLOR = 1644240L;
    public static final long RVA_DRAW_BG = 3483568L;
    public static final long RVA_DRAW_TEXT = 3494400L;
    public static final long RVA_DRAW_ROW = 3491616L;
    public static final long RVA_DRAW_LIST = 3497136L;
    public static final long RVA_MEASURE = 1773456L;
    public static final int OFF_BLOCK_LIST = 960;
    public static final int OFF_ROW_DATA = 968;
    public static final int OFF_ROW_DATA_END = 976;
    public static final int OFF_ROW_DATA_CAP = 984;
    public static final int OFF_SHOW_ONLY_ENABLED = 992;
    public static final int OFF_INPUT = 1000;
    public static final int OFF_COLOR_MODAL = 1248;
    public static final int OFF_LAST_QUERY = 2656;
    public static final int LOOKUP_STRING = 0;
    public static final int LOOKUP_STRING_SIZE = 24;
    public static final int LOOKUP_STRING_CAP = 32;
    public static final int LOOKUP_FLAG = 32;
    public static final int SELECTION_VECTOR = 280;
    public static final int SELECTION_VECTOR_END = 288;
    public static final int ENTRY_STRIDE = 40;
    public static final int ENTRY_FLAG = 32;
    public static final float COLOR_MODAL_WIDTH = 293.0f;
    public static final float COLOR_MODAL_HEIGHT = 383.0f;
    public static final float ROW_TEXT_INSET = 6.0f;
    public static final float ROW_TEXT_GAP = 5.0f;
    public static final float ROW_TEXT_SIZE = 12.0f;
    public static final float ROW_TEXT_OFFSET = 8.0f;
    public static final float ROW_TEXT_PAD = 26.0f;
    public static final float ROW_TEXT_WIDTH = 32.0f;
    public static final float ROW_GLYPH_SIZE = 16.0f;
    public static final float ROW_GLYPH_INSET = 6.0f;
    public static final float ROW_GLYPH_OFFSET = 56.0f;
    public static final float ROW_MIN_WIDTH = 30.0f;
    public static final float ROW_MIN_HEIGHT = 4.0f;
    public static final float ROW_ALPHA = 1.0f;
    public static final float ROW_ANIM_DURATION = 0.22f;
    public static final float ROW_ACCESSORY_HEIGHT = 22.0f;
    public static final float ROW_CORNER = 4.0f;
    public static final float ROW_BODY_GAP = 10.0f;
    public static final float ROW_BODY_HEIGHT = 26.0f;
    public static final float MIN_ROW_WIDTH = 30.0f;
    public static final float ZERO = 0.0f;
    public static final float ONE = 1.0f;
    public static final float HALF = 0.5f;
    public static final float EPSILON = 0.001f;
    public static final String TITLE = "\u041e\u0442\u043e\u0431\u0440\u0430\u0436\u0430\u0435\u043c\u044b\u0435 \u0431\u043b\u043e\u043a\u0438";
    public static final String DESCRIPTION = "\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u0442\u0435 \u043e\u0442\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u0435 \u0431\u043b\u043e\u043a\u043e\u0432 \u0432 \u043f\u043e\u0434\u0441\u0432\u0435\u0442\u043a\u0435 \u0440\u0443\u0434\u044b \u0438 \u043a\u043e\u043d\u0442\u0435\u0439\u043d\u0435\u0440\u043e\u0432.";
    public static final String FILTER_ONLY_ENABLED = "\u0422\u043e\u043b\u044c\u043a\u043e \u0432\u043a\u043b.";
    public static final String FILTER_SHOW_ALL = "\u041f\u043e\u043a\u0430\u0437\u0430\u0442\u044c \u0432\u0441\u0435";
    public static final String DISABLE_ALL = "\u0412\u044b\u043a\u043b\u044e\u0447\u0438\u0442\u044c \u0432\u0441\u0435";
    public static final String EDIT_PLACEHOLDER = "\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u0431\u043b\u043e\u043a\u0430";
    public static final String EDIT_ID = "__blocklist_edit";
    protected BlockList blockList;
    protected final List<ListOverlayBase.Row> rows;
    protected boolean showOnlyEnabled;
    protected final EditField editField;
    protected final ColorModal colorModal;
    protected String lastQuery;

    public BlockListModal(BlockList blockList) {
        super(EDIT_PLACEHOLDER);
        this.rows = ((ListOverlayBase)this).rows;
        this.editField = new EditField(EDIT_ID, EDIT_PLACEHOLDER);
        this.colorModal = new ColorModal(null, null);
        this.lastQuery = "";
        this.blockList = blockList;
        this.rows.clear();
        this.showOnlyEnabled = false;
        this.lastQuery = "";
        this.colorModal.closeOnOutsideClick = false;
        this.editField.setChangeHandler(this::onQueryChanged);
    }

    protected void onQueryChanged(String value) {
    }

    @Override
    public String title() {
        return TITLE;
    }

    @Override
    public String description() {
        return DESCRIPTION;
    }

    @Override
    public String filterLabel() {
        return this.showOnlyEnabled ? FILTER_SHOW_ALL : FILTER_ONLY_ENABLED;
    }

    @Override
    public String filterLabelAlt() {
        return DISABLE_ALL;
    }

    @Override
    public boolean filterFlag() {
        return this.showOnlyEnabled;
    }

    @Override
    public void toggleFilter() {
        this.showOnlyEnabled = !this.showOnlyEnabled;
        this.syncRows();
    }

    @Override
    public List<ListOverlayBase.Row> rowList() {
        ArrayList<ListOverlayBase.Row> out = new ArrayList<ListOverlayBase.Row>();
        for (int i = 0; i < this.rows.size(); ++i) {
            out.add(this.rows.get(i));
        }
        return out;
    }

    @Override
    public ListOverlayBase.Row headerRowA() {
        if (this.blockList == null) {
            return null;
        }
        boolean enabled = false;
        for (int i = 0; i < this.blockList.entries.size(); ++i) {
            if (!this.blockList.entries.get((int)i).enabled) continue;
            enabled = true;
            break;
        }
        return new BlockRow(this.blockList.name, enabled);
    }

    @Override
    public ListOverlayBase.Row headerRowB() {
        return null;
    }

    @Override
    public boolean onRowClicked(ListOverlayBase.Row row, double mx, double my, float left, float top, float width) {
        boolean enabled;
        BlockRow blockRow = (BlockRow)row;
        blockRow.enabled = enabled = !blockRow.enabled;
        BlockListModal.applyEntryEnabled(this.blockList, blockRow.name, enabled);
        this.syncRows();
        return true;
    }

    private static void applyEntryEnabled(BlockList list, String name, boolean enabled) {
        if (list == null) {
            return;
        }
        for (int i = 0; i < list.entries.size(); ++i) {
            BlockEntry entry = list.entries.get(i);
            if (!entry.name.equalsIgnoreCase(name)) continue;
            entry.enabled = enabled;
            list.notifyChanged();
            return;
        }
    }

    @Override
    public void rebuildRows() {
        this.rows.clear();
        if (this.blockList == null) {
            return;
        }
        if (this.blockList.selection.isEmpty()) {
            for (int i = 0; i < this.blockList.entries.size(); ++i) {
                BlockEntry entry = this.blockList.entries.get(i);
                this.addRow(entry.name, entry.enabled);
            }
        } else {
            for (int i = 0; i < this.blockList.selection.size(); ++i) {
                String name = this.blockList.selection.get(i);
                boolean enabled = false;
                for (int j = 0; j < this.blockList.entries.size(); ++j) {
                    BlockEntry entry = this.blockList.entries.get(j);
                    if (!entry.name.equalsIgnoreCase(name)) continue;
                    enabled = entry.enabled;
                    break;
                }
                this.addRow(name, enabled);
            }
        }
        BlockListModal.sortRows(this.rows);
    }

    protected void addRow(String name, boolean enabled) {
        String lower;
        if (this.showOnlyEnabled && !enabled) {
            return;
        }
        boolean skip = false;
        if (!(this.blockList == null || this.blockList.query.isEmpty() || (lower = name.toLowerCase()).length() >= this.blockList.query.length() && lower.contains(this.blockList.query.toLowerCase()))) {
            skip = true;
        }
        if (!skip) {
            this.rows.add(new BlockRow(name, enabled));
        }
    }

    protected static void sortRows(List<ListOverlayBase.Row> rows) {
    }

    @Override
    public void syncRows() {
        this.lastQuery = this.editField.text;
        this.rebuildRows();
    }

    public BlockRow createRow(String name, boolean enabled) {
        return new BlockRow(name, enabled);
    }

    public boolean colorModalHit(double mx, double my) {
        if (!(0.001f < this.colorModal.alphaCurrent()) && !(0.001f < this.colorModal.alphaTarget)) {
            return false;
        }
        return mx >= (double)this.colorModal.getX() && mx <= (double)(this.colorModal.getX() + 293.0f) && my >= (double)this.colorModal.getY() && my <= (double)(this.colorModal.getY() + 383.0f);
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (!this.colorModalHit(mx, my)) {
            return super.mouseClicked(mx, my, button);
        }
        if (this.closed) {
            return true;
        }
        this.syncChildPosition();
        return this.listMouseClicked(mx, my, button);
    }

    protected boolean listMouseClicked(double mx, double my, int button) {
        return super.mouseClicked(mx, my, button);
    }

    @Override
    public void renderBody(Object target, float rx, float ry, float parentAlpha) {
        super.renderBody(target, rx, ry, parentAlpha);
        float weight = BlockListModal.clamp01(parentAlpha);
        float top = (1.0f - weight) * 16.0f + this.y;
        this.editField.render(target, this.x, top, weight);
        this.blockRowListRender(target, rx, ry, parentAlpha);
        if (0.001f < this.colorModal.alphaCurrent() || 0.001f < this.colorModal.alphaTarget) {
            this.colorModal.renderOverlay(target, rx, ry, parentAlpha);
        }
    }

    protected void blockRowListRender(Object target, float rx, float ry, float parentAlpha) {
    }

    @Override
    public void onShowHook() {
        this.rebuildRows();
    }

    public boolean showsOnlyEnabled() {
        return this.showOnlyEnabled;
    }

    public BlockList blockList() {
        return this.blockList;
    }

    public ColorModal colorModal() {
        return this.colorModal;
    }

    public List<ListOverlayBase.Row> rows() {
        return this.rows;
    }

    public static final class EditField {
        public static final long RVA_CTOR = 374960L;
        public static final long RVA_RENDER = 1643792L;
        public static final int OFF_TEXT = 48;
        public static final int OFF_FOCUSED = 96;
        public String text = "";
        public String id;
        public String placeholder;
        public boolean focused;
        public ChangeHandler handler;

        public EditField(String id, String placeholder) {
            this.id = id == null ? "" : id;
            this.placeholder = placeholder == null ? "" : placeholder;
        }

        public void setChangeHandler(ChangeHandler handler) {
            this.handler = handler;
        }

        public void render(Object target, float x, float y, float alpha) {
        }
    }

    public static final class BlockList {
        public static final int OFF_NAME = 224;
        public static final int OFF_ENTRIES = 232;
        public static final int OFF_ENTRIES_END = 240;
        public static final int OFF_QUERY_SIZE = 16;
        public static final int OFF_SELECTION = 280;
        public static final int OFF_SELECTION_END = 288;
        public String name = "";
        public String query = "";
        public final List<BlockEntry> entries = new ArrayList<BlockEntry>();
        public final List<String> selection = new ArrayList<String>();

        public void notifyChanged() {
        }
    }

    public static interface ChangeHandler {
        public void onChanged(String var1);
    }

    public static final class BlockEntry {
        public String name = "";
        public boolean enabled;

        public BlockEntry() {
        }

        public BlockEntry(String name, boolean enabled) {
            this.name = name == null ? "" : name;
            this.enabled = enabled;
        }
    }

    public static class BlockRow
    extends ListOverlayBase.Row {
        public static final long VTABLE_RVA = 12611304L;
        public static final long RVA_CTOR = 1567296L;
        public static final long RVA_RENDER = 1573232L;
        public static final int OFF_NAME = 8;
        public static final int OFF_FLAG = 32;
        public static final int OFF_ANIM = 64;
        public static final int OFF_MARKED = 328;
        public boolean enabled;

        public BlockRow() {
        }

        public BlockRow(String name, boolean enabled) {
            super(name);
            this.enabled = enabled;
        }
    }
}

