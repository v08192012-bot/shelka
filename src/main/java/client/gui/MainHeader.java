/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.Component;
import client.gui.IconButton;
import client.gui.Screen;

public class MainHeader
extends Component {
    public static final int VTABLE_RVA = 12599776;
    public static final int RECT_ANIM_OFFSET = 32;
    public static final int OWNED_BUFFER_A_OFFSET = 72;
    public static final int OWNED_BUFFER_B_OFFSET = 80;
    public static final int FLAG_58_OFFSET = 88;
    public static final int CALLBACK_STORAGE_1_OFFSET = 96;
    public static final int CALLBACK_1_OFFSET = 152;
    public static final int CALLBACK_STORAGE_2_OFFSET = 160;
    public static final int CALLBACK_2_OFFSET = 216;
    public static final int CALLBACK_STORAGE_3_OFFSET = 224;
    public static final int CALLBACK_3_OFFSET = 280;
    public static final int CALLBACK_STORAGE_4_OFFSET = 288;
    public static final int CALLBACK_4_OFFSET = 344;
    public static final int EXPANDED_OFFSET = 352;
    public static final int COLLAPSED_OFFSET = 353;
    public static final int TEXT_OFFSET = 360;
    public static final int EDIT_BUFFER_OFFSET = 392;
    public static final int MARKER_ANIM_OFFSET = 424;
    public static final int COMMITTING_OFFSET = 464;
    public static final int MARKER_DIR_OFFSET = 468;
    public static final int MARKER_ALT_OFFSET = 472;
    public static final int ICON_SWAP_OFFSET = 480;
    public static final int BUTTON_SIDEBAR_OFFSET = 488;
    public static final int BUTTON_FAVORITES_OFFSET = 736;
    public static final int BUTTON_LANGUAGE_OFFSET = 984;
    public static final int BUTTON_LIGHT_OFFSET = 1232;
    public static final int BUTTON_DARK_OFFSET = 1480;
    public static final int BUTTON_COLLAPSE_OFFSET = 1728;
    public static final int COLLAPSE_ANIM_OFFSET = 1976;
    public static final int THEME_ANIM_OFFSET = 2016;
    public static final int SEARCH_ANIM_OFFSET = 2056;
    public static final int SEARCH_READY_OFFSET = 2096;
    public static final int SEARCH_HOVER_ANIM_OFFSET = 2104;
    public static final int SEARCH_X_OFFSET = 2144;
    public static final int SEARCH_Y_OFFSET = 2148;
    public static final int BUTTON_ICON_OFFSET = 96;
    public static final int BUTTON_KEY_OFFSET = 100;
    public static final int BUTTON_SIZE_OFFSET = 108;
    public static final int BUTTON_TEXT_OFFSET = 216;
    public static final int BUTTON_CALLBACK_OFFSET = 208;
    public static final float DEFAULT_WIDTH = 964.0f;
    public static final float DEFAULT_HEIGHT = 50.0f;
    public static final float HEADER_INSET = 16.0f;
    public static final float HEADER_HEIGHT = 32.0f;
    public static final float PANEL_HEIGHT = 50.0f;
    public static final float PANEL_RADIUS = 18.0f;
    public static final float BUTTON_PANEL_SIZE = 42.0f;
    public static final float BUTTON_SIZE = 36.0f;
    public static final float BUTTON_SIZE_WIDE = 46.0f;
    public static final float BUTTON_GAP = 3.0f;
    public static final float BUTTON_ROW_INSET = 4.0f;
    public static final float TITLE_GAP = 6.0f;
    public static final float TITLE_INSET = 1.0f;
    public static final float FONT_SIZE = 14.0f;
    public static final float SEARCH_WIDTH = 300.0f;
    public static final float SEARCH_INNER_WIDTH = 294.0f;
    public static final float SEARCH_HEIGHT = 42.0f;
    public static final float SEARCH_RADIUS = 12.0f;
    public static final float TEXT_INSET_Y = 7.0f;
    public static final float CLEAR_TEXT_OFFSET = 4.0f;
    public static final float COLLAPSE_OFFSET = 46.0f;
    public static final float MARKER_DURATION = 0.18f;
    public static final float FADE_DURATION = 0.22f;
    public static final float SEARCH_DURATION = 0.32f;
    public static final float REVEAL_EXPONENT = 1.7f;
    public static final float EPSILON = 0.001f;
    public static final float NEAR_ONE = 0.999f;
    public static final float HALF = 0.5f;
    public static final float MARKER_STEP = 3.0f;
    public static final float MARKER_CLEARANCE = 8.0f;
    public static final float ICON_GAP = 12.0f;
    public static final float LABEL_GAP = 18.0f;
    public static final float CLEAR_SIZE = 20.0f;
    public static final float CLEAR_OFFSET = 10.0f;
    public static final float CLEAR_INSET = 8.0f;
    public static final float INFO_RIGHT_INSET = 8.0f;
    public static final long INFO_INTERVAL_MS = 60000L;
    public static final int KEY_FAVORITES = 14;
    public static final int KEY_NONE = 89;
    public static final int ICON_COLLAPSE = 16;
    public static final int ICON_EXPAND = 15;
    public static final int ICON_SIDEBAR = 5;
    public static final int ICON_FAVORITES = 13;
    public static final int ICON_LANGUAGE = 19;
    public static final int ICON_LIGHT = 17;
    public static final int ICON_DARK = 18;
    public static final int SEARCH_GLYPH = 9;
    public static final int SEARCH_CLEAR_GLYPH = 74;
    public static final int FAVORITE_GLYPH = 5;
    public static final String LABEL_SIDEBAR = "\u0411\u043e\u043a\u043e\u0432\u0430\u044f \u043f\u0430\u043d\u0435\u043b\u044c";
    public static final String LABEL_FAVORITES = "\u0418\u0437\u0431\u0440\u0430\u043d\u043d\u043e\u0435";
    public static final String LABEL_LIGHT = "\u0421\u0432\u0435\u0442\u043b\u0430\u044f \u0442\u0435\u043c\u0430";
    public static final String LABEL_LIGHT_DISABLED = "\u0421\u0432\u0435\u0442\u043b\u0430\u044f \u0442\u0435\u043c\u0430 \u043d\u0435\u0434\u043e\u0441\u0442\u0443\u043f\u043d\u0430 \u0441 \u043f\u0440\u043e\u0437\u0440\u0430\u0447\u043d\u043e\u0439 \u0442\u0435\u043c\u043e\u0439";
    public static final String LABEL_DARK = "\u0422\u0451\u043c\u043d\u0430\u044f \u0442\u0435\u043c\u0430";
    public static final String LABEL_COLLAPSE = "\u0421\u0432\u0435\u0440\u043d\u0443\u0442\u044c \u0432\u0441\u0451";
    public static final String LABEL_EXPAND = "\u0420\u0430\u0437\u0432\u0435\u0440\u043d\u0443\u0442\u044c";
    public static final String LABEL_EN = "Switch to EN";
    public static final String LABEL_RU = "Switch to RU";
    public static final String TEXT_INITIAL = "All";
    public static final String SEARCH_PLACEHOLDER = "\u041f\u043e\u0438\u0441\u043a";
    public static final String SEARCH_CLEAR_TEXT = "\u00d7";
    public static final String INFO_FORMAT = "{} ms";
    public static final String INFO_EMPTY = "- ms";
    protected final Anim rectAnim = new Anim();
    protected long ownedBufferA;
    protected long ownedBufferB;
    protected byte flag58;
    protected final byte[] callbackStorage1 = new byte[56];
    protected Object callback1;
    protected final byte[] callbackStorage2 = new byte[56];
    protected Object callback2;
    protected final byte[] callbackStorage3 = new byte[56];
    protected Object callback3;
    protected final byte[] callbackStorage4 = new byte[56];
    protected Object callback4;
    protected byte expanded;
    protected byte collapsed;
    protected String text = "All";
    protected String editBuffer = "";
    protected final Anim markerAnim = new Anim();
    protected byte committing;
    protected int markerDir = 1;
    protected int markerAlt = 1;
    protected byte iconSwap;
    protected IconButton sidebarButton;
    protected IconButton favoritesButton;
    protected IconButton languageButton;
    protected IconButton lightButton;
    protected IconButton darkButton;
    protected IconButton collapseButton;
    protected final Anim collapseAnim = new Anim();
    protected final Anim themeAnim = new Anim();
    protected final Anim searchAnim = new Anim();
    protected boolean searchReady;
    protected final Anim searchHoverAnim = new Anim();
    protected float searchX;
    protected float searchY;
    protected long infoStamp;
    protected static int frameMillis;
    private static final float ONE = 1.0f;
    private static final float RECT_ANIM_DURATION = 0.15f;

    public MainHeader() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.width = 0.0f;
        this.height = 0.0f;
        this.flags = 256;
        this.rectAnim.set(0.0f, 0.15f);
        this.ownedBufferA = 0L;
        this.ownedBufferB = 0L;
        this.flag58 = 0;
        this.callback1 = null;
        this.callback2 = null;
        this.callback3 = null;
        this.callback4 = null;
        this.expanded = 0;
        this.collapsed = 0;
        this.text = TEXT_INITIAL;
        this.editBuffer = "";
        this.markerAnim.from = 1.0f;
        this.markerAnim.current = 1.0f;
        this.markerAnim.target = 1.0f;
        this.markerAnim.duration = 0.18f;
        this.markerAnim.easing = 0;
        this.markerAnim.start = Anim.now();
        this.markerAnim.running = false;
        this.committing = 0;
        this.markerDir = 1;
        this.markerAlt = 1;
        this.iconSwap = 0;
        this.sidebarButton = new IconButton(5, 36.0f);
        this.favoritesButton = new IconButton(13, 36.0f);
        this.languageButton = new IconButton(19, 36.0f);
        this.lightButton = new IconButton(17, 36.0f);
        this.darkButton = new IconButton(18, 36.0f);
        this.collapseButton = new IconButton(16, 36.0f);
        this.collapseAnim.set(1.0f, 0.22f);
        this.themeAnim.set(MainHeader.themeLight() ? 1.0f : 0.0f, 0.22f);
        this.searchAnim.from = 0.0f;
        this.searchAnim.current = 0.0f;
        this.searchAnim.target = 0.0f;
        this.searchAnim.duration = 0.32f;
        this.searchAnim.easing = 2;
        this.searchAnim.start = Anim.now();
        this.searchAnim.running = false;
        this.searchHoverAnim.set(0.0f, 0.15f);
        this.width = 964.0f;
        this.height = 50.0f;
        this.markerAnim.easing = 1;
        MainHeader.setButtonSize(this.sidebarButton, 0.0f);
        MainHeader.setButtonSize(this.favoritesButton, 0.0f);
        MainHeader.setButtonSize(this.languageButton, 0.0f);
        MainHeader.setButtonSize(this.lightButton, 0.0f);
        MainHeader.setButtonSize(this.darkButton, 0.0f);
        MainHeader.setButtonSize(this.collapseButton, 0.0f);
        MainHeader.setButtonWidth(this.lightButton, 46.0f);
        MainHeader.setButtonWidth(this.darkButton, 46.0f);
        MainHeader.setButtonLabel(this.sidebarButton, LABEL_SIDEBAR);
        MainHeader.setButtonCallback(this.sidebarButton, MainHeader.createSidebarAction());
        MainHeader.setButtonLabel(this.collapseButton, LABEL_COLLAPSE);
        MainHeader.setButtonCallback(this.collapseButton, MainHeader.createCollapseAction());
        MainHeader.setButtonLabel(this.lightButton, LABEL_LIGHT);
        MainHeader.setButtonCallback(this.lightButton, MainHeader.createLightAction());
        MainHeader.setButtonLabel(this.darkButton, LABEL_DARK);
        MainHeader.setButtonCallback(this.darkButton, MainHeader.createDarkAction());
        MainHeader.setButtonCallback(this.languageButton, MainHeader.createLanguageAction());
        MainHeader.setButtonKey(this.favoritesButton, 14);
        MainHeader.setButtonLabel(this.favoritesButton, LABEL_FAVORITES);
        MainHeader.setButtonCallback(this.favoritesButton, MainHeader.createFavoritesAction());
    }

    @Override
    public void dispose() {
        MainHeader.resetString(360);
        MainHeader.resetString(392);
        MainHeader.clearButton(this.collapseButton);
        MainHeader.clearButton(this.darkButton);
        MainHeader.clearButton(this.lightButton);
        MainHeader.clearButton(this.languageButton);
        MainHeader.clearButton(this.favoritesButton);
        MainHeader.clearButton(this.sidebarButton);
        MainHeader.freeString(392);
        MainHeader.freeString(360);
        MainHeader.releaseChild(this.callback4, this.callback4 != this.callbackStorage4);
        this.callback4 = null;
        MainHeader.releaseChild(this.callback3, this.callback3 != this.callbackStorage3);
        this.callback3 = null;
        MainHeader.releaseChild(this.callback2, this.callback2 != this.callbackStorage2);
        this.callback2 = null;
        MainHeader.releaseChild(this.callback1, this.callback1 != this.callbackStorage1);
        this.callback1 = null;
        super.dispose();
    }

    @Override
    public void render(Object mat, float mouseX, float mouseY, float alpha) {
        float headerX = this.x + 16.0f;
        float headerWidth = this.width - 32.0f;
        Object panel = MainHeader.drawPanelTinted(mat, headerX, this.y, headerWidth, 50.0f, 18.0f, alpha);
        float fVar12 = this.y + 4.0f;
        float fVar13 = headerX + 4.0f;
        float fVar16 = 18.0f;
        this.drawButtonRow(panel, mat, this.sidebarButton, fVar13, fVar12, fVar16, mouseX, mouseY, alpha);
        this.drawFavoritesBadge(this, mat, fVar13, fVar12, alpha);
        float fVar16b = this.y;
        float marker = this.markerAnim.advance(Anim.now());
        if (this.committing != 0 && marker <= 0.001f) {
            if (!this.text.equals(this.editBuffer)) {
                this.text = this.editBuffer;
            }
            this.editBuffer = "";
            this.committing = 0;
            this.markerAnim.duration = 0.18f;
            this.markerAnim.easing = 1;
            this.markerAnim.retarget(1.0f);
            marker = this.markerAnim.advance(Anim.now());
        }
        int dir = -this.markerDir;
        if (this.committing == 0) {
            dir = this.markerDir;
        }
        float value = MainHeader.clamp01(marker);
        value = (float)Math.pow(value, 1.7f);
        MainHeader.drawText(mat, this.text, fVar13 + 42.0f + 6.0f, (1.0f - marker) * 6.0f * (float)dir + fVar16b + 18.0f, 14.0f, MainHeader.themeColor(24), value * alpha);
        this.drawSearchField(mat, mouseX, mouseY, headerX, headerWidth, alpha);
        this.renderRightButtons(mat, mouseX, mouseY, headerX, headerWidth, alpha);
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        IconButton[] order;
        for (IconButton child : order = new IconButton[]{this.sidebarButton, this.collapseButton, this.lightButton, this.darkButton, this.languageButton, this.favoritesButton}) {
            boolean collapseReady;
            boolean bl = collapseReady = child != this.collapseButton || 0.5f <= this.collapseAnim.current;
            if (!collapseReady || button != 0 || !(child.x <= (float)mx) || !(mx <= (double)(child.x + child.width)) || !(child.y <= (float)my) || !(my <= (double)(child.y + child.height)) || !MainHeader.invokeButton(child, mx, my)) continue;
            return true;
        }
        if (button == 0 && this.searchX <= (float)mx && mx <= (double)(this.searchX + 300.0f) && this.searchY <= (float)my && my <= (double)(this.searchY + 42.0f)) {
            if (this.callback4 != null) {
                MainHeader.invokeCallback(this.callback4);
            }
            return true;
        }
        return false;
    }

    public void renderRightButtons(Object mat, float mouseX, float mouseY, float headerX, float headerWidth, float alpha) {
        this.iconSwap = (byte)(16 - (this.expanded != 0 ? 1 : 0));
        MainHeader.setButtonLabel(this.collapseButton, this.expanded != 0 ? LABEL_EXPAND : LABEL_COLLAPSE);
        MainHeader.setButtonLabel(this.languageButton, MainHeader.russianActive() ? LABEL_RU : LABEL_EN);
        if (MainHeader.themeLightAvailable() != this.collapsed) {
            this.collapsed = MainHeader.themeLightAvailable();
            MainHeader.setButtonLabel(this.lightButton, this.collapsed != 0 ? LABEL_LIGHT : LABEL_LIGHT_DISABLED);
        }
        float inset = 4.0f;
        float rightY = this.y + inset;
        float rightEdge = headerX + headerWidth - inset;
        float collapse = this.collapseAnim.advance(Anim.now());
        float collapseX = rightEdge - 42.0f;
        float cursor = rightEdge - collapse * 42.0f;
        if (0.001f < collapse) {
            cursor -= collapse * inset;
        }
        float languageX = (cursor -= 46.0f) - 46.0f;
        float favoritesX = languageX + -46.0f;
        Object handle = this.drawButtonRow(Float.valueOf(collapseX), mat, this.favoritesButton, favoritesX, rightY, 18.0f, mouseX, mouseY, alpha);
        this.drawButtonRow(handle, mat, this.languageButton, languageX, rightY, 18.0f, mouseX, mouseY, alpha);
        MainHeader.drawPanel(mat, cursor, rightY, 46.0f, 42.0f, 14.0f, alpha, 1.0f);
        if (0.001f < collapse) {
            float value = MainHeader.clamp01(collapse);
            value = (float)Math.pow(value, 1.7f);
            this.drawButtonRow(Float.valueOf(value * alpha), mat, this.collapseButton, collapseX, rightY, 18.0f, mouseX, mouseY, alpha);
        }
        float themeTarget = MainHeader.themeLight() ? 1.0f : 0.0f;
        this.themeAnim.retarget(themeTarget);
        float theme = this.themeAnim.advance(Anim.now());
        float lightX = cursor + 3.0f;
        float darkX = lightX + 46.0f + 3.0f;
        float themeY = rightY + 3.0f;
        MainHeader.drawThemeTrack(mat, (darkX - lightX) * theme + lightX, themeY, 46.0f, 46.0f, alpha);
        this.lightButton.x = lightX;
        this.lightButton.y = themeY;
        MainHeader.renderButton(this.lightButton, mat, mouseX, mouseY, alpha);
        this.darkButton.x = darkX;
        this.darkButton.y = themeY;
        MainHeader.renderButton(this.darkButton, mat, mouseX, mouseY, alpha);
        long tick = MainHeader.tickCount();
        if (60000L < tick - this.infoStamp) {
            this.infoStamp = tick;
            MainHeader.collectInfo();
        }
        String info = frameMillis >= 0 ? MainHeader.formatTemplate(INFO_FORMAT, frameMillis) : INFO_EMPTY;
        float infoWidth = MainHeader.measureText(info, 12.0f);
        MainHeader.drawTextAligned(mat, info, favoritesX - 8.0f - infoWidth, themeY, 14.0f, MainHeader.themeColor(24), alpha);
    }

    private Object drawButtonRow(Object handle, Object mat, IconButton button, float x, float y, float font, float mouseX, float mouseY, float alpha) {
        MainHeader.drawPanel(mat, x, y, 42.0f, 42.0f, 14.0f, alpha, 1.0f);
        float bx = x + 3.0f;
        float by = y + 3.0f;
        MainHeader.drawRoundedQuad(mat, bx, by, 36.0f, 36.0f, 12.0f, MainHeader.accentColor(), alpha);
        button.x = bx;
        button.y = by;
        MainHeader.renderButton(button, mat, mouseX, mouseY, alpha);
        return handle;
    }

    private void drawFavoritesBadge(MainHeader header, Object mat, float x, float y, float alpha) {
        float target = 1.0f;
        if (this.collapsed == 0) {
            target = 0.0f;
        }
        if (!this.searchReady) {
            this.searchAnim.from = target;
            this.searchAnim.current = target;
            this.searchAnim.target = target;
            this.searchAnim.running = false;
            this.searchReady = true;
        }
        this.searchAnim.retarget(target);
        float value = this.searchAnim.advance(Anim.now());
        float size = MainHeader.measureGlyph(5);
        float gy = (46.0f - MainHeader.measureGlyphHeight(5)) * 0.5f + y + 3.0f;
        float gx = (46.0f - size) * 0.5f + x + 3.0f;
        int catColor = MainHeader.themeColor(24);
        int eyeColor = MainHeader.themeColor(8);
        if (eyeColor == catColor) {
            eyeColor = (catColor & 0xFF000000) | Math.max(0, ((catColor & 0x00FFFFFF) - 0x222222));
        }
        float d = size > 1.0f ? size : 24.0f;
        float fr = d * 0.40f;
        float er = d * 0.13f;
        float ey = d * 0.06f;
        float ew = d * 0.12f;
        MainHeader.drawRoundedQuad(mat, gx - d * 0.26f - er, gy - d * 0.30f - er, er * 2.0f, er * 2.0f, er, catColor, alpha);
        MainHeader.drawRoundedQuad(mat, gx + d * 0.26f - er, gy - d * 0.30f - er, er * 2.0f, er * 2.0f, er, catColor, alpha);
        MainHeader.drawRoundedQuad(mat, gx - fr, gy - fr, fr * 2.0f, fr * 2.0f, fr, catColor, alpha);
        MainHeader.drawRoundedQuad(mat, gx - ew - ey, gy - d * 0.02f - ey, ey * 2.0f, ey * 2.0f, ey, eyeColor, alpha);
        MainHeader.drawRoundedQuad(mat, gx + ew - ey, gy - d * 0.02f - ey, ey * 2.0f, ey * 2.0f, ey, eyeColor, alpha);
        MainHeader.drawRoundedQuad(mat, gx - d * 0.04f, gy + d * 0.10f, d * 0.08f, d * 0.06f, d * 0.03f, eyeColor, alpha);
    }

    private void drawSearchField(Object mat, float mouseX, float mouseY, float headerX, float headerWidth, float alpha) {
        float target;
        float searchTop = this.y + 4.0f;
        float centered = (headerWidth - 300.0f) * 0.5f + headerX;
        this.searchY = searchTop;
        this.searchX = centered;
        if (mouseX < centered || centered + 300.0f < mouseX || mouseY < searchTop || searchTop + 42.0f < mouseY || Screen.focusedInput != null && !Screen.allowHover) {
            target = 0.0f;
        } else {
            Screen.hoveredWidget = 1;
            target = 1.0f;
        }
        this.searchHoverAnim.retarget(target);
        float hover = this.searchHoverAnim.advance(Anim.now());
        float fade = (hover * 0.5f + 0.5f) * alpha;
        MainHeader.drawPanel(mat, this.searchX, this.searchY, 300.0f, 42.0f, 14.0f, fade, 1.0f);
        float innerX = this.searchX + 3.0f;
        float innerY = this.searchY + 3.0f;
        MainHeader.drawRoundedQuad(mat, innerX, innerY, 294.0f, 36.0f, 12.0f, MainHeader.accentColor(), fade);
        float glyphY = innerY + 18.0f;
        float glyphW = MainHeader.measureGlyph(9);
        float glyphH = MainHeader.measureGlyphHeight(9);
        MainHeader.drawGlyph(mat, 9, innerX + 12.0f, glyphY - glyphH * 0.5f, glyphW, glyphH, MainHeader.themeColor(24), fade);
        MainHeader.drawText(mat, SEARCH_PLACEHOLDER, innerX + 12.0f + glyphW + 6.0f, glyphY - 7.0f, 14.0f, MainHeader.themeColor(24), fade);
        float clearWidth = MainHeader.measureText(SEARCH_CLEAR_TEXT, 12.0f) + 8.0f;
        float clearY = glyphY - 10.0f;
        float clearX = innerX + 294.0f - 12.0f - clearWidth;
        MainHeader.drawRoundedQuad(mat, clearX, clearY, clearWidth, 20.0f, 12.0f, MainHeader.themeColor(8), fade);
        MainHeader.drawText(mat, SEARCH_CLEAR_TEXT, clearX + 4.0f, clearY + 4.0f, 12.0f, MainHeader.themeColor(24), fade);
    }

    private static boolean themeLight() {
        return MainHeader.themeMode() == 1;
    }

    private static byte themeLightAvailable() {
        return 0;
    }

    private static boolean russianActive() {
        return false;
    }

    private static int themeMode() {
        return 0;
    }

    private static int accentColor() {
        return 0;
    }

    private static int themeColor(int offset) {
        return 0;
    }

    private static float clamp01(float value) {
        if (value < 0.0f) {
            return 0.0f;
        }
        if (value > 1.0f) {
            return 1.0f;
        }
        return value;
    }

    private static void setButtonSize(IconButton button, float size) {
    }

    private static void setButtonWidth(IconButton button, float width) {
    }

    private static void setButtonKey(IconButton button, int key) {
    }

    private static void setButtonLabel(IconButton button, String text) {
    }

    private static void setButtonCallback(IconButton button, Object action) {
    }

    private static Object createSidebarAction() {
        return null;
    }

    private static Object createCollapseAction() {
        return null;
    }

    private static Object createLightAction() {
        return null;
    }

    private static Object createDarkAction() {
        return null;
    }

    private static Object createLanguageAction() {
        return null;
    }

    private static Object createFavoritesAction() {
        return null;
    }

    private static void clearButton(IconButton button) {
    }

    private static boolean invokeButton(IconButton button, double mx, double my) {
        return false;
    }

    private static void renderButton(IconButton button, Object mat, float mouseX, float mouseY, float alpha) {
    }

    private static void invokeCallback(Object action) {
    }

    private static void releaseChild(Object sub, boolean heap) {
    }

    private static void resetString(int offset) {
    }

    private static void freeString(int offset) {
    }

    private static Object drawPanelTinted(Object mat, float x, float y, float width, float height, float radius, float alpha) {
        return null;
    }

    private static void drawPanel(Object mat, float x, float y, float width, float height, float radius, float alpha, float style) {
    }

    private static void drawRoundedQuad(Object mat, float x, float y, float width, float height, float radius, int color, float alpha) {
    }

    private static void drawThemeTrack(Object mat, float x, float y, float width, float height, float alpha) {
    }

    private static void drawText(Object mat, String text, float x, float y, float size, int color, float alpha) {
    }

    private static void drawTextAligned(Object mat, String text, float x, float y, float size, int color, float alpha) {
    }

    private static void drawGlyph(Object mat, int glyph, float x, float y, float width, float height, int color, float alpha) {
    }

    private static void drawTexturePlaceholder(Object mat, float angle, float x, float y) {
    }

    private static float measureText(String text, float size) {
        return 0.0f;
    }

    private static float measureGlyph(int glyph) {
        return 0.0f;
    }

    private static float measureGlyphHeight(int glyph) {
        return 0.0f;
    }

    private static float glyphX(int glyph) {
        return 0.0f;
    }

    private static float glyphY(int glyph) {
        return 0.0f;
    }

    private static long tickCount() {
        return 0L;
    }

    private static void collectInfo() {
    }

    private static String formatTemplate(String template, int value) {
        return template;
    }

    public static final class Anim {
        public static final int ANIM_FROM = 0;
        public static final int ANIM_CURRENT = 4;
        public static final int ANIM_TARGET = 8;
        public static final int ANIM_DURATION = 12;
        public static final int ANIM_EASING = 16;
        public static final int ANIM_START = 24;
        public static final int ANIM_RUNNING = 32;
        public static final int EASING_CUBIC = 0;
        public static final int EASING_EXPO = 1;
        public static final int EASING_IN_OUT_CUBIC = 2;
        float from;
        float current;
        float target;
        float duration;
        int easing;
        long start;
        boolean running;

        void set(float value, float duration) {
            this.from = value;
            this.current = value;
            this.target = value;
            this.duration = duration;
            this.easing = 0;
            this.start = Anim.now();
            this.running = false;
        }

        void retarget(float target) {
            float value;
            if (this.target == target) {
                return;
            }
            long time = Anim.now();
            this.from = value = this.advance(time);
            this.target = target;
            this.start = time;
            this.running = true;
        }

        float advance(long time) {
            if (!this.running || this.duration <= 0.0f) {
                this.current = this.target;
                this.running = false;
                return this.current;
            }
            float k = (float)((double)(time - this.start) / 1.0E9) / this.duration;
            if (k <= 0.0f) {
                this.current = this.from;
                return this.current;
            }
            if (k >= 1.0f) {
                this.running = false;
                this.current = this.target;
                return this.current;
            }
            this.current = this.ease(k) * (this.target - this.from) + this.from;
            return this.current;
        }

        float ease(float t) {
            if (this.easing == 1) {
                return Anim.easeOutExpo(t);
            }
            if (this.easing == 2) {
                return Anim.easeInOutCubic(t);
            }
            return Anim.easeOutCubic(t);
        }

        static long now() {
            return System.nanoTime();
        }

        static float easeOutCubic(float t) {
            float inv = 1.0f - t;
            return 1.0f - inv * inv * inv;
        }

        static float easeOutExpo(float t) {
            return 1.0f - (float)Math.pow(2.0, -10.0 * (double)t);
        }

        static float easeInOutCubic(float t) {
            if (t < 0.5f) {
                return 4.0f * t * t * t;
            }
            float inv = 2.0f - 2.0f * t;
            return 1.0f - inv * inv * inv / 2.0f;
        }
    }
}

