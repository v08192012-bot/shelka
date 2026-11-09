/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class Proxy
extends Feature {
    public static final String MODULE = "proxy";
    public static final String DISPLAY = "\u041f\u0440\u043e$\u0439";
    public static final int VTABLE_RVA = 12811088;
    public static final String VERSION_SOCKS4 = "SOCKS4";
    public static final String VERSION_SOCKS5 = "SOCKS5";
    public static final String DEFAULT_ADDRESS = "127.0.0.1:1080";

    public Proxy() {
        super(MODULE, DISPLAY, Category.Client);
        this.add(Setting.input("address", DEFAULT_ADDRESS));
        this.add(Setting.mode("socks5", VERSION_SOCKS5, VERSION_SOCKS4, VERSION_SOCKS5));
        this.add(Setting.input("username", ""));
        this.add(Setting.input("password", ""));
    }

    @Override
    public void onEnable() {
        this.applyProxy();
    }

    @Override
    public void onDisable() {
        this.applyProxy();
    }

    private void applyProxy() {
        if (this.enabled && Client.toggleGateOpen()) {
            int[] port = new int[1];
            String host = this.parseAddress(this.text("address"), port);
            if (host == null) {
                Client.applyProxy(false, true, "", 0, "", "");
            } else {
                Client.applyProxy(true, VERSION_SOCKS5.equals(this.mode("socks5")), host, port[0], this.text("username"), this.text("password"));
            }
        } else {
            Client.applyProxy(false, true, "", 0, "", "");
        }
    }

    private String parseAddress(String raw, int[] portOut) {
        int length;
        if (raw == null) {
            return null;
        }
        int begin = 0;
        for (length = raw.length(); length > 0 && (raw.charAt(begin) == ' ' || raw.charAt(begin) == '\t'); --length) {
            ++begin;
        }
        while (length > 0 && (raw.charAt(begin + length - 1) == ' ' || raw.charAt(begin + length - 1) == '\t')) {
            --length;
        }
        if (length <= 0) {
            return null;
        }
        int colon = raw.indexOf(58, begin);
        if (colon < begin || colon >= begin + length || colon + 1 >= begin + length) {
            return null;
        }
        int value = 0;
        for (int i = colon + 1; i < begin + length; ++i) {
            char ch = raw.charAt(i);
            if (ch < '0' || ch > '9') {
                return null;
            }
            if ((value = value * 10 + (ch - 48)) <= 65535) continue;
            return null;
        }
        if (value == 0) {
            return null;
        }
        portOut[0] = value;
        return raw.substring(begin, colon);
    }

    private String text(String name) {
        Setting s = this.setting(name);
        return s == null ? "" : s.getText();
    }

    private String mode(String name) {
        Setting s = this.setting(name);
        return s == null ? "" : s.getMode();
    }

    private Setting setting(String name) {
        for (Setting s : this.getSettings()) {
            if (!s.getName().equals(name)) continue;
            return s;
        }
        return null;
    }
}

