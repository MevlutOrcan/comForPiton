package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EditEventPage {
    public EditEventPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[contains(text(),'Edit Event')]")
    public WebElement editEventText;

    @FindBy(id = "name")
    public WebElement eventNameTextBox;

    @FindBy(id = "description")
    public WebElement eventDescriptionTextBox;

    @FindBy(id = "mat-input-153")
    public WebElement eventDateTextBox;

    @FindBy(xpath = "//*[@data-placeholder=\"Enter first name\"]")
    public WebElement participantFirstNameTextBox;

    @FindBy(xpath = "//*[@data-placeholder=\"Enter last name\"]")
    public WebElement participantLastNameTextBox;

    @FindBy(xpath = "//*[@data-placeholder=\"Enter email or phone\"]")
    public WebElement participantContactTextBox;

    @FindBy(xpath = "//*[@aria-label=\"Next month\"]")
    public WebElement nextMonthButton;


    @FindBy(xpath = "//button[.='Update Event']")
    public WebElement updateEventButton;


}
