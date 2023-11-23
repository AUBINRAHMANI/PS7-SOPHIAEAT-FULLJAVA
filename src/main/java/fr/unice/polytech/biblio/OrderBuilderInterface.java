package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Restaurant.Dish;

import java.util.List;

public interface OrderBuilderInterface {

   public void pay();

   public void addItem(List<Dish> dishList);





}
