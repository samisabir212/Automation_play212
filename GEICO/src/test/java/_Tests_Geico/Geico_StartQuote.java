package _Tests_Geico;

import BaseAPI.BaseAPI_URL_BY_TEST;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Geico_StartQuote extends BaseAPI_URL_BY_TEST {

    @Parameters("url_home")
    @Test
    public void User_Can_Find_CarInsurance_Quote_By_Zipcode_From_HomePage(String url_home) {


        driver.get(url_home);

        //verify url

        //verify homepage

        //enter zipcode

        //click 'start quote'




    }

    @Parameters("url_sitesearch")
    @Test
    public void User_Can_Find_HomeInsurance_quote_from_SiteSearch_Page(String url_sitesearch) {

        driver.get(url_sitesearch);


        //verify url

        //verify site search page

        //select "Home" from 'Start your free quote feature'

        //enter zipcode

        //click 'Start home quote'

        

    }
}
