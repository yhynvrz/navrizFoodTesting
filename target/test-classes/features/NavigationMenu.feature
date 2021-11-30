
@navigate
Feature: Logged in sales manager should be able to navigate to pages using the top menu. Once in the expected page, user should see correct page Title.


  Scenario: As logged in sales manager i should be able to navigate to Fleet and then Vehicles
    Given Logged in as sales manager on the page
    When  User moves to Fleet option in the top menu
    And Click to Vehicles option
    Then Title of page should be changed to Vehicles


  Scenario: As logged in sales manager i should be able to navigate to Marketing and then Campaigns
    Given Logged in as sales manager on the page
    When  User moves to Marketing option in the top menu
    And Click to Campaigns option
    Then Title of page should be changed to Campaigns

