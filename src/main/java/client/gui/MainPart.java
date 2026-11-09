/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.Component;
import client.gui.ConfigsPart;
import client.gui.FriendsPart;
import client.gui.MainHeader;
import client.gui.ModulesGridPart;
import client.gui.WaypointsPart;

public class MainPart
extends Component {
    public static final int VTABLE_RVA = 12600640;
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
    public static final int HEADER_OFFSET = 288;
    public static final int ABOUT_ACTION_STORAGE_OFFSET = 384;
    public static final int ABOUT_ACTION_OFFSET = 440;
    public static final int FAVORITES_ACTION_STORAGE_OFFSET = 448;
    public static final int FAVORITES_ACTION_OFFSET = 504;
    public static final int CONFIGS_ACTION_STORAGE_OFFSET = 512;
    public static final int CONFIGS_ACTION_OFFSET = 568;
    public static final int WAYPOINTS_ACTION_STORAGE_OFFSET = 576;
    public static final int WAYPOINTS_ACTION_OFFSET = 632;
    public static final int GRID_OFFSET = 2440;
    public static final int CONFIGS_PART_OFFSET = 2656;
    public static final int FRIENDS_PART_OFFSET = 3096;
    public static final int WAYPOINTS_PART_OFFSET = 3552;
    public static final int FADE_ANIM_OFFSET = 3960;
    public static final int OVERLAY_OFFSET = 4000;
    public static final int OVERLAY_STORAGE_OFFSET = 4008;
    public static final int OVERLAY_ACTION_OFFSET = 4064;
    public static final int TAB_OFFSET = 4072;
    public static final int FRIENDS_TAB_OFFSET = 320;
    public static final int GRID_CATEGORY_OFFSET = 296;
    public static final int GRID_FAVORITES_OFFSET = 304;
    public static final int GRID_FAVORITES_SCROLL_OFFSET = 308;
    public static final int GRID_LAYOUT_CALLBACK_OFFSET = 144;
    public static final int ACTIVE_CONFIG_ID_OFFSET = 4076;
    public static final float DEFAULT_WIDTH = 964.0f;
    public static final float DEFAULT_HEIGHT = 700.0f;
    public static final float HEADER_BAND = 57.0f;
    public static final float FADE_DURATION = 0.18f;
    public static final float OVERLAY_DURATION = 0.32f;
    public static final float SLIDE_DISTANCE = 10.0f;
    public static final float EPSILON = 0.001f;
    public static final int FADE_EASING_IN = 0;
    public static final int FADE_EASING_OUT = 1;
    public static final int TAB_MODULES = 0;
    public static final int TAB_FAVORITES = 1;
    public static final int TAB_CONFIGS = 2;
    public static final int TAB_FRIENDS = 3;
    public static final int TAB_WAYPOINTS = 4;
    public static final int FRIENDS_TAB_ALL = 0;
    public static final int FRIENDS_TAB_FRIENDS = 1;
    public static final int FRIENDS_TAB_REQUESTS = 2;
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
    protected final MainHeader header = new MainHeader();
    protected final byte[] aboutActionStorage = new byte[56];
    protected Object aboutAction;
    protected final byte[] favoritesActionStorage = new byte[56];
    protected Object favoritesAction;
    protected final byte[] configsActionStorage = new byte[56];
    protected Object configsAction;
    protected final byte[] waypointsActionStorage = new byte[56];
    protected Object waypointsAction;
    protected final ModulesGridPart grid = new ModulesGridPart();
    protected final ConfigsPart configsPart = new ConfigsPart();
    protected final FriendsPart friendsPart = new FriendsPart();
    protected final WaypointsPart waypointsPart = new WaypointsPart();
    protected final Anim fadeAnim = new Anim();
    protected byte overlay;
    protected final byte[] overlayStorage = new byte[56];
    protected Object overlayAction;
    protected int tab;
    protected int friendsTab;
    protected float favoriteScroll;
    private static final float RECT_ANIM_DURATION = 0.15f;

    public MainPart() {
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
        this.aboutAction = null;
        this.favoritesAction = null;
        this.configsAction = null;
        this.waypointsAction = null;
        MainPart.setPartActionResult(this.grid, MainPart.createLayoutAction(this));
        MainPart.setPartActionResult(this.configsPart, MainPart.createLayoutAction(this));
        MainPart.setPartActionResult(this.friendsPart, MainPart.createLayoutAction(this));
        MainPart.setPartActionResult(this.waypointsPart, MainPart.createLayoutAction(this));
        MainPart.setAction(this.header, MainPart.createAboutAction(this));
        MainPart.setAction(this.grid, MainPart.createConfigsAction(this));
        MainPart.setAction(this.configsPart, MainPart.createFavoritesAction(this));
        MainPart.setAction(this.friendsPart, MainPart.createWaypointsAction(this));
        this.width = 964.0f;
        this.height = 700.0f;
        this.fadeAnim.from = 1.0f;
        this.fadeAnim.current = 1.0f;
        this.fadeAnim.target = 1.0f;
        this.fadeAnim.duration = 0.18f;
        this.fadeAnim.easing = 0;
        this.fadeAnim.start = Anim.now();
        this.fadeAnim.running = false;
        this.overlay = 0;
        this.overlayAction = null;
        this.fadeAnim.easing = 1;
    }

    @Override
    public void dispose() {
        MainPart.releaseChild(this.overlayAction, this.overlayAction != this.overlayStorage);
        this.overlayAction = null;
        MainPart.clearPart(this.waypointsPart);
        MainPart.freeString();
        MainPart.clearPart(this.friendsPart);
        MainPart.clearPart(this.configsPart);
        MainPart.clearGridExtras();
        MainPart.clearGrid();
        MainPart.baseDispose();
        this.header.dispose();
        MainPart.releaseChild(this.callback3, this.callback3 != this.callbackStorage3);
        this.callback3 = null;
        MainPart.releaseChild(this.callback2, this.callback2 != this.callbackStorage2);
        this.callback2 = null;
        MainPart.releaseChild(this.callback1, this.callback1 != this.callbackStorage1);
        this.callback1 = null;
        super.dispose();
    }

    @Override
    public void render(Object mat, float mouseX, float mouseY, float alpha) {
        float fade = this.fadeAnim.advance(Anim.now());
        if (this.overlay != 0 && fade <= 0.001f) {
            if (this.overlayAction != null) {
                MainPart.invokeCallback(this.overlayAction);
            }
            if (this.overlayAction != null) {
                MainPart.releaseChild(this.overlayAction, this.overlayAction != this.overlayStorage);
                this.overlayAction = null;
            }
            this.overlay = 0;
            this.fadeAnim.easing = 1;
            this.fadeAnim.duration = 0.32f;
            this.fadeAnim.retarget(1.0f);
            fade = this.fadeAnim.advance(Anim.now());
        }
        float gridTarget = 1.0f;
        if (this.tab != 0 && this.tab != 1) {
            gridTarget = 0.0f;
        }
        this.header.collapseAnim.retarget(gridTarget);
        this.header.x = this.x;
        this.header.y = this.y;
        this.header.render(mat, mouseX, mouseY, alpha);
        Object active = this.activePart();
        float bandTop = this.y + 57.0f;
        float bandHeight = this.height - 57.0f;
        MainPart.invokePartSetPosition(active, this.x, bandTop);
        MainPart.invokePartSetSize(active, this.width, bandHeight);
        float slide = (1.0f - fade) * 10.0f;
        if (0.001f < slide) {
            Object offset = MainPart.offsetMatrix(mat, 0.0f, slide);
            float clipY = this.header.y + this.header.height;
            MainPart.pushScissor(this.x, clipY, this.width, bandHeight + bandTop - clipY);
            MainPart.invokePartRender(active, offset, mouseX, mouseY, fade * alpha);
            MainPart.popScissor();
        } else {
            MainPart.invokePartRender(active, mat, mouseX, mouseY, fade * alpha);
        }
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (this.header.mouseClicked(mx, my, button)) {
            return true;
        }
        if ((my < (double)this.y || (double)(this.y + 57.0f) <= my) && this.overlay == 0) {
            return MainPart.invokePartMouseClicked(this.activePart(), mx, my, button);
        }
        return true;
    }

    @Override
    public boolean mouseReleased(double mx, double my, int button) {
        if (this.y <= (float)my && my < (double)(this.y + 57.0f)) {
            return false;
        }
        return MainPart.invokePartMouseReleased(this.activePart(), mx, my, button);
    }

    @Override
    public boolean mouseDragged(double mx, double my, int button) {
        return MainPart.invokePartMouseDragged(this.activePart(), mx, my, button);
    }

    @Override
    public boolean mouseScrolled(double mx, double my, double amount) {
        if (this.y <= (float)my && my < (double)(this.y + 57.0f)) {
            return true;
        }
        if (this.overlay != 0) {
            return true;
        }
        return MainPart.invokePartMouseScrolled(this.activePart(), mx, my, amount);
    }

    @Override
    public boolean keyPressed(int key, int modifiers) {
        return MainPart.invokePartKeyPressed(this.activePart(), key);
    }

    @Override
    public boolean keyReleased(int key) {
        return MainPart.invokePartKeyReleased(this.activePart(), key);
    }

    @Override
    public boolean charTyped(char codePoint) {
        return MainPart.invokePartCharTyped(this.activePart(), codePoint);
    }

    public Object activePart() {
        if (this.tab == 2) {
            return this.configsPart;
        }
        if (this.tab == 3) {
            return this.friendsPart;
        }
        if (this.tab == 4) {
            return this.waypointsPart;
        }
        return this.grid;
    }

    public void requestFavorites(boolean value) {
        this.grid.favorites = value;
        if (value) {
            this.grid.favoritesScroll = this.favoriteScroll;
        }
        MainPart.invokeCallback(this.favoritesAction);
    }

    public void requestCategory(Object category, float scroll) {
        MainPart.applyCategory(this.configsPart, category);
        this.grid.category = category;
        this.grid.favorites = false;
        this.favoriteScroll = scroll;
        MainPart.invokeCallback(this.configsAction);
    }

    public void requestConfigs() {
        MainPart.invokeCallback(this.configsAction);
    }

    public void requestFriends(int tab) {
        this.friendsTab = tab;
        MainPart.invokeCallback(this.waypointsAction);
    }

    public void requestWaypoints() {
        MainPart.invokeCallback(this.waypointsAction);
    }

    public int tab() {
        return this.tab;
    }

    public void setTab(int value) {
        this.tab = value;
    }

    public MainHeader header() {
        return this.header;
    }

    public ModulesGridPart grid() {
        return this.grid;
    }

    private static void setPartActionResult(Object part, Object action) {
    }

    private static void invokePartRender(Object part, Object mat, float mouseX, float mouseY, float alpha) {
    }

    private static void invokePartSetPosition(Object part, float x, float y) {
    }

    private static void invokePartSetSize(Object part, float width, float height) {
    }

    private static boolean invokePartMouseClicked(Object part, double mx, double my, int button) {
        return false;
    }

    private static boolean invokePartMouseReleased(Object part, double mx, double my, int button) {
        return false;
    }

    private static boolean invokePartMouseDragged(Object part, double mx, double my, int button) {
        return false;
    }

    private static boolean invokePartMouseScrolled(Object part, double mx, double my, double amount) {
        return false;
    }

    private static boolean invokePartKeyPressed(Object part, int key) {
        return false;
    }

    private static boolean invokePartKeyReleased(Object part, int key) {
        return false;
    }

    private static boolean invokePartCharTyped(Object part, char codePoint) {
        return false;
    }

    private static void setAction(Object target, Object action) {
    }

    private static Object createLayoutAction(MainPart part) {
        return null;
    }

    private static Object createAboutAction(MainPart part) {
        return null;
    }

    private static Object createFavoritesAction(MainPart part) {
        return null;
    }

    private static Object createConfigsAction(MainPart part) {
        return null;
    }

    private static Object createWaypointsAction(MainPart part) {
        return null;
    }

    private static void applyCategory(Object part, Object category) {
    }

    private static void invokeCallback(Object action) {
    }

    private static void releaseChild(Object sub, boolean heap) {
    }

    private static void clearPart(Object part) {
    }

    private static void clearGridExtras() {
    }

    private static void clearGrid() {
    }

    private static void baseDispose() {
    }

    private static void freeString() {
    }

    private static Object offsetMatrix(Object mat, float dx, float dy) {
        return null;
    }

    private static void pushScissor(float x, float y, float width, float height) {
    }

    private static void popScissor() {
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
        public static final int EASING_IN_CUBIC = 3;
        public static final int EASING_OUT_QUINT = 4;
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
            if (this.easing == 3) {
                return Anim.easeInCubic(t);
            }
            if (this.easing == 4) {
                return Anim.easeOutQuint(t);
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

        static float easeInCubic(float t) {
            return t * t * t;
        }

        static float easeOutQuint(float t) {
            float inv = 1.0f - t;
            return 1.0f - inv * inv * inv * inv * inv;
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

