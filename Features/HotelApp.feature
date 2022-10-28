Feature: HotelApp login
  Description: This test is to check the login functionality of the HotelApp

  Background: User is logged in
    Given User is on HotelApp homepage
    When User enters username
    And User enters password
    And User clicks on login button

  Scenario: Search hotel
    When User selects location from dropdown
    And User clicks on search button
    Then List of hotels is displayed
