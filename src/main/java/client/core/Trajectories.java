/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import java.util.ArrayList;
import java.util.List;

public final class Trajectories
extends Feature {
    public static final String MODULE = "trajectories";
    public static final String DISPLAY = "\u0422\u0440\u0430\u0436\u0435\u0441\u0442\u043e\u0440\u0438\u0435\u0437";
    public static final int VTABLE_RVA = 12354672;
    private static final double NANOS_PER_SECOND = 1.0E-9;
    private static final float FADE_IN = 1.0f;
    private static final float FADE_OUT = -1.0f;
    private static final float ANIMATION_SPEED = 20.0f;
    private static final float PROGRESS_MIN = 0.0f;
    private static final float PROGRESS_MAX = 1.0f;
    private static final float LANDING_VISIBLE_THRESHOLD = 0.001f;
    private final List<Landing> landings = new ArrayList<Landing>();
    private final List<Landing> pendingLandings = new ArrayList<Landing>();
    private float progress;
    private long lastFrameTime;

    public Trajectories() {
        super(MODULE, DISPLAY, Category.Render);
        this.add(Setting.mode("projectiles", "All", "All", "EnderPearl", "Snowball", "Egg", "Potion"));
        this.add(Setting.bool("show_line", true));
        this.add(Setting.color("line_color", 0xFF00FF));
        this.add(Setting.bool("show_landing", true));
        this.add(Setting.bool("landings", true));
    }

    @Override
    public void onEnable() {
        this.landings.clear();
        this.landings.addAll(this.pendingLandings);
        this.pendingLandings.clear();
        if (this.landings.isEmpty() && !this.pendingLandings.isEmpty()) {
            this.landings.addAll(this.pendingLandings);
        }
    }

    @Override
    public void onDisable() {
        this.landings.clear();
        this.pendingLandings.clear();
        this.progress = 0.0f;
        this.lastFrameTime = 0L;
    }

    @Override
    public void onTick() {
        boolean showLanding;
        long now = Client.nanoTime();
        double delta = 0.0;
        if (this.lastFrameTime != 0L) {
            delta = (double)(now - this.lastFrameTime) * 1.0E-9;
        }
        this.lastFrameTime = now;
        float target = -1.0f;
        if (!this.pendingLandings.isEmpty()) {
            for (Landing landing : this.pendingLandings) {
                if (!landing.ready) continue;
                target = 1.0f;
                break;
            }
        }
        this.progress = this.animate(this.progress + (float)delta * target * 20.0f);
        if (this.pendingLandings.isEmpty()) {
            return;
        }
        boolean showLine = this.showLine();
        boolean bl = showLanding = this.showLanding() && this.progress > 0.001f;
        if (!showLine && !showLanding) {
            return;
        }
        this.drawTrails();
        if (showLine) {
            for (Landing landing : this.pendingLandings) {
                landing.advance(this.lineColor());
            }
        }
        if (showLanding) {
            this.drawLandings();
        }
    }

    private float animate(float value) {
        if (value < 0.0f) {
            return 0.0f;
        }
        if (value > 1.0f) {
            return 1.0f;
        }
        return value;
    }

    private void drawTrails() {
        for (Landing landing : this.pendingLandings) {
            Client.drawTrailLine(landing.x, landing.y, landing.z, this.lineColor(), this.progress);
        }
    }

    private void drawLandings() {
        for (Landing landing : this.pendingLandings) {
            Client.drawLandingBox(landing.x, landing.y, landing.z, this.lineColor(), this.progress);
        }
    }

    private boolean showLine() {
        Setting setting = this.setting("show_line");
        return setting == null || setting.getBoolean();
    }

    private boolean showLanding() {
        Setting setting = this.setting("show_landing");
        return setting == null || setting.getBoolean();
    }

    private int lineColor() {
        Setting setting = this.setting("line_color");
        return setting == null ? 0xFF00FF : setting.getColor();
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }

    public static final class Landing {
        double x;
        double y;
        double z;
        double height;
        boolean ready;
        final List<double[]> points = new ArrayList<double[]>();

        void advance(int color) {
            if (this.ready) {
                return;
            }
            this.points.add(new double[]{this.x, this.y, this.z});
        }
    }
}

