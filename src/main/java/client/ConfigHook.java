/*
 * ShelkaLegit Config Hook
 * Loaded by Fabric as a separate client entrypoint.
 * Starts a background thread that loads config after native DLL init,
 * and registers a shutdown hook to save config on game exit.
 */
package client;

public class ConfigHook {
    static {
        Thread worker = new Thread(() -> {
            try {
                Thread.sleep(3000L);
                ConfigManager.load();
                Thread saveThread = new Thread(() -> {
                    while (true) {
                        try { Thread.sleep(60000L); } catch (InterruptedException e) { return; }
                        ConfigManager.save();
                    }
                }, "shelkalegit-save");
                saveThread.setDaemon(true);
                saveThread.start();
            } catch (Throwable err) {
                System.out.println("[ShelkaLegit] Config init failed: " + err);
            }
        }, "shelkalegit-config");
        worker.setDaemon(true);
        worker.start();
    }
}
