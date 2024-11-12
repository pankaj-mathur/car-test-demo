package utils;

import java.io.IOException;
import java.util.Properties;

/**
 * Utility class to load and provide access to configuration properties.
 * Reads properties from the "config.properties" file on initialization.
 */
public class Config {
    
    /**
     * Properties object that holds configuration key-value pairs.
     */
    private static final Properties properties = new Properties();

    // Static initializer block to load properties from the "config.properties" file.
    static {
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            properties.load(loader.getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * Retrieves the value of a property based on the provided key.
     *
     * @param key the property key
     * @return the property value associated with the specified key, or null if the key does not exist
     */
    public static String getSetting(String key) {
        return properties.getProperty(key);
    }
}

