/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import java.util.ArrayList;
import java.util.List;

public class Component {
    public static final long VTABLE_RVA = 12582824L;
    public static final int OFF_VTABLE = 0;
    public static final int OFF_X = 8;
    public static final int OFF_Y = 12;
    public static final int OFF_WIDTH = 16;
    public static final int OFF_HEIGHT = 20;
    public static final int OFF_FLAGS = 24;
    public static final int OFF_RECT_ANIM = 32;
    public static final int OFF_ANIM_X = 72;
    public static final int OFF_ANIM_Y = 80;
    public static final int OFF_ANIMATING = 88;
    public static final int OFF_ALPHA_ANIM = 96;
    public static final int OFF_SCROLL = 136;
    public static final int OFF_SCROLL_LIMIT = 140;
    public static final int OFF_CHILDREN = 144;
    public static final int OFF_CHILDREN_END = 152;
    public static final int OFF_MOUSE_OWNED = 168;
    public static final int OFF_FOCUSED = 216;
    public static final int OFF_LAST_INPUT = 224;
    public static final int OFF_CAPTURE = 416;
    public static final int FLAG_DEFAULT = 256;
    public static final long NANOS_PER_SECOND = 1000000000L;
    public static final long NANOS_PER_MILLI = 1000000L;
    public static final int ANIM_FROM = 0;
    public static final int ANIM_CURRENT = 4;
    public static final int ANIM_TARGET = 8;
    public static final int ANIM_DURATION = 12;
    public static final int ANIM_EASING = 16;
    public static final int ANIM_START = 24;
    public static final int ANIM_RUNNING = 32;
    protected float x;
    protected float y;
    protected float width;
    protected float height;
    protected int flags = 256;
    protected Component parent;
    protected final List<Component> children = new ArrayList<Component>();
    protected float animFrom;
    protected float alpha;
    protected float alphaTarget;
    protected float alphaDuration;
    protected long alphaStart;
    protected boolean alphaRunning;
    protected float animXFrom;
    protected float animXCurrent;
    protected float animXTarget;
    protected float animYFrom;
    protected float animYCurrent;
    protected float animYTarget;
    protected long animStart;
    protected float animDuration;
    protected boolean animatingPosition;
    protected float scroll;
    protected float scrollLimit;
    protected boolean mouseOwned;
    protected boolean focused;
    protected long lastInputTime;
    protected Component capture;
    protected boolean hovered;
    protected final Anim hoverAnim = new Anim();
    public static Component hoveredComponent;
    public static boolean cursorSuppressed;
    public static int cursorStyle;
    public static float mouseX;
    public static float mouseY;
    public static final long RVA_DTOR = 2735200779264L;
    public static final long RVA_SET_POSITION = 2735200779184L;
    public static final long RVA_HOVER_TEST = 2735200779424L;
    public static final long RVA_DEFAULT_VIRTUAL = 2735199916496L;
    public static final long RVA_ANIM_ADVANCE = 2735200831600L;
    public static final long RVA_ANIM_CTOR = 2735200856400L;
    public static final long RVA_ANIM_CTOR_EASE = 2735200778960L;
    public static final long RVA_EASE_OUT_CUBIC = 2735200259888L;
    public static final long RVA_EASE_IN_CUBIC = 2735200781008L;
    public static final long RVA_LERP_COLOR = 2735200832496L;
    public static final long RVA_PLAY_SOUND = 2735199719200L;
    public static final long RVA_ICON_METRICS = 2735199818160L;
    public static final long RVA_DRAW_ICON = 2735203174176L;
    public static final long RVA_DRAW_BOX = 2735203170096L;
    public static final long RVA_THEME = 2735203198032L;
    public static final long RVA_NOW = 2735199714128L;
    public static final long RVA_FREE = 2735203701616L;
    public static final int ICON_INVALID = 89;

    protected long now() {
        return System.nanoTime();
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }

    public int getFlags() {
        return this.flags;
    }

    public Component getParent() {
        return this.parent;
    }

    public List<Component> getChildren() {
        return this.children;
    }

    public boolean isVisible() {
        return (this.flags & 0x100) != 0;
    }

