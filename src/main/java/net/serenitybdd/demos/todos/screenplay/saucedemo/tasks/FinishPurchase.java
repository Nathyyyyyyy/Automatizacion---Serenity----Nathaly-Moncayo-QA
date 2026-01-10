package net.serenitybdd.demos.todos.screenplay.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.demos.todos.screenplay.saucedemo.user_interface.CheckoutPage.FINISH_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FinishPurchase implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(FINISH_BUTTON)
        );
    }

    public static FinishPurchase now() {
        return instrumented(FinishPurchase.class);
    }
}

