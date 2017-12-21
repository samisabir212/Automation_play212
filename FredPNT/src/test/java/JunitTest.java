import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.MaximizeWindow;

import Helper.Selenium_Helper;



public class JunitTest extends Selenium_Helper {
	
	
//	
//	AND ALSO PRACTICE SELENIUM CODE:
//	MAKE SURE ONE OF BROWSER IS WORKING, WRITE CODE TO OPEN ANY BROWSER, GO TO AMAZON.COM PAGE, PRINT TITLE,
//	VALIDATE TITLE, PRINT URL AND AGE SOURCE.

	
	public WebDriver driver = null;

	@Before
	public void setup() {
       
		System.setProperty("webdriver.chrome.driver", "/Users/sami/Desktop/RocketLauncher/Mac/Drivers/chromedriver2_25");
        driver = new ChromeDriver();
                
        
        
	
	}
	
	@Test
	public void LaunchGoogle() throws InterruptedException {
		
		
	
        driver.get("https://amazon.com");
        

        
	
        
	}
	
	@After
	public void tearDown() {
		driver.quit();
		
	}

}
