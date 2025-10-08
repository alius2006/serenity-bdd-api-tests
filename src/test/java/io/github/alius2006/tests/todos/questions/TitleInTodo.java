package io.github.alius2006.tests.todos.questions;

import com.fasterxml.jackson.databind.JsonNode;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TitleInTodo implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        JsonNode response = SerenityRest.lastResponse().getBody().as(JsonNode.class);
        return response.get("title").asText();
    }

    public static Question<String> value() {
        return new TitleInTodo();
    }
}
