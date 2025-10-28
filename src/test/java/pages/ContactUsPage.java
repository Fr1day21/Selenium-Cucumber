package pages;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
    private WebDriver driver = DriverFactory.getDriver();

    //Locator Verification
    private final By contactUsTitle = By.xpath("//h2[normalize-space()='Get In Touch']");
    private final By successSubmitMessage = By.xpath("//div[@class='status alert alert-success']");
    //Locator action field
    private final By nameField = By.xpath("//input[@placeholder='Name']");
    private final By emailField = By.xpath("//input[@placeholder='Email']");
    private final By subjectField = By.xpath("//input[@placeholder='Subject']");
    private final By messageField = By.xpath("//textarea[@id='message']");
    //Locator action button
    private final By submitButton = By.xpath("//input[@name='submit']");
    private final By homeButton = By.xpath("//span[normalize-space()='Home']");

    //Action
    public void verifyContactUsPage(){
        driver.findElement(contactUsTitle).isDisplayed();
    }

    public String getSuccessSubmit(){
        return driver.findElement(successSubmitMessage).getText();
    }

    public void enterName(String name){
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterSubject(String subject){
        driver.findElement(subjectField).sendKeys(subject);
    }

    public void enterMessage(String message){
        driver.findElement(messageField).sendKeys(message);
    }

    public void clickSubmit(){
        driver.findElement(submitButton).click();
    }

    public void clickHome(){
        driver.findElement(homeButton).click();
    }
}
