/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.Setting;
import client.gui.AbstractButton;

public class BindButton
extends AbstractButton {
    public static final long VTABLE_RVA = 12588584L;
    public static final long RVA_CTOR = 2735200886464L;
    public static final long RVA_DTOR = 2735200886752L;
    public static final long RVA_MOUSE_CLICKED = 2735200887648L;
    public static final long RVA_KEY_PRESSED = 2735200888000L;
    public static final long RVA_KEY_RELEASED = 2735200888192L;
    public static final long RVA_ON_CLICK = 2735200887616L;
    public static final long RVA_CLEAR_BIND = 2735200886416L;
    public static final long RVA_ASSIGN_BIND = 2735199900464L;
    public static final int OFF_BIND_TARGET = 96;
    public static final int OFF_LISTENING = 104;
    public static final int OFF_CALLBACK_STORAGE = 112;
    public static final int OFF_CALLBACK = 168;
    public static final int OFF_PENDING_KEY = 176;
    public static final int OFF_B8 = 184;
    public static final int OFF_LABEL = 192;
    public static final int OFF_LABEL_SIZE = 208;
    public static final int OFF_LABEL_CAPACITY = 216;
    public static final int OFF_E0 = 224;
    public static final int OFF_E4 = 228;
    public static final int OFF_EC = 236;
    public static final int OFF_F0 = 240;
    public static final int OFF_ANIM = 248;
    public static final int OFF_HEIGHT = 20;
    public static final float DEFAULT_HEIGHT = 24.0f;
    public static final float ANIM_INIT_VALUE = 0.0f;
    public static final float STATE_E0_INIT = -1.0f;
    public static final float STATE_F0_INIT = 0.0f;
    public static final int STATE_B8_INIT = 0;
    public static final int PENDING_KEY_INIT = 0;
    public static final long STATE_E4_INIT = 0L;
    public static final byte STATE_EC_INIT = 0;
    protected boolean listening;
    protected int pendingKey;
    protected int field0xB8 = 0;
    protected String label = "";
    protected float field0xE0 = -1.0f;
    protected long field0xE4 = 0L;
    protected byte field0xEC = 0;
    protected float field0xF0 = 0.0f;
    public final AbstractButton.Anim anim = new AbstractButton.Anim(0.0f, 0.15f);

    public BindButton(Setting target) {
        this.bindTarget = target;
        this.listening = false;
        this.pendingKey = 0;
        this.field0xB8 = 0;
        this.label = "";
        this.field0xE0 = -1.0f;
        this.field0xE4 = 0L;
        this.field0xEC = 0;
        this.field0xF0 = 0.0f;
        this.height = 24.0f;
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (this.bindTarget == null) {
            return false;
        }
        if (this.listening) {
            if (button == 0 && this.contains(mx, my)) {
                this.listening = false;
                this.pendingKey = 0;
                return true;
            }
            this.assignBind(BindButton.mouseButtonCode(button), 0);
            this.listening = false;
            this.pendingKey = 0;
            this.notifyChanged();
            return true;
        }
        if (button == 0 && this.contains(mx, my)) {
            return this.onClick(mx, my);
        }
        return false;
    }

    @Override
    public boolean keyPressed(int keyCode, int modifiers) {
        if (this.bindTarget == null) {
            return false;
        }
        if (!this.listening) {
            if (keyCode != 46) {
                return false;
            }
            if ((this.flags & 0xFF) == 0) {
                return false;
            }
            if (this.bindIsEmpty()) {
                return false;
            }
            this.clearBind();
        } else {
            if (keyCode == 27) {
                this.listening = false;
                this.pendingKey = 0;
                return true;
            }
            if (keyCode == 46) {
                this.clearBind();
            } else {
                if (BindButton.isModifierKey(keyCode)) {
                    this.pendingKey = keyCode;
                    return true;
                }
                this.assignBind(keyCode, modifiers);
            }
            this.pendingKey = 0;
            this.listening = false;
        }
        this.notifyChanged();
        return true;
    }

    @Override
    public boolean keyReleased(int keyCode) {
        int pending;
        if (this.listening && (pending = this.pendingKey) != 0 && keyCode == pending) {
            this.assignBind(pending, 0);
            this.listening = false;
            this.pendingKey = 0;
            this.notifyChanged();
            return true;
        }
        return false;
    }

    @Override
    public boolean onClick(double mx, double my) {
        this.pendingKey = 0;
        this.listening = !this.listening;
        return true;
    }
}

