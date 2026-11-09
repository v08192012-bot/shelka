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

public final class BlockESP
extends Feature {
    public static final String MODULE = "block_esp";
    public static final String DISPLAY = "\u0411\u043b\u043e\u0441\u043a\u0415\u0417\u041f";
    public static final int VTABLE_RVA = 12335800;
    public static final long RVA_ON_TICK = 2735200415376L;
    public static final long RVA_ON_RENDER = 2735200418896L;
    public static final long RVA_ON_ENABLE = 2735200409696L;
    public static final long RVA_ON_DISABLE = 2735200409712L;
    public static final long RVA_LAMBDA_VISIBILITY = 2735200427168L;
    private static final int RAYCAST_LIMIT = 6;
    private static final int NO_SLOT = -1;
    private static final int CHUNK_RADIUS_MARGIN = 2;
    private static final long FNV_OFFSET_BASIS = -3750763034362895579L;
    private static final long FNV_PRIME = 1099511628211L;
    private static final int SCAN_BUDGET_PER_TICK = 12000;
    private static final int SCAN_LO = -28;
    private static final int SCAN_HI = 29;
    private static final int SCAN_RADIUS = 171;
    private final List<int[]> blocks = new ArrayList<int[]>();
    private final List<Byte> blockFlags = new ArrayList<Byte>();
    private final List<Object> chunkScan = new ArrayList<Object>();
    private final List<Object> raycastScan = new ArrayList<Object>();
    private final List<Object> renderList = new ArrayList<Object>();
    private final List<Object> tntDebris = new ArrayList<Object>();
    private final List<Object> listed = new ArrayList<Object>();
    private final List<Object> listedFlags = new ArrayList<Object>();
    private boolean rebuild;
    private boolean chunkListDirty;
    private boolean filterActive;
    private int scanBudget;
    private int cachedCount = -1;
    private boolean paused;

    public BlockESP() {
        super(MODULE, DISPLAY, Category.Render);
        this.add(Setting.mode("mode", "Box", "Box", "Corners", "Fill"));
        this.add(Setting.number("corner_size", 0.3, 0.1, 1.0, 0.1));
        this.add(Setting.bool("unlimited_range", false));
        this.add(Setting.number("range", 32.0, 16.0, 912.0, 8.0));
        this.add(Setting.number("fill_opacity", 0.3, 0.1, 1.0, 0.1));
        this.add(Setting.bool("rotated_only", false));
        this.add(Setting.bool("tracers", false));
        this.add(Setting.bool("tnt_debris", false));
        this.add(Setting.mode("block_list", "Ores", "Ores", "Containers", "Custom"));
    }

    public List<int[]> blocks() {
        return this.blocks;
    }

    public List<Byte> blockFlags() {
        return this.blockFlags;
    }

    public boolean rebuildPending() {
        return this.rebuild;
    }

    public void setRebuild(boolean value) {
        this.rebuild = value;
    }

    public boolean filterActive() {
        return this.filterActive;
    }

    public boolean paused() {
        return this.paused;
    }

    public int cachedCount() {
        return this.cachedCount;
    }

    public List<Object> renderList() {
        return this.renderList;
    }

    public List<Object> chunkScan() {
        return this.chunkScan;
    }

    public List<Object> raycastScan() {
        return this.raycastScan;
    }

    public List<Object> tntDebris() {
        return this.tntDebris;
    }

    public List<Object> listed() {
        return this.listed;
    }

    public List<Object> listedFlags() {
        return this.listedFlags;
    }

    @Override
    public void onEnable() {
        this.rebuild = true;
        this.reset();
    }

    @Override
    public void onDisable() {
        this.reset();
    }

    public void reset() {
        this.blocks.clear();
        this.blockFlags.clear();
        this.chunkScan.clear();
        this.raycastScan.clear();
        this.renderList.clear();
        this.tntDebris.clear();
        this.listed.clear();
        this.listedFlags.clear();
        this.cachedCount = -1;
        this.scanBudget = 0;
        this.chunkListDirty = false;
        this.filterActive = false;
    }

    @Override
    public void onTick() {
        int index;
        if (!Client.inGame()) {
            return;
        }
        if (this.chunkScan.isEmpty()) {
            List<Object> loaded = Client.loadedChunks();
            this.chunkScan.clear();
            this.chunkScan.addAll(loaded);
        }
        if (this.rebuild) {
            this.rebuild = false;
            this.blocks.clear();
            this.blockFlags.clear();
            int count = Client.blockEntryCount(this);
            if (count != 0) {
                this.listed.clear();
                this.listedFlags.clear();
                for (index = 0; index < count; ++index) {
                    this.listed.add(Client.blockEntryColor(this, index));
                    this.listedFlags.add(Client.blockEntryFlag(this, index));
                }
                Client.collectBlocksByList(this, this.listed);
                this.listed.clear();
            }
        }
        if (!this.paused) {
            this.pruneFarChunks();
            this.collectRaycastChunks();
            if (!this.chunkScan.isEmpty()) {
                int budget = 6;
                for (index = 0; index < this.chunkScan.size(); ++index) {
                    if (budget < 1) {
                        return;
                    }
                    Object entry = this.chunkScan.get(index);
                    if (!Client.blockEspRaycastVisible(this, entry)) continue;
                    this.scanChunk(Client.chunkX(entry), Client.chunkZ(entry));
                    --budget;
                }
            }
        } else {
            this.refreshList();
        }
    }

    public void pruneFarChunks() {
        Object entry;
        int index;
        double[] position = Client.entityPosition(Client.player());
        int radius = Client.viewDistanceChunks() + 2;
        int playerChunkX = (int)Math.floor(position[0]) >> 4;
        int playerChunkZ = (int)Math.floor(position[2]) >> 4;
        for (index = this.chunkScan.size() - 1; index >= 0; --index) {
            entry = this.chunkScan.get(index);
            if (Math.abs(Client.chunkX(entry) - playerChunkX) <= radius && Math.abs(Client.chunkZ(entry) - playerChunkZ) <= radius) continue;
            this.chunkScan.remove(index);
        }
        for (index = this.raycastScan.size() - 1; index >= 0; --index) {
            entry = this.raycastScan.get(index);
            if (Math.abs(Client.chunkX(entry) - playerChunkX) <= radius && Math.abs(Client.chunkZ(entry) - playerChunkZ) <= radius) continue;
            this.raycastScan.remove(index);
        }
    }

    public void collectRaycastChunks() {
        int hi;
        double[] position = Client.entityPosition(Client.player());
        int viewDistance = Client.viewDistanceChunks();
        int lo = ~viewDistance;
        if (lo > (hi = viewDistance + 1)) {
            return;
        }
        int count = hi - lo + 1;
        int baseX = ((int)Math.floor(position[0]) >> 4) + lo;
        int baseZ = (int)Math.floor(position[2]) >> 4;
        for (int i = 0; i < count; ++i) {
            int chunkX = baseX + i;
            for (int j = 0; j < count; ++j) {
                int chunkZ = baseZ + lo + j;
                if (this.containsChunk(this.raycastScan, chunkX, chunkZ)) continue;
                Client.addRaycastChunk(this, chunkX, chunkZ);
            }
        }
    }

    public void scanChunk(int chunkX, int chunkZ) {
        ArrayList found = new ArrayList();
        int baseX = chunkX << 4;
        int baseZ = chunkZ << 4;
        Client.forEachChunkBlock(chunkX, chunkZ, (blockX, blockZ, state) -> {
            if (!Client.blockMatchesList(this, state)) {
                return;
            }
            found.add(Client.blockEntryOf(this, state, blockX, blockZ));
        });
        Client.storeChunkBlocks(this, chunkX, chunkZ, found);
    }

    public void refreshList() {
        int total;
        int offset;
        if (!this.listed.isEmpty()) {
            int remaining = Client.listedCount(this);
            if (--remaining > 0) {
                Client.setListedCount(this, remaining);
                return;
            }
            this.listedFlags.clear();
            Client.setListedOffset(this, 0);
            for (int x = -28; x < 29; ++x) {
                for (int y = -28; y < 29; ++y) {
                    for (int z = -28; z < 29; ++z) {
                        Client.addListedOffset(this, x, y, z);
                    }
                }
            }
            this.listed.remove(0);
        }
        if ((offset = Client.listedOffset(this)) < (total = Client.listedCount(this))) {
            int end = Math.min(offset + 12000, total);
            while (offset < end) {
                if (Client.listEntryValid(this, offset)) {
                    Client.moveListEntry(this, offset);
                }
                ++offset;
            }
            Client.setListedOffset(this, offset);
            if (offset >= total) {
                this.listed.clear();
            }
        }
    }

    private static long chunkHash(int chunkZ, int chunkX) {
        long hash = -3750763034362895579L;
        hash = (hash ^ (long)chunkZ & 0xFFL) * 1099511628211L;
        hash = (hash ^ (long)(chunkZ >>> 8) & 0xFFL) * 1099511628211L;
        hash = (hash ^ (long)(chunkZ >>> 16) & 0xFFL) * 1099511628211L;
        hash = (hash ^ (long)(chunkZ >>> 24) & 0xFFL) * 1099511628211L;
        hash = (hash ^ (long)chunkX & 0xFFL) * 1099511628211L;
        hash = (hash ^ (long)(chunkX >>> 8) & 0xFFL) * 1099511628211L;
        hash = (hash ^ (long)(chunkX >>> 16) & 0xFFL) * 1099511628211L;
        hash = (hash ^ (long)(chunkX >>> 24) & 0xFFL) * 1099511628211L;
        return hash;
    }

    private boolean containsChunk(List<Object> list, int chunkX, int chunkZ) {
        long hash = BlockESP.chunkHash(chunkZ, chunkX) & Client.chunkHashMask(this);
        for (Object entry : list) {
            if (Client.chunkHashOf(entry) != hash || Client.chunkX(entry) != chunkX || Client.chunkZ(entry) != chunkZ) continue;
            return true;
        }
        return false;
    }

    @Override
    public void onRender() {
        if (!this.paused) {
            if (this.renderList.isEmpty()) {
                return;
            }
            Client.renderBlockEspSolid(this);
        } else {
            if (this.tntDebris.isEmpty()) {
                return;
            }
            this.renderList.clear();
            for (Object entry : this.tntDebris) {
                this.renderList.add(entry);
            }
        }
        Client.renderBlockEsp(this);
    }

    public double cornerSize() {
        Setting setting = this.setting("corner_size");
        return setting == null ? 0.25 : setting.getNumber();
    }

    public double fillOpacity() {
        Setting setting = this.setting("fill_opacity");
        return setting == null ? 0.25 : setting.getNumber();
    }

    private List<String> settingModes(String name) {
        Setting setting = this.setting(name);
        return setting == null ? new ArrayList() : setting.getModes();
    }

    private Setting setting(String name) {
        for (Setting setting : this.getSettings()) {
            if (!setting.getName().equals(name)) continue;
            return setting;
        }
        return null;
    }
}

