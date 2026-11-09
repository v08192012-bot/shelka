/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.AbstractOverlay;
import client.gui.Component;
import client.gui.ProfileBlock;
import client.gui.Screen;
import client.gui.StatusMenu;

public class ProfileMenu
extends AbstractOverlay {
    public static final long VTABLE_RVA = 12613448L;
    public static final long RVA_CTOR = 2735201396896L;
    public static final long RVA_DTOR = 2735201397520L;
    public static final long RVA_RESET = 2735201404112L;
    public static final long RVA_MOUSE_CLICKED = 2735201402864L;
    public static final long RVA_KEY_PRESSED = 2735201403936L;
    public static final long RVA_OVERLAY_CONST = 2735201397984L;
    public static final long RVA_SET_CHILD = 2735201397648L;
    public static final long RVA_RENDER_BODY = 2735201398000L;
    public static final long RVA_ON_MOUSE_CLICKED = 2735201403168L;
    public static final long RVA_ON_CLOSED = 2735201404048L;
    public static final long RVA_RENDER_HEADER = 2735201399408L;
    public static final long RVA_RENDER_STATUS_BUTTON = 2735201401072L;
    public static final long RVA_DRAW_ICON_IN_BOX = 2735201396736L;
    public static final long RVA_RENDER_BLOCK = 2735201383152L;
    public static final long RVA_PRESENCE_SOURCE = 2735201071440L;
    public static final long RVA_ASSIGN_LISTENER = 2735200812688L;
    public static final long RVA_TOOLTIP = 2735201414960L;
    public static final long RVA_CHILD_LAYOUT = 2735201404176L;
    public static final long RVA_COPY_TO_CLIPBOARD = 2735199737360L;
    public static final int OFF_BLOCK = 208;
    public static final int OFF_STATUS_MENU = 216;
    public static final int OFF_PRESENCE_LISTENER = 424;
    public static final int OFF_COPY_REGION_X = 872;
    public static final int OFF_COPY_REGION_Y = 876;
    public static final int OFF_COPY_REGION_WIDTH = 880;
    public static final int OFF_COPY_REGION_HEIGHT = 884;
    public static final int OFF_STATUS_BUTTON_X = 888;
    public static final int OFF_STATUS_BUTTON_Y = 892;
    public static final int OFF_STATUS_BUTTON_WIDTH = 896;
    public static final int OFF_STATUS_BUTTON_HEIGHT = 900;
    public static final int OFF_COPY_HOVER_ANIM = 904;
    public static final int OFF_STATUS_HOVER_ANIM = 944;
    public static final int OFF_COPIED_ANIM = 984;
    public static final int OFF_PRESENCE = 1024;
    public static final int OFF_PRESENCE_PREVIOUS = 1025;
    public static final int OFF_PRESENCE_ANIM = 1032;
    public static final int OFF_PRESENCE_COLOR = 1072;
    public static final int OFF_PRESENCE_SOURCE_SLOT = 1080;
    public static final int STATUS_MENU_SIZE = 656;
    public static final float WIDTH = 284.0f;
    public static final float HEIGHT = 158.0f;
    public static final float OVERLAY_METRIC = 24.0f;
    public static final float HEADER_OFFSET = 12.0f;
    public static final float BLOCK_HEIGHT = 38.0f;
    public static final float CARD_WIDTH = 260.0f;
    public static final float CARD_HEIGHT = 88.0f;
    public static final float CARD_INSET = 16.0f;
    public static final float ICON_BOX = 16.0f;
    public static final float LABEL_GAP = 3.0f;
    public static final float SUBTITLE_STEP = 22.0f;
    public static final float CARD_RADIUS = 16.0f;
    public static final float STATUS_BUTTON_WIDTH = 244.0f;
    public static final float STATUS_BUTTON_HEIGHT = 30.0f;
    public static final float STATUS_BUTTON_INSET = 2.0f;
    public static final float STATUS_BUTTON_HEIGHT_DRAW = 26.0f;
    public static final float STATUS_BUTTON_RADIUS = 8.0f;
    public static final float STATUS_BUTTON_RADIUS_BASE = 10.0f;
    public static final float COPY_REGION_SIZE = 16.0f;
    public static final float COPY_HOVER_THRESHOLD = 0.5f;
    public static final float PRESENCE_ANIM_DURATION = 0.22f;
    public static final float HOVER_ANIM_DURATION = 0.15f;
    public static final float COPIED_ANIM_DURATION = 1.2f;
    public static final float ALPHA_SHIFT = 16.0f;
    public static final float FADE_POW = 1.7f;
    public static final float TINT_MIX = 0.85f;
    public static final float DOT_INSET = 2.0f;
    public static final float DOT_SIZE = 4.0f;
    public static final float DOT_RADIUS = 2.0f;
    public static final float DOT_DROP = 13.0f;
    public static final float DOT_GAP = 6.0f;
    public static final float LABEL_INSET = 8.0f;
    public static final float LABEL_STEP = 4.0f;
    public static final float FADE_DISTANCE = 4.0f;
    public static final float TITLE_SIZE = 14.0f;
    public static final float SUBTITLE_SIZE = 12.0f;
    public static final float HALF = 0.5f;
    public static final float EMPTY = 0.0f;
    public static final float FULL_ALPHA = 1.0f;
    public static final float NEAR_ONE = 0.999f;
    public static final float EPSILON = 0.001f;
    public static final int ICON_HEADER = 84;
    public static final int ICON_STATUS = 11;
    public static final int ICON_COPY_A = 37;
    public static final int ICON_COPY_B = 12;
    public static final int SOUND_COPY = 14;
    public static final int COLOR_ONLINE = -13919642;
    public static final int COLOR_IDLE = -17896;
    public static final int COLOR_DO_NOT_DISTURB = -2276315;
    public static final int COLOR_OFFLINE = -8158333;
    public static final String LABEL = "\u0423\u0441\u0442\u0430\u043d\u043e\u0432\u0438\u0442\u044c \u0441\u0442\u0430\u0442\u0443\u0441";
    public static final String SUBTITLE = "\u041a\u0430\u043a \u0442\u0435\u0431\u044f \u0432\u0438\u0434\u044f\u0442 \u0434\u0440\u0443\u0437\u044c\u044f";
    public static final String TOOLTIP_COPY = "\u0421\u043a\u043e\u043f\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u043d\u0438\u043a";
    public static final String TOOLTIP_COPIED = "\u0421\u043a\u043e\u043f\u0438\u0440\u043e\u0432\u0430\u043d\u043e";
    protected static boolean INPUT_GRACE = false;
    protected ProfileBlock block;
    protected StatusMenu statusMenu;
    protected boolean statusListOpen;
    protected PresenceListener presenceListener;
    protected float copyRegionX;
    protected float copyRegionY;
    protected float copyRegionWidth;
    protected float copyRegionHeight;
    protected float statusButtonX;
    protected float statusButtonY;
    protected float statusButtonWidth;
    protected float statusButtonHeight;
    protected int presence;
    protected int presencePrevious;
    protected final AbstractOverlay.Animator copyHoverAnim = new AbstractOverlay.Animator();
    protected final AbstractOverlay.Animator statusHoverAnim = new AbstractOverlay.Animator();
    protected final AbstractOverlay.Animator copiedAnim = new AbstractOverlay.Animator();
    protected final AbstractOverlay.Animator presenceAnim = new AbstractOverlay.Animator();
    protected final AbstractOverlay.ColorAnim presenceColor = new AbstractOverlay.ColorAnim();

    public ProfileMenu(ProfileBlock block) {
        this.block = block;
        this.statusMenu = new StatusMenu();
        this.copyRegionX = 0.0f;
        this.copyRegionY = 0.0f;
        this.copyRegionWidth = 0.0f;
        this.copyRegionHeight = 0.0f;
        this.statusButtonX = 0.0f;
        this.statusButtonY = 0.0f;
        this.statusButtonWidth = 0.0f;
        this.statusButtonHeight = 0.0f;
        ProfileMenu.resetAnimator(this.copyHoverAnim, 0.0f, 0.15f, 0);
        ProfileMenu.resetAnimator(this.statusHoverAnim, 0.0f, 0.15f, 0);
        ProfileMenu.resetAnimator(this.copiedAnim, 0.0f, 0.22f, 0);
        this.presence = 1;
        this.presencePrevious = 1;
        ProfileMenu.resetAnimator(this.presenceAnim, 1.0f, 0.22f, 0);
        ProfileMenu.resetColorAnimator(this.presenceColor, -13919642, 0.22f);
        this.width = 284.0f;
        this.height = 158.0f;
        this.presenceListener = new PresenceListener(){

            @Override
            public void onPresence(int value) {
            }
        };
    }

    @Override
    public void reset() {
        this.statusMenu.closed = false;
        this.statusMenu.animFrom = 0.0f;
        this.statusMenu.alpha = 0.0f;
        this.statusMenu.alphaTarget = 0.0f;
        this.statusMenu.alphaRunning = false;
        this.closed = false;
        this.animFrom = 0.0f;
        this.alpha = 0.0f;
        this.alphaTarget = 0.0f;
        this.alphaRunning = false;
    }

    @Override
    public float overlayConst() {
        return 24.0f;
    }

    @Override
    public void setChild(Component value) {
        int color;
        int current;
        this.presencePrevious = current = ProfileMenu.readPresence();
        this.presence = current;
        this.presenceAnim.from = 1.0f;
        this.presenceAnim.current = 1.0f;
        this.presenceAnim.target = 1.0f;
        this.presenceAnim.running = false;
        this.presenceColor.colorFrom = color = ProfileMenu.colorForPresence(current);
        this.presenceColor.colorTarget = color;
        this.presenceColor.from = 1.0f;
        this.presenceColor.current = 1.0f;
        this.presenceColor.target = 1.0f;
        this.presenceColor.running = false;
        super.setChild(value);
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (this.statusMenu.alpha <= 0.001f && this.statusMenu.alphaTarget <= 0.001f || this.statusMenu.closed) {
            return super.mouseClicked(mx, my, button);
        }
        if (!this.closed) {
            if ((double)this.statusMenu.x <= mx && mx <= (double)(this.statusMenu.x + this.statusMenu.width) && (double)this.statusMenu.y <= my && my <= (double)(this.statusMenu.y + this.statusMenu.height)) {
                return this.statusMenu.mouseClicked(mx, my, button);
            }
            this.statusMenu.close();
            if (mx < (double)this.statusButtonX || (double)(this.statusButtonX + this.statusButtonWidth) < mx || my < (double)this.statusButtonY || (double)(this.statusButtonY + this.statusButtonHeight) < my) {
                return super.mouseClicked(mx, my, button);
            }
        }
        return true;
    }

    @Override
    public boolean keyPressed(int keyCode, int modifiers) {
        if (keyCode == 27 && (0.001f < this.statusMenu.alpha || 0.001f < this.statusMenu.alphaTarget) && !this.statusMenu.closed) {
            this.statusMenu.close();
            return true;
        }
        if (!this.closeOnEscape || keyCode != 27) {
            return this.onKeyPressed(keyCode, modifiers);
        }
        this.close();
        return true;
    }

    @Override
    public void renderBody(Object target, float rx, float ry, float parentAlpha) {
        int value = ProfileMenu.readPresence();
        if (value != this.presence) {
            int previous = this.presence;
            this.presence = value;
            this.presencePrevious = previous;
            this.presenceAnim.from = 0.0f;
            this.presenceAnim.current = 0.0f;
            this.presenceAnim.target = 0.0f;
            this.presenceAnim.running = false;
            ProfileMenu.animate(this.presenceAnim, 1.0f);
        }
        ProfileMenu.animateColor(this.presenceColor, ProfileMenu.colorForPresence(this.presence));
        float half = 0.5f;
        float top = (1.0f - ProfileMenu.clamp01(parentAlpha)) * 16.0f + this.y;
        Object rect = OverlayDraw.makeRect(target, parentAlpha, this.width * half + this.x, this.height * half + top);
        OverlayDraw.drawPanelTinted(rect, this.x, top, this.width, this.height, 24.0f, parentAlpha);
        float blockTop = top + 12.0f;
        this.renderHeader(target, rx, ry, blockTop, parentAlpha);
        float cardX = this.x + 12.0f;
        float cardY = blockTop + 38.0f + 8.0f;
        OverlayDraw.drawPanelTinted(rect, cardX, cardY, 260.0f, 88.0f, 16.0f, parentAlpha);
        float[] metrics = OverlayDraw.iconMetrics(84);
        OverlayDraw.drawIcon(rect, 84, (16.0f - metrics[0]) * half + (cardX += 8.0f), (16.0f - metrics[1]) * half + (cardY += 8.0f) + 2.0f, metrics[0], metrics[1], OverlayDraw.themeColor(24), parentAlpha);
        OverlayDraw.drawText(2, rect, LABEL, cardX + 16.0f + 4.0f, cardY + 3.0f, 14.0f, OverlayDraw.themeColor(24), parentAlpha);
        OverlayDraw.drawText(0, rect, SUBTITLE, cardX, (cardY += 22.0f) + 2.0f, 12.0f, OverlayDraw.themeColor(24), parentAlpha * half);
        this.statusButtonX = cardX;
        this.statusButtonY = cardY + 22.0f;
        this.statusButtonWidth = 244.0f;
        this.statusButtonHeight = 30.0f;
        this.renderStatusButton(target, rx, ry, parentAlpha);
        this.statusMenu.renderOverlay(target, rx, ry, parentAlpha);
    }

    public void renderHeader(Object target, float rx, float ry, float blockTop, float alpha) {
        float titleWidth;
        ProfileMenu.renderBlock(this.block, target, blockTop, alpha);
        float tint = ProfileMenu.advance(this.presenceColor, this.now());
        ProfileMenu.mixColor(this.presenceColor.colorFrom, this.presenceColor.colorTarget, tint);
        OverlayDraw.drawBox(target, (blockTop += 38.0f) - 2.0f - 8.0f, alpha + 38.0f - 2.0f - 8.0f, 8.0f);
        blockTop += 8.0f;
        float rightEdge = this.x + this.width - 12.0f;
        float copyTop = alpha + 1.0f;
        this.copyRegionX = rightEdge - 16.0f;
        this.copyRegionY = copyTop - 1.0f;
        this.copyRegionWidth = 16.0f;
        this.copyRegionHeight = 16.0f;
        float iconT = 1.0f;
        if (!this.closed && (double)this.copyRegionX <= (double)rx && (double)rx <= (double)(this.copyRegionX + this.copyRegionWidth) && (double)this.copyRegionY <= (double)ry && (double)ry <= (double)(this.copyRegionY + this.copyRegionHeight) && (activeOverlay == null || INPUT_GRACE)) {
            Screen.hoveredWidget = 1;
            String tooltip = 0.5f < this.copiedAnim.current ? TOOLTIP_COPIED : TOOLTIP_COPY;
            OverlayDraw.tooltip(tooltip, this.copyRegionX, this.copyRegionY, this.copyRegionWidth);
        } else {
            iconT = 0.0f;
        }
        if (this.copyHoverAnim.target != iconT) {
            ProfileMenu.animate(this.copyHoverAnim, iconT);
        }
        float copied = ProfileMenu.advance(this.copiedAnim, this.now());
        ProfileMenu.advance(this.copyHoverAnim, this.now());
        if (copied < 0.999f) {
            OverlayDraw.applyTheme();
            ProfileMenu.drawIconInBox(target, 37, this.copyRegionX, this.copyRegionY, 16.0f, alpha);
        }
        if (0.001f < copied) {
            OverlayDraw.applyTheme();
            ProfileMenu.drawIconInBox(target, 12, this.copyRegionX, this.copyRegionY, 16.0f, alpha);
        }
        if ((titleWidth = this.copyRegionX - 4.0f - blockTop) <= 0.0f) {
            titleWidth = 0.0f;
        }
        OverlayDraw.applyTheme();
        OverlayDraw.drawText(4, target, OverlayDraw.truncate(this.block.pinnedText, titleWidth, 14.0f), blockTop);
        float statusWidth = rightEdge - blockTop;
        if (statusWidth <= 0.0f) {
            statusWidth = 0.0f;
        }
        OverlayDraw.applyTheme();
        OverlayDraw.drawText(2, target, OverlayDraw.truncate(this.block.statusText, statusWidth, 12.0f), blockTop);
    }

    public void renderStatusButton(Object target, float rx, float ry, float alpha) {
        OverlayDraw.drawStatusButton(target, this.statusButtonX, this.statusButtonY, this.statusButtonWidth, this.statusButtonHeight, 10.0f, alpha, 0);
        float hover = 1.0f;
        if (this.closed || (double)rx < (double)this.statusButtonX || (double)(this.statusButtonX + this.statusButtonWidth) < (double)rx || (double)ry < (double)this.statusButtonY || (double)(this.statusButtonY + this.statusButtonHeight) < (double)ry || activeOverlay != null && !INPUT_GRACE) {
            if (this.statusMenu.alpha <= 0.001f && this.statusMenu.alphaTarget <= 0.001f) {
                hover = 0.0f;
            }
        } else {
            Screen.hoveredWidget = 1;
        }
        if (this.statusHoverAnim.target != hover) {
            ProfileMenu.animate(this.statusHoverAnim, hover);
        }
        float buttonX = this.statusButtonX + 2.0f;
        float buttonY = this.statusButtonY + 2.0f;
        float buttonWidth = this.statusButtonWidth - 4.0f;
        float buttonTop = buttonY;
        float eased = ProfileMenu.advance(this.statusHoverAnim, this.now());
        int accent = OverlayDraw.accentColor();
        OverlayDraw.applyTheme();
        int tinted = ProfileMenu.mixColor(accent, OverlayDraw.themeColor(8), 0.85f);
        int border = ProfileMenu.mixColor(accent, tinted, eased);
        OverlayDraw.drawPanelRect(target, buttonX, buttonY, buttonWidth, 26.0f, 8.0f, border, 0, 0, 0, 24.0f, 0.5f, alpha);
        int dotColor = ProfileMenu.mixColor(this.presenceColor.colorFrom, this.presenceColor.colorTarget, this.presenceColor.current);
        OverlayDraw.drawBox(target, buttonX + 8.0f, (buttonY += 13.0f) - 2.0f, 4.0f, 4.0f, 2.0f, 2.0f, 2.0f, 2.0f, dotColor, 0, 0, 0, 0, 0, 0, alpha, 0);
        float pulse = ProfileMenu.advance(this.presenceAnim, this.now());
        float labelY = buttonY - 6.0f;
        buttonX = buttonX + 8.0f + 4.0f + 4.0f;
        float fade = 1.0f - pulse;
        if (pulse < 0.999f) {
            OverlayDraw.applyTheme();
            OverlayDraw.drawText(5, target, StatusMenu.labelFor(this.presencePrevious), buttonX, labelY - pulse * 4.0f, 12.0f, OverlayDraw.themeColor(24), ProfileMenu.powf(ProfileMenu.clamp01(fade)) * alpha);
        }
        OverlayDraw.applyTheme();
        OverlayDraw.drawText(5, target, StatusMenu.labelFor(this.presence), buttonX, fade * 4.0f + labelY, 12.0f, OverlayDraw.themeColor(24), ProfileMenu.powf(ProfileMenu.clamp01(pulse)) * alpha);
        OverlayDraw.applyTheme();
        ProfileMenu.drawIconInBox(target, 11, buttonWidth + buttonTop - 8.0f - 16.0f, buttonY - 8.0f, 16.0f, alpha);
    }

    @Override
    public boolean onMouseClicked(double mx, double my, int button) {
        if (button == 0) {
            if ((double)this.copyRegionX <= mx && mx <= (double)(this.copyRegionX + this.copyRegionWidth) && (double)this.copyRegionY <= my && my <= (double)(this.copyRegionY + this.copyRegionHeight)) {
                OverlayDraw.playSound(14);
                OverlayDraw.copyToClipboard(this.block.pinnedText);
                this.copiedAnim.from = 1.0f;
                this.copiedAnim.current = 1.0f;
                this.copiedAnim.target = 1.0f;
                this.copiedAnim.running = false;
                ProfileMenu.animateDelayed(this.copiedAnim, 0.0f, 1.2f);
                return true;
            }
            if ((double)this.statusButtonX <= mx && mx <= (double)(this.statusButtonX + this.statusButtonWidth) && (double)this.statusButtonY <= my && my <= (double)(this.statusButtonY + this.statusButtonHeight)) {
                OverlayDraw.playSound(14);
                if ((0.001f < this.statusMenu.alpha || 0.001f < this.statusMenu.alphaTarget) && !this.statusMenu.closed) {
                    this.statusMenu.close();
                    return true;
                }
                this.statusMenu.selectedStatus = this.presence;
                this.statusMenu.rebuild();
                for (StatusMenu.Row row : this.statusMenu.rows) {
                    float rowHeight;
                    float layoutY;
                    if (row.id != this.statusMenu.selectedStatus) continue;
                    this.statusMenu.selectYAnim.from = layoutY = row.layoutY;
                    this.statusMenu.selectYAnim.current = layoutY;
                    this.statusMenu.selectYAnim.target = layoutY;
                    this.statusMenu.selectYAnim.running = false;
                    this.statusMenu.selectHeightAnim.from = rowHeight = row.height;
                    this.statusMenu.selectHeightAnim.current = rowHeight;
                    this.statusMenu.selectHeightAnim.target = rowHeight;
                    this.statusMenu.selectHeightAnim.running = false;
                }
                for (StatusMenu.Row row : this.statusMenu.rows) {
                    float value;
                    row.highlight.from = value = row.id == this.statusMenu.selectedStatus ? 1.0f : 0.5f;
                    row.highlight.current = value;
                    row.highlight.target = value;
                    row.highlight.running = false;
                }
                this.statusMenu.setChildAlt(new StatusListLayout(this));
            }
        }
        return true;
    }

    @Override
    public void onClosed() {
        if ((0.001f < this.statusMenu.alpha || 0.001f < this.statusMenu.alphaTarget) && !this.statusMenu.closed) {
            this.statusMenu.close();
        }
    }

    @Override
    public void dispose() {
        this.statusMenu.dispose();
        super.dispose();
    }

    public void toggleStatusList() {
        this.statusListOpen = !this.statusListOpen;
    }

    public boolean isStatusListOpen() {
        return this.statusListOpen;
    }

    public ProfileBlock block() {
        return this.block;
    }

    public StatusMenu statusMenu() {
        return this.statusMenu;
    }

    private static float powf(float value) {
        return (float)Math.pow(value, 1.7f);
    }

    private static void animateDelayed(AbstractOverlay.Animator animator, float target, float delay) {
        float current;
        if (animator.target == target) {
            return;
        }
        long time = System.nanoTime();
        animator.from = current = ProfileMenu.advance(animator, time);
        animator.running = true;
        animator.target = target;
        animator.start = time + (long)((double)delay * 1.0E9);
    }

    private static void animateColor(AbstractOverlay.ColorAnim animator, int color) {
        if (animator.colorTarget == color) {
            return;
        }
        animator.colorFrom = ProfileMenu.mixColor(animator.colorFrom, animator.colorTarget, animator.current);
        animator.colorTarget = color;
        animator.from = 0.0f;
        animator.current = 0.0f;
        animator.target = 0.0f;
        animator.running = false;
        ProfileMenu.animate(animator, 1.0f);
    }

    private static void drawIconInBox(Object target, int icon, float x, float y, float boxSize, float alpha) {
        float[] metrics = OverlayDraw.iconMetrics(icon);
        OverlayDraw.drawIcon(target, icon, (boxSize - metrics[0]) * 0.5f + x, (boxSize - metrics[1]) * 0.5f + y, metrics[0], metrics[1], OverlayDraw.themeColor(24), alpha);
    }

    private static void renderBlock(ProfileBlock block, Object target, float blockY, float alpha) {
    }

    private static int colorForPresence(int value) {
        if (value == 1) {
            return -13919642;
        }
        if (value == 2) {
            return -17896;
        }
        if (value == 3) {
            return -2276315;
        }
        return -8158333;
    }

    private static Object presenceSource() {
        return null;
    }

    private static boolean presenceBound(Object source) {
        return source != null;
    }

    private static Object presenceCallback(Object source) {
        return null;
    }

    private static int presenceValue(Object callback) {
        return 1;
    }

    private static int readPresence() {
        Object source = ProfileMenu.presenceSource();
        if (!ProfileMenu.presenceBound(source)) {
            return 1;
        }
        Object callback = ProfileMenu.presenceCallback(source);
        if (callback == null) {
            return 1;
        }
        return ProfileMenu.presenceValue(callback);
    }

    public static interface PresenceListener {
        public void onPresence(int var1);
    }

    private static final class OverlayDraw {
        public static final int THEME_OFFSET_00 = 0;
        public static final int THEME_OFFSET_04 = 4;
        public static final int THEME_OFFSET_08 = 8;
        public static final int THEME_OFFSET_0C = 12;
        public static final int THEME_OFFSET_10 = 16;
        public static final int THEME_OFFSET_14 = 20;
        public static final int THEME_OFFSET_18 = 24;
        public static final float ACCENT_TINT_MAIN = 0.9f;
        public static final float ACCENT_TINT_ALT = 0.55f;
        public static final float BORDER_TINT = 0.08f;
        public static boolean THEME_GATE_A = false;
        public static boolean THEME_GATE_B = false;
        public static boolean THEME_GATE_C = false;
        public static boolean THEME_GATE_D = false;

        private OverlayDraw() {
        }

        public static Object makeRect(Object target, float alpha, float centerX, float centerY) {
            return null;
        }

        public static void drawPanelTinted(Object target, float x, float y, float w, float h, float radius, float alpha) {
        }

        public static void drawPanelRect(Object target, float x, float y, float w, float h, float radius, int fill, int arg8, int arg9, int arg10, float arg11, float arg12, float alpha) {
        }

        public static void drawBox(Object target, float x, float y, float w, float h, float radiusA, float radiusB, float radiusC, float radiusD, int color, int arg11, int arg12, int arg13, int arg14, int arg15, int arg16, float alpha, int flags) {
        }

        public static void drawBox(Object target, float x, float y, float w) {
        }

        public static void drawStatusButton(Object target, float x, float y, float w, float h, float radius, float alpha, int selected) {
        }

        public static void drawIcon(Object target, int icon, float x, float y, float w, float h, int color, float alpha) {
        }

        public static void drawText(int align, Object target, String text, float x, float y, float size, int color, float alpha) {
        }

        public static void drawText(int align, Object target, String text, float x) {
        }

        public static float[] iconMetrics(int icon) {
            return new float[2];
        }

        public static String truncate(String text, float maxWidth, float size) {
            return text;
        }

        public static void tooltip(String text, float x, float y, float width) {
        }

        public static void copyToClipboard(String text) {
        }

        public static void playSound(int id) {
        }

        public static void applyTheme() {
        }

        public static int themeColor(int offset) {
            return 0;
        }

        public static int accentColor() {
            if (THEME_GATE_A && THEME_GATE_B && THEME_GATE_C && !THEME_GATE_D) {
                return OverlayDraw.themeTint(OverlayDraw.themeColor(8), 0.55f);
            }
            return OverlayDraw.themeTint(OverlayDraw.themeColor(0), 0.9f);
        }

        public static int themeTint(int color, float factor) {
            return 0;
        }
    }

    public static final class StatusListLayout
    extends Component {
        public static final long RVA_INVOKE = 2735201404176L;
        public static final float CHILD_GAP = 8.0f;
        protected final ProfileMenu owner;

        public StatusListLayout(ProfileMenu owner) {
            this.owner = owner;
        }

        @Override
        public float getX() {
            return this.owner.width + this.owner.x + 8.0f;
        }

        @Override
        public float getY() {
            float centered = this.owner.statusButtonHeight * 0.5f + this.owner.statusButtonY - this.owner.statusMenu.height * 0.5f;
            float bottom = this.owner.height + this.owner.y - this.owner.statusMenu.height;
            if (centered <= bottom) {
                bottom = centered;
            }
            return bottom;
        }
    }
}

