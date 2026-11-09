/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.Component;
import client.gui.Screen;

public class SearchRow
extends Component {
    protected float titleRight;
    public static final int VTABLE_RVA = 12602088;
    public static final long RVA_CTOR = 107552L;
    public static final long RVA_DTOR = 108272L;
    public static final long RVA_DELETING_DTOR = 92864L;
    public static final long RVA_RENDER = 110384L;
    public static final long RVA_MOUSE = 112800L;
    public static final long RVA_STATE_A = 113024L;
    public static final long RVA_STATE_B = 113072L;
    public static final long RVA_STATE_C = 113152L;
    public static final long RVA_STATE_D = 113200L;
    public static final long RVA_CONTROLS_RENDER = 111712L;
    public static final long RVA_TITLE_RENDER = 110896L;
    public static final int OFF_MODE = 96;
    public static final int OFF_FEATURE = 104;
    public static final int OFF_CRUMBS = 112;
    public static final int OFF_CRUMBS_END = 120;
    public static final int OFF_CRUMBS_CAP = 128;
    public static final int OFF_SPANS = 136;
    public static final int OFF_SPANS_END = 144;
    public static final int OFF_SPANS_CAP = 152;
    public static final int OFF_CONTROLS = 160;
    public static final int OFF_SELECTED = 168;
    public static final int OFF_HOVER_ANIM = 176;
    public static final int OFF_CONTROLS_SELECTED_FIELD = 592;
    public static final int OFF_CONTROLS_ALPHA_FIELD = 664;
    public static final float ROW_WIDTH = 484.0f;
    public static final float ROW_HEIGHT = 36.0f;
    public static final float HOVER_DURATION = 0.15f;
    public static final float PAD_4 = 4.0f;
    public static final float PAD_6 = 6.0f;
    public static final float PAD_7 = 7.0f;
    public static final float PAD_8 = 8.0f;
    public static final float PAD_12 = 12.0f;
    public static final float PAD_14 = 14.0f;
    public static final float PAD_16 = 16.0f;
    public static final float PAD_20 = 20.0f;
    public static final float PAD_22 = 22.0f;
    public static final float PAD_24 = 24.0f;
    public static final float PAD_28 = 28.0f;
    public static final float PAD_46 = 46.0f;
    public static final float HALF = 0.5f;
    public static final float ONE = 1.0f;
    public static final int ICON_TITLE = 75;
    public static int interactivityTick;
    public static boolean suppressHover;
    protected int mode;
    protected Object feature;
    protected Crumb[] crumbs = new Crumb[0];
    protected Span[] spans = new Span[0];
    protected Controls controls;
    protected boolean selected;
    protected final Component.Anim revealAnim = new Component.Anim();

    public SearchRow(int mode, float x, float y, float width, float height, Object feature) {
        this(mode, feature);
    }

    public SearchRow(int mode, Object feature) {
        this.flags = 256;
        this.x = 0.0f;
        this.y = 0.0f;
        this.width = 0.0f;
        this.height = 0.0f;
        this.resetRectAnimator();
        this.animXFrom = 0.0f;
        this.animYFrom = 0.0f;
        this.animatingPosition = false;
        this.mode = mode;
        this.feature = feature;
        this.crumbs = new Crumb[0];
        this.spans = new Span[0];
        this.controls = null;
        this.selected = false;
        this.revealAnim.set(0.0f, 0.15f);
        this.width = 484.0f;
        this.height = 36.0f;
        if (this.feature != null) {
            Controls built = new Controls(this.hasFeatureFlag18(this.feature) ? this.featureAt18(this.feature) : null);
            this.setControlsRenderValue(built, 288, this.readByte(this.feature, 119));
            this.setControlsFlag(built, 496, this.isPartyMember(this.feature));
            this.writeByte(built, 593, true);
            this.bindControlsAction(built, 496, 1);
            this.bindControlsAction(built, 288, 2);
            this.controls = built;
        }
    }

    @Override
    public void dispose() {
        if (this.controls != null) {
            this.releaseControls(this.controls);
            this.controls = null;
        }
        this.destroySpanList(this.spans);
        this.destroyCrumbList(this.crumbs);
        this.spans = new Span[0];
        this.crumbs = new Crumb[0];
        if (Screen.focusedWidget == this) {
            Screen.focusedWidget = null;
        }
        super.dispose();
    }

    @Override
    public void render(Object renderer, float px, float py, float alpha) {
        if (px < this.x || this.x + this.width < px || py < this.y || this.y + this.height < py) {
            this.setHoverFlag(false);
        } else {
            this.setHoverFlag(true);
            Screen.hoveredWidget = 1;
        }
        float target = 1.0f;
        if (!this.selected) {
            target = 0.0f;
        }
        if (this.revealAnim.target != target) {
            long time = this.now();
            float current = this.advanceAnim(this.revealAnim, time);
            this.revealAnim.start = time;
            this.revealAnim.from = current;
            this.revealAnim.target = target;
            this.revealAnim.running = true;
        }
        float value = this.advanceAnim(this.revealAnim, this.now());
        float faded = (value * 0.5f + 0.5f) * alpha;
        SearchRow.drawIcon(renderer, this.mode, this.x + 12.0f, (this.height - 16.0f) * 0.5f + this.y, 16.0f, 16.0f, SearchRow.themeColor(6), faded);
        float limit = this.controls == null ? this.width + this.x - 12.0f : this.renderControls(this, renderer, px, py, faded) - 8.0f;
        this.renderTitle(this, renderer, limit, faded);
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (this.controls == null) {
            return false;
        }
        if (!this.isFeatureEnabled(this.feature) || suppressHover) {
            if (this.readByte(this.controls, 104)) {
                return this.controlsClick(this.controls, mx, my, button);
            }
            if (this.controlsClick(this.controls, mx, my, button)) {
                return true;
            }
            if (this.controlsClickAt(this.controls, 288, mx, my, button)) {
                return true;
            }
            int count = this.featureLimit(this.feature);
            if (count <= interactivityTick && this.controlsClickAt(this.controls, 496, mx, my, button)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean mouseReleased(double mx, double my, int button) {
        return this.controls != null && this.controlsStateA(this.controls, 496);
    }

    @Override
    public boolean mouseMoved(double mx, double my, double delta) {
        return this.controls != null && this.controlsStateB(this.controls, 496);
    }

    @Override
    public boolean keyPressed(int keyCode, int modifiers) {
        return this.controls != null && this.readByte(this.controls, 104) && this.controlsKeyA(this.controls);
    }

    @Override
    public boolean keyReleased(int keyCode) {
        return this.controls != null && this.readByte(this.controls, 104) && this.controlsKeyB(this.controls);
    }

    protected void setHoverFlag(boolean value) {
        this.flags = this.flags & 0xFF00 | (value ? 1 : 0);
    }

    protected void renderTitle(SearchRow self, Object renderer, float limit, float alpha) {
        float start = self.x + 12.0f + 16.0f + 6.0f;
        if (start < limit) {
            float midY = self.height * 0.5f + self.y;
            float halfAlpha = alpha * 0.5f;
            SearchRow.setScissor(start, self.y, limit - start, 0.0f);
            float cursor = 14.0f;
            for (int i = 0; i < self.crumbs.length && !(limit <= cursor); ++i) {
                float textAlpha;
                Crumb crumb = self.crumbs[i];
                if (i != 0) {
                    SearchRow.drawIcon(renderer, 11, cursor, midY - 7.0f, 14.0f, 14.0f, SearchRow.themeColor(4), halfAlpha);
                    cursor += 20.0f;
                    textAlpha = 12.0f;
                } else {
                    textAlpha = 14.0f;
                }
                for (int j = 0; j < crumb.spans.length; ++j) {
                    Span span = crumb.spans[j];
                    int color = SearchRow.themeColor(i == 0 || span.strong ? 6 : 4);
                    float spanAlpha = i == 0 || span.strong ? alpha : halfAlpha;
                    SearchRow.drawSpan(renderer, span, cursor + span.offset, midY - textAlpha * 0.5f, textAlpha, color, spanAlpha);
                }
                cursor = cursor + crumb.width + 6.0f;
            }
            SearchRow.resetScissor();
        }
    }

    protected float renderControls(SearchRow self, Object renderer, float px, float py, float alpha) {
        Controls c = self.controls;
        boolean party = this.isPartyMember(self.feature);
        if (this.readByte(c, 592) != party) {
            this.writeByte(c, 592, party);
            this.writeFloat(c, 664, party ? 1.0f : 0.0f);
        }
        this.writeByte(c, 384, this.readByte(self.feature, 119));
        float midY = self.height * 0.5f + self.y;
        float right = self.width + self.x - 12.0f;
        boolean enabled = this.isFeatureEnabled(self.feature);
        if (!enabled || suppressHover) {
            float extra;
            float iconX = right - 28.0f;
            float controlY = midY - 6.0f;
            float controlX = midY - 8.0f;
            float titleRight = iconX - 4.0f;
            this.writeFloat(c, 504, iconX);
            this.writeFloat(c, 300, controlY);
            this.writeFloat(c, 508, controlX);
            this.writeFloat(c, 296, titleRight - 12.0f);
            if (this.readPointer(c, 96) == null) {
                extra = 0.0f;
            } else {
                this.controlsMeasure(c);
                extra = this.readFloat(c, 224) + 22.0f + 8.0f + 8.0f;
                if (extra <= 46.0f) {
                    extra = 46.0f;
                }
            }
            float value = titleRight - 4.0f;
            this.writeFloat(c, 16, extra);
            float titleLeft = value - extra;
            this.writeFloat(c, 12, midY - 12.0f);
            this.writeFloat(c, 8, titleLeft);
            int count = this.featureLimit(self.feature);
            if (interactivityTick < count) {
                SearchRow.drawIcon(renderer, 56, iconX += 6.0f, controlX, 16.0f, 16.0f, SearchRow.themeColor(4), alpha);
                if (iconX <= px && px <= iconX + 16.0f && controlX <= py && py <= controlX + 16.0f) {
                    Screen.hoveredWidget = 7;
                }
            } else {
                this.controlsRenderMain(c, 496, renderer, px, py, alpha);
            }
            this.controlsRenderSub(c, 288, renderer, px, py, alpha);
            this.controlsRenderBody(c, renderer, px, py, alpha);
            if (this.isFeatureEnabled(self.feature)) {
                if (extra > 0.0f) {
                    titleLeft -= 4.0f;
                }
                float[] metrics = this.iconMetrics(75);
                SearchRow.drawIcon(renderer, 75, titleLeft -= metrics[0] + 16.0f, midY - 12.0f, alpha);
            }
        } else {
            float labelWidth = this.controlWidth(self);
            float control = this.titleRight - labelWidth;
            float controlY = midY - 12.0f;
            this.drawControlLabel(renderer, control, controlY, alpha);
            float measured = this.controlWidth(self);
            if (control <= px && px <= measured + control && controlY <= py && py <= controlY + 24.0f) {
                Screen.hoveredWidget = 7;
            }
            return control;
        }
        return this.titleRight;
    }

    protected float controlWidth(SearchRow self) {
        return 0.0f;
    }

    protected void drawControlLabel(Object renderer, float x, float y, float alpha) {
    }

    protected boolean isFeatureEnabled(Object feature) {
        return false;
    }

    protected boolean isPartyMember(Object feature) {
        return false;
    }

    protected Object featureAt18(Object feature) {
        return null;
    }

    protected boolean hasFeatureFlag18(Object feature) {
        return false;
    }

    protected int featureLimit(Object feature) {
        return 0;
    }

    protected boolean controlsClick(Object controls, double mx, double my, int button) {
        return false;
    }

    protected boolean controlsClickAt(Object controls, int offset, double mx, double my, int button) {
        return false;
    }

    protected boolean controlsStateA(Object controls, int offset) {
        return false;
    }

    protected boolean controlsStateB(Object controls, int offset) {
        return false;
    }

    protected boolean controlsKeyA(Object controls) {
        return false;
    }

    protected boolean controlsKeyB(Object controls) {
        return false;
    }

    protected void controlsMeasure(Object controls) {
    }

    protected void controlsRenderMain(Object controls, int offset, Object renderer, float px, float py, float alpha) {
    }

    protected void controlsRenderSub(Object controls, int offset, Object renderer, float px, float py, float alpha) {
    }

    protected void controlsRenderBody(Object controls, Object renderer, float px, float py, float alpha) {
    }

    protected void bindControlsAction(Object controls, int offset, int index) {
    }

    protected void setControlsRenderValue(Object controls, int offset, Object value) {
    }

    protected void setControlsFlag(Object controls, int offset, boolean value) {
    }

    protected void releaseControls(Object controls) {
    }

    protected void destroyCrumbList(Crumb[] list) {
    }

    protected void destroySpanList(Span[] list) {
    }

    protected Object readPointer(Object target, int offset) {
        return null;
    }

    protected float readFloat(Object target, int offset) {
        return 0.0f;
    }

    protected void writeFloat(Object target, int offset, float value) {
    }

    protected void writeByte(Object target, int offset, boolean value) {
    }

    protected boolean readByte(Object target, int offset) {
        return false;
    }

    protected float[] iconMetrics(int icon) {
        return new float[2];
    }

    protected float advanceAnim(Component.Anim anim, long time) {
        anim.update(time);
        return anim.current;
    }

    protected void resetRectAnimator() {
        this.animStart = this.now();
        this.animDuration = 0.15f;
    }

    private static void drawIcon(Object renderer, int icon, float x, float y, float w, float h, int color, float alpha) {
    }

    private static void drawIcon(Object renderer, int icon, float x, float y, float alpha) {
    }

    private static void drawSpan(Object renderer, Span span, float x, float y, float size, int color, float alpha) {
    }

    private static void setScissor(float x, float y, float w, float h) {
    }

    private static void resetScissor() {
    }

    private static int themeColor(int index) {
        return 0;
    }

    public static final class Crumb {
        public String text = "";
        public Span[] spans = new Span[0];
        public float width;
    }

    public static final class Span {
        public String text = "";
        public float offset;
        public boolean strong;
    }

    public static final class Controls {
        public static final int OFF_STATE = 104;
        public static final int OFF_MID = 288;
        public static final int OFF_MAIN = 496;
        public Object source;
        public boolean selected;

        public Controls(Object source) {
            this.source = source;
        }
    }
}

