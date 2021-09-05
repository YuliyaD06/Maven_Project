package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GmailPage {

    public static final String LOGIN_IN_GMAIL = "//div[@class='h-c-header__cta']/ul/li[2]/a[@data-action='sign in']";
    public static final String ENTER_EMAIL_GMAIL = "//input[@type='email']";
    public static final String CONTINUE_BUTTON = "//span[text()='Далее']";

    WebDriver driver = Driver.getWebDriver();

    public void confirmRegistration(String password, String mail){
        driver.get("https://www.google.com/intl/ru/gmail/about/#");
        driver.findElement(By.xpath(LOGIN_IN_GMAIL)).click();
        driver.findElement(By.xpath(ENTER_EMAIL_GMAIL)).click();
        driver.findElement(By.xpath(ENTER_EMAIL_GMAIL)).sendKeys(mail);
        driver.findElement(By.xpath(CONTINUE_BUTTON)).click();

    }

}
