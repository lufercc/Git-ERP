@Employee
Feature: Employee
  @create @all
  Scenario Outline: Verify that employee fields are edited with admin role
    Given I navigate to login page
    When I login with "admin" credentials
    And I go to "employees" hhrr submenu
    And I press "create" general button
    And I modify the employee with basic data
      | firstName | firstNameCheck | middleName | middleNameCheck | lastName | secondLastName | marriedName |
      | auto      | true           | js         | false           | <role>   | hr             | none        |

    And I modify the employee with public data
      | address | workEmail        | workPhone     | extCode | workMobile    | codeDesktop | city       | user     | location | country | otherInfo  |
      | ABILA   | test@hotmail.com | 456-158-15532 | 12      | 707-642-51545 | A224        | Cochabamba | <user>   | 0F       | Bolivia | Other info |

    And I modify the employee with personal data
      | nationalOrForeign | idNumber | idExpDate  | idPlace | passportNumber | passportPlace | passportExpDate | hasVisa | visaType                       | visaExpDate | homeAddress | dateBirth  | age | country | city     |
      | National          | 6541512  | 02/22/2017 | CBA     | 4564215        | Angola        | 02/20/2019      | true    | Business and Tourism (B-1/B-2) | 02/20/2019  | Henry56     | 02/12/1986 | 29  | Albania | SomeCity |

    And I modify the employee with hhrr data
      | gender | maritalStatus | numberChildren | startDate  | endDate    | hireDate   | endHireDate | salaryReviewMonth | workingSchedule  | holidayGroup           | vacationAnniversary | internalID |
      | Male   | Cohabiting    | 5              | 02/19/2015 | 02/01/2016 | 01/04/2016 | 01/04/2017  | January           | Recursos humanos | Jala Bolivian Holidays | 02/04/2016          | 654818     |

    And I modify the employee with engineering data
      | department | division | jobTitle | manager       | visible | billable | shadowCategory | notes | commitment | expDateCommit | active | consultant | jce   | reason | lastEvalDate | nextEvalDate |
      | IT         | Support  | Security | Administrator | false   | true     | Risk           | dwe   | true       | 02/03/2016    | true   | true       | false | ders   | 02/03/2016   | 02/03/2017   |

    And I add this nda data to employee form
      | ndaVersion  | signDate   |
      | Version 2   | 02/04/2016 |
      | Version 3   | 02/11/2016 |

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
      | department | division | name     | projectCode   | manager       | weight | startDate  | endDate    | employeer | description |
      | IT         | Support  | Security | TESTPROJABILA | Administrator | 6      | 02/10/2016 | 02/20/2018 | Other     | description |

    And I add this tag data to employee form
      | name          |
      | media jornada |

    And I add this holiday policies data to employee form
      | name               |
      | Bolivian Labor Law |

    And I press "save" general button

    Examples:
      | role      | user    |
      | admin     | Henry51 |
      | srmanager | Henry53 |
      | manager   | Henry54 |
      | lead      | Henry55 |

  @create @all
  Scenario Outline: Verify that employee fields are edited with admin role
    Given I navigate to login page
    When I login with "admin" credentials
    And I go to "employees" hhrr submenu
    And I press "create" general button
    And I modify the employee with basic data
      | firstName | firstNameCheck | middleName | middleNameCheck | lastName | secondLastName | marriedName |
      | auto      | true           | js         | false           | <role>   | hr             | none        |

    And I modify the employee with public data
      | address | workEmail        | workPhone     | extCode | workMobile    | codeDesktop | city       | user     | location | country | otherInfo  |
      | ABILA   | test@hotmail.com | 456-158-15532 | 12      | 707-642-51545 | A224        | Cochabamba | <user>   | 0F       | Bolivia | Other info |

    And I modify the employee with personal data
      | nationalOrForeign | idNumber | idExpDate  | idPlace | passportNumber | passportPlace | passportExpDate | hasVisa | visaType                       | visaExpDate | homeAddress | dateBirth  | age | country | city     |
      | National          | 6541512  | 02/22/2017 | CBA     | 4564215        | Angola        | 02/20/2019      | true    | Business and Tourism (B-1/B-2) | 02/20/2019  | Henry56     | 02/12/1986 | 29  | Albania | SomeCity |

    And I modify the employee with hhrr data
      | gender | maritalStatus | numberChildren | startDate  | endDate    | hireDate   | endHireDate | salaryReviewMonth | workingSchedule  | holidayGroup           | vacationAnniversary | internalID |
      | Male   | Cohabiting    | 5              | 02/19/2015 | 02/01/2016 | 01/04/2016 | 01/04/2017  | January           | Recursos humanos | Jala Bolivian Holidays | 02/04/2016          | 654818     |

    And I modify the employee with engineering data
      | department | division | jobTitle | manager         | lead         | visible | billable | shadowCategory | notes | commitment | expDateCommit | active | consultant | jce   | reason | lastEvalDate | nextEvalDate |
      | IT         | Support  | Security | auto manager hr | auto lead hr | false   | true     | Risk           | dwe   | true       | 02/03/2016    | true   | true       | false | ders   | 02/03/2016   | 02/03/2017   |

    And I add this nda data to employee form
      | ndaVersion  | signDate   |
      | Version 2   | 02/04/2016 |
      | Version 3   | 02/11/2016 |

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
      | department | division | name     | projectCode   | manager         | lead         | weight | startDate  | endDate    | employeer | description |
      | IT         | Support  | Security | TESTPROJABILA | auto manager hr | auto lead hr | 6      | 02/10/2016 | 02/20/2018 | Other     | description |

    And I add this tag data to employee form
      | name          |
      | media jornada |

    And I add this holiday policies data to employee form
      | name               |
      | Bolivian Labor Law |

    And I add this other supervisors data to employee form
      | name              |
      | auto srmanager hr |

    And I press "save" general button

    Examples:
      | role         | user    |
      | employee     | Henry56 |
      | officer      | Henry57 |


