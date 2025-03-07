package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Restaurant.Dish;
import fr.unice.polytech.biblio.Restaurant.HourTime;
import fr.unice.polytech.biblio.Restaurant.Schedules;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderControllerTest {

    private OrderController orderController;
    private Customer customer;
    private Restaurant restaurant;

    private Restaurant newRestaurant;


    private ArrayList<Dish> dishes;
    private SimpleOrder order;


    @BeforeEach
    void setUp() {
        customer = new Customer(1, "John", "Doe");
        dishes = new ArrayList<>();


        dishes.add(new Dish("Hamburger", 10));

        HourTime openingHour = new HourTime(10,0);
        HourTime closingHour = new HourTime(22,0);
        Schedules openingTime = new Schedules(openingHour, closingHour);
        restaurant = new Restaurant("McDonalds", "123 Main St",dishes, openingTime);
        newRestaurant = new Restaurant("Burger King", "456 Elm St", dishes, openingTime);

        order = new SimpleOrder(1, customer, restaurant, dishes);

        orderController = new OrderController();

        orderController.createOrder(order.getId(), order.getCustomer(), order.getRestaurant(), order.getDishes());
    }

    @Test
    void createOrder() {
        assertNotNull(order);
    }

//    @Test
//    void addDish() {
//        Dish newDish = new Dish( "Fries", 5);
//        orderController.addDish(order, newDish);
//
//
//
//        assertTrue(((orderController.getOrderById(1))).getDishes().contains(newDish));
//        assertEquals((orderController.getOrderById(1)).getDishes(), dishes);
//        // System.out.println((orderController.getOrder()).getDishes());
//    }
//
//
//    @Test
//    void chooseRestaurant() {
//        orderController.chooseRestaurant(order, newRestaurant);
//        assertEquals(newRestaurant, orderController.getOrderById(1).getRestaurant());
//
//    }


}