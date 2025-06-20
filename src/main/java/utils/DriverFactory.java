package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverFactory {
    private static WebDriver driver;

    /**
     * Initializes the WebDriver instance if it is not already initialized.
     * This method sets up a new ChromeDriver, maximizes the browser window,
     * and sets a default implicit wait timeout of 15 seconds.
     *
     * @return the initialized WebDriver instance
     */
    public static WebDriver initDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    /**
     * Returns the current instance of the WebDriver.
     *
     * @return the existing WebDriver instance, or null if not initialized
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * Resets the WebDriver instance by setting it to null.
     * This can be used to trigger reinitialization of the driver
     * in the next call to initDriver().
     */
    public static void resetDriver() {
        driver = null;
    }

    /**
     * Types the specified text into the given web element.
     *
     * @param element the WebElement where the text will be entered
     * @param text    the text to be typed into the element
     */
    public void type(WebElement element, String text) {
        element.sendKeys(text);
    }

    /**
     * Types the specified text into the given web element after clear the Web Element existing text.
     *
     * @param element the WebElement where the text will be entered
     * @param text    the text to be typed into the element
     */
    public void clearAndType(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Click the given web element.
     *
     * @param element the WebElement to be clicked
     */
    public void click(WebElement element) {
        element.click();
    }

    /**
     * Click the given web element after element is clickable.
     *
     * @param element the WebElement to be clicked
     */
    public void waitAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement freshElement = wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(element)
        ));
        freshElement.click();
    }

    /**
     * Wait for a element to be clickable.
     *
     * @param element the WebElement to be clicked
     */
    public void waitForClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(element)
        ));
    }

    /**
     * Select an option from dropdown.
     *
     * @param element     the WebElement to be clicked
     * @param visibleText the text to be select
     */
    public void selectValueFromDropdown(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    /**
     * Get text from element.
     *
     * @param element the WebElement to get text
     */
    public String getTextOnElement(WebElement element) {
        waitForElementAppear(element);
        String elementText = element.getText();
        return elementText;
    }

    /**
     * Wait for element appear in DOM.
     *
     * @param element the WebElement to be appearance
     */
    public void waitForElementAppear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Get current page URL.
     */
    public String getCurrentURL() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    /**
     * Get current URL in a new tab.
     */
    public String getCurrentURLInNewTab() {
        String originalWindow = driver.getWindowHandle();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.getWindowHandles().size() > 1);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        String newTabUrl = driver.getCurrentUrl();
        return newTabUrl;
    }

    /**
     * Scroll down the page.
     *
     * @param element the WebElement need to click or type
     */
    public void scrollDownToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
