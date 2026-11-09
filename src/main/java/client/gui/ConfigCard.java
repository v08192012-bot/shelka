package client.gui;

import client.gui.AbstractCard;
import client.gui.Component;
import java.util.function.Consumer;

public class ConfigCard extends Component {
    public static final long VTABLE_RVA = 12590104L;
    public static final long RVA_CTOR = 1234288L;
    public static final long RVA_DTOR = 1236816L;
    public static final long RVA_DELETING_DTOR = 1236752L;
    public static final long RVA_SET_STATE = 1238256L;
    public static final long RVA_RENDER = 1238304L;
    public static final long RVA_ON_CLICK = 1246112L;
    public static final long RVA_MOUSE_RELEASED = 1240464L;
    public static final long RVA_MOUSE_MOVED = 1240592L;
    public static final long RVA_REFRESH_STATE = 1237856L;
    public static final long RVA_HOVER_TEST = 1238864L;
    public static final long RVA_RENDER_COLLAPSED = 1239376L;
    public static final long RVA_RENDER_EXPANDED = 1240672L;
    public static final long RVA_ADD_ICON_BUTTON = 0x119910L;
    public static final long RVA_FAVOURITE_CTOR = 1208720L;
    public static final long RVA_SWITCHER_CTOR = 1212736L;
    public static final long RVA_PLATE_BUTTON_CTOR = 1210816L;
    public static final long RVA_ICON_BUTTON_CTOR = 1209648L;
    public static final long RVA_ASSIGN_CALLBACK_A = 1218400L;
    public static final long RVA_ASSIGN_CALLBACK_B = 1234176L;
    public static final long RVA_ASSIGN_CALLBACK_C = 1192400L;
    public static final long RVA_SWITCHER_RELEASE = 1214144L;
    public static final long RVA_SWITCHER_DRAG = 1213920L;
    public static final long RVA_DRAW_SWITCHER_BUTTON = 1208992L;
    public static final long RVA_DRAW_PANEL = 1139984L;
    public static final long RVA_DRAW_PLATE_BUTTON = 1242096L;
    public static final long RVA_DRAW_ICON_BUTTON = 1211472L;
    public static final long RVA_DRAW_FAVOURITE = 1245344L;
    public static final long RVA_DRAW_SMALL_BUTTON = 1244064L;
    public static final long RVA_DRAW_TEXT_BUTTON = 1242640L;
    public static final long RVA_DRAW_NAME_TEXT = 1143168L;
    public static final long RVA_DRAW_NINE_PATCH = 3503536L;
    public static final long RVA_DRAW_TEXT_AT = 3491616L;
    public static final long RVA_DRAW_RECT = 3511904L;
    public static final long RVA_DRAW_PROGRESS_BAR = 3505888L;
    public static final long RVA_DRAW_GLOW = 3507648L;
    public static final long RVA_RENDERER_STATE = 3515472L;
    public static final long RVA_MEASURE_TEXT = 1773456L;
    public static final long RVA_PLAY_CLICK_SOUND = 36640L;
    public static final int OFF_INFO = 752;
    public static final int OFF_FAVOURITE_BUTTON = 768;
    public static final int OFF_SWITCHER_BUTTON = 976;
    public static final int OFF_SAVE_BUTTON = 1168;
    public static final int OFF_COPY_BUTTON = 1456;
    public static final int OFF_DELETE_BUTTON = 1744;
    public static final int OFF_SETTINGS_BUTTON = 2032;
    public static final int OFF_ICON_BUTTON_A = 2320;
    public static final int OFF_ICON_BUTTON_B = 2568;
    public static final int OFF_ICON_BUTTON_C = 2816;
    public static final int OFF_ICON_BUTTON_D = 3064;
    public static final int OFF_FADE_ANIM_A = 3312;
    public static final int OFF_FADE_ANIM_B = 3352;
    public static final int OFF_PANEL_ANIM_A = 3392;
    public static final int OFF_PANEL_ANIM_B = 3432;
    public static final int OFF_RECT_ANIM_A = 3472;
    public static final int OFF_RECT_ANIM_B = 3512;
    public static final int OFF_ADD_BUTTON_A = 3552;
    public static final int OFF_ADD_BUTTON_B = 3560;
    public static final int OFF_TOGGLE_RECT = 3568;
    public static final int OFF_OK_RECT = 3584;
    public static final int OFF_CANCEL_RECT = 3600;
    public static final int OFF_OK_INPUT_RECT = 3616;
    public static final int OFF_DELETE_RECT = 3624;
    public static final int OFF_CLOSE_CALLBACK = 232;
    public static final int OFF_CANCEL_CALLBACK = 552;
    public static final int OFF_STATE = 136;
    public static final int OFF_FADE_CURRENT_A = 3316;
    public static final int OFF_FADE_CURRENT_B = 3356;
    public static final int OFF_INFO_VALID = 96;
    public static final int OFF_INFO_GROUP = 97;
    public static final int OFF_INFO_BROKEN = 98;
    public static final int OFF_INFO_NAME = 0;
    public static final int OFF_INFO_KEY = 32;
    public static final float CARD_WIDTH = 930.0f;
    public static final float CARD_HEIGHT = 62.0f;
    public static final float CARD_HEIGHT_SELECTED = 174.0f;
    public static final float FAVOURITE_SIZE = 14.0f;
    public static final float ICON_SIZE = 20.0f;
    public static final float ADD_BUTTON_SIZE_A = 16.0f;
    public static final float ADD_BUTTON_SIZE_B = 12.0f;
    public static final float FADE_THRESHOLD = 0.5f;
    public static final float PANEL_RADIUS = 18.0f;
    public static final float HIDDEN_RECT_SIZE = 42.0f;
    public static final float INPUT_RECT_SIZE_A = 16.0f;
    public static final float INPUT_RECT_SIZE_B = 12.0f;
    public static final float ROW_HEIGHT = 42.0f;
    public static final float ROW_PADDING = 12.0f;
    public static final float BUTTON_GAP = 6.0f;
    public static final float SHRINK_SCALE = 0.5f;
    public static final int ICON_SAVE = 30;
    public static final int ICON_COPY = 31;
    public static final int ICON_DELETE = 82;
    public static final int ICON_SETTINGS = 27;
    public static final int ICON_TOGGLE = 32;
    public static final int SOUND_ENABLE = 8;
    public static final int SOUND_CANCEL = 14;
    public static final int SOUND_TOGGLE_ON = 9;
    public static final String LABEL_SAVE = "\u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c \u0432 \u044d\u0442\u043e\u0442 \u043a\u043e\u043d\u0444\u0438\u0433";
    public static final String LABEL_COPY = "\u0421\u043a\u043e\u043f\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u043a\u043b\u044e\u0447";
    public static final String LABEL_DELETE = "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u043a\u043e\u043d\u0444\u0438\u0433";
    public static final String LABEL_SETTINGS = "\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u043a\u043e\u043d\u0444\u0438\u0433\u0430";
    public static int hoverState;
    protected ConfigInfo info;
    protected final FavouriteButton favouriteButton = new FavouriteButton();
    protected final SwitcherButton switcherButton = new SwitcherButton(true);
    protected final PlateIconButton saveButton = new PlateIconButton(30, "\u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c \u0432 \u044d\u0442\u043e\u0442 \u043a\u043e\u043d\u0444\u0438\u0433");
    protected final PlateIconButton copyButton = new PlateIconButton(31, "\u0421\u043a\u043e\u043f\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u043a\u043b\u044e\u0447");
    protected final PlateIconButton deleteButton = new PlateIconButton(82, "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u043a\u043e\u043d\u0444\u0438\u0433");
    protected final PlateIconButton settingsButton = new PlateIconButton(27, "\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u043a\u043e\u043d\u0444\u0438\u0433\u0430");
    protected final IconButton iconButtonA = new IconButton(30, 20.0f);
    protected final IconButton iconButtonB = new IconButton(31, 20.0f);
    protected final IconButton iconButtonC = new IconButton(32, 20.0f);
    protected final IconButton iconButtonD = new IconButton(27, 20.0f);
    protected final AbstractCard.Anim fadeAnimA = new AbstractCard.Anim(1.0f, 0.22f, 0);
    protected final AbstractCard.Anim fadeAnimB = new AbstractCard.Anim(1.0f, 0.22f, 0);
    protected final AbstractCard.Anim panelAnimA = new AbstractCard.Anim(0.0f, 0.22f, 0);
    protected final AbstractCard.Anim panelAnimB = new AbstractCard.Anim(0.0f, 0.22f, 0);
    protected final AbstractCard.Anim rectAnimA = new AbstractCard.Anim(0.0f, 0.0f, 0);
    protected final AbstractCard.Anim rectAnimB = new AbstractCard.Anim(0.0f, 0.0f, 0);
    protected final IconInputButton addButtonA = new IconInputButton(16.0f);
    protected final IconInputButton addButtonB = new IconInputButton(12.0f);
    protected final PlateIconButton[] collapsedButtons = new PlateIconButton[]{this.settingsButton, this.deleteButton, this.copyButton, this.saveButton};
    protected final IconButton[] expandedButtons = new IconButton[]{this.iconButtonD, this.iconButtonC, this.iconButtonB, this.iconButtonA};
    protected Consumer<ConfigInfo> onClose;
    protected Consumer<ConfigInfo> onCancel;
    protected final Rect toggleRect = new Rect(-1.0f, -1.0f, 0.0f, 0.0f);
    protected final Rect okRect = new Rect(-1.0f, -1.0f, 0.0f, 0.0f);
    protected final Rect cancelRect = new Rect(-1.0f, -1.0f, 0.0f, 0.0f);
    protected final Rect inputRectA = new Rect(-1.0f, -1.0f, 0.0f, 0.0f);
    protected final Rect inputRectB = new Rect(-1.0f, -1.0f, 0.0f, 0.0f);
    protected int state;
    protected AbstractCard.Anim animX;
    protected AbstractCard.Anim animY;
    protected boolean animatingPosition;
    protected final Rect deleteRect = new Rect(-1.0f, -1.0f, 42.0f, 42.0f);

