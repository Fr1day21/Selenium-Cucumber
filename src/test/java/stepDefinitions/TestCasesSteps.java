package stepDefinitions;

import io.cucumber.java.en.Then;
import pages.TestCasesPage;

import static org.junit.Assert.assertTrue;

public class TestCasesSteps {

    TestCasesPage testCasesPage = new TestCasesPage();

    @Then("User verify on Test Cases Menu")
    public void userVerifyOnTestCasesMenu() {
        System.out.println(testCasesPage.getTestCasePage());
        assertTrue(testCasesPage.getTestCasePage().contains("TEST CASES"));
    }
}
