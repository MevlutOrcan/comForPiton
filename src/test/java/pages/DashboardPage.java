package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DashboardPage {
    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//strong[.='Welcome Automation Test User']")
    public WebElement welcomeMessageText;

    @FindBy(xpath = "//button[.='Create Event']")
    public WebElement createEventButton;


    @FindBy(xpath = "//div/button[.='Create New Event']")
    public WebElement createNewEventButtonUnderTheForm;

    @FindBy(xpath = "//button[.='Add Participant']")
    public WebElement addParticipantButton;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> participantList;

    @FindBy(xpath = "//button[.='delete']")
    public List<WebElement> deleteParticipantButtonsList;

    @FindBy(xpath = "//*[.='Please add participant!']")
    public WebElement pleaseAddParticipantMessageText;

    @FindBy(xpath = "//*[contains(text(),'Event created successfully')]")
    public WebElement eventCreatedSuccessfullyMessageText;

    @FindBy(xpath = "//button[.='edit']")
    public List<WebElement> editButtonList;

    @FindBy(xpath = "//*[@class='mat-simple-snackbar ng-star-inserted']")
    public WebElement updateSuccessMessageText;

    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> nameList;

    @FindBy(xpath = "//tbody/tr/td[3]")
    public List<WebElement> descriptionList;

    @FindBy(xpath = "//tbody/tr/td[4]")
    public List<WebElement> dateList;

    @FindBy(xpath = "//*[.=' No registered event has been found!! ']")
    public List<WebElement> noRegisteredList;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> eventList;

    @FindBy(xpath = "//button[.='delete']")
    public List<WebElement> deleteButtonOnDashBoard;

    @FindBy(xpath = "//button[.='supervised_user_circle']")
    public WebElement participantsButton;

    @FindBy(xpath = "//table[@class=\"participant-table\"]")
    public WebElement participantsTable;


}
