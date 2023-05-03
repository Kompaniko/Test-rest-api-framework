package utils;

public class Config {
    private static final String BASE_URL = "http://localhost";
    private static final int PORT = 3000;

    private Config() {}

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static int getPort() {
        return PORT;
    }
}
