package pages.vytrack_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverSingleton;



public class DashboardPage {

    public DashboardPage() {
        PageFactory.initElements(DriverSingleton.getDriver(), this);
    }
    public static void navigateToModule(String tab, String module) {
        String tabLocatorXpath = "//span[contains(text(), '" + tab + "') and @class = 'title title-level-1']";
        String moduleLocatorXpath = "//span[.= '" + module + "']";
        DriverSingleton.getDriver().findElement(By.xpath(tabLocatorXpath)).click();
        DriverSingleton.getDriver().findElement(By.xpath(moduleLocatorXpath)).click();
    }

}
