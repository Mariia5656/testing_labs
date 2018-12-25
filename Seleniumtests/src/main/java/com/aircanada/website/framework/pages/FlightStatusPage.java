package com.aircanada.website.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.aircanada.website.framework.utils.Waiters.waitForPageLoad;
import static com.aircanada.website.framework.utils.Waiters.waitVisibilityOfWebElement;

public class FlightStatusPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='error-msgs']/div")
    private WebElement errorMessage;

    public FlightStatusPage() {
        waitForPageLoad(driver, WAIT_TIME);
    }

    public String getErrorText() {
        waitVisibilityOfWebElement(driver, errorMessage, WAIT_TIME);
        return errorMessage.getText().replaceAll("\\r\\n|\\r|\\n", "");
    }
}
