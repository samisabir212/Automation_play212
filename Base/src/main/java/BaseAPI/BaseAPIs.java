package BaseAPI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by sami on 9/24/17.
 */
public class BaseAPIs {

    //initialize webdriver to nill
    WebDriver driver = null;

    @Parameters({"useCloud", "cloudUserName", "cloudAccessKey", "cloudPlateform", "useGrid", "Plateform", "os", "browserName", "browserVersion", "url"})
    @BeforeMethod
    public void setUp(@Optional("false") boolean useCloud, @Optional("sami212") String cloudUserName,
                      @Optional("####") String cloudAccessKey, String cloudPlateform, @Optional("false") boolean useGrid, String Platform, @Optional("Windows 10") String os,
                      @Optional("chrome") String browserName, @Optional("58") String browserVersion, String url) {


    }


    //my local driver
    public WebDriver getLocalDriver(String os, String browserName) {


        if (browserName.equalsIgnoreCase("chrome")) {

            if (os.equalsIgnoreCase("Mac")){
                System.setProperty("webdriver.chrome.driver", "../Base/src/main/java/Drivers/chromedriver");

            } else if (os.equalsIgnoreCase("Win10")) {
                System.setProperty("webdriver.chrome.driver", "Windows path for chrome driver here.");

            } else if (os.equalsIgnoreCase("Linux")) {
                System.setProperty("webdriver.chrome.driver","..Base/src/main/java/Drivers/chromedriverLinux");
            }
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {


            if (os.equalsIgnoreCase("Mac")) {
                System.setProperty("webdriver.gecko.driver", "../Base/src/main/java/Drivers/chromedriver");

            } else if (os.equalsIgnoreCase("Win10")) {
                System.setProperty("webdriver.gecko.driver", "Windows path for chrome driver here.");

            } else if (os.equalsIgnoreCase("Linux")) {
                System.setProperty("webdriver.gecko.driver", "../Base/src/main/java/Drivers/geckodriverLinux");

            }

            driver = new FirefoxDriver();

        } else if (os.equalsIgnoreCase("Win")) {
            if (browserName.equalsIgnoreCase("ie")) {
                System.setProperty("webdriver.ie.driver", "IE windows path to driver here");

            }

            driver = new InternetExplorerDriver();
        }

        return driver;

    }

    public WebDriver getCloudDriver(String cloudUserName, String cloudAccessKey, String os, String browserName, String browserVersion) throws MalformedURLException {

        //create an instance of Desired Capablities called cap
        {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("cloudPlateform", os);
            cap.setBrowserName(browserName);
            cap.setCapability("version", browserVersion);
            driver = new RemoteWebDriver(new URL("http://" + cloudUserName + ":" +
                    cloudAccessKey + "@ondemand.saucelabs.com:80/wd/hub"), cap);

            return driver;


        }


    }

    public WebDriver getGrid(String Platform, String browserName, String browserVersion, String url) {


    }


















}
