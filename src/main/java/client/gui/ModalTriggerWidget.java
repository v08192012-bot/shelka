/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.Setting;
import client.gui.Screen;
import client.gui.SettingWidget;

public class ModalTriggerWidget
extends SettingWidget {
    public static final int VTABLE_RVA = 12609512;
    public static final int MODAL_OFFSET = 128;
    public static final int FRAME_OFFSET = 136;
    public static final int MODAL_EMBED_OFFSET = 176;
    public static final int HOVER_ANIM_OFFSET = 136;
    public static final int HOVER_TARGET_OFFSET = 144;
    public static final int HOVER_STAMP_OFFSET = 160;
    public static final int HOVER_ACTIVE_OFFSET = 168;
    public static final float LABEL_GAP = 6.0f;
    public static final float TRIGGER_HEIGHT = 32.0f;
    public static final float HOVER_SPEED = 0.15f;
    public static final float MODAL_OPEN_EPSILON = 0.001f;
    public static final int TRIGGER_KEY = 89;
    public static final float TRIGGER_SPACING_X = 16.0f;
    public static final float TRIGGER_SPACING_Y = 16.0f;
    protected Object modal = null;
    protected float hoverAnim = 0.0f;
    protected float hoverTarget = 0.0f;
    protected long hoverStamp = 0L;
    protected boolean hoverActive = false;

    public ModalTriggerWidget() {
    }

    public ModalTriggerWidget(Setting setting) {
        super(setting);
    }

    @Override
    public void render(Object mat, float mouseX, float mouseY, float alpha) {
        float labelHeight = SettingWidget.measureTextHeight(mat, this.setting, this.width, alpha);
        float extra = SettingWidget.measureExtraHeight(mat, labelHeight, this.width);
        float labelY = this.labelY(labelHeight, extra);
        float target = 0.0f;
        if (this.x <= mouseX && mouseX <= this.x + this.width && labelY <= mouseY && mouseY <= labelY + 32.0f && (Screen.focusedWidget == null || Screen.allowHover)) {
            Screen.hoveredWidget = 1;
            target = 1.0f;
        }
        float bottom = labelY + 32.0f;
        if (this.hoverTarget != target) {
            this.hoverTarget = target;
            this.hoverStamp = Screen.tick();
            this.hoverActive = true;
        }
        float reveal = this.advanceHover(Screen.tick());
        Object action = this.openAction();
        Object title = this.title();
        ModalTriggerWidget.drawModalTrigger(mat, this.x, labelY, this.width, title, action, reveal, alpha);
        this.height = bottom - this.y;
    }

    public float labelY() {
        return this.labelY(0.0f, 0.0f);
    }

    private float labelY(float labelHeight, float extra) {
        float h = labelHeight;
        if (extra > 0.0f) {
            h = h + 0.0f + extra;
        }
        return h + this.y + 6.0f;
    }

    private float advanceHover(long now) {
        if (!this.hoverActive) {
            return this.hoverAnim;
        }
        float k = (float)((double)(now - this.hoverStamp) / 1.0E9 / (double)0.15f);
        if (k <= 0.0f) {
            this.hoverAnim = this.hoverTarget;
            return this.hoverAnim;
        }
        if (k >= 1.0f) {
            this.hoverActive = false;
            this.hoverAnim = this.hoverTarget;
            return this.hoverAnim;
        }
        this.hoverAnim = Screen.easeOutCubic(k) * (this.hoverTarget - this.hoverAnim) + this.hoverAnim;
        return this.hoverAnim;
    }

    @Override
    public void layout(Object mat, float x, float y, float alpha) {
        if (!this.isVisible()) {
            return;
        }
        if (!this.modalOpen()) {
            return;
        }
        this.renderModal(mat, x, y, alpha);
    }

    @Override
    public void closeModal() {
        if (!this.isVisible()) {
            return;
        }
        if (!this.modalOpen()) {
            return;
        }
        this.hideModal();
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (!this.isVisible()) {
            return false;
        }
        if (!this.modalOpen()) {
            if (button == 0) {
                float w = this.width;
                float top = this.labelY();
                if ((double)this.x <= mx && mx <= (double)(this.x + w) && (double)top <= my && my <= (double)(top + 32.0f)) {
                    this.invokeModalSlot(184, this.positionProvider());
                    return true;
                }
            }
            return false;
        }
        return this.forwardMouseClicked(mx, my, button);
    }

    @Override
    public boolean mouseReleased(double mx, double my, int button) {
        if (!this.isVisible()) {
            return false;
        }
        if (!this.modalOpen()) {
            return false;
        }
        return this.forwardMouseEvent(40, mx, my, button);
    }

    @Override
    public boolean mouseDragged(double mx, double my, int button) {
        if (!this.isVisible()) {
            return false;
        }
        if (!this.modalOpen()) {
            return false;
        }
        return this.forwardMouseEvent(48, mx, my, button);
    }

    @Override
    public boolean mouseScrolled(double mx, double my, double amount) {
        if (!this.isVisible()) {
            return false;
        }
        if (!this.modalOpen()) {
            return false;
        }
        return this.forwardMouseEvent(56, mx, my, amount);
    }

    @Override
    public boolean keyPressed(int key) {
        if (!this.isVisible()) {
            return false;
        }
        if (!this.modalOpen()) {
            return false;
        }
        return this.forwardKey(64, key);
    }

    @Override
    public boolean charTyped(int codePoint) {
        if (!this.isVisible()) {
            return false;
        }
        if (!this.modalOpen()) {
            return false;
        }
        return this.forwardKey(80, codePoint);
    }

    @Override
    public float contentHeight() {
        float a = SettingWidget.measureTextHeight(null, null, this.width, 0.0f);
        float b = this.contentBaseHeight();
        if (a > 0.0f) {
            b = b + 0.0f + a;
        }
        return b + 6.0f + 32.0f;
    }

    @Override
    public boolean isOpen() {
        return this.isVisible() && this.modalOpen();
    }

    public boolean modalOpen() {
        if (!this.isVisible()) {
            return false;
        }
        return this.modalWidth() > 0.001f || this.modalHeight() > 0.001f;
    }

    public boolean modalContainsPoint(double mx, double my) {
        if (!this.isVisible()) {
            return false;
        }
        if (!this.modalOpen()) {
            return false;
        }
        return (double)this.modalX() <= mx && mx <= (double)(this.modalX() + this.modalWidth()) && (double)this.modalY() <= my && my <= (double)(this.modalY() + this.modalHeight());
    }

    public void onTriggered() {
        if (!this.isVisible()) {
            return;
        }
        if (!this.modalOpen()) {
            this.invokeModalSlot(184, this.positionProvider());
        }
    }

    public Object positionProvider() {
        return null;
    }

    public Object openAction() {
        return null;
    }

    public Object title() {
        return null;
    }

    public int triggerKey() {
        return 89;
    }

    public void reset(Object callback) {
    }

    public float spacingX() {
        return 16.0f;
    }

    public float spacingY() {
        return 16.0f;
    }

    @Override
    public boolean isVisible() {
        return false;
    }

    protected float contentBaseHeight() {
        return 0.0f;
    }

    protected float modalX() {
        return 0.0f;
    }

    protected float modalY() {
        return 0.0f;
    }

    protected float modalWidth() {
        return 0.0f;
    }

    protected float modalHeight() {
        return 0.0f;
    }

    protected void renderModal(Object mat, float x, float y, float alpha) {
    }

    protected void hideModal() {
    }

    protected Object invokeModalSlot(int byteOffset, Object ... args) {
        return null;
    }

    protected boolean forwardMouseClicked(double mx, double my, int button) {
        Object m = this.modal;
        if (m == null) {
            return false;
        }
        return ModalTriggerWidget.invokeModalSlotDefault(m, mx, my, button);
    }

    protected boolean forwardMouseEvent(int byteOffset, double mx, double my, double value) {
        Object m = this.modal;
        if (m == null) {
            return false;
        }
        return ModalTriggerWidget.invokeModalSlotDefault(m, mx, my, value);
    }

    protected boolean forwardKey(int byteOffset, int key) {
        Object m = this.modal;
        if (m == null) {
            return false;
        }
        return ModalTriggerWidget.invokeModalSlotDefault(m, key);
    }

    private static boolean invokeModalSlotDefault(Object m, Object ... args) {
        return false;
    }

    private static void drawModalTrigger(Object mat, float x, float y, float width, Object title, Object action, float reveal, float alpha) {
    }
}

