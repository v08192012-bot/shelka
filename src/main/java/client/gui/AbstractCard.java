/*
 * Decompiled with CFR 0.152.
 */
package client.gui;

import client.gui.Component;

public class AbstractCard
extends Component {
    public static final long VTABLE_RVA = 12585800L;
    public static final long RVA_CTOR = 1237424L;
    public static final long RVA_DTOR = 1152928L;
    public static final long RVA_DELETING_DTOR = 1152976L;
    public static final long RVA_RENDER = 1153168L;
    public static final long RVA_MOUSE_CLICKED = 1154208L;
    public static final long RVA_KEY_PRESSED = 1154272L;
    public static final long RVA_KEY_RELEASED = 1154560L;
    public static final long RVA_SET_POSITION = 1153056L;
    public static final long RVA_BLUR_FOCUS = 1153696L;
    public static final long RVA_FOCUS_CHILD_WITH_TEXT = 1154000L;
    public static final long RVA_ANIM_UPDATE = 1149040L;
    public static final long RVA_ANIM_SET_TARGET = 1148816L;
    public static final long RVA_ANIM_CTOR = 1173840L;
    public static final long RVA_RECT_ANIM_CTOR = 577680L;
    public static final long RVA_POSITION_ANIM_APPLY = 1097808L;
    public static final long RVA_SET_POSITION_ANIMATED = 1097088L;
    public static final long RVA_SET_POSITION_DIRECT = 0x10BBB0L;
    public static final long RVA_COMPONENT_DTOR = 1096704L;
    public static final long RVA_EASE_OUT_CUBIC = 577328L;
    public static final long RVA_EASE_OUT_EXPO = 1096336L;
    public static final long RVA_COMMIT_INPUT = 1393056L;
    public static final long RVA_CANCEL_INPUT = 1393296L;
    public static final long RVA_HANDLE_CHAR_INPUT = 3520912L;
    public static final long RVA_INSERT_CODE_POINT = 3522976L;
    public static final long RVA_APPEND_TO_INPUT = 3523184L;
    public static final long RVA_PLAY_CLICK_SOUND = 36640L;
    public static final long RVA_NOW_NANOS = 31568L;
    public static final long RVA_ASSIGN_STRING = 42736L;
    public static final long RVA_COPY_STRING = 74736L;
    public static final int SLOT_DTOR = 0;
    public static final int SLOT_RENDER = 8;
    public static final int SLOT_ATTACH = 16;
    public static final int SLOT_DETACH = 24;
    public static final int SLOT_MOUSE_CLICKED = 32;
    public static final int SLOT_MOUSE_RELEASED = 40;
    public static final int SLOT_MOUSE_MOVED = 48;
    public static final int SLOT_MOUSE_SCROLLED = 56;
    public static final int SLOT_KEY_PRESSED = 64;
    public static final int SLOT_CHAR_TYPED = 72;
    public static final int SLOT_KEY_RELEASED = 80;
    public static final int SLOT_SET_POSITION = 88;
    public static final int SLOT_SET_STATE = 96;
    public static final int SLOT_RENDER_CONTENT = 104;
    public static final int SLOT_ON_MOUSE = 112;
    public static final int OFF_RECT_ANIM = 32;
    public static final int OFF_ANIM_X = 72;
    public static final int OFF_ANIM_Y = 80;
    public static final int OFF_ANIMATING_POSITION = 88;
    public static final int OFF_ALPHA_ANIM = 96;
    public static final int OFF_STATE = 136;
    public static final int OFF_CHILDREN_BEGIN = 144;
    public static final int OFF_CHILDREN_END = 152;
    public static final int OFF_CHILDREN_CAP = 160;
    public static final int OFF_HAS_FOCUS = 168;
    public static final int OFF_FOCUS = 216;
    public static final int OFF_SHIFT_FLAG = 217;
    public static final int OFF_LAST_INPUT = 224;
    public static final int OFF_BLUR_CALLBACK = 288;
    public static final int OFF_KEY_CALLBACK = 352;
    public static final int OFF_CAPTURE = 416;
    public static final float ANIM_DURATION_FAST = 0.15f;
    public static final float ANIM_DURATION_MEDIUM = 0.22f;
    public static final float ANIM_DURATION_SLOW = 0.28f;
    public static final float ONE = 1.0f;
    public static final float ZERO = 0.0f;
    public static final float EASE_OUT_EXPO_FACTOR = -6.931472f;
    public static final int KEY_ENTER = 13;
    public static final int KEY_ESCAPE = 27;
    public static final int MOD_SHIFT = 2;
    public static final String NEWLINE = "\n";
    protected final Anim rectAnim = new Anim(0.0f, 0.0f, 0);
    protected Anim animX;
    protected Anim animY;
    protected final Anim alphaAnim = new Anim(0.0f, 0.22f, 0);
    protected int state;
    public static final int EASE_OUT_CUBIC = 0;
    public static final int EASE_OUT_EXPO = 1;

    public AbstractCard() {
        this.flags = 256;
        this.x = 0.0f;
        this.y = 0.0f;
        this.width = 0.0f;
        this.height = 0.0f;
        this.animX = null;
        this.animY = null;
        this.animatingPosition = false;
        this.state = 0;
        this.mouseOwned = false;
    }

    public static float ease(int easing, float t) {
        if (easing == 1) {
            return AbstractCard.easeOutExponential(t);
        }
        return AbstractCard.easeOutCubic(t);
    }

    public static float easeOutExponential(float t) {
        if (t < 1.0f) {
            return 1.0f - (float)Math.exp(t * -6.931472f);
        }
        return 1.0f;
    }

    @Override
    public void dispose() {
        this.children.clear();
        this.animX = null;
        this.animY = null;
        super.dispose();
    }

    public void renderAnimated(Object renderer, float mouseX, float mouseY, float factor) {
        this.applyPositionAnimation(this.now());
        float value = this.alphaAnim.update(this.now());
        if (0.0f < value * factor) {
            this.render(renderer, mouseX, mouseY, value * factor);
        }
    }

    @Override
    public void render(Object renderer, float mouseX, float mouseY, float alpha) {
    }

    public boolean onMouse(double mx, double my, int button) {
        return false;
    }

    public void setState(int newState, float newWidth) {
        this.width = newWidth;
        this.state = newState;
        this.height = newState == 1 ? 174.0f : 62.0f;
    }

    public void applyPositionAnimation(long time) {
        if (!this.animatingPosition || this.animX == null || this.animY == null) {
            return;
        }
        this.x = this.animX.update(time);
        this.y = this.animY.update(time);
    }

    public static void blurFocusedChildren(Component parent) {
        for (Component child : parent.children) {
            if (!child.focused) continue;
            String text = child instanceof InputChild ? ((InputChild)((Object)child)).getText() : "";
            child.focused = false;
            if (child instanceof InputChild) {
                InputChild input = (InputChild)((Object)child);
                input.setText("");
                input.blur(text);
            }
            if (child.children.isEmpty() || !(child.children.get(0) instanceof AttachAware)) continue;
            ((AttachAware)((Object)child.children.get(0))).onAttach(child);
        }
    }

    public static Component focusedChild(Component parent) {
        for (Component child : parent.children) {
            if (!child.focused) continue;
            return child;
        }
        return null;
    }

    public static boolean routeKeyPressed(Component parent, int keyCode, int modifiers) {
        Component child = AbstractCard.focusedChild(parent);
        if (child == null) {
            return false;
        }
        child.lastInputTime = parent.now() / 1000000L;
        if (keyCode == 13) {
            if (child instanceof InputChild) {
                InputChild input = (InputChild)((Object)child);
                if (input.isShiftCommit() && (modifiers & 2) != 0) {
                    input.setText(input.getText() + NEWLINE);
                    return true;
                }
                input.commit();
                return true;
            }
            return false;
        }
        if (keyCode == 27) {
            if (child instanceof InputChild) {
                ((InputChild)((Object)child)).cancel();
                return true;
            }
            return false;
        }
        if (child instanceof InputChild) {
            return AbstractCard.handleCharacterInput((InputChild)((Object)child), keyCode, modifiers);
        }
        return false;
    }

    public static boolean routeKeyReleased(Component parent, int keyCode) {
        Component child = AbstractCard.focusedChild(parent);
        if (child == null) {
            return false;
        }
        if (!(child.capture == null || child.capture instanceof KeyCapture && ((KeyCapture)((Object)child.capture)).onKey(keyCode))) {
            return false;
        }
        child.lastInputTime = parent.now() / 1000000L;
        if (child instanceof InputChild) {
            return AbstractCard.insertCodePoint((InputChild)((Object)child), keyCode);
        }
        return false;
    }

    public static boolean handleCharacterInput(InputChild child, int keyCode, int modifiers) {
        return AbstractCard.handleCharInput(child, keyCode, modifiers);
    }

    public static boolean handleCharInput(InputChild child, int keyCode, int modifiers) {
        return false;
    }

    public static boolean insertCodePoint(InputChild child, int codePoint) {
        if (codePoint < 32 || codePoint == 127) {
            return false;
        }
        child.setText(child.getText() + new String(Character.toChars(codePoint)));
        return true;
    }

    public static void focusChildWithText(Component parent, Component child, String value) {
        for (Component other : parent.children) {
            if (other == child || !(other instanceof InputChild)) continue;
            ((InputChild)((Object)other)).commit();
        }
        child.focused = true;
        if (child instanceof InputChild) {
            ((InputChild)((Object)child)).setText(value);
        }
        if (!child.children.isEmpty() && child.children.get(0) instanceof AttachAware) {
            ((AttachAware)((Object)child.children.get(0))).onAttach(child);
        }
        child.lastInputTime = parent.now() / 1000000L;
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        if (!this.mouseOwned) {
            if (this.onMouse(mx, my, button)) {
                return true;
            }
            AbstractCard.blurFocusedChildren(this);
        }
        return false;
    }

    @Override
    public boolean keyPressed(int keyCode, int modifiers) {
        return AbstractCard.routeKeyPressed(this, keyCode, modifiers);
    }

    @Override
    public boolean keyReleased(int keyCode) {
        return AbstractCard.routeKeyReleased(this, keyCode);
    }

    @Override
    public void setPosition(float px, float py) {
        if (this.alphaAnim.current == 0.0f && this.alphaAnim.target == 0.0f) {
            this.alphaAnim.setTarget(1.0f);
        }
        this.setPositionAnimated(px, py);
    }

    public void setPositionAnimated(float px, float py) {
        if (this.animX == null) {
            this.animX = new Anim(px, 0.0f, 1);
            this.animY = new Anim(py, 0.0f, 1);
        }
        if (!this.animatingPosition) {
            this.animX.snap(px);
            this.animY.snap(py);
            this.x = px;
            this.y = py;
            this.animatingPosition = true;
            return;
        }
        this.animX.setTarget(px);
        this.animY.setTarget(py);
    }

    public static final class Anim {
        public static final int OFF_FROM = 0;
        public static final int OFF_CURRENT = 4;
        public static final int OFF_TARGET = 8;
        public static final int OFF_DURATION = 12;
        public static final int OFF_EASING = 16;
        public static final int OFF_START = 24;
        public static final int OFF_RUNNING = 32;
        public float from;
        public float current;
        public float target;
        public float duration;
        public int easing;
        public long start;
        public boolean running;

        public Anim(float value, float duration, int easing) {
            this.from = value;
            this.current = value;
            this.target = value;
            this.duration = duration;
            this.easing = easing;
            this.start = System.nanoTime();
            this.running = false;
        }

        public float update(long time) {
            if (!this.running || this.duration <= 0.0f) {
                this.current = this.target;
                this.running = false;
                return this.current;
            }
            float t = (float)((double)(time - this.start) / 1.0E9) / this.duration;
            if (t <= 0.0f) {
                this.current = this.from;
                return this.current;
            }
            if (1.0f <= t) {
                this.running = false;
                this.current = this.target;
                return this.current;
            }
            this.current = AbstractCard.ease(this.easing, t) * (this.target - this.from) + this.from;
            return this.current;
        }

        public void setTarget(float value) {
            if (this.target != value) {
                float resumed;
                long time = System.nanoTime();
                this.from = resumed = this.update(time);
                this.current = resumed;
                this.start = time;
                this.target = value;
                this.running = true;
            }
        }

        public void snap(float value) {
            this.from = value;
            this.current = value;
            this.target = value;
            this.running = false;
        }
    }

    public static interface InputChild {
        public String getText();

        public void setText(String var1);

        public boolean isShiftCommit();

        public void commit();

        public void cancel();

        public void blur(String var1);
    }

    public static interface AttachAware {
        public void onAttach(Component var1);
    }

    public static interface KeyCapture {
        public boolean onKey(int var1);
    }
}

