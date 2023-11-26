package fr.unice.polytech.biblio.Person;

import fr.unice.polytech.biblio.Restaurant.Schedules;
import fr.unice.polytech.biblio.Restaurant.Restaurant;

public class RestaurantManager extends Customer {

    private Restaurant restaurant;
    public RestaurantManager(int id, String name, String surname, Restaurant restaurant) {
        super(id, name, surname);
        this.restaurant = restaurant;
    }

//    public RestaurantManager(String name, String surname) {
//        super(name, surname);
//        this.restaurant = restaurant;
//    }

    public void setOpeningTime(Restaurant restaurant, Schedules openingTime){
        restaurant.setSchedules(openingTime);
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
    public void setRestaurant(Restaurant restaurant){
        this.restaurant = restaurant;
    }
}
