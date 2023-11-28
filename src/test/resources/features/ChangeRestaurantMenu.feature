Feature: Change Menu

  Scenario: Add Dish To Menu
    Given a restaurant manager "Toto" of the restaurant "Nice"
    When the manager decides to add a dish "Pizza" costing 8.5
    Then the restaurant have a new dish

  Scenario: Remove Dish Of Menu
    Given a restaurant manager "Toto" of the restaurant "Nice"
    When the manager decides to remove the dish "Burger" costing 10.5
    Then the restaurant don't have the dish anymore

  Scenario: Change Price Of Dish
    Given a restaurant manager "Toto" of the restaurant "Nice"
    When the manager decides change the price of the dish "Salad" from 12 to 10
    Then the dish "Salad" price is now 10
