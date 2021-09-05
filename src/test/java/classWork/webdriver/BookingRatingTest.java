package classWork.webdriver;

import org.junit.After;
import org.junit.Assert;
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
//2. Ввести в поиск «Москва»,
//выбрать для проживания 2 гостей и 1 номер.
//3. Отфильтровать отели с максимальным рейтингом
//4. Открыть страницу с первым таким отелем
//и проверить, что его рейтинг >=9

public class BookingRatingTest {
    WebDriver driver;

    @Before
    public void makePreconditions(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.booking.com/");
    }

    @Test
    public void checkHotelRatingTest(){
        WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
        search.click();
        search.sendKeys("Москва");
        driver.findElement(By.xpath("//button/span[contains(.,'Search')]")).click();
        driver.findElement(By.xpath("//ul[@role='menubar']/li[5]")).click();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".bui-spinner.bui-spinner--size-large")));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement rating = driver.findElement(By.xpath("//div[@id='hotellist_inner']/div[1]//div[@aria-label='Scored  ']"));
        double highestRating = Double.parseDouble(rating.getText());
        Assert.assertTrue("The rating lower than 9.0", highestRating >= 9.0);
    }

    @After
    public void makepostconditions(){
        driver.close();
        driver.quit();
    }
}
