@Purchase
Feature: Purchase
  @Acceptance
  Scenario: Create a purchase requisition
    Given I navigate to login page
      And I login with "purchase manager" credentials
      And I go to "purchase requisition" purchase submenu
    When I press "create" general button
      And I create a purchase requisition with these data
        | sourceDocument | requisitionType       | requisitionDate | requisitionDeadline | warehouse    | department    | company  |
        | othertest      | Multiple Requisitions | 11/10/2015      | 12/10/2015          | Your Company | IT, Marketing | JalaSoft |
      And I press "save" general button
    Then I go to "purchase requisition" purchase submenu
      And a new record is displayed in purchase requisition list view




