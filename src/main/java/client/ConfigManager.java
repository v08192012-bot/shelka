/*
 * ShelkaLegit Config Manager
 * Auto-saves all module settings on game exit and loads them on startup.
 */
package client;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ConfigManager {
    private static final String CONFIG_DIR = "shelkalegit";
    private static final String CONFIG_FILE = "config.txt";
    private static final String VERSION = "# ShelkaLegit Config v1";
    private static volatile boolean loaded = false;

    private ConfigManager() {
    }

    public static void load() {
        try {
            Path dir = Path.of(System.getProperty("user.home"), CONFIG_DIR);
            Files.createDirectories(dir);
            Path file = dir.resolve(CONFIG_FILE);
            if (!Files.exists(file)) {
                return;
            }
            byte[] raw = Files.readAllBytes(file);
            String content = new String(raw, StandardCharsets.UTF_8);
            String[] lines = content.split("\n");

            Map<String, Feature> featureMap = new HashMap<>();
            for (Feature f : Modules.getInstances()) {
                featureMap.put(f.getName(), f);
            }

            for (String line : lines) {
                if (line.startsWith("#") || line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split("\\|", -1);
                if (parts.length < 2) {
                    continue;
                }
                String type = parts[0];
                Feature feature = featureMap.get(parts[1]);
                if (feature == null) {
                    continue;
                }
                if (type.equals("FEATURE") && parts.length >= 3) {
                    feature.setEnabled(Boolean.parseBoolean(parts[2]));
                } else if (type.equals("SETTING") && parts.length >= 5) {
                    applySetting(feature, parts[2], parts[3], parts[4], parts);
                }
            }
            loaded = true;
            System.out.println("[ShelkaLegit] Config loaded from " + file);
        } catch (Throwable t) {
            System.out.println("[ShelkaLegit] Config load failed: " + t);
        }
    }

    private static void applySetting(Feature feature, String settingName, String settingType, String value, String[] parts) {
        for (Setting s : feature.getSettings()) {
            if (!s.getName().equals(settingName)) {
                continue;
            }
            try {
                if (settingType.equals("BOOLEAN")) {
                    s.setBoolean(Boolean.parseBoolean(value));
                } else if (settingType.equals("NUMBER")) {
                    s.setNumber(Double.parseDouble(value));
                } else if (settingType.equals("MODE")) {
                    s.setMode(value);
                    if (parts.length >= 6 && !parts[5].isEmpty()) {
                        String[] selected = parts[5].split(",");
                        for (String sel : selected) {
                            if (!sel.isEmpty()) {
                                s.setSelected(sel, true);
                            }
                        }
                    }
                } else if (settingType.equals("COLOR")) {
                    s.setColor((int)Long.parseLong(value, 16));
                } else if (settingType.equals("GRADIENT")) {
                    s.setColor((int)Long.parseLong(value, 16));
                    if (parts.length >= 6) {
                        s.setSecondaryColor((int)Long.parseLong(parts[5], 16));
                    }
                } else if (settingType.equals("KEYBIND")) {
                    s.setKey((int)Long.parseLong(value));
                } else if (settingType.equals("TEXT")) {
                    s.setText(value);
                }
            } catch (NumberFormatException e) {
                // Skip invalid values
            }
            return;
        }
    }

    public static void save() {
        try {
            Path dir = Path.of(System.getProperty("user.home"), CONFIG_DIR);
            Files.createDirectories(dir);
            Path file = dir.resolve(CONFIG_FILE);

            StringBuilder sb = new StringBuilder();
            sb.append(VERSION).append('\n');

            for (Feature feature : Modules.getInstances()) {
                sb.append("FEATURE|").append(feature.getName()).append('|').append(feature.isEnabled()).append('\n');
                for (Setting s : feature.getSettings()) {
                    appendSetting(sb, feature, s);
                }
            }

            Files.write(file, sb.toString().getBytes(StandardCharsets.UTF_8));
            System.out.println("[ShelkaLegit] Config saved to " + file);
        } catch (Throwable t) {
            System.out.println("[ShelkaLegit] Config save failed: " + t);
        }
    }

    private static void appendSetting(StringBuilder sb, Feature feature, Setting s) {
        String name = s.getName();
        Setting.Type type = s.getType();

        if (type == Setting.Type.BOOLEAN) {
            sb.append("SETTING|").append(feature.getName()).append('|').append(name).append('|')
              .append("BOOLEAN|").append(s.getBoolean()).append('\n');
        } else if (type == Setting.Type.NUMBER) {
            sb.append("SETTING|").append(feature.getName()).append('|').append(name).append('|')
              .append("NUMBER|").append(s.getNumber()).append('\n');
        } else if (type == Setting.Type.MODE) {
            StringBuilder selected = new StringBuilder();
            for (String sel : s.getSelectedModes()) {
                if (selected.length() > 0) {
                    selected.append(',');
                }
                selected.append(sel);
            }
            sb.append("SETTING|").append(feature.getName()).append('|').append(name).append('|')
              .append("MODE|").append(s.getMode()).append('|').append(selected).append('\n');
        } else if (type == Setting.Type.COLOR) {
            sb.append("SETTING|").append(feature.getName()).append('|').append(name).append('|')
              .append("COLOR|").append(Integer.toHexString(s.getColor())).append('\n');
        } else if (type == Setting.Type.GRADIENT) {
            sb.append("SETTING|").append(feature.getName()).append('|').append(name).append('|')
              .append("GRADIENT|").append(Integer.toHexString(s.getColor())).append('|')
              .append(Integer.toHexString(s.getSecondaryColor())).append('\n');
        } else if (type == Setting.Type.KEYBIND) {
            sb.append("SETTING|").append(feature.getName()).append('|').append(name).append('|')
              .append("KEYBIND|").append(s.getKey()).append('\n');
        } else if (type == Setting.Type.TEXT) {
            sb.append("SETTING|").append(feature.getName()).append('|').append(name).append('|')
              .append("TEXT|").append(s.getText()).append('\n');
        }
    }

    public static boolean isLoaded() {
        return loaded;
    }
}
