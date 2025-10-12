package hooks;

import config.ConfigReader;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = DriverFactory.initDriver();
        driver.get(ConfigReader.get("baseUrl"));
    }

    @After
    public void tearDown(){
        DriverFactory.quitDriver();
    }
}
