/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import client.mc.Entity;

public final class FreeCam
extends Feature {
    public static final String MODULE = "freecam";
    public static final String DISPLAY = "\u0424\u0440\u0435\u0435\u0421\u0430\u043c";
    public static final int VTABLE_RVA = 12289024;
    private static final int INPUT_FORWARD = 1;
    private static final int INPUT_BACKWARD = 2;
    private static final int INPUT_LEFT = 4;
    private static final int INPUT_RIGHT = 8;
    private static final int INPUT_JUMP = 1;
    private static final int INPUT_SNEAK = 1;
    private static final double MAX_STEP_TICKS = 4.0;
    private static final double NANOS_PER_TICK = 5.0E7;
    private static final double STRAFE_OFFSET = 90.0;
    private static final double HALF = 0.5;
    private boolean active;
    private boolean restoring;
    private boolean cameraInitialized;
    private boolean entitiesFlagged;
    private long lastUpdate;
    private long restoreStart;
    private double cameraX;
    private double cameraY;
    private double cameraZ;
    private double savedX;
    private double savedY;
    private double savedZ;
    private float lastHealth;

    public FreeCam() {
        super(MODULE, DISPLAY, Category.Movement);
        this.add(Setting.number("speed", 0.25, 0.05, 4.0));
        this.add(Setting.number("return_ms", 0.0, 0.0, 2000.0));
        this.add(Setting.bool("disable_on_damage", true));
        this.add(Setting.color("box_color", -2147418368));
    }

    @Override
    public void setEnabled(boolean value) {
        if (!value && this.enabled && !this.restoring && this.cameraInitialized && Client.gameReady() && this.returnMs() > 0.0 && Client.inGame()) {
            this.restoring = true;
            this.savedX = this.cameraX;
            this.savedY = this.cameraY;
            this.savedZ = this.cameraZ;
            this.restoreStart = Client.tickTime();
            return;
        }
        if (value) {
            this.restoring = false;
        }
        super.setEnabled(value);
    }

    @Override
    public void onEnable() {
        this.active = true;
        this.restoring = false;
        this.lastHealth = (float)Client.playerHealth();
        this.lastUpdate = Client.tickTime();
        Client.setFreeCamInstance(this);
        Client.addCameraOverride();
        if (Client.cameraOverrides() > 3 && !this.entitiesFlagged) {
            this.entitiesFlagged = true;
        }
        Client.refreshCameraState();
    }

    @Override
    public void onDisable() {
        this.restoring = false;
        Client.setFreeCamInstance(null);
        this.cameraInitialized = false;
        if (this.active) {
            this.active = false;
            if (Client.cameraOverrides() > 0) {
                Client.removeCameraOverride();
            }
            if (Client.cameraOverrides() == 0) {
                Client.onCameraOverrideEnded();
            }
        }
    }

    @Override
    public void onTick() {
        if (Client.cameraOverrides() > 0) {
            Entity self = Client.player();
            if (self != null) {
                Client.suppressEntity(self, false);
                for (Entity entity : Client.trackedEntities()) {
                    if (entity == null) continue;
                    Client.suppressEntity(entity, false);
                }
            }
            return;
        }
        if (!this.entitiesFlagged) {
            return;
        }
        if (Client.isPaused()) {
            this.entitiesFlagged = true;
            return;
        }
        this.entitiesFlagged = false;
        Entity self = Client.player();
        if (self == null || Client.world() == null) {
            return;
        }
        for (Entity entity : Client.trackedEntities()) {
            if (entity == null) continue;
            Client.suppressEntity(entity, Client.selfSuppression(self, entity));
        }
    }

    @Override
    public void onRender() {
        int color = this.boxColor();
        if (!this.cameraInitialized || (color & 0xFF000000) == 0) {
            return;
        }
        Entity self = Client.player();
        if (self == null) {
            return;
        }
        double[] eye = Client.eyePosition(self);
        double half = Client.entityWidth(self) * 0.5;
        double y1 = eye[1];
        double y2 = eye[1] + Client.entityHeight(self);
        Client.drawBox(eye[0] - half, y1, eye[2] - half, eye[0] + half, y2, eye[2] + half, color);
    }

    public void updateCamera() {
        if (this.restoring) {
            this.finishReturn();
            return;
        }
        if (!Client.inGame()) {
            Client.onFreeCamWorldGone(this);
            return;
        }
        float health = (float)Client.playerHealth();
        if (health <= 0.0f || this.disableOnDamage() && health < this.lastHealth) {
            if (this.enabled && Client.gameReady() && this.cameraInitialized) {
                if (this.returnMs() > 0.0 && Client.inGame()) {
                    this.restoring = true;
                    this.savedX = this.cameraX;
                    this.savedY = this.cameraY;
                    this.savedZ = this.cameraZ;
                    this.restoreStart = Client.tickTime();
                    return;
                }
                this.enabled = false;
                this.onSettingsVisibilityChanged(false);
                this.onDisable();
                Client.notifyModuleState(this, false);
            }
            return;
        }
        this.lastHealth = health;
        if (!this.cameraInitialized && !Client.initFreeCamPosition(this)) {
            return;
        }
        double now = Client.tickTime();
        double delta = (now - (double)this.lastUpdate) / 5.0E7;
        this.lastUpdate = Client.tickTime();
        if (delta > 4.0) {
            delta = 4.0;
        }
        double[] rotation = Client.currentRotation();
        double yaw = rotation[0];
        double pitch = rotation[1];
        double newX = this.cameraX;
        double newY = this.cameraY;
        double newZ = this.cameraZ;
        if (!Client.isPaused()) {
            int[] input = Client.inputState();
            int wasd = input[0];
            boolean jump = (input[1] & 1) != 0;
            boolean sneak = (input[2] & 1) != 0;
            double distance = delta * this.speed();
            double yawRad = Math.toRadians(yaw);
            double pitchRad = Math.toRadians(pitch);
            double forwardX = -Math.sin(yawRad) * Math.cos(pitchRad) * distance;
            double forwardY = Math.sin(pitchRad) * distance;
            double forwardZ = Math.cos(yawRad) * Math.cos(pitchRad) * distance;
            double strafeRad = Math.toRadians(yaw - 90.0);
            double strafeX = -Math.sin(strafeRad) * distance;
            double strafeZ = -Math.cos(strafeRad) * distance;
            if ((wasd & 1) != 0) {
                newX += forwardX;
                newY += forwardY;
                newZ += forwardZ;
            }
            if ((wasd & 2) != 0) {
                newX -= forwardX;
                newY -= forwardY;
                newZ -= forwardZ;
            }
            if ((wasd & 4) != 0) {
                newX += strafeX;
                newZ += strafeZ;
            }
            if ((wasd & 8) != 0) {
                newX -= strafeX;
                newZ -= strafeZ;
            }
            if (jump) {
                newY += distance;
            }
            if (sneak) {
                newY -= distance;
            }
        }
        Client.applyFreeCamPosition(this, newX, newY, newZ, yaw, pitch);
    }

    private void finishReturn() {
        if (!Client.returnFreeCamToPlayer(this)) {
            return;
        }
        this.restoring = false;
        double[] rotation = Client.currentRotation();
        Client.applyFreeCamPosition(this, this.cameraX, this.cameraY, this.cameraZ, rotation[0], rotation[1]);
        if (this.enabled) {
            this.enabled = false;
            this.onSettingsVisibilityChanged(false);
            this.onDisable();
            Client.notifyModuleState(this, false);
        }
    }

    public void setCameraInitialized(boolean value) {
        this.cameraInitialized = value;
    }

    public boolean isCameraInitialized() {
        return this.cameraInitialized;
    }

    public void setCameraPosition(double x, double y, double z) {
        this.cameraX = x;
        this.cameraY = y;
        this.cameraZ = z;
    }

    public double cameraX() {
        return this.cameraX;
    }

    public double cameraY() {
        return this.cameraY;
    }

    public double cameraZ() {
        return this.cameraZ;
    }

    public boolean isRestoring() {
        return this.restoring;
    }

    public long restoreStart() {
        return this.restoreStart;
    }

    public double savedX() {
        return this.savedX;
    }

    public double savedY() {
        return this.savedY;
    }

    public double savedZ() {
        return this.savedZ;
    }

    public boolean isActive() {
        return this.active;
    }

    public float lastHealth() {
        return this.lastHealth;
    }

    private double speed() {
        Setting s = this.setting("speed");
        return s == null ? 0.25 : s.getNumber();
    }

    private double returnMs() {
        Setting s = this.setting("return_ms");
        return s == null ? 0.0 : s.getNumber();
    }

    private boolean disableOnDamage() {
        Setting s = this.setting("disable_on_damage");
        return s == null || s.getBoolean();
    }

    private int boxColor() {
        Setting s = this.setting("box_color");
        return s == null ? 0 : s.getColor();
    }

    private Setting setting(String name) {
        for (Setting s : this.getSettings()) {
            if (!s.getName().equals(name)) continue;
            return s;
        }
        return null;
    }
}

