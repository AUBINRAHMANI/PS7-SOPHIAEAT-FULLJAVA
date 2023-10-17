package fr.unice.polytech.biblio;


import java.util.ArrayList;

public class Restaurant {

    public String name;
    public String address;
    public ArrayList<Dish> dishes;

    public Restaurant( String name, String address, ArrayList<Dish> dishes) {
        this.name = name;
        this.address = address;
        this.dishes = dishes;
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


    public String toString() {
        return "Restaurant [name=" + name + ", address=" + address + ", dishes=" + dishes + "]";
    }
}
