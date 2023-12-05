package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Restaurant.HourTime;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import fr.unice.polytech.biblio.Restaurant.Schedules;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GroupOrderTest {


    private GroupOrder groupOrder;
    private Customer customer;

    private Restaurant restaurant;

    @BeforeEach
    void setUp() {
        AbstractOrder order = new SimpleOrder(2, customer,restaurant);
        customer = new Customer(1, "Alice", "Bob");
        groupOrder = new GroupOrder(1, customer,order);
        Schedules schedules = new Schedules(new HourTime(10,00), new HourTime(22,00));
        restaurant = new Restaurant("Kebab", "McDonald's", schedules);
    }

    @Test
    void testAddOrder() {
        AbstractOrder order = new SimpleOrder(2, customer,restaurant);
        groupOrder.addOrder(order);
        assertEquals(2, groupOrder.getOrders().size());
    }

    @Test
    void testGetOrders() {
        AbstractOrder order1 = new SimpleOrder(2, customer,restaurant);
        AbstractOrder order2 = new SimpleOrder(3, customer, restaurant);
        groupOrder.addOrder(order1);
        groupOrder.addOrder(order2);
        ArrayList<AbstractOrder> orders = groupOrder.getOrders();
        assertNotNull(orders);
        assertEquals(3, orders.size());
        assertTrue(orders.contains(order1));
        assertTrue(orders.contains(order2));
    }

    @Test
    void testGetId() {
        assertEquals(1, groupOrder.getId());
    }

    @Test
    void testGetCustomer() {
        assertEquals(customer, groupOrder.getCustomer());
    }


}