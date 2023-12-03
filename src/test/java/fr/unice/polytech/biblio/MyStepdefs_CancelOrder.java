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

public class MyStepdefs_CancelOrder {

    Customer customer;
    Restaurant restaurant;
    OrderController orderController;
    SimpleOrder order;
    Dish dish;
    Schedules openingTime;
    @Given("a customer {string} who has already chosen the restaurant {string} and with a filled order")
    public void aCustomerWhoHasAlreadyChosenTheRestaurantAndWithAFilledOrder(String customerName, String restaurantName) {
        customer = new Customer(1,customerName, "surname");
        HourTime openingHour = new HourTime(10,0);
        HourTime closingHour = new HourTime(22,0);
        openingTime = new Schedules(openingHour, closingHour);
        restaurant = new Restaurant(restaurantName, "1 rue du Coulon", openingTime);
        orderController = new OrderController();
        orderController.createOrder(1,customer,restaurant);
        order=orderController.getOrderById(1);
        orderController.chooseRestaurant(order, restaurant);
        dish = new Dish("hamburger", 10);
        orderController.addDish(order, dish);
    }

    @When("{string} decides to cancel his order")
    public void decidesToCancelHisOrder(String customerName) {
        orderController.cancelOrder(order);
    }

    @Then("The order is cancelled, and {string} can't validate his order")
    public void theOrderIsCancelledAndCanTValidateHisOrder(String customerName) {
        assertEquals(OrderState.CANCELLED,order.getOrderState());
        HourTime currentTime = new HourTime(13,15);
        orderController.validateOrder(order, currentTime);
        assertEquals(OrderState.CANCELLED,order.getOrderState());
    }
}