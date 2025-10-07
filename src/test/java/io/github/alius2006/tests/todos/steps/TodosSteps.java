package io.github.alius2006.tests.todos.steps;

import com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.alius2006.tests.todos.tasks.GetListOfTodos;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class TodosSteps {

    @When("the client requests a list of TODOs")
    public void theClientRequestsTheListOfTodos() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(GetListOfTodos.getListOfTodos());
    }

    @Then("the API returns a list of TODOs including expected items")
    public void theApiReturnsAListOfTodos() {
        Actor actor = OnStage.theActorInTheSpotlight();

        Response response = SerenityRest.lastResponse();

        actor.should(seeThat("The response has status code 200",
                act -> response.getStatusCode(),
                is(equalTo(200))));

        JsonNode jsonResponse = response.getBody().as(JsonNode.class);
        String expectedTitle = "delectus aut autem";

        actor.should(seeThat("The expected title " + expectedTitle + " is present in the response",
                act -> jsonResponse.findValuesAsText("title"),
                hasItem(expectedTitle)));
    }
}
