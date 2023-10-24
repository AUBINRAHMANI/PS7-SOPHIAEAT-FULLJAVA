package fr.unice.polytech.biblio;

import java.util.ArrayList;

public class Order {
    private int id;
    private Customer customer;
    private Restaurant restaurant;
    private ArrayList<Dish> dishes;
    private OrderState orderState;

    public Order(int id, Customer customer, Restaurant restaurant, ArrayList<Dish> dishes) {
        this.id = id;
        this.customer = customer;
        this.restaurant = restaurant;
        this.dishes = dishes;
        this.orderState = OrderState.PENDING;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public OrderState getOrderState() {return orderState; }

    public void setOrderState(OrderState orderState) {this.orderState = orderState;}

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public boolean containsDish(Dish dish) {
        for (Dish d : this.dishes) {
            if (d.getName().equals(dish.getName())) {
                return true;
            }
        }
        return false;
    }

}
