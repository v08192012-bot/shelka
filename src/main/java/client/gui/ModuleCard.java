/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.Setting;
import client.gui.BindButton;
import client.gui.Component;
import client.gui.FavouriteButton;
import client.gui.Screen;
import client.gui.SwitcherButton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ModuleCard
extends Component {
    public static final int VTABLE_RVA = 12589648;
    public static final long RVA_CTOR = 2735200901440L;
    public static final long RVA_DTOR = 2735200818208L;
    public static final long RVA_DTOR_BODY = 2735200816960L;
    public static final long RVA_RENDER = 2735200903024L;
    public static final long RVA_LAYOUT = 2735200906096L;
    public static final long RVA_MOUSE_CLICKED = 2735200910272L;
    public static final long RVA_MOUSE_RELEASED = 2735200911312L;
    public static final long RVA_MOUSE_DRAGGED = 2735200911616L;
    public static final long RVA_MOUSE_SCROLLED = 2735200912000L;
    public static final long RVA_KEY_PRESSED = 2735200912320L;
    public static final long RVA_KEY_RELEASED = 2735200912608L;
    public static final long RVA_CHAR_TYPED = 2735200912896L;
    public static final long RVA_SET_POSITION = 2735200779184L;
    public static final long RVA_UPDATE_HOVER = 2735200779424L;
    public static final long RVA_ALPHA_TARGET = 2735200902896L;
    public static final long RVA_SYNC_CHILD_WIDTHS = 2735200909488L;
    public static final long RVA_REFRESH_CHILD_FADES = 2735200914736L;
    public static final long RVA_SYNC_CHILD_FADES = 2735200914128L;
    public static final long RVA_CHILD_WEIGHT = 2735200915184L;
    public static final long RVA_CHILD_SHOWN = 2735200908048L;
    public static final long RVA_COLLECT_CHILDREN = 2735200909600L;
    public static final long RVA_PREFERRED_HEIGHT = 2735200906624L;
    public static final long RVA_HEADER_LAYOUT = 2735200907424L;
    public static final long RVA_RENDER_HEADER = 2735200904208L;
    public static final long RVA_RENDER_BADGE = 2735200905264L;
    public static final long RVA_LAYOUT_CHILD_ROW = 2735200908224L;
    public static final long RVA_RENDER_CHILDREN = 2735200908816L;
    public static final long RVA_TEXT_STYLE = 2735200901072L;
    public static final long RVA_ANIM_SET = 2735200856400L;
    public static final long RVA_ANIM_ADVANCE = 2735200831600L;
    public static final long RVA_RECT_ANIM_INIT = 2735200260240L;
    public static final long RVA_SWITCHER_CTOR = 2735200895296L;
    public static final long RVA_FAVOURITE_CTOR = 2735200891280L;
    public static final long RVA_BIND_CTOR = 2735200886464L;
    public static final long RVA_NOW = 2735199714128L;
    public static final int FEATURE_OFFSET = 96;
    public static final int SWITCHER_CALLBACK_STORAGE_OFFSET = 208;
    public static final int SWITCHER_CALLBACK_OFFSET = 264;
    public static final int FAVOURITE_CALLBACK_STORAGE_OFFSET = 200;
    public static final int FAVOURITE_CALLBACK_OFFSET = 456;
    public static final int OWNED_CHILDREN_OFFSET = 792;
    public static final int OWNED_CHILDREN_END_OFFSET = 800;
    public static final int OWNED_CHILDREN_CAPACITY_OFFSET = 808;
    public static final int CHILD_FADES_OFFSET = 816;
    public static final int CHILDREN_COLLAPSED_OFFSET = 880;
    public static final int VERSION_LABEL_OFFSET = 888;
    public static final int REVEAL_ANIM_OFFSET = 920;
    public static final int OPEN_ANIM_OFFSET = 960;
    public static final int GLOW_ANIM_OFFSET = 1000;
    public static final int CHILD_PRESS_ANIM_OFFSET = 1040;
    public static final int HIGHLIGHTED_CHILD_OFFSET = 1080;
    public static final int CHILD_WIDTH_OFFSET = 1088;
    public static final int SWITCHER_OFFSET = 104;
    public static final int FAVOURITE_OFFSET = 296;
    public static final int BIND_OFFSET = 504;
    public static final int CHILD_SOURCE_OFFSET = 96;
    public static final int CHILD_TAB_OFFSET = 160;
    public static final int RECT_ANIM_OFFSET = 32;
    public static final int OWNED_BUFFER_A_OFFSET = 72;
    public static final int OWNED_BUFFER_B_OFFSET = 80;
    public static final int FLAG_58_OFFSET = 88;
    public static final float CARD_WIDTH = 305.0f;
    public static final float CLOSED_HEIGHT = 60.0f;
    public static final float HEADER_HEIGHT = 58.0f;
    public static final float HEADER_PAD = 18.0f;
    public static final float HEADER_Y_INSET = 4.0f;
    public static final float HEADER_X_INSET = 6.0f;
    public static final float CHILD_INSET = 36.0f;
    public static final float ROW_GAP = 24.0f;
    public static final float LINK_STEP = 16.0f;
    public static final float LABEL_STEP = 12.0f;
    public static final float ROW_INCREMENT = 22.0f;
    public static final float TEXT_INSET = 8.0f;
    public static final float SWITCHER_GAP = 28.0f;
    public static final float SWITCHER_X_INSET = 4.0f;
    public static final float FAVOURITE_SIZE = 12.0f;
    public static final float BIND_MIN_WIDTH = 46.0f;
    public static final float CHILD_RADIUS = 8.0f;
    public static final float CHILD_HIGHLIGHT_INSET = 6.0f;
    public static final float PANEL_RADIUS = 14.0f;
    public static final float GLOW_RADIUS = 14.0f;
    public static final float GLOW_WIDTH = 2.0f;
    public static final float GLOW_ALPHA = 0.08f;
    public static final float RECT_ANIM_DURATION = 0.15f;
    public static final float REVEAL_DURATION = 0.32f;
    public static final float OPEN_DURATION = 0.22f;
    public static final float FADE_DURATION = 0.5f;
    public static final float ONE = 1.0f;
    public static final float ZERO = 0.0f;
    public static final float HALF = 0.5f;
    public static final float NEAR_ONE = 0.999f;
    public static final float EPSILON = 0.001f;
    public static final int HOVER_MODULE_NAME = 7;
    public static final int SOUND_TOGGLE = 14;
    public static final int ICON_BADGE = 56;
    public static final int ICON_METRICS = 75;
    public static final int TEXT_STYLE_NAME = 5;
    public static final int HEADER_TOGGLE_BUTTON = 1;
    public static final int VERSION_1_21_4 = 1;
    public static final int VERSION_1_21_11 = 2;
    public static final int VERSION_26_2 = 3;
    public static final String VERSION_1_21_4_LABEL = "1.21.4";
    public static final String VERSION_1_21_11_LABEL = "1.21.11";
    public static final String VERSION_26_2_LABEL = "26.2";
    public static final String VERSION_UNKNOWN_LABEL = "unknown";
    public static final String BETA_TOOLTIP = "\u0422\u043e\u043b\u044c\u043a\u043e \u0434\u043b\u044f \u0431\u0435\u0442\u0430-\u0442\u0435\u0441\u0442\u0435\u0440\u043e\u0432";
    public static final String VERSION_TOOLTIP_PREFIX = "\u0422\u043e\u043b\u044c\u043a\u043e \u0441 ";
    protected final Anim rectAnim = new Anim();
    protected long ownedBufferA;
    protected long ownedBufferB;
    protected byte flag58;
    protected Object feature;
    protected SwitcherButton switcher;
    protected FavouriteButton favourite;
    protected BindButton bind;
    protected Object switcherCallback;
    protected Object favouriteCallback;
    protected final byte[] switcherCallbackStorage = new byte[56];
    protected final byte[] favouriteCallbackStorage = new byte[56];
    protected final List<Component> ownedChildren = new ArrayList<Component>();
    protected final Map<Component, Anim> childFades = new HashMap<Component, Anim>();
    protected boolean childrenCollapsed;
    protected String versionLabel = "";
    protected final Anim revealAnim = new Anim();
    protected final Anim openAnim = new Anim();
    protected final Anim glowAnim = new Anim();
    protected final Anim childPressAnim = new Anim();
    protected Component highlightedChild;
    protected float cachedChildWidth;

    public ModuleCard(Object feature) {
        float f;
        this.x = 0.0f;
        this.y = 0.0f;
        this.width = 0.0f;
        this.height = 0.0f;
        this.flags = 256;
        this.rectAnim.set(0.0f, 0.15f);
        this.ownedBufferA = 0L;
        this.ownedBufferB = 0L;
        this.flag58 = 0;
        this.feature = feature;
        this.switcher = new SwitcherButton(ModuleCard.featureToggled(feature));
        this.favourite = new FavouriteButton(ModuleCard.featureFavourite(feature));
        this.bind = new BindButton((Setting)ModuleCard.featureBindTarget(feature));
        this.releaseOwnedChildren();
        this.releaseChildFades();
        this.childrenCollapsed = false;
        this.versionLabel = "";
        this.revealAnim.set(0.0f, 0.32f);
        this.openAnim.set(1.0f, 0.22f);
        this.glowAnim.set(0.0f, 0.5f);
        this.childPressAnim.set(0.0f, 0.5f);
        this.highlightedChild = null;
        this.cachedChildWidth = Float.NaN;
        this.width = 305.0f;
        this.switcher.locked = 1;
        this.switcherCallback = this.createToggleCallback();
        this.favouriteCallback = this.createFavouriteCallback();
        if (ModuleCard.moduleVersionFloor() < ModuleCard.featureVersion(feature)) {
            int version = ModuleCard.featureVersion(feature);
            this.versionLabel = version == 1 ? VERSION_1_21_4_LABEL : (version == 2 ? VERSION_1_21_11_LABEL : (version == 3 ? VERSION_26_2_LABEL : VERSION_UNKNOWN_LABEL));
        }
        this.highlightedChild = null;
        this.releaseOwnedChildren();
        for (Object object : ModuleCard.featureSettings(feature)) {
            Component component = ModuleCard.createSettingWidget(object);
            if (component == null) continue;
            this.ownedChildren.add(component);
        }
        this.syncChildFades();
        this.cachedChildWidth = Float.NaN;
        float collapsedWidth = this.width - 36.0f;
        if (0.001f < Math.abs(collapsedWidth - Float.NaN)) {
            this.cachedChildWidth = collapsedWidth;
            for (Component component : this.ownedChildren) {
                component.width = collapsedWidth;
            }
        }
        float f2 = 0.0f;
        if (!ModuleCard.featureIsOn(feature) || ModuleCard.modulesDimmed()) {
            for (Component child : this.ownedChildren) {
                if (!this.childShown(child)) continue;
                if (!ModuleCard.featureExpandable(feature)) break;
                f2 = 1.0f;
                break;
            }
        }
        this.revealAnim.from = f2;
        this.revealAnim.current = f2;
        this.revealAnim.target = f2;
        this.revealAnim.running = false;
        this.openAnim.from = f = this.featureAlphaTarget();
        this.openAnim.current = f;
        this.openAnim.target = f;
        this.openAnim.running = false;
    }

    @Override
    public void dispose() {
        this.versionLabel = "";
        this.releaseChildFades();
        this.releaseOwnedChildren();
        this.bind.dispose();
        if (this.favouriteCallback != null) {
            ModuleCard.releaseCallback(this.favouriteCallback, this.favouriteCallback != this.favouriteCallbackStorage);
            this.favouriteCallback = null;
        }
        this.favourite.dispose();
        if (this.switcherCallback != null) {
            ModuleCard.releaseCallback(this.switcherCallback, this.switcherCallback != this.switcherCallbackStorage);
            this.switcherCallback = null;
        }
        this.switcher.dispose();
        super.dispose();
    }

    @Override
    public void render(Object mat, float mouseX, float mouseY, float alpha) {
        float revealTarget = 1.0f;
        boolean toggled = ModuleCard.featureToggled(this.feature);
        if (this.switcher.on != toggled) {
            this.switcher.on = toggled;
            this.switcher.target = toggled ? 1.0f : 0.0f;
        }
        this.favourite.selected = ModuleCard.featureFavourite(this.feature);
        this.syncChildWidths();
        this.refreshChildFades();
        float openTarget = this.featureAlphaTarget();
        if (this.openAnim.target != openTarget) {
            this.openAnim.retarget(openTarget);
        }
        float open = this.openAnim.advance(Anim.now()) * alpha;
        if (!this.anyChildShown() || !ModuleCard.featureExpandable(this.feature)) {
            if (!this.childrenCollapsed) {
                for (Component child : this.ownedChildren) {
                    ModuleCard.detachChild(child);
                }
            }
            this.childrenCollapsed = true;
            revealTarget = 0.0f;
        } else {
            this.childrenCollapsed = false;
        }
        if (this.revealAnim.target != revealTarget) {
            this.revealAnim.retarget(revealTarget);
        }
        float reveal = this.revealAnim.advance(Anim.now());
        float preferred = this.measureHeight();
        ModuleCard.drawPanel(mat, this.x, this.y, this.width, preferred, 14.0f, open);
        float glow = this.glowAnim.advance(Anim.now());
        if (0.001f < glow) {
            ModuleCard.drawRoundedBox(mat, this.x, this.y, this.width, preferred, 14.0f, 14.0f, 14.0f, 14.0f, 0, ModuleCard.themeColor(20), 2.0f, 0, 0.0f, 0.0f, 0.0f, glow * alpha, 0);
        }
        float headerY = this.y + 18.0f;
        float headerX = this.x + 18.0f;
        this.renderHeader(mat, mouseX, mouseY, alpha, headerX, headerY);
        if (0.001f < reveal) {
            this.layoutChildRow(headerX, (headerY += 24.0f) + 16.0f);
            if (0.999f <= reveal) {
                this.renderChildren(mat, mouseX, mouseY, reveal * open);
            } else {
                float clipHeight = preferred + this.y - 18.0f - headerY;
                if (clipHeight <= 0.0f) {
                    clipHeight = 0.0f;
                }
                ModuleCard.pushScissor(headerX, headerY, this.width - 36.0f, clipHeight);
                this.renderChildren(mat, mouseX, mouseY, reveal * open);
                ModuleCard.popScissor();
            }
        }
    }

    public void layout(Object mat, float mouseX, float mouseY, float alpha) {
        if (0.001f < this.revealAnim.current) {
            float expand = this.openAnim.current;
            for (Component child : this.ownedChildren) {
                float weight = this.childWeight(child);
                if (!(0.001f < weight)) continue;
                ModuleCard.invokeChildLayout(child, mat, mouseX, mouseY, weight * alpha * expand);
            }
        }
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (0.5f <= this.revealAnim.current) {
            for (Component child : this.collectActiveChildren()) {
                if (!ModuleCard.childAcceptsMouse(child, mx, my) || !child.mouseClicked(mx, my, button)) continue;
                return true;
            }
        }
        if (this.bind.listening && this.bind.mouseClicked(mx, my, button)) {
            return true;
        }
        if (button == 1) {
            float switchY = this.y + 18.0f;
            if ((double)this.x <= mx && mx <= (double)(this.x + this.width) && (double)switchY <= my && my <= (double)(switchY + 24.0f) && this.anyChildShown()) {
                boolean previous = ModuleCard.featureExpandable(this.feature);
                if (this.anyChildShown()) {
                    ModuleCard.setFeatureExpandable(this.feature, !previous);
                }
                ModuleCard.playSound(14);
                return true;
            }
        }
        if (ModuleCard.featureIsOn(this.feature) && !ModuleCard.modulesDimmed()) {
            return false;
        }
        if (ModuleCard.moduleVersionFloor() < ModuleCard.featureVersion(this.feature) || button != 0) {
            if (button != 0) {
                return this.mouseClickedTail(mx, my, button);
            }
        } else {
            if (mx < (double)this.switcher.x || mx > (double)(this.switcher.x + this.switcher.width) || my < (double)this.switcher.y || my > (double)(this.switcher.y + this.switcher.height)) {
                return this.mouseClickedTail(mx, my, button);
            }
            if (this.switcher.press(mx)) {
                return true;
            }
        }
        if ((double)this.favourite.x <= mx && mx <= (double)(this.favourite.x + this.favourite.width) && (double)this.favourite.y <= my && my <= (double)(this.favourite.y + this.favourite.height) && this.favourite.onClick(mx, my)) {
            return true;
        }
        return this.mouseClickedTail(mx, my, button);
    }

    private boolean mouseClickedTail(double mx, double my, int button) {
        if (this.bind.mouseClicked(mx, my, button)) {
            return true;
        }
        if (0.5f >= this.revealAnim.current) {
            for (Component child : this.collectActiveChildren()) {
                if (!child.mouseClicked(mx, my, button)) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean mouseReleased(double mx, double my, int button) {
        if (this.switcher.mouseReleased(mx, my, button)) {
            return true;
        }
        for (Component child : this.collectActiveChildren()) {
            if (!child.mouseReleased(mx, my, button)) continue;
            return true;
        }
        return false;
    }

    public boolean mouseDragged(double mx, double my, int buttons, double deltaX, double deltaY) {
        if (this.switcher.mouseDragged(mx, my, buttons)) {
            return true;
        }
        for (Component child : this.collectActiveChildren()) {
            if (!child.mouseDragged(mx, my, buttons)) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean mouseScrolled(double mx, double my, double amount) {
        if (0.5f <= this.revealAnim.current) {
            for (Component child : this.collectActiveChildren()) {
                if (!child.mouseScrolled(mx, my, amount)) continue;
                return true;
            }
        }
        return false;
    }

    public boolean keyPressed(int keyCode) {
        if (this.bind.keyPressed(keyCode, 0)) {
            return true;
        }
        for (Component child : this.collectActiveChildren()) {
            if (!ModuleCard.invokeChildKeyPressed(child, keyCode)) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean keyReleased(int keyCode) {
        if (this.bind.keyReleased(keyCode)) {
            return true;
        }
        for (Component child : this.collectActiveChildren()) {
            if (!child.keyReleased(keyCode)) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean charTyped(char ch) {
        for (Component child : this.collectActiveChildren()) {
            if (!child.charTyped(ch)) continue;
            return true;
        }
        return false;
    }

    @Override
    public void setPosition(float px, float py) {
        this.x = px;
        this.y = py;
    }

    private float updateHover(float mouseX, float mouseY) {
        float target;
        if (mouseX < this.x || this.x + this.width < mouseX || mouseY < this.y || this.y + this.height < mouseY || Screen.focusedInput != null && !Screen.allowHover) {
            this.flags &= 0xFF00;
            target = 0.0f;
        } else {
            this.flags = this.flags & 0xFF00 | 1;
            target = 1.0f;
        }
        if (this.rectAnim.target != target) {
            long time = Anim.now();
            float value = this.rectAnim.advance(time);
            this.rectAnim.start = time;
            this.rectAnim.from = value;
            this.rectAnim.target = target;
            this.rectAnim.running = true;
        }
        return this.rectAnim.advance(Anim.now());
    }

    private float featureAlphaTarget() {
        if (ModuleCard.featureToggled(this.feature) && (!ModuleCard.featureIsOn(this.feature) || ModuleCard.modulesDimmed())) {
            return 0.5f;
        }
        return 1.0f;
    }

    private void syncChildWidths() {
        float value = this.width - 36.0f;
        if (0.001f < Math.abs(value - this.cachedChildWidth)) {
            this.cachedChildWidth = value;
            for (Component child : this.ownedChildren) {
                child.width = value;
            }
        }
    }

    private void syncChildFades() {
        Iterator<Component> keys = this.childFades.keySet().iterator();
        while (keys.hasNext()) {
            if (this.ownedChildren.contains(keys.next())) continue;
            keys.remove();
        }
        for (Component child : this.ownedChildren) {
            float value;
            Anim anim = this.childFades.get(child);
            if (anim == null) {
                anim = new Anim();
                this.childFades.put(child, anim);
            }
            anim.from = value = ModuleCard.childTabVisible(child) ? 1.0f : 0.0f;
            anim.current = value;
            anim.target = value;
            anim.duration = 0.22f;
            anim.easing = 0;
            anim.start = Anim.now();
            anim.running = false;
        }
    }

    private void refreshChildFades() {
        for (Map.Entry<Component, Anim> entry : this.childFades.entrySet()) {
            float value;
            if (!this.ownedChildren.contains(entry.getKey())) continue;
            Anim anim = entry.getValue();
            float f = value = ModuleCard.childTabVisible(entry.getKey()) ? 1.0f : 0.0f;
            if (anim.target != value) {
                float current;
                long time = Anim.now();
                anim.from = current = anim.advance(time);
                anim.target = value;
                anim.start = time;
                anim.running = true;
            }
            anim.advance(Anim.now());
        }
    }

    private float childWeight(Component child) {
        Anim anim = this.childFades.get(child);
        if (anim == null) {
            return ModuleCard.childTabVisible(child) ? 1.0f : 0.0f;
        }
        return anim.current;
    }

    private boolean anyChildShown() {
        if (!ModuleCard.featureIsOn(this.feature) || ModuleCard.modulesDimmed()) {
            for (Component child : this.ownedChildren) {
                if (!ModuleCard.childTabVisible(child) && !(0.001f < this.childWeight(child))) continue;
                return true;
            }
        }
        return false;
    }

    private boolean childShown(Component child) {
        return ModuleCard.childTabVisible(child) || 0.001f < this.childWeight(child);
    }

    private List<Component> collectActiveChildren() {
        ArrayList<Component> active = new ArrayList<Component>();
        for (Component child : this.ownedChildren) {
            if (!(0.5f < this.childWeight(child))) continue;
            active.add(child);
        }
        return active;
    }

    public float measureHeight() {
        float value = this.revealAnim.current;
        if (value <= 0.001f || !this.anyChildShown()) {
            value = 60.0f;
            this.height = 60.0f;
        } else {
            this.syncChildWidths();
            float gap = 12.0f;
            float total = 0.0f;
            float sum = 58.0f;
            for (Component child : this.ownedChildren) {
                float weight = this.childWeight(child);
                if (!(0.001f < weight)) continue;
                float childHeight = child.preferredHeight();
                float scaledGap = weight * gap;
                if (total <= 0.0f) {
                    scaledGap = 0.0f;
                }
                sum = sum + scaledGap + childHeight * weight;
                total = total + weight * gap + childHeight * weight;
            }
            this.height = value = (sum + 18.0f - 60.0f) * value + 60.0f;
        }
        return value;
    }

    private float headerLayout(float headerX, float headerY) {
        float value;
        if (!ModuleCard.featureIsOn(this.feature) || ModuleCard.modulesDimmed()) {
            float bindWidth;
            float favouriteX;
            float switcherX = this.width - 36.0f + headerX - 28.0f;
            this.switcher.y = headerY + 4.0f;
            float favouriteY = headerY + 6.0f;
            this.switcher.x = switcherX;
            this.favourite.y = favouriteY;
            this.favourite.x = favouriteX = switcherX - 4.0f - 12.0f;
            if (this.bind.bindTarget == null) {
                bindWidth = 0.0f;
            } else {
                this.bind.preferredWidth();
                bindWidth = this.bind.field0xE0 + 22.0f + 8.0f + 8.0f;
                if (bindWidth <= 46.0f) {
                    bindWidth = 46.0f;
                }
            }
            this.bind.width = bindWidth;
            float bindX = favouriteX - 4.0f - bindWidth;
            this.bind.y = headerY + 0.0f;
            this.bind.x = bindX;
            if (ModuleCard.featureIsOn(this.feature)) {
                if (0.0f < bindWidth) {
                    bindX -= 4.0f;
                }
                float[] metrics = ModuleCard.iconMetrics(75);
                bindX -= metrics[0] + 16.0f;
            }
            value = bindX;
        } else {
            float headerWidth = this.width - 36.0f;
            float measured = ModuleCard.measureHeaderText();
            value = headerWidth + headerX - measured;
        }
        return value;
    }

    private void renderHeader(Object mat, float mouseX, float mouseY, float alpha, float headerX, float headerY) {
        float textX;
        float available;
        ModuleCard.theme();
        int style = ModuleCard.textStyleIndex(ModuleCard.featureStyleKind(this.feature));
        ModuleCard.setTextStyle(mat, style);
        float labelX = this.headerLayout(headerX, headerY);
        if (!ModuleCard.featureIsOn(this.feature) || ModuleCard.modulesDimmed()) {
            if (ModuleCard.moduleVersionFloor() < ModuleCard.featureVersion(this.feature)) {
                this.renderVersionBadge(mat, mouseX, mouseY);
            } else {
                this.switcher.render(mat, mouseX, mouseY);
            }
            this.favourite.render(mat, mouseX, mouseY, alpha);
            this.bind.render(mat, mouseX, mouseY, alpha);
            if (ModuleCard.featureIsOn(this.feature)) {
                ModuleCard.drawBadgeIcon(mat, labelX, headerY + 0.0f, alpha);
            }
        } else {
            float labelY = headerY + 0.0f;
            float measured = ModuleCard.measureHeaderText();
            ModuleCard.drawLabel(mat, labelX, labelY, alpha);
            if (labelX <= mouseX && mouseX <= measured + labelX && labelY <= mouseY && mouseY <= labelY + 24.0f && (Screen.focusedInput == null || Screen.allowHover)) {
                Screen.hoveredWidget = 7;
                if (Screen.focusedInput == null || Screen.allowHover) {
                    ModuleCard.showTooltip(BETA_TOOLTIP, 0.0f, labelY, measured, 0.0f, labelX);
                }
            }
        }
        if ((available = labelX - 8.0f - (textX = headerX + 12.0f + 6.0f)) <= 0.0f) {
            available = 0.0f;
        }
        ModuleCard.theme();
        String name = ModuleCard.ellipsize(ModuleCard.featureName(this.feature), available, 16.0f);
        ModuleCard.drawTextStyle(5, mat, name, textX);
    }

    private void renderVersionBadge(Object mat, float mouseX, float mouseY) {
        float badgeX = this.switcher.x + 6.0f;
        float badgeY = this.switcher.y + 0.0f;
        ModuleCard.drawTextStyle(mat, 56, badgeX, badgeY);
        if (badgeX <= mouseX && mouseX <= badgeX + 16.0f && badgeY <= mouseY && mouseY <= badgeY + 16.0f && (Screen.focusedInput == null || Screen.allowHover)) {
            Screen.hoveredWidget = 7;
            ModuleCard.showTooltip(VERSION_TOOLTIP_PREFIX + this.versionLabel, 0.0f, badgeY, 16.0f, 0.0f, badgeX);
        }
    }

    private void layoutChildRow(float childX, float rowY) {
        float total = 0.0f;
        for (Component child : this.ownedChildren) {
            float weight = this.childWeight(child);
            if (!(0.001f < weight)) continue;
            if (0.0f < total) {
                rowY += weight * 12.0f;
            }
            child.setPosition(childX, rowY);
            float childHeight = child.preferredHeight();
            rowY += childHeight * weight;
            total = total + childHeight * weight + weight * 12.0f;
        }
    }

    private void renderChildren(Object mat, float mouseX, float mouseY, float alpha) {
        float press = this.highlightedChild == null ? 0.0f : this.childPressAnim.advance(Anim.now());
        if (this.highlightedChild != null && press <= 0.001f && this.childPressAnim.target <= 0.001f) {
            this.highlightedChild = null;
        }
        if (press <= 0.001f) {
            for (Component child : this.ownedChildren) {
                float weight = this.childWeight(child);
                if (!(0.001f < weight)) continue;
                child.render(mat, mouseX, mouseY, weight * alpha);
            }
        } else {
            for (Component child : this.ownedChildren) {
                float weight = this.childWeight(child);
                if (!(0.001f < weight)) continue;
                if (child == this.highlightedChild) {
                    float childHeight = child.preferredHeight();
                    ModuleCard.drawBox(mat, child.x - 6.0f, child.y - 6.0f, child.width + 12.0f, childHeight + 12.0f, 8.0f, ModuleCard.dimColor(ModuleCard.themeColor(20), 0.08f), weight * alpha * press);
                }
                child.render(mat, mouseX, mouseY, weight * alpha);
            }
        }
    }

    private static int textStyleIndex(int kind) {
        if (kind == 0) {
            return 3;
        }
        if (kind == 1) {
            return 4;
        }
        if (kind == 2) {
            return 7;
        }
        if (kind == 3) {
            return 8;
        }
        if (kind == 4) {
            return 28;
        }
        if (kind == 5) {
            return 2;
        }
        return 1;
    }

    private static void invokeChildLayout(Component child, Object mat, float mouseX, float mouseY, float alpha) {
    }

    private static boolean childAcceptsMouse(Component child, double mx, double my) {
        return false;
    }

    private static boolean invokeChildKeyPressed(Component child, int keyCode) {
        return false;
    }

    private static boolean featureToggled(Object feature) {
        if (ModuleCard.featureEnabled(feature) == 0 || ModuleCard.moduleFilterActive() || ModuleCard.moduleFilterCount() < 1) {
            return false;
        }
        return (ModuleCard.moduleFilterTokenA() ^ ModuleCard.moduleFilterTokenB()) == -1L && ModuleCard.moduleFilterTokenB() != 0L;
    }

    private static boolean childTabVisible(Component child) {
        Object tab = ModuleCard.childTab(child);
        return tab == null || ModuleCard.tabVisible(tab);
    }

    private static Object childTab(Component child) {
        return null;
    }

    private static boolean tabVisible(Object tab) {
        return true;
    }

    private static byte featureEnabled(Object feature) {
        return 0;
    }

    private static boolean featureFavourite(Object feature) {
        return false;
    }

    private static boolean featureExpandable(Object feature) {
        return false;
    }

    private static void setFeatureExpandable(Object feature, boolean value) {
    }

    private static boolean featureIsOn(Object feature) {
        return false;
    }

    private static int featureStyleKind(Object feature) {
        return 0;
    }

    private static int featureVersion(Object feature) {
        return 0;
    }

    private static Object featureBindTarget(Object feature) {
        return null;
    }

    private static String featureName(Object feature) {
        return "";
    }

    private static List<Object> featureSettings(Object feature) {
        return new ArrayList<Object>();
    }

    private static Component createSettingWidget(Object setting) {
        return null;
    }

    private static boolean moduleFilterActive() {
        return false;
    }

    private static int moduleFilterCount() {
        return 0;
    }

    private static long moduleFilterTokenA() {
        return 0L;
    }

    private static long moduleFilterTokenB() {
        return 0L;
    }

    private static boolean modulesDimmed() {
        return false;
    }

    private static int moduleVersionFloor() {
        return 0;
    }

    private Object createToggleCallback() {
        return null;
    }

    private Object createFavouriteCallback() {
        return null;
    }

    private void releaseChildFades() {
        this.childFades.clear();
    }

    private void releaseOwnedChildren() {
        this.ownedChildren.clear();
    }

    private static void detachChild(Component child) {
    }

    private static void releaseCallback(Object sub, boolean heap) {
    }

    private static void playSound(int id) {
    }

    private static void theme() {
    }

    private static int themeColor(int offset) {
        return 0;
    }

    private static int dimColor(int color, float factor) {
        return 0;
    }

    private static float[] iconMetrics(int icon) {
        return new float[2];
    }

    private static float measureHeaderText() {
        return 0.0f;
    }

    private static String ellipsize(String text, float maxWidth, float extra) {
        return text;
    }

    private static void setTextStyle(Object mat, int style) {
    }

    private static void drawPanel(Object mat, float x, float y, float width, float height, float radius, float alpha) {
    }

    private static void drawRoundedBox(Object mat, float x, float y, float width, float height, float radiusTL, float radiusTR, float radiusBR, float radiusBL, int fillTop, int fillBottom, float fillAlpha, int borderColor, float borderWidth, float borderAlpha, float shadowAlpha, float alpha, int flags) {
    }

    private static void drawBox(Object mat, float x, float y, float width, float height, float radius, int color, float alpha) {
    }

    private static void drawLabel(Object mat, float x, float y, float alpha) {
    }

    private static void drawBadgeIcon(Object mat, float x, float y, float alpha) {
    }

    private static void drawTextStyle(Object mat, int style, float x, float y) {
    }

    private static void drawTextStyle(int style, Object mat, String text, float x) {
    }

    private static void showTooltip(String text, float arg300, float arg304, float arg308, float arg320, float arg328) {
    }

    private static void pushScissor(float x, float y, float width, float height) {
    }

    private static void popScissor() {
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
}

