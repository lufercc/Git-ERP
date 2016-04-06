@Employee
Feature: Do not edit supervised employees

  @NoEditEmployeeInformation @all @CRUD
  Scenario Outline: Verify that supervised employee fields are not edited with lead role
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
    And I modify the employee with basic data
      | preferredName |
      | OtherName     |
    And I add this tag data to employee form
      | name      |
      | full time |
    And I modify the employee with public data
      | address   | user     |
      | Careflash | Henry56  |
    And I modify the employee with personal data
      | age |
      | 777 |
    And I add this project data to employee form
      | code |
      | HBH  |
    And I modify the employee with engineering data
      | manager       | lead              | visible | billable | shadowCategory | notes |
      | auto admin hr | auto srmanager hr | true    | true     | Risk           | dwe   |
    And I add this other supervisors data to employee form
      | name            |
      | auto manager hr |

    And I press "save" general button
    And I verify if he has not this data in basic information
      | fullName  |
      | OtherName |
    And I verify if he has not this tag data
      | name      |
      | full time |
    And I verify if he has not this data in public information
      | address   | user     |
      | Careflash | Henry56  |
    And I verify if he has not this simple data in personal information
      | age |
      | 777 |
    And I verify if he has not this simple data in engineering information
      | manager       | lead              | visible | billable | shadowCategory | notes |
      | auto admin hr | auto srmanager hr | true    | true     | Risk           | dwe   |
    And I verify if he has not this other supervisors data
      | name            |
      | auto manager hr |
    And I verify if he has not this project data
      | code |
      | HBH  |

    Examples:
      | number | role |
      | seven  | lead |

  @NoEditEmployeeInformation @all @CRUD
  Scenario Outline: Verify that supervised employee fields are not edited with manager role
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
    And I modify the employee with basic data
      | preferredName |
      | OtherName     |
    And I add this tag data to employee form
      | name      |
      | full time |
    And I modify the employee with public data
      | address   | user     |
      | Careflash | Henry56  |
    And I modify the employee with personal data
      | age |
      | 777 |
    And I add this project data to employee form
      | code |
      | HBH  |
    And I modify the employee with engineering data
      | visible | billable | shadowCategory | notes |
      | true    | true     | Risk           | dwe   |

    And I press "save" general button
    And I verify if he has not this data in basic information
      | fullName  |
      | OtherName |
    And I verify if he has not this tag data
      | name      |
      | full time |
    And I verify if he has not this data in public information
      | address   | user     |
      | Careflash | Henry56  |
    And I verify if he has not this simple data in personal information
      | age |
      | 777 |
    And I verify if he has not this simple data in engineering information
      | visible | billable | shadowCategory | notes |
      | true    | true     | Risk           | dwe   |
    And I verify if he has not this project data
      | code |
      | HBH  |

    Examples:
      | number | role       |
      | eight  | manager    |

  @NoEditEmployeeInformation @all @CRUD
  Scenario Outline: Verify that supervised employee fields are not edited with sr manager role
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
    And I modify the employee with basic data
      | preferredName |
      | OtherName     |
    And I modify the employee with public data
      | address   | user     |
      | Careflash | Henry56  |
    And I modify the employee with personal data
      | age |
      | 777 |
    And I add this project data to employee form
      | code |
      | HBH  |
    And I modify the employee with engineering data
      | visible | billable | shadowCategory | notes |
      | true    | true     | Risk           | dwe   |

    And I press "save" general button
    And I verify if he has not this data in basic information
      | fullName  |
      | OtherName |
    And I verify if he has not this data in public information
      | address   | user     |
      | Careflash | Henry56  |
    And I verify if he has not this simple data in personal information
      | age |
      | 777 |
    And I verify if he has not this simple data in engineering information
      | visible | billable | shadowCategory | notes |
      | true    | true     | Risk           | dwe   |
    And I verify if he has not this project data
      | code |
      | HBH  |

    Examples:
      | number | role       |
      | nine   | sr manager |

  @NoEditEmployeeInformation @all @CRUD
  Scenario Outline: Verify that supervised employee fields are not edited with staffing role
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
    And I modify the employee with basic data
      | preferredName |
      | OtherName     |
    And I modify the employee with public data
      | address   | user     |
      | Careflash | Henry56  |
    And I modify the employee with personal data
      | age |
      | 777 |
    And I add this project data to employee form
      | code |
      | HBH  |

    And I press "save" general button
    And I verify if he has not this data in basic information
      | fullName  |
      | OtherName |
    And I verify if he has not this data in public information
      | address   | user     |
      | Careflash | Henry56  |
    And I verify if he has not this simple data in personal information
      | age |
      | 777 |
    And I verify if he has not this project data
      | code |
      | HBH  |

    Examples:
      | number | role     |
      | ten    | staffing |

  @NoEditEmployeeInformation @all @CRUD
  Scenario Outline: Verify that supervised employee fields are not edited with hr officer role
    Bugs: HBH33[Reg] Staffing fields are hide only for html,they are editable. Removing temporary Edit action for fields related
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
    And I modify the employee with basic data
      | preferredName |
      | OtherName     |
    And I add this tag data to employee form
      | name      |
      | full time |
    And I modify the employee with public data
      | address   |
      | Careflash |
    And I modify the employee with personal data
      | age |
      | 777 |
    And I add this project data to employee form
      | code |
      | HBH  |


    And I press "save" general button
    And I verify if he has not this data in basic information
      | fullName  |
      | OtherName |
    And I verify if he has not this tag data
      | name      |
      | full time |
    And I verify if he has not this data in public information
      | address   |
      | Careflash |
    And I verify if he has not this simple data in personal information
      | age |
      | 777 |
    And I verify if he has not this simple data in engineering information
      | visible | billable | shadowCategory | notes |
      | true    | true     | Risk           | dwe   |
    And I verify if he has not this project data
      | code |
      | HBH  |

    Examples:
      | number | role    |
      | eleven | officer |

  @NoEditEmployeeInformation @all @CRUD
  Scenario Outline: Verify that supervised employee fields are not edited with personnel role
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
    And I modify the employee with basic data
      | preferredName |
      | OtherName     |
    And I add this tag data to employee form
      | name      |
      | full time |
    And I modify the employee with public data
      | address   |
      | Careflash |
    And I modify the employee with personal data
      | age |
      | 777 |
    And I add this project data to employee form
      | code |
      | HBH  |
    And I press "save" general button

    And I verify if he has not this data in basic information
      | fullName  |
      | OtherName |
    And I verify if he has not this tag data
      | name      |
      | full time |
    And I verify if he has not this data in public information
      | address   | user     |
      | Careflash | Henry56  |
    And I verify if he has not this simple data in personal information
      | age |
      | 777 |

    And I verify if he has not this project data
      | code |
      | HBH  |

    Examples:
      | number | role            |
      | twelve | personnel admin |

  @NoEditEmployeeInformation @all @CRUD
  Scenario Outline: Verify that supervised employee fields are not edited with admin role
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
    And I modify the employee with basic data
      | preferredName |
      | OtherName     |

    And I modify the employee with personal data
      | age |
      | 777 |
    And I add this project data to employee form
      | code |
      | HBH  |


    And I press "save" general button
    And I verify if he has not this data in basic information
      | fullName  |
      | OtherName |
    And I verify if he has not this simple data in personal information
      | age |
      | 777 |
    And I verify if he has not this project data
      | code |
      | HBH  |

    Examples:
      | number | role  |
      | eleven | admin |

  @NoEditEmployeeInformation @all @CRUD
  Scenario Outline: Verify that supervised employee fields are not edited with read only roles
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
    Then I am not able to press "edit" general button
    Examples:
      | number | role           |
      | one    | reports        |
      | two    | receptionist   |
      | three  | common officer |
      | four   | hd officer     |

  @NoEditEmployeeInformation @all
  Scenario: Verify that supervised employee fields are not edited with employee role
    TODO: Review exception in driver tools
    Given I navigate to login page
    When I login with "employee" credentials
    Then I am not able to go to "employees" hhrr submenu



