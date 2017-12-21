import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Helper.Selenium_Helper;

public class HomeWork1 extends Selenium_Helper {
//	AND ALSO PRACTICE SELENIUM CODE:
//	MAKE SURE ONE OF BROWSER IS WORKING, WRITE CODE TO OPEN ANY BROWSER, GO TO AMAZON.COM PAGE, PRINT TITLE,
//	VALIDATE TITLE, PRINT URL AND AGE SOURCE.

	
	public WebDriver driver = null;

	@Before
	public void setup() {
       
		System.setProperty("webdriver.chrome.driver", "/Users/sami/Desktop/RocketLauncher/Mac/Drivers/chromedriver2_25");
        driver = new ChromeDriver();
	}
	
	//@Ignore("already tested and works")
	@Test
	public void Verify_Validate_Facebook() throws InterruptedException {
		
		
		driver.manage().window().maximize();
        driver.get("https://amazon.com");
        //get title
        //validateTitle("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
        String Page_title = driver.getTitle();
        System.out.println("pagetitle is :: "+ Page_title);
        
        String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        String title = driver.getTitle();
        Assert.assertEquals(title, expectedTitle);
        if(title.equals(expectedTitle)){
        	System.out.println("title verify :: Passed");
        }else {
        	System.out.println("title verify :: Failed");
        }
        //Verify and print url
        String url_amazon = driver.getCurrentUrl();
        System.out.println(url_amazon);
        String expected_URL = "http://amazon.com";
        if(url_amazon.equals(expected_URL)) {
        	System.out.println("verify url:: passed" );
        }else {
        	System.out.println("verify url:: failed");
        }
        //get page source
        String pgs = driver.getPageSource();
        System.out.println(pgs);
	}
	

	
	@Ignore(" Verify URL Method is not working...")
	@Test
	public void facebook_validate_verify() {
		
		
		driver.get("http://facebook.com");
		
		
		//verify title
		//verifyTitle("Facebook - Log In or Sign Up");
		System.out.println(driver.getTitle());
		
		System.out.println(driver.getCurrentUrl());
		//verify url
		//verifyURL("https://www.facebook.com/");
		
		//get page source
		driver.getPageSource();
		
		
		
		
		
		
		
		
		
		
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
		
	}
	
	

}
