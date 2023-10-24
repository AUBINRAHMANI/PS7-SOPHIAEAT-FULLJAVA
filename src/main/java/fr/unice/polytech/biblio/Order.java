package fr.unice.polytech.biblio;

import java.util.ArrayList;

public class Order {
    public int id;
    public Customer customer;
    public Restaurant restaurant;
    public ArrayList<Dish> dishes;
    public OrderState orderState;

    public boolean isValidated;

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

    public boolean orderState(){
        return true;
    }
}
