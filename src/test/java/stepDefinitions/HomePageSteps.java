package stepDefinitions;

import config.ConfigReader;
import context.TestContext;
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

    public HomePageSteps(TestContext context){
        this.context = context;
    }

    @Given("User in homepage")
    public void user_in_homepage() {
        assertTrue(homePage.getValidationHomePage().contains("Automation"));
    }

    @When("User goto SignupLogin Menu")
    public void user_goto_signuplogin_menu() {
        homePage.goToSignupLoginMenu();
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
}
