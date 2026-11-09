/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;

public final class AutoSell
extends Feature {
    public static final String MODULE = "autosell";
    public static final int VTABLE_RVA = 0xBBB488;
    private boolean running;

    public AutoSell() {
        super(MODULE, "", Category.Player);
        this.add(Setting.mode("server", "\u0430\u0443\u043a\u0446\u0438\u043e\u043d", "\u0430\u0443\u043a\u0446\u0438\u043e\u043d", "\u0438\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044c"));
        this.add(Setting.mode("sell_mode", "\u0412\u0441\u0435 \u0441\u0440\u0430\u0437\u0443", "\u0412\u0441\u0435 \u0441\u0440\u0430\u0437\u0443", "\u041f\u043e \u043e\u0434\u043d\u043e\u0439 \u0448\u0442\u0443\u043a\u0435", "\u041e\u0434\u043d\u0430 \u0446\u0435\u043d\u0430"));
        this.add(Setting.number("markup", 0.0, 0.0, 100.0));
        this.add(Setting.key("sell_bind", 0));
        this.add(Setting.bool("one_price", false));
        this.add(Setting.mode("one_price_layout", "\u0412\u044b\u043a\u043b\u0430\u0434\u043a\u0430", "\u0412\u044b\u043a\u043b\u0430\u0434\u043a\u0430"));
        this.add(Setting.mode("auto_inventory", "\u0422\u043e\u043b\u044c\u043a\u043e \u0445\u043e\u0442\u0431\u0430\u0440", "\u0422\u043e\u043b\u044c\u043a\u043e \u0445\u043e\u0442\u0431\u0430\u0440", "\u0424\u0443\u043b\u043b \u0438\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044c"));
        this.add(Setting.number("sweep_range", 3.0, 1.0, 6.0));
        this.add(Setting.bool("head_turn", true));
    }

    @Override
    public void onDisable() {
        this.running = false;
    }

    public String server() {
        return this.modeOf("server", "\u0430\u0443\u043a\u0446\u0438\u043e\u043d");
    }

    public String sellMode() {
        return this.modeOf("sell_mode", "\u0412\u0441\u0435 \u0441\u0440\u0430\u0437\u0443");
    }

    public double markup() {
        return this.number("markup", 0.0);
    }

    public int sellBind() {
        Setting s = this.setting("sell_bind");
        return s == null ? 0 : s.getKey();
    }

    public boolean onePrice() {
        return this.bool("one_price", false);
    }

    public String onePriceLayout() {
        return this.modeOf("one_price_layout", "\u0412\u044b\u043a\u043b\u0430\u0434\u043a\u0430");
    }

    public String autoInventory() {
        return this.modeOf("auto_inventory", "\u0422\u043e\u043b\u044c\u043a\u043e \u0445\u043e\u0442\u0431\u0430\u0440");
    }

    public double sweepRange() {
        return this.number("sweep_range", 3.0);
    }

    public boolean headTurn() {
        return this.bool("head_turn", true);
    }

    public boolean isRunning() {
        return this.running;
    }

    private String modeOf(String name, String fallback) {
        Setting s = this.setting(name);
        return s == null ? fallback : s.getMode();
    }

    private double number(String name, double fallback) {
        Setting s = this.setting(name);
        return s == null ? fallback : s.getNumber();
    }

    private boolean bool(String name, boolean fallback) {
        Setting s = this.setting(name);
        return s == null ? fallback : s.getBoolean();
    }

    private Setting setting(String name) {
        for (Setting s : this.getSettings()) {
            if (!s.getName().equals(name)) continue;
            return s;
        }
        return null;
    }
}

