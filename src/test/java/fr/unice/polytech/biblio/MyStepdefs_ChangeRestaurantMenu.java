package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.RestaurantManager;
import fr.unice.polytech.biblio.Restaurant.Dish;
import fr.unice.polytech.biblio.Restaurant.HourTime;
import fr.unice.polytech.biblio.Restaurant.Schedules;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class MyStepdefs_ChangeRestaurantMenu {

    RestaurantManager restaurantManager;
    Restaurant restaurant;
    @Given("a restaurant manager {string} of the restaurant {string}")
    public void aManagerOfTheRestaurant(String managerName, String restaurantName) {
        Schedules openingTime = new Schedules(new HourTime(11,0), new HourTime(17,0));
        Dish burger = new Dish("Burger", (float)10.5);
        Dish salad = new Dish("Salad", (float)12);
        ArrayList<Dish> dishes = new ArrayList<>();
        dishes.add(burger);
        dishes.add(salad);
        restaurant = new Restaurant(restaurantName, "1 rue du maire", dishes, openingTime);
        restaurantManager = new RestaurantManager(1,managerName,"Dupont",restaurant);
    }
    @When("the manager decides to add a dish {string} costing {float}")
    public void theManagerDecidesToAddADishCosting(String dishName, float dishPrice) {
        Dish pizza = new Dish(dishName, dishPrice);
        restaurantManager.addDishToMenu(pizza);
    }

    @Then("the restaurant have a new dish")
    public void theRestaurantHaveANewDish() {
        assertEquals(3, restaurantManager.getRestaurant().getDishes().size());
    }

    @When("the manager decides to remove the dish {string} costing {float}")
    public void theManagerDecidesToRemoveTheDishCosting(String dishName, float dishPrice) {
        Dish burger = new Dish(dishName, dishPrice);
        restaurantManager.removeDishOfMenu(burger);
    }

    @Then("the restaurant don't have the dish anymore")
    public void theRestaurantDonTHaveTheDishAnymore() {
        assertEquals(1, restaurantManager.getRestaurant().getDishes().size());
    }

    @When("the manager decides change the price of the dish {string} from {float} to {float}")
    public void theManagerDecidesChangeThePriceOfTheDishFromTo(String dishName, float oldPrice, float newPrice) {
        Dish salad = new Dish(dishName, oldPrice);
        restaurantManager.changePrice(salad, newPrice);
    }

    @Then("the dish {string} price is now {float}")
    public void theDishPriceIsNow(String dishName, float newPrice ) {
        assertEquals(newPrice,restaurantManager.getRestaurant().getDishes().get(1).getPrice(),0.0001);
    }
}
