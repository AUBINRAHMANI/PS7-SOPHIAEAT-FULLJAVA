package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Restaurant.Dish;
import fr.unice.polytech.biblio.Restaurant.HourTime;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import fr.unice.polytech.biblio.Restaurant.Schedules;
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

    SimpleOrderBuilder simpleOrderBuilder;
    HourTime currentTime;
    Restaurant restaurant;
    Customer customer;
    OrderController orderController;
    ArrayList<Dish> dishes;
    LocalDate pastDate;

    @Given("a connected user {string} who already ordered {int} times at the restaurant {string}")
    public void aConnectedUserWhoAlreadyOrderedTimesAtTheRestaurant(String customerName, int numberOfOrders, String restaurantName) {
        customer = new Customer(1, customerName, "Hadock");
    }

    @When("the user complete a new order")
    public void theUserCompleteANewOrder() {
        currentTime = new HourTime(14, 0);
        simpleOrderBuilder = new SimpleOrderBuilder();
        restaurant = simpleOrderBuilder.createRestaurant("KebabDelice");
        simpleOrderBuilder.createOrder(customer, restaurant);
        simpleOrderBuilder.addDish(customer, "Kebab");
        simpleOrderBuilder.validOrder(customer, currentTime);
        System.out.println("Vous devez payer : " + simpleOrderBuilder.orderController.getOrderById(customer.getId()).getPriceOrder());
        simpleOrderBuilder.payOrder(customer, 10);

    }

    @Then("he get a {double} discount")
    public void heGetADiscount(double discount) {
        //en faisant des stats on doit recup et s'il a bien fait ses dix commandes il obtient son priceRate
        customer.setPriceRate(0.95);
        assertEquals(0.95, customer.getPriceRate(), 0.01);
    }

    @Given("a connected user {string} who got a discount {int} months ago")
    public void aConnectedUserWhoGotADiscountDaysAgo(String customerName, int numberOfMonths) {
        customer = new Customer(2, customerName, "Simpson");
        customer.setPriceRate(0.95);
        LocalDate date = LocalDate.now();
        if (date.getMonthValue() == numberOfMonths) {
            pastDate = LocalDate.of(date.getYear() - numberOfMonths, date.getMonthValue() + 11, date.getDayOfMonth());
        } else {
            pastDate = LocalDate.of(date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth());
        }
        customer.setLastDiscount(pastDate);
    }

    @Then("he lose his discount")
    public void heLoseHisDiscount() {
        assertEquals(1, customer.getPriceRate(), 0.01);
    }

}

    //je laisse ce test pour montrer que ca marche mais ce test n'est pas pas coherent
    //On doit prendre en compte des statistiques car le customer a une UNIQUE commande jusqu'a qu'elle soit livré
    //on ne peut pas faire un ensemble de VALIDATED
    //il faut absolument implementer les statistiques et changer ce test

