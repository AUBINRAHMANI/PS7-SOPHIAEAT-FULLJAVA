# Created by wassi at 24/10/2023
Feature: Choose Dish
  # Enter feature description here

  Scenario: Choose Dish
    Given a customer "Toto" who has chosen the restaurant "Nice"
    When "Toto" add a dish "Pizza"
    Then the order price will increase by "Pizza" ‘s price
