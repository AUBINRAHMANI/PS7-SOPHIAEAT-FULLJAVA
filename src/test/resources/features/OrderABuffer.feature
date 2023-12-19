#created by Aubin

Feature: order an buffet

  Scenario: Polytech order an buffet for his students
    Given the organization "Polytech" orders an buffet for his 100 students at the restaurant "KebabDelice"
    When 50 "kebab", 50 "pizza" and 100 "tiramisuDelice" are ordered to 21:0 pm
    Then The order Buffet can be delivered only at 21:0 pm


