/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import java.util.ArrayList;
import java.util.List;

public final class ShulkerPreview
extends Feature {
    public static final String MODULE = "shulker_preview";
    public static final String DISPLAY = "\u0417\u0445\u0443\u043b\u043a\u0435\u0440\u041f\u0440\u0435\u0432\u0438\u0435\u0448";
    public static final int VTABLE_RVA = 12351080;
    public static final long RVA_CONSTRUCT = 2735200530656L;
    public static final long RVA_ON_TICK = 2735200531744L;
    public static final long RVA_ON_RENDER = 2735200532272L;
    public static final long RVA_HAS_PREVIEW = 2735200530560L;
    public static final long RVA_RESET = 2735200530592L;
    public static final int PREVIEW_BIND_DEFAULT = 164;
    public static final int MAX_PREVIEW_SLOTS = 54;
    private final List<Object> contents = new ArrayList<Object>();
    private int previewId = -1;

    public ShulkerPreview() {
        super(MODULE, DISPLAY, Category.Render);
        this.add(Setting.bool("bind_only", false));
        this.add(Setting.key("preview_bind", 164));
    }

    public List<Object> contents() {
        return this.contents;
    }

    public int previewId() {
        return this.previewId;
    }

    public boolean hasPreview() {
        return !this.contents.isEmpty();
    }

    @Override
    public void onEnable() {
        this.reset();
    }

    @Override
    public void onDisable() {
        this.reset();
    }

    public void reset() {
        this.contents.clear();
        this.previewId = -1;
    }

    @Override
    public void onTick() {
        Object stack;
        this.reset();
        if (this.bindOnly()) {
            int key;
            Setting bind = this.setting("preview_bind");
            int n = key = bind == null ? 0 : bind.getKey();
            if (key == 0) {
                return;
            }
            if (!Client.isBindTriggered(key, 0)) {
                return;
            }
        }
        if ((stack = Client.hoveredStack()) == null) {
            return;
        }
        List<Object> slots = Client.containerContents(stack);
        if (slots.size() > 54) {
            slots = slots.subList(0, 54);
        }
        boolean any = false;
        for (Object slot : slots) {
            this.contents.add(slot);
            if (!any && slot == null) continue;
            any = true;
        }
        if (!any) {
            this.reset();
            return;
        }
        this.previewId = Client.openScreenId();
    }

    @Override
    public void onRender() {
        if (this.contents.isEmpty()) {
            return;
        }
        Client.renderShulkerPreview(this.contents);
    }

    public boolean bindOnly() {
        Setting setting = this.setting("bind_only");
        return setting != null && setting.getBoolean();
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }
}

