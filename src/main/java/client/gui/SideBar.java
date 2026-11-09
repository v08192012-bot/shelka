/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.Component;
import client.gui.ProfileBlock;

public class SideBar
extends Component {
    public static final int VTABLE_RVA = 12612400;
    public static final int CALLBACK_A_OFFSET = 152;
    public static final int CALLBACK_B_OFFSET = 216;
    public static final int CALLBACK_C_OFFSET = 280;
    public static final int CALLBACK_D_OFFSET = 344;
    public static final int CALLBACK_E_OFFSET = 408;
    public static final int CALLBACK_F_OFFSET = 472;
    public static final int CALLBACK_G_OFFSET = 536;
    public static final int COLLAPSE_OFFSET = 544;
    public static final int INITIALIZED_OFFSET = 552;
    public static final int SLIDE_ANIM_OFFSET = 560;
    public static final int SLIDE_ANIM_FROM_OFFSET = 560;
    public static final int SLIDE_ANIM_CURRENT_OFFSET = 564;
    public static final int SLIDE_ANIM_TARGET_OFFSET = 568;
    public static final int SLIDE_ANIM_DURATION_OFFSET = 572;
    public static final int SLIDE_ANIM_EASING_OFFSET = 576;
    public static final int SLIDE_ANIM_LAST_TICK_OFFSET = 584;
    public static final int SLIDE_ANIM_RUNNING_OFFSET = 592;
    public static final int HEADER_LABEL_OFFSET = 592;
    public static final int HEADER_BLOCK_OFFSET = 600;
    public static final int HEADER_BLOCK_X_OFFSET = 608;
    public static final int HEADER_BLOCK_Y_OFFSET = 612;
    public static final int HEADER_BLOCK_WIDTH_OFFSET = 616;
    public static final int HEADER_BLOCK_HEIGHT_OFFSET = 620;
    public static final int ICON_FADE_OFFSET = 728;
    public static final int HEADER_ICON_OFFSET = 736;
    public static final int TAB_BUTTON_OFFSET = 744;
    public static final int TAB_BUTTON_X_OFFSET = 752;
    public static final int TAB_BUTTON_Y_OFFSET = 756;
    public static final int TAB_BUTTON_WIDTH_OFFSET = 760;
    public static final int TAB_BUTTON_COLLAPSE_OFFSET = 872;
    public static final int CATEGORY_BLOCK_OFFSET = 880;
    public static final int CATEGORY_BLOCK_X_OFFSET = 888;
    public static final int CATEGORY_BLOCK_Y_OFFSET = 892;
    public static final int CATEGORY_BLOCK_WIDTH_OFFSET = 896;
    public static final int CATEGORY_BLOCK_HEIGHT_OFFSET = 900;
    public static final int CATEGORY_BLOCK_COLLAPSE_OFFSET = 1008;
    public static final int CONFIG_BUTTON_OFFSET = 1272;
    public static final int SETTINGS_BUTTON_OFFSET = 1288;
    public static final int SETTINGS_BUTTON_X_OFFSET = 1296;
    public static final int SETTINGS_BUTTON_Y_OFFSET = 1300;
    public static final int SETTINGS_BUTTON_WIDTH_OFFSET = 1304;
    public static final int SETTINGS_BUTTON_COLLAPSE_OFFSET = 1416;
    public static final int PROFILE_BLOCK_OFFSET = 1424;
    public static final int PROFILE_BLOCK_X_OFFSET = 1432;
    public static final int PROFILE_BLOCK_Y_OFFSET = 1436;
    public static final int PROFILE_BLOCK_WIDTH_OFFSET = 1440;
    public static final int PROFILE_BLOCK_HEIGHT_OFFSET = 1444;
    public static final int PROFILE_BLOCK_COLLAPSE_OFFSET = 1552;
    public static final int PROFILE_BLOCK_FLAG_OFFSET = 1624;
    public static final int CATEGORY_ENTRIES_BEGIN_OFFSET = 1672;
    public static final int CATEGORY_ENTRIES_END_OFFSET = 1680;
    public static final int CATEGORY_ENTRIES_CAP_OFFSET = 1688;
    public static final int ACTION_ENTRIES_BEGIN_OFFSET = 1696;
    public static final int ACTION_ENTRIES_END_OFFSET = 1704;
    public static final int ACTION_ENTRIES_CAP_OFFSET = 1712;
    public static final int FOOTER_ENTRIES_BEGIN_OFFSET = 1720;
    public static final int FOOTER_ENTRIES_END_OFFSET = 1728;
    public static final int FOOTER_ENTRIES_CAP_OFFSET = 1736;
    public static final int ACTION_ITEM_A_OFFSET = 1744;
    public static final int ACTION_ITEM_B_OFFSET = 1752;
    public static final int ACTION_ITEM_C_OFFSET = 1760;
    public static final int FOOTER_ITEM_A_OFFSET = 1768;
    public static final int FOOTER_ITEM_B_OFFSET = 1776;
    public static final int PARTY_ITEM_A_OFFSET = 2080;
    public static final int PARTY_ITEM_B_OFFSET = 2088;
    public static final int PARTY_POPUP_OFFSET = 3504;
    public static final int LAST_MOUSE_X_OFFSET = 3512;
    public static final int ENTRY_X_OFFSET = 8;
    public static final int ENTRY_Y_OFFSET = 12;
    public static final int ENTRY_WIDTH_OFFSET = 16;
    public static final int ENTRY_HEIGHT_OFFSET = 20;
    public static final int ENTRY_COLLAPSE_OFFSET = 16;
    public static final int ENTRY_PAYLOAD_OFFSET = 384;
    public static final int ENTRY_SELECTED_OFFSET = 392;
    public static final int ITEM_CALLBACK_OFFSET = 440;
    public static final int ITEM_FLAG_OFFSET = 576;
    public static final int HEADER_BLOCK_RENDER_OFFSET = 88;
    public static final int EASE_OUT_CUBIC = 0;
    public static final int EASE_OUT_EXPO = 1;
    public static final int SLOT_DTOR = 0;
    public static final int SLOT_RENDER = 1;
    public static final int SLOT_MOUSE_CLICKED = 4;
    public static final int SLOT_SET_POSITION = 11;
    public static final int[] CATEGORY_IDS = new int[]{0, 1, 2, 3, 4, 5};
    public static final int MENU_CONFIGS_ID = 29;
    public static final int MENU_FRIENDS_ID = 34;
    public static final int MENU_WAYPOINTS_ID = 35;
    public static final int MENU_KEYS_ID = 27;
    public static final int MENU_STAFF_ID = 9;
    public static final int MENU_PARTY_ID = 83;
    public static final int HEADER_ICON_ID = 64;
    public static final int MENU_PROFILE = 1;
    public static final int MENU_SETTINGS = 2;
    public static final int MENU_PARTY = 3;
    public static final int SOUND_CLICK = 14;
    public static final float WIDTH = 224.0f;
    public static final float HEIGHT = 700.0f;
    public static final float HEADER_HEIGHT = 49.0f;
    public static final float SLIDE_ANIM_DURATION = 0.22f;
    public static final float COLLAPSE_WIDTH = 208.0f;
    public static final float COLLAPSE_WIDTH_SHIFT = 176.0f;
    public static final float PAD_16 = 16.0f;
    public static final float PAD_2 = 2.0f;
    public static final float PAD_6 = 6.0f;
    public static final float PAD_8 = 8.0f;
    public static final float PAD_9 = 9.0f;
    public static final float PAD_20 = 20.0f;
    public static final float PAD_24 = 24.0f;
    public static final float PAD_36 = 36.0f;
    public static final float PAD_4 = 4.0f;
    public static final float PAD_18 = 18.0f;
    public static final float PAD_15 = 15.0f;
    public static final float PAD_32 = 32.0f;
    public static final float PAD_ONE = 1.0f;
    public static final float HALF = 0.5f;
    public static final float ZERO = 0.0f;
    public static final float ONE = 1.0f;
    public static final float EPSILON = 0.001f;
    public static final float LABEL_WIDTH_MIN = 0.0f;
    public static final float BLOCK_TOP = 49.0f;
    public static final float TAB_OFFSET_A = 18.0f;
    public static final float TAB_OFFSET_B = 16.0f;
    public static final float PAD_38 = 38.0f;
    public static final float LABEL_SIZE = 16.0f;
    public static final float TAB_ROW_STEP = 36.0f;
    public static final float ICON_SIZE = 20.0f;
    public static final int STATUS_COLOR_GREEN = -13919642;
    public static final int STATUS_COLOR_YELLOW = -17896;
    public static final int STATUS_COLOR_RED = -2276315;
    public static final int STATUS_COLOR_GRAY = -8158333;
    public static final int STATUS_ONLINE = 1;
    public static final int STATUS_IDLE = 2;
    public static final int STATUS_DND = 3;
    public static final float PROFILE_ALPHA = 1.0f;
    public static final float ROW_PAD = 20.0f;
    public static final String HEADER_LABEL = "Syst\u0435m";
    public static final String TAB_CAPTION = "\u0421lient categories";
    public static final String SETTINGS_CAPTION = "S\u0435ttings";
    public static final String CONFIGS_CAPTION = "\u0421\u043e\u043d\u0444\u0438\u0433\u0437";
    public static final String FRIENDS_CAPTION = "\u0424\u0440\u0438\u0435\u043d\u0434\u0437";
    public static final String WAYPOINTS_CAPTION = "\u0428\u0430\u0439\u043f\u043e\u0438\u043d\u0442\u0437";
    public static final String KEYS_CAPTION = "\u0417\u0435\u0442\u0442\u0438\u043d\u0433\u0437";
    public static final String STAFF_CAPTION = "\u0417\u0435\u0430\u0440\u0441\u0445";
    public static final String PARTY_CAPTION = "\u041f\u0430\u0440\u0442\u0439 \u0437\u0435\u0442\u0442\u0438\u043d\u0433\u0437";
    public static final String PARTY_FEATURE = "party";
    public Object callbackA = null;
    public Object callbackB = null;
    public Object callbackC = null;
    public Object callbackD = null;
    public Object callbackE = null;
    public Object callbackF = null;
    public Object callbackG = null;
    protected float collapse = 0.0f;
    protected boolean initialized = false;
    protected Anim slideAnim;
    protected String headerLabel = "Syst\u0435m";
    protected Object headerBlock;
    protected float headerBlockX;
    protected float headerBlockY;
    protected float headerBlockWidth;
    protected float headerBlockHeight;
    protected float iconFade;
    protected int headerIcon = 64;
    protected Object tabButton;
    protected float tabButtonX;
    protected float tabButtonY;
    protected float tabButtonWidth;
    protected float tabButtonCollapse;
    protected Object categoryBlock;
    protected float categoryBlockX;
    protected float categoryBlockY;
    protected float categoryBlockWidth;
    protected float categoryBlockHeight = 0.0f;
    protected float categoryBlockCollapse;
    protected boolean configSelected;
    protected Object settingsButton;
    protected float settingsButtonX;
    protected float settingsButtonY;
    protected float settingsButtonWidth;
    protected float settingsButtonCollapse;
    protected ProfileBlock profileBlock = new ProfileBlock();
    protected float profileBlockX;
    protected float profileBlockY;
    protected float profileBlockWidth;
    protected float profileBlockHeight;
    protected float profileBlockCollapse;
    protected boolean profileBlockFlag;
    protected Object[] categoryEntries = new Object[0];
    protected Object[] actionEntries = new Object[0];
    protected Object[] footerEntries = new Object[0];
    protected Object actionItemA;
    protected Object actionItemB;
    protected Object actionItemC;
    protected Object footerItemA;
    protected Object footerItemB;
    protected Object partyItemA;
    protected Object partyItemB;
    protected Object partyPopup;
    protected double lastMouseX;

    public SideBar() {
        this.slideAnim = Anim.init(0.0f, 0.22f, 0);
        this.headerBlock = SideBar.createHeaderBlock(this.headerLabel, 224.0f, 49.0f);
        this.tabButton = SideBar.createPlateButton(TAB_CAPTION);
        this.categoryBlock = SideBar.createCategoryBlock(0);
        this.settingsButton = SideBar.createPlateButton(SETTINGS_CAPTION);
        this.profileBlock = new ProfileBlock();
        this.profileBlock.settingsMenu = SideBar.createSettingsMenu();
        this.profileBlock.profileMenu = SideBar.createProfileMenu(this.profileBlock);
        this.partyItemA = null;
        this.partyItemB = null;
        this.width = 224.0f;
        this.height = 700.0f;
        this.configSelected = false;
        for (int i = 0; i < CATEGORY_IDS.length; ++i) {
            Object entry = SideBar.createEntry(CATEGORY_IDS[i]);
            this.addCategoryEntry(entry);
        }
        this.actionItemA = SideBar.createMenuItem(29, CONFIGS_CAPTION, 1);
        this.addActionEntry(this.actionItemA);
        this.actionItemB = SideBar.createMenuItem(34, FRIENDS_CAPTION, 2);
        this.addActionEntry(this.actionItemB);
        this.actionItemC = SideBar.createMenuItem(35, WAYPOINTS_CAPTION, 3);
        this.addActionEntry(this.actionItemC);
        this.actionItemA = this.actionEntries.length > 0 ? this.actionEntries[0] : null;
        this.actionItemB = this.actionEntries.length > 1 ? this.actionEntries[1] : null;
        this.actionItemC = this.actionEntries.length > 2 ? this.actionEntries[2] : null;
        SideBar.setItemCallback4(this.actionItemA);
        SideBar.setItemCallback5(this.actionItemB);
        SideBar.setItemCallback6(this.actionItemB);
        SideBar.setItemCallback7(this.actionItemC);
        Object footerA = SideBar.createMenuItem(27, KEYS_CAPTION, 2);
        this.addFooterEntry(footerA);
        this.footerItemA = footerA;
        Object footerB = SideBar.createMenuItem(9, STAFF_CAPTION, 1);
        this.addFooterEntry(footerB);
        Object footerC = SideBar.createMenuItem(83, PARTY_CAPTION, 3);
        this.addFooterEntry(footerC);
        this.footerItemB = footerC;
        this.partyItemA = footerB;
        this.partyItemB = footerC;
        SideBar.createPartyPopup();
    }

    @Override
    public void dispose() {
        SideBar.disposeBlock(this.categoryBlock);
        for (int i = 0; i < this.categoryEntries.length; ++i) {
            SideBar.disposeBlock(this.categoryEntries[i]);
        }
        this.initialized = false;
        SideBar.disposeItem(this.headerBlock);
        SideBar.freeString(this.headerLabel);
        SideBar.disposeProfileBlock(this.profileBlock);
        SideBar.disposePartyPopup();
        super.dispose();
    }

    @Override
    public void render(Object mat, float mouseX, float mouseY, float alpha) {
        if (!this.initialized) {
            SideBar.layoutBlock(this.categoryBlock);
            for (int i = 0; i < this.categoryEntries.length; ++i) {
                SideBar.layoutEntry(this.categoryEntries[i]);
            }
            this.initialized = true;
        }
        float edge = 16.0f;
        SideBar.drawSidebarBackdrop(mat, this.x, this.y, this.width, this.height, edge, alpha);
        float iconSize = 20.0f;
        this.tabButtonCollapse = this.collapse;
        this.headerBlockWidth = this.width;
        this.headerBlockX = this.x;
        this.headerBlockY = this.y;
        float iconX = this.x + 16.0f - 2.0f;
        float iconY = this.y + this.headerBlockHeight - 15.0f - 20.0f;
        int color = SideBar.barThemeColor();
        SideBar.drawIcon(mat, this.headerIcon, iconX, iconY, 20.0f, 20.0f, color, alpha);
        float fade = 1.0f - this.tabButtonCollapse;
        float labelX = iconX + iconSize + 6.0f;
        float labelWidth = this.headerBlockWidth + this.headerBlockX - 8.0f - labelX;
        if (labelWidth <= 0.0f) {
            labelWidth = 0.0f;
        }
        SideBar.drawHeaderLabel(this.headerLabel, mat, labelX, iconY + 2.0f, labelWidth, this.headerBlockY, this.headerBlockHeight, 16.0f, edge, fade * alpha);
        float blockX = this.x + 8.0f;
        float blockWidth = 208.0f - this.collapse * 176.0f;
        float slide = this.slideAnim.advance(this.now());
        float blockY = this.y + 49.0f;
        float tabTop = blockY + 18.0f;
        float tabMid = blockY + 16.0f;
        this.tabButtonWidth = blockWidth;
        this.tabButtonX = blockX;
        tabTop -= 1.0f;
        tabMid -= 1.0f;
        this.tabButtonCollapse = this.collapse;
        this.tabButtonY = tabTop -= 9.0f;
        SideBar.renderTabButton(this.tabButton, mat, mouseX, mouseY, alpha);
        this.categoryBlockWidth = blockWidth;
        this.categoryBlockX = blockX;
        this.categoryBlockCollapse = this.collapse;
        this.categoryBlockY = (tabMid - (tabTop += 32.0f)) * slide + tabTop;
        SideBar.renderCategoryBlock(this.categoryBlock, mat, mouseX, mouseY, alpha);
        float rowA = tabMid + 32.0f + 4.0f;
        float rowB = tabTop + 32.0f + 4.0f;
        for (int i = 0; i < this.categoryEntries.length; ++i) {
            Object entry = this.categoryEntries[i];
            SideBar.setEntryCollapse(entry, this.collapse);
            SideBar.setEntryWidth(entry, blockWidth);
            SideBar.setEntryBounds(entry, blockX, (rowA - rowB) * slide + rowB);
            SideBar.renderEntry(entry, mat, mouseX, mouseY, alpha);
            rowA += 36.0f;
            rowB += 36.0f;
        }
        float actionTop = rowA;
        float footerTop = rowB;
        if (this.categoryEntries.length != 0) {
            float offset = (float)(this.categoryEntries.length - 1) * 4.0f;
            footerTop = (float)this.categoryEntries.length * 32.0f + footerTop + offset;
            actionTop = (float)this.categoryEntries.length * 32.0f + actionTop + offset;
        }
        this.settingsButtonCollapse = this.collapse;
        this.settingsButtonX = blockX;
        this.settingsButtonWidth = blockWidth;
        this.settingsButtonY = ((actionTop += 24.0f) - 32.0f - (footerTop += 24.0f)) * slide + footerTop;
        SideBar.renderTabButton(this.settingsButton, mat, mouseX, mouseY, alpha);
        SideBar.renderButtonRow(mat, mouseX, mouseY, alpha, blockX, blockWidth, footerTop + 32.0f, actionTop, this.actionEntries, slide, this.collapse);
        float profileTop = this.y + this.height - 16.0f - 38.0f;
        float count = this.footerEntries.length;
        float footerY = profileTop - ((count - 1.0f) * 4.0f + count * 32.0f) - 24.0f;
        SideBar.renderButtonRow(mat, mouseX, mouseY, alpha, blockX, blockWidth, footerY, footerY, this.footerEntries, 0.0f, this.collapse);
        this.profileBlockWidth = blockWidth;
        this.profileBlockCollapse = this.collapse;
        this.profileBlockFlag = 0.001f < this.profileBlock.hoverAnim.current || 0.001f < this.profileBlock.hoverAnim.target;
        this.profileBlockX = blockX;
        this.profileBlockY = profileTop;
        this.profileBlock.render(mat, mouseX, mouseY, alpha);
    }

    public void layout(Object mat, float x, float y, float alpha) {
    }

    public void update() {
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        Object entry;
        int i;
        this.lastMouseX = mx;
        if (button == 0 && (double)this.categoryBlockX <= mx && mx <= (double)(this.categoryBlockX + this.categoryBlockWidth) && (double)this.categoryBlockY <= my && my <= (double)(this.categoryBlockY + this.categoryBlockHeight)) {
            if (this.configSelected) {
                Object callback = this.callbackB;
                if (callback == null) {
                    return true;
                }
                SideBar.invokeVoid10(callback);
                return true;
            }
            this.clearSelection();
            this.configSelected = true;
            Object callback = this.callbackA;
            if (callback == null) {
                return true;
            }
            SideBar.invokeVoid10(callback);
            return true;
        }
        for (i = 0; i < this.categoryEntries.length; ++i) {
            entry = this.categoryEntries[i];
            if (button != 0 || !((double)SideBar.entryX(entry) <= mx) || !(mx <= (double)(SideBar.entryX(entry) + SideBar.entryWidth(entry))) || !((double)SideBar.entryY(entry) <= my) || !(my <= (double)(SideBar.entryY(entry) + SideBar.entryHeight(entry)))) continue;
            if (!SideBar.entrySelected(entry)) {
                this.clearSelection();
                SideBar.setEntrySelected(entry, true);
                Object callback = this.callbackA;
                if (callback == null) {
                    return true;
                }
                SideBar.invokeVoid10(callback, SideBar.entryPayload(entry));
                return true;
            }
            Object callback = this.callbackB;
            if (callback == null) {
                return true;
            }
            SideBar.invokeVoid10(callback, SideBar.entryPayload(entry));
            return true;
        }
        for (i = 0; i < this.actionEntries.length; ++i) {
            entry = this.actionEntries[i];
            if (button != 0 || !((double)SideBar.entryX(entry) <= mx) || !(mx <= (double)(SideBar.entryX(entry) + SideBar.entryWidth(entry))) || !((double)SideBar.entryY(entry) <= my) || !(my <= (double)(SideBar.entryY(entry) + SideBar.entryHeight(entry)))) continue;
            Object callback = SideBar.itemCallback(entry);
            if (callback == null) {
                return true;
            }
            SideBar.invokeItemCallback(callback);
            return true;
        }
        for (i = 0; i < this.footerEntries.length; ++i) {
            entry = this.footerEntries[i];
            if (button != 0 || !((double)SideBar.entryX(entry) <= mx) || !(mx <= (double)(SideBar.entryX(entry) + SideBar.entryWidth(entry))) || !((double)SideBar.entryY(entry) <= my) || !(my <= (double)(SideBar.entryY(entry) + SideBar.entryHeight(entry)))) continue;
            Object callback = SideBar.itemCallback(entry);
            if (callback == null) {
                return true;
            }
            SideBar.invokeItemCallback(callback);
            return true;
        }
        if (button == 0 && (double)this.profileBlockX <= mx && mx <= (double)(this.profileBlockWidth + this.profileBlockX) && (double)this.profileBlockY <= my && my <= (double)(this.profileBlockHeight + this.profileBlockY)) {
            SideBar.playSound(14);
            this.openProfileMenu();
            return true;
        }
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

    public boolean keyPressed(int key) {
        return false;
    }

    @Override
    public boolean keyReleased(int key) {
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

    private void clearSelection() {
        int i;
        this.configSelected = false;
        for (i = 0; i < this.categoryEntries.length; ++i) {
            SideBar.setEntrySelected(this.categoryEntries[i], false);
        }
        for (i = 0; i < this.actionEntries.length; ++i) {
            SideBar.setItemFlag(this.actionEntries[i], false);
        }
    }

    private void openSettingsMenu() {
        SideBar sidebar = this;
        Object menu = this.profileBlock.settingsMenu;
        SideBar.openMenuAt(menu, this.lastMouseX);
    }

    private void openProfileMenu() {
        int mode = SideBar.currentProfileMode();
        Object menu = this.profileBlock.profileMenu;
        SideBar.setMenuMode(menu, mode);
        SideBar.openMenuAt(menu);
    }

    private static int currentProfileMode() {
        Object state = SideBar.sidebarState();
        if (state == null) {
            return 1;
        }
        return SideBar.showStatusList(state) ? 1 : 1;
    }

    private static boolean showStatusList(Object state) {
        return false;
    }

    private static void setMenuMode(Object menu, int mode) {
        int color = -13919642;
        if (mode != 1) {
            color = -17896;
            if (mode != 2) {
                color = -2276315;
                if (mode != 3) {
                    color = -8158333;
                }
            }
        }
        SideBar.setMenuColor(menu, color);
    }

    private static void setMenuColor(Object menu, int color) {
    }

    private void openPartySettings() {
        Object popup = this.partyPopup;
        if (popup == null) {
            return;
        }
        SideBar.setPopupY(popup, SideBar.popupHeight(popup));
        SideBar.openMenuAt(popup);
    }

    private static Object createHeaderBlock(String label, float width, float height) {
        return null;
    }

    private static Object createPlateButton(String caption) {
        return null;
    }

    private static Object createCategoryBlock(int id) {
        return null;
    }

    private static Object createEntry(int id) {
        return null;
    }

    private static Object createMenuItem(int id, String caption, int mode) {
        return null;
    }

    private static Object createSettingsMenu() {
        return null;
    }

    private static Object createProfileMenu(ProfileBlock owner) {
        return null;
    }

    private static void createPartyPopup() {
    }

    private static void disposePartyPopup() {
    }

    private static void disposeProfileBlock(ProfileBlock block) {
    }

    private static void disposeItem(Object item) {
    }

    private static void disposeBlock(Object block) {
    }

    private static void freeString(String value) {
    }

    private void addCategoryEntry(Object entry) {
        Object[] next = new Object[this.categoryEntries.length + 1];
        for (int i = 0; i < this.categoryEntries.length; ++i) {
            next[i] = this.categoryEntries[i];
        }
        next[this.categoryEntries.length] = entry;
        this.categoryEntries = next;
    }

    private void addActionEntry(Object entry) {
        Object[] next = new Object[this.actionEntries.length + 1];
        for (int i = 0; i < this.actionEntries.length; ++i) {
            next[i] = this.actionEntries[i];
        }
        next[this.actionEntries.length] = entry;
        this.actionEntries = next;
    }

    private void addFooterEntry(Object entry) {
        Object[] next = new Object[this.footerEntries.length + 1];
        for (int i = 0; i < this.footerEntries.length; ++i) {
            next[i] = this.footerEntries[i];
        }
        next[this.footerEntries.length] = entry;
        this.footerEntries = next;
    }

    private static void setItemCallback4(Object item) {
    }

    private static void setItemCallback5(Object item) {
    }

    private static void setItemCallback6(Object item) {
    }

    private static void setItemCallback7(Object item) {
    }

    private static void layoutBlock(Object block) {
    }

    private static void layoutEntry(Object entry) {
    }

    private static void setEntryCollapse(Object entry, float value) {
    }

    private static void setEntryWidth(Object entry, float value) {
    }

    private static void setEntryBounds(Object entry, float x, float y) {
    }

    private static void renderEntry(Object entry, Object mat, float mouseX, float mouseY, float alpha) {
    }

    private static void renderTabButton(Object button, Object mat, float mouseX, float mouseY, float alpha) {
    }

    private static void renderCategoryBlock(Object block, Object mat, float mouseX, float mouseY, float alpha) {
    }

    private static void renderButtonRow(Object mat, float mouseX, float mouseY, float alpha, float x, float width, float top, float bottom, Object[] entries, float slide, float collapse) {
    }

    private static void drawSidebarBackdrop(Object mat, float x, float y, float w, float h, float edge, float alpha) {
    }

    private static void drawHeaderLabel(String label, Object mat, float x, float y, float w, float hostY, float hostHeight, float size, float edge, float alpha) {
    }

    private static void drawIcon(Object mat, int icon, float x, float y, float w, float h, int color, float alpha) {
    }

    private static void playSound(int id) {
    }

    private static void openMenuAt(Object menu) {
    }

    private static void openMenuAt(Object menu, double mouseX) {
    }

    private static void setPopupY(Object popup, float value) {
    }

    private static float popupHeight(Object popup) {
        return 0.0f;
    }

    private static Object sidebarState() {
        return null;
    }

    private static void invokeVoid10(Object callback) {
    }

    private static void invokeVoid10(Object callback, Object payload) {
    }

    private static void invokeItemCallback(Object callback) {
    }

    private static float entryX(Object entry) {
        return 0.0f;
    }

    private static float entryY(Object entry) {
        return 0.0f;
    }

    private static float entryWidth(Object entry) {
        return 0.0f;
    }

    private static float entryHeight(Object entry) {
        return 0.0f;
    }

    private static boolean entrySelected(Object entry) {
        return false;
    }

    private static void setEntrySelected(Object entry, boolean value) {
    }

    private static Object entryPayload(Object entry) {
        return null;
    }

    private static Object itemCallback(Object item) {
        return null;
    }

    private static void setItemFlag(Object item, boolean value) {
    }

    private static int barThemeColor() {
        return 0;
    }

    @Override
    protected long now() {
        return System.nanoTime();
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

