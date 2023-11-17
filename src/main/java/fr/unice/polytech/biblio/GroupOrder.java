package fr.unice.polytech.biblio;

import java.util.ArrayList;

public class GroupOrder extends AbstractOrder {

    private ArrayList<AbstractOrder> orders;

    public GroupOrder(int id, Customer customer, OrderState orderState, ArrayList<AbstractOrder> orders){
        super(id,customer,orderState);
        this.orders = orders;

    }

    public GroupOrder(int id, Customer customer, OrderState orderState){
        super(id,customer,orderState);
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
