package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import fr.unice.polytech.biblio.Restaurant.RestaurantFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class StepDef_orderPass {
    Customer customer;
    SimpleOrderBuilder simpleOrderBuilder;

    Restaurant restaurant;

    String menu;

    @Given("a customer {string}")
    public void aCustomer(String customerName) {
        customer = new Customer(1,customerName,"huzog");
    }

    @When("When “Toto” want to see the available menu of the restaurant {string}")
    public void whenTotoWantToSeeTheAvailableMenuOfTheRestaurant(String kebabDelice) {
        simpleOrderBuilder = new SimpleOrderBuilder();
        restaurant = simpleOrderBuilder.createRestaurant(kebabDelice);
        menu = simpleOrderBuilder.showMenu(restaurant);
    }

    @Then("available menus of the restaurant {string} are displayed")
    public void availableMenusOfTheRestaurantAreDisplayed(String kebabDelice) {
        System.out.println(menu);

        //pour verifier si c'est bon
        RestaurantFactory restaurantFactory = new RestaurantFactory();
        Restaurant restaurantReference = restaurantFactory.createRestaurant("KebabDelice");
        assertEquals(menu,"Les menu du restaurant " + kebabDelice + "sont : " + restaurantReference.getDishes().toString());

    }
}
