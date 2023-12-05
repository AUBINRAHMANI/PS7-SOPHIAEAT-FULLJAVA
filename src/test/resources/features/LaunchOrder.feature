# Created by Aubin at 31/10/2023

Feature: Launch an order

  Scenario: Cook launch an order
    Given restaurant "KebabDelice" with a paid order for user "Toto"
    When restaurant "KebabDelice" begins preparing the order for "Toto"
    Then the status of "Toto"'s order is updated to ''preparation in progress''
