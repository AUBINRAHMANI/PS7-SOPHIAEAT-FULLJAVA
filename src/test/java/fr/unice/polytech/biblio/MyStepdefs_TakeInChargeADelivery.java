package fr.unice.polytech.biblio;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.hu.De;

import static org.junit.Assert.assertEquals;

public class MyStepdefs_TakeInChargeADelivery {

        Deliverer deliverer;
        Restaurant restaurant;
        Order order;
        Dish dish;
        OrderController orderController;
        OpeningTime openingTime;

        @Given("a deliverer {string},")
        public void aDeliverer(String delivererName) {
                deliverer = new Deliverer(delivererName, "Jacky");
        }


        @When("the deliverer {string} selects to take charge of a delivery,")
        public void theDelivererSelectsToTakeChargeOfADelivery(String arg0) {
                HourTime openingHour = new HourTime(10,0);
                HourTime closingHour = new HourTime(22,0);
                openingTime = new OpeningTime(openingHour, closingHour);
                restaurant = new Restaurant("McDonalds", "34 rue de montmartre", openingTime);
                order = new Order(1, new Customer("Jean", "Bon"), restaurant);
                order.setOrderState(OrderState.READY_TO_DELIVER);
                orderController = new OrderController();
                orderController.createOrder(1, new Customer("Jean", "Bon"), restaurant);
                deliverer.TakeInChargeAnOrder(order);
        }


        @Then("the delivery is assigned to the deliverer {string}")
        public void theDeliveryIsAssignedToTheDeliverer(String arg0) {

        }


        @And("is updated “In process delivery”")
        public void isUpdatedInProcessDelivery() {
                assertEquals(OrderState.IN_PROGRESS_DELIVERY, order.getOrderState());
        }


}


