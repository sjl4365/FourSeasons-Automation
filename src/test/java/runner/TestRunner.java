package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/features",
    glue = {"steps", "testContext"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports/report.html"
    },
    monochrome = true
)
public class TestRunner {
}
