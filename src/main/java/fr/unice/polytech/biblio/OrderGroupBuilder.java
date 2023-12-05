package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Customer;

import java.util.ArrayList;

public class OrderGroupBuilder {

   public AbstractOrder order;
   private OrderGroupController orderGroupController;


    public OrderGroupBuilder(){
        this.orderGroupController = new OrderGroupController();

    }

    public void createGroupOrder(Customer customer,AbstractOrder order){
       this.orderGroupController.createGroupedOrder(customer.getId(),customer,order);

    }

    public void addOrder(Customer customer, AbstractOrder order){
        GroupOrder groupOrder = orderGroupController.getGroupOrderByid(customer.getId());
        orderGroupController.addOrder(groupOrder,order);
    }

    public OrderGroupController getOrderGroupController(){
        return this.orderGroupController;
    }


//    public OrderGroupBuilder(){
//        this.order=null;
//    }


//    public void addOrder(AbstractOrder order){
//        this.order=order;
//
//    }

    /*

    public OrderGroupBuilder addOrder(AbstractOrder order) {
        this.orders.add(order);
        return this;
    }

     */

    /*
    public GroupOrder build() {

        return new GroupOrder(orderId, customer, orders);
    }
     */

}
