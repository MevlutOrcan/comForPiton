package stepDefinitions;

import io.cucumber.java.en.*;
import pages.Pages;
import utilities.ConfigReader;
import utilities.Driver;

import static org.junit.Assert.*;
import static utilities.ReusableMethods.*;

public class LoginStepDefs {
    Pages pages=new Pages();
    @Given("User goes to {string}")
    public void user_goes_to(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
    }
    @Then("User verifies they see the Event Manager Login Text")
    public void user_verifies_they_see_the_event_manager_login_text() {
       assertTrue(pages.loginPage().eventManagerLoginText.isDisplayed());
    }
    @Then("User verifies they see the Username TextBox")
    public void user_verifies_they_see_the_username_text_box() {
        assertTrue(pages.loginPage().userNameTextBox.isDisplayed());
    }
    @Then("User verifies they see the Password TextBox")
    public void user_verifies_they_see_the_password_text_box() {
        assertTrue(pages.loginPage().passwordTextBox.isDisplayed());
    }
    @Then("User verifies they see the Login Button")
    public void user_verifies_they_see_the_login_button() {
        assertTrue(pages.loginPage().loginButton.isDisplayed());
    }
    @Then("User clicks to Login Button")
    public void user_clicks_to_login_button() {
        clickElement(pages.loginPage().loginButton);

    }
    @Given("User does Happy Path Login")
    public void user_does_happy_path_login() {
        user_goes_to("URL");
        user_sends_valid_to_username_text_box("UserName");
        user_sends_valid_to_password_text_box("Password");
        user_clicks_to_login_button();
    }
    @Then("User verifies they see the Validation Error Messages")
    public void user_verifies_they_see_the_validation_error_messages() {
        isElementPresent(pages.loginPage().usernameRequiredMessageText);
        isElementPresent(pages.loginPage().passwordRequiredMessageText);

    }
    @When("User sends valid {string} to username text box")
    public void user_sends_valid_to_username_text_box(String username) {
        enterKeys(pages.loginPage().userNameTextBox,ConfigReader.getProperty(username));
    }
    @When("User sends valid {string} to password text box")
    public void user_sends_valid_to_password_text_box(String password) {
        enterKeys(pages.loginPage().passwordTextBox,ConfigReader.getProperty(password));
    }
    @Then("User verifies they see the welcome message")
    public void user_verifies_they_see_the_welcome_message() {
        isElementPresent(pages.dashboardPage().welcomeMessageText);
    }
    @When("User clears all cookies")
    public void user_clears_all_cookies() {
      Driver.getDriver().manage().deleteAllCookies();
    }
    @When("User closes driver")
    public void user_closes_driver() {
       Driver.quitDriver();
    }


}
