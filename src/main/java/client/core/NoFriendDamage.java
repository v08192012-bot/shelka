/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import client.mc.Entity;

public final class NoFriendDamage
extends Feature {
    public static final String MODULE = "no_friend_damage";
    public static final String DISPLAY = "\u041d\u043e\u0424\u0440\u0438\u0435\u043d\u0434\u0414\u0430\u043c\u0430\u0433\u0435";
    public static final int VTABLE_RVA = 12279192;
    public static final int SLOT_ON_CROSSHAIR_PICK = 2;
    public static final long RVA_CONSTRUCT = 2735200072448L;
    public static final long RVA_ON_CROSSHAIR_PICK = 2735200073376L;
    public static final long RVA_ON_ENABLE = 2735200072416L;
    public static final long RVA_ON_DISABLE = 2735200072432L;
    public static final long RVA_LAMBDA = 2735200074352L;
    public static final String MODE_CANCEL = "\u041e\u0442\u043c\u0435\u043d\u0430";
    public static final String MODE_THROUGH = "\u0421\u043a\u0432\u043e\u0437\u044c";
    private static final double REACH_MARGIN = 4.0;

    public NoFriendDamage() {
        super(MODULE, DISPLAY, Category.Player);
        this.add(Setting.mode("mode", MODE_THROUGH, MODE_CANCEL, MODE_THROUGH));
    }

    @Override
    public void onEnable() {
        Client.registerNoFriendDamage(this);
    }

    @Override
    public void onDisable() {
        Client.registerNoFriendDamage(null);
    }

    public void onCrosshairPick() {
        double blockDistance;
        if (!MODE_THROUGH.equals(this.mode())) {
            return;
        }
        if (!Client.inGame()) {
            return;
        }
        Entity target = Client.crosshairEntity();
        if (!Client.isFriend(target)) {
            return;
        }
        Entity self = Client.localPlayer();
        if (self == null) {
            return;
        }
        double[] eye = Client.eyePosition();
        double[] view = Client.lookVector(self);
        double blockRange = Client.blockInteractionRange(self);
        double entityRange = Client.entityInteractionRange(self);
        double[] far = new double[]{eye[0] + view[0] * blockRange, eye[1] + view[1] * blockRange, eye[2] + view[2] * blockRange};
        double range = blockDistance = Client.clipBlockDistance(self, eye, far);
        if (entityRange <= blockDistance) {
            range = entityRange;
        }
        double[] end = new double[]{eye[0] + view[0] * range, eye[1] + view[1] * range, eye[2] + view[2] * range};
        double limit = range + 4.0;
        double limitSq = limit * limit;
        Entity[] found = new Entity[1];
        double[] best = new double[]{range};
        Client.forEachEntity(entity -> {
            double dz;
            double dy;
            if (!Client.isPlayer(entity)) {
                return;
            }
            if (Client.sameEntity(entity, self)) {
                return;
            }
            if (Client.isRemoved(entity)) {
                return;
            }
            double[] position = Client.entityPosition(entity);
            double dx = position[0] - eye[0];
            double distanceSq = dx * dx + (dy = position[1] - eye[1]) * dy + (dz = position[2] - eye[2]) * dz;
            if (distanceSq > limitSq) {
                return;
            }
            if (Client.isFriend(entity)) {
                return;
            }
            double[] point = Client.clipEntityBox(entity, eye, end);
            if (point == null) {
                return;
            }
            double px = point[0] - eye[0];
            double py = point[1] - eye[1];
            double pz = point[2] - eye[2];
            double hit = Math.sqrt(px * px + py * py + pz * pz);
            if (hit < best[0]) {
                best[0] = hit;
                found[0] = entity;
            }
        });
        if (found[0] == null) {
            Client.rebuildCrosshairHit(blockRange);
        } else {
            Client.setCrosshairTarget(found[0]);
        }
    }

    private String mode() {
        Setting setting = this.setting("mode");
        return setting == null ? MODE_THROUGH : setting.getMode();
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }
}

