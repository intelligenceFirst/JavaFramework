package Actions;

import org.openqa.selenium.WebDriver;

/**
 * Created by james on 2/3/2019.
 */
public class Actions {

    private ElementActions elementActions;
    private BrowserActions browserActions;

    public Actions(WebDriver driver) {
        elementActions = new ElementActions(driver);
        browserActions = new BrowserActions(driver);
    }
}
