package fr.unice.polytech.biblio.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Restaurants {

    Restaurant restaurant;
    private Dish kebab = new Dish("kebab",10);
    private Dish pizza = new Dish("pizza",12);
    private Dish hamburgerDelice = new Dish("hamburgerDelice",15);
    private  Dish niceCola = new Dish("niceCola",3);
    private Dish fries = new Dish("fries", 5);
    private Dish tiramisuDelice = new Dish("tiramisuDelice",6);

    private Dish saladeChevre = new Dish("saladChevre",15);
    private Dish royalSalad = new Dish("royalSalad",25);

    private Dish ceasarSalad= new Dish("ceasarSalad",20);

    private Dish eucalyptusBioBeverage = new Dish("eucalyptusBio", 9);

    private Dish sushiPlate = new Dish("sushi",30);

    private Dish maki = new Dish("maki",25);

    private Dish rolls = new Dish("rolls",20);

    private Dish crevette = new Dish("crevette",15);

    private Dish soju = new Dish("soju",10);

    Restaurants restaurants(){
        return null;
    }

   public Restaurant kebabDelice(){
        String kebabDelice = "KebabDelice";
        String adress = "101 rue du Kebab";
        HourTime opening = new HourTime(12,0);
        HourTime closing = new HourTime(23,30);
        Schedules schedules = new Schedules(opening,closing);
        ArrayList<Dish> menuKebabDelice = new ArrayList<>(List.of(kebab, pizza, hamburgerDelice,niceCola,fries,tiramisuDelice));

        Restaurant restaurant = new Restaurant.RestaurantBuilder(kebabDelice,adress)
                .openingTime(schedules)
                .dishes(menuKebabDelice)
                .build();

        return restaurant;

    }


   public Restaurant saladParties() {
       String saladParties = "saladParties";
       String adress = "102 rue de la vache";
       HourTime opening = new HourTime(8, 0);
       HourTime closing = new HourTime(21, 30);
       Schedules schedules = new Schedules(opening, closing);
       ArrayList<Dish> menuSaladParties = new ArrayList<>(List.of(ceasarSalad, saladeChevre, royalSalad, eucalyptusBioBeverage));

       Restaurant restaurant = new Restaurant.RestaurantBuilder(saladParties, adress)
               .openingTime(schedules)
               .dishes(menuSaladParties)
               .build();

       return restaurant;

   }

    public Restaurant leChinoisDeNice() {
        String chinois = "Le chinois de Nice";
        String adress = "555 rue du chien cuit";
        HourTime opening = new HourTime(11, 0);
        HourTime closing = new HourTime(00, 30);
        Schedules schedules = new Schedules(opening, closing);
        ArrayList<Dish> menuChinois = new ArrayList<>(List.of(sushiPlate, maki, rolls,crevette,soju));

        Restaurant restaurant = new Restaurant.RestaurantBuilder(chinois, adress)
                .openingTime(schedules)
                .dishes(menuChinois)
                .build();

        return restaurant;

    }
}
