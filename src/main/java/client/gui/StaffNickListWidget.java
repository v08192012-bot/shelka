/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.Setting;
import client.gui.ModalTriggerWidget;
import client.gui.TextInput;

public class StaffNickListWidget
extends ModalTriggerWidget {
    public static final int VTABLE_RVA = 12606824;
    public static final int LIST_OFFSET = 384;
    public static final int FIELD_OFFSET = 392;
    public static final int CACHE_A_OFFSET = 832;
    public static final int CACHE_B_OFFSET = 840;
    public static final int CACHE_C_OFFSET = 848;
    public static final int ROW_GAP_OFFSET = 856;
    public static final int SCROLL_TARGET_OFFSET = 864;
    public static final int SCROLL_ANIM_OFFSET = 872;
    public static final int FILTER_FLAG_OFFSET = 904;
    public static final int ENTRY_COUNT_OFFSET = 912;
    public static final int CALLBACK_OFFSET = 488;
    public static final int MODAL_WIDTH_OFFSET = 192;
    public static final int MODAL_HEIGHT_OFFSET = 196;
    public static final int MODAL_FLAGS_OFFSET = 313;
    public static final float ROW_GAP = 4.0f;
    public static final float SCROLL_SPEED = 0.28f;
    public static final float MODAL_WIDTH = 310.0f;
    public static final float MODAL_HEIGHT = 232.0f;
    public static final float FIELD_WIDTH = 278.0f;
    public static final float FIELD_HEIGHT = 36.0f;
    public static final float FIELD_FONT_SIZE = 14.0f;
    public static final float FIELD_INSET = 12.0f;
    public static final String FIELD_PLACEHOLDER = "\u0412\u0441\u0442\u0430\u0432\u044c\u0442\u0435 \u043d\u0438\u043a\u0438 \u0447\u0435\u0440\u0435\u0437 \u043f\u0440\u043e\u0431\u0435\u043b, Enter";
    public static final String TITLE_TEXT = "C\u0432\u043e\u0438 \u043d\u0438\u043a\u0438";
    public static final int TRIGGER_KEY = 34;
    public static final int TITLE_LENGTH = 16;
    public static final long NO_TARGET = -1L;
    private Object list;
    private TextInput field;
    private float rowGap = 4.0f;
    private long scrollTarget = -1L;
    private float scrollAnim;
    private boolean filterActive;
    private int entryCount;
    private Object callback;

    public StaffNickListWidget() {
        this.list = null;
        this.field = null;
    }

    public StaffNickListWidget(Setting setting, Object list) {
        super(setting);
        this.list = list;
        this.field = new TextInput(278.0f, 36.0f, FIELD_PLACEHOLDER, 14.0f, 12.0f, 0.0f);
        this.rowGap = 4.0f;
        this.scrollTarget = -1L;
        this.scrollAnim = 0.0f;
        this.filterActive = false;
        this.entryCount = 0;
        this.callback = null;
    }

    @Override
    public int triggerKey() {
        return 34;
    }

    @Override
    public Object title() {
        return TITLE_TEXT;
    }

    @Override
    public void reset(Object callback) {
        this.entryCount = 0;
        this.scrollAnim = 0.0f;
        this.scrollTarget = 0L;
        this.filterActive = false;
        this.resetModalContent(callback);
    }

    @Override
    public Object openAction() {
        return this.field;
    }

    @Override
    public boolean isVisible() {
        return true;
    }

    public Object list() {
        return this.list;
    }

    public TextInput field() {
        return this.field;
    }

    public float rowGap() {
        return this.rowGap;
    }

    public long scrollTarget() {
        return this.scrollTarget;
    }

    public float scrollAnim() {
        return this.scrollAnim;
    }

    public boolean filterActive() {
        return this.filterActive;
    }

    public int entryCount() {
        return this.entryCount;
    }

    private void resetModalContent(Object callback) {
    }
}

