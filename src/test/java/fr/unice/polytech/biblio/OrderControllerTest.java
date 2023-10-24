package fr.unice.polytech.biblio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderControllerTest {
    private OrderController orderController;
    private Customer customer;
    private Restaurant restaurant;
    private ArrayList<Dish> dishes;
    private Order order;

    @BeforeEach
    void setUp() {
        customer = new Customer(1, "John", "Doe");
        dishes = new ArrayList<>();
        dishes.add(new Dish("Hamburger", 10));

        restaurant = new Restaurant("McDonalds", "123 Main St", dishes);

        order = new Order(1, customer, restaurant, dishes);

        orderController = new OrderController();
        orderController.createOrder(order.getId(), order.getCustomer(), order.getRestaurant(), order.getDishes());
    }

    @Test
    void createOrder() {
        assertNotNull(orderController.getOrder());
    }

  /*  @Test
    void addDish() {
        Dish newDish = new Dish(2, "Fries", 5);
        orderController.addDish(newDish);
        assertTrue(orderController.getOrder().getDishes().contains(newDish));
    }

    @Test
    void chooseRestaurant() {
        Restaurant newRestaurant = new Restaurant("Burger King", "456 Elm St", dishes);
        orderController.chooseRestaurant(newRestaurant);
        assertEquals(newRestaurant, orderController.getOrder().getRestaurant());
    }*/
}