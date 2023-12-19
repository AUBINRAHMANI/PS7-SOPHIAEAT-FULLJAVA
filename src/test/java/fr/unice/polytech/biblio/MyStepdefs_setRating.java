package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Payement.PayementState;
import fr.unice.polytech.biblio.Payement.PayementSystem;
import fr.unice.polytech.biblio.Person.Cook;
import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Person.Deliverer;
import fr.unice.polytech.biblio.Restaurant.Dish;
import fr.unice.polytech.biblio.Restaurant.HourTime;
import fr.unice.polytech.biblio.Restaurant.Schedules;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class MyStepdefs_setRating {

    Customer customer;
    Restaurant restaurant;
    OrderController orderController;
    SimpleOrder order;
    Dish dish;
    Schedules openingTime;
    Deliverer deliverer;
    SimpleOrderBuilder simpleOrderBuilder;
    Cook cook;

    @Given("a User {string} who has already order an order at restaurant {string}")
    public void aUserWhoHasAlreadyOrderAnOrderAtRestaurant(String user, String restaurantName) {
        HourTime currentTime = new HourTime(20,0);
        Customer customer = new Customer(1,user,"huzog");
        deliverer = new Deliverer(3,"delivererName", "Lastname");
        simpleOrderBuilder = new SimpleOrderBuilder();
        restaurant = simpleOrderBuilder.createRestaurant(restaurantName);
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



    @And("the order has been delivered")
    public void theOrderHasBeenDelivered() {
        deliverer.TakeInChargeAnOrder(order);
        deliverer.DeliverAnOrder(order);
    }

    @When("{string} set a rate {string} to the order")
    public void setARateToTheOrder(String customerName, String rating) {
        int rate = Integer.parseInt(rating);
        order.setRating(rate);
    }

    @Then("the rate is registered")
    public void theRateIsRegistered() {
        assertEquals(5,order.getRating());
    }



}
