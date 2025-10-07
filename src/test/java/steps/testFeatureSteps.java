package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class testFeatureSteps {
    int result;

    @When("Test When")
    public void testWhen() {
        result = 1+2;
    }

    @Then("Test Then")
    public void testThen() {
        System.out.println(result);
    }
}
