package fr.unice.polytech.biblio;

public class OrderGroupBuilder {

   public AbstractOrder order;


    public OrderGroupBuilder(){
        this.order=null;
    }


    public void addOrder(AbstractOrder order){
        this.order=order;
    }
}
