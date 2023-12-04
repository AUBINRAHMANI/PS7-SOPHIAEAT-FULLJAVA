# Created by wassi at 24/10/2023
Feature: # Enter feature name here
  # Enter feature description here

  Scenario: ChooseDish
    Given a customer "Toto" who has chosen the restaurant "KebabDelice"
    When "Toto" add a dish "kebab"
    Then the order price will increase by "kebab" ‘s price
