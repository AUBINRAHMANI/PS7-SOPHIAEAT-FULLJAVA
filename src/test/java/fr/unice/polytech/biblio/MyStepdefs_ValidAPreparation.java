package fr.unice.polytech.biblio;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.security.interfaces.DSAKey;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MyStepdefs_ValidAPreparation {
    Customer customer;
    private Restaurant restaurant;

    OrderController orderController;

    Dish pizza;

    Order order;

    Cook cook;



    @Given("restaurant {string} with an order from {string} in the preparation in progress status")
    public void OrderInPreparedStatus(String restautantName, String customerName){
        customer = new Customer(customerName,"huzog");
        restaurant = new Restaurant(restautantName);
        pizza = new Dish("pizza",15);

        restaurant.addDish(pizza);
        orderController = new OrderController();

        orderController.createOrder(1,customer,restaurant);
        orderController.chooseRestaurant(restaurant);
        orderController.addDish(pizza);

        order = orderController.getOrder();

        System.out.println(order.getPriceOrder());

        orderController.validateOrder(order);
        orderController.pay(order,15);
        orderController.notify(restaurant);

        cook = new Cook(1,"Obelix","Potion",restaurant);
        cook.prepareOrder(order);
        assertEquals(order.getOrderState(),OrderState.IN_PROGRESS);
    }

    @When("the restaurant completes the preparation of {string}'s order")
    public void OrderCompleted(String customerName){
        cook.completeOrder(order);
    }

    @Then("the order status for {string}'s order is updated to ready to deliver and {string} is notified")
    public void orderIsReadyToDeliver(String username){
        assertEquals(order.getOrderState(),OrderState.READY_TO_DELIVER);
    }
}
