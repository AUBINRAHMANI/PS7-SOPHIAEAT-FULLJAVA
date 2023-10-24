package fr.unice.polytech.biblio;

public class Customer extends User{
    public Customer(int id, String name, String surname) {
        super(id, name, surname);
    }

    public Customer(String name, String surname) {
        super(name, surname);
    }


    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", surname=" + surname + "]";
    }

}
