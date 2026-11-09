/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.Setting;

public class Row {
    public static final long RVA_ROW_HEIGHT = 2735201190848L;
    public static final long RVA_ROW_DRAG = 2735201190864L;
    public static final long RVA_ROW_SPACING = 2735201190880L;
    public static final long RVA_ROW_OPACITY = 2735201190896L;
    public static final long RVA_ROW_TEXT_HEIGHT = 2735201190912L;
    public static final long RVA_ROW_FACTORY = 2735201206896L;
    public static final long RVA_ROW_SYNC = 2735201208704L;
    public static final long RVA_SWITCH_ROW_RENDER = 2735201190944L;
    public static final long RVA_SWITCH_ROW_X = 2735201191072L;
    public static final long RVA_SWITCH_ROW_CLICK = 2735201191104L;
    public static final long RVA_SWITCH_ROW_WIDGET = 2735201191200L;
    public static final long RVA_SLIDER_ROW_RENDER = 2735201191344L;
    public static final long RVA_SLIDER_ROW_CLICK = 2735201193136L;
    public static final long RVA_INPUT_ROW_CTOR = 2735201204656L;
    public static final long RVA_INPUT_ROW_RENDER = 2735201205072L;
    public static final int OWNER_OFFSET = 8;
    public static final int SETTING_OFFSET = 16;
    public static final int HEIGHT_OFFSET = 24;
    public static final int REVEAL_OFFSET = 28;
    public static final int VISIBLE_OFFSET = 32;
    public static final int Y_OFFSET = 36;
    public static final int HANDLER_OFFSET = 40;
    public static final int FLAGS_OFFSET = 48;
    public static final int TAG_OFFSET = 52;
    public static final int BOUND_OFFSET = 64;
    public static final int BOUNDS_OFFSET = 80;
    public static final float DEFAULT_HEIGHT = 4.5f;
    public static final float ROW_HEIGHT = 26.0f;
    public static final float ROW_SPACING = 4.0f;
    public static final float DEFAULT_OPACITY = 1.0f;
    public static final float DRAG_BIAS = 141.0f;
    protected Object owner;
    protected Setting setting;
    protected float height = 4.5f;
    protected float reveal;
    protected boolean visible;
    protected float y;
    protected short flags;
    protected long tag;
    protected Setting bound;
    protected float boundsX;
    protected float boundsY;
    protected float boundsWidth;
    protected float boundsHeight;

    public Row() {
    }

    public Row(Object owner, Setting setting) {
        this.owner = owner;
        this.setting = setting;
        this.height = 4.5f;
        this.reveal = 0.0f;
        this.visible = false;
        this.y = 0.0f;
        this.flags = 0;
        this.tag = 0L;
        this.bound = setting;
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

    public float textHeight() {
        return Row.fontTextHeight();
    }

    public static float fontTextHeight() {
        return 0.0f;
    }

    public void render(Object mat, float x, float y, float width, float height, float mouseX, float mouseY) {
    }

    public boolean mouseClicked(double mx, double my, int button, float x, float y) {
        return false;
    }

    public boolean mouseDragged(double mx, double my, int button) {
        return false;
    }

    public float drag(float value, float width) {
        return value + 141.0f;
    }

    public boolean mouseClicked(double mx, double my, int button) {
        return false;
    }

    public int pressedKey() {
        return 0;
    }

    public boolean keyTyped(int key) {
        return false;
    }

    public boolean onCommit() {
        return false;
    }

    public void setFocused(boolean value) {
    }

    public void setReveal(float value) {
        if (this.reveal == value) {
            return;
        }
        this.reveal = value;
        this.applyReveal(value);
    }

    protected void applyReveal(float value) {
    }

    public void markVisible() {
        if (this.visible) {
            return;
        }
        this.visible = true;
        this.y = 0.0f;
    }

    public void hideAt(float targetY) {
        if (!this.visible) {
            return;
        }
        this.visible = false;
        this.y = targetY <= 0.0f ? 0.0f : targetY;
    }

    public void collapse() {
        this.boundsY = 1.0f;
        this.visible = true;
        this.reveal = 1.0f;
    }

    public Object owner() {
        return this.owner;
    }

    public Setting setting() {
        return this.setting;
    }

    public Setting boundSetting() {
        return this.bound;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public float y() {
        return this.y;
    }

    public float height() {
        return this.height;
    }

    public float boundsX() {
        return this.boundsX;
    }

    public float boundsY() {
        return this.boundsY;
    }

    public float boundsWidth() {
        return this.boundsWidth;
    }

    public float boundsHeight() {
        return this.boundsHeight;
    }

    public void setBounds(float x, float y, float width, float height) {
        this.boundsX = x;
        this.boundsY = y;
        this.boundsWidth = width;
        this.boundsHeight = height;
    }

    public boolean contains(double mx, double my) {
        return mx >= (double)this.boundsX && mx <= (double)(this.boundsX + this.boundsWidth) && my >= (double)this.boundsY && my <= (double)(this.boundsY + this.boundsHeight);
    }
}

