@Accounting
Feature: Accounting
  @EndToEnd
  Scenario: Verify that an asset is created from Purchase Order
    Given I navigate to login page
      And I login with "purchase manager" credentials
      And I go to "purchase orders" purchase submenu
    When I press "create" general button
      And I create a purchase order with these data
      | supplier |
      | IC Norte |
      And I add products to the purchase order
      | product |
      | Amoladora de acero grande |
      And I press "confirm" purchase button
      And get "id" field value for Purchase Order created
      And I logout
    When I login with "warehouse manager" credentials
      And I go to "incoming shipments" purchase submenu
      And I go to incoming shipment created from Purchase Order
      And I press "receive" incoming shipment button
      And I move to "internal moves" from incoming shipment
      And I press "confirm and transfer" incoming shipment button
      And I logout
    When I login with "accountant" credentials
      And I go to "incoming shipments" purchase submenu
      And I go to incoming shipment created from Purchase Order
      And I press "create invoice" incoming shipment button
      And I go to "supplier invoices" accounting submenu
      And I go to supplier invoice created from incoming shipment
      And I press "edit" general button
      And I edit the supplier invoice with these data
      | tin           | number | authorizationNumber | controlCode    |
      | 3511597451515 | 000454 | 65464646464555      | B2-A2-H6-R4-G4 |
      And I press "validate" accounting button
      And get "id" field value for supplier invoice created
      And I go to "assets" accounting submenu
      And a new record is displayed in assets list view
    Then it has "draft" status