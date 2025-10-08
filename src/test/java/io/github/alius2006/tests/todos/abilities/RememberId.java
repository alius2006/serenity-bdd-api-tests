package io.github.alius2006.tests.todos.abilities;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

public class RememberId implements Ability {

    int id;

    public void rememberId(int id) {
        this.id = id;
    }

    public int recallId() {
        return id;
    }

    public static RememberId canRemember() {
        return new RememberId();
    }

    public static RememberId as(Actor actor) {
        return actor.abilityTo(RememberId.class);
    }
}
