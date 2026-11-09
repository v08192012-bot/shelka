/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.AbstractSidebarBlock;
import client.gui.Component;

public class IconTextBlock
extends AbstractSidebarBlock {
    public static final long VTABLE_RVA = 0xC070C0L;
    public static final long RVA_CTOR = 2735201379120L;
    public static final long RVA_DTOR = 2735201379520L;
    public static final long RVA_RENDER = 2735201379584L;
    public static final long RVA_ANIM_CTOR = 2735200260240L;
    public static final long RVA_ANIM_CTOR_VALUE = 2735200856400L;
    public static final long RVA_ANIM_ADVANCE = 2735200831600L;
    public static final long RVA_EASE_OUT_CUBIC = 2735200259888L;
    public static final long RVA_DRAW_COUNTERS = 2735201381248L;
    public static final long RVA_DRAW_HIGHLIGHT = 2735203170976L;
    public static final long RVA_DRAW_ICON = 2735203174176L;
    public static final long RVA_ICON_TEXTURE = 2735199818160L;
    public static final long RVA_INT_TO_TEXT = 2735200319184L;
    public static final long RVA_TEXT_ASSIGN = 2735199764880L;
    public static final long RVA_DEFAULT_BOOL = 2735199916496L;
    public static final long RVA_DEFAULT_INT = 2735199916528L;
    public static final int OFF_ICON = 136;
    public static final int OFF_HIGHLIGHT_ANIM = 144;
    public static final int OFF_COUNTER_ANIM = 184;
    public static final int OFF_BADGE_ANIM = 224;
    public static final int OFF_COUNTER_A_TEXT = 264;
    public static final int OFF_COUNTER_A_CACHED = 296;
    public static final int OFF_COUNTER_B_TEXT = 304;
    public static final int OFF_COUNTER_B_CACHED = 336;
    public static final int OFF_BADGE_TEXT = 344;
    public static final int OFF_BADGE_CACHED = 376;
    public static final float DEFAULT_WIDTH = 208.0f;
    public static final float DEFAULT_HEIGHT = 32.0f;
    public static final float ANIM_SECONDS = 0.15f;
    public static final float HIDDEN_ALPHA = 0.0f;
    public static final float HOVER_ALPHA = 0.82f;
    public static final float ACTIVE_ALPHA = 1.0f;
    public static final float ICON_SIZE = 16.0f;
    public static final float ICON_LEFT = 8.0f;
    public static final float LABEL_GAP = 10.0f;
    public static final float COUNTER_RIGHT = 8.0f;
    public static final float COUNTER_GAP = 4.0f;
    public static final float LABEL_SIZE = 14.0f;
    public static final float PILL_RADIUS = 12.0f;
    public static final float EMPTY_WIDTH = 0.0f;
    public static final float COUNTER_SUM_MIN = 1.0f;
    public static final float BADGE_MIN = 1.0f;
    public static final int BADGE_COLOR_A = -2343358;
    public static final int BADGE_COLOR_B = -772;
    public static final int THEME_PILL = 8;
    public static final int THEME_COUNTER = 0;
    public static final int THEME_LABEL = 24;
    public static final int CURSOR_HAND = 1;
    public static final int ICON_COUNT = 89;
    public static final int ICON_FIRST = 1;
    public int icon;
    public final Component.Anim highlightAnim = new Component.Anim(0.0f, 0.15f);
    public final Component.Anim counterAnim = new Component.Anim(0.0f, 0.15f);
    public final Component.Anim badgeAnim = new Component.Anim(0.0f, 0.15f);
    public final TextSlot counterA = new TextSlot();
    public final TextSlot counterB = new TextSlot();
    public final TextSlot badge = new TextSlot();

    public IconTextBlock(String label, int icon) {
        super(label, 208.0f, 32.0f);
        this.icon = icon;
        this.counterA.reset();
        this.counterB.reset();
        this.badge.reset();
    }

    public IconTextBlock(String label) {
        this(label, 1);
    }

    public int getIcon() {
        return this.icon;
    }

    public void setIcon(int value) {
        this.icon = value;
    }

    public boolean isSelected() {
        return false;
    }

    public int valueA() {
        return 0;
    }

    public int valueB() {
        return 0;
    }

    public int badgeValue() {
        return 0;
    }

    @Override
    public void render(Object renderer, float px, float py, float alpha) {
        float labelX;
        float labelW;
        int badgeSource;
        boolean outside = px < this.x || this.x + this.width < px || py < this.y || this.y + this.height < py || hoveredComponent != null && !cursorSuppressed;
        boolean bl = this.hovered = !outside;
        if (!outside) {
            cursorStyle = 1;
        }
        float target = this.isSelected() ? 1.0f : (this.hovered ? 0.82f : 0.0f);
        this.highlightAnim.retarget(target, this.now());
        this.highlightAnim.update(this.now());
        float highlight = this.highlightAnim.current;
        if (highlight > 0.001f) {
            IconTextBlock.uiDrawBox(renderer, (int)this.x, (int)this.y, this.width, this.height, 12.0f, IconTextBlock.uiThemeColor(8), highlight * alpha);
        }
        IconTextBlock.uiDrawIcon(renderer, this.icon, this.x + 8.0f, (this.height - 16.0f) * 0.5f + this.y, 16.0f, 16.0f, IconTextBlock.uiThemeColor(24), alpha);
        float dimAlpha = this.visibleAlpha(alpha);
        float cursor = this.x + this.width - 8.0f;
        int first = this.valueA();
        int second = this.valueB();
        boolean show = this.isSelected() && (float)(second + first) >= 1.0f;
        this.counterAnim.retarget(show ? 1.0f : 0.0f, this.now());
        this.counterAnim.update(this.now());
        float counters = this.counterAnim.current;
        if (counters > 0.001f) {
            float used = IconTextBlock.drawCounters(renderer, cursor, first > 0 ? this.counterA.value(first) : "", second > 0 ? this.counterB.value(second) : "", IconTextBlock.uiThemeColor(0), IconTextBlock.uiThemeColor(24), counters * dimAlpha, true);
            cursor -= (used + 4.0f) * counters;
        }
        this.badgeAnim.retarget((float)(badgeSource = this.badgeValue()) < 1.0f ? 0.0f : 1.0f, this.now());
        this.badgeAnim.update(this.now());
        float badgeAlpha = this.badgeAnim.current;
        if (badgeAlpha > 0.001f) {
            float used = IconTextBlock.drawCounters(renderer, cursor, this.badge.value(badgeSource), "", -2343358, -772, badgeAlpha * dimAlpha, false);
            cursor -= (used + 4.0f) * badgeAlpha;
        }
        if ((labelW = cursor - (labelX = this.x + 8.0f + 16.0f + 10.0f)) <= 0.0f) {
            labelW = 0.0f;
        }
        this.drawLabel(renderer, labelX, (this.height - 14.0f) * 0.5f + this.y, labelW, 14.0f, IconTextBlock.uiThemeColor(24), dimAlpha);
    }

    @Override
    public void dispose() {
        super.dispose();
        this.counterA.reset();
        this.counterB.reset();
        this.badge.reset();
    }

    public static final class TextSlot {
        public static final int CACHED_NONE = -1;
        public String text = "";
        public int cached = -1;

        public String value(int source) {
            if (source > 0 && source != this.cached) {
                this.text = Integer.toString(source);
                this.cached = source;
            }
            return this.text;
        }

        public void reset() {
            this.text = "";
            this.cached = -1;
        }
    }

    public static enum Icon {
        ICON_00,
        ICON_01,
        ICON_02,
        ICON_03,
        ICON_04,
        ICON_05,
        ICON_06,
        ICON_07,
        ICON_08,
        ICON_09,
        ICON_10,
        ICON_11,
        ICON_12,
        ICON_13,
        ICON_14,
        ICON_15,
        ICON_16,
        ICON_17,
        ICON_18,
        ICON_19,
        ICON_20,
        ICON_21,
        ICON_22,
        ICON_23,
        ICON_24,
        ICON_25,
        ICON_26,
        ICON_27,
        ICON_28,
        ICON_29,
        ICON_30,
        ICON_31,
        ICON_32,
        ICON_33,
        ICON_34,
        ICON_35,
        ICON_36,
        ICON_37,
        ICON_38,
        ICON_39,
        ICON_40,
        ICON_41,
        ICON_42,
        ICON_43,
        ICON_44,
        ICON_45,
        ICON_46,
        ICON_47,
        ICON_48,
        ICON_49,
        ICON_50,
        ICON_51,
        ICON_52,
        ICON_53,
        ICON_54,
        ICON_55,
        ICON_56,
        ICON_57,
        ICON_58,
        ICON_59,
        ICON_60,
        ICON_61,
        ICON_62,
        ICON_63,
        ICON_64,
        ICON_65,
        ICON_66,
        ICON_67,
        ICON_68,
        ICON_69,
        ICON_70,
        ICON_71,
        ICON_72,
        ICON_73,
        ICON_74,
        ICON_75,
        ICON_76,
        ICON_77,
        ICON_78,
        ICON_79,
        ICON_80,
        ICON_81,
        ICON_82,
        ICON_83,
        ICON_84,
        ICON_85,
        ICON_86,
        ICON_87,
        ICON_88;


        public int id() {
            return this.ordinal();
        }

        public static Icon of(int id) {
            if (id < 0 || id >= 89) {
                return ICON_01;
            }
            return Icon.values()[id];
        }
    }
}

