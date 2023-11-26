package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.RestaurantManager;
import fr.unice.polytech.biblio.Restaurant.HourTime;
import fr.unice.polytech.biblio.Restaurant.Schedules;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class MyStepdefs_ChangeRestaurantHours {
    RestaurantManager restaurantManager;
    Restaurant restaurant;
    @Given("a manager {string} of the restaurant {string}")
    public void aManagerOfTheRestaurant(String managerName, String restaurantName) {
        Schedules openingTime = new Schedules(new HourTime(11,0), new HourTime(17,0));
        restaurant = new Restaurant(restaurantName, "1 rue du maire", openingTime);
        restaurantManager = new RestaurantManager(1,managerName,"Dupont",restaurant);
    }

    @When("the manager decides to change the hours to {int}:{int} - {int}:{int}")
    public void decidesToChangeTheHoursTo(int openingHour, int openingMinute, int closingHour, int closingMinute) {
        Schedules newOpeningTime = new Schedules(new HourTime(openingHour,openingMinute), new HourTime(closingHour,closingMinute));
        restaurantManager.setOpeningTime(restaurant, newOpeningTime);
    }

    @Then("the restaurant hours are changed")
    public void theRestaurantHoursAreChanged() {
        assertEquals(restaurant.getSchedules().getOpeningHour().getHour(),10);
        assertEquals(restaurant.getSchedules().getOpeningHour().getMinute(),30);
        assertEquals(restaurant.getSchedules().getClosingHour().getHour(),18);
        assertEquals(restaurant.getSchedules().getClosingHour().getMinute(),45);
    }
}
