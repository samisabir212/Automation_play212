package Test.testTwitter;

import BaseAPI.BaseAPI_URL_BY_TEST;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by sami on 10/16/17.
 */
public class TestTwitter extends BaseAPI_URL_BY_TEST {


    @Parameters("url")
    @Test(enabled = true, priority = 1)
    public void login(String url) {

        driver.get(url);

    }

    @Parameters("url")
    @Test(enabled = true, dependsOnMethods = {"login"}, priority = 2)
    public void profilePage(String url) {

        //click the profile icon
        //click the profile drop down link

    }

    @Parameters("url")
    @Test(enabled = true)
    public void editProfile(String url) {

        //click the edit profile link
        //


    }

    @Parameters("url")
    @Test(enabled = true)
    public void createTweet(String url) {

        //click tweet button
        //enter text in the compose field
        //click


    }

}
