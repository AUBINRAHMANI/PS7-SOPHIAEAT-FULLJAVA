package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Restaurant.Dish;
import fr.unice.polytech.biblio.Restaurant.HourTime;
import fr.unice.polytech.biblio.Restaurant.OpeningTime;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.asm.Advice;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyStepdefs_Discount {

    Restaurant restaurant;
    Customer customer;
    OrderController orderController;
    ArrayList<Dish> dishes;
    LocalDate pastDate;

    @Given("a connected user {string} who already ordered {int} times at the restaurant {string}")
    public void aConnectedUserWhoAlreadyOrderedTimesAtTheRestaurant(String customerName, int numberOfOrders, String restaurantName) {
        orderController = new OrderController();
        customer = new Customer(1,customerName, "Hadock");
        Dish burger = new Dish("Burger", 10);
        Dish pizza = new Dish("Pizza", 12);
        Dish iceCream = new Dish("Ice Cream", 7);
        dishes = new ArrayList<>();
        dishes.add(burger);
        dishes.add(pizza);
        dishes.add(iceCream);
        OpeningTime openingTime = new OpeningTime(new HourTime(10,0), new HourTime(18,0));
        restaurant = new Restaurant(restaurantName, "5 rue du Coulon", dishes, openingTime);
        for(int i = 0; i < 9; i++) {
            orderController.createOrder(i, customer, restaurant, new ArrayList<>(List.of(dishes.get(i % 3))));
        }
        orderController.getOrders().forEach(o -> o.setOrderState(OrderState.DELIVERED));
        assertEquals(numberOfOrders, orderController.getOrders().size());
    }

    @When("the user complete a new order")
    public void theUserCompleteANewOrder() {
        orderController.createOrder(100, customer, restaurant, new ArrayList<>(List.of(dishes.get(0))));
        SimpleOrder order = orderController.getOrderById(100);
        orderController.validateOrder(order, new HourTime(14,0));
        order.setOrderState(OrderState.DELIVERED);
        orderController.pay(order,10);
    }

    @Then("he get a {double} discount")
    public void heGetADiscount(double discount) {
        assertEquals(0.95, customer.getPriceRate(),0.01);
    }

    @Given("a connected user {string} who got a discount {int} months ago")
    public void aConnectedUserWhoGotADiscountDaysAgo(String customerName, int numberOfMonths) {
        orderController = new OrderController();
        customer = new Customer(1,customerName, "Hadock");
        customer.setPriceRate(0.95);
        Dish burger = new Dish("Burger", 10);
        Dish pizza = new Dish("Pizza", 12);
        Dish iceCream = new Dish("Ice Cream", 7);
        dishes = new ArrayList<>();
        dishes.add(burger);
        dishes.add(pizza);
        dishes.add(iceCream);
        OpeningTime openingTime = new OpeningTime(new HourTime(10,0), new HourTime(18,0));
        restaurant = new Restaurant("McDonalds", "1 impasse de la Roya", dishes, openingTime);

        LocalDate date = LocalDate.now();
        if(date.getMonthValue() == numberOfMonths) {
            pastDate = LocalDate.of(date.getYear() - numberOfMonths,date.getMonthValue() + 11, date.getDayOfMonth());
        }
        else {
            pastDate = LocalDate.of(date.getYear(),date.getMonthValue() - 1, date.getDayOfMonth());
        }
        customer.setLastDiscount(pastDate);
    }

    @Then("he lose his discount")
    public void heLoseHisDiscount() {
        assertEquals(1, customer.getPriceRate(), 0.01);
    }

    @Given("a connected user {string} who got a discount {int} days ago and ordered {int} times in the mean time")
    public void aConnectedUserWhoGotADiscountDaysAgoAndOrderedTimesInTheMeanTime(String customerName, int numberOfDays, int numberOfOrders) {
        orderController = new OrderController();
        customer = new Customer(1,customerName, "Hadock");
        customer.setPriceRate(0.95);
        Dish burger = new Dish("Burger", 10);
        Dish pizza = new Dish("Pizza", 12);
        Dish iceCream = new Dish("Ice Cream", 7);
        dishes = new ArrayList<>();
        dishes.add(burger);
        dishes.add(pizza);
        dishes.add(iceCream);
        OpeningTime openingTime = new OpeningTime(new HourTime(10,0), new HourTime(18,0));
        restaurant = new Restaurant("McDonalds", "1 impasse de la Roya", dishes, openingTime);

        for(int i = 0; i < 9; i++) {
            orderController.createOrder(i, customer, restaurant, new ArrayList<>(List.of(dishes.get(i % 3))));
        }
        orderController.getOrders().forEach(o -> o.setOrderState(OrderState.DELIVERED));
        assertEquals(numberOfOrders, orderController.getOrders().size());

        LocalDate date = LocalDate.now();
        if(date.getMonthValue() < 11) {
            pastDate = LocalDate.of(date.getYear(),date.getMonthValue() - 1, date.getDayOfMonth() + 30);
        }
        else {
            pastDate = LocalDate.of(date.getYear(),date.getMonthValue(), date.getDayOfMonth() - numberOfDays);
        }
        customer.setLastDiscount(pastDate);
    }

    @Then("the discount is prolongated")
    public void theDiscountIsProlongated() {
        System.out.println(orderController.ordersForDiscount(customer, LocalDate.now()).size());
        assertTrue(customer.getLastDiscount().isAfter(pastDate));
    }
}
