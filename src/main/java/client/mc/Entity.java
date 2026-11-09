/*
 * Decompiled with CFR 0.152.
 */
package client.mc;

public class Entity {
    private final Object handle;

    public Entity(Object handle) {
        this.handle = handle;
    }

    public Object raw() {
        return this.handle;
    }

    public int id() {
        return 0;
    }

    public double[] position() {
        return new double[3];
    }

    public double[] velocity() {
        return new double[3];
    }

    public double distanceTo(double[] point) {
        double[] p = this.position();
        double dx = p[0] - point[0];
        double dy = p[1] - point[1];
        double dz = p[2] - point[2];
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public boolean isAlive() {
        return true;
    }
}

