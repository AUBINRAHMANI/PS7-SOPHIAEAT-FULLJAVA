package fr.unice.polytech.biblio.Person;

import fr.unice.polytech.biblio.OrderState;
import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Person.Deliverer;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import fr.unice.polytech.biblio.SimpleOrder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DelivererTest {

    SimpleOrder order;
    @Test
    void takeInChargeAnOrder() {
        Customer customer = new Customer(2,"Jean", "Dupont");
        Deliverer deliverer = new Deliverer(2,"Jean", "Dupont");
        Restaurant restaurant = new Restaurant("McDo", "Nice", null);
        order = new SimpleOrder(1,customer , restaurant);
        order.setOrderState(OrderState.READY_TO_DELIVER);
        deliverer.TakeInChargeAnOrder(order);
        assertEquals(OrderState.IN_PROGRESS_DELIVERY, order.getOrderState());
    }


    @Test
    void deliveryAnOrder() {
        Deliverer deliverer = new Deliverer(2,"Jean", "Dupont");
        order = new SimpleOrder(1, new Customer(2,"Jean", "Dupont"), new Restaurant("McDo", "Nice", null));
        order.setOrderState(OrderState.IN_PROGRESS_DELIVERY);
        deliverer.DeliverAnOrder(order);
        assertEquals(OrderState.DELIVERED, order.getOrderState());
    }

}