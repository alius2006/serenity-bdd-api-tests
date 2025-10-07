package io.github.alius2006.tests.todos.tasks;

import io.github.alius2006.tests.todos.abilities.CallTodosApi;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetListOfTodos implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        CallTodosApi.useTheApiAs(actor);
        actor.attemptsTo(Get.resource("/todos"));
    }

    public static GetListOfTodos getListOfTodos() {
        return new GetListOfTodos();
    }
}
