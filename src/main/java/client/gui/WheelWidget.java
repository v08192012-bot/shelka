/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.Setting;
import client.gui.ModalTriggerWidget;

public class WheelWidget
extends ModalTriggerWidget {
    public static final int VTABLE_RVA = 12607056;
    public static final int SETTING_OFFSET = 384;
    public static final int SLOT_COUNT_OFFSET = 392;
    public static final int SELECTED_OFFSET = 396;
    public static final int ACTIVE_SLOT_OFFSET = 404;
    public static final int SCROLL_OFFSET = 408;
    public static final int SECTIONS_OFFSET = 416;
    public static final int SLOTS_OFFSET = 1616;
    public static final int SLOT_STRIDE = 40;
    public static final int SLOT_CAPACITY = 36;
    public static final int FOOTER_A_OFFSET = 3056;
    public static final int FOOTER_B_OFFSET = 3096;
    public static final int FOOTER_C_OFFSET = 3136;
    public static final int MODAL_WIDTH_OFFSET = 192;
    public static final int MODAL_HEIGHT_OFFSET = 196;
    public static final int MODAL_FLAGS_OFFSET = 313;
    public static final float MODAL_WIDTH = 812.0f;
    public static final float MODAL_HEIGHT = 310.0f;
    public static final int TRIGGER_KEY = 26;
    public static final int TITLE_CAPACITY = 31;
    public static final String TITLE_TEXT = "\u041d\u0430\u0441\u0442\u0440\u043e\u0438\u0442\u044c \u043a\u043e\u043b\u0435\u0441\u043e";
    public static final int NO_SLOT = -1;
    private Object setting;
    private int slotCount;
    private long selected = -1L;
    private int activeSlot = -1;
    private int scroll;

    public WheelWidget() {
        this.setting = null;
        this.slotCount = 0;
        this.selected = -1L;
        this.activeSlot = -1;
        this.scroll = 0;
    }

    public WheelWidget(Setting setting) {
        super(setting);
        this.setting = setting;
        this.slotCount = 0;
        this.selected = -1L;
        this.activeSlot = -1;
        this.scroll = 0;
    }

    @Override
    public int triggerKey() {
        return 26;
    }

    @Override
    public Object title() {
        return TITLE_TEXT;
    }

    @Override
    public void reset(Object callback) {
        this.setModalWidth(812.0f);
        this.setModalHeight(310.0f);
        if (this.settingSlotCount() <= this.slotCount) {
            this.slotCount = 0;
        }
        this.activeSlot = -1;
        this.scroll = 0;
        this.resetModalWheel();
        this.resetModalContent();
    }

    public int slotCount() {
        return this.slotCount;
    }

    public long selected() {
        return this.selected;
    }

    public int activeSlot() {
        return this.activeSlot;
    }

    public int scroll() {
        return this.scroll;
    }

    private int settingSlotCount() {
        return 0;
    }

    private void setModalWidth(float value) {
    }

    private void setModalHeight(float value) {
    }

    private void resetModalWheel() {
    }

    private void resetModalContent() {
    }
}

