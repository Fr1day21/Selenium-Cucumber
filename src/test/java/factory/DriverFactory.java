package factory;

import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//settings web driver
public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver initDriver() {
        String headless = ConfigReader.get("headless");

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        if (Boolean.parseBoolean(headless)) {
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
        }

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
