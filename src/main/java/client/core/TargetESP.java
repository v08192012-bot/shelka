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

public final class TargetESP
extends Feature {
    public static final String MODULE = "target_esp";
    public static final String DISPLAY = "\u0422\u0430\u0440\u0433\u0435\u0442\u0415\u0417\u041f";
    public static final int VTABLE_RVA = 12580800;
    public static final long RVA_ON_TICK = 2735200735248L;
    public static final long RVA_ON_RENDER = 2735200737376L;
    public static final long RVA_ON_HIT = 2735200735024L;
    public static final long RVA_ON_ENABLE = 2735200734528L;
    public static final long RVA_ON_DISABLE = 2735200734624L;
    public static final long RVA_EFFECT_INDEX = 2735200734832L;
    public static final long RVA_EFFECT_NAME = 2735200757552L;
    public static final long RVA_MARKER_ENERGY = 2735200734160L;
    public static final long RVA_MARKER_UPDATE = 2735200738400L;
    public static final long RVA_MARKER_LAYOUT = 2735200757680L;
    public static final long RVA_MARKER_GEOMETRY = 2735200757968L;
    public static final long RVA_LAMBDA_VISIBILITY = 2735200739536L;
    public static final long RVA_LAMBDA_CLONE = 2735200739568L;
    public static final long RVA_TINT = 2735199738240L;
    public static final long RVA_COLOR_TABLE = 2735199737968L;
    public static final long RVA_BATCH_DRAW = 2735203042800L;
    private static final String EFFECT_KEY = "effect";
    private static final String SHAPE_KEY = "shape";
    private static final String LOOK_KEY = "look";
    private static final String DISTORTION_KEY = "distortion";
    private static final String TIMING_KEY = "timing";
    private static final String OCCLUDE_KEY = "occlude";
    private static final String RADIUS_KEY = "radius";
    private static final String POINT_SIZE_KEY = "point_size";
    private static final String DENSITY_KEY = "density";
    private static final String TRAIL_KEY = "trail";
    private static final String COLOR_KEY = "color";
    private static final String GLOW_KEY = "glow";
    private static final String SPEED_KEY = "speed";
    private static final String HOLD_KEY = "hold";
    private static final String EFFECT_DEFAULT = "triangle";
    private static final String[] EFFECTS = new String[]{"ring", "triangle", "lightning", "helix", "orbit", "embers", "runes", "pulse"};
    private static final int EFFECT_COUNT = 8;
    private static final int EFFECT_FALLBACK = 0;
    private static final int DISTORTION_EFFECT_LIMIT = 2;
    private static final int DEFAULT_COLOR = -1096636;
    private static final int BATCH_MODE = 8;
    private static final int COLOR_TABLE_VALUE = 8;
    private static final double RADIUS_DEFAULT = 0.7;
    private static final double RADIUS_MIN = 0.4;
    private static final double RADIUS_MAX = 1.6;
    private static final double RADIUS_STEP = 0.05;
    private static final double POINT_SIZE_DEFAULT = 0.17;
    private static final double POINT_SIZE_MIN = 0.04;
    private static final double POINT_SIZE_MAX = 0.4;
    private static final double POINT_SIZE_STEP = 0.01;
    private static final double DENSITY_DEFAULT = 220.0;
    private static final double DENSITY_MIN = 30.0;
    private static final double DENSITY_MAX = 220.0;
    private static final double DENSITY_STEP = 2.0;
    private static final double TRAIL_DEFAULT = 6.0;
    private static final double TRAIL_MIN = 0.0;
    private static final double TRAIL_MAX = 12.0;
    private static final double TRAIL_STEP = 1.0;
    private static final double GLOW_DEFAULT = 0.4;
    private static final double GLOW_MIN = 0.2;
    private static final double GLOW_MAX = 3.0;
    private static final double GLOW_STEP = 0.05;
    private static final double DISTORTION_DEFAULT = 0.0;
    private static final double DISTORTION_MIN = 0.0;
    private static final double DISTORTION_MAX = 100.0;
    private static final double DISTORTION_STEP = 5.0;
    private static final double SPEED_DEFAULT = 0.7;
    private static final double SPEED_MIN = 0.1;
    private static final double SPEED_MAX = 2.0;
    private static final double SPEED_STEP = 0.1;
    private static final double HOLD_DEFAULT = 2.3;
    private static final double HOLD_MIN = 0.3;
    private static final double HOLD_MAX = 10.0;
    private static final double HOLD_STEP = 0.1;
    private static final double NANOS_PER_MS = 1000000.0;
    private static final double MS_PER_SECOND = 1000.0;
    private static final double FRAME_NANOS = 5.0E7;
    private static final double DISTORTION_PERCENT = 100.0;
    private static final float INTERPOLATION_TICKS = 1.0f;
    private static final float FADE_EPSILON = 0.001f;
    private static final float FADE_IN_STEP = 0.15f;
    private static final float FADE_OUT_STEP = 0.3f;
    private static final float FADE_MIN_VISIBLE = 0.03f;
    private static final float FADE_FULL = 1.0f;
    private static final float DISTORTION_SCALE = 0.1f;
    private static final float ENERGY_RAMP = 3.0f;
    private static final float STRIP_THRESHOLD = 0.25f;
    private static TargetESP instance;
    private final List<float[]> vertices = new ArrayList<float[]>();
    private Entity currentTarget;
    private Entity previousTarget;
    private float currentFade;
    private float previousFade;
    private float currentFadePrev;
    private float previousFadePrev;
    private float currentTime;
    private float previousTime;
    private float currentTimePrev;
    private float previousTimePrev;
    private long lastHitNanos;
    private long lastFrameNanos;
    private boolean hitActive;
    private boolean fading;
    private boolean currentLineOfSight;
    private boolean previousLineOfSight;
    private boolean markerActive;

    public TargetESP() {
        super(MODULE, DISPLAY, Category.Render);
        this.add(Setting.mode(EFFECT_KEY, EFFECT_DEFAULT, EFFECTS));
        this.add(Setting.bool(SHAPE_KEY, true));
        this.add(Setting.number(RADIUS_KEY, 0.7, 0.4, 1.6, 0.05));
        this.add(Setting.number(POINT_SIZE_KEY, 0.17, 0.04, 0.4, 0.01));
        this.add(Setting.number(DENSITY_KEY, 220.0, 30.0, 220.0, 2.0));
        this.add(Setting.number(TRAIL_KEY, 6.0, 0.0, 12.0, 1.0));
        this.add(Setting.bool(LOOK_KEY, true));
        this.add(Setting.color(COLOR_KEY, -1096636));
        this.add(Setting.number(GLOW_KEY, 0.4, 0.2, 3.0, 0.05));
        this.add(Setting.number(DISTORTION_KEY, 0.0, 0.0, 100.0, 5.0));
        this.add(Setting.bool(TIMING_KEY, true));
        this.add(Setting.number(SPEED_KEY, 0.7, 0.1, 2.0, 0.1));
        this.add(Setting.number(HOLD_KEY, 2.3, 0.3, 10.0, 0.1));
        this.add(Setting.bool(OCCLUDE_KEY, true));
    }

    public static TargetESP instance() {
        return instance;
    }

    public List<float[]> vertices() {
        return this.vertices;
    }

    public Entity currentTarget() {
        return this.currentTarget;
    }

    public Entity previousTarget() {
        return this.previousTarget;
    }

    public boolean markerActive() {
        return this.markerActive;
    }

    public boolean fadingIn() {
        return this.fading;
    }

    public boolean distortionVisible() {
        return this.effectIndex() <= 2;
    }

    @Override
    public void onEnable() {
        instance = this;
        this.currentFadePrev = 0.0f;
        this.previousFadePrev = 0.0f;
        this.currentFade = 0.0f;
        this.previousFade = 0.0f;
        this.currentTimePrev = 0.0f;
        this.previousTimePrev = 0.0f;
        this.currentTime = 0.0f;
        this.previousTime = 0.0f;
        this.lastHitNanos = 0L;
        this.hitActive = false;
        this.fading = false;
        this.currentLineOfSight = false;
        this.previousLineOfSight = false;
        this.lastFrameNanos = Client.nanos();
        this.applyVisibility();
    }

    @Override
    public void onDisable() {
        instance = null;
        this.currentTarget = null;
        this.previousTarget = null;
        this.currentFadePrev = 0.0f;
        this.previousFadePrev = 0.0f;
        this.currentFade = 0.0f;
        this.previousFade = 0.0f;
        this.currentTimePrev = 0.0f;
        this.previousTimePrev = 0.0f;
        this.currentTime = 0.0f;
        this.previousTime = 0.0f;
        this.lastHitNanos = 0L;
        this.hitActive = false;
        this.fading = false;
        this.currentLineOfSight = false;
        this.previousLineOfSight = false;
    }

    @Override
    protected void onSettingsVisibilityChanged(boolean visible) {
        this.applyVisibility();
    }

    @Override
    public void onTick() {
        float delta;
        if (!Client.inGame()) {
            this.currentTarget = null;
            this.previousTarget = null;
            this.currentFadePrev = 0.0f;
            this.previousFadePrev = 0.0f;
            this.currentFade = 0.0f;
            this.previousFade = 0.0f;
            this.currentTimePrev = 0.0f;
            this.previousTimePrev = 0.0f;
            this.currentTime = 0.0f;
            this.previousTime = 0.0f;
            this.lastHitNanos = 0L;
            this.hitActive = false;
            this.fading = false;
            this.currentLineOfSight = false;
            this.previousLineOfSight = false;
            return;
        }
        long now = Client.nanos();
        this.currentFadePrev = this.currentFade;
        this.previousFadePrev = this.previousFade;
        this.currentTimePrev = this.currentTime;
        this.previousTimePrev = this.previousTime;
        this.lastFrameNanos = now;
        Entity self = Client.resolvePlayer(Client.player());
        boolean invalid = false;
        if (this.currentTarget != null) {
            boolean removed = Client.isRemoved(this.currentTarget);
            boolean alive = Client.isAlive(this.currentTarget);
            if (removed || !alive) {
                invalid = true;
                this.hitActive = false;
            }
        }
        this.currentLineOfSight = false;
        if (this.currentTarget != null) {
            double[] targetPosition = Client.lerpedPosition(this.currentTarget, 1.0f);
            double[] selfPosition = Client.lerpedPosition(self, 1.0f);
            this.currentLineOfSight = !Client.lineOfSightBlocked(self, selfPosition, targetPosition);
        }
        this.previousLineOfSight = false;
        if (this.previousTarget != null) {
            double[] previousPosition = Client.lerpedPosition(this.previousTarget, 1.0f);
            double[] selfPosition = Client.lerpedPosition(self, 1.0f);
            this.previousLineOfSight = !Client.lineOfSightBlocked(self, selfPosition, previousPosition);
        }
        long check = Client.nanos();
        if (!this.hitActive || invalid || this.holdSeconds() * 1000.0 <= (double)(check - this.lastHitNanos) / 1000000.0) {
            this.fading = false;
            if (this.currentTarget != null) {
                delta = 0.0f - this.currentFade;
                this.currentFade = 0.001f <= Math.abs(delta) ? delta * 0.15f + this.currentFade : 0.0f;
                if (this.currentFade < 0.03f) {
                    this.currentFade = 0.0f;
                    this.hitActive = false;
                    this.currentTarget = null;
                }
            }
        } else {
            delta = 1.0f - this.currentFade;
            this.fading = true;
            this.currentFade = 0.001f <= Math.abs(delta) ? delta * 0.15f + this.currentFade : 1.0f;
        }
        if (this.previousTarget != null) {
            delta = 0.0f - this.previousFade;
            float next = 0.0f;
            if (0.001f <= Math.abs(delta)) {
                next = delta * 0.3f + this.previousFade;
            }
            this.previousFade = next;
            if (next < 0.03f) {
                this.previousFade = 0.0f;
                this.previousTarget = null;
            }
        }
        if (0.03f < this.currentFade) {
            this.currentTime += (float)this.animationSpeed();
        }
        if (0.03f < this.previousFade) {
            this.previousTime += (float)this.animationSpeed();
        }
        this.applyVisibility();
    }

    @Override
    public void onEntityHit(Entity entity) {
        if (!Client.isLiving(entity)) {
            return;
        }
        if (!Client.isAlive(entity)) {
            return;
        }
        if (!Client.sameEntity(this.currentTarget, entity)) {
            this.previousTarget = this.currentTarget;
            this.previousFade = this.currentFade;
            this.previousTime = this.currentTime;
            this.currentTarget = entity;
            this.currentFade = 0.0f;
            this.currentTime = 0.0f;
        }
        this.lastHitNanos = Client.nanos();
        this.hitActive = true;
    }

    @Override
    public void onRender() {
        float delta;
        float time;
        boolean drawPrevious;
        float previousValue;
        float previousDelta;
        if (this.currentTarget == null && this.previousTarget == null) {
            return;
        }
        long now = Client.nanos();
        float factor = Math.min((float)((double)(now - this.lastFrameNanos) / 5.0E7), 1.0f);
        float currentValue = this.currentFade;
        float currentDelta = currentValue - this.currentFadePrev;
        if (0.001f <= Math.abs(currentDelta)) {
            currentValue = factor * currentDelta + this.currentFadePrev;
        }
        if (0.001f <= Math.abs(previousDelta = (previousValue = this.previousFade) - this.previousFadePrev)) {
            previousValue = factor * previousDelta + this.previousFadePrev;
        }
        boolean drawCurrent = this.currentTarget != null && this.currentLineOfSight && 0.03f < currentValue;
        boolean bl = drawPrevious = this.previousTarget != null && this.previousLineOfSight && 0.03f < previousValue;
        if (!drawCurrent && !drawPrevious) {
            return;
        }
        int baseColor = this.colorValue();
        int tint = (Client.randomTint(baseColor) ^ baseColor) & 0xFFFFFF ^ baseColor;
        int effect = this.effectIndex();
        this.vertices.clear();
        boolean bl2 = this.markerActive = 0.001f < this.markerEnergy();
        if (drawPrevious) {
            time = this.previousTime;
            delta = time - this.previousTimePrev;
            if (0.001f <= Math.abs(delta)) {
                time = factor * delta + this.previousTimePrev;
            }
            Client.targetEspMarker(this, this.previousTarget, previousValue, time, tint, effect, false);
        }
        if (drawCurrent) {
            time = this.currentTime;
            delta = time - this.currentTimePrev;
            if (0.001f <= Math.abs(delta)) {
                time = factor * delta + this.currentTimePrev;
            }
            Client.targetEspMarker(this, this.currentTarget, currentValue, time, tint, effect, this.fading);
        }
        float brightness = (float)Client.colorTableChannel(tint, 8);
        if (!this.vertices.isEmpty() && Client.renderPassActive()) {
            Client.drawTargetEspStrip(8, this.vertices, (0.25f <= brightness ? 1 : 0) + 1);
        }
    }

    public int effectIndex() {
        Setting setting = this.setting(EFFECT_KEY);
        if (setting == null) {
            return 0;
        }
        List<String> modes = setting.getModes();
        int index = modes.indexOf(setting.getMode());
        if (index < 0 || 8 <= index) {
            return 0;
        }
        return index;
    }

    public float markerEnergy() {
        float delta;
        float delta2;
        if (!this.distortionVisible()) {
            return 0.0f;
        }
        float scale = (float)this.number(DISTORTION_KEY) / 100.0f * 0.1f;
        if (scale <= 0.0f) {
            return 0.0f;
        }
        long now = Client.nanos();
        float factor = (float)((double)(now - this.lastFrameNanos) / 5.0E7);
        if (factor > 1.0f) {
            factor = 1.0f;
        }
        float current = 0.0f;
        if (this.currentTarget != null && this.currentLineOfSight && 0.001f <= Math.abs(delta2 = (current = this.currentFade) - this.currentFadePrev)) {
            current = factor * delta2 + this.currentFadePrev;
        }
        float previous = 0.0f;
        if (this.previousTarget != null && this.previousLineOfSight && 0.001f <= Math.abs(delta = (previous = this.previousFade) - this.previousFadePrev)) {
            previous = factor * delta + this.previousFadePrev;
        }
        if (previous > current) {
            current = previous;
        }
        return (3.0f - (current + current)) * current * scale * current;
    }

    private void applyVisibility() {
        Setting shape = this.setting(SHAPE_KEY);
        Setting look = this.setting(LOOK_KEY);
        Setting timing = this.setting(TIMING_KEY);
        boolean shapeVisible = shape == null || shape.getBoolean();
        boolean lookVisible = look == null || look.getBoolean();
        boolean timingVisible = timing == null || timing.getBoolean();
        this.setVisible(RADIUS_KEY, shapeVisible);
        this.setVisible(POINT_SIZE_KEY, shapeVisible);
        this.setVisible(DENSITY_KEY, shapeVisible);
        this.setVisible(TRAIL_KEY, shapeVisible);
        this.setVisible(COLOR_KEY, lookVisible);
        this.setVisible(GLOW_KEY, lookVisible);
        this.setVisible(SPEED_KEY, timingVisible);
        this.setVisible(HOLD_KEY, timingVisible);
        this.setVisible(DISTORTION_KEY, this.distortionVisible());
    }

    private void setVisible(String key, boolean value) {
        Setting setting = this.setting(key);
        if (setting != null) {
            setting.setVisible(value);
        }
    }

    private double holdSeconds() {
        return this.number(HOLD_KEY);
    }

    private double animationSpeed() {
        return this.number(SPEED_KEY);
    }

    private int colorValue() {
        Setting setting = this.setting(COLOR_KEY);
        return setting == null ? -1096636 : setting.getColor();
    }

    private double number(String key) {
        Setting setting = this.setting(key);
        return setting == null ? 0.0 : setting.getNumber();
    }

    private Setting setting(String key) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(key)) continue;
            return setting;
        }
        return null;
    }
}

