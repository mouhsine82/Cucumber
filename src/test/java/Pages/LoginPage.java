package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods {
    // page factory model
    //QA's write all the locators of the page in respective class

    public LoginPage() {
        PageFactory.initElements(driver, this); // initializing the webElements of the current page
    }

    @FindBy(id="txtUsername")
    public WebElement usernameTextBox;

    @FindBy(id="txtPassword")
    public WebElement passwordTextBox;

    @FindBy(id="btnLogin")
    public WebElement loginBtn;

    @FindBy(xpath = "//a[@id='welcome']")
    public WebElement welcomeIcon;

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logoutIcon;







}
