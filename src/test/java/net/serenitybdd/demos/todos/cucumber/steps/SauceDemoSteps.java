package net.serenitybdd.demos.todos.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.demos.todos.screenplay.saucedemo.questions.ConfirmationMessage;
import net.serenitybdd.demos.todos.screenplay.saucedemo.tasks.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.Map;

import static org.hamcrest.Matchers.equalToIgnoringCase;

public class SauceDemoSteps {

    @Given("{actor} is on the SauceDemo login page")
    public void actorIsOnLoginPage(Actor actor) {
        actor.attemptsTo(
                NavigateToSauceDemo.loginPage()
        );
    }

    @When("{actor} logs in with username {string} and password {string}")
    public void actorLogsIn(Actor actor, String username, String password) {
        actor.attemptsTo(
                Login.withCredentials(username, password)
        );
    }

    @When("{actor} adds {int} products to the cart")
    public void actorAddsProductsToCart(Actor actor, int numberOfProducts) {
        actor.attemptsTo(
                AddProductsToCart.adding(numberOfProducts)
        );
    }

    @When("{actor} views the shopping cart")
    public void actorViewsShoppingCart(Actor actor) {
        actor.attemptsTo(
                ViewCart.page()
        );
    }

    @When("{actor} proceeds to checkout")
    public void actorProceedsToCheckout(Actor actor) {
        actor.attemptsTo(
                ProceedToCheckout.now()
        );
    }

    @When("{actor} completes the checkout form with:")
    public void actorCompletesCheckoutForm(Actor actor, Map<String, String> formData) {
        actor.attemptsTo(
                FillCheckoutForm.withData(
                        formData.get("firstName"),
                        formData.get("lastName"),
                        formData.get("zipCode")
                )
        );
    }

    @When("{actor} finishes the purchase")
    public void actorFinishesPurchase(Actor actor) {
        actor.attemptsTo(
                FinishPurchase.now()
        );
    }

    @Then("{actor} should see the confirmation message {string}")
    public void actorShouldSeeConfirmationMessage(Actor actor, String expectedMessage) {
        actor.attemptsTo(
                Ensure.that(ConfirmationMessage.displayed()).isEqualToIgnoringCase(expectedMessage)
        );
    }
}

