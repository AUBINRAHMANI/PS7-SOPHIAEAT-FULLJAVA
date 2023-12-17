package fr.unice.polytech.biblio.Person;

public class Collective extends User{

    private int numberPerson;
    public Collective(int id, String name, String surname, int numberPerson) {
        super(id, name, surname);
        this.numberPerson = numberPerson;
    }

    public int getNumberPerson(){
        return this.numberPerson;
    }

    public int getId() {
        return super.getId();
    }

}
