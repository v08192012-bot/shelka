/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.BoardToolbar;
import client.gui.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class AbstractCollectionPart
extends Component {
    public static final long VTABLE_RVA = 12585928L;
    public static final long RVA_CTOR = 2735200839568L;
    public static final long RVA_DTOR_BODY = 2735200807888L;
    public static final long RVA_DELETING_DTOR = 2735200840288L;
    public static final long RVA_MOUSE_CLICKED = 2735200845504L;
    public static final long RVA_MOUSE_RELEASED = 2735200846480L;
    public static final long RVA_MOUSE_MOVED = 2735200846640L;
    public static final long RVA_MOUSE_SCROLLED = 2735200847056L;
    public static final long RVA_KEY_PRESSED = 2735200847360L;
    public static final long RVA_KEY_RELEASED = 2735200847552L;
    public static final long RVA_SET_BOARD_LAYOUT = 2735200840496L;
    public static final long RVA_LAYOUT_CALLBACK_OP = 2735200848288L;
    public static final long RVA_LAYOUT_CALLBACK_COPY = 2735200848304L;
    public static final long RVA_ANIMATE_LAYOUT = 2735200841200L;
    public static final long RVA_LAYOUT_LAMBDA_COPY = 2735200847920L;
    public static final long RVA_LAYOUT_LAMBDA_RTTI = 2735200847872L;
    public static final long RVA_SCROLLBAR_HIT = 2735200845248L;
    public static final long RVA_SCROLLBAR_THUMB_Y = 2735200845088L;
    public static final long RVA_SELF_HIT = 2735200779200L;
    public static final long RVA_EASE_IN_CUBIC = 2735200781008L;
    public static final long RVA_EASE_OUT_CUBIC = 2735200259888L;
    public static final long RVA_EASE_OUT_EXPO = 2735200778896L;
    public static final long RVA_ANIM_INIT = 2735200778960L;
    public static final long RVA_ANIM_TARGET = 2735200831376L;
    public static final long RVA_ANIM_ADVANCE = 2735200831600L;
    public static final long RVA_RECT_ANIM_INIT = 2735200260240L;
    public static final long RVA_NOW = 2735199714128L;
    public static final long RVA_NOOP = 2735199916496L;
    public static final long RVA_TOOLBAR_MOUSE_CLICKED = 2735200883728L;
    public static final long RVA_TILE_CTOR = 2735200871952L;
    public static final long RVA_TILE_PLATE_HIT = 2735201081008L;
    public static final long RVA_TILE_PLATE_HOVER = 2735201078176L;
    public static final long RVA_TILE_PLATE_HAS_TEXT = 2735201078080L;
    public static final long RVA_TILE_PLATE_COMMIT = 2735201079152L;
    public static final long RVA_TILE_PLATE_CLEAR = 2735201078320L;
    public static final long RVA_TILE_PLATE_KEY = 2735201081136L;
    public static final long RVA_TILE_PLATE_INSERT = 2735203203472L;
    public static final long RVA_TILE_SET_TEXT_FOCUSED = 2735201526304L;
    public static final long RVA_TILE_TEXT_FOCUS_NOTIFY = 2735201526656L;
    public static final long RVA_TEXT_INPUT_KEY = 2735203205536L;
    public static final long RVA_STRING_ASSIGN = 2735199713520L;
    public static final int SLOT_DTOR = 0;
    public static final int SLOT_DELETING_DTOR = 8;
    public static final int SLOT_MOUSE_CLICKED = 32;
    public static final int SLOT_MOUSE_RELEASED = 40;
    public static final int SLOT_MOUSE_MOVED = 48;
    public static final int SLOT_MOUSE_SCROLLED = 56;
    public static final int SLOT_KEY_PRESSED = 64;
    public static final int SLOT_CHAR_TYPED = 72;
    public static final int SLOT_KEY_RELEASED = 80;
    public static final int SLOT_SET_POSITION = 88;
    public static final int SLOT_HEADER_HEIGHT = 96;
    public static final int OFF_SCROLL_ANIM = 96;
    public static final int OFF_BOARD_TOOLBAR = 208;
    public static final int OFF_ADD_TILE = 216;
    public static final int OFF_ROWS_BEGIN = 224;
    public static final int OFF_ROWS_END = 232;
    public static final int OFF_ROWS_CAP = 240;
    public static final int OFF_LAYOUT_DIRTY = 248;
    public static final int OFF_BOARD_LAYOUT = 252;
    public static final int OFF_LAYOUT_ALPHA_A = 256;
    public static final int OFF_LAYOUT_ALPHA_B = 260;
    public static final int OFF_LAYOUT_FADE = 264;
    public static final int OFF_EASE_POW = 268;
    public static final int OFF_LAYOUT_EASE = 272;
    public static final int OFF_LAST_TIME = 280;
    public static final int OFF_SUPPRESS_CLICK = 288;
    public static final int OFF_OVERLAY_BLOCKED = 296;
    public static final int OFF_LAYOUT_CALLBACK = 304;
    public static final int OFF_LAYOUT_CALLBACK_IMPL = 360;
    public static final int OFF_LAYOUT_LISTENER = 200;
    public static final int OFF_LAYOUT_CACHE0 = 368;
    public static final int OFF_HIT_LIMIT_Y = 372;
    public static final int OFF_CONTENT_TOP = 376;
    public static final int OFF_DRAGGING = 380;
    public static final int OFF_DRAG_OFFSET = 384;
    public static final int OFF_TILE_PLATE = 304;
    public static final int OFF_TILE_PLATE_FOCUSED = 656;
    public static final int OFF_TILE_PLATE_ANIM = 664;
    public static final int OFF_TILE_PLATE_FIELD = 672;
    public static final int OFF_TILE_OVERLAY_OPEN = 928;
    public static final int OFF_TILE_KEY_FILTER = 1040;
    public static final int OFF_TILE_INPUT_CURSOR = 216;
    public static final int OFF_TILE_INPUT_FIELD = 400;
    public static final int OFF_TILE_TEXT = 96;
    public static final int OFF_TOOLBAR_PLATE = 576;
    public static final int OFF_TOOLBAR_OVERLAY_OPEN = 928;
    public static final int OFF_TOOLBAR_KEY_FILTER = 1312;
    public static final int OFF_TOOLBAR_FIELD = 672;
    public static final int OFF_TOOLBAR_TAB_LAYOUT_INDEX = 444;
    public static final int OFF_TOOLBAR_TAB_ALPHA_A = 536;
    public static final int OFF_TOOLBAR_TAB_ALPHA_B = 540;
    public static final int OFF_TOOLBAR_TAB_ALPHA_TARGET = 544;
    public static final int OFF_TOOLBAR_TAB_ALPHA_RUNNING = 568;
    public static final int COMPONENT_CHILDREN_BEGIN = 144;
    public static final int COMPONENT_CHILDREN_END = 152;
    public static final int COMPONENT_FOCUSED = 216;
    public static final float DEFAULT_WIDTH = 964.0f;
    public static final float ANIM_DURATION_SCROLL = 0.28f;
    public static final float ANIM_DURATION_TAB = 0.22f;
    public static final float LAYOUT_ALPHA_DURATION = 0.16f;
    public static final float SCROLL_EPSILON = 0.001f;
    public static final float SCROLLBAR_WIDTH = 14.0f;
    public static final float SCROLLBAR_HEIGHT = 59.0f;
    public static final float SCROLL_STEP = 48.0f;
    public static final float ONE = 1.0f;
    public static final float ZERO = 0.0f;
    public static final float SCROLL_EDGE = 2.0f;
    public static final float LIST_PAD_TOP = 16.0f;
    public static final float LIST_PAD_BOTTOM = 57.0f;
    public static final float TAB_ALPHA_HIDDEN = 1.0f;
    public static final float TAB_ALPHA_SHOWN = 0.0f;
    public static final float EASE_IN_EXPO_RATE = -6.931472f;
    public static final double NANOS = 1.0E9;
    public static final int EASE_OUT_CUBIC = 0;
    public static final int EASE_IN_CUBIC = 1;
    public static final int EASE_OUT_EXPO = 2;
    public static final int KEY_ESCAPE = 27;
    public static final int KEY_ENTER = 13;
    protected BoardToolbar boardToolbar;
    protected AddTileBox addTile;
    protected LayoutListener layoutListener;
    protected Object layoutCallback;
    protected final List<Component> rows = new ArrayList<Component>();
    protected boolean layoutDirty;
    protected int boardLayout;
    protected float layoutAlphaA = 1.0f;
    protected float layoutAlphaB = 1.0f;
    protected float layoutFade = 1.0f;
    protected float easePow = 0.16f;
    protected int layoutEase = 0;
    protected long lastTime;
    protected boolean suppressClick;
    protected boolean overlayBlocked;
    protected float layoutCache0;
    protected float hitLimitY;
    protected float contentTop;
    protected boolean dragging;
    protected float dragOffset;
    protected float layoutCache1;
    protected final Anim scrollAnim = new Anim(0.0f, 0.28f, 2);

    public AbstractCollectionPart() {
    }

    public AbstractCollectionPart(BoardToolbar toolbar, AddTileBox tile) {
        this.flags = 256;
        this.x = 0.0f;
        this.y = 0.0f;
        this.width = 0.0f;
        this.height = 0.0f;
        this.scroll = 0.0f;
        this.scrollLimit = 0.0f;
        this.boardToolbar = toolbar;
        this.addTile = tile;
        this.layoutListener = null;
        this.rows.clear();
        this.layoutDirty = false;
        this.boardLayout = 0;
        this.layoutAlphaA = 1.0f;
        this.layoutAlphaB = 1.0f;
        this.layoutFade = 1.0f;
        this.easePow = 0.16f;
        this.layoutEase = 0;
        this.lastTime = this.now();
        this.suppressClick = false;
        this.overlayBlocked = false;
        this.layoutCache0 = 0.0f;
        this.layoutCache1 = 0.0f;
        this.hitLimitY = 0.0f;
        this.dragging = false;
        this.dragOffset = 0.0f;
        this.width = 964.0f;
        this.layoutEase = 1;
        if (this.boardToolbar != null) {
            this.boardToolbar.onLayoutRequested = this::onBoardLayoutRequested;
        }
    }

    protected void onBoardLayoutRequested(BoardLayout layout) {
        this.setBoardLayout(layout.ordinal(), true);
    }

    public void setBoardLayout(BoardLayout layout, boolean animate) {
        this.setBoardLayout(layout.ordinal(), animate);
    }

    public void setBoardLayout(int layout, boolean animate) {
        BoardToolbar toolbar = this.boardToolbar;
        if (toolbar != null && toolbar.tabLayoutIndex != layout) {
            toolbar.tabLayoutIndex = layout;
            float v = 1.0f;
            if (layout == BoardLayout.LIST.ordinal()) {
                v = 0.0f;
            }
            toolbar.tabAlphaA = v;
            toolbar.tabAlphaB = v;
            toolbar.tabAlphaTarget = v;
            toolbar.tabAlphaRunning = false;
        }
        if (layout == this.boardLayout) {
            if (!animate) {
                return;
            }
        } else {
            if (!animate) {
                this.boardLayout = layout;
                this.layoutDirty = true;
                return;
            }
            this.animateLayout(layout);
        }
        if (this.layoutListener != null) {
            this.layoutListener.acceptInt(layout);
        }
    }

    public void requestLayout(int layout) {
        this.boardLayout = layout;
        this.layoutDirty = true;
    }

    protected void animateLayout(int layout) {
        this.layoutCallback = new LayoutCallback(this, layout);
        this.overlayBlocked = true;
        this.easePow = 0.16f;
        this.layoutEase = 1;
        if (this.layoutFade != 0.0f) {
            float current;
            this.layoutAlphaA = current = AbstractCollectionPart.advanceAnim(this.layoutEase, this.layoutAlphaA, this.layoutAlphaB, this.layoutFade, this.easePow, this.lastTime, this.suppressClick);
            this.layoutAlphaB = current;
            this.layoutFade = 0.0f;
            this.lastTime = this.now();
            this.suppressClick = true;
        }
    }

    protected static float advanceAnim(int ease, float from, float current, float target, float duration, long start, boolean running) {
        if (!running || duration <= 0.0f) {
            return target;
        }
        float t = (float)((double)(System.nanoTime() - start) / 1.0E9) / duration;
        if (t <= 0.0f) {
            return from;
        }
        if (t >= 1.0f) {
            return target;
        }
        return AbstractCollectionPart.easeValue(ease, t) * (target - from) + from;
    }

    public static float easeValue(int ease, float t) {
        if (ease == 1) {
            return AbstractCollectionPart.easeInCubic(t);
        }
        if (ease == 2) {
            return AbstractCollectionPart.easeOutExpo(t);
        }
        return AbstractCollectionPart.easeOutCubic(t);
    }

    public static float easeOutExpo(float t) {
        if (t < 1.0f) {
            return (float)(1.0 - Math.exp(t * -6.931472f));
        }
        return 1.0f;
    }

    @Override
    public void updateAlpha(long time) {
        this.scrollAnim.advance(time);
        this.layoutAlphaB = AbstractCollectionPart.advanceAnim(this.layoutEase, this.layoutAlphaA, this.layoutAlphaB, this.layoutFade, this.easePow, this.lastTime, this.suppressClick);
    }

    public float scrollRange() {
        float v = this.height - 57.0f;
        if (v <= 0.0f) {
            v = 0.0f;
        }
        if ((v -= 2.0f) <= 0.0f) {
            v = 0.0f;
        }
        return v;
    }

    public float scrollTrack() {
        float v = this.scrollLimit - this.height + 16.0f;
        if (v <= 0.0f) {
            v = 0.0f;
        }
        return v;
    }

    public float scrollOffset() {
        return this.thumbY();
    }

    public float thumbY() {
        float track = this.scrollTrack();
        if (track <= 0.0f) {
            return this.y + 57.0f;
        }
        float range = this.scrollRange();
        float ratio = this.scroll / track;
        if (ratio < 0.0f) {
            ratio = 0.0f;
        }
        if (ratio > 1.0f) {
            ratio = 1.0f;
        }
        return (range - 59.0f) * ratio + (this.y + 57.0f);
    }

    public boolean scrollBarHit(double mx, double my) {
        float track = this.scrollTrack();
        if (!(track > 0.001f)) {
            return false;
        }
        float range = this.scrollRange();
        if (!(range > 0.0f)) {
            return false;
        }
        float ty = this.thumbY();
        float tx = this.x + this.width - 2.0f - 2.0f - 14.0f;
        return mx >= (double)tx && mx <= (double)(tx + 14.0f) && my >= (double)ty && my <= (double)(ty + 59.0f);
    }

    public boolean selfHit(double mx, double my) {
        return mx >= (double)this.x && mx <= (double)(this.x + this.width) && my >= (double)this.y && my <= (double)(this.y + this.height);
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (this.boardToolbar != null && this.boardToolbar.mouseClicked(mx, my, button)) {
            return true;
        }
        if ((double)this.hitLimitY > my) {
            return this.selfHit(mx, my);
        }
        if (this.overlayBlocked) {
            return true;
        }
        if (button == 0 && this.scrollBarHit(mx, my)) {
            this.dragging = true;
            float py = (float)my;
            this.dragOffset = py - this.thumbY();
            return true;
        }
        if ((double)this.x > mx) {
            return false;
        }
        if ((double)(this.x + this.width) < mx) {
            return false;
        }
        if ((double)this.contentTop < my) {
            return false;
        }
        ArrayList<Component> snapshot = new ArrayList<Component>(this.children);
        for (Component child : snapshot) {
            if (!child.mouseClicked(mx, my, button)) continue;
            return true;
        }
        AddTileBox tile = this.addTile;
        if (tile != null) {
            if (tile.plateClicked(mx, my, button)) {
                return true;
            }
            if (button == 0 && this.selfHit(mx, my)) {
                if (tile.plateHasText()) {
                    tile.plateCommit();
                    return true;
                }
                if (tile.cursor != null) {
                    tile.cursor.mouseClicked(mx, my, button);
                    return true;
                }
                if (!tile.plateFocused) {
                    tile.plateFocused = true;
                    tile.focusAnim.setTarget(1.0f, this.now());
                    tile.notifyTextFocusChanged();
                    return true;
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
        for (Component child : this.children) {
            if (!child.mouseReleased(mx, my, button)) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean mouseMoved(double mx, double my, double delta) {
        return this.mouseMoved(mx, my, (int)delta, 0.0, 0.0);
    }

    public boolean mouseMoved(double mx, double my, int buttons, double unusedA, double unusedB) {
        float track;
        if (!this.dragging || buttons != 0) {
            for (Component child : this.children) {
                if (!child.mouseMoved(mx, my, buttons)) continue;
                return true;
            }
            return false;
        }
        float range = this.height - 57.0f;
        if (range <= 0.0f) {
            range = 0.0f;
        }
        if ((track = this.scrollLimit - this.height + 16.0f) <= 0.0f) {
            track = 0.0f;
        }
        if ((range -= 2.0f) <= 0.0f) {
            range = 0.0f;
        }
        float v = 0.0f;
        if (0.0f < range - 59.0f) {
            float ratio = ((float)my - this.dragOffset - (this.y + 59.0f)) / (range - 59.0f) * track;
            v = ratio;
            if (v < 0.0f) {
                v = 0.0f;
            }
            if (v > track) {
                v = track;
            }
        }
        this.scroll = v;
        this.scrollAnim.setTarget(v, this.now());
        return true;
    }

    @Override
    public boolean mouseScrolled(double mx, double my, double amount) {
        if ((double)this.hitLimitY <= my) {
            if (!this.overlayBlocked) {
                float v;
                if ((double)this.x > mx) {
                    return false;
                }
                if ((double)(this.x + this.width) < mx) {
                    return false;
                }
                if ((double)this.y > my) {
                    return false;
                }
                if ((double)(this.height + this.y) < my) {
                    return false;
                }
                float track = this.scrollLimit - this.height + 16.0f;
                if (track <= 0.0f) {
                    track = 0.0f;
                }
                if ((v = this.scroll - (float)amount * 48.0f) < 0.0f) {
                    v = 0.0f;
                }
                if (v > track) {
                    v = track;
                }
                this.scroll = v;
                this.scrollAnim.setTarget(v, this.now());
            }
        } else if ((double)this.x > mx || (double)(this.x + this.width) < mx || (double)this.y > my || (double)(this.y + this.height) < my) {
            return false;
        }
        return true;
    }

    @Override
    public boolean keyPressed(int keyCode, int modifiers) {
        for (Component part : this.children) {
            for (Component child : part.children) {
                if (!child.focused) continue;
                return part.keyPressed(keyCode, modifiers);
            }
        }
        if (this.boardToolbar != null && this.boardToolbar.overlayOpen()) {
            return this.boardToolbar.plateKeyPressed(keyCode);
        }
        if (this.addTile != null && this.addTile.plateFocused) {
            return this.addTile.plateKeyPressed(keyCode);
        }
        return false;
    }

    @Override
    public boolean keyReleased(int keyCode) {
        return this.keyReleased(keyCode, 0);
    }

    public boolean keyReleased(int keyCode, int mods) {
        for (Component part : this.children) {
            for (Component child : part.children) {
                if (!child.focused) continue;
                return part.keyReleased(keyCode);
            }
        }
        if (this.boardToolbar == null || !this.boardToolbar.overlayOpen()) {
            AddTileBox tile = this.addTile;
            if (tile != null && tile.plateFocused && (tile.keyFilter == null || tile.acceptsKey(keyCode))) {
                return tile.insertTextChar(keyCode);
            }
            return false;
        }
        if (this.boardToolbar.keyFilter == null || this.boardToolbar.acceptsKey(keyCode)) {
            return this.boardToolbar.insertTextChar(keyCode);
        }
        return false;
    }

    @Override
    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float headerHeight() {
        return 0.0f;
    }

    @Override
    public void dispose() {
        this.layoutCallback = null;
        this.layoutListener = null;
        this.rows.clear();
        if (this.boardToolbar != null) {
            this.boardToolbar.dispose();
        }
        if (this.addTile != null) {
            this.addTile.dispose();
        }
        super.dispose();
    }

    public static class Anim {
        public float from;
        public float current;
        public float target;
        public float duration;
        public int ease;
        public long start;
        public boolean running;

        public Anim(float value, float duration, int ease) {
            this.from = value;
            this.current = value;
            this.target = value;
            this.duration = duration;
            this.ease = ease;
            this.start = System.nanoTime();
            this.running = false;
        }

        public void setTarget(float value, long now) {
            if (this.target == value) {
                return;
            }
            this.advance(now);
            this.from = this.current;
            this.target = value;
            this.start = now;
            this.running = true;
        }

        public void advance(long now) {
            if (!this.running || this.duration <= 0.0f) {
                this.current = this.target;
                this.running = false;
                return;
            }
            float t = (float)((double)(now - this.start) / 1.0E9) / this.duration;
            if (t <= 0.0f) {
                this.current = this.from;
                return;
            }
            if (t >= 1.0f) {
                this.running = false;
                this.current = this.target;
                return;
            }
            this.current = AbstractCollectionPart.easeValue(this.ease, t) * (this.target - this.from) + this.from;
        }

        public float value() {
            return this.current;
        }
    }

    public static class AddTileBox
    extends Component {
        public Consumer<String> onSubmitText;
        public Runnable onSubmitEmpty;
        public Component cursor;
        public Component inputField;
        public Component keyFilter;
        public boolean plateFocused;
        public boolean overlayOpen;
        public String text = "";
        public float hover;
        public float plateX;
        public float plateY;
        public float plateWidth;
        public float plateHeight;
        public final AbstractCollectionPart.Anim focusAnim = new AbstractCollectionPart.Anim(0.0f, 0.28f, 2);

        public boolean plateRectHit(double mx, double my) {
            return mx >= (double)this.plateX && mx <= (double)(this.plateX + this.plateWidth) && my >= (double)this.plateY && my <= (double)(this.plateY + this.plateHeight);
        }

        public boolean hasText() {
            return this.plateHasText();
        }

        public void setText(String value) {
            this.text = value;
        }

        public boolean plateClicked(double mx, double my, int button) {
            if (button != 0) {
                return false;
            }
            boolean inside = mx >= (double)this.x && mx <= (double)(this.x + this.width) && my >= (double)this.y && my <= (double)(this.y + this.height);
            this.setHover(inside ? 1.0f : 0.0f);
            return inside;
        }

        public void setHover(float value) {
            this.hover = value;
        }

        public boolean plateHasText() {
            return this.trimmed().length() != 0;
        }

        public String trimmed() {
            int start;
            int end = this.text.length();
            for (start = 0; start < end && this.text.charAt(start) <= ' '; ++start) {
            }
            while (end > start && this.text.charAt(end - 1) <= ' ') {
                --end;
            }
            return this.text.substring(start, end);
        }

        public boolean plateCommit() {
            String value = this.trimmed();
            if (value.length() == 0) {
                return false;
            }
            if (this.onSubmitText != null) {
                this.onSubmitText.accept(value);
            }
            this.clearText();
            if (this.plateFocused) {
                this.plateFocused = false;
                this.focusAnim.setTarget(0.0f, this.now());
                this.notifyTextFocusChanged();
            }
            return true;
        }

        public void clearText() {
            this.text = "";
        }

        public boolean plateKeyPressed(int keyCode) {
            if (!this.plateFocused) {
                return false;
            }
            if (keyCode == 27) {
                this.plateFocused = false;
                this.focusAnim.setTarget(0.0f, this.now());
                this.notifyTextFocusChanged();
                return true;
            }
            if (keyCode == 13) {
                this.plateCommit();
                return true;
            }
            return this.insertTextChar(keyCode);
        }

        public boolean insertTextChar(int keyCode) {
            if (keyCode < 32 || keyCode == 127) {
                return false;
            }
            this.text = this.text + (char)keyCode;
            return true;
        }

        public void notifyTextFocusChanged() {
        }

        public boolean acceptsKey(int keyCode) {
            return this.keyFilter == null;
        }
    }

    public static interface LayoutListener {
        public void acceptInt(int var1);
    }

    public static enum BoardLayout {
        CARD,
        LIST,
        BOARD;

    }

    public static class LayoutCallback
    implements Runnable {
        private final AbstractCollectionPart owner;
        private final int layout;

        public LayoutCallback(AbstractCollectionPart owner, int layout) {
            this.owner = owner;
            this.layout = layout;
        }

        @Override
        public void run() {
            if (this.owner != null) {
                this.owner.boardLayout = this.layout;
                this.owner.layoutDirty = true;
            }
        }
    }
}

