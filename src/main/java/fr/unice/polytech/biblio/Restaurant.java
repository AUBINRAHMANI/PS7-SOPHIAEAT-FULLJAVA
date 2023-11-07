package fr.unice.polytech.biblio;


import java.util.ArrayList;

public class Restaurant {

    private String name;
    private String address;
    private ArrayList<Dish> dishes;
    private OpeningTime openingTime;

    public OpeningTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(OpeningTime openingTime) {
        this.openingTime = openingTime;
    }

    public Restaurant(String name, String address, ArrayList<Dish> dishes, OpeningTime openingTime) {
        this.name = name;
        this.address = address;
        this.dishes = dishes;
        this.openingTime = openingTime;
    }

    public Restaurant(String name, String address, OpeningTime openingTime) {
        this.name = name;
        this.address = address;
        this.openingTime = openingTime;
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
        return hourTime.compareTo(openingTime.getOpeningHour()) >= 0 && hourTime.compareTo(openingTime.getOpeningHour()) <= 0;
    }

    //a modifier
    public void orderGetReady(Order order){
        order.setOrderState(OrderState.READY_TO_COOK);
    }
}
