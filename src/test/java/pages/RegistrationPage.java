package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    WebDriver driver = Driver.getWebDriver();

    private static final String REGISTRATION_FORM = "//header//div[2]/div[5]/a";
    private static final String CONTINUE_WITH_EMAIL = "//div[@class='app']//button[1]";
    private static final String CREATE_ACCOUNT_BUTTON = "//div[@class='app']//button";

    public void openRegistrationForm() {
        driver.findElement(By.xpath(REGISTRATION_FORM)).click();
    }
    public void enterMailDuringRegistration(String mail) {
        driver.findElement(By.id("username")).sendKeys(mail);
        driver.findElement(By.xpath(CONTINUE_WITH_EMAIL)).click();
    }
    public void enterPasswordDuringRegistration(String password) {
        driver.findElement(By.id("new_password")).sendKeys(password);
        driver.findElement(By.id("confirmed_password")).sendKeys(password);
        driver.findElement(By.xpath(CREATE_ACCOUNT_BUTTON)).click();
    }
}
