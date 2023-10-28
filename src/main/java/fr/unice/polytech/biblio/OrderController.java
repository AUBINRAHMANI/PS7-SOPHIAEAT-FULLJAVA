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

    public boolean notify(Restaurant restaurant){
        if(this.getOrder().getOrderState().equals(OrderState.PAID))
        {
        restaurant.prepareOrder(this.getOrder());
        return true;
        }

        else return false;

    }

  /* public void orderPayable(Order order){
        if(order.getOrderState().equals(OrderState.VALIDATED))
            this.payementSystem.setPayementState(PayementState.UNLOCK);
        else System.out.println("Please Validate your Order before");
    }
*/
    public void validateOrder(Order order){
       if(order.getDishes()!=null){
        order.setOrderState(OrderState.VALIDATED);
        System.out.println(2);
        System.out.println(this.payementSystem.getPayementState());
        this.payementSystem.setPayementState(PayementState.UNLOCK);
        System.out.println(this.payementSystem.getPayementState());
       }
       else System.out.println("The order is empty please");
    }



    public Order getOrder() {
        return this.order;
    }

    public PayementSystem getPayementSystem(){
        return this.payementSystem;
    }
    public Order getCurrentOrder() {
        return this.order;
    }

    public boolean containsDish(Dish dish) {
        if (this.order != null) {
            return this.order.containsDish(dish);
        } else {
            System.out.println("No order created yet. Please create an order first.");
            return false;
        }
    }

    public void pay(Order order, int prix){
        if(payementSystem.getPayementState().equals(PayementState.UNLOCK)){
           if(order.pay(prix))
            validatePayement();
           else payementSystem.setPayementState(PayementState.UNVALID);;
        }
        System.out.println(order.getOrderState());
        System.out.println(payementSystem.getPayementState());
        if(payementSystem.isValid()) order.setOrderState(OrderState.PAID);
    }

    public void validatePayement(){
        payementSystem.setPayementState(PayementState.VALID);

    }
}
