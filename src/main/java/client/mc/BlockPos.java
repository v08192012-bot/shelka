/*
 * Decompiled with CFR 0.152.
 */
package client.mc;

public final class BlockPos {
    private final int x;
    private final int y;
    private final int z;

    public BlockPos(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    public int z() {
        return this.z;
    }

    public BlockPos up() {
        return new BlockPos(this.x, this.y + 1, this.z);
    }

    public BlockPos down() {
        return new BlockPos(this.x, this.y - 1, this.z);
    }

    public double distanceSq(BlockPos other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        double dz = this.z - other.z;
        return dx * dx + dy * dy + dz * dz;
    }

    public String toString() {
        return "BlockPos[" + this.x + ", " + this.y + ", " + this.z + "]";
    }
}

