package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Person.Deliverer;
import fr.unice.polytech.biblio.Restaurant.Dish;
import fr.unice.polytech.biblio.Restaurant.HourTime;
import fr.unice.polytech.biblio.Restaurant.Schedules;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class MyStepdefs_TakeInChargeADelivery {

        Deliverer deliverer;
        Restaurant restaurant;
        SimpleOrder order;
        Customer customer;
        OrderController orderController;
        SimpleOrderBuilder simpleOrderBuilder;
        @Given("a deliverer {string},")
        public void aDeliverer(String delivererName) {
                deliverer = new Deliverer(3,delivererName, "Jacky");
                customer = new Customer(1,"jean","paul");
        }


        @When("the deliverer {string} selects to take charge of a delivery,")
        public void theDelivererSelectsToTakeChargeOfADelivery(String arg0) {
                simpleOrderBuilder = new SimpleOrderBuilder();
                restaurant = simpleOrderBuilder.createRestaurant("KebabDelice");
                simpleOrderBuilder.createOrder(customer,restaurant);
                simpleOrderBuilder.addDish(customer,"kebab");
                order = simpleOrderBuilder.orderController.getOrderById(customer.getId());

                //evidemment faire toute la demarche

                order.setOrderState(OrderState.READY_TO_DELIVER);
                orderController = new OrderController();
                orderController.createOrder(1, new Customer(3,"Jean", "Bon"), restaurant);
                deliverer.TakeInChargeAnOrder(order);
        }


        @Then("the delivery is assigned to the deliverer {string}")
        public void theDeliveryIsAssignedToTheDeliverer(String arg0) {
                deliverer.TakeInChargeAnOrder(order);

        }


        @And("is updated “In process delivery”")
        public void isUpdatedInProcessDelivery() {
                assertEquals(OrderState.IN_PROGRESS_DELIVERY, order.getOrderState());
        }


}


