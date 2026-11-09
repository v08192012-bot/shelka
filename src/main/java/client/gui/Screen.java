/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    public static final long RVA_BUILD = 2735200783552L;
    public static final long RVA_ON_CATEGORY_SELECTED = 2735200798288L;
    public static final long RVA_ON_FAVORITES_SELECTED = 2735200798432L;
    public static final long RVA_APPLY_SETTINGS = 2735200801664L;
    public static final long RVA_ENTRY_COPY = 2735200816352L;
    public static final long RVA_SIDEBAR_ACTION_A = 2735201391536L;
    public static final long RVA_SIDEBAR_ACTION_B = 2735201391568L;
    public static final int CLIENT_OFFSET = 8;
    public static final int BUILT_OFFSET = 40;
    public static final int SIDEBAR_CALLBACK_OFFSET = 56;
    public static final int AUX_OFFSET = 80;
    public static final int CATEGORY_A_OFFSET = 296;
    public static final int SIDEBAR_COLLAPSED_OFFSET = 304;
    public static final int CATEGORY_B_OFFSET = 308;
    public static final int TAB_OFFSET = 316;
    public static final int TAB_STATE_OFFSET = 320;
    public static final int PART_OFFSET = 336;
    public static final int COLLAPSE_ANIM_OFFSET = 368;
    public static final int COLLAPSE_B_OFFSET = 372;
    public static final int COLLAPSE_C_OFFSET = 376;
    public static final int OVERLAY_OFFSET = 400;
    public static final int MENU_FAVORITES = 13;
    public static final int MENU_CONFIGS = 29;
    public static final int MENU_FRIENDS = 34;
    public static final int MENU_PARTY = 75;
    public static final int MENU_INVITATIONS = 76;
    public static final int MENU_WAYPOINTS = 35;
    public static final int MENU_THEME = 18;
    public static final int MENU_LIGHT = 17;
    public static final int MENU_LANGUAGE = 19;
    public static final int TAB_FRIENDS = 2;
    public static final int TAB_PARTY = 3;
    public static final int TAB_INVITATIONS = 4;
    public static final int ENTRY_SIZE = 168;
    public static final float SIDEBAR_WIDTH = 224.0f;
    public static final float SIDEBAR_WIDTH_SHIFT = 176.0f;
    public static final float SIDEBAR_SLIDE = 305.0f;
    public static final float CLICK_SOUND = 11.0f;
    public static final long NANOS_PER_SECOND = 1000000000L;
    public static boolean textInputActive;
    public static int hoveredWidget;
    public static float mouseX;
    public static float mouseY;
    public static Object focusedInput;
    public static boolean allowHover;
    public static Object focusedWidget;
    public static Screen active;
    private Object client;
    private boolean built;
    private Object sidebarCallback;
    private Object part;
    private final List<Entry> entries = new ArrayList<Entry>();
    private float categoryA;
    private boolean sidebarCollapsed;
    private float categoryB;
    private int tab;
    private int tabState;
    private float collapseAnim;
    private float collapsedB;
    private float collapsedC;
    private boolean overlayOpen;
    private static Object fontFavorites;
    private static Object fontConfigs;
    private static Object fontFriends;
    private static Object fontParty;
    private static Object fontInvitations;
    private static Object fontWaypoints;
    private static Object fontTheme;
    private static Object fontLight;
    private static Object fontLanguage;
    private static int themeMode;
    private static boolean languageEnglish;

    public Screen() {
    }

    public Screen(Object client) {
        this.client = client;
    }

    public void build(Object config) {
        float visible;
        if (config == null) {
            return;
        }
        if (!this.built) {
            this.installFonts();
        }
        boolean light = "LIGHT".equals(Screen.configValue(config, "theme"));
        boolean dark = "DARK".equals(Screen.configValue(config, "theme"));
        if (light || dark) {
            int mode;
            int n = mode = light ? 1 : 0;
            if (mode != themeMode) {
                this.applyPalette(mode);
                themeMode = mode;
                this.resetTextColors();
            }
        }
        languageEnglish = "en".equals(Screen.configValue(config, "lang"));
        this.sidebarCollapsed = Screen.boolValue(config, "sidebar_collapsed");
        this.categoryA = visible = this.sidebarCollapsed ? 0.0f : 1.0f;
        this.collapsedB = visible;
        this.collapsedC = visible;
        this.overlayOpen = false;
        this.applySidebarLayout(Screen.clamp(visible, 0.0f, 1.0f));
        this.applyOffset(Screen.configValue(config, "offset_x"));
        this.applyBinds(Screen.configValue(config, "binds"));
        this.entries.clear();
        this.entries.add(new Entry(13, fontFavorites, "favorites"));
        this.entries.add(new Entry(29, fontConfigs, "configs"));
        this.entries.add(new Entry(34, fontFriends, "friends"));
        this.entries.add(new Entry(75, fontParty, "party"));
        this.entries.add(new Entry(76, fontInvitations, "invitations"));
        this.entries.add(new Entry(35, fontWaypoints, "waypoints"));
        this.entries.add(new Entry(18, fontTheme, "theme"));
        this.entries.add(new Entry(17, fontLight, "light"));
        this.entries.add(new Entry(19, fontLanguage, "language"));
    }

    public void onCategorySelected(Object category) {
        if (category == null) {
            return;
        }
        this.applyCategory(category);
        this.playClick();
    }

    public void onFavoritesSelected() {
        Object state = this.clientState();
        int mode = Screen.stateMode(state);
        if (mode == 1) {
            int current = this.tab;
            if (current == 2) {
                this.selectFriends();
                this.playClick();
            } else if (current == 3) {
                this.selectParty();
                this.playClick();
            } else if (current == 4) {
                this.selectInvitations();
                this.playClick();
            } else {
                long value = (long)(this.sidebarCollapsed ? this.collapsedB : this.categoryA);
                this.selectOther(value);
                this.playClick();
            }
        } else {
            boolean value = Screen.stateMode(state) == 0;
            this.tab = Screen.stateMode(state);
            this.tabState = Screen.stateExtra(state);
            this.selectTab(value);
            this.playClick();
        }
    }

    public void render() {
    }

    public boolean mouseClicked(double mx, double my, int button) {
        return false;
    }

    public List<Entry> entries() {
        return this.entries;
    }

    public Object part() {
        return this.part;
    }

    public int tab() {
        return this.tab;
    }

    public boolean isSidebarCollapsed() {
        return this.sidebarCollapsed;
    }

    public static long tick() {
        return System.nanoTime();
    }

    public static float easeOutCubic(float t) {
        float inv = 1.0f - t;
        return 1.0f - inv * inv * inv;
    }

    public static float easeOutExpo(float t) {
        if (t >= 1.0f) {
            return 1.0f;
        }
        return 1.0f - (float)Math.pow(2.0, -10.0 * (double)t);
    }

    private void applySidebarLayout(float visible) {
    }

    private void applyPalette(int mode) {
    }

    private void applyOffset(Object value) {
    }

    private void applyBinds(Object value) {
    }

    private void applyCategory(Object category) {
    }

    private void selectFriends() {
    }

    private void selectParty() {
    }

    private void selectInvitations() {
    }

    private void selectOther(long value) {
    }

    private void selectTab(boolean value) {
    }

    private void playClick() {
    }

    private void installFonts() {
    }

    private void resetTextColors() {
    }

    private Object clientState() {
        return null;
    }

    private static int stateMode(Object state) {
        return 0;
    }

    private static int stateExtra(Object state) {
        return 0;
    }

    private static String configValue(Object config, String key) {
        return null;
    }

    private static boolean boolValue(Object config, String key) {
        return false;
    }

    private static float clamp(float value, float min, float max) {
        if (value < min) {
            return min;
        }
        return value > max ? max : value;
    }

    public static final class Entry {
        public final int id;
        public final Object label;
        public final String key;

        public Entry(int id, Object label, String key) {
            this.id = id;
            this.label = label;
            this.key = key;
        }
    }

    public static final class Anim {
        private float from;
        private float current;
        private float target;
        private final float duration;
        private final boolean expo;
        private long lastTick;
        private boolean animating;

        public Anim(float initial, float duration, boolean expo) {
            this.from = initial;
            this.current = initial;
            this.target = initial;
            this.duration = duration;
            this.expo = expo;
        }

        public float value() {
            return this.current;
        }

        public float target() {
            return this.target;
        }

        public void setTarget(float value) {
            if (this.target == value) {
                return;
            }
            long now = Screen.tick();
            this.current = this.advance(now);
            this.lastTick = now;
            this.target = value;
            this.animating = true;
        }

        public float advance(long now) {
            if (!this.animating || this.duration <= 0.0f) {
                this.from = this.target;
                this.animating = false;
                return this.current;
            }
            float k = (float)((double)(now - this.lastTick) / 1.0E9 / (double)this.duration);
            if (k <= 0.0f) {
                this.current = this.from;
                return this.current;
            }
            if (k >= 1.0f) {
                this.animating = false;
                this.from = this.target;
                return this.current;
            }
            float e = this.expo ? Screen.easeOutExpo(k) : Screen.easeOutCubic(k);
            this.current = e * (this.target - this.from) + this.from;
            return this.current;
        }

        public boolean settled() {
            return !this.animating;
        }
    }
}

