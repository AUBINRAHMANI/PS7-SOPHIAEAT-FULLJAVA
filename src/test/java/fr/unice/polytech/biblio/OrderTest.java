package fr.unice.polytech.biblio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class OrderTest {
    private Order order;
    private Customer customer;
    private Restaurant restaurant;
    private ArrayList<Dish> dishes;

    @BeforeEach
    void setUp() {
        customer = new Customer(1,"John", "Doe");
        dishes = new ArrayList<>();
        dishes.add(new Dish("Hamburger", 10));

        restaurant = new Restaurant("McDonalds","123 Main St" , dishes);

        order = new Order(1, customer, restaurant, dishes);
    }

    @Test
    void getId() {
        assertEquals(1, order.getId());
    }

    @Test
    void getCustomer() {
        assertEquals(customer, order.getCustomer());
    }

    @Test
    void getRestaurant() {
        assertEquals(restaurant, order.getRestaurant());
    }

    @Test
    void getDishes() {
        assertEquals(dishes, order.getDishes());
    }

    @Test
    void getOrderState() {assertEquals(OrderState.PENDING, order.getOrderState());}

    @Test
    void addDish() {
        Dish newDish = new Dish( "Fries", 5);
        order.addDish(newDish);
        assertTrue(order.getDishes().contains(newDish));
    }

    @Test
    void setRestaurant() {
        Restaurant newRestaurant = new Restaurant("Burger King","456 Main St" , dishes);
        order.setRestaurant(newRestaurant);
        assertEquals(newRestaurant, order.getRestaurant());
    }


}