package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Restaurant.Dish;
import fr.unice.polytech.biblio.Restaurant.HourTime;
import fr.unice.polytech.biblio.Restaurant.Schedules;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MyStepdefs_ChooseDish {

    SimpleOrderBuilder simpleOrderBuilder;
    Restaurant restaurant;
    Customer customer;
    Dish dish;
    OrderController orderController;
    SimpleOrder order;
    ArrayList<Dish> dishes;
    Schedules openingTime;
    @Given("a customer {string} who has chosen the restaurant {string}")
    public void aCustomerWhoHasChosenTheRestaurant(String customerName, String restaurantName) {
        customer = new Customer(3 ,customerName, "Some Surname");
        simpleOrderBuilder = new SimpleOrderBuilder();
        restaurant = simpleOrderBuilder.createRestaurant(restaurantName);
        simpleOrderBuilder.createOrder(customer,restaurant);

        //Uniquement pour les tests
        order = simpleOrderBuilder.orderController.getOrderById(customer.getId());
    }

    @When("{string} add a dish {string}")
    public void addADish(String customerName, String dish) {
        simpleOrderBuilder.addDish(customer,dish);
        System.out.println(order.getPriceOrder());
    }

    @Then("the order price will increase by {string} ‘s price")
    public void theOrderPriceWillIncreaseBySPrice(String price) {
        assertNotNull(order);

    }

}
