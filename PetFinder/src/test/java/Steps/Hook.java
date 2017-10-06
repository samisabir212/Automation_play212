package Steps;

import Cucumber_base.BaseUtility_Cucumber;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by sami on 10/4/17.
 */
public class Hook extends BaseUtility_Cucumber {


    private BaseUtility_Cucumber base;

    public Hook(BaseUtility_Cucumber base) {

        this.base = base;

    }


    @Before
    public void initializeTest() {

        System.setProperty("webdriver.gecko.driver", "/Users/sami/Desktop/SeleniumBootCamp/Base/src/main/java/Drivers/geckodriverMAC");


        base.driver = new FirefoxDriver();



    }

    @After
    public void tearDown() {

        base.driver.close();
      //  base.driver.quit();



    }



}
