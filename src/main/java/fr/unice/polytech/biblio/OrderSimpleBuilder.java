package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Restaurant.Dish;
import fr.unice.polytech.biblio.Restaurant.Restaurant;

import java.util.ArrayList;

public class OrderSimpleBuilder {
    private int orderId;
    private Customer customer;
    private Restaurant restaurant;
    private ArrayList<Dish> dishes;

    public OrderSimpleBuilder(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.dishes = new ArrayList<>();
    }

    public OrderSimpleBuilder setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    public OrderSimpleBuilder addDish(Dish dish) {
        this.dishes.add(dish);
        return this;
    }

    public SimpleOrder build() {
        return new SimpleOrder(orderId, customer, restaurant, dishes);
    }

}
