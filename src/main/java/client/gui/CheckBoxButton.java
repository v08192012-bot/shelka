package client.gui;

import client.gui.AbstractButton;

public class CheckBoxButton extends AbstractButton {
    public static final long VTABLE_RVA = 12588696L;
    public static final long RVA_CTOR = 2735200890000L;
    public static final long RVA_DTOR = 2735200890256L;
    public static final long RVA_MOUSE_CLICKED = 2735200886336L;
    public static final long RVA_ON_CLICK = 2735200891136L;
    public static final long RVA_ANIM_INIT = 2735200379760L;
    public static final int OFF_VALUE = 96;
    public static final int OFF_CALLBACK_STORAGE = 104;
    public static final int OFF_CALLBACK = 160;
    public static final int OFF_ANIM_CHECK = 168;
    public static final int OFF_ANIM_CHECK_FROM = 172;
    public static final int OFF_ANIM_CHECK_TARGET = 176;
    public static final int OFF_C8 = 200;
    public static final int OFF_ANIM_BOX = 208;
    public static final int OFF_ANIM_BOX_FROM = 212;
    public static final int OFF_ANIM_BOX_TARGET = 216;
    public static final int OFF_F0 = 240;
    public static final float DEFAULT_WIDTH = 16.0f;
    public static final float DEFAULT_HEIGHT = 16.0f;
    public static final float ANIM_VALUE_INIT = 0.0f;
    public static final float ANIM_DURATION = 0.22f;
    public static final int CLICK_EFFECT_UNCHECKED = 7;
    public static final int CLICK_EFFECT_CHECKED = 6;
    protected boolean value;
    protected boolean field0xC8 = false;
    protected boolean field0xF0 = false;
    public final AbstractButton.Anim animCheck = new AbstractButton.Anim(0.0f, 0.22f);
    public final AbstractButton.Anim animBox = new AbstractButton.Anim(0.0f, 0.22f);

    public CheckBoxButton(boolean checked) {
        this.value = checked;
        this.field0xC8 = false;
        this.field0xF0 = false;
        this.width = 16.0f;
        this.height = 16.0f;
        float initial = checked ? 1.0f : 0.0f;
        this.animCheck.reset(initial, 0.22f);
        this.animBox.reset(initial, 0.22f);
    }

    @Override
    public boolean onClick(double mx, double my) {
        boolean previous = this.value;
        this.value = !previous;
        float target = 1.0f;
        if (previous) {
            this.animCheck.animateTo(0.0f);
            target = 0.0f;
        } else {
            this.animCheck.animateTo(1.0f);
        }
        this.animBox.animateTo(target);
        CheckBoxButton.playClickEffect(this.value ? 6 : 7);
        this.notifyChanged();
        return true;
    }

    public boolean isChecked() {
        return this.value;
    }

    public void setChecked(boolean checked) {
        this.value = checked;
    }
}