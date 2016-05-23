@Accounting
Feature: OdooTest
  @TestLoginOdoo
  Scenario: Verify login
    Given I navigate to odoo login page
    When I login with "user test" odoo credentials
    And I go to "employees" hhrr submenu
    And I press "create" general button
    And I modify the employee with basic data
      | fullName      |
      | test employee |
    And I modify the employee with public data
      | workEmail        | workPhone     | workMobile    |
      | test@hotmail.com | 456-158-15532 | 707-642-51545 |
    And I press "save" general button

  @OdooStepsRefactor
  Scenario: Verify login
    Given I navigate to odoo login page
    When I login with "user test" odoo credentials
    And I go to "employees" hhrr submenu
    And I press "create" general button
    And I modify the employee with basic data
      | fullName      |
      | test employee |
    And I modify the employee with public data
      | workEmail        | workPhone     | workMobile    |
      | test@hotmail.com | 456-158-15532 | 707-642-51545 |
    And I press "save" general button
    And I verify if he has this data in public information
      | workEmail        | workPhone     | workMobile    |
      | test@hotmail.com | 456-158-15532 | 707-642-51545 |

    And remove this "test employee" employee via api with this credentials "user test"
    And create employee via api with this credentials "user test"
      | name | test employeeAPI |
    And create employee with random name via api with this credentials "user test"

