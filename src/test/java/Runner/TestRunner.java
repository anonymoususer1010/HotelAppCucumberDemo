package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
//@CucumberOptions(features = "Features", glue = "com.stepDefinition", plugin = { "pretty",
//"html:target/cucumber-reports.html" })    // For cucumber report

@CucumberOptions(features = "Features", glue = "com.stepDefinition", plugin = { "pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class TestRunner {
}
