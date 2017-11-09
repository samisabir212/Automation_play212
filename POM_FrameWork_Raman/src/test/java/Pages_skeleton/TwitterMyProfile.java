package Pages_skeleton;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sami on 10/16/17.
 */
public class TwitterMyProfile extends TwitterLandingPage {



    //ask your self what are somethings you can do in the profile page?
    /*
    * we can verify that the edit profile is present and validate that we are logged in
    * we can create a tweet
    * we can check our followers
    * we can refresh who to follow
    * we can view all who we can follow
    *
    * */




    //create element for edit profile button
    @FindBy
    WebElement editProfileButton;


    //edit profile
    public TwitterEditProfile editProfile() {

        editProfileButton.click();


        return PageFactory.initElements(driver,TwitterEditProfile.class);

    }







}