    public ConfigCard(ConfigInfo configInfo, boolean selected) {
        this.info = configInfo;
        this.add(this.favouriteButton);
        this.add(this.switcherButton);
        this.add(this.saveButton);
        this.add(this.copyButton);
        this.add(this.deleteButton);
        this.add(this.settingsButton);
        this.add(this.iconButtonA);
        this.add(this.iconButtonB);
        this.add(this.iconButtonC);
        this.add(this.iconButtonD);
        this.add(this.addButtonA);
        this.add(this.addButtonB);
        this.favouriteButton.favourite = selected;
        this.favouriteButton.value = selected ? 1.0f : 0.0f;
        this.favouriteButton.valueAnim.snap(selected ? 1.0f : 0.0f);
        this.favouriteButton.setSize(14.0f, 14.0f);
        this.favouriteButton.onClick = this::onToggleFavourite;
        this.switcherButton.selected = configInfo != null && configInfo.valid;
        this.switcherButton.onChange = this::onToggleSwitcher;
        this.switcherButton.setSize(14.0f, 14.0f);
        this.saveButton.onAction = this::onSaveToThisConfig;
        this.copyButton.onAction = this::onCopyKey;
        this.deleteButton.onAction = this::onDeleteConfig;
        this.settingsButton.onAction = this::onOpenConfigSettings;
        this.iconButtonA.onClick = this::onIconActionA;
        this.iconButtonB.onClick = this::onIconActionB;
        this.iconButtonC.onClick = this::onIconActionC;
        this.iconButtonD.onClick = this::onIconActionD;
        this.iconButtonB.flagD9 = true;
        this.addButtonB.flagD9 = true;
        this.refreshState(true);
        this.state = 0;
        this.width = 930.0f;
        this.height = 62.0f;
    }

