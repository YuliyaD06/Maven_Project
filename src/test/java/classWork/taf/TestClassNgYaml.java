package classWork.taf;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestClassNgYaml {

    WebDriver driver;

    ////***** Make changes for YAML *****////

    /*    @BeforeSuite
    public void suitePreconditions(){
        driver = new ChromeDriver();
    }
    @BeforeTest
    public void makePrecondition(){
        driver = Driver.getWebDriver();
        driver.manage().window().maximize();
    }*/

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
