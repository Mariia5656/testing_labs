package com.aircanada.website.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {

    protected static final int WAIT_TIME = 5;
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
