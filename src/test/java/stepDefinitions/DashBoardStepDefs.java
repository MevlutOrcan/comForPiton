package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import pages.Pages;
import utilities.Driver;

import static org.junit.Assert.*;
import static utilities.ReusableMethods.clickElement;
import static utilities.ReusableMethods.isElementPresent;

public class DashBoardStepDefs {
    Pages pages=new Pages();
    @Then("User verifies the text {string} on the page")
    public void user_verifies_the_text_on_the_page(String text) {
        isElementPresent(Driver.getDriver().findElement(By.xpath(text)));
    }
    @Then("User verifies the url including {string}")
    public void user_verifies_the_url_including(String dash) {
        Driver.getDriver().getCurrentUrl().contains(dash);
    }
    @Given("User goes to {string} directly")
    public void user_goes_to_directly(String url) {
      Driver.getDriver().get(url);
    }
    @Then("User verifies there is an event list or no registered event found messages")
    public void user_verifies_there_is_an_event_list_or_no_registered_event_found_messages() {
        assertTrue(pages.dashboardPage().eventList.size()+pages.dashboardPage().noRegisteredList.size()>0);

    }
    static int eventNumbersBeforeDelete;
    @Given("User cliks Delete button on the Dashboard Page")
    public void user_cliks_delete_button_on_the_dashboard_page() {
        eventNumbersBeforeDelete=pages.dashboardPage().deleteButtonOnDashBoard.size();
        clickElement(pages.dashboardPage().deleteButtonOnDashBoard.get(0));
    }
    @Then("User verifies event numbers deccreased")
    public void user_verifies_event_numbers_deccreased() {

        int eventNumbersAfterDelete=pages.dashboardPage().deleteButtonOnDashBoard.size();
        assertTrue(eventNumbersBeforeDelete>eventNumbersAfterDelete);

    }


    @Given("User cliks to participant icon")
    public void user_cliks_to_participant_icon() {
        clickElement(pages.dashboardPage().participantsButton);
    }
    @Then("User verifies they see the participants list")
    public void user_verifies_they_see_the_participants_list() throws InterruptedException {
        isElementPresent(pages.dashboardPage().participantsTable);
    }

}
