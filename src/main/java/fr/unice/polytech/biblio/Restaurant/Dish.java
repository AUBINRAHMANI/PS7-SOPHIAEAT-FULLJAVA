package fr.unice.polytech.biblio.Restaurant;

import static java.lang.Math.round;

public class Dish {

    public String name;
    public float price;

    public Dish( String name, float price) {
        this.name = name;
        this.price = price;
    }



    public String getName() {
        return name;
    }


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public String toString() {
        return "Dish [ name=" + name + ", price=" + price + "]";
    }

    @Override
    public boolean equals(Object obj) {
        Dish dish = (Dish)obj;
        System.out.println(this.price + " _ " + dish.getPrice() + " _ " + (this.price - dish.getPrice()));
        return this.name == dish.getName() && (int)((this.price - dish.getPrice())*10) == 0;
    }
}
