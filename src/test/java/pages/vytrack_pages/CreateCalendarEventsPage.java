package pages.vytrack_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverSingleton;

public class CreateCalendarEventsPage {


    public CreateCalendarEventsPage(){

        PageFactory.initElements(DriverSingleton.getDriver(),this);
    }

    @FindBy (css = ".select2-chosen") //. is by class
    public WebElement ownerField;

    @FindBy (css = "#user-menu") // # is by name
    public WebElement loginUser;

    @FindBy (css = "[id^= 'oro_calendar_event_form_title']")
    public WebElement titleField;

    @FindBy (css = "[id^= 'date_selector_oro_calendar_event_form_start']")
    public WebElement startDate;

    @FindBy (css = "[id^='time_selector_oro_calendar_event_form_start']")
    public WebElement startTime;

    @FindBy (css = "[title ='Create Calendar event']")
    public WebElement createCalendarEventsBtn;

    @FindBy (css = "[id^= 'recurrence-repeat-view']")
    public WebElement repeatCheckBox;
    @FindBy (css = "[id^= 'recurrence-repeats-view']")
    public WebElement repeatSelectField;
}
