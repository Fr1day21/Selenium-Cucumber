package pages;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage {
    private WebDriver driver = DriverFactory.getDriver();

    //Locator validation
    private final By testCasesTitle = By.xpath("//b[normalize-space()='Test Cases']");

    //Action
    public String getTestCasePage(){
        return driver.findElement(testCasesTitle).getText();
    }
}
