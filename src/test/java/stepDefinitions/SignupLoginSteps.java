package stepDefinitions;

import com.github.javafaker.Faker;
import config.ConfigReader;
import context.TestContext;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.SignupLoginPage;

import static org.junit.Assert.assertTrue;

public class SignupLoginSteps {

    Faker faker = new Faker();
    SignupLoginPage signupLoginPage = new SignupLoginPage();
    TestContext context;

    public SignupLoginSteps(TestContext context){
        this.context = context;
    }

    @And("User verify on SignupLogin Menu")
    public void userVerifyOnSignupLoginMenu() {
        assertTrue(signupLoginPage.getLoginPage().contains("New User Signup!"));
    }

    @And("User enter email login {string}")
    public void userEnterEmailLogin(String value) {
        switch (value){
            case "valid":
                signupLoginPage.enterEmailLogin(ConfigReader.get("email"));
                break;
            case "random":
                signupLoginPage.enterEmailLogin(faker.internet().emailAddress());
                break;
            default:
                throw new IllegalArgumentException("Invalid value");
        }
    }

    @And("User enter password login {string}")
    public void userEnterPasswordLogin(String value) {
        switch (value){
            case "valid":
                signupLoginPage.enterPasswordLogin(ConfigReader.get("password"));
                break;
            case "random":
                signupLoginPage.enterPasswordLogin(faker.internet().password());
                break;
            default:
                throw new IllegalArgumentException("Invalid value");
        }
    }

    @And("User click {string}")
    public void userClickLogin(String button) {

        switch (button){
            case "login":
                signupLoginPage.clickLogin();
                break;
            case "signup" :
                signupLoginPage.clickSignup();
                break;
            default:
                throw new IllegalArgumentException("Invalid value button");
        }
    }

    @And("User enter {string} register")
    public void userEnterNameRegister(String input) {

        switch (input){
            case "name":
                String username = faker.name().username();
                context.set("username register", username);
                signupLoginPage.enterNameSignup(username);
                break;
            case "email":
                String emailAddress = faker.internet().emailAddress();
                context.set("email register", emailAddress);
                signupLoginPage.enterEmailSignup(emailAddress);
                break;
            case "emailExisting":
                signupLoginPage.enterEmailSignup(ConfigReader.get("email"));
                break;
            default:
                throw new IllegalArgumentException("Invalid input");
        }

    }

    @Then("User validation invalid {string}")
    public void userValidationInvalidLogin(String value) {
        switch (value){
            case "login":
                assertTrue(signupLoginPage.getInvalidLogin().contains("incorrect!"));
                break;
            case "signup":
                assertTrue(signupLoginPage.getExistingEmail().contains("already exist!"));
                break;
            default:
                throw new IllegalArgumentException("Invalid value");
        }

    }
}
