package UnitTests;

import Helpers.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by james on 2/9/2019.
 */
public class DriverHelperTests {

    @Test
    public void chromeDriverTest() {
        DriverHelper helper = new DriverHelper();
        WebDriver driver = helper.initializeWebDriver();
        driver.navigate().to("http://google.com");
        String title = driver.getTitle();
        driver.close();
        Assert.assertEquals("Google", title, "Page title doesn't match.");
    }
}
