package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Restaurant.Dish;
import fr.unice.polytech.biblio.Restaurant.HourTime;
import fr.unice.polytech.biblio.Restaurant.OpeningTime;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
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
    SimpleOrder order;
    ArrayList<Dish> dishes;
    OpeningTime openingTime;
    @Given("a customer {string} who has chosen the restaurant {string}")
    public void aCustomerWhoHasChosenTheRestaurant(String customerName, String restaurantName) {
        customer = new Customer(3 ,customerName, "Some Surname");
        HourTime openingHour = new HourTime(10,0);
        HourTime closingHour = new HourTime(22,0);
        openingTime = new OpeningTime(openingHour, closingHour);
        restaurant = new Restaurant(restaurantName, "7 avenue verte", openingTime);
        //order = new Order(1, customer, restaurant, dishes);
        orderController = new OrderController();
        orderController.createOrder(1, customer, restaurant);
        order = orderController.getOrderById(1);
        orderController.chooseRestaurant(order, restaurant);


    }

    @When("{string} add a dish {string}")
    public void addADish(String customerName, String dish) {
        this.dish = new Dish(dish,10);
        orderController.addDish(order, this.dish);
        System.out.println(order.getPriceOrder());
    }

    @Then("the order price will increase by {string} ‘s price")
    public void theOrderPriceWillIncreaseBySPrice(String price) {
        assertNotNull(order);

    }

}
