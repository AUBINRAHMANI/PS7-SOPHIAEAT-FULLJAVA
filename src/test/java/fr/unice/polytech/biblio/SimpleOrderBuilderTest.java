package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Restaurant.Dish;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleOrderBuilderTest {

    private SimpleOrderBuilder simpleOrderBuilder;
    private Customer customer;
    private Restaurant restaurant;

    @BeforeEach
    public void setUp() {
        simpleOrderBuilder = new SimpleOrderBuilder();
        customer = new Customer(1, "Doe", "john@example.com");
        restaurant = new Restaurant.RestaurantBuilder("RestaurantName", "RestaurantAddress").build();
    }

    @Test
    public void testCreateOrder() {
    }

    @Test
    public void testCreateRestaurant() {
        simpleOrderBuilder.createRestaurant("AnotherRestaurant", "AnotherAddress");

    }


}