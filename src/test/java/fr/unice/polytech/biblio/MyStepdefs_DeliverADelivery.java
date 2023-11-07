package fr.unice.polytech.biblio;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class MyStepdefs_DeliverADelivery {

        Deliverer deliverer;
        Order order;

    @Given("a deliverer {string} has retrieved the order for delivery,")
    public void aDelivererHasRetrievedTheOrderForDelivery(String delivererName) {
        deliverer = new Deliverer(delivererName, "Lastname");
        order = new Order(1, new Customer("Jean", "Bon"), new Restaurant("McDo"));
        order.addDish(new Dish("BigMac", 10));
        order.setOrderState(OrderState.READY_TO_DELIVER);
    }


    @When("the deliverer {string} successfully delivers the order to the specified destination,")
    public void theDelivererSuccessfullyDeliversTheOrderToTheSpecifiedDestination(String arg0) {
        deliverer.DeliverAnOrder(order);
    }


    @Then("the delivery is marked as {string} by the system.")
    public void theDeliveryIsMarkedAsByTheSystem(String deliveryStatus) {
        OrderState expectedState = (deliveryStatus.equalsIgnoreCase("delivered")) ? OrderState.READY_TO_DELIVER : OrderState.IN_PROGRESS_DELIVERY;
        assertEquals(expectedState, order.getOrderState());
    }
}


