/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;

public final class Ambience
extends Feature {
    public static final String MODULE = "ambience";
    public static final String DISPLAY = "\u0410\u043c\u0431\u0438\u0435\u043d\u0441\u0435";
    public static final int VTABLE_RVA = 12566360;
    public static final long RVA_ON_ENABLE = 2735200640960L;
    public static final long RVA_ON_DISABLE = 2735200640976L;
    public static final long RVA_FOG_TIME = 2735200649200L;
    public static final long RVA_FOG_PARTICLES = 2735200650016L;
    public static final long RVA_LAMBDA_VISIBILITY = 2735200652272L;
    private static final double NANOS_PER_SECOND = 1.0E9;
    private static final float TIME_STEP_DIVISOR = 0.35f;
    private static final float TIME_MIN = 0.0f;
    private static final float TIME_MAX = 1.0f;
    private static final float FOG_MIN_VISIBLE = 0.002f;
    private static final float FOG_MIN_PARTICLES = 0.004f;
    private static final float PARTICLE_SPREAD = 14.0f;
    private static final float PARTICLE_MAX_COUNT = 4000.0f;
    private static final float PARTICLE_SCALE_DIVISOR = 100.0f;
    private static final double PARTICLE_HALF_HEIGHT = 0.012;
    private static final double PARTICLE_RISE_SPAN = 20.0;
    private static final float PARTICLE_RISE_TOP = 10.0f;
    private static final float PARTICLE_CURL = 0.6f;
    private static final float PARTICLE_CURL_BIAS = 0.7f;
    private static final float PARTICLE_WRAP = 0.85f;
    private static final double PARTICLE_CAM_RADIUS = 100.0;
    private static final float PARTICLE_HEIGHT_MASK = 0.5f;
    private static final float PARTICLE_HEIGHT_BIAS = 0.55f;
    private static final float PARTICLE_SHADE = 0.5f;
    private static final float PARTICLE_TINT_SCALE = 255.0f;
    private static final int PARTICLE_RGB = 14075058;
    private static final long PARTICLE_SEED_MOD = 100000000000L;
    private static final double NANO_SCALE = 1.0E-9;
    private static final int HASH_STEP_0 = -668265263;
    private static final int HASH_STEP_1 = 668265263;
    private static final int HASH_STEP_2 = 1336530526;
    private static final int HASH_STEP_3 = 2004795789;
    private static final int HASH_MUL = 1274126177;
    private static final int HASH_ADD = 374761393;
    private static final int HASH_SEED = 1336530526;
    private static final float HASH_MASK = 1.6777215E7f;
    private static Ambience active;
    private long lastFrameNanos;
    private float fogTime;

    public Ambience() {
        super(MODULE, DISPLAY, Category.Render);
        this.add(Setting.bool("time_group", false));
        this.add(Setting.number("world_group", 0.0, 0.0, 1.0));
        this.add(Setting.bool("fog_layer_group", false));
        this.add(Setting.mode("fog_color_mode", "Layer", "Layer", "Custom"));
        this.add(Setting.bool("wet_group", false));
        this.add(Setting.mode("wet_quality", "Medium", "Low", "Medium", "High"));
        this.add(Setting.bool("rain_group", false));
    }

    public static Ambience active() {
        return active;
    }

    @Override
    public void onEnable() {
        active = this;
    }

    @Override
    public void onDisable() {
        active = null;
    }

    @Override
    public void onRender() {
        this.updateFogTime();
        this.spawnFogParticles();
    }

    public float fogTime() {
        return this.fogTime;
    }

    public void updateFogTime() {
        float value;
        Object list;
        int z;
        int y;
        double[] position;
        int x;
        Object world;
        long now = Client.nanos();
        float step = 1.0f;
        if (this.lastFrameNanos != 0L) {
            step = (float)((double)(now - this.lastFrameNanos) / 1.0E9) / 0.35f;
        }
        this.lastFrameNanos = now;
        if (!Client.flag16e8(this) || !Client.inGame()) {
            this.fogTime = 0.0f;
            return;
        }
        boolean negate = true;
        if (Client.player() != null && (world = Client.worldOf(Client.player())) != null && Client.blockStateAt(x = (int)Math.floor((position = Client.entityPosition(Client.player()))[0]), y = (int)Math.floor(position[1]), z = (int)Math.floor(position[2])) != null && (list = Client.ambienceTimeBlockList()) != null && Client.trackedBlockPresent(world, x, y, z, 0)) {
            negate = false;
        }
        if (negate) {
            step = -step;
        }
        this.fogTime = (value = step + this.fogTime) < 0.0f ? 0.0f : (value > 1.0f ? 1.0f : value);
    }

    public void spawnFogParticles() {
        if (!Client.flag16e8(this)) {
            return;
        }
        if (!(0.002f < this.fogTime)) {
            return;
        }
        float span = (float)(Client.settingDouble(this, 6416) / 100.0) * this.fogTime;
        if (!(0.004f < span)) {
            return;
        }
        int count = (int)((float)Client.settingDouble(this, 6104) * 4000.0f / 100.0f + 0.5f);
        if (count < 0) {
            count = 0;
        }
        if (count > 4000) {
            count = 4000;
        }
        int tint = Math.round(span * 255.0f);
        int color = tint << 24 | 0xD6C4B2;
        float timeSeed = (float)((double)(Client.nanos() % 100000000000L) * 1.0E-9);
        double[] camera = Client.ambienceCameraPosition();
        double baseX = Math.floor(camera[0]);
        double baseY = Math.floor(camera[1]);
        double baseZ = Math.floor(camera[2]);
        int seed = 1336530526;
        for (int i = 0; i < count; ++i) {
            int h12 = Ambience.hash(seed + -668265263);
            int h15 = Ambience.hash(seed) ^ seed;
            int h16 = Ambience.hash(seed + 668265263);
            int h17 = Ambience.hash(seed + 1336530526);
            float rx = (float)((h12 >>> 16 ^ h12) & 0xFFFFFF) / 1.6777215E7f - 0.5f;
            double x = (double)((rx + rx) * 14.0f) + baseX;
            float rz = (float)(((h15 *= 1274126177) >>> 16 ^ h15) & 0xFFFFFF) / 1.6777215E7f - 0.5f;
            double z = (double)((rz + rz) * 14.0f) + baseZ;
            float curl = (float)Math.IEEEremainder(((float)((h16 >>> 16 ^ h16) & 0xFFFFFF) / 1.6777215E7f * 0.6f + 0.7f) * timeSeed * 0.85f + (float)((h17 >>> 16 ^ h17) & 0xFFFFFF) / 1.6777215E7f, 1.0);
            int h18 = Ambience.hash(seed + 2004795789);
            int h18High = h18 >>> 16;
            double y = 10.0 - (double)curl * 20.0 + baseY;
            double yBottom = y - (double)((float)((h18 ^ h18High) & 0xFFFFFF) / 1.6777215E7f * 0.5f + 0.55f);
            if (Client.renderPassActive()) {
                float top = (float)(y - camera[1]);
                float bottom = (float)(yBottom - camera[1]);
                float zPlus = (float)(z + 0.012 - camera[2]);
                float zMinus = (float)(z - 0.012 - camera[2]);
                float xOffset = (float)(x - camera[0]);
                float[] vertices = new float[]{xOffset, top, zPlus, Float.intBitsToFloat(color), xOffset, bottom, zPlus, Float.intBitsToFloat(color), xOffset, bottom, zMinus, Float.intBitsToFloat(color), xOffset, top, zMinus, Float.intBitsToFloat(color), xOffset, bottom, zMinus, Float.intBitsToFloat(color), xOffset, top, zMinus, Float.intBitsToFloat(color)};
                Client.drawWorldQuad(h18High, Client.ambienceParticleBatch(), vertices, 6);
                if (Client.renderPassActive()) {
                    float mirrorNear = (float)(x - 0.012 - camera[0]);
                    float mirrorFar = (float)(x + 0.012 - camera[0]);
                    vertices[0] = mirrorNear;
                    vertices[1] = top;
                    vertices[2] = (float)(z - camera[2]);
                    vertices[4] = mirrorNear;
                    vertices[5] = bottom;
                    vertices[6] = (float)(z - camera[2]);
                    vertices[8] = mirrorNear;
                    vertices[9] = bottom;
                    vertices[10] = (float)(z - camera[2]);
                    vertices[12] = mirrorNear;
                    vertices[13] = top;
                    vertices[14] = (float)(z - camera[2]);
                    vertices[16] = mirrorFar;
                    vertices[17] = bottom;
                    vertices[18] = (float)(z - camera[2]);
                    vertices[20] = mirrorFar;
                    vertices[21] = top;
                    vertices[22] = (float)(z - camera[2]);
                    Client.drawWorldQuad(Float.floatToRawIntBits(vertices[8]), Client.ambienceParticleBatch(), vertices, 6);
                }
            }
            seed += 374761393;
        }
    }

    private static int hash(int value) {
        return (value >>> 13 ^ value) * 1274126177;
    }
}

