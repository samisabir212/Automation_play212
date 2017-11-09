package Interactions;

import BaseAPI.BaseAPI_URL_BY_TEST;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by sami on 10/27/17.
 */
public class Droppable extends BaseAPI_URL_BY_TEST {


    @Parameters("url")
    @Test(enabled = true)
    public void dropMeThere(String url) throws InterruptedException {



        driver.get(url);
        click(By.partialLinkText("Droppable"));

        WebElement iframeDroppable = driver.findElement(By.className("demo-frame"));
        iframeHandle(iframeDroppable);

        dragAndDropByAnyLocatorType(By.id("draggable"), By.id("droppable"));

        sleepFor(5);

    }


}
