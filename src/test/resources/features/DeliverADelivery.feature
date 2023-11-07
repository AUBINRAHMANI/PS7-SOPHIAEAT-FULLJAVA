# Created by wassi at 07/11/2023
Feature: Deliver a delivery


  Scenario: Deliver a delivery
  GIVEN a deliverer "Jacky" has retrieved the order for delivery,
  WHEN the deliverer "Jacky" successfully delivers the order to the specified destination,
  THEN the delivery is marked as "delivered" by the system.
