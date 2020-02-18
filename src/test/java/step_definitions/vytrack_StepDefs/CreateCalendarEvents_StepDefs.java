package step_definitions.vytrack_StepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.vytrack_pages.CreateCalendarEventsPage;
import pages.vytrack_pages.DashboardPage;
import pages.vytrack_pages.LoginPage;
import utilities.Configur;
import utilities.DriverSingleton;
import utilities.SeleniumUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateCalendarEvents_StepDefs {
    LoginPage loginPage = new LoginPage()   ;
    CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

    @Given("the user is signed in as a sale manager")
    public void the_user_is_signed_in_as_a_sale_manager() {
        DriverSingleton.getDriver().get(Configur.getProperty("vytrackUrl"));
        loginPage.usernameInput.sendKeys(Configur.getProperty("storeManagerUserName"));
        loginPage.passwordInput.sendKeys(Configur.getProperty("storeManagerPassword"));
        loginPage.loginButton.click();

    }

    @When("the user is on the All Calendar Events page under the Activities tab")
    public void the_user_is_on_the_All_Calendar_Events_page_under_the_Activities_tab() {
        DashboardPage.navigateToModule("Activities","Calendar Events");
    }

    @When("the user is taken to the Create Calendar Events page after clicking the Create Calendar Event button")
    public void the_user_is_taken_to_the_Create_Calendar_Events_page_after_clicking_the_Create_Calendar_Event_button() {
        createCalendarEventsPage.createCalendarEventsBtn.click();
    }

    @When("the user should see their name as the default value of of the owner field")
    public void the_user_should_see_their_name_as_the_default_value_of_of_the_owner_field() {
        String owner = createCalendarEventsPage.ownerField.getText();
        String loginUser = createCalendarEventsPage.loginUser.getText();

        Assert.assertEquals(owner,loginUser);


    }

    @When("the user should see the title field to be empty by default")
    public void the_user_should_see_the_title_field_to_be_empty_by_default() {
        String titleField = createCalendarEventsPage.titleField.getAttribute("value"); // this field can't use getText

        Assert.assertTrue(titleField.isEmpty());
    }

    @When("the user should see the start date field with the default value of the current date")
    public void the_user_should_see_the_start_date_field_with_the_default_value_of_the_current_date() {
       String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM d, yyy"));
       String actualDate = createCalendarEventsPage.startDate.getAttribute("value");

       Assert.assertEquals(expectedDate,actualDate);
    }

    @When("the user should see the start time field with the default value of the current time")
    public void the_user_should_see_the_start_time_field_with_the_default_value_of_the_current_time() {
        String expectedTime = LocalTime.now().minusHours(2).format(DateTimeFormatter.ofPattern("h:mm a"));
        String actualTime = createCalendarEventsPage.startTime.getAttribute("value");
        Assert.assertEquals(expectedTime, actualTime);
    }

    @When("the user clicks on the Repeat checkbox")
    public void the_user_clicks_on_the_Repeat_checkbox() {
        createCalendarEventsPage.repeatCheckBox.click();

    }

    @Then("the user sees the Repeats select field with the following options: Daily, Weekly, Monthly, Yearly")
    public void the_user_sees_the_Repeats_select_field_with_the_following_options_Daily_Weekly_Monthly_Yearly() {
        List<String> actualOptions = SeleniumUtils.getAllSelectOptions(createCalendarEventsPage.repeatSelectField);
        List<String > expectedOption = new ArrayList<>(Arrays.asList("daily", "weekly", "monthly", "yearly"));


    }
}

