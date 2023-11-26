package fr.unice.polytech.biblio.Restaurant;


import fr.unice.polytech.biblio.OrderState;
import fr.unice.polytech.biblio.SimpleOrder;

import java.util.ArrayList;

public class Restaurant {

    private String name;
    private String address;
    private ArrayList<Dish> dishes;
    private Schedules schedules;

    public Schedules getSchedules() {
        return schedules;
    }

    public void setSchedules(Schedules schedules) {
        this.schedules = schedules;
    }

    public Restaurant(String name, String address, ArrayList<Dish> dishes, Schedules schedules) {
        this.name = name;
        this.address = address;
        this.dishes = dishes;
        this.schedules = schedules;
    }

    public Restaurant(String name, String address, Schedules schedules) {
        this.name = name;
        this.address = address;
        this.schedules = schedules;
        this.dishes = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public void addDish(Dish dish){
        dishes.add(dish);
    }


    public String toString() {
        return "Restaurant [name=" + name + ", address=" + address + ", dishes=" + dishes + "]";
    }

    public Dish getDishByName(String someDish) {
        for (Dish dish : this.dishes) {
            if (dish.getName().equals(someDish)) {
                return dish;
            }
        }
        return null;
    }

    public boolean isTimeValid(HourTime hourTime) {
        return hourTime.compareTo(schedules.getOpeningHour()) >= 0 && hourTime.compareTo(schedules.getClosingHour()) <= 0;
    }

    //a modifier
    public void orderGetReady(SimpleOrder order){
        order.setOrderState(OrderState.READY_TO_COOK);
    }
}
