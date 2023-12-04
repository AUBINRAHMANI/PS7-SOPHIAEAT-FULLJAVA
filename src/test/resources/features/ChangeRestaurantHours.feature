Feature: Change Opening Hours

  Scenario: Change Opening Hours
    Given a manager "Toto" of the restaurant "Le chinois de Nice"
    When the manager decides to change the hours to 10:30 - 18:45
    Then the restaurant hours are changed
