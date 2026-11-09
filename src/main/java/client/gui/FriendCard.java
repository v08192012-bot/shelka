/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.AbstractCard;
import client.gui.Component;
import java.util.function.Consumer;

public class FriendCard
extends Component {
    public static final long VTABLE_RVA = 12596896L;
    public static final long RVA_CTOR = 1355376L;
    public static final long RVA_DTOR = 1358288L;
    public static final long RVA_DELETING_DTOR = 1357728L;
    public static final long RVA_SET_STATE = 1359952L;
    public static final long RVA_RENDER = 1360240L;
    public static final long RVA_ON_CLICK = 1364624L;
    public static final long RVA_REFRESH_BUTTONS = 1358880L;
    public static final long RVA_RENDER_ROW = 1363648L;
    public static final long RVA_RENDER_FOOTER = 1360976L;
    public static final long RVA_INFO_CTOR = 1357792L;
    public static final long RVA_RENDER_AVATAR = 1361952L;
    public static final long RVA_RENDER_NAME_INPUT = 21816016L;
    public static final long RVA_PLATE_BUTTON_CTOR = 1210816L;
    public static final long RVA_TEXT_BUTTON_CTOR = 1214352L;
    public static final long RVA_ICON_BUTTON_CTOR = 1209648L;
    public static final long RVA_ADD_ICON_BUTTON = 0x119910L;
    public static final long RVA_ASSIGN_CALLBACK_A = 1234176L;
    public static final long RVA_ASSIGN_CALLBACK_C = 1192400L;
    public static final long RVA_SET_LABEL = 1215472L;
    public static final long RVA_APPLY_INSTANT = 1216016L;
    public static final long RVA_COLOR_ANIM_CTOR = 1149568L;
    public static final long RVA_TEXT_WIDTH = 1215728L;
    public static final long RVA_DRAW_TEXT_BUTTON = 1216288L;
    public static final long RVA_DRAW_PLATE_BUTTON = 1211472L;
    public static final long RVA_DRAW_NAME = 1143168L;
    public static final long RVA_DRAW_TEXT_AT2 = 3494400L;
    public static final long RVA_DRAW_PANEL = 1139984L;
    public static final long RVA_RENDERER_STATE = 3515472L;
    public static final long RVA_TEXT_COLOR = 3516448L;
    public static final long RVA_FORMAT_TEXT = 3517424L;
    public static final long RVA_STRING_VIEW = 134512L;
    public static final long RVA_MEASURE_TEXT = 1773456L;
    public static final long RVA_BLUR_FOCUS = 1153696L;
    public static final long RVA_FOCUS_CHILD_WITH_TEXT = 1154000L;
    public static final long RVA_PLAY_CLICK_SOUND = 36640L;
    public static final long RVA_DISPLAY_NAME = 199312L;
    public static final long RVA_MOVE_STRING = 82320L;
    public static final long RVA_FREE_STRING = 31152L;
    public static final int OFF_INFO = 624;
    public static final int OFF_DISPLAY_NAME = 856;
    public static final int OFF_NAME_INPUT = 888;
    public static final int OFF_AVATAR_RECT = 896;
    public static final int OFF_AVATAR_WIDTH = 904;
    public static final int OFF_AVATAR_HEIGHT = 908;
    public static final int OFF_COLOR_ANIM = 1232;
    public static final int OFF_BUTTON_ALIAS = 1280;
    public static final int OFF_BUTTON_REMOVE = 1568;
    public static final int OFF_BUTTON_INVITE = 1856;
    public static final int OFF_BUTTON_KICK = 2384;
    public static final int OFF_BUTTON_OWNER = 2912;
    public static final int OFF_BUTTON_ACCEPT = 3440;
    public static final int OFF_BUTTON_DECLINE = 3968;
    public static final int OFF_STATE = 136;
    public static final int OFF_INFO_MODE = 168;
    public static final int OFF_INFO_STATUS = 172;
    public static final int OFF_INFO_FLAG_AD = 173;
    public static final int OFF_INFO_FLAG_B1 = 177;
    public static final int OFF_INFO_FLAG_B2 = 178;
    public static final int OFF_INFO_FLAG_B3 = 179;
    public static final int OFF_TEXT_LABEL = 96;
    public static final int OFF_TEXT_ANIM = 112;
    public static final int OFF_TEXT_FADE_FLAG = 264;
    public static final int OFF_TEXT_OLD_LABEL = 312;
    public static final int OFF_TEXT_CALLBACK = 408;
    public static final int OFF_TEXT_TOOLTIP = 416;
    public static final int OFF_TEXT_EXTRA = 456;
    public static final float CARD_WIDTH = 930.0f;
    public static final float CARD_HEIGHT = 62.0f;
    public static final float CARD_HEIGHT_SELECTED = 112.0f;
    public static final float PLATE_BUTTON_SIZE = 42.0f;
    public static final float NAME_INPUT_SIZE = 12.0f;
    public static final float AVATAR_MIN_SIZE = 30.0f;
    public static final float AVATAR_HEIGHT = 16.0f;
    public static final float PANEL_RADIUS = 18.0f;
    public static final float FADE_FLAG_THRESHOLD = 0.001f;
    public static final float ROW_GAP = 4.0f;
    public static final float TEXT_PADDING = 6.0f;
    public static final float ALPHA_CAP = 127.5f;
    public static final int COLOR_INVITE = -10571281;
    public static final int COLOR_FRIEND = -10569333;
    public static final int COLOR_REQUEST = -17896;
    public static final int COLOR_ENEMY = -2276315;
    public static final int COLOR_DEFAULT = -8158333;
    public static final int ICON_ALIAS = 81;
    public static final int ICON_REMOVE = 82;
    public static final int TEXT_ID_INVITE = 76;
    public static final int TEXT_ID_KICK = 77;
    public static final int TEXT_ID_OWNER = 75;
    public static final int TEXT_ID_ACCEPT = 20;
    public static final int TEXT_ID_DECLINE = 22;
    public static final int SOUND_ENABLE = 8;
    public static final String TEXT_INVITE_SHORT = "\u041a\u0438\u0441\u043a";
    public static final String TEXT_INVITE_LONG = "\u041a\u0438\u0441\u043a \u0424\u0440\u043e\u043c \u041f\u0430\u0440\u0442\u0439";
    public static final String TEXT_OWNER_SHORT = "\u041e\u0448\u043d\u0435\u0440";
    public static final String TEXT_OWNER_LONG = "\u0413\u0438\u0432\u0435 \u041e\u0448\u043d\u0435\u0440";
    public static final String LABEL_INVITE = "\u0418\u043d\u0432\u0438\u0442\u0435";
    public static final String LABEL_ACCEPT = "\u0410\u0441\u0441\u0435\u043f\u0442";
    public static final String LABEL_DECLINE = "\u0414\u0435\u0441\u043b\u0438\u043d\u0435";
    public static final String LABEL_ALIAS = "\u0418\u0437\u043c\u0435\u043d\u0438\u0442\u044c \u0430\u043b\u0438\u0430\u0441";
    public static final String LABEL_REMOVE = "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0438\u0437 \u0434\u0440\u0443\u0437\u0435\u0439";
    public static final String LABEL_INVITE_PARTY = "\u041f\u043e\u0437\u0432\u0430\u0442\u044c \u0432 \u043f\u0430\u0442\u0438";
    public static final String LABEL_KICK_PARTY = "\u0412\u044b\u0433\u043d\u0430\u0442\u044c \u0438\u0437 \u043f\u0430\u0442\u0438";
    public static final String LABEL_GIVE_OWNER = "\u041f\u0435\u0440\u0435\u0434\u0430\u0442\u044c \u043b\u0438\u0434\u0435\u0440\u0441\u0442\u0432\u043e";
    public static int hoverState;
    protected Info info;
    protected final PlateIconButton aliasButton = new PlateIconButton(81, "\u0418\u0437\u043c\u0435\u043d\u0438\u0442\u044c \u0430\u043b\u0438\u0430\u0441");
    protected final PlateIconButton removeButton = new PlateIconButton(82, "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0438\u0437 \u0434\u0440\u0443\u0437\u0435\u0439");
    protected final TextButton inviteButton = new TextButton(76, "\u0418\u043d\u0432\u0438\u0442\u0435");
    protected final TextButton kickButton = new TextButton(77, "\u041a\u0438\u0441\u043a \u0424\u0440\u043e\u043c \u041f\u0430\u0440\u0442\u0439");
    protected final TextButton ownerButton = new TextButton(75, "\u0413\u0438\u0432\u0435 \u041e\u0448\u043d\u0435\u0440");
    protected final TextButton acceptButton = new TextButton(20, "\u0410\u0441\u0441\u0435\u043f\u0442");
    protected final TextButton declineButton = new TextButton(22, "\u0414\u0435\u0441\u043b\u0438\u043d\u0435");
    protected final PlateIconButton[] iconButtons = new PlateIconButton[]{this.aliasButton, this.removeButton};
    protected final PlateIconButton[] iconLayoutOrder = new PlateIconButton[]{this.removeButton, this.aliasButton};
    protected final TextButton[] textButtons = new TextButton[]{this.inviteButton, this.kickButton, this.ownerButton, this.acceptButton, this.declineButton};
    protected final TextButton[] textLayoutOrder = new TextButton[]{this.inviteButton, this.ownerButton, this.kickButton, this.declineButton, this.acceptButton};
    protected final IconInputButton nameInput = new IconInputButton(12.0f);
    protected final ColorAnim colorAnim = new ColorAnim();
    protected final Rect avatarRect = new Rect(0.0f, 0.0f, 0.0f, 0.0f);
    protected Consumer<Info> onAlias;
    protected Runnable onRemove;
    protected Consumer<Info> onInvite;
    protected Consumer<Info> onKick;
    protected Consumer<Info> onGiveOwner;
    protected Consumer<Info> onAccept;
    protected Consumer<Info> onDecline;
    protected final ButtonTemplate[] templates = new ButtonTemplate[3];
    protected int state;
    protected AbstractCard.Anim animX;
    protected AbstractCard.Anim animY;
    protected boolean animatingPosition;

    public FriendCard(Info friendInfo) {
        this.info = friendInfo;
        this.add(this.aliasButton);
        this.add(this.removeButton);
        this.add(this.inviteButton);
        this.add(this.kickButton);
        this.add(this.ownerButton);
        this.add(this.acceptButton);
        this.add(this.declineButton);
        this.add(this.nameInput);
        this.aliasButton.onAction = this::onAliasClicked;
        this.removeButton.onAction = this::onRemoveClicked;
        this.inviteButton.onClick = this::onInviteClicked;
        this.kickButton.onClick = this::onKickClicked;
        this.ownerButton.onClick = this::onGiveOwnerClicked;
        this.acceptButton.onClick = this::onAcceptClicked;
        this.declineButton.onClick = this::onDeclineClicked;
        this.nameInput.onAction = this::onNameCommitted;
        this.colorAnim.reset(this.nameColor());
        String display = friendInfo == null ? "" : friendInfo.name;
        this.inviteButton.setTooltip(LABEL_INVITE_PARTY);
        this.kickButton.setTooltip(LABEL_KICK_PARTY);
        this.ownerButton.setTooltip(LABEL_GIVE_OWNER);
        if (this.state != 0) {
            this.kickButton.setLabel(TEXT_INVITE_LONG);
            this.ownerButton.setLabel(TEXT_OWNER_LONG);
        }
        this.state = 0;
        this.width = 930.0f;
        this.height = 62.0f;
        this.refreshButtons(true);
    }

    private void onAliasClicked(String value) {
    }

    private void onRemoveClicked(String value) {
    }

    private void onInviteClicked() {
    }

    private void onKickClicked() {
    }

    private void onGiveOwnerClicked() {
    }

    private void onAcceptClicked() {
    }

    private void onDeclineClicked() {
    }

    private void onNameCommitted(String value) {
    }

    public void setState(int newState, float newWidth) {
        if (newState != this.state) {
            this.kickButton.setLabel(newState == 1 ? TEXT_INVITE_SHORT : TEXT_INVITE_LONG);
            this.ownerButton.setLabel(newState == 1 ? TEXT_OWNER_SHORT : TEXT_OWNER_LONG);
        }
        this.width = newWidth;
        this.state = newState;
        this.height = newState == 1 ? 112.0f : 62.0f;
    }

    public void applyPositionAnimation(long time) {
        if (!this.animatingPosition || this.animX == null || this.animY == null) {
            return;
        }
        this.x = this.animX.update(time);
        this.y = this.animY.update(time);
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

    @Override
    public void setPosition(float px, float py) {
        this.setPositionAnimated(px, py);
    }

    public void refreshButtons(boolean instant) {
        float target;
        boolean hasName;
        String display = FriendCard.displayName(this.info == null ? "" : this.info.name);
        this.aliasButton.enabled = this.info != null && this.info.mode == 1 && this.info.flagB2;
        this.removeButton.enabled = this.info != null && this.info.mode == 1 && this.info.flagB1;
        this.inviteButton.enabled = this.info != null && this.info.mode == 1 && !this.info.flagAD && this.info.groupMode == 2;
        this.kickButton.enabled = this.info != null && this.info.mode == 2 && this.info.flagB3;
        this.ownerButton.enabled = this.info != null && this.info.mode == 2 && this.info.flagB3;
        this.acceptButton.enabled = this.info != null && this.info.mode == 3;
        boolean bl = this.declineButton.enabled = this.info != null && this.info.mode == 3;
        if (instant) {
            this.aliasButton.enabledAnim.snap(this.aliasButton.enabled ? 1.0f : 0.0f);
            this.removeButton.enabledAnim.snap(this.removeButton.enabled ? 1.0f : 0.0f);
            FriendCard.applyEnabledInstant(this.inviteButton);
            FriendCard.applyEnabledInstant(this.kickButton);
            FriendCard.applyEnabledInstant(this.ownerButton);
            FriendCard.applyEnabledInstant(this.acceptButton);
            FriendCard.applyEnabledInstant(this.declineButton);
        } else {
            this.aliasButton.enabledAnim.setTarget(this.aliasButton.enabled ? 1.0f : 0.0f);
            this.removeButton.enabledAnim.setTarget(this.removeButton.enabled ? 1.0f : 0.0f);
            FriendCard.applyEnabledAnimated(this.inviteButton);
            FriendCard.applyEnabledAnimated(this.kickButton);
            FriendCard.applyEnabledAnimated(this.ownerButton);
            FriendCard.applyEnabledAnimated(this.acceptButton);
            FriendCard.applyEnabledAnimated(this.declineButton);
        }
        this.inviteButton.tooltipVisible = hasName = this.info != null && this.info.name != null && !this.info.name.isEmpty();
        float f = target = hasName ? 1.0f : 0.0f;
        if (this.inviteButton.tooltipAnim.target != target) {
            this.inviteButton.tooltipAnim.from = this.inviteButton.tooltipAnim.update(this.now());
            this.inviteButton.tooltipAnim.target = target;
            this.inviteButton.tooltipAnim.start = this.now();
            this.inviteButton.tooltipAnim.running = true;
        }
        this.inviteButton.setLabel(display);
        this.nameInput.setText(display);
    }

    private static void applyEnabledInstant(TextButton button) {
        float value;
        button.animFrom = value = button.enabled ? 1.0f : 0.0f;
        button.animCurrent = value;
        button.animTarget = value;
        button.animRunning = false;
    }

    private static void applyEnabledAnimated(TextButton button) {
        button.animTarget = button.enabled ? 1.0f : 0.0f;
    }

    @Override
    public void render(Object renderer, float mouseX, float mouseY, float alpha) {
        float used;
        int currentState;
        this.applyPositionAnimation(this.now());
        FriendCard.drawPanel(renderer, this.x, this.y, this.width, this.height, 18.0f, alpha);
        if (0.0f < this.avatarRect.w && mouseX >= this.avatarRect.x && mouseX <= this.avatarRect.x + this.avatarRect.w && mouseY >= this.avatarRect.y && mouseY <= this.avatarRect.y + this.avatarRect.h) {
            hoverState = 2;
        }
        float rowY = (currentState = this.state) == 1 ? this.y + 11.0f : (this.height - 42.0f) * 0.5f + this.y;
        int color = this.nameColor();
        FriendCard.drawNameText(renderer, this.x + 12.0f, rowY, 34, color, alpha);
        float right = this.x + this.width - 12.0f;
        if (currentState == 1) {
            used = this.renderRow(renderer, right, rowY, mouseX, mouseY, alpha, 1);
            this.renderRow(renderer, right, rowY + 42.0f + 6.0f, mouseX, mouseY, alpha, 2);
        } else {
            used = this.renderRow(renderer, right, rowY, mouseX, mouseY, alpha, 0);
        }
        float start = this.x + 12.0f + 42.0f + 6.0f;
        float width2 = right - start - used;
        if (width2 <= 0.0f) {
            width2 = 0.0f;
        }
        this.renderFooter(renderer, start, rowY - 1.0f, width2, alpha);
    }

    public float renderRow(Object renderer, float right, float rowY, float mouseX, float mouseY, float alpha, int mode) {
        int i;
        float cursor = right;
        if (mode == 2) {
            this.layoutTextButtons(cursor, rowY);
            this.drawTextButtons(renderer, mouseX, mouseY, alpha);
            return right - cursor;
        }
        for (i = 0; i < this.iconLayoutOrder.length; ++i) {
            PlateIconButton button = this.iconLayoutOrder[i];
            float size = button.enabledAnim.update(this.now()) * 42.0f;
            button.setPosition(cursor - size, rowY);
            button.setSize(size, size);
            if (!(0.001f < size)) continue;
            cursor -= size + 4.0f;
        }
        if (mode != 1) {
            this.layoutTextButtons(cursor, rowY);
            this.drawTextButtons(renderer, mouseX, mouseY, alpha);
        }
        for (i = 0; i < this.iconButtons.length; ++i) {
            FriendCard.drawIconButton(renderer, this.iconButtons[i], mouseX, mouseY, alpha);
        }
        return right - cursor;
    }

    protected void layoutTextButtons(float right, float rowY) {
        float cursor = right;
        for (int i = 0; i < this.textLayoutOrder.length; ++i) {
            TextButton button = this.textLayoutOrder[i];
            float width = button.textWidth();
            button.setPosition(cursor - width, rowY);
            if (!(0.001f < button.getWidth())) continue;
            cursor -= button.getWidth() + 4.0f;
        }
    }

    protected void drawTextButtons(Object renderer, float mouseX, float mouseY, float alpha) {
        FriendCard.drawTextButton(renderer, this.acceptButton, mouseX, mouseY, alpha);
        FriendCard.drawTextButton(renderer, this.declineButton, mouseX, mouseY, alpha);
        FriendCard.drawTextButton(renderer, this.kickButton, mouseX, mouseY, alpha);
        FriendCard.drawTextButton(renderer, this.ownerButton, mouseX, mouseY, alpha);
        FriendCard.drawTextButton(renderer, this.inviteButton, mouseX, mouseY, alpha);
    }

    public void renderFooter(Object renderer, float px, float py, float width, float alpha) {
        boolean showInput;
        String alias = this.info == null ? "" : this.info.alias;
        float textWidth = FriendCard.measureText(alias, Math.min(alpha, 127.5f), 16.0f);
        FriendCard.drawTextAt2(renderer, 4, px, alias, alpha);
        this.avatarRect.w = 0.0f;
        float inputX = px + textWidth + 6.0f;
        boolean bl = showInput = (alias.isEmpty() || this.nameInput.focused || this.info != null && this.info.flagB2) && this.info != null && this.info.flagB2;
        if (0.0f < alpha - (inputX - px) && (!alias.isEmpty() || this.nameInput.focused || showInput)) {
            float inputY = py + 6.0f;
            FriendCard.textColor(renderer, 63, showInput);
            float inputWidth = FriendCard.renderNameInput(renderer, this.nameInput, alias, inputX);
            if (this.info != null && this.info.flagB2) {
                this.avatarRect.x = inputX - 2.0f;
                this.avatarRect.y = inputY - 2.0f;
                this.avatarRect.w = Math.max(30.0f, inputWidth + 4.0f);
                this.avatarRect.h = 16.0f;
            }
        }
        FriendCard.drawAvatar(renderer, px, py + 24.0f);
    }

    protected int nameColor() {
        if (this.info == null) {
            return -10571281;
        }
        switch (this.info.status) {
            case 1: {
                return -10569333;
            }
            case 2: {
                return -17896;
            }
            case 3: {
                return -2276315;
            }
        }
        return -8158333;
    }

    public boolean onMouse(double mx, double my, int button) {
        Component current;
        int i;
        for (i = 0; i < this.iconButtons.length; ++i) {
            current = this.iconButtons[i];
            if (!((PlateIconButton)current).mousePressed(mx, my, button)) continue;
            AbstractCard.blurFocusedChildren(this);
            return true;
        }
        for (i = 0; i < this.textButtons.length; ++i) {
            current = this.textButtons[i];
            if (!((TextButton)current).mousePressed(mx, my, button)) continue;
            AbstractCard.blurFocusedChildren(this);
            return true;
        }
        if (button == 0 && 0.0f < this.avatarRect.w && mx >= (double)this.avatarRect.x && mx <= (double)(this.avatarRect.x + this.avatarRect.w) && my >= (double)this.avatarRect.y && my <= (double)(this.avatarRect.y + this.avatarRect.h)) {
            AbstractCard.focusChildWithText(this, this.nameInput, this.info == null ? "" : this.info.name);
            return true;
        }
        return false;
    }

    public static void playClickSound(int sound) {
        FriendCard.uiSound(sound);
    }

    public static String displayName(String value) {
        return value;
    }

    public static void drawPanel(Object renderer, float x, float y, float width, float height, float radius, float alpha) {
    }

    public static void drawNameText(Object renderer, float x, float y, int id, int color, float alpha) {
    }

    public static void drawIconButton(Object renderer, Component button, float mouseX, float mouseY, float alpha) {
    }

    public static void drawTextButton(Object renderer, Component button, float mouseX, float mouseY, float alpha) {
    }

    public static void drawAvatar(Object renderer, float x, float y) {
    }

    public static void drawTextAt2(Object renderer, int mode, float x, String text, float alpha) {
    }

    public static float measureText(String text, float alpha, float size) {
        return 0.0f;
    }

    public static void textColor(Object renderer, int alpha, boolean highlight) {
    }

    public static float renderNameInput(Object renderer, Component input, String value, float x) {
        return 0.0f;
    }

    public static float formatText(String value, float alpha, float size) {
        return 0.0f;
    }

    public static class PlateIconButton
    extends Component {
        public static final int OFF_ICON = 96;
        public static final int OFF_VARIANT = 100;
        public static final int OFF_ENABLED = 104;
        public static final int OFF_ENABLED_ANIM = 112;
        public static final int OFF_HOVER_ANIM = 152;
        public static final int OFF_CALLBACK = 192;
        public static final int OFF_LABEL = 256;
        public static final float DEFAULT_SIZE = 42.0f;
        public int icon;
        public int variant;
        public boolean enabled = true;
        public final AbstractCard.Anim enabledAnim = new AbstractCard.Anim(1.0f, 0.22f, 0);
        public final AbstractCard.Anim hoverAnim = new AbstractCard.Anim(0.0f, 0.15f, 0);
        public String label;
        public Consumer<String> onAction;

        public PlateIconButton(int icon, String label) {
            this.icon = icon;
            this.label = label;
            this.setSize(42.0f, 42.0f);
        }

        public boolean mousePressed(double mx, double my, int button) {
            return this.enabled && button == 0 && this.contains(mx, my);
        }
    }

    public static class TextButton
    extends Component {
        public static final int OFF_LABEL = 96;
        public static final int OFF_ANIM = 112;
        public static final int OFF_ENABLED = 140;
        public static final int OFF_VALUE_FROM = 144;
        public static final int OFF_VALUE_CURRENT = 148;
        public static final int OFF_VALUE_TARGET = 152;
        public static final int OFF_ANIM_RUNNING = 176;
        public static final int OFF_FADE_FLAG = 264;
        public static final int OFF_OLD_LABEL = 312;
        public static final int OFF_CALLBACK = 408;
        public static final int OFF_TOOLTIP = 416;
        public static final int OFF_TOOLTIP_VISIBLE = 448;
        public static final int OFF_EXTRA = 456;
        public static final int OFF_TOOLTIP_ANIM = 488;
        public int id;
        public boolean enabled = true;
        public String label = "";
        public String oldLabel = "";
        public String tooltip = "";
        public String extra = "";
        public Runnable onClick;
        public float animFrom;
        public float animCurrent;
        public float animTarget;
        public boolean animRunning;
        public boolean tooltipVisible;
        public boolean fadeFlag;
        public final AbstractCard.Anim tooltipAnim = new AbstractCard.Anim(0.0f, 0.22f, 0);

        public TextButton(int id, String label) {
            this.id = id;
            this.label = label;
        }

        public boolean mousePressed(double mx, double my, int button) {
            return this.enabled && button == 0 && this.contains(mx, my);
        }

        public float textWidth() {
            return 0.0f;
        }

        public void setLabel(String value) {
            String next;
            String string = next = value == null ? "" : value;
            if (!this.label.equals(next)) {
                if (this.fadeFlag && 0.001f < this.alpha) {
                    this.oldLabel = this.label;
                }
                this.label = next;
            }
        }

        public void setTooltip(String value) {
            this.tooltip = value == null ? "" : value;
        }
    }

    public static class IconInputButton
    extends Component
    implements AbstractCard.InputChild {
        public static final int OFF_ICON = 96;
        public static final int OFF_VARIANT = 100;
        public static final int OFF_SIZE = 108;
        public static final int OFF_ANIM = 112;
        public static final int OFF_CALLBACK = 152;
        public static final int OFF_TEXT = 216;
        public static final int OFF_FLAG_D9 = 217;
        public int icon;
        public int variant = 89;
        public float iconSize;
        public boolean flagD9;
        public String text = "";
        public Consumer<String> onAction;
        public Consumer<String> onCommit;
        public final AbstractCard.Anim anim = new AbstractCard.Anim(0.0f, 0.15f, 0);

        public IconInputButton(float size) {
            this.iconSize = size;
            this.setSize(size, size);
        }

        public boolean mousePressed(double mx, double my, int button) {
            return button == 0 && this.contains(mx, my);
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
            return this.flagD9;
        }

        @Override
        public void commit() {
            if (this.onAction != null) {
                this.onAction.accept(this.text);
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

    public static final class ColorAnim {
        public static final int OFF_ALPHA_FROM = 0;
        public static final int OFF_ALPHA_CURRENT = 4;
        public static final int OFF_ALPHA_TARGET = 8;
        public static final int OFF_DURATION = 12;
        public static final int OFF_EASING = 16;
        public static final int OFF_START = 24;
        public static final int OFF_RUNNING = 32;
        public static final int OFF_COLOR_FROM = 40;
        public static final int OFF_COLOR_TO = 44;
        public static final int EASING = 0;
        public float alphaFrom = 1.0f;
        public float alphaCurrent = 1.0f;
        public float alphaTarget = 1.0f;
        public float duration = 0.22f;
        public int colorFrom;
        public int colorTo;
        public long start = System.nanoTime();
        public boolean running;

        public void reset(int color) {
            this.colorFrom = color;
            this.colorTo = color;
            this.alphaFrom = 1.0f;
            this.alphaCurrent = 1.0f;
            this.alphaTarget = 1.0f;
            this.start = System.nanoTime();
            this.running = false;
        }

        public void setColor(int color) {
            if (this.colorTo != color) {
                this.colorFrom = this.colorTo;
                this.colorTo = color;
                this.start = System.nanoTime();
                this.running = true;
            }
        }
    }

    public static final class Rect {
        public float x;
        public float y;
        public float w;
        public float h;

        public Rect(float x, float y, float w, float h) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }
    }

    public static final class ButtonTemplate {
        public static final int OFF_LABEL = 0;
        public static final int OFF_ICON = 80;
        public static final int OFF_SIZE = 96;
        public static final int OFF_FLAG = 112;
        public String label = "";
        public int icon;
        public float width;
        public float height;
        public boolean flag;
    }

    public static final class Info {
        public static final int OFF_MODE = 168;
        public static final int OFF_STATUS = 172;
        public static final int OFF_FLAG_AD = 173;
        public static final int OFF_FLAG_AE = 174;
        public static final int OFF_FLAG_AF = 175;
        public static final int OFF_FLAG_B0 = 176;
        public static final int OFF_FLAG_B1 = 177;
        public static final int OFF_FLAG_B2 = 178;
        public static final int OFF_FLAG_B3 = 179;
        public String name = "";
        public String alias = "";
        public int mode;
        public int groupMode;
        public int status;
        public boolean flagAD;
        public boolean flagAE;
        public boolean flagAF;
        public boolean flagB0;
        public boolean flagB1;
        public boolean flagB2;
        public boolean flagB3;
    }
}

