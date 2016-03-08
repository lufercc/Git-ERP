@Employee
Feature: Employee
@ReadEmployeeMyInformation @all @Now
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
| addressDescription                                                                               | workEmail        | workPhone     | extCode | workMobile    | user     | otherInfo  | location | codeDesktop | country | city       |
| Calle Antofagasta # 241<br>Cercado CBA 3241<br>Bolivia<br>17°21'57.9"S 66°10'32.0"W<br>456158155 | test@hotmail.com | 456-158-15532 | 12      | 707-642-51545 | Henry56  | Other info | 0F       | A224        | Bolivia | Cochabamba |

And I verify if he has this simple data in personal information
| nationalOrForeign | idNumber | idExpDate  | idPlace | passportNumber | passportPlace | passportExpDate | hasVisa | visaType                       | visaExpDate | homeAddressDescription                                              | dateBirth  | age | country | city     |
| National          | 6541512  | 02/22/2017 | CBA     | 4564215        | Angola        | 02/20/2019      | true    | Business and Tourism (B-1/B-2) | 02/20/2019  | C. Tarata<br>Tarata CBA 123<br>Bolivia<br>17°21'57.9"S 66°10'32.0"W | 02/12/1986 | 30  | Albania | SomeCity |

And I verify if he has this simple data in hrdata information
| gender | maritalStatus | numberChildren | startDate  | endDate    | hireDate   | endHireDate | salaryReviewMonth | workingSchedule  | holidayGroup           | vacationAnniversary | internalID |
| Male   | Cohabiting    | 5              | 02/19/2015 | 02/01/2016 | 01/04/2016 | 01/04/2017  | January           | Recursos humanos | Jala Bolivian Holidays | 02/04/2016          | 654818     |

And I verify if he has this simple data in engineering information
| department | division | jobTitle | manager        | lead        | visible | billable | shadowCategory | notes | commitment | active | consultant | jce   | reason | lastEvalDate | nextEvalDate |
| IT         | Support  | Security | autojs manager | jslead otro | false   | false    |                |       | false      | true   | true       | false | ders   | 02/03/2016   | 02/03/2017   |

And I verify if he has this nationality data
| name    | code |
| Bolivia | BO   |

And I verify if he has this nda data
| ndaVersion  | signDate   |
| Version 2   | 02/04/2016 |
| Version 1-A | 02/01/2016 |
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

And I verify if he has this tag data
| name          |
| media jornada |
| dev training  |

And I verify if he has this holiday policies data
| name               |
| Bolivian Labor Law |

And I verify if he has this other supervisors data
| name          |
| Administrator |
Examples:
| role    | employee name   |
| officer | auto officer hr |
