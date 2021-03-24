package com.n26.monefy.steps;

import com.n26.monefy.pages.CalendarMenuPO;
import com.n26.monefy.pages.CalendarMenuPO.DateGroupLabel;
import com.n26.monefy.pages.HomePO;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;

import static com.n26.monefy.pages.CalendarMenuPO.DateGroupLabel.CHOOSEDATE;
import static com.n26.monefy.pages.HomePO.AmountLabel.CALENDAR;

@Slf4j
@AllArgsConstructor
public class CalendarSteps {

    HomePO homePage;
    CalendarMenuPO calendarMenu;

    @And("^Today's date is set to \"([^\"]*)\" on the app$")
    public void setCurrentDate(String date) {
        homePage.tapOnButton(CALENDAR);
        calendarMenu.tapOnButton(CHOOSEDATE);
        calendarMenu.editDateByText(date);
        homePage.getDriver().hideKeyboard();
    }

    @When("^The user sets the date range to \"([^\"]*)\"$")
    public void setDateRange(String range) {
        homePage.tapOnButton(CALENDAR);
        calendarMenu.tapOnButton(DateGroupLabel.valueOf(range.toUpperCase()));
    }

    @Then("^The date displayed on the home page is set to \"([^\"]*)\"$")
    public void assertDisplayedDate(String date) {
        if (date.contains("*")) {
            Assert.assertTrue(homePage.getDateText().
                    contains(date.replace("*", "")));
        } else {
            Assert.assertEquals(homePage.getDateText(), date,
                    "Wrong date is displayed");
        }
    }
}
