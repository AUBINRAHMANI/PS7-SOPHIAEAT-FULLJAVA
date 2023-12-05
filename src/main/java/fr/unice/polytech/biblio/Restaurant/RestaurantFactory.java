package fr.unice.polytech.biblio.Restaurant;

import java.util.HashMap;
import java.util.Map;

public class RestaurantFactory {

    Restaurants restaurants;
    private Map<String, Restaurant> restaurantBuilders;

    public RestaurantFactory(){
        restaurants = new Restaurants();
        restaurantBuilders = new HashMap<>();
        restaurantBuilders.put(restaurants.kebabDelice().getName(),restaurants.kebabDelice());
        restaurantBuilders.put(restaurants.leChinoisDeNice().getName(),restaurants.leChinoisDeNice());
        restaurantBuilders.put(restaurants.saladParties().getName(),restaurants.saladParties());
    }

    public Restaurant createRestaurant(String nameRestaurant){
        Restaurant restaurantChosen = restaurantBuilders.get(nameRestaurant);
        if(restaurantChosen!=null){
            return restaurantChosen;
        }
        else {
            throw new IllegalArgumentException("Nom de restaurant non valide : " + nameRestaurant);
        }
    }
}
