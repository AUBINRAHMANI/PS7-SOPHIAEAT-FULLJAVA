package fr.unice.polytech.biblio;

import java.util.ArrayList;

public class SimpleOrder extends AbstractOrder{
    private Restaurant restaurant;

    private float priceOrder;

    private ArrayList<Dish> dishes;

    public SimpleOrder(int id, Customer customer,OrderState orderState, Restaurant restaurant, int priceOrder){
        super(id,customer,orderState);
        this.restaurant = restaurant;
        this.priceOrder = priceOrder;

    }

    public SimpleOrder(int id, Customer customer,OrderState orderState, Restaurant restaurant){
        super(id,customer,orderState);
        this.restaurant = restaurant;
        this.priceOrder = 0;
    }
    @Override
    public int getId() {
        return id;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public OrderState getOrderState() {
        return orderState;
    }

    public Restaurant getRestaurant(){
        return restaurant;
    }
    public void setRestaurant(Restaurant restaurant){
        this.restaurant = restaurant;
    }
    public void addDish(Dish dish){
        this.dishes.add(dish);
        this.priceOrder += dish.getPrice();
    }

    public ArrayList<Dish> getDishes(){
        return this.dishes;
    }

    public float getPriceOrder(){
        return this.priceOrder;
    }



}
