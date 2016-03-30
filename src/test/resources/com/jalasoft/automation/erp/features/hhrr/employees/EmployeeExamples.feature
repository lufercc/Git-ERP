@Employee
Feature: Employee
  @TestCreateAndEditEmployeeInformation @all
  Scenario: Verify that employee fields are edited with admin role
    Given I navigate to login page
    When I login with "admin" credentials
    And I go to "employees" hhrr submenu
    And I press "create" general button
    And I modify the employee with basic data
      | firstName | firstNameCheck | middleName | middleNameCheck | lastName | secondLastName | marriedName |
      | JSss      | true           | ewed       | false           | eww      | rrrr           | ttgt        |

    And I modify the employee with public data
      | address | workEmail        | workPhone     | extCode | workMobile    | codeDesktop | city       | user     | location | country | otherInfo  |
      | ABILA   | test@hotmail.com | 456-158-15532 | 12      | 707-642-51545 | A224        | Cochabamba | Henry56  | 0F       | Bolivia | other info |

    And I modify the employee with personal data
      | nationalOrForeign | idNumber | idExpDate  | idPlace | passportNumber | passportPlace | passportExpDate | hasVisa | visaType                       | visaExpDate | homeAddress | dateBirth  | country | city     |
      | National          | 6541512  | 02/22/2017 | CBA     | 4564215        | Angola        | 02/20/2019      | true    | Business and Tourism (B-1/B-2) | 02/20/2019  | Henry56     | 02/12/1986 | Albania | SomeCity |

    And I modify the employee with hhrr data
      | gender | maritalStatus | numberChildren | startDate  | endDate    | hireDate   | endHireDate | salaryReviewMonth | workingSchedule  | holidayGroup           | vacationAnniversary | internalID |
      | Male   | Cohabiting    | 5              | 02/19/2015 | 02/01/2016 | 01/04/2016 | 01/04/2017  | January           | Recursos humanos | Jala Bolivian Holidays | 02/04/2016          | 654818     |

    And I modify the employee with engineering data
      | department | division | jobTitle | manager         | lead         | visible | billable | shadowCategory | notes | commitment | active | consultant | jce   | reason | lastEvalDate | nextEvalDate |
      | IT         | Support  | Security | auto manager hr | auto lead hr | false   | true     | Risk           | dwe   | false      | true   | true       | false | ders   | 02/03/2016   | 02/03/2017   |

    And I add this nda data to employee form
      | ndaVersion  | signDate   |
      | Version 2   | 02/04/2016 |
      | Version 1-A | 02/01/2016 |
      | Version 3   | 02/11/2016 |

    And I delete this nda data from employee form
      | ndaVersion  | signDate   |
      | Version 1-A | 02/01/2016 |

    And I add this emergency contact data to employee form
      | name       | relationship | phone    | mobile    |
      | Dark Vader | Padre        | 40-00000 | 797-00000 |

    And I delete this emergency contact data to employee form
      | name       | relationship | phone    | mobile    |
      | Dark Vader | Padre        | 40-00000 | 797-00000 |

    And I delete this emergency contact data to employee form
      | name       | relationship | phone    | mobile    |
      | Dark Vader | Padre        | 40-00000 | 797-00000 |

    And I add this family data to employee form
      | name | lastName | relation | sex    | birthDate  |
      | Dark | Potato   | Son      | Male   | 02/12/1986 |

    And I add this external career data to employee form
      | jobTitle | startDate  | endDate    | employer |
      | xde      | 02/03/2016 | 02/04/2016 | asd      |
      | fsss     | 03/03/2018 | 02/04/2020 | ddd      |

    And I add this internal career data to employee form
      | department | division | jobTitle | projectCode   | manager         | lead         | weight | startDate  | endDate    | employer | description |
      | IT         | Support  | Security | TESTPROJABILA | auto manager hr | auto lead hr | 6      | 02/10/2016 | 02/20/2018 | Other    | description |

    And I delete this internal career data to employee form
      | department | division | jobTitle | projectCode | weight | startDate  | endDate    | employer |
      | IT         | Support  | Security | TPA         | 6      | 02/10/2016 | 02/20/2018 | Other    |

    And I add this nationality data to employee form
      | name  |
      | Ghana |

    And I delete this nationality data to employee form
      | name    | code |
      | Bolivia | BO   |

    And I add this tag data to employee form
      | name          |
      | media jornada |
      | dev training  |

    And I delete this tag data to employee form
      | name         |
      | dev training |

    And I add this holiday policies data to employee form
      | name               |
      | Bolivian Labor Law |

    And I delete this holiday policies data to employee form
      | name               |
      | Bolivian Labor Law |

    And I add this other supervisors data to employee form
      | name              |
      | auto srmanager hr |

    And I delete this other supervisors data to employee form
      | name              |
      | auto srmanager hr |

    And I press "save" general button


  @TestReadEmployeeInformation @all
  Scenario Outline: Verify that employee fields are read with admin role
    Given I navigate to login page
    When I login with "<role>" credentials
    And I go to "employees" hhrr submenu
    And I select "list" view
    And I search employee "auto employee hr" into employee list view
    And I verify if he has this data in basic information
      | fullName                     |
      | auto employee hr |

    And I verify if he has this data in public information
      | address | workEmail        | workPhone     | extCode | workMobile    | user     | otherInfo  | location | codeDesktop | country | city       |
      | ABILA   | test@hotmail.com | 456-158-15532 | 12      | 707-642-51545 | Henry56  | Other info | 0F       | A224        | Bolivia | Cochabamba |

    And I verify if he has this simple data in personal information
      | nationalOrForeign | idNumber | idExpDate  | idPlace | passportNumber | passportPlace | passportExpDate | hasVisa | visaType                       | visaExpDate | homeAddress | dateBirth  | age | country | city     |
      | National          | 6541512  | 02/22/2017 | CBA     | 4564215        | Angola        | 02/20/2019      | true    | Business and Tourism (B-1/B-2) | 02/20/2019  | Henry56     | 02/12/1986 | 30  | Albania | SomeCity |

    And I verify if he has this simple data in hrdata information
      | gender | maritalStatus | numberChildren | startDate  | endDate    | hireDate   | endHireDate | salaryReviewMonth | workingSchedule  | holidayGroup           | vacationAnniversary | internalID |
      | Male   | Cohabiting    | 5              | 02/19/2015 | 02/01/2016 | 01/04/2016 | 01/04/2017  | January           | Recursos humanos | Jala Bolivian Holidays | 02/04/2016          | 654818     |

    And I verify if he has this simple data in engineering information
      | department | division | jobTitle | manager         | lead         | visible | billable | shadowCategory | notes | commitment | expDateCommit | active | consultant | jce   | reason | lastEvalDate | nextEvalDate |
      | IT         | Support  | Security | auto manager hr | auto lead hr | false   | true     | Risk           | dwe   | true       | 02/03/2016    | true   | true       | false | ders   | 02/03/2016   | 02/03/2017   |

    And I verify if he has this nationality data
      | name    | code |
      | Bolivia | BO   |

    And I verify if he has this nda data
      | ndaVersion  | signDate   |
      | Version 2   | 02/04/2016 |
      | Version 3   | 02/11/2016 |

    And I verify if he has this emergency contact data
      | name       | relationship | phone    | mobile    |
      | Dark Vader | Padre        | 40-00000 | 797-00000 |

    And I verify if he has this family data
      | name | lastName | relation | sex    | birthDate  |
      | Dark | Potato   | Son     | Male | 02/12/1986 |

    And I verify if he has this external career data
      | jobTitle | startDate  | endDate    | employer |
      | xde      | 02/03/2016 | 02/04/2016 | asd      |

    And I verify if he has this project data
      | code |
      | TPA  |

    And I verify if he has this internal career data
      | department | division | jobTitle | projectCode | weight | startDate  | endDate    | employer |
      | IT         | Support  | Security | TPA         | 6      | 02/10/2016 | 02/20/2018 | Other    |

    And I verify if he has this tag data
      | name          |
      | media jornada |

    And I verify if he has this holiday policies data
      | name               |
      | Bolivian Labor Law |

    And I verify if he has this other supervisors data
      | name              |
      | auto srmanager hr |
    Examples:
      | role    |
      | admin   |

  @outline @all
  Scenario Outline: Verify that employee fields are read with admin role
    Given I navigate to login page
    When I login with "<role>" credentials
    And I go to "employees" hhrr submenu

    Examples:
      | role    |
      | admin   |
      | officer |

  @DeleteEmployee @all
  Scenario: Verify that employee fields are read with admin role
    Given I navigate to login page
    When I login with "admin" credentials
    And I go to "employees" hhrr submenu
    And I select "list" view
    And I search employee "JSss eww rrrr" into employee list view
    And I press "delete" general button

  @BrowseToMyInformation @all
  Scenario: Verify that employee fields are read with admin role
    Given I navigate to login page
    When I login with "employee" credentials
    And I go to "my information" hhrr submenu
    And I search employee "jsread Employee Vargas Ochoa" into employee list view
    And I verify if he has this data in basic information
      | fullName                     |
      | jsread Employee Vargas Ochoa |

  @UpdateLocalizationData @all
  Scenario Outline: Verify that localization fields are able to be edited with granted roles
    Given I navigate to login page

    When I login with "admin" credentials
    And I create an employee with required fields
      | firstName | lastName          | idNumber | manager        | lead        |
      | luke      | skywalker<number> | 6454215  | autojs manager | jslead otro |
    And I logout
    And I login with "<role>" credentials
    And I go to "employees" hhrr submenu
    And I select "list" view
    And I search employee "luke skywalker<number>" into employee list view
    And I press "edit" general button
    And I modify the employee with public data
      | workEmail        | workPhone     | workMobile    | codeDesktop | city       | location | country | otherInfo  |
      | test@hotmail.com | 456-158-15532 | 707-642-51545 | A224        | Cochabamba | 0F       | Bolivia | other info |
    And I press "save" general button
    And I verify if he has this data in public information
      | workEmail        | workPhone     | workMobile    | codeDesktop | city       | location | country | otherInfo  |
      | test@hotmail.com | 456-158-15532 | 707-642-51545 | A224        | Cochabamba | 0F       | Bolivia | other info |

    Examples:
      | number | role            |
      | oneu   | admin           |
      | twou   | sr manager      |
      | threeu | manager         |
      | fouru  | lead            |
      | fiveu  | officer         |
      | sixu   | personnel admin |


  @ReadLocalizationData @all
  Scenario Outline: Verify that localization fields are able to be edited with granted roles
    Given I navigate to login page
    And I login with "<role>" credentials
    And I go to "employees" hhrr submenu
    And I select "list" view
    And I search employee "jsread Employee Vargas Ochoa" into employee list view
    And I verify if he has this data in public information
      | workEmail        | workPhone     | workMobile    | codeDesktop | city       | location | country | otherInfo  |
      | test@hotmail.com | 456-158-15532 | 707-642-51545 | A224        | Cochabamba | 0F       | Bolivia | Other info |

    Examples:
      | role            |
      | hd officer      |

  @CreateEmployeeWithRequiredFields @all
  Scenario Outline: Verify that localization fields are able to be edited with granted roles
    Given I navigate to login page
    When I login with "<role>" credentials
    And I create an employee with required fields
      | firstName | lastName  | idNumber | manager        |
      | luke      | skywalker | 6454215  | autojs manager |
      | anaki     | skywalker | 6454216  | autojs manager |

    Examples:
      | role    |
      | admin   |

  @TestNot @all
  Scenario: Verify that localization fields are able to be edited with granted roles
    Given I navigate to login page
    And I login with "admin" credentials
    And I do not something

  @TestReadEngEmployeeInformation @all
  Scenario: Verify that employee fields are read with admin role
    Given I navigate to login page
    When I login with "admin" credentials
    And I go to "employees" hhrr submenu
    And I select "list" view
    And I search employee "jsread Employee Vargas Ochoa" into employee list view
    And I verify if he has this simple data in engineering information
      | department | division | jobTitle | manager        | lead        | visible | billable | shadowCategory | notes | commitment | active | consultant | jce   | reason | lastEvalDate | nextEvalDate |
      | IT         | Support  | Security | autojs manager | jslead otro | false   | true     | Risk           | dwe   | false      | true   | true       | false | ders   | 02/03/2016   | 02/03/2017   |


  @TestReadEngEmployeeInformation @all
  Scenario: Verify that employee fields are read with admin role
    Given I navigate to login page
    When I login with "receptionist" credentials
    And I go to "employees" hhrr submenu
    And I select "list" view
    And I search employee "jsread Employee Vargas Ochoa" into employee list view
    And I verify if he has this simple data in engineering information
      | department | division | jobTitle | manager        | lead        | visible | billable | shadowCategory | notes | commitment | active | consultant | jce   | reason | lastEvalDate | nextEvalDate |
      | IT         | Support  | Security | autojs manager | jslead otro | false   | false    |                |       | false      | true   | true       | false | ders   | 02/03/2016   | 02/03/2017   |


  @TestNotFoundInTable
  Scenario Outline: Verify that employee fields are read with admin role
    Given I navigate to login page
    When I login with "<role>" credentials
    And I go to "employees" hhrr submenu
    And I select "list" view
    And I search employee "auto non edit" into employee list view
    Then I verify if he has this internal career data
      | department | division | jobTitle     | projectCode | weight | startDate  | endDate    | employer |
      | IT         | Support  | Security     | TPA         | 6      | 02/10/2016 | 02/20/2018 | Other    |
      | QE         | Security | Tech support | TPO         | 5      | 03/10/2016 | 03/20/2018 | Other emp|
      | SELOG      |          | Technician   |             | 0      | 02/20/2016 |            |          |

    Then I verify if he has not this internal career data
      | department | division | jobTitle   | projectCode | weight | startDate  | endDate    | employer |
      | IT         | Support  | Security   | TPAS        | 6      | 02/10/2016 | 02/20/2018 | Other    |
      | QE         | Support  | Security   | TPAS        | 5      | 02/10/2016 | 02/20/2018 | Other    |
    Examples:
      | role    |
      | admin   |

