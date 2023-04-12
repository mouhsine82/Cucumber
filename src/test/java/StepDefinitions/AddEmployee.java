package StepDefinitions;

import Pages.AddEmpPage;
import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddEmployee extends CommonMethods {


    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        WebElement pimTab=driver.findElement(By.id("menu_pim_viewPimModule"));
        doClick(pimTab);
    }
    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() {
        WebElement addEmployeeBtn=driver.findElement(By.id("menu_pim_addEmployee"));
        doClick(addEmployeeBtn);
    }
    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {

        WebElement firstnameTextBox=driver.findElement(By.id("firstName"));
        sendText(firstnameTextBox, ConfigReader.getPropertyValue("firstname"));

        WebElement middlenameTextBox=driver.findElement(By.id("middleName"));
        sendText(middlenameTextBox, ConfigReader.getPropertyValue("middlename"));

        WebElement lastnameTextBox=driver.findElement(By.id("lastName"));
        sendText(lastnameTextBox, ConfigReader.getPropertyValue("lastname"));


    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
       WebElement saveBtn=driver.findElement(By.id("btnSave"));
       doClick(saveBtn);
    }

    @When("user add {string}, {string} and {string}")
    public void user_add_and(String firstName, String middleName, String lastName) {
        AddEmpPage emp1=new AddEmpPage();
        sendText(emp1.addEmpFirstName, firstName);
        sendText(emp1.addEmpMiddleName, middleName);
        sendText(emp1.addEmpLastName, lastName);
    }
    @Then("clicks on save button")
    public void clicks_on_save_button() {

    }
}
