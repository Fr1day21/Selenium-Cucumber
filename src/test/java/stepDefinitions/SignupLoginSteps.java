package stepDefinitions;

import com.github.javafaker.Faker;
import config.ConfigReader;
import context.TestContext;
import io.cucumber.java.en.And;
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

    @And("User enter email login")
    public void userEnterEmailLogin() {
        signupLoginPage.enterEmailLogin(ConfigReader.get("email"));
    }

    @And("User enter password login")
    public void userEnterPasswordLogin() {
        signupLoginPage.enterPasswordLogin(ConfigReader.get("password"));
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
                signupLoginPage.enterEmailSignup(faker.internet().emailAddress());
                break;
            default:
                throw new IllegalArgumentException("Invalid input");
        }

    }
}
