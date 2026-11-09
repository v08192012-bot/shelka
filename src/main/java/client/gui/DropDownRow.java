/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.Setting;
import client.gui.Component;
import java.util.ArrayList;
import java.util.List;

public class DropDownRow
extends Component {
    public static final long VTABLE_RVA = 0xC055C0L;
    public static final long RVA_FACTORY = 2735201206896L;
    public static final long RVA_DELETING_DTOR = 2735201204592L;
    public static final long RVA_LIST_HEIGHT = 2735201200880L;
    public static final long RVA_COLLAPSED_HEIGHT = 2735201200976L;
    public static final long RVA_UPDATE = 2735201201088L;
    public static final long RVA_RENDER = 2735201201136L;
    public static final long RVA_MOUSE_CLICKED = 2735201203456L;
    public static final long RVA_ROW_HEIGHT = 2735201190848L;
    public static final long RVA_SPACING = 2735201190880L;
    public static final long RVA_OPACITY = 2735201190896L;
    public static final long RVA_ACCENT = 2735201190912L;
    public static final long RVA_DRAG = 2735201190864L;
    public static final long RVA_APPEND_ANIM = 2735201217040L;
    public static final long RVA_RESERVE_ANIMS = 2735201215232L;
    public static final long RVA_GLYPH_METRICS = 2735199818160L;
    public static final long RVA_ARROW_DRAW = 2735203174176L;
    public static final long RVA_LABEL_DRAW = 2735200824272L;
    public static final long RVA_ITEM_DRAW = 2735203176960L;
    public static final int SLOT_LIST_HEIGHT = 1;
    public static final int SLOT_COLLAPSED_HEIGHT = 2;
    public static final int SLOT_UPDATE = 3;
    public static final int SLOT_RENDER = 4;
    public static final int SLOT_MOUSE_CLICKED = 5;
    public static final int SLOT_DRAG = 6;
    public static final int SLOT_SPACING = 7;
    public static final int SLOT_OPACITY = 8;
    public static final int SLOT_ACCENT = 9;
    public static final int SLOT_SET_POSITION = 11;
    public static final int SLOT_COMMIT = 15;
    public static final int OFF_OWNER = 8;
    public static final int OFF_SETTING = 16;
    public static final int OFF_ROW_HEIGHT = 24;
    public static final int OFF_REVEAL = 28;
    public static final int OFF_ROW_VISIBLE = 32;
    public static final int OFF_ROW_Y = 36;
    public static final int OFF_HANDLER = 40;
    public static final int OFF_ROW_FLAGS = 48;
    public static final int OFF_TAG = 52;
    public static final int OFF_CHOICE = 64;
    public static final int OFF_EXPANDED = 72;
    public static final int OFF_EXPAND_ANIM = 80;
    public static final int OFF_REVEAL_CURRENT = 84;
    public static final int OFF_ITEM_ANIMS = 120;
    public static final float ROW_HEIGHT = 26.0f;
    public static final float ROW_SPACING = 4.0f;
    public static final float ROW_OPACITY = 1.0f;
    public static final float DEFAULT_ROW_HEIGHT = 4.5f;
    public static final float ITEM_STEP = 28.0f;
    public static final float EXPAND_DURATION = 0.32f;
    public static final float ITEM_DURATION = 0.22f;
    public static final float ITEM_SELECTED = 1.0f;
    public static final float ITEM_HOVERED = 0.7f;
    public static final float ITEM_IDLE = 0.4f;
    public static final float DRAG_BIAS = 141.0f;
    public static final float EPSILON = 0.001f;
    public static final float ARROW_SIZE = 6.0f;
    public static final float LABEL_GAP = 8.0f;
    public static final float LIST_INDENT = 30.0f;
    public static final float LIST_TOP_PAD = 2.0f;
    public static final float FONT_SIZE = 12.0f;
    public static final float ARROW_GLYPH_W = 6.5f;
    public static final int SOUND_OPEN = 5;
    public static final int SOUND_CLOSE = 4;
    public static final int SOUND_SELECT = 14;
    public static final int ARROW_GLYPH = 10;
    public static final int LABEL_GLYPH = 2;
    private Object owner;
    private Setting setting;
    private Setting choice;
    private float rowHeight = 4.5f;
    private float reveal;
    private boolean rowVisible;
    private float rowY;
    private int rowFlags;
    private long tag;
    private float boundsX;
    private float boundsY;
    private float boundsWidth;
    private float boundsHeight;
    private boolean expanded;
    private final Component.Anim expandAnim = new Component.Anim(0.0f, 0.32f);
    private final List<Component.Anim> itemAnims = new ArrayList<Component.Anim>();
    private Object handler;

    public DropDownRow() {
    }

    public DropDownRow(Object owner, Setting choice) {
        this.owner = owner;
        this.setting = choice;
        this.choice = choice;
        this.expandAnim.update(this.now());
        this.buildItemAnims();
    }

    public DropDownRow(Object owner, Setting choice, String label) {
        this(owner, choice);
    }

    private void buildItemAnims() {
        this.itemAnims.clear();
        int count = this.optionCount();
        for (int i = 0; i < count; ++i) {
            float value = this.isSelected(i) ? 1.0f : 0.4f;
            Component.Anim anim = new Component.Anim(value, 0.22f);
            anim.update(this.now());
            this.itemAnims.add(anim);
        }
    }

    public int optionCount() {
        if (this.choice == null) {
            return 0;
        }
        List<String> modes = this.choice.getModes();
        return modes == null ? 0 : modes.size();
    }

    public boolean isSelected(int index) {
        if (this.choice == null) {
            return false;
        }
        List<String> modes = this.choice.getModes();
        if (modes == null || index < 0 || index >= modes.size()) {
            return false;
        }
        String current = this.choice.getMode();
        return current != null && current.equals(modes.get(index));
    }

    public String optionLabel(int index) {
        if (this.choice == null) {
            return "";
        }
        List<String> modes = this.choice.getModes();
        if (modes == null || index < 0 || index >= modes.size()) {
            return "";
        }
        String s = modes.get(index);
        return s == null ? "" : s;
    }

    public float listHeight() {
        return (float)this.optionCount() * 28.0f * this.reveal + 26.0f;
    }

    public float collapsedHeight() {
        if (this.expanded) {
            return (float)this.optionCount() * 28.0f + 26.0f;
        }
        return 26.0f;
    }

    public float rowHeight() {
        return 26.0f;
    }

    public float rowSpacing() {
        return 4.0f;
    }

    public float opacity() {
        return 1.0f;
    }

    public int accentColor() {
        return DropDownRow.uiThemeColor(0);
    }

    public float drag(float value) {
        return value + 141.0f;
    }

    public void setReveal(float value) {
        if (this.reveal == value) {
            return;
        }
        this.reveal = value;
    }

    public void markVisible() {
        if (this.rowVisible) {
            return;
        }
        this.rowVisible = true;
        this.rowY = 0.0f;
    }

    public void hideAt(float targetY) {
        if (!this.rowVisible) {
            return;
        }
        this.rowVisible = false;
        this.rowY = targetY <= 0.0f ? 0.0f : targetY;
    }

    public float reveal() {
        return this.reveal;
    }

    public boolean rowVisible() {
        return this.rowVisible;
    }

    public float rowY() {
        return this.rowY;
    }

    public boolean expanded() {
        return this.expanded;
    }

    public Object owner() {
        return this.owner;
    }

    public Setting setting() {
        return this.setting;
    }

    @Override
    public float preferredHeight() {
        return 26.0f;
    }

    @Override
    public float preferredWidth() {
        return 26.0f;
    }

    public void update() {
        this.reveal = this.expandAnim.current;
        this.expandAnim.update(this.now());
        this.reveal = this.expandAnim.current;
    }

    @Override
    public void tick() {
        this.update();
    }

    @Override
    public void render(Object renderer, float px, float py, float alpha) {
        this.render(renderer, px, py, this.width, mouseX, mouseY);
    }

    public void render(Object renderer, float px, float py, float pw, float mx, float my) {
        float[] glyph = DropDownRow.uiIconMetrics(10);
        float arrowX = px + pw - 8.0f - (glyph == null ? 0.0f : glyph[0]);
        float arrowY = (26.0f - (glyph == null ? 0.0f : glyph[1])) * 0.5f + py + 1.0f;
        DropDownRow.uiDrawIcon(renderer, 10, arrowX, arrowY, 6.0f, 6.0f, DropDownRow.uiThemeColor(0), this.alpha);
        float labelX = px + 141.0f;
        String label = this.currentLabel();
        float labelW = arrowX - 8.0f - labelX;
        DropDownRow.drawText(renderer, 2, labelX, py + 4.0f, labelW, 12.0f, DropDownRow.uiThemeColor(0), this.alpha);
        if (mx >= px && mx <= px + pw && my >= py && my <= py + 26.0f) {
            cursorStyle = 1;
        }
        float listY = py + 26.0f;
        if (!(0.001f < this.reveal)) {
            return;
        }
        float listH = (float)this.optionCount() * 28.0f * this.reveal;
        DropDownRow.uiDrawBox(renderer, px, listY, pw, listH, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0.0f, 1.0f, 0.0f, this.alpha, 0);
        float itemX = px + 30.0f;
        float itemW = pw - 30.0f;
        int count = this.optionCount();
        if (count == 0) {
            return;
        }
        float itemY = listY + 2.0f;
        long time = this.now();
        for (int i = 0; i < count; ++i) {
            boolean over;
            float top = (float)i * 28.0f + itemY;
            boolean bl = over = mx >= itemX && mx <= itemX + itemW && my >= top && my <= top + 26.0f;
            if (over && this.expanded) {
                cursorStyle = 1;
            }
            float target = this.isSelected(i) ? 1.0f : (over ? 0.7f : 0.4f);
            Component.Anim anim = this.itemAnims.get(i);
            anim.retarget(target, time);
            anim.update(time);
            DropDownRow.uiDrawBox(renderer, itemX, top, itemW, 26.0f, 4.0f, 4.0f, 4.0f, 4.0f, DropDownRow.uiThemeColor(0), DropDownRow.uiThemeColor(0), 1.0f, 0, 0.0f, 1.0f, 0.0f, this.alpha, 0);
            DropDownRow.drawText(renderer, 2, itemX + 4.0f, top + 4.0f, itemW - 12.0f, 12.0f, DropDownRow.uiThemeColor(0), this.alpha);
        }
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        return this.mouseClicked(mx, my, button, this.x, this.y, this.width);
    }

    public boolean mouseClicked(double mx, double my, int button, float px, float py, float pw) {
        if (button != 0) {
            return false;
        }
        if (mx >= (double)px && mx <= (double)(px + pw) && my >= (double)py && my <= (double)(py + 26.0f)) {
            this.expanded = !this.expanded;
            long time = this.now();
            this.expandAnim.retarget(this.expanded ? 1.0f : 0.0f, time);
            this.expandAnim.update(time);
            DropDownRow.uiSound(this.expanded ? 5 : 4);
            return true;
        }
        int count = this.optionCount();
        if (this.expanded && count != 0) {
            for (int i = 0; i < count; ++i) {
                float top = (float)i * 28.0f + py + 26.0f + 2.0f;
                if (!(mx >= (double)(px + 30.0f)) || !(mx <= (double)(pw - 30.0f + px + 30.0f)) || !(my >= (double)top) || !(my <= (double)(top + 26.0f))) continue;
                DropDownRow.uiSound(14);
                this.selectOption(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean mouseMoved(double mx, double my, double delta) {
        mouseX = (float)mx;
        mouseY = (float)my;
        return false;
    }

    @Override
    public boolean mouseScrolled(double mx, double my, double amount) {
        mouseX = (float)mx;
        mouseY = (float)my;
        return false;
    }

    private void selectOption(int index) {
        if (this.choice == null) {
            return;
        }
        String label = this.optionLabel(index);
        if (label.isEmpty()) {
            return;
        }
        this.choice.setMode(label);
    }

    private String currentLabel() {
        if (this.choice == null) {
            return "";
        }
        String s = this.choice.getMode();
        return s == null ? "" : s;
    }

    private static void drawText(Object renderer, int glyph, float px, float py, float pw, float size, int color, float alpha) {
    }
}

