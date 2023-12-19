package fr.unice.polytech.biblio;

import fr.unice.polytech.biblio.Person.Collective;
import fr.unice.polytech.biblio.Person.Cook;
import fr.unice.polytech.biblio.Person.Customer;
import fr.unice.polytech.biblio.Person.Deliverer;
import fr.unice.polytech.biblio.Restaurant.HourTime;
import fr.unice.polytech.biblio.Restaurant.Restaurant;
import fr.unice.polytech.biblio.Restaurant.Schedules;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class StepDef_orderAnBuffet {

    SimpleOrderBuilder simpleOrderBuilder;

    Customer customer;

    Restaurant restaurant;

    Collective collective;

    Buffet buffet;

    Cook cook;

    Deliverer deliverer;

    @Given("the organization {string} orders an buffet for his {int} students at the restaurant {string}")
    public void publicOrderAnBuffetForHisStudents(String polytechname, int numberOfStudents,String restaurantName) {
        simpleOrderBuilder = new SimpleOrderBuilder();
        customer = new Customer(1,polytechname,"nice");
        collective = new Collective(2,"etudiants","SI",numberOfStudents);

        restaurant = simpleOrderBuilder.createRestaurant(restaurantName);
        simpleOrderBuilder.createBuffetOrder(customer,collective,restaurant);
        buffet = (Buffet) simpleOrderBuilder.orderController.getOrderById(customer.getId());




    }

    @When("{int} {string}, {int} {string} and {int} {string} are ordered to {int}:{int} pm")
    public void andAreOrderedToPm(int kebabnumber, String kebab, int pizzaNumber, String pizza, int tiramisunumber, String tiramisu, int arg6, int arg7) {
        HourTime currentime = new HourTime(13, 00);
        simpleOrderBuilder.addDish(customer, kebab, kebabnumber);
        simpleOrderBuilder.addDish(customer, pizza, pizzaNumber);
        simpleOrderBuilder.addDish(customer, tiramisu, tiramisunumber);
        simpleOrderBuilder.validOrder(customer, currentime);
        HourTime to = new HourTime(arg6, arg7);
        simpleOrderBuilder.chooseHourtime(buffet, to);
        System.out.println(buffet.getOrderState());
        System.out.println(buffet.getDishes());
        System.out.println("Vous devez payer : " + buffet.getPriceOrder());
        simpleOrderBuilder.payOrder(customer,1700);

    }
    @Then("The order Buffet can be delivered only at {int}:{int} pm")
    public void theOrderBuffetCanBeDeliveredOnlyAtPm(int arg0, int arg1) {
        cook = new Cook(3,"jean","paul",restaurant);
        cook.prepareOrder(buffet);
        cook.completeOrder(buffet);

        HourTime currentime2 = new HourTime(arg0,arg1);
        deliverer = new Deliverer(5,"fred","livraison");
        System.out.println(buffet.getHourTime());
        System.out.println(currentime2);
        deliverer.TakeInChargeAbuffet(buffet,currentime2);
        deliverer.DeliverAnOrder(buffet);
        System.out.println(buffet.getOrderState());
        assertEquals(buffet.getOrderState(),OrderState.DELIVERED);


    }
}
