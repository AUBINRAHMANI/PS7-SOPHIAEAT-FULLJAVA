package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Payement.PayementState;
import fr.unice.polytech.biblio.Payement.PayementSystem;
import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Restaurant.Dish;
import fr.unice.polytech.biblio.Restaurant.HourTime;
import fr.unice.polytech.biblio.Restaurant.Schedules;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class MyStepdefs_payOrder {

    SimpleOrder order;
    SimpleOrderBuilder simpleOrderBuilder;
    Customer customer;
    Dish dish ;
    Restaurant restaurant;
    Dish pizza;
    //ArrayList<Dish> dishes;
    Schedules openingTime;


    @Given("a customer {string} who has an order with one dish {string} in the restaurant {string}")
    public void customerWhoHasOrdered(String customerName, String dishName, String nameRestaurant){
        customer = new Customer(5,customerName,"huzog");
        simpleOrderBuilder = new SimpleOrderBuilder();
        restaurant = simpleOrderBuilder.createRestaurant(nameRestaurant);
        simpleOrderBuilder.createOrder(customer,restaurant);
        simpleOrderBuilder.addDish(customer,dishName);
        order=simpleOrderBuilder.orderController.getOrderById(customer.getId());



    }

    @When("{string} pays the order")
    public void customerPaysTheOrder(String customerName){
        HourTime currentTime = new HourTime(15,45);
        simpleOrderBuilder.validOrder(customer,currentTime);
        assertEquals(order.getOrderState(),OrderState.VALIDATED);
        simpleOrderBuilder.payOrder(customer,10);

    }

    @Given("the order is paid, the payement is valid and the restaurant is notified of the order for preparation")
    public void orderValidated(){
        PayementSystem payementSystem = order.getPayementSystem();
        assertEquals(payementSystem.getPayementState(), PayementState.VALID);
        assertEquals(order.getOrderState(),OrderState.READY_TO_COOK);
    }


}
