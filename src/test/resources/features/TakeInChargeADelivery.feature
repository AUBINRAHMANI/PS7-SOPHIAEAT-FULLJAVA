# Created by wassi at 07/11/2023
Feature: Take in charge a delivery


  Scenario:  Take in charge a delivery
  Given a deliverer "Jacky",
  When the deliverer "Jacky" selects to take charge of a delivery,
  Then the delivery is assigned to the deliverer "Jacky."
  And is updated “In process delivery”
