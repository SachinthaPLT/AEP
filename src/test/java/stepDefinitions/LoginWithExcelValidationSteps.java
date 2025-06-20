package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginWithExcelValidationSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("user is navigate to login page")
    public void userIsNavigateToLoginPage() {
        driver = DriverFactory.initDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        loginPage = new LoginPage(driver);
    }


    @When("User logs in using credentials from Excel")
    public void userLogsInUsingCredentialsFromExcel(){
        loginPage = new LoginPage(driver);
        loginPage.loginWithExcelData();
    }


}
