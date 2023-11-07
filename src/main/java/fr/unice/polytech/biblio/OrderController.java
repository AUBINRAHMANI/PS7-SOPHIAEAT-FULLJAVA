package fr.unice.polytech.biblio;

import org.mockito.internal.matchers.Or;

import java.util.ArrayList;

public class OrderController {
    private Order order;

    private PayementSystem payementSystem;

    public OrderController() {
        this.order = null;

    }

    public void createOrder(int id, Customer customer, Restaurant restaurant, ArrayList<Dish> dishes) {
        this.order = new Order(id, customer, restaurant, dishes);
        payementSystem = new PayementSystem(id);

    }

    public void createOrder(int id, Customer customer, Restaurant restaurant) {
        this.order = new Order(id, customer, restaurant);
        payementSystem = new PayementSystem(id);

    }


    public void addDish(Dish dish) {
        if (this.order != null) {
            this.order.addDish(dish);
        } else {
            System.out.println("No order created yet. Please create an order first.");
        }
    }

    public void chooseRestaurant(Restaurant restaurant) {
        if (this.order != null) {
            this.order.setRestaurant(restaurant);
        } else {
            System.out.println("No order created yet. Please create an order first.");
        }
    }

    //enlever le boolean après
    public boolean notify(Restaurant restaurant){
        if(this.getOrder().getOrderState().equals(OrderState.PAID))
        {
            restaurant.orderGetReady(this.getOrder());
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
               order.setOrderState(OrderState.VALIDATED);
               System.out.println(2);
               System.out.println(this.payementSystem.getPayementState());
               this.payementSystem.setPayementState(PayementState.UNLOCK);
               System.out.println(this.payementSystem.getPayementState());
           }
       }
    }

    public Order getOrder() {
        return this.order;
    }

    public PayementSystem getPayementSystem(){
        return this.payementSystem;
    }

    public void pay(Order order, int prix){
        Restaurant restaurant = order.getRestaurant();
        if(payementSystem.getPayementState().equals(PayementState.UNLOCK)){
           if(order.pay(prix))
            validatePayement();
           else payementSystem.setPayementState(PayementState.UNVALID);;
        }
        System.out.println(order.getOrderState());
        System.out.println(payementSystem.getPayementState());
        if(payementSystem.isValid()) {
            order.setOrderState(OrderState.PAID);
            //restaurant.orderGetReady(this.getOrder());

        }

        //this.notify(order.getRestaurant());

    }

    public void validatePayement(){
        payementSystem.setPayementState(PayementState.VALID);
    }

    public void cancelOrder(Order order) {
        order.setOrderState(OrderState.CANCELLED);
        payementSystem.setPayementState(PayementState.LOCK);
    }

}
