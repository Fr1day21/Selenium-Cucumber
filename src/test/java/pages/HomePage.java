package pages;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver = DriverFactory.getDriver();

    //Locator Validation
    private final By homePageValidation = By.xpath("//section[@id='slider']//div[@class='item active']//div[1]");
    private final By loggedIn = By.xpath("//li[10]//a[1]");
    private final By deleteAccMessage = By.xpath("//b[normalize-space()='Account Deleted!']");
    //Locator Menu
    private final By signupLoginMenu = By.xpath("//a[normalize-space()='Signup / Login']");
    //LocatorButton
    private final By deleteButton = By.xpath("//a[normalize-space()='Delete Account']");
    private final By continueButton = By.xpath("//a[normalize-space()='Continue']");


    //Action
    public String getValidationHomePage(){
        return driver.findElement(homePageValidation).getText();
    }

    public String getLoggedIn(){
        return driver.findElement(loggedIn).getText();

    }
    public void goToSignupLoginMenu(){
        driver.findElement(signupLoginMenu).click();
    }

    public String getDeleteAccMessage(){
        return driver.findElement(deleteAccMessage).getText();
    }

    public void clickDeleteAcc(){
        driver.findElement(deleteButton).click();
    }

    public void clickContinue(){
        driver.findElement(continueButton).click();
    }


}
