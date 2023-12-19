# Created by Aubin at 19/12/2023
Feature: OrderPass

  Scenario: Menu Display
    Given a customer "Toto"
    When  When “Toto” want to see the available menu of the restaurant "KebabDelice"
    Then available menus of the restaurant "KebabDelice" are displayed
