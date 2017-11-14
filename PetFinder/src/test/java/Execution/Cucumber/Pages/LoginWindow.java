package Execution.Cucumber.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sami on 10/5/17.
 */
public class LoginWindow{


    /*
    * List out all elements in the homepage
    * use the Find by Annotation <@FindBy>
    * Then create the necessary action methods that are incorporated with each of
     *the Web Elements in the homepage
     *
     *DO NOT FOR GET TO INITIALIZE THE PAGE OBJECTS
     * you initialize all the elements by using PageFactory
     *  CLASS TYPE : PageFactory.initelements(Webdriver driver, Class<T>Pageclass to proxy)
    * */


    public LoginWindow(WebDriver driver) {

        PageFactory.initElements(driver, this);


    }

    @FindBy(how = How.XPATH, using = ".//a[@class='link-block with-icon signin']")
    public WebElement signInClick;

    @FindBy(how = How.XPATH, using = ".//div[@class='grid']//input[@id='username']")
    public WebElement txtUsername;

    @FindBy(how = How.XPATH, using = ".//div[@class='grid']//input[@id='password']")
    public WebElement txtPassword;


    @FindBy(how = How.XPATH, using = ".//div[@class='grid']//input[@name='sign_in']")
    public WebElement loginClick;

    @FindBy(how = How.XPATH, using = ".//*[@id='your-account']/a")
    public WebElement myPetFinderClick;


    public void clickSignIn() {


        signInClick.click();

    }

    public void Login(String userName, String passWord) {


        txtUsername.sendKeys(userName);
        txtPassword.sendKeys(passWord);

    }


    public void clickLogin() {

        loginClick.click();

    }


    public void clickMyPetFinder() {

        myPetFinderClick.click();
    }



}
