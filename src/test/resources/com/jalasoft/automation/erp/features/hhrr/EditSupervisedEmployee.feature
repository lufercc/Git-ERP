@Employee
Feature: Employee
  @EditEmployeeInformation @CRUD @all
  Scenario Outline: Verify that employee fields are edited with admin role
    Given I navigate to login page
    When I login with "admin" credentials
    And I create an employee with required fields
      | firstName | lastName     | idNumber | manager        | lead        |
      | auto      | edit<number> | 6454215  | auto manager hr | auto lead hr |
    And I logout
    And I login with "<role>" credentials
    And I go to "employees" hhrr submenu
    And I select "list" view
    And I search employee "auto edit<number>" into employee list view
    And I press "edit" general button
    And I modify the employee with basic data
      | firstName | firstNameCheck | middleName | middleNameCheck | lastName     | secondLastName | marriedName |
      | auto      | true           | js         | true            | edit<number> | emp            | none        |

    And I modify the employee with public data
      | address | workEmail        | workPhone     | extCode | workMobile    | codeDesktop | city       | user     | location | country | otherInfo  |
      | ABILA   | test@hotmail.com | 456-158-15532 | 12      | 707-642-51545 | A224        | Cochabamba | Henry56  | 0F       | Bolivia | other info |

    And I modify the employee with personal data
      | nationalOrForeign | idExpDate  | idPlace | passportNumber | passportPlace | passportExpDate | hasVisa | visaType                       | visaExpDate | homeAddress | dateBirth  | age | country | city     |
      | National          | 02/22/2017 | CBA     | 4564215        | Angola        | 02/20/2019      | true    | Business and Tourism (B-1/B-2) | 02/20/2019  | Henry56     | 02/12/1986 | 29  | Albania | SomeCity |

    And I modify the employee with hhrr data
      | gender | maritalStatus | numberChildren | startDate  | endDate    | hireDate   | endHireDate | salaryReviewMonth | workingSchedule  | holidayGroup           | vacationAnniversary | internalID |
      | Male   | Cohabiting    | 5              | 02/19/2015 | 02/01/2016 | 01/04/2016 | 01/04/2017  | January           | Recursos humanos | Jala Bolivian Holidays | 02/04/2016          | 654818     |

    And I modify the employee with engineering data
      | department | division | jobTitle | manager        | lead        | visible | billable | shadowCategory | notes | commitment | active | consultant | jce   | reason | lastEvalDate | nextEvalDate |
      | IT         | Support  | Security | auto manager hr | auto lead hr | false   | true     | Risk           | dwe   | false      | true   | true       | false | ders   | 02/03/2016   | 02/03/2017   |

    And I add this nda data to employee form
      | ndaVersion  | signDate   |
      | Version 2   | 02/04/2016 |
      | Version 3   | 02/11/2016 |

    And I delete this nda data from employee form
      | ndaVersion  | signDate   |
      | Version 1-A | 02/01/2016 |

    And I add this emergency contact data to employee form
      | name       | relationship | phone    | mobile    |
      | Dark Vader | Padre        | 40-00000 | 797-00000 |

    And I add this family data to employee form
      | name | lastName | relation | sex    | birthDate  |
      | Dark | Potato   | Son      | Male   | 02/12/1986 |

    And I add this external career data to employee form
      | name | startDate  | endDate    | employeer |
      | xde  | 02/03/2016 | 02/04/2016 | asd       |

    And I add this internal career data to employee form
      | department | division | name     | projectCode   | manager        | lead           | weight | startDate  | endDate    | employeer | description |
      | IT         | Support  | Security | TESTPROJABILA | auto manager hr | auto manager hr | 6      | 02/10/2016 | 02/20/2018 | Other     | description |

    And I add this nationality data to employee form
      | name    |
      | Albania |

    And I add this tag data to employee form
      | name          |
      | media jornada |
      | dev training  |

    And I delete this tag data to employee form
      | name          |
      | dev training  |

    And I add this holiday policies data to employee form
      | name               |
      | Bolivian Labor Law |

    And I press "save" general button

    And I verify if he has this data in basic information
      | fullName                     |
      | auto js edit<number> emp     |

    And I verify if he has this data in public information
      | address | workEmail        | workPhone     | extCode | workMobile    | user     | otherInfo  | location | codeDesktop | country | city       |
      | ABILA   | test@hotmail.com | 456-158-15532 | 12      | 707-642-51545 | Henry56  | other info | 0F       | A224        | Bolivia | Cochabamba |

    And I verify if he has this simple data in personal information
      | nationalOrForeign | idNumber | idExpDate  | idPlace | passportNumber | passportPlace | passportExpDate | hasVisa | visaType                       | visaExpDate | homeAddress | dateBirth  | age | country | city     |
      | National          | 6454215  | 02/22/2017 | CBA     | 4564215        | Angola        | 02/20/2019      | true    | Business and Tourism (B-1/B-2) | 02/20/2019  | Henry56     | 02/12/1986 | 30  | Albania | SomeCity |

    And I verify if he has this simple data in hrdata information
      | gender | maritalStatus | numberChildren | startDate  | endDate    | hireDate   | endHireDate | salaryReviewMonth | workingSchedule  | holidayGroup           | vacationAnniversary | internalID |
      | Male   | Cohabiting    | 5              | 02/19/2015 | 02/01/2016 | 01/04/2016 | 01/04/2017  | January           | Recursos humanos | Jala Bolivian Holidays | 02/04/2016          | 654818     |

    And I verify if he has this simple data in engineering information
      | department | division | jobTitle | manager        | lead        | visible | billable | shadowCategory | notes | commitment | active | consultant | jce   | reason | lastEvalDate | nextEvalDate |
      | IT         | Support  | Security | auto manager hr | auto lead hr | false   | true     | Risk           | dwe   | false      | true   | true       | false | ders   | 02/03/2016   | 02/03/2017   |

    And I verify if he has this nationality data
      | name    | code |
      | Bolivia | BO   |
      | Albania | AL   |

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
      | name | startDate  | endDate    | employeer |
      | xde  | 02/03/2016 | 02/04/2016 | asd       |

    And I verify if he has this project data
      | code |
      | TPA  |

    And I verify if he has this internal career data
      | department | division | name     | projectCode | weight | startDate  | endDate    | employeer |
      | IT         | Support  | Security | TPA         | 6      | 02/10/2016 | 02/20/2018 | Other     |

    And I verify if he has this holiday policies data
      | name               |
      | Bolivian Labor Law |

    Examples:
      | number  | role  |
      | one     | admin |

  @EditEmployeeInformation @CRUD @all @Now
  Scenario Outline: Verify that employee fields are edited with admin role
    Given I navigate to login page
    When I login with "admin" credentials
    And I create an employee with required fields
      | firstName | lastName     | idNumber | manager        | lead        |
      | auto      | edit<number> | 6454215  | auto manager hr | auto lead hr |
    And I logout
    And I login with "<role>" credentials
    And I go to "employees" hhrr submenu
    And I select "list" view
    And I search employee "auto edit<number>" into employee list view
    And I press "edit" general button
    And I modify the employee with basic data
      | firstName | firstNameCheck | middleName | middleNameCheck | lastName     | secondLastName | marriedName |
      | auto      | true           | js         | true            | edit<number> | emp            | none        |

    And I modify the employee with public data
      | workEmail        | workPhone     | extCode | workMobile    | codeDesktop | city       | location | country | otherInfo  |
      | test@hotmail.com | 456-158-15532 | 12      | 707-642-51545 | A224        | Cochabamba | 0F       | Bolivia | other info |

    And I modify the employee with personal data
      | nationalOrForeign | idExpDate  | idPlace | passportNumber | passportPlace | passportExpDate | hasVisa | visaType                       | visaExpDate | homeAddress | dateBirth  | age | country | city     |
      | National          | 02/22/2017 | CBA     | 4564215        | Angola        | 02/20/2019      | true    | Business and Tourism (B-1/B-2) | 02/20/2019  | Henry56     | 02/12/1986 | 29  | Albania | SomeCity |

    And I modify the employee with hhrr data
      | gender | maritalStatus | numberChildren | startDate  | endDate    | hireDate   | endHireDate | salaryReviewMonth | workingSchedule  | holidayGroup           | vacationAnniversary | internalID |
      | Male   | Cohabiting    | 5              | 02/19/2015 | 02/01/2016 | 01/04/2016 | 01/04/2017  | January           | Recursos humanos | Jala Bolivian Holidays | 02/04/2016          | 654818     |

    And I modify the employee with engineering data
      | department | division | jobTitle | manager        | lead        | commitment | active | consultant | jce   | reason | lastEvalDate | nextEvalDate |
      | IT         | Support  | Security | auto manager hr | auto lead hr | false      | true   | true       | false | ders   | 02/03/2016   | 02/03/2017   |

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

    And I add this family data to employee form
      | name | lastName | relation | sex    | birthDate  |
      | Dark | Potato   | Son      | Male   | 02/12/1986 |

    And I add this external career data to employee form
      | name | startDate  | endDate    | employeer |
      | xde  | 02/03/2016 | 02/04/2016 | asd       |

    And I add this tag data to employee form
      | name          |
      | media jornada |
      | dev training  |

    And I delete this tag data to employee form
      | name          |
      | dev training  |

    And I add this holiday policies data to employee form
      | name               |
      | Bolivian Labor Law |

    And I press "save" general button

    And I verify if he has this data in basic information
      | fullName                     |
      | auto js edit<number> emp     |

    And I verify if he has this data in public information
      | workEmail        | workPhone     | extCode | workMobile    | otherInfo  | location | codeDesktop | country | city       |
      | test@hotmail.com | 456-158-15532 | 12      | 707-642-51545 | other info | 0F       | A224        | Bolivia | Cochabamba |

    And I verify if he has this simple data in personal information
      | nationalOrForeign | idNumber | idExpDate  | idPlace | passportNumber | passportPlace | passportExpDate | hasVisa | visaType                       | visaExpDate | homeAddress                                              | dateBirth  | age | country | city     |
      | National          | 6454215  | 02/22/2017 | CBA     | 4564215        | Angola        | 02/20/2019      | true    | Business and Tourism (B-1/B-2) | 02/20/2019  | Henry56 | 02/12/1986 | 30  | Albania | SomeCity |

    And I verify if he has this simple data in hrdata information
      | gender | maritalStatus | numberChildren | startDate  | endDate    | hireDate   | endHireDate | salaryReviewMonth | workingSchedule  | holidayGroup           | vacationAnniversary | internalID |
      | Male   | Cohabiting    | 5              | 02/19/2015 | 02/01/2016 | 01/04/2016 | 01/04/2017  | January           | Recursos humanos | Jala Bolivian Holidays | 02/04/2016          | 654818     |

    And I verify if he has this simple data in engineering information
      | department | division | jobTitle | manager        | lead        | visible | billable | shadowCategory | notes | commitment | active | consultant | jce   | reason | lastEvalDate | nextEvalDate |
      | IT         | Support  | Security | auto manager hr | auto lead hr | false   | false    |                |       | false      | true   | true       | false | ders   | 02/03/2016   | 02/03/2017   |

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
      | name | startDate  | endDate    | employeer |
      | xde  | 02/03/2016 | 02/04/2016 | asd       |

    And I verify if he has this holiday policies data
      | name               |
      | Bolivian Labor Law |

    Examples:
      | number  | role       |
      | two     | sr manager |

  @EditEmployeeInformation @CRUD @all
  Scenario Outline: Verify that employee fields are edited with admin role
    Given I navigate to login page
    When I login with "admin" credentials
    And I create an employee with required fields
      | firstName | lastName     | idNumber | manager        | lead        |
      | auto      | edit<number> | 6454215  | auto manager hr | auto lead hr |
    And I logout
    And I login with "<role>" credentials
    And I go to "employees" hhrr submenu
    And I select "list" view
    And I search employee "auto edit<number>" into employee list view
    And I press "edit" general button
    And I modify the employee with basic data
      | firstName | firstNameCheck | middleName | middleNameCheck | lastName     | secondLastName | marriedName |
      | auto      | true           | js         | true            | edit<number> | emp            | none        |

    And I modify the employee with public data
      | workEmail        | workPhone     | extCode | workMobile    | codeDesktop | city       | location | country | otherInfo  |
      | test@hotmail.com | 456-158-15532 | 12      | 707-642-51545 | A224        | Cochabamba | 0F       | Bolivia | other info |

    And I modify the employee with personal data
      | nationalOrForeign | idExpDate  | idPlace | passportNumber | passportPlace | passportExpDate | hasVisa | visaType                       | visaExpDate | homeAddress | dateBirth  | age | country | city     |
      | National          | 02/22/2017 | CBA     | 4564215        | Angola        | 02/20/2019      | true    | Business and Tourism (B-1/B-2) | 02/20/2019  | Henry56     | 02/12/1986 | 29  | Albania | SomeCity |

    And I modify the employee with hhrr data
      | gender | maritalStatus | numberChildren | startDate  | endDate    | hireDate   | endHireDate | salaryReviewMonth | workingSchedule  | holidayGroup           | vacationAnniversary | internalID |
      | Male   | Cohabiting    | 5              | 02/19/2015 | 02/01/2016 | 01/04/2016 | 01/04/2017  | January           | Recursos humanos | Jala Bolivian Holidays | 02/04/2016          | 654818     |

    And I modify the employee with engineering data
      | department | division | jobTitle | manager        | lead        | commitment | active | consultant | jce   | reason | lastEvalDate | nextEvalDate |
      | IT         | Support  | Security | auto manager hr | auto lead hr | false      | true   | true       | false | ders   | 02/03/2016   | 02/03/2017   |

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

    And I add this family data to employee form
      | name | lastName | relation | sex    | birthDate  |
      | Dark | Potato   | Son      | Male   | 02/12/1986 |

    And I add this external career data to employee form
      | name | startDate  | endDate    | employeer |
      | xde  | 02/03/2016 | 02/04/2016 | asd       |

    And I add this holiday policies data to employee form
      | name               |
      | Bolivian Labor Law |

    And I press "save" general button

    And I verify if he has this data in basic information
      | fullName                     |
      | auto js edit<number> emp     |

    And I verify if he has this data in public information
      | workEmail        | workPhone     | extCode | workMobile    | otherInfo  | location | codeDesktop | country | city       |
      | test@hotmail.com | 456-158-15532 | 12      | 707-642-51545 | other info | 0F       | A224        | Bolivia | Cochabamba |

    And I verify if he has this simple data in personal information
      | nationalOrForeign | idNumber | idExpDate  | idPlace | passportNumber | passportPlace | passportExpDate | hasVisa | visaType                       | visaExpDate | homeAddress                                              | dateBirth  | age | country | city     |
      | National          | 6454215  | 02/22/2017 | CBA     | 4564215        | Angola        | 02/20/2019      | true    | Business and Tourism (B-1/B-2) | 02/20/2019  | Henry56 | 02/12/1986 | 30  | Albania | SomeCity |

    And I verify if he has this simple data in hrdata information
      | gender | maritalStatus | numberChildren | startDate  | endDate    | hireDate   | endHireDate | salaryReviewMonth | workingSchedule  | holidayGroup           | vacationAnniversary | internalID |
      | Male   | Cohabiting    | 5              | 02/19/2015 | 02/01/2016 | 01/04/2016 | 01/04/2017  | January           | Recursos humanos | Jala Bolivian Holidays | 02/04/2016          | 654818     |

    And I verify if he has this simple data in engineering information
      | department | division | jobTitle | manager        | lead        | visible | billable | shadowCategory | notes | commitment | active | consultant | jce   | reason | lastEvalDate | nextEvalDate |
      | IT         | Support  | Security | auto manager hr | auto lead hr | false   | false    |                |       | false      | true   | true       | false | ders   | 02/03/2016   | 02/03/2017   |

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
      | name | startDate  | endDate    | employeer |
      | xde  | 02/03/2016 | 02/04/2016 | asd       |

    And I verify if he has this holiday policies data
      | name               |
      | Bolivian Labor Law |

    Examples:
      | number | role            |
      | three  | personnel admin |
      | four   | manager         |

  @EditEmployeeInformation @CRUD @all
  Scenario Outline: Verify that employee fields are edited with admin role
    Given I navigate to login page
    When I login with "admin" credentials
    And I create an employee with required fields
      | firstName | lastName     | idNumber | manager        | lead        |
      | auto      | edit<number> | 6454215  | auto manager hr | auto lead hr |
    And I logout
    And I login with "<role>" credentials
    And I go to "employees" hhrr submenu
    And I select "list" view
    And I search employee "auto edit<number>" into employee list view
    And I press "edit" general button
    And I modify the employee with basic data
      | firstName | firstNameCheck | middleName | middleNameCheck | lastName     | secondLastName | marriedName |
      | auto      | true           | js         | true            | edit<number> | emp            | none        |

    And I modify the employee with public data
      | workEmail        | workPhone     | extCode | workMobile    | codeDesktop | city       | location | country | otherInfo  |
      | test@hotmail.com | 456-158-15532 | 12      | 707-642-51545 | A224        | Cochabamba | 0F       | Bolivia | other info |

    And I modify the employee with personal data
      | nationalOrForeign | idExpDate  | idPlace | passportNumber | passportPlace | passportExpDate | hasVisa | visaType                       | visaExpDate | homeAddress | dateBirth  | age | country | city     |
      | National          | 02/22/2017 | CBA     | 4564215        | Angola        | 02/20/2019      | true    | Business and Tourism (B-1/B-2) | 02/20/2019  | Henry56     | 02/12/1986 | 29  | Albania | SomeCity |

    And I modify the employee with hhrr data
      | gender | maritalStatus | numberChildren | startDate  | endDate    | hireDate   | endHireDate | salaryReviewMonth | workingSchedule  | holidayGroup           | vacationAnniversary | internalID |
      | Male   | Cohabiting    | 5              | 02/19/2015 | 02/01/2016 | 01/04/2016 | 01/04/2017  | January           | Recursos humanos | Jala Bolivian Holidays | 02/04/2016          | 654818     |

    And I modify the employee with engineering data
      | department | division | jobTitle | commitment | active | consultant | jce   | reason | lastEvalDate | nextEvalDate |
      | IT         | Support  | Security | false      | true   | true       | false | ders   | 02/03/2016   | 02/03/2017   |

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

    And I add this family data to employee form
      | name | lastName | relation | sex    | birthDate  |
      | Dark | Potato   | Son      | Male   | 02/12/1986 |

    And I add this external career data to employee form
      | name | startDate  | endDate    | employeer |
      | xde  | 02/03/2016 | 02/04/2016 | asd       |

    And I add this holiday policies data to employee form
      | name               |
      | Bolivian Labor Law |

    And I press "save" general button

    And I verify if he has this data in basic information
      | fullName                     |
      | auto js edit<number> emp     |

    And I verify if he has this data in public information
      | workEmail        | workPhone     | extCode | workMobile    | otherInfo  | location | codeDesktop | country | city       |
      | test@hotmail.com | 456-158-15532 | 12      | 707-642-51545 | other info | 0F       | A224        | Bolivia | Cochabamba |

    And I verify if he has this simple data in personal information
      | nationalOrForeign | idNumber | idExpDate  | idPlace | passportNumber | passportPlace | passportExpDate | hasVisa | visaType                       | visaExpDate | homeAddress                                              | dateBirth  | age | country | city     |
      | National          | 6454215  | 02/22/2017 | CBA     | 4564215        | Angola        | 02/20/2019      | true    | Business and Tourism (B-1/B-2) | 02/20/2019  | Henry56 | 02/12/1986 | 30  | Albania | SomeCity |

    And I verify if he has this simple data in hrdata information
      | gender | maritalStatus | numberChildren | startDate  | endDate    | hireDate   | endHireDate | salaryReviewMonth | workingSchedule  | holidayGroup           | vacationAnniversary | internalID |
      | Male   | Cohabiting    | 5              | 02/19/2015 | 02/01/2016 | 01/04/2016 | 01/04/2017  | January           | Recursos humanos | Jala Bolivian Holidays | 02/04/2016          | 654818     |

    And I verify if he has this simple data in engineering information
      | department | division | jobTitle | visible | billable | shadowCategory | notes | commitment | active | consultant | jce   | reason | lastEvalDate | nextEvalDate |
      | IT         | Support  | Security | false   | false    |                |       | false      | true   | true       | false | ders   | 02/03/2016   | 02/03/2017   |

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
      | name | startDate  | endDate    | employeer |
      | xde  | 02/03/2016 | 02/04/2016 | asd       |

    And I verify if he has this holiday policies data
      | name               |
      | Bolivian Labor Law |

    Examples:
      | number | role            |
      | five   | lead            |