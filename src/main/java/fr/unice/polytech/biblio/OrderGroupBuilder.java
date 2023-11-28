package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Customer;

import java.util.ArrayList;

public class OrderGroupBuilder {

   public AbstractOrder order;
    private int orderId;
    private Customer customer;
    private ArrayList<AbstractOrder> orders;


    public OrderGroupBuilder(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.orders = new ArrayList<>();
    }

    public OrderGroupBuilder addOrder(AbstractOrder order) {
        this.orders.add(order);
        return this;
    }

    public GroupOrder build() {
        return new GroupOrder(orderId, customer, orders);
    }

}
