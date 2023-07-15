package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./features/Rahul.feature",
		tags = "@A1",
		glue = "steps",
		monochrome = true,
		dryRun = false,
		plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		}
		)

public class TestRunner {

}
