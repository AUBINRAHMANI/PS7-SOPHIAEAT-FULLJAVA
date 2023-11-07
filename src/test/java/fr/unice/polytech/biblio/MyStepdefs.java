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
   // ArrayList<Dish> dishes = new ArrayList<Dish>();
    OpeningTime openingTime;

    @Given("a customer {string} {string}")
    public void aCustomer(String customerName, String customerSurname){
        customer = new Customer(customerName, customerSurname);
    }


    @When("{string} choose the restaurant {string}")
    public void chooseTheRestaurant(String customerName, String restaurantName) {
        HourTime openingHour = new HourTime(10,0);
        HourTime closingHour = new HourTime(22,0);
        openingTime = new OpeningTime(openingHour, closingHour);
        restaurant = new Restaurant(restaurantName, "98 rue de la paix", openingTime);
        dish = new Dish("pizza",15);
        restaurant.addDish(dish);
        //order = new Order(1, customer, restaurant, dishes);
        orderController = new OrderController();
        orderController.createOrder(1, customer, restaurant);
        order = orderController.getOrder();
        orderController.chooseRestaurant(restaurant);
    }

    @Then("he will be able to add dishes from the restaurant {string}")
    public void heWillBeAbleToAddDishesFromTheRestaurant(String restaurantName) {
        assertNotNull(orderController.getOrder());
        dish = restaurant.getDishByName("pizza");
        orderController.addDish(dish);
//
//
        //assertTrue(Boolean.parseBoolean(orderController.getCurrentOrder().toString()));
    }



}