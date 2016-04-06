@Employee
Feature: Do not edit supervised employees

  @NoReadEmployeeInformation @all @CRUD
  Scenario Outline: Verify that supervised employee fields are not read with lead role
    Given I navigate to login page
    And I login with "<role>" credentials
    And I go to "employees" hhrr submenu
    And I select "list" view
    And I search employee "auto employee hr" into employee list view
    And I verify if he is not able to go to "history" employee tab

    Examples:
      | role         |
      | receptionist |
