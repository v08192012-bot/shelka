/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.IconTextBlock;
import java.util.function.IntSupplier;

public class ButtonBlock
extends IconTextBlock {
    public static final long VTABLE_RVA = 12610576L;
    public static final long RVA_CTOR = 2735201359552L;
    public static final long RVA_DTOR = 2735200817968L;
    public static final long RVA_MOUSE_CLICKED = 2735201359808L;
    public static final long RVA_IS_SELECTED = 2735201359472L;
    public static final long RVA_COUNTER = 2735201359488L;
    public static final long RVA_BADGE = 2735201359520L;
    public static final long RVA_SET_COUNTER = 2735201385264L;
    public static final long RVA_DEFAULT_INT = 2735199916528L;
    public static final long RVA_FUNCTION_ASSIGN = 2735199908864L;
    public static final long RVA_FREE = 2735203701616L;
    public static final int OFF_ON_CLICK = 384;
    public static final int OFF_ON_COUNTER = 448;
    public static final int OFF_ON_BADGE = 512;
    public static final int OFF_SELECTED = 576;
    public static final int BUTTON = 0;
    public Runnable onClick;
    public IntSupplier counterSource;
    public IntSupplier badgeSource;
    public boolean selected;

    public ButtonBlock(String label, int icon, Runnable onClick) {
        super(label, icon);
        this.onClick = onClick;
        this.counterSource = null;
        this.badgeSource = null;
        this.selected = false;
    }

    public ButtonBlock(String label, int icon) {
        this(label, icon, null);
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
        if (my > (double)(this.y + this.height) || this.onClick == null) {
            return false;
        }
        return this.onClick();
    }

    @Override
    public boolean onClick() {
        if (this.onClick != null) {
            this.onClick.run();
        }
        return true;
    }

    @Override
    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean value) {
        this.selected = value;
    }

    @Override
    public int valueA() {
        return this.counterSource == null ? 0 : this.counterSource.getAsInt();
    }

    @Override
    public int badgeValue() {
        return this.badgeSource == null ? 0 : this.badgeSource.getAsInt();
    }

    public void setCounterSource(IntSupplier source) {
        this.counterSource = source;
    }

    public void setBadgeSource(IntSupplier source) {
        this.badgeSource = source;
    }

    @Override
    public void dispose() {
        super.dispose();
        this.onClick = null;
        this.counterSource = null;
        this.badgeSource = null;
        this.selected = false;
    }
}

