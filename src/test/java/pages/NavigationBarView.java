package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class NavigationBarView {

    WebDriver driver = Driver.getWebDriver();

    private static final String BOOKING_LOGO = "//div[@class='bui-header__logo']";
    private static final String CURRENCY = "//div/button[@data-modal-aria-label='Select your currency']";
    private static final String LANGUAGE = "//div/button[@data-modal-id='language-selection']";
    private static final String CUSTOMER_SERVICES = "//div/a[@data-bui-component='Tooltip']";
    private static final String NOTIFICATIONS = "//div[@id='traveller-header-notifications']";
    private static final String LIST_OF_PROPERTY = "//a[@class='bui-button bui-button--light bui-traveller-header__product-action']";
    private static final String YOUR_ACCOUNT = "//a[@aria-describedby='profile-menu-trigger--title profile-menu-trigger--content']";


    public boolean allHeadersPresent() {
        WebElement bookingLogo = driver.findElement(By.xpath(BOOKING_LOGO));
        WebElement currency = driver.findElement(By.xpath(CURRENCY));
        WebElement language = driver.findElement(By.xpath(LANGUAGE));
        WebElement customerServices = driver.findElement(By.xpath(CUSTOMER_SERVICES));
        WebElement notifications = driver.findElement(By.xpath(NOTIFICATIONS));
        WebElement listOfProperty = driver.findElement(By.xpath(LIST_OF_PROPERTY));
        WebElement account = driver.findElement(By.xpath(YOUR_ACCOUNT));

        List<WebElement> headersList = Arrays.asList(bookingLogo, currency, language, customerServices,
                notifications, listOfProperty, account);
        for (WebElement header : headersList) {
            if (!header.isDisplayed()) {
                System.out.println(header.getText());
            }
        }
        return true;
    }
}

