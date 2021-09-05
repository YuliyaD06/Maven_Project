package classWork.taf;

import driver.Config;
import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClassNg {

    WebDriver driver;

    static {
        doBeforeAll();
        doAfterAll();
    }

    private static void doBeforeAll(){
        Driver.initDriver(Config.CHROME);
    }

    private static void doAfterAll(){
        Runtime.getRuntime().addShutdownHook(new Thread(() ->{
            System.out.println("###################################ShutDownHook");
            Driver.destroy();
        }));
    }

    @BeforeTest
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
