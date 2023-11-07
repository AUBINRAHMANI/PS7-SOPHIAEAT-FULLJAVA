# Created by wassi at 07/11/2023
Feature: Take in charge a delivery


  Scenario:  Take in charge a delivery
  GIVEN a deliverer "Jacky",
  WHEN the deliverer "Jacky" selects to take charge of a delivery,
  THEN the delivery is assigned to the deliverer "Jacky."
  AND is updated “In process delivery”
