package com.aircanada.website.framework.pages;

import com.aircanada.website.framework.core.driver.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {

    protected static final int WAIT_TIME = 5;
    protected WebDriver driver;

    public AbstractPage() {
        this.driver = Browser.getInstance().getWebDriver();
        PageFactory.initElements(driver, this);
    }
}
