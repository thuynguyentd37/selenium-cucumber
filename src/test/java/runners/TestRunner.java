package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",  // Runs all feature files inside this directory
        glue = "stepDefinitions",  // Step definitions package
        //tags = "@smokeTest",  // Runs only scenarios with @smokeTes
        plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"},  // Generates reports
        monochrome = true  // Improves console readability
)
public class TestRunner {
}
