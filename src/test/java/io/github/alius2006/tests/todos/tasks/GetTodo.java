package io.github.alius2006.tests.todos.tasks;

import io.github.alius2006.tests.commonApi.abilities.CallApi;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetTodo implements Task {

    private final int id;

    public GetTodo(int id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        CallApi.useTheApiAs(actor);
        actor.attemptsTo(Get.resource("/todos/{id}")
                .with(request -> request.pathParam("id", id)));
    }

    public static GetTodo getById(int id) {
        return new GetTodo(id);
    }
}
