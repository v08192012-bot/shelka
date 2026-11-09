/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.AbstractOverlay;
import java.util.ArrayList;
import java.util.List;

public class ColorModal
extends AbstractOverlay {
    public static final long VTABLE_RVA = 12608712L;
    public static final long RVA_CTOR = 1585008L;
    public static final long RVA_DTOR = 1586288L;
    public static final long RVA_DELETING_DTOR = 1586224L;
    public static final long RVA_SET_CHILD = 1586448L;
    public static final long RVA_SET_CHILD_ALT = 1586592L;
    public static final long RVA_CLOSE = 1586736L;
    public static final long RVA_SYNC_ROWS = 1587200L;
    public static final long RVA_APPLY_COLOR = 1587328L;
    public static final long RVA_RENDER_BODY = 1587536L;
    public static final long RVA_MOUSE_BODY = 1614000L;
    public static final long RVA_MOUSE_RELEASED = 1620000L;
    public static final long RVA_MOUSE_MOVED = 1614656L;
    public static final long RVA_MOUSE_SCROLLED = 1619440L;
    public static final long RVA_KEY_BODY = 1620128L;
    public static final long RVA_HAS_DRAG_PREVIEW = 1620368L;
    public static final long RVA_OPEN_STOP_MODAL = 1618496L;
    public static final long RVA_RESET_DRAG = 1620464L;
    public static final long RVA_LAYOUT = 1621024L;
    public static final long RVA_HEIGHT = 1621744L;
    public static final long RVA_SMOOTH_HSV = 1607312L;
    public static final long RVA_FRAME_DELTA = 1625984L;
    public static final long RVA_PALETTE = 1625840L;
    public static final long RVA_UNPACK_HSV = 55408L;
    public static final long RVA_PACK_RGB = 55680L;
    public static final long RVA_ROW_SYNC = 1590912L;
    public static final long RVA_ROW_HEIGHT_RESET = 1623824L;
    public static final long RVA_CURSOR = 1611792L;
    public static final long RVA_CANCEL_EDIT = 1393056L;
    public static final long RVA_ROW_KEY = 1393536L;
    public static final long RVA_ROW_SCROLL = 1393792L;
    public static final long RVA_ROW_EDIT = 1393296L;
    public static final long RVA_ACTION_FIELD = 374960L;
    public static final long RVA_DRAW_BG = 3483568L;
    public static final long RVA_DRAW_TEXT = 3494400L;
    public static final long RVA_DRAW_STOP = 3491616L;
    public static final long RVA_DRAW_LIST = 3497136L;
    public static final long RVA_ENGINE_STATE = 3515472L;
    public static final int OFF_COLOR_SETTING = 208;
    public static final int OFF_GRADIENT_SETTING = 216;
    public static final int OFF_STOP_FIELD = 224;
    public static final int OFF_SETTING = 448;
    public static final int OFF_PACKED_COLOR = 456;
    public static final int OFF_ALPHA_ENABLED = 464;
    public static final int OFF_SELECTED_STOP = 472;
    public static final int OFF_CHILD = 480;
    public static final int OFF_STOP_NAME = 488;
    public static final int OFF_GRADIENT_READY_ANIM = 520;
    public static final int OFF_ROWS = 560;
    public static final int OFF_ROW_SPACING = 584;
    public static final int OFF_PRESET_PICKED = 592;
    public static final int OFF_HOVER_LOCK = 600;
    public static final int OFF_DRAG_VALUE = 604;
    public static final int OFF_HEIGHT_ANIM = 616;
    public static final int OFF_LAST_HEIGHT = 624;
    public static final int OFF_HEIGHT_READY = 628;
    public static final int OFF_GRADIENT_READY = 632;
    public static final int OFF_VISIBLE_ANIM = 640;
    public static final int OFF_HUE = 680;
    public static final int OFF_SATURATION = 684;
    public static final int OFF_VALUE = 688;
    public static final int OFF_ALPHA = 692;
    public static final int OFF_SQUARE_HOVER = 696;
    public static final int OFF_HUE_HOVER = 697;
    public static final int OFF_ALPHA_HOVER = 698;
    public static final int OFF_DRAG_OFFSET = 700;
    public static final int OFF_SMOOTH_HUE = 704;
    public static final int OFF_SMOOTH_SATURATION = 708;
    public static final int OFF_SMOOTH_VALUE = 712;
    public static final int OFF_SMOOTH_READY = 716;
    public static final int OFF_PRESET_INDEX = 720;
    public static final int OFF_PREVIEW_FIELD_ANIM = 728;
    public static final int OFF_STOP_PICK_ANIM = 768;
    public static final int OFF_COLOR_ANIM = 808;
    public static final int OFF_PICKING = 856;
    public static final int OFF_PICKED_RGB = 860;
    public static final int OFF_SCREEN_PICK_X = 864;
    public static final int OFF_SCREEN_PICK_READY = 872;
    public static final int OFF_LAST_HOVER_STATE = 876;
    public static final int OFF_SQUARE_ACTIVE = 880;
    public static final int OFF_MODE_ANIM = 888;
    public static final int OFF_STOP_ANIM = 928;
    public static final int OFF_STOP_ANIM_DIR = 968;
    public static final int OFF_ACTION_INDEX = 972;
    public static final int OFF_TAB = 976;
    public static final int OFF_ACTION_FIELD = 984;
    public static final int OFF_ACTION_FIELD_STEP = 1016;
    public static final int OFF_TAB_BASELINE = 1020;
    public static final int OFF_HEADER_HOVER = 1021;
    public static final int OFF_FIELD_BLINK = 1022;
    public static final int OFF_DROPDOWN = 1024;
    public static final int OFF_DROPDOWN_ANIM = 1128;
    public static final int OFF_LIST_ANIM = 1192;
    public static final int OFF_LIST_FLAG = 1200;
    public static final int OFF_LIST_SCROLL = 1208;
    public static final int OFF_CHILD_BUTTON = 1272;
    public static final int OFF_CALLBACK = 1280;
    public static final int OFF_TAB_CALLBACK = 1344;
    public static final int OFF_TAB_BUTTON = 1400;
    public static final int SETTING_VALUE = 232;
    public static final int SETTING_ALPHA_FLAG = 240;
    public static final int SETTING_CHANGE_CALLBACK = 224;
    public static final int GRADIENT_STOPS_BEGIN = 488;
    public static final int GRADIENT_STOPS_END = 496;
    public static final int GRADIENT_ENABLED = 480;
    public static final int GRADIENT_ALPHA_FLAG = 464;
    public static final int STOP_STRIDE = 12;
    public static final int STOP_OFF_COLOR = 4;
    public static final int STOP_OFF_POSITION = 8;
    public static final float WIDTH = 292.0f;
    public static final float HEIGHT = 383.0f;
    public static final float STOP_FIELD_WIDTH = 267.0f;
    public static final float FIELD_DURATION = 0.15f;
    public static final float COLOR_DURATION = 0.22f;
    public static final float STOP_ANIM_DURATION = 0.18f;
    public static final float STOP_ANIM_START = 1.0f;
    public static final float ACTION_FIELD_STEP = 12.0f;
    public static final float ROW_SPACING_VALUE = 4.0f;
    public static final float ALPHA_MAX = 255.0f;
    public static final float PAD = 16.0f;
    public static final float GAP = 8.0f;
    public static final float INNER = 12.0f;
    public static final float HALF = 0.5f;
    public static final float SQUARE_SIZE = 269.0f;
    public static final float ALPHA_BAR_WIDTH = 269.0f;
    public static final float ALPHA_BAR_HEIGHT = 140.0f;
    public static final float ALPHA_BAR_SLOT = 148.0f;
    public static final float BAR_SPAN = 240.0f;
    public static final float ACTION_BUTTON_SIZE = 18.0f;
    public static final float TEXT_FIELD_WIDTH = 60.0f;
    public static final float BODY_GAP = 10.0f;
    public static final float ERROR_GAP = 4.0f;
    public static final float BAR_THICKNESS = 8.0f;
    public static final float STRIP_WIDTH = 60.0f;
    public static final float STRIP_HEIGHT = 26.0f;
    public static final float STOP_ROW_STEP = 48.0f;
    public static final float STOP_ROW_HEIGHT = 28.0f;
    public static final float LIST_ROW_STEP = 137.0f;
    public static final float LIST_ROW_WIDTH = 150.0f;
    public static final float PRESET_STEP = 46.0f;
    public static final float PRESET_SIZE = 32.0f;
    public static final float PRESET_ROW_OFFSET = 6.0f;
    public static final float PRESET_ROW_HEIGHT = 28.0f;
    public static final float PRESET_ROW_WIDTH = 150.0f;
    public static final float PRESET_TEXT_OFFSET = 240.0f;
    public static final float PRESET_TEXT_ADVANCE = 240.0f;
    public static final float LIST_TEXT_OFFSET = 240.0f;
    public static final float HEADER_OFFSET = 293.0f;
    public static final float HEADER_WIDTH = 150.0f;
    public static final float HEADER_HEIGHT = 155.5f;
    public static final float STOP_TEXT_SIZE = 12.0f;
    public static final float HOVER_EPSILON = 0.001f;
    public static final float ONE = 1.0f;
    public static final float ZERO = 0.0f;
    public static final float SMOOTH_EPSILON = 0.01f;
    public static final float SMOOTH_FACTOR = -6.931472f;
    public static final float SMOOTH_DIVISOR = 0.05f;
    public static final float HEIGHT_SMOOTH_DIVISOR = 0.03f;
    public static final float DISABLED_HEIGHT = 38.0f;
    public static final float ROUND_TRIP = 2.0f;
    public static final String DEFAULT_STOP_NAME = "\u0412\u044b\u0431\u043e\u0440 \u0446\u0432\u0435\u0442\u0430";
    public static final int PALETTE_SIZE = 7;
    protected ColorSetting color;
    protected GradientSetting gradient;
    protected String stopName = "\u0412\u044b\u0431\u043e\u0440 \u0446\u0432\u0435\u0442\u0430";
    protected Object setting;
    protected int packedColor;
    protected boolean alphaEnabled;
    protected int selectedStop;
    protected ColorModal child;
    protected final AbstractOverlay.Animator gradientReadyAnim = new AbstractOverlay.Animator();
    protected final List<Row> rows = new ArrayList<Row>();
    protected float rowSpacing = 4.0f;
    protected int presetPicked = -1;
    protected boolean hoverLock;
    protected int dragStop;
    protected final AbstractOverlay.Animator heightAnim = new AbstractOverlay.Animator();
    protected float lastHeight;
    protected boolean heightReady;
    protected int gradientReady;
    protected final AbstractOverlay.Animator visibleAnim = new AbstractOverlay.Animator();
    protected float hue;
    protected float saturation;
    protected float value;
    protected float alphaValue = 1.0f;
    protected boolean squareHover;
    protected boolean hueHover;
    protected boolean alphaHover;
    protected float dragOffset;
    protected float smoothHue;
    protected float smoothSaturation;
    protected float smoothValue;
    protected float smoothAlpha;
    protected boolean smoothReady;
    protected int presetIndex = -1;
    protected final AbstractOverlay.Animator previewFieldAnim = new AbstractOverlay.Animator();
    protected final AbstractOverlay.Animator stopPickAnim = new AbstractOverlay.Animator();
    protected final AbstractOverlay.ColorAnim colorAnim = new AbstractOverlay.ColorAnim();
    protected boolean picking;
    protected int pickedRgb = -16777216;
    protected float screenPickX;
    protected boolean screenPickReady;
    protected int lastHoverState;
    protected boolean squareActive;
    protected final AbstractOverlay.Animator modeAnim = new AbstractOverlay.Animator();
    protected final AbstractOverlay.Animator stopAnim = new AbstractOverlay.Animator();
    protected int stopAnimDirection = 1;
    protected int actionIndex = -1;
    protected int tab = 0;
    protected String actionField = "";

    public ColorModal(ColorSetting colorSetting, GradientSetting gradientSetting) {
        this.color = colorSetting;
        this.gradient = gradientSetting;
        this.stopName = DEFAULT_STOP_NAME;
        this.selectedStop = 0;
        this.child = null;
        ColorModal.resetAnimator(this.gradientReadyAnim, gradientSetting != null && gradientSetting.enabled ? 1.0f : 0.0f, 0.15f, 2);
        this.rows.clear();
        this.rowSpacing = 4.0f;
        this.presetPicked = -1;
        this.hoverLock = false;
        this.dragStop = 0;
        ColorModal.resetAnimator(this.heightAnim, 0.0f, 0.15f, 0);
        this.lastHeight = 0.0f;
        this.heightReady = false;
        this.gradientReady = 0;
        ColorModal.resetAnimator(this.visibleAnim, 0.0f, 0.15f, 0);
        ColorModal.resetAnimator(this.previewFieldAnim, 0.0f, 0.15f, 0);
        ColorModal.resetAnimator(this.stopPickAnim, 0.0f, 0.15f, 2);
        ColorModal.resetColorAnimator(this.colorAnim, colorSetting == null ? 0 : colorSetting.value | 0xFF000000, 0.22f);
        this.picking = false;
        this.pickedRgb = -16777216;
        this.screenPickX = 0.0f;
        this.screenPickReady = false;
        this.lastHoverState = 0;
        this.squareActive = false;
        ColorModal.resetAnimator(this.modeAnim, 0.0f, 0.15f, 0);
        ColorModal.resetAnimator(this.stopAnim, 1.0f, 0.18f, 2);
        this.stopAnimDirection = 1;
        this.actionIndex = -1;
        this.tab = 0;
        this.actionField = "";
        this.width = 292.0f;
        this.height = 383.0f;
        this.setupRows();
        this.syncRows();
    }

    protected void setupRows() {
    }

    public void closeChild() {
        this.child = null;
        this.selectedStop = 0;
    }

    @Override
    public void syncRows() {
        if (this.color == null) {
            return;
        }
        int packed = this.color.value;
        Hsv hsv = ColorModal.unpackHsv(packed);
        this.hue = hsv.hue;
        this.saturation = hsv.saturation;
        this.value = hsv.value;
        this.alphaValue = (float)(packed >>> 24 & 0xFF) / 255.0f;
    }

    public void applyColor() {
        int alpha;
        if (this.color == null) {
            return;
        }
        int packed = ColorModal.packRgb(this.hue, this.saturation, this.value);
        int out = packed & 0xFFFFFF | (alpha = (int)(ColorModal.clamp01(this.alphaValue) * 255.0f) & 0xFF) << 24;
        if (this.color.value != out) {
            this.color.value = out;
            this.color.notifyChanged();
        }
    }

    public void openStopModal(int stopIndex) {
        if (this.gradient == null) {
            return;
        }
        int found = -1;
        for (int i = 0; i < this.gradient.stops.size(); ++i) {
            if (this.gradient.stops.get((int)i).position != stopIndex) continue;
            found = i;
            break;
        }
        if (found < 0) {
            return;
        }
        this.dragStop = 0;
        int raw = this.gradient.stops.get((int)found).color;
        int packed = raw | 0xFF000000;
        if (this.alphaEnabled) {
            packed = raw;
        }
        if (this.packedColor != packed) {
            this.packedColor = packed;
            if (this.setting != null) {
                ColorModal.notifySettingChanged(this.setting);
            }
        }
        this.selectedStop = stopIndex;
        if (this.child == null) {
            this.child = new ColorModal(null, this.gradient);
            this.child.detached = true;
        }
        ColorModal target = this.child;
        target.stopName = ColorModal.stopLabel(found + 1);
        target.applyStop(this.gradient.stops.get(found));
        if (target.alphaCurrent() <= 0.001f && target.alphaTarget <= 0.001f) {
            target.gradientReadyStep();
        } else {
            target.animateAlphaTo(1.0f);
        }
    }

    protected void applyStop(ColorStop stop) {
    }

    public void gradientReadyStep() {
        this.animateAlphaTo(1.0f);
    }

    private static void notifySettingChanged(Object target) {
    }

    private static String stopLabel(int index) {
        return String.valueOf(index);
    }

    public static Hsv unpackHsv(int packed) {
        return new Hsv(0.0f, 0.0f, 0.0f);
    }

    public static int packRgb(float hue, float saturation, float value) {
        return 0;
    }

    @Override
    public void renderBody(Object target, float rx, float ry, float parentAlpha) {
        float diff;
        long time;
        int ready;
        this.smoothHsv();
        int n = ready = this.gradient != null && this.gradient.enabled ? 1 : 0;
        if (ready != this.gradientReady) {
            float current;
            this.gradientReady = ready;
            this.visibleAnim.from = 0.0f;
            this.visibleAnim.current = 0.0f;
            this.visibleAnim.target = 0.0f;
            this.visibleAnim.running = false;
            time = this.now();
            if (!this.visibleAnim.running || this.visibleAnim.duration <= 0.0f) {
                current = this.visibleAnim.target;
            } else {
                float t = (float)((double)(time - this.visibleAnim.start) / 1.0E9) / this.visibleAnim.duration;
                if (t <= 0.0f) {
                    current = this.visibleAnim.from;
                } else if (t >= 1.0f) {
                    this.visibleAnim.running = false;
                    current = this.visibleAnim.target;
                } else {
                    current = ColorModal.applyEasing(this.visibleAnim.easing, t) * (this.visibleAnim.target - this.visibleAnim.from) + this.visibleAnim.from;
                }
            }
            this.visibleAnim.current = current;
            this.visibleAnim.from = current;
            this.visibleAnim.target = 1.0f;
            this.visibleAnim.start = time;
            this.visibleAnim.running = true;
            if (ready != 1) {
                ColorModal.rowHeightReset(this.rows);
                this.hoverLock = false;
                this.dragStop = 0;
            }
        }
        time = this.now();
        float visible = ColorModal.advance(this.visibleAnim, time);
        float weight = ColorModal.clamp01(parentAlpha);
        float top = (1.0f - weight) * 16.0f + this.y;
        Rect rect = new Rect();
        this.layout(target, rect, top);
        if (ready == 1) {
            ColorModal.syncRowRows(this);
            if (this.selectedStop != 0) {
                boolean exists = false;
                for (int i = 0; i < this.gradient.stops.size(); ++i) {
                    if (this.gradient.stops.get((int)i).position != this.selectedStop) continue;
                    exists = true;
                    break;
                }
                if (!exists) {
                    this.selectedStop = 0;
                    if (this.child != null && (0.001f < this.child.alphaCurrent() || 0.001f < this.child.alphaTarget)) {
                        this.child.close();
                    }
                }
            }
        }
        float targetHeight = this.height(this, rect);
        float coeff = ColorModal.frameDelta();
        if (this.heightReady && Math.abs(diff = targetHeight - this.lastHeight) >= 0.01f) {
            coeff = (float)Math.exp(coeff * -6.931472f / 0.03f);
            targetHeight -= coeff * diff;
        }
        this.lastHeight = targetHeight;
        this.heightReady = true;
        this.height = targetHeight;
        this.renderContent(target, rect, top, targetHeight, visible, parentAlpha, rx, ry, ready);
        if (this.child != null && (0.001f < this.child.alphaCurrent() || 0.001f < this.child.alphaTarget)) {
            this.child.renderOverlay(target, rx, ry, parentAlpha);
        }
    }

    protected void renderContent(Object target, Rect rect, float top, float modalHeight, float visible, float parentAlpha, float rx, float ry, int ready) {
        if (ready == 1) {
            this.renderGradientMode(target, rect, top, modalHeight, visible, parentAlpha, rx, ry);
        } else {
            this.renderSolidMode(target, rect, top, modalHeight, visible, parentAlpha, rx, ry);
        }
        ColorModal.updateCursor(this);
    }

    protected void renderGradientMode(Object target, Rect rect, float top, float modalHeight, float visible, float parentAlpha, float rx, float ry) {
    }

    protected void renderSolidMode(Object target, Rect rect, float top, float modalHeight, float visible, float parentAlpha, float rx, float ry) {
    }

    protected float height(ColorModal modal, Rect rect) {
        if (this.gradient == null) {
            return 383.0f;
        }
        if (!this.gradient.enabled) {
            return 421.0f;
        }
        float extra = 0.0f;
        if (this.selectedStop == 0) {
            return rect.height + extra + 8.0f;
        }
        return rect.height + extra + 8.0f;
    }

    protected void smoothHsv() {
        float step = (float)Math.exp(960.9060668945312);
        if (!this.smoothReady) {
            this.smoothAlpha = this.alphaValue;
            this.smoothValue = this.value;
            this.smoothSaturation = this.saturation;
            this.smoothHue = this.hue;
            this.smoothReady = true;
            return;
        }
        float delta = this.saturation - this.smoothSaturation;
        if (Math.abs(delta) >= 0.01f) {
            this.smoothSaturation = this.saturation - step * delta;
        }
        if (Math.abs(delta = this.value - this.smoothValue) >= 0.01f) {
            this.smoothValue = this.value - step * delta;
        }
        if (Math.abs(delta = this.hue - this.smoothHue) >= 0.01f) {
            this.smoothHue = this.hue - step * delta;
        }
        if (Math.abs(delta = this.alphaValue - this.smoothAlpha) >= 0.01f) {
            this.smoothAlpha = this.alphaValue - step * delta;
        }
    }

    public void layout(Object target, Rect out, float top) {
        out.clear();
        out.set(0.0f, top + 267.0f, 1.0f);
        out.height = this.rectHeight();
    }

    protected float rectHeight() {
        return 0.0f;
    }

    @Override
    public boolean onMouseClicked(double mx, double my, int button) {
        ColorModal node = this;
        do {
            boolean faded;
            ColorModal current = node;
            node = node.child;
            if (node == null) {
                return this.mouseBody(current, mx, my, button);
            }
            boolean bl = faded = node.alphaCurrent() <= 0.001f && node.alphaTarget <= 0.001f;
            if (!faded) continue;
            return this.mouseBody(current, mx, my, button);
        } while (!(mx < (double)node.x || (double)(node.x + node.width) < mx || my < (double)node.y) && !((double)(node.y + node.height) < my));
        this.selectedStop = 0;
        if (0.001f < node.alphaCurrent() || 0.001f < node.alphaTarget) {
            node.close();
        }
        return true;
    }

    protected boolean mouseBody(ColorModal modal, double mx, double my, int button) {
        if (modal.picking) {
            if (button != 1) {
                if (button != 0) {
                    return true;
                }
                int rgb = modal.pickedRgb;
                ColorSetting cs = modal.color;
                int alpha = cs == null || !cs.alphaFlag ? 255 : Math.round(modal.alphaValue * 255.0f);
                int packed = alpha << 24 | rgb & 0xFFFFFF;
                int out = packed | 0xFF000000;
                if (cs != null && cs.alphaFlag) {
                    out = packed;
                }
                if (cs != null && cs.value != out) {
                    cs.value = out;
                    cs.notifyChanged();
                }
                modal.syncRows();
                int index = modal.presetIndex;
                if (index >= 0 && index < 7 && modal.color != null) {
                    ColorModal.setPaletteEntry(index, modal.color.value);
                }
                return true;
            }
            modal.picking = false;
            return true;
        }
        if (modal.squareActive && button == 0 && !modal.hitsSquare(mx, my) && (modal.gradient != null && modal.gradient.enabled || modal.outsideBody(mx, my))) {
            modal.squareActive = false;
            return true;
        }
        return super.mouseClicked(mx, my, button);
    }

    protected boolean hitsSquare(double mx, double my) {
        return false;
    }

    protected boolean outsideBody(double mx, double my) {
        Rect rect = new Rect();
        this.layout(null, rect, this.y);
        return mx < (double)rect.x || (double)(rect.x + 60.0f) < mx || my < (double)rect.y || (double)(rect.y + 26.0f) < my;
    }

    @Override
    public boolean mouseReleased(double mx, double my, int button) {
        ColorModal current = this.topmostVisible();
        if (current.dragStop != 0) {
            current.dragStop = 0;
            return true;
        }
        if (!(current.squareHover || current.alphaHover || current.hueHover)) {
            return false;
        }
        current.hueHover = false;
        current.alphaHover = false;
        current.squareHover = false;
        return true;
    }

    public boolean mouseDragged(double mx, double my) {
        ColorModal current = this.topmostVisible();
        if (current.dragStop == 0) {
            if (current.squareHover) {
                ColorModal.dragSquare(current, mx, my);
                return true;
            }
            if (current.hueHover) {
                ColorModal.dragHue(current, mx);
                return true;
            }
            if (current.alphaHover) {
                ColorModal.dragAlpha(current, mx);
                return true;
            }
            return false;
        }
        if (current.gradient == null) {
            return true;
        }
        for (int i = 0; i < current.gradient.stops.size(); ++i) {
            ColorStop stop = current.gradient.stops.get(i);
            if (stop.position != current.dragStop) continue;
            if (i < 0) break;
            Rect rect = new Rect();
            this.layout(null, rect, current.y);
            float delta = ColorModal.clamp01((float)((mx - (double)current.screenPickX - (double)current.dragOffset) / 269.0));
            ColorModal.moveStop(current.gradient, i, delta);
            return true;
        }
        current.dragStop = 0;
        return true;
    }

    protected static void dragSquare(ColorModal modal, double mx, double my) {
        Rect rect = new Rect();
        modal.layout(null, rect, modal.y);
        float xr = ColorModal.clamp01((float)((mx - (double)rect.slots[2]) / 269.0));
        float yr = ColorModal.clamp01((float)((my - (double)rect.slots[3]) / 140.0));
        modal.saturation = xr;
        modal.value = 1.0f - yr;
        modal.applyColor();
    }

    protected static void dragHue(ColorModal modal, double mx) {
        Rect rect = new Rect();
        modal.layout(null, rect, modal.y);
        modal.hue = ColorModal.clamp01((float)((mx - (double)rect.slots[4]) / 240.0));
        modal.applyColor();
    }

    protected static void dragAlpha(ColorModal modal, double mx) {
        Rect rect = new Rect();
        modal.layout(null, rect, modal.y);
        modal.alphaValue = ColorModal.clamp01((float)((mx - (double)rect.slots[4]) / 240.0));
        modal.applyColor();
    }

    protected static void moveStop(GradientSetting gradient, int index, float delta) {
        gradient.setStopPosition(index, delta);
    }

    protected ColorModal topmostVisible() {
        ColorModal current;
        ColorModal node = this;
        do {
            current = node;
        } while ((node = node.child) != null && (0.001f < node.alphaCurrent() || 0.001f < node.alphaTarget));
        return current;
    }

    public static void setPaletteEntry(int index, int color) {
    }

    public static int paletteEntry(int index) {
        return 0;
    }

    @Override
    public boolean onKeyPressed(int keyCode, int modifiers) {
        if (this.child != null && this.child.keyPressed(keyCode, modifiers)) {
            return true;
        }
        if (this.hoverLock && keyCode == 27) {
            this.hoverLock = false;
            return true;
        }
        if (this.actionFieldActive()) {
            return this.actionFieldKey(keyCode, modifiers);
        }
        if (this.closeOnEscape && keyCode == 27) {
            this.close();
            return true;
        }
        return super.onKeyPressed(keyCode, modifiers);
    }

    protected boolean actionFieldActive() {
        return false;
    }

    protected boolean actionFieldKey(int keyCode, int modifiers) {
        return false;
    }

    @Override
    public boolean mouseMoved(double mx, double my, double delta) {
        float fieldTop;
        float fieldLeft;
        ColorModal current = this.topmostVisible();
        if (delta != 0.0) {
            current.close();
            return true;
        }
        Rect rect = new Rect();
        this.layout(null, rect, current.y);
        float actionRight = current.x + 293.0f - 16.0f - 10.0f - 4.0f;
        if (ColorModal.inRect(mx, my, actionRight, rect.slots[1], 18.0f, 18.0f)) {
            current.picking = true;
            return true;
        }
        if (current.squareActive && current.presetIndexHit(mx, my, rect)) {
            current.squareActive = false;
            return true;
        }
        float stripX = rect.slots[10];
        float stripY = rect.slots[11];
        if (ColorModal.inRect(mx, my, stripX, stripY, 60.0f, 26.0f)) {
            current.picking = false;
            return true;
        }
        float squareX = rect.slots[2];
        float squareY = rect.slots[3];
        if (ColorModal.inRect(mx, my, squareX, squareY, 269.0f, 269.0f)) {
            current.squareHover = true;
            current.hueHover = false;
            current.alphaHover = false;
            ColorModal.dragSquare(current, mx, my);
            return true;
        }
        float barX = rect.slots[4];
        float hueY = squareY + 269.0f + 8.0f;
        if (ColorModal.inRect(mx, my, barX, hueY, 240.0f, 8.0f)) {
            current.squareHover = false;
            current.hueHover = true;
            current.alphaHover = false;
            ColorModal.dragHue(current, mx);
            return true;
        }
        float alphaY = hueY + 8.0f + 8.0f + 8.0f;
        if (ColorModal.inRect(mx, my, barX, alphaY, 240.0f, 8.0f)) {
            current.squareHover = false;
            current.hueHover = false;
            current.alphaHover = true;
            ColorModal.dragAlpha(current, mx);
            return true;
        }
        if (current.squareHover && !ColorModal.inRect(mx, my, squareX, squareY, 269.0f, 269.0f)) {
            current.squareHover = false;
            current.dragStop = 0;
        }
        if (current.actionIndex >= 0) {
            current.cancelEdit();
        }
        if (!ColorModal.inRect(mx, my, fieldLeft = current.x + 16.0f - 8.0f, fieldTop = (rect.slots[8] - 16.0f) * 0.5f + rect.slots[9] - 8.0f, 12.0f, 12.0f)) {
            if (!ColorModal.inRect(mx, my, rect.slots[5], rect.slots[5], 60.0f, 12.0f)) {
                if (!ColorModal.inRect(mx, my, rect.slots[5], rect.slots[5] - 8.0f, 60.0f, 12.0f)) {
                    if (!ColorModal.inRect(mx, my, rect.slots[5], rect.slots[5] - 8.0f, 60.0f, 12.0f)) {
                        return true;
                    }
                    current.alphaHover = true;
                    ColorModal.dragAlpha(current, mx);
                    return true;
                }
                current.hueHover = true;
                ColorModal.dragHue(current, mx);
                return true;
            }
            current.squareHover = true;
            ColorModal.dragSquare(current, mx, my);
            return true;
        }
        current.picking = true;
        return true;
    }

    protected boolean presetIndexHit(double mx, double my, Rect rect) {
        return false;
    }

    private static boolean inRect(double mx, double my, float x, float y, float width, float height) {
        return mx >= (double)x && mx <= (double)(x + width) && my >= (double)y && my <= (double)(y + height);
    }

    public boolean hasDragPreview() {
        ColorModal current = this.topmostVisible();
        if (!current.listFlag()) {
            return false;
        }
        current.cancelEdit();
        return true;
    }

    public boolean listFlag() {
        return false;
    }

    @Override
    public void onClosed() {
        this.resetDrag();
    }

    public void resetDrag() {
        this.squareHover = false;
        this.hueHover = false;
        this.selectedStop = 0;
        this.dragStop = 0;
        this.squareActive = false;
        if (this.child != null && (0.001f < this.child.alphaCurrent() || 0.001f < this.child.alphaTarget)) {
            this.child.close();
        }
        if (this.actionFieldActive()) {
            this.cancelEdit();
        }
    }

    protected void cancelEdit() {
    }

    protected static void updateCursor(ColorModal modal) {
    }

    protected static void syncRowRows(ColorModal modal) {
    }

    protected static void rowHeightReset(List<Row> rows) {
    }

    protected static float frameDelta() {
        return 0.0f;
    }

    public static final class ColorSetting {
        public int value;
        public boolean alphaFlag;

        public void notifyChanged() {
        }
    }

    public static final class GradientSetting {
        public static final long RVA_SET_STOP = 40752576L;
        public boolean enabled;
        public boolean alphaFlag;
        public final List<ColorStop> stops = new ArrayList<ColorStop>();

        public void setStopPosition(int index, float ratio) {
            if (index < 0 || index >= this.stops.size()) {
                return;
            }
            this.stops.get((int)index).color = AbstractOverlay.mixColor(this.stops.get((int)index).color, this.stops.get((int)index).color, ratio);
        }
    }

    public static final class Hsv {
        public final float hue;
        public final float saturation;
        public final float value;

        public Hsv(float hue, float saturation, float value) {
            this.hue = hue;
            this.saturation = saturation;
            this.value = value;
        }
    }

    public static final class ColorStop {
        public String name = "";
        public int color;
        public int position;
    }

    public static final class Rect {
        public static final int SIZE = 88;
        public float x;
        public float y;
        public float width;
        public float height;
        public final float[] slots = new float[21];

        public void clear() {
            this.x = 0.0f;
            this.y = 0.0f;
            this.width = 0.0f;
            this.height = 0.0f;
            for (int i = 0; i < this.slots.length; ++i) {
                this.slots[i] = 0.0f;
            }
        }

        public void set(float sx, float sy, float sw) {
            this.x = sx;
            this.y = sy;
            this.width = sw;
        }
    }

    public static final class Row {
        public static final int OFF_NAME = 8;
        public static final int OFF_PROGRESS = 40;
        public static final int OFF_ANIM = 64;
        public static final int OFF_MARKED = 328;
        public String name = "";
        public float progress;
        public float animFrom;
        public float animCurrent;
        public float animTarget;
        public float animDuration = 0.18f;
        public long animStart;
        public boolean animRunning;
        public boolean marked;

        public Row() {
        }

        public Row(String name, boolean marked) {
            this.name = name == null ? "" : name;
            this.marked = marked;
        }
    }
}

