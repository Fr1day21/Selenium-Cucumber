package pages;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import helper.ActionHelper;

public class ProductsPage {
    private WebDriver driver = DriverFactory.getDriver();
    ActionHelper actionHelper = new ActionHelper(driver);

    //Locator Validation
    private final By productsPage = By.xpath("//h2[normalize-space()='All Products']");
    private final By productVisible = By.xpath("//div[@class='features_items']");
    private final By firstProductDetails = By.xpath("(//div[@class='col-sm-9 padding-right'])[1]");
    private final By productInformation = By.xpath("//div[@class='product-information']");
    private final By catalog = By.xpath("//div[@class='product-image-wrapper']");

    //Locator Button
    private final By firstProduct = By.xpath("(//a[contains(text(),'View Product')])[1]");
    private final By buttonSearch = By.xpath("//button[@id='submit_search']");

    //Locator Search
    private final By searchField = By.xpath("//input[@id='search_product']");

    //Action
    public String getProductPageValidation(){
        return driver.findElement(productsPage).getText();
    }

    public void productVisible(){
        driver.findElement(productVisible).isDisplayed();
    }

    public void productsDetails(){
        driver.findElement(firstProductDetails).isDisplayed();
    }

    public void clickFirstProduct(){
        actionHelper.scrollToElement(driver.findElement(firstProduct));
        actionHelper.hoverAndClick(driver.findElement(firstProduct));
    }

    public String getProductInformation(){
        return driver.findElement(productInformation).getText();
    }

    public void clickSearch(){
        driver.findElement(buttonSearch).click();
    }

    public void enterProduct(String search){
        actionHelper.scrollToElement(driver.findElement(searchField));
        driver.findElement(searchField).sendKeys(search);
    }

    public String getCatalogInformation(){
        return driver.findElement(catalog).getText();
    }

}
