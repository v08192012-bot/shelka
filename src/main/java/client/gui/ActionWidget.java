/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.Component;

public class ActionWidget
extends Component {
    public static final long VTABLE_RVA = 12602512L;
    public static final long RVA_CTOR = 11716976L;
    public static final long RVA_BASE_CTOR = 11715248L;
    public static final long RVA_DTOR = 11654448L;
    public static final long RVA_DELETING_DTOR = 11654384L;
    public static final long RVA_RENDER = 11654448L;
    public static final long RVA_MOUSE_CLICKED = 11654624L;
    public static final long RVA_ROW_HEIGHT = 11654368L;
    public static final long RVA_ROW_HEIGHT_ALIAS = 11651424L;
    public static final long RVA_HOVER_SETUP = 1096864L;
    public static final long RVA_SETTING_HOVER = 1495360L;
    public static final long RVA_SETTING_RELEASE = 1495744L;
    public static final long RVA_SETTING_MOVE = 1495632L;
    public static final long RVA_ROW_SIZE = 11651680L;
    public static final long RVA_TEXT_WIDTH = 11651792L;
    public static final long RVA_SNAP_INDEX = 11654080L;
    public static final long RVA_MEASURE_A = 11715872L;
    public static final long RVA_MEASURE_B = 11715584L;
    public static final long RVA_MEASURE_C = 11716096L;
    public static final long RVA_MEASURE_D = 11716624L;
    public static final long RVA_DRAW_TEXT_ICON = 1142464L;
    public static final long RVA_DRAW_PANEL = 1139984L;
    public static final long RVA_DRAW_RECT = 3511904L;
    public static final long RVA_DRAW_TEXT_AT = 3491616L;
    public static final long RVA_PLAY_CLICK_SOUND = 36640L;
    public static final int SLOT_DTOR = 0;
    public static final int SLOT_RENDER = 8;
    public static final int SLOT_MOUSE_CLICKED = 32;
    public static final int SLOT_SET_POSITION = 88;
    public static final int SLOT_ROW_HEIGHT = 96;
    public static final int SLOT_ROW_HEIGHT_ALIAS = 104;
    public static final int SLOT_ICON = 136;
    public static final int SLOT_SIZE_A = 144;
    public static final int SLOT_SIZE_B = 152;
    public static final int SLOT_EXTRA_A = 160;
    public static final int SLOT_EXTRA_B = 168;
    public static final int OFF_SETTING = 96;
    public static final int OFF_VALUE = 104;
    public static final int OFF_FLAG_6C = 108;
    public static final int OFF_VALUE_2 = 112;
    public static final int OFF_FLAG_74 = 116;
    public static final int OFF_FLAG_78 = 120;
    public static final int OFF_ACTION = 128;
    public static final int OFF_FLAGS = 24;
    public static final int OFF_SETTING_NAME = 40;
    public static final int OFF_SETTING_CALLBACK = 288;
    public static final float ROW_WIDTH = 269.0f;
    public static final float ROW_HEIGHT = 48.0f;
    public static final float ROW_HEIGHT_SLOT = 32.0f;
    public static final float ROW_SIZE_SLOT = 16.0f;
    public static final float HOVER_ALPHA = 1.0f;
    public static final int ICON_ACTION = 89;
    public static final int FLAG_HOVERED = 1;
    public static int hoverState;
    protected Action action;
    protected float value = -1.0f;
    protected int flag6C;
    protected float value2 = -1.0f;
    protected int flag74;
    protected boolean flag78;

    public ActionWidget(Action setting) {
        this.action = setting;
        this.width = 269.0f;
        this.height = 48.0f;
        this.value = -1.0f;
        this.value2 = -1.0f;
        this.flag6C = 0;
        this.flag74 = 0;
        this.flag78 = false;
    }

    @Override
    public void render() {
    }

    @Override
    public void render(Object renderer, float mouseX, float mouseY, float alpha) {
        float color = this.hoverColor(mouseX, mouseY);
        if ((this.flags & 0xFF) != 0) {
            hoverState = 1;
        }
        String name = this.action == null ? "" : this.action.name;
        ActionWidget.drawActionRow(renderer, this.x, this.y, this.width, name, 89, color, alpha);
        this.height = 48.0f;
    }

    @Override
    public float preferredHeight() {
        return 32.0f;
    }

    protected float hoverColor(float mx, float my) {
        return 0.0f;
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (button != 0) {
            return false;
        }
        if (mx < (double)this.x || mx > (double)(this.x + this.width)) {
            return false;
        }
        if (my < (double)this.y) {
            return false;
        }
        if (my > (double)(this.y + 32.0f)) {
            return false;
        }
        if (this.action != null && this.action.onClick != null) {
            this.action.onClick.run();
        }
        return true;
    }

    public float rowHeight() {
        return 32.0f;
    }

    public float rowHeightAlias() {
        return 32.0f;
    }

    public int iconId() {
        return 89;
    }

    public float sizeSlot() {
        return 16.0f;
    }

    public static void drawActionRow(Object renderer, float x, float y, float width, String text, int style, float color, float alpha) {
    }

    public static void drawTextIcon(Object renderer, float x, float y, float width, String text, int icon, float color, float alpha) {
    }

    public static void drawPanel(Object renderer, float x, float y, float width, float height, float radius, float alpha) {
    }

    public static void drawRect(Object renderer, float x, float y, float right, float height) {
    }

    public static void drawTextAt(Object renderer, int id, float x, float y, float width, float height, int color, float alpha) {
    }

    public static void playClickSound(int sound) {
    }

    public static final class Action {
        public static final int OFF_NAME = 40;
        public static final int OFF_CALLBACK = 288;
        public String name = "";
        public Runnable onClick;
    }
}

