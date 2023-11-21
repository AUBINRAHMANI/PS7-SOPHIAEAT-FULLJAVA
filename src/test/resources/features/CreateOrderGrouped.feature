# Created by Aubin at 21/11/2023
Feature:

  Scenario: Cancel Order
    Given a customer "Toto" who has already chosen the restaurant "Nice" and with a filled order
    When "Toto" decides to cancel his order
    Then The order is cancelled, and "Toto" can't validate his order