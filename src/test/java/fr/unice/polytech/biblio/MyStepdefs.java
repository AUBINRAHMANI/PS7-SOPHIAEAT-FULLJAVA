package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Customer;
import fr.unice.polytech.biblio.Dish;
import fr.unice.polytech.biblio.OrderController;
import fr.unice.polytech.biblio.Restaurant;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MyStepdefs {


    Restaurant restaurant;

    Customer customer;

    Dish dish;

    OrderController orderController;
    Order order;

    ArrayList<Dish> dishes = new ArrayList<Dish>();

    @Given("a customer {string} {string}")
    public void aCustomer(String customerName, String customerSurname){
        customer = new Customer(customerName, customerSurname);
        order = new Order(1, customer, restaurant, dishes);

    }


    @When("{string} choose the restaurant {string}")
    public void chooseTheRestaurant(String customerName, String restaurantName) {
        restaurant = new Restaurant(restaurantName);
        //order = new Order(1, customer, restaurant, dishes);
        orderController = new OrderController();
        orderController.createOrder(1, customer, restaurant, dishes);
        orderController.chooseRestaurant(restaurant);
    }

    @Then("he will be able to add dishes from the restaurant {string}")
    public void heWillBeAbleToAddDishesFromTheRestaurant(String restaurantName) {
        assertNotNull(orderController.getCurrentOrder());

        dish = restaurant.getDishByName("Some Dish"); // Remplacez "Some Dish" par le nom du plat souhaité.
        orderController.addDish(dish);
//
//
        //assertTrue(Boolean.parseBoolean(orderController.getCurrentOrder().toString()));
    }



}