package Helpers;

import EnvConfigurations.EnvironmentConfiguration;
import Logging.IFLogger;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by james on 2/9/2019.
 */
public class DriverHelper {

    private IFLogger _log = new IFLogger("DriverHelper");

    /**
     * <b>Description:</b> Initializes webdriver. The webdriver that gets initialized based on what the value of "browser" is in the config.properties file.
     * @return
     */
    public WebDriver initializeWebDriver() {
        WebDriver driver = null;

        try {
            String browser = EnvironmentConfiguration.getPropertyValue("browser");

            switch (browser.toLowerCase()) {
                case "c":
                    _log.debug("Attempting to initialize chrome driver");
                    System.setProperty("webdriver.chrome.driver", getDriver(browser).getAbsolutePath());
                    ChromeOptions cOptions = new ChromeOptions();
                    cOptions.addArguments("--start-maximized");
                    driver = new ChromeDriver(cOptions);
                    _log.debug("Successfully initialized chrome driver");
                    break;
                case "f":
                    System.setProperty("webdriver.gecko.driver", getDriver(browser).getAbsolutePath());
                    FirefoxOptions fOptions = new FirefoxOptions();
                    driver = new FirefoxDriver(fOptions);
                    _log.debug("Successfully initialized firefox driver");
                    break;
                case "ie":
                    System.setProperty("webdriver.ie.driver", getDriver(browser).getAbsolutePath());
                    InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                    ieOptions.requireWindowFocus();
                    ieOptions.introduceFlakinessByIgnoringSecurityDomains();
                    ieOptions.destructivelyEnsureCleanSession();
                    driver = new InternetExplorerDriver();
                    _log.debug("Successfully initialized IE driver");
                    break;
                case "e":
                    System.setProperty("webdriver.edge.driver", getDriver(browser).getAbsolutePath());
                    driver = new EdgeDriver();
                    _log.debug("Successfully initialized edge driver");
                    break;
                case "h":
                    System.setProperty("webdriver.chrome.driver", getDriver(browser).getAbsolutePath());
                    ChromeOptions hcOptions = new ChromeOptions();
                    hcOptions.addArguments("--headless");
                    driver = new ChromeDriver(hcOptions);
                    _log.debug("Successfully initialized chrome headless driver");
                    break;
                default:
                    //TODO: add log message here
                    break;
            }
        } catch (Exception e) {
            Assert.fail("Error trying to initialize the driver. " + e.getMessage());
        }

        return driver;
    }

    /**
     * <b>Description:</b> Retrieves the driver.exe from the resources/drivers directory and copies it to the drivers directory in target.
     * @param browser
     * @return
     * @throws IOException
     */
    private File getDriver(String browser) throws IOException {
        File driver = null;

        switch (browser.toLowerCase()) {
            case "c":
                driver = getFile("chromedriver.exe");
                break;
            case "f":
                driver = getFile("geckodriver.exe");
                break;
            case "ie":
                driver = getFile("IEDriverServer.exe");
                break;
            case "e":
                driver = getFile("MicrosoftWebDriver.exe");
                break;
            case "h":
                driver = getFile("chromedriver.exe");
                break;
            default:
                break;
        }

        return driver;
    }

    /**
     * <b>Description:</b> Creates a directory called "drivers" if it doesn't exist and then creates a new webdriver executable in that directory if it doesn't exist.
     * @param driverExecutable
     * @return
     * @throws IOException
     */
    private File getFile(String driverExecutable) throws IOException {
        File driverFile;
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("drivers/" + driverExecutable);
        File file = new File("drivers");
        if (!file.exists()) {
            file.mkdirs();
        }
        driverFile = new File("drivers" + File.separator + driverExecutable);
        if (!driverFile.exists()) {
            driverFile.createNewFile();
            FileUtils.copyURLToFile(resource, driverFile);
        }
        return driverFile;
    }
}