    private void onToggleFavourite() {
    }

    private void onToggleSwitcher() {
    }

    private void onSaveToThisConfig(String value) {
    }

    private void onCopyKey(String value) {
    }

    private void onDeleteConfig(String value) {
    }

    private void onOpenConfigSettings(String value) {
    }

    private void onIconActionA() {
    }

    private void onIconActionB() {
    }

    private void onIconActionC() {
    }

    private void onIconActionD() {
    }

    public Component addIconButton(float size, Consumer<String> onClick) {
        IconInputButton button = new IconInputButton(size);
        button.onAction = onClick;
        this.add(button);
        return button;
    }

    public void refreshState(boolean instant) {
        boolean canSave = this.info != null && !this.info.broken && !this.info.group;
        boolean canSettings = this.info != null && !this.info.broken;
        this.copyButton.enabled = canSave;
        this.settingsButton.enabled = canSettings;
        if (instant) {
            this.copyButton.enabledAnim.snap(canSave ? 1.0f : 0.0f);
            this.settingsButton.enabledAnim.snap(canSettings ? 1.0f : 0.0f);
            this.fadeAnimA.snap(canSave ? 1.0f : 0.0f);
            this.fadeAnimB.snap(canSettings ? 1.0f : 0.0f);
            return;
        }
        this.copyButton.enabledAnim.setTarget(canSave ? 1.0f : 0.0f);
        this.settingsButton.enabledAnim.setTarget(canSettings ? 1.0f : 0.0f);
        this.fadeAnimA.setTarget(canSave ? 1.0f : 0.0f);
        this.fadeAnimB.setTarget(canSettings ? 1.0f : 0.0f);
    }

