package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Payement.PayementState;
import fr.unice.polytech.biblio.Payement.PayementSystem;
import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Restaurant.Dish;
import fr.unice.polytech.biblio.Restaurant.HourTime;
import fr.unice.polytech.biblio.Restaurant.Schedules;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class MyStepdefs_validOrder {
    Customer customer;

    SimpleOrderBuilder orderBuilder;

    Restaurant restaurant;

    SimpleOrder order;

    @Given("a customer {string} {string} who has already chosen the restaurant {string} and with a filled order")
    public void aCustomerWhohasAlreadyChosenTheRestaurant(String customerName,String customerSurname, String restaurantName) {
        customer = new Customer(4, customerName, customerSurname);
        orderBuilder = new SimpleOrderBuilder();
        restaurant = orderBuilder.createRestaurant(restaurantName);
        orderBuilder.createOrder(customer, restaurant);
        order = orderBuilder.orderController.getOrderById(customer.getId()); // present uniquement pour les tests
    }

    @When("{string} decides to validate order")
    public void aCustomerValidateOrder(String customerName) {
        orderBuilder.addDish(customer,"royalSalad");
       // System.out.println(order.getPriceOrder());
        HourTime currentTime = new HourTime(17,15);
        orderBuilder.validOrder(customer,currentTime);
       // System.out.println("1");
       // System.out.println(this.payementSystem.getPayementState());

    }

    @Then("The order is confirmed, and {string} can pay his order")
    public void orderIsConfirmedAndWeCanPayTheOrder(String customerName){
        PayementSystem payementSystem = order.getPayementSystem();

        // On test si l'order est bien validates
        assertEquals(order.getOrderState(),OrderState.VALIDATED);
        assertEquals(PayementState.UNLOCK, payementSystem.getPayementState());

        orderBuilder.payOrder(customer,25);

        System.out.println(1);
        assertEquals(OrderState.READY_TO_COOK,order.getOrderState());
        }


}
