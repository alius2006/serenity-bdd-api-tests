package io.github.alius2006.tests.posts.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.alius2006.tests.commonApi.questions.ResponseStatusCode;
import io.github.alius2006.tests.posts.questions.TitlesInListOfPosts;
import io.github.alius2006.tests.posts.tasks.GetLIstOfPosts;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class PostsSteps {

    @When("the client requests a list of Posts")
    public void theClientRequestsListOfPosts() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(GetLIstOfPosts.getListOfPosts());
    }

    @Then("the API returns a list of Posts including expected items")
    public void theApiReturnsAListOfPosts() {
        Actor actor = OnStage.theActorInTheSpotlight();

        actor.should(
                seeThat("The response has status code 200",
                        ResponseStatusCode.value(),
                        is(equalTo(200))),
                seeThat("The expected title 'sunt aut facere repellat provident occaecati excepturi optio reprehenderit' is present in the response",
                        TitlesInListOfPosts.titles(),
                        hasItem("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
        );
    }
}
