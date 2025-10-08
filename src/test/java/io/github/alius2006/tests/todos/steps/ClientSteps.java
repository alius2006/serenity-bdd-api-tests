package io.github.alius2006.tests.todos.steps;

import io.cucumber.java.en.Given;
import io.github.alius2006.tests.todos.TodosCast;
import io.github.alius2006.tests.todos.abilities.CallTodosApi;
import io.github.alius2006.tests.todos.abilities.RememberId;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientSteps {

    private static final Logger logger = LoggerFactory.getLogger(ClientSteps.class);

    @Given("a client has access to the Todos API")
    public void aClientHasAccessToTheTestAPI() {
        Cast todosClient = new Cast();
        todosClient.actorNamed(TodosCast.TODOS_CLIENT)
                .can(CallTodosApi.canCallTheApi())
                .can(RememberId.canRemember());

        OnStage.setTheStage(new Stage(todosClient));

        OnStage.theActor(TodosCast.TODOS_CLIENT);

        logger.info("Actor {} has access to the Test API", OnStage.theActorInTheSpotlight().getName());
    }
}
