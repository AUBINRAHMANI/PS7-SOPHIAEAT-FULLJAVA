# Created by wassi at 07/11/2023
Feature: Deliver a delivery


  Scenario: Deliver a delivery
  Given a deliverer "Jacky" has retrieved the order for delivery,
  When the deliverer "Jacky" successfully delivers the order to the specified destination,
  Then the delivery is marked as "delivered" by the system.
