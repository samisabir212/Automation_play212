package Tests;



import BaseAPI.BaseAPI_URL_BY_TEST;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by sami on 11/7/17.
 */


public class TEST extends BaseAPI_URL_BY_TEST{

    @Parameters("url")
    @Test
    public void Test_launch(String url) throws InterruptedException {

        driver.get(url);
        clickByCss("#cat9581 > a:nth-child(1)");

    }


}
