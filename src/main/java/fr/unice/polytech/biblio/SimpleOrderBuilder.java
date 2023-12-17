package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Collective;
import fr.unice.polytech.biblio.Restaurant.*;
import fr.unice.polytech.biblio.Restaurant.Restaurant.RestaurantBuilder;
import fr.unice.polytech.biblio.Person.Customer;

import java.util.ArrayList;

public class SimpleOrderBuilder extends OrderBuilder{

    OrderController orderController;

    int id = 0;
    public SimpleOrderBuilder(){
        super();
        this.orderController = new OrderController();
    }

    public void createOrder(Customer customer, Restaurant restaurant){
        this.orderController.createOrder(customer.getId(), customer,restaurant);

    }

    public void createBuffetOrder(Customer customer, Collective collective, Restaurant restaurant)
    {
        this.orderController.createBuffet(customer.getId(),customer, collective,restaurant);
    }



    public void addDish(Customer customer, String nameDish,int number) {
        Dish emptyDish = null;
        Restaurant currentRestaurant = this.orderController.getRestaurant(orderController.getOrderById(customer.getId()));
        SimpleOrder order = this.orderController.getOrderById(customer.getId());
        ArrayList<Dish> menu = currentRestaurant.getDishes();
        for (Dish dish : menu) {
            if (dish.getName().equals(nameDish)) {
                this.orderController.addDish(order, dish, number);
                emptyDish = dish;
                break;
            }
        }
        if (emptyDish == null) System.out.println("Ce restaurant ne contient pas ce plat !");
    }
    public boolean addDish(Customer customer, Dish dish){
        boolean emptyDish = false;
        Restaurant currentRestaurant = this.orderController.getRestaurant(orderController.getOrderById(customer.getId()));
        SimpleOrder order = this.orderController.getOrderById(customer.getId());
        ArrayList<Dish> menu = currentRestaurant.getDishes();
        for(Dish aDish :menu){
            if(aDish.equals(dish)){
                this.orderController.addDish(order,aDish);
                emptyDish = true;
                break;
            }
        }
        if (!emptyDish) System.out.println("Ce restaurant ne contient pas ce plat !");
        else System.out.println(dish + "a bien été ajouté à votre panier !");
        return emptyDish;
    }

    public void addDish(Customer customer, String nameDish){
        Dish emptyDish = null;
        Restaurant currentRestaurant = this.orderController.getRestaurant(orderController.getOrderById(customer.getId()));
        SimpleOrder order = this.orderController.getOrderById(customer.getId());
        ArrayList<Dish> menu = currentRestaurant.getDishes();
        for(Dish dish :menu){
            if(dish.getName().equals(nameDish)){
                this.orderController.addDish(order,dish);
                emptyDish = dish;
                break;
            }
        }
        if (emptyDish == null) System.out.println("Ce restaurant ne contient pas ce plat !");
    }

    public void validOrder(Customer customer, HourTime curentime){
        SimpleOrder currentOrder = orderController.getOrderById(customer.getId());
        orderController.validateOrder(currentOrder,curentime);
        System.out.println("Vous avez validé votre panier");
    }

    public void cancelOrder(Customer customer){
        SimpleOrder order = orderController.getOrderById(customer.getId());
        orderController.cancelOrder(order);
    }
    public void payOrder(Customer customer, int prix){
        SimpleOrder currentOrder = orderController.getOrderById(customer.getId());
        orderController.pay(currentOrder,prix);
        orderController.notify(currentOrder,currentOrder.getRestaurant());
    }

  //  public void createOrder(SimpleOrder order) {
        //OrderController orderController = new OrderController(order);}
    public Restaurant createRestaurant(String restaurantName){
        RestaurantFactory restaurantFactory= new RestaurantFactory();
        return restaurantFactory.createRestaurant(restaurantName);
    }

    public void chooseHourtime(Buffet buffet,HourTime hourTime){
        buffet.setHourTime(hourTime);
    }




}
