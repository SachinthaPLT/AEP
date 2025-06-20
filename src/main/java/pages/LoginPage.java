package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;
import utils.ExcelUtil;

import java.util.List;
import java.util.Map;

public class LoginPage extends DriverFactory {
    List<Map<String, String>> testData = ExcelUtil.readLoginData("LoginData");

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login-selection")
    private WebElement drpAccountType;

    @FindBy(id = "j_username")
    private WebElement txtUsername;

    @FindBy(id = "j_password")
    private WebElement txtPassword;

    @FindBy(xpath = "//button[@aria-label='submit']")
    private WebElement btnSignIn;

    public void selectAccountType(String accountType) {
        selectValueFromDropdown(drpAccountType, accountType);
    }

    public void enterUsername(String username) {
        type(txtUsername, username);
    }

    public void enterPassword(String password) {
        type(txtPassword, password);
    }

    public void clickLogin() {
        click(btnSignIn);
    }

//    public void clickSignIin() {
//        click(btnSignIn);
//
//    }

    public void loginWithExcelData() {
        for (Map<String, String> data : testData) {
            String username = data.get("Username");
            String password = data.get("Password");
            clearAndType(txtUsername, username);
            clearAndType(txtPassword, password);

        }
    }
}