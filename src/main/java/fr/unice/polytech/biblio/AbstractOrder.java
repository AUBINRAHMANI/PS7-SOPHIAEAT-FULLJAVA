package fr.unice.polytech.biblio;

public abstract class AbstractOrder {

    protected int id;

    protected Customer customer;
    protected OrderState orderState;

    public AbstractOrder(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
       this.orderState= OrderState.PENDING;
    }

    public abstract int getId();

    public abstract Customer getCustomer();

    public abstract OrderState getOrderState();
}
