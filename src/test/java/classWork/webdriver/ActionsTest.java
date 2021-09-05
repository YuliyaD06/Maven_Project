package classWork.webdriver;
//Задание:
//1. Перейти на сайт https://www.w3schools.com/java/
//2. Двойным кликом выделить в заголовке слово Tutorial
//3. Скопировать используя горячие клавиши Ctrl+c
//4. Перейти на сайт https://google.com
//5. Вставить в строку поиска скопированное
//6. Запустить поиск клавишей Enter
//7. Убедиться, что каждый из результатов
//содержит искомое слово


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionsTest {

    WebDriver driver;

    @Before
    public void makePreconditions(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.w3schools.com/java/");
        Actions makeFirstActions = new Actions(driver);
    }

    @Test
    public void searchWordTest(){
        WebElement title = driver.findElement(By.xpath("//h1//span[contains(.,'Tutorial')]"));
        Actions makeFirstActions = new Actions(driver);
        makeFirstActions
                .doubleClick(title)
                .keyDown(Keys.COMMAND)
                .sendKeys("C")
                .build()
                .perform();
        driver.get("https://google.com");
        driver.findElement(By.name("q")).click();
        Actions makeNextActions = new Actions(driver);
        makeNextActions
                .keyDown(Keys.COMMAND)
                .sendKeys("V")
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='g']//h3"));
        int allSearchNumber = searchResults.size();
        int resultNumber = 0;
        for (WebElement result : searchResults){
            String text = result.getText();
            Boolean searchTextTutorial = text.toUpperCase().contains("TUTORIAL");
            if (searchTextTutorial == true){
                resultNumber = resultNumber + 1;
            }
        }
        System.out.println(allSearchNumber);
        System.out.println(resultNumber);

        Assert.assertTrue("Not every search result contains the search word", allSearchNumber == resultNumber);
    }

    @After
    public void makePostConditions(){
        driver.close();
        driver.quit();
    }

}
