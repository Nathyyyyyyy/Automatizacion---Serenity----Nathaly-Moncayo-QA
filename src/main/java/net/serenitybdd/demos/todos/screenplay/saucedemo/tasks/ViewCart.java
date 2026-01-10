package net.serenitybdd.demos.todos.screenplay.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.demos.todos.screenplay.saucedemo.user_interface.InventoryPage.SHOPPING_CART_LINK;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ViewCart implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SHOPPING_CART_LINK)
        );
    }

    public static ViewCart page() {
        return instrumented(ViewCart.class);
    }
}

