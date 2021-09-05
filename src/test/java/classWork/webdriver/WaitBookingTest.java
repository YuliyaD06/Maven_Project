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

public class WaitBookingTest {

    WebDriver driver;

    @Before
    public void makePrecond(){
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.booking.com/");
    }

    @Test
    public void highestPriceTest() {

        WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
        search.click();
        search.sendKeys("Париж");
        driver.findElement(By.xpath("//li[@data-label='Paris, Ile de France, France']")).click();
        driver.findElement(By.xpath("//label[@id='xp__guests__toggle']")).click();
        WebElement addAdults = driver.findElement(By.xpath("//span[@id='group_adults_desc']/preceding-sibling::button[1]"));
        addAdults.click();
        addAdults.click();
        driver.findElement(By.xpath("//span[@id='no_rooms_desc']/preceding-sibling::button[1]")).click();
        driver.findElement(By.xpath("//span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']"))
                .click();
        driver.findElement(By.xpath("//td[@data-date='2021-08-05']")).click();
        driver.findElement(By.xpath("//td[@data-date='2021-08-12']")).click();
        driver.findElement(By.xpath("//button/span[contains(.,'Search')]")).click();
        WebElement checkboxPrice = driver.findElement(By.xpath("//div[@id='filter_price']//span[contains(.,'+')]"));
        String expectedPrice = checkboxPrice.getText();
        checkboxPrice.click();

        //add waiting of finishing the spinner. Exclude timeouts and return after FluentWait
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".bui-spinner.bui-spinner--size-large")));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        int expectedPerNight = Integer.parseInt(expectedPrice.replaceAll("\\D+",""));
        driver.findElement(By.xpath("//li[@data-id='price']")).click();

        //add waiting of finishing the spinner. Exclude timeouts and return after FluentWait
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".bui-spinner.bui-spinner--size-large")));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement price = driver.findElement(By.xpath("//div[@id='hotellist_inner']//span[contains(.,'price')]/preceding-sibling::div[1]"));
        String hotelFirst = price.getText();
        int actualMaxPrice = Integer.parseInt(hotelFirst.replaceAll("\\D+",""));
        int actualPerNight = actualMaxPrice / 7;

        //Assert for test
        Assert.assertTrue("The actual price less then expected price!", actualPerNight >= expectedPerNight);

    }

    @After
    public void makePostCond(){
        driver.close();
        driver.quit();
    }


}
