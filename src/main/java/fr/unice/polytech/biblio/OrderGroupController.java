package fr.unice.polytech.biblio;

import java.util.ArrayList;

public class OrderGroupBuilder implements  {

   public AbstractOrder order;

   public ArrayList<AbstractOrder> orders;


    public OrderGroupBuilder(){
        this.orders = new ArrayList<AbstractOrder>();
        this.order=null;
    }


    public void addOrder(AbstractOrder order){
        this.orders.add(order);

    }
}
