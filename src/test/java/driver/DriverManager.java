package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class DriverManager {

    public static WebDriver getDriver(Config config) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //+++ clean session, cookies for Chrome

        switch (config) {
            case CHROME:
                return new ChromeDriver(options);
            case FIREFOX:
                return null;
            case REMOTE:
                return getRemoteDriver();
            default:
                return new ChromeDriver(options);
        }
    }

    private static WebDriver getRemoteDriver() {
        ChromeOptions options = new ChromeOptions();
        RemoteWebDriver webDriver = null;
        try {
            webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return webDriver;
    }
}
