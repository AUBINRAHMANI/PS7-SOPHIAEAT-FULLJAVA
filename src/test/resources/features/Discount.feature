# Created by val at 28/11/2023
Feature: Discount


  Scenario: Get a discount
    Given a connected user "Tutu" who already ordered 9 times at the restaurant "Burger King"
    When the user complete a new order
    Then he get a 0.05 discount

  Scenario: Discount expire
    Given a connected user "Tutu" who got a discount 1 months ago
    When the user complete a new order
    Then he lose his discount

  Scenario: Discount prolongation
    Given a connected user "Tutu" who got a discount 10 days ago and ordered 9 times in the mean time
    When the user complete a new order
    Then the discount is prolongated

