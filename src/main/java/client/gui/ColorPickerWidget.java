/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.Setting;
import client.gui.Component;

public class ColorPickerWidget
extends Component {
    public static final long VTABLE_RVA = 12603672L;
    public static final long RVA_CTOR_COLOR = 2735201183184L;
    public static final long RVA_CTOR_GRADIENT = 2735201183968L;
    public static final long RVA_BASE_CTOR = 2735201239728L;
    public static final long RVA_INIT = 2735201183968L;
    public static final long RVA_SYNC_HEX = 2735201184656L;
    public static final long RVA_OPEN_MODAL = 2735201185024L;
    public static final long RVA_RENDER = 2735201185632L;
    public static final long RVA_TICK = 2735201185376L;
    public static final long RVA_MOUSE_RELEASED = 2735201185440L;
    public static final long RVA_MOUSE_MOVED = 2735201185520L;
    public static final long RVA_MOUSE_CLICKED = 2735201189104L;
    public static final long RVA_KEY_PRESSED = 2735201190208L;
    public static final long RVA_CHAR_TYPED = 2735201190336L;
    public static final long RVA_COMMIT_HEX = 2735201190464L;
    public static final long RVA_HEIGHT = 2735201188416L;
    public static final long RVA_CURSOR_KEY = 2735203203472L;
    public static final long RVA_CURSOR_CHAR = 2735203205536L;
    public static final long RVA_IS_ACTIVE = 2735201185120L;
    public static final long RVA_MODAL_LAYOUT = 2735201185184L;
    public static final long RVA_MODAL_CONTAINS = 2735201185248L;
    public static final long RVA_MODAL_CURSOR = 2735201186960L;
    public static final long RVA_MODAL_HOVER = 2735201188592L;
    public static final long RVA_SWATCH_DRAW = 2735201182368L;
    public static final long RVA_LABEL_WIDTH = 2735201240352L;
    public static final long RVA_VALUE_WIDTH = 2735201240064L;
    public static final long RVA_MODAL_OPEN = 2735201269008L;
    public static final int SLOT_RENDER = 1;
    public static final int SLOT_TICK = 2;
    public static final int SLOT_MOUSE_CLICKED = 4;
    public static final int SLOT_MOUSE_RELEASED = 5;
    public static final int SLOT_MOUSE_MOVED = 6;
    public static final int SLOT_KEY_PRESSED = 8;
    public static final int SLOT_CHAR_TYPED = 10;
    public static final int SLOT_SET_POSITION = 11;
    public static final int SLOT_HEIGHT = 12;
    public static final int SLOT_HEIGHT_ALIAS = 13;
    public static final int SLOT_IS_ACTIVE = 14;
    public static final int SLOT_MODAL_LAYOUT = 15;
    public static final int SLOT_MODAL_CONTAINS = 16;
    public static final int SLOT_KIND = 17;
    public static final int SLOT_MIN_WIDTH = 18;
    public static final int SLOT_MIN_WIDTH_ALIAS = 19;
    public static final int OFF_COLOR_SOURCE = 128;
    public static final int OFF_GRADIENT = 136;
    public static final int OFF_MODAL = 144;
    public static final int OFF_MODAL_VISIBLE = 1552;
    public static final int OFF_HEX_EDIT = 1840;
    public static final int OFF_HEX_EDITING = 2056;
    public static final int OFF_SWATCH_X = 2060;
    public static final int OFF_SWATCH_Y = 2064;
    public static final int OFF_SWATCH_W = 2068;
    public static final int OFF_CACHE_VALID = 2072;
    public static final int OFF_CACHE_COLOR = 2076;
    public static final int OFF_HEX = 2080;
    public static final int OFF_HEX_VALUE = 2112;
    public static final int OFF_PALETTE_INDEX = 2116;
    public static final float COLOR_MATCH_EPSILON = 0.1f;
    public static final float RGB_SCALE = 255.0f;
    public static final float DISTANCE_DIVISOR = 3.0f;
    public static final float LAYOUT_PAD = 8.0f;
    public static final float LAYOUT_TOP = 6.0f;
    public static final float SWATCH_STEP = 28.0f;
    public static final float SWATCH_SIZE = 26.0f;
    public static final float SWATCH_H = 29.0f;
    public static final float SWATCH_TRIM = 6.5f;
    public static final float SWATCH_ROW_OFFSET = 32.0f;
    public static final float SWATCH_LEFT_PAD = 10.0f;
    public static final float SWATCH_RIGHT_PAD = 16.0f;
    public static final float HEX_FIELD_W = 192.0f;
    public static final float HEX_FIELD_H = 26.0f;
    public static final float LABEL_FONT_SIZE = 12.0f;
    public static final float FALLBACK_WIDTH = 56.0f;
    public static final float MODAL_W = 293.0f;
    public static final float MODAL_H = 383.0f;
    public static final float MODAL_PAD = 20.0f;
    public static final float MODAL_DRAG_BIAS = 16.0f;
    public static final float NEAR_ZERO = 0.001f;
    public static final float SECTION_CORNER = 10.0f;
    public static final float ONE = 1.0f;
    public static final int FLOAT_ONE = 1065353216;
    public static final int KIND = 63;
    public static final float MIN_WIDTH = 16.0f;
    public static final float DEFAULT_WIDTH = 269.0f;
    public static final int PALETTE_COUNT = 7;
    public static final int[] PALETTE = new int[]{-1, -16777216, -1096636, -429290, -340971, -14498466, -12877066};
    private Setting setting;
    private Setting colorSource;
    private Setting gradient;
    private boolean modalVisible;
    private String hexEdit = "";
    private boolean hexEditing;
    private float swatchX;
    private float swatchY;
    private float swatchW;
    private boolean cacheValid;
    private int cachedColor;
    private String hex = "";
    private float hexValue;
    private int paletteIndex = -1;
    private boolean hasSecond;
    private float layoutAnimA;
    private float layoutAnimB;
    private int modalColorA;
    private int modalColorB;
    private int modalColorC;
    private boolean modalFlagDF;
    private boolean modalFlagCC;
    private float modalFlag61C;
    private float modalSwatchC;
    private float labelWidth = -1.0f;
    private float labelWidthCache;
    private float valueWidth = -1.0f;
    private float valueWidthCache;
    public static final float LABEL_GAP = 20.0f;

    public ColorPickerWidget() {
    }

    public ColorPickerWidget(Setting setting) {
        this.init(setting);
        this.syncHex();
        this.runInit();
    }

    public ColorPickerWidget(Setting setting, boolean gradient) {
        this.init(setting);
        if (gradient) {
            this.gradient = setting;
            this.hasSecond = true;
        }
        this.syncHex();
        this.runInit();
    }

    private void init(Setting setting) {
        this.setting = setting;
        this.flags = 256;
        this.width = 269.0f;
        this.colorSource = setting;
        this.gradient = null;
        this.modalVisible = false;
        this.hexEditing = false;
        this.hexEdit = "";
        this.hex = "";
        this.hexValue = 0.0f;
        this.paletteIndex = -1;
        this.cacheValid = false;
        this.hasSecond = false;
        this.modalFlagDF = false;
        this.modalFlagCC = false;
        this.swatchX = 0.0f;
        this.swatchY = 0.0f;
        this.swatchW = 0.0f;
        this.modalFlag61C = 1.0f;
        this.modalColorA = 1065353216;
        this.modalColorB = 1065353216;
        this.modalColorC = 1065353216;
        this.modalSwatchC = 0.0f;
        this.labelWidth = -1.0f;
        this.valueWidth = -1.0f;
    }

    private void runInit() {
        if (this.gradient == null || !this.modalFlagDF) {
            float f;
            this.syncHex();
            int index = this.paletteIndex;
            if (index < 0) {
                return;
            }
            this.cachedColor = index;
            this.modalColorA = 1065353216;
            this.modalFlag61C = 1.0f;
            this.modalColorB = 1065353216;
            this.modalFlagDF = false;
            this.swatchW = f = (float)index;
            this.modalSwatchC = f;
            this.modalColorC = 1065353216;
            this.modalFlagCC = false;
        }
    }

    public int kind() {
        return 63;
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

    public int sourceColor() {
        if (this.colorSource == null) {
            return -16777216;
        }
        return this.colorSource.getColor() | 0xFF000000;
    }

    public Setting setting() {
        return this.setting;
    }

    public boolean modalVisible() {
        return this.modalVisible;
    }

    public String hex() {
        return this.hex;
    }

    public int paletteIndex() {
        return this.paletteIndex;
    }

    public void syncHex() {
        int color = this.sourceColor();
        if (this.cacheValid && color == this.cachedColor) {
            return;
        }
        this.cacheValid = true;
        this.cachedColor = color;
        int r = color >>> 16 & 0xFF;
        int g = color >>> 8 & 0xFF;
        int b = color & 0xFF;
        this.hex = String.format("#%02X%02X%02X", r, g, b);
        this.hexValue = ColorPickerWidget.parseHex(this.hex, 12.0f);
        this.paletteIndex = -1;
        for (int i = 0; i < 7; ++i) {
            if ((PALETTE[i] & 0xFFFFFF) != (color & 0xFFFFFF)) continue;
            this.paletteIndex = i;
            return;
        }
    }

    public void openModal() {
        this.modalVisible = true;
        if (ColorPickerWidget.isModalOpenGlobal()) {
            ColorPickerWidget.openModalGlobal();
            return;
        }
        this.openModalLocal();
    }

    @Override
    public boolean isActive() {
        return this.modalVisible && (26.0f < this.layoutAnimA || 26.0f < this.layoutAnimB);
    }

    public boolean modalContains(double mx, double my) {
        if (!this.modalVisible) {
            return false;
        }
        return 26.0f < this.layoutAnimA || 26.0f < this.layoutAnimB;
    }

    @Override
    public void tick() {
        if (!this.modalVisible) {
            return;
        }
        if (26.0f < this.layoutAnimA || 26.0f < this.layoutAnimB) {
            this.advanceModal();
        }
    }

    @Override
    public void render(Object renderer, float px, float py, float alpha) {
        int source = this.sourceColor();
        int theme = ColorPickerWidget.uiThemeColor(0);
        int themeAlt = ColorPickerWidget.uiThemeColor(1);
        int blended = ColorPickerWidget.uiLerpColor(source, theme | 0xFF000000, 0.5f);
        int dr = (blended >>> 16 & 0xFF) - (theme >>> 16 & 0xFF);
        int dg = (blended >>> 8 & 0xFF) - (theme >>> 8 & 0xFF);
        int db = (blended & 0xFF) - (theme & 0xFF);
        float dist = (float)(dg * dg + dr * dr + db * db) / 255.0f;
        if ((dist = (float)Math.sqrt(dist)) < 0.1f) {
            blended = ColorPickerWidget.uiLerpColor(blended, themeAlt | 0xFF000000, 0.5f);
        }
        this.syncHex();
        if (this.hexEditing) {
            this.formatHexEdit();
        }
        boolean second = this.gradient != null && this.hasSecond;
        ColorPickerWidget.renderModal(this, blended, source);
        float swatch = this.swatchHeight();
        float label = this.measureLabel(0.0f);
        float value = this.measureValue();
        float rowY = py - 3.0f;
        float rowH = px + this.width - swatch;
        float swatchTop = rowY + 8.0f;
        float swatchLeft = rowH + 6.0f;
        if (second) {
            ColorPickerWidget.renderModalGradient(this, source);
            this.setModalRow(rowH);
        } else if (!this.hexEditing) {
            ColorPickerWidget.drawSwatchRow(renderer, rowH, swatchTop, alpha);
            ColorPickerWidget.renderHexField(renderer, this.hex, swatchLeft, swatchTop, alpha);
        } else {
            ColorPickerWidget.drawSwatchRow(renderer, rowH, swatchTop, alpha);
            ColorPickerWidget.renderHexEditor(renderer, this.hexEdit, swatchLeft, swatchTop, alpha);
        }
        this.swatchX = rowH;
        this.swatchY = rowY;
        this.swatchW = swatch;
        if (0.0f < value) {
            label = label + 0.0f + value;
        }
        float bottom = label + py + 8.0f;
        ColorPickerWidget.renderSwatch(this, blended, source, bottom, alpha);
        this.height = bottom + 32.0f - this.y;
    }

    @Override
    public void render() {
        this.render(this, this.x, this.y, this.alpha);
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (!this.modalVisible) {
            return this.mouseClickedSwatch(mx, my, button, this.x, this.y, this.width);
        }
        if (mx >= 20.0 && mx <= 297.0 && my >= 20.0 && my <= 387.0) {
            ColorPickerWidget.modalClick(this, mx, my);
            return true;
        }
        ColorPickerWidget.modalCancel(this);
        return true;
    }

    public boolean mouseClickedSwatch(double mx, double my, int button, float px, float py, float pw) {
        float arrowX;
        if (button != 0) {
            if (this.hexEditing) {
                this.commitHex(1);
            }
            return false;
        }
        if (mx >= (double)this.swatchX && mx <= (double)(this.swatchX + this.swatchW) && my >= (double)this.swatchY && my <= (double)(this.swatchY + 26.0f)) {
            if (this.gradient != null && this.hasSecond) {
                this.openModal();
                return true;
            }
            if (this.hexEditing) {
                return true;
            }
            this.syncHex();
            this.hexEdit = this.hex;
            this.hexEditing = true;
            return true;
        }
        if (this.hexEditing) {
            this.commitHex(1);
        }
        if (mx >= (double)(arrowX = px + 10.0f + 16.0f + 26.0f + 8.0f + 32.0f + 8.0f + 10.0f) && mx <= (double)(arrowX + 26.0f) && my >= (double)(this.swatchY + 8.0f + 8.0f) && my <= (double)(this.swatchY + 8.0f + 8.0f + 26.0f)) {
            this.openModal();
            return true;
        }
        if (mx >= (double)px && mx <= (double)(px + pw) && my >= (double)this.swatchY && my <= (double)(this.swatchY + 32.0f)) {
            for (int i = 0; i < 7; ++i) {
                float itemX = (float)i * 32.0f + px + 8.0f - 6.5f;
                if (!(mx >= (double)itemX) || !(mx <= (double)(itemX + 29.0f)) || !(my >= (double)(this.swatchY + 3.0f)) || !(my <= (double)(this.swatchY + 3.0f + 26.0f))) continue;
                this.applyPalette(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean mouseReleased(double mx, double my, int button) {
        if (!this.modalVisible) {
            return false;
        }
        if (26.0f < this.layoutAnimA || 26.0f < this.layoutAnimB) {
            return ColorPickerWidget.modalMouseReleased(this);
        }
        return false;
    }

    @Override
    public boolean mouseMoved(double mx, double my, double delta) {
        mouseX = (float)mx;
        mouseY = (float)my;
        if (!this.modalVisible) {
            return false;
        }
        if (26.0f < this.layoutAnimA || 26.0f < this.layoutAnimB) {
            return ColorPickerWidget.modalMouseMoved(this, mx, my, delta);
        }
        return false;
    }

    @Override
    public boolean mouseScrolled(double mx, double my, double amount) {
        mouseX = (float)mx;
        mouseY = (float)my;
        if (!this.modalVisible) {
            return false;
        }
        if (26.0f < this.layoutAnimA || 26.0f < this.layoutAnimB) {
            return ColorPickerWidget.modalMouseScrolled(this);
        }
        return false;
    }

    @Override
    public boolean keyPressed(int keyCode, int modifiers) {
        if (!this.modalVisible) {
            if (!this.hexEditing) {
                return false;
            }
            if (keyCode == 27) {
                this.hexEditing = false;
                return true;
            }
            ColorPickerWidget.cursorKey(this.hexEdit, keyCode);
            return true;
        }
        if (26.0f < this.layoutAnimA || 26.0f < this.layoutAnimB) {
            return ColorPickerWidget.modalKeyPressed(this, keyCode);
        }
        return false;
    }

    @Override
    public boolean keyReleased(int keyCode) {
        if (!this.modalVisible) {
            return false;
        }
        if (26.0f < this.layoutAnimA || 26.0f < this.layoutAnimB) {
            return ColorPickerWidget.modalKeyReleased(this, keyCode);
        }
        return false;
    }

    @Override
    public boolean charTyped(char ch) {
        if (!this.modalVisible) {
            if (!this.hexEditing) {
                return false;
            }
            if (ColorPickerWidget.isHexChar(ch)) {
                ColorPickerWidget.cursorChar(this.hexEdit, ch);
            }
            return true;
        }
        if (26.0f < this.layoutAnimA || 26.0f < this.layoutAnimB) {
            return ColorPickerWidget.modalCharTyped(this, ch);
        }
        return false;
    }

    public float measuredHeight() {
        float extra;
        if (this.gradient == null || !this.hasSecond) {
            this.syncHex();
            extra = this.hexValue + 32.0f;
        } else {
            extra = 56.0f;
        }
        float w1 = this.measureValueFor(this.width - extra - 6.0f);
        float w2 = this.swatchHeight();
        if (0.0f < w1) {
            w2 = w2 + 0.0f + w1;
        }
        return w2 + 8.0f + 32.0f;
    }

    public void commitHex(int apply) {
        if (!this.hexEditing) {
            return;
        }
        this.hexEditing = false;
        if (apply == 0) {
            return;
        }
        int parsed = ColorPickerWidget.parseHexColor(this.hexEdit);
        if (parsed < 0) {
            return;
        }
        int alpha = -16777216;
        if (this.colorSource != null && this.colorSource.getColor() != 0) {
            alpha = this.colorSource.getColor() & 0xFF000000;
        }
        int value = alpha | parsed & 0xFFFFFF;
        if (this.colorSource != null && this.colorSource.getColor() != value) {
            this.colorSource.setColor(value);
            if (this.setting != null && this.setting != this.colorSource) {
                this.setting.setColor(value);
            }
        }
    }

    private void applyPalette(int index) {
        int color = PALETTE[index];
        if (this.colorSource != null) {
            this.colorSource.setColor(color);
        }
        if (this.setting != null && this.setting != this.colorSource) {
            this.setting.setColor(color);
        }
    }

    private void setModalRow(float value) {
        this.layoutAnimA = value;
    }

    private float measureLabel(float avail) {
        if (this.labelWidth == avail) {
            return this.labelWidthCache;
        }
        this.labelWidth = avail;
        this.labelWidthCache = ColorPickerWidget.fontWidth(this.setting == null ? "" : this.setting.getName(), 12.0f);
        return this.labelWidthCache;
    }

    private float measureValue() {
        float avail = this.width - (this.kind() == 89 ? 0.0f : 20.0f);
        if (avail <= 0.0f) {
            avail = 0.0f;
        }
        return this.measureValueFor(avail);
    }

    private float measureValueFor(float avail) {
        if (this.valueWidth == avail) {
            return this.valueWidthCache;
        }
        this.valueWidth = avail;
        this.valueWidthCache = ColorPickerWidget.fontWidth(this.hex, 12.0f);
        return this.valueWidthCache;
    }

    private float swatchHeight() {
        return 26.0f;
    }

    public static float parseHex(String s, float fallback) {
        int parsed = ColorPickerWidget.parseHexColor(s);
        if (parsed < 0) {
            return fallback;
        }
        return parsed;
    }

    public static int parseHexColor(String s) {
        String t;
        if (s == null) {
            return -1;
        }
        String string = t = s.startsWith("#") ? s.substring(1) : s;
        if (t.length() != 6) {
            return -1;
        }
        int value = 0;
        for (int i = 0; i < 6; ++i) {
            int d = Character.digit(t.charAt(i), 16);
            if (d < 0) {
                return -1;
            }
            value = value << 4 | d;
        }
        return value;
    }

    private static boolean isHexChar(char ch) {
        return ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'f' || ch >= 'A' && ch <= 'F' || ch == '#';
    }

    private static float fontWidth(String s, float size) {
        if (s == null || s.isEmpty()) {
            return 0.0f;
        }
        return (float)s.length() * size;
    }

    private static boolean isModalOpenGlobal() {
        return false;
    }

    private static void openModalGlobal() {
    }

    private void openModalLocal() {
    }

    private void advanceModal() {
    }

    private void formatHexEdit() {
    }

    private static void renderModal(ColorPickerWidget self, int blended, int source) {
    }

    private static void renderModalGradient(ColorPickerWidget self, int source) {
    }

    private static void drawSwatchRow(Object renderer, float px, float py, float alpha) {
    }

    private static void renderHexField(Object renderer, String s, float px, float py, float alpha) {
    }

    private static void renderHexEditor(Object renderer, String s, float px, float py, float alpha) {
    }

    private static void renderSwatch(ColorPickerWidget self, int blended, int source, float py, float alpha) {
    }

    private static boolean modalMouseReleased(ColorPickerWidget self) {
        return false;
    }

    private static boolean modalMouseMoved(ColorPickerWidget self, double mx, double my, double delta) {
        return false;
    }

    private static boolean modalMouseScrolled(ColorPickerWidget self) {
        return false;
    }

    private static boolean modalKeyPressed(ColorPickerWidget self, int keyCode) {
        return false;
    }

    private static boolean modalKeyReleased(ColorPickerWidget self, int keyCode) {
        return false;
    }

    private static boolean modalCharTyped(ColorPickerWidget self, char ch) {
        return false;
    }

    private static void modalClick(ColorPickerWidget self, double mx, double my) {
    }

    private static void modalCancel(ColorPickerWidget self) {
    }

    private static void cursorKey(String s, int keyCode) {
    }

    private static void cursorChar(String s, char ch) {
    }
}

