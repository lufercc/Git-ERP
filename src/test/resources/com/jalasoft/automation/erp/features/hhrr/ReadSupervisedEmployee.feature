@Employee
Feature: Read supervised employees
  @ReadEmployeeInformation @CRUD @all
  Scenario Outline: Verify that employee fields are read with reports role
    Given I navigate to login page
    When I login with "<role>" credentials
    And I go to "employees" hhrr submenu
    And I select "list" view
    And I search employee "auto employee hr" into employee list view
    And I verify if he has this data in basic information
      | fullName         |
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

    And I verify if he has this holiday policies data
      | name               |
      | Bolivian Labor Law |

    And I verify if he has this other supervisors data
      | name              |
      | auto srmanager hr |
    Examples:
      | role    |
      | reports |

  @ReadEmployeeInformation @CRUD @all
  Scenario Outline: Verify that employee fields are read with receptionist role. Note: R2 access, External and Internal careers are not loaded
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
      | department | division | jobTitle | manager         | lead         | visible | billable | shadowCategory | notes | commitment | expDateCommit |active | consultant | jce   | reason | lastEvalDate | nextEvalDate |
      | IT         | Support  | Security | auto manager hr | auto lead hr | false   | false    |                |       | true       | 02/03/2016    |true   | true       | false | ders   | 02/03/2016   | 02/03/2017   |

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
      | role           |
      | receptionist   |

  @ReadEmployeeInformation @CRUD @all
  Scenario Outline: Verify that employee fields are read with X role
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
      | IT         | Support  | Security | auto manager hr | auto lead hr | false   | false    |                |       | true       | 02/03/2016    |true   | true       | false | ders   | 02/03/2016   | 02/03/2017   |

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
      | department | division | jobTitle | projectCode | weight | startDate  | endDate    | employer  |
      | IT         | Support  | Security | TPA         | 6      | 02/10/2016 | 02/20/2018 | Other     |

    And I verify if he has this holiday policies data
      | name               |
      | Bolivian Labor Law |

    And I verify if he has this other supervisors data
      | name              |
      | auto srmanager hr |
    Examples:
      | role           |
      | common officer |
      | hd officer     |