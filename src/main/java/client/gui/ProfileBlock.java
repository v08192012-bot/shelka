/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.AbstractSidebarBlock;
import client.gui.Screen;

public class ProfileBlock
extends AbstractSidebarBlock {
    public static final int VTABLE_RVA = 12611912;
    public static final int TEXT_A_OFFSET = 136;
    public static final int TEXT_A_SIZE_OFFSET = 152;
    public static final int TEXT_A_CAP_OFFSET = 160;
    public static final int TEXT_B_OFFSET = 168;
    public static final int TEXT_B_SIZE_OFFSET = 184;
    public static final int TEXT_B_CAP_OFFSET = 192;
    public static final int HOVERED_FLAG_OFFSET = 24;
    public static final int FLAG_C8_OFFSET = 200;
    public static final int HOVER_ANIM_OFFSET = 208;
    public static final int HOVER_ANIM_FROM_OFFSET = 208;
    public static final int HOVER_ANIM_CURRENT_OFFSET = 212;
    public static final int HOVER_ANIM_TARGET_OFFSET = 216;
    public static final int HOVER_ANIM_DURATION_OFFSET = 220;
    public static final int HOVER_ANIM_EASING_OFFSET = 224;
    public static final int HOVER_ANIM_LAST_TICK_OFFSET = 232;
    public static final int HOVER_ANIM_RUNNING_OFFSET = 240;
    public static final int VALUE_F8_OFFSET = 248;
    public static final int VALUE_100_OFFSET = 256;
    public static final int VALUE_108_OFFSET = 264;
    public static final int LIST_A_BEGIN_OFFSET = 272;
    public static final int LIST_A_END_OFFSET = 280;
    public static final int LIST_A_CAP_OFFSET = 288;
    public static final int LIST_B_BEGIN_OFFSET = 296;
    public static final int LIST_B_END_OFFSET = 304;
    public static final int LIST_B_CAP_OFFSET = 312;
    public static final int VALUE_140_OFFSET = 320;
    public static final int VALUE_148_OFFSET = 328;
    public static final int VALUE_150_OFFSET = 336;
    public static final int ENTRY_A_OFFSET = 344;
    public static final int ENTRY_B_OFFSET = 352;
    public static final int SETTINGS_MENU_OFFSET = 360;
    public static final int PROFILE_MENU_OFFSET = 960;
    public static final int VALUE_820_OFFSET = 2080;
    public static final int VALUE_828_OFFSET = 2088;
    public static final int EASE_OUT_CUBIC = 0;
    public static final float BLOCK_WIDTH = 208.0f;
    public static final float BLOCK_HEIGHT = 38.0f;
    public static final float LABEL = 1.0f;
    public static final float HOVER_DIM = 0.82f;
    public static final float HOVER_NONE = 0.0f;
    public static final float HOVER_ANIM_DURATION = 0.15f;
    public static final float HOVER_EPSILON = 0.001f;
    public static final float AVATAR_INSET = 3.0f;
    public static final float AVATAR_BOX_SIZE = 32.0f;
    public static final float AVATAR_GAP = 16.0f;
    public static final float EDGE_PAD = 8.0f;
    public static final float ROW_HEIGHT = 38.0f;
    public static final float TITLE_SIZE = 14.0f;
    public static final float STATUS_SIZE = 12.0f;
    public static final float HALF = 0.5f;
    public static final int TEXT_ALIGN_RIGHT = 4;
    public static final int TEXT_ALIGN_CENTER = 2;
    public static final long AVATAR_REQUEST_INTERVAL = 30000000000L;
    private static final float EPSILON = 0.001f;
    public String pinnedText = "";
    public String statusText = "";
    public boolean flagC8 = false;
    public boolean hoveredFlag = false;
    public Anim hoverAnim = Anim.init(0.0f, 0.15f, 0);
    public long valueF8 = 0L;
    public long value100 = 0L;
    public long value108 = 0L;
    public long listABegin = 0L;
    public long listAEnd = 0L;
    public long listACap = 0L;
    public long listBBegin = 0L;
    public long listBEnd = 0L;
    public long listBCap = 0L;
    public long value140 = 0L;
    public long value148 = 0L;
    public long value150 = 0L;
    public Object entryA = null;
    public Object entryB = null;
    public Object settingsMenu = ProfileBlock.newSettingsMenu();
    public Object profileMenu = ProfileBlock.newProfileMenu(this);
    public long value820 = 0L;
    public long value828 = 0L;
    private static Object avatarTexture;
    private static boolean avatarRequestPending;
    private static boolean avatarDirect;
    private static long avatarRequestStamp;

    public ProfileBlock() {
        super("", 208.0f, 38.0f);
    }

    @Override
    public void dispose() {
        if (avatarTexture != null && ProfileBlock.hasGlContext()) {
            ProfileBlock.deleteTextures(avatarTexture);
        }
        avatarTexture = null;
        avatarRequestPending = false;
        ProfileBlock.clearString(this.pinnedText);
        ProfileBlock.clearString(this.statusText);
        ProfileBlock.freeString(this.statusText);
        ProfileBlock.freeString(this.pinnedText);
        ProfileBlock.clearString(this.label);
        ProfileBlock.freeString(this.label);
        super.dispose();
    }

    @Override
    public void render(Object mat, float x, float y, float alpha) {
        float value;
        boolean hovered;
        if (x < this.x || this.x + this.width < x || y < this.y || this.y + this.height < y || Screen.focusedWidget != null && !Screen.allowHover) {
            hovered = false;
        } else {
            hovered = true;
            Screen.hoveredWidget = 1;
        }
        this.hoveredFlag = hovered;
        float target = 1.0f;
        if (!this.flagC8) {
            target = 0.82f;
            if (!hovered) {
                target = 0.0f;
            }
        }
        if (this.hoverAnim.target != target) {
            long time = this.now();
            this.hoverAnim.from = this.hoverAnim.advance(time);
            this.hoverAnim.target = target;
            this.hoverAnim.lastTick = time;
            this.hoverAnim.animating = true;
        }
        if (0.001f < (value = this.hoverAnim.advance(this.now()))) {
            ProfileBlock.applyTheme();
            ProfileBlock.drawBlockPanel(mat, this.x, this.y, this.width);
        }
        float gap = 8.0f;
        float left = this.x + 16.0f - 8.0f;
        this.renderAvatar(mat, (this.x - 3.0f - left) * this.fade + left, this.y);
        left = left + 38.0f + gap;
        float textWidth = this.width + this.x - 8.0f - left;
        if (textWidth <= 0.0f) {
            textWidth = 0.0f;
        }
        if (0.0f < textWidth && 0.001f < (1.0f - this.fade) * alpha) {
            String first = ProfileBlock.ellipsize(this.pinnedText, textWidth, 14.0f);
            String second = ProfileBlock.ellipsize(this.statusText, textWidth, 12.0f);
            ProfileBlock.setScissor(left, this.y, textWidth, 38.0f);
            ProfileBlock.applyTheme();
            ProfileBlock.drawText(mat, 4, first, left);
            ProfileBlock.applyTheme();
            ProfileBlock.drawText(mat, 2, second, left);
            ProfileBlock.resetScissor();
        }
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
        return false;
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

    private void renderAvatar(Object mat, float x, float y) {
        float fontSize = 14.0f;
        ProfileBlock.drawAvatarCircle(mat, x, y);
        float insetX = x + 3.0f;
        float insetY = y + 3.0f;
        ProfileBlock.beginAvatarQuad();
        float boxSize = 32.0f;
        ProfileBlock.drawAvatarPlaceholder(mat, insetX, insetY, 32.0f);
        if (!avatarDirect) {
            if (avatarTexture != null) {
                ProfileBlock.drawTexture(mat, avatarTexture, insetX, insetY);
                return;
            }
            long time = this.now();
            if (!(avatarRequestPending || avatarRequestStamp != 0L && time - avatarRequestStamp != 30000000000L && time - avatarRequestStamp <= 29999999999L)) {
                avatarRequestPending = true;
                avatarRequestStamp = time;
                ProfileBlock.submitAvatarRequest(this.pinnedText);
            }
        }
        String letter = "";
        for (int index = 0; index < this.pinnedText.length(); ++index) {
            char c = this.pinnedText.charAt(index);
            if (!Character.isLetterOrDigit(c)) continue;
            letter = String.valueOf(Character.toUpperCase(c));
            break;
        }
        if (!letter.isEmpty()) {
            float measured = ProfileBlock.measureText(letter, fontSize);
            float offset = (boxSize - measured) * 0.5f;
            ProfileBlock.applyTheme();
            ProfileBlock.drawText(mat, 4, letter, offset + insetX);
        }
    }

    private static Object newSettingsMenu() {
        return null;
    }

    private static Object newProfileMenu(Object owner) {
        return null;
    }

    private static void clearString(String value) {
    }

    private static void freeString(String value) {
    }

    private static boolean hasGlContext() {
        return false;
    }

    private static void deleteTextures(Object texture) {
    }

    private static void beginAvatarQuad() {
    }

    private static void submitAvatarRequest(String name) {
    }

    private static void drawAvatarCircle(Object mat, float x, float y) {
    }

    private static void drawAvatarPlaceholder(Object mat, float x, float y, float size) {
    }

    private static void drawTexture(Object mat, Object texture, float x, float y) {
    }

    private static float measureText(String text, float size) {
        return 0.0f;
    }

    private static String ellipsize(String text, float width, float size) {
        return text;
    }

    private static void drawBlockPanel(Object mat, float x, float y, float w) {
    }

    private static void drawText(Object mat, int align, String text, float x) {
    }

    private static void setScissor(float x, float y, float w, float h) {
    }

    private static void resetScissor() {
    }

    private static void applyTheme() {
    }

    public static final class Anim {
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

        public float advance(long time) {
            if (!this.animating || this.duration <= 0.0f) {
                this.current = this.target;
                this.animating = false;
                return this.current;
            }
            float k = (float)((double)(time - this.lastTick) / 1.0E9) / this.duration;
            if (k <= 0.0f) {
                this.current = this.from;
                return this.current;
            }
            if (k >= 1.0f) {
                this.animating = false;
                this.current = this.target;
                return this.current;
            }
            this.current = Anim.ease(this.easing, k) * (this.target - this.from) + this.from;
            return this.current;
        }

        private static float ease(int easing, float t) {
            float inv = 1.0f - t;
            return 1.0f - inv * inv * inv;
        }
    }
}

