package com.aircanada.website.framework.pages.main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.aircanada.website.framework.utils.Waiters.waitForPageLoad;
import static com.aircanada.website.framework.utils.Waiters.waitVisibility;

public class CheckInTabPage extends MainPage {

    @FindBy(xpath = "//input[@id='checkin_first_name']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='checkin_last_name']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='checkin_aeroplan_or_pnr']")
    private WebElement aeroplanOrBookingReferenceField;

    @FindBy(xpath = "//input[@id='checkin_location']")
    private WebElement departureAirportField;

    @FindBy(xpath = "//*[@id='checkinLocationListOrginId_locationListItem_0']")
    private WebElement departureFirstAirportField;

    @FindBy(xpath = "//button[@id='checin_submit_button']")
    private WebElement checkInButton;

    public CheckInTabPage setAeroplanNumberOrBookingReference(String data) {
        aeroplanOrBookingReferenceField.sendKeys(data);
        return this;
    }

    public CheckInTabPage setLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    public CheckInTabPage setFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
        return this;
    }

    public CheckInTabPage setDepartureAirport(String name) {
        departureAirportField.sendKeys(name);
        if (waitVisibility(driver, departureFirstAirportField, WAIT_TIME))
            departureFirstAirportField.click();
        return this;
    }

    public CheckInTabPage checkIn() {
        checkInButton.click();
        waitForPageLoad(driver, WAIT_TIME);
        return this;
    }

}
