/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.Setting;
import client.gui.Component;

public class SettingWidget
extends Component {
    public static final int VTABLE_RVA = 0xC05C00;
    public static final int X_OFFSET = 8;
    public static final int Y_OFFSET = 12;
    public static final int WIDTH_OFFSET = 16;
    public static final int HEIGHT_OFFSET = 20;
    public static final int FLAGS_OFFSET = 24;
    public static final int STYLE_OFFSET = 32;
    public static final int AUX_OFFSET = 72;
    public static final int AUX2_OFFSET = 80;
    public static final int STATE_OFFSET = 88;
    public static final int SETTING_OFFSET = 96;
    public static final int CACHED_A_OFFSET = 104;
    public static final int DRAG_A_OFFSET = 108;
    public static final int CACHED_B_OFFSET = 112;
    public static final int DRAG_B_OFFSET = 116;
    public static final int FOCUSED_OFFSET = 120;
    public static final float NONE = -1.0f;
    public static final float DEFAULT_WIDTH = 269.0f;
    public static final float MIN_HIT = 0.001f;
    public static final float ROW_SPACING = 6.0f;
    protected float x;
    protected float y;
    protected float width;
    protected float height;
    protected boolean flagA;
    protected boolean flagB = true;
    protected Setting setting;
    protected float cachedA = -1.0f;
    protected int dragA;
    protected float cachedB = -1.0f;
    protected int dragB;
    protected boolean focused;
    public static final float EPSILON = 0.001f;
    public static final float UNIT = 1.0f;
    public static final int OPEN_KEY = 89;
    public static final float GAP = 16.0f;
    public static final float BOTTOM_PAD = 32.0f;
    public static final int VTABLE_SLOT_OPEN = 12;
    public static final int VTABLE_SLOT_MEASURE = 13;
    public static final int VTABLE_SLOT_IS_OPEN = 14;
    public static final int VTABLE_SLOT_CLOSE = 15;
    public static final int VTABLE_SLOT_CONTAINS = 16;
    public static final int VTABLE_SLOT_TRIGGER_KEY = 17;
    public static final int VTABLE_SLOT_SPACING_X = 18;
    public static final int VTABLE_SLOT_SPACING_Y = 19;

    public SettingWidget() {
    }

    public SettingWidget(Setting setting) {
        this.flagA = false;
        this.flagB = true;
        this.setting = setting;
        this.cachedA = -1.0f;
        this.cachedB = -1.0f;
        this.focused = false;
        this.width = 269.0f;
    }

    @Override
    public void render(Object mat, float x, float y, float alpha) {
    }

    public void layout(Object mat, float x, float y, float alpha) {
    }

    public void update() {
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        return false;
    }

    @Override
    public boolean mouseReleased(double mx, double my, int button) {
        return false;
    }

    @Override
    public boolean mouseDragged(double mx, double my, int button) {
        return false;
    }

    @Override
    public boolean mouseScrolled(double mx, double my, double amount) {
        return false;
    }

    public boolean keyPressed(int key) {
        return false;
    }

    @Override
    public boolean keyReleased(int key) {
        return false;
    }

    public boolean charTyped(int codePoint) {
        return false;
    }

    @Override
    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float contentHeight() {
        return 0.0f;
    }

    public void measure() {
        this.contentHeight();
    }

    public boolean isOpen() {
        return false;
    }

    public void closeModal() {
    }

    public boolean isFocused() {
        return this.focused;
    }

    public void setFocused(boolean value) {
        this.focused = value;
    }

    public Setting setting() {
        return this.setting;
    }

    public float x() {
        return this.x;
    }

    public float y() {
        return this.y;
    }

    public float width() {
        return this.width;
    }

    public float height() {
        return this.height;
    }

    @Override
    public void setSize(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public static float measureTextHeight(Object mat, Object font, float maxWidth, float wrapWidth) {
        return 0.0f;
    }

    public static float measureExtraHeight(Object mat, float measured, float maxWidth) {
        return 0.0f;
    }
}

