package EnvConfigurations;

import Helpers.FileHelper;
import org.json.JSONObject;
import org.junit.Assert;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by james on 2/3/2019.
 */
public class EnvironmentConfiguration {

    public static String getPropertyValue(String key) {
        return getPropertiesValue(key);
    }

    /**
     * <b>Description:</b> Retrieves an environment config value from the given key.
     * @param key
     * @return
     */
    public static String getEnvironmentConfigValue(String key) {
        JSONObject json = getConfigurations();
        return json.getString(key);
    }

    /**
     * <b>Description:</b> Retrieves the configurations from the environment config (based on the environment that is specified in the config.properties file).
     * @return the config values as a JSONObject.
     */
    public static JSONObject getConfigurations() {
        JSONObject json = null;

        try {
            String environment = getPropertiesValue("environment");

            //TODO: Figure out a better way to look for the config files. We can't rely on them always being in src/main/resources
            String configs = FileHelper.retrieveFileContents(environment + ".json", "src", "main", "resources", "configurations");

            json = new JSONObject(configs);
        } catch (Exception e) {

        }

        return json;
    }

    /**
     * <b>Description:</b> Retrieves a value from the config.properties file based on the provided key.
     * @param propertyKey
     * @return
     */
    private static String getPropertiesValue(String propertyKey) {
        String value = "";
        Properties prop = new Properties();
        InputStream input = null;

        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            input = loader.getResourceAsStream("config.properties");

            // load the file
            prop.load(input);

            value = prop.getProperty(propertyKey);
        } catch (Exception e) {
            Assert.fail(String.format("Error while trying to retrieve '%1s' from '%2s'.", propertyKey, "config.properties"));
        } finally {
            if (null != input) {
                try {
                    input.close();
                } catch (IOException ioe) {
                    Assert.fail(String.format("Error while trying to close input stream. %1s", ioe.getMessage()));
                }
            }
        }

        return value;
    }
}
