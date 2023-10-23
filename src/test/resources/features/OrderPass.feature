# Created by wassi at 23/10/2023
Feature: Order Pass
  # Enter feature description here

  Scenario: Menu Display
    Given a customer "Toto"
    When “Toto” want to see the available menu of the restaurant "Nice"
    Then available menus of the restaurant "Nice" are displayed

