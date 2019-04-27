package com.aircanada.website.framework.pages.main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.aircanada.website.framework.utils.Waiters.waitForPageLoad;

public class MyBookingsTabPage extends MainPage {

    @FindBy(xpath = "//input[@id='bookings_bookingReference']")
    private WebElement bookingReferenceField;

    @FindBy(xpath = "//input[@id='bookings_passenger_lastname']")
    private WebElement bookingPassengerLastNameField;

    @FindBy(xpath = "//button[@id='btnBookingSearch']")
    private WebElement findButton;

    public MyBookingsTabPage setBookingReference(String data) {
        bookingReferenceField.sendKeys(data);
        return this;
    }

    public MyBookingsTabPage setPassengerLastName(String lastName) {
        bookingPassengerLastNameField.sendKeys(lastName);
        return this;
    }

    public MyBookingsTabPage findBooking() {
        findButton.click();
        waitForPageLoad(driver, WAIT_TIME);
        return this;
    }

}
