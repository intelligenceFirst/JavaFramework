package Helpers;

import EnvConfigurations.EnvironmentConfiguration;
import org.apache.commons.io.FileUtils;
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

    public WebDriver initializeWebDriver() {
        WebDriver driver = null;

        try {
            String browser = EnvironmentConfiguration.getPropertyValue("browser");

            switch (browser.toLowerCase()) {
                case "c":
                    //TODO: add log message here
                    System.setProperty("webdriver.chrome.driver", getDriver(browser).getAbsolutePath());
                    ChromeOptions cOptions = new ChromeOptions();
                    cOptions.addArguments("--start-maximized");
                    driver = new ChromeDriver(cOptions);
                    //TODO: add log message here
                    break;
                case "f":
                    System.setProperty("webdriver.gecko.driver", getDriver(browser).getAbsolutePath());
                    FirefoxOptions fOptions = new FirefoxOptions();
                    driver = new FirefoxDriver(fOptions);
                    //TODO: add log message here
                    break;
                case "ie":
                    System.setProperty("webdriver.ie.driver", getDriver(browser).getAbsolutePath());
                    InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                    ieOptions.requireWindowFocus();
                    ieOptions.introduceFlakinessByIgnoringSecurityDomains();
                    ieOptions.destructivelyEnsureCleanSession();
                    driver = new InternetExplorerDriver();
                    //TODO: add log message here
                    break;
                case "e":
                    System.setProperty("webdriver.edge.driver", getDriver(browser).getAbsolutePath());
                    driver = new EdgeDriver();
                    //TODO: add log message here
                    break;
                case "h":
                    //TODO: add log message here
                    break;
                default:
                    //TODO: add log message here
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
                break;

            default:
                break;
        }

        return driver;
    }

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
