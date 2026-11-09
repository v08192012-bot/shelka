/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import client.mc.Entity;

public final class AutoTotem
extends Feature {
    public static final String MODULE = "autototem";
    public static final String DISPLAY = "\u0410\u0443\u0442\u043e\u0422\u043e\u0442\u0435\u043c";
    public static final int VTABLE_RVA = 12275368;
    public static final long RVA_ON_TICK = 2735200049424L;
    public static final long RVA_ON_DISABLE = 2735200041504L;
    public static final long RVA_SLOT_CHANGED = 2735200049888L;
    public static final long RVA_CORE = 2735200050096L;
    public static final long RVA_SWAP_APPLY = 2735200050496L;
    public static final long RVA_SWAP_TICK = 2735200631888L;
    public static final long RVA_SWAP_STOP = 2735200631792L;
    public static final long RVA_SWAP_BEGIN = 2735200631584L;
    public static final long RVA_FIND_SLOT = 2735200053424L;
    public static final long RVA_FALL_DANGER = 2735200051520L;
    public static final long RVA_HEALTH_DANGER = 2735200050912L;
    public static final long RVA_ENTITY_DANGER = 2735200052784L;
    public static final long RVA_OFFHAND_CHECK = 2735200052336L;
    public static final int HOTBAR_SIZE = 9;
    public static final int HOTBAR_OFFSET = 36;
    public static final int INVENTORY_SCAN_SIZE = 36;
    private static final int NO_SLOT = -1;
    private static final long ACTION_DELAY_NANOS = 400000000L;
    private static final double FALL_HEALTH_LIMIT = 5.0;
    private static final double CRYSTAL_HEALTH_LIMIT = 10.0;
    private static final String KEY_HAND = "hand";
    private static final String KEY_HEALTH = "health";
    private static final String KEY_ELYTRA = "elytra";
    private static final String KEY_ELYTRA_HEALTH = "elytra_health";
    private static final String KEY_ABSORPTION = "absorption";
    private static final String KEY_CRYSTAL = "crystal";
    private static final String KEY_TRIDENT = "trident";
    private static final String KEY_TNT = "tnt";
    private static final String KEY_TNT_RANGE = "tnt_range";
    private static final String KEY_TNT_ANY_DISTANCE = "tnt_any_distance";
    private static final String KEY_FALLING = "falling";
    private static final String KEY_MACE = "mace";
    private static final String KEY_MACE_RANGE = "mace_range";
    private static final String KEY_MACE_HEIGHT = "mace_height";
    private static final String KEY_MACE_ROOF = "mace_roof";
    private static final String KEY_MACE_ROOF_RADIUS = "mace_roof_radius";
    private static final String KEY_SAVE_ENCHANTED = "save_enchanted";
    private static final String KEY_SKIP_COOLDOWN = "skip_cooldown";
    private static final String KEY_SWAP_BACK = "swap_back";
    private static final String KEY_NO_SWAP_WHILE_EATING = "no_swap_while_eating";
    private static final String KEY_NO_BALL_SWITCH = "no_ball_switch";
    private final ItemSwap swap = new ItemSwap();
    private int targetSlot = -1;
    private int pendingSlot = -1;
    private int pendingCurrent = -1;
    private boolean swapQueued;
    private int enchantedCount;
    private boolean keyLatch;
    private long lastActionNanos;
    public static final int HOTBAR_OFFHAND_SLOT = 35;

    public AutoTotem() {
        super(MODULE, DISPLAY, Category.Combat);
        this.add(Setting.mode(KEY_HAND, "\u041f\u0440\u0430\u0432\u0430\u044f", "\u041f\u0440\u0430\u0432\u0430\u044f", "\u041b\u0435\u0432\u0430\u044f"));
        this.add(Setting.bool(KEY_NO_SWAP_WHILE_EATING, true));
        this.add(Setting.bool(KEY_SWAP_BACK, true));
        this.add(Setting.bool(KEY_NO_BALL_SWITCH, false));
        this.add(Setting.bool(KEY_SAVE_ENCHANTED, false));
        this.add(Setting.bool(KEY_SKIP_COOLDOWN, true));
        this.add(Setting.number(KEY_HEALTH, 5.0, 0.0, 20.0, 0.5));
        this.add(Setting.bool(KEY_ABSORPTION, true));
        this.add(Setting.bool(KEY_ELYTRA, false));
        this.add(Setting.number(KEY_ELYTRA_HEALTH, 10.0, 0.0, 20.0, 0.5));
        this.add(Setting.bool(KEY_CRYSTAL, true));
        this.add(Setting.bool(KEY_TRIDENT, true));
        this.add(Setting.bool(KEY_TNT, true));
        this.add(Setting.bool(KEY_TNT_ANY_DISTANCE, false));
        this.add(Setting.number(KEY_TNT_RANGE, 6.0, 1.0, 16.0, 0.5));
        this.add(Setting.bool(KEY_FALLING, false));
        this.add(Setting.bool(KEY_MACE, true));
        this.add(Setting.number(KEY_MACE_RANGE, 5.0, 1.0, 16.0, 0.5));
        this.add(Setting.number(KEY_MACE_HEIGHT, 2.0, 1.0, 10.0, 0.5));
        this.add(Setting.bool(KEY_MACE_ROOF, true));
        this.add(Setting.number(KEY_MACE_ROOF_RADIUS, 2.0, 1.0, 4.0, 1.0));
    }

    @Override
    public void onDisable() {
        Client.itemSwapStop(this.swap);
        this.targetSlot = -1;
        this.pendingSlot = -1;
        this.pendingCurrent = -1;
        this.swapQueued = false;
        this.lastActionNanos = 0L;
        this.swap.selected = -1;
    }

    @Override
    public void onTick() {
        Client.itemSwapTick(this.swap);
        Entity player = Client.player();
        if (!Client.inGame() || player == null || Client.health(player) <= 0.0) {
            Client.itemSwapStop(this.swap);
            this.targetSlot = -1;
            this.pendingSlot = -1;
            this.swapQueued = false;
            this.lastActionNanos = 0L;
            return;
        }
        boolean latched = this.keyLatch;
        this.keyLatch = false;
        if (latched) {
            if (!this.swapQueued) {
                this.pendingSlot = -1;
            }
            this.lastActionNanos = Client.nanos();
        }
        if (this.swap.state == 0 || this.swap.state == 3) {
            this.enchantedCount = 0;
            if (this.saveEnchanted()) {
                for (int i = 0; i < 36; ++i) {
                    if (!Client.inventorySlotMatches(i) || Client.inventorySlotEmpty(i)) continue;
                    ++this.enchantedCount;
                }
            }
            this.updateCore();
            return;
        }
    }

    public void onSlotChanged(int slot, Object stack) {
        if (slot == 35 && Client.isTotemStack(stack)) {
            Client.itemSwapStop(this.swap);
            this.lastActionNanos = 0L;
        }
    }

    private void updateCore() {
        int slot;
        long now = Client.nanos();
        if (now - this.lastActionNanos < 400000000L) {
            return;
        }
        if (!this.offhandHasTotem() && (this.fallDanger() || this.healthDanger()) && !this.entityDanger() && (slot = this.findTotemSlot()) != -1) {
            this.applySlot(slot);
            return;
        }
        if (this.noSwapWhileEating() && Client.isUsingItem(Client.player())) {
            return;
        }
        if (!this.swapBack()) {
            return;
        }
        if (this.targetSlot == -1 && this.pendingSlot == -1) {
            return;
        }
        if (!this.offhandHasTotem()) {
            if (this.fallDanger()) {
                return;
            }
            if (this.healthDanger()) {
                return;
            }
        }
        if (this.targetSlot != -1) {
            int restore = this.targetSlot;
            this.targetSlot = -1;
            Client.setSelectedSlot(restore);
            this.lastActionNanos = now;
            return;
        }
        if (this.pendingSlot == -1) {
            return;
        }
        this.swapQueued = false;
        if (this.pendingCurrent == -1) {
            Client.itemSwapBegin(this.swap, this.pendingSlot);
            return;
        }
        Client.itemSwapBegin(this.swap, this.pendingSlot, this.pendingCurrent);
    }

    private void applySlot(int slot) {
        if (this.handMode() != 0) {
            int current = Client.selectedSlot();
            if (slot < 9) {
                if (slot == current) {
                    return;
                }
                if (this.targetSlot == -1) {
                    this.targetSlot = current;
                }
                Client.setSelectedSlot(slot);
                this.lastActionNanos = Client.nanos();
                return;
            }
            if (this.pendingSlot == -1) {
                this.pendingSlot = slot;
                this.pendingCurrent = current;
            }
            this.swapQueued = true;
            if (current > 8) {
                return;
            }
            Client.itemSwapBegin(this.swap, slot, current);
            return;
        }
        Client.equipOffhandTotem(slot);
        this.lastActionNanos = Client.nanos();
    }

    private boolean offhandHasTotem() {
        if (this.handMode() != 0) {
            return false;
        }
        if (this.falling() && Client.health(Client.player()) > 5.0) {
            return false;
        }
        if (!this.noBallSwitch()) {
            return false;
        }
        return Client.offhandHasTotem();
    }

    private boolean fallDanger() {
        Entity player = Client.player();
        if (this.falling() && !Client.isOnGround(player) && !Client.isRiding(player) && player != null) {
            return Client.health(player) > 10.0;
        }
        if (this.mace()) {
            return Client.maceAbove(this, this.maceRange(), this.maceHeight(), this.maceRoof(), this.maceRoofRadius());
        }
        if (this.crystal() || this.tnt() || this.trident()) {
            double range;
            double d = range = this.tntAnyDistance() ? Client.defaultDangerRange() : this.tntRange();
            if (!this.tnt()) {
                range = 0.0;
            }
            return Client.dangerNearby(this, range);
        }
        return false;
    }

    private boolean healthDanger() {
        double absorption = this.absorption() ? Client.absorption(Client.player()) : 0.0;
        double health = Client.health(Client.player());
        if (this.elytra()) {
            double limit = Client.elytraHealthLimit(this, this.elytraHealth());
            return health + absorption <= limit;
        }
        return health + absorption <= Client.settingNumber(this, KEY_HEALTH) + Client.absorptionLimit();
    }

    private boolean entityDanger() {
        return Client.entityDanger(this);
    }

    private int findTotemSlot() {
        int slot;
        if (!(this.saveEnchanted() && Client.findSlotWithItem(0) != -1 || (slot = Client.findTotemSlot(this)) == -1)) {
            return slot;
        }
        return Client.findTotemSlotSkippingCooldown(this, this.skipCooldown());
    }

    private int handMode() {
        Setting setting = this.setting(KEY_HAND);
        return setting == null ? 0 : setting.getModes().indexOf(setting.getMode());
    }

    private boolean falling() {
        return this.bool(KEY_FALLING);
    }

    private boolean saveEnchanted() {
        return this.bool(KEY_SAVE_ENCHANTED);
    }

    private boolean skipCooldown() {
        return this.bool(KEY_SKIP_COOLDOWN);
    }

    private boolean noSwapWhileEating() {
        return this.bool(KEY_NO_SWAP_WHILE_EATING);
    }

    private boolean swapBack() {
        return this.bool(KEY_SWAP_BACK);
    }

    private boolean noBallSwitch() {
        return this.bool(KEY_NO_BALL_SWITCH);
    }

    private boolean absorption() {
        return this.bool(KEY_ABSORPTION);
    }

    private boolean elytra() {
        return this.bool(KEY_ELYTRA);
    }

    private boolean crystal() {
        return this.bool(KEY_CRYSTAL);
    }

    private boolean trident() {
        return this.bool(KEY_TRIDENT);
    }

    private boolean tnt() {
        return this.bool(KEY_TNT);
    }

    private boolean tntAnyDistance() {
        return this.bool(KEY_TNT_ANY_DISTANCE);
    }

    private boolean mace() {
        return this.bool(KEY_MACE);
    }

    private boolean maceRoof() {
        return this.bool(KEY_MACE_ROOF);
    }

    private double tntRange() {
        return this.number(KEY_TNT_RANGE);
    }

    private double maceRange() {
        return this.number(KEY_MACE_RANGE);
    }

    private double maceHeight() {
        return this.number(KEY_MACE_HEIGHT);
    }

    private double maceRoofRadius() {
        return this.number(KEY_MACE_ROOF_RADIUS);
    }

    private double elytraHealth() {
        return this.number(KEY_ELYTRA_HEALTH);
    }

    public int targetSlot() {
        return this.targetSlot;
    }

    public int pendingSlot() {
        return this.pendingSlot;
    }

    public int enchantedCount() {
        return this.enchantedCount;
    }

    public void latchKey() {
        this.keyLatch = true;
    }

    private boolean bool(String key) {
        Setting setting = this.setting(key);
        return setting != null && setting.getBoolean();
    }

    private double number(String key) {
        Setting setting = this.setting(key);
        return setting == null ? 0.0 : setting.getNumber();
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }

    private static final class ItemSwap {
        int state;
        int selected = -1;
        int count;
        boolean active;

        private ItemSwap() {
        }
    }
}

