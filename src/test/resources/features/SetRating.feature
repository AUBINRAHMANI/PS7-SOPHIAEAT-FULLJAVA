# Created by wassi at 19/12/2023
Feature: SetRating

  Scenario: Set a rate to an order
    Given a User "Toto" who has already order an order at restaurant "KebabDelice"
    And the order has been delivered
    When "Toto" set a rate "5" to the order
    Then the rate is registered

