package fr.unice.polytech.biblio;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class MyStepdefs_validOrder {
    Customer customer;

    Restaurant restaurant;

    Order order;

    Dish dish;

  //  ArrayList<Dish> dishes = new ArrayList<>();

    OrderController orderController;

    //PayementSystem payementSystem;


    @Given("a customer {string} {string} who has already chosen the restaurant {string} and with a filled order")
    public void aCustomerWhohasAlreadyChosenTheRestaurant(String customerName,String customerSurname, String restaurantName) {
        customer = new Customer(customerName, customerSurname);
        restaurant = new Restaurant(restaurantName);
        //order = new Order(1, customer, restaurant, dishes);
        //payementSystem = new PayementSystem(1);
        orderController = new OrderController();
        orderController.createOrder(1,customer,restaurant);
        order=orderController.getOrder();
        orderController.chooseRestaurant(restaurant);
    }

    @When("{string} decides to validate order")
    public void aCustomerValidateOrder(String customerName) {
        dish = new Dish("hamburger", 10);
        orderController.addDish(dish);
       // System.out.println(order.getPriceOrder());
        orderController.validateOrder(order);
       // System.out.println("1");
       // System.out.println(this.payementSystem.getPayementState());

    }

    @Then("The order is confirmed, and {string} can pay his order")
    public void orderIsConfirmedAndWeCanPayTheOrder(String customerName){
        PayementSystem payementSystem = orderController.getPayementSystem();

        assertEquals(order.getOrderState(),OrderState.VALIDATED);
        assertEquals(PayementState.UNLOCK, payementSystem.getPayementState());

        orderController.pay(order,10);
        System.out.println(1);
        assertEquals(OrderState.PAID,order.getOrderState());
        }


}
