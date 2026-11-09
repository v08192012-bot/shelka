/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.AbstractButton;

public class IconButton
extends AbstractButton {
    public static final long VTABLE_RVA = 12588920L;
    public static final long RVA_CTOR = 2735200892208L;
    public static final long RVA_DTOR = 2735200892480L;
    public static final long RVA_MOUSE_CLICKED = 2735200886336L;
    public static final long RVA_ON_CLICK = 2735200893328L;
    public static final int OFF_ICON = 96;
    public static final int OFF_ACTIVE_ICON = 100;
    public static final int OFF_CLICK_ENABLED = 104;
    public static final int OFF_DISABLED = 105;
    public static final int OFF_ICON_SIZE = 108;
    public static final int OFF_ICON_ANIM = 112;
    public static final int OFF_CALLBACK_STORAGE = 152;
    public static final int OFF_CALLBACK = 208;
    public static final int OFF_TOOLTIP = 216;
    public static final int OFF_TOOLTIP_SIZE = 232;
    public static final int OFF_TOOLTIP_CAPACITY = 240;
    public static final int ICON_INVALID = 89;
    public static final float ANIM_INIT_VALUE = 0.0f;
    public static final float ANIM_DURATION = 0.15f;
    protected int icon;
    protected int activeIcon = 89;
    protected boolean clickEnabled = false;
    protected boolean disabled = false;
    protected float iconSize;
    protected String tooltip = "";
    public final AbstractButton.Anim anim = new AbstractButton.Anim(0.0f, 0.15f);

    public IconButton(int icon, float size) {
        this.icon = icon;
        this.activeIcon = 89;
        this.clickEnabled = false;
        this.disabled = false;
        this.iconSize = size;
        this.tooltip = "";
        this.width = size;
        this.height = size;
    }

    @Override
    public boolean onClick(double mx, double my) {
        if (this.onChanged != null && !this.disabled) {
            this.onChanged.run();
        }
        return true;
    }

    public int getIcon() {
        return this.icon;
    }

    public void setActiveIcon(int value) {
        this.activeIcon = value;
    }

    public int getActiveIcon() {
        return this.activeIcon;
    }

    public void setDisabled(boolean value) {
        this.disabled = value;
    }

    public boolean isDisabled() {
        return this.disabled;
    }

    public void setTooltip(String value) {
        this.tooltip = value == null ? "" : value;
    }

    public String getTooltip() {
        return this.tooltip;
    }
}

