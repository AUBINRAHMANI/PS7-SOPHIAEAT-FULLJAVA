package fr.unice.polytech.biblio;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.internal.matchers.Or;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MyStepdefs_LauchOrder {

    Customer customer;

    Restaurant restaurant;

    Dish pizza;

   // ArrayList<Dish> dishes;

    OrderController orderController;

    Order order;

    Cook cook;

    @Given("restaurant {string} with a paid order for user {string}")
    public void paidOrderofUser(String restaurantName, String userName){

        Customer customer = new Customer(userName,"huzog");
        pizza = new Dish("pizza", 15);
        restaurant = new Restaurant(restaurantName);
        restaurant.addDish(pizza);
        orderController = new OrderController();
        orderController.createOrder(1,customer,restaurant);
        order = orderController.getOrder();
        orderController.chooseRestaurant(restaurant);

        orderController.addDish(pizza);
        System.out.println(order.getDishes());
        orderController.validateOrder(order);

        orderController.pay(order,15);
        assertEquals(order.getOrderState(),OrderState.READY_TO_COOK);
    }

    @When("restaurant {string} begins preparing the order for {string}")
    public void prepareTheOrderForCustomer(String restaurantName, String customerName){
        cook = new Cook(1,"Obelix","Potion",restaurant);
        cook.prepareOrder(order);
    }

    @Then("the status of {string}'s order is updated to ''preparation in progress''")
    public void orderUpdated(String customerName){
        assertEquals(order.getOrderState(),OrderState.IN_PROGRESS);
    }
}
