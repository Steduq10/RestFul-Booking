package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/updateForbidden.feature"},
        glue = "stepdefinitions.updateForbidden",
        publish = true,
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class UpdateForbiddenRunner {
}
