package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeSearchPage extends CommonMethods {

    @FindBy (xpath ="//input[@id='empsearch_id']" )
    public WebElement empIdTextBox;

    @FindBy(xpath ="//input[@id='searchBtn']" )
    public WebElement searchBtn;

    @FindBy(xpath = "//select[@id='empsearch_job_title']")
    public WebElement jobTitleDdl;

    @FindBy(xpath ="//select[@id='empsearch_employee_status']" )
    public WebElement empStatusDdl;

    @FindBy(xpath = "//select[@id='empsearch_termination']")
    public WebElement includeDdl;

    public EmployeeSearchPage(){
        PageFactory.initElements(driver,this);
    }

}
