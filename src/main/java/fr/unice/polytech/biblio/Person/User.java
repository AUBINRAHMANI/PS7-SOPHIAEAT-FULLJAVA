package fr.unice.polytech.biblio.Person;

public class User {
    public int id;
    public String name;
    public String surname;

    public User(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

//    public User(String name, String surname) {
//        this.name = name;
//        this.surname = surname;
//    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


    public String toString() {
        return "User [id=" + id + ", name=" + name + ", surname=" + surname + "]";
    }
}
