@cucumber
@saucedemo
Feature: Purchase flow in SauceDemo

  As a customer
  I want to purchase products from SauceDemo
  So that I can complete my shopping

  Scenario Outline: Complete a successful purchase with different users
    Given <actor> is on the SauceDemo login page
    When he logs in with username "<username>" and password "<password>"
    And he adds <productCount> products to the cart
    And he views the shopping cart
    And he proceeds to checkout
    And he completes the checkout form with:
      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | zipCode   | <zipCode>   |
    And he finishes the purchase
    Then he should see the confirmation message "Thank you for your order!"

    Examples:
      | actor   | username        | password     | productCount | firstName | lastName  | zipCode |
      | John    | standard_user   | secret_sauce | 2            | John      | Barahona       | 12345   |
      | Sarah   | standard_user   | secret_sauce | 3            | Sarah     | Muñoz     | 67890   |
      | Michael | standard_user   | secret_sauce | 1            | Michael   | Vargas   | 54321   |

