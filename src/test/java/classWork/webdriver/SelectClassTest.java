package classWork.webdriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SelectClassTest {
    WebDriver driver;

    @Before
    public void makePreconditions(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/select-menu");
    }

    @Test
    public void oldStyleSelectTest(){
        Select oldStyleSelect = new Select(driver.findElement(By.xpath("//select[@id='oldSelectMenu']")));
        oldStyleSelect.selectByValue("3");
        String actualColor = driver.findElement(By.xpath("//select[@id='oldSelectMenu']/option[@value='3']")).getText();
        Assert.assertEquals("Yellow", actualColor);
    }
    @Test
    public void multiSelectTest(){
        Select multiSelect = new Select(driver.findElement(By.xpath("//select[@id='cars']")));
        multiSelect.selectByValue("audi");
        String actualCar = driver.findElement(By.xpath("//select[@id='cars']/option[contains(.,'Audi')]"))
                .getAttribute("value");
        Assert.assertEquals("audi", actualCar);
    }

    @Test
    public void selectOneTest(){
        driver.findElement(By.xpath("//div[@class=' css-1hwfws3']/div[contains(.,'Select Option')]")).click();
        driver.findElement(By.xpath("//div[text()='Group 1, option 1']")).click();
        WebElement firstSelect = driver.findElement(By.xpath("//div[text()='Group 1, option 1']"));
        Assert.assertEquals("Group 1, option 1", firstSelect.getText());
    }

    @Test
    public void selectSecondTest(){
        driver.findElement(By.xpath("//div[@class=' css-1hwfws3']/div[contains(.,'Select Option')]")).click();
        driver.findElement(By.xpath("//div[text()='Mr.']")).click();
        WebElement secondSelect = driver.findElement(By.xpath("//div[text()='Mr.']"));
        Assert.assertEquals("Mr.", secondSelect.getText());
    }

    @Test
    public void selectThirdTest(){
        driver.findElement(By.xpath("//div[text()='Select...']")).click();
        driver.findElement(By.xpath("//div[text()='Blue']")).click();
        Assert.assertEquals("Blue", driver.findElement(By.xpath("//div[@class='css-12jo7m5']")).getText());
    }

    @After
    public void makePostconditions(){
        driver.close();
        driver.quit();
    }
}
