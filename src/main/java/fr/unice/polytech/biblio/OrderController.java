package fr.unice.polytech.biblio;

import org.mockito.internal.matchers.Or;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class OrderController {
    private ArrayList<Order> orders;

    public OrderController() {
        this.orders = new ArrayList<>();

    }

    public void createOrder(int id, Customer customer, Restaurant restaurant, ArrayList<Dish> dishes) {
        Order order = new Order(id, customer, restaurant, dishes);
        PayementSystem payementSystem = new PayementSystem(id);
        order.setPayementSystem(payementSystem);
        orders.add(order);
    }

    public void createOrder(int id, Customer customer, Restaurant restaurant) {
        Order order = new Order(id, customer, restaurant);
        PayementSystem payementSystem = new PayementSystem(id);
        order.setPayementSystem(payementSystem);
        orders.add(order);
    }


    public void addDish(Order order,Dish dish) {
        if (order != null) {
            order.addDish(dish);
        } else {
            System.out.println("No order created yet. Please create an order first.");
        }
    }

    public void chooseRestaurant(Order order, Restaurant restaurant) {
        if (order != null) {
            order.setRestaurant(restaurant);
        } else {
            System.out.println("No order created yet. Please create an order first.");
        }
    }

    public Order getOrderById(int id) {
        for(Order order : orders) {
            if(order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    public List<Order> getOrdersByCustomer(Customer customer) {
        List<Order> customerOrders = new ArrayList<>();
        for(Order order : orders) {
            if(order.getCustomer() == customer) {
                customerOrders.add(order);
            }
        }
        return customerOrders;
    }

    //enlever le boolean après
    public boolean notify(Order order, Restaurant restaurant){
        if(order.getOrderState().equals(OrderState.PAID))
        {
            restaurant.orderGetReady(order);
            return true; //pour le test cucumber
        }

        else return false;

    }

  /* public void orderPayable(Order order){
        if(order.getOrderState().equals(OrderState.VALIDATED))
            this.payementSystem.setPayementState(PayementState.UNLOCK);
        else System.out.println("Please Validate your Order before");
    }
*/
    public void validateOrder(Order order, HourTime currentTime){
       if(order.getDishes()==null) {
           System.out.println("The order is empty please");
       }
       else {
           if(order.getOrderState()!=OrderState.PENDING) {
               System.out.println("The order can't be validated");
           }
           else {
               if(order.getRestaurant().isTimeValid(currentTime)) {
                   order.setOrderState(OrderState.VALIDATED);
                   System.out.println(2);
                   System.out.println(order.getPayementSystem());
                   order.getPayementSystem().setPayementState(PayementState.UNLOCK);
                   System.out.println(order.getPayementSystem());
               }
               else {
                   System.out.println("You can't order out of the restaurant opening time");
               }
           }
       }
    }

    public ArrayList<Order> getOrders() {
        return this.orders;
    }

    public void pay(Order order, int prix){
        Restaurant restaurant = order.getRestaurant();
        if(order.getPayementSystem().getPayementState().equals(PayementState.UNLOCK)){
           if(order.pay(prix))
            validatePayement(order);
           else order.getPayementSystem().setPayementState(PayementState.UNVALID);;
        }
        System.out.println(order.getOrderState());
        System.out.println(order.getPayementSystem().getPayementState());
        if(order.getPayementSystem().isValid()) {
            order.setOrderState(OrderState.PAID);
            //restaurant.orderGetReady(this.getOrder());

        }

        //this.notify(order.getRestaurant());

    }

    public void validatePayement(Order order){
        order.getPayementSystem().setPayementState(PayementState.VALID);
    }

    public void cancelOrder(Order order) {
        order.setOrderState(OrderState.CANCELLED);
        order.getPayementSystem().setPayementState(PayementState.LOCK);
    }

}
