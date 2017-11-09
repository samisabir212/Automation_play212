package Execution.Cucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by sami on 10/5/17.
 */


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/Execution.Cucumber.Features"}, glue = "Execution/Cucumber/Steps")
public class TestCucumberRunnerClass {



}
