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
      And get main data from the current asset
    Then it has "running" status
    When I go to "assets assignation" accounting submenu
      And I search asset created in asset assignation
      And I press "request assignation" accounting button
      And I modify the request assignation popup with these data
        | evaluationResponsible | depAreaResponsible | custodian    | depArea   | location             |
        | Henry7                | IT                 | Henry16      | Marketing | Edificio Fundación   |
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
      And get main data from the asset delivery record
      And I go to "assets assignation" accounting submenu
      And I search asset created in asset assignation
    Then it has "assigned" status
      And I go to "internal moves" warehouse submenu
      And I search internal move created in asset delivery order
      And I logout

  @EndToEnd @31007
  Scenario: Verify that an asset is assigned if the asset is created from Purchase Order
    Given I navigate to login page
      And I login with "purchase manager" credentials
      And I go to "purchase orders" purchase submenu
    When I press "create" general button
      And I create a purchase order with these data
        | supplier |
        | Advance  |
      And I add products to the purchase order
        | product |
        | Amoladora de acero grande |
      And I press "confirm" purchase button
      And get main data from current purchase order
      And I logout
    When I login with "warehouse manager" credentials
      And I go to "incoming shipments" purchase submenu
      And I go to incoming shipment created from purchase order
      And I press "receive" incoming shipment button
      And I move to "internal moves" from incoming shipment
      And I press "confirm and transfer" incoming shipment button
      And I logout
    When I login with "accountant" credentials
      And I go to "incoming shipments" purchase submenu
      And I go to incoming shipment created from purchase order
      And I press "create invoice" incoming shipment button
      And I go to "supplier invoices" accounting submenu
      And I go to supplier invoice created from incoming shipment
      And I press "edit" general button
      And I edit the supplier invoice with these data
        | tin           | number | authorizationNumber | controlCode    |
        | 3511597451515 | 000454 | 65464646464555      | B2-A2-H6-R4-G4 |
      And I press "validate" accounting button
      And get main data from current supplier invoice
      And I logout
    When I login with "asset manager" credentials
      And I go to "assets" accounting submenu
      And a new record is displayed in assets list view
      And I press "confirm asset" accounting button
      And get main data from the current asset
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
      And get main data from the asset delivery record
      And I go to "assets assignation" accounting submenu
      And I search asset created in asset assignation
    Then it has "assigned" status
      And I go to "internal moves" warehouse submenu
      And I search internal move created in asset delivery order
      And I logout

  @32140 @Fail
  Scenario: Verify that Journal Entry accounts are properly configured after creating a Purchase Order
    Given I navigate to login page
    When I login with "purchase manager" credentials
      And I go to "purchase orders" purchase submenu
      And I press "create" general button
      And I create a purchase order with these data
        | supplier |
        | IC Norte |
      And I add products to the purchase order
        | product |
        | Amoladora de acero grande |
      And I press "confirm" purchase button
      And get main data from current purchase order
      And I logout
    When I login with "warehouse manager" credentials
      And I go to "incoming shipments" warehouse submenu
      And I search purchase order in incoming shipments
      And get main data from current incoming shipments
      And I press "receive" incoming shipment button
      And I logout
    When I login with "accountant" credentials
      And I go to "incoming shipments" warehouse submenu
      And I search purchase order in incoming shipments
      And I press "create invoice" incoming shipment button
      And I go to "journal entries" accounting submenu
      And I search incoming shipments in journal entries
#     TODO HBH1 Is blocking this scenario

  @32141 @Fail
  Scenario: Verify that Journal Entry is created when doing a Sales Order
    Given I navigate to login page
    When I login with "sales" credentials
      And I go to "sales orders" sales submenu
      And I press "create" general button
      And I modify the sale order with these data
        | client | tin     |
        | ABILA  | 4531577 |
      And I add products to the sales order
        | product |
        | Amoladora de acero grande |
      And I press "confirm" sales button
      And get main data from current sale order
      And I logout
    When I login with "warehouse manager" credentials
      And I go to "delivery orders" warehouse submenu
      And I search sale order in delivery orders
      And I press "force availability" warehouse button
      And I press "deliver" warehouse button
      And get main data from current delivery order
      And I logout
    When I login with "accountant" credentials
      And I go to "journal entries" accounting submenu
      And I search delivery order in journal entries
      And get main data from current journal entry
      And I logout

  @EndToEnd @32510
  Scenario: Verify that an asset follows all the workflow until it`s transferred in an asset delivery record
    Given I navigate to login page
    When I login with "asset manager" credentials
      And I go to "assets" accounting submenu
      And I press "create" general button
      And I modify the asset with these data
        | assetCategoryParent | grossValue |
        | 01_Domo             | 100        |
      And I press "save" general button
      And I press "confirm asset" accounting button
      And get main data from the current asset
      And it has "running" status
      And I go to "assets assignation" accounting submenu
      And I search asset created in asset assignation
      And I press "request assignation" accounting button
      And I modify the request assignation popup with these data
        | evaluationResponsible | depAreaResponsible | custodian    | depArea   | location             |
        | selog_assMan          | IT                 | selog_warMan | Marketing | Su compañía / Salida |
      And I logout
    When I login with "warehouse manager" credentials
      And I go to "internal moves" warehouse submenu
      And I search asset in internal moves
      And I press "force availability" warehouse button
      And I press "confirm and transfer" warehouse button
      And I logout
    When I login with "asset manager" credentials
      And I go to "assets assignation" accounting submenu
      And I search asset created in asset assignation
      And I press "deliver" accounting button
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
      And I logout

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
      And get main data from current purchase order
      And I logout
    When I login with "warehouse manager" credentials
      And I go to "incoming shipments" purchase submenu
      And I go to incoming shipment created from purchase order
      And I press "receive" incoming shipment button
      And I move to "internal moves" from incoming shipment
      And I press "confirm and transfer" incoming shipment button
      And I logout
    When I login with "accountant" credentials
      And I go to "incoming shipments" purchase submenu
      And I go to incoming shipment created from purchase order
      And I press "create invoice" incoming shipment button
      And I go to "supplier invoices" accounting submenu
      And I go to supplier invoice created from incoming shipment
      And I press "edit" general button
      And I edit the supplier invoice with these data
      | tin           | number | authorizationNumber | controlCode    |
      | 3511597451515 | 000454 | 65464646464555      | B2-A2-H6-R4-G4 |
      And I press "validate" accounting button
      And get main data from current supplier invoice
      And I go to "assets" accounting submenu
      And a new record is displayed in assets list view
    Then it has "draft" status
      And I logout