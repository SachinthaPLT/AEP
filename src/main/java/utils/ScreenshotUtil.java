package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    /**
     * Captures a screenshot of the current browser window and saves it to the 'screenshots' directory
     * with a timestamp and scenario name in the file name.
     *
     * The file will be saved in the following format:
     * screenshots/{scenarioName}_{timestamp}.png
     *
     * Invalid characters in the scenario name will be replaced with underscores to ensure a valid file name.
     *
     * @param driver       the WebDriver instance used to capture the screenshot
     * @param scenarioName the name of the scenario (used in the screenshot file name)
     */
    public static void takeScreenshot(WebDriver driver, String scenarioName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String path = "screenshots/" + scenarioName.replaceAll("[^a-zA-Z0-9]", "_") + "_" + timestamp + ".png";

        try {
            FileUtils.copyFile(src, new File(path));
            System.out.println("Saved screenshot: " + path);
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
