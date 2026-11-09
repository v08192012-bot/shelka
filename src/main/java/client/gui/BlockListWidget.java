/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BlockListWidget
extends Component {
    public static final long VTABLE_RVA = 12602912L;
    public static final long RVA_CTOR = 2735201245248L;
    public static final long RVA_CTOR_SETTING_WIDGET = 2735201239728L;
    public static final long RVA_DTOR = 2735201180064L;
    public static final long RVA_RENDER = 2735201327216L;
    public static final long RVA_OVERLAY_RENDER = 2735200849408L;
    public static final long RVA_ON_OVERLAY_RENDER = 2735201327744L;
    public static final long RVA_MEASURE_LAYOUT_ROW = 2735201327136L;
    public static final long RVA_MEASURE_HEIGHT = 2735201228352L;
    public static final long RVA_MEASURE_TEXT = 2735201240352L;
    public static final long RVA_MEASURE_BADGE = 2735201240064L;
    public static final long RVA_MEASURE_ROW = 2735201240576L;
    public static final long RVA_MEASURE_ROW2 = 2735201241104L;
    public static final long RVA_DRAW_ROW = 2735200825024L;
    public static final long RVA_RENDER_FORWARD = 2735201175904L;
    public static final long RVA_IS_OVERLAY_OPEN = 2735201327888L;
    public static final long RVA_DRAW_OVERLAY = 2735201327968L;
    public static final long RVA_OVERLAY_DRAW_CALL = 2735200849248L;
    public static final long RVA_OVERLAY_HIT = 2735201328048L;
    public static final long RVA_TEXT_COLOR = 2735201175920L;
    public static final long RVA_ROW_INSET = 2735201175936L;
    public static final long RVA_LABEL_ALPHA = 2735201180016L;
    public static final long RVA_LABEL_TEXT = 2735201180032L;
    public static final long RVA_OPEN_MODAL = 2735201180144L;
    public static final long RVA_MODAL_RESET = 2735201310144L;
    public static final long RVA_MODAL_SHOW = 2735200848528L;
    public static final long RVA_MOUSE_CLICKED = 2735201328224L;
    public static final long RVA_MOUSE_RELEASED = 2735201328512L;
    public static final long RVA_MOUSE_MOVED = 2735201328640L;
    public static final long RVA_MOUSE_SCROLLED = 2735201328800L;
    public static final long RVA_KEY_PRESSED = 2735201328928L;
    public static final long RVA_CHAR_TYPED = 2735201329056L;
    public static final long RVA_ANIM_INIT = 2735200260240L;
    public static final long RVA_ANIM_VALUE = 2735200831600L;
    public static final long RVA_MODAL_CTOR = 2735201308976L;
    public static final long RVA_INPUT_CTOR = 2735200057520L;
    public static final long RVA_COLOR_MODAL_CTOR = 2735201267568L;
    public static final long RVA_INPUT_CALLBACK = 2735199988368L;
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
    public static final int OFF_SETTING = 96;
    public static final int OFF_FIELD_68 = 104;
    public static final int OFF_FIELD_6C = 108;
    public static final int OFF_FIELD_70 = 112;
    public static final int OFF_FIELD_74 = 116;
    public static final int OFF_FIELD_78 = 120;
    public static final int OFF_MODAL = 128;
    public static final int OFF_TRIGGER_ANIM = 136;
    public static final int OFF_OVERLAY = 176;
    public static final int OFF_BLOCK_LIST = 1136;
    public static final int OFF_ITEMS = 1144;
    public static final int OFF_ITEMS_END = 1152;
    public static final int OFF_ITEMS_CAP = 1160;
    public static final int OFF_FLAG_490 = 1168;
    public static final int OFF_INPUT = 1176;
    public static final int OFF_COLOR_MODAL = 1424;
    public static final int OFF_DRAFT = 2832;
    public static final int OFF_DRAFT_END = 2856;
    public static final int OFF_FLAG_619 = 1561;
    public static final int OFF_OVERLAY_ANIM_A = 100;
    public static final int OFF_OVERLAY_ANIM_B = 104;
    public static final float WIDGET_WIDTH = 269.0f;
    public static final float ROW_HEIGHT = 32.0f;
    public static final float ALPHA_EPS = 0.001f;
    public static final float ONE = 1.0f;
    public static final float ROW_INSET = 16.0f;
    public static final long TEXT_COLOR_CODE = 62L;
    public static final long LABEL_ALPHA_CODE = 89L;
    public static final String OVERLAY_TITLE = "\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u0431\u043b\u043e\u043a\u0430";
    public static final String LABEL_TEXT = "C\u043f\u0438\u0441\u043e\u043a \u0431\u043bo\u043a\u043e\u0432";
    public static final String INPUT_ID = "__blocklist_edit";
    private Object setting;
    private float field68 = -1.0f;
    private int field6c;
    private float field70 = -1.0f;
    private int field74;
    private boolean field78;
    private final BlockListModal modal = new BlockListModal();
    private final float[] triggerAnim = new float[9];
    private float triggerAlpha;
    private Object blockList;
    private final List<Object> items = new ArrayList<Object>();
    private boolean flag490;
    private final PlateInput input = new PlateInput();
    private final ColorModalHolder colorModal = new ColorModalHolder();
    private final StringBuilder draft = new StringBuilder();
    private boolean flag619;
    private float lastRowHeight;
    private int cursorShape;

    public BlockListWidget() {
        this(null);
    }

    public BlockListWidget(Object blockList) {
        this.blockList = blockList;
        this.setting = null;
        this.width = 269.0f;
        this.flags = 256;
        this.field68 = -1.0f;
        this.field70 = -1.0f;
        this.field6c = 0;
        this.field74 = 0;
        this.field78 = false;
        this.triggerAnim[0] = 0.0f;
        this.triggerAnim[2] = 0.0f;
        this.modal.setTitle(OVERLAY_TITLE);
        this.input.init(INPUT_ID, -1, true);
        this.colorModal.attach(this.input, 0);
        this.draft.setLength(0);
        this.flag619 = false;
    }

    public float[] triggerAnim() {
        return this.triggerAnim;
    }

    public BlockListModal overlay() {
        return this.modal;
    }

    public PlateInput inputField() {
        return this.input;
    }

    public List<Object> items() {
        return this.items;
    }

    public boolean isOverlayOpen() {
        return this.modal.openAnim > 0.001f || this.modal.closeAnim > 0.001f;
    }

    public boolean isModalVisible() {
        return this.isOverlayOpen();
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void tick() {
    }

    @Override
    public void render() {
        this.renderInternal(null, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    private void renderInternal(Object matrix, float mx, float my, float scale, float flag) {
        float a = this.measureLayout(this.width);
        float b = this.measureBadge(a, this.width);
        if (b > 0.0f) {
            a = a + 0.0f + b;
        }
        float rowY = a + this.y + 6.0f;
        float hoverTarget = 0.0f;
        if (this.x <= mx && mx <= this.x + this.width && rowY <= my && my <= rowY + 32.0f && (BlockListWidget.cursorGate() == 0 || BlockListWidget.cursorOpenFlag())) {
            this.cursorShape = 1;
            hoverTarget = 1.0f;
        }
        if (this.triggerAnim[2] != hoverTarget) {
            this.triggerAnim[0] = this.animValue(this.triggerAnim, this.now());
            this.triggerAnim[2] = hoverTarget;
            this.triggerAnim[6] = this.now();
            this.triggerAnim[8] = 1.0f;
        }
        float alpha = this.animValue(this.triggerAnim, this.now());
        long colorCode = this.textColorCode();
        String label = this.labelText();
        this.drawRow(matrix, (int)this.x, rowY, (int)this.width, label, colorCode, alpha, scale);
        this.height = rowY + 32.0f - this.y;
    }

    private static int cursorGate() {
        return 0;
    }

    private static boolean cursorOpenFlag() {
        return false;
    }

    private long textColorCode() {
        return 62L;
    }

    private String labelText() {
        return LABEL_TEXT;
    }

    private float measureLayout(float w) {
        return 0.0f;
    }

    private float measureBadge(float a, float w) {
        return 0.0f;
    }

    private float measureHeight() {
        float a = this.measureLayout(this.width);
        float b = this.measureBadge(a, this.width);
        if (a > 0.0f) {
            b = b + 0.0f + a;
        }
        return b + 6.0f + 32.0f;
    }

    private float layoutRowY() {
        float a = this.measureLayout(this.width);
        float b = this.measureBadge(a, this.width);
        if (a > 0.0f) {
            b = b + 0.0f + a;
        }
        return b + this.y + 6.0f;
    }

    private void drawRow(Object matrix, int rx, float ry, int rw, String label, long color, float alpha, float scale) {
    }

    private float animValue(float[] anim, long time) {
        if (anim[8] == 0.0f) {
            return anim[2];
        }
        float t = (float)((double)(time - (long)anim[6]) / 1.0E9);
        if (t <= 0.0f) {
            return anim[0];
        }
        if (t >= 0.22f) {
            anim[8] = 0.0f;
            return anim[2];
        }
        return anim[0] + (anim[2] - anim[0]) * (t / 0.22f);
    }

    public void renderForward() {
        this.preferredHeight();
    }

    public void renderOverlay(Object matrix, float a, float b, float c, float d) {
        if (!this.isOverlayOpen()) {
            return;
        }
        this.modal.render(matrix, b, c, d);
    }

    public void layoutOverlay() {
        if (!this.isOverlayOpen()) {
            return;
        }
        this.overlayLayout();
    }

    private void overlayLayout() {
    }

    public boolean containsModal(double mx, double my) {
        if (!this.isOverlayOpen()) {
            return false;
        }
        return this.modal.contains(mx, my);
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        boolean active = this.isActive();
        if (!active || !this.modal.isOpen()) {
            if (button == 0) {
                float w = this.width;
                float top = this.layoutRowY();
                if ((double)this.x <= mx && mx <= (double)(this.x + w) && (double)top <= my && my <= (double)(top + 32.0f)) {
                    this.openModal();
                    return true;
                }
            }
            return false;
        }
        this.modal.mouseClicked(mx, my, button);
        return true;
    }

    public void openModal() {
        float[] anchor = this.anchor();
        this.modal.reset();
        this.modal.show(anchor[0], anchor[1]);
    }

    private float[] anchor() {
        Supplier<float[]> supplier = new Supplier<float[]>(){

            @Override
            public float[] get() {
                return new float[]{BlockListWidget.this.x, BlockListWidget.this.layoutRowY()};
            }
        };
        float[] pair = (float[])supplier.get();
        this.field68 = pair[0];
        this.field70 = pair[1];
        return pair;
    }

    @Override
    public boolean mouseReleased(double mx, double my, int button) {
        if (!this.isActive() || !this.modal.isOpen()) {
            return false;
        }
        this.modal.mouseReleased(mx, my, button);
        return true;
    }

    @Override
    public boolean mouseMoved(double mx, double my, double delta) {
        if (!this.isActive() || !this.modal.isOpen()) {
            return false;
        }
        this.modal.mouseMoved(mx, my, delta);
        return true;
    }

    @Override
    public boolean mouseScrolled(double mx, double my, double amount) {
        if (!this.isActive() || !this.modal.isOpen()) {
            return false;
        }
        this.modal.mouseScrolled(mx, my, amount);
        return true;
    }

    @Override
    public boolean keyPressed(int keyCode, int modifiers) {
        if (!this.isActive() || !this.modal.isOpen()) {
            return false;
        }
        this.modal.keyPressed(keyCode, modifiers);
        return true;
    }

    @Override
    public boolean charTyped(char ch) {
        if (!this.isActive() || !this.modal.isOpen()) {
            return false;
        }
        this.modal.charTyped(ch);
        return true;
    }

    @Override
    public void setPosition(float px, float py) {
        this.x = px;
        this.y = py;
    }

    public int labelAlphaCode() {
        return 89;
    }

    public String panelLabel() {
        return LABEL_TEXT;
    }

    public float rowInset() {
        return 16.0f;
    }

    @Override
    public float preferredHeight() {
        return this.measureHeight();
    }

    public static final class BlockListModal {
        public String title = "";
        public boolean showing;
        public float openAnim;
        public float closeAnim;
        public float x;
        public float y;
        public float width;
        public float height;

        public void setTitle(String value) {
            this.title = value == null ? "" : value;
        }

        public float positionX() {
            return this.x;
        }

        public float positionY() {
            return this.y;
        }

        public void show(float atX, float atY) {
            this.x = atX;
            this.y = atY;
            this.showing = true;
        }

        public void reset() {
            this.showing = false;
            this.x = 0.0f;
            this.y = 0.0f;
            this.openAnim = 0.0f;
            this.closeAnim = 0.0f;
        }

        public boolean isOpen() {
            return this.openAnim > 0.001f || this.closeAnim > 0.001f;
        }

        public boolean mouseClicked(double mx, double my, int button) {
            return this.isOpen();
        }

        public boolean mouseReleased(double mx, double my, int button) {
            return this.isOpen();
        }

        public boolean mouseMoved(double mx, double my, double delta) {
            return this.isOpen();
        }

        public boolean mouseScrolled(double mx, double my, double amount) {
            return this.isOpen();
        }

        public boolean keyPressed(int keyCode, int modifiers) {
            return this.isOpen();
        }

        public boolean charTyped(char ch) {
            return this.isOpen();
        }

        public void render(Object matrix, float arg1, float arg2, float arg3) {
        }

        public boolean contains(double mx, double my) {
            return mx >= (double)this.x && mx <= (double)(this.x + this.width) && my >= (double)this.y && my <= (double)(this.y + this.height);
        }

        public void measureAndReset() {
            this.height = 0.0f;
            this.showing = false;
        }
    }

    public static final class PlateInput {
        public String id = "";
        public String text = "";
        public boolean focused;

        public void init(String value, int max, boolean flag) {
            this.id = value == null ? "" : value;
        }

        public void setOnChange(Runnable callback) {
        }
    }

    public static final class ColorModalHolder {
        public PlateInput target;
        public int mode;

        public void attach(PlateInput input, int value) {
            this.target = input;
            this.mode = value;
        }
    }

    public static final class OverlayAnim {
        public float value;
        public float target;
        public long time;
        public boolean running;
    }
}

