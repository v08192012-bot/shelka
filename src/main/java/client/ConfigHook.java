/*
 * ShelkaLegit Config Hook
 * Loaded by Fabric as a separate client entrypoint.
 * Starts a background thread that loads config after native DLL init,
 * and periodically saves config.
 */
package client;

import net.fabricmc.api.ClientModInitializer;

public class ConfigHook implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
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
