package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Restaurant.Restaurant.RestaurantBuilder;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import fr.unice.polytech.biblio.Person.Customer;
public class SimpleOrderBuilder extends OrderBuilder{

    OrderController orderController;

    int id = 0;
    public SimpleOrderBuilder(){
        super();
        OrderController orderController = new OrderController();
    }

    public void createOrder(Customer customer, Restaurant restaurant){
        orderController.createOrder(this.id,customer,restaurant);
        id++;
    }

    public void createOrder(SimpleOrder order) {
        OrderController orderController = new OrderController(order);
    }

    public void createRestaurant(String name, String adress){
        Restaurant restaurant = new Restaurant.RestaurantBuilder(name,adress).build();
    }


}
