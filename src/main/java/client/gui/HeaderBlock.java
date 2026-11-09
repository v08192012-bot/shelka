/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.AbstractSidebarBlock;

public class HeaderBlock
extends AbstractSidebarBlock {
    public static final long VTABLE_RVA = 12611672L;
    public static final long RVA_CTOR = 2735201385376L;
    public static final long RVA_DTOR = 2735201378640L;
    public static final long RVA_RENDER = 2735201378736L;
    public static final long RVA_CAPTION_BLOCK_CTOR = 2735201395200L;
    public static final long RVA_DRAW_ICON = 2735203174176L;
    public static final long RVA_DRAW_LABEL = 2735201359232L;
    public static final int OFF_ICON = 136;
    public static final int OFF_CAPTION_BLOCK = 144;
    public static final float DEFAULT_WIDTH = 224.0f;
    public static final float DEFAULT_HEIGHT = 49.0f;
    public static final float CAPTION_WIDTH = 208.0f;
    public static final float CAPTION_HEIGHT = 32.0f;
    public static final float ICON_SIZE = 20.0f;
    public static final float ICON_X_PAD = 16.0f;
    public static final float ICON_X_INSET = 2.0f;
    public static final float ICON_BOTTOM_PAD = 15.0f;
    public static final float LABEL_GAP = 6.0f;
    public static final float LABEL_RIGHT_PAD = 8.0f;
    public static final float LABEL_SIZE = 16.0f;
    public static final float LABEL_DY = 2.0f;
    public static final float EMPTY_WIDTH = 0.0f;
    public static final int THEME_ICON = 24;
    public static final int THEME_LABEL = 20;
    public static final String DEFAULT_LABEL = "ShelkaLegit";
    public static final String DEFAULT_CAPTION = "\u0421lient categories";
    public int icon = 0;
    public String caption;

    public HeaderBlock(String label, String caption) {
        super(label, 224.0f, 49.0f);
        this.caption = caption == null ? "" : caption;
    }

    public HeaderBlock() {
        this(DEFAULT_LABEL, DEFAULT_CAPTION);
    }

    public int getIcon() {
        return this.icon;
    }

    public void setIcon(int value) {
        this.icon = value;
    }

    public String getCaption() {
        return this.caption;
    }

    public void setCaption(String value) {
        this.caption = value == null ? "" : value;
    }

    @Override
    public void render(Object renderer, float px, float py, float alpha) {
        float iconX = this.x + 16.0f - 2.0f;
        float iconY = this.y + this.height - 15.0f - 20.0f;
        HeaderBlock.uiDrawIcon(renderer, this.icon, iconX, iconY, 20.0f, 20.0f, HeaderBlock.uiThemeColor(24), alpha);
        float dimAlpha = this.visibleAlpha(alpha);
        float labelX = iconX + 20.0f + 6.0f;
        float labelW = this.x + this.width - 8.0f - labelX;
        if (labelW <= 0.0f) {
            labelW = 0.0f;
        }
        this.drawLabel(renderer, labelX, iconY + 2.0f, labelW, 16.0f, HeaderBlock.uiThemeColor(20), dimAlpha);
    }

    @Override
    public void dispose() {
        super.dispose();
        this.icon = 0;
        this.caption = "";
    }
}

