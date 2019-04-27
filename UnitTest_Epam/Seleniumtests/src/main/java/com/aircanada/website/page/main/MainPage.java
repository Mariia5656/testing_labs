package com.aircanada.website.page.main;

import com.aircanada.website.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {
    private final String INDEX_PAGE_URL = "https://www.aircanada.com/";

    @FindBy(xpath = "//*[@id='enCAEdition']")
    private WebElement openEnglishVersionForCanadaButton;

    @FindBy(xpath = "//span[text()='Flights']/..")
    private WebElement openFlightsTabButton;

    @FindBy(xpath = "//span[text()='Flight Status']/..")
    private WebElement openFlightStatusTabButton;

    @FindBy(xpath = "//span[text()='My Bookings']/..")
    private WebElement openMyBookingsTabButton;

    @FindBy(xpath = "//span[text()='Check-in']/..")
    private WebElement openCheckInTabButton;

    @FindBy(xpath = "//span[text()='Hotels']/..")
    private WebElement openHotelsTabButton;

    @FindBy(xpath = "//div[@class='tabs-container']/div[@aria-hidden='false']//div[@class='error-msgs']")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[@id='popup-error-grid']//div[contains(@class, 'error-msg')]")
    private WebElement popOutErrorTextBlock;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage open() {
        driver.get(INDEX_PAGE_URL);
        openEnglishVersionForCanadaButton.click();
        return this;
    }

    public FlightsTabPage openFlightsTab() {
        openFlightsTabButton.click();
        return new FlightsTabPage(driver);
    }

    public FlightStatusTabPage openFlightStatusTab() {
        openFlightStatusTabButton.click();
        return new FlightStatusTabPage(driver);
    }

    public MyBookingsTabPage openMyBookingsTab() {
        openMyBookingsTabButton.click();
        return new MyBookingsTabPage(driver);
    }

    public CheckInTabPage openCheckInTab() {
        openCheckInTabButton.click();
        return new CheckInTabPage(driver);
    }

    public HotelsTabPage openHotelsTab() {
        openHotelsTabButton.click();
        return new HotelsTabPage(driver);
    }

    public String getErrorText() {
        return errorMessage.getText().replaceAll("\\r\\n|\\r|\\n", "");
    }

    public String getPopOutErrorText() {
        return popOutErrorTextBlock.getText().replaceAll("\\r\\n|\\r|\\n", "");
    }
}
