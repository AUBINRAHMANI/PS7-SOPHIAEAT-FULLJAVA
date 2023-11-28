package fr.unice.polytech.biblio;

import java.util.List;

public abstract class OrderBuilder {

   OrderController orderController;

   OrderGroupController orderGroupController;


   public OrderBuilder() {
   }

   public void createOrder(AbstractOrder order) {
      if (order instanceof SimpleOrder) {
         return;
      }

      else if (order instanceof GroupOrder) {
         OrderGroupController orderGroupController = new OrderGroupController((GroupOrder) order);
      }
   }

}





