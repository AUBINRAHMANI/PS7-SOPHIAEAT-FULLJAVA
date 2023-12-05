# Created by wassi at 23/10/2023
Feature: Order Pass
  # Enter feature description here

  Scenario: Choose Restaurant
    Given a customer "Toto" "Dupond"
    When "Toto" choose the restaurant "Le chinois de Nice"
    Then he will be able to add dishes from the restaurant "Le chinois de Nice"


