@EventModule
Feature: Event Module

  @ETC01
  Scenario: TC01 User should view create event form if click the Create Event
  button on dashboard
    Given User does Happy Path Login
    When  User clicks Create Event Buttom
    Then  User verifies they see the Event Form
    And User closes driver

  @ETC02
  Scenario: TC02 User should view validation errors if click the Create Event button
  without fill the event form
    Given User does Happy Path Login
    When  User clicks Create Event Buttom
    And   User clicks Create New Event Button
    Then  User verifies error messages
    And   User closes driver

  @ETC03
  Scenario: TC03 User should be able to add new participant when click the Add
  Participant button
    Given User does Happy Path Login
    And  User clicks Create Event Buttom
    When User clicks Add Participant button
    Then User verifies the participants number increases
    And   User closes driver


  @ETC04
  Scenario: TC04 User should view error message if removes all participants
    Given User does Happy Path Login
    And  User clicks Create Event Buttom
    When User cliks Delete Participant Button
    Then User verifies they see the Please Add Participant text
    And   User closes driver

  @ETC05
  Scenario: TC05 User should be able to create new event if fills all required fields
  and redirect to dashboard page with create successful message
    Given User does Happy Path Login
    And  User clicks Create Event Buttom
    When User fills it up the form "eventName" "eventDesc" "eventDate" "firstName" "lastName" "contact"
    And  User clicks Create New Event Button
    Then Use verifies they see successfull message
    And   User closes driver

  @ETC06
  Scenario: TC06 User should be able to edit event. When user click the edit
  button all event fields must be filled according to editing event
    Given User does Happy Path Login
    And  User clicks Create Event Buttom
    When User fills it up the form "eventName" "eventDesc" "eventDate" "firstName" "lastName" "contact"
    And  User clicks Create New Event Button
    When User clicks Edit Button
    And  User edit it up the all form fields "UpdatedEventName" "UpdatedEventDesc" "UpdatedEventDate" "UpdatedfirstName" "UpdatedlastName" "Updatedcontact"
    Then User verifies all form fields are updated
    And   User closes driver

  @ETC07
  Scenario: TC07 User should be able to update event if required fields filled and
  redirect to dashboard page with update successful message
    Given User does Happy Path Login
    And  User clicks Create Event Buttom
    When User fills it up the form "eventName" "eventDesc" "eventDate" "firstName" "lastName" "contact"
    And  User clicks Create New Event Button
    When User clicks Edit Button
    And  User edit it up the all form fields "UpdatedEventName" "UpdatedEventDesc" "UpdatedEventDate" "UpdatedfirstName" "UpdatedlastName" "Updatedcontact"
    And  User clicks Update Event Button
    Then  User verifies Update Successfull Message
    And User verifies they see the updated data
    When User clears all cookies
    And User closes driver