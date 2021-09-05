package classWork.remote.suites.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"classWork.remote.steps.fake"},
        features = {"src/test/resources/features/fake/FakeOne.feature"}
)
public class FakeRunner {
}
