package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Customer;

import java.util.ArrayList;

public class GroupOrder extends AbstractOrder {

    private ArrayList<AbstractOrder> orders;

    public GroupOrder(int id, Customer customer, ArrayList<AbstractOrder> orders){
        super(id,customer);
        this.orders = orders;

    }

    public GroupOrder(int id, Customer customer){
        super(id,customer);
        this.orders = new ArrayList<AbstractOrder>();
    }

    public void addOrder(AbstractOrder order){
        this.orders.add(order);
    }

    public ArrayList<AbstractOrder> getOrders(){
        return this.orders;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public OrderState getOrderState() {
        return orderState;
    }
}
