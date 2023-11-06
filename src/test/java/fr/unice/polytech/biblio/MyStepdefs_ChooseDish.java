package fr.unice.polytech.biblio;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MyStepdefs_ChooseDish {

    Restaurant restaurant;
    Customer customer;
    Dish dish;
    OrderController orderController;
    Order order;
    ArrayList<Dish> dishes;
    @Given("a customer {string} who has chosen the restaurant {string}")
    public void aCustomerWhoHasChosenTheRestaurant(String customerName, String restaurantName) {
        customer = new Customer(customerName, "Some Surname");
        restaurant = new Restaurant(restaurantName);
        //order = new Order(1, customer, restaurant, dishes);
        orderController = new OrderController();
        orderController.createOrder(1, customer, restaurant);
        order = orderController.getOrder();
        orderController.chooseRestaurant(restaurant);


    }

    @When("{string} add a dish {string}")
    public void addADish(String customerName, String dish) {
        this.dish = new Dish(dish,10);
        orderController.addDish(this.dish);
        System.out.println(order.getPriceOrder());
    }

    @Then("the order price will increase by {string} ‘s price")
    public void theOrderPriceWillIncreaseBySPrice(String price) {
        assertNotNull(orderController.getOrder());

    }

}
