package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Cook;
import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Restaurant.Dish;
import fr.unice.polytech.biblio.Restaurant.HourTime;
import fr.unice.polytech.biblio.Restaurant.OpeningTime;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class MyStepdefs_LauchOrder {

    Customer customer;
    Restaurant restaurant;
    Dish pizza;
   // ArrayList<Dish> dishes;
    OrderController orderController;
    SimpleOrder order;
    Cook cook;
    OpeningTime openingTime;

    @Given("restaurant {string} with a paid order for user {string}")
    public void paidOrderofUser(String restaurantName, String userName){

        Customer customer = new Customer(2,userName,"huzog");
        pizza = new Dish("pizza", 15);
        HourTime openingHour = new HourTime(10,0);
        HourTime closingHour = new HourTime(22,0);
        openingTime = new OpeningTime(openingHour, closingHour);
        restaurant = new Restaurant(restaurantName, "2 impasse de l'etoile", openingTime);
        restaurant.addDish(pizza);
        orderController = new OrderController();
        orderController.createOrder(1,customer,restaurant);
        orderController.chooseRestaurant(order, restaurant);
        order = orderController.getOrderById(1);

        orderController.addDish(order, pizza);
        System.out.println(order.getDishes());
        HourTime currentTime = new HourTime(14,30);
        orderController.validateOrder(order, currentTime);

        orderController.pay(order,15);
        orderController.notify(order, restaurant);
        assertEquals(order.getOrderState(),OrderState.READY_TO_COOK);
    }

    @When("restaurant {string} begins preparing the order for {string}")
    public void prepareTheOrderForCustomer(String restaurantName, String customerName){
        cook = new Cook(1,"Obelix","Potion",restaurant);
        cook.prepareOrder(order);

    }

    @Then("the status of {string}'s order is updated to ''preparation in progress''")
    public void orderUpdated(String customerName){
        assertEquals(order.getOrderState(),OrderState.IN_PROGRESS);
    }
}
