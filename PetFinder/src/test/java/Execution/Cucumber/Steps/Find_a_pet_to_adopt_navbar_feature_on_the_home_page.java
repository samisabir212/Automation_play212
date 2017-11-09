package Execution.Cucumber.Steps;

import Execution.Cucumber.Cucumber_base.BaseUtility_Cucumber;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by sami on 10/13/17.
 */
public class Find_a_pet_to_adopt_navbar_feature_on_the_home_page {



    /*
    * call your base class to launch your test with webdriver
    *
    * create a constructor to utilize the base class
    *
    * pass the baseutility classinto the constructor and set base to this.base
    *
    * execute test from features class folder
    * */

    private final BaseUtility_Cucumber base;


    public Find_a_pet_to_adopt_navbar_feature_on_the_home_page(BaseUtility_Cucumber base) {

        this.base = base;


    }



    //get all steps from feature file and turn it into code
    @Given("^i navigate to the Url home page$")
    public void i_navigate_to_the_Url_home_page() throws Throwable {

        //navigate to url
        base.driver.get("http://PetFinder.com");

    }


    @And("^i click find pets button$")
    public void i_click_find_pets_button() throws Throwable {

        //click the "Find Pets" button

    }

    @Then("^i should not be navigated to a result page$")
    public void i_should_not_be_navigated_to_a_result_page() throws Throwable {

        //verify that the user is not on the home



    }

    @Then("^i should stay on the home page$")
    public void i_should_stay_on_the_home_page() throws Throwable {

        //verify that the user is still on the home page by title

    }

    @Then("^a pop up field should appear that says \"(.*?)\" under the location text field box$")
    public void a_pop_up_field_should_appear_that_says_under_the_location_text_field_box(String arg1) throws Throwable {

        //verify that the pop up field appears after clicking the "Find Pet" button


    }

}
