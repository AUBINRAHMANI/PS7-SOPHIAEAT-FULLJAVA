# Created by Aubin at 26/10/2023

  #Feature for pay an Order
  Feature: pay an order

    Scenario: Pay an Order
      Given a customer "Toto" who has an order with one dish "kebab" in the restaurant "KebabDelice"
      When "Toto" pays the order
      Then the order is paid, the payement is valid and the restaurant is notified of the order for preparation

