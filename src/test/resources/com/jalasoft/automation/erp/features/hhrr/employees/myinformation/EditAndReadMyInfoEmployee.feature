@Employee
Feature: Edit and Read My own Information

  @EditMyOwnInformation @MyInformation @all @CRUD
  Scenario Outline: Verify that employee fields are edited with admin role
  Bugs: HBH34[Reg]Edit and Read Careers were removed due create for it self bug. Also Read Project codes
        Review: Removing Edit and Read actions for tags.They are not available
        N/A: Other Information is not available yet

    Given I navigate to login page
    And I login with "admin" credentials
    When I create an employee with required fields
      | firstName | lastName       | user   | idNumber | manager         | lead         |
      | autoedit  | myinfo<number> | <user> | 6454215  | auto manager hr | auto lead hr |
    And I logout
    When I login with "<role>" credentials
    And I go to "my information" hhrr submenu
    And I search employee "autoedit myinfo<number>" into employee list view
    And I press "edit" general button
    When I modify the employee with basic data
      | firstName | firstNameCheck | middleName | middleNameCheck | lastName | secondLastName | marriedName |
      | auto      | true           | edited     | true            | <number> | emp            | none        |


    And I modify the employee with public data
      | address | workEmail        | workPhone     | extCode | workMobile    | codeDesktop | city       | user     | location | country |
      | ABILA   | test@hotmail.com | 456-158-15532 | 12      | 707-642-51545 | A224        | Cochabamba | Henry56  | 0F       | Bolivia |


    And I modify the employee with personal data
      | nationalOrForeign | idNumber | idExpDate  | idPlace | passportNumber | passportPlace | passportExpDate | hasVisa | visaType                       | visaExpDate | homeAddress | dateBirth  | country | city     |
      | National          | 6404205  | 02/22/2017 | CBA     | 4564215        | Angola        | 02/20/2019      | true    | Business and Tourism (B-1/B-2) | 02/20/2019  | Henry56     | 02/12/1986 | Albania | SomeCity |
    And I add this nationality data to employee form
      | name  |
      | Ghana |
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


    And I modify the employee with hhrr data
      | gender | maritalStatus | numberChildren | startDate  | endDate    | hireDate   | endHireDate | salaryReviewMonth | workingSchedule  | holidayGroup           | vacationAnniversary | internalID |
      | Male   | Cohabiting    | 5              | 02/19/2015 | 02/01/2016 | 01/04/2016 | 01/04/2017  | January           | Recursos humanos | Jala Bolivian Holidays | 03/03/2016          | 654818     |
    And I add this holiday policies data to employee form
      | name               |
      | Bolivian Labor Law |
    And I add this family data to employee form
      | name | lastName | relation | sex    | birthDate  |
      | Dark | Potato   | Son      | Male   | 02/12/1986 |


    And I modify the employee with engineering data
      | department | division | jobTitle | manager           | lead            | commitment | expDateCommit | active | consultant | jce   | reason | lastEvalDate | nextEvalDate |
      | IT         | Support  | Security | auto srmanager hr | auto manager hr | true       | 02/03/2016    | true   | true       | false | ders   | 02/03/2016   | 02/03/2017   |
    And I add this other supervisors data to employee form
      | name          |
      | auto admin hr |


    And I press "save" general button


    Then I verify if he has this data in basic information
      | fullName                 |
      | auto edited <number> emp |


    And I verify if he has this data in public information
      | address | workEmail        | workPhone     | extCode | workMobile    | user    | location | codeDesktop | country | city       |
      | ABILA   | test@hotmail.com | 456-158-15532 | 12      | 707-642-51545 | Henry56 | 0F       | A224        | Bolivia | Cochabamba |


    And I verify if he has this simple data in personal information
      | nationalOrForeign | idNumber   | idExpDate  | idPlace | passportNumber | passportPlace | passportExpDate | hasVisa | visaType                       | visaExpDate | homeAddress | dateBirth  | age | country | city     |
      | National          | 6406454215 | 02/22/2017 | CBA     | 4564215        | Angola        | 02/20/2019      | true    | Business and Tourism (B-1/B-2) | 02/20/2019  | Henry56     | 02/12/1986 | 30  | Albania | SomeCity |
    And I verify if he has this nationality data
      | name    | code |
      | Bolivia | BO   |
      | Ghana   | GH   |

    And I verify if he has this nda data
      | ndaVersion  | signDate   |
      | Version 2   | 02/04/2016 |
      | Version 3   | 02/11/2016 |
    And I verify if he has this emergency contact data
      | name       | relationship | phone    | mobile    |
      | Dark Vader | Padre        | 40-00000 | 797-00000 |

    And I verify if he has this simple data in hrdata information
      | gender | maritalStatus | numberChildren | startDate  | endDate    | hireDate   | salaryReviewMonth | workingSchedule  | holidayGroup           | vacationAnniversary | internalID |
      | Male   | Cohabiting    | 5              | 02/19/2015 | 02/01/2016 | 01/04/2016 | January           | Recursos humanos | Jala Bolivian Holidays | 03/03/2016          | 654818     |
    And I verify if he has this family data
      | name | lastName | relation | sex  | birthDate  |
      | Dark | Potato   | Son      | Male | 02/12/1986 |
    And I verify if he has this holiday policies data
      | name               |
      | Bolivian Labor Law |


    And I verify if he has this simple data in engineering information
      | department | division | jobTitle | manager           | lead            | commitment | expDateCommit | active | consultant | jce   | reason | lastEvalDate | nextEvalDate |
      | IT         | Support  | Security | auto srmanager hr | auto manager hr | true       | 02/03/2016    | true   | true       | false | ders   | 02/03/2016   | 02/03/2017   |
    And I verify if he has this other supervisors data
      | name          |
      | auto admin hr |


    Examples:
      | role       | user    | number    |
      | admin      | Henry51 | admin     |
      | staffing   | Henry52 | staffing  |
      | sr manager | Henry53 | srmanager |

  @ReadEmployeeMyInformation @MyInformation @all @CRUD
  Scenario Outline: Verify that I can read my own employee information
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


  And I verify if he has this simple data in hrdata information
    | gender | maritalStatus | numberChildren | startDate  | endDate    | hireDate   | salaryReviewMonth | workingSchedule  | holidayGroup           | vacationAnniversary | internalID |
    | Male   | Cohabiting    | 5              | 02/19/2015 | 02/01/2016 | 01/04/2016 | January           | Recursos humanos | Jala Bolivian Holidays | 02/04/2016          | 654818     |
  And I verify if he has this project data
    | code |
    | TPA  |
  And I verify if he has this family data
    | name | lastName | relation | sex    | birthDate  |
    | Dark | Potato   | Son      | Male   | 02/12/1986 |
  And I verify if he has this holiday policies data
    | name               |
    | Bolivian Labor Law |


  And I verify if he has this simple data in engineering information
    | department | division | jobTitle | manager         | lead         | commitment | expDateCommit | active | consultant | jce   | reason | lastEvalDate | nextEvalDate |
    | IT         | Support  | Security | auto manager hr | auto lead hr | true       | 02/03/2016    | true   | true       | false | ders   | 02/03/2016   | 02/03/2017   |
  And I verify if he has this other supervisors data
    | name              |
    | auto srmanager hr |


  And I verify if he has this external career data
    | jobTitle | startDate  | endDate    | employer |
    | xde      | 02/03/2016 | 02/04/2016 | asd      |
  And I verify if he has this internal career data
    | department | division | jobTitle | startDate  | endDate    | employer  |
    | IT         | Support  | Security | 02/10/2016 | 02/20/2018 | Other     |

  Examples:
    | role            | employee name        | user    |
    | employee        | auto employee hr     | Henry56 |
    | officer         | auto officer hr      | Henry57 |
    | common officer  | auto comofficer hr   | Henry58 |
    | hd officer      | auto hdofficer hr    | Henry59 |
    | reports         | auto reports hr      | Henry60 |
    | receptionist    | auto receptionist hr | Henry61 |
    | personnel admin | auto personnel hr    | Henry62 |

  @ReadEmployeeMyInformation @MyInformation @all @CRUD
  Scenario Outline: Verify that I can read my own employee information with manager and lead
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


    And I verify if he has this simple data in hrdata information
      | gender | maritalStatus | numberChildren | startDate  | endDate    | hireDate   | salaryReviewMonth | workingSchedule  | holidayGroup           | vacationAnniversary | internalID |
      | Male   | Cohabiting    | 5              | 02/19/2015 | 02/01/2016 | 01/04/2016 | January           | Recursos humanos | Jala Bolivian Holidays | 02/04/2016          | 654818     |
    And I verify if he has this project data
      | code |
      | TPA  |
    And I verify if he has this family data
      | name | lastName | relation | sex    | birthDate  |
      | Dark | Potato   | Son      | Male   | 02/12/1986 |
    And I verify if he has this holiday policies data
      | name               |
      | Bolivian Labor Law |


    And I verify if he has this simple data in engineering information
      | department | division | jobTitle | manager       | commitment | expDateCommit | active | consultant | jce   | reason | lastEvalDate | nextEvalDate |
      | IT         | Support  | Security | Administrator | true       | 02/03/2016    | true   | true       | false | ders   | 02/03/2016   | 02/03/2017   |

    And I verify if he has this external career data
      | jobTitle | startDate  | endDate    | employer |
      | xde      | 02/03/2016 | 02/04/2016 | asd      |
    And I verify if he has this internal career data
      | department | division | jobTitle | startDate  | endDate    | employer  |
      | IT         | Support  | Security | 02/10/2016 | 02/20/2018 | Other     |

    Examples:
      | role           | employee name         | user    |
      | manager         | auto manager hr      | Henry54 |
      | lead            | auto lead hr         | Henry55 |


