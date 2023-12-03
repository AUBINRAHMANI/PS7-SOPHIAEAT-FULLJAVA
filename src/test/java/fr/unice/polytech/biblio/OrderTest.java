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


class OrderTest {
    private Order order;
    private Customer customer;
    private Restaurant restaurant;
    private ArrayList<Dish> dishes;
    private Schedules openingTime;

    @BeforeEach
    void setUp() {
        customer = new Customer(1,"John", "Doe");
        dishes = new ArrayList<>();
        dishes.add(new Dish("Hamburger", 10));
        HourTime openingHour = new HourTime(10,0);
        HourTime closingHour = new HourTime(22,0);
        openingTime = new Schedules(openingHour, closingHour);
        restaurant = new Restaurant("McDonalds","123 Main St" , dishes, openingTime);

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
        Restaurant newRestaurant = new Restaurant("Burger King","456 Main St" , dishes, openingTime);
        order.setRestaurant(newRestaurant);
        assertEquals(newRestaurant, order.getRestaurant());
    }


}