/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.IconTextBlock;

public class CategoryBlock
extends IconTextBlock {
    public static final long VTABLE_RVA = 12610712L;
    public static final long RVA_CTOR = 2735201359968L;
    public static final long RVA_DTOR = 2735200818144L;
    public static final long RVA_MOUSE_CLICKED = 2735201360352L;
    public static final long RVA_IS_SELECTED = 2735201359920L;
    public static final long RVA_VALUE_A = 2735201359936L;
    public static final long RVA_VALUE_B = 2735201359952L;
    public static final long RVA_CATEGORY_NAME = 2735199909472L;
    public static final long RVA_CATEGORY_ICON = 2735200901072L;
    public static final long RVA_DEFAULT_INT = 2735199916528L;
    public static final int OFF_CATEGORY = 384;
    public static final int OFF_ALL = 388;
    public static final int OFF_SELECTED = 392;
    public static final int OFF_VALUE_A = 396;
    public static final int OFF_VALUE_B = 400;
    public static final int CATEGORY_COUNT = 6;
    public static final int CATEGORY_NONE = -1;
    public static final int ICON_ALL = 1;
    public static final int BUTTON = 0;
    public static final String NAME_ALL = "All";
    public static final String NAME_COMBAT = "\u0421\u043e\u043c\u0431\u0430\u0442";
    public static final String NAME_MOVEMENT = "\u041c\u043e\u0432\u0435\u043c\u0435\u043d\u0442";
    public static final String NAME_PLAYER = "\u041f\u043b\u0430\u0439\u0435\u0440";
    public static final String NAME_RENDER = "\u0420\u0435\u043d\u0434\u0435\u0440";
    public static final String NAME_VISUAL = "\u0412\u0438\u0437\u0443\u0430\u043b";
    public static final String NAME_CLIENT = "\u0421\u043b\u0438\u0435\u043d\u0442";
    public static final String NAME_UNKNOWN = "";
    public int category;
    public boolean all;
    public boolean selected;
    public int valueA;
    public int valueB;

    public CategoryBlock(int category, boolean all) {
        super(all ? NAME_ALL : CategoryBlock.categoryName(category), all ? 1 : CategoryBlock.categoryIcon(category));
        this.category = category;
        this.all = all;
        this.selected = false;
        this.valueA = 0;
        this.valueB = 0;
    }

    public CategoryBlock(int category) {
        this(category, false);
    }

    public static String categoryName(int category) {
        switch (category) {
            case 0: {
                return NAME_COMBAT;
            }
            case 1: {
                return NAME_MOVEMENT;
            }
            case 2: {
                return NAME_PLAYER;
            }
            case 3: {
                return NAME_RENDER;
            }
            case 4: {
                return NAME_VISUAL;
            }
            case 5: {
                return NAME_CLIENT;
            }
        }
        return NAME_UNKNOWN;
    }

    public static int categoryIcon(int category) {
        switch (category) {
            case 0: {
                return 3;
            }
            case 1: {
                return 4;
            }
            case 2: {
                return 7;
            }
            case 3: {
                return 8;
            }
            case 4: {
                return 28;
            }
            case 5: {
                return 2;
            }
        }
        return 1;
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (button != 0) {
            return false;
        }
        if (mx < (double)this.x || mx > (double)(this.x + this.width)) {
            return false;
        }
        return my >= (double)this.y && my <= (double)(this.y + this.height);
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
        return this.valueA;
    }

    public void setValueA(int value) {
        this.valueA = value;
    }

    @Override
    public int valueB() {
        return this.valueB;
    }

    public void setValueB(int value) {
        this.valueB = value;
    }

    public int getCategory() {
        return this.category;
    }

    public boolean isAll() {
        return this.all;
    }

    @Override
    public void dispose() {
        super.dispose();
        this.selected = false;
        this.valueA = 0;
        this.valueB = 0;
    }
}

