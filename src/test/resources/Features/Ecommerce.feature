Feature: Ecommerce
@Regression

Scenario Outline: Buying a Product in Ecommerce application

    Given Customer Login with "<username>" and "<password>"
    When Customer adding the products to the cart
    And Customer giving details for confiriming the order
    Then customer Placed the order SuccessFully

Examples:
| username      | password     |
| standard_user | secret_sauce |