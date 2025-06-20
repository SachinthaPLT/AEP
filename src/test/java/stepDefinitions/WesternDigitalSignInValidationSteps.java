package stepDefinitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import utils.DriverFactory;

public class WesternDigitalSignInValidationSteps {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;


    @And("I click on the Sign in button")
    public void iClickOnTheSignInButton() {
        driver = DriverFactory.initDriver();
        homePage = new HomePage(driver);
        homePage.clickAccountSignIn();
    }

    @And("I Select account type as {string}")
    public void iSelectAccountTypeAs(String accountType) {
        loginPage = new LoginPage(driver);
        loginPage.selectAccountType(accountType);
    }

    @And("I Type email as {string} in sign in page")
    public void iTypeEmailAsInSignInPage(String email) {
        loginPage.enterUsername(email);
    }

    @And("I Type password as {string} in sign in page")
    public void iTypePasswordAsInSignInPage(String password) {
        loginPage.enterPassword(password);
    }

    @And("I click on Sign in button")
    public void iClickOnSignInButton() {
        loginPage.clickLogin();
    }

    @And("I enter username and passwords from excel file")
    public void iEnterUsernameAndPasswordsFromExcelFile(){
        loginPage.loginWithExcelData();
    }
}
