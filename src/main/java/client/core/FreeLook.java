/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import client.mc.Entity;

public final class FreeLook
extends Feature {
    public static final String MODULE = "free_look";
    public static final String DISPLAY = "\u0424\u0440\u0435\u0435\u041b\u043e\u043e\u043a";
    public static final int VTABLE_RVA = 12574104;
    public static final long RVA_CONSTRUCT = 2735200695264L;
    public static final long RVA_APPLY_ROTATION = 2735200696672L;
    public static final long RVA_ROTATION_HOOK = 2735200696880L;
    public static final long RVA_ON_TICK = 2735200696272L;
    public static final long RVA_ON_ENABLE = 2735200696224L;
    public static final long RVA_RESTORE = 2735200696976L;
    public static final long RVA_ON_DISABLE = 2735200697120L;
    private static final int DEFAULT_LOOK_KEY = 164;
    private static final int BIND_MODE = 0;
    public static final int PERSPECTIVE_FIRST_PERSON = 0;
    public static final int PERSPECTIVE_THIRD_PERSON_BACK = 1;
    private static final double ANGLE_PERIOD = 360.0;
    private static final double ANGLE_HALF = 180.0;
    private boolean active;
    private float yaw;
    private float pitch;
    private boolean overridden;
    private float overriddenYaw;
    private float overriddenPitch;
    private boolean thirdPersonApplied;
    private int previousPerspective;

    public FreeLook() {
        super(MODULE, DISPLAY, Category.Render);
        this.add(Setting.key("look_key", 164));
        this.add(Setting.bool("auto_third_person", true));
        this.active = false;
        this.yaw = 0.0f;
        this.pitch = 0.0f;
        this.overridden = false;
        this.overriddenYaw = 0.0f;
        this.overriddenPitch = 0.0f;
        this.previousPerspective = 0;
    }

    @Override
    public void onEnable() {
        this.active = false;
        this.overridden = false;
        this.thirdPersonApplied = false;
        this.overriddenYaw = 0.0f;
        this.overriddenPitch = 0.0f;
        this.previousPerspective = 0;
    }

    @Override
    public void onDisable() {
        this.disable();
    }

    public void applyRotation() {
        if (!this.active || this.overridden) {
            return;
        }
        Entity entity = Client.cameraEntity();
        if (entity == null) {
            return;
        }
        this.overriddenYaw = Client.entityYaw(entity);
        this.overriddenPitch = Client.entityPitch(entity);
        this.overridden = true;
        Client.setEntityYaw(entity, this.yaw);
        Client.setEntityPitch(entity, this.pitch);
    }

    public float[] modifyRotation(float[] rotation) {
        if (!this.active) {
            if (this.overridden) {
                this.restoreRotation();
            }
            return rotation;
        }
        rotation[0] = this.yaw;
        rotation[1] = this.pitch;
        if (this.overridden) {
            rotation[2] = this.overriddenYaw;
            rotation[3] = this.overriddenPitch;
            this.overridden = false;
        }
        return rotation;
    }

    @Override
    public void onTick() {
        if (this.overridden) {
            this.restoreRotation();
        }
        if (!this.keyDown() || !Client.inGame() || Client.screenOpen()) {
            this.disable();
            return;
        }
        if (this.active || Client.player() == null) {
            return;
        }
        Entity entity = Client.cameraEntity();
        if (entity == null) {
            return;
        }
        this.active = true;
        this.yaw = Client.entityYaw(entity);
        this.pitch = Client.entityPitch(entity);
        this.previousPerspective = Client.perspectiveMode();
        this.thirdPersonApplied = false;
        if (this.autoThirdPerson() && this.previousPerspective == 0) {
            Client.setPerspectiveMode(1);
            this.thirdPersonApplied = true;
        }
    }

    public boolean active() {
        return this.active;
    }

    public boolean overridden() {
        return this.overridden;
    }

    private void restoreRotation() {
        this.overridden = false;
        Entity entity = Client.cameraEntity();
        if (entity == null) {
            return;
        }
        float restoredPitch = this.overriddenPitch;
        Client.setEntityYaw(entity, this.overriddenYaw);
        Client.setEntityPitch(entity, restoredPitch);
    }

    private void disable() {
        Entity entity;
        if (!this.active) {
            return;
        }
        this.active = false;
        this.overridden = false;
        if (this.thirdPersonApplied) {
            Client.setPerspectiveMode(this.previousPerspective);
            this.thirdPersonApplied = false;
        }
        if ((entity = Client.cameraEntity()) == null) {
            return;
        }
        float currentYaw = Client.entityYaw(entity);
        float currentPitch = Client.entityPitch(entity);
        double delta = (double)(this.yaw - currentYaw) % 360.0;
        if (delta > 180.0) {
            delta -= 360.0;
        }
        if (delta < -180.0) {
            delta += 360.0;
        }
        Client.turnEntity(entity, (float)delta, this.pitch - currentPitch);
    }

    private boolean keyDown() {
        Setting setting = this.setting("look_key");
        int key = setting == null ? 0 : setting.getKey();
        return key >= 1 && key <= 255 && Client.isBindDown(key, 0);
    }

    private boolean autoThirdPerson() {
        Setting setting = this.setting("auto_third_person");
        return setting != null && setting.getBoolean();
    }

    private Setting setting(String name) {
        for (Setting candidate : this.getSettings()) {
            if (!candidate.getName().equals(name)) continue;
            return candidate;
        }
        return null;
    }
}

