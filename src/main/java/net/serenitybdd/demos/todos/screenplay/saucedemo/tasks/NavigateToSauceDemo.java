package net.serenitybdd.demos.todos.screenplay.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateToSauceDemo implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("https://www.saucedemo.com/")
        );
    }

    public static NavigateToSauceDemo loginPage() {
        return instrumented(NavigateToSauceDemo.class);
    }
}

