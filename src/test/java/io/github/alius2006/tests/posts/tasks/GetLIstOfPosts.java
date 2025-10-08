package io.github.alius2006.tests.posts.tasks;

import io.github.alius2006.tests.commonApi.abilities.CallApi;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetLIstOfPosts implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        CallApi.useTheApiAs(actor);
        actor.attemptsTo(Get.resource("/posts"));
    }

    public static GetLIstOfPosts getListOfPosts() {
        return new GetLIstOfPosts();
    }
}
