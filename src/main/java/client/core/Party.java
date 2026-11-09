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

public final class Party
extends Feature {
    public static final String MODULE = "party";
    public static final String DISPLAY = "\u041f\u0430\u0440\u0442\u0439";
    public static final int VTABLE_RVA = 12809512;
    public static final String PARTY_NONE = "PARTY_NONE";
    public static final String NOTIFY_TAG = "\u041f\u0430\u0442\u0438";
    public static final int NOTIFY_STYLE = 34;
    public static final long RVA_TICK = 3408672L;
    public static final long RVA_KEY = 3410016L;
    public static final long RVA_RENDER = 3416496L;
    public static final long RVA_HAS_MARKS = 3416432L;
    public static final long RVA_ON_ENABLE = 3408016L;
    public static final long RVA_ON_DISABLE = 3408144L;
    public static final long RVA_DISBAND = 3429008L;
    public static final long RVA_PLACE_MARK = 3410096L;
    public static final long RVA_SEND_MARK = 3412128L;
    public static final long RVA_REFRESH = 3413248L;
    public static final long RVA_SYNC_MEMBERS = 3414736L;
    public static final long RVA_PRUNE = 3425504L;
    public static final long RVA_EXPIRE = 54583456L;
    public static final long RVA_APPEND_BEAM = 3418528L;
    public static final long RVA_RESOLVE_TRACKED = 3417792L;
    public static final long RVA_PROGRESS = 3418368L;
    public static final long RVA_UPDATE_TRACKED = 54579376L;
    public static final long RVA_DRAW_BEAMS = 3419264L;
    private static final long MARK_DEBOUNCE_NANOS = 250000000L;
    private static final int TICK_PARITY_LIMIT = 1;
    private static final int PARTY_SERVER_THRESHOLD = 2;
    private static final double TIME_SCALE = 1.0E-9;
    private static final double MARK_COORD_X_OFFSET = 0.5;
    private static final double MARK_COORD_Y_OFFSET = 1.0;
    private static final double MARK_COORD_Z_OFFSET = 0.5;
    private static final double POP_DURATION = 0.35;
    private static final double POP_BACK_C3 = 2.70158;
    private static final double POP_BACK_C1 = 1.70158;
    private static final float POP_UNIT = 1.0f;
    private static final double PROGRESS_FADE_START = 0.75;
    private static final double PROGRESS_FADE_SCALE = 4.0;
    private static final double ALPHA_BASE = 0.7;
    private static final double ALPHA_FADE = 0.3;
    private static final double ALPHA_THRESHOLD = 0.01;
    private static final double DISTANCE_SCALE = 0.013;
    private static final double DISTANCE_MIN = 0.28;
    private static final double BEAM_RADIUS_FACTOR = 1.55;
    private static final double WAVE_ARG_SCALE = 2.4;
    private static final double LABEL_LIFT_SCALE = 1.6;
    private static final double WAVE_AMPLITUDE = 0.12;
    private static final double BEAM_VERTICAL_OFFSET = 1.25;
    private static final double LABEL_FONT_SIZE = 2.0;
    private static final int LABEL_WORD_A = -1;
    private static final int LABEL_WORD_B = 1;
    private static final int LABEL_COLOR_HIGH = -16777216;
    private static final int LABEL_TINT = 0x4CFFFFFF;
    private static final int LABEL_MODE = 1;
    private static final float LABEL_SCALE = 20.0f;
    private static final float LABEL_ALPHA = 1.0f;
    private static final float LABEL_ALPHA_ALT = 1.0f;
    private static final double TRACK_NANOS = 1.0E-9;
    private static final double TRACK_MAX_DELTA = 0.3;
    private static final double TRACK_DECAY = 0.1;
    private static final double TRACK_VELOCITY_MAX_SQ = 4096.0;
    private static final double TRACK_POSITION_EPSILON = 16.0;
    private static final double TRACK_MIN_DELTA = 0.0;
    private static final double MEMBER_VELOCITY_SCALE = 10.0;
    private static final double LOOK_PROBE_STEP = 0.01;
    private static final double LOOK_REACH = 160.0;
    private static final double DEG_TO_RAD = 0.01745329252;
    private static final double PI = 3.141592654;
    private static final float MAX_ALPHA = 255.0f;
    private static final float MIN_ALPHA = 0.0f;
    private static final int TTL_DEFAULT = 5;
    private static final double TTL_MIN = 1.0;
    private static final double TTL_MAX = 10.0;
    private static final int SIZE_DEFAULT = 1;
    private static final double SIZE_MIN = 0.5;
    private static final double SIZE_MAX = 3.0;
    private static final int COLOR_DEFAULT = -50384;
    private static final int MARK_KEY_DEFAULT = 0;
    private static final int MARK_KEY_MODS_DEFAULT = 0;
    private static boolean connected;
    private static String partyId;
    private static final List<Member> globalMembers;
    private static final List<Invite> invites;
    private static final List<Mark> marks;
    private static final List<TrackedPlayer> markedPlayers;
    private static int generation;
    private static long sequence;
    private static boolean active;
    private static boolean pullSubmitted;
    private static boolean pullPending;
    private final Setting markKeySetting;
    private final Setting ttlSetting;
    private final Setting colorSetting;
    private final Setting sizeSetting;
    private final boolean[] markKeyState = new boolean[1];
    private int markKeyMods = 0;
    private long lastMarkNanos;
    private Object worldHandle;
    private long lastPartySequence;
    private final List<Member> members = new ArrayList<Member>();
    private int tickParity;
    private String ownName = "";
    private final List<Label> labels = new ArrayList<Label>();
    private final List<Beam> beams = new ArrayList<Beam>();

    public Party() {
        super(MODULE, DISPLAY, Category.Client);
        this.markKeySetting = this.add(Setting.key("mark_key", 0));
        this.ttlSetting = this.add(Setting.number("ttl", 5.0, 1.0, 10.0));
        this.colorSetting = this.add(Setting.color("color", -50384));
        this.sizeSetting = this.add(Setting.number("size", 1.0, 0.5, 3.0));
    }

    @Override
    public boolean isVisible() {
        return !marks.isEmpty();
    }

    @Override
    public void onEnable() {
        boolean alreadySubmitted = pullSubmitted;
        active = true;
        pullSubmitted = true;
        if (alreadySubmitted) {
            pullPending = true;
            return;
        }
        Client.submit(Party::pull);
    }

    @Override
    public void onDisable() {
        if (connected) {
            Client.submit(Party::leave);
        }
        active = false;
        connected = false;
        partyId = "";
        globalMembers.clear();
        invites.clear();
        marks.clear();
        markedPlayers.clear();
        ++generation;
        this.lastPartySequence = sequence;
        this.members.clear();
    }

    @Override
    public void onTick() {
        Object world;
        Entity localPlayer = Client.player();
        if (localPlayer != null && (world = Client.worldOf(localPlayer)) != null) {
            boolean same;
            boolean bl = same = this.worldHandle != null && Client.isSameObject(this.worldHandle, world);
            if (!same) {
                this.worldHandle = world;
                marks.clear();
                markedPlayers.clear();
                this.members.clear();
            }
        }
        if (!marks.isEmpty()) {
            String name;
            Entity handle;
            Entity resolved = Client.player();
            Entity entity = handle = resolved == null ? null : Client.resolvePlayer(resolved);
            this.ownName = handle == null ? "" : ((name = Client.playerName(handle)) == null ? "" : name);
        }
        this.syncMembers();
        if (!this.members.isEmpty()) {
            ++this.tickParity;
            if (this.tickParity > 1) {
                this.tickParity = 0;
                this.refresh();
            }
        }
        if (sequence != this.lastPartySequence) {
            this.lastPartySequence = sequence;
            if (!invites.isEmpty()) {
                Invite invite = invites.get(invites.size() - 1);
                Client.partyNotify(invite.inviter, 34);
            }
        }
    }

    @Override
    public void onKey(int key, boolean pressed) {
        int markKey;
        int n = markKey = this.markKeySetting == null ? 0 : this.markKeySetting.getKey();
        if (markKey == 0) {
            return;
        }
        if (!Client.keybindPressed(markKey, this.markKeyMods, this.markKeyState)) {
            return;
        }
        if (!Client.inGame()) {
            return;
        }
        if (Client.screenOpen()) {
            return;
        }
        this.placeMark();
    }

    @Override
    public void onRender() {
        long now = Client.nanos();
        Party.expireState(now);
        int fallbackColor = this.markColor();
        this.labels.clear();
        this.beams.clear();
        for (int i = 0; i < marks.size(); ++i) {
            double[] position;
            int resolvedColor;
            Mark mark = marks.get(i);
            int n = resolvedColor = mark.color != 0 ? mark.color : fallbackColor;
            if (mark.name.isEmpty()) {
                position = new double[]{(double)mark.x + 0.5, (double)mark.y + 1.0, (double)mark.z + 0.5};
                this.appendBeam(mark, now, position, mark.label, resolvedColor);
                continue;
            }
            if (this.hasNewerDuplicate(i) || mark.name.equals(this.ownName) || !this.resolveTracked(mark.name, now, fallbackColor, position = new double[3])) continue;
            this.appendBeam(mark, now, position, mark.name, resolvedColor);
            float progress = Party.markProgress(mark, now);
            float alpha = progress * (float)(resolvedColor >>> 24);
            float clamped = alpha < 0.0f ? 0.0f : Math.min(alpha, 255.0f);
            int faded = resolvedColor & 0xFFFFFF | (int)clamped << 24;
            if (((int)clamped & 0xFF) == 0) continue;
            Label label = new Label();
            label.fontSize = 2.0;
            label.wordA = -1;
            label.wordB = 1;
            label.colorLow = faded >>> 8 << 8;
            label.colorMid = -16777216;
            label.flag = 0;
            label.tint = 0x4CFFFFFF;
            label.mode = faded & 0xFFFFFF00 | 1;
            label.scale = 20.0f;
            label.alpha = 1.0f;
            label.alphaAlt = 1.0f;
            this.labels.add(label);
        }
        if (!this.labels.isEmpty()) {
            Label trailing = new Label();
            trailing.fontSize = 2.0;
            trailing.wordA = -1;
            trailing.wordB = 1;
            trailing.colorLow = fallbackColor >>> 8 << 8;
            trailing.colorMid = -16777216;
            trailing.flag = 0;
            trailing.tint = 0x4CFFFFFF;
            trailing.mode = fallbackColor & 0xFFFFFF00 | 1;
            trailing.scale = 20.0f;
            trailing.alpha = 1.0f;
            trailing.alphaAlt = 1.0f;
            this.labels.add(trailing);
        }
        this.renderBeams();
    }

    private void placeMark() {
        int markZ;
        int markY;
        int markX;
        String targetName;
        double pz;
        double py;
        double px;
        long now = Client.nanos();
        if (now - this.lastMarkNanos < 250000000L) {
            return;
        }
        this.lastMarkNanos = now;
        if (!connected) {
            Client.partyNotify(PARTY_NONE, 34);
            return;
        }
        Entity self = Client.player();
        if (self == null) {
            return;
        }
        Entity handle = Client.resolvePlayer(self);
        if (handle == null) {
            return;
        }
        double[] position = Client.entityInterpolatedPosition(handle);
        if (position == null) {
            px = 0.0;
            py = 0.0;
            pz = 0.0;
        } else {
            px = position[0];
            py = position[1];
            pz = position[2];
        }
        float yaw = Client.entityHeadYaw(handle);
        float pitch = Client.entityHeadPitch(handle);
        double cosPitch = -Math.cos(-((double)pitch) * 0.01745329252);
        double dirX = Math.sin(-((double)yaw) * 0.01745329252 - 3.141592654) * cosPitch;
        double dirY = Math.sin(-((double)pitch) * 0.01745329252);
        double dirZ = Math.cos(-((double)yaw) * 0.01745329252 - 3.141592654) * cosPitch;
        double[] lookOrigin = new double[]{dirX * 160.0 + px, dirY * 160.0 + py, dirZ * 160.0 + pz};
        double[] hit = Client.partyLookRaycast(handle);
        Object[] target = Client.partyPickLookTarget(lookOrigin, new double[]{dirX, dirY, dirZ});
        String string = targetName = target == null ? null : (String)target[0];
        if (targetName == null || targetName.isEmpty()) {
            if (hit == null) {
                return;
            }
            markX = (int)Math.floor(hit[0] - hit[3] * 0.01);
            markY = (int)Math.floor(hit[1] - hit[4] * 0.01);
            markZ = (int)Math.floor(hit[2] - hit[5] * 0.01);
            targetName = "";
        } else {
            markX = (int)Math.floor((Double)target[1]);
            markY = (int)Math.floor((Double)target[2]);
            markZ = (int)Math.floor((Double)target[3]);
        }
        this.sendMark(markX, markY, markZ, targetName);
    }

    private void sendMark(int x, int y, int z, String name) {
        Object world = Client.localWorldRef();
        if (Client.partyServerCount() < 2) {
            String dimension = Client.currentDimensionKey();
            String address = Client.currentServerAddress();
            Client.partySendMark(x, y, z, name, world, dimension, address, this.markColor(), 34);
        } else {
            Client.partySendMarkSimple(x, y, z);
        }
    }

    private void refresh() {
        long now = Client.nanos();
        int serverCount = Client.partyServerCount();
        String address = "";
        String dimension = "";
        Object world = null;
        if (serverCount > 2) {
            address = Client.currentServerAddress();
            dimension = Client.currentDimensionKey();
            world = Client.localWorldRef();
        }
        for (Member member : this.members) {
            double[] position;
            Entity entity = member.entity;
            if (entity == null || Client.isRemoved(entity) || (position = Client.entityPosition(entity)) == null) continue;
            double vx = 0.0;
            double vy = 0.0;
            double vz = 0.0;
            if (member.hadPosition) {
                vx = (position[0] - member.x) * 10.0;
                vy = (position[1] - member.y) * 10.0;
                vz = (position[2] - member.z) * 10.0;
            }
            member.x = position[0];
            member.y = position[1];
            member.z = position[2];
            member.hadPosition = true;
            float yaw = Client.entityBodyYaw(entity);
            member.yaw = yaw;
            TrackedPlayer tracked = Party.findTracked(member.name);
            if (tracked != null) {
                Party.updateTracked(tracked, position, new double[]{vx, vy, vz}, now);
                if (member.world > 0.0) {
                    tracked.world = member.world;
                }
                if (yaw > 0.0f) {
                    tracked.yaw = yaw;
                }
                tracked.alive = true;
            }
            if (serverCount <= 2) continue;
            Client.partyPushStatus(dimension, address, world, member.name, position[0], position[1], position[2], yaw, member.world);
        }
    }

    private void pruneMembers() {
        int index;
        for (index = 0; index < this.members.size(); ++index) {
            Member member = this.members.get(index);
            if (member.name.isEmpty() || !Party.hasMarkFor(member.name) || member.entity == null || !Client.isRemoved(member.entity)) break;
        }
        int write = index;
        for (int read = index + 1; read < this.members.size(); ++read) {
            Member member = this.members.get(read);
            if (member.name.isEmpty() || !Party.hasMarkFor(member.name) || member.entity != null && Client.isRemoved(member.entity)) continue;
            this.members.set(write, member);
            ++write;
        }
        while (this.members.size() > write) {
            this.members.remove(this.members.size() - 1);
        }
    }

    private void syncMembers() {
        this.pruneMembers();
        for (Mark mark : marks) {
            if (mark.name.isEmpty() || this.hasMember(mark.name)) continue;
            Client.partyTrackMarkedPlayers(mark.name);
            return;
        }
    }

    private void appendBeam(Mark mark, long now, double[] position, String label, int color) {
        double dz;
        double dy;
        float fade;
        double age = (double)(now - mark.start) * 1.0E-9;
        double progress = age / 0.35;
        double clamped = progress < 0.0 ? 0.0 : Math.min(progress, 1.0);
        double t = clamped - 1.0;
        double pop = (t * 2.70158 * t * t + 1.0 + t * 1.70158 * t) * ((double)(fade = Party.markProgress(mark, now)) * 0.3 + 0.7);
        if (pop <= 0.01) {
            return;
        }
        double[] view = Client.partyViewPosition();
        double dx = position[0] - view[0];
        double distance = Math.sqrt(dx * dx + (dy = position[1] - view[1]) * dy + (dz = position[2] - view[2]) * dz);
        double distanceFactor = distance * 0.013;
        if (distanceFactor <= 0.28) {
            distanceFactor = 0.28;
        }
        double strength = distanceFactor * this.num("size") * pop;
        double size = strength * 1.55;
        double sway = Math.sin(age * 2.4);
        double lift = age * 1.6;
        Beam beam = new Beam();
        beam.x = position[0];
        beam.y = sway * size * 0.12 + size * 1.25 + position[1];
        beam.z = position[2];
        beam.strength = strength;
        beam.size = size;
        beam.lift = lift;
        beam.fade = fade;
        beam.label = label;
        beam.color = color;
        this.beams.add(beam);
    }

    private void renderBeams() {
        if (this.beams.isEmpty()) {
            return;
        }
        Client.partyDrawBeamBatch(this.beams, this.labels, this.markColor());
    }

    private boolean resolveTracked(String name, long now, int color, double[] out) {
        TrackedPlayer tracked;
        for (Member member : this.members) {
            double[] eye;
            if (!member.name.equals(name)) continue;
            if (member.entity == null || Client.isRemoved(member.entity) || (eye = Client.eyePosition()) == null) break;
            out[0] = eye[0];
            out[1] = eye[1];
            out[2] = eye[2];
            return true;
        }
        if ((tracked = Party.findTracked(name)) == null) {
            return false;
        }
        double delta = (double)(now - (long)tracked.tick) * 1.0E-9;
        if (delta < 0.0) {
            delta = 0.0;
        }
        double lerp = delta > 0.3 ? 0.3 : delta;
        double decay = Math.exp(delta / 0.1);
        out[0] = lerp * tracked.vx + tracked.lastX + decay * tracked.ox;
        out[1] = lerp * tracked.vy + tracked.lastY + decay * tracked.oy;
        out[2] = lerp * tracked.vz + tracked.lastZ + decay * tracked.oz;
        return true;
    }

    private static void updateTracked(TrackedPlayer tracked, double[] position, double[] motion, long now) {
        double mvz;
        double mvy;
        double mvx;
        double predZ;
        double predY;
        double predX;
        if (!tracked.init) {
            predX = position[0];
            predY = position[1];
            predZ = position[2];
        } else {
            double delta = (double)(now - (long)tracked.tick) * 1.0E-9;
            if (delta < 0.0) {
                delta = 0.0;
            }
            double lerp = delta > 0.3 ? 0.3 : delta;
            double decay = Math.exp(delta / 0.1);
            predX = lerp * tracked.vx + tracked.lastX + decay * tracked.ox;
            predY = lerp * tracked.vy + tracked.lastY + decay * tracked.oy;
            predZ = lerp * tracked.vz + tracked.lastZ + decay * tracked.oz;
        }
        double errX = predX - position[0];
        double errY = predY - position[1];
        double errZ = predZ - position[2];
        if (errX * errX + errY * errY + errZ * errZ > 16.0) {
            errX = 0.0;
            errY = 0.0;
            errZ = 0.0;
        }
        tracked.ox = errX;
        tracked.oy = errY;
        tracked.oz = errZ;
        tracked.lastX = position[0];
        tracked.lastY = position[1];
        tracked.lastZ = position[2];
        if (motion == null || motion[0] * motion[0] + motion[1] * motion[1] + motion[2] * motion[2] > 4096.0) {
            mvx = 0.0;
            mvy = 0.0;
            mvz = 0.0;
        } else {
            mvx = motion[0];
            mvy = motion[1];
            mvz = motion[2];
        }
        tracked.tick = now;
        tracked.vx = mvx;
        tracked.vy = mvy;
        tracked.vz = mvz;
        tracked.init = true;
    }

    private static float markProgress(Mark mark, long now) {
        double duration = mark.end - mark.start;
        double progress = 1.0;
        if (duration > 0.0) {
            double raw = (double)(now - mark.start) / duration;
            double clamped = raw < 0.0 ? 0.0 : (raw > 1.0 ? 1.0 : raw);
            progress = clamped;
            if (clamped <= 0.75) {
                return 1.0f;
            }
        }
        return (float)((1.0 - progress) * 4.0);
    }

    private static void expireState(long now) {
        int write = 0;
        for (int read = 0; read < marks.size(); ++read) {
            Mark mark = marks.get(read);
            if (mark.end <= now) continue;
            marks.set(write, mark);
            ++write;
        }
        while (marks.size() > write) {
            marks.remove(marks.size() - 1);
        }
        int trackedWrite = 0;
        for (int read = 0; read < markedPlayers.size(); ++read) {
            TrackedPlayer tracked = markedPlayers.get(read);
            if (tracked.name.isEmpty() || !Party.hasMarkFor(tracked.name)) continue;
            markedPlayers.set(trackedWrite, tracked);
            ++trackedWrite;
        }
        while (markedPlayers.size() > trackedWrite) {
            markedPlayers.remove(markedPlayers.size() - 1);
        }
    }

    private boolean hasNewerDuplicate(int index) {
        Mark mark = marks.get(index);
        for (int i = 0; i < marks.size(); ++i) {
            if (i == index) continue;
            Mark other = marks.get(i);
            if (!other.name.equals(mark.name) || mark.end >= other.end && (other.end != mark.end || index >= i)) continue;
            return true;
        }
        return false;
    }

    private static boolean hasMarkFor(String name) {
        for (Mark mark : marks) {
            if (!mark.name.equals(name)) continue;
            return true;
        }
        return false;
    }

    private boolean hasMember(String name) {
        for (Member member : this.members) {
            if (!member.name.equals(name)) continue;
            return true;
        }
        return false;
    }

    private static TrackedPlayer findTracked(String name) {
        for (TrackedPlayer tracked : markedPlayers) {
            if (!tracked.name.equals(name)) continue;
            return tracked;
        }
        return null;
    }

    private int markColor() {
        return this.colorSetting == null ? -50384 : this.colorSetting.getColor();
    }

    private double num(String name) {
        Setting setting = this.setting(name);
        return setting == null ? 0.0 : setting.getNumber();
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }

    private static void pull() {
        connected = true;
    }

    private static void leave() {
        connected = false;
    }

    public static String partyId() {
        return partyId;
    }

    public static boolean isConnected() {
        return connected;
    }

    public static boolean isActive() {
        return active;
    }

    public static boolean isPullPending() {
        return pullPending;
    }

    public static int generation() {
        return generation;
    }

    public static long sequence() {
        return sequence;
    }

    public static int markCount() {
        return marks.size();
    }

    public static void setPartyState(String id, boolean value) {
        partyId = id == null ? "" : id;
        connected = value;
    }

    public static void requestPull() {
        pullPending = true;
    }

    public static void addMark(int x, int y, int z, String label, String tag, String name, int color, long start, long end) {
        Mark mark = new Mark();
        mark.x = x;
        mark.y = y;
        mark.z = z;
        mark.label = label == null ? "" : label;
        mark.tag = tag == null ? "" : tag;
        mark.name = name == null ? "" : name;
        mark.color = color;
        mark.start = start;
        mark.end = end;
        marks.add(mark);
        ++sequence;
    }

    public static void addInvite(String from, String inviter) {
        Invite invite = new Invite();
        invite.from = from == null ? "" : from;
        invite.inviter = inviter == null ? "" : inviter;
        invites.add(invite);
        ++sequence;
    }

    static {
        partyId = "";
        globalMembers = new ArrayList<Member>();
        invites = new ArrayList<Invite>();
        marks = new ArrayList<Mark>();
        markedPlayers = new ArrayList<TrackedPlayer>();
    }

    public static final class Invite {
        public String from = "";
        public String inviter = "";
    }

    public static final class Mark {
        public int x;
        public int y;
        public int z;
        public String label = "";
        public String tag = "";
        public long start;
        public long end;
        public String name = "";
        public int color;
    }

    public static final class Label {
        public double fontSize;
        public int wordA;
        public int wordB;
        public int colorLow;
        public int colorMid;
        public int flag;
        public int tint;
        public int mode;
        public float scale;
        public float alpha;
        public float alphaAlt;
    }

    public static final class Member {
        public String name = "";
        public String tag = "";
        public Entity entity;
        public double world;
        public double x;
        public double y;
        public double z;
        public double yaw;
        public boolean hadPosition;
    }

    public static final class TrackedPlayer {
        public String name = "";
        public double lastX;
        public double lastY;
        public double lastZ;
        public double vx;
        public double vy;
        public double vz;
        public double ox;
        public double oy;
        public double oz;
        public double tick;
        public boolean init;
        public double world;
        public double yaw;
        public boolean alive;
    }

    public static final class Beam {
        public double x;
        public double y;
        public double z;
        public double strength;
        public double size;
        public double lift;
        public float fade;
        public String label = "";
        public int color;
    }
}

