package fr.unice.polytech.biblio;

import java.util.List;

public abstract class OrderBuilder {

   SimpleOrderBuilder simpleOrderBuilder;

   OrderGroupController orderGroupController;


   public OrderBuilder() {
   }

   public void createOrder(AbstractOrder order) {
      if (order instanceof SimpleOrder) {
         simpleOrderBuilder = new SimpleOrderBuilder();
      }

      else if (order instanceof GroupOrder) {
         orderGroupController = new OrderGroupController();
      }
   }

}





