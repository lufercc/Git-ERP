@Accounting
Feature: Review different tax types
  @TaxTypes @35678
  Scenario: CLD-35678:Verify tha values are acurate when a Supplier Invoices is created with Retention Tax Goods1
    Given I navigate to login page
    When I login with "accountant" credentials
    And I go to "supplier invoices" accounting submenu
    And I press "create" general button
    And I edit the supplier invoice with these data
      | supplier |
      | CustomAutoSupplier  |
    Then I verify if he has supplier invoice data on edit mode
      | supplierInvoiceName | tin     |
      | CustomAutoSupplier             | 2412841 |
    When I edit the supplier invoice with these data
      | purchaseTaxType       |
      | Retention Tax Goods 1 |
    Then I verify these fields are or not displayed on supplier invoice form
      | tin   | number | authorizationNumber | controlCode | supplierReceiptNumber |
      | false | false  | false               | false       | true                  |
    When I edit the supplier invoice with these data
      | supplierReceiptNumber | invoiceDate |
      | 432432                | 09/01/2016  |
    And I add products with this data to supplier invoice
      | productID                      | quantity |
      | AutomationEstabilizador KIA              | 2        |
      | AutomationLote de repuestos motor diesel | 1        |
    And I press "save" general button
    Then I verify products data on supplier invoice
      | productID                      | quantity | unitPrice    | taxes      | amount   |
      | AutomationEstabilizador KIA              | 2        | 150.000000   | RETBIEN1 | 300.00   |
      | AutomationLote de repuestos motor diesel | 1        | 9,745.920000 | RETBIEN1 | 9,745.92 |
    And I verify taxes data on supplier invoice
      | taxDescription                  | taxAccount                       | base     | taxAmount |
      | RETBIENIUE1 - RE-Goods-IUE 5% 1 | 2130105 RETENCIONES IUE - BIENES | 9,242.24 | -502.30   |
      | RETBIENIT1 - RE-Goods-IT 3% 1   | 2130104 RETENCIONES IT           | 9,242.24 | -301.38   |
    And I verify if he has supplier invoice data
      | subtotal  | tax     | total    | balance |
      | 10,045.92 | -803.68 | 9,242.24 | 0.00    |

  @TaxTypes @35795
  Scenario: CLD-35795:Verify tha values are acurate when a Supplier Invoices is created with Retention Tax Goods2
    Given I navigate to login page
    When I login with "accountant" credentials
    And I go to "supplier invoices" accounting submenu
    And I press "create" general button
    And I edit the supplier invoice with these data
      | supplier |
      | CustomAutoSupplier  |
    Then I verify if he has supplier invoice data on edit mode
      | supplierInvoiceName | tin     |
      | CustomAutoSupplier             | 2412841 |
    When I edit the supplier invoice with these data
      | purchaseTaxType       |
      | Retention Tax Goods 2 |
    Then I verify these fields are or not displayed on supplier invoice form
      | tin   | number | authorizationNumber | controlCode | supplierReceiptNumber |
      | false | false  | false               | false       | true                  |
    When I edit the supplier invoice with these data
      | supplierReceiptNumber | invoiceDate |
      | 432432                | 09/01/2016  |
    And I add products with this data to supplier invoice
      | productID                      | quantity |
      | AutomationEstabilizador KIA              | 3        |
      | AutomationLeche                          | 3.5      |
      | AutomationPlatillo de plastico           | 1        |
    And I press "save" general button
    Then I verify products data on supplier invoice
      | productID                  | quantity | unitPrice  | taxes    | amount |
      | AutomationEstabilizador KIA          | 3        | 150.000000 | RETENBIEN2 | 450.00 |
      | AutomationLeche                      | 3.5      | 15.000000  | RETENBIEN2 | 52.50  |
      | AutomationPlatillo de plastico       | 1        | 27.920000  | RETENBIEN2 | 27.92  |
    And I verify taxes data on supplier invoice
      | taxDescription  | taxAccount                       | base   | taxAmount |
      | RE-Goods-IUE 5% | 2130105 RETENCIONES IUE - BIENES | 530.42 | -28.83    |
      | RE-Goods-IT 3%  | 2130104 RETENCIONES IT           | 530.42 | -17.29    |
    And I verify if he has supplier invoice data
      | subtotal  | tax       | total     | balance |
      | 576.54    | -46.12    | 530.42    | 0.00    |

  @TaxTypes @35811
  Scenario Outline: CLD-35811:Verify tha values are acurate when a Supplier Invoices is created if Purchase tax type has tax zero
    Given I navigate to login page
    When I login with "accountant" credentials
    And I go to "supplier invoices" accounting submenu
    And I press "create" general button
    And I edit the supplier invoice with these data
      | supplier |
      | CustomAutoSupplier2 |
    And I edit the supplier invoice with these data
      | purchaseTaxType       |
      | <purchaseTaxType>     |
    Then I verify if he has supplier invoice data on edit mode
      | fiscalPosition   |
      | <fiscalPosition> |
    Then I verify these fields are or not displayed on supplier invoice form
      | tin   | number | authorizationNumber | controlCode |
      | false | false  | false               | false       |
    When I edit the supplier invoice with these data
      | invoiceDate |
      | 09/02/2016  |
    And I add products with this data to supplier invoice
      | productID                      | quantity |
      | AutomationLote de repuestos motor diesel | 1        |
      | AutomationEstabilizador KIA              | 1.7      |
    And I press "save" general button
    Then I verify products data on supplier invoice
      | productID                      | quantity | unitPrice    | taxes   | amount   |
      | AutomationLote de repuestos motor diesel | 1        | 9,355.154800 | <taxes> | 9,355.15 |
      | AutomationEstabilizador KIA              | 1.7      | 130.500000   | <taxes> | 221.85   |

    And I verify taxes data on supplier invoice
      | taxDescription    | taxAccount                                                              | base     | taxAmount |
      | <taxDescription1> | 1133402 INVENTARIO DE MATERIALES, ACCESORIOS  Y SUMINISTROS TRANSITORIO | 9,355.15 | 0.00      |
      | <taxDescription2> | 5310101 COSTO DE EXPORTACIONES                                          | 221.85   | 0.00      |

    And I verify if he has supplier invoice data
      | subtotal | tax  | total    | balance |
      | 9,577.00 | 0.00 | 9,577.00 | 0.00    |

    Examples:
      | purchaseTaxType             | fiscalPosition                 | taxes   | taxDescription1             | taxDescription2             |
      | Simplified System           | Simplified Tax System Purchase | REGSIMP | REGSIMP - I1 Simple System  | REGSIMP - I1 Simple System  |
      | Farming Tax System Purchase | Farming Tax System Purchase    | REGAGRO | REGAGRO - I3 Farming System | REGAGRO - I3 Farming System |

  @TaxTypes @35811
  Scenario Outline: CLD-35811:Verify tha values are acurate when a Supplier Invoices is created if Purchase tax type has tax zero
    Given I navigate to login page
    When I login with "accountant" credentials
    And I go to "supplier invoices" accounting submenu
    And I press "create" general button
    And I edit the supplier invoice with these data
      | supplier |
      | CustomAutoSupplier2 |
    And I edit the supplier invoice with these data
      | purchaseTaxType       |
      | <purchaseTaxType>     |
    Then I verify if he has supplier invoice data on edit mode
      | fiscalPosition   |
      | <fiscalPosition> |
    Then I verify these fields are or not displayed on supplier invoice form
      | tin   | number | authorizationNumber | controlCode |
      | false | false  | false               | false       |
    When I edit the supplier invoice with these data
      | supplierReceiptNumber | invoiceDate |
      | 432432                | 09/01/2016  |
    And I add products with this data to supplier invoice
      | productID                      | quantity |
      | AutomationLote de repuestos motor diesel | 1        |
      | AutomationEstabilizador KIA              | 1.7      |
    And I press "save" general button
    Then I verify products data on supplier invoice
      | productID                      | quantity | unitPrice    | taxes   | amount   |
      | AutomationLote de repuestos motor diesel | 1        | 9,355.154800 | <taxes> | 9,355.15 |
      | AutomationEstabilizador KIA              | 1.7      | 130.500000   | <taxes> | 221.85   |

    And I verify taxes data on supplier invoice
      | taxDescription    | taxAccount                                                              | base     | taxAmount |
      | <taxDescription1> | 1133402 INVENTARIO DE MATERIALES, ACCESORIOS  Y SUMINISTROS TRANSITORIO | 9,355.15 | 0.00      |
      | <taxDescription2> | 5310101 COSTO DE EXPORTACIONES                                          | 221.85   | 0.00      |

    And I verify if he has supplier invoice data
      | subtotal | tax  | total    | balance |
      | 9,577.00 | 0.00 | 9,577.00 | 0.00    |

    Examples:
      | purchaseTaxType             | fiscalPosition                 | taxes   | taxDescription1             | taxDescription2             |
      | Exempt                      | Exempt                         | EXENTO  | EXENTO - I0 Exempt          | EXENTO - I0 Exempt          |

  @TaxTypes @35811
  Scenario Outline: CLD-35811:Verify tha values are acurate when a Supplier Invoices is created if Purchase tax type has tax zero
    Given I navigate to login page
    When I login with "accountant" credentials
    And I go to "supplier invoices" accounting submenu
    And I press "create" general button
    And I edit the supplier invoice with these data
      | supplier |
      | CustomAutoSupplier2 |
    And I edit the supplier invoice with these data
      | purchaseTaxType       |
      | <purchaseTaxType>     |
    Then I verify if he has supplier invoice data on edit mode
      | fiscalPosition   |
      | <fiscalPosition> |
    Then I verify these fields are or not displayed on supplier invoice form
      | tin   | number | authorizationNumber | controlCode |
      | false | false  | false               | false       |
    When I edit the supplier invoice with these data
      | invoiceDate |
      | 09/01/2016  |
    And I add products with this data to supplier invoice
      | productID                      | quantity |
      | AutomationLote de repuestos motor diesel | 1        |
      | AutomationEstabilizador KIA              | 1.7      |
    And I press "save" general button
    Then I verify products data on supplier invoice
      | productID                      | quantity | unitPrice    | taxes   | amount   |
      | AutomationLote de repuestos motor diesel | 1        | 9,355.154800 | <taxes> | 9,355.15 |
      | AutomationEstabilizador KIA              | 1.7      | 130.500000   | <taxes> | 221.85   |

    And I verify taxes data on supplier invoice
      | taxDescription    | taxAccount    | base    | taxAmount |
      | <taxDescription1> | <taxAccount1> | <base1> | 0.00      |

    And I verify if he has supplier invoice data
      | subtotal | tax  | total    | balance |
      | 9,577.00 | 0.00 | 9,577.00 | 0.00    |

    Examples:
      | purchaseTaxType | fiscalPosition          | taxes  | taxDescription1 | taxAccount1                | base1    |
      | Imports         | International Suppliers | IMPORT | I4 Imports      | 1121101 IVA CREDITO FISCAL | 9,577.00 |

  @TaxTypes @35818
  Scenario: CLD-35818:Verify that values are acurate when a Supplier Invoices is created with Retention Tax Services 2
    Given I navigate to login page
    When I login with "accountant" credentials
    And I go to "supplier invoices" accounting submenu
    And I press "create" general button
    And I edit the supplier invoice with these data
      | supplier |
      | CustomAutoSupplier |
    And I edit the supplier invoice with these data
      | purchaseTaxType          |
      | Retention Tax Services 2 |
    Then I verify if he has supplier invoice data on edit mode
      | fiscalPosition           |
      | Retention Tax Services 2 |
    Then I verify these fields are or not displayed on supplier invoice form
      | tin   | number | authorizationNumber | controlCode |
      | false | false  | false               | false       |
    When I edit the supplier invoice with these data
      | supplierReceiptNumber | invoiceDate |
      | 432432                | 09/01/2016  |
    And I add products with this data to supplier invoice
      | productID     | quantity |
      | AutomationMantenimiento | 1.5      |
    And I press "save" general button
    Then I verify products data on supplier invoice
      | productID     | quantity | unitPrice  | taxes    | amount |
      | AutomationMantenimiento | 1.5      | 250.550000 | RETSERV2 | 375.83 |

    And I verify taxes data on supplier invoice
      | taxDescription    | taxAccount                          | base   | taxAmount |
      | RE-Serv-IUE 12.5% | 2130106 RETENCIONES IUE - SERVICIOS | 375.83 | -55.60    |
      | RE-Serv-IT 3%     | 2130104 RETENCIONES IT              | 375.83 | -13.34    |

    And I verify if he has supplier invoice data
      | subtotal | tax    | total  | balance |
      | 444.77   | -68.94 | 375.83 | 0.00    |

  @TaxTypes @35821
  Scenario: CLD-35821:Verify that values are acurate when a Supplier Invoices is created with Retention Tax Services 1
    Given I navigate to login page
    When I login with "accountant" credentials
    And I go to "supplier invoices" accounting submenu
    And I press "create" general button
    And I edit the supplier invoice with these data
      | supplier |
      | CustomAutoSupplier |
    And I edit the supplier invoice with these data
      | purchaseTaxType          |
      | Retention Tax Services 1 |
    Then I verify if he has supplier invoice data on edit mode
      | fiscalPosition           |
      | Retention Tax Services 1 |
    Then I verify these fields are or not displayed on supplier invoice form
      | tin   | number | authorizationNumber | controlCode |
      | false | false  | false               | false       |
    When I edit the supplier invoice with these data
      | supplierReceiptNumber | invoiceDate |
      | 432432                | 09/01/2016  |
    And I add products with this data to supplier invoice
      | productID | quantity |
      | AutomationLuz       | 30       |
    And I press "save" general button
    Then I verify products data on supplier invoice
      | productID | quantity | unitPrice    | taxes    | amount    |
      | AutomationLuz       | 30       | 1,655.460000 | RETSERV1 | 49,663.80 |

    And I verify taxes data on supplier invoice
      | taxDescription                    | taxAccount                          | base      | taxAmount |
      | RETSERVIUE1 - RE-Serv-IUE 12.5% 1 | 2130106 RETENCIONES IUE - SERVICIOS | 41,965.91 | -6,207.98 |
      | RETSERVIT1 - RE-Serv-IT 3% 1      | 2130104 RETENCIONES IT              | 41,965.91 | -1,489.91 |

    And I verify if he has supplier invoice data
      | subtotal  | tax       | total     | balance |
      | 49,663.80 | -7,697.89 | 41,965.91 | 0.00    |

  @TaxTypes @35822
  Scenario: CLD-35822:Verify tha values are acurate when a Supplier Invoices is created with VAT Complementary System 1
    Given I navigate to login page
    When I login with "accountant" credentials
    And I go to "supplier invoices" accounting submenu
    And I press "create" general button
    And I edit the supplier invoice with these data
      | supplier |
      | CustomAutoSupplier2 |
    And I edit the supplier invoice with these data
      | purchaseTaxType            |
      | VAT Complementary System 1 |
    Then I verify if he has supplier invoice data on edit mode
      | fiscalPosition             |
      | VAT Complementary System 1 |
    Then I verify these fields are or not displayed on supplier invoice form
      | tin   | number | authorizationNumber | controlCode |
      | false | false  | false               | false       |
    When I edit the supplier invoice with these data
      | supplierReceiptNumber | invoiceDate |
      | 432432                | 09/01/2016  |
    And I add products with this data to supplier invoice
      | productID     | quantity |
      | AutomationMantenimiento | 25.35    |
    And I press "save" general button
    Then I verify products data on supplier invoice
      | productID     | quantity | unitPrice  | taxes     | amount   |
      | AutomationMantenimiento | 25.35    | 275.153600 | RCRETIVA1 | 6,975.14 |

    And I verify taxes data on supplier invoice
      | taxDescription             | taxAccount                 | base     | taxAmount |
      | RCRETIVA13 - CS-RE-VAT 13% | 2130103 RETENCIONES RC-IVA | 5,859.12 | -906.77   |
      | ITRETIVA3 - IT-RE-VAT 3%   | 2130104 RETENCIONES IT     | 5,859.12 | -209.25   |

    And I verify if he has supplier invoice data
      | subtotal | tax       | total    | balance |
      | 6,975.14 | -1,116.02 | 5,859.12 | 0.00    |

  @TaxTypes @35857
  Scenario: CLD-35857:Verify that values are acurate when a Supplier Invoices is created with VAT Complementary System 2
    Given I navigate to login page
    When I login with "accountant" credentials
    And I go to "supplier invoices" accounting submenu
    And I press "create" general button
    And I edit the supplier invoice with these data
      | supplier |
      | CustomAutoSupplier2 |
    And I edit the supplier invoice with these data
      | purchaseTaxType            |
      | VAT Complementary System 2 |
    Then I verify if he has supplier invoice data on edit mode
      | fiscalPosition             |
      | VAT Complementary System 2 |
    Then I verify these fields are or not displayed on supplier invoice form
      | tin   | number | authorizationNumber | controlCode |
      | false | false  | false               | false       |
    When I edit the supplier invoice with these data
      | supplierReceiptNumber | invoiceDate |
      | 432432                | 09/01/2016  |
    And I add products with this data to supplier invoice
      | productID | quantity |
      | AutomationLuz       | 3.3      |
    And I press "save" general button
    Then I verify products data on supplier invoice
      | productID | quantity | unitPrice    | taxes     | amount   |
      | AutomationLuz       | 3.3      | 1,491.581300 | RCRETIVA2 | 4,922.22 |

    And I verify taxes data on supplier invoice
      | taxDescription  | taxAccount                 | base     | taxAmount |
      | CS-RE-VAT 13% 2 | 2130103 RETENCIONES RC-IVA | 4,922.22 | -761.77   |
      | IT-RE-VAT 3% 2  | 2130104 RETENCIONES IT     | 4,922.22 | -175.79   |

    And I verify if he has supplier invoice data
      | subtotal | tax     | total    | balance |
      | 5,859.78 | -937.56 | 4,922.22 | 0.00    |

  @TaxTypes @35869
  Scenario: CLD-35869:Verify tha values are acurate when a Supplier Invoices is created if tax is zero and service product
    Given I navigate to login page
    When I login with "accountant" credentials
    And I go to "supplier invoices" accounting submenu
    And I press "create" general button
    And I edit the supplier invoice with these data
      | supplier |
      | CustomAutoSupplier  |
    And I edit the supplier invoice with these data
      | purchaseTaxType                |
      | Integrated Tax System Purchase |
    Then I verify if he has supplier invoice data on edit mode
      | fiscalPosition                 |
      | Integrated Tax System Purchase |
    Then I verify these fields are or not displayed on supplier invoice form
      | tin   | number | authorizationNumber | controlCode | supplierReceiptNumber |
      | false | false  | false               | false       | false                 |
    When I edit the supplier invoice with these data
      | invoiceDate |
      | 09/01/2016  |
    And I add products with this data to supplier invoice
      | productID     | quantity |
      | AutomationMantenimiento | 7.55     |
    And I press "save" general button
    Then I verify products data on supplier invoice
      | productID     | quantity | unitPrice  | taxes   | amount   |
      | AutomationMantenimiento | 7.55     | 250.550000 | REGINTE | 1,891.65 |

    And I verify taxes data on supplier invoice
      | taxDescription                 | taxAccount                                                              | base     | taxAmount |
      | REGINTE - I2 Integrated System | 1133402 INVENTARIO DE MATERIALES, ACCESORIOS  Y SUMINISTROS TRANSITORIO | 1,891.65 | 0.00      |

    And I verify if he has supplier invoice data
      | subtotal | tax  | total     | balance |
      | 1,891.65 | 0.00 | 1,891.65  | 0.00    |

  @TaxTypes @35869
  Scenario: CLD-35869:Verify tha values are acurate when a Supplier Invoices is created if tax is zero and service product
    Given I navigate to login page
    When I login with "accountant" credentials
    And I go to "supplier invoices" accounting submenu
    And I press "create" general button
    And I edit the supplier invoice with these data
      | supplier |
      | CustomAutoSupplier  |
    And I edit the supplier invoice with these data
      | purchaseTaxType |
      | Exempt          |
    Then I verify if he has supplier invoice data on edit mode
      | fiscalPosition |
      | Exempt         |
    Then I verify these fields are or not displayed on supplier invoice form
      | tin   | number | authorizationNumber | controlCode |
      | false | false  | false               | false       |
    When I edit the supplier invoice with these data
      | supplierReceiptNumber | invoiceDate |
      | 432432                | 09/01/2016  |
    And I add products with this data to supplier invoice
      | productID     | quantity |
      | AutomationMantenimiento | 7.55     |
    And I press "save" general button
    Then I verify products data on supplier invoice
      | productID     | quantity | unitPrice  | taxes  | amount   |
      | AutomationMantenimiento | 7.55     | 250.550000 | EXENTO | 1,891.65 |

    And I verify taxes data on supplier invoice
      | taxDescription     | taxAccount                                                              | base     | taxAmount |
      | EXENTO - I0 Exempt | 1133402 INVENTARIO DE MATERIALES, ACCESORIOS  Y SUMINISTROS TRANSITORIO | 1,891.65 | 0.00      |

    And I verify if he has supplier invoice data
      | subtotal | tax  | total     | balance |
      | 1,891.65 | 0.00 | 1,891.65  | 0.00    |

  @TaxTypes @35894
  Scenario: CLD-35894:Verify that values are acurate when a Supplier Invoices is created with Basic Services
    Given I navigate to login page
    When I login with "accountant" credentials
    And I go to "supplier invoices" accounting submenu
    And I press "create" general button
    And I edit the supplier invoice with these data
      | supplier |
      | CustomAutoSupplier2 |
    And I edit the supplier invoice with these data
      | purchaseTaxType |
      | Basic Services  |
    Then I verify if he has supplier invoice data on edit mode
      | fiscalPosition          | tin     |
      | Basic Services Purchase | 6805325 |
    Then I edit the supplier invoice with these data
      | number | authorizationNumber | controlCode | invoiceDate | amountNoVAT |
      | 256987 | 256987              | 256987      | 09/01/2016  | 20.00       |
    And I add products with this data to supplier invoice
      | productID | quantity |
      | AutomationLuz       | 4.8      |
    And I press "save" general button
    Then I verify products data on supplier invoice
      | productID | quantity | unitPrice   | taxes         | amount   |
      | AutomationLuz       | 4.8      | 1,491.581300 | COMPSERVELEC | 7,159.59 |

    And I verify taxes data on supplier invoice
      | taxDescription | taxAccount                                                              | base     | taxAmount |
      | ELECTR VAT 13% | 1121101 IVA CREDITO FISCAL                                              | 6,228.84 | 930.75    |
      | ELECTR Exempt  | 1133402 INVENTARIO DE MATERIALES, ACCESORIOS  Y SUMINISTROS TRANSITORIO | 6,228.84 | 20.00     |

    And I verify if he has supplier invoice data
      | subtotal | tax    | amountNoVAT | total     | balance |
      | 6,228.84 | 930.75 | 20.00       | 7,179.59  | 0.00    |

  @TaxTypes @35909
  Scenario: CLD-35909:Verify that values are acurate when a Supplier Invoices is created with Fuel
    Given I navigate to login page
    When I login with "accountant" credentials
    And I go to "supplier invoices" accounting submenu
    And I press "create" general button
    And I edit the supplier invoice with these data
      | supplier |
      | CustomAutoSupplier  |
    And I edit the supplier invoice with these data
      | purchaseTaxType |
      | Fuel            |
    Then I verify if he has supplier invoice data on edit mode
      | fiscalPosition | tin     |
      | Fuel Purchase  | 2412841 |
    Then I edit the supplier invoice with these data
      | number | authorizationNumber | controlCode | invoiceDate | amountNoVAT |
      | 256987 | 256987              | 256987      | 09/01/2016  | 30.00       |
    And I add products with this data to supplier invoice
      | productID     | quantity |
      | AutomationMantenimiento | 35.8     |
    And I press "save" general button
    Then I verify products data on supplier invoice
      | productID     | quantity | unitPrice  | taxes    | amount   |
      | AutomationMantenimiento | 35.8     | 250.550000 | COMPCOMB | 8,969.69 |

    And I verify taxes data on supplier invoice
      | taxDescription | taxAccount                                                            | base     | taxAmount |
      | Fuel VAT 13% | 1121101 IVA CREDITO FISCAL                                              | 8,123.45 | 816.24    |
      | Fuel Exempt  | 1133402 INVENTARIO DE MATERIALES, ACCESORIOS  Y SUMINISTROS TRANSITORIO | 8,123.45 | 30.00     |

    And I verify if he has supplier invoice data
      | subtotal | tax    | amountNoVAT | total     | balance |
      | 8,123.45 | 816.24 | 30.00       | 8,969.69  | 0.00    |

  @TaxTypes @35924
  Scenario: CLD-35924:Verify that values are acurate when a Supplier Invoices is created with Normal
    Given I navigate to login page
    When I login with "accountant" credentials
    And I go to "supplier invoices" accounting submenu
    And I press "create" general button
    And I edit the supplier invoice with these data
      | supplier |
      | CustomAutoSupplier2 |
    And I edit the supplier invoice with these data
      | purchaseTaxType |
      | Normal          |
    Then I verify if he has supplier invoice data on edit mode
      | fiscalPosition    | tin     |
      | Normal Purchase 1 | 6805325 |
    Then I edit the supplier invoice with these data
      | number | authorizationNumber | controlCode | invoiceDate |
      | 256987 | 256987              | 256987      | 09/01/2016  |
    And I add products with this data to supplier invoice
      | productID            | quantity |
      | AutomationLeche                | 5.7      |
      | AutomationPlatillo de plastico | 2        |
      | AutomationEstabilizador KIA    | 1        |
    And I press "save" general button
    Then I verify products data on supplier invoice
      | productID            | quantity | unitPrice  | taxes     | amount |
      | AutomationLeche                | 5.7      | 12.063800  | IVACOMPRA | 68.76  |
      | AutomationPlatillo de plastico | 2        | 26.053900  | IVACOMPRA | 52.11  |
      | AutomationEstabilizador KIA    | 1        | 130.500000 | IVACOMPRA | 130.50 |

    And I verify taxes data on supplier invoice
      | taxDescription   | taxAccount                 | base   | taxAmount |
      | VAT 13% Purchase | 1121101 IVA CREDITO FISCAL | 218.69 | 32.68     |

    And I verify if he has supplier invoice data
      | subtotal | tax   | total  | balance |
      | 218.69   | 32.68 | 251.37 | 0.00    |


  @TaxTypes @35925
  Scenario: CLD-35925:Verify that values are acurate when a Supplier Invoices is created with Stockable Fuel
    Given I navigate to login page
    When I login with "accountant" credentials
    And I go to "supplier invoices" accounting submenu
    And I press "create" general button
    And I edit the supplier invoice with these data
      | supplier |
      | CustomAutoSupplier  |
    And I edit the supplier invoice with these data
      | purchaseTaxType |
      | Stockable Fuel  |
    Then I verify if he has supplier invoice data on edit mode
      | fiscalPosition | tin     |
      | Fuel Purchase  | 2412841 |
    Then I edit the supplier invoice with these data
      | number | authorizationNumber | controlCode | invoiceDate | amountNoVAT |
      | 256987 | 256987              | 256987      | 09/02/2016  | 30.00       |
    And I add products with this data to supplier invoice
      | productID            | quantity |
      | AutomationLeche                | 110.6    |
      | AutomationPlatillo de plastico | 18       |
      | AutomationEstabilizador KIA    | 3        |
    And I press "save" general button
    Then I verify products data on supplier invoice
      | productID            | quantity | unitPrice  | taxes    | amount   |
      | AutomationLeche                | 110.6    | 15.000000  | COMPCOMB | 1,659.00 |
      | AutomationPlatillo de plastico | 18       | 27.920000  | COMPCOMB | 502.56   |
      | AutomationEstabilizador KIA    | 3        | 150.000000 | COMPCOMB | 450.00   |

    And I verify taxes data on supplier invoice
      | taxDescription | taxAccount                                                              | base     | taxAmount |
      | Fuel VAT 13%   | 1121101 IVA CREDITO FISCAL                                              | 2,283.91 | 237.65    |
      | Fuel Exempt    | 5310101 COSTO DE EXPORTACIONES                                          | 379.05   | 30.00     |
      | Fuel Exempt    | 1133402 INVENTARIO DE MATERIALES, ACCESORIOS  Y SUMINISTROS TRANSITORIO | 1,904.86 | 30.00     |

    And I verify if he has supplier invoice data
      | subtotal | tax    | amountNoVAT | total    | balance |
      | 2,343.91 | 237.65 | 30.00       | 2,611.56 | 0.00    |

  @TaxTypes @35926
  Scenario: CLD-35926:Verify that values are acurate when a Supplier Invoices is created with Special Tax ICE
    Given I navigate to login page
    When I login with "accountant" credentials
    And I go to "supplier invoices" accounting submenu
    And I press "create" general button
    And I edit the supplier invoice with these data
      | supplier |
      | CustomAutoSupplier  |
    And I edit the supplier invoice with these data
      | purchaseTaxType |
      | Special Tax (ICE)  |
    Then I verify if he has supplier invoice data on edit mode
      | fiscalPosition | tin     |
      | Special Tax (ICE)  | 2412841 |
    Then I edit the supplier invoice with these data
      | number | authorizationNumber | controlCode | invoiceDate | ice   |
      | 256987 | 256987              | 256987      | 09/01/2016  | 38.18 |
    And I add products with this data to supplier invoice
      | productID            | quantity |
      | AutomationLeche                | 110.6    |
      | AutomationPlatillo de plastico | 18       |
      | AutomationEstabilizador KIA    | 3        |
    And I press "save" general button
    Then I verify products data on supplier invoice
      | productID            | quantity | unitPrice  | taxes     | amount   |
      | AutomationLeche                | 110.6    | 15.000000  | COMPRAICE | 1,659.00 |
      | AutomationPlatillo de plastico | 18       | 27.920000  | COMPRAICE | 502.56   |
      | AutomationEstabilizador KIA    | 3        | 150.000000 | COMPRAICE | 450.00   |

    And I verify taxes data on supplier invoice
      | taxDescription | taxAccount                                                              | base     | taxAmount |
      | VAT 13 % ICE   | 1121101 IVA CREDITO FISCAL                                              | 2,272.06 | 339.50    |
      | ICE            | 5310101 COSTO DE EXPORTACIONES                                          | 391.50   | 38.18     |
      | ICE            | 1133402 INVENTARIO DE MATERIALES, ACCESORIOS  Y SUMINISTROS TRANSITORIO | 1,880.56 | 38.18     |

    And I verify if he has supplier invoice data
      | subtotal | tax    | ice   | total    | balance |
      | 2,272.06 | 339.50 | 38.18 | 2,649.74 | 0.00    |