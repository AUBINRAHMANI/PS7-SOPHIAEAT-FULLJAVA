package fr.unice.polytech.biblio.Person;

import fr.unice.polytech.biblio.Restaurant.HourTime;
import fr.unice.polytech.biblio.Restaurant.Schedules;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantManagerTest {

    private Restaurant restaurant;
    private RestaurantManager restaurantManager;

    @BeforeEach
    public void setUp() {
        restaurant = new Restaurant("McDonalds", "123 Main St", new Schedules(new HourTime(10,00), new HourTime(22,00)));
        restaurantManager = new RestaurantManager(1, "John", "Doe", restaurant);
    }

    @Test
    public void testSetOpeningTime() {
        Schedules schedules = new Schedules(new HourTime(10,00), new HourTime(22,00));
        restaurantManager.setOpeningTime(restaurant, schedules);
        assertEquals(schedules, restaurant.getSchedules());
    }

    @Test
    public void testGetRestaurant() {
        Restaurant retrievedRestaurant = restaurantManager.getRestaurant();
        assertEquals(restaurant, retrievedRestaurant);
    }


}