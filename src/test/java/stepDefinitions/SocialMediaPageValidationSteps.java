package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import utils.DriverFactory;

public class SocialMediaPageValidationSteps {
    WebDriver driver;
    HomePage homePage;

    @When("I click on the {string} icon")
    public void iClickOnTheIcon(String socialMediaName) {
        driver = DriverFactory.initDriver();
        homePage = new HomePage(driver);
        homePage.clickOnSocialMediaLink(socialMediaName);
    }

    @Then("New tab should open and navigate to {string} page")
    public void newTabShouldOpenAndNavigateToPage(String socialMedialPageLink) {
       Assert.assertEquals(homePage.getNewTabPageURL(),socialMedialPageLink);
    }
}
