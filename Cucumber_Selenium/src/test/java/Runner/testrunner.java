package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/javaFeatures"
,glue= {"seleniumgluecode"}
,plugin = {"pretty", "html:target/htmlreports"}
)

public class testrunner {

}
 