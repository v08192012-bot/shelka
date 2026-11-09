/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.Setting;
import client.gui.Row;
import client.gui.SwitcherButton;

public class SwitchRow
extends Row {
    public static final int VTABLE_RVA = 12604232;
    public static final int SWITCH_OFFSET = 72;
    public static final int CACHED_STATE_OFFSET = 168;
    public static final int TOGGLE_ANIM_OFFSET = 240;
    public static final float SWITCH_WIDTH = 28.0f;
    public static final float SWITCH_HEIGHT = 16.0f;
    public static final float SWITCH_RIGHT_INSET = 8.0f;
    public static final float SWITCH_TOP_INSET = 5.0f;
    public static final float UNIT = 1.0f;
    private SwitcherButton toggle;
    private boolean cachedState;
    private float toggleAnim;

    public SwitchRow() {
    }

    public SwitchRow(Object owner, Setting setting) {
        super(owner, setting);
        this.bound = setting;
        this.toggle = new SwitcherButton(SwitchRow.checked(setting));
        this.cachedState = false;
        this.toggleAnim = 0.0f;
    }

    private static boolean checked(Setting setting) {
        return setting != null && setting.getBoolean();
    }

    @Override
    public void render(Object mat, float x, float y, float width, float height, float mouseX, float mouseY) {
        boolean state = SwitchRow.checked(this.bound);
        if (this.cachedState != state) {
            this.cachedState = state;
            this.toggleAnim = state ? 1.0f : 0.0f;
        }
        float rowSpan = x + width - 8.0f;
        this.boundsY = y + 5.0f;
        this.boundsX = rowSpan - 28.0f;
        this.boundsWidth = 28.0f;
        this.boundsHeight = 16.0f;
        if (this.toggle != null) {
            this.toggle.render(mat, mouseX, mouseY);
        }
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (button != 0) {
            return false;
        }
        if (!((double)this.boundsX <= mx && mx <= (double)(this.boundsX + this.boundsWidth) && (double)this.boundsY <= my && my <= (double)(this.boundsY + this.boundsHeight))) {
            return false;
        }
        return this.toggle != null && this.toggle.press(mx);
    }

    @Override
    public float drag(float x, float width) {
        return x + width - 8.0f - 28.0f;
    }

    public SwitcherButton toggle() {
        return this.toggle;
    }

    public boolean state() {
        return this.cachedState;
    }

    public float toggleAnim() {
        return this.toggleAnim;
    }
}

