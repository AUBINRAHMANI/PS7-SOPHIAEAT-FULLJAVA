package fr.unice.polytech.biblio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleOrderBuilderTest {

    SimpleOrderBuilder simpleOrderBuilder;

    Customer customer;

    Dish dishPizza;

    Dish dishHamburger;

    @Test
    void createOrder() {
        simpleOrderBuilder = new SimpleOrderBuilder();

    }

    @Test
    void addRestaurant() {
    }
}