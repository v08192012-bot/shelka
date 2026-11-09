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
import java.util.Collections;
import java.util.List;

public final class Protect
extends Feature {
    public static final String MODULE = "protect";
    public static final String DISPLAY = "\u041f\u0440\u043e\u0442\u0435\u0441\u0442";
    public static final int VTABLE_RVA = 12322424;
    public static final long RVA_ON_ENABLE = 2735200334816L;
    public static final long RVA_ON_DISABLE = 2735200334864L;
    public static final long RVA_ON_TICK = 2735200335552L;
    public static final long RVA_LAZY_USERNAME = 2735200335344L;
    public static final long RVA_APPLY = 2735200337488L;
    public static final long RVA_REFRESH_OTHERS = 2735200336848L;
    public static final long RVA_SNAPSHOT_INIT = 2735200354816L;
    public static final String DEFAULT_NICK = "ShelkaLegit";
    public static final String DEFAULT_OTHERS_NICK = "Player";
    private static final int MARK_TABLE_SIZE = 256;
    private static final int CASE_DELTA = 32;
    private static final int CASE_UPPER_PROBE = 191;
    private static final int CASE_LOWER_PROBE = 159;
    private static final int ALPHABET_GAP = 25;
    private static final int MIN_TAB_NAME_LENGTH = 3;
    private static final int MAX_TAB_NAME_LENGTH = 16;
    private String username = "";
    private long cachedToken;
    private final List<Entity> tracked = new ArrayList<Entity>();
    private final List<String> hiddenOthers = new ArrayList<String>();
    private final List<String> detectedOthers = new ArrayList<String>();
    private final List<String[]> boardReplaceEntries = new ArrayList<String[]>();
    private final List<String[]> nickPairs = new ArrayList<String[]>();
    private final List<String> othersNames = new ArrayList<String>();
    private String othersNickSnapshot = "";
    private boolean[] firstLetterMarks = new boolean[256];
    private boolean hidePasswordSnapshot;

    public Protect() {
        super(MODULE, DISPLAY, Category.Player);
        this.add(Setting.bool("hide_nick", true));
        this.add(Setting.input("custom_nick", DEFAULT_NICK));
        this.add(Setting.bool("hide_skin", false));
        this.add(Setting.mode("skin", "Alex", "Alex", "Ari", "Efe", "Kai", "Makena", "Noor", "Steve", "Sunny", "Zuri"));
        this.add(Setting.bool("slim_skin", false));
        this.add(Setting.bool("friend_skin", false));
        this.add(Setting.bool("all_skin", false));
        this.add(Setting.bool("hide_friends", true));
        this.add(Setting.bool("hide_donate", false));
        this.add(Setting.input("donate_text", ""));
        this.add(Setting.color("donate_color", -10682526));
        this.add(Setting.bool("hide_others", false));
        this.add(Setting.input("others_nick", DEFAULT_OTHERS_NICK));
        this.add(Setting.bool("hide_password", true));
        this.add(Setting.bool("fake_board", false));
        this.add(Setting.input("fake_anarchy", ""));
        this.add(Setting.input("fake_tokens", ""));
        this.add(Setting.input("fake_rank", ""));
        this.add(Setting.color("fake_rank_color", -10682526));
        this.add(Setting.input("board_replace", ""));
    }

    @Override
    public void onEnable() {
        this.username = "";
        this.apply();
    }

    @Override
    public void onDisable() {
        this.username = "";
        this.tracked.clear();
        this.hiddenOthers.clear();
        this.apply();
    }

    @Override
    public void onTick() {
        String fetched;
        String fetched2;
        if (this.username.isEmpty() && (fetched2 = Client.currentUsername()) != null && !fetched2.isEmpty()) {
            this.username = fetched2;
            this.apply();
        }
        this.tracked.clear();
        String name = "";
        Entity self = Client.player();
        if (self != null && (fetched = Client.playerName(self)) != null) {
            name = fetched;
        }
        if (this.hideSkin() && !this.allSkin()) {
            Entity selfEntity = Client.entityByName(name);
            if (selfEntity != null) {
                this.tracked.add(selfEntity);
            }
            if (this.friendSkin()) {
                Client.forEachFriendName(friendName -> {
                    Entity friendEntity = Client.entityByName(friendName);
                    if (friendEntity != null) {
                        this.tracked.add(friendEntity);
                    }
                });
            }
        }
        boolean othersChanged = this.hideOthers() && this.refreshHiddenOthers();
        long token = Client.boardToken();
        if (!name.equals(this.username) || token != this.cachedToken || othersChanged) {
            this.username = name;
            this.cachedToken = token;
            this.apply();
        }
    }

    private boolean refreshHiddenOthers() {
        this.detectedOthers.clear();
        for (String tabName : Client.tabPlayerNames()) {
            int length;
            if (tabName == null || (length = tabName.length()) < 3 || length > 16 || this.equalsCased(tabName, this.username) || Client.isFriendName(tabName)) continue;
            this.detectedOthers.add(this.asciiLower(tabName));
        }
        Collections.sort(this.detectedOthers);
        for (int i = this.detectedOthers.size() - 1; i > 0; --i) {
            if (!this.detectedOthers.get(i).equals(this.detectedOthers.get(i - 1))) continue;
            this.detectedOthers.remove(i);
        }
        if (this.detectedOthers.equals(this.hiddenOthers)) {
            return false;
        }
        this.hiddenOthers.clear();
        this.hiddenOthers.addAll(this.detectedOthers);
        return true;
    }

    private void apply() {
        boolean ready = Client.protectGateOpen(this);
        ArrayList<String[]> pairs = new ArrayList<String[]>();
        ArrayList<String> others = new ArrayList<String>();
        String othersNick = "";
        boolean passwordHidden = false;
        if (ready) {
            if (this.hideNick() && !this.username.isEmpty()) {
                String replacement = this.customNick();
                if (replacement.isEmpty()) {
                    replacement = DEFAULT_NICK;
                }
                pairs.add(new String[]{this.username, replacement});
            }
            if (this.hideFriends()) {
                Client.forEachFriendName(friendName -> pairs.add(new String[]{friendName, Client.friendDisplayName(friendName)}));
            }
            if (this.fakeBoard()) {
                pairs.addAll(this.boardReplaceEntries);
            }
            if (this.hideOthers() && !this.hiddenOthers.isEmpty()) {
                others.addAll(this.hiddenOthers);
                othersNick = this.othersNick();
                if (othersNick.isEmpty()) {
                    othersNick = DEFAULT_OTHERS_NICK;
                }
            }
            passwordHidden = this.hidePassword();
        }
        this.nickPairs.clear();
        this.nickPairs.addAll(pairs);
        this.othersNames.clear();
        this.othersNames.addAll(others);
        this.othersNickSnapshot = othersNick;
        this.hidePasswordSnapshot = passwordHidden;
        this.markFirstLetters(pairs);
        Client.protectApply(this);
    }

    private void markFirstLetters(List<String[]> pairs) {
        boolean[] marks = new boolean[256];
        for (String[] pair : pairs) {
            if (pair[0].isEmpty()) continue;
            int first = pair[0].charAt(0) & 0xFF;
            int lower = first + 32;
            if (25 < (first + 191 & 0xFF)) {
                lower = first;
            }
            int upper = first - 32;
            if (25 < (first + 159 & 0xFF)) {
                upper = first;
            }
            marks[lower & 0xFF] = true;
            marks[upper & 0xFF] = true;
        }
        this.firstLetterMarks = marks;
    }

    private boolean equalsCased(String left, String right) {
        return this.asciiLower(left).equals(this.asciiLower(right));
    }

    private String asciiLower(String value) {
        StringBuilder builder = new StringBuilder(value.length());
        for (int i = 0; i < value.length(); ++i) {
            char c = value.charAt(i);
            builder.append(c >= 'A' && c <= 'Z' ? (char)(c + 32) : c);
        }
        return builder.toString();
    }

    public List<Entity> tracked() {
        return this.tracked;
    }

    public String cachedName() {
        return this.username;
    }

    public long cachedToken() {
        return this.cachedToken;
    }

    public List<String> hiddenOthers() {
        return this.hiddenOthers;
    }

    public List<String> detectedOthers() {
        return this.detectedOthers;
    }

    public List<String[]> boardReplaceEntries() {
        return this.boardReplaceEntries;
    }

    public List<String[]> nickPairs() {
        return this.nickPairs;
    }

    public List<String> othersNames() {
        return this.othersNames;
    }

    public String othersNickSnapshot() {
        return this.othersNickSnapshot;
    }

    public boolean[] firstLetterMarks() {
        return this.firstLetterMarks;
    }

    public boolean hidePasswordSnapshot() {
        return this.hidePasswordSnapshot;
    }

    private boolean hideNick() {
        return this.flag("hide_nick");
    }

    private String customNick() {
        return this.text("custom_nick");
    }

    private boolean hideSkin() {
        return this.flag("hide_skin");
    }

    private boolean friendSkin() {
        return this.flag("friend_skin");
    }

    private boolean allSkin() {
        return this.flag("all_skin");
    }

    private boolean hideFriends() {
        return this.flag("hide_friends");
    }

    private boolean hideOthers() {
        return this.flag("hide_others");
    }

    private String othersNick() {
        return this.text("others_nick");
    }

    private boolean hidePassword() {
        return this.flag("hide_password");
    }

    private boolean fakeBoard() {
        return this.flag("fake_board");
    }

    private boolean flag(String name) {
        Setting s = this.setting(name);
        return s != null && s.getBoolean();
    }

    private String text(String name) {
        Setting s = this.setting(name);
        return s == null || s.getText() == null ? "" : s.getText();
    }

    private Setting setting(String name) {
        for (Setting s : this.getSettings()) {
            if (!s.getName().equals(name)) continue;
            return s;
        }
        return null;
    }
}

