package SeleniumGrid;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by sami on 7/25/17.
 */
public class GridBaseAPI {


    protected WebDriver driver;
    protected SearchPageFactory search;
    public Properties OR = new Properties();
    public Properties Config = new Properties();
    public FileInputStream fis;

    


    @Parameters({"Plateform", "browserName", "browserVersion", "url"})
    @BeforeClass(alwaysRun = true)
    public void setup(String Plateform, String browserName, String browserVersion, String url) throws MalformedURLException {

        driver = getDriverInstance(Plateform, browserName, browserVersion, url);
        //connected to parameter to run the test by using search
        SearchPageFactory search = PageFactory.initElements(driver, SearchPageFactory.class);
    }


    public static WebDriver getDriverInstance(String platform, String browserName, String browserVersion, String url)
            throws MalformedURLException {

        //passing node url to remote driver
        String nodeURL = "http://192.168.1.175:4444/wd/hub";

        WebDriver driver = null;

        DesiredCapabilities caps = new DesiredCapabilities();

        // Platforms
        if (platform.equalsIgnoreCase("Windows")) {
            caps.setPlatform(Platform.WINDOWS);
        }
        if (platform.equalsIgnoreCase("MAC")) {
            caps.setPlatform(Platform.MAC);
        }
        if (browserName.equalsIgnoreCase("Linux")) {
            caps.setPlatform(Platform.LINUX);
        }

            // Browsers
        if (browserName.equalsIgnoreCase("chrome")) {
            caps = DesiredCapabilities.chrome();
        }
        if (browserName.equalsIgnoreCase("firefox")) {
            caps = DesiredCapabilities.firefox();
        }
        // Version
        caps.setVersion(browserVersion);
        driver = new RemoteWebDriver(new URL(nodeURL), caps);
        // Maximize the browserName's window
        // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Open the Application
        driver.get(url);
        return driver;
    }






    @AfterClass
    public void afterClass() {
        driver.quit();
    }


    /************CLICK***********/

    //click by id
    public void clickById(String locator) {
        driver.findElement(By.id(locator)).click();
    }

    //click by xpath
    public void clickByXpath(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    //click by css
    public void clickByCss(String locator) {
        driver.findElement(By.cssSelector(locator)).click();
    }



    /**********TYPE SEND KEYS*********/


    public void typeByCss(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }

    //typeing by id locator
    public void typeByID(String locator, String value) {
        driver.findElement(By.id(locator)).sendKeys(value);
    }

    //type by id and enter key
    public void typeByIdEnter(String locator, String value) {
        driver.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
    }


    //type by xpath and ENTER key
    public void typeByXpathEnter(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER);
    }

    //type by css and ENTER key
    public void typeByCssEnter(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
    }

    //type by xpath
    public void typeByXpath(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }

    //?????
    public void takeEnterKeys(String locator) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }


    /*sleep*/
    public void sleepFor(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    //get list of elements by xpath
    public List<WebElement> getListOfWebElementsByXpath(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.xpath(locator));
        return list;

    }

    public List<WebElement> getListOfWebElementsByID(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.id(locator));

        System.out.println(list.toString());

        return list;
    }

    public List<WebElement> printListOfWebElementsByID(String locator) {

        WebElement element = driver.findElement(By.id(locator));
        Select sel = new Select(element);
        List<WebElement> options = sel.getOptions();
        int size = options.size();
        System.out.println("***Data from WebApp***");

        for (int i = 0; i < 3; i++) {

            String optionName = options.get(i).getText();
            System.out.println(optionName);

        }


        return options;
    }


}
