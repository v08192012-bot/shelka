/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.AbstractCard;
import client.gui.Component;
import client.gui.Screen;
import java.util.function.Consumer;

public class WaypointCard
extends AbstractCard {
    public static final int VTABLE_RVA = 12614600;
    public static final int SLOT_DTOR = 0;
    public static final int SLOT_RENDER = 8;
    public static final int SLOT_ATTACH = 16;
    public static final int SLOT_DETACH = 24;
    public static final int SLOT_MOUSE_CLICKED = 32;
    public static final int SLOT_MOUSE_RELEASED = 40;
    public static final int SLOT_MOUSE_MOVED = 48;
    public static final int SLOT_MOUSE_SCROLLED = 56;
    public static final int SLOT_KEY_PRESSED = 64;
    public static final int SLOT_CHAR_TYPED = 72;
    public static final int SLOT_KEY_RELEASED = 80;
    public static final int SLOT_SET_POSITION = 88;
    public static final int SLOT_SET_STATE = 96;
    public static final int SLOT_RENDER_CONTENT = 104;
    public static final int SLOT_ON_MOUSE = 112;
    public static final int RVA_CTOR = 1736672;
    public static final int RVA_DELETING_DTOR = 1738896;
    public static final int RVA_DTOR = 1738960;
    public static final int RVA_RENDER = 1153168;
    public static final int RVA_ATTACH = 227504;
    public static final int RVA_DEFAULT_VIRTUAL = 233936;
    public static final int RVA_MOUSE_CLICKED = 1154208;
    public static final int RVA_KEY_PRESSED = 1154272;
    public static final int RVA_KEY_RELEASED = 1154560;
    public static final int RVA_SET_POSITION = 1153056;
    public static final int RVA_SET_STATE = 1739584;
    public static final int RVA_RENDER_CONTENT = 1740528;
    public static final int RVA_ON_MOUSE = 1746720;
    public static final int RVA_MOUSE_RELEASED = 1747984;
    public static final int RVA_MOUSE_MOVED = 1748096;
    public static final int RVA_RENDER_EXPANDED = 1741376;
    public static final int RVA_RENDER_COLLAPSED = 1742512;
    public static final int RVA_DRAW_TITLE_ROW = 1743648;
    public static final int RVA_DRAW_COORD_ROW = 1744688;
    public static final int RVA_DRAW_COORD_FIELD = 1745408;
    public static final int RVA_FORMAT_CAPTION = 1739632;
    public static final int RVA_ON_TITLE_CHANGED = 1748176;
    public static final int RVA_ON_COORD_CHANGED = 1748592;
    public static final int RVA_PAIR_ACTION_MOVE = 1749376;
    public static final int RVA_PAIR_ACTION_COPY = 1749216;
    public static final int RVA_PAIR_ACTION_DELETE = 1749056;
    public static final int RVA_COORD_ACTION_X = 1749728;
    public static final int RVA_COORD_ACTION_Y = 1749664;
    public static final int RVA_COORD_ACTION_Z = 1749600;
    public static final int RVA_TITLE_ACTION = 1749792;
    public static final int RVA_KEY_PREDICATE = 1736080;
    public static final int RVA_ADD_ICON_BUTTON = 0x119910;
    public static final int RVA_PLATE_BUTTON_CTOR = 1210816;
    public static final int RVA_PLATE_BUTTON_DTOR = 1211216;
    public static final int RVA_ICON_BUTTON_CTOR = 1209648;
    public static final int RVA_ICON_BUTTON_DTOR = 1214016;
    public static final int RVA_ICON_BUTTON_RENDER = 1210064;
    public static final int RVA_SWITCHER_CTOR = 1212736;
    public static final int RVA_SWITCHER_RENDER = 1213040;
    public static final int RVA_SWITCHER_DRAG = 1213920;
    public static final int RVA_SWITCHER_RELEASE = 1214144;
    public static final int RVA_ASSIGN_PLATE_ACTION = 1234176;
    public static final int RVA_ASSIGN_ICON_ACTION = 1192400;
    public static final int RVA_ASSIGN_LABEL = 82320;
    public static final int RVA_ASSIGN_KEY_CAPTURE = 1393936;
    public static final int RVA_ANIM_CTOR = 1173840;
    public static final int RVA_ANIM_UPDATE = 1149040;
    public static final int RVA_INFO_CTOR = 1331824;
    public static final int RVA_INFO_DTOR = 1284640;
    public static final int RVA_COMPONENT_DTOR = 1096704;
    public static final int RVA_CHILDREN_CLEAR = 1155824;
    public static final int RVA_NOW = 31568;
    public static final int RVA_PLAY_SOUND = 36640;
    public static final int RVA_BLUR_FOCUS = 1153696;
    public static final int RVA_FOCUS_CHILD_WITH_TEXT = 1154000;
    public static final int RVA_THEME = 3515472;
    public static final int RVA_DRAW_PANEL = 1139984;
    public static final int RVA_DRAW_LABEL = 1143168;
    public static final int RVA_DRAW_ICON_BUTTON = 1211472;
    public static final int RVA_DRAW_ICON = 3491616;
    public static final int RVA_DRAW_TEXT = 3514880;
    public static final int RVA_WRAP_TEXT = 3517424;
    public static final int RVA_ELLIPSIZE = 3518496;
    public static final int RVA_DRAW_CARET = 3508304;
    public static final int RVA_MEASURE_TEXT = 1773456;
    public static final int RVA_TO_STRING = 636624;
    public static final int RVA_COPY_STRING = 74736;
    public static final int RVA_FILE_TIME = 108272;
    public static final int RVA_SYSTEM_TICKS = 206944;
    public static final int RVA_PARSE_COORDS = 97712;
    public static final int RVA_IS_FOCUSED = 28328704;
    public static final int RVA_DRAW_FRAME = 1140544;
    public static final int RVA_DRAW_FIELD = 1141392;
    public static final int RVA_DRAW_CAPTION = 1143568;
    public static final int RVA_TEXT_WIDTH = 1172176;
    public static final int RVA_CURRENT_POSITION = 10358176;
    public static final int RVA_WORLD_SOURCE = 134512;
    public static final int INFO_NAME_OFFSET = 560;
    public static final int CALLBACK_MOVE_OFFSET = 176;
    public static final int CALLBACK_MOVE_SLOT_OFFSET = 232;
    public static final int CALLBACK_COPY_OFFSET = 240;
    public static final int CALLBACK_COPY_SLOT_OFFSET = 296;
    public static final int CALLBACK_TOGGLE_OFFSET = 304;
    public static final int CALLBACK_TOGGLE_SLOT_OFFSET = 360;
    public static final int CALLBACK_DELETE_OFFSET = 368;
    public static final int CALLBACK_DELETE_SLOT_OFFSET = 424;
    public static final int CALLBACK_TITLE_OFFSET = 432;
    public static final int CALLBACK_TITLE_SLOT_OFFSET = 488;
    public static final int CALLBACK_COORD_OFFSET = 496;
    public static final int CALLBACK_COORD_SLOT_OFFSET = 552;
    public static final int SWITCHER_OFFSET = 728;
    public static final int PLATE_MOVE_OFFSET = 920;
    public static final int PLATE_COPY_OFFSET = 1208;
    public static final int PLATE_DELETE_OFFSET = 1496;
    public static final int ICON_MOVE_OFFSET = 1784;
    public static final int ICON_COPY_OFFSET = 2032;
    public static final int ICON_DELETE_OFFSET = 2280;
    public static final int ALPHA_ANIM_OFFSET = 2528;
    public static final int INPUT_TITLE_OFFSET = 2568;
    public static final int INPUT_X_OFFSET = 2576;
    public static final int INPUT_Y_OFFSET = 2584;
    public static final int INPUT_Z_OFFSET = 2592;
    public static final int HIDDEN_RECT_OFFSET = 2600;
    public static final int SLOT_X_OFFSET = 2616;
    public static final int SLOT_Y_OFFSET = 2628;
    public static final int SLOT_W_OFFSET = 2632;
    public static final int TOGGLE_X_OFFSET = 2636;
    public static final int TOGGLE_Y_OFFSET = 2640;
    public static final int ENABLED_OFFSET = 1024;
    public static final int ALPHA_A_OFFSET = 1032;
    public static final int ALPHA_B_OFFSET = 1036;
    public static final int ALPHA_C_OFFSET = 1040;
    public static final int FLAG_428_OFFSET = 1064;
    public static final int SWITCHER_ON_OFFSET = 96;
    public static final int SWITCHER_LOCKED_OFFSET = 97;
    public static final int SWITCHER_CALLBACK_OFFSET = 160;
    public static final int SWITCHER_TARGET_OFFSET = 168;
    public static final int SWITCHER_FADE_OFFSET = 172;
    public static final int SWITCHER_KNOB_OFFSET = 176;
    public static final int SWITCHER_DRAGGING_OFFSET = 180;
    public static final int SWITCHER_DRAG_PAST_OFFSET = 181;
    public static final int SWITCHER_PRESS_STATE_OFFSET = 182;
    public static final int SWITCHER_PRESS_X_OFFSET = 184;
    public static final int SWITCHER_STATE_MIRROR_OFFSET = 824;
    public static final int SWITCHER_FADE_OUT_OFFSET = 896;
    public static final int PLATE_ICON_OFFSET = 96;
    public static final int PLATE_ENABLED_OFFSET = 104;
    public static final int PLATE_ANIM_OFFSET = 112;
    public static final int PLATE_ACTION_OFFSET = 192;
    public static final int PLATE_LABEL_OFFSET = 216;
    public static final int ICON_ID_OFFSET = 96;
    public static final int ICON_ACTIVE_OFFSET = 100;
    public static final int ICON_ENABLED_OFFSET = 104;
    public static final int ICON_DISABLED_OFFSET = 105;
    public static final int ICON_SIZE_OFFSET = 108;
    public static final int ICON_ANIM_OFFSET = 112;
    public static final int ICON_CALLBACK_OFFSET = 208;
    public static final int ICON_LABEL_OFFSET = 216;
    public static final int INPUT_TEXT_OFFSET = 0;
    public static final int INPUT_SIZE_OFFSET = 32;
    public static final int INPUT_FLAG_25_OFFSET = 37;
    public static final int INPUT_FLAG_26_OFFSET = 38;
    public static final int INPUT_MIN_OFFSET = 40;
    public static final int INPUT_MAX_OFFSET = 80;
    public static final int INPUT_CUSTOM_TEXT_OFFSET = 216;
    public static final int INPUT_KEY_CAPTURE_OFFSET = 360;
    public static final int INPUT_ALLOC_SIZE = 424;
    public static final int INFO_NAME_STRUCT_OFFSET = 0;
    public static final int INFO_KEY_STRUCT_OFFSET = 32;
    public static final int INFO_X_STRUCT_OFFSET = 64;
    public static final int INFO_Y_STRUCT_OFFSET = 68;
    public static final int INFO_Z_STRUCT_OFFSET = 72;
    public static final int INFO_WORLD_STRUCT_OFFSET = 80;
    public static final int INFO_SELECTED_STRUCT_OFFSET = 112;
    public static final int INFO_EXTRA_STRUCT_OFFSET = 120;
    public static final int INFO_BROKEN_STRUCT_OFFSET = 152;
    public static final int INFO_FLAG99_STRUCT_OFFSET = 153;
    public static final int INFO_DEADLINE_STRUCT_OFFSET = 160;
    public static final int INFO_SIZE = 168;
    public static final float ONE = 1.0f;
    public static final float ZERO = 0.0f;
    public static final float HALF = 0.5f;
    public static final float MINUS_ONE = -1.0f;
    public static final float CARD_WIDTH = 930.0f;
    public static final float CARD_HEIGHT = 62.0f;
    public static final float CARD_HEIGHT_EXPANDED = 126.0f;
    public static final float DIM_ALPHA = 0.7f;
    public static final float ANIM_DURATION_MEDIUM = 0.22f;
    public static final float ROW_HEIGHT = 42.0f;
    public static final float RADIUS = 18.0f;
    public static final float RADIUS_COLLAPSED = 14.0f;
    public static final float PAD_18 = 18.0f;
    public static final float PAD_16 = 16.0f;
    public static final float PAD_12 = 12.0f;
    public static final float GAP_8 = 8.0f;
    public static final float GAP_6 = 6.0f;
    public static final float GAP_4 = 4.0f;
    public static final float GAP_3 = 3.0f;
    public static final float GAP_2 = 2.0f;
    public static final float GAP_1 = 1.0f;
    public static final float SWITCH_INSET = -28.0f;
    public static final float SWITCH_INSET_POSITIVE = 28.0f;
    public static final float SWITCH_STEP = -8.0f;
    public static final float SWITCH_OFFSET_Y = 13.0f;
    public static final float BUTTON_SPAN = 36.0f;
    public static final float BUTTON_STEP = 22.0f;
    public static final float BUTTON_STEP_NEGATIVE = -22.0f;
    public static final float COORD_ROW_SPAN = 270.0f;
    public static final float COLLAPSED_INSET = 32.0f;
    public static final float COLLAPSED_ROW_STEP = 24.0f;
    public static final float VISIBLE_EPSILON = 0.001f;
    public static final float FIELD_HEIGHT = 20.0f;
    public static final float MEASURE_PAD = 9.0f;
    public static final float MEASURE_EXTRA = 26.0f;
    public static final float ICON_SIZE = 20.0f;
    public static final float ADD_BUTTON_SIZE_A = 16.0f;
    public static final float ADD_BUTTON_SIZE_B = 12.0f;
    public static final int PLATE_ICON_MOVE = 30;
    public static final int PLATE_ICON_COPY = 37;
    public static final int PLATE_ICON_DELETE = 82;
    public static final int ICON_ID_MOVE = 30;
    public static final int ICON_ID_COPY = 37;
    public static final int ICON_ID_DELETE = 32;
    public static final int ICON_ID_HEADER = 35;
    public static final int SOUND_ENABLE = 8;
    public static final int SOUND_MOVE = 12;
    public static final int SOUND_COPY = 14;
    public static final int SOUND_DELETE = 13;
    public static final int HOVER_TOGGLE = 1;
    public static final int HOVER_FIELD = 2;
    public static final int STATE_COLLAPSED = 0;
    public static final int STATE_EXPANDED = 1;
    public static final int MAX_KEY_CODE = 59;
    public static final long KEY_MASK = 864532803075702784L;
    public static final int TEXT_MODE_PLAIN = 2;
    public static final int TEXT_MODE_WRAPPED = 4;
    public static final int TEXT_MODE_MEASURED = 1;
    public static final long TICKS_PER_MILLI = 10000L;
    public static final long MILLIS_PER_SECOND = 1000L;
    public static final long SECONDS_PER_MINUTE = 60L;
    public static final int AXIS_X = 0;
    public static final int AXIS_Y = 1;
    public static final int AXIS_Z = 2;
    public static final String LABEL_MOVE = "\u041f\u0435\u0440\u0435\u043d\u0435\u0441\u0442\u0438 \u0441\u044e\u0434\u0430 \u2014 \u0433\u0434\u0435 \u0441\u0442\u043e\u0438\u0442\u0435";
    public static final String LABEL_COPY = "\u0421\u043a\u043e\u043f\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u043a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u044b";
    public static final String LABEL_DELETE = "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0442\u043e\u0447\u043a\u0443";
    public static final String COORD_X = "X";
    public static final String COORD_Y = "Y";
    public static final String COORD_Z = "Z";
    public static final int ICON_INVALID = 89;
    protected WaypointInfo info;
    protected SwitcherButton switcher;
    protected PlateIconButton plateMove;
    protected PlateIconButton plateCopy;
    protected PlateIconButton plateDelete;
    protected IconButton iconMove;
    protected IconButton iconCopy;
    protected IconButton iconDelete;
    protected final AbstractCard.Anim alphaAnim = new AbstractCard.Anim(1.0f, 0.22f, 0);
    protected PlateInput inputTitle;
    protected PlateInput inputX;
    protected PlateInput inputY;
    protected PlateInput inputZ;
    protected Object callbackMove = null;
    protected Object callbackCopy = null;
    protected Object callbackToggle = null;
    protected Object callbackDelete = null;
    protected Object callbackTitle = null;
    protected Object callbackCoord = null;
    protected boolean enabled;
    protected float alphaA;
    protected float alphaB;
    protected float alphaC;
    protected boolean flag428;
    protected float hiddenRectX;
    protected float hiddenRectY;
    protected float hiddenRectW;
    protected float hiddenRectH;
    protected final float[] slotX = new float[3];
    protected float slotY;
    protected float slotW;
    protected float toggleX;
    protected float toggleY;

    public WaypointCard(WaypointInfo waypointInfo) {
        float start;
        float availability;
        this.info = waypointInfo;
        this.switcher = new SwitcherButton(this.info.selected);
        this.plateMove = new PlateIconButton(30, LABEL_MOVE);
        this.plateCopy = new PlateIconButton(37, LABEL_COPY);
        this.plateDelete = new PlateIconButton(82, LABEL_DELETE);
        this.iconMove = new IconButton(30, 20.0f);
        this.iconCopy = new IconButton(37, 20.0f);
        this.iconDelete = new IconButton(32, 20.0f);
        this.inputTitle = (PlateInput)this.addIconButton(16.0f, this::onTitleAction);
        this.inputX = (PlateInput)this.addIconButton(12.0f, this::onCoordXAction);
        this.inputY = (PlateInput)this.addIconButton(12.0f, this::onCoordYAction);
        this.inputZ = (PlateInput)this.addIconButton(12.0f, this::onCoordZAction);
        this.hiddenRectX = 0.0f;
        this.hiddenRectY = 0.0f;
        this.hiddenRectW = 0.0f;
        this.hiddenRectH = 0.0f;
        this.slotX[0] = 0.0f;
        this.slotX[1] = 0.0f;
        this.slotX[2] = 0.0f;
        this.slotY = 0.0f;
        this.slotW = 0.0f;
        this.toggleX = -1.0f;
        this.toggleY = -1.0f;
        WaypointCard.assignKeyCapture(this.inputX, WaypointCard::acceptKeyCode);
        WaypointCard.assignKeyCapture(this.inputY, WaypointCard::acceptKeyCode);
        WaypointCard.assignKeyCapture(this.inputZ, WaypointCard::acceptKeyCode);
        WaypointCard.assignPlateAction(this.plateMove, this.iconMove, LABEL_MOVE, this::onPlateMoveAction);
        this.iconMove.iconSize = 0.0f;
        WaypointCard.assignLabel(this.iconMove, LABEL_MOVE);
        WaypointCard.assignIconAction(this.iconMove, this::onPlateMoveAction);
        WaypointCard.assignPlateAction(this.plateCopy, this.iconCopy, LABEL_COPY, this::onPlateCopyAction);
        this.iconCopy.iconSize = 0.0f;
        WaypointCard.assignLabel(this.iconCopy, LABEL_COPY);
        WaypointCard.assignIconAction(this.iconCopy, this::onPlateCopyAction);
        WaypointCard.assignPlateAction(this.plateDelete, this.iconDelete, LABEL_DELETE, this::onPlateDeleteAction);
        this.iconDelete.iconSize = 0.0f;
        WaypointCard.assignLabel(this.iconDelete, LABEL_DELETE);
        WaypointCard.assignIconAction(this.iconDelete, this::onPlateDeleteAction);
        this.enabled = !this.info.broken;
        this.alphaA = availability = this.enabled ? 1.0f : 0.0f;
        this.alphaB = availability;
        this.alphaC = availability;
        this.flag428 = false;
        this.switcher.locked = false;
        this.alphaAnim.from = start = this.info.selected || this.info.broken ? 1.0f : 0.7f;
        this.alphaAnim.current = start;
        this.alphaAnim.target = start;
        this.alphaAnim.running = false;
        this.state = 0;
        this.width = 930.0f;
        this.height = 62.0f;
        WaypointCard.releaseInfoCopy(waypointInfo);
    }

    @Override
    public void dispose() {
        WaypointCard.releaseIconButton(this.iconDelete);
        WaypointCard.releaseIconButton(this.iconCopy);
        WaypointCard.releaseIconButton(this.iconMove);
        WaypointCard.releasePlateButton(this.plateDelete);
        WaypointCard.releasePlateButton(this.plateCopy);
        WaypointCard.releasePlateButton(this.plateMove);
        WaypointCard.releaseCallback(this.switcher.callback);
        this.switcher.callback = null;
        WaypointCard.releaseSwitcher(this.switcher);
        WaypointCard.releaseInfo(this.info);
        WaypointCard.releaseCallback(this.callbackCoord);
        this.callbackCoord = null;
        WaypointCard.releaseCallback(this.callbackTitle);
        this.callbackTitle = null;
        WaypointCard.releaseCallback(this.callbackDelete);
        this.callbackDelete = null;
        WaypointCard.releaseCallback(this.callbackToggle);
        this.callbackToggle = null;
        WaypointCard.releaseCallback(this.callbackCopy);
        this.callbackCopy = null;
        WaypointCard.releaseCallback(this.callbackMove);
        this.callbackMove = null;
        super.dispose();
    }

    @Override
    public void setState(int newState, float newWidth) {
        this.width = newWidth;
        this.state = newState;
        if (newState == 1) {
            this.height = 126.0f;
            return;
        }
        this.height = 62.0f;
    }

    public void renderContent(Object mat, float mouseX, float mouseY, float alpha) {
        long time;
        float fVar10 = mouseX;
        float fVar9 = 1.0f;
        if (!this.info.selected && !this.info.broken) {
            fVar9 = 0.7f;
        }
        if (this.alphaAnim.target != fVar9) {
            time = this.now();
            float value = this.alphaAnim.update(time);
            this.alphaAnim.start = time;
            this.alphaAnim.from = value;
            this.alphaAnim.target = fVar9;
            this.alphaAnim.running = true;
        }
        time = this.now();
        float fade = this.alphaAnim.update(time);
        float radius = 18.0f;
        if (this.state == 1) {
            radius = 14.0f;
        }
        WaypointCard.drawPanel(mat, this.x, this.y, this.width, this.height, radius, alpha);
        if (!(this.info.broken || fVar10 < this.x || this.x + this.width < fVar10 || mouseY < this.y || this.y + this.height < mouseY || Screen.focusedWidget != null && !Screen.allowHover)) {
            float fVar2 = this.toggleX;
            if (0.0f <= fVar2 && fVar2 <= fVar10 && fVar10 <= fVar2 + 42.0f && this.toggleY <= mouseY && mouseY <= this.toggleY + 42.0f) {
                Screen.hoveredWidget = 1;
            } else {
                boolean inside = this.hiddenRectW <= 0.0f ? false : !(fVar10 < this.hiddenRectX || this.hiddenRectW + this.hiddenRectX < fVar10 || mouseY < this.hiddenRectY || this.hiddenRectY + this.hiddenRectH < mouseY);
                for (int i = 0; i < this.slotX.length && !inside; ++i) {
                    inside = !(fVar10 < this.slotX[i] || this.slotX[i] + this.slotW < fVar10 || mouseY < this.slotY || this.slotY + 36.0f < mouseY);
                }
                if (inside) {
                    Screen.hoveredWidget = 2;
                }
            }
        }
        if (this.state == 1) {
            this.renderCollapsed(mat, mouseX, mouseY, alpha);
            return;
        }
        this.renderExpanded(mat, mouseX, mouseY, fade * alpha);
    }

    @Override
    public boolean onMouse(double mouseXD, double mouseYD, int button) {
        int i;
        Object current;
        float mouseX = (float)mouseXD;
        float mouseY = (float)mouseYD;
        if (this.state == 1) {
            IconButton[] expanded = new IconButton[]{this.iconDelete, this.iconCopy, this.iconMove};
            for (i = 0; i < expanded.length; ++i) {
                current = expanded[i];
                if (current == this.iconMove && this.info.broken || button != 0 || !(mouseXD >= (double)((IconButton)current).x) || !(mouseXD <= (double)(((IconButton)current).x + ((IconButton)current).width)) || !(mouseYD >= (double)((IconButton)current).y) || !(mouseYD <= (double)(((IconButton)current).y + ((IconButton)current).height)) || !((IconButton)current).mousePressed(mouseX, mouseY)) continue;
                AbstractCard.blurFocusedChildren(this);
                return true;
            }
        } else {
            PlateIconButton[] collapsed = new PlateIconButton[]{this.plateDelete, this.plateCopy, this.plateMove};
            for (i = 0; i < collapsed.length; ++i) {
                current = collapsed[i];
                if (!((PlateIconButton)current).enabled || !(0.001f <= ((PlateIconButton)current).enabledAnim.current) || button != 0 || !(mouseXD >= (double)((PlateIconButton)current).x) || !(mouseXD <= (double)(((PlateIconButton)current).x + ((PlateIconButton)current).width)) || !(mouseYD >= (double)((PlateIconButton)current).y) || !(mouseYD <= (double)(((PlateIconButton)current).y + ((PlateIconButton)current).height)) || !((PlateIconButton)current).mousePressed(mouseX, mouseY)) continue;
                AbstractCard.blurFocusedChildren(this);
                return true;
            }
        }
        if (!this.info.broken) {
            if (button != 0) {
                return false;
            }
            if (mouseXD >= (double)this.switcher.x && mouseXD <= (double)(this.switcher.x + this.switcher.width) && mouseYD >= (double)this.switcher.y && mouseYD <= (double)(this.switcher.y + this.switcher.height) && this.switcher.mousePressed(mouseX, mouseY)) {
                AbstractCard.blurFocusedChildren(this);
                return true;
            }
        } else if (button != 0) {
            return false;
        }
        if (this.info.broken) {
            return false;
        }
        float fVar1 = this.toggleX;
        if (0.0f <= fVar1 && (double)fVar1 <= mouseXD && mouseXD <= (double)(fVar1 + 42.0f) && (double)this.toggleY <= mouseYD && mouseYD <= (double)(this.toggleY + 42.0f)) {
            boolean bVar12;
            AbstractCard.blurFocusedChildren(this);
            boolean cVar3 = this.info.selected;
            this.info.selected = bVar12 = !cVar3;
            if (this.switcher.on != bVar12) {
                this.switcher.on = bVar12;
                this.switcher.target = bVar12 ? 1.0f : 0.0f;
            }
            WaypointCard.playClickSound((cVar3 ? 1 : 0) + 8);
            if (this.callbackToggle == null) {
                return true;
            }
            WaypointCard.invokeInfoCallback(this.callbackToggle, this.info);
            return true;
        }
        if (0.0f < this.hiddenRectW && mouseXD >= (double)this.hiddenRectX && mouseXD <= (double)(this.hiddenRectX + this.hiddenRectW) && mouseYD >= (double)this.hiddenRectY && mouseYD <= (double)(this.hiddenRectY + this.hiddenRectH)) {
            AbstractCard.focusChildWithText(this, this.inputTitle, this.info.key);
            return true;
        }
        for (i = 0; i < this.slotX.length; ++i) {
            int coordinate;
            PlateInput field;
            if (mouseXD < (double)this.slotX[i] || (double)(this.slotX[i] + this.slotW) < mouseXD || mouseYD < (double)this.slotY || (double)(this.slotY + 36.0f) < mouseYD) continue;
            if (i == 0) {
                field = this.inputX;
                coordinate = this.info.x;
            } else if (i == 1) {
                field = this.inputY;
                coordinate = this.info.y;
            } else {
                field = this.inputZ;
                coordinate = this.info.z;
            }
            AbstractCard.focusChildWithText(this, field, WaypointCard.toCoordinateText(coordinate));
            return true;
        }
        return false;
    }

    @Override
    public boolean mouseReleased(double mx, double my, int button) {
        if (!this.info.broken && this.switcher.mouseReleased(mx, my, button)) {
            if (this.switcher.on != this.info.selected) {
                Object callback = this.callbackToggle;
                this.info.selected = this.switcher.on;
                if (callback != null) {
                    WaypointCard.invokeInfoCallback(callback, this.info);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean mouseMoved(double mx, double my, double delta) {
        return !this.info.broken && this.switcher.mouseMoved(mx, my, delta);
    }

    private void renderExpanded(Object mat, float mouseX, float mouseY, float alpha) {
        float rowY = (this.height - 42.0f) * 0.5f + this.y;
        WaypointCard.drawLabel(this, mat, this.x + 12.0f, rowY);
        this.toggleX = this.x + 12.0f;
        this.toggleY = rowY;
        float cursor = this.x + this.width - 12.0f;
        if (!this.info.broken) {
            this.switcher.x = cursor += -28.0f;
            this.switcher.y = rowY + 13.0f;
            boolean selected = this.info.selected;
            if (this.switcher.on != selected) {
                this.switcher.on = selected;
                this.switcher.target = selected ? 1.0f : 0.0f;
            }
            this.switcher.render(mat, mouseX, mouseY, alpha);
            cursor += -8.0f;
        }
        float step = 4.0f;
        PlateIconButton[] order = new PlateIconButton[]{this.plateDelete, this.plateCopy, this.plateMove};
        for (int i = 0; i < order.length; ++i) {
            float value;
            PlateIconButton button = order[i];
            button.width = value = button.enabledAnim.update(this.now()) * 42.0f;
            button.x = cursor - value;
            button.y = rowY;
            if (!(0.001f < value)) continue;
            cursor -= value + step;
        }
        PlateIconButton[] drawOrder = new PlateIconButton[]{this.plateMove, this.plateCopy, this.plateDelete};
        for (int i = 0; i < drawOrder.length; ++i) {
            WaypointCard.drawIconButton(drawOrder[i], mat, mouseX, mouseY, alpha);
        }
        this.drawCoordRow(mat, cursor -= 270.0f, rowY, 270.0f, alpha);
        float textX = this.x + 12.0f + 42.0f + 6.0f;
        float available = cursor - step - textX;
        if (available <= 0.0f) {
            available = 0.0f;
        }
        this.drawTitleRow(mat, textX, rowY + 1.0f, available, alpha);
        if (!this.info.world.isEmpty()) {
            String wrapped = WaypointCard.wrapText(this.info.world, available, 12.0f);
            WaypointCard.rendererState();
            WaypointCard.drawText(2, mat, wrapped, textX);
        }
    }

    private void renderCollapsed(Object mat, float mouseX, float mouseY, float alpha) {
        this.toggleY = -1.0f;
        this.toggleX = -1.0f;
        float fVar6 = this.y + 16.0f;
        float fVar5 = this.x + 16.0f;
        float fVar7 = this.width - 32.0f;
        WaypointCard.rendererState();
        WaypointCard.drawTextAt(mat, 35, fVar5, fVar6 + 3.0f, 18.0f, 18.0f);
        fVar7 += fVar5;
        if (!this.info.broken) {
            this.switcher.x = fVar7 - 28.0f;
            this.switcher.y = fVar6 + 4.0f;
            boolean selected = this.info.selected;
            if (this.switcher.on != selected) {
                this.switcher.on = selected;
                this.switcher.target = selected ? 1.0f : 0.0f;
            }
            this.switcher.render(mat, mouseX, mouseY, alpha);
        }
        float titleX = fVar5 + 18.0f + 6.0f;
        float available = Math.max(this.switcher.x - 8.0f - titleX, 0.0f);
        this.drawTitleRow(mat, titleX, fVar6, available, alpha);
        this.drawCoordRow(mat, fVar5, fVar6 + 24.0f + 6.0f, this.width - 32.0f, alpha);
        float rowY = this.height + this.y - 16.0f - 16.0f;
        float iconX = fVar7 - 20.0f;
        this.iconDelete.x = iconX + 2.0f;
        this.iconDelete.y = rowY -= 2.0f;
        WaypointCard.renderIconButton(this.iconDelete, mat, mouseX, mouseY, alpha);
        this.iconCopy.x = (fVar7 -= 22.0f) - 20.0f + 2.0f;
        this.iconCopy.y = rowY;
        WaypointCard.renderIconButton(this.iconCopy, mat, mouseX, mouseY, alpha);
        fVar7 -= 22.0f;
        if (!this.info.broken) {
            this.iconMove.x = fVar7 - 20.0f + 2.0f;
            this.iconMove.y = rowY;
            WaypointCard.renderIconButton(this.iconMove, mat, mouseX, mouseY, alpha);
            fVar7 += -22.0f;
        }
        if (!this.info.key.isEmpty()) {
            float captionWidth = fVar7 - 8.0f - fVar5;
            if (captionWidth <= 0.0f) {
                captionWidth = 0.0f;
            }
            String wrapped = WaypointCard.wrapText(this.info.key, captionWidth, 12.0f);
            WaypointCard.rendererState();
            WaypointCard.drawText(2, mat, wrapped, fVar5);
        }
    }

    private void drawTitleRow(Object mat, float px, float py, float available, float alpha) {
        float keyWidth;
        String caption = this.formatCaption();
        float measured = caption.isEmpty() ? 0.0f : WaypointCard.textWidth(caption, 9.0f) + 26.0f + 6.0f;
        float rowY = py + 4.0f;
        float rest = available - measured;
        if (rest <= 0.0f) {
            rest = 0.0f;
        }
        if (!this.info.broken) {
            WaypointCard.rendererState();
            keyWidth = WaypointCard.drawAndMeasure(mat, this.inputTitle, this.info.key, px);
            this.hiddenRectX = px - 2.0f;
            this.hiddenRectY = rowY - 2.0f;
            this.hiddenRectW = rest + 4.0f;
            this.hiddenRectH = 20.0f;
        } else {
            String wrapped = WaypointCard.wrapText(this.info.key, rest, 16.0f);
            WaypointCard.rendererState();
            WaypointCard.drawText(4, mat, wrapped, px);
            keyWidth = WaypointCard.textWidth(wrapped, 12.0f);
            this.hiddenRectW = 0.0f;
        }
        if (caption.isEmpty()) {
            return;
        }
        if (keyWidth <= rest) {
            rest = keyWidth;
        }
        float captionX = rest + px + 6.0f;
        WaypointCard.drawCaption(mat, captionX, py + 2.0f);
    }

    private void drawCoordRow(Object mat, float px, float py, float available, float alpha) {
        float fVar62;
        float fVar61;
        float fVar60;
        WaypointCard.drawFrame(mat, px, py, available, 42.0f, 14.0f, alpha, 0);
        float fVar3 = 3.0f;
        float fVar12 = 12.0f;
        float fVar4 = 36.0f;
        float positionY = py + 3.0f;
        float positionX = px + 3.0f;
        float fVar7 = available - 6.0f - 4.0f;
        this.slotY = positionY;
        this.slotW = fVar7 / 3.0f;
        this.slotX[0] = fVar60 = (this.slotW + 2.0f) * 0.0f + positionX;
        WaypointCard.drawField(mat, fVar60, this.slotY, this.slotW, fVar4, fVar12, 0.0f, 0.0f, fVar12, alpha);
        this.drawCoordField(mat, 0, this.slotX[0], this.slotY, this.slotW, alpha);
        this.slotX[1] = fVar61 = this.slotW + 2.0f + positionX;
        WaypointCard.drawField(mat, fVar61, this.slotY, this.slotW, fVar4, 0.0f, 0.0f, 0.0f, 0.0f, alpha);
        this.drawCoordField(mat, 1, this.slotX[1], this.slotY, this.slotW, alpha);
        this.slotX[2] = fVar62 = this.slotW + 2.0f + (this.slotW + 2.0f + positionX);
        WaypointCard.drawField(mat, fVar62, this.slotY, this.slotW, fVar4, 0.0f, fVar12, fVar12, 0.0f, alpha);
        this.drawCoordField(mat, 2, this.slotX[2], this.slotY, this.slotW, alpha);
    }

    private void drawCoordField(Object mat, int index, float px, float py, float pw, float alpha) {
        int coordinate;
        PlateInput field;
        if (index == 0) {
            field = this.inputX;
            coordinate = this.info.x;
        } else if (index == 1) {
            field = this.inputY;
            coordinate = this.info.y;
        } else {
            field = this.inputZ;
            coordinate = this.info.z;
        }
        String value = !field.customText ? WaypointCard.toCoordinateText(coordinate) : field.text;
        String label = WaypointCard.coordLabel(index);
        float fVar14 = 12.0f;
        float fVar15 = px + 12.0f;
        float fVar16 = py + 12.0f;
        WaypointCard.rendererState();
        WaypointCard.drawText(4, mat, label, fVar15);
        float labelWidth = WaypointCard.textWidth(label, fVar14);
        float fVar13 = px + pw - fVar14;
        fVar13 = fVar13 - fVar15 - (labelWidth + 8.0f);
        if (fVar13 <= 0.0f) {
            fVar13 = 0.0f;
        }
        String fitted = WaypointCard.ellipsize(value, fVar13, fVar14);
        float fittedWidth = WaypointCard.textWidth(fitted, fVar14);
        float valueX = px + pw - fVar14 - fittedWidth;
        WaypointCard.rendererState();
        WaypointCard.drawText(4, mat, fitted, valueX);
        if (field.customText && WaypointCard.isFocused(field)) {
            WaypointCard.rendererState();
            WaypointCard.drawCaret(mat, valueX + fVar14 + 1.0f, fVar16);
        }
        WaypointCard.releaseText(value);
        WaypointCard.releaseText(label);
        WaypointCard.releaseText(fitted);
    }

    private String formatCaption() {
        long ticks;
        long left;
        if (0L < this.info.deadline && 0L < (left = this.info.deadline - (ticks = WaypointCard.systemTicks()) / 10000L)) {
            long seconds = left / 1000L;
            long minutes = seconds / 60L;
            long remainder = seconds + minutes * -60L;
            return WaypointCard.formatCaptionPair(minutes, remainder);
        }
        if (this.info.flag99) {
            return "";
        }
        String world = WaypointCard.currentWorldName();
        if (world == null) {
            return "";
        }
        if (!world.equals(this.info.world)) {
            return "";
        }
        double dx = WaypointCard.playerX() - (double)this.info.x;
        double dy = WaypointCard.playerY() - (double)this.info.y;
        double dz = WaypointCard.playerZ() - (double)this.info.z;
        return WaypointCard.toDistanceText(Math.sqrt(dx * dx + dy * dy + dz * dz));
    }

    public void onTitleChanged(String value) {
        int start;
        int end = value.length();
        for (start = 0; start < end && ' ' >= value.charAt(start); ++start) {
        }
        while (start < end && ' ' >= value.charAt(end - 1)) {
            --end;
        }
        if (start < end && value.charAt(start) == '+') {
            ++start;
        }
        if (start == end) {
            return;
        }
        if (value.substring(start, end).equals(this.info.key)) {
            return;
        }
        if (this.callbackTitle == null) {
            return;
        }
        WaypointCard.invokeInfoCallback(this.callbackTitle, this.info);
    }

    public void onCoordChanged(String value, int axis) {
        int newZ;
        int newY;
        int newX;
        int currentX = this.info.x;
        int currentY = this.info.y;
        int currentZ = this.info.z;
        int[] triple = WaypointCard.parseCoordinateTriple(value);
        if (triple != null) {
            newX = triple[0];
            newY = triple[1];
            newZ = triple[2];
        } else {
            int parsed;
            newX = parsed = WaypointCard.parseCoordinate(value);
            newY = currentY;
            newZ = currentZ;
            if (axis != 0) {
                newX = currentX;
                newY = parsed;
                if (axis != 1) {
                    newY = currentY;
                    newZ = parsed;
                }
            }
        }
        if (newX == currentX && newY == currentY && newZ == currentZ) {
            return;
        }
        if (this.callbackCoord == null) {
            return;
        }
        WaypointCard.invokeCoordCallback(this.callbackCoord, this.info, newX, newY, newZ);
    }

    private void onPlateMoveAction(WaypointCard card, Object closure) {
        WaypointCard.playClickSound(12);
        if (card.callbackDelete != null) {
            WaypointCard.invokeInfoCallback(card.callbackDelete, card.info);
        }
    }

    private void onPlateCopyAction(WaypointCard card, Object closure) {
        WaypointCard.playClickSound(14);
        if (card.callbackCopy != null) {
            WaypointCard.invokeInfoCallback(card.callbackCopy, card.info);
        }
    }

    private void onPlateDeleteAction(WaypointCard card, Object closure) {
        WaypointCard.playClickSound(13);
        if (card.callbackMove != null) {
            WaypointCard.invokeInfoCallback(card.callbackMove, card.info);
        }
    }

    private void onTitleAction(String value) {
        this.onTitleChanged(value);
    }

    private void onCoordXAction(String value) {
        this.onCoordChanged(value, 0);
    }

    private void onCoordYAction(String value) {
        this.onCoordChanged(value, 1);
    }

    private void onCoordZAction(String value) {
        this.onCoordChanged(value, 2);
    }

    public Component addIconButton(float size, Consumer<String> onChanged) {
        PlateInput input = new PlateInput(size, onChanged);
        this.add(input);
        return input;
    }

    private static boolean acceptKeyCode(int code) {
        if (((long)code & 0xFFFFFFFFL) > 59L) {
            return false;
        }
        return (864532803075702784L >>> code & 1L) != 0L;
    }

    private static String coordLabel(int index) {
        if (index == 0) {
            return COORD_X;
        }
        return index == 1 ? COORD_Y : COORD_Z;
    }

    private static String formatCaptionPair(long minutes, long seconds) {
        return minutes + ":" + (seconds < 10L ? "0" : "") + seconds;
    }

    private static String toCoordinateText(int value) {
        return Integer.toString(value);
    }

    private static String toDistanceText(double distance) {
        return Double.toString(distance);
    }

    private static int[] parseCoordinateTriple(String value) {
        return null;
    }

    private static int parseCoordinate(String value) {
        return 0;
    }

    private static String currentWorldName() {
        return null;
    }

    private static double playerX() {
        return 0.0;
    }

    private static double playerY() {
        return 0.0;
    }

    private static double playerZ() {
        return 0.0;
    }

    private static long systemTicks() {
        return System.currentTimeMillis();
    }

    private static void assignPlateAction(PlateIconButton plate, IconButton icon, String label, PlateAction action) {
    }

    private static void assignIconAction(IconButton icon, PlateAction action) {
    }

    private static void assignLabel(IconButton icon, String label) {
    }

    private static void assignKeyCapture(PlateInput input, KeyPredicate predicate) {
    }

    private static void invokeInfoCallback(Object callback, WaypointInfo value) {
    }

    private static void invokeCoordCallback(Object callback, WaypointInfo value, int px, int py, int pz) {
    }

    private static void releaseCallback(Object callback) {
    }

    private static void releaseInfo(WaypointInfo value) {
    }

    private static void releaseInfoCopy(WaypointInfo value) {
    }

    private static void releaseSwitcher(SwitcherButton value) {
    }

    private static void releasePlateButton(PlateIconButton value) {
    }

    private static void releaseIconButton(IconButton value) {
    }

    private static void releaseText(String value) {
    }

    private static void playClickSound(int sound) {
    }

    private static void rendererState() {
    }

    private static float textWidth(String value, float reference) {
        return 0.0f;
    }

    private static String wrapText(String value, float width, float reference) {
        return value;
    }

    private static String ellipsize(String value, float width, float reference) {
        return value;
    }

    private static boolean isFocused(PlateInput field) {
        return false;
    }

    private static void drawPanel(Object mat, float px, float py, float pw, float ph, float radius, float alpha) {
    }

    private static void drawLabel(WaypointCard card, Object mat, float px, float py) {
    }

    private static void drawIconButton(PlateIconButton button, Object mat, float mouseX, float mouseY, float alpha) {
    }

    private static void renderIconButton(IconButton button, Object mat, float mouseX, float mouseY, float alpha) {
    }

    private static void drawTextAt(Object mat, int id, float px, float py, float pw, float ph) {
    }

    private static void drawFrame(Object mat, float px, float py, float pw, float ph, float radius, float alpha, int flags) {
    }

    private static void drawField(Object mat, float px, float py, float pw, float ph, float radius, float cornerA, float cornerB, float cornerC, float alpha) {
    }

    private static void drawText(int mode, Object mat, String value, float px) {
    }

    private static float drawAndMeasure(Object mat, PlateInput field, String value, float px) {
        return 0.0f;
    }

    private static void drawCaption(Object mat, float px, float py) {
    }

    private static void drawCaret(Object mat, float px, float py) {
    }

    public static final class WaypointInfo {
        public static final int NAME_OFFSET = 0;
        public static final int KEY_OFFSET = 32;
        public static final int X_OFFSET = 64;
        public static final int Y_OFFSET = 68;
        public static final int Z_OFFSET = 72;
        public static final int WORLD_OFFSET = 80;
        public static final int SELECTED_OFFSET = 112;
        public static final int EXTRA_OFFSET = 120;
        public static final int BROKEN_OFFSET = 152;
        public static final int FLAG99_OFFSET = 153;
        public static final int DEADLINE_OFFSET = 160;
        public static final int SIZE = 168;
        public String name = "";
        public String key = "";
        public int x;
        public int y;
        public int z;
        public String world = "";
        public boolean selected;
        public String extra = "";
        public boolean broken;
        public boolean flag99;
        public long deadline;
    }

    public static class SwitcherButton
    extends Component {
        public static final float DEFAULT_WIDTH = 28.0f;
        public static final float DEFAULT_HEIGHT = 16.0f;
        public static final float DRAG_THRESHOLD = 1.5f;
        public static final float DRAG_ORIGIN_PAD = 2.0f;
        public static final float DRAG_ORIGIN_EXTRA = 6.0f;
        public static final float DRAG_RANGE_INSET = 12.0f;
        public static final float DRAG_RANGE_EXTRA = 4.0f;
        public static final int HOVER_NONE = 0;
        public static final int HOVER_SWITCH = 1;
        public static final int HOVER_DRAG = 3;
        public static final int OPTION_ON_INDEX = 8;
        public boolean on;
        public boolean locked;
        public Object callback;
        public float target;
        public float fade;
        public float knob;
        public boolean dragging;
        public boolean dragPastThreshold;
        public boolean pressState;
        public double pressX;

        public SwitcherButton(boolean value) {
            float initial;
            this.on = value;
            this.target = initial = value ? 1.0f : 0.0f;
            this.fade = initial;
            this.knob = initial;
            this.dragging = false;
            this.dragPastThreshold = false;
            this.pressState = false;
            this.pressX = 0.0;
            this.setSize(28.0f, 16.0f);
        }

        public boolean mousePressed(float mouseX, float mouseY) {
            this.pressState = this.on;
            this.pressX = mouseX;
            this.dragging = true;
            this.dragPastThreshold = false;
            return true;
        }

        @Override
        public boolean mouseReleased(double mx, double my, int button) {
            boolean value;
            if (!this.dragging || button != 0) {
                return false;
            }
            this.dragging = false;
            this.dragPastThreshold = false;
            if (!this.dragPastThreshold) {
                value = this.pressState;
            } else {
                boolean bl = value = 0.5f <= this.target;
            }
            if (this.on != value) {
                this.on = value;
                if (!this.locked) {
                    SwitcherButton.updateOption((value ? 0 : 1) + 8);
                }
                if (this.callback != null) {
                    SwitcherButton.invokeSwitcherCallback(this.callback);
                }
            }
            this.target = value ? 1.0f : 0.0f;
            return true;
        }

        @Override
        public boolean mouseMoved(double mx, double my, double delta) {
            float fraction;
            if (!this.dragging) {
                return false;
            }
            if (!this.dragPastThreshold) {
                if (Math.abs(mx - this.pressX) < 1.5) {
                    return true;
                }
                this.dragPastThreshold = true;
            }
            if ((fraction = (float)((mx - (double)(this.x + 2.0f + 6.0f)) / (double)(this.width - 12.0f - 4.0f))) < 0.0f) {
                fraction = 0.0f;
            }
            if (fraction > 1.0f) {
                fraction = 1.0f;
            }
            this.target = fraction;
            return true;
        }

        @Override
        public void render(Object mat, float mouseX, float mouseY, float alpha) {
            if (this.dragPastThreshold) {
                Screen.hoveredWidget = 3;
            } else if (this.dragging || !(mouseX < this.x) && !(this.x + this.width < mouseX) && !(mouseY < this.y) && !(this.y + this.height < mouseY) && (Screen.focusedWidget == null || Screen.allowHover)) {
                Screen.hoveredWidget = 1;
            }
            SwitcherButton.drawSwitch(mat, this.x, this.y, this.width, this.height, this.knob, this.fade, this.on, alpha);
        }

        public boolean isOn() {
            return this.on;
        }

        private static void updateOption(int index) {
        }

        private static void invokeSwitcherCallback(Object target) {
        }

        private static void drawSwitch(Object mat, float px, float py, float pw, float ph, float knob, float fade, boolean on, float alpha) {
        }
    }

    public static class PlateIconButton
    extends Component {
        public int icon;
        public int variant;
        public boolean enabled = true;
        public final AbstractCard.Anim enabledAnim = new AbstractCard.Anim(1.0f, 0.22f, 0);
        public final AbstractCard.Anim hoverAnim = new AbstractCard.Anim(0.0f, 0.15f, 0);
        public String label = "";
        public Consumer<String> onAction;

        public PlateIconButton(int icon, String label) {
            this.icon = icon;
            this.variant = 0;
            this.label = label;
            this.setSize(42.0f, 42.0f);
        }

        public boolean mousePressed(float mouseX, float mouseY) {
            this.fire();
            return true;
        }

        public void fire() {
            if (this.onAction != null) {
                this.onAction.accept(this.label);
            }
        }
    }

    public static class IconButton
    extends Component {
        public int icon;
        public int activeIcon = 89;
        public boolean clickEnabled;
        public boolean disabled;
        public float iconSize;
        public final AbstractCard.Anim anim = new AbstractCard.Anim(0.0f, 0.15f, 0);
        public Runnable onClick;
        public Consumer<String> onAction;
        public String label = "";

        public IconButton(int icon, float size) {
            this.icon = icon;
            this.activeIcon = 89;
            this.clickEnabled = false;
            this.disabled = false;
            this.iconSize = size;
            this.setSize(size, size);
        }

        public boolean mousePressed(float mouseX, float mouseY) {
            this.fire();
            return true;
        }

        public void fire() {
            if (this.onClick != null) {
                this.onClick.run();
            }
        }
    }

    public static class PlateInput
    extends Component {
        public String text = "";
        public float size;
        public boolean flag25;
        public boolean flag26;
        public String minimum = "";
        public String maximum = "";
        public boolean customText;
        public KeyPredicate keyCapture;
        public Consumer<String> onChanged;

        public PlateInput(float size, Consumer<String> onChanged) {
            this.size = size;
            this.flag25 = true;
            this.flag26 = false;
            this.customText = false;
            this.onChanged = onChanged;
            this.setSize(size, size);
        }

        public String value() {
            return this.text;
        }

        public void setValue(String value) {
            this.text = value == null ? "" : value;
        }
    }

    public static interface KeyPredicate {
        public boolean test(int var1);
    }

    public static interface PlateAction {
        public void run(WaypointCard var1, Object var2);
    }
}

