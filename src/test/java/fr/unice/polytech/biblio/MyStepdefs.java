package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Restaurant.Dish;
import fr.unice.polytech.biblio.Restaurant.HourTime;
import fr.unice.polytech.biblio.Restaurant.OpeningTime;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class MyStepdefs {


    Restaurant restaurant;
    Customer customer;
    Dish dish;
    OrderController orderController;
    SimpleOrder order;
   // ArrayList<Dish> dishes = new ArrayList<Dish>();
    OpeningTime openingTime;

    @Given("a customer {string} {string}")
    public void aCustomer(String customerName, String customerSurname){
        customer = new Customer(2,customerName, customerSurname);
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
        order = orderController.getOrderById(1);
        orderController.chooseRestaurant(order, restaurant);
    }

    @Then("he will be able to add dishes from the restaurant {string}")
    public void heWillBeAbleToAddDishesFromTheRestaurant(String restaurantName) {
        assertNotNull(order);
        dish = restaurant.getDishByName("pizza");
        orderController.addDish(order, dish);
//
//
        //assertTrue(Boolean.parseBoolean(orderController.getCurrentOrder().toString()));
    }



}