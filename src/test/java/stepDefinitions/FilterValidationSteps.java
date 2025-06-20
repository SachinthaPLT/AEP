package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.ProductPage;
import utils.DriverFactory;

public class FilterValidationSteps {
    WebDriver driver;
    HomePage homePage;
    ProductPage productPage;


    @When("I click on the {string} button on top navigation")
    public void iClickOnTheButtonOnTopNavigation(String navItem) {
        driver = DriverFactory.initDriver();
        homePage = new HomePage(driver);
        homePage.clickOnNavBarItems(navItem);
    }

    @And("I click on {string}")
    public void iClickOn(String productName) {
        homePage.clickOnProductName(productName);
    }

    @And("I Filter the {string} products by using {string} filter")
    public void iFilterTheProductsByUsingFilter(String brandName, String filter) {
        productPage = new ProductPage(driver);
        productPage.clickOnFilter(filter);
        productPage.clickOnBrand(brandName);
    }

    @Then("I should see the {string} text on top of the product list")
    public void iShouldSeeTheTextOnTopOfTheProductList(String productName) {
        Assert.assertEquals(productPage.getProductPageTitle(),productName);
    }
}
