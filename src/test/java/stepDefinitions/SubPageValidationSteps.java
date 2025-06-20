package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import utils.DriverFactory;

public class SubPageValidationSteps {
    WebDriver driver;
    HomePage homePage;


    @When("I click on the {string} button")
    public void iClickOnTheButton(String pageName) {
        driver = DriverFactory.initDriver();
        homePage = new HomePage(driver);
        homePage.clickTermsOfPageLink(pageName);

    }

    @Then("I should navigate to {string} page")
    public void iShouldNavigateToPage(String pageUrl) {
        Assert.assertEquals(homePage.getPageURL(), pageUrl);
    }
}
