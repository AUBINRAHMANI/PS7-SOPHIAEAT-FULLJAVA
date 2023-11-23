package fr.unice.polytech.biblio.Person;

import fr.unice.polytech.biblio.OrderState;
import fr.unice.polytech.biblio.Person.Cook;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import fr.unice.polytech.biblio.SimpleOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CookTest {
    private Cook cook;
    private Restaurant restaurant;

    @BeforeEach
    public void setUp() {
        // Créer une instance de Cook avec un restaurant pour chaque test
        restaurant = new Restaurant("Nom du restaurant", "Adresse du restaurant", null, null);
        cook = new Cook(1, "Nom du cook", "Prénom du cook", restaurant);
    }

    @Test
    public void testPrepareOrder_OrderReadyToCook_StateChangesToInProgress() {
        // Arrange
        SimpleOrder order = new SimpleOrder(1,new Customer(1, "Nom du client", "Prénom du client"), restaurant);
        order.setOrderState(OrderState.READY_TO_COOK);

        // Act
        cook.prepareOrder(order);

        // Assert
        assertEquals(OrderState.IN_PROGRESS, order.getOrderState());
    }

    @Test
    public void testPrepareOrder_OrderNotReadyToCook_StateStaysSame() {
        // Arrange
        SimpleOrder order = new SimpleOrder(1,new Customer(1, "Nom du client", "Prénom du client"), restaurant);
        order.setOrderState(OrderState.DELIVERED); // Setting a state other than READY_TO_COOK

        // Act
        cook.prepareOrder(order);

        // Assert
        assertNotEquals(OrderState.IN_PROGRESS, order.getOrderState());
        // Ensure the state remains unchanged
        assertEquals(OrderState.DELIVERED, order.getOrderState());
    }

    @Test
    public void testCompleteOrder_OrderInProgress_StateChangesToReadyToDeliver() {
        // Arrange
        SimpleOrder order = new SimpleOrder(1,new Customer(1, "Nom du client", "Prénom du client"), restaurant);
        order.setOrderState(OrderState.IN_PROGRESS);

        // Act
        cook.completeOrder(order);

        // Assert
        assertEquals(OrderState.READY_TO_DELIVER, order.getOrderState());
    }

    @Test
    public void testCompleteOrder_OrderNotInProgress_StateStaysSame() {
        // Arrange
        SimpleOrder order = new SimpleOrder(1,new Customer(1, "Nom du client", "Prénom du client"), restaurant);
        order.setOrderState(OrderState.PAID); // Setting a state other than IN_PROGRESS

        // Act
        cook.completeOrder(order);

        // Assert
        assertNotEquals(OrderState.READY_TO_DELIVER, order.getOrderState());
        // Ensure the state remains unchanged
        assertEquals(OrderState.PAID, order.getOrderState());
    }
}
