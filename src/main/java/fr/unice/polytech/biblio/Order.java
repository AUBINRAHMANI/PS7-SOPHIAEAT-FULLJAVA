package fr.unice.polytech.biblio;

import java.util.ArrayList;

public class Order {
    private int id;
    private Customer customer;
    private Restaurant restaurant;
    private ArrayList<Dish> dishes;
    private OrderState orderState;
    private float priceOrder;
    private PayementSystem payementSystem;

    public PayementSystem getPayementSystem() {
        return payementSystem;
    }

    public void setPayementSystem(PayementSystem payementSystem) {
        this.payementSystem = payementSystem;
    }

    public Order(int id, Customer customer, Restaurant restaurant, ArrayList<Dish> dishes) {
        this.id = id;
        this.customer = customer;
        this.restaurant = restaurant;
        this.dishes = dishes;
        this.orderState = OrderState.PENDING;
        this.priceOrder = 0;
    }

    public Order(int id, Customer customer, Restaurant restaurant) {
        this.id = id;
        this.customer = customer;
        this.restaurant = restaurant;
        this.dishes = new ArrayList<Dish>();
        this.orderState = OrderState.PENDING;
        this.priceOrder = 0;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public Restaurant getRestaurant() {
        return this.restaurant;
    }

    public ArrayList<Dish> getDishes() {
        return this.dishes;
    }

    public OrderState getOrderState() {return this.orderState; }

    public void setOrderState(OrderState orderState) {this.orderState = orderState;}


    public void addDish(Dish dish) {
        if(this.dishes==null) this.priceOrder=0;
        else {
            this.dishes.add(dish);
            this.priceOrder += dish.getPrice();
        }
    }

    public float getPriceOrder() {
        return this.priceOrder;
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

    public boolean pay(int prix){
        return getPriceOrder() == prix;

    }

}
