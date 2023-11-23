package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Cook;
import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Restaurant.OpeningTime;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import fr.unice.polytech.biblio.Restaurant.Dish;
import fr.unice.polytech.biblio.Restaurant.HourTime;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class MyStepdefs_ValidAPreparation {
    Customer customer;
    private Restaurant restaurant;
    OrderController orderController;
    Dish pizza;
    SimpleOrder order;
    Cook cook;
    OpeningTime openingTime;


    @Given("restaurant {string} with an order from {string} in the preparation in progress status")
    public void OrderInPreparedStatus(String restaurantName, String customerName){
        customer = new Customer(2,customerName,"huzog");
        HourTime openingHour = new HourTime(10,0);
        HourTime closingHour = new HourTime(22,0);
        openingTime = new OpeningTime(openingHour, closingHour);
        restaurant = new Restaurant(restaurantName, "6 rue de l'eglise", openingTime);
        pizza = new Dish("pizza",15);

        restaurant.addDish(pizza);
        orderController = new OrderController();

        orderController.createOrder(1,customer,restaurant);
        order = orderController.getOrderById(1);
        orderController.chooseRestaurant(order, restaurant);
        orderController.addDish(order, pizza);



        System.out.println(order.getPriceOrder());

        HourTime currentTime = new HourTime(16,0);
        orderController.validateOrder(order, currentTime);
        orderController.pay(order,15);
        orderController.notify(order, restaurant);

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
