package pages;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class SignupPage {
    private WebDriver driver = DriverFactory.getDriver();

    //Locator Verification
    private final By successRegister = By.xpath("//b[normalize-space()='Account Created!']");
    private final By signupPageTitle = By.xpath("//b[normalize-space()='Enter Account Information']");
    //Locator action field
    private final By passwordFieldSignup = By.xpath("//input[@id='password']");
    private final By firstNameField = By.xpath("//input[@id='first_name']");
    private final By lastNameField = By.xpath("//input[@id='last_name']");
    private final By companyField = By.xpath("//input[@id='company']");
    private final By addressField = By.xpath("//input[@id='address1']");
    private final By stateField = By.xpath("//input[@id='state']");
    private final By cityField = By.xpath("//input[@id='city']");
    private final By zipcodeField = By.xpath("//input[@id='zipcode']");
    private final By mobileNumField = By.xpath("//input[@id='mobile_number']");
    private final By dropdownDays = By.xpath("//select[@id='days']");
    private final By dropdownMonths = By.xpath("//select[@id='months']");
    private final By dropdownYears = By.xpath("//select[@id='years']");
    //Locator action click
    private final By chooseGenderMr = By.xpath("//input[@id='id_gender1']");
    private final By registerButton = By.xpath("//button[normalize-space()='Create Account']");
    private final By continueButton = By.xpath("//a[normalize-space()='Continue']");

    //Action
    public String getSuccessRegister(){
        return driver.findElement(successRegister).getText();
    }

    public String getSignupTitle(){
        return driver.findElement(signupPageTitle).getText();
    }

    public void enterPasswordSignup(String password){
        driver.findElement(passwordFieldSignup).sendKeys(password);
    }

    public void enterFirstName(String firstName){
       driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterCompany(String company){
        driver.findElement(companyField).sendKeys(company);
    }

    public void enterAddress(String address){
        driver.findElement(addressField).sendKeys(address);
    }

    public void chooseCountry(){
        Random random = new Random();
        List<String> countries = List.of("India", "United States", "Canada", "Australia", "New Zealand", "Singapore");
        String selectedCountry = countries.get(random.nextInt(countries.size()));

        Select dropDown = new Select(driver.findElement(By.id("country")));
        dropDown.selectByVisibleText(selectedCountry);
    }

    public void enterState(String state){
        driver.findElement(stateField).sendKeys(state);
    }

    public void enterCity(String city){
        driver.findElement(cityField).sendKeys(city);
    }

    public void enterZipCode(String zipCode){
        driver.findElement(zipcodeField).sendKeys(zipCode);
    }

    public void enterMobileNum(String mobileNum){
        driver.findElement(mobileNumField).sendKeys(mobileNum);
    }

    public void enterDays(Integer days){
        driver.findElement(dropdownDays).sendKeys(days.toString());
    }

    public void enterMonths(Integer months){
        driver.findElement(dropdownMonths).sendKeys(months.toString());
    }

    public void enterYear(Integer year){
        driver.findElement(dropdownYears).sendKeys(year.toString());
    }

    public void chooseGender(){
        driver.findElement(chooseGenderMr).click();
    }

    public void clickRegister(){
        driver.findElement(registerButton).click();
    }

    public void clickContinue(){
        driver.findElement(continueButton).click();
    }


}
