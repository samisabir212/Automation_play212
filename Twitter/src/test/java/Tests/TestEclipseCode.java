package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestEclipseCode {


    public WebDriver driver = null;


    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/sami/IdeaProjects/SeleniumBootCamp/Twitter/src/test/java/Drivers/chromedriverMAC");
        driver = new ChromeDriver();
    }

    @Test
    public void LaunchGoogle() {


        driver.get("http://www.google.com");



    }

    @After
    public void tearDown() {
        driver.quit();

    }
}
