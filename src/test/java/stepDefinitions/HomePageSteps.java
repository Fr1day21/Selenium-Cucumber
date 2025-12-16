package stepDefinitions;

import com.github.javafaker.Faker;
import config.ConfigReader;
import context.TestContext;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HomePageSteps {

    HomePage homePage = new HomePage();
    TestContext context;
    Faker faker = new Faker();

    public HomePageSteps(TestContext context){
        this.context = context;
    }

    @Given("User in homepage")
    public void user_in_homepage() {
        assertTrue(homePage.getValidationHomePage().contains("Automation"));
    }

    @When("User goto {string} Menu")
    public void user_goto_signuplogin_menu(String menu) {
        switch (menu){
            case "SignupLogin" :
                homePage.goToSignupLoginMenu();
                break;
            case "ContactUs" :
                homePage.goToContactUsMenu();
                break;
            case "Test Cases" :
                homePage.goToTestCaseMenu();
                break;
            case "Products" :
                homePage.goToProductMenu();
                break;
            default:
                throw new IllegalArgumentException("Invalid Menu");
        }
    }

    @Then("User validation correct account login {string}")
    public void userValidationCorrectAccountLogin(String validationType) {
        switch (validationType){
            case "exist":
                assertTrue(homePage.getLoggedIn().contains(ConfigReader.get("name")));
                break;
            case "random":
                assertTrue(homePage.getLoggedIn().contains(context.get("username register", String.class)));
                break;
            default:
                throw new IllegalArgumentException("Invalid validation type");
        }


    }

    @And("User delete account")
    public void userDeleteAccount() {
        homePage.clickDeleteAcc();
    }

    @And("User verify account deleted")
    public void userVerifyAccountDeleted() {
        assertEquals("ACCOUNT DELETED!", homePage.getDeleteAccMessage());
    }

    @Then("User click continue")
    public void userClickContinue() {
        homePage.clickContinue();
    }

    @When("User scroll down to footer")
    public void userScrollDownToFooter() {
        homePage.scrollDownHomePage();
    }

    @And("User verify text {string}")
    public void userVerifyText(String text) {
        assertTrue(homePage.getSubscriptionTitle().contains(text));
    }

    @And("User enter email address")
    public void userEnterEmailAddress() {
        homePage.enterEmailSubscription(faker.internet().emailAddress());
    }

    @And("User click arrow button")
    public void userClickArrowButton() {
        homePage.clickArrowButton();
    }

    @Then("User verify {string} display")
    public void userVerifyDisplay(String condition) {
        switch (condition){
            case "Subscription Message" :
                homePage.verifySubscriptionMessage();
                break;
            default:
                throw new IllegalArgumentException("Not Working");
        }
    }
}
