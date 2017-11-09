package pages_myFlow;

import BaseAPI.BaseAPI_URL_BY_TEST;
import com.gargoylesoftware.htmlunit.javascript.host.canvas.ext.WEBGL_compressed_texture_s3tc;
import org.openqa.selenium.WebElement;

import java.util.Properties;

/**
 * Created by sami on 10/16/17.
 */
public class welcomePageNotLoggedIn extends BaseAPI_URL_BY_TEST {


    //Properties properties = new Properties();
    /*
    * we're going to login with user name and password and press login
    * this will be one test alone.
    * */
    public void doLogin(String userName, String passWord) {


        //enter username;
        username.sendKeys(userName);

        //enter password
        password.sendKeys(passWord);

        //click login
        signin.click();




    }


    WebElement username;

    WebElement password;

    WebElement signin;

}
