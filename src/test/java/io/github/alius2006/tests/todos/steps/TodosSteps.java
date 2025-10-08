package io.github.alius2006.tests.todos.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.alius2006.tests.commonApi.abilities.RememberId;
import io.github.alius2006.tests.commonApi.questions.Id;
import io.github.alius2006.tests.commonApi.questions.ResponseStatusCode;
import io.github.alius2006.tests.todos.questions.TitleInTodo;
import io.github.alius2006.tests.todos.questions.TitlesInListOfTodos;
import io.github.alius2006.tests.todos.tasks.GetListOfTodos;
import io.github.alius2006.tests.todos.tasks.GetTodo;
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

    @When("the client requests a TODO with ID {int}")
    public void theClientRequestsATodoWithId(int id) {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.abilityTo(RememberId.class).rememberId(id);
        actor.attemptsTo(GetTodo.getById(id));
    }

    @Then("the API returns a list of TODOs including expected items")
    public void theApiReturnsAListOfTodos() {
        Actor actor = OnStage.theActorInTheSpotlight();

        actor.should(
                seeThat("The response has status code 200",
                        ResponseStatusCode.value(),
                        is(equalTo(200))),
                seeThat("The expected title 'delectus aut autem' is present in the response",
                        TitlesInListOfTodos.titles(),
                        hasItem("delectus aut autem"))
        );
    }

    @Then("the API returns a TODO with the correct ID and title {string}")
    public void theApiReturnsATodoWithTheCorrectIdAndTitle(String expectedTitle) {
        Actor actor = OnStage.theActorInTheSpotlight();
        int id = actor.abilityTo(RememberId.class).recallId();

        actor.should(
                seeThat("The response has status code 200",
                        ResponseStatusCode.value(),
                        is(equalTo(200))),
                seeThat("The id in the response equals the given id",
                        Id.value(),
                        is(equalTo(id))),
                seeThat("The title in the response equals the expected title",
                        TitleInTodo.value(),
                        is(equalTo(expectedTitle)))
        );
    }
}
