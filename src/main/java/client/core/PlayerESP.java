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

public final class PlayerESP
extends Feature {
    public static final String MODULE = "player_esp";
    public static final String DISPLAY = "\u041f\u043b\u0430\u0439\u0435\u0440\u0415\u0417\u041f";
    public static final int VTABLE_RVA = 12348968;
    public static final long RVA_ON_TICK = 2735200516880L;
    public static final long RVA_ON_RENDER = 2735200519552L;
    public static final long RVA_ON_ENABLE = 2735200516384L;
    public static final long RVA_ON_DISABLE = 2735200516560L;
    public static final long RVA_LAMBDA_VISIBILITY = 2735200526064L;
    private static final double NANO_SCALE = 1.0E-9;
    private static final float GLOW_RAMP_RATE = 5.0f;
    private static final float RAMP_LOW = 0.0f;
    private static final float RAMP_HIGH = 1.0f;
    private static final int FADE_TICKS = 5;
    private static PlayerESP active;
    private final List<Object> targets = new ArrayList<Object>();
    private final List<Object> boxes = new ArrayList<Object>();
    private final List<Object> friendBoxes = new ArrayList<Object>();
    private final List<Object> drawList = new ArrayList<Object>();
    private final List<Object> pending = new ArrayList<Object>();
    private boolean invisibleActive;
    private int fadeTimer;
    private boolean faded;
    private float glowRamp;
    private long lastFrameNanos;

    public PlayerESP() {
        super(MODULE, DISPLAY, Category.Render);
        this.add(Setting.mode("targets", "players", "players", "mobs", "all"));
        this.add(Setting.mode("mode", "box", "box", "glow"));
        this.add(Setting.bool("show_friends", true));
        this.add(Setting.mode("armor_filter", "all", "all", "armored", "netherite"));
        this.add(Setting.number("shape_geometry", 2.0, 0.1, 5.0));
        this.add(Setting.color("shape_colors", -1));
        this.add(Setting.bool("shape_glow", true));
        this.add(Setting.bool("shape_friends", false));
        this.add(Setting.gradient("glow_colors", -13183233, -38090));
        this.add(Setting.number("glow_halo", 24.0, 4.0, 96.0));
        this.add(Setting.bool("glow_animation_group", false));
        this.add(Setting.bool("glow_through_walls", true));
        this.add(Setting.number("line_width", 2.0, 0.1, 5.0));
        this.add(Setting.bool("distance_scale", true));
        this.add(Setting.color("line_color", -1));
        this.add(Setting.bool("outline", false));
        this.add(Setting.color("outline_color", -16777216));
        this.add(Setting.bool("fill", false));
        this.add(Setting.color("fill_color", 0x4CFFFFFF));
        this.add(Setting.bool("box_glow", true));
        this.add(Setting.number("box_glow_radius", 20.0, 4.0, 96.0));
        this.add(Setting.number("box_glow_intensity", 1.0, 0.1, 4.0));
        this.add(Setting.bool("friend_custom_color", false));
        this.add(Setting.color("friend_line_color", -16711681));
        this.add(Setting.color("friend_fill_color", 1275133951));
        this.add(Setting.gradient("glow_color", -13183233, -38090));
        this.add(Setting.number("glow_gradient_speed", 0.0, 0.0, 5.0));
        this.add(Setting.color("glow_fill_color", 0xFFFFFF));
        this.add(Setting.gradient("glow_friend_color", -16711681, -256));
        this.add(Setting.number("glow_radius", 24.0, 4.0, 96.0));
        this.add(Setting.number("glow_intensity", 1.5, 0.3, 4.0));
        this.add(Setting.bool("glow_animation", false));
        this.add(Setting.number("glow_animation_strength", 1.0, 0.0, 3.0));
        this.add(Setting.number("glow_animation_scale", 1.0, 1.0, 2.5));
    }

    public static PlayerESP active() {
        return active;
    }

    public List<Object> targets() {
        return this.targets;
    }

    public List<Object> boxes() {
        return this.boxes;
    }

    public List<Object> friendBoxes() {
        return this.friendBoxes;
    }

    public List<Object> drawList() {
        return this.drawList;
    }

    public List<Object> pending() {
        return this.pending;
    }

    public boolean invisibleActive() {
        return this.invisibleActive;
    }

    public int fadeTimer() {
        return this.fadeTimer;
    }

    public boolean faded() {
        return this.faded;
    }

    public float glowRamp() {
        return this.glowRamp;
    }

    public long lastFrameNanos() {
        return this.lastFrameNanos;
    }

    public void tickFade() {
        ++this.fadeTimer;
        if (this.fadeTimer > 5 && !this.faded) {
            this.faded = true;
        }
    }

    public void resetFade() {
        this.fadeTimer = 0;
    }

    @Override
    public void onEnable() {
        this.glowRamp = 0.0f;
        this.lastFrameNanos = Client.nanos();
        this.targets.clear();
        this.boxes.clear();
        this.friendBoxes.clear();
        Client.resetPlayerEspTimeline(this);
        this.invisibleActive = false;
        this.fadeTimer = 0;
        active = this;
    }

    @Override
    public void onDisable() {
        this.invisibleActive = false;
        active = null;
        this.targets.clear();
        this.boxes.clear();
        this.friendBoxes.clear();
        Client.resetPlayerEspTimeline(this);
    }

    @Override
    public void onTick() {
        if (!this.targets.isEmpty()) {
            this.targets.clear();
        }
        Client.resetPlayerEspTimeline(this);
        this.invisibleActive = false;
        if (!Client.inGame()) {
            return;
        }
        boolean players = Client.targetsMatchPlayers(this);
        boolean mobs = this.modeIs("targets", "mobs") ? true : this.modeIs("targets", "all");
        if (!players && !mobs) {
            return;
        }
        Entity local = Client.player();
        double[] reference = Client.entityPosition(local);
        boolean showFriends = this.flag("show_friends");
        boolean glowMode = this.modeIs("mode", "glow");
        boolean throughWallsGlow = glowMode && !this.flag("glow_through_walls");
        boolean armorFilter = Client.armorFilterNetherite(this);
        if (players) {
            Client.forEachPlayer(player -> Client.collectPlayerEspTarget(this, player, reference, throughWallsGlow, armorFilter, showFriends));
        }
        if (mobs) {
            Client.forEachEntity(entity -> Client.collectMobEspTarget(this, entity, reference, armorFilter, throughWallsGlow));
        }
        if (!glowMode || this.pending.isEmpty() || this.faded) {
            this.invisibleActive = false;
            Client.resetPlayerEspTimeline(this);
        } else {
            this.invisibleActive = true;
        }
    }

    @Override
    public void onRender() {
        long now = Client.nanos();
        long previous = this.lastFrameNanos;
        this.lastFrameNanos = now;
        float ramp = (float)((double)(now - previous) * 1.0E-9) * 5.0f + this.glowRamp;
        float low = ramp >= 0.0f ? ramp : 0.0f;
        this.glowRamp = ramp <= 1.0f ? low : 1.0f;
        Client.updatePlayerEspGroups(this);
        if (this.boxes.isEmpty() && this.friendBoxes.isEmpty()) {
            return;
        }
        if (this.modeIs("mode", "glow")) {
            Client.renderPlayerEspSolid(this);
            return;
        }
        Client.PlayerEspStyle style = new Client.PlayerEspStyle();
        style.lineWidth = this.num("line_width");
        style.distanceScale = this.flag("distance_scale");
        style.outline = this.flag("outline");
        style.outlineColor = this.colorOf("outline_color");
        style.fill = this.flag("fill");
        style.boxGlow = this.flag("box_glow");
        style.boxGlowRadius = (float)this.num("box_glow_radius");
        style.boxGlowIntensity = (float)this.num("box_glow_intensity");
        style.glowRamp = this.glowRamp;
        if (this.flag("friend_custom_color") && this.flag("show_friends")) {
            style.lineColor = this.colorOf("line_color");
            style.fillColor = this.colorOf("fill_color");
            Client.renderPlayerEspGroup(this, this.boxes, style);
            style.lineColor = this.colorOf("friend_line_color");
            style.fillColor = this.colorOf("friend_fill_color");
            Client.renderPlayerEspGroup(this, this.friendBoxes, style);
            return;
        }
        this.drawList.clear();
        this.drawList.addAll(this.boxes);
        this.drawList.addAll(this.friendBoxes);
        style.lineColor = this.colorOf("line_color");
        style.fillColor = this.colorOf("fill_color");
        Client.renderPlayerEspGroup(this, this.drawList, style);
    }

    private boolean flag(String name) {
        Setting setting = this.setting(name);
        return setting != null && setting.getBoolean();
    }

    private double num(String name) {
        Setting setting = this.setting(name);
        return setting == null ? 0.0 : setting.getNumber();
    }

    private int colorOf(String name) {
        Setting setting = this.setting(name);
        return setting == null ? 0 : setting.getColor();
    }

    private String mode(String name) {
        Setting setting = this.setting(name);
        return setting == null ? "" : setting.getMode();
    }

    private boolean modeIs(String name, String value) {
        return value.equals(this.mode(name));
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }
}

