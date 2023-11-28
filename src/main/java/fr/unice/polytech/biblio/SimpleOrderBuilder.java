package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Restaurant.RestaurantBuilder;

public class SimpleOrderBuilder extends OrderBuilder{

    public SimpleOrderBuilder(){
        super();
    }
    public void createOrder(SimpleOrder order) {
        OrderController orderController = new OrderController(order);
    }

    public void addRestaurant(String name, String adress){
        RestaurantBuilder restaurantBuilder = new RestaurantBuilder(name,adress);
    }


}
