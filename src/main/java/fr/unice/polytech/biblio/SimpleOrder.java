package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Payement.PayementSystem;
import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Restaurant.Dish;
import fr.unice.polytech.biblio.Restaurant.Restaurant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class SimpleOrder extends AbstractOrder{
    protected Restaurant restaurant;

    protected double priceOrder;

    protected ArrayList<Dish> dishes;

    protected PayementSystem payementSystem;

    protected boolean usedForDiscount;
    protected boolean isBuffet;

    protected int rating;


    public SimpleOrder(int id, Customer customer, Restaurant restaurant, int priceOrder){
        super(id,customer);
        this.restaurant = restaurant;
        this.priceOrder = priceOrder;
        this.dishes = new ArrayList<>();
        this.usedForDiscount = false;
    }

    public SimpleOrder(int id, Customer customer, Restaurant restaurant){
        super(id,customer);
        this.restaurant = restaurant;
        this.priceOrder = 0;
        this.dishes = new ArrayList<>();
        this.usedForDiscount = false;
    }

    public SimpleOrder(int id, Customer customer, Restaurant restaurant,ArrayList<Dish> dishes){
        super(id,customer);
        this.restaurant = restaurant;
        this.priceOrder = 0;
        this.dishes=dishes;
        this.usedForDiscount = false;
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

    public void addDish(Dish dish, int number){
        for(int i=0; i<number;i++){
            dishes.add(dish);
            this.priceOrder += dish.getPrice();
        }
    }

    public ArrayList<Dish> getDishes(){
        return this.dishes;
    }

    public double getPriceOrder(){
        return this.priceOrder;
    }

    public void setOrderState(OrderState orderState){
        this.orderState=orderState;
    }

    public void setPayementSystem(PayementSystem payementSystem){
        this.payementSystem = payementSystem;

    }

    public PayementSystem getPayementSystem(){
        return this.payementSystem;
    }

    public boolean pay(double prix){
        return getPriceOrder() == prix;

    }

    public boolean isUsedForDiscount() {
        return usedForDiscount;
    }

    public void setUsedForDiscount(boolean usedForDiscount) {
        this.usedForDiscount = usedForDiscount;
    }

    public boolean getBuffetState(){
        return this.isBuffet;
    }

    public void setRating(int rating){
        if (rating > 5 || rating < 0) {
            throw new IllegalArgumentException("Rating must be between 0 and 5");
        }
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}
