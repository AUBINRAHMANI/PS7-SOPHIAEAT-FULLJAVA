# Created by Aubin at 07/11/2023

Feature: valid a preparation

  Scenario: valid a preparation of an order
    Given restaurant "Nice" with an order from "Toto" in the preparation in progress status
    When the restaurant completes the preparation of "Toto"'s order
    Then the restaurant completes the preparation of "Toto"'s order
