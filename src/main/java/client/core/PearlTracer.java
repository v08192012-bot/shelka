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
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class PearlTracer
extends Feature {
    public static final String MODULE = "pearl_tracer";
    public static final String DISPLAY = "\u041f\u0435\u0430\u0440\u043b\u0422\u0440\u0430\u0441\u0435\u0440";
    public static final int VTABLE_RVA = 12344600;
    private static final int ENTITIES_OFFSET = 440;
    private static final int MARKERS_OFFSET = 504;
    private static final int SCRATCH_OFFSET = 568;
    private static final int LAST_FRAME_OFFSET = 592;
    private static final int SHOW_TRAJECTORY_OFFSET = 832;
    private static final int SHOW_LANDING_POINT_OFFSET = 1072;
    private static final int SHOW_HITBOX_OFFSET = 1312;
    private static final int SHOW_PLATE_OFFSET = 1552;
    private static final int PLATE_SCALE_OFFSET = 1792;
    private static final int IGNORE_OWN_OFFSET = 2384;
    private static final int TRACK_FRIENDS_OFFSET = 2624;
    private static final int TRAJECTORY_COLOR_OFFSET = 3144;
    private static final int LANDING_COLOR_OFFSET = 3392;
    private static final int FRIEND_TRAJECTORY_COLOR_OFFSET = 3640;
    private static final int FRIEND_LANDING_COLOR_OFFSET = 3888;
    private static final int ENTRY_ID_OFFSET = 16;
    private static final int ENTRY_LANDED_OFFSET = 72;
    private static final int ENTRY_TICKS_OFFSET = 76;
    private static final int ENTRY_PROGRESS_OFFSET = 80;
    private static final int ENTRY_FRIEND_OFFSET = 84;
    private static final int ENTRY_INITIALIZED_OFFSET = 85;
    private static final int ENTRY_SEEN_OFFSET = 86;
    private static final double DRAG = 0.99;
    private static final double GRAVITY = 0.03;
    private static final double SEGMENT_EPSILON = 1.0E-4;
    private static final double MIN_TRACE_Y = -64.0;
    private static final double MAX_TRACE_RANGE_SQ = 250000.0;
    private static final double NANO_SCALE = 1.0E-9;
    private static final float MAX_FRAME_STEP = 0.1f;
    private static final int SIMULATED_TICKS = 200;
    private static final int SEGMENTS_BEHIND = 1;
    private static final int SEGMENTS_AHEAD = 10;
    private static final double BEST_DISTANCE_START = 1.0E300;
    private static final double MARKER_HALF = 0.5;
    private static final float LANDING_LINE_WIDTH = 0.8f;
    private static final float TRAJECTORY_LINE_WIDTH = 1.0f;
    private static final float BOX_LINE_WIDTH = 0.6f;
    private static final double BOX_HALF = 0.3;
    private static final double BOX_HEIGHT = 1.8;
    private static final float ALPHA_SCALE = 0.5f;
    private static final float MAX_ALPHA = 255.0f;
    private static final float PLATE_ANIM_SPEED = 10.0f;
    private static final float PLATE_ANIM_LIMIT = 1.0f;
    private static final double PLATE_HEIGHT = 1.0;
    private static final double TICKS_PER_SECOND = 20.0;
    private static final double SCALE_PER_BLOCK = 0.0025;
    private static final double MIN_PLATE_SCALE = 0.02;
    private static final double MAX_PLATE_SCALE = 0.1;
    private static final String PLATE_ITEM = "minecraft:ender_pearl";
    private final Map<Integer, Trace> traces = new LinkedHashMap<Integer, Trace>();
    private final Map<Integer, Float> markers = new LinkedHashMap<Integer, Float>();
    private final List<double[]> scratch = new ArrayList<double[]>();
    private long lastFrame;

    public PearlTracer() {
        super(MODULE, DISPLAY, Category.Render);
        this.add(Setting.mode("display", "show_trajectory", "show_trajectory", "show_landing_point", "show_hitbox", "show_plate", "plate_scale"));
        this.add(Setting.mode("sources", "ignore_own", "ignore_own", "track_friends"));
        this.add(Setting.mode("colors", "trajectory_color", "trajectory_color", "landing_color", "friend_trajectory_color", "friend_landing_color"));
        this.add(Setting.bool("show_trajectory", true));
        this.add(Setting.bool("show_landing_point", true));
        this.add(Setting.bool("show_hitbox", true));
        this.add(Setting.bool("show_plate", true));
        this.add(Setting.number("plate_scale", 0.3, 0.1, 1.0));
        this.add(Setting.bool("ignore_own", true));
        this.add(Setting.bool("track_friends", true));
        this.add(Setting.color("trajectory_color", -1));
        this.add(Setting.color("landing_color", -1));
        this.add(Setting.color("friend_trajectory_color", -10046721));
        this.add(Setting.color("friend_landing_color", -10046721));
    }

    @Override
    public void onDisable() {
        this.traces.clear();
        this.markers.clear();
        this.lastFrame = 0L;
    }

    @Override
    protected void onSettingsVisibilityChanged(boolean visible) {
        this.applyVisibility();
    }

    @Override
    public void onTick() {
        this.applyVisibility();
        if (!Client.inGame()) {
            return;
        }
        Entity self = Client.player();
        for (Trace trace : this.traces.values()) {
            trace.seen = false;
        }
        int[] budget = new int[]{1};
        Client.forEachEntity(entity -> this.collect((Entity)entity, self, budget));
        Iterator<Map.Entry<Integer, Trace>> traceIterator = this.traces.entrySet().iterator();
        while (traceIterator.hasNext()) {
            if (traceIterator.next().getValue().seen) continue;
            traceIterator.remove();
        }
        Iterator<Integer> markerIterator = this.markers.keySet().iterator();
        while (markerIterator.hasNext()) {
            if (this.traces.containsKey(markerIterator.next())) continue;
            markerIterator.remove();
        }
    }

    @Override
    public void onRender() {
        float step;
        if (this.traces.isEmpty()) {
            return;
        }
        long now = Client.nanos();
        if (this.lastFrame == 0L) {
            step = 0.0f;
        } else {
            float elapsed = (float)((double)(now - this.lastFrame) * 1.0E-9);
            step = 0.1f;
            if (elapsed <= 0.1f) {
                step = elapsed;
            }
        }
        this.lastFrame = now;
        if (this.showTrajectory()) {
            this.drawTrajectories();
        }
        if (this.showLandingPoint()) {
            this.drawLandingMarkers();
        }
        if (this.showHitbox()) {
            this.drawBoxes();
        }
        if (this.showPlate()) {
            this.drawPlates(step);
        }
    }

    private void collect(Entity entity, Entity self, int[] budget) {
        boolean own;
        if (!Client.isEnderPearl(entity)) {
            return;
        }
        Entity owner = Client.entityOwner(entity);
        boolean bl = own = owner != null && self != null && Client.sameEntity(owner, self);
        if (this.ignoreOwn() && own) {
            return;
        }
        int id = Client.entityId(entity);
        Trace trace = this.traces.get(id);
        if (trace == null) {
            trace = new Trace(id);
            this.traces.put(id, trace);
        }
        trace.seen = true;
        boolean friend = false;
        if (owner != null && Client.isPlayerEntity(owner) && !own) {
            friend = Client.isFriendName(Client.playerName(owner));
        }
        trace.friend = friend;
        double[] position = Client.entityPosition(entity);
        if (!trace.initialized && budget[0] > 0) {
            budget[0] = budget[0] - 1;
            this.simulate(entity, position, trace);
            trace.initialized = true;
        }
        if (trace.path.size() < 2) {
            return;
        }
        this.updateProgress(trace, position);
    }

    private void simulate(Entity entity, double[] start, Trace trace) {
        trace.path.clear();
        trace.landed = false;
        trace.ticks = 200;
        double[] current = new double[]{start[0], start[1], start[2]};
        double[] motion = Client.deltaMovement(entity);
        double vx = motion[0];
        double vy = motion[1];
        double vz = motion[2];
        double[] next = new double[3];
        int step = 0;
        do {
            if ((step & 1) == 0) {
                trace.path.add(new double[]{current[0], current[1], current[2]});
            }
            vy = (vy - 0.03) * 0.99;
            next[0] = (vx *= 0.99) + current[0];
            next[1] = vy + current[1];
            next[2] = (vz *= 0.99) + current[2];
            if (this.segmentBlocked(entity, current, next)) {
                trace.landed = true;
                trace.landing[0] = current[0];
                trace.landing[1] = current[1];
                trace.landing[2] = current[2];
                trace.ticks = step;
                break;
            }
            current[0] = next[0];
            current[1] = next[1];
            current[2] = next[2];
            if (!(current[1] < -64.0) && !(PearlTracer.distanceSq(start, current) > 250000.0)) continue;
            trace.ticks = step;
            break;
        } while (++step < 200);
        if (!trace.landed && !trace.path.isEmpty()) {
            double[] last = trace.path.get(trace.path.size() - 1);
            trace.landing[0] = last[0];
            trace.landing[1] = last[1];
            trace.landing[2] = last[2];
            trace.landed = true;
        }
    }

    private boolean segmentBlocked(Entity entity, double[] from, double[] to) {
        if (PearlTracer.distanceSq(from, to) < 1.0E-4) {
            return false;
        }
        return !Client.hasLineOfSight(from, to);
    }

    private void updateProgress(Trace trace, double[] position) {
        int start;
        List<double[]> path = trace.path;
        int count = path.size();
        if (count < 2) {
            return;
        }
        float found = trace.progress;
        int index = (int)trace.progress;
        int end = count - 1;
        if (index + 10 < end) {
            end = index + 10;
        }
        int n = start = index == 0 ? 0 : index - 1;
        if (start < end) {
            double best = 1.0E300;
            for (int i = start; i < end; ++i) {
                double dz;
                double dy;
                double[] from = path.get(i);
                double[] to = path.get(i + 1);
                double dx = to[0] - from[0];
                double lengthSq = dx * dx + (dy = to[1] - from[1]) * dy + (dz = to[2] - from[2]) * dz;
                if (lengthSq < 1.0E-4) continue;
                double t = ((position[0] - from[0]) * dx + (position[1] - from[1]) * dy + (position[2] - from[2]) * dz) / lengthSq;
                if (t < 0.0) {
                    t = 0.0;
                } else if (t > 1.0) {
                    t = 1.0;
                }
                double offsetX = t * dx + from[0] - position[0];
                double offsetY = t * dy + from[1] - position[1];
                double offsetZ = t * dz + from[2] - position[2];
                double distance = offsetX * offsetX + offsetY * offsetY + offsetZ * offsetZ;
                if (!(distance < best)) continue;
                best = distance;
                found = (float)((double)i + t);
            }
        }
        if (found > trace.progress) {
            trace.progress = found;
        }
    }

    private void drawTrajectories() {
        for (Trace trace : this.traces.values()) {
            int index;
            int count = trace.path.size();
            if (count <= 1 || (index = (int)trace.progress) >= count - 1) continue;
            int color = this.trackFriends() && trace.friend ? this.friendTrajectoryColor() : this.trajectoryColor();
            this.scratch.clear();
            double[] from = trace.path.get(index);
            double[] to = trace.path.get(index + 1);
            double t = (double)trace.progress - (double)index;
            this.scratch.add(new double[]{(to[0] - from[0]) * t + from[0], (to[1] - from[1]) * t + from[1], (to[2] - from[2]) * t + from[2]});
            for (int i = index + 1; i < count; ++i) {
                this.scratch.add(trace.path.get(i));
            }
            int segments = this.scratch.size();
            if (segments <= 1) continue;
            int i = 0;
            while (i + 1 < segments) {
                Client.drawWorldLine(this.scratch.get(i), this.scratch.get(i + 1), color, 1.0f);
                ++i;
            }
        }
    }

    private void drawLandingMarkers() {
        for (Trace trace : this.traces.values()) {
            if (!trace.landed) continue;
            int color = this.trackFriends() && trace.friend ? this.friendLandingColor() : this.landingColor();
            double x = trace.landing[0];
            double y = trace.landing[1];
            double z = trace.landing[2];
            Client.drawWorldLine(new double[]{x - 0.5, y, z}, new double[]{x + 0.5, y, z}, color, 0.8f);
            Client.drawWorldLine(new double[]{x, y - 0.5, z}, new double[]{x, y + 0.5, z}, color, 0.8f);
            Client.drawWorldLine(new double[]{x, y, z - 0.5}, new double[]{x, y, z + 0.5}, color, 0.8f);
        }
    }

    private void drawBoxes() {
        for (Trace trace : this.traces.values()) {
            if (!trace.landed) continue;
            int color = this.trackFriends() && trace.friend ? this.friendLandingColor() : this.landingColor();
            float alpha = (float)(color >>> 24) * 0.5f;
            if (alpha < 0.0f) {
                alpha = 0.0f;
            } else if (alpha > 255.0f) {
                alpha = 255.0f;
            }
            int shaded = (int)alpha << 24 | color & 0xFFFFFF;
            double x = trace.landing[0];
            double y = trace.landing[1];
            double z = trace.landing[2];
            double top = y + 1.8;
            double minX = x - 0.3;
            double maxX = x + 0.3;
            double minZ = z - 0.3;
            double maxZ = z + 0.3;
            double[] levels = new double[]{y, top};
            for (int i = 0; i < levels.length; ++i) {
                double level = levels[i];
                Client.drawWorldLine(new double[]{minX, level, minZ}, new double[]{maxX, level, minZ}, shaded, 0.6f);
                Client.drawWorldLine(new double[]{maxX, level, minZ}, new double[]{maxX, level, maxZ}, shaded, 0.6f);
                Client.drawWorldLine(new double[]{maxX, level, maxZ}, new double[]{minX, level, maxZ}, shaded, 0.6f);
                Client.drawWorldLine(new double[]{minX, level, maxZ}, new double[]{minX, level, minZ}, shaded, 0.6f);
            }
            Client.drawWorldLine(new double[]{minX, y, minZ}, new double[]{minX, top, minZ}, shaded, 0.6f);
            Client.drawWorldLine(new double[]{maxX, y, minZ}, new double[]{maxX, top, minZ}, shaded, 0.6f);
            Client.drawWorldLine(new double[]{maxX, y, maxZ}, new double[]{maxX, top, maxZ}, shaded, 0.6f);
            Client.drawWorldLine(new double[]{minX, y, maxZ}, new double[]{minX, top, maxZ}, shaded, 0.6f);
        }
    }

    private void drawPlates(float step) {
        for (Trace trace : this.traces.values()) {
            double offsetZ;
            double offsetY;
            double[] eye;
            double offsetX;
            double distance;
            double scale;
            if (!trace.landed) continue;
            double seconds = ((double)trace.ticks - ((double)trace.progress + (double)trace.progress)) / 20.0;
            if (seconds <= 0.0) {
                seconds = 0.0;
            }
            if ((scale = (distance = Math.sqrt((offsetX = (eye = Client.eyePosition())[0] - trace.landing[0]) * offsetX + (offsetY = eye[1] - trace.landing[1]) * offsetY + (offsetZ = eye[2] - trace.landing[2]) * offsetZ)) * 0.0025) < 0.02) {
                scale = 0.02;
            } else if (scale > 0.1) {
                scale = 0.1;
            }
            float target = (float)(scale * this.plateScale());
            Float stored = this.markers.get(trace.id);
            float animated = stored == null ? target : stored.floatValue();
            float factor = step * 10.0f;
            if (factor > 1.0f) {
                factor = 1.0f;
            }
            animated = factor * (target - animated) + animated;
            this.markers.put(trace.id, Float.valueOf(animated));
            Client.drawWorldPlate(new double[]{trace.landing[0], trace.landing[1] + 1.0, trace.landing[2]}, animated, PLATE_ITEM, PearlTracer.plateLabel(seconds));
        }
    }

    private void applyVisibility() {
        Setting colors;
        Setting plateScale;
        Setting friendLanding;
        Setting friendTrajectory;
        Setting landing;
        Setting trajectory = this.setting("trajectory_color");
        if (trajectory != null) {
            trajectory.setVisible(this.showTrajectory());
        }
        if ((landing = this.setting("landing_color")) != null) {
            landing.setVisible(this.showLandingPoint());
        }
        if ((friendTrajectory = this.setting("friend_trajectory_color")) != null) {
            friendTrajectory.setVisible(this.trackFriends() && this.showTrajectory());
        }
        if ((friendLanding = this.setting("friend_landing_color")) != null) {
            friendLanding.setVisible(this.trackFriends() && this.showLandingPoint());
        }
        if ((plateScale = this.setting("plate_scale")) != null) {
            plateScale.setVisible(this.showPlate());
        }
        if ((colors = this.setting("colors")) != null) {
            colors.setVisible(this.showTrajectory() || this.showLandingPoint());
        }
    }

    private static double distanceSq(double[] a, double[] b) {
        double dx = a[0] - b[0];
        double dy = a[1] - b[1];
        double dz = a[2] - b[2];
        return dx * dx + dy * dy + dz * dz;
    }

    private static String plateLabel(double value) {
        return String.format(Locale.ROOT, "%.6f", value);
    }

    private boolean showTrajectory() {
        return this.flag("show_trajectory");
    }

    private boolean showLandingPoint() {
        return this.flag("show_landing_point");
    }

    private boolean showHitbox() {
        return this.flag("show_hitbox");
    }

    private boolean showPlate() {
        return this.flag("show_plate");
    }

    private boolean ignoreOwn() {
        return this.flag("ignore_own");
    }

    private boolean trackFriends() {
        return this.flag("track_friends");
    }

    private int landingColor() {
        Setting setting = this.setting("landing_color");
        return setting == null ? 0 : setting.getColor();
    }

    private int trajectoryColor() {
        Setting setting = this.setting("trajectory_color");
        return setting == null ? 0 : setting.getColor();
    }

    private int friendTrajectoryColor() {
        Setting setting = this.setting("friend_trajectory_color");
        return setting == null ? 0 : setting.getColor();
    }

    private int friendLandingColor() {
        Setting setting = this.setting("friend_landing_color");
        return setting == null ? 0 : setting.getColor();
    }

    private double plateScale() {
        Setting setting = this.setting("plate_scale");
        return setting == null ? 0.3 : setting.getNumber();
    }

    private boolean flag(String name) {
        Setting setting = this.setting(name);
        return setting != null && setting.getBoolean();
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }

    private static final class Trace {
        private final int id;
        private final List<double[]> path = new ArrayList<double[]>();
        private final double[] landing = new double[3];
        private boolean landed;
        private int ticks;
        private float progress;
        private boolean friend;
        private boolean initialized;
        private boolean seen;

        private Trace(int id) {
            this.id = id;
        }
    }
}

