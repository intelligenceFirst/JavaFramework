package Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by james on 8/4/2018.
 */
public class BrowserActions {

    private WebDriver _driver;

    public BrowserActions(WebDriver driver) {
        _driver = driver;
    }

    /**
     * <b>Description:</b> Retrieves the title from the current page.
     * @return
     * @throws Exception
     */
     public String getPageTitle() throws Exception {
         String title = "";
         try {
             title = _driver.getTitle();
         } catch (Exception e) {
             throw e;
         }

         return title;
     }

    /**
     * <b>Description:</b> Retrieves the url from the currently focused window.
     * @return
     * @throws Exception
     */
     public String getCurrentUrl() throws Exception {
         String url = "";
         try {
             url = _driver.getCurrentUrl();
         } catch (Exception e) {
             throw e;
         }

         return url;
     }

    /**
     * <b>Description:</b> Retrieves the page source from the currently focused window.
     * @return
     * @throws Exception
     */
     public String getPageSource() throws Exception {
         String source = "";
         try {
             source = _driver.getPageSource();
         } catch (Exception e) {
             throw e;
         }

         return source;
     }

    /**
     * <b>Description:</b> Closes the webdriver if it isn't null.
     */
    public void close() {
         if (null != _driver) {
             _driver.close();
         }
     }

    /**
     * <b>Description:</b> Quits the webdriver if it isn't null.
     */
    public void quit() {
        if (null != _driver) {
            _driver.quit();
        }
    }

    /**
     * <b>Description:</b> Retrieves the currently focused window handle.
     * @return
     * @throws Exception
     */
    public String getCurrentWindowHandle() throws Exception {
        String handle = "";
        try {
            handle = _driver.getWindowHandle();
        } catch (Exception e) {
            throw e;
        }

        return handle;
    }

    /**
     * <b>Description:</b> Retrieves the window handles of all the browser windows / tabs.
     * @return
     * @throws Exception
     */
    public Set<String> getCurrentWindowHandles() throws Exception {
        Set<String> handles = new HashSet<>();
        try {
            handles = _driver.getWindowHandles();
        } catch (Exception e) {
            throw e;
        }

        return handles;
    }

    /**
     * <b>Description:</b> Switches to a window with a given window handle.
     * @param handle
     * @return
     */
    public WebDriver switchToWindow(String handle) {
        try {
            return _driver.switchTo().window(handle);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * <b>Description:</b> Switches to a window with a given page title.
     * @param title
     * @return
     * @throws Exception
     */
    public WebDriver switchToWindowWithPagetitle(String title) throws Exception {
        try {
            Set<String> handles = getCurrentWindowHandles();

            for (String handle : handles) {
                if (title.equals(switchToWindow(handle).getTitle())) {
                    return switchToWindow(handle);
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return null;
    }

    /**
     * <b>Description:</b> Checks if an alert dialog is present.
     * @return True if present
     */
    public boolean isAlertPresent() {
        boolean isPresent = false;
        try {
            isPresent = ExpectedConditions.alertIsPresent() != null;
        } catch (Exception e) {
            throw e;
        }

        return isPresent;
    }

    /**
     * <b>Description:</b> Accepts an open alert dialog.
     */
    public void acceptAlert() {
        try {
            if (isAlertPresent()) {
                _driver.switchTo().alert().accept();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * <b>Description:</b> Dismisses an open alert dialog.
     */
    public void dismissAlert() {
        try {
            if (isAlertPresent()) {
                _driver.switchTo().alert().dismiss();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * <b>Description:</b> Retrieves the alert text.
     * @return
     */
    public String getAlertText() {
        String text = "";
        try {
            text = _driver.switchTo().alert().getText();
        } catch (Exception e) {
            throw e;
        }

        return text;
    }

    /**
     * <b>Description:</b> Navigates to the given url.
     * @param url
     */
    public void navigateTo(String url) {
        try {
            _driver.navigate().to(url);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * <b>Description:</b> Simulates clicking the "Forward" button of a browser window.
     */
    public void forward() {
        try {
            _driver.navigate().forward();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * <b>Description:</b> Simulates clicking the "Back" button of a browser window.
     */
    public void back() {
        try {
            _driver.navigate().back();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * <b>Description:</b> Refreshes the current browser window.
     */
    public void refresh() {
        try {
            _driver.navigate().refresh();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * <b>Description:</b> Maximizes the browser window.
     */
    public void maximize() {
        try {
            _driver.manage().window().maximize();
        } catch (Exception e) {
            throw e;
        }
    }
}
