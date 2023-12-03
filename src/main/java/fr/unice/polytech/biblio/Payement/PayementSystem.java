package fr.unice.polytech.biblio.Payement;

public class PayementSystem {

    private int id;
    private PayementState payementState;

    public PayementSystem(int id){
        this.payementState= PayementState.LOCK;
        this.id=id;
    }

    public PayementState getPayementState(){
        return this.payementState;
    }

    public void setPayementState(PayementState payementState){
        this.payementState=payementState;
    }

    public boolean isValid(){
        return (this.getPayementState().equals(PayementState.VALID));
    }

}
