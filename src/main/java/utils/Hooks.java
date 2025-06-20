package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    WebDriver driver;

    /**
     * Initializes the WebDriver before each Cucumber scenario.
     * This method is executed before every scenario as part of the test setup process.
     * It ensures the browser instance is ready for automation steps.
     */
    @Before
    public void setUp() {
        DriverFactory.initDriver();
    }

    /**
     * Performs cleanup after each Cucumber scenario.
     *
     * If the scenario has failed, captures a screenshot and attaches it to the Cucumber report.
     * Also saves the screenshot to disk using ScreenshotUtil.
     * Finally, quits the WebDriver and resets the driver instance.
     *
     * @param scenario the current Cucumber scenario, used to check failure status and attach screenshots
     */
    @After
    public void tearDown(Scenario scenario) {
        driver = DriverFactory.getDriver();
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");

            // Optional: also save to disk using your ScreenshotUtil
            ScreenshotUtil.takeScreenshot(driver, scenario.getName());
        }
        if (driver != null) {
            driver.quit();
            DriverFactory.resetDriver();
        }
    }
}
