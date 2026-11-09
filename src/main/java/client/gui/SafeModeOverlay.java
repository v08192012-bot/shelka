/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.AbstractOverlay;
import client.gui.Screen;
import java.util.ArrayList;
import java.util.List;

public class SafeModeOverlay
extends AbstractOverlay {
    public static final float DEFAULT_DURATION = 0.15f;
    public static final float DEFAULT_ALPHA_DURATION = 0.15f;
    public static final int VTABLE_RVA = 12587744;
    public static final long RVA_CTOR = 6880L;
    public static final long RVA_DTOR = 1174128L;
    public static final long RVA_RESET = 1187424L;
    public static final long RVA_RENDER_BODY = 1181056L;
    public static final long RVA_ON_MOUSE_CLICKED = 1186496L;
    public static final long RVA_ON_KEY_PRESSED = 1186848L;
    public static final long RVA_ON_DISPOSED = 1186928L;
    public static final long RVA_REQUEST_SNAPSHOT = 1175360L;
    public static final long RVA_APPLY_SNAPSHOT = 1174192L;
    public static final long RVA_SET_MODE = 1179424L;
    public static final long RVA_OPEN_SELECTED = 1179888L;
    public static final long RVA_REFRESH = 1179728L;
    public static final long RVA_RENDER_HEADER = 1184384L;
    public static final long RVA_RELEASE_ONE_TEXTURE = 1179280L;
    public static final long RVA_CENTER_ON_SCREEN = 1168768L;
    public static final long RVA_COLLECT_WINDOWS = 942768L;
    public static final long RVA_MOVE_LIST = 1188192L;
    public static final long RVA_PANEL_RECT = 696912L;
    public static final long RVA_DRAW_TEXT = 3494400L;
    public static final long RVA_DRAW_GLYPH = 3491616L;
    public static final long RVA_DRAW_SURFACE = 3502704L;
    public static final long RVA_MEASURE_LINES = 251792L;
    public static final int OFF_CHILD_SLOT = 200;
    public static final int OFF_MODE = 208;
    public static final int OFF_OPEN_ANIM = 216;
    public static final int OFF_HEIGHT_SMOOTH = 256;
    public static final int OFF_ENTRIES = 264;
    public static final int OFF_LABEL_PRIMARY = 288;
    public static final int OFF_LABEL_DETAIL = 320;
    public static final int OFF_STATUS_TEXT = 352;
    public static final int OFF_PREVIOUS_SNAPSHOT = 384;
    public static final int OFF_TEXTURE_A = 392;
    public static final int OFF_TEXTURE_B = 396;
    public static final int OFF_TEXTURE_WIDTH = 400;
    public static final int OFF_TEXTURE_HEIGHT = 404;
    public static final int OFF_SNAPSHOT_HANDLE = 408;
    public static final int OFF_IMAGE_A = 416;
    public static final int OFF_IMAGE_A_WIDTH = 440;
    public static final int OFF_IMAGE_A_HEIGHT = 444;
    public static final int OFF_IMAGE_B = 448;
    public static final int OFF_IMAGE_B_WIDTH = 472;
    public static final int OFF_IMAGE_B_HEIGHT = 476;
    public static final int OFF_SNAPSHOT_PENDING = 480;
    public static final int OFF_LOADING_LABEL = 481;
    public static final int OFF_REQUEST_TIME = 488;
    public static final int OFF_PANEL_TOP = 496;
    public static final int OFF_BUTTON_X = 500;
    public static final int OFF_PANEL_RIGHT = 504;
    public static final int OFF_PANEL_HALF_WIDTH = 508;
    public static final int OFF_HINT_X = 512;
    public static final int OFF_HINT_Y = 516;
    public static final int OFF_TWO_COLUMN = 520;
    public static final int OFF_CLOSE_REQUESTED = 521;
    public static final int OFF_HOVER_LEFT_ANIM = 528;
    public static final int OFF_HOVER_RIGHT_ANIM = 568;
    public static final int OFF_LOAD_ANIM = 608;
    public static final int MODE_LIST = 0;
    public static final int MODE_DETAIL = 1;
    public static final int MODE_IMAGE = 2;
    public static final float PANEL_WIDTH = 360.0f;
    public static final float PANEL_HEIGHT = 295.0f;
    public static final float PANEL_RADIUS = 12.0f;
    public static final float PANEL_PADDING = 16.0f;
    public static final float PANEL_INNER_GAP = 8.0f;
    public static final float PANEL_BOTTOM_GAP = 32.0f;
    public static final float BUTTON_HEIGHT = 32.0f;
    public static final float BUTTON_RADIUS = 8.0f;
    public static final float HINT_WIDTH = 248.0f;
    public static final float HINT_HEIGHT = 167.0f;
    public static final float HINT_RADIUS = 8.0f;
    public static final float THUMB_WIDTH = 236.0f;
    public static final float THUMB_HEIGHT = 133.0f;
    public static final float THUMB_PADDING = 2.0f;
    public static final float HEADER_TEXT_SIZE = 16.0f;
    public static final float TITLE_TEXT_SIZE = 12.0f;
    public static final float LABEL_TEXT_SIZE = 14.0f;
    public static final float DETAIL_TEXT_SIZE = 12.0f;
    public static final float LINE_HEIGHT = 14.4f;
    public static final float LINES_BIAS = 44.0f;
    public static final float MEASURE_MAX_WIDTH = 328.0f;
    public static final float OPEN_THRESHOLD = 0.5f;
    public static final float SNAPSHOT_POLL_SECONDS = 1.0f;
    public static final float NANOS_PER_SECOND = 1.0E9f;
    public static final int HOVERED_WIDGET_SAFE_MODE = 1;
    public static final int HOVER_SOUND_IN = 8;
    public static final int HOVER_SOUND_OUT = 9;
    public static final int ICON_WARNING = 51;
    private static final String HEADER_LABEL = "SafeModeOverlay.header";
    private static final String TITLE_LABEL = "SafeModeOverlay.title";
    private static final String TITLE_LABEL_ALT = "SafeModeOverlay.titleAlt";
    private static final String LIST_LABEL = "SafeModeOverlay.list";
    private static final String LIST_LABEL_ALT = "SafeModeOverlay.listAlt";
    private static final String DETAIL_LABEL = "SafeModeOverlay.detail";
    private static final String DETAIL_LABEL_ALT = "SafeModeOverlay.detailAlt";
    private static final String EMPTY_LABEL = "SafeModeOverlay.empty";
    private static final String LOADING_LABEL_A = "SafeModeOverlay.loadingA";
    private static final String LOADING_LABEL_B = "SafeModeOverlay.loadingB";
    private static final String DEFAULT_DETAIL = "SafeModeOverlay.defaultDetail";
    private static final String DEFAULT_ENTRY = "SafeModeOverlay.defaultEntry";
    private static Object dismissHandler;
    private final List<Object> entries = new ArrayList<Object>();
    private final List<Object> imageA = new ArrayList<Object>();
    private final List<Object> imageB = new ArrayList<Object>();
    private Object childSlot;
    private int mode;
    private Object previousSnapshot;
    private Object snapshotHandle;
    private int textureA;
    private int textureB;
    private int textureWidth;
    private int textureHeight;
    private int imageAWidth;
    private int imageAHeight;
    private int imageBWidth;
    private int imageBHeight;
    private float heightSmooth = 295.0f;
    private float panelTop;
    private float buttonX;
    private float panelRight;
    private float panelHalfWidth;
    private float hintX;
    private float hintY;
    private boolean twoColumn;
    private boolean closeRequested;
    private boolean snapshotPending;
    private boolean loadingLabel;
    private long requestTime;
    private final AbstractOverlay.Animator openAnim = new AbstractOverlay.Animator(0.0f, 0.15f, 0);
    private final AbstractOverlay.Animator hoverLeftAnim = new AbstractOverlay.Animator(0.0f, 0.15f, 0);
    private final AbstractOverlay.Animator hoverRightAnim = new AbstractOverlay.Animator(0.0f, 0.15f, 0);
    private final AbstractOverlay.Animator loadAnim = new AbstractOverlay.Animator(0.0f, 0.15f, 0);

    public SafeModeOverlay() {
        this.initRectAnimator();
        this.animXFrom = 0.0f;
        this.animXCurrent = 0.0f;
        this.animXTarget = 0.0f;
        this.animYFrom = 0.0f;
        this.animYCurrent = 0.0f;
        this.animYTarget = 0.0f;
        this.animatingPosition = false;
        this.animFrom = 0.0f;
        this.alpha = 0.0f;
        this.alphaTarget = 0.0f;
        this.alphaDuration = 0.15f;
        this.alphaEasing = 1;
        this.alphaStart = this.now();
        this.alphaRunning = false;
        this.closed = false;
        this.closeOnOutsideClick = true;
        this.closeOnEscape = true;
        this.detached = false;
        this.child = null;
        this.childSlot = null;
        this.mode = 0;
        SafeModeOverlay.resetAnimator(this.openAnim, 0.0f, 0.15f, 0);
        this.heightSmooth = 295.0f;
        this.previousSnapshot = null;
        this.snapshotHandle = null;
        this.textureA = 0;
        this.textureB = 0;
        this.textureWidth = 0;
        this.textureHeight = 0;
        this.imageAWidth = 0;
        this.imageAHeight = 0;
        this.imageBWidth = 0;
        this.imageBHeight = 0;
        this.panelTop = 0.0f;
        this.buttonX = 0.0f;
        this.panelRight = 0.0f;
        this.panelHalfWidth = 0.0f;
        this.hintX = 0.0f;
        this.hintY = 0.0f;
        this.twoColumn = false;
        this.closeRequested = false;
        this.snapshotPending = false;
        this.loadingLabel = false;
        this.requestTime = 0L;
        SafeModeOverlay.resetAnimator(this.hoverLeftAnim, 0.0f, 0.15f, 0);
        SafeModeOverlay.resetAnimator(this.hoverRightAnim, 0.0f, 0.15f, 0);
        SafeModeOverlay.resetAnimator(this.loadAnim, 0.0f, 0.15f, 0);
    }

    public void show() {
        this.closeRequested = true;
        this.mode = 0;
        SafeModeOverlay.resetAnimator(this.openAnim, 0.0f, 0.15f, 0);
        SafeModeOverlay.resetAnimator(this.hoverLeftAnim, 0.0f, 0.15f, 0);
        SafeModeOverlay.resetAnimator(this.hoverRightAnim, 0.0f, 0.15f, 0);
        SafeModeOverlay.resetAnimator(this.loadAnim, 0.0f, 0.15f, 0);
        SafeModeOverlay.clearLabel(352);
        SafeModeOverlay.applySnapshot(SafeModeOverlay.collectWindows());
        this.snapshotPending = true;
        this.requestTime = this.now();
        SafeModeOverlay.submitSnapshotRequest();
        this.width = 360.0f;
        this.height = 295.0f;
        this.heightSmooth = 295.0f;
        this.centerOnScreen();
        this.activate();
    }

    @Override
    public void dispose() {
        SafeModeOverlay.releaseSnapshotState();
        super.dispose();
    }

    @Override
    public void reset() {
        this.closed = false;
        this.animFrom = 0.0f;
        this.alpha = 0.0f;
        this.alphaTarget = 0.0f;
        this.alphaRunning = false;
        this.onDisposed();
    }

    @Override
    public void onDisposed() {
        if (this.closeRequested) {
            this.closeRequested = false;
            if (dismissHandler != null) {
                SafeModeOverlay.releaseDismissHandler(dismissHandler);
            }
        }
        this.mode = 0;
        this.openAnim.from = 0.0f;
        this.openAnim.current = 0.0f;
        this.openAnim.target = 0.0f;
        this.openAnim.running = false;
        SafeModeOverlay.releaseEntries();
        this.entries.clear();
        SafeModeOverlay.clearLabel(288);
        SafeModeOverlay.clearLabel(320);
        SafeModeOverlay.releaseTextures();
        this.previousSnapshot = null;
        this.snapshotHandle = null;
        SafeModeOverlay.releaseImageList(this.imageA);
        this.imageA.clear();
        this.imageAWidth = 0;
        this.imageAHeight = 0;
        SafeModeOverlay.releaseImageList(this.imageB);
        this.imageB.clear();
        this.imageBWidth = 0;
        this.imageBHeight = 0;
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void renderBody(Object renderer, float mouseX, float mouseY, float alpha) {
        if (this.mode == 0 && !this.snapshotPending && 1.0f <= (float)((double)(this.now() - this.requestTime) / 1.0E9)) {
            this.requestSnapshot();
        }
        SafeModeOverlay.refresh();
        float open = SafeModeOverlay.advance(this.openAnim, this.now());
        float height = this.heightSmooth;
        float magnitude = Math.abs(open);
        if (!(Float.isNaN(magnitude) || Float.isInfinite(magnitude) || Float.isNaN(height) || Float.isInfinite(height))) {
            if (0.0f < height) {
                if (open != 1.0f) {
                    boolean keep;
                    float scaled = magnitude * (height - 295.0f) + 295.0f;
                    if (1.0f < open == 295.0f < height) {
                        keep = scaled < height;
                    } else {
                        boolean bl = keep = height < scaled;
                    }
                    if (!keep) {
                        height = scaled;
                    }
                }
            } else {
                height = height * open + (1.0f - open) * 295.0f;
            }
        } else if (!Float.isNaN(height)) {
            float base = open;
            height = !Float.isNaN(open) ? (Float.isInfinite(magnitude) ? (height - 295.0f) * open : (open < 0.0f ? 295.0f - height : (1.0f < open ? (height -= 295.0f) : height * open + (1.0f - open) * 295.0f))) : base + open;
        } else {
            height = height + 295.0f + open;
        }
        this.heightSmooth = height;
        this.height = height;
        this.renderPanels(renderer, mouseX, mouseY, alpha, open);
    }

    private void renderPanels(Object renderer, float mouseX, float mouseY, float alpha, float open) {
        String secondaryLabel;
        String primaryLabel;
        float rightTarget;
        float leftTarget;
        float bodyValue;
        float buttonLeft;
        this.centerOnScreen();
        float top = this.y;
        float alphaClamped = alpha;
        if (alphaClamped < 0.0f) {
            alphaClamped = 0.0f;
        }
        if (alphaClamped > 1.0f) {
            alphaClamped = 1.0f;
        }
        float rectTop = (1.0f - alphaClamped) * 16.0f + top;
        Object rect = SafeModeOverlay.makeRect(renderer, alpha, this.width * 0.5f + this.x, this.height * 0.5f + rectTop);
        int panelColor = SafeModeOverlay.uiThemeColor(SafeModeOverlay.uiTheme(), 8);
        SafeModeOverlay.drawPanel(rect, this.x, rectTop, this.width, this.height, 12.0f, 12.0f, 12.0f, 12.0f, panelColor, SafeModeOverlay.uiThemeColor(SafeModeOverlay.uiTheme(), 12), 1.0f, 0.0f, 0, 0.0f, 0.0f, alpha, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        float innerWidth = this.width - 32.0f;
        float headerTop = rectTop + 16.0f;
        float left = this.x + 16.0f;
        float halfWidth = innerWidth - 8.0f;
        this.panelTop = rectTop + this.height - 16.0f - 32.0f;
        this.panelHalfWidth = halfWidth *= 0.5f;
        if (this.mode == 0 && this.entries.isEmpty()) {
            this.twoColumn = false;
            buttonLeft = (innerWidth - halfWidth) * 0.5f + left;
        } else {
            this.twoColumn = true;
            buttonLeft = left;
        }
        this.buttonX = buttonLeft;
        float value = (1.0f - open) * alpha;
        this.panelRight = halfWidth + left + 8.0f;
        if (0.001f < value) {
            SafeModeOverlay.drawText(4, renderer, HEADER_LABEL, left, headerTop, 16.0f, SafeModeOverlay.uiThemeColor(SafeModeOverlay.uiTheme(), 24), value);
            float titleTop = headerTop + 16.0f + 8.0f;
            String titleLabel = this.entries.isEmpty() ? TITLE_LABEL : TITLE_LABEL_ALT;
            SafeModeOverlay.drawText(0, renderer, titleLabel, left, titleTop, 12.0f, SafeModeOverlay.uiThemeColor(SafeModeOverlay.uiTheme(), 16), value);
            float hintW = Math.round((this.width - 248.0f) * 0.5f);
            this.hintX = hintW + this.x;
            this.hintY = titleTop + 12.0f + 12.0f;
            this.renderHeader(renderer, mouseX, mouseY, value);
        }
        if (0.001f < (bodyValue = open * alpha)) {
            int labelColor;
            String label;
            if (this.mode == 1) {
                label = LIST_LABEL_ALT;
                labelColor = SafeModeOverlay.uiThemeColor(SafeModeOverlay.uiTheme(), 24);
            } else {
                label = LIST_LABEL;
                labelColor = SafeModeOverlay.uiThemeColor(SafeModeOverlay.uiTheme(), 40);
            }
            SafeModeOverlay.drawText(4, renderer, label, left, headerTop, 16.0f, labelColor, bodyValue);
            String detail;
            int detailColor;
            if (this.mode == 1) {
                detail = LOADING_LABEL_A;
                detailColor = SafeModeOverlay.uiThemeColor(SafeModeOverlay.uiTheme(), 24);
                SafeModeOverlay.drawTextClipped(0, renderer, detail, left, headerTop + 16.0f + 12.0f, 12.0f, innerWidth, detailColor, bodyValue);
            } else {
                detail = this.statusText();
                detailColor = SafeModeOverlay.uiThemeColor(SafeModeOverlay.uiTheme(), 16);
                SafeModeOverlay.drawTextClipped(0, renderer, detail, left, headerTop + 16.0f + 12.0f, 12.0f, innerWidth, detailColor, bodyValue);
            }
        }
        float panelTop = this.panelTop;
        boolean leftHovered = this.buttonX <= mouseX && mouseX <= this.buttonX + this.panelHalfWidth && panelTop <= mouseY && mouseY <= panelTop + 32.0f && (activeOverlay == null || Screen.allowHover);
        boolean rightHovered = this.twoColumn && this.panelRight <= mouseX && mouseX <= this.panelRight + this.panelHalfWidth && panelTop <= mouseY && mouseY <= panelTop + 32.0f && (activeOverlay == null || Screen.allowHover);
        if (leftHovered || rightHovered) {
            Screen.hoveredWidget = 1;
        }
        float f = leftTarget = leftHovered ? 1.0f : 0.0f;
        if (this.hoverLeftAnim.target != leftTarget) {
            SafeModeOverlay.animate(this.hoverLeftAnim, leftTarget);
        }
        float f2 = rightTarget = rightHovered ? 1.0f : 0.0f;
        if (this.hoverRightAnim.target != rightTarget) {
            SafeModeOverlay.animate(this.hoverRightAnim, rightTarget);
        }
        int leftColor = SafeModeOverlay.uiLerpColor(SafeModeOverlay.uiThemeColor(SafeModeOverlay.uiTheme(), 0), SafeModeOverlay.uiThemeColor(SafeModeOverlay.uiTheme(), 8), 0.85f);
        leftColor = SafeModeOverlay.uiLerpColor(SafeModeOverlay.uiThemeColor(SafeModeOverlay.uiTheme(), 4), leftColor, this.hoverLeftAnim.current);
        SafeModeOverlay.drawPanel(rect, this.buttonX, panelTop, this.panelHalfWidth, 32.0f, 8.0f, 8.0f, 8.0f, 8.0f, leftColor, SafeModeOverlay.uiThemeColor(SafeModeOverlay.uiTheme(), 12), 1.0f, 4.36207616E8f, 0, 1.0f, 1.0f, alpha, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        float rightHover = SafeModeOverlay.advance(this.hoverRightAnim, this.now());
        if (this.twoColumn) {
            int rightColor = SafeModeOverlay.uiLerpColor(SafeModeOverlay.uiThemeColor(SafeModeOverlay.uiTheme(), 20), SafeModeOverlay.uiThemeColor(SafeModeOverlay.uiTheme(), 24), rightHover * 0.15f);
            SafeModeOverlay.drawPanel(rect, this.panelRight, panelTop, this.panelHalfWidth, 32.0f, 8.0f, 8.0f, 8.0f, 8.0f, rightColor, 0, 0.0f, 4.36207616E8f, 0, 1.0f, 1.0f, alpha, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        }
        if (0.5f < open) {
            if (this.mode == 1) {
                primaryLabel = LIST_LABEL_ALT;
                secondaryLabel = DETAIL_LABEL_ALT;
            } else {
                primaryLabel = LIST_LABEL;
                secondaryLabel = DETAIL_LABEL;
            }
        } else {
            primaryLabel = EMPTY_LABEL;
            secondaryLabel = EMPTY_LABEL;
        }
        float labelTop = panelTop + 9.0f;
        float primaryWidth = SafeModeOverlay.measureText(0, primaryLabel, 14.0f);
        SafeModeOverlay.drawText(2, renderer, primaryLabel, (this.panelHalfWidth - primaryWidth) * 0.5f + this.buttonX, labelTop, 14.0f, SafeModeOverlay.uiThemeColor(SafeModeOverlay.uiTheme(), 24), alpha);
        if (this.twoColumn) {
            float secondaryWidth = SafeModeOverlay.measureText(0, secondaryLabel, 14.0f);
            SafeModeOverlay.drawText(2, renderer, secondaryLabel, (this.panelHalfWidth - secondaryWidth) * 0.5f + this.panelRight, labelTop, 14.0f, SafeModeOverlay.uiThemeColor(SafeModeOverlay.uiTheme(), 24), alpha);
        }
    }

    @Override
    public boolean onMouseClicked(double mx, double my, int button) {
        if (button != 0) {
            return false;
        }
        float panelTop = this.panelTop;
        if ((double)this.buttonX <= mx && mx <= (double)(this.buttonX + this.panelHalfWidth) && (double)panelTop <= my && my <= (double)(panelTop + 32.0f)) {
            if (this.mode == 2) {
                this.closeAndRefresh();
                return true;
            }
            this.close();
            return true;
        }
        if (!this.twoColumn || mx < (double)this.panelRight || (double)(this.panelRight + this.panelHalfWidth) < mx || my < (double)panelTop || (double)(panelTop + 32.0f) < my) {
            if (this.mode != 0 || mx < (double)this.hintX || (double)(this.hintX + 248.0f) < mx || my < (double)this.hintY || (double)(this.hintY + 167.0f) < my) {
                return false;
            }
        } else if (this.mode == 0) {
            this.openSelected();
        } else {
            if (this.mode == 1) {
                this.close();
                return true;
            }
            if (this.mode == 2) {
                this.closeAndRefresh();
                return true;
            }
        }
        return true;
    }

    @Override
    public boolean onKeyPressed(int keyCode, int modifiers) {
        if (keyCode == 13) {
            if (this.mode == 1) {
                this.close();
                return true;
            }
            if (this.mode == 0 && !this.entries.isEmpty()) {
                this.openSelected();
                return true;
            }
        }
        return false;
    }

    private void requestSnapshot() {
        this.snapshotPending = true;
        this.requestTime = this.now();
        SafeModeOverlay.submitSnapshotRequest();
    }

    private void openSelected() {
        if (this.entries.isEmpty()) {
            return;
        }
        Object id = SafeModeOverlay.firstEntryId();
        if (SafeModeOverlay.lookupSnapshotEntry(id) != null) {
            SafeModeOverlay.applySnapshotDetail(id);
        } else {
            SafeModeOverlay.applySnapshotDetail(DEFAULT_DETAIL);
        }
        this.setMode(2);
    }

    private void setMode(int value) {
        this.mode = value;
        String text = value == 1 ? LOADING_LABEL_B : this.statusText();
        int lines = SafeModeOverlay.measureLines(0, text, 12.0f, 328.0f);
        this.heightSmooth = (float)lines * 14.4f + 44.0f + 16.0f + 32.0f + 16.0f;
        if (this.openAnim.target != 1.0f) {
            SafeModeOverlay.animate(this.openAnim, 1.0f);
        }
    }

    private void closeAndRefresh() {
        this.mode = 0;
        if (this.openAnim.target != 0.0f) {
            SafeModeOverlay.animate(this.openAnim, 0.0f);
        }
        Object snapshot = SafeModeOverlay.collectWindows();
        SafeModeOverlay.applySnapshot(snapshot);
        if (!this.snapshotPending) {
            this.requestSnapshot();
        }
    }

    private void renderHeader(Object renderer, float mouseX, float mouseY, float alpha) {
        boolean populated = !this.entries.isEmpty();
        float hoverTarget = populated && this.hintX <= mouseX && mouseX <= this.hintX + 248.0f && this.hintY <= mouseY && mouseY <= this.hintY + 167.0f ? 1.0f : 0.0f;
        if (this.loadAnim.target != hoverTarget) {
            SafeModeOverlay.animate(this.loadAnim, hoverTarget);
        }
        float hover = SafeModeOverlay.advance(this.loadAnim, this.now());
        int fill = SafeModeOverlay.uiLerpColor(SafeModeOverlay.uiThemeColor(SafeModeOverlay.uiTheme(), 4), SafeModeOverlay.uiThemeColor(SafeModeOverlay.uiTheme(), 8), hover);
        float borderMix = populated ? hover * 0.5f + 0.5f : 0.0f;
        int border = SafeModeOverlay.uiLerpColor(SafeModeOverlay.uiThemeColor(SafeModeOverlay.uiTheme(), 12), SafeModeOverlay.uiThemeColor(SafeModeOverlay.uiTheme(), 20), borderMix);
        SafeModeOverlay.drawPanel(renderer, this.hintX, this.hintY, 248.0f, 167.0f, 8.0f, 8.0f, 8.0f, 8.0f, fill, border, 1.0f, 4.36207616E8f, 0, 2.0f, 8.0f, alpha, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        if (populated) {
            if (this.textureB == 0) {
                float iconX = this.hintX + 8.0f;
                float iconY = this.hintY + 6.0f;
                SafeModeOverlay.drawIcon(renderer, 51, iconX, iconY, 16.0f, 16.0f, SafeModeOverlay.uiThemeColor(SafeModeOverlay.uiTheme(), 16), alpha);
            } else {
                SafeModeOverlay.drawSurface(renderer, this.textureB, this.hintX + 8.0f, this.hintY + 6.0f, 16.0f, 16.0f, 0.0f, -1, alpha);
            }
            float labelLeft = this.hintX + 8.0f;
            float labelTop = this.hintY + 8.0f;
            SafeModeOverlay.drawText(2, renderer, this.labelPrimary(), labelLeft + 16.0f + 2.0f, labelTop, 12.0f, SafeModeOverlay.uiThemeColor(SafeModeOverlay.uiTheme(), 24), alpha);
            float detailWidth = SafeModeOverlay.measureText(0, this.labelDetail(), 12.0f);
            SafeModeOverlay.drawText(0, renderer, this.labelDetail(), this.hintX + 248.0f - 8.0f - detailWidth, labelTop, 12.0f, SafeModeOverlay.uiThemeColor(SafeModeOverlay.uiTheme(), 16), alpha);
            float imageLeft = this.hintX + 8.0f;
            float imageTop = this.hintY + 28.0f;
            SafeModeOverlay.drawBox(renderer, imageLeft, imageTop, 236.0f, 133.0f, 4.0f, 4.0f, 4.0f, 4.0f, SafeModeOverlay.uiThemeColor(SafeModeOverlay.uiTheme(), 12), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, alpha, 0);
            if (this.textureA == 0) {
                float titleWidth = SafeModeOverlay.measureText(0, this.labelPrimary(), 14.0f);
                SafeModeOverlay.drawText(0, renderer, this.labelPrimary(), (236.0f / (float)this.textureWidth - titleWidth) * 0.5f + imageLeft, imageTop + 60.5f, 14.0f, SafeModeOverlay.uiThemeColor(SafeModeOverlay.uiTheme(), 24), alpha);
            } else {
                float scaleY = 133.0f / (float)this.textureHeight;
                float scaleX = 236.0f / (float)this.textureWidth;
                if (scaleY <= scaleX) {
                    scaleX = scaleY;
                }
                float drawWidth = Math.round((float)this.textureWidth * scaleX);
                float drawHeight = Math.round((float)this.textureHeight * scaleX);
                float offsetX = Math.round((236.0f - drawWidth) * 0.5f);
                float offsetY = Math.round((133.0f - drawHeight) * 0.5f);
                SafeModeOverlay.drawSurface(renderer, this.textureA, offsetX + imageLeft, offsetY + imageTop, drawWidth, drawHeight, 4.0f, -1, alpha);
            }
        } else {
            float iconX = this.hintX + 124.0f;
            float iconY = this.hintY + 83.5f;
            SafeModeOverlay.drawIcon(renderer, 51, iconX - 10.0f, iconY - 20.0f - 4.0f, 20.0f, 20.0f, SafeModeOverlay.uiThemeColor(SafeModeOverlay.uiTheme(), 16), alpha * 0.5f);
            float titleWidth = SafeModeOverlay.measureText(0, EMPTY_LABEL, 12.0f);
            SafeModeOverlay.drawText(0, renderer, EMPTY_LABEL, iconX - titleWidth * 0.5f, iconY + 8.0f, 12.0f, SafeModeOverlay.uiThemeColor(SafeModeOverlay.uiTheme(), 16), alpha);
        }
    }

    private void centerOnScreen() {
        SafeModeOverlay.initGuiMetrics();
        float scale = SafeModeOverlay.guiScale();
        float width = (float)SafeModeOverlay.screenWidth() / scale - this.width;
        if (width <= 0.0f) {
            width = 0.0f;
        }
        this.x = Math.round(width * 0.5f);
        float height = (float)SafeModeOverlay.screenHeight() / scale - this.height;
        if (height <= 0.0f) {
            height = 0.0f;
        }
        this.y = Math.round(height * 0.5f);
    }

    private String labelPrimary() {
        return SafeModeOverlay.labelAt(288);
    }

    private String labelDetail() {
        return SafeModeOverlay.labelAt(320);
    }

    private String statusText() {
        return SafeModeOverlay.labelAt(352);
    }

    private static String labelAt(int offset) {
        return "";
    }

    private static void clearLabel(int offset) {
    }

    private static void releaseEntries() {
    }

    private static void releaseImageList(List<Object> images) {
    }

    private static void releaseTextures() {
    }

    private static void releaseOneTexture(int id) {
    }

    private static void releaseDismissHandler(Object handler) {
    }

    private static void submitSnapshotRequest() {
    }

    private static Object collectWindows() {
        return null;
    }

    private static Object firstEntryId() {
        return null;
    }

    private static Object lookupSnapshotEntry(Object id) {
        return null;
    }

    private static void applySnapshotDetail(Object value) {
    }

    private static void applySnapshot(Object snapshot) {
    }

    private static void refresh() {
    }

    private static void releaseSnapshotState() {
    }

    private static void initGuiMetrics() {
    }

    private static float guiScale() {
        return 1.0f;
    }

    private static int screenWidth() {
        return 0;
    }

    private static int screenHeight() {
        return 0;
    }

    private static Object makeRect(Object renderer, float alpha, float right, float bottom) {
        return new float[8];
    }

    private static void drawPanel(Object rect, float x, float y, float w, float h, float r0, float r1, float r2, float r3, int fill, int border, float borderWidth, float shadowColor, int shadowFlag, float shadowAlpha, float scale, float alpha, Object ... tail) {
    }

    private static void drawBox(Object renderer, float x, float y, float w, float h, float r0, float r1, float r2, float r3, int color, float a1, float a2, float a3, float a4, float a5, float a6, float alpha, Object ... tail) {
    }

    private static void drawText(int style, Object renderer, String text, float x, float y, float size, int color, float alpha) {
    }

    private static void drawTextClipped(int style, Object renderer, String text, float x, float y, float size, float maxWidth, int color, float alpha) {
    }

    private static void drawIcon(Object renderer, int icon, float x, float y, float w, float h, int color, float alpha) {
    }

    private static void drawSurface(Object renderer, int texture, float x, float y, float w, float h, float inset, int mode, float alpha) {
    }

    private static float measureText(int style, String text, float size) {
        return 0.0f;
    }

    private static int measureLines(int style, String text, float size, float maxWidth) {
        return 0;
    }

    public static int uiThemeColor(Object theme, int offset) {
        return 0;
    }

    public static Object uiTheme() {
        return null;
    }
}

