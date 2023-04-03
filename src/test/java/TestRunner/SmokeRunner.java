package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Features" , glue = "StepDefinitions", dryRun = false)// dryRun will run only the test case that doesn't have code instead of running all test cases
                                                                                                       //if its TRUE it will only generate the code without running test cases MUST be false to run all the test cases
public class SmokeRunner {
    

}
