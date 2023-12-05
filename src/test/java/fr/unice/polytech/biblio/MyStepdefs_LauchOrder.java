package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Cook;
import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Restaurant.Dish;
import fr.unice.polytech.biblio.Restaurant.HourTime;
import fr.unice.polytech.biblio.Restaurant.Schedules;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class MyStepdefs_LauchOrder {

    Customer customer;
    SimpleOrderBuilder simpleOrderBuilder;
    Restaurant restaurant;
    Dish pizza;
   // ArrayList<Dish> dishes;
    OrderController orderController;
    SimpleOrder order;
    Cook cook;
    Schedules openingTime;

    @Given("restaurant {string} with a paid order for user {string}")
    public void paidOrderofUser(String restaurantName, String userName){

        customer = new Customer(2,userName,"huzog");
        simpleOrderBuilder = new SimpleOrderBuilder();
        restaurant = simpleOrderBuilder.createRestaurant(restaurantName);
        simpleOrderBuilder.createOrder(customer,restaurant);
        simpleOrderBuilder.addDish(customer,"kebab");
        order = simpleOrderBuilder.orderController.getOrderById(customer.getId());
        HourTime currentTime = new HourTime(14,30);
        simpleOrderBuilder.validOrder(customer, currentTime);
        simpleOrderBuilder.payOrder(customer,10);
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
