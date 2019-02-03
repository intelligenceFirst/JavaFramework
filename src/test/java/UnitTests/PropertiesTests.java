package UnitTests;

import EnvConfigurations.EnvironmentConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by james on 2/3/2019.
 */
public class PropertiesTests {

    @Test
    public void getBrowserPropertyTest() throws IOException {
        String browser = EnvironmentConfiguration.getPropertiesValue("browser");
        Assert.assertEquals("c", browser, "The browser's didn't match.");
    }

    @Test
    public void getEnvironmentPropertyTest() throws IOException {
        String browser = EnvironmentConfiguration.getPropertiesValue("environment");
        Assert.assertEquals("dev", browser, "The environment's didn't match.");
    }
}
