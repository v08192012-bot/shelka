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

public final class Waypoints
extends Feature {
    public static final String MODULE = "waypoints";
    public static final String DISPLAY = "\u0428\u0430\u0439\u043f\u043e\u0438\u043d\u0442\u0437";
    public static final int VTABLE_RVA = 12818992;
    public static final long RVA_CTOR = 3453104L;
    public static final long RVA_ON_TICK = 3456032L;
    public static final long RVA_ON_RENDER = 3459232L;
    public static final long RVA_IS_VISIBLE = 3452288L;
    public static final long RVA_ON_CHAT = 3457824L;
    public static final long RVA_ON_DISABLE = 3456384L;
    public static final long RVA_EVENT_UPDATE = 3456944L;
    public static final long RVA_BUILD_EVENTS = 3458288L;
    public static final long RVA_DRAW_PLATE = 3459872L;
    public static final long RVA_ADD_WAYPOINT = 3470480L;
    public static final long RVA_PURGE = 3471184L;
    private static final double PLATE_XZ_OFFSET = 0.5;
    private static final double PLATE_Y_OFFSET = 1.0;
    private static final double PLATE_MIN_DISTANCE = 0.001;
    private static final double PLATE_CLAMP_DISTANCE = 32.0;
    private static final double PLATE_SIZE_FACTOR = 0.0025;
    private static final double PLATE_SIZE_MIN = 0.02;
    private static final double PLATE_SIZE_MAX = 0.1;
    private static final double PLATE_SCALE_DIVISOR = 100.0;
    private static final long JOIN_REFRESH_DELAY_MS = 2000L;
    private static final long RETRY_DELAY_MS = 6000L;
    private static final long BUSY_DELAY_MS = 5000L;
    private static final long COLLECT_WINDOW_MS = 1200L;
    private static final long REFRESH_MIN_DELAY_MS = 30000L;
    private static final long REFRESH_MAX_DELAY_MS = 300000L;
    private static final long REFRESH_AFTER_EVENT_MS = 3000L;
    private static final long SECONDS_TO_MS = 1000L;
    private static final int EVENT_MARKER_LENGTH = 14;
    private static final int EVENT_TYPE_TIMED = 1;
    private static final String EVENTS_COMMAND = "events delay";
    private static final String EVENT_MARKER = "[\u0418\u0432\u0435\u043d\u0442\u044b]";
    private static final String NEXT_EVENT_NAME = "\u0421\u043b\u0435\u0434\u0443\u044e\u0449\u0438\u0439 \u0438\u0432\u0435\u043d\u0442";
    private static final String[] EVENT_SKIP_PATTERNS = new String[]{"\u0430\u0438\u0440-\u0434\u0440\u043e\u043f", "\u0430\u0438\u0440\u0434\u0440\u043e\u043f", "air drop", "airdrop", "\u0430\u043b\u0442\u0430\u0440\u044c \u043d\u0435\u0436\u0438\u0442\u0438"};
    private static final List<Waypoint> WAYPOINTS = new ArrayList<Waypoint>();
    private String worldKey = "";
    private Object worldHandle;
    private long refreshAt;
    private long retryAt;
    private long collectUntil;
    private final List<String> pendingLines = new ArrayList<String>();

    public Waypoints() {
        super(MODULE, DISPLAY, Category.Client);
        this.add(Setting.bool("render_in_world", true));
        this.add(Setting.bool("render_in_hud", true));
        this.add(Setting.number("max_distance", 1000.0, 16.0, 50000.0));
        this.add(Setting.number("plate_scale", 50.0, 10.0, 200.0));
        this.add(Setting.bool("toggle_affects_world", true));
        this.add(Setting.bool("toggle_affects_hud", true));
        this.add(Setting.bool("event_waypoints", false));
    }

    public static List<Waypoint> waypoints() {
        return WAYPOINTS;
    }

    @Override
    public boolean isVisible() {
        return this.renderInWorld() && !this.worldKey.isEmpty() && !WAYPOINTS.isEmpty();
    }

    @Override
    public void onTick() {
        this.worldKey = Client.normalizeWorldKey(Client.currentServerAddress());
        this.updateEvents(Client.uptimeMillis());
    }

    @Override
    public void onRender() {
        if (!this.renderInWorld() || this.worldKey.isEmpty()) {
            return;
        }
        double maxDistance = this.maxDistance();
        boolean affectsWorld = this.toggleAffectsWorld();
        double[] view = Client.waypointViewPosition();
        Entity player = Client.player();
        double[] position = Client.entityPosition(player);
        if (position == null) {
            position = new double[3];
        }
        for (int index = 0; index < WAYPOINTS.size(); ++index) {
            double offsetZ;
            double offsetY;
            double offsetX;
            double distance;
            Waypoint waypoint = WAYPOINTS.get(index);
            if (waypoint.world.length() != this.worldKey.length() || !waypoint.world.equals(this.worldKey) || waypoint.hidden || affectsWorld && !waypoint.plateVisible || !((distance = Math.sqrt((offsetX = position[0] - (double)waypoint.x) * offsetX + (offsetY = position[1] - (double)waypoint.y) * offsetY + (offsetZ = position[2] - (double)waypoint.z) * offsetZ)) <= maxDistance)) continue;
            this.drawPlate(view, waypoint, distance);
        }
    }

    @Override
    public void onDisable() {
        this.resetState();
    }

    public void onChat(String message) {
        int marker;
        if (!this.eventWaypoints()) {
            return;
        }
        String stripped = Client.stripColorCodes(message);
        int n = marker = 14 <= stripped.length() ? stripped.indexOf(EVENT_MARKER) : -1;
        if (marker == -1) {
            if (this.collectUntil == 0L) {
                return;
            }
        } else {
            this.pendingLines.clear();
            this.collectUntil = Client.uptimeMillis() + 1200L;
        }
        this.pendingLines.add(message);
    }

    private void drawPlate(double[] view, Waypoint waypoint, double distance) {
        double offsetX = (double)waypoint.x + 0.5 - view[0];
        double offsetY = (double)waypoint.y + 1.0 - view[1];
        double offsetZ = (double)waypoint.z + 0.5 - view[2];
        double length = Math.sqrt(offsetX * offsetX + offsetY * offsetY + offsetZ * offsetZ);
        if (length < 0.001) {
            return;
        }
        double clamp = 1.0;
        if (length > 32.0) {
            clamp = 32.0 / length;
        }
        double positionX = offsetX * clamp + view[0];
        double positionY = offsetY * clamp + view[1];
        double positionZ = offsetZ * clamp + view[2];
        double size = clamp * length * 0.0025;
        if (size < 0.02) {
            size = 0.02;
        } else if (size > 0.1) {
            size = 0.1;
        }
        double scale = this.plateScale() / 100.0;
        Client.drawWaypointPlate(new double[]{positionX, positionY, positionZ}, waypoint.name, (float)scale, (float)size, (float)distance);
    }

    private void updateEvents(long now) {
        Object world;
        if (!this.eventWaypoints()) {
            if (this.refreshAt == 0L && this.retryAt == 0L && this.collectUntil == 0L && this.worldHandle == null) {
                return;
            }
            this.resetState();
            return;
        }
        Entity player = Client.player();
        if (!(player == null || (world = Client.worldOf(player)) == null || this.worldHandle != null && Client.isSameObject(this.worldHandle, world))) {
            this.worldHandle = world;
            Waypoints.purge();
            this.refreshAt = now + 2000L;
            this.retryAt = 0L;
            this.collectUntil = 0L;
            this.pendingLines.clear();
        }
        if (this.collectUntil == 0L || now < this.collectUntil) {
            if (this.refreshAt == 0L || now < this.refreshAt) {
                if (this.retryAt != 0L && this.collectUntil == 0L && this.retryAt <= now) {
                    this.retryAt = 0L;
                }
                return;
            }
            if (!Client.inGame() || this.worldKey.isEmpty()) {
                return;
            }
            if (Client.protectGateOpen(Client.holyWorldOwner()) && Client.holyWorldFlagSet(Client.holyWorldOwner())) {
                this.refreshAt = now + 5000L;
                return;
            }
            this.refreshAt = 0L;
            this.retryAt = now + 6000L;
            this.collectUntil = 0L;
            this.pendingLines.clear();
            Client.sendChatCommand(EVENTS_COMMAND);
            return;
        }
        this.collectUntil = 0L;
        this.retryAt = 0L;
        Client.EventQuery query = Client.parseEventQuery(this.pendingLines);
        this.buildFromEvents(query, now);
        this.pendingLines.clear();
    }

    private void buildFromEvents(Client.EventQuery query, long now) {
        Waypoints.purge();
        if (this.worldKey.isEmpty()) {
            return;
        }
        long earliest = Long.MAX_VALUE;
        for (int index = 0; index < query.events.size(); ++index) {
            long expiry;
            Client.EventEntry event = query.events.get(index);
            if (Waypoints.skipEvent(event.name)) continue;
            if (!event.hasPosition) {
                if (event.type != 1 || event.seconds < 0) continue;
                expiry = (long)event.seconds * 1000L + now;
            } else {
                expiry = event.type == 1 ? (event.seconds < 0 ? 0L : (long)event.seconds * 1000L + now) : 0L;
            }
            int x = event.hasPosition ? event.x : 0;
            int y = event.hasPosition ? event.y : 0;
            int z = event.hasPosition ? event.z : 0;
            this.addWaypoint(event.name, x, y, z, true, !event.hasPosition, expiry);
            if (expiry == 0L || expiry >= earliest) continue;
            earliest = expiry;
        }
        if (query.nextDelaySeconds >= 0) {
            long expiry = (long)query.nextDelaySeconds * 1000L + now;
            this.addWaypoint(NEXT_EVENT_NAME, 0, 0, 0, true, true, expiry);
            if (expiry < earliest) {
                earliest = expiry;
            }
        }
        long next = now + 300000L;
        if (earliest != Long.MAX_VALUE && earliest + 3000L < next) {
            next = earliest + 3000L;
        }
        if (next < now + 30000L) {
            next = now + 30000L;
        }
        this.refreshAt = next;
    }

    private static boolean skipEvent(String name) {
        if (name == null) {
            return true;
        }
        for (int index = 0; index < EVENT_SKIP_PATTERNS.length; ++index) {
            if (!name.contains(EVENT_SKIP_PATTERNS[index])) continue;
            return true;
        }
        return false;
    }

    private Waypoint addWaypoint(String name, int x, int y, int z, boolean plateVisible, boolean noPosition, long expiry) {
        String trimmedName = name == null ? "" : name.trim();
        String trimmedWorld = this.worldKey.trim();
        if (trimmedName.isEmpty() || trimmedWorld.isEmpty()) {
            return null;
        }
        Waypoint waypoint = new Waypoint();
        waypoint.name = trimmedName;
        waypoint.x = x;
        waypoint.y = y;
        waypoint.z = z;
        waypoint.world = trimmedWorld;
        waypoint.plateVisible = plateVisible;
        waypoint.alive = true;
        waypoint.noPosition = noPosition;
        waypoint.expiry = expiry;
        WAYPOINTS.add(waypoint);
        if (!plateVisible) {
            Client.waypointNotify(2);
        }
        return waypoint;
    }

    private static void purge() {
        int write = 0;
        for (int read = 0; read < WAYPOINTS.size(); ++read) {
            Waypoint waypoint = WAYPOINTS.get(read);
            if (!waypoint.alive) continue;
            WAYPOINTS.set(write, waypoint);
            ++write;
        }
        while (WAYPOINTS.size() > write) {
            WAYPOINTS.remove(WAYPOINTS.size() - 1);
        }
    }

    private void resetState() {
        this.refreshAt = 0L;
        this.retryAt = 0L;
        this.collectUntil = 0L;
        this.pendingLines.clear();
        this.worldHandle = null;
        Waypoints.purge();
    }

    private boolean renderInWorld() {
        Setting setting = this.setting("render_in_world");
        return setting == null || setting.getBoolean();
    }

    private double maxDistance() {
        Setting setting = this.setting("max_distance");
        return setting == null ? 1000.0 : setting.getNumber();
    }

    private double plateScale() {
        Setting setting = this.setting("plate_scale");
        return setting == null ? 50.0 : setting.getNumber();
    }

    private boolean toggleAffectsWorld() {
        Setting setting = this.setting("toggle_affects_world");
        return setting == null || setting.getBoolean();
    }

    private boolean eventWaypoints() {
        Setting setting = this.setting("event_waypoints");
        return setting != null && setting.getBoolean();
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }

    public static final class Waypoint {
        public String name = "";
        public int x;
        public int y;
        public int z;
        public String world = "";
        public boolean plateVisible;
        public boolean alive;
        public boolean hidden;
        public boolean noPosition;
        public long expiry;
    }
}

