package fr.unice.polytech.biblio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DishTest {
    private Dish dish;

    @BeforeEach
    void setUp() {
        dish = new Dish(1, "Pasta",  10.0f);
    }

    @Test
    void getId() {
        assertEquals(1, dish.getId());
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
        assertEquals("Dish [id=1, name=Pasta, price=10.0]", dish.toString());
    }

    @Test
    void notEqualsTest() {
        Dish anotherDish = new Dish(2, "Salad",  8.0f);
        assertNotEquals(anotherDish, dish);
    }



}