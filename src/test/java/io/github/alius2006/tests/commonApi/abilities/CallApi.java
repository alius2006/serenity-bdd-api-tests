package io.github.alius2006.tests.commonApi.abilities;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.model.util.EnvironmentVariables;

public class CallApi implements Ability {

    static EnvironmentVariables environmentVariables = Serenity.environmentVariables();
    static String apiBaseUrl = environmentVariables.getProperty("api.base.url");

    public static Ability canCallTheApi() {
        return new CallApi();
    }

    public static void useTheApiAs(Actor actor) {
        if (actor.abilityTo(CallApi.class) != null) {
            actor.whoCan(CallAnApi.at(apiBaseUrl));
        }
    }
}
