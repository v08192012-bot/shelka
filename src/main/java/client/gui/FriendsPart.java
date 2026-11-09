/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.AbstractCollectionPart;
import client.gui.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class FriendsPart
extends AbstractCollectionPart {
    public static final long VTABLE_RVA = 12598544L;
    public static final long RVA_DTOR_BODY = 2735201050880L;
    public static final long RVA_RENDER = 2735201052448L;
    public static final long RVA_CARD_HEIGHT = 2735201050960L;
    public static final long RVA_SHOW_TAB = 2735201051088L;
    public static final long RVA_MOUSE_CLICKED = 2735201053328L;
    public static final long RVA_COMMIT_QUERY = 2735201052208L;
    public static final long RVA_TAB_MENU_ACTION = 2735201051712L;
    public static final long RVA_BUILD_CARD = 2735201063232L;
    public static final long RVA_REFRESH = 2735201060784L;
    public static final long RVA_FETCH_ENTRIES = 2735201053632L;
    public static final long RVA_APPLY_INFO = 2735201041440L;
    public static final long RVA_COPY_INFO = 2735201040352L;
    public static final long RVA_CTOR_LAMBDA_TAB = 2735201070448L;
    public static final long RVA_CTOR_LAMBDA_QUERY = 2735201069808L;
    public static final long RVA_CTOR_LAMBDA_COMMIT = 2735201070176L;
    public static final long RVA_CTOR_LAMBDA_ACTIONS = 2735201069872L;
    public static final long RVA_TAB_SORT_LESS = 2735201070496L;
    public static final long RVA_BUILD_LAMBDA_1 = 2735201069664L;
    public static final long RVA_BUILD_LAMBDA_2 = 2735201069488L;
    public static final long RVA_BUILD_LAMBDA_3 = 2735201069344L;
    public static final long RVA_BUILD_LAMBDA_4 = 2735201069200L;
    public static final long RVA_BUILD_LAMBDA_5 = 2735201069056L;
    public static final long RVA_BUILD_LAMBDA_6 = 2735201068912L;
    public static final long RVA_BUILD_LAMBDA_7 = 2735201068592L;
    public static final long RVA_FRIEND_LIST = 2735201108880L;
    public static final long RVA_PLATFORM_API = 2735201071440L;
    public static final long RVA_SOCIAL_API = 2735201107408L;
    public static final long RVA_INPUT_SUBMIT = 2735201079152L;
    public static final long RVA_INPUT_HAS_TEXT = 2735201078080L;
    public static final long RVA_INPUT_SWAP_TEXT = 2735201078432L;
    public static final long RVA_INPUT_SET_TEXT_ANIM = 2735201077584L;
    public static final int OFF_TAB = 392;
    public static final int OFF_PARTY_PEER = 400;
    public static final int OFF_PLATFORM_HANDLE = 408;
    public static final int OFF_SOCIAL_HANDLE = 416;
    public static final int OFF_SELF_NAME_PTR = 424;
    public static final int OFF_SELF_NAME_LEN = 440;
    public static final int OFF_SELF_NAME_CAP = 448;
    public static final int OFF_PEER_ENABLED = 116;
    public static final int OFF_PEER_INVITE_SUPPORTED = 144;
    public static final int OFF_ENTRY_TYPE = 0;
    public static final int OFF_ENTRY_FLAG_2C = 44;
    public static final int OFF_ENTRY_TEXT_08 = 8;
    public static final int OFF_ENTRY_TEXT_28 = 40;
    public static final int OFF_ENTRY_TEXT_48 = 72;
    public static final int OFF_ENTRY_TEXT_68 = 104;
    public static final int OFF_ENTRY_TEXT_88 = 136;
    public static final int OFF_ENTRY_TEXT_B8 = 184;
    public static final int OFF_ENTRY_A8 = 168;
    public static final int OFF_ENTRY_AC = 172;
    public static final int OFF_ENTRY_AD = 173;
    public static final int OFF_ENTRY_AE = 174;
    public static final int OFF_ENTRY_AF = 175;
    public static final int OFF_ENTRY_B0 = 176;
    public static final int OFF_ENTRY_B1 = 177;
    public static final int OFF_ENTRY_B2 = 178;
    public static final int OFF_ENTRY_B3 = 179;
    public static final int OFF_ENTRY_D8 = 216;
    public static final int OFF_ENTRY_DC = 220;
    public static final int OFF_ENTRY_E0 = 224;
    public static final int OFF_ENTRY_E4 = 228;
    public static final int ENTRY_SIZE = 232;
    public static final int OFF_STRING_PTR = 0;
    public static final int OFF_STRING_SIZE = 16;
    public static final int OFF_STRING_CAP = 24;
    public static final int OFF_CARD_INFO = 624;
    public static final int OFF_CARD_TEXT_278 = 632;
    public static final int OFF_CARD_TEXT_298 = 664;
    public static final int OFF_CARD_TEXT_2B8 = 696;
    public static final int OFF_CARD_TEXT_2D8 = 728;
    public static final int OFF_CARD_TEXT_2F8 = 760;
    public static final int OFF_CARD_TEXT_328 = 808;
    public static final int OFF_CARD_TITLE_TEXT = 856;
    public static final int OFF_CARD_FLAG_A8 = 168;
    public static final int OFF_CARD_ACTIONABLE = 1384;
    public static final int OFF_CARD_CB_08 = 8;
    public static final int OFF_CARD_CB_10 = 16;
    public static final int OFF_CARD_CB_18 = 24;
    public static final int OFF_CARD_CB_20 = 32;
    public static final int OFF_CARD_CB_28 = 40;
    public static final int OFF_CARD_CB_30 = 48;
    public static final int OFF_CARD_CB_38 = 56;
    public static final int OFF_TAB_ENTRY_ACTIVE = 65;
    public static final int OFF_TAB_ENTRY_ENABLED = 66;
    public static final int TAB_ENTRY_SIZE = 72;
    public static final int OFF_TOOLBAR_QUERY_X = 584;
    public static final int OFF_TOOLBAR_QUERY_Y = 588;
    public static final int OFF_TOOLBAR_QUERY_W = 592;
    public static final int OFF_TOOLBAR_QUERY_H = 596;
    public static final int OFF_PLATE_Y = 584;
    public static final int OFF_PLATE_X = 588;
    public static final int OFF_PLATE_WIDTH = 592;
    public static final int OFF_PLATE_HEIGHT = 596;
    public static final int OFF_ADDTILE_PLATE = 304;
    public static final int OFF_ADDTILE_PLATE_X = 312;
    public static final int OFF_ADDTILE_PLATE_Y = 316;
    public static final int OFF_ADDTILE_PLATE_WIDTH = 320;
    public static final int OFF_ADDTILE_PLATE_HEIGHT = 324;
    public static final int OFF_TOOLBAR_CELL_718 = 1816;
    public static final int OFF_TOOLBAR_CELL_ICON_798 = 1944;
    public static final int OFF_TOOLBAR_SEARCH_INPUT_240 = 576;
    public static final int OFF_TOOLBAR_SEARCH_FLAG_3A0 = 928;
    public static final int OFF_TOOLBAR_CELL_928 = 2344;
    public static final int OFF_TOOLBAR_CELL_ICON_9A8 = 2472;
    public static final int OFF_TOOLBAR_BUTTON_2A0 = 672;
    public static final int OFF_ADDTILE_HEIGHT = 20;
    public static final float ADD_TILE_HEIGHT = 62.0f;
    public static final int OFF_ADDTILE_CB_60 = 96;
    public static final int OFF_ADDTILE_CB_A0 = 160;
    public static final int OFF_API_B8 = 184;
    public static final int OFF_API_178 = 376;
    public static final int OFF_API_1B8 = 440;
    public static final int OFF_API_1F8 = 504;
    public static final int OFF_API_238 = 568;
    public static final int OFF_API_278 = 632;
    public static final int OFF_API_2B8 = 696;
    public static final int OFF_API_2F8 = 760;
    public static final int OFF_API_378 = 888;
    public static final int OFF_API_3F8 = 1016;
    public static final int OFF_API_ID = 56;
    public static final int ICON_TOOLBAR = 76;
    public static final int ICON_ADD_TILE = 34;
    public static final int ICON_DISBAND = 77;
    public static final String TAB_TITLE_FRIENDS = "\u0424\u0440\u0438\u0435\u043d\u0434\u0437";
    public static final String TAB_TITLE_PARTY = "\u041f\u0430\u0440\u0442\u0439";
    public static final String TAB_TITLE_INVITATIONS = "\u0418\u043d\u0432\u0438\u0442\u0430\u0442\u0438\u043e\u043d\u0437";
    public static final String TOOLBAR_QUERY_FRIENDS = "\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u043d\u0438\u043a\u043d\u0435\u0439\u043c...";
    public static final String TOOLBAR_QUERY_PARTY = "\u041d\u0438\u043a \u0434\u0440\u0443\u0433\u0430...";
    public static final String TOOLBAR_BUTTON_FRIENDS = "\u0410\u0434\u0434 \u0424\u0440\u0438\u0435\u043d\u0434";
    public static final String TOOLBAR_BUTTON_PARTY = "\u0418\u043d\u0432\u0438\u0442\u0435";
    public static final String ADD_TILE_TITLE = "\u0410\u0434\u0434 \u043d\u0435\u0448 \u0444\u0440\u0438\u0435\u043d\u0434";
    public static final String ADD_TILE_HINT = "\u041d\u0430\u0436\u043c\u0438\u0442\u0435, \u0447\u0442\u043e\u0431\u044b \u0434\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0434\u0440\u0443\u0433\u0430 \u043f\u043e \u043d\u0438\u043a\u0443";
    public static final String INVITE_TITLE = "\u0418\u043d\u0432\u0438\u0442\u0435 \u0442\u043e \u043f\u0430\u0440\u0442\u0439";
    public static final String PARTY_CARD_HINT = "\u041f\u043e\u0437\u043e\u0432\u0438\u0442\u0435 \u0434\u0440\u0443\u0433\u0430 \u043f\u043e \u043d\u0438\u043a\u0443 \u2014 \u043e\u043d \u0434\u043e\u043b\u0436\u0435\u043d \u0431\u044b\u0442\u044c \u0432 \u0441\u0435\u0442\u0438";
    public static final String PARTY_BETA_HINT = "\u041f\u0430\u0442\u0438 \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u0430 \u0431\u0435\u0442\u0430-\u0442\u0435\u0441\u0442\u0435\u0440\u0430\u043c";
    public static final String PARTY_LEAVE = "\u041b\u0435\u0430\u0432\u0435";
    public static final String PARTY_DISBAND = "\u0414\u0438\u0437\u0431\u0430\u043d\u0434";
    public static final String DEFAULT_SELF_NAME = "ShelkaLegit";
    public static final float CARD_FADE_SECONDS = 0.28f;
    public static final float CHAT_WIDTH_LIMIT = 0.001f;
    public static final float TAB_HALF = 0.5f;
    public static final float TOOLBAR_PAD_X = 16.0f;
    public static final float TOOLBAR_PAD_W = 32.0f;
    public static final float TOOLBAR_PAD_Y = 4.0f;
    public static final float TOOLBAR_QUERY_H = 46.0f;
    public static final float NEARLY_ONE = 0.999f;
    public static final int PARTY_MEMBER_MIN = 1;
    protected static final Api PLATFORM_API = new Api();
    protected static final Api SOCIAL_API = new Api();
    protected Object partyPeer = null;
    protected Api platformApi = PLATFORM_API;
    protected Api socialApi = SOCIAL_API;
    protected String selfName = "ShelkaLegit";
    protected int activeTab = 0;
    protected int toolbarTabApplied = -1;
    protected String toolbarQuery = "\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u043d\u0438\u043a\u043d\u0435\u0439\u043c...";
    protected String toolbarButton = "\u0410\u0434\u0434 \u0424\u0440\u0438\u0435\u043d\u0434";
    protected String toolbarCellText = "\u0414\u0438\u0437\u0431\u0430\u043d\u0434";
    protected int toolbarCellIcon = 77;
    protected float toolbarQueryWidth = 46.0f;
    protected StringAction addTileSubmit;

    public FriendsPart() {
        if (this.boardToolbar != null) {
            this.boardToolbar.setTab(2, false);
            this.boardToolbar.onTabChanged = value -> this.showTab(value, true);
            this.boardToolbar.onTitleChanged = value -> this.commitQuery((String)value);
            this.boardToolbar.onClose = () -> this.commitInputs();
            this.boardToolbar.onTabMenuAction = this::runTabMenuAction;
        }
        this.addTileSubmit = value -> this.commitQuery(value);
        this.applyToolbarCell(2);
        this.platformApi = FriendsPart.platformApi();
        this.socialApi = FriendsPart.socialApi();
        this.syncHandles();
        this.refresh();
    }

    public static Api platformApi() {
        return PLATFORM_API;
    }

    public static Api socialApi() {
        return SOCIAL_API;
    }

    public void installToolbarCallbacks() {
        if (this.boardToolbar != null) {
            this.boardToolbar.onTabChanged = value -> this.showTab(value, true);
            this.boardToolbar.onTitleChanged = value -> this.commitQuery((String)value);
            this.boardToolbar.onClose = () -> this.commitInputs();
            this.boardToolbar.onTabMenuAction = this::runTabMenuAction;
        }
        if (this.addTile != null) {
            this.addTile.onSubmitText = value -> this.commitQuery((String)value);
        }
        this.addTileSubmit = value -> this.commitQuery(value);
    }

    public void commitInputs() {
        if (this.addTile != null) {
            this.addTile.plateCommit();
        }
    }

    public void commitQuery(String value) {
        StringRef text = new StringRef(value);
        if (text.empty()) {
            return;
        }
        if (this.activeTab == 1) {
            Consumer<String> handler = FriendsPart.platformApi().slot178;
            if (handler != null) {
                handler.accept(text.value);
            }
            return;
        }
        Consumer<String> handler = FriendsPart.platformApi().slot278;
        if (handler != null) {
            handler.accept(text.value);
        }
        this.refresh();
    }

    public void runTabMenuAction() {
        Consumer<String> handler;
        List<TabEntry> entries = this.friendList();
        String activeName = "";
        for (int i = 0; i < entries.size(); ++i) {
            TabEntry entry = entries.get(i);
            if (!entry.enabled) continue;
            activeName = entry.activeName;
        }
        boolean enabled = this.activeTabEnabled();
        if (enabled) {
            handler = FriendsPart.socialApi().slot2F8;
            if (handler != null) {
                handler.accept(activeName);
            }
            return;
        }
        handler = FriendsPart.socialApi().slot238;
        if (handler != null) {
            handler.accept(activeName);
        }
    }

    public String activeTabName() {
        List<TabEntry> entries = this.friendList();
        String last = "";
        for (int i = 0; i < entries.size(); ++i) {
            TabEntry entry = entries.get(i);
            last = entry.activeName;
        }
        return last;
    }

    public boolean activeTabEnabled() {
        List<TabEntry> entries = this.friendList();
        String activeName = "";
        for (int i = 0; i < entries.size(); ++i) {
            TabEntry entry = entries.get(i);
            if (!entry.enabled) continue;
            activeName = entry.activeName;
        }
        return activeName.length() != 0;
    }

    public List<TabEntry> friendList() {
        ArrayList<TabEntry> out = new ArrayList<TabEntry>();
        for (Component row : this.rows) {
            if (!(row instanceof FriendCard)) continue;
            FriendCard card = (FriendCard)row;
            TabEntry entry = new TabEntry();
            entry.activeName = entry.name = card.info == null || card.info.text08 == null ? "" : card.info.text08;
            entry.active = entry.enabled = card.actionable;
            out.add(entry);
        }
        return out;
    }

    public void showTab(int tab, boolean animate) {
        int resolved = tab;
        if (resolved == 1) {
            if (this.partyPeer == null || !FriendsPart.peerEnabled(this.partyPeer) || this.partyBlocked() || this.partyTooSmall() || this.partyNotJoined()) {
                resolved = 0;
            }
        } else if (resolved == 2 && this.partyPeer != null && FriendsPart.peerInviteSupported(this.partyPeer) && !this.partyBetaOnly()) {
            resolved = 0;
        }
        if (resolved == this.activeTab && animate) {
            return;
        }
        if (this.boardToolbar != null) {
            this.boardToolbar.setTab(resolved, animate);
        }
        this.applyToolbarQuery(resolved, animate);
        this.applyToolbarCell(resolved);
        if (animate) {
            this.setBoardLayout(resolved, true);
            return;
        }
        this.activeTab = resolved;
        this.layoutDirty = true;
    }

    public void showTab(Tab tab, boolean animate) {
        this.showTab(tab.ordinal(), animate);
    }

    public void applyToolbarQuery(int tab, boolean animate) {
        boolean party = tab == 1;
        this.toolbarQuery = party ? TOOLBAR_QUERY_PARTY : TOOLBAR_QUERY_FRIENDS;
        this.toolbarButton = party ? TOOLBAR_BUTTON_PARTY : TOOLBAR_BUTTON_FRIENDS;
        float f = this.toolbarQueryWidth = party ? (float)TOOLBAR_QUERY_PARTY.length() : (float)TOOLBAR_QUERY_FRIENDS.length();
        if (this.addTile != null) {
            this.addTile.text = this.toolbarQuery;
        }
    }

    public void applyToolbarCell(int tab) {
        this.toolbarCellIcon = tab == 2 ? 77 : 76;
        this.toolbarCellText = tab == 2 ? PARTY_DISBAND : PARTY_LEAVE;
    }

    public void showTabFromMenu(int tab) {
        this.activeTab = tab;
        this.layoutDirty = true;
        if (this.boardToolbar != null) {
            this.boardToolbar.setTab(tab, false);
        }
        this.applyToolbarQuery(tab, false);
        this.applyToolbarCell(tab);
    }

    public boolean partyBlocked() {
        return true;
    }

    public boolean partyBetaOnly() {
        return true;
    }

    public boolean partyTooSmall() {
        return false;
    }

    public boolean partyNotJoined() {
        return false;
    }

    public static boolean peerEnabled(Object peer) {
        return false;
    }

    public static boolean peerInviteSupported(Object peer) {
        return false;
    }

    public void syncHandles() {
        Object self;
        this.platformApi = FriendsPart.platformApi();
        this.socialApi = FriendsPart.socialApi();
        Object platformId = null;
        if (this.platformApi.slotId != null) {
            platformId = this.platformApi.slotId.get();
        }
        Object socialId = null;
        if (this.socialApi.slotId != null) {
            socialId = this.socialApi.slotId.get();
        }
        if (platformId == null) {
            platformId = DEFAULT_SELF_NAME;
        }
        if (socialId == null) {
            socialId = DEFAULT_SELF_NAME;
        }
        if ((self = platformId) == null) {
            self = DEFAULT_SELF_NAME;
        }
        this.selfName = String.valueOf(self);
        if (this.selfName.equals(DEFAULT_SELF_NAME)) {
            return;
        }
        this.refresh();
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (button == 0) {
            if (this.boardToolbar != null && this.boardToolbar.plateRectHit(mx, my) && this.addTile != null && this.addTile.plateHasText() && !this.boardToolbar.plateHasText()) {
                this.boardToolbar.setPlateText(this.addTile.text);
                return true;
            }
            if (this.addTile != null && this.addTile.plateRectHit(mx, my) && this.boardToolbar != null && this.boardToolbar.plateHasText() && !this.addTile.plateHasText()) {
                this.addTile.setText(this.boardToolbar.plate.text);
                return true;
            }
        }
        return super.mouseClicked(mx, my, button);
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public void render() {
        super.render();
    }

    public void renderHeader() {
        String text;
        boolean enabled = this.activeTabEnabled();
        String string = text = enabled ? PARTY_DISBAND : PARTY_LEAVE;
        if (this.boardToolbar != null && !this.toolbarCellText.equals(text)) {
            this.toolbarCellText = text;
            this.boardToolbar.setTab(2, false);
        }
        if (this.toolbarTabApplied == 1 && (this.partyPeer == null || !FriendsPart.peerEnabled(this.partyPeer) || this.partyBlocked() || this.partyTooSmall() || this.partyNotJoined())) {
            this.showTab(0, true);
        }
        this.syncHandles();
    }

    public float cardHeight() {
        return 112.0f;
    }

    public FriendCard buildCard(Info info) {
        if (info == null) {
            return null;
        }
        FriendCard card = new FriendCard();
        card.applyInfo(info.copy(), false);
        card.onInvite = value -> {
            Consumer<String> handler = FriendsPart.platformApi().slot378;
            if (handler != null) {
                handler.accept((String)value);
            }
        };
        card.onPrimary = value -> {
            if (value == null) {
                return;
            }
            Consumer<String> handler = FriendsPart.platformApi().slot2B8;
            if (handler != null) {
                handler.accept(value.nickname);
            }
            this.refresh();
        };
        card.onSecondary = value -> {
            if (value == null) {
                return;
            }
            Consumer<String> handler = FriendsPart.socialApi().slot278;
            if (handler != null) {
                handler.accept(value.nickname);
            }
        };
        card.onTertiary = value -> {
            if (value == null) {
                return;
            }
            Consumer<String> handler = FriendsPart.socialApi().slot2B8;
            if (handler != null) {
                handler.accept(value.nickname);
            }
        };
        card.onQuaternary = value -> {
            if (value == null) {
                return;
            }
            Consumer<String> handler = FriendsPart.socialApi().slot1B8;
            if (handler != null) {
                handler.accept(value.action);
            }
        };
        card.onQuinary = value -> {
            if (value == null) {
                return;
            }
            Consumer<String> handler = FriendsPart.socialApi().slot1F8;
            if (handler != null) {
                handler.accept(value.action);
            }
        };
        card.onSenary = value -> {
            if (value == null) {
                return;
            }
            Consumer<String> handler = FriendsPart.socialApi().slot2F8;
            if (handler != null) {
                handler.accept(value.action);
            }
        };
        card.onInviteByName = (value, name) -> {
            if (value == null) {
                return;
            }
            if (value.type == 0 || value.flagAC) {
                Consumer<String> handler = FriendsPart.platformApi().slot3F8;
                if (handler != null) {
                    handler.accept(name);
                }
            } else {
                Consumer<String> handler = FriendsPart.platformApi().slot2F8;
                if (handler != null) {
                    handler.accept(value.nickname);
                }
            }
            this.refresh();
        };
        return card;
    }

    public void refresh() {
        int i;
        List<Info> entries = this.fetchEntries();
        ArrayList<FriendCard> added = new ArrayList<FriendCard>();
        for (i = 0; i < entries.size(); ++i) {
            Info entry = entries.get(i);
            FriendCard existing = this.findCard(entry);
            if (existing == null) {
                FriendCard created = this.buildCard(entry);
                if (created == null) continue;
                added.add(created);
                continue;
            }
            if (existing.collapsed) continue;
            existing.applyInfo(entry, false);
        }
        for (i = 0; i < added.size(); ++i) {
            FriendCard card = (FriendCard)added.get(i);
            if (this.rows.contains(card)) continue;
            this.rows.add(card);
            card.collapsed = false;
            if (card.getAlpha() == 1.0f) continue;
            card.animateAlpha(1.0f, 0.28f);
        }
        for (i = 0; i < this.rows.size(); ++i) {
            FriendCard card;
            Component row = (Component)this.rows.get(i);
            if (!(row instanceof FriendCard) || added.contains(card = (FriendCard)row) || card.collapsed) continue;
            card.collapsed = true;
            if (card.getAlpha() == 0.0f) continue;
            card.animateAlpha(0.0f, 0.28f);
        }
    }

    public FriendCard findCard(Info entry) {
        if (entry == null) {
            return null;
        }
        for (int i = 0; i < this.rows.size(); ++i) {
            Component row = (Component)this.rows.get(i);
            if (!(row instanceof FriendCard)) continue;
            FriendCard card = (FriendCard)row;
            if (card.collapsed || !card.containsName(entry.text08)) continue;
            return card;
        }
        return null;
    }

    public List<Info> fetchEntries() {
        return new ArrayList<Info>();
    }

    public void requestRefresh() {
        this.refresh();
        this.layoutDirty = true;
    }

    @Override
    public void dispose() {
        this.rows.clear();
        this.selfName = "";
        super.dispose();
    }

    public static final class Api {
        public static final long RVA_PLATFORM = 2735201071440L;
        public static final long RVA_SOCIAL = 2735201107408L;
        public Consumer<String> slot178;
        public Consumer<String> slot1B8;
        public Consumer<String> slot1F8;
        public Consumer<String> slot238;
        public Consumer<String> slot278;
        public Consumer<String> slot2B8;
        public Consumer<String> slot2F8;
        public Consumer<String> slot378;
        public Consumer<String> slot3F8;
        public Consumer<String> slotB8;
        public IntSupplier slotId;
    }

    public static interface StringAction {
        public void invoke(String var1);
    }

    public static final class StringRef {
        public String value;

        public StringRef(String value) {
            this.value = value == null ? "" : value;
        }

        public int size() {
            return this.value.length();
        }

        public boolean empty() {
            return this.value.length() == 0;
        }
    }

    public static final class TabEntry {
        public String name;
        public String activeName;
        public boolean active;
        public boolean enabled;
    }

    public static class FriendCard
    extends Component {
        public static final int OFF_INFO = 624;
        public Info info;
        public boolean collapsed;
        public boolean actionable;
        public String titleText = "";
        public Consumer<String> onInvite;
        public InfoAction onPrimary;
        public InfoAction onSecondary;
        public InfoAction onTertiary;
        public InfoAction onQuaternary;
        public InfoAction onQuinary;
        public InfoAction onSenary;
        public InfoStringAction onInviteByName;

        public void applyInfo(Info value, boolean animate) {
            if (value == null) {
                return;
            }
            this.info = value.copy();
            this.titleText = value.text08 == null ? "" : value.text08;
            this.actionable = value.type == 1 && value.flagB2;
        }

        public boolean containsName(String name) {
            if (this.info == null || this.info.text08 == null) {
                return false;
            }
            return this.info.text08.equals(name);
        }
    }

    public static final class Info {
        public int type;
        public String text08;
        public String nickname;
        public String text48;
        public String text68;
        public String text88;
        public int fieldA8;
        public boolean flagAC;
        public boolean flagAD;
        public boolean flagAE;
        public boolean flagAF;
        public boolean flagB0;
        public boolean flagB1;
        public boolean flagB2;
        public boolean flagB3;
        public String action;
        public int fieldD8;
        public int fieldDC;
        public int fieldE0;
        public int fieldE4;

        public static Info of(int type, String text08, String nickname) {
            Info info = new Info();
            info.type = type;
            info.text08 = text08;
            info.nickname = nickname;
            return info;
        }

        public Info copy() {
            Info copy = new Info();
            copy.type = this.type;
            copy.text08 = this.text08;
            copy.nickname = this.nickname;
            copy.text48 = this.text48;
            copy.text68 = this.text68;
            copy.text88 = this.text88;
            copy.fieldA8 = this.fieldA8;
            copy.flagAC = this.flagAC;
            copy.flagAD = this.flagAD;
            copy.flagAE = this.flagAE;
            copy.flagAF = this.flagAF;
            copy.flagB0 = this.flagB0;
            copy.flagB1 = this.flagB1;
            copy.flagB2 = this.flagB2;
            copy.flagB3 = this.flagB3;
            copy.action = this.action;
            copy.fieldD8 = this.fieldD8;
            copy.fieldDC = this.fieldDC;
            copy.fieldE0 = this.fieldE0;
            copy.fieldE4 = this.fieldE4;
            return copy;
        }
    }

    public static enum Tab {
        FRIENDS,
        PARTY,
        INVITATIONS;

    }

    public static interface IntSupplier {
        public int get();
    }

    public static interface InfoAction {
        public void invoke(Info var1);
    }

    public static interface InfoStringAction {
        public void invoke(Info var1, String var2);
    }
}

