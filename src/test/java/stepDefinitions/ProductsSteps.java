package stepDefinitions;

import context.TestContext;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.ProductsPage;
import utils.Data;
import utils.Helper;

import static org.junit.Assert.assertTrue;

public class ProductsSteps {

    ProductsPage productsPage = new ProductsPage();
    TestContext context;
    Data data = new Data();
    Helper helper = new Helper();

    public ProductsSteps(TestContext context){
        this.context = context;
    }

    @And("User on product page")
    public void userOnProductPage() {
        assertTrue(productsPage.getProductPageValidation().contains("ALL PRODUCTS"));
    }

    @And("User can see the product")
    public void userCanSeeTheProduct() {
        productsPage.productVisible();
    }

    @And("User click view product")
    public void userClickViewProduct() {
        productsPage.clickFirstProduct();
    }

    @And("User can see detail product")
    public void userCanSeeDetailProduct() {
        productsPage.productsDetails();
    }

    @Then("User verify detail product {string}")
    public void userVerifyDetailProduct(String condition) {

        switch (condition){
            case "product1" :
                assertTrue(productsPage.getProductInformation().contains("Blue Top"));
                assertTrue(productsPage.getProductInformation().contains("Category: Women > Tops"));
                assertTrue(productsPage.getProductInformation().contains("Rs. 500"));
                assertTrue(productsPage.getProductInformation().contains("Availability"));
                assertTrue(productsPage.getProductInformation().contains("Condition"));
                assertTrue(productsPage.getProductInformation().contains("Brand"));
                break;
            default:
                throw new IllegalArgumentException("Invalid condition");
        }

    }

    @And("User enter name product on search field")
    public void userEnterNameProductOnSearchField() {
        String setProduct = helper.setSearchProduct(data.forProduct());
        productsPage.enterProduct(setProduct);
    }

    @And("User click search")
    public void userClickSearch() {
        productsPage.clickSearch();
    }

    @Then("User can see related product")
    public void userCanSeeRelatedProduct() {
        assertTrue(productsPage.getCatalogInformation().contains(helper.getSearchProduct()));
    }
}
