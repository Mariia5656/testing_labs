package com.aircanada.website.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.aircanada.website.utils.Waiters.waitForPageLoad;
import static com.aircanada.website.utils.Waiters.waitVisibilityOfWebElement;

public class FlightStatusPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='error-msgs']/div")
    private WebElement errorMessage;

    public FlightStatusPage(WebDriver driver) {
        super(driver);
        waitForPageLoad(driver, WAIT_TIME);
    }

    public String getErrorText() {
        waitVisibilityOfWebElement(driver, errorMessage, WAIT_TIME);
        return errorMessage.getText().replaceAll("\\r\\n|\\r|\\n", "");
    }
}
