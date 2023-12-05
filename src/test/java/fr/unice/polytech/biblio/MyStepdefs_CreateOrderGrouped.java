package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Restaurant.Dish;
import fr.unice.polytech.biblio.Restaurant.HourTime;
import fr.unice.polytech.biblio.Restaurant.Schedules;
import fr.unice.polytech.biblio.Restaurant.Restaurant;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class MyStepdefs_CreateOrderGrouped {

    SimpleOrderBuilder simpleOrderBuilder;

    Customer customerAlice;

    Customer customerBob;

    Restaurant restaurant;

    SimpleOrder orderAlice;

    SimpleOrder orderBob;

    OrderGroupBuilder orderGroupBuilder;

    GroupOrder groupOrdersAlice;



    @Given("a connected user {string}")
    public void aConnectedUser(String customerName) {
        customerAlice = new Customer(1, customerName, "Alice");

    }

    @When("{string} create an order simple with that dishes: {string}")

    public void createAnOrderGroupedWithThatDishesAnd(String customerName, String kebab) {
        simpleOrderBuilder = new SimpleOrderBuilder();
        restaurant = simpleOrderBuilder.createRestaurant("KebabDelice");
        simpleOrderBuilder.createOrder(customerAlice,restaurant);
        simpleOrderBuilder.addDish(customerAlice,kebab);

        orderAlice = simpleOrderBuilder.orderController.getOrderById(customerAlice.getId());
//        orderController.createOrder(1,customerAlice,restaurant);
//        orderController.createOrder(2,customerAlice,restaurant); // mettre bob, modifier la classe pour que ca soit une liste d'order pour retrouver (exemple avec les id)
//        orderController.addDish(dishHamburger);
//        orderController.addDish(dishPizza); //non c'est deux orders

       // orderController.createOrder(2,customerAlice,restaurant); // mettre bob, modifier la classe pour que ca soit une liste d'order pour retrouver (exemple avec les id)// orderBob = orderController.getOrderById(2);
      //orderController.addDish(orderBob,dishPizza);
    }

    @And("{string} create another order simple for user {string} with that dishes : {string}")
    public void createAnotherOrderSimpleForUserWithThatDishes(String nameAlice, String nameBob, String fries) {
        customerBob = new Customer(2, nameBob, "huzog");
        orderGroupBuilder = new OrderGroupBuilder();

        orderGroupBuilder.createGroupOrder(customerAlice,orderAlice);
        simpleOrderBuilder.createOrder(customerBob,restaurant);
        orderBob = simpleOrderBuilder.orderController.getOrderById(customerBob.getId());
        simpleOrderBuilder.addDish(customerBob,fries);
        orderGroupBuilder.addOrder(customerAlice,orderBob);


        groupOrdersAlice = orderGroupBuilder.getOrderGroupController().getGroupOrderByid(customerAlice.getId());


    }

    @Then("the order grouped is created")
    public void theOrderGroupedIsCreated() {
        System.out.println(groupOrdersAlice.getOrders().toString());
        assertEquals(2,groupOrdersAlice.getOrders().size());
        //orderGroupBuilder.addOrder(customerAlice,orderAlice); Enlever les // pour montrer qu'on ne peut pas mettre deux fois une meme commande
        assertNotNull(groupOrdersAlice);
    }


}
