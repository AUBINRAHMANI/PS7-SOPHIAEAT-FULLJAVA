import fr.unice.polytech.biblio.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs_CreateOrderGrouped {

    Customer customerAlice;

    Restaurant restaurant;

    Dish dish;

    OrderController orderController;

    AbstractOrder order;




    @Given("a connected user {string}")
    public void aConnectedUser(String customerName) {
        customerAlice = new Customer(1, customerName, "huzog");


    }

    @When("{string} create an order grouped with that dishes {string} and {string}")
    public void createAnOrderGroupedWithThatDishesAnd(String arg0, String arg1, String arg2) {
        Restaurant restaurant

    }


    @And("Alice invite other users {string} and {string}")
    public void aliceInviteOtherUsersAnd(String arg0, String arg1) {
    }


    @Then("the order grouped is created")
    public void theOrderGroupedIsCreated() {
    }
}
