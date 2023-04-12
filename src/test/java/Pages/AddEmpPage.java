package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmpPage extends CommonMethods {
    public AddEmpPage() {
        PageFactory.initElements(driver, this);
    }
    ///////////////////////////////////////////////////////////
    // add employee firstname, middlename and lastname for Scenario outline add employee

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement addEmpFirstName;

    @FindBy(xpath = "//input[@id='middleName']")
    public WebElement addEmpMiddleName;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement addEmpLastName;
}
