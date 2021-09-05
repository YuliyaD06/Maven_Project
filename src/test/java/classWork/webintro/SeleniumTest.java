package classWork.webintro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    //********      default variant for Starting classWork.webdriver

    static WebDriver driver = new ChromeDriver();
    public static void main(String[] args) {

        driver.get("https://selenium.dev");
    }

}