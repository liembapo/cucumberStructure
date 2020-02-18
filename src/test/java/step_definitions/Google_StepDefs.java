package step_definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.google_pages.GoogleLandingPage;
import utilities.DriverSingleton;

public class Google_StepDefs {

    GoogleLandingPage googleLandingPage = new GoogleLandingPage();

    @When("User is on google homepage")
    public void user_is_on_google_homepage() {
        //1. get the goole page
        DriverSingleton.getDriver().get("https://www.google.com");
    }

    @Then("User should see title contains Google")
    public void user_should_see_title_contains_Google() {
        //2.compare the actual title to expected title
        String actualTitle = DriverSingleton.getDriver().getTitle();
        String expectedTitle = "Google";

        Assert.assertTrue(actualTitle.contains(expectedTitle), "title doenst contains expected value");
    }

    @When("User type wooden spoon on search box")
    public void user_type_wooden_spoon_on_search_box(){
    googleLandingPage.googleSearchBox.sendKeys("wooden spoon");
    }

    @When("User click the search button")
    public void user_click_the_search_button(){
    googleLandingPage.searchButton.click();
    }

    @Then("User should see wooden spoon title")
    public void user_should_see_wooden_spoon_title(){
    String actual_title = DriverSingleton.getDriver().getTitle();
    String expected_title = "wooden spoon";

    Assert.assertTrue(expected_title.contains(actual_title));
    }

}
