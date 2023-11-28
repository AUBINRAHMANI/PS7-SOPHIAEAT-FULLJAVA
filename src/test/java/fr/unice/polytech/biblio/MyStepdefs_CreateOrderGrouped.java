package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Restaurant.Dish;
import fr.unice.polytech.biblio.Restaurant.HourTime;
import fr.unice.polytech.biblio.Restaurant.Schedules;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;



public class MyStepdefs_CreateOrderGrouped {

    Customer customerAlice;

    Restaurant restaurant;

    Dish dishHamburger;

    Dish dishPizza;

    OrderController orderController;

    OrderGroupBuilder orderGroupBuilder;

    SimpleOrder order;

    Schedules openingTime;

    HourTime opening;

    HourTime closing;

    ArrayList<Dish> menu;

    ArrayList<Dish> orderlist;









    @Given("a connected user {string}")
    public void aConnectedUser(String customerName) {
        customerAlice = new Customer(1, customerName, "huzog");


    }

    @When("{string} create an order grouped with that dishes {string} and {string}")
    public void createAnOrderGroupedWithThatDishesAnd(String customerName, String hamburger, String pizza) {

        dishHamburger = new Dish(hamburger,15);
        dishPizza = new Dish(pizza,13);

        opening = new HourTime(18,30);
        closing = new HourTime(1,0);
        openingTime = new Schedules(opening,closing);

        menu = new ArrayList<Dish>();
        menu.add(dishHamburger);
        menu.add(dishPizza);

        restaurant = new Restaurant("kebabiste","13 rue des kebabs Nice",menu,openingTime);

        orderController = new OrderController();
        orderGroupBuilder = new OrderGroupBuilder(  1, customerAlice);

//        orderController.chooseRestaurant(restaurant);
//
//        orderController.createOrder(1,customerAlice,restaurant);
//        orderController.createOrder(2,customerAlice,restaurant); // mettre bob, modifier la classe pour que ca soit une liste d'order pour retrouver (exemple avec les id)
//        orderController.addDish(dishHamburger);
//        orderController.addDish(dishPizza); //non c'est deux orders












    }


    @And("Alice invite other users {string} and {string}")
    public void aliceInviteOtherUsersAnd(String arg0, String arg1) {
    }


    @Then("the order grouped is created")
    public void theOrderGroupedIsCreated() {
    }
}
