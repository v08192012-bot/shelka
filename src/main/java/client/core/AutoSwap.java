/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class AutoSwap
extends Feature {
    public static final String MODULE = "autoswap";
    public static final String DISPLAY = "\u0410\u0443\u0442\u043e\u0417\u0448\u0430\u043f";
    public static final int VTABLE_RVA = 12310536;
    public static final long RVA_ON_BINDS = 2735200237984L;
    public static final long RVA_ON_TICK = 2735200238624L;
    public static final long RVA_ON_DISABLE = 2735200238160L;
    public static final long RVA_RESET = 2735200238240L;
    public static final long RVA_BIND_HANDLER = 2735200242320L;
    public static final long RVA_SWAP_STEP = 2735200243952L;
    public static final long RVA_REFRESH_ITEMS = 2735200241216L;
    public static final long RVA_TICK_STATE = 2735200247696L;
    public static final long RVA_GROUP = 2735200249648L;
    private static final int BIND_LATCH_COUNT = 7;
    private static final int COMMON_BIND_MASK = 31;
    private static final int SWAP_STEP_NONE = 0;
    private static final int SWAP_STEP_ONE = 1;
    private static final int SWAP_STEP_TWO = 2;
    private static final String GROUP_CHORUS_FRUIT = "chorus_fruit";
    private static final String GROUP_EXPERIENCE_BOTTLE = "experience_bottle";
    private static final String BIND_WIND_CHARGE = "wind_charge";
    private static final String BIND_ENDER_PEARL = "ender_pearl";
    private static final String BIND_TOTEM_TO_TOTEM = "totem_to_totem";
    private static final String EFFECT_ALL = "all";
    private static final String EFFECT_SPHERE_TO_SPHERE = "sphere_to_sphere";
    private final boolean[] swapLatch = new boolean[1];
    private final boolean[] sphereLatch = new boolean[1];
    private final boolean[] totemLatch = new boolean[1];
    private final boolean[] totemTotemLatch = new boolean[1];
    private final boolean[] commonLatch = new boolean[1];
    private final boolean[] ftLatch = new boolean[1];
    private final boolean[] hwLatch = new boolean[1];
    private int swapStep;

    public AutoSwap() {
        super(MODULE, DISPLAY, Category.Movement);
        this.add(Setting.mode("server", "\u0410\u0432\u0442\u043e", "\u0410\u0432\u0442\u043e", "HolyWorld", "FunTime", "\u0414\u0440\u0443\u0433\u043e\u0439"));
        this.add(Setting.mode("mode", "\u0422\u0430\u043f", "\u0422\u0430\u043f", "\u0425\u043e\u043b\u0434"));
        this.add(Setting.mode("trigger", "\u041a\u043b\u0430\u0432\u0438\u0448\u0430", "\u041a\u043b\u0430\u0432\u0438\u0448\u0430", "\u0423\u0440\u043e\u043d", "\u0422\u043e\u0442\u0435\u043c"));
        this.add(Setting.bool("cooldown_done", false));
        this.add(Setting.bool("silent_swap", false));
        this.add(Setting.key("swap_bind", 0));
        this.add(Setting.key("totem_swap_bind", 0));
        this.add(Setting.key("sphere_swap_bind", 0));
        this.add(Setting.key("totem_totem_bind", 0));
        this.add(Setting.key("common_binds", 0));
        this.add(Setting.key("ft_binds", 0));
        this.add(Setting.key("hw_binds", 0));
    }

    @Override
    public void onEnable() {
        this.reset();
    }

    @Override
    public void onDisable() {
        if (Client.autoSwapUseKeyHeld(this) || Client.autoSwapUseKey2Held(this)) {
            Client.setUseKey(false);
        }
        if (Client.autoSwapPendingUse(this) && Client.autoSwapPendingCount(this) != 0) {
            Client.setUseKey2(false);
        }
        this.reset();
    }

    @Override
    public void onTick() {
        Client.swapManagerTick(Client.autoSwapManager(this));
        if (!Client.inGame()) {
            this.reset();
            return;
        }
        Client.autoSwapRefreshItems(this);
        Client.autoSwapTickState(this);
        Client.autoSwapGroup(this, GROUP_CHORUS_FRUIT);
        Client.autoSwapGroup(this, GROUP_EXPERIENCE_BOTTLE);
        Client.autoSwapPendingUseTick(this);
        Client.autoSwapStateStep(Client.autoSwapManager(this));
        boolean sphere = Client.keybindPressed(this.bind("sphere_swap_bind"), 0, this.sphereLatch);
        boolean totem = Client.keybindPressed(this.bind("totem_swap_bind"), 0, this.totemLatch);
        boolean totemTotem = Client.keybindPressed(this.bind("totem_totem_bind"), 0, this.totemTotemLatch);
        boolean common = Client.keybindPressed(this.bind("common_binds"), 0, this.commonLatch);
        boolean ft = Client.keybindPressed(this.bind("ft_binds"), 0, this.ftLatch);
        boolean hw = Client.keybindPressed(this.bind("hw_binds"), 0, this.hwLatch);
        boolean swap = Client.keybindPressed(this.bind("swap_bind"), 0, this.swapLatch);
        Client.autoSwapProcessGroups(this);
        if (Client.isPaused()) {
            return;
        }
        if (sphere || totem) {
            Client.autoSwapSwapStep(this, BIND_WIND_CHARGE, totem);
        }
        if (totemTotem && Client.autoSwapUseKeyHeld(this)) {
            Client.autoSwapHandleBind(this, BIND_ENDER_PEARL);
        }
        if (Client.hasStatusEffect(EFFECT_ALL)) {
            if (common) {
                Client.autoSwapSwapStep(this, null, false);
            }
            if (swap) {
                Client.autoSwapSwapStep(this, null, true);
            }
            if (!ft) {
                return;
            }
            Client.autoSwapSwapStep(this, null, true);
            return;
        }
        if (!hw) {
            return;
        }
        if (!Client.hasItemNamed(EFFECT_SPHERE_TO_SPHERE)) {
            return;
        }
        if (Client.settingListContains(this, "common_binds", BIND_TOTEM_TO_TOTEM)) {
            Client.autoSwapSwapStep(this, null, false);
            return;
        }
        Client.autoSwapSwapStep(this, null, true);
    }

    public void onBindScan() {
        Client.autoSwapScanBinds(this);
    }

    public int swapStep() {
        return this.swapStep;
    }

    public void reset() {
        Client.swapManagerReset(Client.autoSwapManager(this));
        Client.autoSwapResetPending(this);
        this.swapStep = 0;
        this.swapLatch[0] = false;
        this.sphereLatch[0] = false;
        this.totemLatch[0] = false;
        this.totemTotemLatch[0] = false;
        this.commonLatch[0] = false;
        this.ftLatch[0] = false;
        this.hwLatch[0] = false;
    }

    public boolean swapStepActive() {
        return Client.autoSwapStepActive(Client.autoSwapManager(this));
    }

    private int bind(String name) {
        Setting setting = this.setting(name);
        return setting == null ? 0 : setting.getKey();
    }

    private Setting setting(String name) {
        for (Setting value : this.getSettings()) {
            if (!value.getName().equals(name)) continue;
            return value;
        }
        return null;
    }
}

