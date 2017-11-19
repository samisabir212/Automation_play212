package Interactions;

import BaseAPI.BaseAPI_URL_BY_TEST;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;

/**
 * Created by sami on 10/27/17.
 */
public class Draggable extends BaseAPI_URL_BY_TEST {


    @Parameters("url")
    @Test(enabled = true)
    public void dragMe(String url) throws InterruptedException {


        driver.get(url);

        click(By.partialLinkText("Draggable"));

        try {
            dragAndDrop(".//li[@id=‘draggable’]", ".//ul[@id=‘sortable’]//li[@class=‘ui-state-default ui-sortable-handle’]");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
