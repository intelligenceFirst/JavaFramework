package UnitTests;

import Helpers.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Created by james on 2/9/2019.
 */
public class DriverHelperTests {

    @Test
    public void chromeDriverTest() {
        DriverHelper helper = new DriverHelper();
        WebDriver driver = helper.initializeWebDriver();
    }
}
