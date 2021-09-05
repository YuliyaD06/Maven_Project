package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DestinationView {

    WebDriver driver = Driver.getWebDriver();

    private static final String DESTINATION_SEARCH_INPUT = "//label[@class='sb-destination-label-sr']/input";

    public void chooseDestination(String city){
        driver.findElement(By.xpath(DESTINATION_SEARCH_INPUT)).sendKeys(city);
    }
}
