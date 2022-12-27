package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/getAll.feature"},
        glue = "stepdefinitions.getAll",
        publish = true,
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class GetAllRunner {
}
