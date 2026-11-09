/*
 * Decompiled with CFR 0.152.
 */
package client.core;

import client.Category;
import client.Feature;
import client.Setting;
import client.mc.Client;
import client.mc.Entity;

public final class NoRender
extends Feature {
    public static final String MODULE = "no_render";
    public static final String DISPLAY = "\u041d\u043e\u0420\u0435\u043d\u0434\u0435\u0440";
    public static final int VTABLE_RVA = 12579200;
    public static final long RVA_CONSTRUCT = 2735200717200L;
    public static final long RVA_ON_ENABLE = 2735200723344L;
    public static final long RVA_ON_DISABLE = 2735200723680L;
    public static final long RVA_ON_TICK = 2735200724384L;
    public static final long RVA_REFRESH_OPTIONS = 2735200720896L;
    public static final long RVA_EFFECT_SUPPRESS = 2735200721424L;
    public static final long RVA_LAMBDA_XP = 2735200727040L;
    public static final String KEY_SCOREBOARD = "scoreboard";
    public static final String KEY_FIRE = "fire";
    public static final String KEY_IN_WALL = "in_wall";
    public static final String KEY_FROST = "frost";
    public static final String KEY_NAUSEA = "nausea";
    public static final String KEY_BLINDNESS = "blindness";
    public static final String KEY_BUBBLES = "bubbles";
    public static final String KEY_BOSS_BAR = "boss_bar";
    public static final String KEY_EFFECTS = "effects";
    public static final String KEY_ATTACK_INDICATOR = "attack_indicator";
    public static final String KEY_EXPLOSION_PARTICLES = "explosion_particles";
    public static final String KEY_BORDER = "border";
    public static final String KEY_WEATHER = "weather";
    public static final String KEY_XP_BOTTLES = "xp_bottles";
    public static final String KEY_SHADOWS = "shadows";
    public static final String KEY_FOG = "fog";
    public static final String KEY_WITHER_HEARTS = "wither_hearts";
    public static final String KEY_BLOCK_PARTICLES = "block_particles";
    public static final String KEY_DARKNESS = "darkness";
    public static final String KEY_BOB = "bob";
    public static final String KEY_HURT_CAM = "hurt_cam";
    public static final String KEY_VIGNETTE = "vignette";
    public static final String KEY_GLOW = "glow";
    public static final String OPTION_BOB_VIEW = "bobView";
    public static final String OPTION_ENTITY_SHADOWS = "entityShadows";
    public static final String OPTION_DAMAGE_TILT = "damageTiltStrength";
    public static final String OPTION_FOG_ENABLED = "fogEnabled";
    public static final String OPTION_VIGNETTE = "vignette";
    public static final String OPTION_ATTACK_INDICATOR = "attackIndicator";
    public static final String EFFECT_DARKNESS = "darkness";
    public static final String EFFECT_BLINDNESS = "blindness";
    public static final String EFFECT_NAUSEA = "nausea";
    public static final String EFFECT_WITHER = "wither";
    public static final double BORDER_SIZE = 6.0E7;
    public static final float WEATHER_LEVEL = 0.0f;
    private static NoRender active;
    private boolean bossBar;
    private boolean bubbles;
    private boolean blockParticles;
    private boolean explosionParticles;
    private boolean glow;
    private boolean effects;
    private boolean frost;
    private boolean inWall;
    private boolean fire;
    private boolean blindness;
    private boolean darkness;
    private boolean nausea;
    private boolean witherHearts;
    private boolean bobApplied;
    private boolean bobSaved;
    private boolean shadowsApplied;
    private boolean shadowsSaved;
    private boolean hurtCamApplied;
    private double hurtCamSaved;
    private boolean fogApplied;
    private boolean fogSaved;
    private boolean vignetteApplied;
    private boolean vignetteSaved;
    private boolean indicatorApplied;
    private int indicatorSaved;
    private String scoreboardTitle = "";
    private String scoreboardTeam = "";

    public NoRender() {
        super(MODULE, DISPLAY, Category.Movement);
        this.add(Setting.bool("options", true));
        this.add(Setting.bool(KEY_SCOREBOARD, true));
        this.add(Setting.bool(KEY_FIRE, true));
        this.add(Setting.bool(KEY_IN_WALL, true));
        this.add(Setting.bool(KEY_FROST, true));
        this.add(Setting.bool("nausea", true));
        this.add(Setting.bool("blindness", true));
        this.add(Setting.bool(KEY_BUBBLES, true));
        this.add(Setting.bool(KEY_BOSS_BAR, true));
        this.add(Setting.bool(KEY_EFFECTS, true));
        this.add(Setting.bool(KEY_ATTACK_INDICATOR, true));
        this.add(Setting.bool(KEY_EXPLOSION_PARTICLES, true));
        this.add(Setting.bool(KEY_BORDER, true));
        this.add(Setting.bool(KEY_WEATHER, true));
        this.add(Setting.bool(KEY_XP_BOTTLES, true));
        this.add(Setting.bool(KEY_SHADOWS, true));
        this.add(Setting.bool(KEY_FOG, true));
        this.add(Setting.bool(KEY_WITHER_HEARTS, true));
        this.add(Setting.bool(KEY_BLOCK_PARTICLES, true));
        this.add(Setting.bool("darkness", true));
        this.add(Setting.bool(KEY_BOB, true));
        this.add(Setting.bool(KEY_HURT_CAM, true));
        this.add(Setting.bool("vignette", true));
        this.add(Setting.bool(KEY_GLOW, true));
    }

    public static NoRender active() {
        return active;
    }

    public boolean suppresses(String key) {
        if (KEY_BOSS_BAR.equals(key)) {
            return this.bossBar;
        }
        if (KEY_BUBBLES.equals(key)) {
            return this.bubbles;
        }
        if (KEY_BLOCK_PARTICLES.equals(key)) {
            return this.blockParticles;
        }
        if (KEY_EXPLOSION_PARTICLES.equals(key)) {
            return this.explosionParticles;
        }
        if (KEY_GLOW.equals(key)) {
            return this.glow;
        }
        if (KEY_EFFECTS.equals(key)) {
            return this.effects;
        }
        if (KEY_FROST.equals(key)) {
            return this.frost;
        }
        if (KEY_IN_WALL.equals(key)) {
            return this.inWall;
        }
        if (KEY_FIRE.equals(key)) {
            return this.fire;
        }
        if ("blindness".equals(key)) {
            return this.blindness;
        }
        if ("darkness".equals(key)) {
            return this.darkness;
        }
        if ("nausea".equals(key)) {
            return this.nausea;
        }
        if (KEY_WITHER_HEARTS.equals(key)) {
            return this.witherHearts;
        }
        return false;
    }

    public String scoreboardTitle() {
        return this.scoreboardTitle;
    }

    public String scoreboardTeam() {
        return this.scoreboardTeam;
    }

    @Override
    public void onEnable() {
        this.indicatorApplied = false;
        this.vignetteApplied = false;
        this.hurtCamApplied = false;
        this.fogApplied = false;
        this.shadowsApplied = false;
        this.bobApplied = false;
        this.scoreboardTitle = "";
        this.scoreboardTeam = "";
        this.refreshOptionFlags();
        active = this;
    }

    @Override
    public void onDisable() {
        active = null;
        if (this.bobApplied) {
            Client.setGameOptionBoolean(OPTION_BOB_VIEW, this.bobSaved);
        }
        if (this.shadowsApplied) {
            Client.setGameOptionBoolean(OPTION_ENTITY_SHADOWS, this.shadowsSaved);
        }
        if (this.fogApplied) {
            Client.setGameOptionBoolean(OPTION_FOG_ENABLED, this.fogSaved);
        }
        if (this.hurtCamApplied) {
            Client.setGameOptionDouble(OPTION_DAMAGE_TILT, this.hurtCamSaved);
        }
        if (this.vignetteApplied) {
            Client.setGameOptionBoolean("vignette", this.vignetteSaved);
        }
        if (this.indicatorApplied) {
            Client.setGameOptionInt(OPTION_ATTACK_INDICATOR, this.indicatorSaved);
        }
        this.indicatorApplied = false;
        this.vignetteApplied = false;
        this.hurtCamApplied = false;
        this.fogApplied = false;
        this.shadowsApplied = false;
        this.bobApplied = false;
        Client.clearScoreboardCache();
        this.scoreboardTitle = "";
        this.scoreboardTeam = "";
        this.bossBar = false;
        this.bubbles = false;
        this.blockParticles = false;
        this.explosionParticles = false;
        this.glow = false;
        this.effects = false;
        this.frost = false;
        this.inWall = false;
        this.fire = false;
        this.blindness = false;
        this.darkness = false;
        this.nausea = false;
        this.witherHearts = false;
    }

    @Override
    public void onTick() {
        this.refreshOptionFlags();
        this.applyBob();
        this.applyShadows();
        this.applyHurtCam();
        this.applyFog();
        this.applyVignette();
        this.applyAttackIndicator();
        if (!Client.inGame()) {
            return;
        }
        this.applyEffectSuppression();
        this.applyWeather();
        this.applyBorder();
        this.applyScoreboard();
        if (this.option(KEY_XP_BOTTLES)) {
            Client.forEachEntity(this::hideXpOrb);
        }
    }

    public void refreshOptionFlags() {
        this.bossBar = this.option(KEY_BOSS_BAR);
        this.bubbles = this.option(KEY_BUBBLES);
        this.blockParticles = this.option(KEY_BLOCK_PARTICLES);
        this.explosionParticles = this.option(KEY_EXPLOSION_PARTICLES);
        this.glow = this.option(KEY_GLOW);
        this.effects = this.option(KEY_EFFECTS);
        this.frost = this.option(KEY_FROST);
        this.inWall = this.option(KEY_IN_WALL);
        this.fire = this.option(KEY_FIRE);
        this.blindness = this.option("blindness");
        this.darkness = this.option("darkness");
        this.nausea = this.option("nausea");
        this.witherHearts = this.option(KEY_WITHER_HEARTS);
    }

    private void applyBob() {
        if (!this.option(KEY_BOB)) {
            if (this.bobApplied) {
                Client.setGameOptionBoolean(OPTION_BOB_VIEW, this.bobSaved);
                this.bobApplied = false;
            }
            return;
        }
        if (!this.bobApplied) {
            this.bobSaved = Client.gameOptionBoolean(OPTION_BOB_VIEW);
            this.bobApplied = true;
        }
        if (Client.gameOptionBoolean(OPTION_BOB_VIEW)) {
            Client.setGameOptionBoolean(OPTION_BOB_VIEW, false);
        }
    }

    private void applyShadows() {
        if (!this.option(KEY_SHADOWS)) {
            if (this.shadowsApplied) {
                Client.setGameOptionBoolean(OPTION_ENTITY_SHADOWS, this.shadowsSaved);
                this.shadowsApplied = false;
            }
            return;
        }
        if (!this.shadowsApplied) {
            this.shadowsSaved = Client.gameOptionBoolean(OPTION_ENTITY_SHADOWS);
            this.shadowsApplied = true;
        }
        if (Client.gameOptionBoolean(OPTION_ENTITY_SHADOWS)) {
            Client.setGameOptionBoolean(OPTION_ENTITY_SHADOWS, false);
        }
    }

    private void applyHurtCam() {
        if (!this.option(KEY_HURT_CAM)) {
            if (this.hurtCamApplied) {
                Client.setGameOptionDouble(OPTION_DAMAGE_TILT, this.hurtCamSaved);
                this.hurtCamApplied = false;
            }
            return;
        }
        if (!this.hurtCamApplied) {
            this.hurtCamSaved = Client.gameOptionDouble(OPTION_DAMAGE_TILT);
            this.hurtCamApplied = true;
        }
        if (Client.gameOptionDouble(OPTION_DAMAGE_TILT) != 0.0) {
            Client.setGameOptionDouble(OPTION_DAMAGE_TILT, 0.0);
        }
    }

    private void applyFog() {
        if (!this.option(KEY_FOG)) {
            if (this.fogApplied) {
                Client.setGameOptionBoolean(OPTION_FOG_ENABLED, this.fogSaved);
                this.fogApplied = false;
            }
            return;
        }
        if (!this.fogApplied) {
            this.fogSaved = Client.gameOptionBoolean(OPTION_FOG_ENABLED);
            this.fogApplied = true;
        }
        if (Client.gameOptionBoolean(OPTION_FOG_ENABLED)) {
            Client.setGameOptionBoolean(OPTION_FOG_ENABLED, false);
        }
    }

    private void applyVignette() {
        if (!this.option("vignette")) {
            if (this.vignetteApplied) {
                Client.setGameOptionBoolean("vignette", this.vignetteSaved);
                this.vignetteApplied = false;
            }
            return;
        }
        if (!this.vignetteApplied) {
            this.vignetteSaved = Client.gameOptionBoolean("vignette");
            this.vignetteApplied = true;
        }
        if (Client.gameOptionBoolean("vignette")) {
            Client.setGameOptionBoolean("vignette", false);
        }
    }

    private void applyAttackIndicator() {
        if (!this.option(KEY_ATTACK_INDICATOR)) {
            if (this.indicatorApplied) {
                Client.setGameOptionInt(OPTION_ATTACK_INDICATOR, this.indicatorSaved);
                this.indicatorApplied = false;
            }
            return;
        }
        if (!this.indicatorApplied) {
            this.indicatorSaved = Client.gameOptionInt(OPTION_ATTACK_INDICATOR);
            this.indicatorApplied = true;
        }
        if (Client.gameOptionInt(OPTION_ATTACK_INDICATOR) != 0) {
            Client.setGameOptionInt(OPTION_ATTACK_INDICATOR, 0);
        }
    }

    private void applyEffectSuppression() {
        Entity self = Client.localPlayer();
        if (this.fire && self != null) {
            Client.setRemainingFireTicks(self, 0);
            Client.setEntityFlag(self, 0, false);
        }
        if (this.darkness) {
            Client.removeStatusEffect(self, "darkness");
        }
        if (this.blindness) {
            Client.removeStatusEffect(self, "blindness");
        }
        if (this.nausea) {
            Client.removeStatusEffect(self, "nausea");
        }
        if (this.witherHearts) {
            Client.removeStatusEffect(self, EFFECT_WITHER);
        }
    }

    private void applyWeather() {
        if (!this.option(KEY_WEATHER)) {
            return;
        }
        Client.setRainLevel(0.0f);
        Client.setThunderLevel(0.0f);
    }

    private void applyBorder() {
        if (!this.option(KEY_BORDER)) {
            return;
        }
        Client.setWorldBorderSize(6.0E7);
    }

    private void applyScoreboard() {
        if (!this.option(KEY_SCOREBOARD)) {
            if (!this.scoreboardTitle.isEmpty() || !this.scoreboardTeam.isEmpty()) {
                Client.clearScoreboardCache();
                this.scoreboardTitle = "";
                this.scoreboardTeam = "";
            }
            return;
        }
        String title = Client.scoreboardSidebarTitle();
        String team = Client.scoreboardTeamTitle();
        if (!title.isEmpty()) {
            this.scoreboardTitle = title;
        }
        if (!team.isEmpty()) {
            this.scoreboardTeam = team;
        }
    }

    private void hideXpOrb(Entity entity) {
        if (!Client.isExperienceOrb(entity)) {
            return;
        }
        Client.removeEntityLocal(entity);
    }

    private boolean option(String key) {
        Setting setting = this.setting(key);
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