    public void setState(int newState, float newWidth) {
        this.width = newWidth;
        this.state = newState;
        this.height = newState == 1 ? 174.0f : 62.0f;
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

    @Override
    public boolean mouseReleased(double mx, double my, int button) {
        if (this.state != 0) {
            return false;
        }
        if (!this.switcherButton.mouseReleased(mx, my, button)) {
            return false;
        }
        if (this.switcherButton.selected && this.info != null && !this.info.valid) {
            ConfigCard.playClickSound(8);
            if (this.onClose != null) {
                this.onClose.accept(this.info);
            }
        }
        return true;
    }

    @Override
    public boolean mouseDragged(double mx, double my, int button) {
        if (this.state != 0) {
            return false;
        }
        return this.switcherButton.mouseDragged(mx, my, button);
    }

    @Override
    public void render(Object renderer, float mouseX, float mouseY, float alpha) {
        float targetB;
        float targetA;
        this.applyPositionAnimation(this.now());
        float f = targetA = this.info != null && this.info.valid ? 1.0f : 0.0f;
        if (this.panelAnimA.target != targetA) {
            this.panelAnimA.from = this.panelAnimA.update(this.now());
            this.panelAnimA.target = targetA;
            this.panelAnimA.start = this.now();
            this.panelAnimA.running = true;
        }
        float f2 = targetB = this.info != null && this.info.group ? 1.0f : 0.0f;
        if (this.panelAnimB.target != targetB) {
            this.panelAnimB.from = this.panelAnimB.update(this.now());
            this.panelAnimB.target = targetB;
            this.panelAnimB.start = this.now();
            this.panelAnimB.running = true;
        }
        this.panelAnimA.update(this.now());
        this.panelAnimB.update(this.now());
        ConfigCard.drawPanel(renderer, this.x, this.y, this.width, this.height, 18.0f, alpha);
        if (mouseX >= this.x && mouseX <= this.x + this.width && mouseY >= this.y && mouseY <= this.y + this.height) {
            this.hoverTest(mouseX, mouseY);
        }
        if (this.state == 1) {
            this.renderExpanded(renderer, mouseX, mouseY, alpha);
        } else {
            this.renderCollapsed(renderer, mouseX, mouseY, alpha);
        }
    }

    public void renderCollapsed(Object renderer, float mouseX, float mouseY, float alpha) {
        int i;
        float rowY = (this.height - 42.0f) * 0.5f + this.y;
        boolean canSave = this.info != null && !this.info.broken && !this.info.group;
        boolean canSettings = this.info != null && !this.info.broken;
        this.copyButton.enabled = canSave;
        this.settingsButton.enabled = canSettings;
        ConfigCard.drawNameText(renderer, this.x + 12.0f, rowY, 29, -1, alpha);
        ConfigCard.drawPlateButton(renderer, this.x + 12.0f, rowY, this.x + this.width - 12.0f, 42.0f, alpha);
        this.setPanelRects(rowY);
        ConfigCard.drawSmallButton(renderer, this.x + 15.0f, rowY + 21.0f, 14.0f, 42.0f, alpha);
        float cursor = rowY;
        for (i = 0; i < this.collapsedButtons.length; ++i) {
            PlateIconButton current = this.collapsedButtons[i];
            float value = current.enabledAnim.update(this.now()) * 0.5f;
            current.setPosition(this.x + this.width - cursor - value, rowY);
            current.setSize(value, value);
            if (!(0.001f < value)) continue;
            cursor += value + 4.0f;
        }
        for (i = 0; i < this.collapsedButtons.length; ++i) {
            ConfigCard.drawIconButton(renderer, this.collapsedButtons[i], mouseX, mouseY, alpha);
        }
        ConfigCard.drawToggle(renderer, alpha);
    }

    public void renderExpanded(Object renderer, float mouseX, float mouseY, float alpha) {
        float rowY = (this.height - 42.0f) * 0.5f + this.y;
        float value = this.panelAnimA.update(this.now());
        ConfigCard.drawNameText(renderer, this.x + 12.0f, rowY, 34, -1, alpha);
        float statusY = this.y + this.height - 12.0f;
        if (this.info != null && this.info.broken) {
            ConfigCard.drawTextAt(renderer, 29, this.x + this.width - 12.0f - value, statusY, -1, alpha);
        } else {
            ConfigCard.drawTextAt(renderer, 29, this.x + this.width - 12.0f, statusY - 2.0f, -1, alpha);
        }
        float headerHeight = (this.height - 42.0f) * 0.5f;
        for (int i = 0; i < this.expandedButtons.length; ++i) {
            IconButton current = this.expandedButtons[i];
            if (current == this.iconButtonB && 0.5f <= this.fadeAnimA.current || current == this.iconButtonD && 0.5f <= this.fadeAnimB.current) continue;
            current.setPosition(this.x + this.width - 12.0f, this.y + 20.0f + (float)i * 0.0f);
            ConfigCard.drawIconButton(renderer, current, mouseX, mouseY, alpha);
        }
        this.panelAnimB.update(this.now());
        float panelY = this.y + 42.0f + headerHeight;
        ConfigCard.drawProgressBar(renderer, this.x + 12.0f, panelY, this.width - 12.0f - 12.0f, 12.0f);
        ConfigCard.drawTextAt(renderer, 29, this.x + 12.0f, panelY + 6.0f, -1, alpha);
        float inputX = this.x + this.width - 12.0f - 16.0f - 16.0f;
        ConfigCard.drawInputField(renderer, this.x, panelY, inputX, alpha);
        this.okRect.set(inputX + 12.0f, panelY + 1.0f, 16.0f, 16.0f);
        this.cancelRect.set(inputX + 36.0f, panelY + 5.0f, 12.0f, 12.0f);
        this.inputRectA.set(this.x + 15.0f, panelY + 12.0f, 16.0f, 16.0f);
        this.inputRectB.set(this.x + 15.0f, panelY + 12.0f, 12.0f, 12.0f);
        ConfigCard.drawGlow(renderer, this.x + 12.0f, panelY + 24.0f, this.width - 12.0f, 0.4f);
        float footerY = this.y + this.height - 24.0f;
        ConfigCard.drawRect(renderer, this.x + 15.0f, footerY, this.x + this.width - 30.0f, 24.0f);
        ConfigCard.drawTextAt(renderer, 29, this.x + 15.0f + 12.0f, footerY + 6.0f, -1, alpha);
        ConfigCard.drawFavourite(renderer, this.x + 15.0f, footerY + 6.0f, 24.0f, 12.0f, alpha);
        float slotY = this.y + this.height - 42.0f;
        this.addButtonA.setPosition(this.x + 15.0f, slotY);
        this.addButtonB.setPosition(this.x + this.width - 12.0f - 12.0f, slotY);
        ConfigCard.drawInputButton(renderer, this.addButtonA, alpha);
        ConfigCard.drawInputButton(renderer, this.addButtonB, alpha);
    }

    public void hoverTest(float mouseX, float mouseY) {
        boolean insideSwitcher;
        if (this.info != null && (this.info.broken || !this.info.valid) && this.info.broken) {
            return;
        }
        boolean bl = insideSwitcher = mouseX >= this.favouriteButton.getX() && mouseX <= this.favouriteButton.getX() + this.favouriteButton.getWidth() && mouseY >= this.favouriteButton.getY() && mouseY <= this.favouriteButton.getY() + this.favouriteButton.getHeight();
        if (insideSwitcher) {
            hoverState = 1;
            return;
        }
        if (this.state == 1) {
            if (mouseX >= this.okRect.x && mouseX <= this.okRect.x + this.okRect.w && mouseY >= this.okRect.y && mouseY <= this.okRect.y + this.okRect.h) {
                hoverState = 2;
                return;
            }
        } else if (mouseY >= this.toggleRect.y && mouseY <= this.toggleRect.y + this.toggleRect.h && mouseX >= this.x + this.width - 12.0f && mouseX <= this.x + this.width - 12.0f + 42.0f) {
            hoverState = 2;
            return;
        }
        hoverState = 2;
    }

    protected void setPanelRects(float rowY) {
        this.toggleRect.set(this.x + this.width - 12.0f, rowY, 42.0f, 42.0f);
        this.inputRectA.set(this.x + 12.0f, rowY, 0.0f, 0.0f);
        this.inputRectB.set(this.x + this.width - 12.0f - 12.0f, rowY, 12.0f, 42.0f);
    }

    public boolean onMouse(double mx, double my, int button) {
        if (this.state == 1) {
            if (button == 0 && ConfigCard.hit(this.favouriteButton, mx, my) && this.favouriteButton.mousePressed(mx, my, button)) {
                return true;
            }
            for (int i = 0; i < this.expandedButtons.length; ++i) {
                IconButton current = this.expandedButtons[i];
                if (current == this.iconButtonB && 0.5f <= this.fadeAnimA.current || current == this.iconButtonD && 0.5f <= this.fadeAnimB.current || button != 0 || !ConfigCard.hit(current, mx, my) || !current.mousePressed(mx, my, button)) continue;
                AbstractCard.blurFocusedChildren(this);
                return true;
            }
            if (button != 0) {
                return false;
            }
        } else {
            for (int i = 0; i < this.collapsedButtons.length; ++i) {
                PlateIconButton current = this.collapsedButtons[i];
                if (!current.enabled || 0.5f > current.enabledAnim.current || button != 0 || !ConfigCard.hit(current, mx, my) || !current.mousePressed(mx, my, button)) continue;
                AbstractCard.blurFocusedChildren(this);
                return true;
            }
            if (button != 0) {
                return false;
            }
            if (ConfigCard.hit(this.switcherButton, mx, my) && this.switcherButton.mousePressed(mx, my, button)) {
                AbstractCard.blurFocusedChildren(this);
                return true;
            }
        }
        if (0.0f <= this.deleteRectX() && mx >= (double)this.deleteRectX() && mx <= (double)(this.deleteRectX() + 42.0f) && my >= (double)this.deleteRectY() && my <= (double)(this.deleteRectY() + 42.0f) || this.state == 1 && mx >= (double)this.okInputRectX() && mx <= (double)(this.okInputRectX() + 16.0f) && my >= (double)this.okInputRectY() && my <= (double)(this.okInputRectY() + 16.0f)) {
            AbstractCard.blurFocusedChildren(this);
            if (this.info != null && !this.info.valid) {
                ConfigCard.playClickSound(8);
                if (this.onClose != null) {
                    this.onClose.accept(this.info);
                    return true;
                }
            }
            return true;
        }
        if (0.0f < this.cancelRect.w && ConfigCard.hit(this.cancelRect, mx, my)) {
            AbstractCard.blurFocusedChildren(this);
            ConfigCard.playClickSound(14);
            if (this.onCancel == null) {
                return true;
            }
            this.onCancel.accept(this.info);
            return true;
        }
        if (this.info != null && this.info.broken) {
            return false;
        }
        if (!ConfigCard.hit(this.toggleRect, mx, my)) {
            if (this.info != null && this.info.broken) {
                return false;
            }
            if (mx < (double)this.inputRectA.x || mx > (double)(this.inputRectA.x + this.inputRectA.w)) {
                return false;
            }
            if (my < (double)this.inputRectA.y || my > (double)(this.inputRectA.y + this.inputRectA.h)) {
                return false;
            }
            AbstractCard.focusChildWithText(this, this.addButtonA, this.info == null ? "" : this.info.name);
            return true;
        }
        AbstractCard.focusChildWithText(this, this.addButtonB, this.info == null ? "" : this.info.key);
        return true;
    }

    protected float deleteRectX() {
        return this.deleteRect.x;
    }

    protected float deleteRectY() {
        return this.deleteRect.y;
    }

    protected float okInputRectX() {
        return this.inputRectA.x;
    }

    protected float okInputRectY() {
        return this.inputRectA.y;
    }

    private static boolean hit(Component component, double mx, double my) {
        return component.contains(mx, my);
    }

    private static boolean hit(Rect rect, double mx, double my) {
        return mx >= (double)rect.x && mx <= (double)(rect.x + rect.w) && my >= (double)rect.y && my <= (double)(rect.y + rect.h);
    }

    public static void playClickSound(int sound) {
        ConfigCard.uiSound(sound);
    }

    public static void drawPanel(Object renderer, float x, float y, float width, float height, float radius, float alpha) {
    }

    public static void drawNameText(Object renderer, float x, float y, int id, int color, float alpha) {
    }

    public static void drawPlateButton(Object renderer, float x, float y, float right, float height, float alpha) {
    }

    public static void drawIconButton(Object renderer, Component button, float mouseX, float mouseY, float alpha) {
    }

    public static void drawSmallButton(Object renderer, float x, float y, float width, float height, float alpha) {
    }

    public static void drawToggle(Object renderer, float alpha) {
    }

    public static void drawTextAt(Object renderer, int id, float x, float y, int color, float alpha) {
    }

    public static void drawRect(Object renderer, float x, float y, float right, float height) {
    }

    public static void drawInputField(Object renderer, float x, float y, float right, float alpha) {
    }

    public static void drawInputButton(Object renderer, Component button, float alpha) {
    }

    public static void drawProgressBar(Object renderer, float x, float y, float width, float height) {
    }

    public static void drawGlow(Object renderer, float x, float y, float width, float value) {
    }

    public static void drawFavourite(Object renderer, float x, float y, float width, float height, float alpha) {
    }

    public static void drawNinePatch(Object renderer, float x, float y, float width, float height, int color, float alpha) {
    }

    public static void drawSwitcherButton(Object renderer, Component button, float mouseX, float mouseY, float alpha) {
    }

    public static class FavouriteButton extends Component {
        public static final int OFF_FAVOURITE = 96;
        public static final int OFF_CALLBACK = 104;
        public static final int OFF_FLAG_70 = 112;
        public static final int OFF_VALUE_ANIM = 168;
        public static final float DEFAULT_SIZE = 12.0f;
        public boolean favourite;
        public float value;
        public final AbstractCard.Anim valueAnim = new AbstractCard.Anim(0.0f, 0.15f, 0);
        public Runnable onClick;

        public FavouriteButton() {
            this.setSize(12.0f, 12.0f);
        }

        public boolean mousePressed(double mx, double my, int button) {
            return button == 0 && this.contains(mx, my);
        }
    }

    public static class SwitcherButton extends Component {
        public static final int OFF_VALUE = 96;
        public static final int OFF_FLAG_61 = 97;
        public static final int OFF_ANIM = 112;
        public static final int OFF_CALLBACK = 160;
        public static final int OFF_VALUE_FROM = 168;
        public static final int OFF_VALUE_CURRENT = 172;
        public static final int OFF_VALUE_TARGET = 176;
        public static final int OFF_PRESSED = 180;
        public static final int OFF_DRAGGED = 181;
        public static final int OFF_FLAG_B6 = 182;
        public static final int OFF_PRESS_TIME = 184;
        public static final float DEFAULT_WIDTH = 15.0f;
        public static final float DEFAULT_HEIGHT = 16.0f;
        public static final double DRAG_TIMEOUT = 1.5;
        public boolean selected;
        public boolean flag61;
        public boolean pressed;
        public boolean dragged;
        public boolean flagB6;
        public double pressTime;
        public float valueFrom;
        public float valueCurrent;
        public float valueTarget;
        public Runnable onChange;
        public final AbstractCard.Anim anim = new AbstractCard.Anim(0.0f, 0.15f, 0);

        public SwitcherButton(boolean value) {
            float initial;
            this.selected = value;
            this.valueFrom = initial = value ? 1.0f : 0.0f;
            this.valueCurrent = initial;
            this.valueTarget = initial;
            this.setSize(15.0f, 16.0f);
        }

        public boolean mousePressed(double mx, double my, int button) {
            return button == 0 && this.contains(mx, my);
        }

        @Override
        public boolean mouseDragged(double mx, double my, int button) {
            float t;
            if (!this.pressed || button != 0) {
                return false;
            }
            if (!this.dragged) {
                if ((double)this.now() / 1.0E9 - this.pressTime < 1.5) {
                    return true;
                }
                this.dragged = true;
            }
            if ((t = (float)((mx - (double)(this.x + 2.0f + 6.0f)) / (double)(this.width - 12.0f - 4.0f))) < 0.0f) {
                t = 0.0f;
            }
            if (t > 1.0f) {
                t = 1.0f;
            }
            this.valueFrom = t;
            return true;
        }

        @Override
        public boolean mouseReleased(double mx, double my, int button) {
            if (!this.pressed || button != 0) {
                return false;
            }
            boolean wasDragged = this.dragged;
            this.pressed = false;
            this.dragged = false;
            boolean next = wasDragged ? 0.5f <= this.valueFrom : !this.flagB6;
            if (this.selected != next) {
                this.selected = next;
                ConfigCard.playClickSound(next ? 9 : 8);
                if (this.onChange != null) {
                    this.onChange.run();
                }
            }
            this.valueFrom = next ? 1.0f : 0.0f;
            return true;
        }
    }

    public static class PlateIconButton extends Component {
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
            return button == 0 && this.contains(mx, my);
        }
    }

