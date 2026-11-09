/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import java.util.ArrayList;
import java.util.List;

public final class ContainerHelper
extends Feature {
    public static final String MODULE = "container_helper";
    public static final String DISPLAY = "\u0421\u043e\u043d\u0442\u0430\u0438\u043d\u0435\u0440\u0425\u0435\u043b\u043f\u0435\u0440";
    public static final int VTABLE_RVA = 12312048;
    public static final long RVA_RESET = 2735200262288L;
    public static final long RVA_BUILD_BUTTONS = 2735200262416L;
    public static final long RVA_TICK = 2735200263568L;
    public static final long RVA_RENDER = 2735200264384L;
    public static final long RVA_VISIBLE = 2735200259936L;
    public static final long RVA_RECORD_INIT = 2735200260240L;
    public static final long RVA_SLOT_LIST = 2735200265760L;
    public static final long RVA_MOVE_MATCHING = 2735200266480L;
    public static final long RVA_SORT = 2735200266592L;
    public static final long RVA_STASH = 2735200267344L;
    public static final String BUTTON_DROP = "drop";
    public static final String BUTTON_TAKE = "take";
    public static final String BUTTON_SORT = "sort";
    public static final String BUTTON_STASH = "stash";
    private static final int NO_ACTION = -1;
    private static final int ACTION_DROP = 0;
    private static final int ACTION_TAKE_MATCHING = 1;
    private static final int ACTION_TAKE_OTHER = 2;
    private static final int ACTION_OPEN_CONTAINER = 3;
    private static final int BUTTON_COUNT = 4;
    private static final int WAIT_ITERATIONS = 2;
    public static final float BUTTON_HEIGHT = 16.0f;
    public static final float PRESS_ALPHA = 0.5f;
    private final List<Button> buttons = new ArrayList<Button>();
    private final Animation[] animations = new Animation[4];
    private int action = -1;
    private boolean clicked;
    private boolean waiting;
    private boolean containerOwned;
    private boolean screenFlag;
    private int syncId = -1;

    public ContainerHelper() {
        super(MODULE, DISPLAY, Category.Player);
        this.add(Setting.bool(BUTTON_DROP, true));
        this.add(Setting.bool(BUTTON_TAKE, true));
        this.add(Setting.bool(BUTTON_SORT, true));
        this.add(Setting.bool(BUTTON_STASH, true));
        for (int i = 0; i < 4; ++i) {
            this.animations[i] = new Animation();
        }
    }

    @Override
    public void onEnable() {
        this.reset();
    }

    @Override
    public void onDisable() {
        this.reset();
    }

    @Override
    public boolean isVisible() {
        return !this.buttons.isEmpty();
    }

    public boolean hasButtons() {
        return !this.buttons.isEmpty();
    }

    public List<Button> buttons() {
        return this.buttons;
    }

    public Animation[] animations() {
        return this.animations;
    }

    public int action() {
        return this.action;
    }

    public void setAction(int value) {
        this.action = value;
    }

    public boolean buttonEnabled(int index) {
        Setting setting = this.getSettings().get(index);
        return setting != null && setting.getBoolean();
    }

    @Override
    public void onTick() {
        int[] list;
        this.buildButtons();
        if (this.buttons.isEmpty()) {
            this.action = -1;
            this.clicked = Client.rawKeyState() < 0;
            this.clearAnimations();
        } else {
            int queued = this.action;
            if (queued >= 0) {
                this.action = -1;
                if (queued == 0) {
                    for (int slot : list = Client.containerSlotIndices()) {
                        if (!Client.slotPresent(slot)) continue;
                        Client.clickSlot(slot, 1);
                    }
                } else if (queued == 1) {
                    Client.moveMatchingSlots(true);
                } else if (queued == 2) {
                    Client.moveMatchingSlots(false);
                } else if (queued == 3) {
                    this.waiting = true;
                    this.syncId = Client.containerSyncId();
                    this.containerOwned = this.screenFlag;
                }
            }
        }
        if (this.waiting) {
            if (!Client.inGame() || this.buttons.isEmpty() || Client.containerSyncId() != this.syncId) {
                this.waiting = false;
                return;
            }
            int iterations = 0;
            do {
                if ((list = Client.containerSlotIndices()).length == 0) {
                    this.waiting = false;
                    return;
                }
                if (Client.containerSlotItemMatches(list[0])) {
                    this.waiting = false;
                    return;
                }
                if (Client.sortContainer() || Client.stashContainer()) continue;
                this.waiting = false;
                return;
            } while (++iterations < 2);
            return;
        }
    }

    @Override
    public void onRender() {
        if (!Client.containerScreenOpen()) {
            this.reset();
            return;
        }
        double scale = Client.guiScale();
        if (scale <= 0.0) {
            return;
        }
        boolean attackPressed = Client.rawKeyState() < 0;
        boolean freshClick = attackPressed && !this.clicked && !Client.isPaused();
        this.clicked = attackPressed;
        for (Button button : this.buttons) {
            float alpha;
            boolean hovered = Client.hoveredRect(button.x, button.y, button.width, 16.0);
            float f = alpha = hovered ? 0.5f : 0.0f;
            if (hovered && freshClick && this.action < 0) {
                this.action = button.index;
            }
            Animation animation = this.animations[button.index];
            if (animation.alpha != alpha) {
                long now = Client.nanos();
                animation.seed = Client.animationSeed(now);
                animation.alpha = alpha;
                animation.targetNanos = now;
                animation.active = true;
            }
            Client.drawContainerButton(button, animation, Client.nanos());
        }
    }

    private void reset() {
        this.buttons.clear();
        this.clearAnimations();
        this.action = -1;
        this.clicked = false;
        this.containerOwned = false;
        this.screenFlag = false;
        this.syncId = -1;
        this.waiting = false;
    }

    private void clearAnimations() {
        for (Animation animation : this.animations) {
            animation.seed = 0;
            animation.alpha = 0.0f;
            animation.targetNanos = 0L;
            animation.active = false;
        }
    }

    private void buildButtons() {
        double[][] layout = Client.containerButtonLayout();
        this.buttons.clear();
        if (!Client.inGame()) {
            return;
        }
        boolean auction = Client.isAuctionScreen(Client.openScreenTitle());
        if (!auction && !Client.inventoryScreenOpen()) {
            return;
        }
        this.containerOwned = auction;
        this.screenFlag = auction;
        int[] search = new int[2];
        if (!Client.containerSearch(search)) {
            return;
        }
        for (int i = 0; i < layout.length; ++i) {
            if (!this.buttonEnabled(i)) continue;
            Button button = new Button();
            button.x = layout[i][0];
            button.y = layout[i][1];
            button.width = layout[i][2];
            button.index = i;
            this.buttons.add(button);
        }
    }

    public static final class Animation {
        public int seed;
        public float alpha;
        public long targetNanos;
        public boolean active;
    }

    public static final class Button {
        public double x;
        public double y;
        public double width;
        public int index;
    }
}

