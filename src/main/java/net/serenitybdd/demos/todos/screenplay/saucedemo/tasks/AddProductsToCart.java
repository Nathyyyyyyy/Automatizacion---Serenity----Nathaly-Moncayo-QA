package net.serenitybdd.demos.todos.screenplay.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.demos.todos.screenplay.saucedemo.user_interface.InventoryPage.ADD_TO_CART_BUTTONS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProductsToCart implements Task {

    private final int numberOfProducts;

    public AddProductsToCart(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i = 0; i < numberOfProducts; i++) {
            actor.attemptsTo(
                    Click.on(ADD_TO_CART_BUTTONS.resolveAllFor(actor).get(i))
            );
        }
    }

    public static AddProductsToCart adding(int numberOfProducts) {
        return instrumented(AddProductsToCart.class, numberOfProducts);
    }
}

