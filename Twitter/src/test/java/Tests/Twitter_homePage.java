package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Twitter_homePage {


    public static WebDriver driver = null;


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/sami/IdeaProjects/SeleniumBootCamp/Base/src/main/java/Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://finance.google.com/finance");

        Thread.sleep(400);

        driver.findElement(By.linkText("News")).click();


        Thread.sleep(500);

        driver.close();

    }
}
