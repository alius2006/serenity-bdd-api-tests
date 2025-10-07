package io.github.alius2006.tests.todos.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.alius2006.tests.todos.questions.ResponseStatusCode;
import io.github.alius2006.tests.todos.questions.Titles;
import io.github.alius2006.tests.todos.tasks.GetListOfTodos;
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

        actor.should(
                seeThat("The response has status code 200",
                        ResponseStatusCode.value(),
                        is(equalTo(200))),
                seeThat("The expected title 'delectus aut autem' is present in the response",
                        Titles.titles(),
                        hasItem("delectus aut autem"))
        );
    }
}
