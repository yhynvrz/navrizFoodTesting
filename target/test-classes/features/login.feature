
@login
Feature: User should be able to login

  Background:
    Given the user is on the login page

  @driver  @smoke
  Scenario: Login as a Driver
    When the user entres the Driver information
    Then the user should be able to login


    @salesmanager
    Scenario: Login as a Salesmanager
      When The user enters the Salesmanager information
      Then the user should be able to login


    @storesmanager @smoke
    Scenario: Login as a Store manager
    When The user enters the Store manager information
    Then the user should be able to login