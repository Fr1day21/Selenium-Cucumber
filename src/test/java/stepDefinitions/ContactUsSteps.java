package stepDefinitions;

import com.github.javafaker.Faker;
import config.ConfigReader;
import factory.DriverFactory;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import pages.ContactUsPage;

import static org.junit.Assert.assertTrue;

public class ContactUsSteps{
    WebDriver driver = DriverFactory.getDriver();
    ContactUsPage contactUsPage = new ContactUsPage();
    Faker faker = new Faker();

    @And("User verify on Contact Us Menu")
    public void userVerifyOnContactUsMenu() {
        contactUsPage.verifyContactUsPage();
    }

    @And("User enter {string} Contact Us")
    public void userEnterContactUs(String value) {
        switch (value){
            case "name":
                contactUsPage.enterName(faker.name().fullName());
                break;
            case "email":
                contactUsPage.enterEmail(ConfigReader.get("email"));
                break;
            case "subject":
                contactUsPage.enterSubject(faker.lorem().sentence());
                break;
            case "message":
                contactUsPage.enterMessage(faker.lorem().paragraph());
                break;
            default:
                throw new IllegalArgumentException("Invalid value");
        }
    }

    @And("User click submit")
    public void userClickSubmit() {
        contactUsPage.clickSubmit();
    }

    @And("User click accept alert")
    public void userClickAcceptAlert() throws InterruptedException {
        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Then("User verify submit success")
    public void userVerifySubmitSuccess() {
        assertTrue(contactUsPage.getSuccessSubmit().contains("submitted successfully."));
    }

    @And("User click home button")
    public void userClickHomeButton() {
        contactUsPage.clickHome();
    }
}
