package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

public class ProductPage extends DriverFactory {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(@class,'heading-mb-0')]")
    private WebElement lblProductTitle;

    private static final String lblFilterType = "//span[contains(text(),'%s')]//..//..";
    private static final String lblBrandName = "//span[contains(text(),'%s')]//..//..";


    public void clickOnFilter(String filterName){
        By lblFilterName = By.xpath(String.format(lblFilterType, filterName));
        click(driver.findElement(lblFilterName));
    }

    public void clickOnBrand(String brandName){
        By cbkBrandName = By.xpath(String.format(lblBrandName, brandName));
        click(driver.findElement(cbkBrandName));
    }

    public String getProductPageTitle(){
        String productTitle = getTextOnElement(lblProductTitle);
        return productTitle;
    }
}