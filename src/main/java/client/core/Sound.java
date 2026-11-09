/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import java.util.List;

public final class Sound
extends Feature {
    public static final String MODULE = "sound";
    public static final String DISPLAY = "\u0417\u043e\u0443\u043d\u0434\u0437";
    public static final int VTABLE_RVA = 12267952;
    public static final long RVA_CONSTRUCT = 2735200001392L;
    public static final long RVA_APPLY_PITCH = 2735200003136L;
    public static final long RVA_ON_ENABLE = 2735200003232L;
    public static final long RVA_ON_DISABLE = 2735200003264L;
    public static final long RVA_SLIDER_CALLBACK = 2735199988368L;
    public static final String MODE_LOW = "low";
    public static final String MODE_MID = "mid";
    public static final String MODE_HIGH = "high";
    private static final double VOLUME_DIVISOR = 100.0;
    private static final float VOLUME_MIN = 0.0f;
    private static final float VOLUME_MAX = 1.0f;
    private static final int PITCH_INDEX_DEFAULT = 1;
    private static final int PITCH_INDEX_LAST = 2;

    public Sound() {
        super(MODULE, DISPLAY, Category.Client);
        this.add(Setting.number("master_volume", 20.0, 0.0, 100.0, 1.0));
        this.add(Setting.mode("pitch", "\u0421\u0440\u0435\u0434\u043d\u0438\u0435", "\u041d\u0438\u0437\u043a\u0438\u0435", "\u0421\u0440\u0435\u0434\u043d\u0438\u0435", "\u0412\u044b\u0441\u043e\u043a\u0438\u0435"));
        this.apply();
    }

    @Override
    public void onEnable() {
        Client.setInterfaceSoundEnabled(true);
        this.apply();
    }

    @Override
    public void onDisable() {
        Client.setInterfaceSoundEnabled(false);
    }

    @Override
    public void onTick() {
        this.apply();
    }

    public void apply() {
        Client.setInterfaceSoundVolume(this.clampVolume(this.masterVolume()));
        Client.setInterfaceSoundPitch(this.pitchIndex());
    }

    public double masterVolume() {
        Setting setting = this.setting("master_volume");
        return setting == null ? 20.0 : setting.getNumber();
    }

    public float volumeFactor() {
        return this.clampVolume(this.masterVolume());
    }

    public int pitchIndex() {
        String selected;
        Setting setting = this.setting("pitch");
        List<String> modes = setting == null ? null : setting.getModes();
        int count = modes == null ? 0 : modes.size();
        String string = selected = setting == null ? null : setting.getMode();
        if (count != 0 && selected != null && selected.equals(modes.get(0))) {
            return 0;
        }
        if (count < 3 || selected == null || !selected.equals(modes.get(2))) {
            return 1;
        }
        return 2;
    }

    private float clampVolume(double raw) {
        float value = (float)(raw / 100.0);
        if (0.0f <= value) {
            if (value <= 1.0f) {
                return value;
            }
            return 1.0f;
        }
        return 0.0f;
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }
}

