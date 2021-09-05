package classWork.webintro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class GoogleWeather {
    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.click();
        element.sendKeys("погода Минск");
        Thread.sleep(1000);
        WebElement elementSearchButton = driver.findElement(By.xpath("//span[contains(.,'сейчас')]"));
        elementSearchButton.click();
        WebElement elementTomorrow = driver.findElement(By.xpath("//div[@data-wob-di='1']"));
        elementTomorrow.click();

        String dayOfWeek =
                DateTimeFormatter.ofPattern("EEEE")
                        .withLocale(new Locale("be", "BY"))
                        .format(LocalDate.now().plus(1, ChronoUnit.DAYS).getDayOfWeek());
        WebElement elementTemTomorrow = driver.findElement(By.xpath(String.format("//*[contains(@aria-label,'Celsius %s 12:00')]", dayOfWeek)));
        System.out.println(elementTemTomorrow.getAttribute("aria-label").split("°")[0]);
        driver.close();
        driver.quit();

    }
}
