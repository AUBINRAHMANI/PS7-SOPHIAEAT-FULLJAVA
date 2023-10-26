package fr.unice.polytech.biblio;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.security.interfaces.DSAKey;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyStepdefs_payOrder {

    Order order;
    OrderController orderController;

    Customer customer;

    Dish dish ;

    Restaurant restaurant;

    Dish pizza;

    ArrayList<Dish> dishes;


    @Given("a customer {String} who has an order with one dish {String} in the restaurant {String}")
    public void customerWhoHasOrdered(String customerName, String dishName, String nameRestaurant){
        customer = new Customer(customerName,"huzog");
        dish = new Dish(dishName,20);
        pizza = new Dish("pizza",30);
        restaurant = new Restaurant(nameRestaurant);
        restaurant.addDish(dish);
        restaurant.addDish(pizza);
        dishes = restaurant.getDishes();

        orderController = new OrderController();
        orderController.createOrder(1,customer,restaurant,dishes);
        orderController.chooseRestaurant(restaurant);
        order = orderController.getOrder();
    }


}
