package fr.unice.polytech.biblio.Person;

import fr.unice.polytech.biblio.Buffet;
import fr.unice.polytech.biblio.Order;
import fr.unice.polytech.biblio.OrderState;
import fr.unice.polytech.biblio.Person.User;
import fr.unice.polytech.biblio.Restaurant.HourTime;
import fr.unice.polytech.biblio.SimpleOrder;

public class Deliverer extends User {
    public Deliverer(int id, String name, String surname) {
        super(id, name, surname);
    }

//    public Deliverer(String name, String surname) {
//        super(name, surname);
//    }

    public void TakeInChargeAnOrder(SimpleOrder order){
        if(order.getOrderState().equals(OrderState.READY_TO_DELIVER) || !order.getBuffetState())
            order.setOrderState(OrderState.IN_PROGRESS_DELIVERY);
    }

    public void DeliverAnOrder(SimpleOrder order){
        if(order.getOrderState().equals(OrderState.IN_PROGRESS_DELIVERY))
            order.setOrderState(OrderState.DELIVERED);
    }

    public void TakeInChargeAbuffet(Buffet buffet, HourTime currentime){
        if((buffet.getHourTime().equals(currentime)) && ((buffet.getOrderState()).equals(OrderState.READY_TO_DELIVER))){
            buffet.setOrderState(OrderState.IN_PROGRESS_DELIVERY);
        }
    }

}
