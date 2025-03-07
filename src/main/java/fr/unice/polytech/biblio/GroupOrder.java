package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Customer;

import java.util.ArrayList;

public class GroupOrder extends AbstractOrder {

    private ArrayList<AbstractOrder> orders;

    public GroupOrder(int id, Customer customer, ArrayList<AbstractOrder> orders){
        super(id,customer);
        this.orders = orders;

    }

    public GroupOrder(int id, Customer customer,AbstractOrder abstractOrder){
        super(id,customer);
        this.orders = new ArrayList<AbstractOrder>();
        orders.add(abstractOrder);
    }

    public void addOrder(AbstractOrder order){
        if(order.getId()==this.getId()){
            throw new RuntimeException("Impossible de mettre deux fois une meme commande");
        }
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
