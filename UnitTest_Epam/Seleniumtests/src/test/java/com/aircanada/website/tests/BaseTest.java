package com.aircanada.website.tests;

import com.aircanada.website.BeforeAndAfterTestMethods;
import com.aircanada.website.page.FlightStatusPage;
import com.aircanada.website.page.main.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseTest extends BeforeAndAfterTestMethods {


    @Test()
    public void moreThanTenAdultPassengersErrorTest() {
        String error = "You have selected more than 9 passengers.Find out more about travelling as a group.";
        FlightsTabPage page = new MainPage(driver)
                .open()
                .openFlightsTab()
                .setAdultPassengers(10);
        String errorText = page.getPassengersErrorText();
        Assert.assertEquals(errorText, error, "Error text is not equal");
    }

    @Test()
    public void singleChildrenPassengerErrorTest() {
        String error = "Children under age 8 must travel with an adult age 16 or older. Children ages 8 to 11 can travel alone but you'll need to contact Air Canada Reservations at least 48 hours before departure to purchase their ticket and request our Unaccompanied Minor service.";
        FlightsTabPage page = new MainPage(driver)
                .open()
                .openFlightsTab()
                .setAdultPassengers(0)
                .setYouthPassengers(0)
                .setChildrenPassengers(1);
        String errorText = page.getPassengersErrorText();
        Assert.assertEquals(errorText, error, "Error text is not equal");
    }

    @Test()
    public void incompleteFieldsFillingTest() {
        String error = "We can't seem to locate the point of origin you've entered. Please try again.Note: When you enter a country, region, state, province or city name in the search field, a choice of airports will be displayed.";
        FlightsTabPage page = new MainPage(driver)
                .open()
                .openFlightsTab()
                .findFlight();
        String errorText = page.getPopOutErrorText();
        Assert.assertEquals(errorText, error, "Error text is not equal");
    }

    @Test()
    public void incorrectPromoCodeTest() {
        String error = "The Promotion Code you entered doesn't exist or is expired. Make sure you entered it correctly.";
        FlightsTabPage page = new MainPage(driver)
                .open()
                .openFlightsTab()
                .setStartAirport("Moscow")
                .setDestinationAirport("New York")
                .setFirstAvailableStartDate()
                .setLastAvailableStartDate()
                .setPromoCode("hahahaha")
                .findFlight();
        String errorText = page.getErrorText();
        Assert.assertEquals(errorText, error, "Error text is not equal");
    }

    @Test()
    public void incorrectFlightSearchTest() {
        String error = "The flight number you entered appears to be incorrect. Please validate the flight number and try again.";
        FlightStatusPage page = new MainPage(driver)
                .open()
                .openFlightStatusTab()
                .setFlightNumber("1234")
                .findFlight();
        String errorText = page.getErrorText();
        Assert.assertEquals(errorText, error, "Error text is not equal");
    }

    @Test()
    public void incorrectStartAirportTest() {
        String error = "We weren't able to find the location you're looking for. Please try re-entering it or choose another location.Note: When you enter a country, region, state, province or city name in the search field, a choice of destinations will be displayed.";
        FlightsTabPage page = new MainPage(driver)
                .open()
                .openFlightsTab()
                .setStartAirport("Moscaw");
        String errorText = page.getPopOutErrorText();
        Assert.assertEquals(errorText, error, "Error text is not equal");
    }

    @Test()
    public void incorrectMyBookingDataTest() {
        String error = "The booking reference you entered doesn't appear to be valid. Make sure you're entering an Air Canada booking reference.Did you book with another airline? You can ask them to provide you with an Air Canada booking reference.For assistance, contact Air Canada ReservationsOpens in a new window.";
        MyBookingsTabPage page = new MainPage(driver)
                .open()
                .openMyBookingsTab()
                .setBookingReference("Hahaha")
                .setPassengerLastName("Boltach")
                .findBooking();
        String errorText = page.getErrorText();
        Assert.assertEquals(errorText, error, "Error text is not equal");
    }

    @Test()
    public void incorrectCheckInDataTest() {
        String error = "The booking reference or Aeroplan Number you entered does not appear to be valid. Please make any necessary corrections and try again.";
        CheckInTabPage page = new MainPage(driver)
                .open()
                .openCheckInTab()
                .setFirstName("Valiantsin")
                .setLastName("Boltach")
                .setDepartureAirport("Moscow")
                .setAeroplanNumberOrBookingReference("INVALIDDATA")
                .checkIn();
        String errorText = page.getErrorText();
        Assert.assertEquals(errorText, error, "Error text is not equal");
    }

    @Test()
    public void hotelsIncorrectDayIntevalTest() {
        String error = "Your check-in and check-out dates cannot be more than 28 days apart. Please choose different dates and try again.";
        HotelsTabPage page = new MainPage(driver)
                .open()
                .openHotelsTab()
                .setLocation("Moscow")
                .setFirstAvailableStartDate()
                .setLastAvailableStartDate();
        String errorText = page.getErrorText();
        Assert.assertEquals(errorText, error, "Error text is not equal");
    }

    @Test()
    public void oneWayFlightTest() {
        FlightsTabPage page = new MainPage(driver)
                .open()
                .openFlightsTab()
                .checkOneWayFlight();
        Boolean isReturnBlockDisabled = page.isReturnBlockDisabled();
        Assert.assertTrue(isReturnBlockDisabled, "Return block isn't disabled");
    }

}