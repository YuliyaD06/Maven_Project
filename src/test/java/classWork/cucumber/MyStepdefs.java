package classWork.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MyStepdefs {
    @Given("I start execution")
    public void iStartExecution() {
        Assert.assertTrue(true);
    }

    @When("I add {int} and {int}")
    public void iAddAnd(int arg0, int arg1) {
        Assert.assertEquals(3, arg0+arg1);
    }

    @Then("I verify that result equals {int}")
    public void iVerifyThatResultEquals(int arg0) {
        Assert.assertEquals(3, arg0);
    }

    @When("I subtract {int} and {int}")
    public void iSubtractAnd(int arg0, int arg1) {
        Assert.assertEquals(1, arg0-arg1);
    }
}
