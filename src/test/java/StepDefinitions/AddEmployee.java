package StepDefinitions;


import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class AddEmployee extends CommonMethods {


    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        // here we are calling addEmployeePage object from PageInitializer.webElement from AddEmployeePage
        doClick(addEmployeePage.pimTab);
    }

    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() {

        doClick(addEmployeePage.addEmployeeBtn);
    }

    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {
        //System.out.println(10/0);
        sendText(addEmployeePage.firstnameTextBox, ConfigReader.getPropertyValue("firstname"));

        sendText(addEmployeePage.middlenameTextBox, ConfigReader.getPropertyValue("middlename"));

        sendText(addEmployeePage.lastnameTextBox, ConfigReader.getPropertyValue("lastname"));


    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        doClick(addEmployeePage.saveBtn);
    }


        }


