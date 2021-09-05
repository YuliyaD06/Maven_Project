package classWork.taf;

import driver.Driver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TestClassTwo {

    WebDriver driver;

    @Before
    public void makePrecondition(){
        driver = Driver.getWebDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void getBookTitleTest(){
        driver.get("https://www.booking.com/");
        System.out.println(driver.getTitle());
    }

    @Test
    public void getDemoTitleTest(){
        driver.get("https://demoqa.com/");
        System.out.println(driver.getTitle());
    }

}
