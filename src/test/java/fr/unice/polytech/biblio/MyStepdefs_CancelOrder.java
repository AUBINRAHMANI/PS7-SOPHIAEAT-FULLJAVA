package fr.unice.polytech.biblio;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class MyStepdefs_CancelOrder {

    Customer customer;
    Restaurant restaurant;
    OrderController orderController;
    Order order;
    Dish dish;
    @Given("a customer {string} who has already chosen the restaurant {string} and with a filled order")
    public void aCustomerWhoHasAlreadyChosenTheRestaurantAndWithAFilledOrder(String customerName, String restaurantName) {
        customer = new Customer(customerName, "surname");
        restaurant = new Restaurant(restaurantName);
        orderController = new OrderController();
        orderController.createOrder(1,customer,restaurant);
        order=orderController.getOrder();
        orderController.chooseRestaurant(restaurant);
        dish = new Dish("hamburger", 10);
        orderController.addDish(dish);
    }

    @When("{string} decides to cancel his order")
    public void decidesToCancelHisOrder(String customerName) {
        orderController.cancelOrder(order);
    }

    @Then("The order is cancelled, and {string} can't validate his order")
    public void theOrderIsCancelledAndCanTValidateHisOrder(String customerName) {
        assertEquals(OrderState.CANCELLED,order.getOrderState());
        orderController.validateOrder(order);
        assertEquals(OrderState.CANCELLED,order.getOrderState());
    }
}
