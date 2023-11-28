package fr.unice.polytech.biblio;

import java.util.List;

public abstract class OrderBuilder {

   public OrderBuilder() {
   }

   public void createOrder(AbstractOrder order) {
      if (order instanceof SimpleOrder) {
         OrderController orderController = new OrderController((SimpleOrder) order);
      }

      else if (order instanceof GroupOrder) {
         OrderGroupController orderGroupController = new OrderGroupController((GroupOrder) order);
      }
   }

}





