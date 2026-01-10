package net.serenitybdd.demos.todos.screenplay.saucedemo.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {
    public static final Target CHECKOUT_BUTTON = Target.the("checkout button")
            .locatedBy("#checkout");

    public static final Target CART_ITEMS = Target.the("cart items")
            .locatedBy(".cart_item");
}

