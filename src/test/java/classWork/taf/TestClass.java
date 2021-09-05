package classWork.taf;

import driver.Config;
import driver.Driver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TestClass {

    WebDriver driver;

    static {
        doBeforeAll();
        doAfterAll();
    }

    private static void doBeforeAll(){
        Driver.initDriver(Config.valueOf(System.getProperty("BROWSER")));
    }

    private static void doAfterAll(){
        Runtime.getRuntime().addShutdownHook(new Thread(() ->{
            System.out.println("###################################ShutDownHook");
            Driver.destroy();
        }));
    }

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
