package Pages_skeleton;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sami on 10/16/17.
 */

//twitter login page has a landing page
    //this is a has a relationship
public class TwitterLandingPage extends TwitterLoginPage {


    @FindBy(how = How.ID, using = "user-dropdown-toggle")
    WebElement profileButton;


    WebElement followingButton;


    WebElement tweetsButton;


    WebElement followersButton;



    //profile page takes you to profile
    //when you get to the profile page you want to interact with those page elements
    //so make this method to return the Profile page elements and methods by removing void and adding the class name
    public TwitterMyProfile goToProfile() {

        //go to profile
        profileButton.click();


        //return the twitterMyProfile page elements and methods
        return PageFactory.initElements(driver, TwitterMyProfile.class);
        //now go to the twitterMyprofile page and create instance and call those methods and use the elments

    }

    public void goToFollowing() {

        //go see followers
        followingButton.click();

    }

    public void goToTweets() {

        //go see myt weets
        tweetsButton.click();


    }

    public void goToFollowers() {


        followersButton.click();



    }






}
