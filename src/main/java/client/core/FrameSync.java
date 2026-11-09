/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.mc.Client;

public final class FrameSync
extends Feature {
    public static final String MODULE = "frame_sync";
    public static final String DISPLAY = "\u0424\u0440\u0430\u043c\u0435\u0417\u0439\u043d\u0441";
    public static final int VTABLE_RVA = 12573616;
    public static final long RVA_ON_ENABLE = 2735200695152L;
    public static final long RVA_ON_DISABLE = 2735200695248L;
    private static final long NANOS_PER_SECOND = 1000000000L;
    private static final int DEFAULT_REFRESH_RATE = 60;
    private static FrameSync active;
    private long frameIntervalNanos = 0L;
    private long lastFrameTime = 0L;
    private long accumulatedNanos = 0L;
    private int refreshRate = 60;
    private boolean frameLimited = false;

    public FrameSync() {
        super(MODULE, DISPLAY, Category.Render);
        active = this;
        this.refreshRate = Client.monitorRefreshRate();
        this.frameIntervalNanos = 1000000000L / (long)this.refreshRate;
    }

    public static FrameSync active() {
        return active;
    }

    public long frameIntervalNanos() {
        return this.frameIntervalNanos;
    }

    public long lastFrameTime() {
        return this.lastFrameTime;
    }

    public long accumulatedNanos() {
        return this.accumulatedNanos;
    }

    public void setAccumulatedNanos(long value) {
        this.accumulatedNanos = value;
    }

    public int refreshRate() {
        return this.refreshRate;
    }

    public boolean frameLimited() {
        return this.frameLimited;
    }

    public void setFrameLimited(boolean value) {
        this.frameLimited = value;
    }

    @Override
    public void onEnable() {
        int rate = Client.monitorRefreshRate();
        this.frameIntervalNanos = 1000000000L / (long)rate;
        this.refreshRate = Client.monitorRefreshRate();
        this.lastFrameTime = Client.nanos();
        this.accumulatedNanos = 0L;
    }

    @Override
    public void onDisable() {
        this.frameLimited = false;
        Client.setFrameLimit(0);
    }
}

