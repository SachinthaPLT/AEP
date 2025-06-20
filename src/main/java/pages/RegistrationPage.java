package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

public class RegistrationPage extends DriverFactory {
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "accountType")
    private WebElement drpAccountType;

    @FindBy(id = "contToRegs")
    private WebElement btnContinueToRegistration;

    @FindBy(name = "firstName")
    private WebElement txtFirstName;

    @FindBy(name = "lastName")
    private WebElement txtLastName;

    @FindBy(name = "email")
    private WebElement txtEmail;

    @FindBy(name = "pwd")
    private WebElement txtPassword;

    @FindBy(xpath = "//input[@id='registrationPrivacyStatement']//..//span")
    private WebElement cbkPrivacyCheckbox;

    @FindBy(xpath = "//button[@aria-label='Join Now']")
    private WebElement btnJoinNow;

    public void selectAccountType(String accountType) {
        selectValueFromDropdown(drpAccountType, accountType);
    }

    public void clickContinueToRegistration() {
        click(btnContinueToRegistration);
    }

    public void typeFirstName(String firstname) {
        type(txtFirstName, firstname);
    }

    public void typeLastName(String lastname) {
        type(txtLastName, lastname);
    }

    public void typeEmail(String email) {
        type(txtEmail, email);
    }

    public void typePassword(String password) {
        type(txtPassword, password);
    }

    public void clickConsent() {
        waitAndClick(cbkPrivacyCheckbox);
    }

    public void clickJoinNow() {
        click(btnJoinNow);
    }

}
