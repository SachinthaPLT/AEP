package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepDefinitions","utils"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "com.aventstack.chaintest.plugins.ChainTestCucumberListener:target/chaintest-report/"
        },
        monochrome = true
)
public class TestRunnerWithChainTestReports extends AbstractTestNGCucumberTests {}
