package io.github.alius2006.tests.commonApi.questions;

import com.fasterxml.jackson.databind.JsonNode;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Id implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse().getBody().as(JsonNode.class).get("id").asInt();
    }

    public static Question<Integer> value() {
        return new Id();
    }
}
