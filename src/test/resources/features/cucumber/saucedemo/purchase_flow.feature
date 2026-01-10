@cucumber
@saucedemo
Feature: Purchase flow in SauceDemo

  As a customer
  I want to purchase products from SauceDemo
  So that I can complete my shopping

  Scenario: Complete a successful purchase
    Given John is on the SauceDemo login page
    When he logs in with username "standard_user" and password "secret_sauce"
    And he adds 2 products to the cart
    And he views the shopping cart
    And he proceeds to checkout
    And he completes the checkout form with:
      | firstName | John     |
      | lastName  | Doe      |
      | zipCode   | 12345    |
    And he finishes the purchase
    Then he should see the confirmation message "Thank you for your order!"

