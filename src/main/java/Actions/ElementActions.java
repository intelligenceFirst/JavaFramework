package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by james on 8/4/2018.
 */
public class ElementActions {

    private WebDriver driver;

    public ElementActions(WebDriver driver) { this.driver = driver; }

    /**
     * <b>Description:</b> Clear the text from a page element.
     * @param pageElement
     * @throws Exception
     */
    public void Clear(By pageElement) throws Exception {
        try {
            driver.findElement(pageElement).clear();
        } catch (Exception e) {
            throw e;
        }
    }
}
