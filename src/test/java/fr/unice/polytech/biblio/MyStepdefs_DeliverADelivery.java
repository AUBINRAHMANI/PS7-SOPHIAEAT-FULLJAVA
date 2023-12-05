package fr.unice.polytech.biblio;
import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Person.Deliverer;
import fr.unice.polytech.biblio.Restaurant.Dish;
import fr.unice.polytech.biblio.Person.Cook;

import fr.unice.polytech.biblio.Restaurant.HourTime;
import fr.unice.polytech.biblio.Restaurant.Schedules;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class MyStepdefs_DeliverADelivery {

        SimpleOrderBuilder simpleOrderBuilder;

        Cook cook;

        Restaurant restaurant;
        Deliverer deliverer;
        SimpleOrder order;


    @Given("a deliverer {string} has retrieved the order for delivery,")
    public void aDelivererHasRetrievedTheOrderForDelivery(String delivererName) {
        HourTime currentTime = new HourTime(20,0);
        Customer customer = new Customer(1,"jean paul","huzog");
        deliverer = new Deliverer(3,delivererName, "Lastname");
        simpleOrderBuilder = new SimpleOrderBuilder();
        restaurant = simpleOrderBuilder.createRestaurant("KebabDelice");
        simpleOrderBuilder.createOrder(customer,restaurant);
        simpleOrderBuilder.addDish(customer,"kebab");
        order = simpleOrderBuilder.orderController.getOrderById(customer.getId());
        simpleOrderBuilder.validOrder(customer,currentTime);
        simpleOrderBuilder.payOrder(customer,10);

        System.out.println(order.getOrderState());

        cook = new Cook(4,"Rachid","bouboule",restaurant);
        cook.prepareOrder(order);
        cook.completeOrder(order);

    }


    @When("the deliverer {string} successfully delivers the order to the specified destination,")
    public void theDelivererSuccessfullyDeliversTheOrderToTheSpecifiedDestination(String arg0) {
        deliverer.TakeInChargeAnOrder(order);
        deliverer.DeliverAnOrder(order);

    }


    @Then("the delivery is marked as {string} by the system.")
    public void theDeliveryIsMarkedAsByTheSystem(String deliveryStatus) {
        OrderState expectedState = (deliveryStatus.equalsIgnoreCase("delivered")) ? OrderState.DELIVERED : OrderState.IN_PROGRESS_DELIVERY;
        assertEquals(expectedState, order.getOrderState());


    }
}


