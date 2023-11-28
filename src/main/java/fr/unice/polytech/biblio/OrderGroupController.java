package fr.unice.polytech.biblio;

import java.util.ArrayList;

public class OrderGroupController {

   public AbstractOrder order;

   public ArrayList<AbstractOrder> orders;


    public OrderGroupController(){
        this.orders = new ArrayList<AbstractOrder>();
        this.order=null;
    }

    public OrderGroupController(GroupOrder order){
        this.orders = new ArrayList<>();
        this.orders.add(order);
    }


    public void addOrder(AbstractOrder order){
        this.orders.add(order);

    }

}
