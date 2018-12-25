package com.aircanada.website.framework.core.driver;

import com.aircanada.website.framework.common.exceptions.UnknownDriverTypeException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public final class Browser {

    private static final String BROWSER_PROP = "browser";
    private static final String WEBDRIVERS_FOLDER = "src/main/resources/binaries/";
    private static WebDriverTypes defaultDriverType = WebDriverTypes.CHROME;
    private static WebDriverTypes driverType;
    private static WebDriver webDriver;
    private static Browser instance;

    private Browser() {
    }

    public static void setDefaultWebDriverType(WebDriverTypes type) {
        defaultDriverType = type;
    }

    public static Browser getInstance() throws UnknownDriverTypeException {
        driverType = WebDriverTypes.valueOf(System.getProperty(BROWSER_PROP, defaultDriverType.toString()).toUpperCase());
        if (instance == null) {
            webDriver = initDriver(driverType);
            instance = new Browser();
        }
        return instance;
    }

    private static WebDriver initDriver(WebDriverTypes type) throws UnknownDriverTypeException {
        // Кирилл, ну ты же в курсе, что это очень плохо?
        // Это является плохим подходом, потмоу что бинарники максимально желательно хранить не на гите.
        // Да и прогрессивная часть человечества уже начала юзать WebDriverManager (даже Selenide)
        System.setProperty("webdriver.ie.driver", WEBDRIVERS_FOLDER + "IEDriverServer.exe");
        System.setProperty("webdriver.chrome.driver", WEBDRIVERS_FOLDER + "chromedriver.exe");
        System.setProperty("webdriver.opera.driver", WEBDRIVERS_FOLDER + "operadriver.exe");
        System.setProperty("webdriver.edge.driver", WEBDRIVERS_FOLDER + "MicrosoftWebDriver.exe");
        System.setProperty("webdriver.gecko.driver", WEBDRIVERS_FOLDER + "geckodriver.exe");

        WebDriver driver = null;
        switch (type) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case IE:
                driver = new InternetExplorerDriver();
                break;
            case OPERA:
                driver = new OperaDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            default:
                throw new UnknownDriverTypeException("Unknown web driver specified: " + type);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }

    public void exit() {
        try {
            if (webDriver != null) {
                webDriver.quit();
                webDriver = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            instance = null;
            driverType = null;
        }
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public boolean isBrowserAlive() {
        return webDriver != null;
    }
}
