package Execution.Cucumber.Steps;

import Execution.Cucumber.Cucumber_base.BaseUtility_Cucumber;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by sami on 10/4/17.
 *
 * Technically the HOOK is our Temporary Base.
 */
public class Hook extends BaseUtility_Cucumber {


    private BaseUtility_Cucumber base;

    public Hook(BaseUtility_Cucumber base) {

        this.base = base;

    }


    @Before
    public void initializeTest() {

        System.setProperty("webdriver.chrome.driver", "/Users/sami/IdeaProjects/SeleniumBootCamp/Base/src/main/java/Drivers/chromedriver");


        base.driver = new ChromeDriver();



    }

    @After
    public void tearDown() {

        base.driver.close();
      //  base.driver.quit();



    }



}
