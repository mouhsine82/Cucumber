package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Features" , glue = "StepDefinitions", dryRun = false, tags = "@testcase2")
// features option helps Cucumber to locate feature files
// glue option helps Cucumber to locate the step definition file
// dryRun will run only the test case that doesn't have code instead of running all test cases
//if its TRUE it will only generate the code without running test cases MUST be false to run all the test cases
//tags option will execute the tagged testcase as mentioned in your runner class (use smoke test/regression test)
public class SmokeRunner {
    

}
