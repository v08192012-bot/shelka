/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.Setting;
import client.gui.Row;
import client.gui.Screen;

public class SliderRow
extends Row {
    public static final int VTABLE_RVA = 12605112;
    public static final int SMOOTH_OFFSET = 72;
    public static final int VALUE_OFFSET = 80;
    public static final int INITIALIZED_OFFSET = 84;
    public static final int REVEAL_ANIM_OFFSET = 88;
    public static final int CACHED_TEXT_OFFSET = 128;
    public static final int CACHED_WIDTH_OFFSET = 136;
    public static final float LABEL_X_BIAS = 141.0f;
    public static final float LABEL_WIDTH = 70.0f;
    public static final float LABEL_Y_BIAS = 10.0f;
    public static final float DRAG_SPEED = 0.05f;
    public static final float VALUE_EPSILON = 0.01f;
    public static final float LOG_HALF = -0.6931472f;
    public static final float REVEAL_SPEED = 0.22f;
    public static final float NONE = -1.0f;
    public static final float TRACK_HEIGHT = 2.0f;
    public static final float HALF = 0.5f;
    private float smooth;
    private float value;
    private boolean initialized;
    private float revealAnim;
    private float cachedText = -1.0f;
    private float textWidth;
    private float revealTarget;
    private float cachedWidth = -1.0f;
    public static final float HOLD = 6.0f;

    public SliderRow() {
    }

    public SliderRow(Object owner, Setting setting) {
        super(owner, setting);
        this.bound = setting;
        this.smooth = -1.0f;
        this.value = 0.0f;
        this.initialized = false;
        this.revealAnim = 0.0f;
        this.cachedWidth = -1.0f;
    }

    @Override
    public void render(Object mat, float x, float y, float width, float height, float mouseX, float mouseY) {
        float targetAlpha;
        boolean dragging;
        float target = (float)this.bound.getNumber();
        float factor = this.smoothFactor();
        if (!this.initialized) {
            this.initialized = true;
        } else {
            float diff = target - this.value;
            if (0.01f <= Math.abs(diff)) {
                factor = (float)Math.exp(factor * -0.6931472f / 0.05f);
                target -= factor * diff;
            }
        }
        this.value = target;
        float labelX = x + 141.0f;
        float labelY = y + 10.0f;
        Object ownerObject = this.owner;
        boolean bl = dragging = this.ownerDragTarget() == this.bound;
        if (dragging) {
            Screen.hoveredWidget = 3;
        } else if (labelX <= mouseX && mouseX <= labelX + 70.0f && y <= mouseY && mouseY <= y + 26.0f && (Screen.focusedWidget == null || Screen.allowHover)) {
            Screen.hoveredWidget = 1;
        }
        double min = this.bound.getMin();
        double max = this.bound.getMax();
        float ratio = (float)SliderRow.clamp(((double)this.value - min) / (max - min), 0.0, 1.0);
        float f = targetAlpha = dragging ? 0.0f : 1.0f;
        if (this.revealTarget != targetAlpha) {
            this.revealTarget = targetAlpha;
        }
        float reveal = this.revealAnim;
        float trackY = labelY + 4.0f;
        float knobX = labelX + ratio * 70.0f - reveal * 0.5f;
        SliderRow.drawTrack(mat, labelX, trackY, 70.0f * ratio, 2.0f);
        SliderRow.drawKnob(mat, knobX, trackY - 6.0f, 2.0f);
        if (this.cachedText < 0.0f || this.bound.getNumber() != (double)this.cachedText) {
            this.textWidth = SliderRow.measureText(mat, this.bound.getName(), 136.0f);
            this.cachedText = (float)this.bound.getNumber();
        }
        SliderRow.drawValue(mat, this.bound, x + width - 8.0f - this.textWidth, trackY);
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button, float x, float y) {
        if (button != 0) {
            return false;
        }
        float labelX = x + 141.0f;
        if (!((double)labelX <= mx && mx <= (double)(labelX + 70.0f) && (double)y <= my && my <= (double)(y + 26.0f))) {
            return false;
        }
        this.setOwnerDragTarget(this.bound);
        double before = this.bound.getNumber();
        double ratio = SliderRow.clamp((mx - (double)labelX) / 70.0, 0.0, 1.0);
        double min = this.bound.getMin();
        double max = this.bound.getMax();
        this.bound.setNumber((max - min) * ratio + min);
        if (this.bound.getNumber() != before) {
            this.playClick();
        }
        return true;
    }

    @Override
    public float drag(float value0, float width) {
        return value0 + 141.0f;
    }

    public boolean mouseDragged(double mx, float y) {
        return false;
    }

    public float value() {
        return this.value;
    }

    public float revealAnim() {
        return this.revealAnim;
    }

    private float smoothFactor() {
        return 0.0f;
    }

    private Object ownerDragTarget() {
        return null;
    }

    private void setOwnerDragTarget(Setting setting) {
    }

    private void playClick() {
    }

    private static double clamp(double value, double min, double max) {
        if (value < min) {
            return min;
        }
        return value > max ? max : value;
    }

    private static void drawTrack(Object mat, float x, float y, float width, float height) {
    }

    private static void drawKnob(Object mat, float x, float y, float size) {
    }

    private static float measureText(Object mat, String text, float widthHint) {
        return 0.0f;
    }

    private static void drawValue(Object mat, Setting setting, float x, float y) {
    }
}

