/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.AbstractOverlay;
import client.gui.Component;
import client.gui.Screen;
import java.util.ArrayList;
import java.util.List;

public class SwapWheelModal
extends AbstractOverlay {
    public static final long VTABLE_RVA = 12610272L;
    public static final long RVA_CTOR = 1558896L;
    public static final long RVA_DTOR = 1657824L;
    public static final long RVA_RESET = 1657680L;
    public static final long RVA_KEY_PRESSED = 1656976L;
    public static final long RVA_KEY_RELEASED = 1657600L;
    public static final long RVA_SET_CHILD = 1658352L;
    public static final long RVA_IS_ACTIVE = 16128L;
    public static final long RVA_RENDER = 1658496L;
    public static final long RVA_MOUSE_CLICKED = 1670704L;
    public static final long RVA_ON_KEY_PRESSED = 1657280L;
    public static final long RVA_INIT_WHEEL_ANIMS = 1657648L;
    public static final long RVA_RENDER_HEADER = 1659824L;
    public static final long RVA_RENDER_SLOTS = 1660800L;
    public static final long RVA_RENDER_PANEL = 1663344L;
    public static final long RVA_RENDER_SLOT = 1666256L;
    public static final long RVA_RENDER_GRID_SLOT = 1665456L;
    public static final long RVA_RENDER_FOOTER = 1669888L;
    public static final long RVA_FETCH_ENTRY = 1672496L;
    public static final long RVA_DEFAULT_ENTRY = 0x199190L;
    public static final long RVA_APPLY_CAPTURE = 1657728L;
    public static final long RVA_COPY_ENTRY = 1658000L;
    public static final long RVA_CENTER = 1168768L;
    public static final int OFF_X = 8;
    public static final int OFF_Y = 12;
    public static final int OFF_WIDTH = 16;
    public static final int OFF_HEIGHT = 20;
    public static final int OFF_CLOSED = 136;
    public static final int OFF_CLOSE_OUTSIDE = 137;
    public static final int OFF_CLOSE_ESCAPE = 138;
    public static final int OFF_DETACHED = 139;
    public static final int OFF_CHILD = 200;
    public static final int OFF_SETTING = 208;
    public static final int OFF_SELECTED = 216;
    public static final int OFF_HOVER_INDEX = 220;
    public static final int OFF_HOVER_SLOT = 224;
    public static final int OFF_CAPTURE_INDEX = 228;
    public static final int OFF_CAPTURE_KEY = 232;
    public static final int OFF_PANEL_ANIMS = 240;
    public static final int OFF_GRID_ANIMS = 1440;
    public static final int OFF_CLOSE_ANIM = 2880;
    public static final int OFF_HEADER_ANIM = 2920;
    public static final int OFF_CLEAR_ANIM = 2960;
    public static final int GROUP_STRIDE = 200;
    public static final int OFF_GROUP_HOVER = 0;
    public static final int OFF_GROUP_ITEM = 40;
    public static final int OFF_GROUP_ACTION = 80;
    public static final int OFF_GROUP_BIND = 120;
    public static final int OFF_GROUP_KEY = 160;
    public static final int ANIM_BASE = 240;
    public static final int ANIM_STRIDE = 40;
    public static final int ANIM_COUNT = 69;
    public static final int ANIM_GRID_BASE = 1440;
    public static final int GRID_ANIM_COUNT = 36;
    public static final int SLOT_COUNT = 6;
    public static final int GRID_SLOTS = 27;
    public static final int GRID_ROWS = 9;
    public static final int GRID_ROW_START = 9;
    public static final int GRID_ROW_END = 36;
    public static final int CHARGE_ON_CHANGE = 224;
    public static final int CHARGE_KEY = 232;
    public static final int CHARGE_MODS = 236;
    public static final int ITEM_TAG = 16;
    public static final float PAD = 16.0f;
    public static final float RADIUS = 12.0f;
    public static final float ONE = 1.0f;
    public static final float HALF = 0.5f;
    public static final float F2 = 2.0f;
    public static final float F4 = 4.0f;
    public static final float F5 = 5.0f;
    public static final float F6 = 6.0f;
    public static final float F7 = 7.0f;
    public static final float F8 = 8.0f;
    public static final float F10 = 10.0f;
    public static final float F12 = 12.0f;
    public static final float F14 = 14.0f;
    public static final float F16 = 16.0f;
    public static final float F18 = 18.0f;
    public static final float F20 = 20.0f;
    public static final float F24 = 24.0f;
    public static final float F26 = 26.0f;
    public static final float F28 = 28.0f;
    public static final float F30 = 30.0f;
    public static final float F31 = 31.0f;
    public static final float F38 = 38.0f;
    public static final float F40 = 40.0f;
    public static final float F48 = 48.0f;
    public static final float F59 = 59.0f;
    public static final float F70 = 70.0f;
    public static final float F78 = 78.0f;
    public static final float F92 = 92.0f;
    public static final float F93 = 93.0f;
    public static final float F100 = 100.0f;
    public static final float F156 = 156.0f;
    public static final float F200 = 200.0f;
    public static final float F204 = 204.0f;
    public static final float F220 = 220.0f;
    public static final float F226 = 226.0f;
    public static final float F254 = 254.0f;
    public static final float F302 = 302.0f;
    public static final float WHEEL_WIDTH = 812.0f;
    public static final float WHEEL_HEIGHT = 310.0f;
    public static final float EPS = 0.001f;
    public static final float ALPHA_EPS = 0.999f;
    public static final float F0_85 = 0.85f;
    public static final float F0_7 = 0.7f;
    public static final float F0_35 = 0.35f;
    public static final float TAU = (float)Math.PI * 2;
    public static final float PI = (float)Math.PI;
    public static final float ANGLE_STEP = 0.02f;
    public static final float INV_SLOT_STEP = 0.0063661975f;
    public static final float F1_7 = 1.7f;
    public static final float ANIM_DURATION = 0.15f;
    public static final float PANEL_DURATION = 0.55f;
    public static final float BIND_DURATION = 0.28f;
    public static final int THEME_PRIMARY = 0;
    public static final int THEME_BORDER = 4;
    public static final int THEME_SECONDARY = 8;
    public static final int THEME_PANEL = 12;
    public static final int THEME_TEXT = 16;
    public static final int THEME_ACCENT = 20;
    public static final int THEME_MUTED = 24;
    private static final String BIND_PREFIX = "\u042f\u0447\u0435\u0439\u043a\u0430 ";
    private static final String EMPTY_SLOT = "\u042f\u0447\u0435\u0439\u043a\u0430 \u043f\u0443\u0441\u0442\u0430\u044f \u2014 \u0434\u043e\u0431\u0430\u0432\u044c\u0442\u0435 \u043f\u0440\u0435\u0434\u043c\u0435\u0442 \u0438\u0437 \u0438\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044f";
    private static final String CLEAR_LABEL = "\u041e\u0447\u0438\u0441\u0442\u0438\u0442\u044c \u0432\u044b\u0431\u0440\u0430\u043d\u043d\u0443\u044e \u044f\u0447\u0435\u0439\u043a\u0443";
    private static final String LEFT_HAND_LABEL = "\u0412 \u043b\u0435\u0432\u043e\u0439 \u0440\u0443\u043a\u0435";
    private static final String NONE_LABEL = "None";
    private static final String DOTS_LABEL = "...";
    protected ItemWheel setting;
    protected int selectedIndex;
    protected int hoverIndex = -1;
    protected int hoverSlot = -1;
    protected int captureIndex = -1;
    protected int captureKey;
    protected final AbstractOverlay.Animator[] anims = new AbstractOverlay.Animator[69];
    protected final float[] layout = new float[6];

    public SwapWheelModal(ItemWheel setting) {
        int i;
        this.setting = setting;
        this.selectedIndex = 0;
        this.hoverIndex = -1;
        this.hoverSlot = -1;
        this.captureIndex = -1;
        this.captureKey = 0;
        for (i = 0; i < this.anims.length; ++i) {
            this.anims[i] = new AbstractOverlay.Animator();
        }
        this.initWheelAnims();
        for (i = 0; i < 36; ++i) {
            SwapWheelModal.resetAnimator(this.animAt(1440 + i * 40), 0.0f, 0.15f, 0);
        }
        SwapWheelModal.resetAnimator(this.animAt(2880), 0.0f, 0.15f, 0);
        SwapWheelModal.resetAnimator(this.animAt(2920), 0.0f, 0.15f, 0);
        SwapWheelModal.resetAnimator(this.animAt(2960), 0.0f, 0.15f, 0);
        this.width = 812.0f;
        this.height = 310.0f;
        this.closeOnOutsideClick = true;
        this.closeOnEscape = true;
    }

    protected AbstractOverlay.Animator animAt(int offset) {
        return this.anims[(offset - 240) / 40];
    }

    protected AbstractOverlay.Animator gridAnim(int index) {
        return this.animAt(1440 + index * 40);
    }

    protected void initWheelAnims() {
        int base = 240;
        SwapWheelModal.resetAnimator(this.animAt(base + 0), 0.0f, 0.15f, 0);
        SwapWheelModal.resetAnimator(this.animAt(base + 40), 0.0f, 0.15f, 0);
        SwapWheelModal.resetAnimator(this.animAt(base + 80), 0.0f, 0.15f, 0);
        SwapWheelModal.resetAnimator(this.animAt(base + 120), 0.0f, 0.55f, 0);
        SwapWheelModal.resetAnimator(this.animAt(base + 160), 0.0f, 0.15f, 0);
        SwapWheelModal.resetAnimator(this.animAt(base + 200), 0.0f, 0.15f, 0);
        SwapWheelModal.resetAnimator(this.animAt(base + 240), 0.0f, 0.15f, 0);
        SwapWheelModal.resetAnimator(this.animAt(base + 320), 0.0f, 0.55f, 0);
        SwapWheelModal.resetAnimator(this.animAt(base + 360), 0.0f, 0.15f, 0);
        SwapWheelModal.resetAnimator(this.animAt(base + 400), 0.0f, 0.15f, 0);
        SwapWheelModal.resetAnimator(this.animAt(base + 440), 0.0f, 0.15f, 0);
        SwapWheelModal.resetAnimator(this.animAt(base + 520), 0.0f, 0.55f, 0);
        SwapWheelModal.resetAnimator(this.animAt(base + 560), 0.0f, 0.15f, 0);
        SwapWheelModal.resetAnimator(this.animAt(base + 600), 0.0f, 0.15f, 0);
        SwapWheelModal.resetAnimator(this.animAt(base + 640), 0.0f, 0.15f, 0);
        SwapWheelModal.resetAnimator(this.animAt(base + 720), 0.0f, 0.55f, 0);
        SwapWheelModal.resetAnimator(this.animAt(base + 760), 0.0f, 0.15f, 0);
        SwapWheelModal.resetAnimator(this.animAt(base + 800), 0.0f, 0.15f, 0);
        SwapWheelModal.resetAnimator(this.animAt(base + 840), 0.0f, 0.15f, 0);
        SwapWheelModal.resetAnimator(this.animAt(base + 920), 0.0f, 0.55f, 0);
        SwapWheelModal.resetAnimator(this.animAt(base + 960), 0.0f, 0.15f, 0);
        SwapWheelModal.resetAnimator(this.animAt(base + 1000), 0.0f, 0.15f, 0);
        SwapWheelModal.resetAnimator(this.animAt(base + 1040), 0.0f, 0.15f, 0);
        SwapWheelModal.resetAnimator(this.animAt(base + 1120), 0.0f, 0.55f, 0);
        SwapWheelModal.resetAnimator(this.animAt(base + 1160), 0.0f, 0.15f, 0);
    }

    @Override
    public void reset() {
        super.reset();
        this.captureKey = 0;
        this.captureIndex = -1;
    }

    @Override
    public void dispose() {
        if (this.child != null) {
            this.child = null;
        }
        this.children.clear();
        this.capture = null;
    }

    @Override
    public void setChild(Component value) {
        this.width = 812.0f;
        this.height = 310.0f;
        if (this.setting.slotCount() <= this.selectedIndex) {
            this.selectedIndex = 0;
        }
        this.captureIndex = -1;
        this.captureKey = 0;
        this.centerOnScreen();
        this.activate();
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public boolean keyPressed(int keyCode, int modifiers) {
        int index = this.captureIndex;
        if (index < 0) {
            if (this.closeOnEscape && keyCode == 27) {
                this.close();
                return true;
            }
            return this.onKeyPressed(keyCode, modifiers);
        }
        if (keyCode == 27 || keyCode == 46) {
            Charge charge;
            if (index < 6 && (charge = this.setting.chargeAt(index)) != null && (charge.key != 0 || charge.mods != 0)) {
                charge.key = 0;
                charge.mods = 0;
                if (charge.onChange != null) {
                    charge.onChange.run();
                }
            }
        } else {
            Charge charge;
            if (keyCode - 16 < 3 || keyCode - 160 < 6) {
                this.captureKey = keyCode;
                return true;
            }
            if (index < 6 && (charge = this.setting.chargeAt(index)) != null && (charge.key != keyCode || charge.mods != modifiers)) {
                charge.key = keyCode;
                charge.mods = modifiers;
                if (charge.onChange != null) {
                    charge.onChange.run();
                }
            }
        }
        this.captureKey = 0;
        this.captureIndex = -1;
        return true;
    }

    @Override
    public boolean keyReleased(int keyCode) {
        int bound;
        if (this.captureIndex >= 0 && (bound = this.captureKey) != 0 && keyCode == bound) {
            this.applyCapture(this.captureIndex, bound, 0);
            this.captureIndex = -1;
            this.captureKey = 0;
            return true;
        }
        return false;
    }

    @Override
    public boolean onKeyPressed(int keyCode, int modifiers) {
        int index = this.captureIndex;
        if (index < 0) {
            int digit = keyCode - 49;
            if (digit < 9 && digit < this.setting.slotCount()) {
                this.selectedIndex = digit;
                return true;
            }
            if (keyCode != 46 && keyCode != 8) {
                return false;
            }
            this.setting.selectSlot(this.selectedIndex);
            return true;
        }
        Charge charge = null;
        if (keyCode == 27 || keyCode == 46) {
            if (index > 5) {
                this.captureIndex = -1;
                this.captureKey = 0;
                return true;
            }
            charge = this.setting.chargeAt(index);
            if (charge == null || charge.key == 0 && charge.mods == 0) {
                this.captureIndex = -1;
                this.captureKey = 0;
                return true;
            }
            charge.key = 0;
            charge.mods = 0;
        } else {
            if (keyCode - 16 < 3 || keyCode - 160 < 6) {
                this.captureKey = keyCode;
                return true;
            }
            if (index > 5) {
                this.captureIndex = -1;
                this.captureKey = 0;
                return true;
            }
            charge = this.setting.chargeAt(index);
            if (charge == null || charge.key == keyCode && charge.mods == modifiers) {
                this.captureIndex = -1;
                this.captureKey = 0;
                return true;
            }
            charge.key = keyCode;
            charge.mods = modifiers;
        }
        if (charge.onChange != null) {
            charge.onChange.run();
        }
        this.captureIndex = -1;
        this.captureKey = 0;
        return true;
    }

    protected void applyCapture(int index, int keyCode, int modifiers) {
        Charge charge;
        if (index >= 0 && index < 6 && (charge = this.setting.chargeAt(index)) != null && (charge.key != keyCode || charge.mods != modifiers)) {
            charge.key = keyCode;
            charge.mods = modifiers;
            if (charge.onChange != null) {
                charge.onChange.run();
            }
        }
    }

    protected void centerOnScreen() {
        float fx = (SwapWheelModal.screenWidth() / SwapWheelModal.screenScale() - this.width) * 0.5f;
        if (fx <= 0.0f) {
            fx = 0.0f;
        }
        this.x = Math.round(fx);
        float fy = (SwapWheelModal.screenHeight() / SwapWheelModal.screenScale() - this.height) * 0.5f;
        if (fy <= 0.0f) {
            fy = 0.0f;
        }
        this.y = Math.round(fy);
    }

    @Override
    public void renderBody(Object target, float px, float py, float parentAlpha) {
        int slotCount = this.setting.slotCount();
        if (slotCount <= this.selectedIndex) {
            this.selectedIndex = 0;
        }
        this.centerOnScreen();
        float source = parentAlpha;
        if (this.captureIndex >= 0) {
            Screen.textInputActive = true;
        }
        float top = (1.0f - SwapWheelModal.clamp01(source)) * 16.0f + this.y;
        Object rect = SwapWheelModal.makeRect(new Object(), target, source, this.width * 0.5f + this.x, this.height * 0.5f + top);
        int themePrimary = SwapWheelModal.themeColor(0);
        int themePanel = SwapWheelModal.themeColor(12);
        SwapWheelModal.drawPanel(rect, this.x, top, this.width, this.height, 12.0f, 12.0f, 12.0f, 12.0f, themePrimary, themePanel, 1.0f, 0x1A000000, 0, 2.0f, 6.0f, source, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        this.renderHeader(target, rect, top, px, py, source);
        float pad = 14.0f;
        float rowTop = top + 40.0f + 14.0f;
        float left = this.x + 14.0f;
        float panelTop = rowTop + 10.0f;
        this.renderSlots(target, rect, left, panelTop, px, py, slotCount, source);
        left = left + 200.0f + pad;
        this.renderPanel(target, rect, left, panelTop, px, py, source);
        float right = left + 302.0f + pad;
        float laterTop = rowTop + 0.0f;
        int themeSecondary = SwapWheelModal.themeColor(8);
        themePanel = SwapWheelModal.themeColor(12);
        SwapWheelModal.drawPanel(rect, right, laterTop, 254.0f, 204.0f, 8.0f, 8.0f, 8.0f, 8.0f, themeSecondary, themePanel, 1.0f, 0, 0, 0.0f, 0.0f, source, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        float rowStep = 30.0f;
        int slotIndex = 0;
        do {
            this.renderSlot(target, rect, slotIndex, right + 14.0f, (float)slotIndex * rowStep + laterTop + 14.0f, slotIndex < slotCount, px, py, source);
        } while (++slotIndex < 6);
        this.renderFooter(target, rect, top, px, py, source);
        if (this.hoverSlot >= 0 && this.hoverSlot < slotCount || this.hoverIndex >= 0) {
            Screen.hoveredWidget = 1;
        }
    }

    protected void renderHeader(Object target, Object rect, float top, float mouseX, float mouseY, float alpha) {
        float hoverTarget;
        SwapWheelModal.themeColor(0);
        SwapWheelModal.themeColor(12);
        float one = 1.0f;
        float titleY = this.y + 12.0f;
        float titleX = this.x + 14.0f;
        SwapWheelModal.drawIcon(target, 47, titleX, titleY + 1.0f, 14.0f, 14.0f, SwapWheelModal.themeColor(24), alpha);
        SwapWheelModal.drawText(4, target, this.setting.name(), titleX + 14.0f + 8.0f, titleY, 16.0f, SwapWheelModal.themeColor(24), alpha);
        float pad = 20.0f;
        float f10 = 10.0f;
        float closeTop = this.y + 10.0f;
        float closeLeft = this.x + this.width - 14.0f - 20.0f;
        if (closeLeft > mouseX || closeLeft + 20.0f < mouseX || closeTop > mouseY || closeTop + 20.0f < mouseY || AbstractOverlay.activeOverlay != null && !Screen.allowHover) {
            hoverTarget = 0.0f;
        } else {
            Screen.hoveredWidget = 1;
            hoverTarget = one;
        }
        AbstractOverlay.Animator anim = this.animAt(2920);
        if (anim.target != hoverTarget) {
            SwapWheelModal.animate(anim, hoverTarget);
        }
        float eased = SwapWheelModal.advance(anim, this.now());
        int color = SwapWheelModal.uiLerpColor(SwapWheelModal.themeColor(8), SwapWheelModal.themeColor(12), eased);
        SwapWheelModal.drawBox(target, closeLeft, closeTop, 20.0f, 20.0f, 6.0f, 6.0f, 6.0f, 6.0f, color, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, alpha, 0);
        SwapWheelModal.drawIcon(target, 22, closeLeft + 5.0f, closeTop + 6.0f, 10.0f, 10.0f, SwapWheelModal.themeColor(24), alpha);
        SwapWheelModal.drawBoxGradient(target, this.x + 14.0f, this.y + 40.0f, this.width - 28.0f, 1.0f, 0.0f, SwapWheelModal.themeColor(12), alpha);
    }

    protected void renderSlots(Object target, Object rect, float left, float top, float mouseX, float mouseY, int slotCount, float alpha) {
        float count;
        float radius;
        SwapWheelModal.themeColor(0);
        SwapWheelModal.themeColor(12);
        float one = 1.0f;
        SwapWheelModal.drawBox(target, left, top, 200.0f, 200.0f, 6.0f, 6.0f, 6.0f, 6.0f, SwapWheelModal.themeColor(0), SwapWheelModal.themeColor(12), 1.0f, 0, 0.0f, 0.0f, 0.0f, alpha, 0);
        float ring = 78.0f;
        float centerX = left + 100.0f;
        float centerY = this.y + 40.0f + 14.0f + 10.0f + 92.0f;
        float clamped = alpha;
        if (clamped < 0.0f) {
            clamped = 0.0f;
        }
        if (clamped > 1.0f) {
            clamped = 1.0f;
        }
        this.layout[0] = radius = (1.0f - clamped) * 16.0f + centerY;
        this.layout[1] = centerX;
        this.hoverSlot = this.hitWheel(mouseX - centerX, mouseY - centerY, 40.0f, ring);
        if (slotCount <= 0) {
            return;
        }
        this.layout[5] = count = (float)slotCount;
        this.layout[4] = SwapWheelModal.negate(radius);
        this.layout[2] = SwapWheelModal.negate(centerX);
        float spanY = radius - ring;
        float spanX = centerX - ring;
        int index = 0;
        do {
            AbstractOverlay.Animator anim = this.animAt(240 + index * 200);
            int selected = this.selectedIndex;
            float slotTarget = 1.0f;
            if (index != this.hoverSlot && index != selected) {
                slotTarget = 0.0f;
            }
            if (anim.target != slotTarget) {
                SwapWheelModal.animate(anim, slotTarget);
            }
            float scale = 0.7f;
            float blend = 0.35f;
            if (index == selected) {
                SwapWheelModal.themeColor(16);
                scale = 0.35f;
            } else {
                SwapWheelModal.themeColor(16);
            }
            float hovered = SwapWheelModal.advance(anim, this.now());
            SwapWheelModal.themeColor(20);
            float amount = hovered * scale;
            if (0.0f < amount && amount < 1.0f) {
                int steps = 0;
                while ((steps += 8) < 32) {
                }
            }
            float angle = (float)index * ((float)Math.PI * 2) / count + 0.02f;
            float cos = (float)Math.cos(angle);
            float sin = (float)Math.sin(angle);
            float rx = SwapWheelModal.rectX(rect);
            float ry = SwapWheelModal.rectY(rect);
            float rw = SwapWheelModal.rectWidth(rect);
            float rh = SwapWheelModal.rectHeight(rect);
            float extra = SwapWheelModal.rectExtra(rect);
            float m0 = rx * cos + sin * rw;
            float m1 = ry * cos + sin * rh;
            float m2 = cos * rw - rx * sin;
            float m3 = cos * rh - ry * sin;
            float tx = this.layout[4] * m3 + this.layout[2] * m1 + rh * this.layout[0] + ry * this.layout[1] + extra;
            float ty = this.layout[4] * m2 + this.layout[2] * m0 + rw * this.layout[0] + rx * centerX + SwapWheelModal.rectExtraLow(rect);
            SwapWheelModal.transformQuad(target, m0, m1, m2, m3, ty, tx, spanX, spanY, 156.0f);
        } while (++index < slotCount);
        float step = (float)Math.PI / count;
        int label = 1;
        do {
            float angle = (float)(label - 1) * ((float)Math.PI * 2) / count + step;
            float sin = (float)Math.sin(angle);
            float labelY = sin * 59.0f + centerX;
            float cos = (float)Math.cos(angle);
            float labelX = cos * 59.0f + centerX;
            Object slot = this.setting.slotAt(label - 1);
            if (slot == null || SwapWheelModal.slotTag(slot) == null) {
                SwapWheelModal.drawText(2, target, Integer.toString(label), labelY - 8.0f);
                continue;
            }
            SwapWheelModal.drawText(2, target, slot, labelY - 8.0f, labelX - 8.0f, 8.0f, SwapWheelModal.themeColor(16), alpha);
        } while (++label <= slotCount);
    }

    protected int hitWheel(float dx, float dy, float inner, float outer) {
        float distance = (float)Math.sqrt(dx * dx + dy * dy);
        if (distance < inner || outer < distance) {
            return -1;
        }
        return SwapWheelModal.clampSlot((int)((float)Math.atan2(dy, dx) / ((float)Math.PI * 2) * 6.0f));
    }

    protected static int clampSlot(int value) {
        return value;
    }

    protected void renderPanel(Object target, Object rect, float left, float top, float mouseX, float mouseY, float alpha) {
        float eased;
        SwapWheelModal.themeColor(0);
        SwapWheelModal.themeColor(12);
        SwapWheelModal.drawBox(target, left, top, 226.0f, 200.0f, 6.0f, 6.0f, 6.0f, 6.0f, SwapWheelModal.themeColor(0), SwapWheelModal.themeColor(12), 1.0f, 0, 0.0f, 0.0f, 0.0f, alpha, 0);
        left += 14.0f;
        top += 14.0f;
        List<WheelEntry> items = this.setting.itemList();
        int count = items.size();
        this.hoverIndex = -1;
        int index = 9;
        int cursor = 9;
        while (index < 36) {
            int column = (index - 9) / 9;
            int row = (index - 9) % 9;
            WheelEntry entry = cursor < count ? items.get(cursor) : null;
            float cellX = (float)row * 31.0f + left;
            float cellY = (float)column * 31.0f + top;
            this.renderGridSlot(target, rect, index, entry, cellX, cellY, mouseX, mouseY, alpha);
            ++index;
            ++cursor;
        }
        float lowerTop = top + 93.0f + 26.0f;
        index = 0;
        do {
            WheelEntry entry = index < count ? items.get(index) : null;
            this.renderGridSlot(target, rect, index, entry, (float)index * 31.0f + left, lowerTop, mouseX, mouseY, alpha);
        } while (++index < 9);
        float finish = lowerTop + 8.0f + 26.0f + 8.0f;
        WheelEntry placeholder = this.defaultEntry();
        float hoverTarget = 0.0f;
        if (!(left > mouseX || left + 26.0f < mouseX || finish > mouseY || finish + 26.0f < mouseY || AbstractOverlay.activeOverlay != null && !Screen.allowHover)) {
            this.hoverIndex = 40;
            hoverTarget = 1.0f;
        }
        AbstractOverlay.Animator anim = this.animAt(2880);
        if (anim.target != hoverTarget) {
            SwapWheelModal.animate(anim, hoverTarget);
        }
        if (0.0f < (eased = SwapWheelModal.advance(anim, this.now()) * 0.7f) && eased < 1.0f) {
            int steps = 0;
            while ((steps += 8) < 32) {
            }
        }
        if (placeholder != null) {
            SwapWheelModal.transformEntry(target, SwapWheelModal.transformMatrix(placeholder), left + 5.0f, finish + 5.0f);
            SwapWheelModal.drawEntryIcon(target, placeholder, left, finish);
        }
        SwapWheelModal.drawText(2, target, EMPTY_SLOT, left + 26.0f + 10.0f);
    }

    protected void renderGridSlot(Object target, Object rect, int index, WheelEntry entry, float cellX, float cellY, float mouseX, float mouseY, float alpha) {
        float hoverTarget;
        float size = 26.0f;
        float one = 1.0f;
        if (cellX > mouseX || cellX + 26.0f < mouseX || cellY > mouseY || cellY + 26.0f < mouseY || AbstractOverlay.activeOverlay != null && !Screen.allowHover) {
            hoverTarget = 0.0f;
        } else {
            this.hoverIndex = index;
            hoverTarget = one;
        }
        AbstractOverlay.Animator anim = this.gridAnim(index);
        if (anim.target != hoverTarget) {
            SwapWheelModal.animate(anim, hoverTarget);
        }
        float hovered = SwapWheelModal.advance(anim, this.now()) * 0.7f;
        int color = SwapWheelModal.uiLerpColor(SwapWheelModal.themeColor(4), SwapWheelModal.themeColor(12), hovered);
        SwapWheelModal.drawBox(target, cellX, cellY, 26.0f, 26.0f, 6.0f, 6.0f, 6.0f, 6.0f, color, SwapWheelModal.themeColor(12), 1.0f, 0, 0.0f, 0.0f, 0.0f, alpha, 0);
        if (entry != null && SwapWheelModal.slotTag(entry) != null) {
            SwapWheelModal.transformEntry(target, SwapWheelModal.transformMatrix(entry), cellX + 5.0f, cellY + 5.0f);
            SwapWheelModal.drawEntryIcon(target, entry, cellX, cellY);
        }
    }

    protected void renderSlot(Object target, Object rect, int index, float left, float top, boolean usable, float mouseX, float mouseY, float alpha) {
        float actionTarget;
        SwapWheelModal.themeColor(0);
        float edge = 8.0f;
        float panelWidth = 226.0f;
        SwapWheelModal.drawPanel(rect, left, top, 226.0f, 200.0f, 6.0f, 6.0f, 6.0f, 6.0f, SwapWheelModal.themeColor(0), SwapWheelModal.themeColor(12), 1.0f, 0, 0, 0.0f, 0.0f, alpha, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        float iconX = left + 8.0f;
        float iconY = top + 5.0f;
        float iconSize;
        WheelEntry entry = this.setting.itemAt(index);
        if (!usable || entry == null || SwapWheelModal.slotTag(entry) == null) {
            SwapWheelModal.themeColor(0);
            iconSize = 16.0f;
            SwapWheelModal.drawIcon(target, 33, iconX, iconY);
            if (!usable) {
                SwapWheelModal.themeColor(0);
            } else {
                if (iconX <= mouseX && mouseX <= iconX + iconSize && iconY <= mouseY && mouseY <= iconY + iconSize && (AbstractOverlay.activeOverlay == null || Screen.allowHover)) {
                    SwapWheelModal.showTooltip(EMPTY_SLOT);
                }
                SwapWheelModal.themeColor(0);
            }
            this.drawSlotLabel(target, rect, index, iconX, iconY, iconSize, alpha);
        } else {
            iconX = left + 8.0f;
            iconSize = 16.0f;
            SwapWheelModal.drawIcon(target, 33, iconX, iconY);
            SwapWheelModal.drawIcon(target, 68, left + 8.0f, top + 5.0f);
            this.drawSlotLabel(target, rect, index, left + 8.0f, iconY, 16.0f, alpha);
        }
        AbstractOverlay.Animator itemAnim = this.animAt(280 + index * 200);
        float itemTarget = 1.0f;
        float itemHover = itemAnim.target;
        if (index != this.hoverSlot) {
            itemTarget = 0.0f;
        }
        if (itemHover != itemTarget) {
            SwapWheelModal.animate(itemAnim, itemTarget);
        }
        AbstractOverlay.Animator actionAnim = this.animAt(320 + index * 200);
        float f = actionTarget = usable ? 1.0f : 0.0f;
        if (actionAnim.target != actionTarget) {
            SwapWheelModal.animate(actionAnim, actionTarget);
        }
        float action = SwapWheelModal.advance(actionAnim, this.now());
        float actionX = left + 226.0f - 8.0f - 20.0f;
        float actionY = left + this.width - 8.0f - 20.0f;
        if (this.hoverTest(actionX, actionY, mouseX, mouseY)) {
            Screen.hoveredWidget = 1;
        }
        SwapWheelModal.drawIcon(target, 68, actionX, actionY);
    }

    protected void drawSlotLabel(Object target, Object rect, int index, float iconX, float iconY, float iconSize, float alpha) {
        float labelX = iconX + iconSize + 6.0f;
        String label = BIND_PREFIX + (index + 1);
        SwapWheelModal.drawText(2, target, label, labelX);
    }

    protected void renderFooter(Object target, Object rect, float top, float mouseX, float mouseY, float alpha) {
        float hoverTarget;
        float lineTop = top + this.height - 38.0f;
        SwapWheelModal.drawBoxGradient(target, this.x + 14.0f, lineTop, this.width - 28.0f, 1.0f, 0.0f, SwapWheelModal.themeColor(12), alpha);
        float buttonTop = lineTop + 7.0f;
        float buttonLeft = (this.width - 220.0f) * 0.5f + this.x;
        if (buttonLeft > mouseX || buttonLeft + 220.0f < mouseX || buttonTop > mouseY || buttonTop + 24.0f < mouseY || AbstractOverlay.activeOverlay != null && !Screen.allowHover) {
            hoverTarget = 0.0f;
        } else {
            Screen.hoveredWidget = 1;
            hoverTarget = 1.0f;
        }
        AbstractOverlay.Animator anim = this.animAt(2960);
        if (anim.target != hoverTarget) {
            SwapWheelModal.animate(anim, hoverTarget);
        }
        float eased = SwapWheelModal.advance(anim, this.now());
        int color = SwapWheelModal.uiLerpColor(SwapWheelModal.themeColor(8), SwapWheelModal.themeColor(12), eased);
        SwapWheelModal.drawBox(target, buttonLeft, buttonTop, 220.0f, 24.0f, 6.0f, 6.0f, 6.0f, 6.0f, color, SwapWheelModal.themeColor(12), 1.0f, 0, 0.0f, 0.0f, 0.0f, alpha, 0);
        SwapWheelModal.drawIcon(target, 32, buttonLeft + 10.0f, buttonTop + 6.0f, 12.0f, 12.0f, SwapWheelModal.themeColor(24), alpha);
        SwapWheelModal.drawText(2, target, CLEAR_LABEL, buttonLeft + 28.0f, buttonTop + 6.0f, 18.0f, SwapWheelModal.themeColor(24), alpha);
    }

    protected boolean hoverTest(float left, float top, float mouseX, float mouseY) {
        return left <= mouseX && mouseX <= left + 20.0f && top <= mouseY && mouseY <= top + 20.0f && (AbstractOverlay.activeOverlay == null || Screen.allowHover);
    }

    protected WheelEntry fetchEntry() {
        List<WheelEntry> items = this.setting.itemList();
        int index = this.selectedIndex;
        if (index < 0 || items.size() <= index) {
            return this.defaultEntry();
        }
        return items.get(index);
    }

    protected WheelEntry defaultEntry() {
        WheelEntry entry = new WheelEntry();
        entry.nameA = NONE_LABEL;
        entry.nameB = DOTS_LABEL;
        entry.nameC = "";
        entry.nameD = "";
        entry.key = -1;
        entry.flag = 0;
        return entry;
    }

    @Override
    public boolean onMouseClicked(double mx, double my, int button) {
        Charge charge;
        int mode = 0;
        ItemWheel wheel = this.setting;
        int slotCount = wheel.slotCount();
        int captured = this.captureIndex;
        if (captured < 0) {
            float baseX = this.x;
            float baseY = this.y;
            float column = baseX + 14.0f + 200.0f + 14.0f + 302.0f + 14.0f + 14.0f + 226.0f - 8.0f - 20.0f;
            float wide = column - 4.0f - 70.0f;
            for (int index = 0; index < 6; ++index) {
                Charge charge2;
                float rowTop = (float)index * 30.0f + baseY + 40.0f + 14.0f + 0.0f + 14.0f + 4.0f;
                if ((double)wide <= mx && mx <= (double)(wide + 70.0f) && (double)rowTop <= my && my <= (double)(rowTop + 18.0f)) {
                    mode = 1;
                } else {
                    if (!((double)column <= mx) || !(mx <= (double)(column + 20.0f)) || !((double)rowTop <= my) || !(my <= (double)(rowTop + 18.0f))) continue;
                    mode = 2;
                }
                if (index < 0 || index >= slotCount || button != 0) break;
                if (mode == 1) {
                    this.captureIndex = index;
                    this.captureKey = 0;
                    return true;
                }
                if (mode != 2) break;
                if (index < 6 && (charge2 = wheel.chargeAt(index)) != null) {
                    SwapWheelModal.beginKeyCapture();
                }
                AbstractOverlay.Animator anim = this.animAt(360 + index * 200);
                anim.from = 0.0f;
                anim.current = 0.0f;
                anim.target = 0.0f;
                anim.running = false;
                SwapWheelModal.animate(anim, 1.0f);
                return true;
            }
            float closeTop = baseY + 10.0f;
            float closeLeft = baseX + this.width - 14.0f - 20.0f;
            if (button != 0 || mx < (double)closeLeft || (double)(closeLeft + 20.0f) < mx || my < (double)closeTop || (double)(closeTop + 20.0f) < my) {
                int hover = this.hoverSlot;
                if (hover < 0 || slotCount <= hover) {
                    if (button == 0 && this.hoverIndex >= 0) {
                        WheelEntry source = this.hoverIndex != 40 ? this.fetchEntry() : this.defaultEntry();
                        WheelEntry entry = this.copyEntry(source);
                        if (entry.nameA.length() != 0) {
                            ItemWheel owner = this.setting;
                            int target = this.selectedIndex;
                            if (target < 6) {
                                owner.setItem(target, entry);
                                if (owner.onSlotChange != null) {
                                    owner.onSlotChange.run();
                                }
                            }
                            this.selectedIndex = (this.selectedIndex + 1) % slotCount;
                        }
                        return true;
                    }
                } else {
                    if (button == 0) {
                        this.selectedIndex = hover;
                        return true;
                    }
                    if (button == 1) {
                        wheel.selectSlot(this.selectedIndex);
                        return true;
                    }
                }
                float clearLeft = (this.width - 220.0f) * 0.5f + baseX;
                float clearTop = baseY + this.height - 38.0f + 7.0f;
                if (button != 0 || mx < (double)clearLeft || (double)(clearLeft + 220.0f) < mx || my < (double)clearTop || (double)(clearTop + 24.0f) < my) {
                    return !(mx < (double)baseX || (double)(baseX + this.width) < mx || my < (double)baseY) && !((double)(baseY + this.height) < my);
                }
                wheel.selectSlot(this.selectedIndex);
                return true;
            }
            this.close();
            return true;
        }
        if (captured < 6 && (charge = wheel.chargeAt(captured)) != null) {
            int state = 0;
            if (button == 0) {
                state = 1;
            } else if (button == 1) {
                state = 2;
            } else if (button == 2) {
                state = 4;
            } else if (button == 3) {
                state = 5;
            } else if (button == 4) {
                state = 6;
            }
            if (charge.key != state || charge.mods != 0) {
                charge.key = state;
                charge.mods = 0;
                if (charge.onChange != null) {
                    charge.onChange.run();
                }
            }
        }
        this.captureIndex = -1;
        this.captureKey = 0;
        return true;
    }

    protected WheelEntry copyEntry(WheelEntry source) {
        WheelEntry out = new WheelEntry();
        out.nameA = source.nameA;
        out.nameB = source.nameB;
        out.key = source.key;
        out.nameC = source.nameC;
        out.nameD = source.nameD;
        out.flag = source.flag;
        return out;
    }

    protected static float negate(float value) {
        return value == 0.0f ? 0.0f : -value;
    }

    protected static float rectX(Object rect) {
        return 0.0f;
    }

    protected static float rectY(Object rect) {
        return 0.0f;
    }

    protected static float rectWidth(Object rect) {
        return 0.0f;
    }

    protected static float rectHeight(Object rect) {
        return 0.0f;
    }

    protected static float rectExtra(Object rect) {
        return 0.0f;
    }

    protected static float rectExtraLow(Object rect) {
        return 0.0f;
    }

    protected static Object slotTag(Object slot) {
        return slot;
    }

    protected static Object slotTag(WheelEntry entry) {
        return entry.nameA;
    }

    protected static Object transformMatrix(Object slot) {
        return slot;
    }

    protected static void transformQuad(Object target, float m0, float m1, float m2, float m3, float tx, float ty, float left, float top, float size) {
    }

    protected static void transformEntry(Object target, Object matrix, float px, float py) {
    }

    protected static void drawEntryIcon(Object target, Object entry, float px, float py) {
    }

    protected static void showTooltip(String text) {
    }

    protected static void beginKeyCapture() {
    }

    protected static float screenWidth() {
        return 0.0f;
    }

    protected static float screenHeight() {
        return 0.0f;
    }

    protected static float screenScale() {
        return 1.0f;
    }

    protected static int themeColor(int index) {
        return 0;
    }

    protected static void drawPanel(Object rect, float px, float py, float pw, float ph, float r1, float r2, float r3, float r4, int colorA, int colorB, float alpha1, int border, int borderWidth, float cornerSpread, float thickness, float alpha2, int z1, int z2, int z3, int z4, int z5, int z6, int z7, int z8, int z9, int z10, int z11, int z12, int z13) {
    }

    protected static void drawBox(Object target, float px, float py, float pw, float ph, float r1, float r2, float r3, float r4, int fillTop, int fillBottom, float fillAlpha, int border, float borderWidth, float borderAlpha, float shadowAlpha, float alpha, int flags) {
    }

    protected static void drawBoxGradient(Object target, float px, float py, float pw, float ph, float f1, int color, float alpha) {
    }

    protected static void drawText(int mode, Object target, Object text, float px) {
    }

    protected static void drawText(int mode, Object target, Object text, float px, float py, float size, int color, float alpha) {
    }

    protected static void drawIcon(Object target, int icon, float px, float py) {
    }

    protected static void drawIcon(Object target, int icon, float px, float py, float pw, float ph, int color, float alpha) {
    }

    protected static float measureText(Object target, Object text, float size) {
        return 0.0f;
    }

    protected static Object makeRect(Object out, Object target, float alpha, float px, float py) {
        return out;
    }

    protected static void setScissor(float px, float py, float pw, float ph) {
    }

    protected static void resetScissor() {
    }

    public static class ItemWheel {
        public static final int OFF_NAME = 1104;
        public static final int OFF_NAME_LEN = 1120;
        public static final int OFF_CHARGES = 1048;
        public static final int OFF_SLOT_COUNT = 1096;
        public static final int OFF_ITEMS = 232;
        public static final int OFF_ITEM_STRIDE = 136;
        public Runnable onSlotChange;
        private final List<Charge> charges = new ArrayList<Charge>();
        private final List<WheelEntry> items = new ArrayList<WheelEntry>();
        private final List<WheelEntry> slots = new ArrayList<WheelEntry>();

        public int slotCount() {
            return this.items.size();
        }

        public String name() {
            return "";
        }

        public Charge chargeAt(int index) {
            if (index < 0 || index >= 6) {
                return null;
            }
            while (this.charges.size() <= index) {
                this.charges.add(new Charge());
            }
            return this.charges.get(index);
        }

        public WheelEntry itemAt(int index) {
            if (index < 0 || index >= this.items.size()) {
                return null;
            }
            return this.items.get(index);
        }

        public Object slotAt(int index) {
            if (index < 0 || index >= this.items.size()) {
                return null;
            }
            return this.items.get(index);
        }

        public void setItem(int index, WheelEntry entry) {
        }

        public void selectSlot(int index) {
        }

        public List<WheelEntry> itemList() {
            return this.items;
        }
    }

    public static class Charge {
        public static final int OFF_ON_CHANGE = 224;
        public static final int OFF_KEY = 232;
        public static final int OFF_MODS = 236;
        public Runnable onChange;
        public int key;
        public int mods;
    }

    public static class WheelEntry {
        public static final int OFF_NAME_A = 0;
        public static final int OFF_NAME_B = 32;
        public static final int OFF_KEY = 64;
        public static final int OFF_NAME_C = 72;
        public static final int OFF_NAME_D = 104;
        public static final int OFF_TAG = 16;
        public static final int OFF_FLAG = 136;
        public String nameA = "";
        public String nameB = "";
        public int key;
        public String nameC = "";
        public String nameD = "";
        public int flag;
    }
}

