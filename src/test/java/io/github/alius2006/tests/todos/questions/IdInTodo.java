package io.github.alius2006.tests.todos.questions;

import com.fasterxml.jackson.databind.JsonNode;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class IdInTodo implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse().getBody().as(JsonNode.class).get("id").asInt();
    }

    public static Question<Integer> value() {
        return new IdInTodo();
    }
}
