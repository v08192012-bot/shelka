/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import client.mc.Entity;

public final class AutoCart
extends Feature {
    public static final String MODULE = "autocart";
    public static final String DISPLAY = "\u0410\u0443\u0442\u043e\u0421\u0430\u0440\u0442";
    public static final int VTABLE_RVA = 12271872;
    public static final long RVA_ON_TICK = 2735200036224L;
    public static final long RVA_ON_LOOK = 2735200035536L;
    public static final long RVA_ON_DAMAGE = 2735200035360L;
    public static final long RVA_ON_TOGGLE = 2735200035344L;
    public static final long RVA_START = 2735200037440L;
    public static final long RVA_AIM = 2735200039408L;
    public static final long RVA_SELECT_SLOT = 2735200040320L;
    public static final long RVA_RESET = 2735200035392L;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PLACE_RAIL = 1;
    private static final int STATE_PLACE_CART = 2;
    private static final int STATE_USE = 3;
    private static final int STATE_HOLD = 4;
    private static final int STATE_RESTORE = 5;
    private static final int SWAP_NONE = -1;
    private static final int HOTBAR_LAST = 8;
    private static final int INVENTORY_LIMIT = 36;
    private static final int FRAME_LIMIT = 201;
    private static final int FACE_LIMIT = 6;
    private static final int AIM_HELD_FRAMES = 2;
    private static final double NANOS_PER_SECOND = 1.0E9;
    private static final float TICK_SCALE_F = 20.0f;
    private static final float CHARGE_DIVISOR = 3.0f;
    private static final double THROW_SPEED_SCALE = 3.0;
    private static final double DAMAGE_THRESHOLD = 2.0;
    private static final double AIM_HORIZON = 0.1;
    private static final double AIM_REST_RADIUS = 0.001;
    private static final double AIM_TOLERANCE = 1.5;
    private static final double HALF_BLOCK = 0.5;
    private static final double AIM_POINT_LIFT = 0.0625;
    private static final double AIM_DT_EPSILON = 0.05;
    private static final double AIM_FACTOR_MIN = 0.01;
    private static final double AIM_FACTOR_MAX = 0.95;
    private static final double AIM_SCALE = 0.8;
    private static final double ANGLE_FULL = 360.0;
    private static final double ANGLE_HALF = 180.0;
    private static final double ANGLE_NEG_FULL = -360.0;
    private static final double ANGLE_NEG_HALF = -180.0;
    private static final int[][] FACE_OFFSETS = new int[][]{{0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}, {-1, 0, 0}, {1, 0, 0}};
    private final int[] swapManager = Client.newSwapManager();
    private final boolean[] keyLatch = new boolean[1];
    private int state;
    private int frameCounter;
    private int holdTicks;
    private int attempts;
    private int aimHeld;
    private int blockX;
    private int blockY;
    private int blockZ;
    private int face;
    private int targetX;
    private int targetY;
    private int targetZ;
    private double aimPointX;
    private double aimPointY;
    private double aimPointZ;
    private double centerX;
    private double centerY;
    private double centerZ;
    private float aimYaw;
    private float aimPitch;
    private double aimAccumX;
    private double aimAccumZ;
    private long lastAimNanos;
    private int previousSlot = -1;
    private int railSlot = -1;
    private int cartSlot = -1;
    private int useSlot = -1;
    private int currentSlot = -1;
    private int pendingSlot = -1;
    private boolean useKeyDown;
    private final boolean[] triggerLatch = new boolean[1];
    private boolean triggered;
    private boolean restoreLatch;
    private boolean applied;

    public AutoCart() {
        super(MODULE, DISPLAY, Category.Combat);
        this.add(Setting.mode("mode", "\u041f\u043e\u0440\u044f\u0434\u043e\u043a", "\u041f\u043e\u0440\u044f\u0434\u043e\u043a", "\u041f\u043e\u0440\u044f\u0434\u043e\u043a2"));
        this.add(Setting.key("activate", 0));
        this.add(Setting.number("charge_ticks", 7.0, 5.0, 20.0));
        this.add(Setting.number("place_delay", 1.0, 1.0, 10.0));
        this.add(Setting.number("aim_speed", 1.0, 0.5, 10.0));
        this.add(Setting.bool("auto_disable", false));
    }

    @Override
    public void onEnable() {
        this.resetState();
    }

    @Override
    public void onDisable() {
        this.resetState();
    }

    @Override
    public void onTick() {
        Client.swapManagerTick(this.swapManager);
        if (!Client.inGame()) {
            if (this.state == 0) {
                return;
            }
            this.resetState();
            return;
        }
        if (this.triggered) {
            this.triggered = false;
            if (this.state == 0 && !Client.isPaused()) {
                this.start();
            }
        }
        if (this.state == 0) {
            return;
        }
        ++this.frameCounter;
        if (this.frameCounter >= 201) {
            this.resetState();
            return;
        }
        this.updateAim();
        if (this.holdTicks > 0) {
            --this.holdTicks;
            return;
        }
        switch (this.state) {
            case 1: {
                this.placeRail();
                return;
            }
            case 2: {
                this.placeCart();
                return;
            }
            case 3: {
                this.useItem();
                return;
            }
            case 4: {
                this.holdItem();
                return;
            }
            case 5: {
                this.restore();
                return;
            }
        }
    }

    @Override
    public void onRender() {
        this.applyAim();
    }

    public void onDamage(double amount) {
        if (this.state == 0) {
            return;
        }
        if (!(2.0 < amount)) {
            return;
        }
        this.resetState();
    }

    private void placeRail() {
        if (!this.ensureSlot(this.railSlot)) {
            return;
        }
        if (this.aimHeld < 2) {
            return;
        }
        Object hit = Client.blockHitResult(this.aimPointX, this.aimPointY, this.aimPointZ, this.face, this.blockX, this.blockY, this.blockZ);
        if (hit != null) {
            Client.interactBlock(hit);
        }
        this.state = 2;
        this.holdTicks = (int)this.placeDelay() - 1;
    }

    private void placeCart() {
        if (!this.ensureSlot(this.cartSlot)) {
            return;
        }
        Object hit = Client.blockHitResult(this.centerX, this.centerY, this.centerZ, 1, this.targetX, this.targetY, this.targetZ);
        if (hit != null) {
            Client.interactBlock(hit);
        }
        this.state = this.ordered() ? 5 : 3;
    }

    private void useItem() {
        if (!this.ensureSlot(this.useSlot)) {
            return;
        }
        Entity player = Client.player();
        Client.interactItem(player);
        if (!Client.isUsingItem(player)) {
            this.resetState();
            return;
        }
        Client.setUseKey(true);
        this.useKeyDown = true;
        this.attempts = 0;
        this.state = 4;
    }

    private void holdItem() {
        Entity player = Client.player();
        ++this.attempts;
        if (!Client.isUsingItem(player)) {
            this.resetState();
            return;
        }
        Client.setUseKey(true);
        if (this.attempts < (int)this.placeDelay()) {
            return;
        }
        if (this.aimHeld < 2) {
            return;
        }
        Client.setUseKey(false);
        this.useKeyDown = false;
        Client.stopUsingItem(player);
        this.aimHeld = 0;
        this.state = this.ordered() ? 1 : 5;
    }

    private void restore() {
        Client.setSelectedSlotReflective(this.previousSlot);
        boolean disable = this.autoDisable();
        if (this.useKeyDown) {
            Client.setUseKey(false);
        }
        this.useKeyDown = false;
        Client.swapManagerReset(this.swapManager);
        this.currentSlot = -1;
        this.state = 0;
        this.attempts = 0;
        this.holdTicks = 0;
        this.aimAccumZ = 0.0;
        this.aimAccumX = 0.0;
        this.lastAimNanos = 0L;
        this.cartSlot = -1;
        this.previousSlot = -1;
        this.triggered = false;
        this.triggerLatch[0] = false;
        if (disable && this.enabled) {
            this.setEnabled(false);
        }
    }

    private void start() {
        int[] hit = Client.raycastBlockData();
        if (hit == null) {
            return;
        }
        boolean found = hit[0] != 0;
        this.blockX = hit[1];
        this.blockY = hit[2];
        this.blockZ = hit[3];
        this.face = hit[4];
        if (!found || this.face >= 6) {
            return;
        }
        this.railSlot = Client.findRailSlot();
        this.cartSlot = Client.findCartItemSlot();
        this.useSlot = Client.findChargedItemSlot();
        int extra = Client.findEnchantedSlot(48);
        if (this.railSlot < 0 || this.cartSlot < 0 || this.useSlot < 0 || extra < 0) {
            this.cartSlot = -1;
            this.railSlot = -1;
            return;
        }
        int[] offset = FACE_OFFSETS[this.face];
        this.targetX = offset[0] + this.blockX;
        this.targetY = offset[1] + this.blockY;
        this.targetZ = offset[2] + this.blockZ;
        this.aimPointX = (double)offset[0] * 0.5 + (double)this.blockX + 0.5;
        this.aimPointY = (double)offset[1] * 0.5 + (double)this.blockY + 0.5;
        this.aimPointZ = (double)this.blockZ + 0.5 + (double)offset[2] * 0.5;
        this.centerX = (double)this.targetX + 0.5;
        this.centerY = (double)this.targetY + 0.0625;
        this.centerZ = (double)this.targetZ + 0.5;
        Entity player = Client.player();
        this.previousSlot = Client.selectedSlot();
        this.currentSlot = -1;
        this.aimYaw = Client.entityYaw(player);
        this.aimPitch = Client.entityPitch(player);
        this.aimAccumZ = 0.0;
        this.aimAccumX = 0.0;
        this.lastAimNanos = Client.nanos();
        this.attempts = 0;
        this.state = this.ordered() ? 3 : 1;
        this.frameCounter = 0;
    }

    private void updateAim() {
        Entity player = Client.player();
        Entity subject = Client.aimSubject(player);
        double[] playerPosition = Client.entityPosition(subject);
        float yaw = Client.entityYaw(player);
        float pitch = Client.entityPitch(player);
        if (this.state == 3 || this.state == 4) {
            int charge = this.attempts + 1;
            if (charge < (int)this.chargeTicks()) {
                charge = (int)this.chargeTicks();
            }
            float factor = (float)charge / 20.0f;
            factor = (factor * factor + factor + factor) / 3.0f;
            double targetBlockX = (double)this.targetX + 0.5;
            double targetBlockY = (double)this.targetY + 0.5;
            double targetBlockZ = (double)this.targetZ + 0.5;
            double speed = (double)factor * 3.0;
            if (speed <= 0.1) {
                speed = 0.1;
            }
            double heightDelta = targetBlockY - ((double)this.targetY - 0.1);
            double distance = Math.sqrt((targetBlockX - playerPosition[0]) * (targetBlockX - playerPosition[0]) + (targetBlockZ - playerPosition[2]) * (targetBlockZ - playerPosition[2]));
            float[] rotation = Client.lookAt(playerPosition, new double[]{targetBlockX, targetBlockY, targetBlockZ}, yaw, pitch);
            this.aimYaw = rotation[0];
            this.aimPitch = rotation[1];
            if (0.001 < distance) {
                this.aimPitch = (float)Client.solveThrowPitch(distance, heightDelta, speed);
            }
        } else {
            float[] rotation = Client.lookAt(playerPosition, new double[]{this.aimPointX, this.aimPointY, this.aimPointZ}, yaw, pitch);
            this.aimYaw = rotation[0];
            this.aimPitch = rotation[1];
        }
        double yawDelta = AutoCart.wrapDegrees((double)this.aimYaw - (double)yaw);
        double pitchDelta = (double)this.aimPitch - (double)pitch;
        this.aimHeld = Math.sqrt(yawDelta * yawDelta + pitchDelta * pitchDelta) < 1.5 ? ++this.aimHeld : 0;
    }

    public void applyAim() {
        if (Client.keybindPressed(this.bind("activate"), this.activateMods(), this.triggerLatch)) {
            this.triggered = true;
        }
        if (this.state == 0) {
            return;
        }
        if (!Client.inGame()) {
            return;
        }
        if (Client.isPauseScreen()) {
            return;
        }
        long now = Client.nanos();
        double delta = 0.0;
        if (this.lastAimNanos > 0L) {
            delta = (double)(now - this.lastAimNanos) / 1.0E9;
        }
        this.lastAimNanos = now;
        Entity player = Client.player();
        double yawDelta = AutoCart.wrapDegrees((double)this.aimYaw - (double)Client.entityYaw(player));
        double pitchDelta = (double)this.aimPitch - (double)Client.entityPitch(player);
        if (Math.abs(yawDelta) < 0.05 && Math.abs(pitchDelta) < 0.05) {
            return;
        }
        double factor = AutoCart.clamp(this.aimSpeed() * 0.8 * delta, 0.01, 0.95);
        this.aimAccumX += yawDelta;
        this.aimAccumZ += pitchDelta;
        Client.rotateBy(player, (float)(factor * yawDelta), (float)(factor * pitchDelta));
    }

    private boolean ensureSlot(int slot) {
        if (this.currentSlot != slot) {
            if (slot > 8) {
                if (this.pendingSlot == slot) {
                    boolean flag = this.restoreLatch;
                    this.restoreLatch = false;
                    if (flag) {
                        Client.setSelectedSlotReflective(this.previousSlot);
                        this.currentSlot = slot;
                        return true;
                    }
                } else if (Client.swapManagerFree(this.swapManager)) {
                    Client.swapManagerSwapOnce(this.swapManager, slot, this.previousSlot);
                    this.pendingSlot = slot;
                }
                return false;
            }
            Client.setSelectedSlotReflective(slot);
            this.currentSlot = slot;
        }
        return true;
    }

    private void resetState() {
        if (this.useKeyDown) {
            Client.setUseKey(false);
        }
        this.useKeyDown = false;
        Client.swapManagerReset(this.swapManager);
        this.currentSlot = -1;
        this.state = 0;
        this.attempts = 0;
        this.holdTicks = 0;
        this.aimAccumZ = 0.0;
        this.aimAccumX = 0.0;
        this.lastAimNanos = 0L;
        this.triggered = false;
        this.triggerLatch[0] = false;
        this.cartSlot = -1;
        this.previousSlot = -1;
    }

    public int state() {
        return this.state;
    }

    public int railSlot() {
        return this.railSlot;
    }

    public int cartSlot() {
        return this.cartSlot;
    }

    public int useSlot() {
        return this.useSlot;
    }

    public int aimHeld() {
        return this.aimHeld;
    }

    public int frameCounter() {
        return this.frameCounter;
    }

    private static double clamp(double value, double min, double max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    private static double wrapDegrees(double angle) {
        double wrapped = angle % 360.0;
        if (wrapped > 180.0) {
            wrapped += -360.0;
        }
        if (wrapped < -180.0) {
            wrapped += 360.0;
        }
        return wrapped;
    }

    private boolean ordered() {
        Setting setting = this.setting("mode");
        return setting != null && !"\u041f\u043e\u0440\u044f\u0434\u043e\u043a".equals(setting.getMode());
    }

    private double chargeTicks() {
        Setting setting = this.setting("charge_ticks");
        return setting == null ? 7.0 : setting.getNumber();
    }

    private double placeDelay() {
        Setting setting = this.setting("place_delay");
        return setting == null ? 1.0 : setting.getNumber();
    }

    private double aimSpeed() {
        Setting setting = this.setting("aim_speed");
        return setting == null ? 1.0 : setting.getNumber();
    }

    private boolean autoDisable() {
        Setting setting = this.setting("auto_disable");
        return setting != null && setting.getBoolean();
    }

    private int bind(String name) {
        Setting setting = this.setting(name);
        return setting == null ? 0 : setting.getKey();
    }

    private int activateMods() {
        return 0;
    }

    private Setting setting(String name) {
        for (Setting value : this.getSettings()) {
            if (!value.getName().equals(name)) continue;
            return value;
        }
        return null;
    }
}

