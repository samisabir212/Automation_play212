package Test;


import Pages_skeleton.TwitterEditProfile;
import Pages_skeleton.TwitterLandingPage;
import Pages_skeleton.TwitterLoginPage;
import Pages_skeleton.TwitterMyProfile;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by sami on 10/14/17.
 */



public class testLogin extends TwitterLoginPage {



    @Parameters("url")
    @Test(enabled = true)
    public void TestLogin(String url) {

        driver.get(url);

        //must creat instance of page factory of TwitterLoginPage called twitlp
        TwitterLoginPage twitlp = PageFactory.initElements(driver, TwitterLoginPage.class);
        //notice we can update the hard coded data by data providors utilizing excel

        //creating a "has a" relationship by storing twitlp to landing page
        //so this line of code below will log the user in by 'doLogin' method then the the goToProfile method
        //now you can use all the methods and elements from landing page.
        TwitterLandingPage landingPage = twitlp.doLogin("samisabir22", "Apples212");




        //going to profile
        TwitterMyProfile twitterMyProfile = landingPage.goToProfile();
        //go to edit profile page
        twitterMyProfile.editProfile();

        //of edit profile class called edit profile lets us use the myprofile elements
        //this gives us access.
        TwitterEditProfile editProfile = twitterMyProfile.editProfile();

        editProfile.changeBio();


        //calling the edit profile pages change picture method.
        editProfile.changePicture();


        //go to followers
        landingPage.goToFollowers();

        //go to tweets
        landingPage.goToTweets();







    }




}
