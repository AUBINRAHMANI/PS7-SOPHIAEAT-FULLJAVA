package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Customer;

import java.util.ArrayList;

public class OrderGroupController {

   public AbstractOrder order;

   private GroupOrder groupOrder;

   public ArrayList<GroupOrder> groupOrders;


    public OrderGroupController(){
        this.groupOrders = new ArrayList<GroupOrder>();
    }


    public GroupOrder getGroupOrderByid(int id){
        GroupOrder currentGroupOrder = null;
        for(GroupOrder groupOrder1 : groupOrders ){
            if(groupOrder1.getId()==id){
                currentGroupOrder=groupOrder1;
            }
        }
        return currentGroupOrder;
    }


    public void addOrder(GroupOrder groupOrder,AbstractOrder order){
       groupOrder.addOrder(order);
    }

    public void createGroupedOrder(int id, Customer customer, AbstractOrder order) {
        groupOrder = new GroupOrder(id,customer,order);
        groupOrders.add(groupOrder);
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
