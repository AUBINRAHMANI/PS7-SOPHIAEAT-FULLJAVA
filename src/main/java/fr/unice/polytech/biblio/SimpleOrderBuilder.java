package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Restaurant.*;
import fr.unice.polytech.biblio.Restaurant.Restaurant.RestaurantBuilder;
import fr.unice.polytech.biblio.Person.Customer;

import java.util.ArrayList;

public class SimpleOrderBuilder extends OrderBuilder{

    OrderController orderController;

    int id = 0;
    public SimpleOrderBuilder(){
        super();
        OrderController orderController = new OrderController();
    }

    public void createOrder(Customer customer, Restaurant restaurant){
        orderController.createOrder(customer.getId(), customer,restaurant);

    }

    public void addDish(Customer customer, Dish dish){
        SimpleOrder currentOrder = orderController.getOrderById(customer.getId());
        orderController.addDish(currentOrder,dish);
        System.out.println(dish + "a bien été ajouté à votre panier !");
    }

    public void addDishes(Customer customer, ArrayList<Dish> dishes){
        SimpleOrder currentOrder = orderController.getOrderById(customer.getId());
        orderController.addDishes(currentOrder,dishes);
        System.out.println(dishes.toString() + " ont bien été ajouté au panier !");
    }

    public void validOrder(Customer customer, HourTime curentime){
        SimpleOrder currentOrder = orderController.getOrderById(customer.getId());
        orderController.validateOrder(currentOrder,curentime);
        System.out.println("Vous avez validé votre panier");
    }
    public void payOrder(Customer customer, int prix){
        SimpleOrder currentOrder = orderController.getOrderById(customer.getId());
        orderController.pay(currentOrder,prix);
    }

  //  public void createOrder(SimpleOrder order) {
        //OrderController orderController = new OrderController(order);}

    public void chooseRestaurant(Customer customer, String restaurant){
        RestaurantFactory restaurantFactory= new RestaurantFactory();
        Restaurant restaurantChosen = restaurantFactory.createRestaurant(restaurant);
        orderController.chooseRestaurant(orderController.getOrderById(customer.getId()),restaurantChosen);


    }


}
