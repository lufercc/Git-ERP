@Employee
Feature: Employee
  @testhr
  Scenario: Verify that an asset is assigned if the asset is created manually
    Given I navigate to login page
    When I login with "admin" credentials
    And I go to "employees" hhrr submenu
    And I press "create" general button
    And I modify the employee with basic data
      | name    |
      | JSss    |
    And I logout
  @readMyInformation
  Scenario: Verify that an asset is assigned if the asset is created manually
    Given I navigate to login page
    When I login with "admin" credentials
    And I go to "employees" hhrr submenu
    And I select "list" view
    And I search employee "jsread Employee Vargas Ochoa" into employee list view
    And I verify if he has this data in basic information
      | fullName                     |
      | jsread Employee Vargas Ochoa |

    And I verify if he has this nationality data
      | name    | code |
      | Bolivia | BO   |

    And I verify if he has this nda data
      | ndaVersion  | signDate   |
      | Versión 2   | 02/04/2016 |
      | Versión 1-A | 02/01/2016 |
      | Versión 3   | 02/11/2016 |

    And I verify if he has this emergency contact data
      | name       | relationship | phone    | mobile    |
      | Dark Vader | Padre        | 40-00000 | 797-00000 |
    And I verify if he has this family data
      | name | lastName | relation | sex    | birthDate  |
      | Dark | Potato   | Hijo     | Hombre | 02/12/1986 |
    And I verify if he has this external career data
      | name | startDate  | endDate    | employeer |
      | xde  | 02/03/2016 | 02/04/2016 | asd       |
    And I verify if he has this internal career data
      | department | division  | name    | projectCode | weight | startDate  | endDate    | employeer |
      | department | division  | name    | projectCode | weight | startDate  | endDate    | employeer |
    And I logout