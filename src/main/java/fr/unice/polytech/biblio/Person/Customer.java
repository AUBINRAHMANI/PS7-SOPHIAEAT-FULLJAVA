package fr.unice.polytech.biblio.Person;

import fr.unice.polytech.biblio.Person.User;

import java.time.LocalDate;
import java.util.Date;

public class Customer extends User {

    private double priceRate;
    private LocalDate lastDiscount;
    public double getPriceRate() {
        return priceRate;
    }

    public void setPriceRate(double priceRate) {
        this.priceRate = priceRate;
    }

    public LocalDate getLastDiscount() {
        return lastDiscount;
    }

    public void setLastDiscount(LocalDate lastDiscount) {
        this.lastDiscount = lastDiscount;
    }

    public Customer(int id, String name, String surname) {
        super(id, name, surname);
        this.priceRate = 1.0;
        this.lastDiscount = LocalDate.of(1970,1,1);
    }


    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", surname=" + surname + "]";
    }

    public boolean validForDiscount(LocalDate currentDate) {
        return (lastDiscount.getYear() == currentDate.getYear() && currentDate.getDayOfYear() - lastDiscount.getDayOfYear() < 15) || (lastDiscount.getYear() == currentDate.getYear() - 1 && lastDiscount.getDayOfYear() - currentDate.getDayOfYear() > 350);
    }
}