    public static class IconButton extends Component {
        public static final int OFF_ICON = 96;
        public static final int OFF_VARIANT = 100;
        public static final int OFF_FLAGS = 104;
        public static final int OFF_SIZE = 108;
        public static final int OFF_ANIM = 112;
        public static final int OFF_CALLBACK_A = 152;
        public static final int OFF_CALLBACK_B = 208;
        public static final int OFF_LABEL = 216;
        public static final int OFF_FLAG_D9 = 217;
        public static final int DEFAULT_VARIANT = 89;
        public int icon;
        public int variant = 89;
        public int flags;
        public float iconSize;
        public String label = "";
        public boolean flagD9;
        public final AbstractCard.Anim anim = new AbstractCard.Anim(0.0f, 0.15f, 0);
        public Runnable onClick;

        public IconButton(int icon, float iconSize) {
            this.icon = icon;
            this.iconSize = iconSize;
            this.setSize(iconSize, iconSize);
        }

        public boolean mousePressed(double mx, double my, int button) {
            return button == 0 && this.contains(mx, my);
        }
    }

    public static class IconInputButton extends Component implements AbstractCard.InputChild {
        public static final int OFF_ICON = 96;
        public static final int OFF_VARIANT = 100;
        public static final int OFF_SIZE = 108;
        public static final int OFF_ANIM = 112;
        public static final int OFF_CALLBACK = 152;
        public static final int OFF_CALLBACK_B = 208;
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

        public void set(float x, float y, float w, float h) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }
    }

    public static final class ConfigInfo {
        public static final int OFF_NAME = 0;
        public static final int OFF_KEY = 32;
        public static final int OFF_VALID = 96;
        public static final int OFF_GROUP = 97;
        public static final int OFF_BROKEN = 98;
        public String name = "";
        public String key = "";
        public boolean valid;
        public boolean group;
        public boolean broken;
    }
}