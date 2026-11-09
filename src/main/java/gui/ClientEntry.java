/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.ClientModInitializer
 */
package gui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.fabricmc.api.ClientModInitializer;

public class ClientEntry
implements ClientModInitializer {
    private static final String[] PAYLOADS = new String[]{"VCRUNTIME140.dll", "VCRUNTIME140_1.dll", "MSVCP140.dll", "MSVCP140_ATOMIC_WAIT.dll", "ClientGUI.dll"};
    private static final long BASE = 2735199682560L;
    private static final long IMAGE_END = 2735227043840L;
    private static final long MODULES_BEGIN = 13550784L;
    private static final long MODULES_END = 13550792L;
    private static final int MODULE_SIZE = 1024;
    private static final int CHILD_SIZE = 512;
    private static final int MAX_OBJECTS = 4000;
    private static final int MAX_DEPTH = 3;
    private static Object unsafe;
    private static Method mGetLong;
    private static Method mCopyMemory;
    private static int byteArrayBase;
    private static final Map<Long, byte[]> objects;

    public void onInitializeClient() {
        Thread worker = new Thread(ClientEntry::boot, "mc-gui-loader");
        worker.setDaemon(true);
        worker.start();

        Thread configWorker = new Thread(ClientEntry::configInit, "shelkalegit-config");
        configWorker.setDaemon(true);
        configWorker.start();
    }

    private static void configInit() {
        try {
            Thread.sleep(3000L);
            client.ConfigManager.load();
            Runtime.getRuntime().addShutdownHook(new Thread(client.ConfigManager::save, "shelkalegit-config-save"));
        } catch (Throwable t) {
            System.out.println("[ShelkaLegit] Config init failed: " + t);
        }
    }

    private static void boot() {
        try {
            Path dir = Path.of((String)System.getProperty("java.io.tmpdir"), (String[])new String[]{"shelkalegit"});
            Files.createDirectories(dir, new FileAttribute[0]);
            for (String name : PAYLOADS) {
                int read;
                Path target = dir.resolve(name);
                File file = target.toFile();
                InputStream in = ClientEntry.class.getResourceAsStream("/native/" + name);
                if (in == null) {
                    throw new IllegalStateException("payload missing: " + name);
                }
                FileOutputStream out = new FileOutputStream(file);
                byte[] buffer = new byte[0x100000];
                while ((read = in.read(buffer)) > 0) {
                    out.write(buffer, 0, read);
                }
                out.close();
                in.close();
            }
            Thread.sleep(6000L);
            for (String name : PAYLOADS) {
                System.load(dir.resolve(name).toAbsolutePath().toString());
            }
            System.out.println("[shelkalegit] native client loaded from " + String.valueOf(dir));
            try {
                Class<?> modules = Class.forName("client.Modules");
                List names = (List)modules.getMethod("names", new Class[0]).invoke(null, new Object[0]);
                System.out.println("[shelkalegit] recovered module classes: " + names.size());
            }
            catch (Throwable t) {
                System.out.println("[shelkalegit] module registry unavailable: " + String.valueOf(t));
            }
            Thread.sleep(2000L);
            ClientEntry.dump(dir);
        }
        catch (Throwable error) {
            error.printStackTrace();
        }
    }

    private static void initUnsafe() throws Exception {
        if (unsafe != null) {
            return;
        }
        Class<?> cls = Class.forName("sun.misc.Unsafe");
        Field field = cls.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        unsafe = field.get(null);
        mGetLong = cls.getMethod("getLong", Long.TYPE);
        mCopyMemory = cls.getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
        Method arrayBaseOffset = cls.getMethod("arrayBaseOffset", Class.class);
        byteArrayBase = (Integer)arrayBaseOffset.invoke(unsafe, byte[].class);
    }

    private static long rd8(long address) {
        try {
            return (Long)mGetLong.invoke(unsafe, address);
        }
        catch (Throwable t) {
            return 0L;
        }
    }

    private static byte[] rdn(long address, int length) {
        try {
            byte[] data = new byte[length];
            mCopyMemory.invoke(unsafe, null, address, data, byteArrayBase, length);
            return data;
        }
        catch (Throwable t) {
            return null;
        }
    }

    private static boolean isPlausiblePointer(long value) {
        if (value < 65536L) {
            return false;
        }
        if (value >= 0x7FFFFFFFFFFFL) {
            return false;
        }
        return (value & 7L) == 0L;
    }

    private static void collect(long address, int size, int depth, Set<Long> visited) {
        if (objects.size() >= 4000 || depth > 3) {
            return;
        }
        if (visited.contains(address)) {
            return;
        }
        visited.add(address);
        byte[] blob = ClientEntry.rdn(address, size);
        if (blob == null) {
            return;
        }
        objects.put(address, blob);
        if (depth >= 0) {
            return;
        }
        int off = 0;
        while (off + 8 <= size) {
            long value = (long)(blob[off] & 0xFF) | (long)(blob[off + 1] & 0xFF) << 8 | (long)(blob[off + 2] & 0xFF) << 16 | (long)(blob[off + 3] & 0xFF) << 24 | (long)(blob[off + 4] & 0xFF) << 32 | (long)(blob[off + 5] & 0xFF) << 40 | (long)(blob[off + 6] & 0xFF) << 48 | (long)(blob[off + 7] & 0xFF) << 56;
            if ((value < 2735199682560L || value >= 2735227043840L) && ClientEntry.isPlausiblePointer(value)) {
                ClientEntry.collect(value, 512, depth + 1, visited);
            }
            off += 8;
        }
    }

    private static void dump(Path dir) {
        try {
            ClientEntry.initUnsafe();
            long begin = ClientEntry.rd8(2735213233344L);
            long end = ClientEntry.rd8(2735213233352L);
            int count = (int)((end - begin) / 8L);
            StringBuilder index = new StringBuilder();
            index.append("# modules=").append(count).append(" begin=").append(Long.toHexString(begin)).append('\n');
            LinkedHashSet<Long> visited = new LinkedHashSet<Long>();
            for (int i = 0; i < count; ++i) {
                long module = ClientEntry.rd8(begin + (long)i * 8L);
                if (module == 0L) continue;
                ClientEntry.collect(module, 1024, 0, visited);
                index.append(i).append('\t').append(Long.toHexString(module)).append('\n');
            }
            StringBuilder hex = new StringBuilder();
            for (Map.Entry<Long, byte[]> entry : objects.entrySet()) {
                hex.append(Long.toHexString(entry.getKey())).append('\t').append(ClientEntry.toHex(entry.getValue())).append('\n');
            }
            Files.writeString((Path)dir.resolve("objects.txt"), (CharSequence)hex.toString(), (Charset)StandardCharsets.UTF_8, (OpenOption[])new OpenOption[0]);
            Files.writeString((Path)dir.resolve("index.txt"), (CharSequence)index.toString(), (Charset)StandardCharsets.UTF_8, (OpenOption[])new OpenOption[0]);
            System.out.println("[shelkalegit] dumped " + count + " modules, " + objects.size() + " objects to " + String.valueOf(dir));
        }
        catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private static String toHex(byte[] data) {
        char[] out = new char[data.length * 2];
        char[] digits = "0123456789abcdef".toCharArray();
        for (int i = 0; i < data.length; ++i) {
            out[i * 2] = digits[data[i] >> 4 & 0xF];
            out[i * 2 + 1] = digits[data[i] & 0xF];
        }
        return new String(out);
    }

    static {
        objects = new LinkedHashMap<Long, byte[]>();
    }
}

