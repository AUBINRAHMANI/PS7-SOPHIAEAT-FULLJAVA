package fr.unice.polytech.biblio.Restaurant;

import fr.unice.polytech.biblio.Restaurant.Dish;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

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
        assertEquals(10.0f, dish.getPrice(), 0.001);
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


    @Test
    void testEquals() {
        Dish sameDish = new Dish("Pasta", 10.0f);
        Dish differentDish = new Dish("Burger", 8.0f);

        assertTrue(dish.equals(sameDish));
        assertFalse(dish.equals(differentDish));
        assertFalse(dish.equals(null));
    }

    @Test
    void testHashCode() {
        Dish sameDish = new Dish("Pasta", 10.0f);
        Dish differentDish = new Dish("Burger", 8.0f);


        assertNotEquals(dish.hashCode(), differentDish.hashCode());
    }

    @Test
    void testEqualsDifferentClass() {
        Object differentObject = new Object();
        assertFalse(dish.equals(differentObject));
    }


}