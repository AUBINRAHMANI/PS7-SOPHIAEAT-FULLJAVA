Feature: Change Menu

  Scenario: Add Dish To Menu
    Given a restaurant manager "Toto" of the restaurant "kebabDelice"
    When the manager decides to add a dish "tacos" costing 8.5
    Then the restaurant have a new dish

  Scenario: Remove Dish Of Menu
    Given a restaurant manager "Toto" of the restaurant "kebabDelice"
    When the manager decides to remove the dish "kebab" costing 10
    Then the restaurant don't have the dish anymore

  Scenario: Change Price Of Dish
    Given a restaurant manager "Toto" of the restaurant "kebabDelice"
    When the manager decides change the price of the dish "fries" from 5 to 10
    Then the dish "fries" price is now 12
