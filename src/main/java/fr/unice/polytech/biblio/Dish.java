package fr.unice.polytech.biblio;

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


    public String toString() {
        return "Dish [ name=" + name + ", price=" + price + "]";
    }
}
