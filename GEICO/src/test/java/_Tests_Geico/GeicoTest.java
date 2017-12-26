package _Tests_Geico;

import BaseAPI.Base_API_Cloud_Enhanced;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by sami on 11/22/17.
 */
public class GeicoTest extends Base_API_Cloud_Enhanced {



    @Test
    public void startQuote() throws InterruptedException {


        //verify url

        //verify homepage

        //enter zipcode
        typeByID("zip","22042");
        //wait(6);
        sleepFor(2);
        //click 'start quote'
        click(By.id("submitButton"));
        sleepFor(2);




    }


}
