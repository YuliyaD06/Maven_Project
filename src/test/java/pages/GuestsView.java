package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GuestsView {

    WebDriver driver = Driver.getWebDriver();

    private static final String GUESTS_FORM = "//label[@id='xp__guests__toggle']";
    private static final String ADD_ADULTS_GUESTS = "//button[@aria-describedby='group_adults_desc']/span[text()='+']";
    private static final String ADD_CHILDREN_GUESTS = "//button[@aria-describedby='group_children_desc']/span[text()='+']";
    private static final String ADD_ROOMS_GUESTS = "//button[@aria-describedby='no_rooms_desc']/span[text()='+']";

    public void addNumberOfRooms(){
        driver.findElement(By.xpath(ADD_ROOMS_GUESTS)).click();
    }
}
