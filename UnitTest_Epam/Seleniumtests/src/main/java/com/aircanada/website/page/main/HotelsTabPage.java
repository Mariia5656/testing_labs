package com.aircanada.website.page.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.aircanada.website.utils.Waiters.waitVisibility;

public class HotelsTabPage extends MainPage {

    @FindBy(xpath = "//input[@id='hotels_location']")
    private WebElement locationField;

    @FindBy(xpath = "//*[@id='hotelLocationListId_0_0_locationListItem_0']")
    private WebElement locationFirstEntryField;

    @FindBy(xpath = "//*[@id='hotel_checkin_date_wrapper']")
    private WebElement startDateOpenButton;

    @FindBy(xpath = "//div[contains(@class, 'ui-datepicker-group-first')]//td[not(contains(@class, 'ui-state-disabled'))]")
    private WebElement startFirstAvailableDateButton;

    @FindBy(xpath = "//*[@data-dev-keyvent-id='hotel_return_date']")
    private WebElement endDateOpenButton;

    @FindBy(xpath = "//div[contains(@class, 'ui-datepicker-group-last')]//td[@data-date='31']")
    private WebElement endLastAvailableDateButton;

    public HotelsTabPage(WebDriver driver) {
        super(driver);
    }

    public HotelsTabPage setFirstAvailableStartDate() {
        startDateOpenButton.click();
        startFirstAvailableDateButton.click();
        return this;
    }

    public HotelsTabPage setLastAvailableStartDate() {
        endDateOpenButton.click();
        endLastAvailableDateButton.click();
        return this;
    }

    public HotelsTabPage setLocation(String name) {
        locationField.sendKeys(name);
        if (waitVisibility(driver, locationFirstEntryField, WAIT_TIME))
            locationFirstEntryField.click();
        return this;
    }


}
