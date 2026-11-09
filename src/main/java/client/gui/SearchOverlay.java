/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.AbstractOverlay;
import client.gui.Component;
import client.gui.Screen;
import client.gui.SearchRow;
import client.gui.TextInput;
import java.util.ArrayList;
import java.util.List;

public class SearchOverlay
extends AbstractOverlay {
    public static final int VTABLE_RVA = 12601888;
    public static final long RVA_CTOR = 1427584L;
    public static final long RVA_DTOR = 1124800L;
    public static final long RVA_MOUSE_CLICKED = 1461760L;
    public static final long RVA_MOUSE_RELEASED = 1462336L;
    public static final long RVA_MOUSE_MOVED = 1462496L;
    public static final long RVA_MOUSE_SCROLLED = 1462720L;
    public static final long RVA_KEY_PRESSED = 1462992L;
    public static final long RVA_KEY_RELEASED = 1463200L;
    public static final long RVA_CHAR_TYPED = 1463296L;
    public static final long RVA_OVERLAY_CONST = 1427264L;
    public static final long RVA_RENDER_BODY = 1456016L;
    public static final long RVA_ON_MOUSE_CLICKED = 1461952L;
    public static final long RVA_ON_KEY_PRESSED = 1463424L;
    public static final long RVA_LAYOUT = 1464800L;
    public static final long RVA_RENDER_HEADER = 1456560L;
    public static final long RVA_RENDER_ROWS = 1458432L;
    public static final long RVA_RENDER_ITEM = 1460400L;
    public static final long RVA_MOVE_SELECTION = 1464048L;
    public static final long RVA_SELECT_INDEX = 1463824L;
    public static final long RVA_ERASE_VISIBLE = 1476624L;
    public static final long RVA_ADD_TARGET = 1454112L;
    public static final long RVA_RELEASE_COLLECTIONS = 1428864L;
    public static final long RVA_SET_INPUT_CALLBACK = 1427152L;
    public static final int OFF_ITEM_ACTION = 264;
    public static final int OFF_TARGET_ACTION = 328;
    public static final int OFF_DISMISS_ACTION = 392;
    public static final int OFF_TEXT_INPUT = 400;
    public static final int OFF_INPUT_TEXT_SIZE = 432;
    public static final int OFF_INPUT_FOCUS_FLAG = 436;
    public static final int OFF_INPUT_ACTIVE = 437;
    public static final int OFF_INPUT_HOVER = 438;
    public static final int OFF_INPUT_LINE_A = 440;
    public static final int OFF_INPUT_LINE_B = 472;
    public static final int OFF_INPUT_RESERVED = 544;
    public static final int OFF_TARGETS = 608;
    public static final int OFF_ENTRIES = 640;
    public static final int OFF_ROWS = 664;
    public static final int OFF_VISIBLE = 688;
    public static final int OFF_OPEN_ANIM_VALUE = 712;
    public static final int OFF_SELECTED_INDEX = 716;
    public static final int OFF_HOVER_DAMP = 720;
    public static final int OFF_ITEM_DAMP = 728;
    public static final int OFF_SELECT_ANIM = 736;
    public static final int OFF_HEADER_ANIM = 776;
    public static final int OFF_INPUT_ANIM = 816;
    public static final int OFF_SCROLL_ANIM = 856;
    public static final int OFF_SCROLL = 896;
    public static final int OFF_CONTENT_TOP = 900;
    public static final int OFF_CONTENT_BOTTOM = 904;
    public static final int OFF_LAST_MOUSE_X = 908;
    public static final int OFF_LAST_MOUSE_Y = 912;
    public static final int OFF_MOUSE_VALID = 916;
    public static final int OFF_TARGET_MAP = 920;
    public static final int OFF_INPUT_TOUCHED = 960;
    public static final int OFF_ITEM_TYPE = 32;
    public static final int OFF_ITEM_TITLE = 40;
    public static final int OFF_ITEM_SUBTITLE = 72;
    public static final int OFF_ITEM_SUBTITLE_LEN = 88;
    public static final int OFF_ITEM_CHILD = 104;
    public static final int OFF_ITEM_ALT_CHILD = 112;
    public static final int OFF_ITEM_ACTION_REF = 168;
    public static final int OFF_ITEM_ACTION_ALT = 176;
    public static final int OFF_ITEM_REVEAL = 184;
    public static final int OFF_ITEM_OFFSET = 188;
    public static final int OFF_ITEM_ALPHA_ANIM = 200;
    public static final int OFF_ITEM_EXIT_A = 204;
    public static final int OFF_ITEM_EXIT_B = 208;
    public static final int ITEM_TYPE_HEADER = 0;
    public static final int ITEM_TYPE_DIVIDER = 1;
    public static final int ITEM_TYPE_ROW = 2;
    public static final int ITEM_TYPE_ROW_ALT = 3;
    public static final int ITEM_TYPE_STATE = 4;
    public static final float PANEL_WIDTH = 500.0f;
    public static final float PANEL_HEIGHT = 50.0f;
    public static final float PANEL_MAX_WIDTH = 480.0f;
    public static final float PANEL_MARGIN_Y = 50.0f;
    public static final float ROW_WIDTH = 484.0f;
    public static final float ROW_HEIGHT = 36.0f;
    public static final float ROW_HEIGHT_ALT = 32.0f;
    public static final float HEADER_HEIGHT = 42.0f;
    public static final float INPUT_HEIGHT = 36.0f;
    public static final float LIST_TOP_OFFSET = 46.0f;
    public static final float SCROLL_STEP = 48.0f;
    public static final float HOVER_DAMP = 0.1f;
    public static final float HOVER_DAMP_MIN = 0.11f;
    public static final float ITEM_DAMP = 0.1f;
    public static final float ITEM_DAMP_MIN = 0.06f;
    public static final float VISIBLE_EPSILON = 0.001f;
    public static final float INPUT_TEXT_SIZE = 14.0f;
    public static final float DEFAULT_DURATION = 0.15f;
    public static final float SCROLL_DURATION = 0.28f;
    public static final int HOVER_SOUND_IN = 8;
    public static final int HOVER_SOUND_OUT = 9;
    public static final int ICON_SEARCH = 9;
    public static final int ICON_CLEAR = 80;
    public static final int ICON_LOADING = 12;
    public static final int HOVERED_WIDGET_SEARCH = 2;
    private static final String HINT_TEXT = "SearchOverlay.hint";
    private static final String QUERY_TEXT = "SearchOverlay.query";
    private static final String LOADING_ICON_TEXT = "SearchOverlay.loading";
    private static final String STATE_LABEL_SHORT = "SearchOverlay.stateShort";
    private static final String STATE_LABEL_LONG = "SearchOverlay.stateLong";
    private final List<Item> targets = new ArrayList<Item>();
    private final List<Item> entries = new ArrayList<Item>();
    private final List<Item> rows = new ArrayList<Item>();
    private final List<Item> visible = new ArrayList<Item>();
    private final TextInput textInput = new TextInput();
    private Object itemAction = null;
    private Object targetAction = null;
    private Object dismissAction = null;
    private float openAnimValue = 0.0f;
    private int selectedIndex = -1;
    private float hoverDampValue = 0.0f;
    private float hoverDampVelocity = 0.0f;
    private float itemDampValue = 0.0f;
    private float itemDampVelocity = 0.0f;
    private float inputTextSize = 14.0f;
    private boolean focusFlag = false;
    private boolean inputActive = false;
    private boolean inputHover = false;
    private float scroll = 0.0f;
    private float contentTop = 0.0f;
    private float contentBottom = 0.0f;
    private float lastMouseX = 0.0f;
    private float lastMouseY = 0.0f;
    private boolean mouseValid = false;
    private Object targetMap;
    private boolean inputTouched = false;
    private final AbstractOverlay.Animator selectAnim = new AbstractOverlay.Animator(0.0f, 0.15f, 0);
    private final AbstractOverlay.Animator headerAnim = new AbstractOverlay.Animator(0.0f, 0.15f, 0);
    private final AbstractOverlay.Animator inputAnim = new AbstractOverlay.Animator(0.0f, 0.15f, 0);
    private final AbstractOverlay.Animator scrollAnim = new AbstractOverlay.Animator(0.0f, 0.28f, 2);

    public SearchOverlay() {
        SearchOverlay.resetAnimator(this.selectAnim, 0.0f, 0.15f, 0);
        SearchOverlay.resetAnimator(this.headerAnim, 0.0f, 0.15f, 0);
        SearchOverlay.resetAnimator(this.inputAnim, 0.0f, 0.15f, 0);
        SearchOverlay.resetAnimator(this.scrollAnim, 0.0f, 0.28f, 2);
        SearchOverlay.registerTargetMap();
        this.inputActive = true;
        this.width = 500.0f;
        this.height = 50.0f;
        SearchOverlay.setInputChangedCallback(this.textInput);
    }

    @Override
    public void dispose() {
        SearchOverlay.clearTargetMapEntries();
        SearchOverlay.clearTargetMap();
        SearchOverlay.releaseCollections();
        SearchOverlay.releaseCallback(264);
        SearchOverlay.releaseCallback(328);
        SearchOverlay.releaseCallback(392);
        SearchOverlay.clearTargetMap();
        SearchOverlay.releaseTargetMapStorage();
        SearchOverlay.releaseVisibleList();
        SearchOverlay.releaseRowList();
        SearchOverlay.releaseEntryList();
        SearchOverlay.releaseTargetList();
        SearchOverlay.releaseInputField();
        SearchOverlay.releaseCallback(392);
        SearchOverlay.releaseCallback(328);
        SearchOverlay.releaseCallback(264);
        super.dispose();
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        for (Item item : this.rows) {
            SearchRow row = item == null ? null : item.child;
            if (row == null || row.controls == null || !SearchOverlay.controlsCaptured(row.controls)) continue;
            if ((double)this.x <= mx && mx <= (double)(this.x + this.width) && (double)this.y <= my && my <= (double)(this.y + this.height)) {
                row.mouseClicked(mx, my, button);
                return true;
            }
            SearchOverlay.controlsSetCaptured(row.controls, false);
            SearchOverlay.controlsSetLastInput(row.controls, 0);
            return true;
        }
        return super.mouseClicked(mx, my, button);
    }

    @Override
    public boolean mouseReleased(double mx, double my, int button) {
        for (Item item : this.rows) {
            SearchRow row = item == null ? null : item.child;
            if (row == null || row.controls == null || !SearchOverlay.controlsStateA(row.controls, 496, mx, my, button)) continue;
            return true;
        }
        return true;
    }

    @Override
    public boolean mouseMoved(double mx, double my, double delta) {
        for (Item item : this.rows) {
            SearchRow row = item == null ? null : item.child;
            if (row == null || row.controls == null || !SearchOverlay.controlsStateB(row.controls, 496, mx, my, 0)) continue;
            return true;
        }
        return true;
    }

    @Override
    public boolean mouseScrolled(double mx, double my, double amount) {
        if ((double)this.x <= mx && mx <= (double)(this.x + this.width) && (double)this.contentTop <= my && my <= (double)(this.contentBottom - this.contentTop + this.contentTop)) {
            float next;
            float maxScroll;
            float limit = this.openAnimValue + 50.0f;
            if (480.0f <= limit) {
                limit = 480.0f;
            }
            if ((maxScroll = this.openAnimValue - (limit - 8.0f - 42.0f)) <= 0.0f) {
                maxScroll = 0.0f;
            }
            float result = (next = this.scroll - (float)amount * 48.0f) <= 0.0f ? 0.0f : (next <= maxScroll ? next : maxScroll);
            this.scroll = result;
            SearchOverlay.animate(this.scrollAnim, result);
        }
        return true;
    }

    @Override
    public boolean keyPressed(int keyCode, int modifiers) {
        this.inputTouched = false;
        for (Item item : this.rows) {
            SearchRow row = item == null ? null : item.child;
            if (row == null || row.controls == null || !SearchOverlay.controlsCaptured(row.controls)) continue;
            SearchOverlay.controlsKeyA(row.controls, keyCode);
            this.inputTouched = true;
            return true;
        }
        if (keyCode == 27 && SearchOverlay.inputHasContent()) {
            SearchOverlay.clearInputLine();
            return true;
        }
        if (this.closeOnEscape && keyCode == 27) {
            this.close();
            return true;
        }
        return this.onKeyPressed(keyCode, modifiers);
    }

    @Override
    public boolean keyReleased(int keyCode) {
        for (Item item : this.rows) {
            SearchRow row = item == null ? null : item.child;
            if (row == null || row.controls == null || !SearchOverlay.controlsCaptured(row.controls)) continue;
            SearchOverlay.controlsKeyB(row.controls, keyCode);
            return true;
        }
        return true;
    }

    @Override
    public boolean charTyped(char ch) {
        if (!this.inputTouched) {
            for (Item item : this.rows) {
                SearchRow row = item == null ? null : item.child;
                if (row == null || row.controls == null || !SearchOverlay.controlsCaptured(row.controls)) continue;
                this.inputTouched = false;
                return true;
            }
            this.inputTouched = false;
            SearchOverlay.textInputCharTyped(this.textInput, ch);
            return true;
        }
        this.inputTouched = false;
        return true;
    }

    @Override
    public float overlayConst() {
        return 18.0f;
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void renderBody(Object renderer, float mouseX, float mouseY, float alpha) {
        float heightValue;
        float limit;
        this.layout();
        if (this.closed) {
            limit = 50.0f;
        } else {
            limit = this.openAnimValue + 50.0f;
            if (480.0f <= limit) {
                limit = 480.0f;
            }
        }
        this.hoverDampValue = heightValue = SearchOverlay.smoothDamp(this.hoverDampValue, limit, 0.1f, 0.11f);
        this.hoverDampVelocity = SearchOverlay.smoothDampVelocity(heightValue, this.hoverDampVelocity);
        float alphaClamped = alpha;
        if (alphaClamped < 0.0f) {
            alphaClamped = 0.0f;
        }
        if (alphaClamped > 1.0f) {
            alphaClamped = 1.0f;
        }
        float halfWidth = this.width * 0.5f;
        this.height = heightValue;
        float top = (1.0f - alphaClamped) * 16.0f + this.y;
        float[] rect = SearchOverlay.makeRect(renderer, alpha, halfWidth + this.x, heightValue * 0.5f + top);
        SearchOverlay.drawBackdrop(rect, this.x, top, this.width, this.height, 18.0f, alpha);
        this.renderHeader(rect, alpha, top);
        this.renderRows(rect, mouseX, mouseY, alpha, top);
        if (this.x <= mouseX && mouseX <= this.x + this.width && this.y <= mouseY && mouseY <= this.y + 46.0f) {
            Screen.hoveredWidget = 2;
        }
    }

    @Override
    public boolean onMouseClicked(double mx, double my, int button) {
        if (my < (double)this.contentTop || my > (double)this.contentBottom) {
            return true;
        }
        for (int index = 0; index < this.rows.size(); ++index) {
            Item item = this.rows.get(index);
            if (item.type != 2 && item.type != 3) continue;
            if (item.child != null && item.child.mouseClicked(mx, my, button)) {
                return true;
            }
            SearchRow hit = item.child;
            if (hit == null) {
                hit = item.altChild;
            }
            if (hit == null || !((double)hit.x <= mx) || !(mx <= (double)(hit.x + hit.width)) || !((double)hit.y <= my) || !(my <= (double)(hit.y + hit.height))) continue;
            this.selectedIndex = index;
            if (button != 1) {
                if (button != 0) {
                    return true;
                }
                if (item.actionAlt == null) {
                    return true;
                }
                SearchOverlay.invokeCallback(item.actionAlt);
                return true;
            }
            if (item.child == null) {
                return true;
            }
            Component toggle = (Component)SearchOverlay.readPointer(item.child, 104);
            if (toggle == null) {
                return true;
            }
            boolean state = SearchOverlay.readBool(toggle);
            SearchOverlay.writeBool(toggle, !state);
            return true;
        }
        return true;
    }

    @Override
    public boolean onKeyPressed(int keyCode, int modifiers) {
        switch (keyCode) {
            case 9: {
                this.moveSelection((int)(((long)(modifiers & 1) ^ 1L) * 2L - 1L), true);
                return true;
            }
            case 13: {
                this.handleEnterKey(modifiers);
                SearchOverlay.textInputKeyPressed(this.textInput, keyCode, modifiers);
                return true;
            }
            case 33: {
                this.moveSelection(-5, false);
                return true;
            }
            case 34: {
                this.moveSelection(5, false);
                return true;
            }
            case 38: {
                this.moveSelection(-1, true);
                return true;
            }
            case 40: {
                this.moveSelection(1, true);
                return true;
            }
        }
        SearchOverlay.textInputKeyPressed(this.textInput, keyCode, modifiers);
        return true;
    }

    private void handleEnterKey(int modifiers) {
        Component handle;
        boolean toggle;
        boolean bl = toggle = (modifiers & 1) != 0 || (modifiers & 2) != 0;
        if (this.selectedIndex < 0) {
            return;
        }
        Item item = this.rows.get(this.selectedIndex);
        if (toggle && item.child != null && (handle = (Component)SearchOverlay.readPointer(item.child, 104)) != null) {
            boolean state = SearchOverlay.readBool(handle);
            SearchOverlay.writeBool(handle, !state);
            return;
        }
        if (item.actionAlt != null) {
            SearchOverlay.invokeCallback(item.actionAlt);
        }
    }

    private void layout() {
        SearchOverlay.initGuiMetrics();
        float scale = SearchOverlay.guiScale();
        float screenW = SearchOverlay.screenWidth();
        float screenH = SearchOverlay.screenHeight();
        this.x = Math.round((screenW / scale - this.width) * 0.5f);
        this.y = Math.round((screenH / scale - 480.0f) * 0.5f);
    }

    private void renderHeader(Object renderer, float alpha, float top) {
        float target = SearchOverlay.inputHasContent() ? 1.0f : 0.0f;
        if (this.headerAnim.target != target) {
            long time = this.now();
            float current = SearchOverlay.advance(this.headerAnim, time);
            this.headerAnim.start = time;
            this.headerAnim.from = current;
            this.headerAnim.target = target;
            this.headerAnim.running = true;
        }
        float headerValue = SearchOverlay.advance(this.headerAnim, this.now());
        float innerAlpha = (headerValue * 0.5f + 0.5f) * alpha;
        float left = this.x + 4.0f;
        float rowTop = top + 4.0f;
        float innerWidth = this.width - 8.0f;
        SearchOverlay.drawHeaderPlate(renderer, left, rowTop, innerWidth, 42.0f, 14.0f, innerAlpha, 1);
        float fieldLeft = left + 3.0f;
        float fieldTop = rowTop + 3.0f;
        float fieldWidth = innerWidth - 6.0f;
        SearchOverlay.drawHeaderPlateInner(renderer, fieldLeft, fieldTop, fieldWidth, 36.0f, 12.0f, SearchOverlay.headerPanelStyle(), innerAlpha);
        float iconTop = fieldTop + 18.0f;
        float[] icon = SearchOverlay.uiIconMetrics(9);
        SearchOverlay.uiDrawIcon(renderer, 9, fieldLeft + 12.0f, iconTop - icon[1] * 0.5f, icon[0], icon[1], SearchOverlay.uiThemeColor(SearchOverlay.uiTheme(), 24), innerAlpha);
        float inputTarget = !SearchOverlay.inputHasContent() || this.selectedIndex < 0 ? 0.0f : 1.0f;
        if (this.inputAnim.target != inputTarget) {
            long time = this.now();
            float current = SearchOverlay.advance(this.inputAnim, time);
            this.inputAnim.start = time;
            this.inputAnim.from = current;
            this.inputAnim.target = inputTarget;
            this.inputAnim.running = true;
        }
        float inputValue = SearchOverlay.advance(this.inputAnim, this.now());
        float hintWidth = SearchOverlay.measureText(0, HINT_TEXT, 12.0f);
        float boxWidth = SearchOverlay.measureText(0, QUERY_TEXT, 12.0f) + hintWidth + 2.0f + 8.0f;
        float boxTop = iconTop - 10.0f;
        float right = fieldWidth + fieldLeft;
        float value = (20.0f - boxWidth) * inputValue + boxWidth;
        float boxLeft = right - 12.0f - value;
        SearchOverlay.drawInputBox(renderer, boxLeft, boxTop, value, 20.0f, SearchOverlay.uiThemeColor(SearchOverlay.uiTheme(), 8), innerAlpha);
        SearchOverlay.setScissor(boxLeft, boxTop, value, 20.0f);
        if (inputValue < 0.999f) {
            float faded = (1.0f - inputValue) * alpha;
            SearchOverlay.drawText(2, renderer, HINT_TEXT, boxLeft + 4.0f, boxTop + 4.0f, 12.0f, SearchOverlay.uiThemeColor(SearchOverlay.uiTheme(), 24), faded);
            SearchOverlay.drawText(2, renderer, QUERY_TEXT, boxLeft + 4.0f + hintWidth + 2.0f, boxTop + 4.0f, 12.0f, SearchOverlay.uiThemeColor(SearchOverlay.uiTheme(), 24), faded);
        }
        if (0.001f < inputValue) {
            float[] clearIcon = SearchOverlay.uiIconMetrics(80);
            SearchOverlay.uiDrawIcon(renderer, 80, (value - clearIcon[0]) * 0.5f + boxLeft, (20.0f - clearIcon[1]) * 0.5f + boxTop, clearIcon[0], clearIcon[1], SearchOverlay.uiThemeColor(SearchOverlay.uiTheme(), 24), inputValue * alpha);
        }
        SearchOverlay.resetScissor();
        float listLeft = fieldLeft + 12.0f + icon[0] + 6.0f;
        float listWidth = boxLeft - 6.0f - listLeft;
        if (listWidth <= 0.0f) {
            listWidth = 0.0f;
        }
        SearchOverlay.setScissor(listLeft, fieldTop, listWidth, 36.0f);
        float fade = 1.0f - headerValue;
        if (0.001f < fade) {
            float clamped = fade;
            if (clamped <= 0.0f) {
                clamped = 0.0f;
            }
            if (clamped > 1.0f) {
                clamped = 1.0f;
            }
            float eased = (float)Math.pow(clamped, 1.7);
            SearchOverlay.drawText(5, renderer, LOADING_ICON_TEXT, headerValue * 7.0f + listLeft, iconTop - 7.0f, 14.0f, SearchOverlay.uiThemeColor(SearchOverlay.uiTheme(), 24), eased * alpha);
        }
        SearchRow focused = null;
        for (Item item : this.rows) {
            SearchRow row = item == null ? null : item.child;
            if (row == null || row.controls == null || !SearchOverlay.controlsCaptured(row.controls)) continue;
            focused = row;
            break;
        }
        SearchOverlay.renderInputWidget(renderer, listLeft, iconTop - 7.0f, listWidth, SearchOverlay.uiThemeColor(SearchOverlay.uiTheme(), 24), alpha, focused == null);
        SearchOverlay.resetScissor();
    }

    private void renderRows(Object renderer, float mouseX, float mouseY, float alpha, float top) {
        float clipHeight;
        float selectTarget;
        Item candidate;
        float clampedScroll;
        this.contentBottom = top + this.height - 4.0f;
        this.contentTop = top + 4.0f + 42.0f;
        float maxScroll = this.openAnimValue + 50.0f;
        if (480.0f <= maxScroll) {
            maxScroll = 480.0f;
        }
        if ((maxScroll = this.openAnimValue - (maxScroll - 8.0f - 42.0f)) <= 0.0f) {
            maxScroll = 0.0f;
        }
        if ((clampedScroll = this.scroll) <= 0.0f) {
            clampedScroll = 0.0f;
        }
        if (!(clampedScroll <= maxScroll)) {
            clampedScroll = maxScroll;
        }
        this.scroll = clampedScroll;
        if (this.scrollAnim.target != clampedScroll) {
            long time = this.now();
            float current = SearchOverlay.advance(this.scrollAnim, time);
            this.scrollAnim.start = time;
            this.scrollAnim.from = current;
            this.scrollAnim.target = clampedScroll;
            this.scrollAnim.running = true;
        }
        float scrollValue = SearchOverlay.advance(this.scrollAnim, this.now());
        float listY = this.contentTop - scrollValue;
        float rowLeft = this.x + 4.0f + 4.0f;
        boolean mouseMoved = !this.mouseValid ? false : (mouseX != this.lastMouseX || Float.isNaN(mouseY) || Float.isNaN(this.lastMouseY) ? true : mouseY != this.lastMouseY);
        this.lastMouseY = mouseY;
        this.lastMouseX = mouseX;
        this.mouseValid = true;
        Item selected = null;
        if (this.selectedIndex >= 0 && this.selectedIndex < this.rows.size() && (candidate = this.rows.get(this.selectedIndex)) != null && candidate.type == 2) {
            selected = candidate;
        }
        float f = selectTarget = selected == null ? 0.0f : 1.0f;
        if (this.selectAnim.target != selectTarget) {
            long time = this.now();
            float current = SearchOverlay.advance(this.selectAnim, time);
            this.selectAnim.start = time;
            this.selectAnim.from = current;
            this.selectAnim.target = selectTarget;
            this.selectAnim.running = true;
        }
        float selectValue = SearchOverlay.advance(this.selectAnim, this.now());
        if (selected != null) {
            if (selectValue <= 0.001f) {
                this.itemDampValue = selected.reveal;
                this.itemDampVelocity = 0.0f;
            }
            this.itemDampValue = SearchOverlay.smoothDamp(this.itemDampValue, selected.reveal, 0.1f, 0.06f);
            this.itemDampVelocity = SearchOverlay.smoothDampVelocity(this.itemDampValue, this.itemDampVelocity);
        }
        float thumbStart = this.clampRange(scrollValue / 24.0f);
        float thumbSize = this.clampRange((maxScroll - scrollValue) / 24.0f);
        boolean needsLayers = 0.001f < thumbStart || 0.001f < thumbSize;
        float thumbValue = thumbStart;
        if (needsLayers) {
            SearchOverlay.beginClipLayer();
        }
        if ((clipHeight = this.contentBottom - this.contentTop) <= 0.0f) {
            clipHeight = 0.0f;
        }
        SearchOverlay.setScissor(this.x, this.contentTop, this.width, clipHeight);
        if (0.001f < selectValue) {
            float backdropAlpha = 1.0f;
            if (selected != null) {
                backdropAlpha = selected.exitA;
            }
            SearchOverlay.drawBackdrop(renderer, rowLeft - 1.0f, listY + this.itemDampValue + 2.0f - 1.0f, 486.0f, 38.0f, 14.0f, selectValue * alpha * backdropAlpha);
        }
        for (Item item : new ArrayList<Item>(this.visible)) {
            if (item == null) continue;
            this.renderItem(renderer, item, listY, mouseX, mouseY, alpha);
        }
        int hoverIndex = -1;
        for (int index = 0; index < this.rows.size(); ++index) {
            SearchRow alternate;
            boolean isSelected;
            float rowWidth = 484.0f;
            float rowExtent = 36.0f;
            Item item = this.rows.get(index);
            boolean bl = isSelected = index == this.selectedIndex;
            if (item.child != null) {
                item.child.selected = isSelected;
            }
            if ((alternate = item.altChild) != null) {
                alternate.selected = isSelected;
            }
            this.renderItem(renderer, item, listY, mouseX, mouseY, alpha);
            if (!mouseMoved || item.type != 2 && item.type != 3 || !(this.contentTop <= mouseY) || !(mouseY <= this.contentBottom)) continue;
            float rowTop = listY + item.offset + 2.0f;
            if (item.type == 3) {
                rowExtent = 32.0f;
            }
            if (!(rowLeft <= mouseX) || !(mouseX <= rowLeft + rowWidth) || !(rowTop <= mouseY) || !(mouseY <= rowExtent + rowTop)) continue;
            hoverIndex = index;
        }
        SearchOverlay.resetScissor();
        if (needsLayers) {
            float matScaleX = 0.0f;
            float matOffsetY = 0.0f;
            float matOffsetX = 0.0f;
            float[] rectA = new float[10];
            float[] rectB = new float[10];
            float common = matOffsetY + matOffsetX;
            rectA[0] = (this.contentTop + 18.0f) * matScaleX + common;
            rectB[6] = (this.contentBottom - 18.0f) * matScaleX + common;
            rectA[1] = matScaleX * this.contentTop + common;
            rectA[3] = matScaleX * this.contentBottom + common;
            rectA[8] = thumbValue;
            SearchOverlay.drawScrollbar(1.0f, rectA, rectB);
        }
        this.compactVisible();
        if (hoverIndex >= 0 && hoverIndex != this.selectedIndex) {
            this.selectedIndex = hoverIndex;
        }
    }

    private void renderItem(Object renderer, Item item, float listY, float mouseX, float mouseY, float alpha) {
        item.offset = SearchOverlay.smoothDamp(item.offset, item.reveal, 0.1f, 0.06f);
        item.offsetVelocity = SearchOverlay.smoothDampVelocity(item.offset, item.offsetVelocity);
        float value = SearchOverlay.advance(item.alphaAnim, this.now());
        float itemTop = listY + item.offset;
        float reveal = value * alpha;
        if (!(0.001f < reveal && this.contentTop <= itemTop + 96.0f && itemTop <= this.contentBottom)) {
            return;
        }
        int type = item.type;
        float left = this.x + 4.0f + 4.0f;
        if (type == 0) {
            float headerLeft = left + 8.0f;
            float headerAlpha = reveal * 0.5f;
            float textTop = itemTop + 4.0f + 8.0f;
            SearchOverlay.drawText(3, renderer, item.title, headerLeft, textTop, 12.0f, SearchOverlay.uiThemeColor(SearchOverlay.uiTheme(), 24), headerAlpha);
            if (!item.subtitle.isEmpty()) {
                float titleWidth = SearchOverlay.measureText(0, item.title, 12.0f);
                SearchOverlay.drawText(2, renderer, item.subtitle, titleWidth + (headerLeft + 6.0f), textTop, 12.0f, SearchOverlay.uiThemeColor(SearchOverlay.uiTheme(), 16), headerAlpha);
            }
        } else if (type == 1) {
            SearchOverlay.drawBoxGradient(renderer, this.x + 4.0f, itemTop + 4.0f, this.width - 8.0f, 1.0f, 0.0f, SearchOverlay.uiThemeColor(SearchOverlay.uiTheme(), 12), reveal);
        } else if (type == 2) {
            SearchRow row = item.child;
            float rowY = itemTop + 2.0f;
            row.x = left;
            row.y = rowY;
            row.render(renderer, mouseX, mouseY, reveal);
        } else if (type == 3) {
            SearchRow row = item.altChild;
            float rowY = itemTop + 2.0f;
            row.x = left;
            row.y = rowY;
            this.renderAltRow(row, renderer, mouseX, mouseY, reveal);
        } else if (type == 4) {
            float phase = item.exitA;
            float stateTop = itemTop + 18.0f;
            float spin = phase * 3.0f;
            float centerX = this.width * 0.5f + this.x;
            float wave = (float)Math.sin((spin + spin) * (float)Math.PI);
            SearchOverlay.uiDrawIcon(renderer, 9, wave * (1.0f - phase) * 4.0f + (centerX - 10.0f), stateTop, 20.0f, 20.0f, SearchOverlay.uiThemeColor(SearchOverlay.uiTheme(), 16), reveal);
            float labelTop = stateTop + 20.0f + 10.0f;
            float labelWidth = SearchOverlay.measureText(0, STATE_LABEL_SHORT, 14.0f);
            SearchOverlay.drawText(5, renderer, STATE_LABEL_SHORT, centerX - labelWidth * 0.5f, labelTop, 14.0f, SearchOverlay.uiThemeColor(SearchOverlay.uiTheme(), 24), reveal);
            float hintWidth = SearchOverlay.measureText(0, STATE_LABEL_LONG, 12.0f);
            SearchOverlay.drawText(0, renderer, STATE_LABEL_LONG, centerX - hintWidth * 0.5f, labelTop + 14.0f + 6.0f, 12.0f, SearchOverlay.uiThemeColor(SearchOverlay.uiTheme(), 16), reveal);
        }
    }

    private void moveSelection(int delta, boolean wrap) {
        int position;
        ArrayList<Integer> selectable = new ArrayList<Integer>();
        for (int index = 0; index < this.rows.size(); ++index) {
            int type = this.rows.get((int)index).type;
            if (type != 2 && type != 3) continue;
            selectable.add(index);
        }
        if (selectable.isEmpty()) {
            return;
        }
        int count = selectable.size();
        for (position = 0; position < count && (Integer)selectable.get(position) < this.selectedIndex; ++position) {
        }
        if (position == count && 0 < delta) {
            position = -1;
        }
        int last = count - 1;
        int next = !wrap ? (position < 0 ? 0 : (position <= last ? position : last)) : (count + (position += delta) % count) % count;
        this.selectIndex((Integer)selectable.get(next), true);
    }

    private void selectIndex(int index, boolean reveal) {
        float view;
        float itemTop;
        this.selectedIndex = index;
        if (!reveal || index < 0) {
            return;
        }
        Item item = this.rows.get(index);
        float anchor = itemTop = item.reveal + 2.0f;
        if (0 < index && this.rows.get((int)(index - 1)).type == 0) {
            anchor = this.rows.get((int)(index - 1)).reveal;
        }
        float extent = 36.0f;
        if (item.type == 3) {
            extent = 32.0f;
        }
        if ((view = this.scroll) + 4.0f <= anchor) {
            float limit = this.openAnimValue + 50.0f;
            if (480.0f <= limit) {
                limit = 480.0f;
            }
            float maxScroll = limit - 8.0f - 42.0f;
            float next = view;
            if (itemTop + extent <= maxScroll + view) {
                this.scroll = next;
                SearchOverlay.animate(this.scrollAnim, next);
                return;
            }
            this.scroll = next = itemTop + extent + 4.0f - maxScroll;
            SearchOverlay.animate(this.scrollAnim, next);
            return;
        }
        this.scroll = anchor;
        SearchOverlay.animate(this.scrollAnim, anchor);
    }

    private void compactVisible() {
        Item item;
        int keep;
        int size = this.visible.size();
        for (keep = 0; !(keep >= size || (item = this.visible.get(keep)) == null || item.exitB <= 0.001f && item.exitA <= 0.001f); ++keep) {
        }
        if (keep != size) {
            for (int scan = keep + 1; scan < size; ++scan) {
                Item candidate = this.visible.get(scan);
                if (candidate == null || !(0.001f < candidate.exitB) && !(0.001f < candidate.exitA)) continue;
                this.visible.set(scan, null);
                Item moved = this.visible.get(keep);
                this.visible.set(keep, candidate);
                if (moved != null) {
                    SearchOverlay.releaseItem(moved);
                }
                ++keep;
            }
        }
        for (int tail = this.visible.size() - 1; tail >= keep; --tail) {
            Item removed = this.visible.remove(tail);
            if (removed == null) continue;
            SearchOverlay.releaseItem(removed);
        }
    }

    private void addTarget(List<Item> items, Object target, List<Object> crumbs) {
        Object row;
        if (SearchOverlay.readByte(target, 32) == 1) {
            Object entry = SearchOverlay.findOrCreateEntry(target, crumbs, 3);
            if (SearchOverlay.readPointer(entry, 112) == null) {
                Object tile = SearchOverlay.createTile(SearchOverlay.readPointer(target, 56));
                SearchOverlay.writePointer(entry, 112, tile);
                SearchOverlay.writeFloat(tile, 16, 484.0f);
                SearchOverlay.initTile(tile);
            }
            SearchOverlay.bindCrumbs(entry, 120);
            SearchOverlay.releaseCrumbs(crumbs);
            return;
        }
        Object entry = SearchOverlay.findOrCreateEntry(target, crumbs, 0);
        if (SearchOverlay.readPointer(entry, 104) == null) {
            row = new SearchRow(SearchOverlay.readInt(target, 36), 0.0f, 0.0f, 0.0f, 0.0f, SearchOverlay.readPointer(target, 40));
            SearchOverlay.writePointer(entry, 104, row);
        }
        row = SearchOverlay.readPointer(entry, 104);
        SearchOverlay.setRowCrumbs(row, SearchOverlay.takeCrumbs(crumbs));
        if (SearchOverlay.readInt(target, 32) < 0) {
            SearchOverlay.bindCrumbs(entry, 120);
        } else {
            SearchOverlay.bindCrumbsAlt(entry, 120);
        }
        SearchOverlay.releaseCrumbs(crumbs);
    }

    private float clampRange(float value) {
        if (value <= 0.0f) {
            return 0.0f;
        }
        if (value <= 1.0f) {
            return value;
        }
        return 1.0f;
    }

    private void renderAltRow(SearchRow row, Object renderer, float mouseX, float mouseY, float alpha) {
    }

    private static void clearTargetMapEntries() {
    }

    private static void clearTargetMap() {
    }

    private static void releaseTargetMapStorage() {
    }

    private static void releaseCollections() {
    }

    private static void releaseVisibleList() {
    }

    private static void releaseRowList() {
    }

    private static void releaseEntryList() {
    }

    private static void releaseTargetList() {
    }

    private static void releaseInputField() {
    }

    private static void releaseItem(Object item) {
    }

    private static void releaseCrumbs(List<Object> crumbs) {
    }

    private static void releaseCallback(int offset) {
    }

    private static void registerTargetMap() {
    }

    private static void bindCrumbs(Object entry, int offset) {
    }

    private static void bindCrumbsAlt(Object entry, int offset) {
    }

    private static void setRowCrumbs(Object row, List<Object> crumbs) {
    }

    private static List<Object> takeCrumbs(List<Object> crumbs) {
        ArrayList<Object> moved = new ArrayList<Object>(crumbs);
        crumbs.clear();
        return moved;
    }

    private static Object createTile(Object handle) {
        return null;
    }

    private static void initTile(Object tile) {
    }

    private static Object findOrCreateEntry(Object target, List<Object> crumbs, int kind) {
        return null;
    }

    private static <T> T readPointer(Object target, int offset) {
        return null;
    }

    private static void writePointer(Object target, int offset, Object value) {
    }

    private static int readInt(Object target, int offset) {
        return 0;
    }

    private static int readByte(Object target, int offset) {
        return 0;
    }

    private static float readFloat(Object target, int offset) {
        return 0.0f;
    }

    private static void writeFloat(Object target, int offset, float value) {
    }

    private static boolean readBool(Object target) {
        return false;
    }

    private static void writeBool(Object target, boolean value) {
    }

    private static void invokeCallback(Object callback) {
    }

    private static boolean controlsCaptured(Object controls) {
        return false;
    }

    private static void controlsSetCaptured(Object controls, boolean value) {
    }

    private static void controlsSetLastInput(Object controls, int value) {
    }

    private static boolean controlsStateA(Object controls, int offset, double mx, double my, int button) {
        return false;
    }

    private static boolean controlsStateB(Object controls, int offset, double mx, double my, int button) {
        return false;
    }

    private static boolean controlsKeyA(Object controls, int keyCode) {
        return false;
    }

    private static boolean controlsKeyB(Object controls, int keyCode) {
        return false;
    }

    private static boolean inputHasContent() {
        return false;
    }

    private static void clearInputLine() {
    }

    private static void setInputChangedCallback(TextInput input) {
    }

    private static void textInputCharTyped(TextInput input, char ch) {
    }

    private static void textInputKeyPressed(TextInput input, int keyCode, int modifiers) {
    }

    private static void renderInputWidget(Object renderer, float x, float y, float w, int color, float alpha, boolean focused) {
    }

    private static void initGuiMetrics() {
    }

    private static float guiScale() {
        return 1.0f;
    }

    private static int screenWidth() {
        return 0;
    }

    private static int screenHeight() {
        return 0;
    }

    private static float smoothDamp(float value, float target, float smoothTime, float maxSpeed) {
        return target;
    }

    private static float smoothDampVelocity(float value, float velocity) {
        return 0.0f;
    }

    private static float[] makeRect(Object renderer, float alpha, float right, float bottom) {
        return new float[8];
    }

    private static void drawBackdrop(Object rect, float x, float y, float w, float h, float radius, float alpha) {
    }

    private static void drawHeaderPlate(Object renderer, float x, float y, float w, float h, float radius, float alpha, int flags) {
    }

    private static void drawHeaderPlateInner(Object renderer, float x, float y, float w, float h, float radius, int style, float alpha) {
    }

    private static int headerPanelStyle() {
        return 0;
    }

    private static void drawInputBox(Object renderer, float x, float y, float w, float h, int color, float alpha) {
    }

    private static void drawBoxGradient(Object renderer, float x, float y, float w, float h, float color, int themeIndex, float alpha) {
    }

    private static void drawText(int style, Object renderer, String text, float x, float y, float size, int color, float alpha) {
    }

    private static float measureText(int style, String text, float size) {
        return 0.0f;
    }

    private static void drawScrollbar(float depth, float[] rectA, float[] rectB) {
    }

    private static void beginClipLayer() {
    }

    private static void setScissor(float x, float y, float w, float h) {
    }

    private static void resetScissor() {
    }

    public static int uiThemeColor(Object theme, int offset) {
        return 0;
    }

    public static Object uiTheme() {
        return null;
    }

    public static final class Item {
        public int type;
        public String title = "";
        public String subtitle = "";
        public SearchRow child;
        public SearchRow altChild;
        public Object action;
        public Object actionAlt;
        public float reveal;
        public float offset;
        public float offsetVelocity;
        public float exitA;
        public float exitB;
        public final AbstractOverlay.Animator alphaAnim = new AbstractOverlay.Animator(0.0f, 0.15f, 0);
    }
}

