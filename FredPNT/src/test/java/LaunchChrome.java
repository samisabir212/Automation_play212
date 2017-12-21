import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChrome {
	
	
	
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = null;
        System.setProperty("webdriver.chrome.driver", "/Users/sami/Desktop/RocketLauncher/Mac/Drivers/chromedriver2_25");
        driver = new ChromeDriver();
        driver.get("https://finance.google.com/finance");

        Thread.sleep(400);

        driver.findElement(By.linkText("News")).click();

        Thread.sleep(500);

        driver.close();
		
		
	}
	

}
