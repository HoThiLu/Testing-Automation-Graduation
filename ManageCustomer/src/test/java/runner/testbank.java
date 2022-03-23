package runner;

import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/java/features/testbank.feature"},
		glue = {"stepdefinitions"},
				plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
				dryRun = false,
				monochrome = true
        )
public class testbank {
}