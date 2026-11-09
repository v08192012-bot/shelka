/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.AbstractOverlay;
import client.gui.Component;
import client.gui.Screen;
import java.util.ArrayList;
import java.util.List;

public class SettingsMenu
extends AbstractOverlay {
    public static final int VTABLE_RVA = 12613856;
    public static final long RVA_DTOR = 2735201404880L;
    public static final long RVA_CTOR = 2735201404432L;
    public static final long RVA_CONST_VALUE = 2735201404944L;
    public static final long RVA_SET_CHILD = 2735201404960L;
    public static final long RVA_CLOSE_RESET = 2735201405200L;
    public static final long RVA_DRAW_KEY_SLOT = 2735201405232L;
    public static final long RVA_DRAW_KEY_ROW = 2735201406736L;
    public static final long RVA_RENDER_BODY = 2735201407104L;
    public static final long RVA_ON_MOUSE_CLICKED = 2735201410624L;
    public static final long RVA_ON_KEY_PRESSED = 2735201411424L;
    public static final long RVA_KEY_RELEASED = 2735201411616L;
    public static final long RVA_LAMBDA_COPY = 2735201411936L;
    public static final long RVA_CALLER_OPEN_SETTINGS = 2735201394240L;
    public static final long RVA_NOW = 2735199714128L;
    public static final long RVA_ANIMATE = 2735200831376L;
    public static final long RVA_ADVANCE = 2735200831600L;
    public static final long RVA_ANIM_INIT_CUBIC = 2735200856400L;
    public static final long RVA_ANIM_INIT_DEFAULT = 2735200260240L;
    public static final long RVA_SET_CHILD_BASE = 2735200848528L;
    public static final long RVA_THEME = 2735203198032L;
    public static final long RVA_ACCENT = 2735200821536L;
    public static final long RVA_MIX_COLOR = 2735200832496L;
    public static final long RVA_SET_THEME = 2735203199120L;
    public static final long RVA_SOUND = 2735199719200L;
    public static final long RVA_ICON_METRICS = 2735199818160L;
    public static final long RVA_MEASURE_TEXT = 2735201456016L;
    public static final long RVA_DRAW_TEXT = 2735203176960L;
    public static final long RVA_DRAW_ICON = 2735203174176L;
    public static final long RVA_MAKE_RECT = 2735200379472L;
    public static final long RVA_DRAW_BOX_THEMED = 2735200822544L;
    public static final long RVA_DRAW_BOX_ACCENT = 2735200822832L;
    public static final long RVA_DRAW_BOX_STYLED = 2735200821232L;
    public static final long RVA_DRAW_CHIP_BOX = 2735200824272L;
    public static final long RVA_DRAW_HOVER_PILL = 2735200824400L;
    public static final long RVA_MODIFIER_WIDTH = 2735200889024L;
    public static final long RVA_MODIFIER_TEXT = 2735200889616L;
    public static final long RVA_WRAP_TEXT = 2735203199984L;
    public static final long RVA_LOCALIZE = 2735199817072L;
    public static final long RVA_KEY_NAME = 2735203017616L;
    public static final long RVA_KEY_LABEL = 2735203020320L;
    public static final long RVA_ALLOCATE = 2735203701616L;
    public static final long RVA_DESTROY_STRING = 2735199713712L;
    public static final int CALLBACK_OFFSET = 264;
    public static final int KEYBIND_OFFSET = 272;
    public static final int LIGHT_SLOT_OFFSET = 280;
    public static final int LIGHT_SLOT_END_OFFSET = 296;
    public static final int DARK_SLOT_OFFSET = 296;
    public static final int DARK_SLOT_END_OFFSET = 312;
    public static final int LANGUAGE_BUTTON_OFFSET = 312;
    public static final int LANGUAGE_BUTTON_END_OFFSET = 328;
    public static final int MODE_LEFT_OFFSET = 328;
    public static final int MODE_LEFT_END_OFFSET = 344;
    public static final int MODE_RIGHT_OFFSET = 344;
    public static final int MODE_RIGHT_END_OFFSET = 360;
    public static final int ROW_A_OFFSET = 360;
    public static final int ROW_A_END_OFFSET = 376;
    public static final int ROW_B_OFFSET = 376;
    public static final int ROW_B_END_OFFSET = 392;
    public static final int THEME_ANIM_OFFSET = 392;
    public static final int MODE_ANIM_OFFSET = 432;
    public static final int LANGUAGE_ANIM_OFFSET = 472;
    public static final int ROW_A_ANIM_OFFSET = 512;
    public static final int ROW_B_ANIM_OFFSET = 552;
    public static final int LISTENING_OFFSET = 592;
    public static final int PENDING_KEY_OFFSET = 596;
    public static final int RECT_X_OFFSET = 0;
    public static final int RECT_Y_OFFSET = 4;
    public static final int RECT_WIDTH_OFFSET = 8;
    public static final int RECT_HEIGHT_OFFSET = 12;
    public static final int RECT_X = 0;
    public static final int RECT_Y = 1;
    public static final int RECT_WIDTH = 2;
    public static final int RECT_HEIGHT = 3;
    public static final int ANIM_FROM_OFFSET = 0;
    public static final int ANIM_CURRENT_OFFSET = 4;
    public static final int ANIM_TARGET_OFFSET = 8;
    public static final int ANIM_DURATION_OFFSET = 12;
    public static final int ANIM_EASING_OFFSET = 16;
    public static final int ANIM_START_OFFSET = 24;
    public static final int ANIM_RUNNING_OFFSET = 32;
    public static final int CONFIG_NAME_OFFSET = 16;
    public static final int CONFIG_NAME_SIZE_OFFSET = 32;
    public static final int CONFIG_NAME_CAPACITY_OFFSET = 40;
    public static final int CONFIG_KEYBIND_OFFSET = 192;
    public static final int KEY_CALLBACK_OFFSET = 224;
    public static final int KEY_CODE_OFFSET = 232;
    public static final int KEY_MODIFIERS_OFFSET = 236;
    public static final int LABEL_MODIFIERS_OFFSET = 0;
    public static final int LABEL_TEXT_OFFSET = 8;
    public static final int LABEL_TEXT_SIZE_OFFSET = 24;
    public static final int LABEL_TEXT_CAPACITY_OFFSET = 32;
    public static final float CONST_VALUE = 20.0f;
    public static final float PANEL_WIDTH = 220.0f;
    public static final float PANEL_HEIGHT = 202.0f;
    public static final float PANEL_RADIUS = 20.0f;
    public static final float SLIDE_OFFSET = 16.0f;
    public static final float ROW_PAD = 8.0f;
    public static final float ROW_INSET = 6.0f;
    public static final float ROW_STEP = 48.0f;
    public static final float ROW_RADIUS = 14.0f;
    public static final float ROW_HEIGHT = 42.0f;
    public static final float CHIP_RADIUS = 12.0f;
    public static final float CHIP_HEIGHT = 36.0f;
    public static final float CHIP_INSET = 3.0f;
    public static final float CHIP_GAP = 2.0f;
    public static final float HALF = 0.5f;
    public static final float ICON_STRIP_START = 20.0f;
    public static final float ICON_STRIP_GAP = 10.0f;
    public static final float MODE_DIM = 0.3f;
    public static final float MODE_LIFT = 0.7f;
    public static final float ACCENT_BLEND = 0.85f;
    public static final float HINT_SIZE = 11.0f;
    public static final float SLOT_SIZE = 14.0f;
    public static final float TEXT_SIZE = 12.0f;
    public static final float LABEL_INSET = 16.0f;
    public static final float LABEL_LEAD = 4.0f;
    public static final float LABEL_PAD = 8.0f;
    public static final float LABEL_BASELINE = 6.0f;
    public static final float LABEL_TOP = 18.0f;
    public static final float PILL_RADIUS = 24.0f;
    public static final float PILL_ALPHA = 0.5f;
    public static final float DIM_FACTOR = 0.5f;
    public static final float ANIM_SPEED = 0.22f;
    public static final float ANIM_DEFAULT_DURATION = 0.15f;
    public static final int HOVER_DEFAULT = 1;
    public static final int HOVER_LIGHT_DISABLED = 7;
    public static final int TEXT_STYLE_HINT = 4;
    public static final int TEXT_STYLE_LABEL = 5;
    public static final int ICON_LIGHT = 17;
    public static final int ICON_DARK = 18;
    public static final int ICON_LANGUAGE = 19;
    public static final int ICON_MODIFIERS = 21;
    public static final int SOUND_CLICK = 14;
    public static final int VK_ESCAPE = 27;
    public static final int VK_MODIFIER_LOW = 16;
    public static final int VK_MODIFIER_ALT_LOW = 160;
    public static final int THEME_DARK = 1;
    public static final int THEME_LIGHT = 0;
    public static final int MODE_PREFIXED = 1;
    public static final int MODE_PLAIN = 0;
    public static final int MODIFIER_CTRL = 2;
    public static final int MODIFIER_SHIFT = 1;
    public static final int MODIFIER_ALT = 4;
    public static final int PENDING_KEY_NONE = 0;
    public static final int[] MODE_ICONS = new int[]{86, 88, 87};
    public static final String KEYBIND_ENTRY_NAME = "clickgui";
    public static final String ROW_A_TITLE = "\u041f\u0430\u043d\u0438\u0441 & \u0421\u043b\u0435\u0430\u043d";
    public static final String ROW_B_TITLE = "\u0421\u043b\u0438\u0441\u043a\u0413\u0443\u0438";
    public static final String HINT_TEXT = "SHIFT ALT CTRL";
    public static final String LISTENING_TEXT = "...";
    public static final String DEFAULT_KEY_TEXT = "None";
    public static final String MODIFIER_CTRL_TEXT = "CTRL + ";
    public static final String MODIFIER_SHIFT_TEXT = "SHIFT + ";
    public static final String MODIFIER_ALT_TEXT = "ALT + ";
    public static final String EMPTY_TEXT = "";
    public static boolean hoverGatePointerNull = true;
    public static boolean mouseInsideWindow;
    private static boolean lightThemeUnavailable;
    private static boolean russianActive;
    private static boolean modePrefixed;
    private static int currentTheme;
    private static boolean registryInitialized;
    private static final Object HINT_FONT;
    private static final Object LABEL_FONT;
    private static final List<ConfigEntry> CONFIG_ENTRIES;
    protected Object callback = null;
    protected KeyEntry keybind;
    protected final float[] lightSlotRect = new float[4];
    protected final float[] darkSlotRect = new float[4];
    protected final float[] languageRect = new float[4];
    protected final float[] modeLeftRect = new float[4];
    protected final float[] modeRightRect = new float[4];
    protected final float[] rowARect = new float[4];
    protected final float[] rowBRect = new float[4];
    protected final AbstractOverlay.Animator themeAnim = new AbstractOverlay.Animator();
    protected final AbstractOverlay.Animator modeAnim = new AbstractOverlay.Animator();
    protected final AbstractOverlay.Animator languageAnim = new AbstractOverlay.Animator();
    protected final AbstractOverlay.Animator rowAAnim = new AbstractOverlay.Animator();
    protected final AbstractOverlay.Animator rowBAnim = new AbstractOverlay.Animator();
    protected boolean listening;
    protected int pendingKey;
    protected final float[] frameRect = new float[6];

    public SettingsMenu() {
        if (!registryInitialized) {
            registryInitialized = true;
            SettingsMenu.ensureRegistryInitialized();
        }
        KeyEntry found = null;
        for (int index = 0; index < CONFIG_ENTRIES.size(); ++index) {
            ConfigEntry candidate = CONFIG_ENTRIES.get(index);
            if (candidate.name.length() != 8 || !candidate.name.equals(KEYBIND_ENTRY_NAME)) continue;
            found = candidate.keybind;
            break;
        }
        this.lightSlotRect[0] = 0.0f;
        this.lightSlotRect[1] = 0.0f;
        this.lightSlotRect[2] = 0.0f;
        this.lightSlotRect[3] = 0.0f;
        this.darkSlotRect[0] = 0.0f;
        this.darkSlotRect[1] = 0.0f;
        this.keybind = found;
        this.darkSlotRect[2] = 0.0f;
        this.darkSlotRect[3] = 0.0f;
        this.languageRect[0] = 0.0f;
        this.languageRect[1] = 0.0f;
        this.languageRect[2] = 0.0f;
        this.languageRect[3] = 0.0f;
        this.modeLeftRect[0] = 0.0f;
        this.modeLeftRect[1] = 0.0f;
        this.modeLeftRect[2] = 0.0f;
        this.modeLeftRect[3] = 0.0f;
        this.modeRightRect[0] = 0.0f;
        this.modeRightRect[1] = 0.0f;
        this.modeRightRect[2] = 0.0f;
        this.modeRightRect[3] = 0.0f;
        this.rowARect[0] = 0.0f;
        this.rowARect[1] = 0.0f;
        this.rowARect[2] = 0.0f;
        this.rowARect[3] = 0.0f;
        this.rowBRect[0] = 0.0f;
        this.rowBRect[1] = 0.0f;
        this.rowBRect[2] = 0.0f;
        this.rowBRect[3] = 0.0f;
        SettingsMenu.resetAnimator(this.themeAnim, currentTheme == 1 ? 1.0f : 0.0f, 0.22f, 0);
        SettingsMenu.resetAnimator(this.modeAnim, SettingsMenu.modeFlag() == 1 ? 1.0f : 0.0f, 0.22f, 0);
        SettingsMenu.resetAnimator(this.languageAnim, 0.0f, 0.15f, 0);
        SettingsMenu.resetAnimator(this.rowAAnim, 0.0f, 0.15f, 0);
        SettingsMenu.resetAnimator(this.rowBAnim, 0.0f, 0.15f, 0);
        this.listening = false;
        this.pendingKey = 0;
        this.width = 220.0f;
        this.height = 202.0f;
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public boolean keyReleased(int keyCode) {
        if (!this.listening) {
            return false;
        }
        int pending = this.pendingKey;
        if (pending == 0 || keyCode != pending) {
            return false;
        }
        if (this.keybind.key != pending || this.keybind.modifiers != 0) {
            this.keybind.key = pending;
            this.keybind.modifiers = 0;
            if (this.keybind.callback != null) {
                SettingsMenu.invokeCallback(this.keybind.callback);
            }
        }
        this.pendingKey = 0;
        this.listening = false;
        this.closeOnEscape = true;
        return true;
    }

    @Override
    public float overlayConst() {
        return 20.0f;
    }

    public void openAt(Object callback) {
        this.callback = callback;
    }

    @Override
    public void setChild(Component value) {
        super.setChild(value);
    }

    @Override
    public void renderBody(Object mat, float mouseX, float mouseY, float parentAlpha) {
        if (this.listening) {
            Screen.textInputActive = true;
        }
        float clampedLow = 0.0f <= parentAlpha ? parentAlpha : 0.0f;
        float clampedAlpha = parentAlpha <= 1.0f ? clampedLow : 1.0f;
        float slideY = (1.0f - clampedAlpha) * 16.0f + this.y;
        SettingsMenu.makeRect(this.frameRect, mat, parentAlpha, this.width * 0.5f + this.x);
        SettingsMenu.drawThemedBox(this.frameRect, this.x, slideY, this.width, this.height, 20.0f, parentAlpha);
        float rowX = this.x + 8.0f;
        float rowW = this.width - 16.0f;
        SettingsMenu.animate(this.themeAnim, currentTheme == 1 ? 1.0f : 0.0f);
        float themeProgress = SettingsMenu.advance(this.themeAnim, this.now());
        this.drawKeyRow(this.frameRect, rowX, slideY += 8.0f, rowW - 6.0f - 42.0f, themeProgress, this.lightSlotRect, this.darkSlotRect, parentAlpha);
        float lightIconAlpha = parentAlpha;
        if (lightThemeUnavailable) {
            lightIconAlpha = parentAlpha * 0.5f;
        }
        float[] icon = SettingsMenu.iconMetrics(17);
        float iconWidth = icon[0];
        float iconHeight = icon[1];
        SettingsMenu.drawIcon(this.frameRect, 17, (this.lightSlotRect[2] - iconWidth) * 0.5f + this.lightSlotRect[0], (this.lightSlotRect[3] - iconHeight) * 0.5f + this.lightSlotRect[1], iconWidth, iconHeight, SettingsMenu.themeColor(24), lightIconAlpha);
        icon = SettingsMenu.iconMetrics(18);
        iconWidth = icon[0];
        iconHeight = icon[1];
        SettingsMenu.drawIcon(this.frameRect, 18, (this.darkSlotRect[2] - iconWidth) * 0.5f + this.darkSlotRect[0], (this.darkSlotRect[3] - iconHeight) * 0.5f + this.darkSlotRect[1], iconWidth, iconHeight, SettingsMenu.themeColor(24), parentAlpha);
        this.languageRect[0] = rowW + rowX - 42.0f;
        this.languageRect[1] = slideY;
        this.languageRect[2] = 42.0f;
        this.languageRect[3] = 42.0f;
        SettingsMenu.drawAccentBox(this.frameRect, this.languageRect[0], slideY, 42.0f, this.languageRect[3], 14.0f, parentAlpha);
        float languageHover = 0.0f;
        if (this.languageRect[0] <= mouseX && mouseX <= this.languageRect[0] + this.languageRect[2] && this.languageRect[1] <= mouseY && mouseY <= this.languageRect[1] + this.languageRect[3] && (!hoverGatePointerNull || mouseInsideWindow)) {
            languageHover = 1.0f;
        }
        SettingsMenu.animate(this.languageAnim, languageHover);
        float buttonX = this.languageRect[0] + 3.0f;
        float buttonY = this.languageRect[1] + 3.0f;
        float buttonProgress = SettingsMenu.advance(this.languageAnim, this.now());
        int accent = SettingsMenu.accentColor();
        int accentBlend = SettingsMenu.mixColor(accent, SettingsMenu.themeColor(8), 0.85f);
        int buttonColor = SettingsMenu.mixColor(accent, accentBlend, buttonProgress);
        SettingsMenu.drawBoxStyled(this.frameRect, buttonX, buttonY, 36.0f, 36.0f, 12.0f, buttonColor, 0.0f, 0.0f, 0, 24.0f, 0.5f, parentAlpha);
        icon = SettingsMenu.iconMetrics(19);
        iconWidth = icon[0];
        iconHeight = icon[1];
        SettingsMenu.drawIcon(this.frameRect, 19, (36.0f - iconWidth) * 0.5f + buttonX, (36.0f - iconHeight) * 0.5f + buttonY, iconWidth, iconHeight, SettingsMenu.themeColor(24), parentAlpha);
        SettingsMenu.animate(this.modeAnim, SettingsMenu.modeFlag() == 1 ? 1.0f : 0.0f);
        float modeProgress = SettingsMenu.advance(this.modeAnim, this.now());
        this.drawKeyRow(this.frameRect, rowX, slideY += 48.0f, rowW, modeProgress, this.modeLeftRect, this.modeRightRect, parentAlpha);
        float modeAlpha = (modeProgress *= 0.3f) + 0.7f;
        float iconStrip = 20.0f;
        for (int stripIndex = 0; stripIndex < MODE_ICONS.length; ++stripIndex) {
            icon = SettingsMenu.iconMetrics(MODE_ICONS[stripIndex]);
            iconStrip += icon[0];
        }
        float stripY = this.modeLeftRect[3] * 0.5f + this.modeLeftRect[1];
        float stripX = (this.modeLeftRect[2] - iconStrip) * 0.5f + this.modeLeftRect[0];
        for (int iconIndex = 0; iconIndex < MODE_ICONS.length; ++iconIndex) {
            int iconId = MODE_ICONS[iconIndex];
            icon = SettingsMenu.iconMetrics(iconId);
            iconWidth = icon[0];
            iconHeight = icon[1];
            SettingsMenu.drawIcon(this.frameRect, iconId, stripX, stripY - iconHeight * 0.5f, iconWidth, iconHeight, SettingsMenu.themeColor(24), (1.0f - modeProgress) * parentAlpha);
            stripX = stripX + iconWidth + 10.0f;
        }
        float hintWidth = SettingsMenu.measureText(HINT_FONT, SettingsMenu.localize(HINT_TEXT), 11.0f);
        SettingsMenu.drawText(4, this.frameRect, HINT_TEXT, (this.modeRightRect[2] - hintWidth) * 0.5f + this.modeRightRect[0], (this.modeRightRect[3] - 11.0f) * 0.5f + this.modeRightRect[1], 11.0f, SettingsMenu.themeColor(24), modeAlpha * parentAlpha);
        this.rowARect[0] = rowX;
        this.rowARect[1] = slideY += 48.0f;
        this.rowARect[2] = rowW;
        this.rowARect[3] = 42.0f;
        this.drawKeySlot(this.frameRect, this.rowARect, ROW_A_TITLE, null, this.rowAAnim, mouseX, mouseY, parentAlpha);
        this.rowBRect[0] = rowX;
        this.rowBRect[1] = slideY + 48.0f;
        this.rowBRect[2] = rowW;
        this.rowBRect[3] = 42.0f;
        KeyLabel keyLabel = this.keybind == null ? new KeyLabel(0, EMPTY_TEXT) : (!this.listening ? (this.keybind.key == 0 || SettingsMenu.modeFlag() == 1 ? new KeyLabel(0, SettingsMenu.defaultKeyLabel(this.keybind)) : new KeyLabel(this.keybind.modifiers, SettingsMenu.keyName(this.keybind.key))) : new KeyLabel(0, LISTENING_TEXT));
        if (this.keybind == null) {
            keyLabel = null;
        }
        this.drawKeySlot(this.frameRect, this.rowBRect, ROW_B_TITLE, keyLabel, this.rowBAnim, mouseX, mouseY, parentAlpha);
        if (lightThemeUnavailable && this.lightSlotRect[0] <= mouseX && mouseX <= this.lightSlotRect[0] + this.lightSlotRect[2] && this.lightSlotRect[1] <= mouseY && mouseY <= this.lightSlotRect[1] + this.lightSlotRect[3] && (!hoverGatePointerNull || mouseInsideWindow)) {
            Screen.hoveredWidget = 7;
            return;
        }
        if ((mouseX < this.lightSlotRect[0] || this.lightSlotRect[0] + this.lightSlotRect[2] < mouseX || mouseY < this.lightSlotRect[1] || this.lightSlotRect[1] + this.lightSlotRect[3] < mouseY || hoverGatePointerNull && !mouseInsideWindow) && (mouseX < this.darkSlotRect[0] || this.darkSlotRect[0] + this.darkSlotRect[2] < mouseX || mouseY < this.darkSlotRect[1] || this.darkSlotRect[1] + this.darkSlotRect[3] < mouseY || hoverGatePointerNull && !mouseInsideWindow) && (mouseX < this.languageRect[0] || this.languageRect[0] + this.languageRect[2] < mouseX || mouseY < this.languageRect[1] || this.languageRect[1] + this.languageRect[3] < mouseY || hoverGatePointerNull && !mouseInsideWindow) && (mouseX < this.modeLeftRect[0] || this.modeLeftRect[0] + this.modeLeftRect[2] < mouseX || mouseY < this.modeLeftRect[1] || this.modeLeftRect[1] + this.modeLeftRect[3] < mouseY || hoverGatePointerNull && !mouseInsideWindow) && (mouseX < this.modeRightRect[0] || this.modeRightRect[0] + this.modeRightRect[2] < mouseX || mouseY < this.modeRightRect[1] || this.modeRightRect[1] + this.modeRightRect[3] < mouseY || hoverGatePointerNull && !mouseInsideWindow) && (mouseX < this.rowARect[0] || this.rowARect[0] + this.rowARect[2] < mouseX || mouseY < this.rowARect[1] || this.rowARect[1] + this.rowARect[3] < mouseY || hoverGatePointerNull && !mouseInsideWindow)) {
            if (this.keybind == null) {
                return;
            }
            if (mouseX < this.rowBRect[0] || this.rowBRect[0] + this.rowBRect[2] < mouseX || mouseY < this.rowBRect[1] || this.rowBRect[1] + this.rowBRect[3] < mouseY || hoverGatePointerNull && !mouseInsideWindow) {
                return;
            }
        }
        Screen.hoveredWidget = 1;
    }

    @Override
    public boolean onMouseClicked(double mouseX, double mouseY, int button) {
        if (this.listening) {
            this.listening = false;
            this.pendingKey = 0;
            this.closeOnEscape = true;
            return true;
        }
        if (button == 0) {
            if ((double)this.lightSlotRect[0] <= mouseX && mouseX <= (double)(this.lightSlotRect[0] + this.lightSlotRect[2]) && (double)this.lightSlotRect[1] <= mouseY && mouseY <= (double)(this.lightSlotRect[1] + this.lightSlotRect[3])) {
                if (lightThemeUnavailable) {
                    return true;
                }
                SettingsMenu.uiSound(14);
                SettingsMenu.setTheme(0);
                return true;
            }
            if ((double)this.darkSlotRect[0] <= mouseX && mouseX <= (double)(this.darkSlotRect[0] + this.darkSlotRect[2]) && (double)this.darkSlotRect[1] <= mouseY && mouseY <= (double)(this.darkSlotRect[1] + this.darkSlotRect[3])) {
                SettingsMenu.uiSound(14);
                SettingsMenu.setTheme(1);
                return true;
            }
            if ((double)this.languageRect[0] <= mouseX && mouseX <= (double)(this.languageRect[0] + this.languageRect[2]) && (double)this.languageRect[1] <= mouseY && mouseY <= (double)(this.languageRect[1] + this.languageRect[3])) {
                SettingsMenu.uiSound(14);
                russianActive = !russianActive;
                return true;
            }
            if ((double)this.modeLeftRect[0] <= mouseX && mouseX <= (double)(this.modeLeftRect[0] + this.modeLeftRect[2]) && (double)this.modeLeftRect[1] <= mouseY && mouseY <= (double)(this.modeLeftRect[1] + this.modeLeftRect[3])) {
                SettingsMenu.uiSound(14);
                SettingsMenu.setModeFlag(0);
                return true;
            }
            if ((double)this.modeRightRect[0] <= mouseX && mouseX <= (double)(this.modeRightRect[0] + this.modeRightRect[2]) && (double)this.modeRightRect[1] <= mouseY && mouseY <= (double)(this.modeRightRect[1] + this.modeRightRect[3])) {
                SettingsMenu.uiSound(14);
                SettingsMenu.setModeFlag(1);
                return true;
            }
            if ((double)this.rowARect[0] <= mouseX && mouseX <= (double)(this.rowARect[0] + this.rowARect[2]) && (double)this.rowARect[1] <= mouseY && mouseY <= (double)(this.rowARect[1] + this.rowARect[3])) {
                SettingsMenu.uiSound(14);
                if (this.callback != null) {
                    SettingsMenu.invokeCallback(this.callback);
                }
                this.close();
                return true;
            }
            if ((double)this.rowBRect[0] <= mouseX && mouseX <= (double)(this.rowBRect[0] + this.rowBRect[2]) && (double)this.rowBRect[1] <= mouseY && mouseY <= (double)(this.rowBRect[1] + this.rowBRect[3]) && this.keybind != null) {
                SettingsMenu.uiSound(14);
                this.listening = true;
                this.pendingKey = 0;
                this.closeOnEscape = false;
            }
        }
        return true;
    }

    @Override
    public boolean onKeyPressed(int keyCode, int modifiers) {
        if (!this.listening) {
            return false;
        }
        if (keyCode == 27) {
            this.listening = false;
            this.pendingKey = 0;
            this.closeOnEscape = true;
            return true;
        }
        if (2L < ((long)(keyCode - 16) & 0xFFFFFFFFL) && 5L < ((long)(keyCode - 160) & 0xFFFFFFFFL)) {
            if (this.keybind.key != keyCode || this.keybind.modifiers != modifiers) {
                this.keybind.key = keyCode;
                this.keybind.modifiers = modifiers;
                if (this.keybind.callback != null) {
                    SettingsMenu.invokeCallback(this.keybind.callback);
                }
            }
            this.listening = false;
            this.pendingKey = 0;
            this.closeOnEscape = true;
            return true;
        }
        this.pendingKey = keyCode;
        return true;
    }

    @Override
    public void onClosed() {
        this.listening = false;
        this.pendingKey = 0;
        this.closeOnEscape = true;
    }

    protected void drawKeyRow(Object mat, float x, float y, float width, float progress, float[] outA, float[] outB, float alpha) {
        SettingsMenu.drawThemedBox(mat, x, y, width, 42.0f, 14.0f, alpha);
        float chipX = x + 3.0f;
        float chipY = y + 3.0f;
        float chipW = (width - 6.0f - 2.0f) * 0.5f;
        float shift = chipX + chipW + 2.0f;
        int chipColor = SettingsMenu.accentColor();
        SettingsMenu.drawChipBox(mat, (shift - chipX) * progress + chipX, chipY, chipW, 36.0f, 12.0f, chipColor, alpha);
        outA[0] = chipX;
        outA[1] = chipY;
        outA[2] = chipW;
        outA[3] = 36.0f;
        outB[0] = shift;
        outB[1] = chipY;
        outB[2] = chipW;
        outB[3] = 36.0f;
    }

    protected void drawKeySlot(Object mat, float[] rect, String title, KeyLabel key, AbstractOverlay.Animator hoverAnim, float mouseX, float mouseY, float alpha) {
        SettingsMenu.drawThemedBox(mat, rect[0], rect[1], rect[2], rect[3], 14.0f, alpha);
        float hoverTarget = 1.0f;
        if (mouseX < rect[0] || rect[0] + rect[2] < mouseX || mouseY < rect[1] || rect[1] + rect[3] < mouseY || hoverGatePointerNull && !mouseInsideWindow) {
            hoverTarget = 0.0f;
        }
        SettingsMenu.animate(hoverAnim, hoverTarget);
        float chipX = rect[0] + 3.0f;
        float chipY = rect[1] + 3.0f;
        float chipW = rect[2] - 6.0f;
        float hover = SettingsMenu.advance(hoverAnim, this.now());
        int accent = SettingsMenu.accentColor();
        int accentBlend = SettingsMenu.mixColor(accent, SettingsMenu.themeColor(8), 0.85f);
        int chipColor = SettingsMenu.mixColor(accent, accentBlend, hover);
        SettingsMenu.drawBoxStyled(mat, chipX, chipY, chipW, 36.0f, 12.0f, chipColor, 0.0f, 0.0f, 0, 24.0f, 0.5f, alpha);
        float labelY = chipY + 18.0f;
        float labelWidth = 0.0f;
        if (key != null) {
            float[] icon = SettingsMenu.iconMetrics(21);
            float iconWidth = icon[0];
            float iconHeight = icon[1];
            float modifierWidth = SettingsMenu.measureModifierWidth(key.modifiers, 12.0f);
            float keyWidth = SettingsMenu.measureText(LABEL_FONT, SettingsMenu.localize(key.text), 12.0f);
            labelWidth = iconWidth + 16.0f + 4.0f + modifierWidth + keyWidth;
            float labelX = chipW + chipX - 8.0f - labelWidth;
            SettingsMenu.drawHoverPill(mat, labelX, labelY - 12.0f, labelWidth, 24.0f, alpha * 0.3f);
            SettingsMenu.drawIcon(mat, 21, labelX += 8.0f, labelY - iconHeight * 0.5f, iconWidth, iconHeight, SettingsMenu.themeColor(24), alpha * 0.3f);
            float penX = SettingsMenu.drawModifierText(mat, key, labelX + iconWidth + 4.0f, labelY - 6.0f, 12.0f, SettingsMenu.themeColor(24), alpha * 0.3f);
            SettingsMenu.drawText(5, mat, key.text, penX, labelY - 6.0f, 12.0f, SettingsMenu.themeColor(24), alpha * 0.3f);
            labelWidth += 8.0f;
        }
        SettingsMenu.drawText(5, mat, SettingsMenu.wrapText(title, chipW - 16.0f - labelWidth, 14.0f), chipX + 8.0f, labelY - 6.0f, 14.0f, SettingsMenu.themeColor(24), alpha);
    }

    private static void ensureRegistryInitialized() {
    }

    private static int modeFlag() {
        return modePrefixed ? 1 : 0;
    }

    private static void setModeFlag(int value) {
        modePrefixed = value == 1;
    }

    private static void setTheme(int index) {
        if (!(index == currentTheme || lightThemeUnavailable && index == 0)) {
            currentTheme = index;
        }
    }

    private static void invokeCallback(Object value) {
    }

    private static int themeColor(int index) {
        return 0;
    }

    private static int accentColor() {
        return 0;
    }

    private static float[] iconMetrics(int icon) {
        return new float[2];
    }

    private static float measureText(Object font, String text, float size) {
        return 0.0f;
    }

    private static float measureModifierWidth(int modifiers, float size) {
        return 0.0f;
    }

    private static String localize(String text) {
        return text;
    }

    private static String keyName(int keyCode) {
        return EMPTY_TEXT;
    }

    private static String defaultKeyLabel(KeyEntry entry) {
        if (entry.key == 0) {
            return DEFAULT_KEY_TEXT;
        }
        StringBuilder builder = new StringBuilder();
        if ((entry.modifiers & 2) != 0) {
            builder.append(MODIFIER_CTRL_TEXT);
        }
        if ((entry.modifiers & 1) != 0) {
            builder.append(MODIFIER_SHIFT_TEXT);
        }
        if ((entry.modifiers & 4) != 0) {
            builder.append(MODIFIER_ALT_TEXT);
        }
        builder.append(SettingsMenu.keyName(entry.key));
        return builder.toString();
    }

    private static String wrapText(String text, float maxWidth, float size) {
        return text;
    }

    private static float[] makeRect(float[] out, Object mat, float alpha, float x) {
        return out;
    }

    private static void drawThemedBox(Object mat, float x, float y, float width, float height, float radius, float alpha) {
    }

    private static void drawAccentBox(Object mat, float x, float y, float width, float height, float radius, float alpha) {
    }

    private static void drawBoxStyled(Object mat, float x, float y, float width, float height, float radius, int color, float fadeA, float fadeB, int border, float spread, float scale, float alpha) {
    }

    private static void drawChipBox(Object mat, float x, float y, float width, float height, float radius, int color, float alpha) {
    }

    private static void drawHoverPill(Object mat, float x, float y, float width, float radius, float alpha) {
    }

    private static void drawIcon(Object mat, int icon, float x, float y, float width, float height, int color, float alpha) {
    }

    private static void drawText(int style, Object mat, String text, float x, float y, float size, int color, float alpha) {
    }

    private static float drawModifierText(Object mat, KeyLabel key, float x, float y, float size, int color, float alpha) {
        return x;
    }

    static {
        HINT_FONT = new Object();
        LABEL_FONT = new Object();
        CONFIG_ENTRIES = new ArrayList<ConfigEntry>();
    }

    public static final class ConfigEntry {
        public String name = "";
        public KeyEntry keybind;
    }

    public static final class KeyEntry {
        public Object callback;
        public int key;
        public int modifiers;
    }

    public static final class KeyLabel {
        public int modifiers;
        public String text;

        public KeyLabel(int modifiers, String text) {
            this.modifiers = modifiers;
            this.text = text;
        }
    }
}

