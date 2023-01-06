package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//mat-card-title/*[.=' Event Manager Login ']")
    public WebElement eventManagerLoginText;

    @FindBy(css = "#username")
    public WebElement userNameTextBox;

    @FindBy(css = "#password")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//button/span[.='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[contains(text(),'Username field is required')]")
    public WebElement usernameRequiredMessageText;

    @FindBy(xpath = "//*[contains(text(),'Password field is required')]")
    public WebElement passwordRequiredMessageText;

    @FindBy(xpath = "//*[contains(text(),'Event created successfully')]")
    public WebElement eventCreatedSuccessfullyMessageText;


}
