package pages;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupLoginPage {
    private WebDriver driver = DriverFactory.getDriver();

    //Locator Validation
    private final By loginPageTitle = By.xpath("//h2[normalize-space()='New User Signup!']");
    private final By incorrectLoginMessage = By.xpath("//p[normalize-space()='Your email or password is incorrect!']");
    private final By emailExistingMessage = By.xpath("//p[normalize-space()='Email Address already exist!']");
    //Locator Field
    private final By emailLoginField = By.name("email");
    private final By passwordLoginField = By.name("password");
    private final By nameSignupField = By.xpath("//input[@placeholder='Name']");
    private final By emailSignupField = By.xpath("//input[@data-qa='signup-email']");

    //Locator Button
    private final By loginButton = By.xpath("//button[normalize-space()='Login']");
    private final By signupButton = By.xpath("//button[normalize-space()='Signup']");

    //Action
    public String getLoginPage(){
        return driver.findElement(loginPageTitle).getText();
    }

    public String getInvalidLogin(){
        return driver.findElement(incorrectLoginMessage).getText();
    }

    public String getExistingEmail(){
        return driver.findElement(emailExistingMessage).getText();
    }

    public void enterEmailLogin(String email){
        driver.findElement(emailLoginField).sendKeys(email);
    }

    public void enterPasswordLogin(String password){
        driver.findElement(passwordLoginField).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(loginButton).click();
    }

    public void enterNameSignup(String name){
        driver.findElement(nameSignupField).sendKeys(name);
    }

    public void enterEmailSignup(String email){
        driver.findElement(emailSignupField).sendKeys(email);
    }

    public void clickSignup(){
        driver.findElement(signupButton).click();
    }
}
