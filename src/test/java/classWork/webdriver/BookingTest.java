package classWork.webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

//Задание:
//1. Перейти на сайт booking.com
//2. Ввести в поиск «Москва», выбрать для
//проживания 2 гостей и 1 номер c 10/08/2021 до 15/08/2021.
//3. Проверить, что в Москве есть отели на введенные даты
public class BookingTest {
    WebDriver driver;

    @Before
    public void makePreconditions(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.booking.com/");
    }

    @Test
    public void checkHotelsTest(){
        WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
        search.click();
        search.sendKeys("Москва");
        driver.findElement(By.xpath("//span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']"))
                .click();
        driver.findElement(By.xpath("//td[@data-date='2021-08-10']")).click();
        driver.findElement(By.xpath("//td[@data-date='2021-08-15']")).click();
        driver.findElement(By.xpath("//button/span[contains(.,'Search')]")).click();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".bui-spinner.bui-spinner--size-large")));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement infoHotels = driver.findElement(By.xpath("//div[@class='sr_header ']/h1"));
        String numberOfHotels = infoHotels.getText();
        int number = Integer.parseInt(numberOfHotels.replaceAll("\\D+",""));
        if (number > 0){
            System.out.println("Hotels for the specified date are available.");
        }
    }

    @After
    public void makepostconditions(){
        driver.quit();
        driver.close();
    }
}
