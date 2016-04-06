@Employee
Feature: Do not edit My own Information
  @NoEditEmployeeMyInformation @MyInformation @all @CRUD
  Scenario Outline: Verify that I can not edit my own employee information when I belong to Read Information group
  Given I navigate to login page
    When I login with "<role>" credentials
    And I go to "my information" hhrr submenu
    And I search employee "<employee name>" into employee list view
  Then I am not able to press "edit" general button

  Examples:
    | role            | employee name        |
    | employee        | auto employee hr     |
    | common officer  | auto comofficer hr   |
    | hd officer      | auto hdofficer hr    |
    | receptionist    | auto receptionist hr |
    | reports         | auto reports hr      |
    | lead            | auto lead hr         |
    | manager         | auto manager hr      |
    | personnel admin | auto personnel hr    |
    | officer         | auto officer hr      |
