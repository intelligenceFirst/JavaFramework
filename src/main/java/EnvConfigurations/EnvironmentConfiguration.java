package EnvConfigurations;

import org.json.JSONObject;
import org.junit.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by james on 2/3/2019.
 */
public class EnvironmentConfiguration {

    private static String filename = "config.properties";
    private static InputStream input;

    public static String getPropertiesValue(String propertyKey) throws IOException {
        String env = "";
        Properties prop = new Properties();

        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            input = loader.getResourceAsStream(filename);

            // load the file
            prop.load(input);

            env = prop.getProperty(propertyKey);
        } catch (Exception e) {
            Assert.fail(String.format("Error while trying to retrieve '%1s' from '%2s'.", propertyKey, filename));
        } finally {
            if (null != input) {
                try {
                    input.close();
                } catch (IOException ioe) {
                    Assert.fail("Error while trying to close input stream.");
                }
            }
        }

        return env;
    }
}
