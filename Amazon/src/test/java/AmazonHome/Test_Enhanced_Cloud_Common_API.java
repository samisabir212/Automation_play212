package AmazonHome;

import BaseAPI.Base_API_Cloud_Enhanced;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test_Enhanced_Cloud_Common_API extends Base_API_Cloud_Enhanced {


    @Parameters("URL")
    @Test(enabled = true)
    public void initialize() {


        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("xbox one");





    }
}
