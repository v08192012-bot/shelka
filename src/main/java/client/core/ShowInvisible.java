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

public final class ShowInvisible
extends Feature {
    public static final String MODULE = "show_invisible";
    public static final String DISPLAY = "\u0417\u0445\u043e\u0448\u0418\u043d\u0432\u0438\u0437\u0438\u0431\u043b\u0435";
    public static final int VTABLE_RVA = 12350448;
    private static final double MODEL_HALF_WIDTH = 0.5;
    private static final double BOX_PADDING = 0.1;
    private static final double NAME_PADDING = 0.05;
    private static final int BOX_COLOR = -16776961;
    private static final int OUTLINE_COLOR = 0x4CFFFFFF;
    private static final double OUTLINE_WIDTH = 0.008;
    private final List<Entity> players = new ArrayList<Entity>();
    private final List<double[]> boxes = new ArrayList<double[]>();
    private final List<double[]> names = new ArrayList<double[]>();
    private final List<double[]> outlines = new ArrayList<double[]>();

    public ShowInvisible() {
        super(MODULE, DISPLAY, Category.Render);
        this.add(Setting.bool("solid", true));
        this.add(Setting.bool("show_hitbox", true));
    }

    @Override
    public void onEnable() {
        this.stash();
        this.players.clear();
        this.boxes.clear();
        this.names.clear();
        this.outlines.clear();
    }

    @Override
    public void onDisable() {
        this.stash();
        this.players.clear();
        this.boxes.clear();
        this.names.clear();
        this.outlines.clear();
    }

    @Override
    public void onTick() {
        this.stash();
        this.players.clear();
        if (!Client.inGame()) {
            return;
        }
        Entity self = Client.player();
        if (self == null) {
            return;
        }
        boolean solid = this.solid();
        for (Entity entity : Client.entities()) {
            if (entity == null || !Client.isLiving(entity) || !solid && !Client.isInvisible(entity)) continue;
            this.players.add(entity);
        }
    }

    public void render() {
        this.stash();
        if (this.players.isEmpty()) {
            return;
        }
        for (Entity entity : this.players) {
            double[] position = Client.entityPosition(entity);
            double half = 0.5 * (double)Client.entityScale(entity);
            double[] bounds = new double[]{position[0] - half - 0.1, position[1] - 0.1, position[2] - half - 0.1, position[0] + half + 0.1, position[1] + Client.entityHeight(entity) + 0.1, position[2] + half + 0.1};
            if (!Client.isBoxVisible(bounds)) continue;
            double[] view = Client.interpolatedPosition(entity);
            double[] box = new double[]{view[0] - half, view[1], view[2] - half, view[0] + half, view[1] + Client.entityHeight(entity), view[2] + half};
            this.boxes.add(box);
            double eye = Client.entityEyeHeight(entity);
            double[] outline = new double[]{view[0] - half, view[1] - 0.05, view[2] - half, view[0] + half, view[1] + eye + 0.05, view[2] + half};
            this.outlines.add(outline);
            double head = Client.entityNameHeight(entity);
            double[] name = new double[]{view[0], view[1] + head + eye, view[2], view[0] + half * 2.0, view[1] + head * 2.0 + half, view[2] + half * 2.0};
            this.names.add(name);
        }
        if (this.boxes.isEmpty()) {
            return;
        }
        Client.fillBoxes(this.boxes, -16776961);
        Client.fillBoxes(this.names, 0x4CFFFFFF);
        for (double[] outline : this.outlines) {
            Client.drawBoxOutline(outline, -16776961, 0.008);
        }
    }

    private void stash() {
        this.names.clear();
        this.boxes.clear();
        this.outlines.clear();
    }

    private boolean solid() {
        Setting setting = this.setting("solid");
        return setting == null || setting.getBoolean();
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }
}

