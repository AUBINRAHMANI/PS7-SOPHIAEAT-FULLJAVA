package fr.unice.polytech.biblio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DishTest {
    private Dish dish;

    @BeforeEach
    void setUp() {
        dish = new Dish("Pasta",  10.0f);
    }



    @Test
    void getName() {
        assertEquals("Pasta", dish.getName());
    }


    @Test
    void getPrice() {
        assertEquals(10.0f, dish.getPrice());
    }

    @Test
    void toStringTest() {
        assertEquals("Dish [ name=Pasta, price=10.0]", dish.toString());
    }

    @Test
    void notEqualsTest() {
        Dish anotherDish = new Dish("Salad",  8.0f);
        assertNotEquals(anotherDish, dish);
    }



}