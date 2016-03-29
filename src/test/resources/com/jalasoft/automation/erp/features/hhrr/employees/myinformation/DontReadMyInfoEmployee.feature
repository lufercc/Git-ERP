@Employee
Feature: Do not read my information

  @DontReadMyInformation @all @CRUD
  Scenario Outline: Verify that hhrr fields are not read with these roles
    Given I navigate to login page
    When I login with "<role>" credentials
    And I go to "my information" hhrr submenu
    And I select "list" view
    And I search employee "<employee name>" into employee list view
    And I verify no one of these fields are read in hhrr information
    | endHireDate |
    | 01/04/2017  |
    Examples:
      | role            | employee name        |
      | manager         | auto manager hr      |
      | lead            | auto lead hr         |
      | employee        | auto employee hr     |
      | officer         | auto officer hr      |
      | common officer  | auto comofficer hr   |
      | hd officer      | auto hdofficer hr    |
      | reports         | auto reports hr      |
      | receptionist    | auto receptionist hr |
      | personnel admin | auto personnel hr    |

  @DontReadMyInformation @all @CRUD @thos
  Scenario Outline: Verify that hhrr fields are not read with these roles
    Given I navigate to login page
    When I login with "<role>" credentials
    And I go to "my information" hhrr submenu
    And I select "list" view
    And I search employee "<employee name>" into employee list view
    And I verify no one of these fields are read in engineering information
      | visible | billable | shadowCategory | notes |
      | true    | true     | Risk           | dwe   |
    Examples:
      | role            | employee name        |
      | manager         | auto manager hr      |
      | lead            | auto lead hr         |
      | employee        | auto employee hr     |
      | officer         | auto officer hr      |
      | common officer  | auto comofficer hr   |
      | hd officer      | auto hdofficer hr    |
      | reports         | auto reports hr      |
      | receptionist    | auto receptionist hr |
      | personnel admin | auto personnel hr    |

  @DontReadMyInformation @all @CRUD
  Scenario Outline: Verify that hhrr fields are not read with these roles
    Given I navigate to login page
    When I login with "<role>" credentials
    And I go to "my information" hhrr submenu
    And I select "list" view
    And I search employee "<employee name>" into employee list view
    And I verify if he has not this simple data in engineering information
      | visible | billable | shadowCategory | notes |
      | true    | true     | Risk           | dwe   |
    Examples:
      | role            | employee name        |
      | admin           | auto admin hr        |
      | staffing        | auto staffing hr     |
      | sr manager      | auto srmanager hr    |