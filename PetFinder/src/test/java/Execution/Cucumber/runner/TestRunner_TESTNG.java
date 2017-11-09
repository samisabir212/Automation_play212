package Execution.Cucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Created by sami on 10/6/17.
 */


//@RunWith(Execution.Cucumber.class)
@CucumberOptions(features = {"src/test/java/Execution.Cucumber.Features"}, format = {"json:target/cucumber.json","html:target/site/cucumber-pretty"} ,glue = "Execution/Cucumber/Steps")
public class TestRunner_TESTNG extends AbstractTestNGCucumberTests {







    
}
