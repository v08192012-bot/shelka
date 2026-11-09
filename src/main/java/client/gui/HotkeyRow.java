/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.Setting;
import client.gui.Component;

public class HotkeyRow
extends Component {
    public static final long VTABLE_RVA = 12604040L;
    public static final long RVA_FACTORY = 2735201206896L;
    public static final long RVA_DELETING_DTOR = 2735201200832L;
    public static final long RVA_ROW_HEIGHT = 2735201190848L;
    public static final long RVA_ROW_SPACING = 2735201190880L;
    public static final long RVA_ROW_OPACITY = 2735201190896L;
    public static final long RVA_ROW_ACCENT = 2735201190912L;
    public static final long RVA_DRAG = 2735201190864L;
    public static final long RVA_DEFAULT_ANIM = 2735200260240L;
    public static final long RVA_RENDER = 2735201197952L;
    public static final long RVA_MOUSE_CLICKED = 2735201199760L;
    public static final long RVA_METRIC = 2735201200656L;
    public static final long RVA_KEY_PRESSED = 2735201200288L;
    public static final long RVA_KEY_RELEASED = 2735201200512L;
    public static final long RVA_GLYPH_METRICS = 2735199818160L;
    public static final long RVA_KEY_TEXT = 2735203176960L;
    public static final int SLOT_ROW_HEIGHT = 1;
    public static final int SLOT_ROW_HEIGHT_ALIAS = 2;
    public static final int SLOT_UPDATE = 3;
    public static final int SLOT_RENDER = 4;
    public static final int SLOT_MOUSE_CLICKED = 5;
    public static final int SLOT_METRIC = 6;
    public static final int SLOT_SPACING = 7;
    public static final int SLOT_OPACITY = 8;
    public static final int SLOT_ACCENT = 9;
    public static final int SLOT_SET_POSITION = 11;
    public static final int SLOT_KEY_PRESSED = 12;
    public static final int SLOT_KEY_RELEASED = 13;
    public static final int SLOT_COMMIT = 15;
    public static final int OFF_OWNER = 8;
    public static final int OFF_SETTING = 16;
    public static final int OFF_ROW_HEIGHT = 24;
    public static final int OFF_REVEAL = 28;
    public static final int OFF_ROW_VISIBLE = 32;
    public static final int OFF_ROW_Y = 36;
    public static final int OFF_HANDLER = 40;
    public static final int OFF_ROW_FLAGS = 48;
    public static final int OFF_TAG = 52;
    public static final int OFF_KEYBIND = 64;
    public static final int OFF_CAPTURING = 72;
    public static final int OFF_PENDING_MOD = 76;
    public static final int OFF_CAPTURE_ANIM = 80;
    public static final int OFF_HOVER_ANIM = 120;
    public static final int OFF_PRESS_ANIM = 160;
    public static final int OFF_KEY_ANIM = 200;
    public static final float ROW_HEIGHT = 26.0f;
    public static final float ROW_SPACING = 4.0f;
    public static final float ROW_OPACITY = 1.0f;
    public static final float DEFAULT_ROW_HEIGHT = 4.5f;
    public static final float CAPTURE_DURATION = 0.15f;
    public static final float HOVER_DURATION = 0.15f;
    public static final float PRESS_DURATION = 0.15f;
    public static final float KEY_DURATION = 0.55f;
    public static final float EPSILON = 0.001f;
    public static final float NEAR_ONE = 0.999f;
    public static final float DRAG_BIAS = 141.0f;
    public static final float BADGE_W = 20.0f;
    public static final float CAPTURE_W = 70.0f;
    public static final float ZONE_H = 18.0f;
    public static final float BADGE_PAD_X = 8.0f;
    public static final float BADGE_PAD_Y = 5.0f;
    public static final float INSET = 2.0f;
    public static final float GLYPH_SIZE = 16.0f;
    public static final float SECTION_H = 32.0f;
    public static final float TEXT_INSET = 3.0f;
    public static final float BADGE_TEXT_OFFSET = 4.0f;
    public static final float BADGE_ANIM_SCALE = 2.0f;
    private Object owner;
    private Setting setting;
    private Setting keyBind;
    private float rowHeight = 4.5f;
    private float reveal;
    private boolean rowVisible;
    private float rowY;
    private int rowFlags;
    private long tag;
    private float boundsX;
    private float boundsY;
    private float boundsWidth;
    private float boundsHeight;
    private boolean capturing;
    private int pendingModifier;
    private int boundKey;
    private int boundModifiers;
    private Object handler;
    private final Component.Anim captureAnim = new Component.Anim(0.0f, 0.15f);
    private final Component.Anim hoverAnim = new Component.Anim(0.0f, 0.15f);
    private final Component.Anim pressAnim = new Component.Anim(0.0f, 0.15f);
    private final Component.Anim keyAnim = new Component.Anim(0.0f, 0.55f);
    public static final float PI = (float)Math.PI;
    public static final int GLYPH_ICON = 68;

    public HotkeyRow() {
    }

    public HotkeyRow(Object owner, Setting keyBind) {
        this.owner = owner;
        this.setting = keyBind;
        this.keyBind = keyBind;
        this.boundKey = keyBind == null ? 0 : keyBind.getKey();
        this.boundModifiers = 0;
        long time = this.now();
        this.captureAnim.update(time);
        this.hoverAnim.update(time);
        this.pressAnim.update(time);
        this.keyAnim.update(time);
    }

    public HotkeyRow(Object owner, Setting keyBind, String label) {
        this(owner, keyBind);
    }

    public float rowHeight() {
        return 26.0f;
    }

    public float rowSpacing() {
        return 4.0f;
    }

    public float opacity() {
        return 1.0f;
    }

    public int accentColor() {
        return HotkeyRow.uiThemeColor(0);
    }

    public float drag(float value) {
        return value + 141.0f;
    }

    public float metric(float a, float b) {
        return a + b - 8.0f - 20.0f - 4.0f - 70.0f;
    }

    public void setReveal(float value) {
        if (this.reveal == value) {
            return;
        }
        this.reveal = value;
    }

    public void markVisible() {
        if (this.rowVisible) {
            return;
        }
        this.rowVisible = true;
        this.rowY = 0.0f;
    }

    public void hideAt(float targetY) {
        if (!this.rowVisible) {
            return;
        }
        this.rowVisible = false;
        this.rowY = targetY <= 0.0f ? 0.0f : targetY;
    }

    public float reveal() {
        return this.reveal;
    }

    public boolean rowVisible() {
        return this.rowVisible;
    }

    public float rowY() {
        return this.rowY;
    }

    public Object owner() {
        return this.owner;
    }

    public Setting setting() {
        return this.setting;
    }

    public boolean capturing() {
        return this.capturing;
    }

    @Override
    public float preferredHeight() {
        return 26.0f;
    }

    @Override
    public float preferredWidth() {
        return 26.0f;
    }

    public void update() {
    }

    @Override
    public void tick() {
        this.update();
    }

    @Override
    public void render(Object renderer, float px, float py, float alpha) {
        this.render(renderer, px, py, this.width, mouseX, mouseY, alpha);
    }

    public void render(Object renderer, float px, float py, float pw, float mx, float my, float alpha) {
        boolean overBadge;
        float zoneX = px + pw - 20.0f - 20.0f;
        float captureX = zoneX - 4.0f - 70.0f;
        float zoneY = py + 5.0f - 2.0f;
        long time = this.now();
        this.captureAnim.retarget(this.capturing ? 1.0f : 0.0f, time);
        this.captureAnim.update(time);
        float capture = this.captureAnim.current;
        boolean overCapture = !this.capturing && mx >= captureX && mx <= captureX + 70.0f && my >= zoneY && my <= zoneY + 18.0f;
        this.hoverAnim.retarget(overCapture ? 1.0f : 0.0f, time);
        this.hoverAnim.update(time);
        float hover = this.hoverAnim.current;
        if (overCapture) {
            cursorStyle = 1;
        }
        String label = !this.capturing ? this.keyLabel() : "";
        float textW = HotkeyRow.fontWidth(label, 12.0f);
        float textX = (70.0f - textW) * 0.5f + captureX;
        if (0.001f < capture || 0.001f < hover) {
            HotkeyRow.uiDrawIcon(renderer, 0, textX, zoneY + 3.0f, textW, 18.0f, HotkeyRow.uiThemeColor(0), alpha);
        }
        boolean bl = overBadge = mx >= zoneX && mx <= zoneX + 20.0f && my >= zoneY && my <= zoneY + 18.0f;
        if (overBadge) {
            cursorStyle = 1;
        }
        if (overCapture || overBadge) {
            cursorStyle = 1;
        }
        this.pressAnim.retarget(overBadge ? 1.0f : 0.0f, time);
        this.pressAnim.update(time);
        float press = this.pressAnim.current;
        float glyphX = zoneX + 4.0f;
        float glyphY = zoneY + 3.0f;
        if (0.001f < press && press < 0.999f) {
            float angle = (press + press) * (float)Math.PI;
            HotkeyRow.uiDrawBox(renderer, glyphX, glyphY, 16.0f, 16.0f, angle, angle, angle, angle, 0, 0, 0.0f, HotkeyRow.uiThemeColor(0), 1.0f, press * alpha, 0.0f, alpha, 0);
        }
        HotkeyRow.uiDrawIcon(renderer, 68, glyphX, glyphY, 16.0f, 16.0f, HotkeyRow.uiThemeColor(0), alpha);
        this.height = zoneY + 32.0f - this.y;
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        return this.mouseClicked(mx, my, button, this.x, this.y, this.width);
    }

    public boolean mouseClicked(double mx, double my, int button, float px, float py, float pw) {
        boolean overBadge;
        float zoneX = px + pw - 20.0f - 20.0f;
        float captureX = zoneX - 4.0f - 70.0f;
        float zoneY = py + 5.0f - 2.0f;
        boolean overCapture = mx >= (double)captureX && mx <= (double)(captureX + 70.0f) && my >= (double)zoneY && my <= (double)(zoneY + 18.0f);
        boolean bl = overBadge = mx >= (double)zoneX && mx <= (double)(zoneX + 20.0f) && my >= (double)zoneY && my <= (double)(zoneY + 18.0f);
        if (this.capturing) {
            int key = 0;
            if (button != 0 || !overCapture) {
                if (button == 0) {
                    key = 1;
                } else if (button == 1) {
                    key = 2;
                } else if (button == 2) {
                    key = 4;
                } else if (button == 3) {
                    key = 5;
                } else if (button == 4) {
                    key = 6;
                }
                if (this.boundKey != key || this.boundModifiers != 0) {
                    this.boundKey = key;
                    this.boundModifiers = 0;
                    this.applyKey();
                }
            }
            this.capturing = false;
            this.pendingModifier = 0;
            return true;
        }
        if (button != 0) {
            return false;
        }
        if (overBadge) {
            if (this.boundKey != 0 || this.boundModifiers != 0) {
                this.boundKey = 0;
                this.boundModifiers = 0;
                this.applyKey();
            }
            long time = this.now();
            this.keyAnim.set(0.0f, 0.55f);
            this.keyAnim.retarget(1.0f, time);
            this.keyAnim.update(time);
            this.capturing = false;
            this.pendingModifier = 0;
            return true;
        }
        if (overCapture) {
            this.capturing = true;
            this.pendingModifier = 0;
            return true;
        }
        return false;
    }

    @Override
    public boolean mouseMoved(double mx, double my, double delta) {
        mouseX = (float)mx;
        mouseY = (float)my;
        return false;
    }

    @Override
    public boolean mouseScrolled(double mx, double my, double amount) {
        mouseX = (float)mx;
        mouseY = (float)my;
        return false;
    }

    @Override
    public boolean keyPressed(int keyCode, int modifiers) {
        if (!this.capturing) {
            return false;
        }
        if (keyCode == 27) {
            if (this.boundKey != 0 || this.boundModifiers != 0) {
                this.boundKey = 0;
                this.boundModifiers = 0;
                this.applyKey();
            }
            this.capturing = false;
            this.pendingModifier = 0;
            return true;
        }
        if (keyCode >= 16 && keyCode <= 18 || keyCode >= 160 && keyCode <= 165) {
            this.pendingModifier = keyCode;
            return true;
        }
        if (this.boundKey != keyCode || this.boundModifiers != modifiers) {
            this.boundKey = keyCode;
            this.boundModifiers = modifiers;
            this.applyKey();
        }
        this.capturing = false;
        this.pendingModifier = 0;
        return true;
    }

    @Override
    public boolean keyReleased(int keyCode) {
        if (!this.capturing) {
            return false;
        }
        int pending = this.pendingModifier;
        if (pending == 0 || keyCode != pending) {
            return false;
        }
        if (this.boundKey != pending || this.boundModifiers != 0) {
            this.boundKey = pending;
            this.boundModifiers = 0;
            this.applyKey();
        }
        this.pendingModifier = 0;
        this.capturing = false;
        return true;
    }

    public void onCommit() {
        if (!this.capturing) {
            return;
        }
        this.capturing = false;
        this.pendingModifier = 0;
    }

    private void applyKey() {
        if (this.keyBind != null) {
            this.keyBind.setKey(this.boundKey);
        }
    }

    private String keyLabel() {
        if (this.boundKey == 0) {
            return "";
        }
        return HotkeyRow.nameOf(this.boundKey);
    }

    private static String nameOf(int key) {
        return "";
    }

    private static float fontWidth(String s, float size) {
        if (s == null || s.isEmpty()) {
            return 0.0f;
        }
        return (float)s.length() * size;
    }
}

