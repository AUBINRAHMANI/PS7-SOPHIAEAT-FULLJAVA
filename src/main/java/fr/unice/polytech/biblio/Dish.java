package fr.unice.polytech.biblio;

public class Dish {
    public int id;
    public String name;
    public float price;

    public Dish(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public float getPrice() {
        return price;
    }


    public String toString() {
        return "Dish [id=" + id + ", name=" + name + ", price=" + price + "]";
    }
}
