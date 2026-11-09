/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.Setting;
import client.gui.Component;

public class AbstractButton
extends Component {
    public static final long VTABLE_RVA = 0L;
    public static final long RVA_RECT_ANIM_INIT = 2735200260240L;
    public static final long RVA_MOUSE_CLICKED = 2735200886336L;
    public static final long RVA_SET_POSITION = 2735200779184L;
    public static final long RVA_EASE_OUT_CUBIC = 2735200259888L;
    public static final long RVA_ANIM_INIT = 2735200856400L;
    public static final long RVA_ANIM_SET_TARGET = 2735200831376L;
    public static final long RVA_ANIM_ADVANCE = 2735200831600L;
    public static final long RVA_PLAY_EFFECT = 2735199719200L;
    public static final long RVA_NOW = 2735199714128L;
    public static final int SLOT_DTOR = 0;
    public static final int SLOT_DELETING_DTOR = 1;
    public static final int SLOT_HIDDEN_A = 2;
    public static final int SLOT_HIDDEN_B = 3;
    public static final int SLOT_MOUSE_CLICKED = 4;
    public static final int SLOT_MOUSE_RELEASED = 5;
    public static final int SLOT_MOUSE_MOVED = 6;
    public static final int SLOT_MOUSE_SCROLLED = 7;
    public static final int SLOT_KEY_PRESSED = 8;
    public static final int SLOT_KEY_RELEASED = 9;
    public static final int SLOT_CHAR_TYPED = 10;
    public static final int SLOT_SET_POSITION = 11;
    public static final int SLOT_ON_CLICK = 12;
    public static final int OFF_VTABLE = 0;
    public static final int OFF_X = 8;
    public static final int OFF_Y = 12;
    public static final int OFF_WIDTH = 16;
    public static final int OFF_HEIGHT = 20;
    public static final int OFF_FLAGS = 24;
    public static final int OFF_RECT_ANIM = 32;
    public static final int OFF_ANIM_X = 72;
    public static final int OFF_ANIM_Y = 80;
    public static final int OFF_ANIMATING_POSITION = 88;
    public static final int FLAGS_INIT = 256;
    public static final int FLAGS_LOW_BYTE_MASK = 255;
    public static final float ANIM_VALUE_OFF = 0.0f;
    public static final float ANIM_VALUE_ON = 1.0f;
    public static final float ANIM_DURATION_FAST = 0.15f;
    public static final float ANIM_DURATION_SLOW = 0.22f;
    public static final int VK_DELETE = 46;
    public static final int VK_ESCAPE = 27;
    public static final int MOUSE_CODE_NONE = 0;
    public static final int MOUSE_CODE_LEFT = 1;
    public static final int MOUSE_CODE_RIGHT = 2;
    public static final int MOUSE_CODE_MIDDLE = 4;
    public static final int MOUSE_CODE_X1 = 5;
    public static final int MOUSE_CODE_X2 = 6;
    public static final int CLICK_EFFECT_LIMIT = 20;
    public static final int CLICK_EFFECT_REPEAT_ID = 17;
    public static final long CLICK_EFFECT_REPEAT_DELAY = 35000000L;
    public static final int CLICK_EFFECT_SLOT_COUNT = 6;
    public static final int CLICK_EFFECT_DEF_STRIDE = 152;
    public static final int CLICK_EFFECT_SLOT_STRIDE = 32;
    public static final int CLICK_EFFECT_DEF_FORMAT_A = 8;
    public static final int CLICK_EFFECT_DEF_FORMAT_B = 16;
    public static final boolean EFFECTS_GATE_A_INIT = false;
    public static final boolean EFFECTS_GATE_B_INIT = false;
    public static final float EFFECTS_SCALE_INIT = 0.49f;
    public static final int EFFECTS_VARIANT_INIT = 2;
    public static final long EFFECTS_LAST_TIME_INIT = 0L;
    public static boolean effectsGateA = false;
    public static boolean effectsGateB = false;
    public static float effectsScale = 0.49f;
    public static int effectsVariant = 2;
    public static long effectsLastTime = 0L;
    public static final int[] effectsCursor = new int[20];
    public static final int BIND_TARGET_KEY_OFFSET = 232;
    public static final int BIND_TARGET_MODS_OFFSET = 236;
    public static final int BIND_TARGET_LISTENER_OFFSET = 224;
    protected Setting bindTarget;
    protected Runnable onChanged;

    public AbstractButton() {
        this.flags = 256;
        this.x = 0.0f;
        this.y = 0.0f;
        this.width = 0.0f;
        this.height = 0.0f;
        this.animatingPosition = false;
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (button == 0 && this.contains(mx, my)) {
            return this.onClick(mx, my);
        }
        return false;
    }

    public boolean onClick(double mx, double my) {
        return false;
    }

    public Setting getBindTarget() {
        return this.bindTarget;
    }

    public void setBindTarget(Setting target) {
        this.bindTarget = target;
    }

    public Runnable getOnChanged() {
        return this.onChanged;
    }

    public void setOnChanged(Runnable callback) {
        if (this.onChanged == callback) {
            return;
        }
        this.onChanged = callback;
    }

    protected void notifyChanged() {
        if (this.onChanged != null) {
            this.onChanged.run();
        }
    }

    protected boolean bindIsEmpty() {
        return this.bindTarget == null || this.bindTarget.getKey() == 0;
    }

    protected void assignBind(int key, int mods) {
        if (this.bindTarget.getKey() == key && mods == 0) {
            return;
        }
        this.bindTarget.setKey(key);
        if (this.onChanged != null) {
            this.onChanged.run();
        }
    }

    protected void clearBind() {
        if (this.bindTarget == null) {
            return;
        }
        if (this.bindTarget.getKey() == 0) {
            return;
        }
        this.bindTarget.setKey(0);
        if (this.onChanged != null) {
            this.onChanged.run();
        }
    }

    protected static int mouseButtonCode(int button) {
        if (button == 0) {
            return 1;
        }
        if (button == 1) {
            return 2;
        }
        if (button == 2) {
            return 4;
        }
        if (button == 3) {
            return 5;
        }
        if (button == 4) {
            return 6;
        }
        return 0;
    }

    protected static boolean isModifierKey(int key) {
        if (key >= 16 && key < 19) {
            return true;
        }
        return key >= 160 && key < 166;
    }

    protected static void playClickEffect(int id) {
        if (!effectsGateA || !effectsGateB || effectsScale <= 0.0f || id >= 20) {
            return;
        }
        long stamp = effectsLastTime;
        if (id == 17) {
            long time = System.nanoTime();
            if (time - effectsLastTime < 35000000L) {
                return;
            }
            stamp = time;
        }
        effectsLastTime = stamp;
        int cursor = effectsCursor[id];
        AbstractButton.effectsCursor[id] = (cursor + 1) % 6;
        AbstractButton.spawnClickEffect(id, effectsVariant, cursor);
    }

    private static void spawnClickEffect(int id, int variant, int cursor) {
    }

    public static final class Anim {
        public static final int OFF_FROM = 0;
        public static final int OFF_VALUE = 4;
        public static final int OFF_TARGET = 8;
        public static final int OFF_DURATION = 12;
        public static final int OFF_EASING = 16;
        public static final int OFF_TIME = 24;
        public static final int OFF_RUNNING = 32;
        public static final int SIZE = 40;
        public float from;
        public float value;
        public float target;
        public float duration;
        public long time;
        public boolean running;

        public Anim(float from, float duration) {
            this.from = from;
            this.value = from;
            this.target = from;
            this.duration = duration;
            this.time = 0L;
            this.running = false;
        }

        public boolean isRunning() {
            return this.running;
        }

        public void reset(float from, float duration) {
            this.from = from;
            this.value = from;
            this.target = from;
            this.duration = duration;
            this.time = 0L;
            this.running = false;
        }

        public void animateTo(float newTarget) {
            if (this.target == newTarget) {
                return;
            }
            long now = System.nanoTime();
            this.advance(now);
            this.time = now;
            this.from = this.value;
            this.target = newTarget;
            this.running = true;
        }

        public void advance(long now) {
            if (!this.running || this.duration <= 0.0f) {
                this.value = this.target;
                this.running = false;
                return;
            }
            float t = (float)((double)(now - this.time) / 1.0E9) / this.duration;
            if (t <= 0.0f) {
                this.value = this.from;
                return;
            }
            if (t >= 1.0f) {
                this.running = false;
                this.value = this.target;
                return;
            }
            this.value = Component.easeOutCubic(t) * (this.target - this.from) + this.from;
        }
    }
}

