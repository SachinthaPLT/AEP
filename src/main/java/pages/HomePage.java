package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

public class HomePage extends DriverFactory {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".login-btn-trigger ")
    private WebElement btnSignIn;

    @FindBy(css = ".shopAccountLogin")
    private WebElement BtnSignInAccount;

    @FindBy(xpath = "//a[@aria-label='Create Account']")
    private WebElement btnCreateAccount;

    @FindBy(id = "username")
    private WebElement txtEmailAddress;

    @FindBy(id = "sign-in-button")
    private WebElement btnContinue;

    @FindBy(css = ".login-btn-trigger span")
    private WebElement lblWelcome;

    @FindBy(xpath = "//button[contains(@aria-label,'My Accounts ')]")
    private WebElement btnAccount;

    private static final String btnSocialMedia = "//a[contains(@aria-label,'%s')]";
    private static final String btnNavBarItem = "//li[contains(@aria-label,'%s')]";
    private static final String lblProductName = "//a[contains(@aria-label,'%s')]";


    public void clickSignIn() {
        click(btnSignIn);
    }

    public void clickAccountSignIn() {
        click(BtnSignInAccount);
    }

    public void clickCreateAccount() {
        waitAndClick(btnCreateAccount);
    }

    public void typeEmail(String email) {
        type(txtEmailAddress, email);
    }

    public void clickContinue() {
        waitAndClick(btnContinue);
    }

    public String getWelcomeText() {
        waitForClickable(btnAccount);
        return getTextOnElement(lblWelcome);
    }

    public String getPageURL() {
        return getCurrentURL();
    }

    public void clickTermsOfPageLink(String pageName) {
        scrollDownToElement(driver.findElement(By.linkText(pageName)));
        click(driver.findElement(By.linkText(pageName)));
    }

    public void clickOnSocialMediaLink(String socialMediaName) {
        By socialMediaLink = By.xpath(String.format(btnSocialMedia, socialMediaName));
        scrollDownToElement(driver.findElement(socialMediaLink));
        click(driver.findElement(socialMediaLink));

    }

    public String getNewTabPageURL() {
        return getCurrentURLInNewTab();
    }

    public void clickOnNavBarItems(String navBarItem) {
        By navItemLocator = By.xpath(String.format(btnNavBarItem, navBarItem));
        click(driver.findElement(navItemLocator));
    }

    public void clickOnProductName(String productName) {
        By productNameInList = By.xpath(String.format(lblProductName, productName));
        click(driver.findElement(productNameInList));
    }
}
