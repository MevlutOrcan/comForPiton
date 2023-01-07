@DashBoardModule
Feature: Dashboard Module

  @DTC01 @Positive
  Scenario: TC01 User should view dashboard if authenticated
    Given User does Happy Path Login
    And User goes to "https://e2e-assessment.piton.com.tr/dashboard" directly
    Then User verifies the url including "dashboard"
    When User closes driver

  @DTC02 @Negative
  Scenario: TC02 User should redirect to login page if not authenticated
    Given User goes to "https://e2e-assessment.piton.com.tr/dashboard" directly
    Then User verifies they see the Event Manager Login Text
    When User closes driver

  @DTC03 @Positive
  Scenario: TC03 User should view list of events if any event created
  otherwise user should view notification message states no registered event found
    Given User does Happy Path Login
    Then User verifies there is an event list or no registered event found messages
    When User closes driver

  @DTC04 @Positive
  Scenario: TC04  User should be able navigate edit event when click the edit event button
    Given User does Happy Path Login
    And User creates an event
    And User clicks Edit Button
    Then User verifies the url including "edit-event"
    When User closes driver


  @DTC05 @Positive
  Scenario: TC05  User should be able to delete event when click the delete button
    Given User does Happy Path Login
    And User creates an event
    Given User cliks Delete button on the Dashboard Page
    Then User verifies event numbers deccreased
    When User closes driver

  @DTC06 @Positive
  Scenario: TC06  User should be able to view event participants
    Given User does Happy Path Login
    And User creates an event
    Given User cliks to participant icon
    Then User verifies they see the participants list
    When User closes driver
