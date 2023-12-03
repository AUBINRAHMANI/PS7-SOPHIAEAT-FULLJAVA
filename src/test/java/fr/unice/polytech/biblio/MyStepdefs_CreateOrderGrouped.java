package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Payement.PayementSystem;
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

import static org.junit.Assert.assertNotNull;


public class MyStepdefs_CreateOrderGrouped {

    Customer customerAlice;

    Restaurant restaurant;

    Dish dishHamburger;

    Dish dishPizza;

    OrderController orderController;

    OrderGroupController orderGroupController;

    SimpleOrder order;

    Schedules openingTime;

    HourTime opening;

    HourTime closing;

    ArrayList<Dish> menu;

    ArrayList<Dish> orderlist;

    SimpleOrder orderAlice;

    SimpleOrder orderBob;

    OrderGroupBuilder orderGroupBuilder;




    @Given("a connected user {string}")
    public void aConnectedUser(String customerName) {
        customerAlice = new Customer(1, customerName, "Alice");

    }

    @When("{string} create an order simple with that dishes: {string}")
    public void createAnOrderGroupedWithThatDishesAnd(String customerName, String hamburger) {

        dishHamburger = new Dish(hamburger,15);
//        dishPizza = new Dish(pizza,13);

        opening = new HourTime(18,30);
        closing = new HourTime(1,0);
        openingTime = new Schedules(opening,closing);

        menu = new ArrayList<Dish>();
        menu.add(dishHamburger);
//        menu.add(dishPizza);

        restaurant = new Restaurant("kebabiste","13 rue des kebabs Nice",menu,openingTime);

        orderController = new OrderController();

        orderGroupController = new OrderGroupController();

        orderController.createOrder(1,customerAlice,restaurant);
        orderAlice = orderController.getOrderById(1);
        orderController.chooseRestaurant(orderAlice,restaurant);
        orderController.addDish(orderAlice,dishHamburger);

//      orderGroupBuilder = new OrderGroupBuilder(  1, customerAlice);

//        orderController.chooseRestaurant(restaurant);
//
//        orderController.createOrder(1,customerAlice,restaurant);
//        orderController.createOrder(2,customerAlice,restaurant); // mettre bob, modifier la classe pour que ca soit une liste d'order pour retrouver (exemple avec les id)
//        orderController.addDish(dishHamburger);
//        orderController.addDish(dishPizza); //non c'est deux orders


       // orderController.createOrder(2,customerAlice,restaurant); // mettre bob, modifier la classe pour que ca soit une liste d'order pour retrouver (exemple avec les id)// orderBob = orderController.getOrderById(2);
      //orderController.addDish(orderBob,dishPizza);
    }

    @And("{string} create another order simple for user {string} with that dishes : {string}")
    public void createAnotherOrderSimpleForUserWithThatDishes(String customer, String customerBob, String pizza) {


        orderGroupBuilder = new OrderGroupBuilder(  1, customerAlice);
        orderGroupBuilder.addOrder(orderAlice);
        orderGroupBuilder.addOrder(orderBob);

        orderGroupBuilder.build();

    }

    @Then("the order grouped is created")
    public void theOrderGroupedIsCreated() {
        //assertNotNull(orderGroupBuilder.getOrderGrouped());
    }


}
