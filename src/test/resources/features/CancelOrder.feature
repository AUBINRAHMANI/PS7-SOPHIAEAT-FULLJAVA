# Created by valentin at 07/11/2023
Feature: Cancel Order

  Scenario: Cancel Order
    Given a customer "Toto" who has already chosen the restaurant "saladParties" and with a filled order
    When "Toto" decides to cancel his order
    Then The order is cancelled and deleted, and "Toto" can't validate his order but he can create one more
