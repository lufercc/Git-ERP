@Employee
Feature: Employee
  @tagsrefactor
  Scenario: CLD-36448:Verify that a new employee is created
    Given I navigate to odoo login page
    When I login with "adminodoo" odoo credentials
    And I go to "employees" hhrr submenu
    And I press "create" general button
    And I modify the employee with basic data
      | firstName   | lastName    |
      | testEmployee| Automation  |

    And I modify the employee with personal data
      | nationalOrForeign | idNumber | idExpDate  | idPlace |
      | National          | 6541512  | 02/22/2017 | CBA     |

    And I add this tag data to employee form
      | name          |
      | media jornada |
      | test          |
      | test2         |
    And I delete this tag data to employee form
      | name          |
      | test2         |
    And I add this nationality data to employee form
      | name   |
      | China  |
      | France |
      | Fiji   |
    And I delete this nationality data to employee form
      | name |
      | Fiji |
    And I add this holiday policies data to employee form
      | name               |
      | Bolivian Labor Law |
    And I press "save" general button
    Then I verify if he has this tag data
      | name          |
      | media jornada |
      | test          |
    And I verify if he has this nationality data
      | name   |
      | China  |
      | France |
    And I verify if he has this holiday policies data
      | name               |
      | Bolivian Labor Law |
