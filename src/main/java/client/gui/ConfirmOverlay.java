/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.AbstractOverlay;
import client.gui.Component;

public class ConfirmOverlay
extends AbstractOverlay {
    public static final long VTABLE_RVA = 12586552L;
    public static final long RVA_CTOR = 6576L;
    public static final long RVA_DTOR = 1167920L;
    public static final long RVA_DELETING_DTOR = 1167744L;
    public static final long RVA_RENDER_BODY = 1169056L;
    public static final long RVA_SHOW = 1168176L;
    public static final long RVA_LAYOUT = 1168768L;
    public static final long RVA_MOUSE_BODY = 0x11E010L;
    public static final long RVA_KEY_BODY = 1171792L;
    public static final long RVA_CONFIRM = 1171824L;
    public static final long RVA_DISPOSE = 1172080L;
    public static final long RVA_CHECKBOX_CTOR = 1207440L;
    public static final long RVA_CHECKBOX_RENDER = 1207904L;
    public static final long RVA_INIT_ANIM_022 = 10855280L;
    public static final long RVA_RECT = 696912L;
    public static final long RVA_MEASURE = 1773456L;
    public static final long RVA_DRAW_BG = 3483568L;
    public static final long RVA_DRAW_TEXT_CENTER = 3494400L;
    public static final long RVA_DRAW_TEXT_LEFT = 3497136L;
    public static final long RVA_DRAW_GLYPH = 3491616L;
    public static final int OFF_CANCEL_Y = 208;
    public static final int OFF_CANCEL_X = 212;
    public static final int OFF_ACCEPT_X = 216;
    public static final int OFF_BUTTON_HALF_WIDTH = 220;
    public static final int OFF_TITLE = 224;
    public static final int OFF_DESCRIPTION = 256;
    public static final int OFF_CALLBACK = 288;
    public static final int OFF_CHECKBOX = 352;
    public static final int OFF_CHECKBOX_CHECKED = 448;
    public static final int OFF_CANCEL_ANIM = 600;
    public static final int OFF_ACCEPT_ANIM = 640;
    public static final float SHOW_X = 320.0f;
    public static final float SHOW_Y_BASE = 40.0f;
    public static final float SHOW_Y_TEXT_SCALE = 14.4f;
    public static final float SHOW_Y_STEP_A = 12.0f;
    public static final float SHOW_Y_STEP_B = 16.0f;
    public static final float SHOW_Y_STEP_C = 12.0f;
    public static final float SHOW_Y_STEP_D = 32.0f;
    public static final float SHOW_Y_STEP_E = 16.0f;
    public static final float PAD = 16.0f;
    public static final float GAP = 8.0f;
    public static final float HALF = 0.5f;
    public static final float BUTTON_ROW_HEIGHT = 32.0f;
    public static final float LABEL_SIZE = 16.0f;
    public static final float DESCRIPTION_SIZE = 12.0f;
    public static final float BUTTON_TEXT_INSET = 2.0f;
    public static final float EMPTY = 0.0f;
    public static final String NOTE_LABEL = "\u041d\u0435 \u043f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0442\u044c \u0441\u043d\u043e\u0432\u0430";
    public static final String CANCEL_LABEL = "\u041d\u0430\u0437\u0430\u0434";
    public static final String ACCEPT_LABEL = "\u041e\u043a\u0435\u0439";
    protected String title = "";
    protected String description = "";
    protected float cancelY;
    protected float cancelX;
    protected float acceptX;
    protected float buttonHalfWidth;
    protected ConfirmCallback callback;
    protected boolean hovered;
    protected final CheckBoxButton noteCheckBox = new CheckBoxButton(false);
    protected final AbstractOverlay.Animator cancelAnim = new AbstractOverlay.Animator();
    protected final AbstractOverlay.Animator acceptAnim = new AbstractOverlay.Animator();
    protected static boolean handCursor;

    public ConfirmOverlay() {
        ConfirmOverlay.resetAnimator(this.cancelAnim, 0.0f, 0.15f, 0);
        ConfirmOverlay.resetAnimator(this.acceptAnim, 0.0f, 0.15f, 0);
        this.title = "";
        this.description = "";
        this.cancelY = 0.0f;
        this.cancelX = 0.0f;
        this.acceptX = 0.0f;
        this.buttonHalfWidth = 0.0f;
        this.callback = null;
        this.hovered = false;
    }

    public void show(String titleText, String descriptionText, ConfirmCallback handler) {
        this.title = titleText == null ? "" : titleText;
        this.description = descriptionText == null ? "" : descriptionText;
        this.callback = handler;
        ConfirmOverlay.resetAnimator(this.cancelAnim, 0.0f, 0.15f, 0);
        ConfirmOverlay.resetAnimator(this.acceptAnim, 0.0f, 0.15f, 0);
        if (this.hovered) {
            this.hovered = false;
            ConfirmOverlay.animate(this.cancelAnim, 0.0f);
            ConfirmOverlay.animate(this.acceptAnim, 0.0f);
        }
        this.x = 320.0f;
        this.y = OverlayDraw.measure(this.description, 12.0f) * 14.4f + 40.0f + 12.0f + 16.0f + 12.0f + 32.0f + 16.0f;
        this.layoutForScreen();
        this.activate();
    }

    public void layoutForScreen() {
        float screenWidth = OverlayDraw.measure(null, 0.0f);
        float screenHeight = OverlayDraw.measure(null, 0.0f);
        float scale = ConfirmOverlay.screenScale();
        float sx = (screenWidth / scale - this.width) * 0.5f;
        if (sx <= 0.0f) {
            sx = 0.0f;
        }
        this.x = Math.round(sx);
        float sy = (screenHeight / scale - this.height) * 0.5f;
        if (sy <= 0.0f) {
            sy = 0.0f;
        }
        this.y = Math.round(sy);
    }

    protected static float screenScale() {
        return 1.0f;
    }

    @Override
    public void renderBody(Object target, float rx, float ry, float parentAlpha) {
        this.layoutForScreen();
        float alphaScale = ConfirmOverlay.clamp01(parentAlpha);
        float top = (1.0f - alphaScale) * 16.0f + this.y;
        float boxX = this.x + this.width * 0.5f;
        float boxY = top + this.height * 0.5f;
        OverlayDraw.roundRect(target, this.x, top, this.width, this.height, parentAlpha, 0.0f, 0.0f);
        OverlayDraw.text(target, this.x + 16.0f, top + 16.0f, this.title, 16.0f, parentAlpha);
        OverlayDraw.text(target, this.x + 16.0f, top + 16.0f + 16.0f + 8.0f, this.description, 12.0f, parentAlpha);
        float halfWidth = (this.width - 32.0f) * 0.5f;
        float rowTop = top + this.height - 16.0f - 32.0f;
        this.cancelX = this.x + 16.0f;
        this.buttonHalfWidth = halfWidth;
        this.cancelY = rowTop;
        this.acceptX = halfWidth + this.cancelX + 8.0f;
        this.noteCheckBox.renderBody(target, this.cancelX, this.cancelY, parentAlpha);
        OverlayDraw.text(target, this.cancelX + 16.0f + 8.0f, this.cancelY + 2.0f, NOTE_LABEL, 12.0f, parentAlpha);
        boolean overCancel = ConfirmOverlay.inRect(rx, ry, this.cancelX, this.cancelY, this.buttonHalfWidth, 32.0f);
        boolean overAccept = ConfirmOverlay.inRect(rx, ry, this.acceptX, this.cancelY, this.buttonHalfWidth, 32.0f);
        if (overCancel || overAccept) {
            handCursor = true;
        }
        ConfirmOverlay.animate(this.cancelAnim, overCancel ? 1.0f : 0.0f);
        ConfirmOverlay.animate(this.acceptAnim, overAccept ? 1.0f : 0.0f);
        long time = this.now();
        float cancel = ConfirmOverlay.advance(this.cancelAnim, time);
        float accept = ConfirmOverlay.advance(this.acceptAnim, time);
        OverlayDraw.roundRect(target, this.cancelX, this.cancelY, this.buttonHalfWidth, 32.0f, parentAlpha, cancel, cancel);
        OverlayDraw.text(target, this.cancelX + 0.5f * this.buttonHalfWidth, this.cancelY + 16.0f, CANCEL_LABEL, 12.0f, parentAlpha);
        OverlayDraw.roundRect(target, this.acceptX, this.cancelY, this.buttonHalfWidth, 32.0f, parentAlpha, accept, accept);
        OverlayDraw.text(target, this.acceptX + 0.5f * this.buttonHalfWidth, this.cancelY + 16.0f, ACCEPT_LABEL, 12.0f, parentAlpha);
        OverlayDraw.glyph(target, boxX, boxY, 0.0f, 0.0f, parentAlpha);
    }

    private static boolean inRect(double mx, double my, float x, float y, float width, float height) {
        return mx >= (double)x && mx <= (double)(x + width) && my >= (double)y && my <= (double)(y + height);
    }

    @Override
    public boolean onMouseClicked(double mx, double my, int button) {
        if (button != 0) {
            return false;
        }
        if (ConfirmOverlay.inRect(mx, my, this.noteCheckBox.getX(), this.noteCheckBox.getY(), this.noteCheckBox.getWidth(), this.noteCheckBox.getHeight()) && this.noteCheckBox.hitTest(mx, my)) {
            return true;
        }
        if (ConfirmOverlay.inRect(mx, my, this.cancelX, this.cancelY, this.buttonHalfWidth, 32.0f)) {
            this.confirm();
            return true;
        }
        if (ConfirmOverlay.inRect(mx, my, this.acceptX, this.cancelY, this.buttonHalfWidth, 32.0f)) {
            this.close();
            return true;
        }
        return false;
    }

    @Override
    public boolean onKeyPressed(int keyCode, int modifiers) {
        if (keyCode != 13) {
            return false;
        }
        this.confirm();
        return true;
    }

    public void confirm() {
        ConfirmCallback handler = this.callback;
        this.callback = null;
        boolean value = this.noteCheckBox.checked;
        this.close();
        if (handler != null) {
            handler.invoke(value);
        }
    }

    @Override
    public void onDisposed() {
        this.callback = null;
        this.title = "";
        this.description = "";
    }

    public boolean noteRequested() {
        return this.noteCheckBox.checked;
    }

    public static boolean handCursor() {
        return handCursor;
    }

    public static final class CheckBoxButton
    extends Component {
        public static final long VTABLE_RVA = 12631168L;
        public static final long RVA_CTOR = 1207440L;
        public static final long RVA_RENDER = 1207904L;
        public static final int OFF_CHECKED = 96;
        public static final int OFF_FOCUS_ANIM = 168;
        public static final int OFF_FILL_ANIM = 208;
        public static final int OFF_HOVERED = 240;
        public static final float DEFAULT_SIZE = 16.0f;
        public static final float ANIM_DURATION = 0.22f;
        public boolean checked;
        public boolean hovered;
        public final AbstractOverlay.Animator focusAnim = new AbstractOverlay.Animator();
        public final AbstractOverlay.Animator fillAnim = new AbstractOverlay.Animator();

        public CheckBoxButton(boolean checked) {
            this.flags = 256;
            this.x = 0.0f;
            this.y = 0.0f;
            this.width = 0.0f;
            this.height = 0.0f;
            this.animXFrom = 0.0f;
            this.animXCurrent = 0.0f;
            this.animXTarget = 0.0f;
            this.animYFrom = 0.0f;
            this.animYCurrent = 0.0f;
            this.animYTarget = 0.0f;
            this.animatingPosition = false;
            this.animFrom = 0.0f;
            this.alpha = 0.0f;
            this.alphaTarget = 0.0f;
            this.alphaDuration = 0.15f;
            this.alphaStart = this.now();
            this.alphaRunning = false;
            this.checked = checked;
            this.width = 16.0f;
            this.height = 16.0f;
            float value = checked ? 1.0f : 0.0f;
            AbstractOverlay.resetAnimator(this.focusAnim, value, 0.22f, 0);
            AbstractOverlay.resetAnimator(this.fillAnim, value, 0.22f, 0);
            this.focusAnim.running = false;
            this.fillAnim.running = false;
            this.hovered = false;
        }

        @Override
        public boolean hitTest(double mx, double my) {
            return true;
        }

        public void renderBody(Object target, float rx, float ry, float parentAlpha) {
            if (this.contains(rx, ry)) {
                this.hovered = true;
            }
            long time = this.now();
            float fill = AbstractOverlay.advance(this.fillAnim, time);
            float focus = AbstractOverlay.advance(this.focusAnim, time);
            OverlayDraw.roundRect(target, this.x, this.y, this.width, this.height, parentAlpha, fill, focus);
            if (0.001f < focus) {
                OverlayDraw.glyph(target, this.x + (this.width - 8.0f) * 0.5f, this.y + (this.height - 8.0f) * 0.5f, 8.0f, 6.0f, focus * parentAlpha);
            }
        }
    }

    public static interface ConfirmCallback {
        public void invoke(boolean var1);
    }

    public static final class OverlayDraw {
        public static void roundRect(Object target, float x, float y, float width, float height, float parentAlpha, float fill, float border) {
        }

        public static void glyph(Object target, float x, float y, float width, float height, float alpha) {
        }

        public static void text(Object target, float x, float y, String text, float size, float alpha) {
        }

        public static float measure(String text, float size) {
            return 0.0f;
        }
    }
}

