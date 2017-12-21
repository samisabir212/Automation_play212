package AmazonHome;

import BaseAPI.BaseAPI_URL_BY_TEST;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAmazonHome extends BaseAPI_URL_BY_TEST {



    @Parameters({"url"})
    @Test(enabled = true)
    public void searchForAnyItem(String url) {


        driver.get(url);
        //get current title
        verifyTitle("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");


        //get current url
        verifyURL("http://Amazon.com");

        //fix
        fix_maxmize_deletecookies_wait();

        //send keys
        typeBy_EnterKey(By.id("twotabsearchtextbox"), "xbox one");

        //verify text search
        waitForElement(5, By.xpath(".//span[@id='editableBreadcrumbContent']//span[@class='a-color-state a-text-bold' and text()='\"xbox one\"']"));
        verifyTextFieldisDisplayed(".//span[@id='editableBreadcrumbContent']//span[@class='a-color-state a-text-bold' and text()='\"xbox one\"']");

    }

    @Parameters({"url"})
    @Test(enabled = false)
    public void getTitle(String url) {


        driver.get(url);

        String title = driver.getTitle();
        System.out.println(title);
    }



}
