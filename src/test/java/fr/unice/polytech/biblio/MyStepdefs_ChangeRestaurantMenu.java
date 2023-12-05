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

    SimpleOrderBuilder simpleOrderBuilder;

    RestaurantManager restaurantManager;
    Restaurant restaurant;
    @Given("a restaurant manager {string} of the restaurant {string}")
    public void aManagerOfTheRestaurant(String managerName, String restaurantName) {
        simpleOrderBuilder = new SimpleOrderBuilder();
        restaurant = simpleOrderBuilder.createRestaurant("KebabDelice");
        restaurantManager = new RestaurantManager(1,managerName,"Dupont",restaurant);
    }
    @When("the manager decides to add a dish {string} costing {float}")
    public void theManagerDecidesToAddADishCosting(String dishName, float dishPrice) {
        Dish tacos = new Dish(dishName, dishPrice);
        restaurantManager.addDishToMenu(tacos);
    }

    @Then("the restaurant have a new dish")
    public void theRestaurantHaveANewDish() {
        assertEquals(7, restaurantManager.getRestaurant().getDishes().size());
    }

    @When("the manager decides to remove the dish {string} costing {float}")
    public void theManagerDecidesToRemoveTheDishCosting(String dishName, float dishPrice) {
        Dish kebab = new Dish(dishName, dishPrice);
        restaurantManager.removeDishOfMenu(kebab);
    }

    @Then("the restaurant don't have the dish anymore")
    public void theRestaurantDonTHaveTheDishAnymore() {
        assertEquals(5, restaurantManager.getRestaurant().getDishes().size());
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
