/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.Component;

public class AbstractSidebarBlock
extends Component {
    public static final long VTABLE_RVA = 12610472L;
    public static final long RVA_CTOR = 2735201358848L;
    public static final long RVA_DTOR = 2735201359136L;
    public static final long RVA_DTOR_BASE = 2735200808624L;
    public static final long RVA_COMPONENT_CTOR = 2735200840352L;
    public static final long RVA_RENDER = 2735203705538L;
    public static final long RVA_DRAW_LABEL = 2735201359232L;
    public static final long RVA_DRAW_TEXT = 2735203181056L;
    public static final long RVA_DRAW_TEXT_BASE = 2735203176960L;
    public static final long RVA_SCISSOR_PUSH = 2735200780464L;
    public static final long RVA_SCISSOR_POP = 2735200780784L;
    public static final long RVA_DEFAULT_BOOL = 2735199916496L;
    public static final long RVA_DEFAULT_INT = 2735199916528L;
    public static final long RVA_SET_POSITION = 2735200779184L;
    public static final long RVA_THEME = 2735203198032L;
    public static final int SLOT_DTOR = 0;
    public static final int SLOT_RENDER = 1;
    public static final int SLOT_MOUSE_CLICKED = 4;
    public static final int SLOT_MOUSE_RELEASED = 5;
    public static final int SLOT_MOUSE_MOVED = 6;
    public static final int SLOT_MOUSE_SCROLLED = 7;
    public static final int SLOT_KEY_PRESSED = 8;
    public static final int SLOT_KEY_RELEASED = 9;
    public static final int SLOT_CHAR_TYPED = 10;
    public static final int SLOT_SET_POSITION = 11;
    public static final int OFF_VTABLE = 0;
    public static final int OFF_X = 8;
    public static final int OFF_Y = 12;
    public static final int OFF_WIDTH = 16;
    public static final int OFF_HEIGHT = 20;
    public static final int OFF_FLAGS = 24;
    public static final int OFF_LABEL = 96;
    public static final int OFF_FADE = 128;
    public static final int FLAGS_INIT = 256;
    public static final float VISIBLE_EPSILON = 0.001f;
    public static final float FADE_NONE = 0.0f;
    public static final float FULL_ALPHA = 1.0f;
    public static final float LABEL_CLIP_WIDTH_MIN = 0.0f;
    public static final float DEFAULT_BLOCK_WIDTH = 208.0f;
    public static final float DEFAULT_BLOCK_HEIGHT = 32.0f;
    public String label;
    public float fade;

    public AbstractSidebarBlock() {
        this("", 208.0f, 32.0f);
    }

    public AbstractSidebarBlock(String label) {
        this(label, 208.0f, 32.0f);
    }

    public AbstractSidebarBlock(String label, float width, float height) {
        this.flags = 256;
        this.x = 0.0f;
        this.y = 0.0f;
        this.width = width;
        this.height = height;
        this.label = label == null ? "" : label;
        this.fade = 0.0f;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String value) {
        this.label = value == null ? "" : value;
    }

    public float getFade() {
        return this.fade;
    }

    public void setFade(float value) {
        this.fade = value;
    }

    public float visibleAlpha(float alpha) {
        return (1.0f - this.fade) * alpha;
    }

    protected void drawLabel(Object renderer, float lx, float ly, float lw, float size, int color, float alpha) {
        if (lw <= 0.0f || alpha <= 0.001f) {
            return;
        }
        AbstractSidebarBlock.pushScissor(lx, this.y, lw, this.height);
        AbstractSidebarBlock.labelDrawText(renderer, lx, ly, this.label, size, color, alpha);
        AbstractSidebarBlock.popScissor();
    }

    protected static float drawCounters(Object renderer, float cx, String first, String second, int firstColor, int secondColor, float alpha, boolean trailing) {
        return 0.0f;
    }

    protected static void labelDrawText(Object renderer, float tx, float ty, String text, float size, int color, float alpha) {
    }

    protected static void pushScissor(float cx, float cy, float cw, float ch) {
    }

    protected static void popScissor() {
    }

    @Override
    public void dispose() {
        super.dispose();
        this.label = "";
        this.fade = 0.0f;
    }
}

