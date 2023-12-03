package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Payement.PayementState;
import fr.unice.polytech.biblio.Payement.PayementSystem;
import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Restaurant.Dish;
import fr.unice.polytech.biblio.Restaurant.HourTime;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import net.bytebuddy.asm.Advice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class OrderController {
    //private SimpleOrder order;

    private ArrayList<SimpleOrder> orders;

    private PayementSystem payementSystem;


    public OrderController() {
        this.orders = new ArrayList<>();

    }

    public OrderController(SimpleOrder order){
        this.orders = new ArrayList<SimpleOrder>();
        this.orders.add(order);
    }

    public void createOrder(int id, Customer customer, Restaurant restaurant, ArrayList<Dish> dishes) {

        SimpleOrder order = new SimpleOrder(id, customer, restaurant, dishes);
        PayementSystem payementSystem = new PayementSystem(id);
        order.setPayementSystem(payementSystem);
        orders.add(order);

    }

    public void createOrder(int id, Customer customer, Restaurant restaurant) {
        SimpleOrder order = new SimpleOrder(id, customer, restaurant);
        PayementSystem payementSystem = new PayementSystem(id);
        order.setPayementSystem(payementSystem);
        orders.add(order);
    }
    public void addDish(SimpleOrder order, Dish dish) {

        if (order != null) {
            order.addDish(dish);
        } else {
            System.out.println("No order created yet. Please create an order first.");
        }
    }

    public void chooseRestaurant(SimpleOrder order, Restaurant restaurant) {
        if (order != null) {
            order.setRestaurant(restaurant);
        } else {
            System.out.println("No order created yet. Please create an order first.");
        }
    }

    public SimpleOrder getOrderById(int id) {
        for(SimpleOrder order : orders) {
            if(order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    public List<SimpleOrder> getOrdersByCustomer(Customer customer) {
        List<SimpleOrder> customerOrders = new ArrayList<>();
        for(SimpleOrder order : orders) {
            if(order.getCustomer() == customer) {
                customerOrders.add(order);
            }
        }
        return customerOrders;
    }

    //enlever le boolean après
    public boolean notify(SimpleOrder order, Restaurant restaurant){
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
    public void validateOrder(SimpleOrder order, HourTime currentTime){
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

    public PayementSystem getPayementSystem() {
        return this.payementSystem;
    }

    public ArrayList<SimpleOrder> getOrders() {
        return this.orders;

    }

    public void pay(SimpleOrder order, double prix){
        Restaurant restaurant = order.getRestaurant();
        checkDiscount(order.getCustomer());
        prix = prix * order.customer.getPriceRate();
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

    public void validatePayement(SimpleOrder order){
        order.getPayementSystem().setPayementState(PayementState.VALID);
    }

    public void cancelOrder(SimpleOrder order) {
        order.setOrderState(OrderState.CANCELLED);
        order.getPayementSystem().setPayementState(PayementState.LOCK);
    }

    public List<SimpleOrder> ordersForDiscount(Customer customer, LocalDate currentDate) {
        List<SimpleOrder> validOrders = new ArrayList<>();
        List<SimpleOrder> orders = getOrdersByCustomer(customer);
        for(SimpleOrder order : orders) {
            if(!order.isUsedForDiscount() && order.getOrderState()==OrderState.DELIVERED) {
                validOrders.add(order);
            }
        }
        return validOrders;
    }

    public void checkDiscount(Customer customer) {
        LocalDate currentDate = LocalDate.now();
        if(!customer.validForDiscount(currentDate)) {
            customer.setPriceRate(1);
        }

        List<SimpleOrder> validOrders = ordersForDiscount(customer, currentDate);
        if(validOrders.size() >= 10) {
            customer.setPriceRate(0.95);
            customer.setLastDiscount(LocalDate.now());
            validOrders.forEach(vo -> vo.setUsedForDiscount(true));
        }
    }

}
