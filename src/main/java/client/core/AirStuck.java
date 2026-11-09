/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import client.mc.Entity;

public final class AirStuck
extends Feature {
    public static final String MODULE = "airstuck";
    public static final int VTABLE_RVA = 12287520;
    public static final int ENABLE_RVA = 448704;
    public static final int DISABLE_RVA = 448992;
    public static final int TICK_RVA = 449184;
    public static final int SET_ENABLED_RVA = 448272;
    public static final int STACK_LIMIT = 3;
    public static final long KICK_PROTECTION_NANOS = 28000000000L;
    public static final String MSG_KICK_PROTECTION = "\u00a7c[AirStuck] \u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0432\u044b\u043a\u043b\u044e\u0447\u0435\u043d (\u0437\u0430\u0449\u0438\u0442\u0430 \u043e\u0442 \u043a\u0438\u043a\u0430)";
    public static final String MSG_NEED_AIR = "\u00a7c\u0412\u0430\u043c \u043d\u0443\u0436\u043d\u043e \u043d\u0430\u0445\u043e\u0434\u0438\u0442\u044c\u0441\u044f \u0432 \u0432\u043e\u0437\u0434\u0443\u0445\u0435";
    private final double[] savedVelocity = new double[3];
    private boolean active;
    private long enableTime;

    public AirStuck() {
        super(MODULE, "\u0410\u0438\u0440\u0417\u0442\u0443\u0441\u043a", Category.Movement);
        this.add(Setting.mode("mode", "Vanilla", "Vanilla", "Packet"));
        this.add(Setting.bool("fall_check", true));
    }

    @Override
    public void setEnabled(boolean value) {
        Entity self;
        if (value && this.fallCheck() && Client.inGame() && Client.isOnGround(self = Client.localPlayer())) {
            Client.sendMessage(self, MSG_NEED_AIR);
            return;
        }
        super.setEnabled(value);
    }

    @Override
    public void onEnable() {
        Client.registerAirStuck(this);
        this.enableTime = Client.nanoTime();
        Entity self = Client.localPlayer();
        double[] motion = Client.deltaMovement(self);
        this.savedVelocity[0] = motion[0];
        this.savedVelocity[1] = motion[1];
        this.savedVelocity[2] = motion[2];
        Client.setNoGravity(self, true);
        this.active = true;
        Client.incrementAirStuckCounter();
        Client.setAirStuckCleanupPending(false);
        if (Client.airStuckCounter() > 3 && !Client.airStuckStacked()) {
            Client.setAirStuckStacked(true);
        }
        Client.refreshAirStuck();
    }

    @Override
    public void onDisable() {
        Client.registerAirStuck(null);
        if (this.active) {
            this.active = false;
            Client.decrementAirStuckCounter();
            if (Client.airStuckCounter() == 0) {
                Client.finishAirStuck();
            }
        }
        if (!Client.inGame()) {
            return;
        }
        Entity self = Client.localPlayer();
        Client.setNoGravity(self, false);
        if (this.fallCheck() && Client.isOnGround(self)) {
            return;
        }
        Client.setDeltaMovement(self, this.savedVelocity);
    }

    @Override
    public void onTick() {
        if (Client.airStuckCounter() < 1) {
            if (Client.airStuckCleanupPending()) {
                Client.finishAirStuck();
            }
        } else {
            Client.refreshAirStuck();
        }
        Entity self = Client.localPlayer();
        if (!this.kickProtection() || Client.nanoTime() - this.enableTime < 28000000000L) {
            Client.setDeltaMovement(self, new double[]{0.0, 0.0, 0.0});
            Client.setNoGravity(self, true);
            return;
        }
        Client.sendMessage(self, MSG_KICK_PROTECTION);
        this.setEnabled(false);
    }

    private boolean fallCheck() {
        Setting s = this.setting("fall_check");
        return s != null && s.getBoolean();
    }

    private boolean kickProtection() {
        Setting s = this.setting("ft");
        return s != null && s.getBoolean();
    }

    private Setting setting(String name) {
        for (Setting s : this.getSettings()) {
            if (!s.getName().equals(name)) continue;
            return s;
        }
        return null;
    }
}

