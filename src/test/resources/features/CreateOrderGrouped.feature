# Created by Aubin at 21/11/2023
Feature:

  Scenario: Create Order Grouped
    Given a connected user "Alice"
    When "Alice" create an order simple with that dishes: "Hamburger"
    And "Alice" create another order simple for user "bob" with that dishes : "Pizza"
    Then the order grouped is created