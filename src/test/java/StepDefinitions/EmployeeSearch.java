package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmployeeSearch extends CommonMethods {
    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {

        sendText(employeeSearchPage.empIdTextBox, ConfigReader.getPropertyValue("empid"));

    }

    @When("clicks on search button")
    public void clicks_on_search_button() {

        doClick(employeeSearchPage.searchBtn);
    }

    @When("user see employee information is displayed")
    public void user_see_employee_information_is_displayed() {
        System.out.println("The employee is displayed");

    }

    @When("user select Job Title")
    public void user_select_job_title() {

       selectByOptions(employeeSearchPage.jobTitleDdl,"Singer");

       selectByOptions(employeeSearchPage.empStatusDdl,"Active");

       selectByOptions(employeeSearchPage.includeDdl,"Current and Past Employees");

    }
}
