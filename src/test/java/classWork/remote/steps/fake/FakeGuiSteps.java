package classWork.remote.steps.fake;

import driver.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FakeGuiSteps {

    @When("I start waiting")
    public void iStartWaiting() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Given("I go to demoqa.com")
    public void iGoToDemoqaCom() {
        Driver.getWebDriver().get("https://demoqa.com");
    }

    @Then("I just passed")
    public void iJustPassed() {
        Assert.assertTrue(true);
    }
}
