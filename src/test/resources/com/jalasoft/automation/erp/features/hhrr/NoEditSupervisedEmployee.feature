@Employee
Feature: Edit supervised employees
  @NoEditEmployeeInformation @CRUD @all
  Scenario Outline: Verify that employee fields are edited with admin role
    Given I navigate to login page
      And I login with "admin" credentials
    When I create an employee with required fields
      | firstName | lastName       | idNumber | manager         | lead         |
      | auto      | noedit<number> | 6454215  | auto manager hr | auto lead hr |
      And I logout
      And I login with "<role>" credentials
      And I go to "employees" hhrr submenu
      And I select "list" view
      And I search employee "auto noedit<number>" into employee list view
      And I am not able to press "edit" general button
    Examples:
      | number | role           |
      | one    | reports        |
      | two    | receptionist   |
      | three  | common officer |
      | four   | hd officer     |

  @NoEditEmployeeInformationNow @CRUD @all
  Scenario Outline: Verify that employee fields are edited with admin role
    Given I navigate to login page
      And I login with "admin" credentials
    When I create an employee with required fields
      | firstName | lastName       | idNumber | manager         | lead         |
      | auto      | noedit<number> | 6454215  | auto manager hr | auto lead hr |
    And I logout
    And I login with "<role>" credentials
    And I go to "employees" hhrr submenu
    And I select "list" view
    And I search employee "auto noedit<number>" into employee list view
    And I press "edit" general button
    When I modify the employee with public data
      | address |
      | ABILA   |
    And I modify the employee with personal data
      | age |
      | 26  |

    And I press "save" general button
    And I logout
    And I login with "admin" credentials
    And I go to "employees" hhrr submenu
    And I select "list" view
    And I search employee "auto noedit<number>" into employee list view
    Then I verify if he has not this data in public information
      | address |
      | ABILA   |
    Then I verify if he has not this simple data in personal information
      | age |
      | 26  |

    Examples:
      | number  | role |
      | five    | lead |

