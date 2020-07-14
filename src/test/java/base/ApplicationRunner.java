package base;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/feature/"},
        plugin = {"html:target/site/cucumber-pretty", "json:target/cucumber.json"},
        glue = {"login", "customer"},
        //      dryRun = true,
        monochrome = true)
public class ApplicationRunner {
}
