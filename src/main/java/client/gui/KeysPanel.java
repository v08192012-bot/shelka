/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.Component;
import client.gui.Screen;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class KeysPanel
extends Component {
    public static final int VTABLE_RVA = 12595904;
    public static final long RVA_CTOR = 2735201014800L;
    public static final long RVA_DTOR = 2735201015472L;
    public static final long RVA_OPEN = 2735201016096L;
    public static final long RVA_REFRESH = 2735201016528L;
    public static final long RVA_REFRESH_CALLBACK = 2735201016672L;
    public static final long RVA_COLLECT_ENTRIES = 2735201017072L;
    public static final long RVA_FIND_INFO = 2735201017776L;
    public static final long RVA_LIST_TOP = 2735201017968L;
    public static final long RVA_SCROLL_GAUGE = 2735201018096L;
    public static final long RVA_RENDER = 2735201018176L;
    public static final long RVA_DRAW_BUTTON = 2735201019776L;
    public static final long RVA_DRAW_KEY_LIST = 2735201020736L;
    public static final long RVA_DRAW_ROW = 2735201022352L;
    public static final long RVA_SYNC_ROWS = 2735201023888L;
    public static final long RVA_CREATE_ROW = 2735201024928L;
    public static final long RVA_MOUSE_CLICKED = 2735201025328L;
    public static final long RVA_HANDLE_LIST_CLICK = 2735201026176L;
    public static final long RVA_MOUSE_RELEASED = 2735201027376L;
    public static final long RVA_MOUSE_DRAGGED = 2735201027408L;
    public static final long RVA_MOUSE_SCROLLED = 2735201027744L;
    public static final long RVA_KEY_PRESSED = 2735201028176L;
    public static final long RVA_COLLECT_KEY_TEXT = 2735201028208L;
    public static final long RVA_ROW_ANIM = 2735201014640L;
    public static final long RVA_SYNC_ROW_ORDER = 2735201029968L;
    public static final long RVA_ENSURE_ROWS = 2735201031568L;
    public static final long RVA_ANIM_CACHE_INIT = 2735201032368L;
    public static final long RVA_ANIM_INIT = 2735200260240L;
    public static final long RVA_ANIM_SET = 2735200856400L;
    public static final long RVA_ANIM_SET_EXPO = 2735200778960L;
    public static final long RVA_ANIM_RETARGET = 2735200831376L;
    public static final long RVA_ANIM_DELAYED_RETARGET = 2735200831472L;
    public static final long RVA_ANIM_ADVANCE = 2735200831600L;
    public static final long RVA_FRAME_DELTA = 2735201308544L;
    public static final long RVA_SPRING_STEP = 2735201308640L;
    public static final long RVA_HIT_TEST = 2735200779200L;
    public static final long RVA_BASE_DTOR = 2735200779264L;
    public static final long RVA_PLAY_SOUND = 2735199719200L;
    public static final long RVA_CLIPBOARD = 2735199737360L;
    public static final long RVA_LIST_KEYS = 2735200980032L;
    public static final long RVA_CREATE_KEY = 2735200979392L;
    public static final long RVA_DELETE_KEY = 2735200980752L;
    public static final long RVA_THEME = 2735203198032L;
    public static final long RVA_LERP_COLOR = 2735200832496L;
    public static final long RVA_DRAW_PANEL = 2735203166128L;
    public static final long RVA_DRAW_BACKGROUND = 2735203170384L;
    public static final long RVA_DRAW_ICON = 2735203174176L;
    public static final long RVA_DRAW_SHAPE = 2735203176960L;
    public static final long RVA_DRAW_TEXT = 2735203179696L;
    public static final long RVA_MEASURE_WRAPPED = 2735203178384L;
    public static final long RVA_MEASURE_TEXT = 2735201456016L;
    public static final long RVA_ELLIPSIZE = 2735203199984L;
    public static final long RVA_MAKE_RECT = 2735200822544L;
    public static final long RVA_PUSH_SCISSOR = 2735200379472L;
    public static final long RVA_PUSH_LIST_LAYER = 2735200780464L;
    public static final long RVA_POP_LIST_LAYER = 2735200780784L;
    public static final int VTABLE_OFFSET = 0;
    public static final int X_OFFSET = 8;
    public static final int Y_OFFSET = 12;
    public static final int WIDTH_OFFSET = 16;
    public static final int HEIGHT_OFFSET = 20;
    public static final int FLAGS_OFFSET = 24;
    public static final int RECT_ANIM_OFFSET = 32;
    public static final int OWNED_BUFFER_A_OFFSET = 72;
    public static final int OWNED_BUFFER_B_OFFSET = 80;
    public static final int FLAG_58_OFFSET = 88;
    public static final int NAME_OFFSET = 96;
    public static final int KEY_INFOS_OFFSET = 128;
    public static final int KEY_INFOS_END_OFFSET = 136;
    public static final int KEY_INFOS_CAP_OFFSET = 144;
    public static final int HIDE_CATEGORIES_OFFSET = 152;
    public static final int VISIBLE_OFFSET = 153;
    public static final int HOST_STORAGE_OFFSET = 160;
    public static final int HOST_OFFSET = 216;
    public static final int ALPHA_ANIM_OFFSET = 224;
    public static final int COPY_ANIM_OFFSET = 264;
    public static final int CREATE_ANIM_OFFSET = 304;
    public static final int HINT_ANIM_OFFSET = 344;
    public static final int ROW_ANIM_CACHE_OFFSET = 384;
    public static final int ROW_ANIM_CACHE_AUX_OFFSET = 392;
    public static final int ROW_ANIM_CACHE_BUCKETS_OFFSET = 408;
    public static final int GLYPH_ANIM_CACHE_OFFSET = 448;
    public static final int GLYPH_ANIM_CACHE_AUX_OFFSET = 456;
    public static final int GLYPH_ANIM_CACHE_BUCKETS_OFFSET = 472;
    public static final int ROWS_OFFSET = 512;
    public static final int ROWS_END_OFFSET = 520;
    public static final int ROWS_CAP_OFFSET = 528;
    public static final int ROW_GAP_OFFSET = 536;
    public static final int FRAME_TIMER_OFFSET = 544;
    public static final int SCROLL_ANIM_OFFSET = 552;
    public static final int SCROLL_OFFSET = 592;
    public static final int SCROLL_FRAME_OFFSET = 596;
    public static final int SCROLL_FRAME_VALID_OFFSET = 600;
    public static final int DRAGGING_OFFSET = 601;
    public static final int DRAG_OFFSET_OFFSET = 604;
    public static final int INFO_NAME_OFFSET = 0;
    public static final int INFO_LENGTH_OFFSET = 16;
    public static final int INFO_CATEGORY_OFFSET = 32;
    public static final int ROW_INFO_OFFSET = 0;
    public static final int ROW_RATE_OFFSET = 16;
    public static final int ROW_ALPHA_OFFSET = 20;
    public static final int ROW_VISIBLE_OFFSET = 24;
    public static final int ROW_DELAY_OFFSET = 28;
    public static final int ROW_EASE_OFFSET = 32;
    public static final int ROW_SMOOTH_OFFSET = 40;
    public static final int ROW_INITIALIZED_OFFSET = 41;
    public static final int ROW_CURRENT_Y_OFFSET = 44;
    public static final int ROW_TARGET_Y_OFFSET = 48;
    public static final int CACHE_VALUE_OFFSET = 0;
    public static final int CACHE_HEAD_OFFSET = 8;
    public static final int CACHE_COUNT_OFFSET = 16;
    public static final int CACHE_BUCKETS_OFFSET = 24;
    public static final int CACHE_MASK_OFFSET = 48;
    public static final int CACHE_BUCKET_COUNT_OFFSET = 56;
    public static final float WIDTH = 276.0f;
    public static final float HEIGHT = 288.0f;
    public static final float PAD = 12.0f;
    public static final float GAP = 4.0f;
    public static final float GAP6 = 6.0f;
    public static final float GAP8 = 8.0f;
    public static final float ROW_HEIGHT = 20.0f;
    public static final float LIST_WIDTH = 252.0f;
    public static final float HEADER_BLOCK = 32.0f;
    public static final float BTN_WIDTH = 120.0f;
    public static final float BTN_HEIGHT = 26.0f;
    public static final float BTN_INSET = 3.0f;
    public static final float PANEL_RADIUS = 14.0f;
    public static final float SCROLLBAR_WIDTH = 40.0f;
    public static final float SCROLLBAR_GRAB = 6.0f;
    public static final float SCROLL_STEP = 24.0f;
    public static final float CLOSE_Y = 14.0f;
    public static final float CLOSE_SIZE = 16.0f;
    public static final float SLIDE_IN = 16.0f;
    public static final float GLYPH_SIZE = 8.0f;
    public static final float LABEL_X = 138.0f;
    public static final float LABEL_Y = 144.0f;
    public static final float SUBTITLE_SIZE = 12.0f;
    public static final float SUBTITLE_WIDTH = 224.0f;
    public static final float SUBTITLE_LINE = 14.4f;
    public static final float ROW_RATE = 4.5f;
    public static final float ROW_GAP = 4.0f;
    public static final float MENU_TITLE_SIZE = 12.0f;
    public static final float BUTTON_TEXT_SIZE = 12.0f;
    public static final float BUTTON_TEXT_INSET = 7.0f;
    public static final float ROW_TEXT_INSET = 6.0f;
    public static final float ROW_GLYPH_INSET = 3.0f;
    public static final float ROW_GLYPH_SPACING = 14.0f;
    public static final float ROW_CONTROL_WIDTH = 13.0f;
    public static final float ROW_CONTROL_HEIGHT = 14.0f;
    public static final float ROW_RESERVED = 11.0f;
    public static final float TEXT_ALPHA = 0.85f;
    public static final float BUTTON_MIX = 0.45f;
    public static final float HINT_DELAY = 1.5f;
    public static final float ANIM_DURATION = 0.15f;
    public static final float FADE_DURATION = 0.22f;
    public static final float SCROLL_DURATION = 0.32f;
    public static final float HINT_DURATION = 0.3f;
    public static final float DEFAULT_STEP = 0.016666668f;
    public static final float MAX_STEP = 0.1f;
    public static final float ALPHA_EPS = 0.001f;
    public static final float NEAR_ONE = 0.999f;
    public static final float HALF = 0.5f;
    public static final float SPRING_EPS = 0.05f;
    public static final float SPRING_SMOOTH = 14.0f;
    public static final float ONE = 1.0f;
    public static final int ICON_CLOSE = 22;
    public static final int ICON_KEY = 54;
    public static final int ICON_REMOVE = 32;
    public static final int ICON_MARK = 20;
    public static final int SHAPE_ROUNDED_QUAD = 4;
    public static final int SHAPE_TEXT = 2;
    public static final int SHAPE_GLYPH = 0;
    public static final int PANEL_SHADOW = 0x1A000000;
    public static final int THEME_BACKGROUND = 0;
    public static final int THEME_ROW = 4;
    public static final int THEME_SURFACE = 8;
    public static final int THEME_TEXT = 16;
    public static final int THEME_HEADER = 24;
    public static final int THEME_ACCENT = 28;
    public static final int SOUND_OPEN = 10;
    public static final int SOUND_CREATE = 12;
    public static final int SOUND_DELETE = 13;
    public static final int SOUND_ACTION = 14;
    public static final int CURSOR_HAND = 1;
    public static final int CURSOR_RESIZE = 4;
    public static final int CLOSE_KEY = 27;
    public static final String TITLE = "\u041f\u0440\u0438\u0432\u0430\u0442\u043d\u044b\u0435 \u043a\u043b\u044e\u0447\u0438";
    public static final String SUBTITLE = "\u0423\u043f\u0440\u0430\u0432\u043b\u044f\u0439\u0442\u0435 \u0441\u0432\u043e\u0438\u043c\u0438 \u043f\u0440\u0438\u0432\u0430\u0442\u043d\u044b\u043c\u0438 \u043a\u043b\u044e\u0447\u0430\u043c\u0438.";
    public static final String LABEL_CREATE = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c";
    public static final String LABEL_COPY = "\u0421\u043a\u043e\u043f\u0438\u0440\u043e\u0432\u0430\u0442\u044c";
    protected final Anim rectAnim = new Anim();
    protected long ownedBufferA;
    protected long ownedBufferB;
    protected byte flag58;
    protected String name = "";
    protected final List<KeyInfo> keyInfos = new ArrayList<KeyInfo>();
    protected boolean hideCategories;
    protected boolean visible;
    protected final byte[] hostStorage = new byte[56];
    protected Component host;
    protected final Anim alphaAnim = new Anim();
    protected final Anim copyAnim = new Anim();
    protected final Anim createAnim = new Anim();
    protected final Anim hintAnim = new Anim();
    protected final AnimCache rowAnimCache = new AnimCache();
    protected final AnimCache glyphAnimCache = new AnimCache();
    protected final List<KeyRow> rows = new ArrayList<KeyRow>();
    protected float rowGap = 4.0f;
    protected long frameTimer = -1L;
    protected final Anim scrollAnim = new Anim();
    protected float scroll;
    protected float scrollFrame;
    protected boolean scrollFrameValid;
    protected boolean dragging;
    protected float dragOffset;
    protected String clipboardText;
    protected String lastCreated;
    private static List<CacheEntry> staticCache;

    public KeysPanel() {
        this("");
    }

    public KeysPanel(String name) {
        this.x = 0.0f;
        this.y = 0.0f;
        this.width = 0.0f;
        this.height = 0.0f;
        this.flags = 256;
        KeysPanel.initAnim(this.rectAnim, 0.0f, 0.15f, 0);
        this.ownedBufferA = 0L;
        this.ownedBufferB = 0L;
        this.flag58 = 0;
        this.name = name != null ? name : "";
        this.keyInfos.clear();
        this.hideCategories = false;
        this.visible = false;
        this.host = null;
        this.alphaAnim.set(0.0f, 0.22f);
        KeysPanel.initAnim(this.copyAnim, 0.0f, 0.15f, 0);
        KeysPanel.initAnim(this.createAnim, 0.0f, 0.15f, 0);
        KeysPanel.initAnim(this.hintAnim, 0.0f, 0.3f, 2);
        this.rowAnimCache.init();
        this.glyphAnimCache.init();
        this.rows.clear();
        this.rowGap = 4.0f;
        this.frameTimer = -1L;
        this.scrollAnim.set(0.0f, 0.32f);
        this.scrollAnim.easing = 1;
        this.scroll = 0.0f;
        this.scrollFrame = 0.0f;
        this.scrollFrameValid = false;
        this.dragging = false;
        this.dragOffset = 0.0f;
        this.width = 276.0f;
        this.height = 288.0f;
    }

    @Override
    public void dispose() {
        KeysPanel.resetString(96);
        this.releaseKeyInfos();
        this.shrinkKeyInfos();
        this.rowAnimCache.disposeNodes();
        this.glyphAnimCache.disposeNodes();
        this.removeRows();
        this.shrinkRows();
        this.releaseHost();
        this.freeRows();
        this.glyphAnimCache.disposeBuckets();
        this.glyphAnimCache.disposeNodes();
        this.rowAnimCache.disposeBuckets();
        this.rowAnimCache.disposeNodes();
        this.releaseHost();
        this.freeKeyInfos();
        KeysPanel.freeString(96);
        super.dispose();
    }

    public void open(Component hostComponent) {
        if (this.host != hostComponent) {
            if (this.host != null) {
                this.releaseHost();
            }
            this.host = hostComponent;
        }
        if (this.host != null) {
            this.x = this.host.getX();
            this.y = this.host.getY();
        }
        this.visible = true;
        KeysPanel.playSound(10);
        this.keyInfos.clear();
        CacheEntry entry = KeysPanel.staticCacheFind(this.name);
        if (entry != null) {
            this.keyInfos.addAll(entry.infos);
        }
        this.refresh();
    }

    public void refresh() {
        this.listKeys(this.name, new Consumer<List<KeyInfo>>(){

            @Override
            public void accept(List<KeyInfo> keys) {
                KeysPanel.this.refreshCallback(keys);
            }
        });
    }

    private void refreshCallback(List<KeyInfo> keys) {
        CacheEntry entry;
        if (keys != this.keyInfos) {
            this.keyInfos.clear();
            if (keys != null) {
                this.keyInfos.addAll(keys);
            }
        }
        if ((entry = KeysPanel.staticCacheGet(this.name)) != null) {
            entry.infos.clear();
            entry.infos.addAll(this.keyInfos);
        }
    }

    private List<String> collectEntries() {
        ArrayList<String> main = new ArrayList<String>();
        ArrayList<String> separators = new ArrayList<String>();
        for (int i = 0; i < this.keyInfos.size(); ++i) {
            KeyInfo info = this.keyInfos.get(i);
            if (info.category == 0) {
                main.add(info.name);
                continue;
            }
            if (this.hideCategories) continue;
            separators.add(info.name);
        }
        return main;
    }

    private KeyInfo findKeyInfo(String value) {
        for (int i = 0; i < this.keyInfos.size(); ++i) {
            KeyInfo info = this.keyInfos.get(i);
            if (info.name.compareTo(value) != 0) continue;
            return info;
        }
        return null;
    }

    public float listTop(float baseY) {
        return KeysPanel.measureWrappedText(SUBTITLE, 12.0f, 224.0f) * 14.4f + 32.0f + baseY + 8.0f;
    }

    private float scrollGauge(int count, float viewport) {
        if (count < 1) {
            float value = 0.0f - viewport;
            if (value <= 0.0f) {
                value = 0.0f;
            }
            return value;
        }
        float value = (float)(count - 1) * 4.0f + (float)count * 20.0f + 8.0f - viewport;
        if (value <= 0.0f) {
            value = 0.0f;
        }
        return value;
    }

    @Override
    public void syncRows() {
        List<String> names = this.collectEntries();
        this.ensureRows(names, 0.0f);
        block0: for (int i = 0; i < this.rows.size(); ++i) {
            KeyRow row = this.rows.get(i);
            for (int j = 0; j < this.keyInfos.size(); ++j) {
                KeyInfo info = this.keyInfos.get(j);
                if (info.name.compareTo(KeysPanel.rowName(row)) != 0) continue;
                row.info = info;
                continue block0;
            }
        }
        this.syncRowOrder(names);
        float delta = this.frameDelta();
        for (int i = 0; i < this.rows.size(); ++i) {
            this.springStep(this.rows.get(i), delta);
        }
        this.removeHiddenRows();
    }

    private void ensureRows(List<String> names, float stagger) {
        int index = 0;
        for (int i = 0; i < names.size(); ++i) {
            String value = names.get(i);
            KeyRow match = this.findRow(value);
            if (match != null) {
                if (match.visible) continue;
                match.visible = true;
                match.delay = 0.0f;
                continue;
            }
            KeyRow row = this.createRow(value);
            if (row == null) continue;
            if (!row.visible) {
                if (stagger <= 0.0f) {
                    row.delay = 0.0f;
                } else {
                    float delay = (float)index * stagger;
                    if (delay <= 0.0f) {
                        delay = 0.0f;
                    }
                    row.delay = delay;
                }
                row.visible = true;
            }
            this.rows.add(row);
            ++index;
        }
        int hidden = 0;
        for (int i = 0; i < this.rows.size(); ++i) {
            float delay;
            KeyRow row = this.rows.get(i);
            if (KeysPanel.findName(names, KeysPanel.rowName(row)) != null || !row.visible) continue;
            if (stagger <= 0.0f) {
                delay = 0.0f;
            } else {
                delay = (float)hidden * stagger;
                if (delay <= 0.0f) {
                    delay = 0.0f;
                }
            }
            row.visible = false;
            row.delay = delay;
            ++hidden;
        }
    }

    private KeyRow createRow(String value) {
        KeyInfo info = this.findKeyInfo(value);
        if (info == null) {
            return null;
        }
        KeyRow row = new KeyRow();
        row.info = info;
        row.rate = 4.5f;
        row.alpha = 0.0f;
        row.visible = false;
        row.delay = 0.0f;
        row.smooth = true;
        row.initialized = false;
        row.currentY = 0.0f;
        row.targetY = 0.0f;
        return row;
    }

    private void syncRowOrder(List<String> names) {
        int i;
        ArrayList<KeyRow> ordered = new ArrayList<KeyRow>();
        for (i = 0; i < names.size(); ++i) {
            String value = names.get(i);
            KeyRow match = this.findRow(value);
            if (match == null) continue;
            ordered.add(match);
        }
        for (i = 0; i < this.rows.size(); ++i) {
            KeyRow row = this.rows.get(i);
            if (ordered.contains(row)) continue;
            ordered.add(row);
        }
        this.rows.clear();
        this.rows.addAll(ordered);
    }

    private void removeHiddenRows() {
        for (int i = this.rows.size() - 1; i >= 0; --i) {
            KeyRow row = this.rows.get(i);
            if (row.visible || !(row.alpha <= 0.001f)) continue;
            this.rows.remove(i);
        }
    }

    private float frameDelta() {
        long current;
        long previous = this.frameTimer;
        this.frameTimer = current = Anim.now();
        if (previous < 0L) {
            return 0.016666668f;
        }
        float delta = (float)((double)(current - previous) / 1.0E9);
        float value = 0.0f;
        if (0.0f <= delta && delta <= 0.1f) {
            value = delta;
        }
        return value;
    }

    private void springStep(KeyRow row, float dt) {
        float value;
        float delay = row.delay;
        float step = dt;
        if (0.0f < delay) {
            if (dt < delay) {
                row.delay = delay - dt;
                step = 0.0f;
            } else {
                row.delay = 0.0f;
                step = dt - delay;
            }
        }
        if (!row.visible) {
            value = row.alpha - step * row.rate;
            if (value <= 0.0f) {
                value = 0.0f;
            }
        } else {
            value = step * row.rate + row.alpha;
            if (1.0f <= value) {
                value = 1.0f;
            }
        }
        row.alpha = value;
        if (row.smooth && row.initialized) {
            float diff = row.targetY - row.currentY;
            if (Math.abs(diff) < 0.05f) {
                row.currentY = row.targetY;
                return;
            }
            float k = dt * 14.0f;
            if (1.0f <= k) {
                k = 1.0f;
            }
            row.currentY = k * diff + row.currentY;
        }
    }

    @Override
    public void render(Object mat, float mouseX, float mouseY, float alpha) {
        float fade;
        float target;
        float f = target = this.visible ? 1.0f : 0.0f;
        if (this.alphaAnim.target != target) {
            float value;
            long time = Anim.now();
            this.alphaAnim.from = value = this.alphaAnim.advance(time);
            this.alphaAnim.target = target;
            this.alphaAnim.start = time;
            this.alphaAnim.running = true;
        }
        if (0.001f < (fade = this.alphaAnim.advance(Anim.now()))) {
            if (this.host != null) {
                this.x = this.host.getX();
                this.y = this.host.getY();
            }
            this.syncRows();
            float scaled = fade * alpha;
            float rowY = (1.0f - KeysPanel.clamp01(fade)) * 16.0f + this.y;
            KeysPanel.pushScissor(mat, fade, this.x + 138.0f, rowY + 144.0f);
            Object rect = KeysPanel.makeRect(this.x, rowY, 276.0f, 288.0f, 14.0f);
            float left = this.x + 12.0f;
            float top = rowY + 12.0f;
            KeysPanel.drawRoundedQuad(mat, rect, left, top, 14.0f, KeysPanel.themeColor(24), scaled);
            KeysPanel.drawIcon(mat, rect, 22, this.x + 276.0f - 12.0f - 8.0f, rowY + 14.0f, 8.0f, KeysPanel.themeColor(16), scaled);
            KeysPanel.drawText(mat, rect, TITLE, left, top + 14.0f + 4.0f, 12.0f, 224.0f, KeysPanel.themeColor(16), scaled);
            float panelTop = this.listTop(rowY);
            KeysPanel.drawPanel(mat, rect, left, panelTop, 252.0f, 32.0f, 14.0f, KeysPanel.themeColor(8), 0x1A000000, 8.0f, scaled);
            float buttonY = panelTop + 3.0f;
            float buttonX = left + 4.0f;
            this.drawButton(mat, buttonX, buttonY, 120.0f, LABEL_COPY, this.copyAnim, this.hintAnim, mouseX, mouseY, scaled);
            this.drawButton(mat, buttonX + 120.0f + 4.0f, buttonY, 120.0f, LABEL_CREATE, this.createAnim, null, mouseX, mouseY, scaled);
            this.drawKeyList(mat, mouseX, mouseY, rowY, scaled);
            if (!this.dragging) {
                float closeY = this.y + 14.0f - 4.0f;
                float closeX = this.x + 276.0f - 12.0f - 8.0f - 4.0f;
                if (closeX <= mouseX && mouseX <= closeX + 16.0f && closeY <= mouseY && mouseY <= closeY + 16.0f) {
                    Screen.hoveredWidget = 1;
                }
            } else {
                Screen.hoveredWidget = 4;
            }
            KeysPanel.popScissor();
        } else if (!this.visible && this.host != null) {
            this.releaseHost();
        }
    }

    private void drawButton(Object mat, float x, float y, float w, String label, Anim hoverAnim, Anim hintAnim, float mouseX, float mouseY, float alpha) {
        float hover = 1.0f;
        if (mouseX < x || x + w < mouseX || mouseY < y || y + 26.0f < mouseY) {
            hover = 0.0f;
        } else {
            Screen.hoveredWidget = 1;
        }
        KeysPanel.retarget(hoverAnim, hover);
        int color = KeysPanel.mixColor(KeysPanel.themeColor(8), KeysPanel.themeColor(24), 0.85f);
        color = KeysPanel.mixColor(KeysPanel.themeColor(0), color, hoverAnim.advance(Anim.now()));
        if (hintAnim != null) {
            float hint = hintAnim.advance(Anim.now());
            if (0.5f < hintAnim.target && 0.999f < hint) {
                KeysPanel.delayedRetarget(hintAnim, 0.0f, 1.5f);
            }
            if (0.001f < hint) {
                color = KeysPanel.mixColor(color, KeysPanel.themeColor(28), hint *= 0.45f);
            }
        }
        KeysPanel.drawPanel(mat, null, x, y, w, 26.0f, 6.0f, color, 0x1A000000, 1.0f, alpha);
        float textWidth = KeysPanel.measureText(label, 12.0f);
        float textX = (w - textWidth) * 0.5f + x;
        KeysPanel.drawText(mat, null, label, textX, y + 7.0f, 12.0f, w, KeysPanel.themeColor(24), alpha);
    }

    private void drawKeyList(Object mat, float mouseX, float mouseY, float baseY, float alpha) {
        float reveal;
        KeyRow row;
        int i;
        float clamped;
        float content;
        float viewRight;
        float left = this.x + 12.0f;
        float panelTop = this.listTop(baseY);
        float innerTop = panelTop + 32.0f + 6.0f;
        float bottom = baseY + 288.0f - (panelTop + 32.0f + 6.0f) - 12.0f;
        KeysPanel.drawListBackground(mat, left, innerTop, 252.0f, bottom, 8.0f, alpha);
        float rowLeft = left + 4.0f;
        float rowRight = left + 252.0f - 4.0f;
        int count = this.rows.size();
        if (count < 7) {
            viewRight = rowRight;
            content = count < 1 ? 0.0f : (float)(count - 1) * 4.0f + (float)count * 20.0f + 8.0f;
        } else {
            viewRight = rowRight - 6.0f - 4.0f;
            content = (float)(count - 1) * 4.0f + (float)count * 20.0f + 8.0f;
        }
        float gauge = content - bottom;
        if (gauge <= 0.0f) {
            gauge = 0.0f;
        }
        this.scroll = clamped = KeysPanel.clampScroll(this.scroll, gauge);
        if (!this.scrollFrameValid || clamped != this.scrollFrame) {
            KeysPanel.retarget(this.scrollAnim, clamped);
            this.scrollFrame = this.scroll;
            this.scrollFrameValid = true;
        }
        float scrollValue = this.scrollAnim.advance(Anim.now());
        float origin = innerTop + 4.0f;
        float rowY = origin - scrollValue;
        boolean first = true;
        for (i = 0; i < this.rows.size(); ++i) {
            row = this.rows.get(i);
            reveal = KeysPanel.rowReveal(row);
            if (!first) {
                rowY += reveal * this.rowGap;
            }
            first = false;
            row.targetY = rowY;
            if (!row.initialized) {
                row.currentY = rowY;
                row.initialized = true;
            }
            rowY += reveal * 20.0f;
        }
        KeysPanel.pushListLayer();
        for (i = 0; i < this.rows.size(); ++i) {
            float currentY;
            row = this.rows.get(i);
            reveal = KeysPanel.rowReveal(row);
            if (!(0.0f < reveal) || !(innerTop <= (currentY = row.currentY) + 4.0f) || !(currentY <= bottom + innerTop)) continue;
            this.drawRow(mat, row.info, currentY, rowLeft, viewRight - rowLeft, mouseX, mouseY, reveal * alpha);
        }
        KeysPanel.popListLayer();
        if (6 < count) {
            float barX = viewRight - 6.0f;
            float thumb = content <= 0.0f ? 0.0f : (bottom + innerTop - 4.0f - origin - 40.0f) * (scrollValue / gauge);
            KeysPanel.drawPanel(mat, null, barX, thumb + origin, 6.0f, 40.0f, 4.0f, KeysPanel.themeColor(4), 0x1A000000, 6.0f, alpha);
        }
    }

    private void drawRow(Object mat, KeyInfo info, float x, float y, float w, float mouseX, float mouseY, float alpha) {
        int icon;
        int iconColor;
        Anim anim = KeysPanel.rowAnim(this.rowAnimCache, info);
        float hover = 0.0f;
        if (!(mouseX < x || x + w < mouseX || mouseY < y || y + 20.0f < mouseY)) {
            Screen.hoveredWidget = 1;
            hover = info != null && info.category != 0 ? 0.0f : 1.0f;
        }
        KeysPanel.retarget(anim, hover);
        int color = KeysPanel.mixColor(KeysPanel.themeColor(4), KeysPanel.themeColor(8), 0.85f);
        if (info != null && info.category == 0) {
            color = KeysPanel.mixColor(KeysPanel.themeColor(4), color, anim.advance(Anim.now()));
        }
        KeysPanel.drawPanel(mat, null, x, y, w, 20.0f, 6.0f, color, 0x1A000000, 6.0f, alpha);
        float controlY = y + 3.0f;
        KeysPanel.drawIcon(mat, null, 54, x + 6.0f, controlY, 14.0f, KeysPanel.themeColor(16), alpha);
        float rightX = x + w - 6.0f;
        float controlX = rightX - 13.0f;
        float textX = x + 6.0f + 14.0f + 6.0f;
        int textColor = info != null && info.category == 0 ? KeysPanel.themeColor(16) : KeysPanel.themeColor(24);
        float avail = controlX - 6.0f - textX;
        if (avail <= 0.0f) {
            avail = 0.0f;
        }
        String label = KeysPanel.ellipsize(info == null ? "" : info.name, avail, 12.0f);
        KeysPanel.drawText(mat, null, label, textX, controlY, 12.0f, avail, textColor, alpha);
        if (info == null || info.category == 0) {
            Anim glyphAnim = KeysPanel.rowAnim(this.glyphAnimCache, info);
            float glyphHover = 0.0f;
            if (!(mouseX < controlX || controlX + 13.0f < mouseX || mouseY < controlY || controlY + 14.0f < mouseY)) {
                glyphHover = 1.0f;
            }
            KeysPanel.retarget(glyphAnim, glyphHover);
            float glyphValue = glyphAnim.advance(Anim.now());
            iconColor = KeysPanel.mixColor(KeysPanel.themeColor(16), KeysPanel.themeColor(24), glyphValue);
            icon = 32;
        } else {
            controlY = y + 6.0f;
            controlX = rightX - 11.0f;
            iconColor = KeysPanel.themeColor(24);
            icon = 20;
        }
        KeysPanel.drawIcon(mat, null, icon, controlX, controlY, 13.0f, iconColor, alpha);
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (!this.visible || button != 0) {
            return false;
        }
        if (this.host != null) {
            this.x = this.host.getX();
            this.y = this.host.getY();
        }
        float closeY = this.y + 14.0f - 4.0f;
        float closeX = this.x + 276.0f - 12.0f - 8.0f - 4.0f;
        if (mx < (double)closeX || (double)(closeX + 16.0f) < mx || my < (double)closeY || (double)(closeY + 16.0f) < my) {
            float buttonY = this.listTop(this.y) + 3.0f;
            float copyX = this.x + 12.0f + 4.0f;
            float createX = copyX + 120.0f + 4.0f;
            if (mx < (double)copyX || (double)(copyX + 120.0f) < mx || my < (double)buttonY || (double)(buttonY + 26.0f) < my) {
                if (mx < (double)createX || (double)(createX + 120.0f) < mx || my < (double)buttonY || (double)(buttonY + 26.0f) < my) {
                    if (this.handleListClick(mx, my)) {
                        return true;
                    }
                    return this.hitRect(mx, my);
                }
                KeysPanel.playSound(12);
                this.createKey(this.name, new Consumer<String>(){

                    @Override
                    public void accept(String created) {
                        KeysPanel.this.lastCreated = created;
                    }
                });
                return true;
            }
            KeysPanel.playSound(14);
            String text = this.collectKeyText();
            if (text != null && text.length() != 0) {
                KeysPanel.setClipboard(text);
                if (text.length() != 0) {
                    KeysPanel.playSound(14);
                    KeysPanel.initAnim(this.hintAnim, 0.0f, 0.3f, 2);
                    KeysPanel.retarget(this.hintAnim, 1.0f);
                }
            }
            return true;
        }
        this.visible = false;
        return true;
    }

    private boolean handleListClick(double mx, double my) {
        float left = this.x + 12.0f;
        float innerTop = this.listTop(this.y) + 32.0f + 6.0f;
        float bottom = this.y + 288.0f - (this.listTop(this.y) + 32.0f + 6.0f) - 12.0f;
        float rowLeft = left + 4.0f;
        float rowRight = left + 252.0f - 4.0f;
        float rowEnd = rowRight - 6.0f;
        int count = this.rows.size();
        if (6 < count) {
            float barX = rowEnd - 4.0f;
            float gauge = (float)(count - 1) * 4.0f + (float)count * 20.0f + 8.0f - bottom;
            if (gauge <= 0.0f) {
                gauge = 0.0f;
            }
            gauge = gauge <= 0.0f ? 0.0f : (bottom + innerTop - 4.0f - (innerTop + 4.0f) - 40.0f) * (this.scrollAnim.current / gauge);
            float thumbY = gauge + innerTop + 4.0f;
            if ((double)barX <= mx && mx <= (double)(barX + 6.0f) && (double)thumbY <= my && my <= (double)(thumbY + 40.0f)) {
                this.dragging = true;
                this.dragOffset = (float)my - thumbY;
                return true;
            }
        }
        if ((double)innerTop <= my && my <= (double)(bottom + innerTop)) {
            for (int i = 0; i < this.rows.size(); ++i) {
                float removeX;
                KeyRow row = this.rows.get(i);
                if (!(0.5f < KeysPanel.rowAlphaAt(row, KeysPanel.clamp01(row.alpha)))) continue;
                KeyInfo info = row.info;
                float rowY = row.currentY;
                if (!(innerTop <= rowY) || !(rowY + 20.0f <= bottom + innerTop)) continue;
                if ((info == null || info.category == 0) && (double)(removeX = rowEnd - 6.0f - 13.0f) <= mx && mx <= (double)(removeX + 13.0f) && (double)(rowY + 3.0f) <= my && my <= (double)(rowY + 3.0f + 14.0f)) {
                    KeysPanel.playSound(13);
                    this.deleteKey(this.name, info == null ? "" : info.name, new Runnable(){

                        @Override
                        public void run() {
                            KeysPanel.this.onDeleteKeyResult();
                        }
                    });
                    return true;
                }
                if (!((double)rowLeft <= mx) || !(mx <= (double)rowRight) || !((double)rowY <= my) || !(my <= (double)(rowY + 20.0f))) continue;
                KeysPanel.playSound(14);
                if (info != null) {
                    KeysPanel.setClipboard(info.name);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean mouseReleased(double mx, double my, int button) {
        if (this.dragging && button == 0) {
            this.dragging = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean mouseDragged(double mx, double my, int button) {
        if (this.dragging && button == 0) {
            float panelTop = this.listTop(this.y);
            float bottomY = this.y + 288.0f;
            float innerTop = panelTop + 32.0f + 6.0f;
            float trackTop = innerTop + 4.0f;
            float bottom = bottomY - (this.listTop(this.y) + 32.0f + 6.0f) - 12.0f;
            float gauge = this.scrollGauge(this.rows.size(), bottom);
            float value = ((float)my - this.dragOffset - trackTop) / (bottom + innerTop - 4.0f - trackTop - 40.0f) * gauge;
            this.scroll = KeysPanel.clampScroll(value, gauge);
            return true;
        }
        return false;
    }

    @Override
    public boolean mouseScrolled(double mx, double my, double amount) {
        if (!this.visible) {
            return false;
        }
        float left = this.x + 12.0f;
        float panelTop = this.listTop(this.y);
        float bottomY = this.y + 288.0f;
        float innerTop = panelTop + 32.0f + 6.0f;
        float bottom = bottomY - (this.listTop(this.y) + 32.0f + 6.0f) - 12.0f;
        int count = this.rows.size();
        if ((double)left <= mx && mx <= (double)(left + 252.0f) && (double)innerTop <= my && my <= (double)(bottom + innerTop) && 6 < count) {
            float gauge = this.scrollGauge(count, bottom);
            float value = this.scroll - (float)amount * 24.0f;
            this.scroll = KeysPanel.clampScroll(value, gauge);
            return true;
        }
        return false;
    }

    @Override
    public boolean keyPressed(int keyCode, int modifiers) {
        if (this.visible && keyCode == 27) {
            this.visible = false;
            return true;
        }
        return false;
    }

    private String collectKeyText() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.keyInfos.size(); ++i) {
            KeyInfo info = this.keyInfos.get(i);
            if (info.category != 0 || info.length == 0) continue;
            if (builder.length() != 0) {
                builder.append('\n');
            }
            builder.append(info.name);
        }
        return builder.toString();
    }

    public String configName() {
        return this.name;
    }

    public boolean isVisibleFlag() {
        return this.visible;
    }

    public float scrollOffset() {
        return this.scroll;
    }

    public void setScroll(float value) {
        this.scroll = value;
    }

    public boolean isDragging() {
        return this.dragging;
    }

    public void setDragging(boolean value) {
        this.dragging = value;
    }

    public List<KeyRow> rows() {
        return this.rows;
    }

    public List<KeyInfo> keyInfos() {
        return this.keyInfos;
    }

    public String takeClipboardText() {
        String value = this.clipboardText;
        this.clipboardText = null;
        return value;
    }

    public String takeCreated() {
        String value = this.lastCreated;
        this.lastCreated = null;
        return value;
    }

    private KeyRow findRow(String value) {
        for (int i = 0; i < this.rows.size(); ++i) {
            KeyRow row = this.rows.get(i);
            if (KeysPanel.rowName(row).compareTo(value) != 0) continue;
            return row;
        }
        return null;
    }

    private static String findName(List<String> names, String value) {
        for (int i = 0; i < names.size(); ++i) {
            if (names.get(i).compareTo(value) != 0) continue;
            return names.get(i);
        }
        return null;
    }

    private static String rowName(KeyRow row) {
        return row.info == null ? "" : row.info.name;
    }

    private static float rowReveal(KeyRow row) {
        return row.alpha;
    }

    private static float rowAlphaAt(KeyRow row, float alpha) {
        return alpha;
    }

    private boolean hitRect(double mx, double my) {
        return (double)this.x <= mx && mx <= (double)(this.x + this.width) && (double)this.y <= my && my <= (double)(this.y + this.height);
    }

    private static float clamp01(float value) {
        if (value < 0.0f) {
            return 0.0f;
        }
        if (value > 1.0f) {
            return 1.0f;
        }
        return value;
    }

    private static float clampScroll(float value, float limit) {
        if (value < 0.0f) {
            return 0.0f;
        }
        if (value > limit) {
            return limit;
        }
        return value;
    }

    private static void initAnim(Anim anim, float value, float duration, int easing) {
        anim.from = value;
        anim.current = value;
        anim.target = value;
        anim.duration = duration;
        anim.easing = easing;
        anim.start = Anim.now();
        anim.running = false;
    }

    private static void retarget(Anim anim, float target) {
        float value;
        if (anim.target == target) {
            return;
        }
        long time = Anim.now();
        anim.from = value = anim.advance(time);
        anim.target = target;
        anim.start = time;
        anim.running = true;
    }

    private static void delayedRetarget(Anim anim, float target, float delay) {
        float value;
        if (anim.target == target) {
            return;
        }
        long time = Anim.now();
        anim.from = value = anim.advance(time);
        anim.running = true;
        anim.target = target;
        anim.start = time - (long)((double)delay * 1.0E9);
    }

    private static Anim rowAnim(AnimCache cache, KeyInfo info) {
        return cache.get(info == null ? "" : info.name);
    }

    private static CacheEntry staticCacheGet(String key) {
        CacheEntry entry = KeysPanel.staticCacheFind(key);
        if (entry == null) {
            entry = new CacheEntry(key);
            KeysPanel.staticCache().add(entry);
        }
        return entry;
    }

    private static CacheEntry staticCacheFind(String key) {
        List<CacheEntry> cache = KeysPanel.staticCache();
        for (int i = 0; i < cache.size(); ++i) {
            if (cache.get((int)i).name.compareTo(key) != 0) continue;
            return cache.get(i);
        }
        return null;
    }

    private static List<CacheEntry> staticCache() {
        if (staticCache == null) {
            staticCache = new ArrayList<CacheEntry>();
        }
        return staticCache;
    }

    private void releaseKeyInfos() {
    }

    private void shrinkKeyInfos() {
    }

    private void freeKeyInfos() {
    }

    private void removeRows() {
    }

    private void shrinkRows() {
    }

    private void freeRows() {
    }

    private void releaseHost() {
        this.host = null;
    }

    private static void resetString(int offset) {
    }

    private static void freeString(int offset) {
    }

    private void listKeys(String key, Consumer<List<KeyInfo>> callback) {
        callback.accept(new ArrayList());
    }

    private void onDeleteKeyResult() {
    }

    private void createKey(String key, Consumer<String> callback) {
        callback.accept(key);
    }

    private void deleteKey(String key, String value, Runnable callback) {
        callback.run();
    }

    private static void setClipboard(String text) {
    }

    private static void playSound(int id) {
    }

    private static int themeColor(int offset) {
        return 0;
    }

    private static int mixColor(int from, int to, float t) {
        return 0;
    }

    private static float measureWrappedText(String text, float size, float width) {
        return 0.0f;
    }

    private static float measureText(String text, float size) {
        return 0.0f;
    }

    private static String ellipsize(String text, float width, float size) {
        return text;
    }

    private static Object pushScissor(Object mat, float alpha, float x, float y) {
        return null;
    }

    private static void popScissor() {
    }

    private static Object makeRect(float x, float y, float width, float height, float radius) {
        return null;
    }

    private static void drawRoundedQuad(Object mat, Object rect, float x, float y, float radius, int color, float alpha) {
    }

    private static void drawPanel(Object mat, Object rect, float x, float y, float width, float height, float inset, int color, int shadow, float radius, float alpha) {
    }

    private static void drawListBackground(Object mat, float x, float y, float width, float height, float radius, float alpha) {
    }

    private static void drawIcon(Object mat, Object rect, int icon, float x, float y, float size, int color, float alpha) {
    }

    private static void drawText(Object mat, Object rect, String text, float x, float y, float size, float width, int color, float alpha) {
    }

    private static void pushListLayer() {
    }

    private static void popListLayer() {
    }

    private static final class Anim {
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
        float from;
        float current;
        float target;
        float duration;
        int easing;
        long start;
        boolean running;

        private Anim() {
        }

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
            return Anim.easeOutCubic(t);
        }

        static long now() {
            return System.nanoTime();
        }

        static float easeOutCubic(float t) {
            float inv = 1.0f - t;
            return 1.0f - inv * inv * inv;
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

    private static final class AnimCache {
        private final List<String> keys = new ArrayList<String>();
        private final List<Anim> values = new ArrayList<Anim>();

        private AnimCache() {
        }

        void init() {
            this.keys.clear();
            this.values.clear();
        }

        Anim get(String key) {
            for (int i = 0; i < this.keys.size(); ++i) {
                if (this.keys.get(i).compareTo(key) != 0) continue;
                return this.values.get(i);
            }
            Anim anim = new Anim();
            KeysPanel.initAnim(anim, 0.0f, 0.15f, 0);
            this.keys.add(key);
            this.values.add(anim);
            return anim;
        }

        void disposeNodes() {
            this.keys.clear();
            this.values.clear();
        }

        void disposeBuckets() {
        }
    }

    private static final class CacheEntry {
        final String name;
        final List<KeyInfo> infos = new ArrayList<KeyInfo>();

        CacheEntry(String name) {
            this.name = name != null ? name : "";
        }
    }

    public static final class KeyInfo {
        public String name = "";
        public int length;
        public byte category;

        public KeyInfo() {
        }

        public KeyInfo(String name) {
            this.name = name != null ? name : "";
            this.length = this.name.length();
            this.category = 0;
        }

        public void setName(String value) {
            this.name = value != null ? value : "";
            this.length = this.name.length();
        }
    }

    public static final class KeyRow {
        public KeyInfo info;
        public float rate = 4.5f;
        public float alpha;
        public boolean visible;
        public float delay;
        public boolean smooth;
        public boolean initialized;
        public float currentY;
        public float targetY;
    }
}

