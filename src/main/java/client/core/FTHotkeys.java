/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class FTHotkeys
extends Feature {
    public static final String MODULE = "fthotkeys";
    public static final String DISPLAY = "\u0424\u0422\u0425\u043e\u0442\u043a\u0435\u044b\u0437";
    public static final int VTABLE_RVA = 12313128;
    public static final long RVA_ON_TICK = 2735200280448L;
    public static final long RVA_ON_DISABLE = 2735200277840L;
    public static final long RVA_TRIGGER_TICK = 2735200280720L;
    private static final int NO_SLOT = -1;
    private boolean menuPending;
    private int menuTicks;
    private int clickCounter = -1;

    public FTHotkeys() {
        super(MODULE, DISPLAY, Category.Player);
        this.add(Setting.number("arena_slot", 25.0, 1.0, 54.0, 1.0));
        this.add(Setting.number("click_delay", 1.0, 0.0, 20.0, 1.0));
        this.add(Setting.number("open_timeout", 60.0, 10.0, 2000.0, 5.0));
        this.add(Setting.key("arena_trigger", 0));
        this.add(Setting.key("invest_trigger", 0));
        this.add(Setting.key("storage_trigger", 0));
    }

    public boolean menuPending() {
        return this.menuPending;
    }

    public void setMenuPending(boolean value) {
        this.menuPending = value;
    }

    public int menuTicks() {
        return this.menuTicks;
    }

    public void setMenuTicks(int value) {
        this.menuTicks = value;
    }

    public int clickCounter() {
        return this.clickCounter;
    }

    public void setClickCounter(int value) {
        this.clickCounter = value;
    }

    @Override
    public void onEnable() {
        this.menuPending = false;
        this.menuTicks = 0;
        this.clickCounter = -1;
    }

    @Override
    public void onDisable() {
        this.menuPending = false;
        this.menuTicks = 0;
        this.clickCounter = -1;
    }

    @Override
    public void onTick() {
        Client.fthotkeyTick(this);
        if (!this.menuPending) {
            return;
        }
        if (!Client.inGame() || ++this.menuTicks > (int)this.openTimeout()) {
            this.menuTicks = 0;
            this.menuPending = false;
            this.clickCounter = -1;
            return;
        }
        if (Client.inventoryScreenOpen()) {
            int slot = (int)this.arenaSlot() - 1;
            if (slot >= 0 && slot < Client.containerSize()) {
                int counter = this.clickCounter;
                if (counter < 0) {
                    this.clickCounter = 0;
                    counter = 0;
                }
                if (counter < (int)this.clickDelay()) {
                    this.clickCounter = counter + 1;
                    return;
                }
                Client.clickSlot(slot, 0, 0, 0);
                Client.closeScreen();
            }
            this.menuTicks = 0;
            this.menuPending = false;
            this.clickCounter = -1;
            return;
        }
    }

    private double arenaSlot() {
        Setting setting = this.setting("arena_slot");
        return setting == null ? 1.0 : setting.getNumber();
    }

    private double clickDelay() {
        Setting setting = this.setting("click_delay");
        return setting == null ? 2.0 : setting.getNumber();
    }

    private double openTimeout() {
        Setting setting = this.setting("open_timeout");
        return setting == null ? 5.0 : setting.getNumber();
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }
}

