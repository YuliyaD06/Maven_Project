package pages;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class CommonBookingPage {

    public static final String CLOSE_WELCOME_CARD = "//button[@title='Close']";
    public static final String SEARCH_BUTTON = "//div[@class='xp__button']//button";

    WebDriver driver = Driver.getWebDriver();

    public void openBookingPage(){
        driver.get("https://www.booking.com");
    }
    public void closeWelcomeCard(){
        driver.findElement(By.xpath(CLOSE_WELCOME_CARD)).click();
    }
    public void searchHotels(){
        driver.findElement(By.xpath(SEARCH_BUTTON)).click();
    }
    public void passCaptcha(){
        List<WebElement> iframeElements = driver.findElements(By.xpath("//iframe"));
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".bui-spinner.bui-spinner--size-large")));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println(iframeElements.size());

        //driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='px-captcha']/iframe[8]")));
        /*WebElement captcha = driver.findElement(By.id("jmtizSJxDoYzibW"));

        Actions action = new Actions(driver);
        action.clickAndHold(captcha).build().perform();
        try{
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        action.release(captcha).build().perform();*/
    }

}
