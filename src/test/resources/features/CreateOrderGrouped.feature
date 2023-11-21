# Created by Aubin at 21/11/2023
Feature:

  Scenario: Create Order Grouped
    Given a connected user "Alice"
    When "Alice" create an order grouped with that dishes "hamburger" and "pizza"
    And Alice invite other users "Bob" and "Claire"
    Then the order grouped is created