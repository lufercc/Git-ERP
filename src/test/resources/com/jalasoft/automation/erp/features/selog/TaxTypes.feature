@Accounting
Feature: Accounting
  @TaxTypes @35678
  Scenario: Verify that an asset is assigned if the asset is created manually
    Given I navigate to login page
    When I login with "accountant" credentials
      And I go to "supplier invoices" accounting submenu
      And I press "create" general button
      And I edit the supplier invoice with these data
        | supplier |
        | Advance  |
    Then I verify if he has supplier invoice data on edit mode
      | supplierInvoiceName | tin     |
      | Advance             | 2412841 |
    When I edit the supplier invoice with these data
      | purchaseTaxType       |
      | Retention Tax Goods 1 |
    Then I verify these fields are or not displayed on supplier invoice form
      | tin   | number | authorizationNumber | controlCode | supplierReceiptNumber |
      | false | false  | false               | false       | true                  |
    When I edit the supplier invoice with these data
      | supplierReceiptNumber | invoiceDate |
      | 432432                | 04/18/2016  |
      And I add products with this data to supplier invoice
        | productID                  | quantity |
        | Tubo                       | 2        |
        | Amoladora de acero mediana | 1        |
      And I press "save" general button
    Then I verify products data on supplier invoice
      | productID                  | quantity | unitPrice | amount |
      | Tubo                       | 2        | 75.000000 | 150.00 |
      | Amoladora de acero mediana | 1        | 45.300000 | 45.30  |
      And I verify taxes data on supplier invoice
        | taxDescription                   | taxAccount                       | base   | taxAmount |
        | RETBIENIUE1 - RE-Goods-IUE 5% 1  | 2130105 RETENCIONES IUE - BIENES | 179.67 | -9.77     |
        | RETBIENIT1 - RE-Goods-IT 3% 1    | 2130104 RETENCIONES IT           | 179.67 | -5.86     |
      And I verify if he has supplier invoice data
        | subtotal | tax     | total  | balance |
        | 195.30   | -15.63  | 179.67 | 0.00    |


