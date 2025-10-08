package io.github.alius2006.tests.posts.steps;

import io.cucumber.java.en.Given;
import io.github.alius2006.tests.commonApi.abilities.CallApi;
import io.github.alius2006.tests.posts.PostsCast;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientSteps {

    private static final Logger logger = LoggerFactory.getLogger(ClientSteps.class);

    @Given("a client has access to the Posts API")
    public void aClientHasAccessToTheTestAPI() {
        Cast todosClient = new Cast();
        todosClient.actorNamed(PostsCast.POSTS_CLIENT)
                .can(CallApi.canCallTheApi());

        OnStage.setTheStage(new Stage(todosClient));

        OnStage.theActor(PostsCast.POSTS_CLIENT);

        logger.info("Actor {} has access to the Test API", OnStage.theActorInTheSpotlight().getName());
    }
}
