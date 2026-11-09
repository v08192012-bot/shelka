/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.AbstractOverlay;
import client.gui.Component;
import client.gui.ModuleCard;

public class PartySettingsPopup
extends AbstractOverlay {
    public static final long VTABLE_RVA = 12613112L;
    public static final long RVA_CTOR = 2735201385376L;
    public static final long RVA_DTOR = 2735200816544L;
    public static final long RVA_MOUSE_CLICKED = 2735201396272L;
    public static final long RVA_MOUSE_RELEASED = 2735201396448L;
    public static final long RVA_MOUSE_MOVED = 2735201396464L;
    public static final long RVA_MOUSE_SCROLLED = 2735201396480L;
    public static final long RVA_KEY_PRESSED = 2735201396512L;
    public static final long RVA_KEY_RELEASED = 2735201396624L;
    public static final long RVA_CHAR_TYPED = 2735201396640L;
    public static final long RVA_OVERLAY_CONST = 2735201395872L;
    public static final long RVA_SET_CHILD = 2735201395712L;
    public static final long RVA_RENDER_BODY = 2735201395888L;
    public static final long RVA_ON_MOUSE_CLICKED = 2735201396416L;
    public static final long RVA_ON_CLOSED = 2735201396656L;
    public static final long RVA_CARD_CTOR = 2735200901440L;
    public static final long RVA_CARD_DTOR = 2735200816960L;
    public static final long RVA_CARD_PREFERRED_HEIGHT = 2735200906624L;
    public static final long RVA_CARD_TARGET_HEIGHT = 2735200907024L;
    public static final long RVA_CARD_LAYOUT_HEADER = 2735200907264L;
    public static final long RVA_CARD_RENDER = 2735200903024L;
    public static final long RVA_CARD_LAYOUT = 2735200906096L;
    public static final long RVA_CARD_ACCEPTS_MOUSE = 2735200913152L;
    public static final long RVA_CARD_MOUSE_CLICKED = 2735200910272L;
    public static final long RVA_CARD_MOUSE_RELEASED = 2735200911312L;
    public static final long RVA_CARD_MOUSE_DRAGGED = 2735200911616L;
    public static final long RVA_CARD_MOUSE_SCROLLED = 2735200912000L;
    public static final long RVA_CARD_KEY_PRESSED = 2735200912320L;
    public static final long RVA_CARD_KEY_RELEASED = 2735200912608L;
    public static final long RVA_CARD_CHAR_TYPED = 2735200912896L;
    public static final int OFF_CARD = 208;
    public static final int OFF_CARD_X = 216;
    public static final int OFF_CARD_Y = 220;
    public static final int OFF_CARD_WIDTH = 224;
    public static final int OFF_CARD_HEIGHT = 228;
    public static final int OFF_CARD_CHILD_WIDTH = 1296;
    public static final int ROW_SLOT_EXPANDED = 14;
    public static final int ROW_SLOT_COLLAPSE = 15;
    public static final float CARD_WIDTH = 305.0f;
    public static final float EPSILON = 0.001f;
    public static final float HALF = 0.5f;
    public static final float ALPHA_SHIFT = 16.0f;
    public static final float OVERLAY_METRIC = 14.0f;
    public static final float EMPTY = 0.0f;
    public static final float FULL_ALPHA = 1.0f;
    protected ModuleCard card;

    public PartySettingsPopup(Object feature) {
        this.card = new ModuleCard(feature);
        this.width = 305.0f;
        if (0.001f < Math.abs(this.card.width - 305.0f)) {
            this.card.width = 305.0f;
            this.card.cachedChildWidth = Float.NaN;
        }
    }

    @Override
    public float overlayConst() {
        return 14.0f;
    }

    @Override
    public void setChild(Component value) {
        this.height = PartySettingsPopup.cardTargetHeight(this.card);
        super.setChild(value);
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (!PartySettingsPopup.cardAcceptsMouse(this.card)) {
            return super.mouseClicked(mx, my, button);
        }
        if (!this.closed) {
            this.card.mouseClicked(mx, my, button);
        }
        return true;
    }

    @Override
    public boolean mouseReleased(double mx, double my, int button) {
        this.card.mouseReleased(mx, my, button);
        return true;
    }

    @Override
    public boolean mouseMoved(double mx, double my, double delta) {
        return this.card.mouseDragged(mx, my, (int)delta, 0.0, 0.0);
    }

    @Override
    public boolean mouseScrolled(double mx, double my, double amount) {
        this.card.mouseScrolled(mx, my, amount);
        return true;
    }

    @Override
    public boolean keyPressed(int keyCode, int modifiers) {
        if (!this.card.keyPressed(keyCode)) {
            if (!this.closeOnEscape || keyCode != 27) {
                return this.onKeyPressed(keyCode, modifiers);
            }
            this.close();
        }
        return true;
    }

    @Override
    public boolean keyReleased(int keyCode) {
        this.card.keyReleased(keyCode);
        return true;
    }

    @Override
    public boolean charTyped(char ch) {
        this.card.charTyped(ch);
        return true;
    }

    @Override
    public void renderBody(Object target, float rx, float ry, float parentAlpha) {
        float cardHeight = PartySettingsPopup.cardPreferredHeight(this.card);
        float clamped = PartySettingsPopup.clamp01(parentAlpha);
        float top = (1.0f - clamped) * 16.0f + this.y;
        this.height = cardHeight;
        Object rect = OverlayDraw.makeRect(target, parentAlpha, this.width * 0.5f + this.x, cardHeight * 0.5f + top);
        this.card.x = this.x;
        this.card.y = top;
        PartySettingsPopup.cardLayoutHeader(this.card);
        this.card.render(rect, rx, ry, parentAlpha);
        this.card.layout(target, rx, ry, parentAlpha);
    }

    @Override
    public boolean onMouseClicked(double mx, double my, int button) {
        this.card.mouseClicked(mx, my, button);
        return true;
    }

    @Override
    public void onClosed() {
        for (Component child : this.card.ownedChildren) {
            if (!PartySettingsPopup.isExpanded(child)) continue;
            PartySettingsPopup.collapse(child);
        }
    }

    @Override
    public void dispose() {
        this.card = null;
        super.dispose();
    }

    public ModuleCard card() {
        return this.card;
    }

    private static boolean isExpanded(Component child) {
        return false;
    }

    private static void collapse(Component child) {
    }

    private static boolean cardAcceptsMouse(ModuleCard value) {
        return false;
    }

    private static float cardTargetHeight(ModuleCard value) {
        return 0.0f;
    }

    private static float cardPreferredHeight(ModuleCard value) {
        return 0.0f;
    }

    private static void cardLayoutHeader(ModuleCard value) {
    }

    private static final class OverlayDraw {
        private OverlayDraw() {
        }

        public static Object makeRect(Object target, float alpha, float centerX, float centerY) {
            return null;
        }
    }
}

