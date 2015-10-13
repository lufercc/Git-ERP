@UserLogin
Feature: Login to ERP Portal
    
  @ValidLogin
  Scenario: Valid user login
    Given I navigate to login page
    When I login with "valid" credentials
    Then Not error message is displayed
    And I am on the home page