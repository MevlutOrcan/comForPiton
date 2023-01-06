package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CreateEventPage {
    public CreateEventPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "name")
    public WebElement eventNameTextBox;

    @FindBy(id = "description")
    public WebElement eventDescriptionTextBox;

    @FindBy(id = "mat-input-135")
    public WebElement eventDateTextBox;

    @FindBy(xpath = "//button[@aria-label=\"Open calendar\"]")
    public WebElement eventDateIcon;



    @FindBy(xpath = "//*[@data-placeholder=\"Enter first name\"]")
    public WebElement participantFirstNameTextBox;

    @FindBy(xpath = "//*[@data-placeholder=\"Enter last name\"]")
    public WebElement participantLastNameTextBox;

    @FindBy(xpath = "//*[@data-placeholder=\"Enter email or phone\"]")
    public WebElement participantContactTextBox;

    @FindBy(xpath = "//form")
    public WebElement createEventForm;

    @FindBy(xpath = "//mat-error")
    public List<WebElement> errorsInCreateEventForm;


}
