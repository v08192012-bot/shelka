/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.Setting;
import client.gui.AbstractTrackChoiceWidget;

public class AlignmentWidget
extends AbstractTrackChoiceWidget {
    public static final long VTABLE_RVA = 12602680L;
    public static final int OFF_ALIGNMENT = 184;
    public static final long RVA_DESTROY = 2735201179248L;
    public static final long RVA_TYPE_ID = 2735201179216L;
    public static final long RVA_VALUE_PAD = 2735201179232L;
    public static final long RVA_VALUE_MIN = 2735200848336L;
    public static final long RVA_TRACK_COUNT = 2735201179312L;
    public static final long RVA_LABEL = 2735201179328L;
    public static final long RVA_ANIM_TARGET = 2735201179456L;
    public static final long RVA_SET_INDEX = 2735201179520L;
    public static final long RVA_RENDER_TRACK = 2735201179584L;
    public static final long RVA_ALIGNMENT_LABELS = 2735212489136L;
    public static final long RVA_ALIGNMENT_LABEL_CENTER = 2735212489096L;
    public static final long RVA_ALIGNMENT_LABEL_RIGHT = 2735212489112L;
    public static final long RVA_EMPTY_STRING = 2735204023753L;
    public static final float VALUE_PAD = 12.0f;
    public static final float VALUE_MIN = 8.0f;
    public static final float TRACK_TOP_OFFSET = 11.5f;
    public static final float ICON_WIDTH = 14.0f;
    public static final float ICON_HEIGHT = 9.0f;
    public static final String LABEL_LEFT = "\u041b\u0435\u0432\u043e";
    public static final String LABEL_CENTER = "\u0426\u0435\u043d\u0442\u0440";
    public static final String LABEL_RIGHT = "\u041f\u0440\u0430\u0432\u043e";
    public static final int TRACK_COUNT = 3;
    public static final int ANIM_FALLBACK_INDEX = 1;

    public AlignmentWidget() {
    }

    public AlignmentWidget(Setting setting) {
        super(setting);
        float index;
        this.trackSetting = setting;
        this.animFrom = index = this.alignmentIndex();
        this.animCurrent = index;
        this.animTarget = index;
        this.animRunning = false;
    }

    @Override
    protected int getTypeId() {
        return 66;
    }

    @Override
    protected float getValuePad() {
        return 12.0f;
    }

    @Override
    protected float getValueMin() {
        return 8.0f;
    }

    @Override
    protected int getTrackCount() {
        return 3;
    }

    @Override
    protected String getTrackLabel() {
        int value = this.alignmentValue();
        if (value == 0) {
            return LABEL_LEFT;
        }
        if (value == 1) {
            return LABEL_CENTER;
        }
        if (value == 2) {
            return LABEL_RIGHT;
        }
        return "";
    }

    protected int alignmentValue() {
        Setting s = this.trackSetting;
        if (s == null) {
            return 0;
        }
        return AlignmentWidget.alignmentIndexOf(s.getMode());
    }

    protected float alignmentIndex() {
        int value = this.alignmentValue();
        for (int i = 0; i < ALIGNMENT_VALUES.length; ++i) {
            if (ALIGNMENT_VALUES[i] != value) continue;
            return i;
        }
        return 1.0f;
    }

    protected static int alignmentIndexOf(String mode) {
        if (mode == null) {
            return 0;
        }
        if (mode.equals(LABEL_CENTER)) {
            return 1;
        }
        if (mode.equals(LABEL_RIGHT)) {
            return 2;
        }
        return 0;
    }

    public static String alignmentMode(int value) {
        for (int i = 0; i < ALIGNMENT_VALUES.length; ++i) {
            if (ALIGNMENT_VALUES[i] != value) continue;
            if (value == 0) {
                return LABEL_LEFT;
            }
            if (value == 1) {
                return LABEL_CENTER;
            }
            if (value != 2) continue;
            return LABEL_RIGHT;
        }
        return "";
    }

    @Override
    protected float getTrackAnimTarget() {
        int value = this.alignmentValue();
        for (int i = 0; i < ALIGNMENT_VALUES.length; ++i) {
            if (ALIGNMENT_VALUES[i] != value) continue;
            return i;
        }
        return 1.0f;
    }

    @Override
    protected void setTrackIndex(int index) {
        if (index < 0 || index >= ALIGNMENT_VALUES.length) {
            return;
        }
        Setting s = this.trackSetting;
        if (s == null) {
            return;
        }
        int target = ALIGNMENT_VALUES[index];
        if (AlignmentWidget.alignmentIndexOf(s.getMode()) == target) {
            return;
        }
        s.setMode(AlignmentWidget.alignmentMode(target));
        this.notifyChanged();
    }

    protected void notifyChanged() {
    }

    @Override
    protected void renderTrack(Object mat, float top, float alpha) {
        float ty = top + 11.5f;
        int value = this.alignmentValue();
        for (int i = 0; i < 3; ++i) {
            int color = ALIGNMENT_VALUES[i] == value ? AlignmentWidget.rendererSecondaryColor() : AlignmentWidget.rendererColor();
            float cellsA = this.cellWidth();
            float baseX = this.x;
            float cellsB = this.cellWidth();
            int kind = ALIGNMENT_VALUES[i];
            int icon = kind == 0 ? 42 : (kind == 1 ? 43 : (kind == 2 ? 44 : 42));
            AlignmentWidget.drawText(mat, icon, cellsB * 0.5f + baseX + 3.0f + (cellsA + 2.0f) * (float)i - 7.0f, ty, 14.0f, 9.0f, color, alpha);
        }
    }
}

