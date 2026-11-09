/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.AbstractCollectionPart;
import client.gui.BoardToolbar;
import client.gui.Component;
import client.gui.WaypointCard;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class WaypointsPart
extends AbstractCollectionPart {
    public static final int VTABLE_RVA = 12615552;
    public static final long RVA_CTOR = 2735201432592L;
    public static final long RVA_DELETING_DTOR = 2735201434432L;
    public static final long RVA_HEADER_HEIGHT = 2735201434496L;
    public static final long RVA_RENDER = 2735201434512L;
    public static final long RVA_REFRESH = 2735201434624L;
    public static final long RVA_BUILD_CARD = 2735201435808L;
    public static final long RVA_ADD_WAYPOINT_AT_PLAYER = 2735201436448L;
    public static final long RVA_COMMIT_INPUT = 2735201437120L;
    public static final long RVA_APPLY_TAB = 2735201437936L;
    public static final long RVA_TAB_COUNT = 2735201438032L;
    public static final long RVA_CARD_COLOR = 2735201438144L;
    public static final long RVA_CARD_RENAME = 2735201438336L;
    public static final long RVA_CARD_LOCATE = 2735201438512L;
    public static final long RVA_CARD_FLAG = 2735201438720L;
    public static final long RVA_CARD_COORDS = 2735201438864L;
    public static final long RVA_CARD_PRIMARY = 2735201439232L;
    public static final long RVA_TAB_CHANGED = 2735201439648L;
    public static final long RVA_FETCH_WAYPOINTS = 2735201440768L;
    public static final long RVA_PLAYER_POSITION = 2735201432400L;
    public static final long RVA_KEY_FILTER = 2735201418640L;
    public static final long RVA_MOUSE_CLICKED = 2735200845504L;
    public static final long RVA_MOUSE_RELEASED = 2735200846480L;
    public static final long RVA_MOUSE_MOVED = 2735200846640L;
    public static final long RVA_MOUSE_SCROLLED = 2735200847056L;
    public static final long RVA_KEY_PRESSED = 2735200847360L;
    public static final long RVA_KEY_RELEASED = 2735200847552L;
    public static final long RVA_SET_POSITION = 2735200779184L;
    public static final long RVA_ROW_PUSH = 2735200954208L;
    public static final long RVA_ROW_PUSH_COPY = 2735200954560L;
    public static final long RVA_ROW_ASSIGN = 2735200951984L;
    public static final long RVA_INFO_ASSIGN = 2735201421920L;
    public static final long RVA_CARD_COLLAPSE = 2735200893920L;
    public static final long RVA_CARD_CTOR = 2735201419232L;
    public static final long RVA_INFO_COPY = 2735201014384L;
    public static final long RVA_LAYOUT_DEFER = 2735200841200L;
    public static final long RVA_ANIM_ADVANCE = 2735200831600L;
    public static final long RVA_TAB_SET = 2735200878672L;
    public static final long RVA_PLATE_COLOR = 2735201078832L;
    public static final long RVA_COORD_PARSE = 2735201418672L;
    public static final long RVA_COORD_FORMAT = 2735199761632L;
    public static final long RVA_CLIPBOARD = 2735199737360L;
    public static final long RVA_STRING_ASSIGN = 2735199713520L;
    public static final long RVA_NOW = 2735199714128L;
    public static final int OFF_TAB = 392;
    public static final int OFF_LAST_REFRESH = 400;
    public static final int OFF_BOARD_TOOLBAR = 208;
    public static final int OFF_ADD_TILE = 216;
    public static final int OFF_ROWS_BEGIN = 224;
    public static final int OFF_ROWS_END = 232;
    public static final int OFF_TOOLBAR_TAB_CHANGED = 96;
    public static final int OFF_TOOLBAR_TITLE_CHANGED = 160;
    public static final int OFF_TOOLBAR_CLOSE = 224;
    public static final int OFF_TOOLBAR_PLATE = 576;
    public static final int OFF_TOOLBAR_PLATE_KEY_FILTER = 1256;
    public static final int OFF_ADDTILE_SUBMIT_TEXT = 96;
    public static final int OFF_ADDTILE_SUBMIT_EMPTY = 160;
    public static final int OFF_ADDTILE_PLATE = 304;
    public static final int OFF_ADDTILE_PLATE_KEY_FILTER = 984;
    public static final int OFF_INFO_NAME = 0;
    public static final int OFF_INFO_KEY = 32;
    public static final int OFF_INFO_X = 64;
    public static final int OFF_INFO_Y = 68;
    public static final int OFF_INFO_Z = 72;
    public static final int OFF_INFO_WORLD = 80;
    public static final int OFF_INFO_SELECTED = 112;
    public static final int OFF_INFO_EXTRA = 120;
    public static final int OFF_INFO_BROKEN = 152;
    public static final int OFF_INFO_FLAG_99 = 153;
    public static final int OFF_INFO_DEADLINE = 160;
    public static final int OFF_INFO_NAME_SIZE = 16;
    public static final int OFF_INFO_NAME_CAP = 24;
    public static final int INFO_SIZE = 168;
    public static final int INFO_SSO_CAPACITY = 15;
    public static final int OFF_CARD_CLAIMED = 168;
    public static final int OFF_CARD_ACTION_1 = 176;
    public static final int OFF_CARD_ACTION_2 = 240;
    public static final int OFF_CARD_ACTION_3 = 304;
    public static final int OFF_CARD_ACTION_4 = 368;
    public static final int OFF_CARD_ACTION_5 = 432;
    public static final int OFF_CARD_ACTION_6 = 496;
    public static final int OFF_CARD_INFO = 560;
    public static final int OFF_CARD_NAME_SIZE = 576;
    public static final int OFF_CARD_NAME_CAP = 584;
    public static final int OFF_CARD_SELECTED = 672;
    public static final int OFF_CARD_COLLAPSED = 712;
    public static final int OFF_CARD_SELECTED_FLAG = 824;
    public static final int OFF_CARD_ALPHA_TARGET = 896;
    public static final int OFF_CARD_COLLAPSE_OWNER = 920;
    public static final int OFF_CARD_ALPHA_ANIM = 96;
    public static final int OFF_CARD_ALPHA_FROM = 96;
    public static final int OFF_CARD_ALPHA_CURRENT = 100;
    public static final int OFF_CARD_ALPHA_ANIM_TARGET = 104;
    public static final int OFF_CARD_ALPHA_DURATION = 108;
    public static final int OFF_CARD_ALPHA_EASE = 112;
    public static final int OFF_CARD_ALPHA_TICK = 120;
    public static final int OFF_CARD_ALPHA_RUNNING = 128;
    public static final int OFF_CARD_COLLAPSE_FLAG = 104;
    public static final int OFF_CARD_COLLAPSE_ANIM = 112;
    public static final int OFF_CARD_COLLAPSE_TARGET = 120;
    public static final int OFF_CARD_COLLAPSE_TICK = 136;
    public static final int OFF_CARD_COLLAPSE_RUNNING = 144;
    public static final int VTABLE_SLOT_DTOR = 0;
    public static final int VTABLE_SLOT_RENDER = 8;
    public static final int VTABLE_SLOT_MOUSE_CLICKED = 32;
    public static final int VTABLE_SLOT_MOUSE_RELEASED = 40;
    public static final int VTABLE_SLOT_MOUSE_MOVED = 48;
    public static final int VTABLE_SLOT_MOUSE_SCROLLED = 56;
    public static final int VTABLE_SLOT_KEY_PRESSED = 64;
    public static final int VTABLE_SLOT_KEY_RELEASED = 80;
    public static final int VTABLE_SLOT_HEADER_HEIGHT = 96;
    public static final int TAB_WAYPOINTS = 0;
    public static final int TAB_EVENTS = 1;
    public static final long REFRESH_PERIOD_NANOS = 1500000000L;
    public static final int WAYPOINT_CACHE_MIN = 33;
    public static final int WAYPOINT_CACHE_LIMIT = Integer.MAX_VALUE;
    public static final float HEADER_HEIGHT = 126.0f;
    public static final float ZERO = 0.0f;
    public static final float ONE = 1.0f;
    public static final float LAYOUT_FADE_DURATION = 0.16f;
    public static final double POSITION_FLOOR_BIAS = 0.0;
    public static final double NANOS_PER_SECOND = 1.0E9;
    public static final int COLOR_PLATE_ERROR = -2343358;
    public static final int COLOR_PLATE_SUCCESS = -13919642;
    public static final int ICON_ADD_TILE = 35;
    public static final int ICON_ADD_TILE_FRAME = 61;
    public static final int ICON_TOOLBAR = 61;
    public static final int ICON_TOOLBAR_WIDGET = 53;
    public static final long KEY_FILTER_MASK = 864532803075702784L;
    public static final int KEY_FILTER_LIMIT = 59;
    public static final String TEXT_TAB_WAYPOINTS = "\u0428\u0430\u0439\u043f\u043e\u0438\u043d\u0442\u0437";
    public static final String TEXT_TAB_EVENTS = "\u0415\u0432\u0435\u043d\u0442\u0437";
    public static final String TEXT_TOOLBAR_TITLE = "\u041d\u0430\u0436\u043c\u0438\u0442\u0435, \u0447\u0442\u043e\u0431\u044b \u043e\u0442\u043c\u0435\u0442\u0438\u0442\u044c \u043c\u0435\u0441\u0442\u043e, \u0433\u0434\u0435 \u0441\u0442\u043e\u0438\u0442\u0435";
    public static final String TEXT_TOOLBAR_SECOND_LABEL = "\u041d\u0435\u0448 \u0428\u0430\u0439\u043f\u043e\u0438\u043d\u0442";
    public static final String TEXT_ADD_TITLE = "\u0410\u0434\u0434 \u043d\u0435\u0448 \u0448\u0430\u0439\u043f\u043e\u0438\u043d\u0442";
    public static final String TEXT_ADD_SUBTITLE = "\u041d\u0430\u0436\u043c\u0438\u0442\u0435, \u0447\u0442\u043e\u0431\u044b \u043e\u0442\u043c\u0435\u0442\u0438\u0442\u044c \u043c\u0435\u0441\u0442\u043e, \u0433\u0434\u0435 \u0441\u0442\u043e\u0438\u0442\u0435";
    public static final String TEXT_ADD_PLACEHOLDER = "\u0412\u0441\u0442\u0430\u0432\u044c\u0442\u0435 XYZ...";
    public static final String TEXT_COORD_PATTERN = "{} {} {}";
    public static final String EMPTY_TEXT = "";
    protected int tab = 0;
    protected long lastRefresh = 0L;
    private static final KeyPredicate KEY_FILTER = new KeyPredicate(){

        @Override
        public boolean test(int code) {
            return WaypointsPart.isCoordinateKey(code);
        }
    };
    public static final int WAYPOINT_SERVICE_PRIMARY = 0;
    public static final int WAYPOINT_SERVICE_LOCATE = 1;
    public static final int WAYPOINT_SERVICE_CREATE = 2;

    public WaypointsPart() {
        super(WaypointsPart.createToolbar(), WaypointsPart.createAddTileBox(35, TEXT_ADD_TITLE, "\u041d\u0430\u0436\u043c\u0438\u0442\u0435, \u0447\u0442\u043e\u0431\u044b \u043e\u0442\u043c\u0435\u0442\u0438\u0442\u044c \u043c\u0435\u0441\u0442\u043e, \u0433\u0434\u0435 \u0441\u0442\u043e\u0438\u0442\u0435", TEXT_ADD_PLACEHOLDER, 61));
        this.boardToolbar.onTabChanged = new IntConsumer(){

            @Override
            public void accept(int index) {
                WaypointsPart.this.onTabChanged(index);
            }
        };
        this.boardToolbar.onTitleChanged = new Consumer<String>(){

            @Override
            public void accept(String value) {
                WaypointsPart.this.commitInput(value, WaypointsPart.this.plateAt(208, 576));
            }
        };
        this.boardToolbar.onClose = new Runnable(){

            @Override
            public void run() {
                WaypointsPart.this.addWaypointAtPlayer();
            }
        };
        WaypointsPart.installPlateKeyFilter(this.plateAt(208, 576), KEY_FILTER);
        this.addTile.onSubmitText = new Consumer<String>(){

            @Override
            public void accept(String value) {
                WaypointsPart.this.commitInput(value, WaypointsPart.this.plateAt(216, 304));
            }
        };
        this.addTile.onSubmitEmpty = new Runnable(){

            @Override
            public void run() {
                WaypointsPart.this.addWaypointAtPlayer();
            }
        };
        WaypointsPart.installPlateKeyFilter(this.plateAt(216, 304), KEY_FILTER);
        this.refresh();
    }

    public static boolean isCoordinateKey(int code) {
        if (code > 59) {
            return false;
        }
        return (864532803075702784L >>> code & 1L) != 0L;
    }

    private static BoardToolbar createToolbar() {
        ArrayList<BoardToolbar.Tab> tabs = new ArrayList<BoardToolbar.Tab>();
        BoardToolbar.Tab waypointsTab = new BoardToolbar.Tab();
        waypointsTab.label = TEXT_TAB_WAYPOINTS;
        waypointsTab.flag = false;
        waypointsTab.label2 = null;
        waypointsTab.callback = null;
        tabs.add(waypointsTab);
        BoardToolbar.Tab eventsTab = new BoardToolbar.Tab();
        eventsTab.label = TEXT_TAB_EVENTS;
        eventsTab.flag = false;
        eventsTab.label2 = null;
        eventsTab.callback = new Runnable(){

            @Override
            public void run() {
                WaypointsPart.tabCount();
            }
        };
        tabs.add(eventsTab);
        return new BoardToolbar(tabs, "\u041d\u0430\u0436\u043c\u0438\u0442\u0435, \u0447\u0442\u043e\u0431\u044b \u043e\u0442\u043c\u0435\u0442\u0438\u0442\u044c \u043c\u0435\u0441\u0442\u043e, \u0433\u0434\u0435 \u0441\u0442\u043e\u0438\u0442\u0435", 61, TEXT_TOOLBAR_SECOND_LABEL, 53);
    }

    private static AbstractCollectionPart.AddTileBox createAddTileBox(int icon, String title, String subtitle, String placeholder, int icon2) {
        AbstractCollectionPart.AddTileBox tile = new AbstractCollectionPart.AddTileBox();
        return tile;
    }

    private static void installPlateKeyFilter(Object plate, KeyPredicate filter) {
    }

    private Object plateAt(int ownerOffset, int plateOffset) {
        if (ownerOffset == 208 && plateOffset == 576) {
            return this.boardToolbar.plate;
        }
        if (ownerOffset == 216 && plateOffset == 304) {
            return this.addTile;
        }
        return null;
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void render(Object renderer, float px, float py, float alpha) {
        if (1500000000L < this.now() - this.lastRefresh) {
            this.refresh();
        }
        super.render(renderer, px, py, alpha);
    }

    @Override
    public float headerHeight() {
        return 126.0f;
    }

    public void refresh() {
        this.lastRefresh = this.now();
        List<WaypointCard.WaypointInfo> snapshot = WaypointsPart.fetchWaypoints();
        ArrayList<Component> rebuilt = new ArrayList<Component>(snapshot.size());
        for (int i = 0; i < snapshot.size(); ++i) {
            WaypointCard.WaypointInfo info = snapshot.get(i);
            String name = info.name;
            int size = name.length();
            if (size == 0 || info.broken != (this.tab == 1)) continue;
            boolean matched = false;
            for (int r = 0; r < this.rows.size(); ++r) {
                Component row = (Component)this.rows.get(r);
                if (WaypointsPart.cardClaimed(row) || !WaypointsPart.cardName(row).equals(name)) continue;
                WaypointsPart.applyCardInfo(row, info);
                boolean selected = WaypointsPart.cardSelected(row);
                if (WaypointsPart.cardSelectedFlag(row) != selected) {
                    WaypointsPart.setCardSelectedFlag(row, selected);
                    WaypointsPart.setCardAlphaTarget(row, selected ? 1.0f : 0.0f);
                }
                WaypointsPart.setCardCollapsed(row, !WaypointsPart.cardCollapsed(row));
                rebuilt.add(row);
                matched = true;
                break;
            }
            if (matched) continue;
            rebuilt.add(this.buildCard(info));
        }
        for (int r = 0; r < this.rows.size(); ++r) {
            Component row = (Component)this.rows.get(r);
            if (WaypointsPart.cardClaimed(row) || rebuilt.contains(row)) continue;
            WaypointsPart.setCardClaimed(row, true);
            if (WaypointsPart.cardAlphaAnimTarget(row) != 0.0f) {
                long time = this.now();
                WaypointsPart.advanceCardAlpha(row, time);
                WaypointsPart.setCardAlphaFrom(row, WaypointsPart.cardAlphaCurrent(row));
                WaypointsPart.setCardAlphaAnimTarget(row, 0.0f);
                WaypointsPart.setCardAlphaTick(row, time);
                WaypointsPart.setCardAlphaRunning(row, true);
            }
            rebuilt.add(row);
        }
        this.rows.clear();
        this.rows.addAll(rebuilt);
        snapshot.clear();
    }

    public WaypointCard buildCard(WaypointCard.WaypointInfo info) {
        WaypointCard.WaypointInfo copy = WaypointsPart.copyWaypointInfo(info);
        WaypointCard card = WaypointsPart.createWaypointCard(copy);
        WaypointsPart.bindCardAction(card, 176, new WaypointAction(){

            @Override
            public void invoke(WaypointCard.WaypointInfo value) {
                WaypointsPart.this.onCardPrimary(value);
            }
        });
        WaypointsPart.bindCardAction(card, 240, new WaypointAction(){

            @Override
            public void invoke(WaypointCard.WaypointInfo value) {
                WaypointsPart.this.onCardSecondary(value);
            }
        });
        WaypointsPart.bindCardAction(card, 304, new WaypointAction(){

            @Override
            public void invoke(WaypointCard.WaypointInfo value) {
                WaypointsPart.this.onCardFlag(value);
            }
        });
        WaypointsPart.bindCardAction(card, 368, new WaypointAction(){

            @Override
            public void invoke(WaypointCard.WaypointInfo value) {
                WaypointsPart.this.onCardLocate(value);
            }
        });
        WaypointsPart.bindCardAction(card, 432, new WaypointStringAction(){

            @Override
            public void invoke(WaypointCard.WaypointInfo value, String text) {
                WaypointsPart.this.onCardRename(value, text);
            }
        });
        WaypointsPart.bindCardAction(card, 496, new WaypointColorAction(){

            @Override
            public void invoke(WaypointCard.WaypointInfo value, int r, int g, int b) {
                WaypointsPart.this.onCardColor(value, r, g, b);
            }
        });
        return card;
    }

    private static WaypointCard createWaypointCard(WaypointCard.WaypointInfo info) {
        return new WaypointCard(info);
    }

    private static WaypointCard.WaypointInfo copyWaypointInfo(WaypointCard.WaypointInfo info) {
        WaypointCard.WaypointInfo copy = new WaypointCard.WaypointInfo();
        if (info == null) {
            return copy;
        }
        copy.name = info.name;
        copy.key = info.key;
        copy.x = info.x;
        copy.y = info.y;
        copy.z = info.z;
        copy.world = info.world;
        copy.selected = info.selected;
        copy.extra = info.extra;
        copy.broken = info.broken;
        copy.flag99 = info.flag99;
        copy.deadline = info.deadline;
        return copy;
    }

    private static void bindCardAction(WaypointCard card, int offset, Object action) {
    }

    private void onCardPrimary(WaypointCard.WaypointInfo info) {
        if (info.name.length() != 0) {
            WaypointsPart.invokeWaypointService(0, info.name, info);
            this.refresh();
        }
    }

    private void onCardSecondary(WaypointCard.WaypointInfo info) {
        int x = info.x;
        int y = info.y;
        int z = info.z;
        String text = WaypointsPart.formatCoordinates(TEXT_COORD_PATTERN, x, y, z);
        WaypointsPart.copyToClipboard(text);
    }

    private void onCardFlag(WaypointCard.WaypointInfo info) {
        if (info.name.length() != 0) {
            WaypointsPart.invokeWaypointFlagService(info.name, info.selected);
        }
    }

    private void onCardLocate(WaypointCard.WaypointInfo info) {
        if (info.name.length() != 0) {
            PlayerPosition position = WaypointsPart.playerPosition();
            if (position.valid) {
                WaypointsPart.invokeWaypointService(1, info.name, info);
                this.refresh();
            }
        }
    }

    private void onCardRename(WaypointCard.WaypointInfo info, String value) {
        if (info.name.length() != 0) {
            WaypointsPart.invokeWaypointRenameService(info.name, value);
            this.refresh();
        }
    }

    private void onCardColor(WaypointCard.WaypointInfo info, int r, int g, int b) {
        if (info.name.length() != 0) {
            WaypointsPart.invokeWaypointColorService(info.name, r, g, b);
            this.refresh();
        }
    }

    public static int tabCount() {
        List<WaypointCard.WaypointInfo> snapshot = WaypointsPart.fetchWaypoints();
        int count = 0;
        for (int i = 0; i < snapshot.size(); ++i) {
            WaypointCard.WaypointInfo info = snapshot.get(i);
            int next = count + 1;
            if (!info.broken) {
                next = count;
            }
            count = next;
        }
        snapshot.clear();
        return count;
    }

    private void onTabChanged(final int index) {
        this.beginDeferredLayout(new Runnable(){

            @Override
            public void run() {
                WaypointsPart.this.applyTab(index);
            }
        });
    }

    private void applyTab(int index) {
        this.tab = index;
        this.refresh();
        this.layoutDirty = true;
    }

    private void beginDeferredLayout(Runnable action) {
        this.layoutCallback = action;
        this.overlayBlocked = true;
        this.easePow = 0.16f;
        this.layoutEase = 1;
        if (this.layoutFade != 0.0f) {
            long time = this.now();
            this.layoutAlphaB = this.layoutAlphaA;
            this.layoutFade = 0.0f;
            this.lastTime = time;
            this.suppressClick = true;
        }
    }

    private void commitInput(String value, Object plate) {
        WaypointDraft draft = WaypointsPart.parseCoordinates(value);
        String playerName = WaypointsPart.currentPlayerName();
        if (draft.valid && WaypointsPart.isInGame() && playerName.length() != 0) {
            WaypointsPart.invokeWaypointService(2, playerName, draft.x, draft.y, draft.z);
            WaypointsPart.setPlateColor(plate, -13919642);
            if (this.tab == 0) {
                this.refresh();
            } else {
                WaypointsPart.setToolbarTab(this.boardToolbar, 0);
                this.tab = 0;
                this.refresh();
            }
            return;
        }
        WaypointsPart.setPlateColor(plate, -2343358);
    }

    private void addWaypointAtPlayer() {
        PlayerPosition position = WaypointsPart.playerPosition();
        String playerName = WaypointsPart.currentPlayerName();
        if (!position.valid || playerName.length() == 0) {
            WaypointsPart.setPlateColor(this.plateAt(208, 576), -2343358);
            return;
        }
        WaypointsPart.invokeWaypointService(2, playerName, position.x, position.y, position.z);
        if (this.tab != 0) {
            WaypointsPart.setToolbarTab(this.boardToolbar, 0);
            this.tab = 0;
        }
        this.refresh();
    }

    private static List<WaypointCard.WaypointInfo> fetchWaypoints() {
        ArrayList<WaypointCard.WaypointInfo> out = new ArrayList<WaypointCard.WaypointInfo>();
        if (!WaypointsPart.isWaypointStoreAvailable()) {
            return out;
        }
        List<WaypointCard.WaypointInfo> source = WaypointsPart.waypointStoreSnapshot();
        int count = source.size();
        for (int i = 0; i < count; ++i) {
            out.add(WaypointsPart.copyWaypointInfo(source.get(i)));
        }
        return out;
    }

    private static PlayerPosition playerPosition() {
        PlayerPosition out = new PlayerPosition();
        double px = 0.0;
        double py = 0.0;
        double pz = 0.0;
        if (WaypointsPart.isPlayerPresent()) {
            out.x = (int)Math.floor(px + 0.0);
            out.y = (int)Math.floor(py + 0.0);
            out.z = (int)Math.floor(pz + 0.0);
            out.valid = true;
            return out;
        }
        out.valid = false;
        return out;
    }

    private static boolean isWaypointStoreAvailable() {
        return false;
    }

    private static List<WaypointCard.WaypointInfo> waypointStoreSnapshot() {
        return new ArrayList<WaypointCard.WaypointInfo>();
    }

    private static boolean isPlayerPresent() {
        return false;
    }

    private static boolean isInGame() {
        return false;
    }

    private static String currentPlayerName() {
        return EMPTY_TEXT;
    }

    private static WaypointDraft parseCoordinates(String value) {
        return new WaypointDraft();
    }

    private static String formatCoordinates(String pattern, int x, int y, int z) {
        return EMPTY_TEXT;
    }

    private static void copyToClipboard(String text) {
    }

    private static void setPlateColor(Object plate, int color) {
    }

    private static void setToolbarTab(BoardToolbar toolbar, int index) {
    }

    private static void invokeWaypointService(int service, String name, WaypointCard.WaypointInfo info) {
    }

    private static void invokeWaypointService(int service, String name, int x, int y, int z) {
    }

    private static void invokeWaypointFlagService(String name, boolean flag) {
    }

    private static void invokeWaypointRenameService(String name, String value) {
    }

    private static void invokeWaypointColorService(String name, int r, int g, int b) {
    }

    private static boolean cardClaimed(Component card) {
        return false;
    }

    private static void setCardClaimed(Component card, boolean value) {
    }

    private static String cardName(Component card) {
        return EMPTY_TEXT;
    }

    private static void applyCardInfo(Component card, WaypointCard.WaypointInfo info) {
    }

    private static boolean cardSelected(Component card) {
        return false;
    }

    private static boolean cardSelectedFlag(Component card) {
        return false;
    }

    private static void setCardSelectedFlag(Component card, boolean value) {
    }

    private static boolean cardCollapsed(Component card) {
        return false;
    }

    private static void setCardCollapsed(Component card, boolean value) {
    }

    private static void setCardAlphaTarget(Component card, float value) {
    }

    private static float cardAlphaAnimTarget(Component card) {
        return 0.0f;
    }

    private static void setCardAlphaAnimTarget(Component card, float value) {
    }

    private static void advanceCardAlpha(Component card, long time) {
    }

    private static float cardAlphaCurrent(Component card) {
        return 0.0f;
    }

    private static void setCardAlphaFrom(Component card, float value) {
    }

    private static void setCardAlphaTick(Component card, long time) {
    }

    private static void setCardAlphaRunning(Component card, boolean value) {
    }

    public static interface KeyPredicate {
        public boolean test(int var1);
    }

    public static final class PlayerPosition {
        public int x;
        public int y;
        public int z;
        public boolean valid;
    }

    public static final class WaypointDraft {
        public int x;
        public int y;
        public int z;
        public boolean valid;
    }

    public static interface WaypointColorAction {
        public void invoke(WaypointCard.WaypointInfo var1, int var2, int var3, int var4);
    }

    public static interface WaypointStringAction {
        public void invoke(WaypointCard.WaypointInfo var1, String var2);
    }

    public static interface WaypointAction {
        public void invoke(WaypointCard.WaypointInfo var1);
    }
}

