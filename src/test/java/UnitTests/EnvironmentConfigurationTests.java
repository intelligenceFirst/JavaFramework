package UnitTests;

import EnvConfigurations.EnvironmentConfiguration;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by james on 2/3/2019.
 */
public class EnvironmentConfigurationTests {

    @Test
    public void getConfigurationsTest() {
        JSONObject configs = EnvironmentConfiguration.getConfigurations();
        Assert.assertEquals("is awesome", configs.getString("password"), "The config values didn't match.");
    }

    @Test
    public void getValueTest() {
        String password = EnvironmentConfiguration.getEnvironmentConfigValue("password");
        Assert.assertEquals("is awesome", password, "The config values didn't match.");
    }
}
