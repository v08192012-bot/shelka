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

public final class Backtrack
extends Feature {
    public static final String MODULE = "backtrack";
    public static final int VTABLE_RVA = 12276056;
    public static final int ENABLE_RVA = 377888;
    public static final int DISABLE_RVA = 377968;
    public static final int WINDOW_TICK_RVA = 378048;
    public static final int SCAN_TICK_RVA = 378336;
    public static final int RENDER_RVA = 380256;
    public static final int WINDOW_REFRESH_RVA = 377776;
    public static final int TRACE_RVA = 379360;
    public static final int TRACE_LIMIT_RVA = 669856;
    public static final String STATUS_WINDOW_CLOSED = "\u043e\u043a\u043d\u043e \u0437\u0430\u043a\u0440\u044b\u0442\u043e";
    public static final String STATUS_NO_PLAYER = "\u043d\u0435\u0442 \u0438\u0433\u0440\u043e\u043a\u0430";
    public static final String STATUS_VANILLA_AIMING = "\u0432\u0430\u043d\u0438\u043b\u044c \u0443\u0436\u0435 \u0446\u0435\u043b\u0438\u0442\u0441\u044f \u0432 \u0441\u0443\u0449\u043d\u043e\u0441\u0442\u044c";
    public static final String STATUS_OUTSIDE_WINDOWS = "\u043f\u0440\u0438\u0446\u0435\u043b \u0432\u043d\u0435 \u0440\u0430\u0437\u0432\u0451\u0440\u0442\u043e\u043a";
    public static final String STATUS_ON_WINDOW = "\u043f\u0440\u0438\u0446\u0435\u043b \u043d\u0430\u0432\u0435\u0434\u0451\u043d \u043d\u0430 \u0440\u0430\u0437\u0432\u0451\u0440\u0442\u043a\u0443";
    public static final String STATUS_BLOCKED = "\u0440\u0430\u0437\u0432\u0451\u0440\u0442\u043a\u0443 \u0437\u0430\u0433\u043e\u0440\u0430\u0436\u0438\u0432\u0430\u0435\u0442 \u0431\u043b\u043e\u043a";
    private static final int FILL_COLOR_ALPHA = 0x33000000;
    private static final int OUTLINE_COLOR_ALPHA = 0x66000000;
    private static final int LABEL_COLOR = -16777216;
    private static final float LABEL_SIZE = 20.0f;
    private static final float LABEL_ALPHA = 1.0f;
    private static final double WINDOW_MIN = 25.0;
    private static double windowScale;
    private final List<Window> windows = new ArrayList<Window>();
    private final List<Window> processed = new ArrayList<Window>();
    private String status = "";

    public Backtrack() {
        super(MODULE, "\u0411\u0430\u0441\u043a\u0442\u0440\u0430\u0441\u043a", Category.Combat);
        this.add(Setting.number("reach", 3.0, 1.0, 8.0));
        this.add(Setting.number("window", 200.0, 0.0, 1000.0));
        this.add(Setting.bool("show_box", true));
        this.add(Setting.color("box_color", -12877066));
    }

    @Override
    public void onEnable() {
        this.refreshWindowScale();
        this.clearWindows();
    }

    @Override
    public void onDisable() {
        windowScale = 0.0;
        this.clearWindows();
    }

    @Override
    public void onTick() {
        this.scanCrosshair();
        this.trackWindows();
    }

    @Override
    public void onRender() {
        if (this.windows.isEmpty()) {
            return;
        }
        int color = this.boxColor();
        Client.drawWindowPass(this.windows, color & 0xFFFFFF | 0x33000000, 20.0f, 1.0f, null, true, false, -16777216);
        Client.drawWindowPass(this.processed, color & 0xFFFFFF | 0x66000000, 20.0f, 1.0f, Client.WINDOW_ALPHA_STEPS, false, true, -16777216);
    }

    private void trackWindows() {
        this.refreshWindowScale();
        this.clearWindows();
        if (!this.showBox()) {
            return;
        }
        for (Entity entity : Client.entities()) {
            int id = Client.entityId(entity);
            double[] raw = Client.windowSnapshot(entity);
            this.windows.add(new Window(raw[0], raw[1], raw[2], raw[3], id, 0, 0, 0));
            double[] converted = Client.convertWindowSnapshot(entity);
            this.processed.add(new Window(converted[0], converted[1], converted[2], converted[3], id, 0, 0, 0));
        }
    }

    private void scanCrosshair() {
        if (windowScale <= 0.0) {
            this.setStatus(STATUS_WINDOW_CLOSED);
            return;
        }
        if (Client.crosshairEntity() != null) {
            this.setStatus(STATUS_VANILLA_AIMING);
            return;
        }
        Entity raw = Client.player();
        if (raw == null) {
            this.setStatus(STATUS_NO_PLAYER);
            return;
        }
        Entity self = Client.resolvePlayer(raw);
        if (self == null) {
            this.setStatus(STATUS_NO_PLAYER);
            return;
        }
        double reach = this.reach();
        double[] selfPosition = Client.lerpedPosition(self, 1.0f);
        double[] look = Client.lookVector(self);
        double[] rayEnd = new double[]{reach * look[0] + selfPosition[0], reach * look[1] + selfPosition[1], reach * look[2] + selfPosition[2]};
        double[] hitDistance = new double[]{0.0};
        Entity hit = Client.traceWindowTarget(selfPosition, rayEnd, hitDistance);
        if (hit == null) {
            this.setStatus(STATUS_OUTSIDE_WINDOWS);
            return;
        }
        double limit = Client.traceDistance(self, selfPosition, rayEnd, reach);
        if (hitDistance[0] <= limit) {
            this.setStatus(STATUS_ON_WINDOW);
            return;
        }
        this.setStatus(STATUS_BLOCKED);
    }

    private void clearWindows() {
        this.windows.clear();
        this.processed.clear();
    }

    private void setStatus(String value) {
        if (this.status.equals(value)) {
            return;
        }
        this.status = value;
    }

    private void refreshWindowScale() {
        windowScale = this.window();
        if (!this.isEnabled() || !Client.clientReady() || windowScale < 25.0) {
            windowScale = 0.0;
        }
        if (windowScale <= 0.0) {
            windowScale = 0.0;
        }
    }

    private double reach() {
        Setting s = this.setting("reach");
        return s == null ? 3.0 : s.getNumber();
    }

    private double window() {
        Setting s = this.setting("window");
        return s == null ? 200.0 : s.getNumber();
    }

    private boolean showBox() {
        Setting s = this.setting("show_box");
        return s != null && s.getBoolean();
    }

    private int boxColor() {
        Setting s = this.setting("box_color");
        return s == null ? -12877066 : s.getColor();
    }

    private Setting setting(String name) {
        for (Setting s : this.getSettings()) {
            if (!s.getName().equals(name)) continue;
            return s;
        }
        return null;
    }

    public static final class Window {
        private final double posX;
        private final double posY;
        private final double posZ;
        private final double time;
        private final int id;
        private final int field0;
        private final int field1;
        private final int field2;

        public Window(double posX, double posY, double posZ, double time, int id, int field0, int field1, int field2) {
            this.posX = posX;
            this.posY = posY;
            this.posZ = posZ;
            this.time = time;
            this.id = id;
            this.field0 = field0;
            this.field1 = field1;
            this.field2 = field2;
        }

        public double x() {
            return this.posX;
        }

        public double y() {
            return this.posY;
        }

        public double z() {
            return this.posZ;
        }

        public double time() {
            return this.time;
        }

        public int id() {
            return this.id;
        }

        public int field0() {
            return this.field0;
        }

        public int field1() {
            return this.field1;
        }

        public int field2() {
            return this.field2;
        }
    }
}

