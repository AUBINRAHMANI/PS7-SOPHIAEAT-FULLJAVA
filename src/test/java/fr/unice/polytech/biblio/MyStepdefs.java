package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Restaurant.Dish;
import fr.unice.polytech.biblio.Restaurant.HourTime;
import fr.unice.polytech.biblio.Restaurant.Schedules;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class MyStepdefs {

    SimpleOrderBuilder simpleOrderBuilder;
    Restaurant restaurant;
    Customer customer;
    Dish dish;
    OrderController orderController;
    SimpleOrder order;
   // ArrayList<Dish> dishes = new ArrayList<Dish>();
    Schedules openingTime;

    @Given("a customer {string} {string}")
    public void aCustomer(String customerName, String customerSurname){
        customer = new Customer(2,customerName, customerSurname);
    }


    @When("{string} choose the restaurant {string}")
    public void chooseTheRestaurant(String customerName, String restaurantName) {
        simpleOrderBuilder = new SimpleOrderBuilder();
        restaurant = simpleOrderBuilder.createRestaurant(restaurantName);
        simpleOrderBuilder.createOrder(customer,restaurant);

        order = simpleOrderBuilder.orderController.getOrderById(customer.getId());
    }

    @Then("he will be able to add dishes from the restaurant {string}")
    public void heWillBeAbleToAddDishesFromTheRestaurant(String restaurantName) {
        assertNotNull(order);
        dish = restaurant.getDishByName("maki");
        simpleOrderBuilder.addDish(customer,dish);

        Dish dishPizza = new Dish("pizza",10);
        assertFalse(simpleOrderBuilder.addDish(customer,dishPizza));
//
//
        //assertTrue(Boolean.parseBoolean(orderController.getCurrentOrder().toString()));
    }



}