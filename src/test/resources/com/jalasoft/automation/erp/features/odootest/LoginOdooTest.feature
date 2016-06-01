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

  @OdooStepsRefactorEmployee
  Scenario: CLD-36420:Verify that a new employee with only mandatory fields is created
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

    And I press "save" general button
    And I verify if he has this data in basic information
      | firstName   | lastName    |
      | testEmployee| Automation  |

    And remove this "test employee" employee via api with this credentials "adminodoo"
    And create employee via api with this credentials "adminodoo"
      | name | test employeeAPI |
    And create employee with random name via api with this credentials "adminodoo"

  @OdooStepsRefactor
  Scenario: CLD-36448:Verify that a new employee is created
    Given I navigate to odoo login page
    When I login with "adminodoo" odoo credentials
    And I go to "employees" hhrr submenu
    And I press "create" general button
    And I modify the employee with basic data
      | firstName | middleName | lastName   | secondLastName | marriedName |
      | testEmplo | js         | Automation | hr             | none        |

    And I modify the employee with public data
      | address | workEmail        | workPhone     | extCode | workMobile    | city       | location | country | otherInfo  |
      | ABILA   | test@hotmail.com | 456-158-15532 | 12      | 707-642-51545 | Cochabamba | 0F       | Bolivia | Other info |

    And I modify the employee with personal data
      | nationalOrForeign | idNumber | idExpDate  | idPlace | passportNumber | passportPlace | passportExpDate | hasVisa | homeAddress  | dateBirth  | country | city     |
      | National          | 6541512  | 02/22/2017 | CBA     | 4564215        | Angola        | 02/20/2019      | false   | Administrator| 02/12/1986 | Albania | SomeCity |

    And I modify the employee with hhrr data
      | gender | maritalStatus | numberChildren | hireDate   | workingSchedule  | holidayGroup           | vacationAnniversary | internalID |
      | Male   | Single        | 3              | 01/04/2016 | Recursos humanos | Jala Bolivian Holidays | 02/04/2016          | 654818     |

    And I modify the employee with engineering data
      | department | division    | jobTitle | manager        | consultant |
      | Sales      | Outsourcing | Security | Auto S Manager | true       |

    And I add this family data to employee form
      | name | lastName | relation | sex    | birthDate  |
      | Dark | Potato   | Son      | Male   | 02/12/1986 |

    And I add this external career data to employee form
      | jobTitle | startDate  | endDate    | employer |
      | xde      | 02/03/2016 | 02/04/2016 | asd      |

    And I add this tag data to employee form
      | name          |
      | media jornada |

    And I press "save" general button