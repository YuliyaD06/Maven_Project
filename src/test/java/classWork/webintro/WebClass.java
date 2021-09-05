package classWork.webintro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebClass {
    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {

        driver.get("https://www.google.com");
        driver.navigate().to("https://mail.ru");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.close();
        driver.quit();
    }
}
