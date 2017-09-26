package TestCases.AccountApplicationTest;

import BaseAPI.BaseAPIs;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by sami on 9/26/17.
 */


public class AccountApplication001 extends BaseAPIs {


    @Test
    public void AccountAppTest001() throws InterruptedException {

        clickByXpath(".//a[@class='btn btn-green-solid']");
        getCurrentPageUrl();
        verifyURL("https://invest.tdameritrade.com/grid/p/accountApplication");
        waitUntilClickAble(".//td[@class='dijitReset dijitRight dijitButtonNode dijitArrowButton dijitDownArrowButton dijitArrowButtonContainer']");
        clickByXpath(".//td[@class='dijitReset dijitRight dijitButtonNode dijitArrowButton dijitDownArrowButton dijitArrowButtonContainer']");
        clickByXpath(".//td[@id='dijit_MenuItem_16_text' and text()='Mr']");
        //typeByXpath("(.//div[@class='dijitReset dijitInputField dijitInputContainer'])[1]", "sami");



    }


}
