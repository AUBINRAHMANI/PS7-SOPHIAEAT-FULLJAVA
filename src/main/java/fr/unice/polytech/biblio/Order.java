package fr.unice.polytech.biblio;

import java.util.ArrayList;

public class Order {
    public int id;
    public Customer customer;
    public Restaurant restaurant;
    public ArrayList<Dish> dishes;
    public boolean isPaid;
    public boolean isDelivered;
    public int price;

    public Order(int id, Customer customer, Restaurant restaurant, ArrayList<Dish> dishes) {
        this.id = id;
        this.customer = customer;
        this.restaurant = restaurant;
        this.dishes = dishes;
        this.isPaid = false;
        this.isDelivered = false;
        this.price=0;
    }


    public int getPrice() {
        return price;
    }

    public void addPrice(int price) {
        this.price+= price;
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

    public boolean getIsPaid() {
        return isPaid;
    }

    public boolean getIsDelivered() {
        return isDelivered;
    }



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
