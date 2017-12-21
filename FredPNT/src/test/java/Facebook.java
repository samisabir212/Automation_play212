import Helper.Selenium_Helper;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook extends Selenium_Helper {

    public WebDriver driver = null;


    @Before
    public void initialize() {

        System.setProperty("webdriver.chrome.driver", "/Users/sami/Desktop/RocketLauncher/Mac/Drivers/chromedriver2_25");
        driver = new ChromeDriver();


    }


    public void testFB() {

        driver.get("https://facebook.com");





    }


}
