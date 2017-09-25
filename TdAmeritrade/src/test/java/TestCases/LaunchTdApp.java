package TestCases;

import BaseAPI.BaseAPIs;
import org.testng.annotations.Test;

/**
 * Created by sami on 9/24/17.
 */
public class LaunchTdApp extends BaseAPIs {


    @Test
    public void LaunchTdAPP() throws InterruptedException {
        sleepFor(3);

        clickByXpath(".//a[@class='btn btn-green-solid']");


    }



}
