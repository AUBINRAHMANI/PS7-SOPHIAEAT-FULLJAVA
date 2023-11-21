package fr.unice.polytech.biblio;

public class Admin extends Customer {


    public Admin(int id, String name, String surname) {
        super(id, name, surname);
    }

    public Admin(String name, String surname) {
        super(name, surname);
    }

    public void setOpeningTime(Restaurant restaurant,OpeningTime openingTime){
        restaurant.setOpeningTime(openingTime);
    }

    public void addRestaurant(){

    }

   // public void



}
