package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver = Driver.getWebDriver();

    private static final String HEADER_SIGN_IN_BUTTON = "//a[@class='bui-button bui-button--secondary js-header-login-link']/span[contains(.,'Sign in')]";
    private static final String ENTER_MAIL_FIELD = "//div[@class='bui-input-text__field']/input";
    private static final String ENTER_PASSWORD_FIELD = "//div/input[@type='password']";
    private static final String LOGIN_FLOW_IGN_IN_BUTTON = "//form/button/span[text()='Sign in']";
    private static final String CONTINUE_WITH_EMAIL = "//div[@class='app']//button[1]";

    public void loginWithEmail(String mail, String password){
        driver.findElement(By.xpath(HEADER_SIGN_IN_BUTTON)).click();
        driver.findElement(By.xpath(ENTER_MAIL_FIELD)).sendKeys(mail);
        driver.findElement(By.xpath(CONTINUE_WITH_EMAIL)).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement passwordElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ENTER_PASSWORD_FIELD)));
        driver.findElement(By.xpath(ENTER_PASSWORD_FIELD)).sendKeys(password);
        driver.findElement(By.xpath(LOGIN_FLOW_IGN_IN_BUTTON)).click();
    }
}
