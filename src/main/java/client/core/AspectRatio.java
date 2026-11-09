/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class AspectRatio
extends Feature {
    public static final String MODULE = "aspect_ratio";
    public static final String DISPLAY = "\u0410\u0437\u043f\u0435\u0441\u0442\u0420\u0430\u0442\u0438\u043e";
    public static final int VTABLE_RVA = 12566984;
    public static final long RVA_CONSTRUCT = 2735200652352L;
    public static final long RVA_ON_ENABLE = 2735200653936L;
    private int previousAspect;
    private int appliedAspect;
    private long appliedAt;

    public AspectRatio() {
        super(MODULE, DISPLAY, Category.Render);
        this.add(Setting.mode("preset", "16:9", "16:9", "16:10", "4:3", "1:1", "\u0421\u0432\u043e\u0451"));
        this.add(Setting.number("ratio", 1.7778, 0.5, 4.0));
    }

    @Override
    public void onEnable() {
        this.previousAspect = Client.windowAspect();
        this.appliedAspect = 0;
        this.appliedAt = Client.timerNanos();
    }
}

