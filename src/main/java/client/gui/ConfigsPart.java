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

public class ConfigsPart
extends AbstractCollectionPart {
    public static final long VTABLE_RVA = 12592928L;
    public static final long RVA_CTOR = 2735200940512L;
    public static final long RVA_DTOR = 2735200942320L;
    public static final long RVA_DELETING_DTOR = 2735200942256L;
    public static final long RVA_SLOT12 = 2735200942832L;
    public static final long RVA_BUILD_CARD = 2735200946320L;
    public static final long RVA_OPEN_SETTINGS_FOR = 2735200947376L;
    public static final long RVA_HANDLE_CREATE = 2735200948304L;
    public static final long RVA_HANDLE_IMPORT = 2735200948736L;
    public static final long RVA_HANDLE_RENAME = 2735200948896L;
    public static final long RVA_HANDLE_ACTIVATE = 2735200949472L;
    public static final long RVA_HANDLE_DELETE = 2735200960896L;
    public static final long RVA_HANDLE_DESCRIBE = 2735200960576L;
    public static final long RVA_HANDLE_SHARE = 2735200961136L;
    public static final long RVA_REFRESH_FROM_SERVER = 2735200942992L;
    public static final long RVA_SYNC_ROWS = 2735200943408L;
    public static final long RVA_CTOR_TAB_CHANGED = 2735200962000L;
    public static final long RVA_CTOR_TAB_CHANGED_INNER = 2735200958976L;
    public static final long RVA_CTOR_TEXT_TOOLBAR = 2735200961920L;
    public static final long RVA_CTOR_TEXT_TILE = 2735200961792L;
    public static final long RVA_CTOR_CREATE = 2735200961728L;
    public static final long RVA_COUNT_PRIVATE = 2735200959120L;
    public static final long RVA_COUNT_PUBLIC = 2735200959072L;
    public static final long RVA_COUNT_BY_FLAG = 2735200940400L;
    public static final long RVA_TAB_VECTOR_COPY = 2735200952176L;
    public static final long RVA_ADD_TILE_FACTORY = 2735200871952L;
    public static final long RVA_LAYOUT_DEFER = 2735200841200L;
    public static final long RVA_CARD_CB_ACTIVATE = 2735200958848L;
    public static final long RVA_CARD_CB_SAVE = 2735200961328L;
    public static final long RVA_CARD_CB_RENAME = 2735200960832L;
    public static final long RVA_CARD_CB_PRIVATE = 2735200958736L;
    public static final long RVA_CARD_CB_UPDATE = 2735200960288L;
    public static final long RVA_CARD_CB_SETTINGS = 2735200959968L;
    public static final long RVA_DETAILS_CB_ACTIVATE = 2735200958848L;
    public static final long RVA_DETAILS_CB_REFRESH = 2735200957856L;
    public static final long RVA_DETAILS_CB_PRIVATE = 2735200958736L;
    public static final long RVA_DETAILS_CB_CLOSE = 2735200958672L;
    public static final long RVA_DETAILS_ANCHOR = 2735200958448L;
    public static final long RVA_DETAILS_PLACE = 2735200848528L;
    public static final long RVA_DETAILS_DISMISS = 2735200849248L;
    public static final long RVA_DETAILS_CTOR = 2735200932304L;
    public static final long RVA_CLOSE_DETAILS = 2735200948208L;
    public static final long RVA_ROW_HIDE = 2735200953792L;
    public static final long RVA_ROW_FIND = 2735200942848L;
    public static final long RVA_ROW_PUSH = 2735200954208L;
    public static final long RVA_ROW_ERASE = 2735200954560L;
    public static final long RVA_ROW_ASSIGN = 2735200951984L;
    public static final long RVA_SORT_SMALL = 2735200952528L;
    public static final long RVA_SORT_LARGE = 2735200953520L;
    public static final long RVA_GEN_NAME = 2735200949776L;
    public static final long RVA_GEN_NOTE = 2735200951200L;
    public static final long RVA_GEN_RANDOM = 2735200939648L;
    public static final long RVA_GEN_BASE36 = 2735200939904L;
    public static final long RVA_GEN_TWIST = 2735200966704L;
    public static final long RVA_SVC = 2735200967488L;
    public static final long RVA_SVC_CREATE = 2735200993296L;
    public static final long RVA_SVC_IMPORT = 2735200992352L;
    public static final long RVA_SVC_RENAME = 2735200975136L;
    public static final long RVA_SVC_ACTIVATE = 2735200974496L;
    public static final long RVA_SVC_DELETE = 2735200977312L;
    public static final long RVA_SVC_DESCRIBE = 2735200976240L;
    public static final long RVA_SVC_SHARE = 2735200978752L;
    public static final long RVA_SVC_PRIVATE = 2735200978032L;
    public static final long RVA_SVC_LIST = 2735200994144L;
    public static final long RVA_SUBMIT = 2735202903888L;
    public static final int OFF_TAB_FILTER = 392;
    public static final int OFF_NAME_BEGIN = 400;
    public static final int OFF_NAME_END = 408;
    public static final int OFF_NAME_CAP = 416;
    public static final int OFF_DETAILS = 424;
    public static final int OFF_DETAILS_PREV = 432;
    public static final int TAB_ALL = 0;
    public static final int TAB_PRIVATE = 1;
    public static final int TAB_PUBLIC = 2;
    public static final int TAB_STRIDE = 200;
    public static final int TAB_SLOTS = 3;
    public static final int SORT_SMALL_LIMIT = 33;
    public static final int NAME_ATTEMPTS = 33;
    public static final int CONFIG_INFO_ACTIVE = 96;
    public static final int CONFIG_INFO_PRIVATE = 97;
    public static final int CARD_ANIM_FROM = 96;
    public static final int CARD_ANIM_CURRENT = 100;
    public static final int CARD_ANIM_TARGET = 104;
    public static final int CARD_ANIM_START = 120;
    public static final int CARD_ANIM_RUNNING = 128;
    public static final int CARD_NAME = 752;
    public static final int CARD_ACTIVE = 864;
    public static final int CARD_HIDDEN = 168;
    public static final int DETAILS_SELECTED = 208;
    public static final int DETAILS_TOGGLE_ACTIVE = 224;
    public static final int DETAILS_TOGGLE_PRIVATE = 472;
    public static final int DETAILS_CB_ACTIVATE = 1696;
    public static final int DETAILS_CB_REFRESH = 1760;
    public static final int DETAILS_CB_CLOSE = 1824;
    public static final int DETAILS_CB_PRIVATE = 1888;
    public static final int DETAILS_ANCHOR = 144;
    public static final int ADD_TILE_ICON = 29;
    public static final int ADD_TILE_ICON_RIGHT = 54;
    public static final float ADD_TILE_HEIGHT = 62.0f;
    public static final int TOOLBAR_INPUT = 576;
    public static final long RVA_TOOLBAR_INPUT = 2735200875072L;
    public static final String TEXT_TAB = "\u0421\u043e\u043d\u0444\u0438\u0433\u0437";
    public static final String TEXT_TAB_PRIVATE = "\u041f\u0440\u0438\u0432\u0430\u0442\u0435";
    public static final String TEXT_TAB_PUBLIC = "\u041f\u0443\u0431\u043b\u0438\u0441";
    public static final String TEXT_ADD_TITLE = "\u0410\u0434\u0434 \u043d\u0435\u0448 \u0441\u043e\u043d\u0444\u0438\u0433\u0443\u0440\u0430\u0442\u0438\u043e\u043d";
    public static final String TEXT_ADD_SUBTITLE = "\u041d\u0430\u0436\u043c\u0438\u0442\u0435, \u0447\u0442\u043e\u0431\u044b \u0441\u043e\u0437\u0434\u0430\u0442\u044c \u043d\u043e\u0432\u044b\u0439 \u043a\u043e\u043d\u0444\u0438\u0433";
    public static final String TEXT_ADD_PLACEHOLDER = "\u0412\u0441\u0442\u0430\u0432\u044c\u0442\u0435 \u043a\u043b\u044e\u0447...";
    public static final String TEXT_FILTER_LIST = "\u0421\u043f\u0438\u0441\u043a\u043e\u043c";
    public static final String TEXT_FILTER_TILES = "\u041f\u043b\u0438\u0442\u043a\u0430\u043c\u0438";
    public static final String KEY_THEME = "theme";
    public static final String KEY_LANG = "lang";
    public static final String KEY_WORDS = "words";
    public static final String KEY_BINDS = "binds";
    public static final String KEY_BOARDS = "boards";
    public static final String KEY_SCROLL = "scroll";
    public static final String KEY_OFFSET_X = "offset_x";
    public static final String KEY_OFFSET_Y = "offset_y";
    public static final String KEY_SIDEBAR_COLLAPSED = "sidebar_collapsed";
    public static final float SLOT12_VALUE = 174.0f;
    public static final float FADE_DURATION = 0.16f;
    public static final float CARD_ANIM_DURATION = 0.28f;
    public static final float DETAILS_GAP = 16.0f;
    public static final float DETAILS_WIDTH = 250.0f;
    public static final float DETAILS_OFFSET_Y = 1.75f;
    private static final String[] NAME_WORDS = new String[]{"\u043a\u0444\u0433", "\u043a\u043e\u043d\u0444\u0438\u0433"};
    private static final String[] NOTE_WORDS = new String[]{"\u043e\u043f\u0438\u0441\u0430\u043d\u0438\u0435", "\u043e\u043f\u0438\u0441\u0430\u043b\u043e\u0432\u043e", "\u0434\u0435\u0441\u043a\u0440\u0438\u043f\u0448\u043d"};
    private static final String NAME_SEPARATOR = "-";
    private static final int NAME_RANDOM_BOUND = 9000;
    private static final int NAME_RANDOM_BASE = 1000;
    private static final int BASE36 = 36;
    private static final String BASE36_DIGITS = "0123456789abcdefghijklmnopqrstuvwxyz";
    private final List<String> names = new ArrayList<String>();
    private final List<ConfigInfo> entries = new ArrayList<ConfigInfo>();
    private int tabFilter;
    private Runnable pendingTransition;
    private ConfigDetailsCard details;
    private ConfigDetailsCard detailsPrev;

    public ConfigsPart() {
        this.names.clear();
        this.entries.clear();
        this.tabFilter = 0;
        this.pendingTransition = null;
        this.details = null;
        this.detailsPrev = null;
        this.boardToolbar.onTabChanged = new IntConsumer(){

            @Override
            public void accept(final int index) {
                ConfigsPart.this.beginDeferredLayout(new Runnable(){

                    @Override
                    public void run() {
                        ConfigsPart.this.tabFilter = index;
                        ConfigsPart.this.syncRows();
                        ConfigsPart.this.layoutDirty = true;
                    }
                });
            }
        };
        this.boardToolbar.onTitleChanged = new Consumer<String>(){

            @Override
            public void accept(String text) {
                ConfigsPart.this.handleImport(text, new ToolbarPlateInputRef());
            }
        };
        this.boardToolbar.onClose = new Runnable(){

            @Override
            public void run() {
                ConfigsPart.this.handleCreate();
            }
        };
        this.addTile.onSubmitText = new Consumer<String>(){

            @Override
            public void accept(String text) {
                ConfigsPart.this.handleImport(text, new AddTilePlateInputRef());
            }
        };
        this.addTile.onSubmitEmpty = new Runnable(){

            @Override
            public void run() {
                ConfigsPart.this.handleCreate();
            }
        };
        this.refreshFromServer();
    }

    public String[][] tabSpec() {
        return new String[][]{{TEXT_TAB, TEXT_TAB_PRIVATE}, {TEXT_TAB, TEXT_TAB_PUBLIC}, {TEXT_TAB, TEXT_TAB_PRIVATE}};
    }

    public int[] tabPredicate() {
        return new int[]{1, 2, 1};
    }

    private void beginDeferredLayout(Runnable action) {
        this.pendingTransition = action;
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

    public void runPendingTransition() {
        Runnable action = this.pendingTransition;
        this.pendingTransition = null;
        if (action != null) {
            action.run();
        }
    }

    public ConfigCard buildCard(ConfigInfo info) {
        if (info == null) {
            return null;
        }
        boolean isNew = !this.containsName(info.name);
        final ConfigCard card = new ConfigCard(info, isNew);
        card.onActivate = new Consumer<ConfigInfo>(){

            @Override
            public void accept(ConfigInfo item) {
                ConfigsPart.this.handleActivate(item);
            }
        };
        card.onSaveCurrent = new Runnable(){

            @Override
            public void run() {
                ConfigsPart.this.saveCurrent();
            }
        };
        card.onShare = new Consumer<ConfigInfo>(){

            @Override
            public void accept(ConfigInfo item) {
                ConfigsPart.this.handleShare(item);
            }
        };
        card.onDelete = new Consumer<ConfigInfo>(){

            @Override
            public void accept(ConfigInfo item) {
                ConfigsPart.this.handleDelete(item);
            }
        };
        card.onRename = new Consumer<ConfigInfo>(){

            @Override
            public void accept(ConfigInfo item) {
                ConfigsPart.this.handleRename(item, card.pendingName);
            }
        };
        card.onDescribe = new CardDescribeCallback(){

            @Override
            public void accept(ConfigInfo item, String text) {
                ConfigsPart.this.handleDescribe(item, text);
            }
        };
        card.onTogglePrivate = new Consumer<ConfigInfo>(){

            @Override
            public void accept(ConfigInfo item) {
                ConfigsPart.this.togglePrivate(item);
            }
        };
        card.onUpdate = new CardUpdateCallback(){

            @Override
            public void accept(ConfigInfo item, boolean visible) {
                ConfigsPart.this.applyUpdate(item, visible);
            }
        };
        card.onOpenSettings = new Consumer<ConfigInfo>(){

            @Override
            public void accept(ConfigInfo item) {
                ConfigsPart.this.openSettingsFor(card, item);
            }
        };
        return card;
    }

    public void openSettingsFor(final ConfigCard card, ConfigInfo info) {
        if (info == null) {
            return;
        }
        if (this.details != null) {
            this.dismissDetails();
        }
        this.closeDetails();
        ConfigDetailsCard view = new ConfigDetailsCard(info);
        view.onActivate = new Consumer<ConfigInfo>(){

            @Override
            public void accept(ConfigInfo item) {
                ConfigsPart.this.handleActivate(item);
            }
        };
        view.onRefresh = new Runnable(){

            @Override
            public void run() {
                ConfigsPart.this.refreshFromServer();
            }
        };
        view.onTogglePrivate = new Consumer<ConfigInfo>(){

            @Override
            public void accept(ConfigInfo item) {
                ConfigsPart.this.togglePrivate(item);
            }
        };
        view.onClose = new Consumer<ConfigInfo>(){

            @Override
            public void accept(ConfigInfo item) {
                ConfigsPart.this.closeDetails();
            }
        };
        view.onAnchor = new AnchorProvider(){

            @Override
            public float[] anchor() {
                return ConfigsPart.this.computeDetailsAnchor(card);
            }
        };
        ConfigDetailsCard previous = this.detailsPrev;
        this.detailsPrev = view;
        if (previous != null) {
            previous.dispose();
        }
        this.placeDetails(view);
    }

    private float[] computeDetailsAnchor(ConfigCard card) {
        float left;
        float top;
        float right = card.x + card.width;
        if (card.columnIndex == 1) {
            top = card.y;
            left = right + 16.0f;
        } else {
            left = right - 250.0f;
            top = card.height + card.y + 1.75f;
        }
        if (this.toolsRightEdge() + 250.0f > left) {
            left = card.x - 16.0f - 250.0f;
        }
        return new float[]{left, top};
    }

    private float toolsRightEdge() {
        return this.boardToolbar.x + this.boardToolbar.width;
    }

    private void placeDetails(ConfigDetailsCard view) {
        float[] fArray;
        if (view.onAnchor != null) {
            fArray = view.onAnchor.anchor();
        } else {
            float[] fArray2 = new float[2];
            fArray2[0] = 0.0f;
            fArray = fArray2;
            fArray2[1] = 0.0f;
        }
        float[] point = fArray;
        view.setPosition(point[0], point[1]);
        view.setSize(view.width, view.height);
    }

    private void closeDetails() {
        ConfigDetailsCard card = this.details;
        if (card == null) {
            return;
        }
        this.details = null;
        this.detailsPrev = card;
        if (this.detailsPrev != null) {
            this.detailsPrev.dispose();
        }
    }

    private void dismissDetails() {
        if (this.details != null) {
            this.details.dismiss();
        }
    }

    public void refreshFromServer() {
        ConfigsService service = ConfigsService.instance();
        if (!service.hasRefreshHandler()) {
            return;
        }
        service.refresh(new Runnable(){

            @Override
            public void run() {
            }
        });
    }

    public void handleCreate() {
        CardConsumer callback = new CardConsumer(){

            @Override
            public void accept(ConfigInfo info) {
                if (info == null) {
                    return;
                }
                ConfigsPart.this.addName(info.name);
                ConfigsPart.this.syncRows();
            }
        };
        String note = this.generateNote();
        String name = this.generateName();
        ConfigsService service = ConfigsService.instance();
        if (!service.hasCreateHandler()) {
            if (callback != null) {
                callback.accept(new ConfigInfo());
            }
            return;
        }
        service.create(name, note, callback);
    }

    public void handleImport(String text, PlateInputRef input) {
        String key = text;
        final PlateInputRef field = input;
        CardConsumer callback = new CardConsumer(){

            @Override
            public void accept(ConfigInfo info) {
                if (info == null) {
                    return;
                }
                if (field != null) {
                    field.clearText();
                }
                ConfigsPart.this.addName(info.name);
                ConfigsPart.this.syncRows();
            }
        };
        ConfigsService service = ConfigsService.instance();
        if (!service.hasImportHandler()) {
            if (callback != null) {
                callback.accept(new ConfigInfo());
            }
            return;
        }
        service.importByKey(key, callback);
    }

    public void handleRename(ConfigInfo info, String newName) {
        int index;
        if (info == null) {
            return;
        }
        ConfigsService service = ConfigsService.instance();
        if (!service.hasRenameHandler()) {
            info.name = newName;
            return;
        }
        if (newName != null && !this.containsName(newName) && (index = this.indexOfName(info.name)) >= 0) {
            this.names.set(index, newName);
        }
        service.rename(info.name, newName, new CardConsumer(){

            @Override
            public void accept(ConfigInfo item) {
                ConfigsPart.this.syncRows();
            }
        });
    }

    public void handleActivate(ConfigInfo info) {
        if (info == null) {
            return;
        }
        ConfigsService service = ConfigsService.instance();
        if (!service.hasActivateHandler()) {
            info.active = true;
            return;
        }
        service.setActive(info.name, new CardConsumer(){

            @Override
            public void accept(ConfigInfo item) {
                ConfigsPart.this.syncRows();
            }
        });
    }

    public void handleDelete(ConfigInfo info) {
        if (info == null) {
            return;
        }
        this.dropName(info.name);
        ConfigsService service = ConfigsService.instance();
        if (!service.hasDeleteHandler()) {
            this.syncRows();
            return;
        }
        service.deleteConfig(info.name, new CardConsumer(){

            @Override
            public void accept(ConfigInfo item) {
                ConfigsPart.this.syncRows();
            }
        });
    }

    public void handleDescribe(ConfigInfo info, String text) {
        if (info == null) {
            return;
        }
        ConfigsService service = ConfigsService.instance();
        if (!service.hasDescribeHandler()) {
            if (this.details != null) {
                this.details.refresh();
            }
            return;
        }
        service.setDescription(info.name, text, new CardConsumer(){

            @Override
            public void accept(ConfigInfo item) {
                if (ConfigsPart.this.details != null) {
                    ConfigsPart.this.details.refresh();
                }
                ConfigsPart.this.syncRows();
            }
        });
    }

    public void handleShare(ConfigInfo info) {
        if (info == null) {
            return;
        }
        ConfigsService service = ConfigsService.instance();
        if (!service.hasShareHandler()) {
            return;
        }
        service.share(info.name, new CardConsumer(){

            @Override
            public void accept(ConfigInfo item) {
            }
        });
    }

    public void saveCurrent() {
        ConfigsService service = ConfigsService.instance();
        if (!service.hasSaveHandler()) {
            return;
        }
        service.saveCurrent(new Runnable(){

            @Override
            public void run() {
                ConfigsPart.this.syncRows();
            }
        });
    }

    public void togglePrivate(ConfigInfo info) {
        boolean value;
        if (info == null) {
            return;
        }
        info.privateFlag = value = !info.privateFlag;
        ConfigsService service = ConfigsService.instance();
        if (!service.hasPrivateHandler()) {
            if (this.tabFilter != 0) {
                this.syncRows();
            }
            return;
        }
        service.setPrivate(info.name, value, new CardConsumer(){

            @Override
            public void accept(ConfigInfo item) {
                if (ConfigsPart.this.tabFilter != 0) {
                    ConfigsPart.this.syncRows();
                }
            }
        });
    }

    public void applyUpdate(ConfigInfo info, boolean visible) {
        if (info == null) {
            return;
        }
        if (visible) {
            this.addName(info.name);
        } else {
            this.dropName(info.name);
        }
        this.syncRows();
    }

    public int countByFlag(boolean privateValue) {
        int count = 0;
        List<ConfigInfo> all = ConfigsService.instance().list();
        for (int i = 0; i < all.size(); ++i) {
            ConfigInfo info = all.get(i);
            if (info == null || info.privateFlag != privateValue) continue;
            ++count;
        }
        return count;
    }

    @Override
    public void syncRows() {
        Component row;
        int i;
        ConfigInfo info;
        List<String> source = ConfigsService.instance().listNames();
        this.entries.clear();
        for (int i2 = 0; i2 < source.size(); ++i2) {
            String name = source.get(i2);
            info = ConfigsService.instance().find(name);
            if (info == null || this.tabFilter == 1 && !info.privateFlag || this.tabFilter == 2 && info.privateFlag) continue;
            ConfigInfo existing = null;
            for (int k = 0; k < this.entries.size(); ++k) {
                if (!name.equals(this.entries.get((int)k).name)) continue;
                existing = this.entries.get(k);
                break;
            }
            if (existing != null) {
                existing.copyFrom(info);
                continue;
            }
            this.entries.add(info);
        }
        if (this.entries.size() > 33) {
            this.sortEntriesLarge(this.entries);
        } else {
            this.sortEntriesSmall(this.entries);
        }
        ArrayList<ConfigCard> fresh = new ArrayList<ConfigCard>();
        for (i = 0; i < this.entries.size(); ++i) {
            info = this.entries.get(i);
            ConfigCard found = this.findRow(info.name);
            if (found == null) {
                ConfigCard card = this.buildCard(info);
                if (card == null) continue;
                fresh.add(card);
                continue;
            }
            found.active = this.containsName(found.configName);
            fresh.add(found);
        }
        for (i = 0; i < this.rows.size(); ++i) {
            row = (Component)this.rows.get(i);
            if (!(row instanceof ConfigCard)) continue;
            ConfigCard card = (ConfigCard)row;
            if (card.hidden || fresh.contains(card)) continue;
            card.hidden = true;
            card.anim.setTarget(0.0f, this.now());
        }
        this.rows.clear();
        this.rows.addAll(fresh);
        for (i = 0; i < this.rows.size(); ++i) {
            row = (Component)this.rows.get(i);
            if (!(row instanceof ConfigCard)) continue;
            ((ConfigCard)row).hidden = false;
        }
        if (this.details != null && this.details.selectedName != null) {
            for (i = 0; i < this.entries.size(); ++i) {
                if (!this.details.selectedName.equals(this.entries.get((int)i).name)) continue;
                this.details.select(this.entries.get(i));
                break;
            }
        }
    }

    private ConfigCard findRow(String name) {
        if (name == null) {
            return null;
        }
        for (int i = 0; i < this.rows.size(); ++i) {
            Component row = (Component)this.rows.get(i);
            if (!(row instanceof ConfigCard) || !name.equals(((ConfigCard)row).configName)) continue;
            return (ConfigCard)row;
        }
        return null;
    }

    private void sortEntriesSmall(List<ConfigInfo> list) {
        for (int i = 1; i < list.size(); ++i) {
            int j;
            ConfigInfo key = list.get(i);
            for (j = i - 1; j >= 0 && this.compareEntries(list.get(j), key) > 0; --j) {
                list.set(j + 1, list.get(j));
            }
            list.set(j + 1, key);
        }
    }

    private void sortEntriesLarge(List<ConfigInfo> list) {
        this.mergeSort(list, new ConfigInfo[list.size()], 0, list.size() - 1);
    }

    private void mergeSort(List<ConfigInfo> list, ConfigInfo[] buffer, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + hi >>> 1;
        this.mergeSort(list, buffer, lo, mid);
        this.mergeSort(list, buffer, mid + 1, hi);
        int i = lo;
        int j = mid + 1;
        int k = lo;
        while (i <= mid && j <= hi) {
            buffer[k++] = this.compareEntries(list.get(j), list.get(i)) < 0 ? list.get(j++) : list.get(i++);
        }
        while (i <= mid) {
            buffer[k++] = list.get(i++);
        }
        while (j <= hi) {
            buffer[k++] = list.get(j++);
        }
        for (int t = lo; t <= hi; ++t) {
            list.set(t, buffer[t]);
        }
    }

    private int compareEntries(ConfigInfo a, ConfigInfo b) {
        if (a == b) {
            return 0;
        }
        if (a == null) {
            return -1;
        }
        if (b == null) {
            return 1;
        }
        return a.name.compareTo(b.name);
    }

    private String generateNote() {
        int number = ConfigsService.random(9000) + 1000;
        String word = NOTE_WORDS[ConfigsService.random(NOTE_WORDS.length)];
        return word + NAME_SEPARATOR + number;
    }

    private String generateName() {
        List<String> existing = ConfigsService.instance().listNames();
        for (int attempt = 0; attempt < 33; ++attempt) {
            int number = ConfigsService.random(9000) + 1000;
            String word = NAME_WORDS[ConfigsService.random(NAME_WORDS.length)];
            String candidate = word + NAME_SEPARATOR + number;
            if (existing.contains(candidate)) continue;
            return candidate;
        }
        return ConfigsService.base36(System.currentTimeMillis() / 1000L);
    }

    private boolean containsName(String name) {
        if (name == null) {
            return false;
        }
        for (int i = 0; i < this.names.size(); ++i) {
            if (!name.equals(this.names.get(i))) continue;
            return true;
        }
        return false;
    }

    private int indexOfName(String name) {
        if (name == null) {
            return -1;
        }
        for (int i = 0; i < this.names.size(); ++i) {
            if (!name.equals(this.names.get(i))) continue;
            return i;
        }
        return -1;
    }

    private void addName(String name) {
        if (name == null) {
            return;
        }
        if (!this.containsName(name)) {
            this.names.add(name);
        }
    }

    private void dropName(String name) {
        int index = this.indexOfName(name);
        if (index >= 0) {
            this.names.remove(index);
        }
    }

    public String displayText(int index) {
        if (index < 0 || index >= this.entries.size()) {
            return null;
        }
        return this.entries.get((int)index).name;
    }

    public ConfigCard cardAt(int index) {
        if (index < 0 || index >= this.rows.size()) {
            return null;
        }
        Component row = (Component)this.rows.get(index);
        return row instanceof ConfigCard ? (ConfigCard)row : null;
    }

    public ConfigInfo infoAt(int index) {
        if (index < 0 || index >= this.entries.size()) {
            return null;
        }
        return this.entries.get(index);
    }

    public int entryCount() {
        return this.entries.size();
    }

    public int nameCount() {
        return this.names.size();
    }

    public int tabFilter() {
        return this.tabFilter;
    }

    public void setTabFilter(int value) {
        if (this.tabFilter == value) {
            return;
        }
        this.tabFilter = value;
        this.syncRows();
    }

    public ConfigDetailsCard detailsCard() {
        return this.details;
    }

    public float slot12() {
        return 174.0f;
    }

    @Override
    public void dispose() {
        this.names.clear();
        this.entries.clear();
        this.pendingTransition = null;
        this.details = null;
        this.detailsPrev = null;
        super.dispose();
    }

    public static class ConfigDetailsCard
    extends Component {
        public static final int OFF_CB_ACTIVATE = 1696;
        public static final int OFF_CB_REFRESH = 1760;
        public static final int OFF_CB_CLOSE = 1824;
        public static final int OFF_CB_PRIVATE = 1888;
        public static final int OFF_ANCHOR = 144;
        public static final int OFF_SELECTED = 208;
        public ConfigInfo info;
        public String selectedName;
        public Consumer<ConfigInfo> onActivate;
        public Runnable onRefresh;
        public Consumer<ConfigInfo> onTogglePrivate;
        public Consumer<ConfigInfo> onClose;
        public AnchorProvider onAnchor;

        public ConfigDetailsCard(ConfigInfo info) {
            this.info = info;
            this.selectedName = info != null ? info.name : null;
        }

        public void select(ConfigInfo value) {
            this.info = value;
            this.selectedName = value != null ? value.name : null;
        }

        public void refresh() {
        }

        public void dismiss() {
        }
    }

    public static class ConfigInfo {
        public static final int OFF_ACTIVE = 96;
        public static final int OFF_PRIVATE = 97;
        public String name;
        public String description;
        public boolean active;
        public boolean privateFlag;

        public ConfigInfo() {
            this.name = "";
            this.description = "";
            this.active = false;
            this.privateFlag = false;
        }

        public ConfigInfo(String name, String description, boolean active, boolean privateFlag) {
            this.name = name;
            this.description = description;
            this.active = active;
            this.privateFlag = privateFlag;
        }

        public ConfigInfo copyFrom(ConfigInfo other) {
            this.name = other.name;
            this.description = other.description;
            this.active = other.active;
            this.privateFlag = other.privateFlag;
            return this;
        }
    }

    public static class ConfigCard
    extends Component {
        public static final int OFF_CB_ACTIVATE = 8;
        public static final int OFF_CB_SAVE = 240;
        public static final int OFF_CB_SHARE = 304;
        public static final int OFF_CB_DELETE = 368;
        public static final int OFF_CB_SETTINGS = 432;
        public static final int OFF_CB_PRIVATE = 496;
        public static final int OFF_CB_UPDATE = 560;
        public static final int OFF_CB_RENAME = 624;
        public static final int OFF_CB_DESCRIBE = 688;
        public static final int OFF_NAME = 752;
        public static final int OFF_ACTIVE = 864;
        public static final int OFF_HIDDEN = 168;
        public ConfigInfo info;
        public boolean isNew;
        public String configName;
        public String pendingName;
        public boolean active;
        public boolean hidden;
        public int columnIndex;
        public final CardAnim anim = new CardAnim(1.0f, 0.28f);
        public Consumer<ConfigInfo> onActivate;
        public Runnable onSaveCurrent;
        public Consumer<ConfigInfo> onShare;
        public Consumer<ConfigInfo> onDelete;
        public Consumer<ConfigInfo> onRename;
        public CardDescribeCallback onDescribe;
        public Consumer<ConfigInfo> onTogglePrivate;
        public CardUpdateCallback onUpdate;
        public Consumer<ConfigInfo> onOpenSettings;

        public ConfigCard(ConfigInfo info, boolean isNew) {
            this.info = info;
            this.isNew = isNew;
            this.pendingName = this.configName = info != null ? info.name : "";
            this.active = info != null && info.active;
            this.hidden = false;
            this.columnIndex = 0;
        }

        public boolean applyUpdate(boolean visible) {
            this.hidden = !visible;
            return this.hidden;
        }

        @Override
        public void tick() {
            this.anim.advance(this.now());
        }
    }

    public static interface CardDescribeCallback {
        public void accept(ConfigInfo var1, String var2);
    }

    public static interface CardUpdateCallback {
        public void accept(ConfigInfo var1, boolean var2);
    }

    public static interface AnchorProvider {
        public float[] anchor();
    }

    public static class ConfigsService {
        public static final int OFF_REFRESH = 56;
        public static final int OFF_ACTIVATE = 120;
        public static final int OFF_SAVE = 248;
        public static final int OFF_RENAME = 312;
        public static final int OFF_DESCRIBE = 376;
        public static final int OFF_DELETE = 440;
        public static final int OFF_PRIVATE = 568;
        public static final int OFF_SHARE = 632;
        public static final int OFF_IMPORT = 888;
        public static final int OFF_CREATE = 952;
        public static final int OFF_LIST = 1024;
        public static final int MT_N = 624;
        public static final int MT_M = 397;
        public static final int MT_MATRIX_A = -1727483681;
        public static final int MT_UPPER_MASK = Integer.MIN_VALUE;
        public static final int MT_LOWER_MASK = Integer.MAX_VALUE;
        public static final int MT_INIT_MUL = 1812433253;
        public static final int MT_SEED = -1;
        private static final ConfigsService INSTANCE = new ConfigsService();
        private final List<String> keys = new ArrayList<String>();
        private final List<ConfigInfo> items = new ArrayList<ConfigInfo>();
        private final int[] state = new int[624];
        private int index = 624;

        public ConfigsService() {
            this.state[0] = -1;
            for (int i = 1; i < 624; ++i) {
                this.state[i] = 1812433253 * (this.state[i - 1] ^ this.state[i - 1] >>> 30) + i;
            }
            this.index = 624;
        }

        public static ConfigsService instance() {
            return INSTANCE;
        }

        public int nextInt() {
            if (this.index >= 624) {
                this.twist();
            }
            int y = this.state[this.index++];
            y ^= y >>> 11;
            y ^= y << 7 & 0x9D2C5680;
            y ^= y << 15 & 0xEFC60000;
            y ^= y >>> 18;
            return y;
        }

        private void twist() {
            for (int i = 0; i < 624; ++i) {
                int x = this.state[i] & Integer.MIN_VALUE | this.state[(i + 1) % 624] & Integer.MAX_VALUE;
                int xa = x >>> 1;
                if ((x & 1) != 0) {
                    xa ^= 0x9908B0DF;
                }
                this.state[i] = this.state[(i + 397) % 624] ^ xa;
            }
            this.index = 0;
        }

        public static int random(int bound) {
            if (bound <= 0) {
                return 0;
            }
            long range = (long)bound - 1L & 0xFFFFFFFFL;
            long u = range ^ 0x80000000L;
            if (u == Integer.MAX_VALUE) {
                return INSTANCE.nextInt();
            }
            u = u + 0x80000001L & 0xFFFFFFFFL;
            long g = (long)INSTANCE.nextInt() & 0xFFFFFFFFL;
            long product = g * u;
            long low = product & 0xFFFFFFFFL;
            if (low < u) {
                long threshold = (0x100000000L - u) % u & 0xFFFFFFFFL;
                while (low < threshold) {
                    g = (long)INSTANCE.nextInt() & 0xFFFFFFFFL;
                    product = g * u;
                    low = product & 0xFFFFFFFFL;
                }
            }
            return (int)(product >>> 32);
        }

        public static String base36(long value) {
            if (value <= 0L) {
                return "0";
            }
            StringBuffer out = new StringBuffer();
            for (long rest = value; rest > 0L; rest /= 36L) {
                out.append(ConfigsPart.BASE36_DIGITS.charAt((int)(rest % 36L)));
            }
            return out.reverse().toString();
        }

        public List<String> listNames() {
            return new ArrayList<String>(this.keys);
        }

        public List<ConfigInfo> list() {
            return new ArrayList<ConfigInfo>(this.items);
        }

        public void put(ConfigInfo info) {
            if (info == null) {
                return;
            }
            if (!this.keys.contains(info.name)) {
                this.keys.add(info.name);
            }
            for (int i = 0; i < this.items.size(); ++i) {
                if (!info.name.equals(this.items.get((int)i).name)) continue;
                this.items.get(i).copyFrom(info);
                return;
            }
            this.items.add(info);
        }

        public void remove(String name) {
            this.keys.remove(name);
            for (int i = this.items.size() - 1; i >= 0; --i) {
                if (!name.equals(this.items.get((int)i).name)) continue;
                this.items.remove(i);
                return;
            }
        }

        public ConfigInfo find(String name) {
            for (int i = 0; i < this.items.size(); ++i) {
                if (name == null || !name.equals(this.items.get((int)i).name)) continue;
                return this.items.get(i);
            }
            return null;
        }

        public boolean hasRefreshHandler() {
            return true;
        }

        public boolean hasCreateHandler() {
            return true;
        }

        public boolean hasImportHandler() {
            return true;
        }

        public boolean hasRenameHandler() {
            return true;
        }

        public boolean hasActivateHandler() {
            return true;
        }

        public boolean hasDeleteHandler() {
            return true;
        }

        public boolean hasDescribeHandler() {
            return true;
        }

        public boolean hasShareHandler() {
            return true;
        }

        public boolean hasPrivateHandler() {
            return true;
        }

        public boolean hasSaveHandler() {
            return true;
        }

        public void refresh(Runnable callback) {
            if (callback != null) {
                callback.run();
            }
        }

        public void create(String name, String note, CardConsumer callback) {
            ConfigInfo info = new ConfigInfo(name, note, false, false);
            this.put(info);
            if (callback != null) {
                callback.accept(info);
            }
        }

        public void importByKey(String key, CardConsumer callback) {
            ConfigInfo info = new ConfigInfo(key, "", false, false);
            this.put(info);
            if (callback != null) {
                callback.accept(info);
            }
        }

        public void rename(String name, String newName, CardConsumer callback) {
            ConfigInfo info = this.find(name);
            if (info != null && newName != null) {
                this.keys.remove(info.name);
                info.name = newName;
                this.keys.add(newName);
            }
            if (callback != null) {
                callback.accept(info);
            }
        }

        public void setActive(String name, CardConsumer callback) {
            ConfigInfo info = this.find(name);
            if (info != null) {
                for (int i = 0; i < this.items.size(); ++i) {
                    this.items.get((int)i).active = false;
                }
                info.active = true;
            }
            if (callback != null) {
                callback.accept(info);
            }
        }

        public void deleteConfig(String name, CardConsumer callback) {
            ConfigInfo info = this.find(name);
            this.remove(name);
            if (callback != null) {
                callback.accept(info);
            }
        }

        public void setDescription(String name, String text, CardConsumer callback) {
            ConfigInfo info = this.find(name);
            if (info != null) {
                info.description = text;
            }
            if (callback != null) {
                callback.accept(info);
            }
        }

        public void share(String name, CardConsumer callback) {
            ConfigInfo info = this.find(name);
            if (callback != null) {
                callback.accept(info);
            }
        }

        public void setPrivate(String name, boolean value, CardConsumer callback) {
            ConfigInfo info = this.find(name);
            if (info != null) {
                info.privateFlag = value;
            }
            if (callback != null) {
                callback.accept(info);
            }
        }

        public void saveCurrent(Runnable callback) {
            if (callback != null) {
                callback.run();
            }
        }
    }

    public static interface CardConsumer {
        public void accept(ConfigInfo var1);
    }

    public static interface PlateInputRef {
        public void clearText();

        public String text();
    }

    public static class CardAnim {
        public static final int OFF_FROM = 0;
        public static final int OFF_CURRENT = 4;
        public static final int OFF_TARGET = 8;
        public static final int OFF_START = 24;
        public static final int OFF_RUNNING = 32;
        public float from;
        public float current;
        public float target;
        public float duration;
        public int ease;
        public long start;
        public boolean running;

        public CardAnim(float initial, float duration) {
            this.from = initial;
            this.current = initial;
            this.target = initial;
            this.duration = duration;
            this.ease = 0;
            this.start = System.nanoTime();
            this.running = false;
        }

        public void setTarget(float value, long time) {
            if (this.target == value) {
                return;
            }
            this.from = this.current;
            this.start = time;
            this.target = value;
            this.running = true;
        }

        public float advance(long time) {
            if (!this.running || this.duration <= 0.0f) {
                this.running = false;
                this.current = this.target;
                return this.current;
            }
            float t = (float)((double)(time - this.start) / 1.0E9) / this.duration;
            if (t <= 0.0f) {
                this.current = this.from;
                return this.current;
            }
            if (t >= 1.0f) {
                this.running = false;
                this.current = this.target;
                return this.current;
            }
            float k = this.ease == 1 ? Component.easeInCubic(t) : Component.easeOutCubic(t);
            this.current = k * (this.target - this.from) + this.from;
            return this.current;
        }

        public float value() {
            return this.current;
        }
    }

    public static class ToolbarPlateInputRef
    implements PlateInputRef {
        @Override
        public void clearText() {
        }

        @Override
        public String text() {
            return null;
        }
    }

    public class AddTilePlateInputRef
    implements PlateInputRef {
        @Override
        public void clearText() {
            ConfigsPart.this.addTile.clearText();
        }

        @Override
        public String text() {
            return ConfigsPart.this.addTile.text;
        }
    }
}

