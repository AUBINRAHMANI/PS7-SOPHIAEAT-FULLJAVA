package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Restaurant.Dish;
import fr.unice.polytech.biblio.Restaurant.HourTime;
import fr.unice.polytech.biblio.Restaurant.Schedules;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MyStepdefs_CancelOrder {

    Customer customer;
    Restaurant restaurant;
    OrderController orderController;
    SimpleOrder order;
    Dish dish;
    Schedules openingTime;

    SimpleOrderBuilder simpleOrderBuilder;

    @Given("a customer {string} who has already chosen the restaurant {string} and with a filled order")
    public void aCustomerWhoHasAlreadyChosenTheRestaurantAndWithAFilledOrder(String customerName, String restaurantName) {
        customer = new Customer(1,customerName, "surname");
        simpleOrderBuilder = new SimpleOrderBuilder();
        restaurant = simpleOrderBuilder.createRestaurant(restaurantName);
        simpleOrderBuilder.createOrder(customer,restaurant);
        simpleOrderBuilder.addDish(customer,"saladChevre");
        simpleOrderBuilder.addDish(customer,"royalSalad");

        //uniquement pour le test
        order = simpleOrderBuilder.orderController.getOrderById(customer.getId());
    }

    @When("{string} decides to cancel his order")
    public void decidesToCancelHisOrder(String customerName) {
        simpleOrderBuilder.cancelOrder(customer);

    }

    @Then("The order is cancelled and deleted, and {string} can't validate his order but he can create one more")
    public void theOrderIsCancelledAndCanTValidateHisOrder(String customerName) {
        assertEquals(OrderState.CANCELLED,order.getOrderState());
        HourTime currentTime = new HourTime(13,15);
        simpleOrderBuilder.validOrder(customer,currentTime);
        assertNull(simpleOrderBuilder.orderController.getOrderById(customer.getId()));

        //on test maintenant apres avoir payé
        simpleOrderBuilder.createOrder(customer,restaurant);
        SimpleOrder order2 = simpleOrderBuilder.orderController.getOrderById(customer.getId());
        simpleOrderBuilder.addDish(customer,"royalSalad");
        simpleOrderBuilder.validOrder(customer,currentTime);
        System.out.println("Vous devez payer : " + order2.getPriceOrder());
        simpleOrderBuilder.payOrder(customer,25);
        simpleOrderBuilder.cancelOrder(customer);
        assertEquals(OrderState.READY_TO_COOK,order2.getOrderState());

    }
}
