package net.serenitybdd.demos.todos.screenplay.saucedemo.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class InventoryPage {
    public static final Target ADD_TO_CART_BUTTONS = Target.the("add to cart buttons")
            .locatedBy("button[id^='add-to-cart']");

    public static final Target SHOPPING_CART_BADGE = Target.the("shopping cart badge")
            .locatedBy(".shopping_cart_badge");

    public static final Target SHOPPING_CART_LINK = Target.the("shopping cart link")
            .locatedBy(".shopping_cart_link");
}

