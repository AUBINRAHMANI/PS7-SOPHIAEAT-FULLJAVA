package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Restaurant.Dish;
import fr.unice.polytech.biblio.Restaurant.HourTime;
import fr.unice.polytech.biblio.Restaurant.Restaurant;

import java.util.ArrayList;

public class Buffet extends SimpleOrder{

    private HourTime hourTime;
    public Buffet(int id, Customer customer, Restaurant restaurant, ArrayList<Dish> dishes) {
        super(id, customer, restaurant, dishes);
        hourTime = null;
        this.isBuffet = true;
    }

    public Buffet(int id, Customer customer, Restaurant restaurant) {
        super(id,customer,restaurant);
        hourTime = null;
        this.isBuffet = true;
    }

    public void setHourTime(HourTime hourTime){
        this.hourTime=hourTime;
    }

    public HourTime getHourTime(){
        return this.hourTime;
    }

}
