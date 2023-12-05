package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Cook;
import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Restaurant.Schedules;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import fr.unice.polytech.biblio.Restaurant.Dish;
import fr.unice.polytech.biblio.Restaurant.HourTime;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class MyStepdefs_ValidAPreparation {

    SimpleOrderBuilder simpleOrderBuilder;
    Customer customer;
    private Restaurant restaurant;
    OrderController orderController;
    Dish pizza;
    SimpleOrder order;
    Cook cook;
    Schedules openingTime;


    @Given("restaurant {string} with an order from {string} in the preparation in progress status")
    public void OrderInPreparedStatus(String restaurantName, String customerName){
        customer = new Customer(2,customerName,"huzog");
        simpleOrderBuilder = new SimpleOrderBuilder();
        restaurant = simpleOrderBuilder.createRestaurant(restaurantName);
        simpleOrderBuilder.createOrder(customer,restaurant);
        simpleOrderBuilder.addDish(customer,"kebab");
        order = simpleOrderBuilder.orderController.getOrderById(customer.getId());
        System.out.println(order.getPriceOrder());

        HourTime currentTime = new HourTime(16,0);
        simpleOrderBuilder.validOrder(customer, currentTime);
        simpleOrderBuilder.payOrder(customer,10);
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
