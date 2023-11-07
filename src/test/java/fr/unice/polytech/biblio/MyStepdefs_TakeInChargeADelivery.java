package fr.unice.polytech.biblio;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.hu.De;

public class MyStepdefs_TakeInChargeADelivery {

        Deliverer deliverer;

        Restaurant restaurant;

        Order order;

        Dish dish;

        OrderController orderController;



        @Given("a deliverer {string}")
        public void a_deliverer(String delivererName) {
            // Add your code here to create a deliverer

        }

        @When("the deliverer {string} selects to take charge of a delivery")
        public void the_deliverer_selects_to_take_charge_of_a_delivery(String delivererName) {
            // Add your code here to simulate the delivery assignment process


        }

        @Then("the delivery is assigned to the deliverer {string} and is updated {string}")
        public void the_delivery_is_assigned_to_the_deliverer_and_is_updated(String delivererName, String status) {
            // Add your code here to check if the delivery is assigned to the correct deliverer and has the correct status


        }
    }


