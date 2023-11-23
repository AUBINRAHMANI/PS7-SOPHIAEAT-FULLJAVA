package fr.unice.polytech.biblio;
import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Person.Deliverer;
import fr.unice.polytech.biblio.Restaurant.Dish;
import fr.unice.polytech.biblio.Restaurant.HourTime;
import fr.unice.polytech.biblio.Restaurant.OpeningTime;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class MyStepdefs_DeliverADelivery {

        Deliverer deliverer;
        Order order;
        OpeningTime openingTime;

    @Given("a deliverer {string} has retrieved the order for delivery,")
    public void aDelivererHasRetrievedTheOrderForDelivery(String delivererName) {
        deliverer = new Deliverer(3,delivererName, "Lastname");
        HourTime openingHour = new HourTime(10,0);
        HourTime closingHour = new HourTime(22,0);
        openingTime = new OpeningTime(openingHour, closingHour);
        order = new Order(1, new Customer(1,"Jean", "Bon"), new Restaurant("McDo", "27 avenue des champs", openingTime));
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


