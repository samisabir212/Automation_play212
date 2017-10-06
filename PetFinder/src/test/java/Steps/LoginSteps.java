package Steps;

import Cucumber_base.BaseUtility_Cucumber;
import Pages.LoginWindow;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by sami on 10/3/17.
 */
 public class LoginSteps {


    private final BaseUtility_Cucumber base;






    public LoginSteps(BaseUtility_Cucumber base) {

        this.base = base;
        
    }


    @Given("^i navigate to the Url$")
    public void iNavigateToTheUrl() throws Throwable {


        base.driver.navigate().to("http://www.petfinder.com");
        base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        System.out.println("Navigated to the url");

    }

    @And("^I click sign in button$")
    public void iClickSignInButton() throws Throwable {

        LoginWindow loginWindow = new LoginWindow(base.driver);


        //base.driver.findElement(By.xpath(".//a[@class='link-block with-icon signin']")).click();
        loginWindow.clickSignIn();

        Thread.sleep(2000);

    }


    @And("^I enter the the following data for logging in$")
    public void iEnterTheTheFollowingDataForLoggingIn(DataTable table) throws Throwable {

        //creates an array list of type List not ArrayList
        List<User> users = new ArrayList<User>();

        //storeing all the users to this users array list from features table
        users = table.asList(User.class);

        for (User user: users) {

            LoginWindow loginWindow = new LoginWindow(base.driver);


            loginWindow.Login(user.username, user.password);




           // base.driver.findElement(By.xpath(".//div[@class='grid']//input[@id='username']")).sendKeys(user.username);
            //Thread.sleep(3000);
            //base.driver.findElement(By.xpath(".//div[@class='grid']//input[@id='password']")).sendKeys(user.password);
            //Thread.sleep(3000);

        }


    }


    /*@And("^I enter the ([^\"]*) and ([^\"]*)$")
    public void iEnterTheUsernameAndPassword(String username, String password) throws Throwable {




    }
*/



    @And("^I click Login button$")
    public void iClickLoginButton() throws Throwable {

        LoginWindow loginWindow = new LoginWindow(base.driver);


        System.out.println("clicking  login button");
       // base.driver.findElement(By.xpath(".//div[@class='grid']//input[@name='sign_in']")).click();

        loginWindow.clickLogin();


    }

    @Then("^I can click the 'My pet Finder button'$")
    public void iCanClickTheMyPetFinderButton() throws Throwable {

        LoginWindow loginWindow = new LoginWindow(base.driver);


        System.out.println("clicking petfinder button");
       // base.driver.findElement(By.xpath(".//*[@id='your-account']/a")).click();
        loginWindow.clickMyPetFinder();


    }

    @And("^I should be Redirected to the Profile page$")
    public void iShouldBeRedirectedToTheProfilePage() throws Throwable {

        System.out.println("redirected to the profile page");
        String profileTitle = base.driver.getTitle();
        System.out.println(profileTitle);

    }



    /*must create a constructor to store the values so you can use it to store it within an array*/
    //my constructor to access the Username and password data set from table
    public class User {

        public String username;
        public String password;

        //my constructor
        public User(String userName, String passWord) {
            username = userName;
            password = passWord;
        }

    }
}
