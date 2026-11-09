/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.Component;
import client.gui.KeysPanel;

public class ConfigDetailsCard
extends Component {
    public static final long VTABLE_RVA = 12591368L;
    public static final long RVA_CTOR = 2735200932304L;
    public static final long RVA_CTOR_ABSTRACT_OVERLAY = 2735200850112L;
    public static final long RVA_DTOR = 2735200933184L;
    public static final long RVA_RENDER = 2735200849408L;
    public static final long RVA_RENDER_DETAILS = 2735200933744L;
    public static final long RVA_MOUSE_CLICKED = 2735200937728L;
    public static final long RVA_ON_BODY_CLICKED = 2735200937824L;
    public static final long RVA_MOUSE_RELEASED = 2735200939200L;
    public static final long RVA_MOUSE_MOVED = 2735200938832L;
    public static final long RVA_MOUSE_SCROLLED = 2735200938384L;
    public static final long RVA_KEY_PRESSED = 2735200850016L;
    public static final long RVA_CLOSE_KEYS = 2735200938352L;
    public static final long RVA_ON_CLOSE = 2735200933664L;
    public static final long RVA_RESET_STATE = 2735200933712L;
    public static final long RVA_BASE_MOUSE_CLICKED = 2735200849840L;
    public static final long RVA_KEYS_PANEL_CTOR = 2735201014800L;
    public static final long RVA_KEYS_PANEL_OPEN = 2735201016096L;
    public static final long RVA_KEYS_PANEL_MOUSE_CLICKED = 2735201025328L;
    public static final long RVA_WIDGET_CTOR = 2735200890000L;
    public static final long RVA_WIDGET_CALLBACK = 2735200900960L;
    public static final long RVA_ANIM_INIT_F = 2735200856400L;
    public static final long RVA_ANIM_INIT = 2735200260240L;
    public static final long RVA_ANIM_SET = 2735200831376L;
    public static final long RVA_ANIM_VALUE = 2735200831600L;
    public static final long RVA_LIST_TOP = 2735201017968L;
    public static final long RVA_MAX_SCROLL = 2735201018096L;
    public static final long RVA_HIT_RECT = 2735200779200L;
    public static final long RVA_HIT_RECT_4F = 2735200779104L;
    public static final long RVA_TEXT_COPY = 2735199757296L;
    public static final long RVA_NOW = 2735199714128L;
    public static final int OFF_X = 8;
    public static final int OFF_Y = 12;
    public static final int OFF_WIDTH = 16;
    public static final int OFF_HEIGHT = 20;
    public static final int OFF_FLAGS = 24;
    public static final int OFF_RECT_ANIM = 32;
    public static final int OFF_ANIM_X = 72;
    public static final int OFF_ANIM_Y = 80;
    public static final int OFF_ANIMATING = 88;
    public static final int OFF_OPEN_ANIM = 96;
    public static final int OFF_OPEN_FROM = 104;
    public static final int OFF_OPEN_VFN = 112;
    public static final int OFF_OPEN_TIME = 120;
    public static final int OFF_OPEN_RUNNING = 128;
    public static final int OFF_OVERLAY_FLAGS = 136;
    public static final int OFF_HOST = 200;
    public static final int OFF_CONFIG = 208;
    public static final int OFF_CONFIG_CTRL = 216;
    public static final int OFF_HEADER_WIDGET_A = 224;
    public static final int OFF_FLAG_140 = 320;
    public static final int OFF_HEADER_WIDGET_B = 472;
    public static final int OFF_FLAG_238 = 568;
    public static final int OFF_HEADER_WIDGET_C = 720;
    public static final int OFF_KEYS_PANEL = 968;
    public static final int OFF_KEYS_OPEN = 1121;
    public static final int OFF_TOGGLE_ANIM_A = 1576;
    public static final int OFF_TOGGLE_TARGET_A = 1584;
    public static final int OFF_TOGGLE_RUNNING_A = 1608;
    public static final int OFF_TOGGLE_ANIM_B = 1616;
    public static final int OFF_TOGGLE_TARGET_B = 1624;
    public static final int OFF_TOGGLE_RUNNING_B = 1648;
    public static final int OFF_ROW_ANIM = 1656;
    public static final int OFF_SLOT_6D8 = 1752;
    public static final int OFF_SLOT_718 = 1816;
    public static final int OFF_SHARE_CALLBACK = 1880;
    public static final int OFF_SLOT_798 = 1944;
    public static final int OFF_ANCHOR_X = 1952;
    public static final int OFF_ANCHOR_Y = 1956;
    public static final int OFF_ANCHOR_W = 1960;
    public static final int OFF_ANCHOR_H = 1964;
    public static final int OFF_KEYS_X = 976;
    public static final int OFF_KEYS_Y = 980;
    public static final int OFF_KEYS_W = 984;
    public static final int OFF_KEYS_H = 988;
    public static final int OFF_KEYS_ROWS = 1480;
    public static final int OFF_KEYS_ROWS_END = 1488;
    public static final int OFF_KEYS_SCROLL = 1560;
    public static final int OFF_KEYS_DRAGGING = 1569;
    public static final int OFF_KEYS_DRAG_OFFSET = 1572;
    public static final int OFF_CONFIG_HAS_KEYS = 96;
    public static final int OFF_CONFIG_HAS_EXTRA = 97;
    public static final int OFF_CONFIG_PENDING = 98;
    public static final int OFF_WIDGET_X = 8;
    public static final int OFF_WIDGET_Y = 12;
    public static final int OFF_WIDGET_W = 16;
    public static final int OFF_WIDGET_H = 20;
    public static final int OFF_WIDGET_ANIM = 96;
    public static final float CARD_WIDTH = 300.0f;
    public static final float HALF = 0.5f;
    public static final float ONE = 1.0f;
    public static final float PAD = 12.0f;
    public static final float GAP = 4.0f;
    public static final float GAP6 = 6.0f;
    public static final float HEADER_BLOCK = 32.0f;
    public static final float LIST_WIDTH = 252.0f;
    public static final float HEIGHT_288 = 288.0f;
    public static final float SCROLL_STEP = 24.0f;
    public static final float SCROLLBAR_WIDTH = 40.0f;
    public static final int CLOSE_KEY = 27;
    public static final int WIDGET_CLICK_SLOT = 12;
    private ConfigInfo config;
    private float openAnim = -1.0f;
    private float openFrom;
    private long openTime;
    private boolean openRunning;
    private boolean overlayClosed;
    private boolean closeOnOutside = true;
    private boolean closeOnEscape = true;
    private Component host;
    private HeaderWidget headerA;
    private HeaderWidget headerB;
    private HeaderWidget headerC;
    private boolean hasKeysMark;
    private boolean hasExtraMark;
    private boolean keysOpen;
    private boolean keysDragging;
    private float keysDragOffset;
    private float sliderAnimA;
    private float sliderTargetA;
    private boolean sliderRunningA;
    private float sliderAnimB;
    private float sliderTargetB;
    private boolean sliderRunningB;
    private float rowAnim;
    private float anchorX;
    private float anchorY;
    private float anchorW;
    private float anchorH;
    private final KeysPanel keysPanel;
    private final float[] rowAnimator = new float[9];
    private Runnable shareCallback;
    private int cursorShape;

    public ConfigDetailsCard() {
        this(null);
    }

    public ConfigDetailsCard(ConfigInfo info) {
        this.config = info;
        this.width = 300.0f;
        this.flags = 256;
        this.headerA = new HeaderWidget(info != null && info.hasKeys);
        this.headerB = new HeaderWidget(info != null && info.hasExtra);
        this.headerC = new HeaderWidget(false);
        this.hasKeysMark = info != null && info.hasKeys;
        this.hasExtraMark = info != null && info.hasExtra;
        this.keysPanel = new KeysPanel(info == null ? "" : info.name);
        this.openAnim = -1.0f;
        this.openFrom = -1.0f;
        this.openRunning = false;
        this.overlayClosed = false;
        this.closeOnOutside = true;
        this.closeOnEscape = true;
        this.sliderTargetA = this.sliderAnimA = info != null && info.hasKeys ? 1.0f : 0.5f;
        this.sliderRunningA = false;
        this.sliderTargetB = this.sliderAnimB = info != null && info.hasExtra ? 1.0f : 0.5f;
        this.sliderRunningB = false;
        this.rowAnim = 0.0f;
        this.keysOpen = false;
        this.keysDragging = false;
        this.keysDragOffset = 0.0f;
        this.anchorX = 0.0f;
        this.anchorY = 0.0f;
        this.anchorW = 0.0f;
        this.anchorH = 0.0f;
        this.headerA.setOnClick(this::onHeaderA);
        this.headerB.setOnClick(this::onHeaderB);
        this.headerC.setOnClick(this::onHeaderC);
    }

    private void onHeaderA() {
    }

    private void onHeaderB() {
    }

    private void onHeaderC() {
    }

    public ConfigInfo config() {
        return this.config;
    }

    public KeysPanel keysPanel() {
        return this.keysPanel;
    }

    public HeaderWidget headerA() {
        return this.headerA;
    }

    public HeaderWidget headerB() {
        return this.headerB;
    }

    public HeaderWidget headerC() {
        return this.headerC;
    }

    public boolean isKeysOpen() {
        return this.keysOpen;
    }

    public boolean isKeysDragging() {
        return this.keysDragging;
    }

    public int cursor() {
        return this.cursorShape;
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void tick() {
        this.updateOpenAnim(this.now());
    }

    @Override
    public void render() {
        this.renderDetails(null, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    private void renderDetails(Object matrix, float a, float b, float c, float scale) {
        float targetA = 0.5f;
        if (this.config != null && this.config.hasKeys) {
            targetA = 1.0f;
        }
        if (this.sliderTargetA != targetA) {
            this.sliderAnimA = this.sliderAnimA;
            this.sliderTargetA = targetA;
            this.sliderRunningA = true;
        }
        float targetB = 0.5f;
        if (this.config != null && this.config.hasExtra) {
            targetB = 1.0f;
        }
        if (this.sliderTargetB != targetB) {
            this.sliderAnimB = this.sliderAnimB;
            this.sliderTargetB = targetB;
            this.sliderRunningB = true;
        }
        if (this.rowAnimator[2] != this.rowAnim) {
            this.rowAnimator[0] = this.rowAnimatorValue();
            this.rowAnimator[2] = this.rowAnim;
            this.rowAnimator[6] = this.now();
            this.rowAnimator[8] = 1.0f;
        }
        this.renderBody(matrix, a, b, c, scale);
    }

    private float rowAnimatorValue() {
        return this.rowAnimator[2];
    }

    private void renderBody(Object matrix, float a, float b, float c, float scale) {
    }

    private void updateOpenAnim(long time) {
        if (!this.openRunning) {
            return;
        }
        float t = (float)((double)(time - this.openTime) / 1.0E9);
        if (t >= 1.0f) {
            this.openRunning = false;
            this.openAnim = this.openFrom;
        }
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (this.keysOpen) {
            float kx = this.keysPanel.getX();
            float ky = this.keysPanel.getY();
            if ((double)kx <= mx && mx <= (double)(kx + this.keysPanel.getWidth()) && (double)ky <= my && my <= (double)(ky + this.keysPanel.getHeight())) {
                return this.onBodyClicked(mx, my, button);
            }
        }
        return this.baseMouseClicked(mx, my, button);
    }

    private boolean baseMouseClicked(double mx, double my, int button) {
        if (this.host != null) {
            this.x = this.host.getX();
            this.y = this.host.getY();
        }
        if (button == 0 && this.closeOnOutside && !this.hitRect(mx, my)) {
            this.onClose();
            return true;
        }
        return this.onBodyClicked(mx, my, button);
    }

    private boolean isOverlayOpen() {
        return !this.overlayClosed;
    }

    private boolean hitRect(double mx, double my) {
        return mx >= (double)this.x && mx <= (double)(this.x + this.width) && my >= (double)this.y && my <= (double)(this.y + this.height);
    }

    @Override
    public boolean mouseReleased(double mx, double my, int button) {
        if (this.keysOpen && this.keysDragging && button == 0) {
            this.keysDragging = false;
            this.keysPanel.setDragging(false);
            return true;
        }
        return false;
    }

    @Override
    public boolean mouseMoved(double mx, double my, double delta) {
        if (!this.keysOpen || !this.keysDragging || delta != 0.0) {
            return false;
        }
        float ksX = this.keysPanel.getX();
        float ksY = this.keysPanel.getY();
        float listTop1 = this.keysListTop(ksY);
        float bottomY = ksY + 288.0f;
        float inner1 = listTop1 + 32.0f + 6.0f;
        float listTop2 = this.keysListTop(ksY);
        float trackTop = inner1 + 4.0f;
        float inner2 = bottomY - (listTop2 + 32.0f + 6.0f) - 12.0f;
        float gauge = this.keysScrollGauge(ksY);
        float value = ((float)my - this.keysDragOffset - trackTop) / (inner2 + inner1 - 4.0f - trackTop - 40.0f) * gauge;
        float clamped = 0.0f;
        if (value >= 0.0f) {
            clamped = value <= gauge ? value : gauge;
        }
        this.keysPanel.setScroll(clamped);
        return true;
    }

    @Override
    public boolean mouseScrolled(double mx, double my, double amount) {
        if (!this.keysOpen) {
            return false;
        }
        float ksX = this.keysPanel.getX();
        float ksY = this.keysPanel.getY();
        float listTop1 = this.keysListTop(ksY);
        float bottomY = ksY + 288.0f;
        float inner1 = listTop1 + 32.0f + 6.0f;
        float listTop2 = this.keysListTop(ksY);
        float inner2 = bottomY - (listTop2 + 32.0f + 6.0f) - 12.0f;
        int count = this.keysPanel.rows().size();
        if (mx >= (double)(ksX + 12.0f) && mx <= (double)(ksX + 12.0f + 252.0f) && my >= (double)listTop1 && my <= (double)(inner2 + listTop2) && count > 6) {
            float gauge = this.keysScrollGauge(ksY);
            float value = this.keysPanel.scrollOffset() - (float)amount * 24.0f;
            float clamped = 0.0f;
            if (value >= 0.0f) {
                clamped = value <= gauge ? value : gauge;
            }
            this.keysPanel.setScroll(clamped);
            return true;
        }
        return false;
    }

    @Override
    public boolean keyPressed(int keyCode, int modifiers) {
        if (this.closeOnEscape && keyCode == 27) {
            this.onClose();
            return true;
        }
        return this.closeKeysOnEscape(keyCode);
    }

    private boolean closeKeysOnEscape(int keyCode) {
        if (this.keysOpen && keyCode == 27) {
            this.keysOpen = false;
            return true;
        }
        return false;
    }

    private float keysListTop(float ksY) {
        return 30.0f + ksY + 8.0f;
    }

    private float keysScrollGauge(float ksY) {
        int count = this.keysPanel.rows().size();
        float top = this.keysListTop(ksY);
        if (count < 1) {
            float value = 0.0f - top;
            if (value <= 0.0f) {
                value = 0.0f;
            }
            return value;
        }
        float value = (float)(count - 1) * 4.0f + (float)count * 20.0f + 8.0f - top;
        if (value <= 0.0f) {
            value = 0.0f;
        }
        return value;
    }

    @Override
    public boolean charTyped(char ch) {
        return false;
    }

    public boolean onBodyClicked(double mx, double my, int button) {
        boolean headerCConsumed;
        if (this.keysOpen) {
            if (this.keysPanel.mouseClicked(mx, my, button)) {
                return true;
            }
            this.keysOpen = false;
            return true;
        }
        if (button == 0 && (double)this.headerA.x <= mx && mx <= (double)(this.headerA.x + this.headerA.width) && (double)this.headerA.y <= my && my <= (double)(this.headerA.y + this.headerA.height) ? this.headerA.clicked(mx, my, button) : button != 0) {
            return true;
        }
        if ((double)this.headerB.x <= mx && mx <= (double)(this.headerB.x + this.headerB.width) && (double)this.headerB.y <= my && my <= (double)(this.headerB.y + this.headerB.height) && this.headerB.clicked(mx, my, button)) {
            return true;
        }
        boolean bl = headerCConsumed = (double)this.headerC.x <= mx && mx <= (double)(this.headerC.x + this.headerC.width) && (double)this.headerC.y <= my && my <= (double)(this.headerC.y + this.headerC.height) && this.headerC.clicked(mx, my, button);
        if (!headerCConsumed && this.config != null && !this.config.pending && this.config.hasExtra && this.hitAnchor(mx, my)) {
            this.openKeysPanel();
        }
        return true;
    }

    private boolean hitAnchor(double mx, double my) {
        return mx >= (double)this.anchorX && mx <= (double)(this.anchorX + this.anchorW) && my >= (double)this.anchorY && my <= (double)(this.anchorY + this.anchorH);
    }

    public void openKeysPanel() {
        this.anchorX = this.x;
        this.anchorY = this.layoutRowY();
        this.anchorW = this.width;
        this.anchorH = 32.0f;
        this.keysPanel.open(this);
        this.keysOpen = true;
    }

    private float layoutRowY() {
        return this.y;
    }

    public void onClose() {
        this.keysOpen = false;
        this.shareCallback = null;
    }

    public void resetState() {
        this.keysOpen = false;
        this.keysPanel.setPosition(0.0f, 0.0f);
        this.keysPanel.setSize(0.0f, 0.0f);
        this.overlayClosed = false;
        this.closeOnOutside = true;
        this.closeOnEscape = true;
    }

    public void setHost(Component value) {
        this.host = value;
    }

    public void setShareCallback(Runnable value) {
        this.shareCallback = value;
    }

    public void setKeysOpen(boolean value) {
        this.keysOpen = value;
    }

    public float openAnimValue() {
        return this.openAnim;
    }

    public float openAnimTarget() {
        return this.openFrom;
    }

    public void setOpenAnimTarget(float value) {
        this.openFrom = value;
    }

    public float sliderAnimA() {
        return this.sliderAnimA;
    }

    public float sliderAnimB() {
        return this.sliderAnimB;
    }

    public float rowAnim() {
        return this.rowAnim;
    }

    public void setRowAnim(float value) {
        this.rowAnim = value;
    }

    public float anchorX() {
        return this.anchorX;
    }

    public float anchorY() {
        return this.anchorY;
    }

    public float anchorW() {
        return this.anchorW;
    }

    public float anchorH() {
        return this.anchorH;
    }

    public void setAnchor(float ax, float ay, float aw, float ah) {
        this.anchorX = ax;
        this.anchorY = ay;
        this.anchorW = aw;
        this.anchorH = ah;
    }

    public boolean isCloseOnOutside() {
        return this.closeOnOutside;
    }

    public boolean isCloseOnEscape() {
        return this.closeOnEscape;
    }

    public boolean isOverlayClosed() {
        return this.overlayClosed;
    }

    public static final class ConfigInfo {
        public String name = "";
        public boolean hasKeys;
        public boolean hasExtra;
        public boolean pending;

        public ConfigInfo() {
        }

        public ConfigInfo(String name, boolean hasKeys, boolean hasExtra, boolean pending) {
            this.name = name == null ? "" : name;
            this.hasKeys = hasKeys;
            this.hasExtra = hasExtra;
            this.pending = pending;
        }
    }

    public static final class HeaderWidget {
        public float x;
        public float y;
        public float width;
        public float height;
        public float animValue;
        public boolean enabled;

        public HeaderWidget() {
        }

        public HeaderWidget(boolean enabled) {
            this.enabled = enabled;
        }

        public boolean clicked(double mx, double my, int button) {
            return this.enabled;
        }

        public void setOnClick(Runnable callback) {
        }
    }
}