    public void setVisible(boolean value) {
        this.flags = value ? (this.flags |= 0x100) : (this.flags &= 0xFFFFFEFF);
    }

    public void add(Component child) {
        if (child == null) {
            return;
        }
        child.parent = this;
        this.children.add(child);
    }

    public void remove(Component child) {
        if (child == null) {
            return;
        }
        this.children.remove(child);
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setSize(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public boolean contains(double mx, double my) {
        return mx >= (double)this.x && mx <= (double)(this.x + this.width) && my >= (double)this.y && my <= (double)(this.y + this.height);
    }

    public float getAlpha() {
        return this.alpha;
    }

    public void setAlpha(float value) {
        this.alpha = value;
    }

    public void animateAlpha(float target, float duration) {
        if (this.alphaTarget == target) {
            return;
        }
        this.animFrom = this.alpha;
        this.alphaStart = this.now();
        this.alphaTarget = target;
        this.alphaDuration = duration;
        this.alphaRunning = true;
    }

    public void updateAlpha(long time) {
        if (!this.alphaRunning || this.alphaDuration <= 0.0f) {
            this.alpha = this.alphaTarget;
            this.alphaRunning = false;
            return;
        }
        float t = (float)((double)(time - this.alphaStart) / 1.0E9) / this.alphaDuration;
        if (t <= 0.0f) {
            this.alpha = this.animFrom;
            return;
        }
        if (t >= 1.0f) {
            this.alphaRunning = false;
            this.alpha = this.alphaTarget;
            return;
        }
        this.alpha = Component.easeOutCubic(t) * (this.alphaTarget - this.animFrom) + this.animFrom;
    }

    public void updatePositionAnimation(long time) {
        float t;
        if (this.animatingPosition && this.animXCurrent != this.animXTarget) {
            t = (float)((double)(time - this.animStart) / 1.0E9) / this.animDuration;
            if (t <= 0.0f) {
                this.animXCurrent = this.animXFrom;
            } else if (t >= 1.0f) {
                this.animatingPosition = false;
                this.animXCurrent = this.animXTarget;
            } else {
                this.animXCurrent = Component.easeOutCubic(t) * (this.animXTarget - this.animXFrom) + this.animXFrom;
            }
        }
        if (this.animatingPosition && this.animYCurrent != this.animYTarget) {
            t = (float)((double)(time - this.animStart) / 1.0E9) / this.animDuration;
            if (t <= 0.0f) {
                this.animYCurrent = this.animYFrom;
            } else if (t >= 1.0f) {
                this.animatingPosition = false;
                this.animYCurrent = this.animYTarget;
            } else {
                this.animYCurrent = Component.easeOutCubic(t) * (this.animYTarget - this.animYFrom) + this.animYFrom;
            }
        }
    }

    public static float easeOutCubic(float t) {
        float inv = 1.0f - t;
        return 1.0f - inv * inv * inv;
    }

    public static float easeInCubic(float t) {
        return t * t * t;
    }

    public float uiHoverTest(float mx, float my) {
        float target;
        boolean outside;
        boolean bl = outside = mx < this.x || this.x + this.width < mx || my < this.y || this.y + this.height < my || hoveredComponent != null && !cursorSuppressed;
        if (outside) {
            this.hovered = false;
            target = 0.0f;
        } else {
            this.hovered = true;
            target = 1.0f;
        }
        long time = this.now();
        this.hoverAnim.retarget(target, time);
        this.hoverAnim.update(time);
        return this.hoverAnim.current;
    }

    public boolean hitTest(double mx, double my) {
        return mx >= (double)this.x && mx <= (double)(this.x + this.width) && my >= (double)this.y && my <= (double)(this.y + this.height);
    }

    public boolean hitTest(double mx, double my, float inset) {
        float hx = (this.width - inset) * 0.5f + this.x;
        float hy = (this.height - inset) * 0.5f + this.y;
        return (double)hx <= mx && mx <= (double)(hx + inset) && (double)hy <= my && my <= (double)(hy + inset);
    }

    public static int uiThemeColor(int index) {
        return Component.uiThemeColor(Component.uiTheme(), index);
    }

    public static int uiThemeColor(Object theme, int offset) {
        return 0;
    }

    public static Object uiTheme() {
        return null;
    }

    public static void uiSound(int id) {
    }

    public static int uiLerpColor(int from, int to, float t) {
        if (t <= 0.0f) {
            return from;
        }
        if (t >= 1.0f) {
            return to;
        }
        int out = 0;
        for (int shift = 0; shift < 32; shift += 8) {
            float a = from >>> shift & 0xFF;
            float b = to >>> shift & 0xFF;
            int v = (int)((b - a) * t + a);
            out |= v << shift;
        }
        return out;
    }

    public static float[] uiIconMetrics(int icon) {
        return new float[2];
    }

    public static void uiDrawIcon(Object renderer, int icon, float x, float y, float w, float h, int color, float alpha) {
    }

    public static void uiDrawBox(Object renderer, float x, float y, float w, float h, float radiusTL, float radiusTR, float radiusBR, float radiusBL, int fillTop, int fillBottom, float fillAlpha, int borderColor, float borderWidth, float borderAlpha, float shadowAlpha, float alpha, int flags) {
    }

    public static void uiDrawBox(Object renderer, float x, float y, float w, float h, int color, float alpha) {
        Component.uiDrawBox(renderer, x, y, w, h, 0.0f, 0.0f, 0.0f, 0.0f, color, color, 1.0f, 0, 0.0f, 1.0f, 0.0f, alpha, 0);
    }

    public static void uiDrawBox(Object renderer, float x, float y, float w, float h, float radius, int color, float alpha) {
        Component.uiDrawBox(renderer, x, y, w, h, radius, radius, radius, radius, color, color, 1.0f, 0, 0.0f, 1.0f, 0.0f, alpha, 0);
    }

    public void tick() {
    }

    public boolean isActive() {
        return false;
    }

    public boolean onClick() {
        return true;
    }

    public void render() {
    }

    public void render(Object renderer, float px, float py, float alpha) {
        this.render();
    }

    public void render(Object renderer, float px, float py) {
        this.render(renderer, px, py, 1.0f);
    }

    public boolean mouseDragged(double mx, double my, int button) {
        return false;
    }

    public float preferredWidth() {
        return this.width;
    }

    public float preferredHeight() {
        return this.height;
    }

    public void syncRows() {
    }

    public boolean mouseClicked(double mx, double my, int button) {
        return false;
    }

    public boolean mouseReleased(double mx, double my, int button) {
        return false;
    }

    public boolean mouseMoved(double mx, double my, double delta) {
        return false;
    }

    public boolean mouseScrolled(double mx, double my, double amount) {
        return false;
    }

    public boolean keyPressed(int keyCode, int modifiers) {
        return false;
    }

    public boolean keyReleased(int keyCode) {
        return false;
    }

    public boolean charTyped(char ch) {
        return false;
    }

    public void dispose() {
        this.children.clear();
        this.capture = null;
    }

    public static class Anim {
        public float from;
        public float current;
        public float target;
        public float duration;
        public long start;
        public boolean running;

        public Anim() {
        }

        public Anim(float value, float duration) {
            this.from = value;
            this.current = value;
            this.target = value;
            this.duration = duration;
        }

        public void set(float value, float duration) {
            this.from = value;
            this.current = value;
            this.target = value;
            this.duration = duration;
            this.start = System.nanoTime();
            this.running = false;
        }

        public void retarget(float target, long time) {
            if (this.target == target) {
                return;
            }
            this.from = this.current;
            this.start = time;
            this.target = target;
            this.running = true;
        }

        public void update(long time) {
            if (!this.running || this.duration <= 0.0f) {
                this.current = this.target;
                this.running = false;
                return;
            }
            float t = (float)((double)(time - this.start) / 1.0E9) / this.duration;
            if (t <= 0.0f) {
                this.current = this.from;
                return;
            }
            if (t >= 1.0f) {
                this.running = false;
                this.current = this.target;
                return;
            }
            this.current = Component.easeOutCubic(t) * (this.target - this.from) + this.from;
        }
    }
}

