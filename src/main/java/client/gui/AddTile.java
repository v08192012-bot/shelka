/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.AbstractCard;
import client.gui.Component;

public class AddTile
extends Component {
    public static final long VTABLE_RVA = 12588000L;
    public static final long RVA_CTOR = 1189392L;
    public static final long RVA_DTOR = 1134112L;
    public static final long RVA_DELETING_DTOR_WRAPPER = 1130592L;
    public static final long RVA_RENDER = 1190144L;
    public static final long RVA_MOUSE_CLICKED = 1191904L;
    public static final long RVA_KEY_PRESSED = 1192208L;
    public static final long RVA_KEY_RELEASED = 1192224L;
    public static final long RVA_SET_POSITION = 1190128L;
    public static final long RVA_INPUT_CTOR = 1394064L;
    public static final long RVA_INPUT_DTOR = 1394768L;
    public static final long RVA_INPUT_RENDER = 1396944L;
    public static final long RVA_INPUT_MOUSE_CLICKED = 1398448L;
    public static final long RVA_INPUT_FOCUS_STATE = 1395520L;
    public static final long RVA_INPUT_SELECT = 1396592L;
    public static final long RVA_INPUT_KEY_PRESSED = 1398576L;
    public static final long RVA_INPUT_SET_FOCUSED = 1843744L;
    public static final long RVA_ASSIGN_CALLBACK = 1189280L;
    public static final long RVA_POSITION_ANIM_APPLY = 1097808L;
    public static final long RVA_SET_POSITION_ANIMATED = 1097088L;
    public static final long RVA_ANIM_SET_TARGET = 1148816L;
    public static final long RVA_DRAW_PANEL = 1139984L;
    public static final long RVA_DRAW_RECT_OUTLINE = 1140544L;
    public static final long RVA_PUSH_CLIP = 1138976L;
    public static final long RVA_DRAW_CORNER_MARKS = 1141712L;
    public static final long RVA_RENDERER_STATE = 3515472L;
    public static final long RVA_DRAW_TEXT_AT = 3491616L;
    public static final long RVA_DRAW_TEXT_AT2 = 3494400L;
    public static final long RVA_STRING_VIEW = 134512L;
    public static final long RVA_MEASURE_TEXT = 1773456L;
    public static final long RVA_INSERT_CODE_POINT = 3522976L;
    public static final long RVA_HOVER_STATE = 23724720L;
    public static final int SLOT_DTOR = 0;
    public static final int SLOT_RENDER = 8;
    public static final int SLOT_MOUSE_CLICKED = 32;
    public static final int SLOT_KEY_PRESSED = 64;
    public static final int SLOT_KEY_RELEASED = 80;
    public static final int SLOT_SET_POSITION = 88;
    public static final int OFF_CHILDREN_END = 152;
    public static final int OFF_FLAG_D8 = 216;
    public static final int OFF_CLICK_CALLBACK = 216;
    public static final int OFF_ICON = 224;
    public static final int OFF_TITLE = 232;
    public static final int OFF_SUBTITLE = 264;
    public static final int OFF_FLAG_128 = 296;
    public static final int OFF_INPUT = 304;
    public static final int OFF_INPUT_BOX_X = 312;
    public static final int OFF_INPUT_BOX_Y = 316;
    public static final int OFF_INPUT_BOX_W = 320;
    public static final int OFF_INPUT_BOX_H = 324;
    public static final int OFF_INPUT_FOCUSED = 656;
    public static final int OFF_INPUT_FOCUS_ANIM = 664;
    public static final int OFF_INPUT_TEXT = 400;
    public static final int OFF_INPUT_CAPTURE = 1040;
    public static final float INPUT_WIDTH = 230.0f;
    public static final float TILE_HEIGHT = 62.0f;
    public static final float INPUT_BOX_HEIGHT = 24.0f;
    public static final float ICON_BOX_SIZE = 42.0f;
    public static final float PADDING = 12.0f;
    public static final float GAP = 6.0f;
    public static final float ICON_INSET = 3.0f;
    public static final float ICON_TEXT_INSET = 13.0f;
    public static final float TEXT_ROW_Y_OFFSET = 1.0f;
    public static final float HOVER_ALPHA = 1.0f;
    public static final int DRAW_MODE_TITLE = 5;
    public static final int DRAW_MODE_SUBTITLE = 2;
    public static int hoverState;
    protected int icon;
    protected String title;
    protected String subtitle;
    protected int flag128;
    protected Runnable onClick;
    protected final PlateInput input = new PlateInput(230.0f);
    protected AbstractCard.Anim animX;
    protected AbstractCard.Anim animY;
    protected boolean animatingPosition;
    private static final TextRow TEXT_ROW_TITLE;
    private static final TextRow TEXT_ROW_SUBTITLE;

    public AddTile(int tileIcon, String tileTitle, String tileSubtitle, String inputText, int trailingIcon) {
        this.icon = tileIcon;
        this.title = tileTitle == null ? "" : tileTitle;
        this.subtitle = tileSubtitle == null ? "" : tileSubtitle;
        this.flag128 = 0;
        this.input.setText(inputText == null ? "" : inputText);
        this.input.onCommit = this::onInputCommitted;
        this.add(this.input);
        this.height = 62.0f;
    }

    private void onInputCommitted(String value) {
    }

    @Override
    public void render() {
    }

    @Override
    public void render(Object renderer, float mouseX, float mouseY, float alpha) {
        float inputBoxY;
        float inputBoxX;
        this.applyPositionAnimation(this.now());
        if (mouseX >= this.x && mouseX <= this.x + this.width && mouseY >= this.y && mouseY <= this.y + this.height) {
            hoverState = 1;
        }
        float titleX = this.x + 12.0f;
        float rowY = (this.height - 42.0f) * 0.5f + this.y;
        if (this.flag128 == 1) {
            AddTile.pushClip();
            float measuredTitle = AddTile.measureText(TEXT_ROW_TITLE, this.title, 12.0f);
            float measuredSubtitle = AddTile.measureText(TEXT_ROW_SUBTITLE, this.subtitle, 12.0f);
            float longest = measuredTitle <= measuredSubtitle ? measuredSubtitle : measuredTitle;
            float shortest = measuredTitle <= measuredSubtitle ? measuredTitle : measuredSubtitle;
            float capped = longest <= 230.0f ? longest : 230.0f;
            float left = (this.x - capped) * 0.5f + this.x;
            float boxY = (this.height - 24.0f) * 0.5f + this.y;
            inputBoxX = (this.x - capped) * 0.5f + this.x;
            inputBoxY = boxY + 24.0f + 6.0f;
            float textWidth = (this.x - capped) * 0.5f + this.x;
        } else {
            AddTile.drawPanel(renderer, this.x, this.y, this.width, this.height);
            float start = this.x + 12.0f;
            float boxY = (this.height - 42.0f) * 0.5f + this.y;
            float right = this.x + this.width - 12.0f - 230.0f;
            float inputY = (this.height - 24.0f) * 0.5f + this.y;
            float available = right - 6.0f - (start + 12.0f + 6.0f);
            inputBoxX = right;
            inputBoxY = inputY;
            float textWidth = available <= 0.0f ? 0.0f : available;
        }
        AddTile.drawRectOutline(renderer, titleX, rowY, 42.0f, 42.0f);
        AddTile.pushClip();
        AddTile.drawCornerMarks(renderer, titleX + 3.0f, rowY + 3.0f);
        AddTile.rendererState();
        AddTile.drawTextAt(renderer, this.icon, titleX + 13.0f, rowY + 13.0f, alpha);
        float textX = titleX + 42.0f + 6.0f;
        AddTile.rendererState();
        AddTile.drawTextAt2(5, renderer, titleX, this.title, textX);
        AddTile.drawTextAt2(2, renderer, titleX, this.subtitle, textX);
        this.input.setSize(230.0f, 24.0f);
        this.input.setPosition(inputBoxX, inputBoxY);
        this.input.render(renderer, mouseX, mouseY, alpha);
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (this.input.mousePressed(mx, my, button)) {
            return true;
        }
        if (button != 0) {
            return false;
        }
        if (mx < (double)this.x || mx > (double)(this.x + this.width)) {
            return false;
        }
        if (my < (double)this.y || my > (double)(this.y + this.height)) {
            return false;
        }
        if (this.input.focusState()) {
            this.input.select();
            return true;
        }
        if (this.onClick != null) {
            this.onClick.run();
            return true;
        }
        if (!this.input.focused) {
            this.input.setFocused(true);
            return true;
        }
        return true;
    }

    @Override
    public boolean keyPressed(int keyCode, int modifiers) {
        return this.input.keyPressedInput(keyCode, modifiers);
    }

    @Override
    public boolean keyReleased(int keyCode) {
        return this.input.keyReleasedInput(keyCode);
    }

    @Override
    public void setPosition(float px, float py) {
        this.setPositionAnimated(px, py);
    }

    public void setPositionAnimated(float px, float py) {
        if (this.animX == null) {
            this.animX = new AbstractCard.Anim(px, 0.0f, 1);
            this.animY = new AbstractCard.Anim(py, 0.0f, 1);
        }
        if (!this.animatingPosition) {
            this.animX.snap(px);
            this.animY.snap(py);
            this.x = px;
            this.y = py;
            this.animatingPosition = true;
            return;
        }
        this.animX.setTarget(px);
        this.animY.setTarget(py);
    }

    public void applyPositionAnimation(long time) {
        if (!this.animatingPosition || this.animX == null || this.animY == null) {
            return;
        }
        this.x = this.animX.update(time);
        this.y = this.animY.update(time);
    }

    public static void drawPanel(Object renderer, float x, float y, float width, float height) {
    }

    public static void drawRectOutline(Object renderer, float x, float y, float width, float height) {
    }

    public static void pushClip() {
    }

    public static void drawCornerMarks(Object renderer, float x, float y) {
    }

    public static Object rendererState() {
        return null;
    }

    public static void drawTextAt(Object renderer, int icon, float x, float y, float alpha) {
        AddTile.uiDrawIcon(renderer, icon, x, y, 42.0f, 42.0f, -1, alpha);
    }

    public static void drawTextAt2(int mode, Object renderer, float x, String text, float textX) {
    }

    public static void playClickSound(int sound) {
        AddTile.uiSound(sound);
    }

    public static float measureText(TextRow row, String text, float size) {
        return 0.0f;
    }

    static {
        TEXT_ROW_TITLE = new TextRow();
        TEXT_ROW_SUBTITLE = new TextRow();
    }

    public static class PlateInput
    extends Component
    implements AbstractCard.InputChild {
        public static final int OFF_FOCUSED = 656;
        public static final int OFF_FOCUS_ANIM = 664;
        public static final int OFF_TEXT = 400;
        public static final int OFF_CAPTURE = 1040;
        public static final int OFF_WIDTH = 96;
        public String text = "";
        public boolean selected;
        public boolean shiftCommit;
        public Consumer2 onCommit;
        public final AbstractCard.Anim focusAnim = new AbstractCard.Anim(0.0f, 0.22f, 0);

        public PlateInput(float width) {
            this.setSize(width, 24.0f);
        }

        public boolean mousePressed(double mx, double my, int button) {
            return button == 0 && this.contains(mx, my);
        }

        public boolean focusState() {
            return this.focused;
        }

        public void select() {
            this.selected = true;
        }

        public void setFocused(boolean value) {
            this.focused = value;
            this.focusAnim.setTarget(value ? 1.0f : 0.0f);
        }

        public boolean keyPressedInput(int keyCode, int modifiers) {
            return false;
        }

        public boolean keyReleasedInput(int keyCode) {
            if (!this.focused) {
                return false;
            }
            if (this.capture != null && this.capture instanceof AbstractCard.KeyCapture && !((AbstractCard.KeyCapture)((Object)this.capture)).onKey(keyCode)) {
                return false;
            }
            return AbstractCard.insertCodePoint(this, keyCode);
        }

        @Override
        public void render(Object renderer, float mouseX, float mouseY, float alpha) {
        }

        @Override
        public String getText() {
            return this.text;
        }

        @Override
        public void setText(String value) {
            this.text = value == null ? "" : value;
        }

        @Override
        public boolean isShiftCommit() {
            return this.shiftCommit;
        }

        @Override
        public void commit() {
            if (this.onCommit != null) {
                this.onCommit.accept(this.text);
            }
            this.focused = false;
        }

        @Override
        public void cancel() {
            this.focused = false;
        }

        @Override
        public void blur(String value) {
            if (this.onCommit != null) {
                this.onCommit.accept(value);
            }
        }
    }

    public static interface Consumer2 {
        public void accept(String var1);
    }

    public static final class TextRow {
        public String text = "";
    }
}

