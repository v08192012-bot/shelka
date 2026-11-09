/*
 * Decompiled with CFR 0.152.
 */
package client.mc;

import client.Feature;
import client.Setting;
import client.mc.BlockPos;
import client.mc.Entity;
import client.mc.ItemStack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public final class Client {
    public static final long RVA_SCREEN_OPEN = 2735202245184L;
    public static final long RVA_BREAKING_BLOCK = 2735202258928L;
    public static final long RVA_CONTAINER_SCREEN = 2735202246352L;
    public static final long RVA_INVENTORY_SCREEN = 2735202248720L;
    public static final long RVA_OPEN_SCREEN_TITLE = 2735202249808L;
    public static final long RVA_OPEN_SCREEN_ID = 2735202247792L;
    public static final long RVA_AUCTION_SCREEN = 2735200259984L;
    public static final long RVA_ENTITY_REMOVED = 2735202494256L;
    public static final long RVA_SAME_ENTITY = 2735202491424L;
    public static final long RVA_LINE_OF_SIGHT = 2735202778912L;
    public static final long RVA_FOR_EACH_PLAYER = 2735202781728L;
    public static final long RVA_FOR_EACH_ENTITY = 2735202782384L;
    public static final long RVA_ENTITY_BY_NAME = 2735203280848L;
    public static final long RVA_LOADED_CHUNKS = 2735202054240L;
    public static final long RVA_COLLECT_BLOCKS = 2735202052128L;
    public static final long RVA_WORLD_OF = 2735202057840L;
    public static final long RVA_BLOCK_STATE = 2735202051040L;
    public static final long RVA_CLIENT_WORLD = 2735202040624L;
    public static final long RVA_SINGLEPLAYER_WORLD = 2735202026176L;
    public static final long RVA_WORLD_FOR = 2735202020240L;
    public static final long RVA_TRACKED_BLOCK = 2735199824368L;
    public static final long RVA_TICK_HOOK_ADD = 2735202267600L;
    public static final long RVA_TICK_HOOK_REMOVE = 2735200620992L;
    public static final long RVA_CLOSE_SCREEN = 2735202251472L;
    public static final long RVA_CONTAINER_SIZE = 2735202554880L;
    public static final long RVA_CONTAINER_SYNC_ID = 2735202554768L;
    public static final long RVA_SLOT_STACK = 2735202555152L;
    public static final long RVA_STACK_ITEM_ID = 2735202490048L;
    public static final long RVA_SLOT_PRESENT = 2735202555920L;
    public static final long RVA_CLICK_SLOT = 2735202549968L;
    public static final long RVA_CONTAINER_SEARCH = 2735202557120L;
    public static final long RVA_REFRESH_RATE = 2735200695024L;
    public static final long RVA_SET_FRAME_LIMIT = 2735202245888L;
    public static final long RVA_USERNAME = 2735202260160L;
    public static final long RVA_PLAYER_NAME = 2735202499296L;
    public static final long RVA_KEY_STATE = 2735213246577L;
    public static final long RVA_KEY_PRESSED = 2735202267888L;
    public static final long RVA_DRAW_LINE = 2735203329552L;
    public static final long RVA_DRAW_QUAD = 2735203332336L;
    public static final long RVA_DRAW_BOX = 2735203331056L;
    public static final long RVA_CAMERA_BASIS = 2735203325152L;
    public static final long RVA_COLOR_TABLE = 2735199737968L;
    public static final long RVA_RANDOM_TINT = 2735199738240L;
    public static final long RVA_MICROTIME = 2735199714128L;
    public static final long RVA_ENTITY_LIST_GROW = 2735200027520L;
    public static final long RVA_LIST_CONTAINS = 2735203010416L;
    public static final long RVA_ASSIGN_STRING = 2735199764880L;
    public static final int ITEM_MACE = 1;
    public static final int ITEM_SPEAR = 2;
    public static final int SLOT_NONE = -1;
    public static final double[] WINDOW_ALPHA_STEPS = new double[]{0.8, 0.85, 0.9, 0.95, 0.97, 0.975, 0.99};
    private static final String[] SLOT_SETTER_NAMES = new String[]{"d", "setSelectedSlot", "method_61496", "setSelectedSlot", "m_385457_"};
    private static final String SLOT_SETTER_DESCRIPTOR = "(I)V";
    private static int mappingIndex;
    private static int airStuckCounter;
    private static boolean airStuckCleanupPending;
    private static boolean airStuckStacked;
    private static int combatLock;
    private static Object activeAirStuck;
    private static Object noInteract;
    private static Object noPush;
    private static Object noServerRotate;
    private static Object noSlow;
    private static Object noFriendDamage;
    public static final double DEFAULT_BLOCK_RANGE = 4.5;
    public static final double DEFAULT_ENTITY_RANGE = 3.0;
    public static final double THROW_GRAVITY = 0.05;
    public static final double THROW_DRAG = 0.99;
    public static final double THROW_MIN_LIFT = 0.05;
    public static final long RVA_CAMERA_ENTITY = 2735202152208L;
    public static final long RVA_SET_YAW = 2735202523488L;
    public static final long RVA_SET_PITCH = 2735202523664L;
    public static final long RVA_TURN = 2735202512272L;
    public static final long RVA_GET_PERSPECTIVE = 2735202632016L;
    public static final long RVA_SET_PERSPECTIVE = 2735202623664L;
    public static final long RVA_RESTORE_PERSPECTIVE = 2735202632320L;
    public static final long RVA_QUICK_MOVE_SLOT = 2735202556800L;
    public static final long RVA_SNEAK_KEY = 2735202267424L;
    public static final long RVA_STACK_PRESENT = 2735202473280L;
    public static final long RVA_SLOT_ITEM = 2735202551280L;
    public static final long RVA_COMPONENT_MATCH = 2735199824368L;
    public static final long RVA_COMPONENT_INIT = 2735202538928L;
    public static final long RVA_STACK_COLOR_PRIMARY = 2735202535488L;
    public static final long RVA_STACK_COLOR_SECONDARY = 2735202536176L;
    public static final long RVA_ITEM_ID_MATCH = 2735202480272L;
    public static final long RVA_ITEM_COLOR_APPLY = 2735200227520L;
    public static final long RVA_SPRINT_KEY = 2735202266960L;
    public static final long RVA_IS_TOUCHING_WATER = 2735202492304L;
    public static final long RVA_IS_SUBMERGED_IN_WATER = 2735202492496L;
    public static final long RVA_SET_SWIMMING = 2735202307600L;
    public static final long RVA_STREAM_EXCLUSION_OVERLAY = 2735213242895L;
    public static final long RVA_STREAM_TEARDOWN = 2735200831376L;
    public static final long RVA_INTERFACE_SOUND_ENABLED = 2735213239082L;
    public static final long RVA_INTERFACE_SOUND_VOLUME = 2735213018772L;
    public static final long RVA_INTERFACE_SOUND_PITCH = 2735213018776L;
    public static final long RVA_SOUND_FILTER_APPLY = 2735200366112L;
    public static final long RVA_POST_PROCESS_READY = 2735201480912L;
    public static final long RVA_POST_PROCESS_BEGIN = 2735201506240L;
    public static final long RVA_POST_PROCESS_TARGET_VALID = 2735201473968L;
    public static final long RVA_POST_PROCESS_BIND = 2735201511328L;
    public static final long RVA_POST_PROCESS_UNBIND = 2735201511264L;
    public static final long RVA_POST_PROCESS_DRAW = 2735201464528L;
    public static final long RVA_POST_PROCESS_VALUE = 2735201508560L;
    public static final long RVA_POST_PROCESS_END = 2735201510464L;
    public static final long RVA_POST_PROCESS_RELEASE = 2735201463936L;
    public static final long RVA_GUI_SCALE = 2735202247792L;
    public static final long RVA_CONTAINER_SLOT_LIST = 2735200265760L;
    public static final long RVA_MOVE_MATCHING_SLOTS = 2735200266480L;
    public static final long RVA_SORT_CONTAINER = 2735200266592L;
    public static final long RVA_STASH_CONTAINER = 2735200267344L;
    public static final long RVA_SLOT_ITEM_MATCHES = 2735202473280L;
    public static final long RVA_SLOT_ITEM_AT = 2735202555376L;
    public static final long RVA_ANIMATION_SEED = 2735200831600L;
    public static final long RVA_BUTTON_DRAW = 2735200832496L;
    public static final double GUI_SCALE_DEFAULT = 2.0;
    public static final long RVA_WORLD_KEY_NORMALIZE = 3471472L;
    public static final long RVA_STRIP_COLOR_CODES = 197440L;
    public static final long RVA_EVENT_QUERY_PARSE = 909648L;
    public static final long RVA_WAYPOINT_PLATE = 3459872L;
    public static final long RVA_WAYPOINT_NOTIFY = 3314928L;
    public static final long VA_VIEW_POSITION = 2735213035704L;
    public static final long VA_HOLY_WORLD_OWNER = 2735213254000L;
    private static final char COLOR_CODE_PREFIX = '\u00a7';
    public static final long RVA_ITEM_SWAP_TICK = 2735200631888L;
    public static final long RVA_ITEM_SWAP_STOP = 2735200631792L;
    public static final long RVA_ITEM_SWAP_BEGIN = 2735200631584L;
    public static final long RVA_TOTEM_SLOT = 2735200053424L;
    public static final long RVA_TOTEM_SLOT_NO_COOLDOWN = 2735200054432L;
    public static final long RVA_OFFHAND_TOTEM = 2735200052336L;
    public static final long RVA_HEALTH_DANGER = 2735200050912L;
    public static final long RVA_FALL_DANGER = 2735200051520L;
    public static final long RVA_ENTITY_DANGER = 2735200052784L;
    public static final long RVA_MACE_ABOVE = 2735200053824L;
    public static final long RVA_ABSORPTION = 2735202507024L;
    public static final long RVA_PLAYER_HEALTH = 2735202505088L;
    public static final int ITEM_TOTEM = 0;
    private static final double DEFAULT_DANGER_RANGE = 16.0;
    private static final double ABSORPTION_LIMIT = 0.0;

    private Client() {
    }

    public static boolean inGame() {
        return false;
    }

    public static boolean isPaused() {
        return false;
    }

    public static boolean isPlayerAlive() {
        return false;
    }

    public static Entity player() {
        return null;
    }

    public static Entity crosshairEntity() {
        return null;
    }

    public static List<Entity> entities() {
        return Collections.emptyList();
    }

    public static boolean isLiving(Entity entity) {
        return entity != null && entity.isAlive();
    }

    public static boolean isCrystal(Entity entity) {
        return false;
    }

    public static boolean isOwnCrystal(Entity entity) {
        return false;
    }

    public static boolean isFriend(Entity entity) {
        return false;
    }

    public static boolean canSee(Entity entity) {
        return true;
    }

    public static boolean sameEntity(Entity a, Entity b) {
        return a != null && a == b;
    }

    public static double health(Entity entity) {
        return entity == null ? 0.0 : 20.0;
    }

    public static int entityId(Entity entity) {
        return entity == null ? -1 : entity.id();
    }

    public static double[] entityPosition(Entity entity) {
        return entity == null ? new double[3] : entity.position();
    }

    public static double[] eyePosition() {
        return new double[3];
    }

    public static double[] currentRotation() {
        return new double[]{0.0, 0.0};
    }

    public static void setRotation(double yaw, double pitch) {
    }

    public static BlockPos raycastBlock() {
        return null;
    }

    public static boolean isObsidian(BlockPos pos) {
        return false;
    }

    public static boolean canPlaceCrystal(BlockPos pos) {
        return Client.isObsidian(pos) && Client.isObsidian(pos.up());
    }

    public static Entity spawnEndCrystal(double[] position) {
        return null;
    }

    public static void attack(Entity entity) {
    }

    public static void swingMainHand() {
    }

    public static boolean isHoldingItem(int itemId) {
        return false;
    }

    public static boolean isScreenOpen() {
        return false;
    }

    public static boolean canAttack(Entity entity) {
        return entity != null && entity.isAlive();
    }

    public static boolean isHoldingWeapon() {
        return false;
    }

    public static void setAttackKey(boolean pressed) {
    }

    public static void releaseAttackKey() {
    }

    public static long nanos() {
        return System.nanoTime();
    }

    public static boolean screenOpen() {
        return false;
    }

    public static boolean isBreakingBlock() {
        return false;
    }

    public static boolean containerScreenOpen() {
        return false;
    }

    public static boolean inventoryScreenOpen() {
        return false;
    }

    public static String openScreenTitle() {
        return "";
    }

    public static int openScreenId() {
        return 0;
    }

    public static boolean isAuctionScreen(String title) {
        return false;
    }

    public static boolean isRemoved(Entity entity) {
        return entity == null;
    }

    public static boolean hasLineOfSight(double[] from, double[] to) {
        return true;
    }

    public static void forEachPlayer(Consumer<Entity> action) {
    }

    public static void forEachEntity(Consumer<Entity> action) {
    }

    public static Entity entityByName(String name) {
        return null;
    }

    public static void maintainList(List<Entity> list) {
    }

    public static List<Object> loadedChunks() {
        return Collections.emptyList();
    }

    public static void collectBlocksByList(Object owner, List<Object> target) {
    }

    public static Object worldOf(Object any) {
        return null;
    }

    public static Object blockStateAt(int x, int y, int z) {
        return null;
    }

    public static Object clientWorld() {
        return null;
    }

    public static Object singleplayerWorld() {
        return null;
    }

    public static Object worldFor(Object any) {
        return null;
    }

    public static boolean trackedBlockPresent(Object world, int x, int y, int z, int id) {
        return false;
    }

    public static void checkJni() {
    }

    public static void installTickHook() {
    }

    public static void uninstallTickHook() {
    }

    public static void closeScreen() {
    }

    public static int containerSize() {
        return 0;
    }

    public static int containerSyncId() {
        return 0;
    }

    public static Object slotStack(int index) {
        return null;
    }

    public static int stackItemId(Object stack) {
        return 0;
    }

    public static boolean slotPresent(int index) {
        return false;
    }

    public static void clickSlot(int slot, int button, int mode, int keyCode) {
    }

    public static void clickSlot(int slot, int button, int mode) {
    }

    public static void clickSlot(int slot, int button) {
    }

    public static boolean containerSearchMatches(Object a, Object b) {
        return false;
    }

    public static int monitorRefreshRate() {
        return 60;
    }

    public static void setFrameLimit(int value) {
    }

    public static String currentUsername() {
        return "";
    }

    public static String playerName(Object player) {
        return "";
    }

    public static List<String> boardSections() {
        return Collections.emptyList();
    }

    public static List<BoardSection> protectSections() {
        return Collections.emptyList();
    }

    public static long boardToken() {
        return 0L;
    }

    public static int rawKeyState() {
        return 0;
    }

    public static boolean keyPressed() {
        return false;
    }

    public static void drawWorldLine(double[] from, double[] to, int color, float width) {
    }

    public static void drawWorldQuad(int texture, int pointer, float[] vertices, int count) {
    }

    public static void drawWorldBox(double[] min, double[] max, int color) {
    }

    public static void cameraBasis(double[] origin, double[] basis, double alpha) {
    }

    public static int modulateColor(int color) {
        return color;
    }

    public static int randomTint(int color) {
        return color;
    }

    public static boolean listContains(List<String> list, String value) {
        return list != null && list.contains(value);
    }

    public static void assignString(Object target, String value) {
    }

    public static void invalidateRenderCache() {
    }

    public static boolean isJumpKeyDown() {
        return false;
    }

    public static boolean isAttackKeyDown() {
        return false;
    }

    public static boolean isSneaking() {
        return false;
    }

    public static int jumpKey() {
        return 0;
    }

    public static void setJumpKey(int key) {
    }

    public static boolean hasPendingException() {
        return false;
    }

    public static boolean isOnGround(Entity entity) {
        return false;
    }

    public static boolean isSprinting(Entity entity) {
        return false;
    }

    public static boolean isRiding(Entity entity) {
        return false;
    }

    public static boolean isInWater(Entity entity) {
        return false;
    }

    public static int hurtTicks(Entity entity) {
        return 0;
    }

    public static Entity knockbackSource(Entity entity) {
        return null;
    }

    public static double motionY(Entity entity) {
        return 0.0;
    }

    public static double motionHorizontal(Entity entity) {
        return 0.0;
    }

    public static void clearMotion(Entity entity) {
    }

    public static double random(double bound) {
        return Math.random() * bound;
    }

    public static long nanoTime() {
        return System.nanoTime();
    }

    public static int crosshairEntityId() {
        return -1;
    }

    public static int blockingEntityId() {
        return -1;
    }

    public static boolean isBlocking(Entity entity) {
        return false;
    }

    public static boolean isTargetBlocking(Entity entity) {
        return false;
    }

    public static boolean isAttackable(Entity entity) {
        return entity != null;
    }

    public static boolean isHoldingShield(Entity entity) {
        return false;
    }

    public static void releaseAttack() {
    }

    public static void releaseAttack(int entityId) {
    }

    public static Entity crosshairTarget() {
        return null;
    }

    public static void attackWith(Entity self, Entity target) {
    }

    public static ItemStack heldItem() {
        return null;
    }

    public static void useItem(ItemStack stack) {
    }

    public static void closeContainer() {
    }

    public static void replayContainerAction(int id, int first, int second, Object reference) {
    }

    public static boolean isBindDown(int key, int mode) {
        return false;
    }

    public static void swapToElytra() {
    }

    public static void useFirework() {
    }

    public static void stopUsingItem(Entity entity) {
    }

    public static Entity localPlayer() {
        return Client.player();
    }

    public static Entity resolvePlayer(Entity entity) {
        return entity;
    }

    public static boolean hasCrosshairEntity() {
        return Client.crosshairEntity() != null;
    }

    public static int mappingIndex() {
        return mappingIndex;
    }

    public static void setMappingIndex(int value) {
        mappingIndex = value;
    }

    public static String slotSetterName() {
        int index = mappingIndex;
        if (index < 0 || index >= SLOT_SETTER_NAMES.length) {
            return SLOT_SETTER_NAMES[2];
        }
        return SLOT_SETTER_NAMES[index];
    }

    public static String slotSetterDescriptor() {
        return SLOT_SETTER_DESCRIPTOR;
    }

    public static boolean clientReady() {
        return !Client.isPaused() && !Client.isScreenOpen();
    }

    public static boolean enableGateOpen() {
        return true;
    }

    public static boolean isForwardKeyDown() {
        return false;
    }

    public static boolean isAttackKeyClicked() {
        return false;
    }

    public static boolean consumeAttackClick() {
        return false;
    }

    public static double attackCooldown(Entity entity) {
        return Client.attackCooldown(entity, 0.0f);
    }

    public static double attackCooldown(Entity entity, float ticksAhead) {
        return 1.0;
    }

    public static double randomDelay(double min, double max) {
        if (max <= min) {
            return min;
        }
        return min + Math.random() * (max - min);
    }

    public static void setSprinting(Entity entity, boolean sprinting) {
    }

    public static double[] deltaMovement(Entity entity) {
        return entity == null ? new double[3] : entity.velocity();
    }

    public static void setDeltaMovement(Entity entity, double[] motion) {
    }

    public static void setNoGravity(Entity entity, boolean value) {
    }

    public static void sendMessage(Entity entity, String message) {
    }

    public static void resetAttackStrengthTicker(Entity self, Entity target) {
    }

    public static void syncSelectedSlot() {
    }

    public static int airStuckCounter() {
        return airStuckCounter;
    }

    public static void incrementAirStuckCounter() {
        ++airStuckCounter;
    }

    public static void decrementAirStuckCounter() {
        if (airStuckCounter > 0) {
            --airStuckCounter;
        }
    }

    public static boolean airStuckCleanupPending() {
        return airStuckCleanupPending;
    }

    public static void setAirStuckCleanupPending(boolean value) {
        airStuckCleanupPending = value;
    }

    public static boolean airStuckStacked() {
        return airStuckStacked;
    }

    public static void setAirStuckStacked(boolean value) {
        airStuckStacked = value;
    }

    public static void registerAirStuck(Object module) {
        activeAirStuck = module;
    }

    public static Object activeAirStuck() {
        return activeAirStuck;
    }

    public static void refreshAirStuck() {
    }

    public static void finishAirStuck() {
    }

    public static int combatLock() {
        return combatLock;
    }

    public static void setCombatLock(int value) {
        combatLock = value;
    }

    public static KeyState keyState() {
        return new KeyState();
    }

    public static int selectedSlot() {
        return 0;
    }

    public static void setSelectedSlot(int slot) {
    }

    public static void setSelectedSlotReflective(int slot) {
    }

    public static int findSlotWithItem(int itemId) {
        return -1;
    }

    public static int findSlotWithLungeSpear() {
        return -1;
    }

    public static boolean hasLungeSpear() {
        return false;
    }

    public static ItemStack itemAtSlot(int slot) {
        return null;
    }

    public static boolean isMaceItem(ItemStack stack) {
        return false;
    }

    public static boolean isHoldingSword(Entity entity) {
        return false;
    }

    public static void performLungeAttack() {
    }

    public static void notifyMissingLungeSpear(String message, String label) {
    }

    public static Entity findTargetEntity(double reach) {
        return null;
    }

    public static double[] lerpedPosition(Entity entity, float partialTicks) {
        return Client.entityPosition(entity);
    }

    public static double[] lookVector(Entity entity) {
        return new double[3];
    }

    public static Entity traceWindowTarget(double[] from, double[] to, double[] outDistance) {
        outDistance[0] = 0.0;
        return null;
    }

    public static double traceDistance(Entity entity, double[] from, double[] to, double reach) {
        return 0.0;
    }

    public static double[] windowSnapshot(Entity entity) {
        double[] position = Client.entityPosition(entity);
        return new double[]{position[0], position[1], position[2], 0.0};
    }

    public static double[] convertWindowSnapshot(Entity entity) {
        return Client.windowSnapshot(entity);
    }

    public static void drawWindowPass(List<?> windows, int color, float size, float alpha, double[] alphaSteps, boolean visible, boolean outline, int textColor) {
    }

    public static boolean flag16e8(Object module) {
        return false;
    }

    public static double settingDouble(Object module, int offset) {
        return 0.0;
    }

    public static Object ambienceTimeBlockList() {
        return null;
    }

    public static double[] ambienceCameraPosition() {
        return new double[3];
    }

    public static int ambienceParticleBatch() {
        return 0;
    }

    public static boolean renderPassActive() {
        return false;
    }

    public static boolean isPlayer(Entity entity) {
        return false;
    }

    public static boolean isCrystalEntity(Entity entity) {
        return false;
    }

    public static boolean isTntEntity(Entity entity) {
        return false;
    }

    public static int tntFuse(Entity entity) {
        return -1;
    }

    public static boolean isIgnoredName(String name) {
        return false;
    }

    public static void leaveServer() {
    }

    public static Entity entityByNameAny(List<String> names) {
        return null;
    }

    public static boolean protectNeedsRefresh(Object module) {
        return false;
    }

    public static void protectApply(Object module) {
    }

    public static boolean protectBoardContains(Object module, String value) {
        return false;
    }

    public static boolean isTaggedPlayer(Entity entity) {
        return false;
    }

    public static void notifyPulseTag(String name) {
    }

    public static void flushPulseTag() {
    }

    public static int fireworkBindResult() {
        return -1;
    }

    public static int fireworkBindSlot() {
        return -1;
    }

    public static void startFireworkAction(int slot, int mode) {
    }

    public static int swapBindResult() {
        return -1;
    }

    public static int swapBindSlot() {
        return -1;
    }

    public static void pushActionStep(int slot, int mode, int first, int second) {
    }

    public static void stepAction(int state, int slot, int mode, int keyCode) {
    }

    public static boolean isPearlOwnedBy(Entity entity, Object module) {
        return false;
    }

    public static boolean flag56(Entity entity) {
        return false;
    }

    public static boolean flag54(Entity entity) {
        return false;
    }

    public static boolean flag340(Object module) {
        return false;
    }

    public static boolean flag430(Object module) {
        return false;
    }

    public static boolean flag520(Object module) {
        return false;
    }

    public static boolean flag610(Object module) {
        return false;
    }

    public static boolean flagA40(Object module) {
        return false;
    }

    public static int settingColor(Object module, int offset) {
        return -1;
    }

    public static void drawPearlBoxes(Object module) {
    }

    public static void drawPearlLandingMarker(Object module) {
    }

    public static void drawPearlLandingPlate(Object module, float step) {
    }

    public static void fthotkeyTick(Object module) {
    }

    public static void auctionSearchText(Object module) {
    }

    public static void auctionOpenSearch(Object module) {
    }

    public static int auctionSlotItemId(Object module, int index) {
        return 0;
    }

    public static void auctionRebuildCards(Object module) {
    }

    public static void auctionClearPending(Object module) {
    }

    public static void auctionBuildPanel(Object module, long argument) {
    }

    public static void auctionClickCard(Object module, int mode) {
    }

    public static boolean panelEnabled(Object module) {
        return false;
    }

    public static boolean mouseConsumed() {
        return false;
    }

    public static void textureSetup(int tinted, int primary) {
    }

    public static double targetEspColorValue(Object module) {
        return 0.0;
    }

    public static double targetEspEffectValue(Object module) {
        return 0.0;
    }

    public static void renderTargetMarker(Object module, Entity target, float fade, int color, float scale) {
    }

    public static double colorTableChannel(int color, int offset) {
        return 0.0;
    }

    public static boolean textureBatchReady() {
        return false;
    }

    public static void flushTexturedBatch() {
    }

    public static void drawTexturedStrip(int mode, List<float[]> vertices, boolean expanded) {
    }

    public static long timerNanos() {
        return System.nanoTime();
    }

    public static double[] playerPosition() {
        return Client.entityPosition(Client.player());
    }

    public static boolean isPrimedTnt(Entity entity) {
        return false;
    }

    public static boolean isTrackedEntity(Entity entity) {
        return entity != null && !Client.isRemoved(entity);
    }

    public static void drawTntTimer(double x, double y, double z, double fuse, float scale) {
    }

    public static Entity spawnNamedPlayer(String name) {
        return null;
    }

    public static void removeEntity(int entityId) {
    }

    public static void onFakePlayerRemoved() {
    }

    public static boolean isFriendTeleportRequest() {
        return false;
    }

    public static void sendChatCommand(String command) {
    }

    public static int itemUseCooldown() {
        return 0;
    }

    public static void setItemUseCooldown(int value) {
    }

    public static int findStealSlot() {
        return -1;
    }

    public static boolean isSpectator(Entity entity) {
        return false;
    }

    public static boolean isMining() {
        return false;
    }

    public static boolean canMine() {
        return true;
    }

    public static void selectSlot(int slot) {
    }

    public static void selectToolSlot(int target) {
    }

    public static void restoreToolSlot() {
    }

    public static void updateToolState() {
    }

    public static void resetToolSwitcher() {
    }

    public static boolean isBreakKeyIdle() {
        return false;
    }

    public static Object raycastTarget() {
        return null;
    }

    public static Object blockState(Entity player, Object hit) {
        return null;
    }

    public static int findBestTool(Object blockState) {
        return -1;
    }

    public static void setSneak(boolean pressed) {
    }

    public static boolean isSneaking(Entity entity) {
        return entity != null && Client.isSneaking();
    }

    public static boolean isAlive(Entity entity) {
        return entity != null && entity.isAlive();
    }

    public static void resetNameTagLayout(Object module) {
    }

    public static Object playerHandle() {
        return null;
    }

    public static void resetNameTagGroups(Object module) {
    }

    public static void refreshNameTagPrefixes(Object module) {
    }

    public static boolean voiceChatEnabled() {
        return false;
    }

    public static void initVoiceChatIcon() {
    }

    public static boolean voiceChatIconReady() {
        return false;
    }

    public static boolean flagC48(Object module) {
        return false;
    }

    public static void initPulseIcon() {
    }

    public static boolean pulseIconReady() {
        return false;
    }

    public static void buildNameTag(Object module, Entity player, double[] eye, double distanceSq, boolean voiceReady, boolean pulseReady, boolean prefix, boolean refreshSlot, boolean funtime, boolean mineblaze, boolean hearts, boolean slotsEnabled) {
    }

    public static void renderNameTags(Object module) {
    }

    public static void resetPlayerEspTimeline(Object module) {
    }

    public static boolean targetsMatchPlayers(Object module) {
        return false;
    }

    public static boolean armorFilterNetherite(Object module) {
        return false;
    }

    public static void collectPlayerEspTarget(Object module, Entity player, double[] eye, boolean glowMode, boolean armorFilter, boolean showFriends) {
    }

    public static void collectMobEspTarget(Object module, Entity entity, double[] eye, boolean armorFilter, boolean throughWalls) {
    }

    public static boolean flag1c0(Object module) {
        return false;
    }

    public static boolean flag1590(Object module) {
        return false;
    }

    public static boolean flag5d8(Object module) {
        return false;
    }

    public static void updatePlayerEspGroups(Object module) {
    }

    public static void renderPlayerEspSolid(Object module) {
    }

    public static void appendPlayerEspGroup(Object module, List<?> source) {
    }

    public static void renderPlayerEspGroup(Object module, List<?> source, PlayerEspStyle style) {
    }

    public static int blockEntryCount(Object module) {
        return 0;
    }

    public static int blockEntryColor(Object module, int index) {
        return 0;
    }

    public static byte blockEntryFlag(Object module, int index) {
        return 0;
    }

    public static void blockEspScanChunk(Object module) {
    }

    public static int chunkX(Object chunkEntry) {
        return 0;
    }

    public static int chunkZ(Object chunkEntry) {
        return 0;
    }

    public static int viewDistanceChunks() {
        return 8;
    }

    public static void addRaycastChunk(Object module, int chunkX, int chunkZ) {
    }

    public static long chunkHashMask(Object module) {
        return 0L;
    }

    public static long chunkHashOf(Object chunkEntry) {
        return 0L;
    }

    public static void forEachChunkBlock(int chunkX, int chunkZ, ChunkBlockConsumer consumer) {
    }

    public static boolean blockMatchesList(Object module, Object state) {
        return false;
    }

    public static Object blockEntryOf(Object module, Object state, int blockX, int blockZ) {
        return null;
    }

    public static void storeChunkBlocks(Object module, int chunkX, int chunkZ, List<?> blocks) {
    }

    public static int listedCount(Object module) {
        return 0;
    }

    public static void setListedCount(Object module, int value) {
    }

    public static int listedOffset(Object module) {
        return 0;
    }

    public static void setListedOffset(Object module, int value) {
    }

    public static void addListedOffset(Object module, int x, int y, int z) {
    }

    public static boolean listEntryValid(Object module, int offset) {
        return false;
    }

    public static void moveListEntry(Object module, int offset) {
    }

    public static void blockEspCollectRaycast(Object module) {
    }

    public static boolean blockEspRaycastVisible(Object module, Object entry) {
        return false;
    }

    public static void blockEspMarkVisible(Object module, Object entry) {
    }

    public static void blockEspListRefresh(Object module) {
    }

    public static void renderBlockEspSolid(Object module) {
    }

    public static void renderBlockEsp(Object module) {
    }

    public static boolean isDeathScreenOpen() {
        return false;
    }

    public static void requestRespawn(Entity player) {
    }

    public static void sendSystemMessage(String message) {
    }

    public static String translate(String text) {
        return text;
    }

    public static String formatMessage(String template, Object ... args) {
        int at;
        String result = Client.translate(template);
        StringBuilder builder = new StringBuilder();
        int index = 0;
        for (int i = 0; i < args.length && (at = result.indexOf("{}", index)) >= 0; ++i) {
            builder.append(result, index, at).append(args[i]);
            index = at + 2;
        }
        builder.append(result, index, result.length());
        return builder.toString();
    }

    public static int windowAspect() {
        return 0;
    }

    public static boolean isBindTriggered(int key, int flags) {
        return false;
    }

    public static boolean isKeyDown(int key) {
        return false;
    }

    public static String heldItemName(boolean offHand, boolean stripBrackets) {
        return "";
    }

    public static boolean anyOtherPlayerWithin(Entity self, double range) {
        return false;
    }

    public static void startLag() {
    }

    public static void stopLag() {
    }

    public static float playerYaw() {
        return 0.0f;
    }

    public static float playerPitch() {
        return 0.0f;
    }

    public static void setPlayerYaw(float yaw) {
    }

    public static void setPlayerPitch(float pitch) {
    }

    public static int perspective() {
        return 0;
    }

    public static void setPerspective(int mode) {
    }

    public static Object hoveredStack() {
        return null;
    }

    public static boolean isShulkerBox(Object stack) {
        return false;
    }

    public static int stackIdentity(Object stack) {
        return -1;
    }

    public static List<Object> containerContents(Object stack) {
        return Collections.emptyList();
    }

    public static void renderShulkerPreview(List<Object> contents) {
    }

    public static int holyWorldCombatTicks() {
        return 0;
    }

    public static List<String> scoreboardLines() {
        return Collections.emptyList();
    }

    public static boolean containsLeaveMarker(List<String> lines) {
        return false;
    }

    public static long messageNumber(String message) {
        return 0L;
    }

    public static int textNumber(String message, int index) {
        return 0;
    }

    public static double playerHealth() {
        return 20.0;
    }

    public static void restoreWheelSelection(int index) {
    }

    public static Object wheelAt(int wheel, int index) {
        return null;
    }

    public static boolean wheelValid(Object wheel) {
        return wheel != null;
    }

    public static int wheelTarget(int wheel, int index) {
        return -1;
    }

    public static boolean wheelMatches(Object stack, int target) {
        return false;
    }

    public static Object heldSlotStack() {
        return null;
    }

    public static void releaseUseKey() {
    }

    public static void updateWheel(long wheel, Object module) {
    }

    public static void processWheel(Object module, int wheel) {
    }

    public static boolean isWheelKeyHeld(int wheel) {
        return false;
    }

    public static int firstWheelCell(Object module, int wheel) {
        return -1;
    }

    public static void resetNoRenderState() {
    }

    public static void releaseNoRenderState() {
    }

    public static void setHideFire(boolean value) {
    }

    public static void setHideWeather(boolean value) {
    }

    public static void setFogMode(int value) {
    }

    public static void setFogDensity(double value) {
    }

    public static void setHideOverlay(boolean value) {
    }

    public static void setHideSigns(boolean value) {
    }

    public static void setHideHud(boolean value) {
    }

    public static void restoreSwap(int slot) {
    }

    public static int findSwapSlot(Object module, int bind) {
        return -1;
    }

    public static void silentSwap(int slot) {
    }

    public static boolean stackPresent(Object stack) {
        return stack != null;
    }

    public static String stackItemName(Object stack) {
        return "";
    }

    public static int stackTint(Object stack) {
        return 0;
    }

    public static int mainHandItemId() {
        return -1;
    }

    public static double lagDefaultDelay() {
        return 250.0;
    }

    public static double lagDelayMin() {
        return 0.0;
    }

    public static double lagDelayMax() {
        return 1000.0;
    }

    public static double lagDelayStep() {
        return 50.0;
    }

    public static List<Object> lagFeatures() {
        return Collections.emptyList();
    }

    public static boolean lagGateOpen() {
        return true;
    }

    public static int lagHoldCount() {
        return 0;
    }

    public static boolean lagArmed() {
        return true;
    }

    public static boolean lagWindowElapsed() {
        return true;
    }

    public static void setLagWindowStart(long value) {
    }

    public static void releaseLag() {
    }

    public static long lagLastReleaseNanos() {
        return 0L;
    }

    public static void setLagLastReleaseNanos(long value) {
    }

    public static boolean lagHeld() {
        return false;
    }

    public static void setLagHeld(boolean value) {
    }

    public static double lagHoldSeconds() {
        return 0.15;
    }

    public static void setLagHoldSeconds(double value) {
    }

    public static void flushLag() {
    }

    public static int lagPendingTicks() {
        return -1;
    }

    public static boolean lagHasTicks() {
        return false;
    }

    public static double lagMaxHold(double value) {
        return value;
    }

    public static double lagHoldCap() {
        return 0.15;
    }

    public static double lagOutOfRangeGrace() {
        return 0.15;
    }

    public static double settingNumber(Object module, String name) {
        if (!(module instanceof Feature)) {
            return 0.0;
        }
        for (Setting setting : ((Feature)module).getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting.getNumber();
        }
        return 0.0;
    }

    public static void beginLag() {
    }

    public static void beginLag(int tick) {
    }

    public static boolean canHoldLag() {
        return true;
    }

    public static double lagGraceMillis() {
        return 150.0;
    }

    public static double lagHoldMillis() {
        return 150.0;
    }

    public static double lagHoldMillis(double range) {
        return range + range;
    }

    public static boolean lagPending() {
        return false;
    }

    public static void setLagPending(boolean value) {
    }

    public static int lagQueueDepth() {
        return 0;
    }

    public static long lagStartNanos() {
        return 0L;
    }

    public static void setLagStartNanos(long value) {
    }

    public static boolean lagSuspended() {
        return false;
    }

    public static boolean lagTicking() {
        return false;
    }

    public static boolean lagWindowOpen() {
        return true;
    }

    public static int tickCount() {
        return 0;
    }

    public static boolean panicRequested() {
        return false;
    }

    public static void requestPanic() {
    }

    public static boolean toggleGateOpen() {
        return false;
    }

    public static boolean contains(String haystack, String needle) {
        return haystack != null && needle != null && haystack.contains(needle);
    }

    public static long indexOf(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1L;
        }
        return haystack.indexOf(needle);
    }

    public static List<String> bossBarLines() {
        return Collections.emptyList();
    }

    public static void applyProxy(boolean enabled, boolean socks5, String host, int port, String username, String password) {
    }

    public static void safeModeStart() {
    }

    public static void safeModeStop() {
    }

    public static void safeModeShutdown() {
    }

    public static void removeLogFilter() {
    }

    public static boolean keybindPressed(int key, int mods) {
        return false;
    }

    public static void swapRotation(float yaw, float pitch) {
    }

    public static int stateFlag() {
        return 0;
    }

    public static void setStateFlag(int value) {
    }

    public static int findHotbarSlotByName(String itemName) {
        return -1;
    }

    public static int findHotbarSlotByItemId(int itemId) {
        return -1;
    }

    public static int hotbarItemCooldown(int slot) {
        return -1;
    }

    public static boolean hotbarItemUsable(int slot) {
        return true;
    }

    public static void registerNoInteract(Object module) {
        noInteract = module;
    }

    public static Object noInteract() {
        return noInteract;
    }

    public static void registerNoPush(Object module) {
        noPush = module;
    }

    public static Object noPush() {
        return noPush;
    }

    public static void registerNoServerRotate(Object module) {
        noServerRotate = module;
    }

    public static Object noServerRotate() {
        return noServerRotate;
    }

    public static void registerNoSlow(Object module) {
        noSlow = module;
    }

    public static Object noSlow() {
        return noSlow;
    }

    public static void registerNoFriendDamage(Object module) {
        noFriendDamage = module;
    }

    public static Object noFriendDamage() {
        return noFriendDamage;
    }

    public static int jumpCooldown(Entity entity) {
        return 0;
    }

    public static void setJumpCooldown(Entity entity, int value) {
    }

    public static double[] stuckSpeedMultiplier(Entity entity) {
        double[] dArray;
        if (entity == null) {
            dArray = null;
        } else {
            double[] dArray2 = new double[3];
            dArray2[0] = 1.0;
            dArray2[1] = 1.0;
            dArray = dArray2;
            dArray2[2] = 1.0;
        }
        return dArray;
    }

    public static boolean isInCobweb(Entity entity) {
        return false;
    }

    public static float[] moveVector(Entity entity) {
        return new float[]{0.0f, 0.0f};
    }

    public static float viewYaw(Entity entity) {
        return 0.0f;
    }

    public static boolean isSneakKeyDown() {
        return false;
    }

    public static boolean friendExists(String name) {
        return false;
    }

    public static void addFriend(String name) {
        Client.notifyFriendListChanged();
    }

    public static boolean removeFriend(String name) {
        return false;
    }

    public static void bumpFriendRevision() {
    }

    public static void notifyFriendListChanged() {
    }

    public static double blockInteractionRange(Entity entity) {
        return 4.5;
    }

    public static double entityInteractionRange(Entity entity) {
        return 3.0;
    }

    public static double clipBlockDistance(Entity entity, double[] from, double[] to) {
        return 0.0;
    }

    public static double[] clipEntityBox(Entity entity, double[] from, double[] to) {
        return null;
    }

    public static void rebuildCrosshairHit(double range) {
    }

    public static void setCrosshairTarget(Entity entity) {
    }

    public static boolean gameOptionBoolean(String name) {
        return false;
    }

    public static void setGameOptionBoolean(String name, boolean value) {
    }

    public static double gameOptionDouble(String name) {
        return 0.0;
    }

    public static void setGameOptionDouble(String name, double value) {
    }

    public static int gameOptionInt(String name) {
        return 0;
    }

    public static void setGameOptionInt(String name, int value) {
    }

    public static void setRemainingFireTicks(Entity entity, int ticks) {
    }

    public static void setEntityFlag(Entity entity, int flag, boolean value) {
    }

    public static void removeStatusEffect(Entity entity, String effect) {
    }

    public static void setRainLevel(float level) {
    }

    public static void setThunderLevel(float level) {
    }

    public static void setWorldBorderSize(double size) {
    }

    public static String scoreboardSidebarTitle() {
        return "";
    }

    public static String scoreboardTeamTitle() {
        return "";
    }

    public static void clearScoreboardCache() {
    }

    public static boolean isExperienceOrb(Entity entity) {
        return false;
    }

    public static void removeEntityLocal(Entity entity) {
    }

    public static boolean keybindPressed(int key, int mods, boolean[] latch) {
        boolean down = Client.isBindTriggered(key, mods);
        if (!down) {
            latch[0] = false;
            return false;
        }
        if (latch[0]) {
            return false;
        }
        latch[0] = true;
        return true;
    }

    public static boolean isPauseScreen() {
        return false;
    }

    public static float entityYaw(Entity entity) {
        return 0.0f;
    }

    public static float entityPitch(Entity entity) {
        return 0.0f;
    }

    public static void rotateBy(Entity entity, float yawDelta, float pitchDelta) {
    }

    public static double wrapDegrees(double angle) {
        double wrapped = angle % 360.0;
        if (wrapped > 180.0) {
            wrapped += -360.0;
        }
        if (wrapped < -180.0) {
            wrapped += 360.0;
        }
        return wrapped;
    }

    public static boolean sameItem(Object first, Object second) {
        return first != null && first == second;
    }

    public static Object inventoryStack(int index) {
        return null;
    }

    public static Object stackItem(Object stack) {
        return null;
    }

    public static Object potionItem() {
        return null;
    }

    public static int itemStackEffectAmplifier(Object stack) {
        return -1;
    }

    public static void interactItem(Entity player) {
    }

    public static int[] newSwapManager() {
        return new int[18];
    }

    public static int swapManagerState(int[] manager) {
        return manager[0];
    }

    public static boolean swapManagerFree(int[] manager) {
        return manager[0] == 0 || manager[0] == 3;
    }

    public static void swapManagerTick(int[] manager) {
    }

    public static void swapManagerReset(int[] manager) {
    }

    public static void swapManagerQueue(int[] manager, int first, int second, int third) {
    }

    public static boolean protectGateOpen(Object module) {
        return module instanceof Feature && ((Feature)module).isEnabled() && Client.toggleGateOpen();
    }

    public static void forEachFriendName(Consumer<String> action) {
    }

    public static String friendDisplayName(String name) {
        return name;
    }

    public static List<String> tabPlayerNames() {
        return Collections.emptyList();
    }

    public static boolean isFriendName(String name) {
        return false;
    }

    public static boolean isEnderPearl(Entity entity) {
        return false;
    }

    public static Entity entityOwner(Entity entity) {
        return null;
    }

    public static boolean isPlayerEntity(Object entity) {
        return entity instanceof Entity;
    }

    public static void drawWorldPlate(double[] position, float scale, String item, String label) {
    }

    public static void submit(Runnable task) {
    }

    public static boolean isSameObject(Object a, Object b) {
        return a != null && a == b;
    }

    public static double[] entityInterpolatedPosition(Entity entity) {
        return entity == null ? new double[3] : entity.position();
    }

    public static float entityHeadYaw(Entity entity) {
        return 0.0f;
    }

    public static float entityHeadPitch(Entity entity) {
        return 0.0f;
    }

    public static float entityBodyYaw(Entity entity) {
        return 0.0f;
    }

    public static double[] partyLookRaycast(Entity entity) {
        return null;
    }

    public static Object[] partyPickLookTarget(double[] origin, double[] direction) {
        return null;
    }

    public static Object localWorldRef() {
        return null;
    }

    public static int partyServerCount() {
        return 0;
    }

    public static String currentServerAddress() {
        return "";
    }

    public static String currentDimensionKey() {
        return "";
    }

    public static void partyNotify(String text, int style) {
    }

    public static void partySendMark(int x, int y, int z, String name, Object world, String dimension, String server, int color, int style) {
    }

    public static void partySendMarkSimple(int x, int y, int z) {
    }

    public static void partyPushStatus(String dimension, String server, Object world, String name, double x, double y, double z, float yaw, double extra) {
    }

    public static void partyTrackMarkedPlayers(String name) {
    }

    public static double[] partyViewPosition() {
        return new double[3];
    }

    public static void partyDrawBeamBatch(List<?> beams, List<?> labels, int color) {
    }

    public static boolean isUsingItem(Entity entity) {
        return false;
    }

    public static boolean isUsingItem() {
        return Client.isUsingItem(Client.player());
    }

    public static void setUseKey(boolean held) {
    }

    public static int[] raycastBlockData() {
        return null;
    }

    public static Object blockHitResult(double x, double y, double z, int face, int blockX, int blockY, int blockZ) {
        return null;
    }

    public static void interactBlock(Object hitResult) {
    }

    public static Entity aimSubject(Entity player) {
        return player;
    }

    public static float[] lookAt(double[] from, double[] to, float yaw, float pitch) {
        return new float[]{yaw, pitch};
    }

    public static double solveThrowPitch(double distance, double heightDelta, double speed) {
        double best = 90.0;
        double bestHeight = Double.NEGATIVE_INFINITY;
        double previous = 90.0;
        for (double angle = 90.0; angle > -90.0; angle -= 1.0) {
            double height = Client.simulateThrow(angle, speed, distance);
            if (heightDelta <= height) {
                return Client.refineThrow(angle, previous, speed, distance, heightDelta);
            }
            if (bestHeight < height) {
                best = angle;
                bestHeight = height;
            }
            previous = angle;
        }
        return Client.refineThrow(best, previous, speed, distance, heightDelta);
    }

    private static double refineThrow(double high, double low, double speed, double distance, double heightDelta) {
        double upper = high;
        double lower = low;
        for (int pass = 0; pass < 3; ++pass) {
            double middle = (upper + lower) * 0.5;
            double height = Client.simulateThrow(middle, speed, distance);
            if (heightDelta <= height) {
                upper = middle;
                continue;
            }
            lower = middle;
        }
        return (upper + lower) * 0.5;
    }

    private static double simulateThrow(double angle, double speed, double distance) {
        double radians = angle * Math.PI / 180.0;
        double horizontal = Math.cos(radians) * speed;
        double vertical = Math.sin(radians) * speed;
        double travelled = 0.0;
        double height = 0.0;
        double lastIncrement = 0.0;
        double step = 0.0;
        for (int tick = 0; tick < 300; ++tick) {
            double nextHorizontal = horizontal * 0.99;
            double nextVertical = (vertical - 0.05) * 0.99;
            step = nextHorizontal + travelled;
            if (distance <= step || nextHorizontal / 0.010000000000000009 + step < distance) break;
            horizontal = nextHorizontal;
            vertical = nextVertical;
            travelled = step;
            height += nextVertical;
            lastIncrement = nextVertical;
        }
        double fraction = 0.0;
        if (travelled < step) {
            fraction = (distance - travelled) / (step - travelled);
        }
        return lastIncrement * fraction + height;
    }

    public static int findRailSlot() {
        return -1;
    }

    public static int findCartItemSlot() {
        return -1;
    }

    public static int findChargedItemSlot() {
        return -1;
    }

    public static int findEnchantedSlot(int level) {
        return -1;
    }

    public static void swapManagerSwapOnce(int[] manager, int from, int to) {
    }

    public static Entity cameraEntity() {
        return Client.player();
    }

    public static void setEntityYaw(Entity entity, float yaw) {
    }

    public static void setEntityPitch(Entity entity, float pitch) {
    }

    public static void turnEntity(Entity entity, float deltaYaw, float deltaPitch) {
    }

    public static int perspectiveMode() {
        return 0;
    }

    public static void setPerspectiveMode(int mode) {
    }

    public static void markHandGlowDirty() {
    }

    public static void resetHudElementPosition(String element) {
    }

    public static String heldItemDisplayName(boolean offHand) {
        return "";
    }

    public static boolean sneakBindDown() {
        return false;
    }

    public static boolean isSneakKeyPressed() {
        return false;
    }

    public static int quickMoveSlot() {
        return -1;
    }

    public static void quickMoveSlot(int slot) {
        Client.clickSlot(slot, 0, 1, 0);
    }

    public static Object slotItem(int index) {
        return null;
    }

    public static boolean colorComponentMatches(Object item) {
        return false;
    }

    public static int[] stackColorPair(Object stack) {
        return new int[]{-1, -1};
    }

    public static boolean stackMatchesItemId(Object stack, int itemId) {
        return false;
    }

    public static boolean stackMatchesAnyItemId(Object stack, int[] itemIds) {
        for (int itemId : itemIds) {
            if (!Client.stackMatchesItemId(stack, itemId)) continue;
            return true;
        }
        return false;
    }

    public static void applyItemColors(Object module) {
    }

    public static void setSprintKeyDown(boolean pressed) {
    }

    public static boolean isTouchingWater(Entity entity) {
        return Client.isInWater(entity);
    }

    public static boolean isSubmergedInWater(Entity entity) {
        return Client.isInWater(entity);
    }

    public static void setSwimming(Entity entity, boolean swimming) {
    }

    public static boolean streamCaptureActive() {
        return Client.renderPassActive();
    }

    public static boolean streamExclusionOverlayActive() {
        return Client.renderPassActive();
    }

    public static void teardownStreamExclusion(Object module) {
    }

    public static void notifyModuleToggled(Object module) {
    }

    public static void setInterfaceSoundEnabled(boolean enabled) {
    }

    public static void setInterfaceSoundVolume(float volume) {
    }

    public static void setInterfaceSoundPitch(int index) {
    }

    public static void soundReducerApply(Object module, Object soundId, String group, boolean reduce, double volume) {
    }

    public static boolean postProcessReady() {
        return Client.renderPassActive();
    }

    public static void beginPostProcess(int width, int height, int flags) {
    }

    public static boolean postProcessTargetValid() {
        return Client.renderPassActive();
    }

    public static void bindPostProcessTarget() {
    }

    public static void unbindPostProcessTarget() {
    }

    public static void drawPostProcessQuad() {
    }

    public static void setPostProcessValue(float value) {
    }

    public static void endPostProcess() {
    }

    public static void releasePostProcess() {
    }

    public static boolean lineOfSightBlocked(Entity viewer, double[] from, double[] to) {
        return false;
    }

    public static void targetEspMarker(Object module, Entity target, float fade, float animTime, int color, int effect, boolean primary) {
    }

    public static void drawTargetEspStrip(int mode, List<float[]> vertices, int expanded) {
    }

    public static double guiScale() {
        return 2.0;
    }

    public static boolean hoveredRect(double x, double y, double width, double height) {
        return false;
    }

    public static int animationSeed(long nanos) {
        return 0;
    }

    public static void drawContainerButton(Object button, Object animation, long nanos) {
    }

    public static double[][] containerButtonLayout() {
        return new double[0][3];
    }

    public static int[] containerSlotIndices() {
        return new int[0];
    }

    public static void moveMatchingSlots(boolean matching) {
    }

    public static boolean sortContainer() {
        return false;
    }

    public static boolean stashContainer() {
        return false;
    }

    public static boolean containerSearch(int[] result) {
        return false;
    }

    public static boolean containerSlotItemMatches(int slot) {
        return false;
    }

    public static void setUseKey2(boolean held) {
    }

    public static boolean autoSwapUseKeyHeld(Object module) {
        return false;
    }

    public static boolean autoSwapUseKey2Held(Object module) {
        return false;
    }

    public static boolean autoSwapPendingUse(Object module) {
        return false;
    }

    public static int autoSwapPendingCount(Object module) {
        return 0;
    }

    public static int[] autoSwapManager(Object module) {
        return new int[18];
    }

    public static boolean autoSwapStepActive(int[] manager) {
        return manager[0] == 0 || manager[0] == 3;
    }

    public static void autoSwapRefreshItems(Object module) {
    }

    public static void autoSwapTickState(Object module) {
    }

    public static void autoSwapGroup(Object module, String group) {
    }

    public static void autoSwapPendingUseTick(Object module) {
    }

    public static void autoSwapStateStep(int[] manager) {
    }

    public static void autoSwapProcessGroups(Object module) {
    }

    public static void autoSwapHandleBind(Object module, String bind) {
    }

    public static void autoSwapSwapStep(Object module, String bind, boolean flag) {
    }

    public static void autoSwapScanBinds(Object module) {
    }

    public static void autoSwapResetPending(Object module) {
    }

    public static long uptimeMillis() {
        return System.currentTimeMillis();
    }

    public static String stripColorCodes(String text) {
        if (text == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder(text.length());
        int index = 0;
        while (index < text.length()) {
            char current = text.charAt(index);
            if (current == '\u00a7') {
                index += 2;
                continue;
            }
            builder.append(current);
            ++index;
        }
        return builder.toString();
    }

    public static String normalizeWorldKey(String value) {
        int dot;
        if (value == null) {
            return "";
        }
        String trimmed = value.trim();
        int colon = trimmed.indexOf(58);
        int bracket = trimmed.indexOf(93);
        String cut = trimmed;
        if (colon > 0 && (bracket < 0 || colon > bracket)) {
            cut = trimmed.substring(0, colon);
        }
        if ((dot = cut.indexOf(46)) < 0) {
            return cut;
        }
        return cut.substring(0, dot);
    }

    public static Object holyWorldOwner() {
        return null;
    }

    public static boolean holyWorldFlagSet(Object module) {
        return false;
    }

    public static double[] waypointViewPosition() {
        return new double[3];
    }

    public static EventQuery parseEventQuery(List<String> lines) {
        return new EventQuery();
    }

    public static void drawWaypointPlate(double[] position, String name, float scale, float size, float distance) {
    }

    public static void waypointNotify(int style) {
    }

    public static boolean hasStatusEffect(String effect) {
        return false;
    }

    public static boolean hasItemNamed(String item) {
        return false;
    }

    public static boolean settingListContains(Object module, String setting, String value) {
        return false;
    }

    public static void applyTheme(Object theme) {
    }

    public static void resetTheme() {
    }

    public static boolean themeAccentGradientActive() {
        return false;
    }

    public static int wheelCellCount(int wheel) {
        return 0;
    }

    public static void setWheelCellCount(int wheel, int count) {
    }

    public static void clearWheelCellKeys(int wheel) {
    }

    public static boolean wheelIsOpen(int wheel) {
        return false;
    }

    public static void setWheelOpen(int wheel, boolean value) {
    }

    public static int wheelCellBindKey(int wheel, int cell) {
        return 0;
    }

    public static int wheelCellBindModifiers(int wheel, int cell) {
        return 0;
    }

    public static boolean wheelCellBindHeld(int wheel, int cell) {
        return false;
    }

    public static boolean wheelCellKeyClicked(int wheel, int cell, int key, int modifiers) {
        return false;
    }

    public static boolean wheelCellEmpty(Object cell) {
        return true;
    }

    public static boolean wheelCellMatchesStack(Object cell, Object item) {
        return false;
    }

    public static int findSlotForWheelCell(Object cell) {
        return -1;
    }

    public static int hoveredWheelCell(int wheel, int count) {
        return -1;
    }

    public static int inventoryItemIdForCell(Object inventory, int slot, Object cell) {
        return -1;
    }

    public static Object playerInventory() {
        return null;
    }

    public static void useHeldItem(Object item) {
    }

    public static int slotItemId(int slot) {
        return -1;
    }

    public static boolean slotEmpty(int slot) {
        return true;
    }

    public static void selectHotbarSlot(int slot) {
    }

    public static boolean handHoldIdle(Object module) {
        return true;
    }

    public static void handHoldTick(Object module) {
    }

    public static void handHoldRelease(Object module) {
    }

    public static void handHoldSwapSlot(Object module, int slot) {
    }

    public static void handHoldUseSlot(Object module, int slot, int flag) {
    }

    public static void handHoldCommitSelection(Object module, int slot, int item, int field, int aux, boolean flag) {
    }

    public static void handHoldPushAction(Object module, int slot, int count, int mode) {
    }

    public static void handHoldPushActions(Object module, int[][] actions) {
    }

    public static void stageBundleUse(Object module, int slot, int itemId, int selectedSlot, int selectedItem, boolean empty) {
    }

    public static void clearPlayerUsingState() {
    }

    public static boolean mouseInputBlocked() {
        return false;
    }

    public static boolean mouseButtonDown(int button) {
        return false;
    }

    public static float guiHeight() {
        return 0.0f;
    }

    public static float windowPixelWidth() {
        return 0.0f;
    }

    public static float windowPixelHeight() {
        return 0.0f;
    }

    public static void drawWheelSegment(float[] quad, float anchorX, float anchorY, float radius, float step, int color) {
    }

    public static void drawWheelCell(float[] rect, int wheel, int cell, float angle, float scale, float alpha) {
    }

    public static boolean shuttingDown() {
        return false;
    }

    public static void itemSwapTick(Object state) {
    }

    public static void itemSwapStop(Object state) {
    }

    public static void itemSwapBegin(Object state, int slot) {
    }

    public static void itemSwapBegin(Object state, int slot, int previous) {
    }

    public static boolean inventorySlotMatches(int index) {
        return false;
    }

    public static boolean inventorySlotEmpty(int index) {
        return false;
    }

    public static boolean isTotemStack(Object stack) {
        return false;
    }

    public static boolean offhandHasTotem() {
        return false;
    }

    public static void equipOffhandTotem(int slot) {
    }

    public static double absorption(Entity entity) {
        return 0.0;
    }

    public static double absorptionLimit() {
        return 0.0;
    }

    public static double elytraHealthLimit(Object module, double fallback) {
        return fallback;
    }

    public static double defaultDangerRange() {
        return 16.0;
    }

    public static boolean maceAbove(Object module, double range, double height, boolean roof, double roofRadius) {
        return false;
    }

    public static boolean dangerNearby(Object module, double range) {
        return false;
    }

    public static boolean entityDanger(Object module) {
        return false;
    }

    public static int findTotemSlot(Object module) {
        return -1;
    }

    public static int findTotemSlotSkippingCooldown(Object module, boolean skipCooldown) {
        return -1;
    }

    public static boolean PlayerEspStyle() {
        return false;
    }

    public static void addCameraOverride(Object owner) {
    }

    public static boolean anyInputPressed() {
        return false;
    }

    public static void applyFreeCamPosition() {
    }

    public static void applyGamma(double value) {
    }

    public static void applyGammaForFrame() {
    }

    public static void applyProjectileAim(double[] rotation) {
    }

    public static boolean attackAllowed() {
        return false;
    }

    public static boolean attackKeyState() {
        return false;
    }

    public static void attackTarget(Object target) {
    }

    public static void beginAttack(Object target) {
    }

    public static double biomeGamma(int x, int y, int z) {
        return 0.0;
    }

    public static BlockPos blockPosition(Object entity) {
        return null;
    }

    public static int cameraOverrides() {
        return -1;
    }

    public static boolean canAttackTarget(Object entity) {
        return false;
    }

    public static void cancelPendingTarget() {
    }

    public static void checkPendingException() {
    }

    public static void clearChams() {
    }

    public static boolean comboAttackReady() {
        return false;
    }

    public static void completeAttack() {
    }

    public static void drawBox(double[] a, double[] b, int color) {
    }

    public static void drawBoxOutline(double[] a, double[] b, int color, float width) {
    }

    public static boolean drawWheelSegment(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8) {
        return false;
    }

    public static boolean drawWorldLine(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7) {
        return false;
    }

    public static double entityEyeHeight(Object entity) {
        return 0.0;
    }

    public static Entity entityHandle(Object entity) {
        return null;
    }

    public static double entityHeight(Object entity) {
        return 0.0;
    }

    public static String entityName(Object entity) {
        return "";
    }

    public static double entityNameHeight(Object entity) {
        return 0.0;
    }

    public static int entityNetworkId(Object entity) {
        return -1;
    }

    public static float entityScale(Object entity) {
        return 0.0f;
    }

    public static int entityTick(Object entity) {
        return -1;
    }

    public static double entityWidth(Object entity) {
        return 0.0;
    }

    public static double[] eyePosition(Object entity) {
        return new double[3];
    }

    public static double fallDistance(Object entity) {
        return 0.0;
    }

    public static void fillBoxes(Object list) {
    }

    public static int findFoodSlot() {
        return -1;
    }

    public static int findInvisSlot() {
        return -1;
    }

    public static Entity findNearestHit(Object self) {
        return null;
    }

    public static Entity findSlamTarget() {
        return null;
    }

    public static Object findThroughEntities(Object entity) {
        return null;
    }

    public static int foodLevel(Object player) {
        return -1;
    }

    public static double frameTime() {
        return 0.0;
    }

    public static double gameGamma() {
        return 0.0;
    }

    public static boolean gameReady() {
        return false;
    }

    public static boolean gammaOption() {
        return false;
    }

    public static boolean handToStunSlam(Object target) {
        return false;
    }

    public static boolean hasNewFrameTime() {
        return false;
    }

    public static void initFreeCamPosition() {
    }

    public static int[] inputState() {
        return new int[8];
    }

    public static double[] interpolatedPosition(Object entity) {
        return new double[3];
    }

    public static boolean isBoxVisible(Object box) {
        return false;
    }

    public static boolean isHoldingCrossbow() {
        return false;
    }

    public static boolean isHoldingWeaponClass2() {
        return false;
    }

    public static boolean isInvisible(Object entity) {
        return false;
    }

    public static boolean isTargetValid(Object entity) {
        return false;
    }

    public static boolean isThirdPerson() {
        return false;
    }

    public static boolean isVisibleTarget(Object entity) {
        return false;
    }

    public static int itemUseRemaining() {
        return -1;
    }

    public static int itemUseTicks() {
        return -1;
    }

    public static double leadDeltaLimit() {
        return 0.0;
    }

    public static boolean lookAt(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5) {
        return false;
    }

    public static boolean lungeReady() {
        return false;
    }

    public static void markChamsDirty() {
    }

    public static void notifyModuleState(int state) {
    }

    public static void onCameraOverrideEnded() {
    }

    public static void onFreeCamWorldGone() {
    }

    public static boolean partyPickLookTarget(Object a0, Object a1, Object a2, Object a3) {
        return false;
    }

    public static void prepareProjectileAim() {
    }

    public static double projectileDivergence(Object item) {
        return 0.0;
    }

    public static double projectileGravity(Object item) {
        return 0.0;
    }

    public static double projectileSpeed(Object item) {
        return 0.0;
    }

    public static boolean raycastEntity() {
        return false;
    }

    public static void refreshCameraState() {
    }

    public static boolean releaseOption(Object a0) {
        return false;
    }

    public static void removeCameraOverride(Object owner) {
    }

    public static boolean renderChams(Object a0, Object a1) {
        return false;
    }

    public static int renderMode() {
        return 0;
    }

    public static boolean resolvePendingTarget(Object a0) {
        return false;
    }

    public static boolean restoreSlot() {
        return false;
    }

    public static void returnFreeCamToPlayer() {
    }

    public static boolean selfSuppression(Object self, Object entity) {
        return false;
    }

    public static boolean setDeltaMovement(Object a0, Object a1, Object a2, Object a3) {
        return false;
    }

    public static boolean setFrameTime(Object a0, Object a1) {
        return false;
    }

    public static void setFreeCamInstance(Object instance) {
    }

    public static boolean setHeldFlag(Object a0, Object a1) {
        return false;
    }

    public static boolean slamKeyPressed() {
        return false;
    }

    public static boolean slamReady() {
        return false;
    }

    public static void startComboLunge() {
    }

    public static void suppressEntity(Object entity, boolean suppress) {
    }

    public static boolean swapHotbarSlot(Object a0) {
        return false;
    }

    public static double targetPropA(Object target) {
        return 0.0;
    }

    public static double targetPropB(Object target) {
        return 0.0;
    }

    public static double targetPropC(Object target) {
        return 0.0;
    }

    public static long tickTime() {
        return 0L;
    }

    public static Iterable<Entity> trackedEntities() {
        return Collections.emptyList();
    }

    public static Object world() {
        return null;
    }

    public static boolean wtapActive() {
        return false;
    }

    public static boolean wtapAttackCheck(Object a0) {
        return false;
    }

    public static boolean wtapOnAttack(Object a0) {
        return false;
    }

    public static void setCameraDistance(float distance, boolean clip) {
    }

    public static void setGammaOption(Object player, double value) {
    }

    public static void interactTarget(Object target, boolean throughWalls) {
    }

    public static double[] entityVelocity(Object entity) {
        return new double[3];
    }

    public static boolean canReachTarget(Object target, double yaw, double pitch, double reach) {
        return false;
    }

    public static boolean canDrawEntityOutlines() {
        return false;
    }

    public static void drawTrailLine(double x, double y, double z, int color, float progress) {
    }

    public static void drawLandingBox(double x, double y, double z, int color, float progress) {
    }

    public static boolean withinFov(double[] a, double[] b, double fov) {
        return false;
    }

    public static void resetAttackStrength(Object player) {
    }

    public static String heldItemName() {
        return "";
    }

    public static void onFakePlayerRemoved(Object entity) {
    }

    public static boolean isFriendTeleportRequest(String msg) {
        return false;
    }

    public static void drawTntTimer(Object entity) {
    }

    public static boolean addCameraOverride() {
        return false;
    }

    public static boolean applyFreeCamPosition(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5) {
        return false;
    }

    public static boolean applyGammaForFrame(Object a0, Object a1, Object a2) {
        return false;
    }

    public static boolean applyProjectileAim(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6) {
        return false;
    }

    public static boolean attackAllowed(Object a0) {
        return false;
    }

    public static boolean beginAttack() {
        return false;
    }

    public static boolean canAttackTarget(Object a0, Object a1) {
        return false;
    }

    public static boolean cancelPendingTarget(Object a0) {
        return false;
    }

    public static boolean comboAttackReady(Object a0, Object a1) {
        return false;
    }

    public static boolean completeAttack(Object a0) {
        return false;
    }

    public static boolean drawBox(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6) {
        return false;
    }

    public static boolean drawBoxOutline(Object a0, Object a1, Object a2) {
        return false;
    }

    public static boolean fillBoxes(Object a0, Object a1) {
        return false;
    }

    public static boolean findThroughEntities(Object a0, Object a1, Object a2) {
        return false;
    }

    public static boolean handToStunSlam(Object a0, Object a1, Object a2) {
        return false;
    }

    public static boolean hasNewFrameTime(Object a0, Object a1) {
        return false;
    }

    public static boolean initFreeCamPosition(Object a0) {
        return false;
    }

    public static boolean notifyModuleState(Object a0, Object a1) {
        return false;
    }

    public static boolean onFreeCamWorldGone(Object a0) {
        return false;
    }

    public static boolean prepareProjectileAim(Object a0, Object a1) {
        return false;
    }

    public static boolean removeCameraOverride() {
        return false;
    }

    public static boolean returnFreeCamToPlayer(Object a0) {
        return false;
    }

    public static boolean startComboLunge(Object a0, Object a1) {
        return false;
    }

    public static void addRotation(float yaw, float pitch) {
    }

    public static final class KeyState {
        private final boolean[] keys = new boolean[7];

        public boolean attack() {
            return this.keys[0];
        }

        public boolean back() {
            return this.keys[1];
        }

        public boolean left() {
            return this.keys[2];
        }

        public boolean right() {
            return this.keys[3];
        }

        public boolean forward() {
            return this.keys[4];
        }

        public boolean jump() {
            return this.keys[5];
        }

        public boolean sneak() {
            return this.keys[6];
        }
    }

    public static final class EventQuery {
        public final List<EventEntry> events = new ArrayList<EventEntry>();
        public int nextDelaySeconds = -1;
    }

    public static final class EventEntry {
        public String name = "";
        public int type;
        public int seconds;
        public boolean hasPosition;
        public int x;
        public int y;
        public int z;
    }

    public static interface ChunkBlockConsumer {
        public void accept(int var1, int var2, Object var3);
    }

    public static final class PlayerEspStyle {
        public int color;
        public int friendColor;
        public float glow;
        public float halo;
        public boolean throughWalls;
        public double lineWidth;
        public boolean distanceScale;
        public int lineColor;
        public boolean outline;
        public int outlineColor;
        public boolean fill;
        public int fillColor;
        public boolean boxGlow;
        public float boxGlowRadius;
        public float boxGlowIntensity;
        public float glowRamp;
    }

    public static final class BoardSection {
        public String name() {
            return "";
        }

        public List<String> members() {
            return Collections.emptyList();
        }
    }
}

