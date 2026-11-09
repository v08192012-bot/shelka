/*
 * Decompiled with CFR 0.152.
 */
package client.aim;

import client.mc.Client;

public final class Rotation {
    private double yaw;
    private double pitch;

    public Rotation(double yaw, double pitch) {
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public double yaw() {
        return this.yaw;
    }

    public double pitch() {
        return this.pitch;
    }

    public void set(double yaw, double pitch) {
        this.yaw = Rotation.clamp(yaw);
        this.pitch = Rotation.clampPitch(pitch);
    }

    public static double wrap(double angle) {
        if ((angle %= 360.0) >= 180.0) {
            angle -= 360.0;
        }
        if (angle < -180.0) {
            angle += 360.0;
        }
        return angle;
    }

    public static double clamp(double yaw) {
        return yaw % 360.0;
    }

    public static double clampPitch(double pitch) {
        return Math.max(-90.0, Math.min(90.0, pitch));
    }

    public static double[] delta(double[] current, double[] targetPosition) {
        double[] self = Client.eyePosition();
        double dx = targetPosition[0] - self[0];
        double dy = targetPosition[1] - self[1];
        double dz = targetPosition[2] - self[2];
        double horizontal = Math.sqrt(dx * dx + dz * dz);
        double targetYaw = Math.toDegrees(Math.atan2(-dx, dz));
        double targetPitch = -Math.toDegrees(Math.atan2(dy, horizontal));
        double yawDelta = Rotation.wrap(targetYaw - current[0]);
        double pitchDelta = targetPitch - current[1];
        return new double[]{yawDelta, pitchDelta};
    }
}

