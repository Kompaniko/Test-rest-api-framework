package utils;


public class ConfigManager {

    private static ConfigManager manager;

    private ConfigManager() {}

    public static ConfigManager getInstance() {
        if (manager == null) {
            synchronized (ConfigManager.class) {
                if (manager == null) {
                    manager = new ConfigManager();
                }
            }
        }
        return manager;
    }

    public String getString(String key) {
        String value = System.getProperty(key);
        if (value == null) {
            switch (key) {
                case "base_url":
                    value = Config.getBaseUrl();
                    break;
                case "port":
                    value = Integer.toString(Config.getPort());
                    break;
                default:
                    throw new IllegalArgumentException("Invalid key: " + key);
            }
        }
        return value;
    }
}
