/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.Component;
import client.gui.ModuleCard;
import client.gui.Screen;
import java.util.ArrayList;
import java.util.List;

public class ModulesGridPart
extends Component {
    public static final int VTABLE_RVA = 12601136;
    public static final int RECT_ANIM_OFFSET = 32;
    public static final int OWNED_BUFFER_A_OFFSET = 72;
    public static final int OWNED_BUFFER_B_OFFSET = 80;
    public static final int FLAG_58_OFFSET = 88;
    public static final int CARDS_OFFSET = 96;
    public static final int COLUMNS_OFFSET = 120;
    public static final int SCROLL_ANIM_OFFSET = 144;
    public static final int SCROLL_OFFSET = 184;
    public static final int CONTENT_HEIGHT_OFFSET = 188;
    public static final int COLUMN_WIDTH_OFFSET = 192;
    public static final int DRAGGING_OFFSET = 196;
    public static final int DRAG_ANCHOR_OFFSET = 200;
    public static final int BAND_TOP_OFFSET = 204;
    public static final int BAND_BOTTOM_OFFSET = 208;
    public static final int CATEGORY_OFFSET = 296;
    public static final int FAVORITES_OFFSET = 304;
    public static final int FAVORITES_SCROLL_OFFSET = 308;
    public static final int CARD_HEIGHT_OFFSET = 16;
    public static final int CARD_ANIM_OFFSET = 920;
    public static final int CARD_VISIBLE_OFFSET = 118;
    public static final float DEFAULT_WIDTH = 964.0f;
    public static final float COLUMN_WIDTH = 305.0f;
    public static final float COLUMN_GAP = 8.0f;
    public static final float GRID_PADDING = 16.0f;
    public static final float BAND_INSET = 2.0f;
    public static final float SCROLL_STEP = 48.0f;
    public static final float SCROLLBAR_MIN_HEIGHT = 59.0f;
    public static final float SCROLLBAR_INSET = 4.0f;
    public static final float SCROLLBAR_GAP = 6.0f;
    public static final float SCROLLBAR_WIDTH = 3.0f;
    public static final float SCROLLBAR_PADDING = 64.0f;
    public static final float VIEWPORT_RATIO = 0.0625f;
    public static final float EPSILON = 0.001f;
    public static final float FADE_DURATION = 0.28f;
    public static final float HALF = 0.5f;
    public static final int COLUMN_COUNT = 3;
    public static final int HOVER_GRID = 1;
    public static final int HOVER_SCROLLBAR = 4;
    protected final Anim rectAnim = new Anim();
    protected long ownedBufferA;
    protected long ownedBufferB;
    protected byte flag58;
    protected final List<ModuleCard> cards = new ArrayList<ModuleCard>();
    protected final List<Integer> columns = new ArrayList<Integer>();
    protected final Anim scrollAnim = new Anim();
    protected float scroll;
    protected float contentHeight;
    protected float columnWidth = 305.0f;
    protected boolean dragging;
    protected float dragAnchor;
    protected float bandTop;
    protected float bandBottom;
    protected Object category;
    protected boolean favorites;
    protected float favoritesScroll;
    private static final float RECT_ANIM_DURATION = 0.15f;

    public ModulesGridPart() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.width = 0.0f;
        this.height = 0.0f;
        this.flags = 256;
        this.rectAnim.set(0.0f, 0.15f);
        this.ownedBufferA = 0L;
        this.ownedBufferB = 0L;
        this.flag58 = 0;
        this.scrollAnim.from = 0.0f;
        this.scrollAnim.current = 0.0f;
        this.scrollAnim.target = 0.0f;
        this.scrollAnim.duration = 0.28f;
        this.scrollAnim.easing = 1;
        this.scrollAnim.start = Anim.now();
        this.scrollAnim.running = false;
        this.scroll = 0.0f;
        this.columnWidth = 305.0f;
        this.dragging = false;
        this.category = null;
        this.favorites = false;
        this.favoritesScroll = 0.0f;
        this.width = 964.0f;
    }

    @Override
    public void dispose() {
        ModulesGridPart.clearCards();
        ModulesGridPart.clearColumns();
        super.dispose();
    }

    public void setModules(List<?> modules) {
        if (!this.cards.isEmpty()) {
            ModulesGridPart.destroyCards();
        }
        for (Object module : modules) {
            ModuleCard card = new ModuleCard(module);
            if (0.001f < Math.abs(card.width - this.columnWidth)) {
                card.width = this.columnWidth;
                ModulesGridPart.cardRemeasure(card);
            }
            ModulesGridPart.setModuleEnabled(card.feature, ModulesGridPart.moduleEnabled(module));
            float target = !ModulesGridPart.cardAvailable(card) || !ModulesGridPart.featureEnabled(card.feature) ? 0.0f : 1.0f;
            ModulesGridPart.cardSnapReveal(card, target);
            this.cards.add(card);
        }
        this.syncColumns();
        this.scroll = 0.0f;
        this.scrollAnim.target = 0.0f;
        this.contentHeight = 0.0f;
        this.dragging = false;
    }

    @Override
    public void render(Object mat, float mouseX, float mouseY, float alpha) {
        boolean clip;
        for (ModuleCard card : this.cards) {
            float target = !ModulesGridPart.cardAvailable(card) || !ModulesGridPart.featureEnabled(card.feature) ? 0.0f : 1.0f;
            ModulesGridPart.cardDriveReveal(card, target);
        }
        this.syncColumns();
        float offset = this.scrollAnim.advance(Anim.now());
        float pad = 8.0f;
        float originX = this.x + 16.0f;
        float originY = this.y - offset;
        float bandH = this.height - 2.0f;
        this.bandTop = this.y;
        if (bandH <= 0.0f) {
            bandH = 0.0f;
        }
        float columnPitch = this.columnWidth + pad;
        this.bandBottom = this.y + bandH;
        float scrolled = -1.0E9f;
        if (this.y <= mouseY && mouseY <= this.y + bandH) {
            scrolled = mouseY;
        }
        float viewTop = ModulesGridPart.clamp01(offset * 0.0625f);
        float maxScroll = this.contentHeight - this.height;
        if (maxScroll <= 0.0f) {
            maxScroll = 0.0f;
        }
        float viewBottom = ModulesGridPart.clamp01((maxScroll - offset) * 0.0625f);
        boolean bl = clip = viewTop > 0.001f || viewBottom > 0.001f;
        if (clip) {
            ModulesGridPart.drawScrollHint();
        }
        float clipHeight = bandH + 6.0f;
        ModulesGridPart.pushScissor(this.x, this.y - 6.0f, this.width, clipHeight);
        float[] columnHeights = new float[3];
        for (int i = 0; i < this.cards.size(); ++i) {
            float columnY;
            ModuleCard card = this.cards.get(i);
            int column = i < this.columns.size() ? this.columns.get(i) : 0;
            float cardHeight = ModulesGridPart.cardPreferredHeight(card);
            card.y = columnY = columnHeights[column] + originY;
            card.x = (float)column * columnPitch + originX;
            ModulesGridPart.cardArrange(card);
            if (this.y < columnY + cardHeight && columnY < this.y + bandH) {
                card.render(mat, mouseX, scrolled, alpha);
            }
            columnHeights[column] = cardHeight + pad + columnHeights[column];
        }
        ModulesGridPart.popScissor();
        ModulesGridPart.pushScissor(this.x, this.y - 6.0f, this.width, clipHeight);
        for (ModuleCard card : this.cards) {
            card.layout(mat, mouseX, mouseY, alpha);
        }
        ModulesGridPart.popScissor();
        if (clip) {
            ModulesGridPart.drawScrollbarTrack(mouseY, viewTop, viewBottom, originX, this.bandTop, this.bandBottom);
        }
        float content = 0.0f;
        for (int i = 0; i < 3; ++i) {
            if (!(content < columnHeights[i])) continue;
            content = columnHeights[i];
        }
        this.contentHeight = content;
        ModulesGridPart.layoutScrollbar();
        if (this.dragging) {
            Screen.hoveredWidget = 4;
        } else if (ModulesGridPart.scrollbarContains(mouseX, mouseY) && (Screen.focusedInput == null || Screen.allowHover)) {
            Screen.hoveredWidget = 1;
        }
        float overflow = this.contentHeight - this.height;
        if (overflow <= 0.0f) {
            overflow = 0.0f;
        }
        if (0.001f < overflow) {
            float track = this.height - 2.0f - 16.0f;
            if (track <= 0.0f) {
                track = 0.0f;
            }
            if (59.0f < track) {
                Object thumb = ModulesGridPart.scrollbarThumb(this.y + pad, track, 59.0f, offset);
                ModulesGridPart.drawScrollbar(mat, this.x + this.width - 4.0f - 6.0f, thumb, alpha);
            }
        }
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        for (ModuleCard card : this.cards) {
            if (!ModulesGridPart.cardAcceptsInput(card)) continue;
            if (card.mouseClicked(mx, my, button)) {
                return true;
            }
            for (Component child : ModulesGridPart.cardChildren(card)) {
                if (!ModulesGridPart.invokeWidgetMouseClicked(child, mx, my, button)) continue;
                ModulesGridPart.invokeWidgetMouseReleased(child, mx, my, button);
            }
            return true;
        }
        if (button == 0 && ModulesGridPart.scrollbarContains(mx, my)) {
            this.dragging = true;
            this.dragAnchor = (float)my - ModulesGridPart.scrollbarOffset();
            return true;
        }
        if (this.x <= (float)mx && mx <= (double)(this.x + this.width) && this.bandTop <= (float)my && my <= (double)this.bandBottom) {
            for (ModuleCard card : this.cards) {
                if (!card.mouseClicked(mx, my, button)) continue;
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
        for (ModuleCard card : this.cards) {
            if (card.mouseReleased(mx, my, button)) {
                return true;
            }
            for (Component child : ModulesGridPart.cardChildren(card)) {
                if (!ModulesGridPart.invokeWidgetMouseReleased(child, mx, my, button)) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean mouseDragged(double mx, double my, int button) {
        return this.mouseDragged(mx, my, button, 0.0, 0.0);
    }

    public boolean mouseDragged(double mx, double my, int buttons, double deltaX, double deltaY) {
        float track;
        if (!this.dragging || buttons != 0) {
            for (ModuleCard card : this.cards) {
                if (!card.mouseDragged(mx, my, buttons, deltaX, deltaY)) continue;
                return true;
            }
            return false;
        }
        float maxScroll = this.contentHeight - this.height;
        if (maxScroll <= 0.0f) {
            maxScroll = 0.0f;
        }
        if ((track = this.height - 2.0f - 16.0f) <= 0.0f) {
            track = 0.0f;
        }
        float value = 0.0f;
        if (0.0f < track - 59.0f) {
            value = ((float)my - this.dragAnchor - (this.y + 8.0f)) / (track - 59.0f) * maxScroll;
            if (value < 0.0f) {
                value = 0.0f;
            }
            if (value > maxScroll) {
                value = maxScroll;
            }
        }
        this.scroll = value;
        this.scrollAnim.retarget(value);
        return true;
    }

    @Override
    public boolean mouseScrolled(double mx, double my, double amount) {
        float value;
        if (!(this.x <= (float)mx && mx <= (double)(this.x + this.width) && this.y <= (float)my && my <= (double)(this.y + this.height))) {
            return true;
        }
        for (ModuleCard card : this.cards) {
            if (!card.mouseScrolled(mx, my, amount)) continue;
            return true;
        }
        float maxScroll = this.contentHeight - this.height;
        if (maxScroll <= 0.0f) {
            maxScroll = 0.0f;
        }
        this.scroll = value = ModulesGridPart.clamp(this.scroll - (float)amount * 48.0f, 0.0f, maxScroll);
        if (this.scrollAnim.target != value) {
            this.scrollAnim.advance(Anim.now());
            this.scrollAnim.target = value;
            this.scrollAnim.start = Anim.now();
            this.scrollAnim.running = true;
        }
        return true;
    }

    @Override
    public boolean keyPressed(int key, int modifiers) {
        for (ModuleCard card : this.cards) {
            if (card.keyPressed(key)) {
                return true;
            }
            for (Component child : ModulesGridPart.cardChildren(card)) {
                if (!ModulesGridPart.invokeWidgetKeyPressed(child, key)) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean keyReleased(int key) {
        for (ModuleCard card : this.cards) {
            if (card.keyReleased(key)) {
                return true;
            }
            for (Component child : ModulesGridPart.cardChildren(card)) {
                if (!ModulesGridPart.invokeWidgetKeyReleased(child, key)) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean charTyped(char codePoint) {
        for (ModuleCard card : this.cards) {
            for (Component child : ModulesGridPart.cardChildren(card)) {
                if (!ModulesGridPart.invokeWidgetCharTyped(child, codePoint)) continue;
                return true;
            }
        }
        return false;
    }

    private void syncColumns() {
        while (this.columns.size() < this.cards.size()) {
            this.columns.add(0);
        }
        while (this.columns.size() > this.cards.size()) {
            this.columns.remove(this.columns.size() - 1);
        }
        float[] heights = new float[3];
        for (int i = 0; i < this.cards.size(); ++i) {
            int column;
            int n = column = heights[1] < heights[0] ? 1 : 0;
            if (heights[2] < heights[column]) {
                column = 2;
            }
            this.columns.set(i, column);
            heights[column] = ModulesGridPart.cardPreferredHeight(this.cards.get(i)) + 8.0f + heights[column];
        }
    }

    private static void cardSnapReveal(ModuleCard card, float target) {
    }

    private static void cardDriveReveal(ModuleCard card, float target) {
    }

    private static float cardPreferredHeight(ModuleCard card) {
        return 0.0f;
    }

    private static void cardArrange(ModuleCard card) {
    }

    private static void cardRemeasure(ModuleCard card) {
    }

    private static boolean cardAcceptsInput(ModuleCard card) {
        return false;
    }

    private static boolean cardAvailable(ModuleCard card) {
        return false;
    }

    private static List<Component> cardChildren(ModuleCard card) {
        return new ArrayList<Component>();
    }

    public List<ModuleCard> cards() {
        return this.cards;
    }

    public boolean favorites() {
        return this.favorites;
    }

    public Object category() {
        return this.category;
    }

    public float contentHeight() {
        return this.contentHeight;
    }

    public void setScroll(float value) {
        this.scroll = value;
    }

    private static boolean moduleEnabled(Object module) {
        return false;
    }

    private static void setModuleEnabled(Object feature, boolean value) {
    }

    private static boolean featureEnabled(Object feature) {
        return false;
    }

    private static float clamp(float value, float min, float max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    private static float clamp01(float value) {
        return ModulesGridPart.clamp(value, 0.0f, 1.0f);
    }

    private static void destroyCards() {
    }

    private static void clearCards() {
    }

    private static void clearColumns() {
    }

    private static void drawScrollHint() {
    }

    private static void drawScrollbarTrack(float mouseY, float viewTop, float viewBottom, float x, float bandTop, float bandBottom) {
    }

    private static Object scrollbarThumb(float y, float track, float minHeight, float offset) {
        return null;
    }

    private static void drawScrollbar(Object mat, float x, Object thumb, float alpha) {
    }

    private static void pushScissor(float x, float y, float width, float height) {
    }

    private static void popScissor() {
    }

    private static boolean scrollbarContains(double mx, double my) {
        return false;
    }

    private static float scrollbarOffset() {
        return 0.0f;
    }

    private static void layoutScrollbar() {
    }

    private static boolean invokeWidgetMouseClicked(Component widget, double mx, double my, int button) {
        return false;
    }

    private static boolean invokeWidgetMouseReleased(Component widget, double mx, double my, int button) {
        return false;
    }

    private static boolean invokeWidgetKeyPressed(Component widget, int key) {
        return false;
    }

    private static boolean invokeWidgetKeyReleased(Component widget, int key) {
        return false;
    }

    private static boolean invokeWidgetCharTyped(Component widget, char codePoint) {
        return false;
    }

    public static final class Anim {
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
}

