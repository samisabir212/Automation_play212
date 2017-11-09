package Pages_skeleton;

import BaseAPI.BaseAPI_URL_BY_TEST;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sami on 10/14/17.
 *
 * in page object model
 * the page classes will hold the methods that do the actions
 * the page classes will hold the web element objects by using the @FindBy annotation
 */
public class TwitterLoginPage extends BaseAPI_URL_BY_TEST {

    //create a constructor to initialize the webdriver.
    //i dont think this is needed because we are extending an advanced base api called BaseAPI_URL_BY_TEST


    //so we are using the page factory to be able to utilize these elements across different pages.
    //this is the key for the is a has a relationship
    //if a page has a common element.. we dont need to re create the elements over and over for each page.



    @FindBy(how = How.CSS, using = "a[class=‘EdgeButton EdgeButton--transparent EdgeButton--medium StreamsLogin js-login’]")
    WebElement loginButton;

    @FindBy(how = How.CSS, using = ".text-input email-input js-signin-email")
    WebElement username;

    @FindBy(how = How.XPATH, using = "//div[@class='LoginForm-input LoginForm-password']//input[@class='text-input']")
    WebElement password;

    @FindBy(how = How.CSS, using = ".EdgeButton EdgeButton--primary EdgeButton--medium submit js-submit")
    WebElement signingButton;


/*    //constructor
    public TwitterLoginPage(WebDriver driver) {

        this.driver = driver;
    }*/


    //this is called twitterLandingPage because its of the TwitterLandingPage Class
    //notice its public TwitterLandingPage and then the method name is doLogin
    //so its going to be a return type of landing page.
    //why ? becuause Twitterlogin page has a landing page.
    //notice we are using the "Has a" relationship
    public TwitterLandingPage doLogin(String userName, String passWord) {

        //navigate to twitter
        //verify the login button is present
        waitForElement(4, By.cssSelector("a[class=‘EdgeButton EdgeButton--transparent EdgeButton--medium StreamsLogin js-login’]"));
        loginButton.isDisplayed();
        //click login button
        loginButton.click();

        //verify the username field is present
        username.isDisplayed();

        //verify the password field is present
        password.isDisplayed();

        //verify the sign in button is present
        signingButton.isDisplayed();


        //user enters username
        username.sendKeys(userName);

        //user enters password
        password.sendKeys(passWord);

        //user clicks sign in
        signingButton.click();


        //this will initialze the pagefactory for the landing page.
        //page factory always takes the driver parameter first then the class as a parameter
        //by returning the PageFactory of TwitterlandingPage it is returning the elements
        //imagine a chain of classes sharing common elements waiting to be used to create actions
        //when we use the loginpage we are going to return the landing page page elements. code below (Page factory)
        return PageFactory.initElements(driver, TwitterLandingPage.class);
    }





}
