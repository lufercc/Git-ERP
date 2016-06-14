@Employee
Feature: Employee
  @tagsrefactor
  Scenario: Test to review tag behavior
    Given I navigate to odoo login page
      And I login with "adminodoo" odoo credentials
      And I go to "employees" hhrr submenu
      And I press "create" general button
      And I modify the employee with basic data
        | firstName   | lastName |
        | testEmployee| tag      |

      And I modify the employee with personal data
        | nationalOrForeign | idNumber | idExpDate  | idPlace |
        | National          | 6541512  | 02/22/2017 | CBA     |

    When I add this tag data to employee form
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

  @tablesrefactor
  Scenario: Test to review table behavior
    Given I navigate to odoo login page
      And I login with "adminodoo" odoo credentials
      And I go to "employees" hhrr submenu
      And I press "create" general button
      And I modify the employee with basic data
        | firstName   | lastName |
        | testEmployee| table    |

      And I modify the employee with personal data
        | nationalOrForeign | idNumber | idExpDate  | idPlace |
        | National          | 6541512  | 02/22/2017 | CBA     |

    When I add this emergency contact data to employee form
      | name       | relationship | phone    | employee       |
      | Dark Vader | Padre        | 40-00000 | Auto S Manager |
      | Dark Vader | Padre        | 40-00000 | Carlos Test    |

      And I delete this emergency contact data to employee form
        | name       |
        | Dark Vader |

      And I add this family data to employee form
        | name  | lastName | relation | sex    | birthDate  |
        | Dark  | Potato   | Son      | Male   | 02/12/1986 |
        | Light | Tomato   | Parent   | Female | 03/13/1987 |

      And I delete this family data to employee form
        | name  | lastName | relation | sex    | birthDate  |
        | Dark  | Potato   | Son      | Male   | 1986-02-12 |

      And I add this external career data to employee form
        | jobTitle | startDate  | endDate    | employer | description |
        | xde      | 02/03/2016 | 02/04/2016 | asd      | asd         |
        | fsss     | 03/03/2018 | 02/04/2020 | ddd      | ggg         |

      And I delete this external career data to employee form
        | jobTitle | startDate  | endDate    | employer |
        | xde      | 02/03/2016 | 02/04/2016 | asd      |

      And I add this internal career data to employee form
        | department | jobTitle | manager        | lead        | startDate  | endDate    | employer | description |
        | IT         | Security | auto h manager | auto h lead | 02/10/2016 | 02/20/2018 | other    | description |
        | Sales      | Security | auto h manager | auto h lead | 03/10/2016 | 03/20/2018 | otros    | descripcion |

      And I delete this internal career data to employee form
        | department | jobTitle | startDate  | endDate    | employer |
        | Sales      | Security | 03/10/2016 | 03/20/2018 | otros    |

      And I press "save" general button
    Then I verify if he has this family data
      | name  | lastName | relation | sex    | birthDate  |
      | Light | Tomato   | Parent   | Female | 1987-03-13 |

      And I verify if he has this emergency contact data
        | name       |
        | Dark Vader |

      And I verify if he has this external career data
        | jobTitle | startDate  | endDate    | employer |
        | fsss     | 03/03/2018 | 02/04/2020 | ddd      |

      And I verify if he has this internal career data
        | department | jobTitle | startDate  | endDate    | employer |
        | IT         | Security | 02/10/2016 | 02/20/2018 | other    |

