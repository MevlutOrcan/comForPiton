package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.Pages;
import utilities.Driver;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


import static org.junit.Assert.*;
import static utilities.ReusableMethods.*;

public class EventStepDefs {
    Pages pages = new Pages();
    static String eventName, eventDesc, eventDate, firstName, lastName, contact;

    @When("User clicks Create Event Buttom")
    public void user_clicks_create_event_buttom() {
        clickElement(pages.dashboardPage().createEventButton);
    }

    @Then("User verifies they see the Event Form")
    public void user_verifies_they_see_the_event_form() {
        isElementPresent(pages.createEventPage().createEventForm);
    }

    @When("User clicks Create New Event Button")
    public void user_clicks_create_new_event_button() {
        clickElement(pages.dashboardPage().createNewEventButtonUnderTheForm);
    }

    @Then("User verifies error messages")
    public void user_verifies_error_messages() {
        assertTrue(pages.createEventPage().errorsInCreateEventForm.size() > 4);
    }

    Integer firstTimeParticipantListSize;

    @When("User clicks Add Participant button")
    public void user_clicks_add_participant_button() {
        firstTimeParticipantListSize = pages.dashboardPage().participantList.size();
        clickElement(pages.dashboardPage().addParticipantButton);
    }

    @Then("User verifies the participants number increases")
    public void user_verifies_the_participants_number_increases() {
        Integer lastTimeParticipantListSize = pages.dashboardPage().participantList.size();
        assertTrue(firstTimeParticipantListSize < lastTimeParticipantListSize);
    }

    @When("User cliks Delete Participant Button")
    public void user_cliks_delete_participant_button() {
        List<WebElement> deletebuttons = pages.dashboardPage().deleteParticipantButtonsList;
        for (WebElement w : deletebuttons
        ) {
            clickElement(w);
        }

    }

    @Then("User verifies they see the Please Add Participant text")
    public void user_verifies_they_see_the_please_add_participant_text() {
        isElementPresent(pages.dashboardPage().pleaseAddParticipantMessageText);
    }

   static String eventNameBeforeUpdate;
   static String descNameBeforeUpdate;
    static String dataBeforeUpdated;
    @When("User fills it up the form {string} {string} {string} {string} {string} {string}")
    public void user_fills_it_up_the_form(String eventName, String eventDesc, String eventDate, String firstName, String lastName, String contact) {
        eventNameBeforeUpdate= getValueWithJs("name");
        descNameBeforeUpdate=getValueWithJs("description");
        dataBeforeUpdated=eventNameBeforeUpdate+descNameBeforeUpdate;


        firstName = getFaker().name().firstName();
        eventName = getFaker().name().username();
        eventDesc = getFaker().name().fullName();
        lastName = getFaker().name().lastName();
        contact = (String) getFaker().phoneNumber().phoneNumber();

        enterKeys(pages.createEventPage().eventNameTextBox, eventName, true);
        enterKeys(pages.createEventPage().eventDescriptionTextBox, eventDesc, true);
        clickElement(pages.createEventPage().eventDateIcon);
        clickElement(pages.editEventPage().nextMonthButton);
        clickElement(Driver.getDriver().findElement(By.xpath("(//tbody/tr/td)[27]")));
        enterKeys(pages.createEventPage().participantFirstNameTextBox, firstName, true);
        enterKeys(pages.createEventPage().participantLastNameTextBox, lastName, true);
        enterKeys(pages.createEventPage().participantContactTextBox, contact, true);

    }
    @Given("User creates an event")
    public void user_creates_an_event() {
        clickElement(pages.dashboardPage().createEventButton);
        user_fills_it_up_the_form(" "," "," "," "," "," ");
        clickElement(pages.dashboardPage().createNewEventButtonUnderTheForm);
    }

    @Then("Use verifies they see successfull message")
    public void use_verifies_they_see_successfull_message() {
        isElementPresent(pages.dashboardPage().eventCreatedSuccessfullyMessageText);
    }

    @When("User clicks Edit Button")
    public void user_clicks_edit_button() {
        clickElement(pages.dashboardPage().editButtonList.get(0));
    }

    @When("User edit it up the all form fields {string} {string} {string} {string} {string} {string}")
    public void user_edit_it_up_the_all_form_fields(String eventName, String eventDesc, String eventDate, String firstName, String lastName, String contact) throws IOException {
        getScreenshot("beforeEdit");
        firstName = getFaker().name().firstName();
        eventName = getFaker().name().username();
        eventDesc = getFaker().name().fullName();
        lastName = getFaker().name().lastName();
        contact = (String) getFaker().phoneNumber().phoneNumber();

        enterKeys(pages.createEventPage().eventNameTextBox, eventName, true);
        enterKeys(pages.createEventPage().eventDescriptionTextBox, eventDesc, true);
        clickElement(pages.createEventPage().eventDateIcon);
        clickElement(pages.editEventPage().nextMonthButton);
        clickElement(Driver.getDriver().findElement(By.xpath("(//tbody/tr/td)[27]")));
        enterKeys(pages.editEventPage().participantFirstNameTextBox, firstName, true);
        enterKeys(pages.editEventPage().participantLastNameTextBox, lastName, true);
        enterKeys(pages.editEventPage().participantContactTextBox, contact, true);

        updatedEventName= getValueWithJs("name");
        updatedDescName=getValueWithJs("description");
    }
static String updatedEventName;
static String updatedDescName;
    @Then("User verifies all form fields are updated")
    public void user_verifies_all_form_fields_are_updated() throws IOException {


       String dataAfterUpdate= getValueWithJs("name")+getValueWithJs("description");
       assertNotEquals(dataAfterUpdate,dataBeforeUpdated);
        getScreenshot("afterEdit");
    }

    @Given("User clicks Update Event Button")
    public void user_clicks_update_event_button() {
      clickElement(pages.editEventPage().updateEventButton);
    }
    @Then("User verifies Update Successfull Message")
    public void user_verifies_update_successfull_message() {
        isElementPresent(pages.dashboardPage().updateSuccessMessageText);
    }
    @Then("User verifies they see the updated data")
    public void user_verifies_they_see_the_updated_data() {

      assertTrue(pages.dashboardPage().nameList.stream().anyMatch(t-> t.getText().equals(updatedEventName)));
      assertTrue(pages.dashboardPage().descriptionList.stream().anyMatch(t-> t.getText().equals(updatedDescName)));

    }
}
