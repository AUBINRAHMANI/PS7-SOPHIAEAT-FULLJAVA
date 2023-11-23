package fr.unice.polytech.biblio.Person;

import fr.unice.polytech.biblio.Order;
import fr.unice.polytech.biblio.OrderState;
import fr.unice.polytech.biblio.Person.User;

public class Deliverer extends User {
    public Deliverer(int id, String name, String surname) {
        super(id, name, surname);
    }

//    public Deliverer(String name, String surname) {
//        super(name, surname);
//    }

    public void TakeInChargeAnOrder(Order order){
        if(order.getOrderState().equals(OrderState.READY_TO_DELIVER))
            order.setOrderState(OrderState.IN_PROGRESS_DELIVERY);
    }

    public void DeliverAnOrder(Order order){
        if(order.getOrderState().equals(OrderState.IN_PROGRESS_DELIVERY))
            order.setOrderState(OrderState.DELIVERED);
    }

}
