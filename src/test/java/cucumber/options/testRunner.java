package cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", plugin = "json:target/jsonReports/cucumber-report.json", glue= "stepDefinitions", tags = "@addPlace")
public class testRunner {
//	tags = "@deletePlace"
//	plugin = "json:target/jsonReports/cucumber-report.json"
//	plugin = {"pretty", "html:target/cucumnber-reports"}, monochrome = true

}
