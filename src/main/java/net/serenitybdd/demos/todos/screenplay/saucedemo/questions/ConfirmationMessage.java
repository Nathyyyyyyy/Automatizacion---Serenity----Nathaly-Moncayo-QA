package net.serenitybdd.demos.todos.screenplay.saucedemo.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static net.serenitybdd.demos.todos.screenplay.saucedemo.user_interface.CheckoutPage.CONFIRMATION_MESSAGE;

public class ConfirmationMessage {

    public static Question<String> displayed() {
        return actor -> Text.of(CONFIRMATION_MESSAGE).answeredBy(actor);
    }
}

