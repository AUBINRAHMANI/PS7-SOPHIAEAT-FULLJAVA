package fr.unice.polytech.biblio;

public class Cook extends User{

    private Restaurant restaurant;
    public Cook(int id, String name, String surname, Restaurant restaurant) {
        super(id, name, surname);
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant(){
        return this.restaurant;
    }

    public void prepareOrder(Order order){
        if(order.getOrderState().equals(OrderState.READY_TO_COOK))
            order.setOrderState(OrderState.IN_PROGRESS);
    }

    public void completeOrder(Order order){
        if(order.getOrderState().equals(OrderState.IN_PROGRESS)){
            order.setOrderState(OrderState.READY_TO_DELIVER);
        }
    }
}
