/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.Setting;
import client.gui.Component;

public class HotkeyWidget
extends Component {
    public static final long VTABLE_RVA = 12605552L;
    public static final long RVA_BASE_CTOR = 2735201239728L;
    public static final long RVA_DELETING_DTOR = 2735201226176L;
    public static final long RVA_RENDER = 2735201226240L;
    public static final long RVA_MOUSE_CLICKED = 2735201228688L;
    public static final long RVA_KEY_PRESSED = 2735201229232L;
    public static final long RVA_KEY_RELEASED = 2735201229488L;
    public static final long RVA_HEIGHT = 2735201228352L;
    public static final long RVA_VALUE_WIDTH = 2735201240064L;
    public static final long RVA_LABEL_WIDTH = 2735201240352L;
    public static final long RVA_BADGE_RENDER = 2735201227104L;
    public static final long RVA_BADGE_CONTAINS = 2735201228448L;
    public static final long RVA_GLYPH_METRICS = 2735199818160L;
    public static final long RVA_SECTION_DRAW = 2735200823424L;
    public static final long RVA_BADGE_DRAW = 2735200824272L;
    public static final long RVA_KEY_TEXT = 2735203176960L;
    public static final int SLOT_RENDER = 1;
    public static final int SLOT_MOUSE_CLICKED = 4;
    public static final int SLOT_KEY_PRESSED = 8;
    public static final int SLOT_KEY_RELEASED = 9;
    public static final int SLOT_SET_POSITION = 11;
    public static final int SLOT_HEIGHT = 12;
    public static final int SLOT_HEIGHT_ALIAS = 13;
    public static final int SLOT_KIND = 17;
    public static final int SLOT_MIN_WIDTH = 18;
    public static final int SLOT_MIN_WIDTH_ALIAS = 19;
    public static final int OFF_SETTING = 128;
    public static final int OFF_CAPTURING = 136;
    public static final int OFF_CAPTURE_ANIM = 144;
    public static final int OFF_KEY_ANIM = 184;
    public static final int OFF_PENDING_MOD = 224;
    public static final float FOCUS_DURATION = 0.15f;
    public static final float KEY_ANIM_DURATION = 0.55f;
    public static final float EPSILON = 0.001f;
    public static final float NEAR_ONE = 0.999f;
    public static final float SECTION_H = 32.0f;
    public static final float SECTION_TOP = 6.0f;
    public static final float SECTION_PAD = 2.0f;
    public static final float SECTION_PAD2 = 8.0f;
    public static final float BADGE_SIZE = 26.0f;
    public static final float BADGE_INSET = 3.0f;
    public static final float BADGE_TEXT_PAD = 5.0f;
    public static final float BADGE_W = 29.0f;
    public static final float LABEL_FONT_SIZE = 12.0f;
    public static final float DEFAULT_WIDTH = 269.0f;
    public static final float GLYPH_SIZE = 16.0f;
    public static final int KIND = 89;
    public static final float MIN_WIDTH = 16.0f;
    public static final int GLYPH_ICON = 68;
    public static final float BADGE_CORNER = 8.0f;
    public static final float SECTION_CORNER = 10.0f;
    private Setting setting;
    private boolean capturing;
    private int boundKey;
    private int boundModifiers;
    private int pendingModifier;
    private final Component.Anim captureAnim = new Component.Anim(0.0f, 0.15f);
    private final Component.Anim keyAnim = new Component.Anim(0.0f, 0.55f);
    private float labelWidth = -1.0f;
    private float labelWidthCache;
    private float valueWidth = -1.0f;
    private float valueWidthCache;
    public static final float LABEL_GAP = 20.0f;
    public static final float PI = (float)Math.PI;

    public HotkeyWidget() {
    }

    public HotkeyWidget(Setting setting) {
        this.setting = setting;
        this.flags = 256;
        this.width = 269.0f;
        this.boundKey = setting == null ? 0 : setting.getKey();
        this.boundModifiers = 0;
        this.captureAnim.update(this.now());
        this.keyAnim.update(this.now());
    }

    public int kind() {
        return 89;
    }

    public float minWidth() {
        return 16.0f;
    }

    @Override
    public float preferredWidth() {
        return 16.0f;
    }

    @Override
    public float preferredHeight() {
        return this.measuredHeight();
    }

    public float measuredHeight() {
        float lw = this.measureLabel(this.width);
        float vw = this.measureValue();
        if (0.0f < lw) {
            vw = vw + 0.0f + lw;
        }
        return vw + 6.0f + 32.0f;
    }

    public float measureLabel(float avail) {
        if (this.setting == null) {
            return 0.0f;
        }
        if (this.labelWidth == avail) {
            return this.labelWidthCache;
        }
        this.labelWidth = avail;
        this.labelWidthCache = HotkeyWidget.fontWidth(this.setting == null ? "" : this.setting.getName(), 12.0f);
        return this.labelWidthCache;
    }

    public float measureValue() {
        float avail = this.width - (this.kind() == 89 ? 0.0f : 20.0f);
        if (avail <= 0.0f) {
            avail = 0.0f;
        }
        if (this.valueWidth == avail) {
            return this.valueWidthCache;
        }
        this.valueWidth = avail;
        float measured = HotkeyWidget.fontWidth(this.keyLabel(), 12.0f);
        if (measured > avail) {
            measured = avail;
        }
        this.valueWidthCache = measured;
        return this.valueWidthCache;
    }

    public boolean capturing() {
        return this.capturing;
    }

    public Setting setting() {
        return this.setting;
    }

    public int key() {
        return this.boundKey;
    }

    @Override
    public void tick() {
        long time = this.now();
        this.captureAnim.update(time);
        this.keyAnim.update(time);
    }

    @Override
    public void render(Object renderer, float px, float py, float alpha) {
        boolean overBadge;
        boolean overLabel;
        float label = this.measureLabel(this.width);
        float value = this.measureValue();
        if (0.0f < value) {
            label = label + 0.0f + value;
        }
        float glyphX = px + 3.0f;
        float rowTop = label + py + 6.0f;
        float innerTop = rowTop + 3.0f;
        float sectionRight = px + this.width - 6.0f - 2.0f;
        float labelRight = sectionRight - 26.0f - 29.0f;
        boolean bl = overLabel = mouseX >= glyphX && mouseX <= labelRight && mouseY >= innerTop && mouseY <= innerTop + 26.0f;
        if (overLabel) {
            cursorStyle = 1;
        }
        float badgeX = px + this.width - 3.0f - 26.0f;
        float badgeY = value + py + 6.0f + 3.0f;
        boolean bl2 = overBadge = mouseX >= badgeX && mouseX <= badgeX + 26.0f && mouseY >= badgeY && mouseY <= badgeY + 26.0f;
        if (overBadge) {
            cursorStyle = 1;
        }
        HotkeyWidget.uiDrawBox(renderer, px, rowTop, this.width, 32.0f, 10.0f, 10.0f, 10.0f, 10.0f, HotkeyWidget.uiThemeColor(0), HotkeyWidget.uiThemeColor(0), 1.0f, 0, 0.0f, 1.0f, 0.0f, alpha, 0);
        this.renderKeyBadge(renderer, glyphX, badgeY, labelRight - glyphX, alpha);
        HotkeyWidget.uiDrawBox(renderer, badgeX, badgeY, 26.0f, 26.0f, 8.0f, 8.0f, 8.0f, 8.0f, HotkeyWidget.uiThemeColor(1), HotkeyWidget.uiThemeColor(1), 1.0f, 0, 0.0f, 1.0f, 0.0f, alpha, 0);
        float iconX = badgeX + 5.0f;
        float iconY = badgeY + 5.0f;
        long time = this.now();
        this.keyAnim.update(time);
        float pop = this.keyAnim.current;
        if (0.001f < pop && pop < 0.999f) {
            HotkeyWidget.uiDrawBox(renderer, iconX, iconY, 16.0f, 16.0f, (pop + pop) * (float)Math.PI, (pop + pop) * (float)Math.PI, (pop + pop) * (float)Math.PI, (pop + pop) * (float)Math.PI, 0, 0, 0.0f, HotkeyWidget.uiThemeColor(0), 1.0f, pop * alpha, 0.0f, alpha, 0);
        }
        HotkeyWidget.uiDrawIcon(renderer, 68, iconX, iconY, 16.0f, 16.0f, HotkeyWidget.uiThemeColor(0), alpha);
        this.height = rowTop + 32.0f - this.y;
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (this.capturing) {
            int key = 0;
            if (button != 0 || !this.badgeContains(mx, my)) {
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
        float label = this.measureLabel(this.width);
        float value = this.measureValue();
        if (0.0f < label) {
            value = value + 0.0f + label;
        }
        float badgeX = this.x + this.width - 3.0f - 26.0f;
        float badgeY = value + this.y + 6.0f + 3.0f;
        if (mx >= (double)badgeX && mx <= (double)(badgeX + 26.0f) && my >= (double)badgeY && my <= (double)(badgeY + 26.0f)) {
            if (this.boundKey != 0 || this.boundModifiers != 0) {
                this.boundKey = 0;
                this.boundModifiers = 0;
                this.applyKey();
            }
            this.capturing = false;
            this.pendingModifier = 0;
            long time = this.now();
            this.keyAnim.set(0.0f, 0.55f);
            this.keyAnim.retarget(1.0f, time);
            this.keyAnim.update(time);
            return true;
        }
        if (this.badgeContains(mx, my)) {
            this.capturing = true;
            this.pendingModifier = 0;
            return true;
        }
        return false;
    }

    public boolean badgeContains(double mx, double my) {
        float label = this.measureLabel(this.width);
        float value = this.measureValue();
        if (0.0f < label) {
            value = value + 0.0f + label;
        }
        float left = this.x + 3.0f;
        float right = this.x + this.width - 6.0f - 2.0f - 29.0f;
        float top = value + this.y + 6.0f + 3.0f;
        return mx >= (double)left && mx <= (double)right && my >= (double)top && my <= (double)(top + 26.0f);
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

    private void applyKey() {
        if (this.setting != null) {
            this.setting.setKey(this.boundKey);
        }
    }

    private String keyLabel() {
        if (this.boundKey == 0) {
            return "";
        }
        return HotkeyWidget.nameOf(this.boundKey);
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

    private void renderKeyBadge(Object renderer, float px, float py, float pw, float alpha) {
        String label = !this.capturing ? this.keyLabel() : "";
        if (label.isEmpty()) {
            return;
        }
        HotkeyWidget.uiDrawIcon(renderer, 0, px, py, pw, 0.0f, HotkeyWidget.uiThemeColor(0), alpha);
    }
}

