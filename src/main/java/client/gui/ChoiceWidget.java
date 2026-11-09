/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.Setting;
import client.gui.AbstractTrackChoiceWidget;
import java.util.List;

public class ChoiceWidget
extends AbstractTrackChoiceWidget {
    public static final long VTABLE_RVA = 12603336L;
    public static final int OFF_CHOICE = 184;
    public static final long RVA_DESTROY = 2735201179248L;
    public static final long RVA_TYPE_ID = 2735201181296L;
    public static final long RVA_TRACK_COUNT = 2735200069104L;
    public static final long RVA_LABEL = 2735201181312L;
    public static final long RVA_ANIM_TARGET = 2735201181376L;
    public static final long RVA_SET_INDEX = 2735201181408L;
    public static final long RVA_RENDER_TRACK = 2735201181520L;
    public static final long RVA_PLAY_SOUND = 2735199719200L;
    public static final long RVA_STRING_COPY = 2735199757296L;
    public static final float OPTION_TEXT_TOP = 10.0f;
    public static final float OPTION_ICON_TOP = 11.5f;
    public static final float OPTION_ICON_WIDTH = 14.0f;
    public static final float OPTION_ICON_HEIGHT = 9.0f;
    public static final int TRACK_COUNT = 2;
    public static final int OPTION_ICON_TEXT = 89;
    public static final int SOUND_TOGGLE_ON = 7;
    public static final int SOUND_TOGGLE_OFF = 6;
    protected final TrackOption[] options = new TrackOption[2];

    public ChoiceWidget() {
        float flag;
        this.initSettingWidget(null);
        this.trackSetting = null;
        this.options[0] = new TrackOption("", 89);
        this.options[1] = new TrackOption("", 89);
        this.animFrom = flag = 0.0f;
        this.animCurrent = flag;
        this.animTarget = flag;
        this.animRunning = false;
    }

    public ChoiceWidget(Setting setting) {
        super(setting);
        float flag;
        this.trackSetting = setting;
        this.options[0] = new TrackOption(this.optionText(0), 89);
        this.options[1] = new TrackOption(this.optionText(1), 89);
        this.animFrom = flag = this.choiceValue() ? 1.0f : 0.0f;
        this.animCurrent = flag;
        this.animTarget = flag;
        this.animRunning = false;
    }

    @Override
    protected int getTypeId() {
        return 73;
    }

    @Override
    protected int getTrackCount() {
        return 2;
    }

    protected boolean choiceValue() {
        Setting s = this.trackSetting;
        if (s == null) {
            return false;
        }
        return s.getModes().indexOf(s.getMode()) == 1;
    }

    protected String optionText(int index) {
        Setting s = this.trackSetting;
        if (s == null) {
            return "";
        }
        List<String> modes = s.getModes();
        if (index < 0 || index >= modes.size()) {
            return "";
        }
        return modes.get(index);
    }

    @Override
    protected String getTrackLabel() {
        return this.optionText(this.choiceValue() ? 1 : 0);
    }

    @Override
    protected String settingValue() {
        return this.getTrackLabel();
    }

    @Override
    protected float getTrackAnimTarget() {
        return this.choiceValue() ? 1.0f : 0.0f;
    }

    @Override
    protected void setTrackIndex(int index) {
        boolean target;
        Setting s = this.trackSetting;
        if (s == null) {
            return;
        }
        boolean bl = target = index == 1;
        if (target != this.choiceValue()) {
            ChoiceWidget.playSound(target ? 7 : 6);
        }
        if (this.choiceValue() != target) {
            s.setMode(this.optionText(target ? 1 : 0));
            this.notifyChanged();
        }
    }

    protected void notifyChanged() {
    }

    protected static void playSound(int id) {
    }

    protected void drawOptionText(Object mat, String text, float px, float py, float size, int color, float alpha) {
    }

    @Override
    protected void renderTrack(Object mat, float top, float alpha) {
        boolean checked = this.choiceValue();
        for (int i = 0; i < 2; ++i) {
            float baseX;
            TrackOption option = this.options[i];
            int color = i == 1 == checked ? ChoiceWidget.rendererSecondaryColor() : ChoiceWidget.rendererColor();
            if (option.icon == 89) {
                float width = ChoiceWidget.textWidth(option.text, 12.0f);
                baseX = this.x;
                float offset = top + 10.0f;
                float cellsA = this.cellWidth();
                float cellsB = this.cellWidth();
                this.drawOptionText(mat, option.text, cellsB * 0.5f + (cellsA + 2.0f) * (float)i + baseX + 3.0f - width * 0.5f, offset, 12.0f, color, alpha);
                continue;
            }
            float cellsA = this.cellWidth();
            baseX = this.x;
            float cellsB = this.cellWidth();
            ChoiceWidget.drawText(mat, option.icon, cellsB * 0.5f + baseX + 3.0f + (cellsA + 2.0f) * (float)i - 7.0f, top + 11.5f, 14.0f, 9.0f, color, alpha);
        }
    }

    public static final class TrackOption {
        public final String text;
        public final int icon;

        public TrackOption(String text, int icon) {
            this.text = text;
            this.icon = icon;
        }
    }
}

