package net.serenitybdd.demos.todos.screenplay.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.demos.todos.screenplay.saucedemo.user_interface.CheckoutPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillCheckoutForm implements Task {

    private final String firstName;
    private final String lastName;
    private final String zipCode;

    public FillCheckoutForm(String firstName, String lastName, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(firstName).into(FIRST_NAME_FIELD),
                Enter.theValue(lastName).into(LAST_NAME_FIELD),
                Enter.theValue(zipCode).into(POSTAL_CODE_FIELD),
                Click.on(CONTINUE_BUTTON)
        );
    }

    public static FillCheckoutForm withData(String firstName, String lastName, String zipCode) {
        return instrumented(FillCheckoutForm.class, firstName, lastName, zipCode);
    }
}

