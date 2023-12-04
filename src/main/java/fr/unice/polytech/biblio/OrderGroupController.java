package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Customer;

import java.util.ArrayList;

public class OrderGroupController {

   public AbstractOrder order;

   private GroupOrder groupOrder;

   public ArrayList<AbstractOrder> orders;


    public OrderGroupController(){
        this.orders = new ArrayList<AbstractOrder>();
    }

    public OrderGroupController(GroupOrder order){
        this.orders = new ArrayList<>();
        this.orders.add(order);
    }


    public void addOrder(AbstractOrder order){
        this.orders.add(order);

    }

    public void createGroupedOrder(int id, Customer customer, AbstractOrder order) {
        groupOrder = new GroupOrder(id,customer,order);
        groupOrder.addOrder(order);
    }

    public ArrayList<AbstractOrder> getOrders(){
        return this.orders;
    }

    /*
    public void createGroupedOrder(int id, Customer customer, ArrayList<AbstractOrder> orders) {
        OrderGroupBuilder builder = new OrderGroupBuilder(id, customer);
        for (AbstractOrder order : orders) {
            builder.addOrder(order);
        }

        GroupOrder groupedOrder = builder.build();
        orders.add(groupedOrder);
    }
    */

}
