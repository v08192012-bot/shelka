/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import client.mc.Entity;
import java.util.ArrayList;
import java.util.List;

public final class TntTimer
extends Feature {
    public static final String MODULE = "tnt_timer";
    public static final String DISPLAY = "\u0422\u043d\u0442\u0422\u0438\u043c\u0435\u0440";
    public static final int VTABLE_RVA = 12353032;
    public static final long RVA_CONSTRUCT = 2735200543472L;
    public static final long RVA_ON_TICK = 2735200544368L;
    public static final long RVA_ON_RENDER = 2735200544864L;
    public static final long RVA_ON_DISABLE = 2735200544288L;
    private static final double NANOS_TO_SECONDS = 1.0E-9;
    private static final double MAX_DELTA_SECONDS = 0.1;
    private static final double SMOOTHING = 10.0;
    private static final double MAX_SMOOTHING = 1.0;
    private static final double SCALE_PER_BLOCK = 0.0025;
    private static final double MIN_SCALE = 0.02;
    private static final double MAX_SCALE = 0.1;
    private static final double PLATE_HEIGHT = 1.5;
    private static final double FUSE_TICKS = 20.0;
    private static final double PLATE_SCALE_DEFAULT = 0.3;
    private final List<Entity> tracked = new ArrayList<Entity>();
    private final List<Integer> aliveIds = new ArrayList<Integer>();
    private final List<Float> scales = new ArrayList<Float>();
    private long lastUpdate;

    public TntTimer() {
        super(MODULE, DISPLAY, Category.Render);
        this.add(Setting.number("plate_scale", 0.3, 0.1, 1.0, 0.1));
    }

    @Override
    public void onDisable() {
        this.tracked.clear();
        this.aliveIds.clear();
        this.scales.clear();
        this.lastUpdate = 0L;
    }

    @Override
    public void onTick() {
        this.aliveIds.clear();
        if (!Client.inGame()) {
            return;
        }
        Client.forEachEntity(entity -> {
            if (Client.isPrimedTnt(entity)) {
                this.aliveIds.add(Client.entityId(entity));
            }
        });
        for (int i = this.tracked.size() - 1; i >= 0; --i) {
            Entity entity2 = this.tracked.get(i);
            if (this.aliveIds.contains(Client.entityId(entity2))) continue;
            this.tracked.remove(i);
            if (i >= this.scales.size()) continue;
            this.scales.remove(i);
        }
    }

    @Override
    public void onRender() {
        float elapsed;
        long now = Client.timerNanos();
        float delta = this.lastUpdate == 0L ? 0.0f : ((double)(elapsed = (float)((double)(now - this.lastUpdate) * 1.0E-9)) <= 0.1 ? elapsed : 0.1f);
        this.lastUpdate = now;
        float factor = (float)Math.min((double)delta * 10.0, 1.0);
        double plateScale = this.plateScale();
        while (this.scales.size() < this.tracked.size()) {
            this.scales.add(Float.valueOf(0.0f));
        }
        for (int i = 0; i < this.tracked.size(); ++i) {
            double dz;
            double dy;
            double[] self;
            Entity entity = this.tracked.get(i);
            if (!Client.isAlive(entity)) continue;
            double[] position = Client.entityPosition(entity);
            double dx = position[0] - (self = Client.playerPosition())[0];
            double distance = Math.sqrt(dx * dx + (dy = position[1] - self[1]) * dy + (dz = position[2] - self[2]) * dz);
            double scale = distance * 0.0025;
            if (scale > 0.1) {
                scale = 0.1;
            }
            if (scale < 0.02) {
                scale = 0.02;
            }
            float target = (float)(scale * plateScale);
            float previous = this.scales.get(i).floatValue();
            this.scales.set(i, Float.valueOf((target - previous) * factor + previous));
            double fuse = (double)Client.tntFuse(entity) / 20.0;
            if (fuse <= 0.0) {
                fuse = 0.0;
            }
            Client.drawTntTimer(position[0], position[1] + 1.5, position[2], fuse, this.scales.get(i).floatValue());
        }
    }

    private double plateScale() {
        Setting setting = this.setting("plate_scale");
        return setting == null ? 0.3 : setting.getNumber();
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }
}

