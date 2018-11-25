package com.aircanada.website.page.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.aircanada.website.utils.Waiters.waitForPageLoad;
import static com.aircanada.website.utils.Waiters.waitVisibility;

public class FlightsTabPage extends MainPage {

    @FindBy(xpath = "//div[@id='passengersInputLabel']")
    private WebElement openPassengersDropdownButton;

    @FindBy(xpath = "//input[@id='origin_R_0']")
    private WebElement flightAirportStartField;

    @FindBy(xpath = "//div[@id='departureDateLabel']")
    private WebElement flightStartDateOpenButton;

    @FindBy(xpath = "//div[contains(@class, 'ui-datepicker-group-first')]//td[not(contains(@class, 'ui-state-disabled'))]")
    private WebElement flightStartFirstAvailableDateButton;

    @FindBy(xpath = "//div[@id='returnDateLabel']")
    private WebElement flightEndDateOpenButton;

    @FindBy(xpath = "//div[contains(@class, 'ui-datepicker-group-last')]//td[@data-date='31']")
    private WebElement flightEndLastAvailableDateButton;

    @FindBy(xpath = "//input[@id='destination_R_0']")
    private WebElement flightAirportEndField;

    @FindBy(xpath = "//*[@id='flightLocationListOrginId0_locationListItem_0']")
    private WebElement flightStartFirstAirportField;

    @FindBy(xpath = "//*[@id='flightLocationListDestinationId0_locationListItem_0']")
    private WebElement flightEndFirstAirportField;

    @FindBy(xpath = "//input[@id='promoCode']")
    private WebElement promoCodeField;

    @FindBy(xpath = "//div[@id='fligthPaxErrorId_0']")
    private WebElement passengersErrorTextBlock;

    @FindBy(xpath = "//*[@id='oneWay']")
    private WebElement oneWayRadiobutton;

    @FindBy(xpath = "//input[@data-se-id='btnFlightsSearchOption2']")
    private WebElement findButton;

    // Adult passengers

    @FindBy(xpath = "//button[@id='btnAdultCountAdd']")
    private WebElement addAdultPassengerButton;

    @FindBy(xpath = "//button[@id='btnAdultCountSub']")
    private WebElement deleteAdultPassengerButton;

    @FindBy(xpath = "//li[@id='flightsPaxType_adt']/div/div")
    private WebElement adultPassengersCountBlock;

    // Youth passengers

    @FindBy(xpath = "//button[@id='btnYouthCountAdd']")
    private WebElement addYouthPassengerButton;

    @FindBy(xpath = "//button[@id='btnYouthCountSub']")
    private WebElement deleteYouthPassengerButton;

    @FindBy(xpath = "//li[@id='flightsPaxType_yth']/div/div")
    private WebElement youthPassengersCountBlock;

    // Children passengers

    @FindBy(xpath = "//button[@id='btnChildCountAdd']")
    private WebElement addChildrenPassengerButton;

    @FindBy(xpath = "//button[@id='btnChildCountSub']")
    private WebElement deleteChildrenPassengerButton;

    @FindBy(xpath = "//li[@id='flightsPaxType_chd']/div/div")
    private WebElement childrenPassengersCountBlock;


    public FlightsTabPage(WebDriver driver) {
        super(driver);
    }

    public FlightsTabPage setAdultPassengers(int count) {
        openPassengersDropdownButton.click();
        int adultPassengersCount = Integer.parseInt(adultPassengersCountBlock.getText());
        if (adultPassengersCount < count) {
            for (int iterator = adultPassengersCount; iterator < count; iterator++) {
                addAdultPassengerButton.click();
            }
        } else {
            for (int iterator = adultPassengersCount; iterator > count; iterator--) {
                deleteAdultPassengerButton.click();
            }
        }
        return this;
    }

    public FlightsTabPage setYouthPassengers(int count) {
        openPassengersDropdownButton.click();
        int youthPassengersCount = Integer.parseInt(youthPassengersCountBlock.getText());
        if (youthPassengersCount < count) {
            for (int iterator = youthPassengersCount; iterator < count; iterator++) {
                addYouthPassengerButton.click();
            }
        } else {
            for (int iterator = youthPassengersCount; iterator > count; iterator--) {
                deleteYouthPassengerButton.click();
            }
        }
        return this;
    }

    public FlightsTabPage setChildrenPassengers(int count) {
        openPassengersDropdownButton.click();
        int childrenPassengersCount = Integer.parseInt(childrenPassengersCountBlock.getText());
        if (childrenPassengersCount < count) {
            for (int iterator = childrenPassengersCount; iterator < count; iterator++) {
                addChildrenPassengerButton.click();
            }
        } else {
            for (int iterator = childrenPassengersCount; iterator > count; iterator--) {
                deleteYouthPassengerButton.click();
            }
        }
        return this;
    }

    public FlightsTabPage findFlight() {
        findButton.click();
        waitForPageLoad(driver, WAIT_TIME);
        return this;
    }

    public FlightsTabPage setStartAirport(String name) {
        flightAirportStartField.sendKeys(name);
        if (waitVisibility(driver, flightStartFirstAirportField, WAIT_TIME))
            flightStartFirstAirportField.click();
        return this;
    }

    public FlightsTabPage setFirstAvailableStartDate() {
        flightStartDateOpenButton.click();
        flightStartFirstAvailableDateButton.click();
        return this;
    }

    public FlightsTabPage setLastAvailableStartDate() {
        flightEndDateOpenButton.click();
        flightEndLastAvailableDateButton.click();
        return this;
    }

    public FlightsTabPage setDestinationAirport(String name) {
        flightAirportEndField.sendKeys(name);
        if (waitVisibility(driver, flightEndFirstAirportField, WAIT_TIME))
            flightEndFirstAirportField.click();
        return this;
    }

    public FlightsTabPage checkOneWayFlight() {
        oneWayRadiobutton.click();
        waitForPageLoad(driver, WAIT_TIME);
        return this;
    }

    public FlightsTabPage setPromoCode(String data) {
        promoCodeField.sendKeys(data);
        return this;
    }

    public String getPassengersErrorText() {
        return passengersErrorTextBlock.getText().replaceAll("\\r\\n|\\r|\\n", "");
    }

    public Boolean isReturnBlockDisabled() {
        return Boolean.valueOf(flightEndDateOpenButton.getAttribute("aria-disabled"));
    }
}
