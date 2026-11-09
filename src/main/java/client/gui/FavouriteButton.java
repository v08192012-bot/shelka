/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.AbstractButton;

public class FavouriteButton
extends AbstractButton {
    public static final long VTABLE_RVA = 12588808L;
    public static final long RVA_CTOR = 2735200891280L;
    public static final long RVA_DTOR = 2735200891440L;
    public static final long RVA_MOUSE_CLICKED = 2735200886336L;
    public static final long RVA_ON_CLICK = 2735200892144L;
    public static final int OFF_SELECTED = 96;
    public static final int OFF_CALLBACK_STORAGE = 104;
    public static final int OFF_CALLBACK = 160;
    public static final int OFF_ANIM = 168;
    public static final int OFF_ANIM_FROM = 172;
    public static final int OFF_ANIM_TARGET = 176;
    public static final float DEFAULT_WIDTH = 12.0f;
    public static final float DEFAULT_HEIGHT = 12.0f;
    public static final float ANIM_INIT_VALUE = 0.0f;
    public static final float ANIM_DURATION = 0.15f;
    public static final int CLICK_EFFECT_BASE = 2;
    public static final int CLICK_EFFECT_SELECTED = 3;
    public static final int CLICK_EFFECT_DESELECTED = 2;
    protected boolean selected;
    public final AbstractButton.Anim anim = new AbstractButton.Anim(0.0f, 0.15f);

    public FavouriteButton(boolean favourite) {
        this.selected = favourite;
        this.width = 12.0f;
        this.height = 12.0f;
        float initial = favourite ? 1.0f : 0.0f;
        this.anim.reset(initial, 0.15f);
    }

    @Override
    public boolean onClick(double mx, double my) {
        boolean previous = this.selected;
        this.selected = !previous;
        FavouriteButton.playClickEffect(previous ? 3 : 2);
        this.notifyChanged();
        return true;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean value) {
        this.selected = value;
    }
}

