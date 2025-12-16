package pages;

import factory.DriverFactory;
import helper.ActionHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver = DriverFactory.getDriver();
    private ActionHelper actionHelper = new ActionHelper(driver);

    //Locator Validation
    private final By homePageValidation = By.xpath("//section[@id='slider']//div[@class='item active']//div[1]");
    private final By loggedIn = By.xpath("//li[10]//a[1]");
    private final By deleteAccMessage = By.xpath("//b[normalize-space()='Account Deleted!']");
    private final By subscriptionTitle = By.xpath("//h2[normalize-space()='Subscription']");
    private final By subscriptionMessage = By.xpath("//div[@class='footer-widget']//div[@class='row']");
    //Locator Menu
    private final By signupLoginMenu = By.xpath("//a[normalize-space()='Signup / Login']");
    private final By contactUsMenu = By.xpath("//a[normalize-space()='Contact us']");
    private final By testCaseMenu = By.xpath("//a[contains(text(),'Test Cases')]");
    private final By productsMenu = By.xpath("//a[@href='/products']");
    //LocatorButton
    private final By deleteButton = By.xpath("//a[normalize-space()='Delete Account']");
    private final By continueButton = By.xpath("//a[normalize-space()='Continue']");
    private final By arrowButton = By.xpath("//button[@id='subscribe']");
    //Locator Field
    private final By subscriptionField = By.xpath("//input[@id='susbscribe_email']");


    //Action
    public String getValidationHomePage(){
        return driver.findElement(homePageValidation).getText();
    }

    public String getLoggedIn(){
        return driver.findElement(loggedIn).getText();

    //Action Menu
    }
    public void goToSignupLoginMenu(){
        driver.findElement(signupLoginMenu).click();
    }

    public void goToContactUsMenu(){
        driver.findElement(contactUsMenu).click();
    }

    public void goToTestCaseMenu(){
        driver.findElement(testCaseMenu).click();
    }

    public void goToProductMenu(){
        driver.findElement(productsMenu).click();
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

    public void scrollDownHomePage(){
        actionHelper.scrollToBottom();
    }

    public void enterEmailSubscription(String email){
        driver.findElement(subscriptionField).sendKeys(email);
    }

    public void clickArrowButton(){
        driver.findElement(arrowButton).click();
    }

    public String getSubscriptionTitle(){
        return driver.findElement(subscriptionTitle).getText();
    }

    public void verifySubscriptionMessage(){
        driver.findElement(subscriptionMessage).isDisplayed();
    }




}
