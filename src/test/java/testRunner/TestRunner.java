package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"features/anzhome.feature"},
		glue = {"steps"},
		plugin = {"pretty", "json:target/json-report/cucumber.json" },
		dryRun = false,
		strict = true,
		monochrome = true,
		tags = {}
		
		)
public class TestRunner {

}