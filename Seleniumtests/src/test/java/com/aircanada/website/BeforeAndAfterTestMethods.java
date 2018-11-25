package com.aircanada.website;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BeforeAndAfterTestMethods {
    private static final int IMPLICITLY_TIMEOUT = 15;
    private static final int WEBDRIVER_WAIT_TIMEOUT = 30;
    protected WebDriver driver;
    protected WebDriverWait driverWait;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Other\\Valiantsin_Boltach\\epam\\SeleniumDistrs\\drivers\\chromedriver-v2.35-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, WEBDRIVER_WAIT_TIMEOUT);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_TIMEOUT, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        driver.quit();
    }
}
