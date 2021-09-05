package classWork.webdriver;
//Задание:
//1. Перейти на сайт booking.com
//2. Найти отели для города «Москва»
//2. Проскролить страницу к 10-му отелю сверху
//3. Изменить цвет фона на зеленый,
//а цвет текста названия на красный
//4. Проверить, что название красного цвета

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

import java.util.concurrent.TimeUnit;

public class JavascriptExecutorTest {

    WebDriver driver;

    @Before
    public void makepreconditions(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.booking.com/");
    }

    @Test
    public void checkTextColorsTest(){
        WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
        search.click();
        search.sendKeys("Москва");
        driver.findElement(By.xpath("//button/span[contains(.,'Search')]")).click();
        WebElement hotel = driver.findElement(By.xpath("//div[@id='hotellist_inner']/div[10]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hotel);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = 'Green'", hotel);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color = 'Red'", hotel);
        String rgbFormat = driver.findElement(By.xpath("//div[@id='hotellist_inner']/div[10]//div[@class='hotel_desc']"))
                .getCssValue("color");
        System.out.println(rgbFormat);
        String hexcolor = Color.fromString(rgbFormat).asHex();
        System.out.println(hexcolor);
        if (hexcolor.equals("#ff0000")){
            hexcolor = "Red";
        }
        //Assert.assertEquals("#ff0000", hexcolor);
        Assert.assertEquals("Red", hexcolor);
    }

    @After
    public void makePostconditions(){
        driver.close();
        driver.quit();
    }
}
