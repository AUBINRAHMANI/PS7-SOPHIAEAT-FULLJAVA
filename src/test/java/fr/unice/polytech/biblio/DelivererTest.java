package fr.unice.polytech.biblio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DelivererTest {


    @Test
    void takeInChargeAnOrder() {
        Deliverer deliverer = new Deliverer("Jean", "Dupont");
        Order order = new Order(1, new Customer("Jean", "Dupont"), new Restaurant("McDo", "Nice", null));
        order.setOrderState(OrderState.READY_TO_DELIVER);
        deliverer.TakeInChargeAnOrder(order);
        assertEquals(OrderState.IN_PROGRESS_DELIVERY, order.getOrderState());
    }

}