# Created by Aubin at 25/10/2023
Feature: Valid an Order
  # Enter feature description here

  Scenario: Valid an Order
    Given a customer "Toto" "Dupond" who has already chosen the restaurant "saladParties" and with a filled order
    When "Toto" decides to validate order
    Then The order is confirmed, and "Toto" can pay his order