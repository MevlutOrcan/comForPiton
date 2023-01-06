@Loginmodule
Feature: Login Module

  @LTC01
  Scenario: TC01 User should see login form if not authenticated.
  Login Form should contain username password and login button
    Given User goes to "URL"
    Then  User verifies they see the Event Manager Login Text
    And   User verifies they see the Username TextBox
    And   User verifies they see the Password TextBox
    And   User verifies they see the Login Button
    And   User closes driver

  @LTC02
  Scenario: TC02 – User should see validation errors if click the login button without
  fill the login form
    Given User goes to "URL"
    Then  User verifies they see the Event Manager Login Text
    And   User clicks to Login Button
    Then  User verifies they see the Validation Error Messages
    And   User closes driver

  @LTC03
  Scenario: TC03 User should navigate to the dashboard and see welcome
  message if authenticate successfully
    Given User goes to "URL"
    Then  User verifies they see the Event Manager Login Text
    When  User sends valid "UserName" to username text box
    And   User sends valid "Password" to password text box
    And   User clicks to Login Button
    Then  User verifies they see the welcome message
    When  User clears all cookies
    And   User closes driver