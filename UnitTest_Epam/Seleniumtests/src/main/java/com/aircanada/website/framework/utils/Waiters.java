package com.aircanada.website.framework.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {
    public static void waitForPageLoad(WebDriver driver, int timeout) {
        ExpectedCondition<Boolean> pageLoadCondition = webDriver ->
                ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        new WebDriverWait(driver, timeout).until(pageLoadCondition);
    }

    public static void waitVisibilityOfWebElement(WebDriver driver, WebElement webElement, int seconds) {
        new WebDriverWait(driver, seconds)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public static boolean waitVisibility(WebDriver driver, WebElement webElement, int seconds) {
        try {
            new WebDriverWait(driver, seconds)
                    .until(ExpectedConditions.visibilityOf(webElement));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
