/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.BlockPos;
import client.mc.Client;
import client.mc.Entity;
import java.util.ArrayList;
import java.util.List;

public final class PlayerChams
extends Feature {
    public static final String MODULE = "player_chams";
    public static final String DISPLAY = "\u041f\u043b\u0430\u0439\u0435\u0440\u0421\u0445\u0430\u043c\u0437";
    public static final int VTABLE_RVA = 12345664;
    private static final double MODEL_HALF_WIDTH = 0.5;
    private static final List<double[]> boxes = new ArrayList<double[]>();
    private static final List<double[]> outlines = new ArrayList<double[]>();
    private Entity localPlayer;

    public PlayerChams() {
        super(MODULE, DISPLAY, Category.Render);
        this.add(Setting.bool("armour", true));
        this.add(Setting.number("distance", 64.0, 8.0, 256.0));
    }

    @Override
    public void onEnable() {
        boxes.clear();
        outlines.clear();
        Client.markChamsDirty();
    }

    @Override
    public void onDisable() {
        boxes.clear();
        outlines.clear();
        this.localPlayer = null;
        Client.markChamsDirty();
    }

    @Override
    public void onTick() {
        boxes.clear();
        outlines.clear();
        Entity self = Client.player();
        if (self == null) {
            Client.markChamsDirty();
            return;
        }
        BlockPos center = Client.blockPosition(Client.playerHandle());
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;
        if (center != null) {
            x = center.x();
            y = center.y();
            z = center.z();
        }
        double reach = this.distance();
        double reachSq = reach * reach;
        boolean armour = this.armour();
        this.localPlayer = self;
        this.collect(self, x, y, z, reachSq, armour);
        this.prune();
        int mode = Client.renderMode();
        if (mode == 1) {
            return;
        }
        if (mode != 3) {
            Client.clearChams();
            return;
        }
        Client.renderChams(outlines, armour);
    }

    private void collect(Entity self, double x, double y, double z, double reachSq, boolean armour) {
        for (Entity entity : Client.entities()) {
            double dz;
            double dy;
            double[] pos;
            double dx;
            if (entity == null || entity == self || !Client.isLiving(entity) || (dx = (pos = Client.entityPosition(entity))[0] - x) * dx + (dy = pos[1] - y) * dy + (dz = pos[2] - z) * dz > reachSq) continue;
            double[] box = new double[]{pos[0] - 0.5, pos[1], pos[2] - 0.5, pos[0] + 0.5, pos[1] + Client.entityHeight(entity), pos[2] + 0.5};
            boxes.add(box);
            outlines.add(box);
        }
    }

    private void prune() {
        for (int i = boxes.size() - 1; i >= 0; --i) {
            if (outlines.size() > i) continue;
            boxes.remove(i);
        }
    }

    private boolean armour() {
        Setting setting = this.setting("armour");
        return setting == null || setting.getBoolean();
    }

    private double distance() {
        Setting setting = this.setting("distance");
        return setting == null ? 64.0 : setting.getNumber();
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }
}

