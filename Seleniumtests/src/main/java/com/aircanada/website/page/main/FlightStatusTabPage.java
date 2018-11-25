package com.aircanada.website.page.main;

import com.aircanada.website.page.FlightStatusPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightStatusTabPage extends MainPage {

    @FindBy(xpath = "//input[@id='status_by_number_flight']")
    private WebElement flightNumberField;

    @FindBy(xpath = "//button[@id='btnStatusByNumberSearch']")
    private WebElement findButton;

    public FlightStatusTabPage(WebDriver driver) {
        super(driver);
    }

    public FlightStatusTabPage setFlightNumber(String number) {
        flightNumberField.sendKeys(number);
        return this;
    }

    public FlightStatusPage findFlight() {
        findButton.click();
        return new FlightStatusPage(driver);
    }
}
