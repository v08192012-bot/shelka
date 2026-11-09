/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.Component;
import client.gui.Screen;

public class ScrollablePart
extends Component {
    public static final int VTABLE_RVA = 12586152;
    public static final int X_OFFSET = 8;
    public static final int Y_OFFSET = 12;
    public static final int WIDTH_OFFSET = 16;
    public static final int HEIGHT_OFFSET = 20;
    public static final int FLAGS_OFFSET = 24;
    public static final int RECT_ANIM_OFFSET = 32;
    public static final int ARENA_A_OFFSET = 72;
    public static final int ARENA_B_OFFSET = 80;
    public static final int STATE_OFFSET = 88;
    public static final int SCROLL_ANIM_OFFSET = 96;
    public static final int SCROLL_OFFSET = 136;
    public static final int SCROLL_LIMIT_OFFSET = 140;
    public static final int HANDLE_OFFSET = 200;
    public static final int TOOLBAR_OFFSET = 208;
    public static final int ADD_TILE_OFFSET = 216;
    public static final int CHILDREN_BEGIN_OFFSET = 224;
    public static final int CHILDREN_END_OFFSET = 232;
    public static final int CHILDREN_CAP_OFFSET = 240;
    public static final int FLAG_F8_OFFSET = 248;
    public static final int VALUE_FC_OFFSET = 252;
    public static final int SCALE_ANIM_OFFSET = 256;
    public static final int FLAG_120_OFFSET = 288;
    public static final int FLAG_128_OFFSET = 296;
    public static final int STATE_168_OFFSET = 360;
    public static final int STATE_170_OFFSET = 368;
    public static final int VALUE_178_OFFSET = 376;
    public static final int FLAG_17C_OFFSET = 380;
    public static final int VALUE_180_OFFSET = 384;
    private static final int EASE_OUT_CUBIC = 0;
    private static final int EASE_OUT_EXPO = 1;
    private static final int EASE_IN_CUBIC = 2;
    public static final float DEFAULT_WIDTH = 965.0f;
    public static final float SCROLL_ANIM_DURATION = 0.28f;
    public static final float RECT_ANIM_DURATION = 0.15f;
    public static final float SCALE_ANIM_DURATION = 0.16f;
    public static final float SCROLL_EDGE_PADDING = 16.0f;
    public static final float SCROLL_STEP = 48.0f;
    public static final int FLAG_VISIBLE = 256;
    protected float x = 0.0f;
    protected float y = 0.0f;
    protected float width = 0.0f;
    protected float height = 0.0f;
    protected int flags = 256;
    protected Anim rectAnim = new Anim(0.0f, 0.15f, 0);
    protected long arenaA = 0L;
    protected long arenaB = 0L;
    protected boolean state58 = false;
    protected Anim scrollAnim = new Anim(0.0f, 0.28f, 1);
    protected float scroll = 0.0f;
    protected float scrollLimit = 0.0f;
    protected long handle = 0L;
    protected Object toolbar;
    protected Object addTile;
    protected long childrenBegin;
    protected long childrenEnd;
    protected long childrenCap;
    protected boolean flagF8;
    protected float valueFC;
    protected Anim scaleAnim = new Anim(1.0f, 0.16f, 2);
    protected boolean flag120;
    protected boolean flag128;
    protected long state168;
    protected long state170;
    protected float value178;
    protected boolean flag17C;
    protected float value180;

    public ScrollablePart(Object toolbar, Object addTile) {
        this.rectAnim = Anim.init(0.0f, 0.15f, 0);
        this.scrollAnim = Anim.init(0.0f, 0.28f, 1);
        this.toolbar = toolbar;
        this.addTile = addTile;
        this.childrenBegin = 0L;
        this.childrenEnd = 0L;
        this.childrenCap = 0L;
        this.flagF8 = false;
        this.valueFC = 0.0f;
        this.scaleAnim = Anim.init(1.0f, 0.16f, 2);
        this.scaleAnim.from = 1.0f;
        this.scaleAnim.current = 1.0f;
        this.scaleAnim.target = 1.0f;
        this.flag120 = false;
        this.flag128 = false;
        this.state168 = 0L;
        this.state170 = 0L;
        this.value178 = 0.0f;
        this.flag17C = false;
        this.value180 = 0.0f;
        this.width = 965.0f;
        this.scaleAnim.easing = 2;
        ScrollablePart.attachBoardLayoutListener(this.toolbar, this);
        ScrollablePart.releaseToolbar(toolbar);
        ScrollablePart.releaseAddTile(addTile);
    }

    @Override
    public void dispose() {
        super.dispose();
        if (Screen.focusedInput == this) {
            Screen.focusedInput = null;
        }
    }

    @Override
    public void render(Object mat, float x, float y, float alpha) {
        super.render();
    }

    public void layout(Object mat, float x, float y, float alpha) {
    }

    public void update() {
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        return false;
    }

    @Override
    public boolean mouseReleased(double mx, double my, int button) {
        return false;
    }

    @Override
    public boolean mouseDragged(double mx, double my, int button) {
        return false;
    }

    @Override
    public boolean mouseScrolled(double mx, double my, double amount) {
        if (mx < (double)this.x || mx > (double)(this.x + this.width)) {
            return false;
        }
        if (my < (double)this.y || my > (double)(this.y + this.height)) {
            return false;
        }
        float limit = this.scrollLimit - this.height + 16.0f;
        float next = this.scroll - (float)amount * 48.0f;
        if (limit <= 0.0f) {
            limit = 0.0f;
        }
        float clamped = next < 0.0f ? 0.0f : next;
        if (next > limit) {
            clamped = limit;
        }
        this.scroll = clamped;
        this.scrollAnim.retarget(this.scroll, this.now());
        return true;
    }

    public boolean keyPressed(int keyCode) {
        return false;
    }

    @Override
    public boolean keyReleased(int keyCode) {
        return false;
    }

    public boolean charTyped(int codePoint) {
        return false;
    }

    @Override
    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    private static void attachBoardLayoutListener(Object toolbar, ScrollablePart self) {
    }

    private static void releaseToolbar(Object toolbar) {
    }

    private static void releaseAddTile(Object addTile) {
    }

    protected static float easeCubicOut(float t) {
        float inv = 1.0f - t;
        return 1.0f - inv * inv * inv;
    }

    protected static float easeCubicIn(float t) {
        return t * t * t;
    }

    protected static float easeExpoOut(float t) {
        if (t >= 1.0f) {
            return 1.0f;
        }
        return 1.0f - (float)Math.exp(t * -6.931472f);
    }

    protected static class Anim {
        public float from;
        public float current;
        public float target;
        public float duration;
        public int easing;
        public long lastTick;
        public boolean animating;

        public Anim() {
        }

        public Anim(float value, float seconds, int easing) {
            this.from = value;
            this.current = value;
            this.target = value;
            this.duration = seconds;
            this.easing = easing;
        }

        public static Anim init(float value, float seconds, int easing) {
            Anim anim = new Anim(value, seconds, easing);
            anim.lastTick = System.nanoTime();
            anim.animating = false;
            return anim;
        }

        public void retarget(float target, long time) {
            if (this.target == target) {
                return;
            }
            this.from = this.advance(time);
            this.lastTick = time;
            this.target = target;
            this.animating = true;
        }

        public float advance(long time) {
            if (!this.animating || this.duration <= 0.0f) {
                this.current = this.target;
                this.animating = false;
                return this.target;
            }
            float k = (float)((double)(time - this.lastTick) / 1.0E9) / this.duration;
            if (k <= 0.0f) {
                this.current = this.from;
                return this.from;
            }
            if (k >= 1.0f) {
                this.animating = false;
                this.current = this.target;
                return this.target;
            }
            this.current = Anim.ease(this.easing, k) * (this.target - this.from) + this.from;
            return this.current;
        }

        private static float ease(int easing, float t) {
            if (easing == 0) {
                return ScrollablePart.easeCubicOut(t);
            }
            if (easing == 2) {
                return ScrollablePart.easeCubicIn(t);
            }
            return ScrollablePart.easeExpoOut(t);
        }
    }
}

