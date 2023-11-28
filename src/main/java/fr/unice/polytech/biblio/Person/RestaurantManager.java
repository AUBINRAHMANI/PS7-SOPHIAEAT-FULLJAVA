package fr.unice.polytech.biblio.Person;


import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Restaurant.Dish;
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


    public void setOpeningTime(Schedules openingTime) {
        this.restaurant.setSchedules(openingTime);
    }

    public void addDishToMenu(Dish dish) {
        this.restaurant.addDish(dish);
    }

    public void removeDishOfMenu(Dish dish) {
        restaurant.removeDish(dish);
    }

    public void changePrice(Dish dish, float newPrice) {
        for (Dish searchDish : this.restaurant.getDishes()) {
            if (searchDish.name.equals(dish.name)) {
                searchDish.setPrice(newPrice);
            }
        }
    }


    public void setOpeningTime (Restaurant restaurant, Schedules openingTime){
            restaurant.setSchedules(openingTime);
    }


    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }


}