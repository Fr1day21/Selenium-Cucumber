package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.SignupPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SignupSteps {

    Faker faker = new Faker();
    SignupPage signupPage = new SignupPage();

    @Then("User verify on {string}")
    public void userVerifyOn(String verification) {
        switch (verification){
            case "Signup Page" :
                assertEquals("ENTER ACCOUNT INFORMATION", signupPage.getSignupTitle());
                break;
            case "Success Register" :
                assertEquals("ACCOUNT CREATED!", signupPage.getSuccessRegister());
                break;
            default:
                throw new IllegalArgumentException("Invalid verification");
        }
    }

    @And("User choose gender")
    public void userChooseGender() {
        signupPage.chooseGender();
    }

    @And("User enter password signup")
    public void userEnterPasswordSignup() {
        signupPage.enterPasswordSignup(faker.internet().password());
    }

    @And("User choose {string} birth")
    public void userChooseBirth(String birthType) {
        switch (birthType){
            case "days":
                signupPage.enterDays(faker.number().numberBetween(1,30));
                break;
            case "months":
                signupPage.enterMonths(faker.number().numberBetween(1, 12));
                break;
            case "year":
                signupPage.enterYear(faker.number().numberBetween(1993, 2003));
                break;
            default:
                throw new IllegalArgumentException("Invalid birth type");
        }
    }

    @And("User enter {string} name")
    public void userEnterName(String typeName) {
        switch (typeName){
            case "first":
                signupPage.enterFirstName(faker.name().firstName());
                break;
            case "last":
                signupPage.enterLastName(faker.name().lastName());
                break;
            default:
                throw new IllegalArgumentException("Invalid type name");
        }
    }

    @And("User enter {string}")
    public void userEnter(String type) {
        switch (type){
            case "company":
                signupPage.enterCompany(faker.company().name());
                break;
            case "address":
                signupPage.enterAddress(faker.address().fullAddress());
                break;
            case "state":
                signupPage.enterState(faker.address().state());
                break;
            case "city":
                signupPage.enterCity(faker.address().city());
                break;
            case "zip code":
                signupPage.enterZipCode(faker.address().zipCode());
                break;
            case "mobile number":
                signupPage.enterMobileNum(faker.phoneNumber().phoneNumber());
                break;
            default:
                throw new IllegalArgumentException("Invalid type");
        }
    }

    @And("User choose country")
    public void userChooseCountry() {
        signupPage.chooseCountry();
    }

    @And("User click {string} signup")
    public void userClickCreateAccount(String buttonType) {
        switch (buttonType){
            case "create account":
                signupPage.clickRegister();
                break;
            case "continue":
                signupPage.clickContinue();
                break;
            default:
                throw new IllegalArgumentException("Invalid button type");
        }
    }
}
