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

    public void validateOrder(Order order){
       if(order.getDishes()!=null)
        order.setOrderState(OrderState.VALIDATED);
       else System.out.println("The order is empty please");
    }

    public Order getOrder() {
        return this.order;
    }

    public Object getCurrentOrder() {
        return this.order;
    }

    public boolean containsDish(Dish dish) {
        if (this.order != null) {
            return this.order.containsDish(dish);
        } else {
            System.out.println("No order created yet. Please create an order first.");
            return false;
        }
    }
}
