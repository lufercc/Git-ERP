@Accounting
Feature: Accounting
  @EndToEnd @31006
  Scenario: Verify that an asset is assigned if the asset is created manually
    Given I navigate to login page
    When I login with "asset manager" credentials
      And I go to "assets" accounting submenu
      And I press "create" general button
      And I modify the asset with these data
        | assetCategoryParent | grossValue |
        | 01_Domo             | 100        |
      And I press "save" general button
      And I press "confirm asset" accounting button
      And get main data from the asset created
    Then it has "running" status
    When I go to "assets assignation" accounting submenu
      And I search asset created in asset assignation
      And I press "request assignation" accounting button
      And I modify the request assignation popup with these data
        | evaluationResponsible | depAreaResponsible | custodian    | depArea   | location             |
        | selog_assMan          | IT                 | selog_warMan | Marketing | Su compañía / Salida |
      And I press "internal moves" accounting internal button
      And I logout
    When I login with "warehouse manager" credentials
      And I go to "internal moves" warehouse submenu
      And I search internal move created in asset assignation
      And I press "force availability" warehouse button
      And I press "confirm and transfer" warehouse button
      And I logout
      And I login with "asset manager" credentials
      And I go to "assets assignation" accounting submenu
      And I search asset created in asset assignation
    Then it has "evaluation" status
    When I press "deliver" accounting button
      And I modify the deliver asset popup with these data
        | assetStatus    | assetNote |
        | Bueno          | Some Note |
      And I press "more" general button
      And I press "create delivery record" extra general accounting button
      And I press "delivery records" accounting internal button
      And I open to the 1 record displayed for asset delivery records
      And I press "deliver" accounting button
      And I press "Ok" button for general popup
      And I send email from popup
      And I go to "assets assignation" accounting submenu
      And I search asset created in asset assignation
    Then it has "assigned" status

  @EndToEnd @31727
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