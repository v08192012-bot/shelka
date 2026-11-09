/*
 * Decompiled with CFR 0.152.
 */
package client;

import java.util.ArrayList;
import java.util.List;

public class Setting {
    private final String name;
    private final Type type;
    private boolean booleanValue;
    private double numberValue;
    private double min;
    private double max;
    private double step = 1.0;
    private String modeValue;
    private final List<String> modes = new ArrayList<String>();
    private final List<String> selected = new ArrayList<String>();
    private int colorValue;
    private int secondaryColorValue;
    private int keyValue;
    private String textValue = "";
    private boolean visible = true;

    public Setting(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public static Setting bool(String name, boolean value) {
        Setting s = new Setting(name, Type.BOOLEAN);
        s.booleanValue = value;
        return s;
    }

    public static Setting number(String name, double value, double min, double max) {
        Setting s = new Setting(name, Type.NUMBER);
        s.numberValue = value;
        s.min = min;
        s.max = max;
        return s;
    }

    public static Setting number(String name, double value, double min, double max, double step) {
        Setting s = new Setting(name, Type.NUMBER);
        s.numberValue = value;
        s.min = min;
        s.max = max;
        s.step = step;
        return s;
    }

    public static Setting mode(String name, String value, String ... modes) {
        Setting s = new Setting(name, Type.MODE);
        s.modeValue = value;
        for (String m : modes) {
            s.modes.add(m);
        }
        return s;
    }

    public static Setting multi(String name, String ... modes) {
        Setting s = new Setting(name, Type.MODE);
        for (String m : modes) {
            s.modes.add(m);
        }
        if (modes.length > 0) {
            s.modeValue = modes[0];
        }
        return s;
    }

    public List<String> getSelectedModes() {
        return this.selected;
    }

    public boolean isSelected(String mode) {
        return this.selected.contains(mode);
    }

    public void setSelected(String mode, boolean value) {
        if (value) {
            if (!this.selected.contains(mode)) {
                this.selected.add(mode);
            }
        } else {
            this.selected.remove(mode);
        }
    }

    public void toggleSelected(String mode) {
        this.setSelected(mode, !this.isSelected(mode));
    }

    public static Setting color(String name, int value) {
        Setting s = new Setting(name, Type.COLOR);
        s.colorValue = value;
        return s;
    }

    public static Setting gradient(String name, int from, int to) {
        Setting s = new Setting(name, Type.GRADIENT);
        s.colorValue = from;
        s.secondaryColorValue = to;
        return s;
    }

    public static Setting key(String name, int value) {
        Setting s = new Setting(name, Type.KEYBIND);
        s.keyValue = value;
        return s;
    }

    public static Setting input(String name, String value) {
        Setting s = new Setting(name, Type.TEXT);
        s.textValue = value;
        return s;
    }

    public String getText() {
        return this.textValue;
    }

    public void setText(String value) {
        this.textValue = value;
    }

    public boolean isEmptyText() {
        return this.textValue == null || this.textValue.isEmpty();
    }

    public String getName() {
        return this.name;
    }

    public Type getType() {
        return this.type;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean value) {
        this.visible = value;
    }

    public boolean getBoolean() {
        return this.booleanValue;
    }

    public void setBoolean(boolean value) {
        this.booleanValue = value;
    }

    public double getNumber() {
        return this.numberValue;
    }

    public void setNumber(double value) {
        this.numberValue = Math.max(this.min, Math.min(this.max, value));
    }

    public double getMin() {
        return this.min;
    }

    public double getMax() {
        return this.max;
    }

    public double getStep() {
        return this.step;
    }

    public String getMode() {
        return this.modeValue;
    }

    public void setMode(String value) {
        this.modeValue = value;
    }

    public List<String> getModes() {
        return this.modes;
    }

    public int getColor() {
        return this.colorValue;
    }

    public void setColor(int value) {
        this.colorValue = value;
    }

    public int getSecondaryColor() {
        return this.secondaryColorValue;
    }

    public void setSecondaryColor(int value) {
        this.secondaryColorValue = value;
    }

    public int getKey() {
        return this.keyValue;
    }

    public void setKey(int value) {
        this.keyValue = value;
    }

    public static enum Type {
        BOOLEAN,
        NUMBER,
        MODE,
        COLOR,
        KEYBIND,
        GRADIENT,
        TEXT;

    }
}

