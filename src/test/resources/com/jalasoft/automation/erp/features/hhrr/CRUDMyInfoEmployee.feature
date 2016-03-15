@Employee
Feature: Read My own Information
  @ReadEmployeeMyInformation @all @CRUD
  Scenario Outline: Verify that I can read my own employee information
  Bugs:JCB325  Careers data were removed from this scenario until this was fixed
  Given I navigate to login page
  When I login with "<role>" credentials
  And I go to "my information" hhrr submenu
  And I select "list" view
  And I search employee "<employee name>" into employee list view
  And I verify if he has this data in basic information
  | fullName        |
  | <employee name> |
  And I verify if he has this data in public information
    | address | workEmail        | workPhone     | extCode | workMobile    | user   | location | codeDesktop | country | city       |
    | ABILA   | test@hotmail.com | 456-158-15532 | 12      | 707-642-51545 | <user> | 0F       | A224        | Bolivia | Cochabamba |

  And I verify if he has this simple data in personal information
    | nationalOrForeign | idNumber | idExpDate  | idPlace | passportNumber | passportPlace | passportExpDate | hasVisa | visaType                       | visaExpDate | homeAddress | dateBirth  | age | country | city     |
    | National          | 6541512  | 02/22/2017 | CBA     | 4564215        | Angola        | 02/20/2019      | true    | Business and Tourism (B-1/B-2) | 02/20/2019  | Henry56     | 02/12/1986 | 30  | Albania | SomeCity |

  And I verify if he has this simple data in hrdata information
    | gender | maritalStatus | numberChildren | startDate  | endDate    | hireDate   | salaryReviewMonth | workingSchedule  | holidayGroup           | vacationAnniversary | internalID |
    | Male   | Cohabiting    | 5              | 02/19/2015 | 02/01/2016 | 01/04/2016 | January           | Recursos humanos | Jala Bolivian Holidays | 02/04/2016          | 654818     |

  And I verify if he has this simple data in engineering information
    | department | division | jobTitle | manager         | lead         | commitment | expDateCommit | active | consultant | jce   | reason | lastEvalDate | nextEvalDate |
    | IT         | Support  | Security | auto manager hr | auto lead hr | true       | 02/03/2016    | true   | true       | false | ders   | 02/03/2016   | 02/03/2017   |

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

  And I verify if he has this project data
    | code |
    | TPA  |

  And I verify if he has this holiday policies data
    | name               |
    | Bolivian Labor Law |

  And I verify if he has this other supervisors data
    | name              |
    | auto srmanager hr |
  Examples:
    | role           | employee name        | user    |
    | common officer | auto comofficer hr   | Henry58 |
    | employee       | auto employee hr     | Henry56 |
    | officer        | auto officer hr      | Henry57 |
    | receptionist   | auto receptionist hr | Henry61 |
    | reports        | auto reports hr      | Henry60 |


  @ReadEmployeeMyInformation @all @CRUD
  Scenario Outline: Verify that I can read my own employee information
  Bugs:JCB325  Careers data were removed from this scenario until this was fixed
    Given I navigate to login page
    When I login with "<role>" credentials
    And I go to "my information" hhrr submenu
    And I select "list" view
    And I search employee "<employee name>" into employee list view
    And I verify if he has this data in basic information
      | fullName        |
      | <employee name> |
    And I verify if he has this data in public information
      | address | workEmail        | workPhone     | extCode | workMobile    | user   | location | codeDesktop | country | city       |
      | ABILA   | test@hotmail.com | 456-158-15532 | 12      | 707-642-51545 | <user> | 0F       | A224        | Bolivia | Cochabamba |

    And I verify if he has this simple data in personal information
      | nationalOrForeign | idNumber | idExpDate  | idPlace | passportNumber | passportPlace | passportExpDate | hasVisa | visaType                       | visaExpDate | homeAddress | dateBirth  | age | country | city     |
      | National          | 6541512  | 02/22/2017 | CBA     | 4564215        | Angola        | 02/20/2019      | true    | Business and Tourism (B-1/B-2) | 02/20/2019  | Henry56     | 02/12/1986 | 30  | Albania | SomeCity |

    And I verify if he has this simple data in hrdata information
      | gender | maritalStatus | numberChildren | startDate  | endDate    | hireDate   | salaryReviewMonth | workingSchedule  | holidayGroup           | vacationAnniversary | internalID |
      | Male   | Cohabiting    | 5              | 02/19/2015 | 02/01/2016 | 01/04/2016 | January           | Recursos humanos | Jala Bolivian Holidays | 02/04/2016          | 654818     |

    And I verify if he has this simple data in engineering information
      | department | division | jobTitle | manager       | commitment | expDateCommit | active | consultant | jce   | reason | lastEvalDate | nextEvalDate |
      | IT         | Support  | Security | Administrator | true       | 02/03/2016    | true   | true       | false | ders   | 02/03/2016   | 02/03/2017   |

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

    And I verify if he has this project data
      | code |
      | TPA  |

    And I verify if he has this holiday policies data
      | name               |
      | Bolivian Labor Law |

    Examples:
      | role         | employee name        | user    |
      | lead         | auto lead hr         | Henry55 |
      | manager      | auto manager hr      | Henry54 |

  @EditMyOwnInformation @CRUD @all
  Scenario Outline: Verify that employee fields are edited with srmanager and admin roles
  Bugs:JCB325  Careers data were removed from this scenario until this was fixed
    Given I navigate to login page
    When I login with "<role>" credentials
    And I go to "my information" hhrr submenu
    And I select "list" view
    And I search employee "<employee name>" into employee list view
    And I press "edit" general button
    And I modify the employee with personal data
      | passportNumber | passportPlace | passportExpDate | hasVisa | visaType                       | visaExpDate |
      | 4564215        | Angola        | 02/20/2019      | true    | Business and Tourism (B-1/B-2) | 02/20/2019  |

    And I remove all emergency contact data from employee form

    And I add this emergency contact data to employee form
      | name       | relationship | phone    | mobile    |
      | Dark Vader | Padre        | 40-00000 | 797-00000 |

    And I press "save" general button

    And I verify if he has this data in basic information
      | fullName        |
      | <employee name> |
    And I verify if he has this data in public information
      | address | workEmail        | workPhone     | extCode | workMobile    | user   | location | codeDesktop | country | city       |
      | ABILA   | test@hotmail.com | 456-158-15532 | 12      | 707-642-51545 | <user> | 0F       | A224        | Bolivia | Cochabamba |

    And I verify if he has this simple data in personal information
      | nationalOrForeign | idNumber | idExpDate  | idPlace | passportNumber | passportPlace | passportExpDate | hasVisa | visaType                       | visaExpDate | homeAddress | dateBirth  | age | country | city     |
      | National          | 6541512  | 02/22/2017 | CBA     | 4564215        | Angola        | 02/20/2019      | true    | Business and Tourism (B-1/B-2) | 02/20/2019  | Henry56     | 02/12/1986 | 30  | Albania | SomeCity |

    And I verify if he has this simple data in hrdata information
      | gender | maritalStatus | numberChildren | startDate  | endDate    | hireDate   | salaryReviewMonth | workingSchedule  | holidayGroup           | vacationAnniversary | internalID |
      | Male   | Cohabiting    | 5              | 02/19/2015 | 02/01/2016 | 01/04/2016 | January           | Recursos humanos | Jala Bolivian Holidays | 02/04/2016          | 654818     |

    And I verify if he has this simple data in engineering information
      | department | division | jobTitle | manager       | commitment | expDateCommit | active | consultant | jce   | reason | lastEvalDate | nextEvalDate |
      | IT         | Support  | Security | Administrator | true       | 02/03/2016    | true   | true       | false | ders   | 02/03/2016   | 02/03/2017   |

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

    And I verify if he has this project data
      | code |
      | TPA  |

    And I verify if he has this holiday policies data
      | name               |
      | Bolivian Labor Law |

    Examples:
      | role       | employee name     | user    |
      | sr manager | auto srmanager hr | Henry53 |
      | admin      | auto admin hr     | Henry51 |

  @EditMyOwnInformation @CRUD @all
  Scenario Outline: Verify that employee fields are edited with staffing role
  Bugs:JCB325  Careers data were removed from this scenario until this was fixed
    Given I navigate to login page
    When I login with "<role>" credentials
    And I go to "my information" hhrr submenu
    And I select "list" view
    And I search employee "<employee name>" into employee list view
    And I press "edit" general button
    And I modify the employee with personal data
      | passportNumber | passportPlace | passportExpDate | hasVisa | visaType                       | visaExpDate |
      | 4564215        | Angola        | 02/20/2019      | true    | Business and Tourism (B-1/B-2) | 02/20/2019  |

    And I remove all emergency contact data from employee form

    And I add this emergency contact data to employee form
      | name       | relationship | phone    | mobile    |
      | Dark Vader | Padre        | 40-00000 | 797-00000 |

    And I press "save" general button

    And I verify if he has this data in basic information
      | fullName        |
      | <employee name> |
    And I verify if he has this data in public information
      | address | workEmail        | workPhone     | extCode | workMobile    | user   | location | codeDesktop | country | city       |
      | ABILA   | test@hotmail.com | 456-158-15532 | 12      | 707-642-51545 | <user> | 0F       | A224        | Bolivia | Cochabamba |

    And I verify if he has this simple data in personal information
      | nationalOrForeign | idNumber | idExpDate  | idPlace | passportNumber | passportPlace | passportExpDate | hasVisa | visaType                       | visaExpDate | homeAddress | dateBirth  | age | country | city     |
      | National          | 6541512  | 02/22/2017 | CBA     | 4564215        | Angola        | 02/20/2019      | true    | Business and Tourism (B-1/B-2) | 02/20/2019  | Henry56     | 02/12/1986 | 30  | Albania | SomeCity |

    And I verify if he has this simple data in hrdata information
      | gender | maritalStatus | numberChildren | startDate  | endDate    | hireDate   | salaryReviewMonth | workingSchedule  | holidayGroup           | vacationAnniversary | internalID |
      | Male   | Cohabiting    | 5              | 02/19/2015 | 02/01/2016 | 01/04/2016 | January           | Recursos humanos | Jala Bolivian Holidays | 02/04/2016          | 654818     |

    And I verify if he has this simple data in engineering information
      | department | division | jobTitle | manager         | lead         | commitment | expDateCommit | active | consultant | jce   | reason | lastEvalDate | nextEvalDate |
      | IT         | Support  | Security | auto manager hr | auto lead hr | true       | 02/03/2016    | true   | true       | false | ders   | 02/03/2016   | 02/03/2017   |

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

    And I verify if he has this project data
      | code |
      | TPA  |

    And I verify if he has this holiday policies data
      | name               |
      | Bolivian Labor Law |

    Examples:
      | role         | employee name      | user    |
      | staffing     | auto staffing hr   | Henry52 |

