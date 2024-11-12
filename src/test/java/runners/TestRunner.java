package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utils.GenerateReport;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

/**
 * TestRunner class for executing Cucumber tests with JUnit.
 * Configures Cucumber options for feature file locations, step definitions, and reporting.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "steps",
    plugin = {"pretty", "json:target/cucumber.json", "html:target/cucumber-report.html"}
)
public class TestRunner {
    @AfterClass
    public static void generateReport() {
        GenerateReport.generateCucumberReport();
    }
}
