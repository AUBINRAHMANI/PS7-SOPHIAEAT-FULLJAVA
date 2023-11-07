package fr.unice.polytech.biblio;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.security.interfaces.DSAKey;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MyStepdefs_payOrder {

    Order order;
    OrderController orderController;
    Customer customer;
    Dish dish ;
    Restaurant restaurant;
    Dish pizza;
    //ArrayList<Dish> dishes;
    OpeningTime openingTime;


    @Given("a customer {string} who has an order with one dish {string} in the restaurant {string}")
    public void customerWhoHasOrdered(String customerName, String dishName, String nameRestaurant){
        customer = new Customer(customerName,"huzog");
        dish = new Dish(dishName,20);
        pizza = new Dish("pizza",30);
        HourTime openingHour = new HourTime(10,0);
        HourTime closingHour = new HourTime(22,0);
        openingTime = new OpeningTime(openingHour, closingHour);
        restaurant = new Restaurant(nameRestaurant, "17 boulevard de l'aiguille", openingTime);
        restaurant.addDish(dish);
        restaurant.addDish(pizza);


        orderController = new OrderController();
        orderController.createOrder(1,customer,restaurant);
        orderController.chooseRestaurant(order, restaurant);
        order = orderController.getOrderById(1);
        orderController.addDish(order, dish);
    }

    @When("{string} pays the order")
    public void customerPaysTheOrder(String customerName){
        HourTime currentTime = new HourTime(15,45);
        orderController.validateOrder(order, currentTime);
        assertEquals(order.getOrderState(),OrderState.VALIDATED);
        orderController.pay(order,20);

    }

    @Given("the order is paid, the payement is valid and the restaurant is notified of the order for preparation")
    public void orderValidated(){
        PayementSystem payementSystem = order.getPayementSystem();
        assertEquals(order.getOrderState(),OrderState.PAID);
        assertEquals(payementSystem.getPayementState(),PayementState.VALID);
        assertTrue( orderController.notify(order, restaurant));
        assertEquals(order.getOrderState(),OrderState.READY_TO_COOK);
    }


}
