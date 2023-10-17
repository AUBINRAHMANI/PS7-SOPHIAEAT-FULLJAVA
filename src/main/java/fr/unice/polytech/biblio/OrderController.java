package fr.unice.polytech.biblio;

import java.util.ArrayList;

public class OrderController {
    private Order order;

    public OrderController() {
        this.order = null;
    }

    public void createOrder(int id, Customer customer, Restaurant restaurant, ArrayList<Dish> dishes) {
        this.order = new Order(id, customer, restaurant, dishes);
    }


    public void addDish(Dish dish) {
        if (this.order != null) {
            this.order.addDish(dish);
        } else {
            System.out.println("No order created yet. Please create an order first.");
        }
    }

    public void chooseRestaurant(Restaurant restaurant) {
        if (this.order != null) {
            this.order.setRestaurant(restaurant);
        } else {
            System.out.println("No order created yet. Please create an order first.");
        }
    }


    public Order getOrder() {
        return this.order;
    }
}
