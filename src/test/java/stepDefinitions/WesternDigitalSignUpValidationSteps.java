package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import utils.DriverFactory;

public class WesternDigitalSignUpValidationSteps {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    RegistrationPage registrationPage;

    @Given("I navigate to {string}")
    public void iNavigateTo(String url) {
        driver = DriverFactory.initDriver();
        driver.get(url);
        loginPage = new LoginPage(driver);
    }

    @When("I click on the Log In button")
    public void iClickOnTheLogInButton() {
        homePage = new HomePage(driver);
        homePage.clickSignIn();
    }

    @And("I click on the Create an Account button")
    public void iClickOnTheCreateAnAccountButton()  {
        homePage.clickCreateAccount();
    }

    @And("I Select account type as {string} and click on continue to registration")
    public void iSelectAccountTypeAsAndClickOnContinueToRegistration(String accountType) {
        registrationPage = new RegistrationPage(driver);
        registrationPage.selectAccountType(accountType);
        registrationPage.clickContinueToRegistration();
    }

    @And("I Type firstname as {string} and lastname as {string}")
    public void iTypeFirstnameAsAndLastnameAs(String firstname, String lastname) {
        registrationPage.typeFirstName(firstname);
        registrationPage.typeLastName(lastname);
    }

    @And("I Type email as {string}")
    public void iTypeEmailAs(String email) {
        registrationPage.typeEmail(email);
    }

    @And("I Type password as {string}")
    public void iTypePasswordAs(String password) {
        registrationPage.typePassword(password);
    }

    @And("I Click consent checkbox")
    public void iClickConsentCheckbox() {
        registrationPage.clickConsent();
    }

    @And("I click on Join Now button")
    public void iClickOnJoinNowButton() {
        registrationPage.clickJoinNow();
    }

    @Then("Then user should landed to Home page and should be able to see the {string}")
    public void thenUserShouldLandedToHomePageAndShouldBeAbleToSeeThe(String welcomeMessage) {
        Assert.assertEquals(homePage.getWelcomeText(),welcomeMessage);
    }

}
