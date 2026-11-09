/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.AbstractCollectionPart;
import client.gui.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class BoardToolbar
extends Component {
    public static final long VTABLE_RVA = 12588312L;
    public static final long RVA_CTOR = 2735200875184L;
    public static final long RVA_DTOR_BODY = 2735200877456L;
    public static final long RVA_DELETING_DTOR = 2735200816896L;
    public static final long RVA_RENDER = 2735200882816L;
    public static final long RVA_MOUSE_CLICKED = 2735200883728L;
    public static final long RVA_KEY_PRESSED = 2735200884176L;
    public static final long RVA_KEY_RELEASED = 2735200884192L;
    public static final long RVA_SET_TAB = 2735200878672L;
    public static final long RVA_SELF_HIT = 2735200779200L;
    public static final long RVA_TAB_HIT = 2735200886336L;
    public static final long RVA_BUTTON_HOVER = 2735200900528L;
    public static final long RVA_PLATE_HIT = 2735201081008L;
    public static final long RVA_PLATE_KEY = 2735201081136L;
    public static final long RVA_PLATE_HOVER = 2735201078176L;
    public static final long RVA_PLATE_TEXT = 2735201079152L;
    public static final long RVA_PLATE_CLEAR = 2735201078320L;
    public static final long RVA_TEXT_INPUT_KEY = 2735203205536L;
    public static final long RVA_ANIM_EXPO_INIT = 2735200778960L;
    public static final long RVA_ANIM_CUBIC_INIT = 2735200856400L;
    public static final long RVA_ANIM_ADVANCE = 2735200831600L;
    public static final long RVA_ANIM_TARGET = 2735200831376L;
    public static final long RVA_PLATE_INIT = 2735201076624L;
    public static final long RVA_BUTTON_INIT = 2735200892208L;
    public static final long RVA_BUTTON_CALLBACK = 2735200874960L;
    public static final long RVA_BUTTON_RENDER = 2735200892624L;
    public static final long RVA_PLATE_CALLBACK = 2735200871840L;
    public static final long RVA_WIDGET_INIT = 2735200896912L;
    public static final long RVA_WIDGET_RENDER = 2735200898848L;
    public static final long RVA_WIDGET_SIZE = 2735200898288L;
    public static final long RVA_WIDGET_CALLBACK = 2735200875072L;
    public static final long RVA_PLATE_RENDER = 2735201079504L;
    public static final long RVA_ROW_RENDER = 2735200879072L;
    public static final long RVA_BG_RENDER = 2735200822832L;
    public static final long RVA_BG_RENDER2 = 2735200823104L;
    public static final long RVA_BG_RENDER3 = 2735200824272L;
    public static final long RVA_TAB_VECTOR_CTOR = 2735200884512L;
    public static final long RVA_TABSTATE_COPY = 2735200885872L;
    public static final long RVA_TAB_VECTOR_GROW = 2735200884704L;
    public static final long RVA_TAB_DTOR = 2735200877344L;
    public static final long RVA_STRING_SET = 2735199764880L;
    public static final long RVA_PLAY_SOUND = 2735199719200L;
    public static final long RVA_NOW = 2735199714128L;
    public static final long RVA_NOOP = 2735199916496L;
    public static final int SLOT_DTOR = 0;
    public static final int SLOT_RENDER = 8;
    public static final int SLOT_MOUSE_CLICKED = 32;
    public static final int SLOT_KEY_PRESSED = 64;
    public static final int SLOT_KEY_RELEASED = 80;
    public static final int SLOT_SET_POSITION = 88;
    public static final int OFF_CHILDREN_END = 152;
    public static final int OFF_TAB_LISTENER = 152;
    public static final int OFF_TABSTATE_BEGIN = 416;
    public static final int OFF_TABSTATE_END = 424;
    public static final int OFF_TABSTATE_CAP = 432;
    public static final int OFF_SELECTED_TAB = 440;
    public static final int OFF_TAB_LAYOUT_INDEX = 444;
    public static final int OFF_TAB_ANIM1 = 448;
    public static final int OFF_TAB_MENU_ACTION = 288;
    public static final int OFF_TAB_MENU_ACTION_IMPL = 344;
    public static final int OFF_LAYOUT_CALLBACK = 296;
    public static final int OFF_LAYOUT_CALLBACK_IMPL = 352;
    public static final int OFF_TAB_ANIM2 = 488;
    public static final int OFF_TAB_ANIM1_RUNNING = 528;
    public static final int OFF_TAB_ALPHA_FROM = 536;
    public static final int OFF_TAB_ALPHA = 540;
    public static final int OFF_TAB_ALPHA_TARGET = 544;
    public static final int OFF_TAB_ALPHA_DURATION = 548;
    public static final int OFF_TAB_ALPHA_EASE = 552;
    public static final int OFF_TAB_ALPHA_START = 560;
    public static final int OFF_TAB_ALPHA_RUNNING = 568;
    public static final int OFF_PLATE = 576;
    public static final int OFF_PLATE_WIDTH = 592;
    public static final int OFF_PLATE_Y = 584;
    public static final int OFF_PLATE_X = 588;
    public static final int OFF_OVERLAY_OPEN = 928;
    public static final int OFF_PLATE_END = 1304;
    public static final int OFF_KEY_FILTER = 1312;
    public static final int OFF_FIELD = 672;
    public static final int OFF_BUTTON1 = 1320;
    public static final int OFF_BUTTON1_Y = 1328;
    public static final int OFF_BUTTON1_H = 1332;
    public static final int OFF_BUTTON1_W = 1336;
    public static final int OFF_BUTTON1_FLAG = 1428;
    public static final int OFF_BUTTON1_TEXT = 1536;
    public static final int OFF_BUTTON2 = 1568;
    public static final int OFF_BUTTON2_X = 1576;
    public static final int OFF_BUTTON2_Y = 1580;
    public static final int OFF_BUTTON2_W = 1584;
    public static final int OFF_BUTTON2_FLAG = 1676;
    public static final int OFF_WIDGET1 = 1816;
    public static final int OFF_WIDGET1_X = 1824;
    public static final int OFF_WIDGET1_Y = 1828;
    public static final int OFF_WIDGET1_W = 1832;
    public static final int OFF_WIDGET1_TEXT = 1784;
    public static final int OFF_WIDGET2 = 2344;
    public static final int OFF_WIDGET2_X = 2352;
    public static final int OFF_WIDGET2_Y = 2356;
    public static final int OFF_WIDGET2_W = 2360;
    public static final int OFF_TAB_ROW_X = 2872;
    public static final int OFF_TAB_ROW_W = 2880;
    public static final int OFF_TAB_ROW_Y = 2876;
    public static final int OFF_SEARCH_ALPHA = 2484;
    public static final int OFF_LABEL1 = 2488;
    public static final int OFF_LABEL1_ALPHA = 2496;
    public static final int OFF_LABEL1_RUNNING = 2520;
    public static final int OFF_ROOT_FLAG = 924;
    public static final int OFF_TABSTATE_LABEL = 0;
    public static final int OFF_TABSTATE_CALLBACK = 32;
    public static final int OFF_TABSTATE_FLAG = 96;
    public static final int OFF_TABSTATE_CALLBACK2 = 104;
    public static final int OFF_TABSTATE_EXTRA = 0;
    public static final int OFF_TABSTATE_ANIM = 200;
    public static final int OFF_TABSTATE_ANIM_FROM = 200;
    public static final int OFF_TABSTATE_ANIM_CURRENT = 204;
    public static final int OFF_TABSTATE_ANIM_TARGET = 208;
    public static final int OFF_TABSTATE_ANIM_DURATION = 212;
    public static final int OFF_TABSTATE_ANIM_EASE = 216;
    public static final int OFF_TABSTATE_ANIM_START = 224;
    public static final int OFF_TABSTATE_ANIM_RUNNING = 232;
    public static final int OFF_TABSTATE_SELECTED = 320;
    public static final int OFF_TABSTATE_EXTRA_LABEL = 328;
    public static final int OFF_TABSTATE_INDEX = 360;
    public static final int OFF_TABSTATE_X = 364;
    public static final int OFF_TABSTATE_W = 368;
    public static final int TABSTATE_SIZE = 376;
    public static final int OFF_TAB_LABEL = 0;
    public static final int OFF_TAB_CALLBACK = 32;
    public static final int OFF_TAB_FLAG = 96;
    public static final int OFF_TAB_CALLBACK2 = 104;
    public static final int OFF_TAB_LABEL2 = 168;
    public static final int TAB_SIZE = 200;
    public static final String LABEL_BUTTON1 = "\u0421\u043f\u0438\u0441\u043a\u043e\u043c";
    public static final String LABEL_BUTTON2 = "\u041f\u043b\u0438\u0442\u043a\u0430\u043c\u0438";
    public static final long RVA_STR_BUTTON1 = 2735212270712L;
    public static final long RVA_STR_BUTTON2 = 2735212270728L;
    public static final int WIDGET_FLAG_88 = 136;
    public static final float WIDTH = 964.0f;
    public static final float HEIGHT = 36.0f;
    public static final float TAB_ANIM_DURATION = 0.32f;
    public static final float TAB_ALPHA_DURATION = 0.32f;
    public static final float TAB_FADE_DURATION = 0.22f;
    public static final float BUTTON_ANIM_DURATION = 0.36f;
    public static final float TAB_ROW_PAD = 2.0f;
    public static final float TAB_ROW_HEIGHT = 36.0f;
    public static final float ROW_STEP = 4.0f;
    public static final float ROW_STEP2 = 5.0f;
    public static final float ROW_EDGE = 4.0f;
    public static final float ROW_OFFSET = 3.0f;
    public static final float BG_PAD = 16.0f;
    public static final float BG_INSET = 32.0f;
    public static final float BG_HEIGHT = 50.0f;
    public static final float BG_RADIUS = 18.0f;
    public static final float BG_ROUND = 42.0f;
    public static final float BG_ROUND2 = 14.0f;
    public static final float BG_ROUND3 = 12.0f;
    public static final float TAB_ROW_HEIGHT2 = 36.0f;
    public static final float TAB_RADIUS = 12.0f;
    public static final float SEARCH_WIDTH = 100.0f;
    public static final float SEARCH_HEIGHT = 42.0f;
    public static final float SEARCH_RADIUS = 14.0f;
    public static final float SEARCH_INSET = 46.0f;
    public static final float TAB_ROW_INSET = 36.0f;
    public static final float SCROLL_EDGE = 2.0f;
    public static final float CLAMP_UNIT = 3.0f;
    public static final float HALF_SCALE = 0.5f;
    public static final float BG_ALPHA_OFF = 100.0f;
    public static final float BG_ALPHA_OFF2 = 46.0f;
    public static final float PLATE_WIDTH = 230.0f;
    public static final float BUTTON_SIZE = 46.0f;
    public static final float WIDGET_SHRINK = 4.0f;
    public static final float HALF = 0.5f;
    public static final float ANIM_EPSILON = 0.001f;
    public static final float ONE = 1.0f;
    public static final float ZERO = 0.0f;
    public static final float TAB_ALPHA_SHOWN = 1.0f;
    public static final float TAB_ALPHA_HIDDEN = 0.0f;
    public static final int LIST_LAYOUT_INDEX = 1;
    public static final int ICON_PLATE = 54;
    public static final int ICON_BUTTON1 = 79;
    public static final int ICON_BUTTON2 = 78;
    public static final int SOUND_TAB = 11;
    public static final int KEY_ESCAPE = 27;
    public static final int KEY_ENTER = 13;
    public Consumer<AbstractCollectionPart.BoardLayout> onLayoutRequested;
    public IntConsumer onTabChanged;
    public Consumer<String> onTitleChanged;
    public Runnable onClose;
    public Runnable onTabMenuAction;
    public TabListener tabListener;
    public final List<TabState> tabStates = new ArrayList<TabState>();
    public int selectedTab = -1;
    public int tabLayoutIndex;
    public final AbstractCollectionPart.Anim tabAnim1 = new AbstractCollectionPart.Anim(0.0f, 0.32f, 2);
    public final AbstractCollectionPart.Anim tabAnim2 = new AbstractCollectionPart.Anim(0.0f, 0.32f, 2);
    public boolean tabAnim1Running;
    public final AbstractCollectionPart.Anim tabAlphaAnim = new AbstractCollectionPart.Anim(0.0f, 0.22f, 0);
    public float tabAlphaA;
    public float tabAlphaB;
    public float tabAlphaTarget;
    public float tabAlphaDuration = 0.22f;
    public int tabAlphaEase = 0;
    public long tabAlphaStart;
    public boolean tabAlphaRunning;
    public PlateInput plate;
    public ToolButton button1;
    public ToolButton button2;
    public ToolWidget widget1;
    public ToolWidget widget2;
    public float tabRowX;
    public float tabRowY;
    public float tabRowW;
    public boolean searchAlpha;
    public Object label1;
    public float label1Alpha;
    public boolean label1Running;
    public boolean plateFocused;
    public Component keyFilter;
    public Component field;
    public boolean rootFlag;

    public BoardToolbar() {
    }

    public BoardToolbar(List<Tab> tabs, String title, int icon, String secondLabel, int icon2) {
        this.flags = 256;
        this.x = 0.0f;
        this.y = 0.0f;
        this.tabListener = null;
        this.tabStates.clear();
        this.selectedTab = -1;
        this.tabLayoutIndex = 0;
        this.tabAnim1.duration = 0.32f;
        this.tabAnim2.duration = 0.32f;
        this.tabAnim1Running = false;
        this.tabAlphaAnim.duration = 0.22f;
        this.tabAlphaAnim.ease = 0;
        this.plate = new PlateInput();
        this.plate.callback = null;
        this.plate.setSize(230.0f, 0.0f);
        this.button1 = new ToolButton();
        this.button1.icon = 79;
        this.button1.flag = 0.36f;
        this.button2 = new ToolButton();
        this.button2.icon = 78;
        this.button2.flag = 0.36f;
        this.widget1 = new ToolWidget();
        this.widget1.icon = icon2;
        this.widget1.mode = 0;
        this.widget2 = new ToolWidget();
        this.widget2.icon = 0;
        this.tabRowX = 0.0f;
        this.tabRowW = 0.0f;
        this.width = 964.0f;
        this.height = 36.0f;
        if (tabs != null && !tabs.isEmpty()) {
            int count = tabs.size();
            for (int i = 0; i < count; ++i) {
                Tab tab = tabs.get(i);
                TabState state = new TabState();
                state.label = tab.label;
                state.callback = tab.callback;
                state.flag = tab.flag;
                state.callback2 = tab.callback2;
                state.label2 = tab.label2;
                state.index = -1;
                state.x = 0.0f;
                state.w = 0.0f;
                state.selected = false;
                state.extraLabel = "";
                state.anim.from = 0.0f;
                state.anim.current = 0.0f;
                state.anim.target = 0.0f;
                state.anim.running = false;
                this.tabStates.add(state);
            }
        }
        if (!this.tabStates.isEmpty()) {
            TabState first = this.tabStates.get(0);
            first.anim.from = 1.0f;
            first.anim.current = 1.0f;
            first.anim.target = 1.0f;
            first.anim.running = false;
        }
        float v = 0.0f;
        if (this.tabLayoutIndex != 1) {
            v = 1.0f;
        }
        this.tabAlphaA = v;
        this.tabAlphaB = v;
        this.tabAlphaTarget = v;
        this.tabAlphaRunning = false;
        this.button1.setSize(46.0f, 46.0f);
        this.button2.setSize(46.0f, 46.0f);
        this.button1.label = LABEL_BUTTON1;
        this.button2.label = LABEL_BUTTON2;
        this.widget1.label = secondLabel;
        this.plate.callback = null;
        this.button1.callback = this.onClickButton1();
        this.button2.callback = this.onClickButton2();
        this.plate.callback = this.onPlateSubmit();
        this.widget1.callback = this.onClickWidget1();
        this.widget2.callback = this.onClickWidget2();
        this.widget1.flag88 = 1;
        this.widget2.flag88 = 1;
        this.searchAlpha = false;
        this.label1 = null;
        this.label1Alpha = 0.0f;
        this.label1Running = false;
        this.rootFlag = true;
    }

    protected Runnable onClickButton1() {
        return null;
    }

    protected Runnable onClickButton2() {
        return null;
    }

    protected Consumer<String> onPlateSubmit() {
        return null;
    }

    protected Runnable onClickWidget1() {
        return null;
    }

    protected Runnable onClickWidget2() {
        return null;
    }

    public List<TabState> tabs() {
        return this.tabStates;
    }

    public int currentTab() {
        return this.selectedTab;
    }

    public void setTab(int index) {
        this.setTab(index, true);
    }

    public void setTab(int index, boolean animate) {
        if (index < 0 || index >= this.tabStates.size()) {
            return;
        }
        this.selectedTab = index;
        int count = this.tabStates.size();
        for (int i = 0; i < count; ++i) {
            float target;
            TabState state = this.tabStates.get(i);
            float f = target = i == index ? 1.0f : 0.0f;
            if (!animate) {
                state.anim.from = target;
                state.anim.current = target;
                state.anim.target = target;
                state.anim.running = false;
                continue;
            }
            if (state.anim.target == target) continue;
            long time = this.now();
            state.anim.advance(time);
            float value = state.anim.current;
            state.anim.target = target;
            state.anim.start = time;
            state.anim.running = true;
            state.anim.from = value;
        }
        if (!animate) {
            this.tabAnim1Running = false;
        }
    }

    public boolean acceptsKey(int keyCode) {
        return this.keyFilter == null;
    }

    public boolean insertTextChar(int keyCode) {
        if (this.plate == null) {
            return false;
        }
        return this.plate.insertTextChar(keyCode);
    }

    public boolean plateKeyPressed(int keyCode) {
        if (this.plate == null) {
            return false;
        }
        return this.plate.plateKeyPressed(keyCode);
    }

    public boolean plateRectHit(double mx, double my) {
        if (this.plate == null) {
            return false;
        }
        return mx >= (double)this.plate.x && mx <= (double)(this.plate.x + this.plate.width) && my >= (double)this.plate.y && my <= (double)(this.plate.y + this.plate.height);
    }

    public boolean plateHasText() {
        return this.plate != null && this.plate.hasText();
    }

    public boolean overlayOpen() {
        return this.plate != null && this.plate.focused;
    }

    public void setPlateText(String value) {
        if (this.plate != null) {
            this.plate.text = value;
        }
    }

    @Override
    public void render() {
        this.renderToolbar(0.0f, 0.0f, 0.0f);
    }

    protected void renderToolbar(float offsetX, float offsetY, float alpha) {
        float h;
        float bgX = this.x + 16.0f;
        float bgW = this.width - 32.0f;
        this.renderBackground(bgX, this.y, bgW, 50.0f, 18.0f, alpha);
        float rowY = this.y + 4.0f;
        this.renderTabRow(offsetX, offsetY, bgX + 4.0f, this.y + 5.0f, alpha);
        float right = bgW + bgX - 4.0f;
        if (this.widget2 != null) {
            h = this.widget2.measuredHeight();
            this.widget2.y = rowY;
            this.widget2.x = right - h;
            right -= this.widget2.widthCache;
            if (0.001f < this.widget2.widthCache) {
                right += 4.0f;
            }
        }
        if (this.widget1 != null) {
            h = this.widget1.measuredHeight();
            this.widget1.x = right - h;
            this.widget1.y = rowY;
        }
        float widgetW = 0.0f;
        if (this.widget1 != null) {
            widgetW = this.widget1.widthCache;
        }
        float rowX = right - (widgetW + 4.0f) - 100.0f;
        this.renderBackground2(rowX, rowY, 100.0f, 42.0f, 14.0f, alpha, 1);
        long time = this.now();
        float y2 = rowY + 3.0f;
        float x2 = rowX + 3.0f;
        float x3 = x2 + 46.0f + 2.0f;
        float t = AbstractCollectionPart.easeValue(0, 0.0f);
        this.renderBackground3(t * (x3 - x2) + x2, y2, 46.0f, 36.0f, 12.0f, time, alpha);
        if (this.button2 != null) {
            this.button2.x = x2;
            this.button2.y = y2;
            this.renderButton(this.button2, offsetX, offsetY, alpha);
        }
        if (this.button1 != null) {
            this.button1.x = x3;
            this.button1.y = y2;
            this.renderButton(this.button1, offsetX, offsetY, alpha);
        }
        if (this.widget1 != null) {
            this.renderWidget(this.widget1, offsetX, offsetY, alpha);
        }
        if (this.widget2 != null) {
            this.renderWidget(this.widget2, offsetX, offsetY, alpha);
        }
        if (this.plate != null) {
            float w = 230.0f;
            this.plate.y = rowY;
            this.plate.x = (bgW - w) * 0.5f + bgX;
            this.renderPlate(this.plate, offsetX, offsetY);
        }
    }

    protected void renderBackground(float px, float py, float pw, float ph, float radius, float alpha) {
    }

    protected void renderBackground2(float px, float py, float pw, float ph, float radius, float alpha, int mode) {
    }

    protected void renderBackground3(float px, float py, float pw, float ph, float radius, long time, float alpha) {
    }

    protected void renderTabRow(float offsetX, float offsetY, float px, float py, float alpha) {
        this.tabRowX = px;
        this.tabRowY = py;
        for (int i = 0; i < this.tabStates.size(); ++i) {
            TabState state = this.tabStates.get(i);
            state.anim.advance(this.now());
            state.x = this.tabRowX;
            state.w = state.anim.value();
        }
    }

    protected void renderButton(ToolButton button, float offsetX, float offsetY, float alpha) {
    }

    protected void renderWidget(ToolWidget widget, float offsetX, float offsetY, float alpha) {
    }

    protected void renderPlate(PlateInput input, float offsetX, float offsetY) {
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        int count;
        if (this.plate != null && this.plate.plateClicked(mx, my, button)) {
            return true;
        }
        if (this.widget1 != null && this.widget1.widgetHit(mx, my, button)) {
            return true;
        }
        if (this.widget2 != null && this.widget2.widgetHit(mx, my, button)) {
            return true;
        }
        if (this.button1 != null && this.button1.iconHit(mx, my, button)) {
            return true;
        }
        if (this.button2 != null && this.button2.iconHit(mx, my, button)) {
            return true;
        }
        if (button == 0 && (count = this.tabStates.size()) != 0) {
            float rowTop = this.tabRowY + 2.0f;
            float rowBottom = rowTop + 36.0f;
            int i = 0;
            TabState state = this.tabStates.get(0);
            while (mx < (double)state.x || mx > (double)(state.x + state.w) || my < (double)rowTop || my > (double)rowBottom) {
                if (count <= ++i) {
                    return this.selfHit(mx, my);
                }
                state = this.tabStates.get(i);
            }
            if (i != this.selectedTab && !state.selected) {
                this.setTab(i, true);
                BoardToolbar.uiSound(11);
                if (this.tabListener != null) {
                    this.tabListener.acceptInt(i);
                }
            }
            return true;
        }
        return this.selfHit(mx, my);
    }

    protected boolean selfHit(double mx, double my) {
        return mx >= (double)this.x && mx <= (double)(this.x + this.width) && my >= (double)this.y && my <= (double)(this.y + this.height);
    }

    @Override
    public boolean keyPressed(int keyCode, int modifiers) {
        if (this.plate == null) {
            return false;
        }
        return this.plate.plateKeyPressed(keyCode);
    }

    @Override
    public boolean keyReleased(int keyCode) {
        if (!this.overlayOpen()) {
            return false;
        }
        if (this.keyFilter != null && !this.acceptsKey(keyCode)) {
            return false;
        }
        return this.insertTextChar(keyCode);
    }

    @Override
    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void dispose() {
        if (this.tabListener != null) {
            this.tabListener = null;
        }
        this.tabStates.clear();
        if (this.plate != null) {
            this.plate.dispose();
        }
        if (this.button1 != null) {
            this.button1.dispose();
        }
        if (this.button2 != null) {
            this.button2.dispose();
        }
        if (this.widget1 != null) {
            this.widget1.dispose();
        }
        if (this.widget2 != null) {
            this.widget2.dispose();
        }
        super.dispose();
    }

    public static interface TabListener {
        public void acceptInt(int var1);
    }

    public static class PlateInput
    extends Component {
        public Consumer<String> callback;
        public Component keyFilter;
        public String text = "";
        public boolean focused;
        public float hover;
        public final AbstractCollectionPart.Anim anim = new AbstractCollectionPart.Anim(0.0f, 0.32f, 2);

        public boolean plateClicked(double mx, double my, int button) {
            if (button != 0) {
                return false;
            }
            boolean inside = mx >= (double)this.x && mx <= (double)(this.x + this.width) && my >= (double)this.y && my <= (double)(this.y + this.height);
            this.hover = inside ? 1.0f : 0.0f;
            return inside;
        }

        public String trimmed() {
            int start;
            int end = this.text.length();
            for (start = 0; start < end && this.text.charAt(start) <= ' '; ++start) {
            }
            while (end > start && this.text.charAt(end - 1) <= ' ') {
                --end;
            }
            return this.text.substring(start, end);
        }

        public boolean hasText() {
            return this.trimmed().length() != 0;
        }

        public boolean commit() {
            String value = this.trimmed();
            if (value.length() == 0) {
                return false;
            }
            if (this.callback != null) {
                this.callback.accept(value);
            }
            this.clearText();
            if (this.focused) {
                this.focused = false;
                this.anim.setTarget(0.0f, this.now());
                this.notifyFocusChanged();
            }
            return true;
        }

        public void clearText() {
            this.text = "";
        }

        public boolean plateKeyPressed(int keyCode) {
            if (!this.focused) {
                return false;
            }
            if (keyCode == 27) {
                this.focused = false;
                this.anim.setTarget(0.0f, this.now());
                this.notifyFocusChanged();
                return true;
            }
            if (keyCode == 13) {
                this.commit();
                return true;
            }
            return this.insertTextChar(keyCode);
        }

        public boolean insertTextChar(int keyCode) {
            if (keyCode < 32 || keyCode == 127) {
                return false;
            }
            this.text = this.text + (char)keyCode;
            return true;
        }

        public void notifyFocusChanged() {
        }
    }

    public static class ToolButton
    extends Component {
        public Runnable callback;
        public int icon;
        public float flag;
        public String label = "";

        public boolean iconHit(double mx, double my, int button) {
            if (button != 0) {
                return false;
            }
            return mx >= (double)this.x && mx <= (double)(this.x + this.width) && my >= (double)this.y && my <= (double)(this.y + this.height);
        }
    }

    public static class ToolWidget
    extends Component {
        public Object callback;
        public int icon;
        public String label = "";
        public int mode;
        public int flag88;
        public float widthCache;
        public float heightCache;

        public boolean widgetHit(double mx, double my, int button) {
            if (button != 0) {
                return false;
            }
            return mx >= (double)this.x && mx <= (double)(this.x + this.width) && my >= (double)this.y && my <= (double)(this.y + this.height);
        }

        public float measuredHeight() {
            return this.heightCache;
        }
    }

    public static class Tab {
        public String label;
        public Runnable callback;
        public boolean flag;
        public Runnable callback2;
        public String label2;

        public Tab() {
        }

        public Tab(String label, Runnable callback, boolean flag, Runnable callback2, String label2) {
            this.label = label;
            this.callback = callback;
            this.flag = flag;
            this.callback2 = callback2;
            this.label2 = label2;
        }
    }

    public static class TabState {
        public String label;
        public Runnable callback;
        public boolean flag;
        public Runnable callback2;
        public String label2;
        public final AbstractCollectionPart.Anim anim = new AbstractCollectionPart.Anim(1.0f, 0.22f, 0);
        public boolean selected;
        public String extraLabel = "";
        public int index = -1;
        public float x;
        public float w;
    }
}

