package io.github.alius2006.tests.todos.questions;

import com.fasterxml.jackson.databind.JsonNode;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class Titles implements Question<List<String>> {

    @Override
    public List<String> answeredBy(Actor actor) {
        JsonNode response = SerenityRest.lastResponse().getBody().as(JsonNode.class);
        return response.findValuesAsText("title");
    }

    public static Question<List<String>> titles() {
        return new Titles();
    }
}
